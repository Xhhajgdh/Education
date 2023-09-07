<template>
  <!-- 一个包含多个部分的页面容器 -->
  <div class="screen-container" :style="containerStyle">
    <!-- 页面头部，包含标题和主题切换按钮 -->
    <header class="screen-header" :style="titleColor">
      <div>
        <img :src="headerSrc" alt="">
      </div>
      <span class="title">Eliauk教育数据分析页面</span>
      <div class="title-right">
        <img :src="themeSrc" class="qiehuan" @click="handleChangeTheme">
      </div>
    </header>
    <!-- 页面主体内容 -->
    <div class="screen-body">
      <!-- 左侧区域 -->
      <section class="screen-left">
        <!-- 左上部分，包含 Price 组件 -->
        <div id="left-top" :class="[fullScreenStatus.price ? 'fullscreen' : '']">
          <Price ref="price"></Price>
          <!-- 缩放按钮 -->
          <div class="resize">
            <span @click="changeSize('price')" :class="['iconfont', fullScreenStatus.price ? 'icon-compress-alt' : 'icon-expand-alt']"></span>
          </div>
        </div>
        <!-- 左下部分，包含 Area 组件 -->
        <div id="left-bottom" :class="[fullScreenStatus.area ? 'fullscreen' : '']">
          <Area ref="area"></Area>
          <!-- 缩放按钮 -->
          <div class="resize">
            <span @click="changeSize('area')" :class="['iconfont', fullScreenStatus.area ? 'icon-compress-alt' : 'icon-expand-alt']"></span>
          </div>
        </div>
      </section>
      <!-- 中间区域 -->
      <section class="screen-middle">
        <!-- 中上部分，包含 AgeAndPrice 组件 -->
        <div id="middle-top" :class="[fullScreenStatus.areaandprice ? 'fullscreen' : '']">
          <AgeAndPrice ref="areaandprice"></AgeAndPrice>
          <!-- 缩放按钮 -->
          <div class="resize">
            <span @click="changeSize('areaandprice')" :class="['iconfont', fullScreenStatus.areaandprice ? 'icon-compress-alt' : 'icon-expand-alt']"></span>
          </div>
        </div>
        <!-- 中下部分，包含 CourseType 组件 -->
        <div id="middle-bottom" :class="[fullScreenStatus.coursetype ? 'fullscreen' : '']">
          <CourseType ref="coursetype"></CourseType>
          <!-- 缩放按钮 -->
          <div class="resize">
            <span @click="changeSize('coursetype')" :class="['iconfont', fullScreenStatus.coursetype ? 'icon-compress-alt' : 'icon-expand-alt']"></span>
          </div>
        </div>
      </section>
      <!-- 右侧区域 -->
      <section class="screen-right">
        <!-- 右上部分，包含 OrderPayWay 组件 -->
        <div id="right-top" :class="[fullScreenStatus.coursepayway ? 'fullscreen' : '']">
          <OrderPayWay ref="coursepayway"></OrderPayWay>
          <!-- 缩放按钮 -->
          <div class="resize">
            <span @click="changeSize('coursepayway')" :class="['iconfont', fullScreenStatus.coursepayway ? 'icon-compress-alt' : 'icon-expand-alt']"></span>
          </div>
        </div>
        <!-- 右下部分，包含 Agecount 组件 -->
        <div id="right-bottom" :class="[fullScreenStatus.coursearea ? 'fullscreen' : '']">
          <Agecount ref="coursearea"></Agecount>
          <!-- 缩放按钮 -->
          <div class="resize">
            <span @click="changeSize('coursearea')" :class="['iconfont', fullScreenStatus.coursearea ? 'icon-compress-alt' : 'icon-expand-alt']"></span>
          </div>
        </div>
      </section>
    </div>
  </div>
</template>

<script>
import Price from '../components/1Price.vue'
import Area from '../components/4Area.vue'
import AgeAndPrice from '../components/2AgeAndPrice.vue'
import CourseType from '../components/5CourseType.vue'
import OrderPayWay from '../components/3-OrderPayWay.vue'
import Agecount from '../components/6Agecount.vue'
import { mapState } from 'vuex'
import { getThemeValue } from '../utils/theme_utils'

export default {
  data() {
    // 定义每一个图表的全屏状态
    return {
      fullScreenStatus: {
        price: false,
        area: false,
        areaandprice: false,
        coursetype: false,
        coursepayway: false,
        coursearea: false
      }
    }
  },
  methods: {
    changeSize(chartName) {
      // 改变 fullScreenStatus 的数据
      this.fullScreenStatus[chartName] = !this.fullScreenStatus[chartName]
      // 调用每一个图表组件的 screenAdapter 方法
      this.$nextTick(() => {
        this.$refs[chartName].screenAdapter()
      })
    },
    // 主题切换事件
    handleChangeTheme() {
      // 修改 VueX 中的数据
      this.$store.commit('changeTheme')
    }
  },
  components: {
    Price,
    Area,
    AgeAndPrice,
    CourseType,
    OrderPayWay,
    Agecount
  },
  computed: {
    ...mapState(['theme']),
    headerSrc() {
      return '/static/img/' + getThemeValue(this.theme).headerBorderSrc
    },
    themeSrc() {
      return '/static/img/' + getThemeValue(this.theme).themeSrc
    },
    containerStyle() {
      return {
        backgroundColor: getThemeValue(this.theme).backgroundColor,
        color: getThemeValue(this.theme).titleColor
      }
    },
    titleColor() {
      return {
        color: getThemeValue(this.theme).titleColor
      }
    }
  }
}
</script>

<style lang="less" scoped>
/* 全屏样式的定义 */
.fullscreen {
  position: fixed !important;
  top: 0 !important;
  left: 0 !important;
  width: 100% !important;
  height: 100% !important;
  margin: 0 !important;
  z-index: 100;
}

.screen-container {
  width: 100%;
  height: 100%;
  padding: 0 20px;
  background-color: #161522;
  color: #fff;
  box-sizing: border-box;
}

.screen-header {
  width: 100%;
  height: 64px;
  font-size: 20px;
  position: relative;

  >div {
    img {
      width: 100%;
    }
  }

  .title {
    position: absolute;
    left: 50%;
    top: 50%;
    font-size: 20px;
    transform: translate(-50%, -50%);
  }

  .title-right {
    display: flex;
    align-items: center;
    position: absolute;
    right: 0px;
    top: 50%;
    transform: translateY(-80%);
  }

  .qiehuan {
    width: 28px;
    height: 21px;
    cursor: pointer;
  }

  .datetime {
    font-size: 15px;
    margin-left: 10px;
  }

  .logo {
    position: absolute;
    left: 0px;
    top: 50%;
    transform: translateY(-80%);

    a {
      text-decoration: none;
    }
  }
}

.screen-body {
  width: 100%;
  height: 100%;
  display: flex;
  margin-top: 10px;

  .screen-left {
    height: 100%;
    width: 27.6%;

    #left-top {
      height: 53%;
      position: relative;
    }

    #left-bottom {
      height: 31%;
      margin-top: 25px;
      position: relative;
    }
  }

  .screen-middle {
    height: 100%;
    width: 41.5%;
    margin-left: 1.6%;
    margin-right: 1.6%;

    #middle-top {
      width: 100%;
      height: 56%;
      position: relative;
    }

    #middle-bottom {
      margin-top: 25px;
      width: 100%;
      height: 28%;
      position: relative;
    }
  }

  .screen-right {
    height: 100%;
    width: 27.6%;

    #right-top {
      height: 46%;
      position: relative;
    }

    #right-bottom {
      height: 38%;
      margin-top: 25px;
      position: relative;
    }
  }
}

.resize {
  position: absolute;
  right: 20px;
  top: 20px;
  cursor: pointer;
}
</style>
