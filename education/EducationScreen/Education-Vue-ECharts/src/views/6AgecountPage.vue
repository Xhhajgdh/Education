<!--针对/areapage这条路劲而显示出来
在这个组件中通过子组件注册的方式，要显示Agecount.vue这个组件
 -->
<template>
 <div class="com-page">
    <Agecount></Agecount>
 </div>
</template>

<script>
	import Agecount from '../components/6Agecount.vue'
	export default{
		name: 'AgecountPage',
		components:{
			Agecount
		}
	}
</script>

<style>

</style>
