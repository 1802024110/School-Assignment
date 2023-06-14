// 基于准备好的dom，初始化echarts实例
var page4 = echarts.init(document.getElementById('page4'));

getJson('json/page4.json').then(rawData => {

  // 将数据转换为 Echarts 需要的格式
  var data = Object.entries(rawData).map(([key, value]) => ({
    name: key,
    value: value
  }));

  option = {
    xAxis: {
      type: 'category',
      data: data.map(item => item.name)
    },
    yAxis: {
      type: 'value'
    },
    series: [
      {
        data: data.map(item => item.value),
        type: 'line',
        smooth: true,
        tooltip: {
          trigger: 'axis',
          axisPointer: {
            type: 'line',
            animation: false,
            label: {
              backgroundColor: '#505765'
            }
          }
        }
      }
    ]
  };

  // 使用刚指定的配置项和数据显示图表。
  page4.setOption(option);
});
