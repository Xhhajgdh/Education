<template>
  <!-- 学生年龄与消费指数比分析页面容器 -->
  <div class="com-container">
    <!-- 图表容器 -->
    <div class="com-chart" ref="areaandprice_ref"></div>
  </div>
</template>

<script>
import { mapState } from 'vuex'
export default {
  data () {
    return {
      chartInstance: null, // ECharts 图表实例
      allData: null, // 服务器返回的数据
      axisData: [] // 坐标轴数据
    }
  },
  mounted () {
    this.initChart() // 初始化图表
    this.getData() // 获取数据
    window.addEventListener('resize', this.screenAdapter) // 监听窗口大小变化事件
    // 在页面加载完成时，主动进行屏幕的适配
    this.screenAdapter()

    setInterval(() => {
      this.getData();
      console.log("Realtime start")
    }, 1000); // 10000 毫秒 = 10 秒

  },
  destroyed() {
    // 在组件销毁的时候，取消监听器和定时器
    window.removeEventListener('resize', this.screenAdapter)
    clearInterval(this.timerId)
  },
  methods: {
    initChart () {
      // 初始化图表实例
      this.chartInstance = this.$echarts.init(this.$refs.areaandprice_ref, this.theme)
      const initOption = {
        // 图表的标题
        title: {
          text: '▎2-学生年龄与消费指数比',
          left: 20,
          top: 20
        },
        grid: {
          left: '3%',
          right: '7%',
          bottom: '7%',
          containLabel: true
        },
        tooltip: {
          showDelay: 0,
          formatter: function (params) {
            if (params.value.length > 1) {
              return params.value[0] + '平 ' + params.value[1] + '元/月 ';
            }
            else {
              return params.name + ' : ' + params.value + '元/月 ';
            }
          },
          axisPointer: {
            show: true,
            type: 'cross',
            lineStyle: {
              type: 'dashed',
              width: 1
            }
          }
        },
        xAxis: {
          type: 'value',
          scale: true,
          axisLabel: {
            formatter: '{value} 岁'
          }
        },
        yAxis: {
          type: 'value',
          scale: true,
          axisLabel: {
            formatter: '{value} 元'
          }
        },
        series: [
          {
            type: 'scatter',
            emphasis: {
              focus: 'series'
            },
          }
        ]
      }
      this.chartInstance.setOption(initOption)
    },
    async getData () {
      // 获取数据
      const { data: ret } = await this.$http.get('getAnaly2')
      this.allData = ret.data
      console.log(this.allData)
      this.updateChart()
    },
    updateChart () {
      // 处理数据
      for (let i = 0; i < this.allData.length; i++) {
        const name = this.allData[i].cate
        const value = parseFloat(this.allData[i].count) // 使用原始数据
        this.axisData.push([name, value])
      }
      console.log(this.axisData)
      const dataOption = {
        series: [
          {
            data: this.axisData
          }
        ]
      }
      this.chartInstance.setOption(dataOption)
    },
    screenAdapter () {
      // 屏幕适配
      const titleFontSize = (this.$refs.areaandprice_ref.offsetWidth / 100) * 3.6
      const adapterOption = {
        title: {
          textStyle: {
            fontSize: titleFontSize / 2
          }
        }
      }
      this.chartInstance.setOption(adapterOption)
      // 手动调用图表的 resize 才能产生效果
      this.chartInstance.resize()
    }
  },
  computed: {
    ...mapState(['theme'])
  },
  watch: {
    theme () {
      console.log('主题切换了')
      this.chartInstance.dispose() // 销毁当前图表
      this.initChart() // 重新以最新的主题名称初始化图表对象
      this.screenAdapter() // 完成屏幕的适配
      this.updateChart() // 更新图表的展示
    }
  }
}
</script>

<style>
/* 这里可以添加样式，暂为空 */
</style>
