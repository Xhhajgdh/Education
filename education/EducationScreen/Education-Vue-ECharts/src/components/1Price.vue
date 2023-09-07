<template>
  <!-- 数据分析页面容器 -->
  <div class="com-container">
    <!-- 存放图表的容器 -->
    <div class="com-chart" ref="price_ref"></div>
  </div>
</template>



<script>
import { mapState } from 'vuex'
export default {
  data() {
    return {
      chartInstance: null, // ECharts 图表实例
      allData: null, // 服务器返回的数据
      startValue: 0, // 区域缩放的起点值
      endValue: 9, // 区域缩放的终点值
      timerId: null // 定时器标识
    }
  },
  mounted() {
    // 初始化图表
    this.initChart()
    // 获取数据
    this.getData()
    // 监听窗口大小变化事件
    window.addEventListener('resize', this.screenAdapter)
    // 页面加载完成时进行屏幕适配
    this.screenAdapter()


    setInterval(() => {
      this.getData();
      console.log("Realtime start")
    }, 1000); // 10000 毫秒 = 10 秒



  },
  destroyed() {
    // 组件销毁时，移除窗口大小变化监听和清除定时器
    window.removeEventListener('resize', this.screenAdapter)
    clearInterval(this.timerId)
  },
  methods: {
    // 初始化图表
    initChart() {
      // 创建 ECharts 实例并初始化配置
      this.chartInstance = this.$echarts.init(this.$refs.price_ref, this.theme)
      const initOption = {
        // 图表的标题
        title: {
          text: '▎1-各学科教育平均订单金额数据统计',
          left: 20,
          top: 20
        },
        // 坐标轴的位置
        grid: {
          top: '40%',
          left: '5%',
          right: '5%',
          bottom: '5%',
          containLabel: true // 距离是包含坐标轴上的文字
        },
        tooltip: {
          show: true
        },
        xAxis: {
          type: 'category'
        },
        yAxis: {
          type: 'value',
          axisLabel: {
            formatter: '{value} 元/月'
          }
        },
        series: [
          {
            type: 'bar'
          }
        ]
      }
      this.chartInstance.setOption(initOption)
      // 监听鼠标事件，当鼠标悬停时清除定时器，移出时重新开始自动滚动
      this.chartInstance.on('mouseover', () => {
        clearInterval(this.timerId)
      })
      this.chartInstance.on('mouseout', () => {
        this.startInterval()
      })
    },
    // 获取数据并初始化图表
    async getData() {
      // 发起 HTTP 请求获取数据
      const { data: ret } = await this.$http.get('getAnaly3')
      this.allData = ret.data
      console.log(this.allData)
      console.log(typeof this.allData)
      // 对数组进行排序
      this.allData.sort((a, b) => {
        return b.count - a.count
      })
      // 更新图表内容
      this.updateChart()
      // 在获取数据后，加载完图表后启动自动滚动的动画
      this.startInterval()
    },
    // 更新图表内容
    updateChart() {
      // 颜色数组
      const colorArr = [
        ['#0BA82C', '#4FF778'],
        ['#2E72BF', '#23E5E5'],
        ['#5052EE', '#AB6EE5']
      ]
      // 处理数据
      const areaNames = this.allData.map((item) => {
        return item.cate
      })
      const avgPrice = this.allData.map((item) => {
        return item.count
      })
      const dataOption = {
        xAxis: {
          data: areaNames
        },
        dataZoom: {
          show: false,
          startValue: this.startValue,
          endValue: this.endValue
        },
        series: [
          {
            data: avgPrice,
            itemStyle: {
              color: (arg) => {
                let targetColorArr = null
                if (arg.value > 1200) {
                  targetColorArr = colorArr[0]
                } else if (arg.value > 500) {
                  targetColorArr = colorArr[1]
                } else {
                  targetColorArr = colorArr[2]
                }
                return new this.$echarts.graphic.LinearGradient(0, 0, 0, 1, [
                  // 百分之0状态之下的颜色值
                  {
                    offset: 0,
                    color: targetColorArr[0]
                  },
                  // 百分之100状态之下的颜色值
                  {
                    offset: 1,
                    color: targetColorArr[1]
                  }
                ])
              }
            }
          }
        ]
      }
      this.chartInstance.setOption(dataOption)
    },
    // 屏幕适配
    screenAdapter() {
      const titleFontSize = (this.$refs.price_ref.offsetWidth / 100) * 3.6
      // 浏览器分辨率大小相关的配置项
      const adapterOption = {
        title: {
          textStyle: {
            titleFontSize: titleFontSize
          }
        },
        series: [
          {
            barWidth: titleFontSize,
            itemStyle: {
              barBorderRadius: [titleFontSize / 2, titleFontSize / 2, 0, 0]
            }
          }
        ]
      }
      this.chartInstance.setOption(adapterOption)
      // 手动调用图表的 resize 才能产生效果
      this.chartInstance.resize()
    },
    // 开始滚动定时器
    startInterval() {
      if (this.timerId) {
        clearInterval(this.timerId)
      }
      this.timerId = setInterval(() => {
        this.startValue++
        this.endValue++
        console.log('end: ' + this.endValue)
        console.log('length:' + this.allData.length)
        if (this.endValue > this.allData.length - 1) {
          this.startValue = 0
          this.endValue = 9
        }
        this.updateChart()
      }, 2000)
    }
  },
  computed: {
    ...mapState(['theme'])
  },
  watch: {
    // 监听主题变化事件
    theme() {
      console.log('主题切换了')
      // 销毁当前图表
      this.chartInstance.dispose()
      // 重新以最新的主题名称初始化图表对象
      this.initChart()
      // 完成屏幕适配
      this.screenAdapter()
      // 更新图表的展示
      this.updateChart()
    }
  }
}
</script>

<style>
/* 这里可以添加样式，暂为空 */
</style>
