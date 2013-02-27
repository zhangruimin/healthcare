function realTimeDataFetcher(totalPoints){
    var stubData =[], currentData = [], buffer = [];
    var initValue = 0, isDataReady = false;
    function init(){
        while (buffer.length < totalPoints) {
            buffer.push(initValue);
        }
        refreshData();
    }

    function refreshData(){
        currentData = [];
        for(var i = 0; i < buffer.length; i++){
            currentData.push([i, buffer[i]]);
        }
//        isDataReady = false;
        $.ajax({
            url: "/healthcare/next.do",
            type: 'Get',
            success: function (data) {
                buffer = data["data"];
//                isDataReady = true;
            },
            timeout: 30000,
            error: function () {
                alert("Failed to get data");
            }
            }
        );
    }
    init();
    return{
        getNextPacket: function(){
//            if(isDataReady){
                refreshData();
                return currentData;
//            } else{
//                return stubData;
//            }
        }
    }
}

$(function () {
    var updateInterval = 10, marginPoints = 10, totalPoints = 250;

    var options = {
        series: { shadowSize: 0 },
        yaxis: { min: 0, max: 300 },
        xaxis: { show: false }
    };


    var fetcher = realTimeDataFetcher(totalPoints);
    var currentData = fetcher.getNextPacket();

    var plot = $.plot($("#electrocardiogram"), [ currentData ], options);

    var currentX = 0;
    var newData = [];

    function refreshCurrentData(currentData, newData, currentX) {
        currentData[currentX] = newData[currentX];
        for (var j = currentX + 1 ; j < Math.min(currentX + marginPoints, currentData.length); j++) {
            currentData[j] = 0;
        }
    }

    function update() {
        if(currentX===0){
            newData = fetcher.getNextPacket();
        }

        refreshCurrentData(currentData, newData, currentX);
        plot.setData([currentData]);
        // since the axes don't change, we don't need to call plot.setupGrid()
        plot.draw();

        currentX++;
        currentX = currentX%totalPoints;
        setTimeout(update, updateInterval);
    }

    update();
});