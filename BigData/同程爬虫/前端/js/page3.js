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
