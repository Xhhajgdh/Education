<template>
  <!-- 页面容器 -->
  <div className="com-page">
    <!-- 包含 Price 组件 -->
    <Price></Price>
  </div>
</template>

<script>
// 导入 Price 组件
import Price from '../components/1Price.vue'

export default {
  // 组件名称
  name: 'PricePage',
  components: {
    // 注册 Price 组件为子组件
    Price
  }
}
</script>

<style>
/* 可以在这里定义样式，但此处为空 */
</style>
