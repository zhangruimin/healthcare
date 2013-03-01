function realTimeDataFetcher(totalPoints){
    var stubData =[], currentData = [], waveRecord;
    var initValue = 0, isDataReady = false;
    function init(){
        while (stubData.length < totalPoints) {
            stubData.push(initValue);
        }
        refreshData();
    }

    function refreshData(){
        currentData = [];
        if(waveRecord == null){
            for(var i = 0; i < stubData.length; i++){
                currentData.push([i, stubData[i]]);
            }
        }  else{
            for(var i = 0; i < waveRecord.data.length; i++){
                currentData.push([i, waveRecord.data[i]]);
            }
        }

        $.ajax({
            url: "/healthcare/next.do",
            type: 'Get',
            data: {timestamp: waveRecord == null ? 0 : waveRecord.timestamp},
            success: function (data) {
                waveRecord = data;
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
            refreshData();
            return currentData;
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