import Vue from 'vue'
import VueRouter from 'vue-router'
import Home from '../views/Home.vue'
import PricePage from '../views/1PricePage.vue'
import AgeAndPricePage from '../views/2AgeAndPricePage.vue'
import OrderPayWayPage from '../views/3OrderPayWayPage.vue'
import AreaPage from '../views/4AreaPage.vue'
import CourseTypePage from '../views/5CourseTypePage.vue'
import AgecountPage from '../views/6AgecountPage.vue'


Vue.use(VueRouter)

const routes = [
  {
    path: '/',
    redirect: '/home'
  },
  {
    path: '/home',
    component: Home
  },
  {
    path: '/areapage',
    component: AreaPage
  },
  {
    path: '/coursetypepage',
    component: CourseTypePage
  },
  {
    path: '/orderpaywaypage',
    component: OrderPayWayPage
  },
  {
    path: '/ageandpricepage',
    component: AgeAndPricePage
  },
  {
    path: '/pricepage',
    component: PricePage
  },
  {
    path: '/ageareapage',
    component: AgecountPage
  }
]

const router = new VueRouter({
  routes
})

export default router
