<template\>
  <div class="manage">
      <el-dialog
        title="提示"
        :visible.sync="dialogVisible"
        width="50%"
        :before-close="handleClose">
        <!-- 用户的表单信息 -->
        <el-form ref="form" :rules="rules" :inline="true" :model="form" label-width="100px">
            <el-form-item label="教室名称" prop="name">
              <el-input placeholder="请输入教室名称" v-model="form.name"></el-input>
            </el-form-item>
            <el-form-item label="教室号" prop="id">
              <el-input placeholder="请输入教室号" v-model="form.id"></el-input>
            </el-form-item>
            <el-form-item label="楼层" prop="floor">
              <el-input placeholder="请输入楼层" v-model="form.floor"></el-input>
            </el-form-item>
            <el-form-item label="教学楼" prop="building">
              <el-input placeholder="请输入教学楼名称" v-model="form.building"></el-input>
            </el-form-item>
            <el-form-item label="座位数" prop="capacity">
              <el-input placeholder="请输入座位数" v-model="form.capacity"></el-input>
            </el-form-item>
            <el-form-item label="多媒体教室" prop="media">
              <el-select v-model="form.media" placeholder="请选择">
                  <el-option label="是" value="1"></el-option>
                  <el-option label="否" value="0"></el-option>
              </el-select>
            </el-form-item>
        </el-form>
        <span slot="footer" class="dialog-footer">
          <el-button @click="cancel">取 消</el-button>
          <el-button type="primary" @click="submit">确 定</el-button>
        </span>
    </el-dialog>
    <div class="manage-header">
      <el-button @click="handleAdd" type="primary">
          添加新教室
      </el-button>
      <el-table
       :data="tableData"
       style="width: 100%">
          <el-table-column
            prop="name"
            label="教室名称">
          </el-table-column>
          <el-table-column
            prop="id"
            label="教室号">
          </el-table-column>
          <el-table-column
            prop="floor"
            label="楼层">
          </el-table-column>
          <el-table-column
            prop="building"
            label="教学楼">
          </el-table-column>
          <el-table-column
            prop="capacity"
            label="座位数">
          </el-table-column>
          <el-table-column
            prop="media"
            label="多媒体教室">
            <template slot-scope="scope">
               <span style="margin-left: 10px">{{ scope.row.media == 1 ? '是' : '否' }}</span>
            </template>
          </el-table-column>
          <el-table-column
            prop="capacity"
            label="操作">
            <template slot-scope="scope">
               <el-button size="mini" @click="handleEdit(scope.row)">编辑</el-button>
               <el-button type="danger" size="mini" @click="handleDelete(scope.row)">删除</el-button>
            </template>
          </el-table-column>
      </el-table>
    </div>
  </div>
</template>
<script>
import { getUser, addUser, editUser } from '../api'
export default {
    data() {
    return {
        dialogVisible: false,
        form:{
          name:'',
          id:'',
          floor:'',
          building:'',
          capacity:'',
          media:''
        },
        rules:{
            name:[
                { required: true, message: '请输入教室名称', trigger: 'blur' }
            ],
            id:[
                { required: true, message: '请输入教室号', trigger: 'blur' }
            ],
            floor:[
                { required: true, message: '请输入楼层', trigger: 'blur' }
            ],
            building:[
                { required: true, message: '请输入教学楼名称', trigger: 'blur' }
            ],
            capacity:[
                { required: true, message: '请输入座位数', trigger: 'blur' }
            ],
            media:[
                { required: true, message: '请选择是否为多媒体教室', trigger: 'blur' }
            ]
        },
        tableData: [
          {
            name: '教室1',
            id: '1',
            floor: '1',
            building: '教学楼1',
            capacity: '50',
            media: '1'
          },
          {
            name: '教室2',
            id: '2',
            floor: '2',
            building: '教学楼2',
            capacity: '60',
            media: '1'
          },
          {
            name: '教室3',
            id: '3',
            floor: '3',
            building: '教学楼3',
            capacity: '70',
            media: '0'
          },
          {
            name: '教室4',
            id: '4',
            floor: '4',
            building: '教学楼4',
            capacity: '100',
            media: '1'
          }
        ],
        modelType: 0 // 0表示新增的弹窗， 1表示编辑
    };
  },
  methods:{
      // 提交用户表单
      submit() {    
        this.$refs.form.validate(valid => {
            // console.log(valid, 'valid')
            if (valid) {
                // 后续对表单数据的处理
                if (this.modelType === 0) {
                    addUser(this.form).then(() => {
                        // 重新获取列表的接口
                        this.getList()
                    })
                } else {
                    editUser(this.form).then(() => {
                        // 重新获取列表的接口
                        this.getList()
                    })
                }

                // 清空表单的数据
                this.$refs.form.resetFields()
                // 关闭弹窗
                this.dialogVisible = false
            }
        });
      },
      // 弹窗关闭的时候
      handleClose() {
          this.$refs.form.resetFields()
          this.dialogVisible = false
      },
      cancel() {
          this.handleClose()
      },
      handleEdit(row) {
         this.modelType = 1
      },
      handleDelete(row) {

      },
      handleAdd() {
          this.dialogVisible = true
          this.modelType = 0
      },
      getList() {
          // 获取的列表的数据 
          getUser().then(({ data }) => {
              console.log(data)
              this.tableData = ["教室一","101","1","弘毅","90","0"]
          })
      }
  },
  mounted() {
      this.getList()
  }
};
</script>
