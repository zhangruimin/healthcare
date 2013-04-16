function dataFetcher(time, dataType, place) {

	function fetchData() {

		$.ajax({
			url : "/healthcare/healthManage/fetch",
			type : 'Get',
			data : {
				timestamp : time,
				dataType : dataType
			},
			success : function(data1) {

				if (null != dataType) {
					var result = [];
					for ( var i = 0; i < data1[0].data.length; i++) {
						result.push([
								new Date(data1[0].timestamp[i].replace(/-/ig,
										'/')).getTime(),
								parseFloat(data1[0].data[i]) ]);
					}
					if (dataType == "TEMP1") {
						$.plot(place, [ result ], {
							xaxis : {
								mode : "time",
								timezone : "browser"
							},
							points : {
								show : true
							},
							lines : {
								show : true
							}
						});
					} else if (dataType == "HR") {
						$.plot(place, [ result ], {
							xaxis : {
								mode : "time",
								timezone : "browser"
							},
							points : {
								show : true
							},
							lines : {
								show : true
							}
						});
					} else if (dataType == "SPO2") {
						$.plot(place, [ result ], {
							xaxis : {
								mode : "time",
								timezone : "browser"
							},
							points : {
								show : true
							},
							lines : {
								show : true
							}
						});
					} else if (dataType == "RESP") {
						$.plot(place, [ result ], {
							xaxis : {
								mode : "time",
								timezone : "browser"
							},
							points : {
								show : true
							},
							lines : {
								show : true
							}
						});
					} else if (dataType == "PR") {
						$.plot(place, [ result ], {
							xaxis : {
								mode : "time",
								timezone : "browser"
							},
							points : {
								show : true
							},
							lines : {
								show : true
							}
						});
					} else if (dataType == "NIBP") {
						$.plot(place, [ result ], {
							xaxis : {
								mode : "time",
								timezone : "browser"
							},
							points : {
								show : true
							},
							lines : {
								show : true
							}
						});
					} else if (dataType == "BS") {
						$.plot(place, [ result ], {
							xaxis : {
								mode : "time",
								timezone : "browser"
							},
							points : {
								show : true
							},
							lines : {
								show : true
							}
						});
					}
				} else {

					var result1 = [];
					for ( var i = 0; i < data1[0].data.length; i++) {
						result1.push([
								new Date(data1[0].timestamp[i].replace(/-/ig,
										'/')).getTime(),
								parseFloat(data1[0].data[i]) ]);
					}

					var result2 = [];
					for ( var i = 0; i < data1[1].data.length; i++) {
						result2.push([
								new Date(data1[1].timestamp[i].replace(/-/ig,
										'/')).getTime(),
								parseFloat(data1[1].data[i]) ]);
					}

					var result3 = [];
					for ( var i = 0; i < data1[2].data.length; i++) {
						result3.push([
								new Date(data1[2].timestamp[i].replace(/-/ig,
										'/')).getTime(),
								parseFloat(data1[2].data[i]) ]);
					}

					var result4 = [];
					for ( var i = 0; i < data1[3].data.length; i++) {
						result4.push([
								new Date(data1[3].timestamp[i].replace(/-/ig,
										'/')).getTime(),
								parseFloat(data1[3].data[i]) ]);
					}

					var result5 = [];
					for ( var i = 0; i < data1[4].data.length; i++) {
						result5.push([
								new Date(data1[4].timestamp[i].replace(/-/ig,
										'/')).getTime(),
								parseFloat(data1[4].data[i]) ]);
					}

					var result6 = [];
					for ( var i = 0; i < data1[5].data.length; i++) {
						result6.push([
								new Date(data1[5].timestamp[i].replace(/-/ig,
										'/')).getTime(),
								parseFloat(data1[5].data[i]) ]);
					}

					var result7 = [];
					for ( var i = 0; i < data1[6].data.length; i++) {
						result7.push([
								new Date(data1[6].timestamp[i].replace(/-/ig,
										'/')).getTime(),
								parseFloat(data1[6].data[i]) ]);
					}

					$.plot("#placeholder1", [ result1 ], {
						xaxis : {
							mode : "time",
							timezone : "browser"
						},
						points : {
							show : true
						},
						lines : {
							show : true
						}
					});
					$.plot("#placeholder2", [ result2 ], {
						xaxis : {
							mode : "time",
							timezone : "browser"
						},
						points : {
							show : true
						},
						lines : {
							show : true
						}
					});
					$.plot("#placeholder3", [ result3 ], {
						xaxis : {
							mode : "time",
							timezone : "browser"
						},
						points : {
							show : true
						},
						lines : {
							show : true
						}
					});

					$.plot("#placeholder4", [ result4 ], {
						xaxis : {
							mode : "time",
							timezone : "browser"
						},
						points : {
							show : true
						},
						lines : {
							show : true
						}
					});
					$.plot("#placeholder5", [ result5 ], {
						xaxis : {
							mode : "time",
							timezone : "browser"
						},
						points : {
							show : true
						},
						lines : {
							show : true
						}
					});
					$.plot("#placeholder6", [ result6 ], {
						xaxis : {
							mode : "time",
							timezone : "browser"
						},
						points : {
							show : true
						},
						lines : {
							show : true
						}
					});

					$.plot("#placeholder7", [ result7 ], {
						xaxis : {
							mode : "time",
							timezone : "browser"
						},
						points : {
							show : true
						},
						lines : {
							show : true
						}
					});
				}
			},
			error : function() {
				// alert("Failed to get data");
			}
		});
	}

	return {
		getData : function() {
			fetchData();
		}
	};
}

function dataDiagramDrawer(settings) {

	return {
		draw : function() {
			var fetcher = dataFetcher(settings.time, settings.dataType,
					settings.place);
			fetcher.getData();
		}
	};
}

$(function() {

	$("#tabs").tabs();

	dataDiagramDrawer({
		time : "today",
		dataType : "TEMP1",
		place : "#placeholder1"
	}).draw();

	dataDiagramDrawer({
		time : "today",
		dataType : "HR",
		place : "#placeholder2"
	}).draw();

	dataDiagramDrawer({
		time : "today",
		dataType : "SPO2",
		place : "#placeholder3"
	}).draw();

	dataDiagramDrawer({
		time : "today",
		dataType : "RESP",
		place : "#placeholder4"
	}).draw();

	dataDiagramDrawer({
		time : "today",
		dataType : "PR",
		place : "#placeholder5"
	}).draw();

	dataDiagramDrawer({
		time : "today",
		dataType : "NIBP",
		place : "#placeholder6"
	}).draw();
	
	dataDiagramDrawer({
		time : "today",
		dataType : "BS",
		place : "#placeholder7"
	}).draw();

	$("#lastday").click(function() {
		dataDiagramDrawer({
			time : "LAST_DAY",
			dataType : null
		}).draw();
	});

	$("#lastweek").click(function() {
		dataDiagramDrawer({
			time : "LAST_WEEK",
			dataType : null
		}).draw();
	});

	$("#lastmonth").click(function() {
		dataDiagramDrawer({
			time : "LAST_MONTH",
			dataType : null
		}).draw();
	});
>>>>>>> deployed edition
});