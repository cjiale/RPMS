<template>
  <el-container>
      <el-aside style="width: 200px;margin-top: 20px">
          <switch></switch>
          <SideMenu></SideMenu>
      </el-aside>
      <el-main>
          <projects class="projects-area"></projects>
      </el-main>
  </el-container>
</template>

<script>
 import SideMenu from './SideMenu'
 import Projects from './Projects'
 export default {
   name: 'AppLibrary',
   components: {SideMenu,Projects} 
 }
</script>

<style scoped>
.projects-area {
    width: 990px;
    margin-left: auto;
    margin-right: auto;
  }
</style>
