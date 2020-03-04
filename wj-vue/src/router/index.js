import Vue from 'vue'
import Router from 'vue-router'
//import HelloWorld from '@/components/HelloWorld'
// 导入刚才编写的组件
import AppIndex from '@/components/home/Appindex'
import Login from '@/components/Login'
Vue.use(Router)

export default new Router({
  mode: 'history',
  routes: [
    // {
    //   path: '/',
    //   name: 'HelloWorld',
    //   component: HelloWorld
    // },
    {
      path: '/login',
      name: 'Login',
      component: Login
    },
    {
      path: '/index',
      name: 'AppInde',
      component: AppIndex,
      meta: {
        requireAuth: true
      }
    }
  ]
})
