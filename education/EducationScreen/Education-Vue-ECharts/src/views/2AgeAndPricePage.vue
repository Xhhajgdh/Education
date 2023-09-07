<!--针对/areapage这条路劲而显示出来
在这个组件中通过子组件注册的方式，要显示Area.vue这个组件
 -->
<template>
 <div class="com-page">
    <AgeAndPrice></AgeAndPrice>
 </div>
</template>

<script>
	import AgeAndPrice from '../components/2AgeAndPrice.vue'
	export default{
		name: 'AgeAndPricePage',
		components:{
			AgeAndPrice
		}
	}
</script>

<style>

</style>
