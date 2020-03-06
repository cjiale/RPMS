<template>
  <el-container>
      <el-aside style="width: 200px;margin-top: 20px">
          <switch></switch>
          <SideMenu @indexSelect="listByCategory" ref= "sideMenu"></SideMenu>
      </el-aside>
      <el-main>
          <projects class="projects-area" ref="projectsArea"></projects>
      </el-main>
  </el-container>
</template>

<script>
 import SideMenu from './SideMenu'
 import Projects from './Projects'
 export default {
   name: 'AppLibrary',
   components: {SideMenu,Projects} ,
   methods: {
     listByCategory(){
       var _this = this
       var cid = this.$refs.sideMenu.cid
       var url = '/categories' + cid + '/projects'
       this.$axios.get(url).then(resp =>{
         if(resp && resp.status ===200){
           _this.$refs.projectsArea.projects = resp.data
         }
       })
     }
   }
 }
</script>

<style scoped>
.projects-area {
    width: 990px;
    margin-left: auto;
    margin-right: auto;
  }
</style>
