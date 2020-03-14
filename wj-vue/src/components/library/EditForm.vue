<template>
  <div>
    <i class="el-icon-circle-plus-outline"  @click="dialogFormVisible = true"></i>
    <el-dialog
      title="添加/修改项目"
      :visible.sync="dialogFormVisible"
      @close="clear">
      <el-form v-model="form" style="text-align: left" ref="dataForm">
        <el-form-item label="项目名" :label-width="formLabelWidth" prop="title">
          <el-input v-model="form.title" autocomplete="off" placeholder="请输入项目名"></el-input>
        </el-form-item>
        <el-form-item label="申请人" :label-width="formLabelWidth" prop="author">
          <el-input v-model="form.author" autocomplete="off" placeholder="请输入申请人"></el-input>
        </el-form-item>
        <el-form-item label="申请日期" :label-width="formLabelWidth" prop="date">
          <el-input v-model="form.date" autocomplete="off" placeholder="请输入申请日期"></el-input>
        </el-form-item>
        <el-form-item label="申请单位" :label-width="formLabelWidth" prop="press">
          <el-input v-model="form.press" autocomplete="off" placeholder="请输入申请单位"></el-input>
        </el-form-item>
        <el-form-item label="申请资金" :label-width="formLabelWidth" prop="money">
          <el-input v-model="form.money" autocomplete="off" placeholder="请输入申请资金"></el-input>
        </el-form-item>
        <el-form-item label="封面" :label-width="formLabelWidth" prop="cover">
          <el-input v-model="form.cover" autocomplete="off" placeholder="图片 URL"></el-input>
          <img-upload @onUpload="uploadImg" ref="imgUpload"></img-upload>
        </el-form-item>
        <el-form-item label="简介" :label-width="formLabelWidth" prop="abs">
          <el-input type="textarea" v-model="form.abs" autocomplete="off" placeholder="请输入项目简介"></el-input>
        </el-form-item>
        <el-form-item label="分类" :label-width="formLabelWidth" prop="cid">
          <el-select v-model="form.category.id" placeholder="请选择分类">
            <el-option label="综合研究" value="1"></el-option>
            <el-option label="实践研究" value="2"></el-option>
            <el-option label="理论研究" value="3"></el-option>       
          </el-select>
        </el-form-item>
        <el-form-item prop="id" style="height: 0">
          <el-input type="hidden" v-model="form.id" autocomplete="off"></el-input>
        </el-form-item>
      </el-form>
      <div slot="footer" class="dialog-footer">
        <el-button @click="dialogFormVisible = false">取 消</el-button>
        <el-button type="primary" @click="onSubmit">确 定</el-button>
      </div>
    </el-dialog>
  </div>
</template>

<script>
import ImgUpload from './ImgUpload'
  export default {
    name: 'EditForm',
    components: {ImgUpload},
    data () {
      return {
        dialogFormVisible: false,
        form: {
          id: '',
          title: '',
          author: '',
          date: '',
          press: '',
          cover: '',
          abs: '',
          money: '',
          category: {
            id: '',
            name: ''
          }
        },
        formLabelWidth: '120px'
      }
    },
    methods: {
      clear () {
        this.form = {
          id: '',
          title: '',
          author: '',
          date: '',
          press: '',
          cover: '',
          abs: '',
          money: '',
          category: {
                 id: '',
                 name: ''
          }
        }
      },
      onSubmit () {
        this.$axios
          .post('/projects', {
            id: this.form.id,
            cover: this.form.cover,
            title: this.form.title,
            author: this.form.author,
            date: this.form.date,
            press: this.form.press,
            abs: this.form.abs,
            money:this.form.money,
            category: this.form.category,
          }).then(resp => {
          if (resp && resp.status === 200) {
            this.dialogFormVisible = false
            this.$emit('onSubmit')
          }
        })
      },
      uploadImg(){
        this.form.cover = this.$refs.imgUpload.url
      }
    }
  }
</script>

<style scoped>
  .el-icon-circle-plus-outline {
    margin: 50px 0 0 20px;
    font-size: 100px;
    float: left;
    cursor: pointer;
  }
</style>


