// 基于准备好的dom，初始化echarts实例
var myChart = echarts.init(document.getElementById('page5'));

getJson('json/page5.json').then(rawData => {

  const total = rawData.reduce((a, b) => a + b, 0); // 计算总数


  // 计算好评、中评和差评的百分比
  var percentage = rawData.map(value => ((value / total) * 100).toFixed(2) + "%");

  option = {
    series: [
      {
        type: 'pie',
        radius: '55%',
        center: ['50%', '50%'],
        data: [
          { value: rawData[0], name: '好评 ' + percentage[0] },
          { value: rawData[1], name: '中评 ' + percentage[1] },
          { value: rawData[2], name: '差评 ' + percentage[2] }
        ],
        label: {
          formatter: '{b}: {d}%'
        },
        emphasis: {
          label: {
            show: true,
            fontSize: '16',
            fontWeight: 'bold'
          }
        }
      }
    ]
  };

  // 使用刚指定的配置项和数据显示图表。
  myChart.setOption(option);
});
