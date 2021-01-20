/*Dashboard3 Init*/
 
"use strict"; 

/*****E-Charts function start*****/
var echartsConfig = function() {
	if( $('#e_chart_11').length > 0 ){
		var eChart_11 = echarts.init(document.getElementById('e_chart_11'));
		const tempType = document.getElementsByName("type");
		const tempCount = document.getElementsByName("count");
		const data1=[];
		const data2=[];
		for (var i = 0, j = tempType.length; i < j; i++){
			data1[i]=tempType[i].value; //获得值(els[i].id)，并存入数组;　　//获得ID　　
		}
		for (var i = 0, j = tempCount.length; i < j; i++){
			data2[i]=tempCount[i].value; //获得值(els[i].id)，并存入数组;　　//获得ID　　
		}
		var option10 = {
			color: ['#00456b'],
			tooltip: {
				show: true,
				trigger: 'axis',
				backgroundColor: '#fff',
				borderRadius:6,
				padding:6,
				axisPointer:{
					lineStyle:{
						width:0,
					}
				},
				textStyle: {
					color: '#324148',
					fontFamily: '"Nunito", sans-serif',
					fontSize: 12
				}	
			},
			
			xAxis: [{
				type: 'category',
				data:data1,
				axisLine: {
					show:false
				},
				axisTick: {
					show:false
				},
				axisLabel: {
					textStyle: {
						color: '#5e7d8a'
					}
				}
			}],
			yAxis: {
				type: 'value',
				axisLine: {
					show:false
				},
				axisTick: {
					show:false
				},
				axisLabel: {
					textStyle: {
						color: '#5e7d8a'
					}
				},
				splitLine: {
					lineStyle: {
						color: 'transparent',
					}
				}
			},
			grid: {
				top: '3%',
				left: '3%',
				right: '3%',
				bottom: '3%',
				containLabel: true
			},
			series: [{
				data: data2,
				type: 'bar',
				barMaxWidth: 30,
				itemStyle: {
					normal: {
						barBorderRadius: [6, 6, 0, 0] ,
					}
				},
				label: {
					normal: {
						show: true,
						position: 'inside'
					}
				},
			}]
		};
		eChart_11.setOption(option10);
		eChart_11.resize();
		document.getElementById("a").style.display="none";
	}
}
/*****E-Charts function end*****/

/*****Resize function start*****/
var echartResize;
$(window).on("resize", function () {
	/*E-Chart Resize*/
	clearTimeout(echartResize);
	echartResize = setTimeout(echartsConfig, 200);
}).resize(); 
/*****Resize function end*****/

/*****Function Call start*****/
echartsConfig();
/*****Function Call end*****/