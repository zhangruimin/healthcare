function realTimeDataFetcher(totalPoints, waveType, defaultValue) {
    var stubData = [], currentData = [], waveRecord;

    function init() {
        while (stubData.length < totalPoints) {
            stubData.push(defaultValue);
        }
        refreshData();
    }

    function refreshData() {
        currentData = [];
        if (waveRecord == null) {
            for (var i = 0; i < stubData.length; i++) {
                currentData.push([i, stubData[i]]);
            }
        } else {
            for (var i = 0; i < waveRecord.data.length; i++) {
                currentData.push([i, waveRecord.data[i]]);
            }
        }

        $.ajax({
                url:"/healthcare/realTimeData/next",
                type:'Get',
                data:{timestamp:waveRecord == null ? 0 : waveRecord.timestamp, waveType:waveType},
                success:function (data) {
                    waveRecord = data;
                },
                timeout:30000,
                error:function () {
                    //alert("Failed to get data");
                }
            }
        );
    }

    init();
    return{
        getNextPacket:function () {
            refreshData();
            return currentData;
        }
    }
}

function waveDiagramDrawer(settings, plotOptions) {
    return {
        draw:function () {
            var fetcher = realTimeDataFetcher(settings.totalPoints, settings.waveType, settings.defaultValue);
            var currentData = fetcher.getNextPacket();
            var plot = $.plot($(settings.place), [ currentData ], plotOptions);

            var currentX = 0;
            var newData = [];

            function refreshCurrentData(currentData, newData, currentX) {
                currentData[currentX] = newData[currentX];
                for (var j = currentX + 1; j < Math.min(currentX + settings.marginPoints, currentData.length); j++) {
                    currentData[j] = 0;
                }
            }

            function update() {
                if (currentX === 0) {
                    newData = fetcher.getNextPacket();
                }

                refreshCurrentData(currentData, newData, currentX);
                plot.setData([currentData]);
                plot.draw();

                currentX++;
                currentX = currentX % settings.totalPoints;
                setTimeout(update, settings.updateInterval);
            }

            update();
        }
    }
}

function digitDataDrawer(settings) {
    var defaultSettings = {
        updateInterval:5000
    };
    settings = $.extend(defaultSettings, settings);

    return {
        draw:function () {
            function update() {
                $.ajax({
                        url:"/healthcare/realTimeData/nextDigitData",
                        type:'Get',
                        success:function (data) {
                            if (data["temperature"]) {
                                $("#temperature").text(data["temperature"]);
                            }
                            if (data["heartRate"]) {
                                $("#HR-real-time-data").text(data["heartRate"]);
                            }
                            if (data["heartRate"]) {
                                $("#PRData").text(data["pr"]);
                            }
                            if (data["bloodOxygen"]) {
                                $("#bloodOxygen").text(data["bloodOxygen"]);
                            }

                            if (data["resp"]) {
                                $("#RESP-value").text(data["resp"]);
                            }

                            if (data["bs"]) {
                                $("#GLU-real-time-data").text(data["bs"]);
                            }
                        },
                        timeout:30000,
                        error:function () {
                            //alert("Failed to get data");
                        }
                    }
                );
                setTimeout(update, settings.updateInterval);
            }

            update();
        }
    }
}

$(function () {
    waveDiagramDrawer(
        {
            updateInterval:10,
            marginPoints:10,
            totalPoints:240,
            waveType:"ECG",
            place:"#electrocardiogram",
            defaultValue:150
        },
        {
            series:{ shadowSize:0, color:"#52b242" },
            yaxis:{ min:-100, max:300},
            xaxis:{ show:true, labelWidth:0, tickSize:20, font:{color:"blue"} },
            grid:{ borderWidth:0 }
        }
    ).draw();

    waveDiagramDrawer({
            updateInterval:40,
            marginPoints:3,
            totalPoints:60,
            waveType:"BO",
            place:"#bloodoxygendiogram",
            defaultValue:30
        },
        {
            series:{ shadowSize:0, color:"#ff7163" },
            yaxis:{ min:24.5, max:100},
            xaxis:{ show:true },
            grid:{borderWidth:0},
            legend:{show:true}
        }
    ).draw();

    waveDiagramDrawer({
            updateInterval:110,
            marginPoints:2,
            totalPoints:40,
            waveType:"BREATH",
            place:"#RESPdiogram",
            defaultValue:0
        },
        {
            series:{ shadowSize:0, color:"#5AAADE" },
            yaxis:{ min:0, max:300},
            xaxis:{ show:true },
            grid:{borderWidth:0},
            legend:{show:true}
        }
    ).draw();

    digitDataDrawer().draw();
});