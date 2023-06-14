// 基于准备好的dom，初始化echarts实例
var page3 = echarts.init(document.getElementById('page3'));

getJson('json/page3.json').then(data => {
  option = {
    xAxis: {
      type: 'category',
      data: data.map(item => item.month)
    },
    yAxis: {
      type: 'value'
    },
    series: [
      {
        data: data.map(item => item.count),
        type: 'bar',
        showBackground: true,
        backgroundStyle: {
          color: 'rgba(180, 180, 180, 0.2)'
        }
      }
    ]
  };

  // 使用刚指定的配置项和数据显示图表。
  page3.setOption(option);
});




// 指定图表的配置项和数据
// var option = {
//   title: {
//     text: 'ECharts 入门示例'
//   },
//   tooltip: {},
//   legend: {
//     data: ['销量']
//   },
//   xAxis: {
//     data: ['衬衫', '羊毛衫', '雪纺衫', '裤子', '高跟鞋', '袜子']
//   },
//   yAxis: {},
//   series: [
//     {
//       name: '销量',
//       type: 'bar',
//       data: [5, 20, 36, 10, 10, 20]
//     }
//   ]
// };

