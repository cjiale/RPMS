<template>
  <div style="margin-top: 10px">
      <div class="home">
        <update-card id="update-card"></update-card>
      </div>
  </div>
</template>

<script>
  import UpdateCard from './UpdateCard'
  export default {
    name: 'AppIndex',
    components: { UpdateCard}
  }
</script>

<style scoped>
  .home {
    width: 990px;
    margin-left: auto;
    margin-right: auto;
    margin-top: -20px;

  }

  #header-div {
    padding-bottom: 20px;
    padding-left: 5px;
    background-color: white;
    /*background: url("../../assets/img/bg/bg3.jpg");*/
  }

  #side-menu {
    position: fixed;
    margin-left: 50%;
    left: -680px;
    top: 100px;
  }
</style>
