<template>
  <div class="app-container">
    <!--查询表单-->
    <div class="search-div">
      <el-form label-width="70px" size="small">
        <el-row>
          <el-col :span="24">
            <el-form-item label="角色名称">
              <el-input style="width: 100%" v-model="searchObj.roleName"
                        placeholder="角色名称"></el-input>
            </el-form-item>
          </el-col>
        </el-row>
        <el-row style="display:flex">
          <el-button type="primary" icon="el-icon-search" size="mini"
                     @click="fetchData()">搜索
          </el-button>
          <el-button icon="el-icon-refresh" size="mini" @click="resetData">重置
          </el-button>
        </el-row>
      </el-form>
    </div>
    <!-- 工具条 -->
    <div class="tools-div">
      <el-button type="success" icon="el-icon-plus" size="mini" @click="add">添 加
      </el-button>
      <el-button class="btn-add" size="mini" @click="batchRemove()">批量删除
      </el-button>
    </div>

    <el-table
      v-loading="listLoading"
      :data="list"
      stripe
      border
      style="width: 100%;margin-top: 10px;">
      <el-table-column
        label="序号"
        width="70"
        align="center"
        @selection-change="handleSelectionChange">
        <el-table-column type="selection"/>
        <template slot-scope="scope">
          {{ (page - 1) * limit + scope.$index + 1 }}
        </template>
      </el-table-column>
      <el-table-column prop="roleName" label="角色名称"/>
      <el-table-column prop="roleCode" label="角色编码"/>
      <el-table-column prop="createTime" label="创建时间" width="160"/>
      <el-table-column label="操作" width="200" align="center">
        <template slot-scope="scope">
          <el-button type="primary" icon="el-icon-edit" size="mini"
                     @click="edit(scope.row.id)" title="修改"/>
          <el-button type="danger" icon="el-icon-delete" size="mini"
                     @click="removeDataById(scope.row.id)" title="删除"/>
        </template>
      </el-table-column>

    </el-table>
    <div class="block">
      <el-pagination
        background
        layout="total, sizes, prev, pager, next, jumper"
        :current-page="page"
        @size-change="handleSizeChange"
        :page-sizes="[1, 3, 5, 10]"
        :page-size="limit"
        :total="total"
        @current-change="fetchData"
        style="padding: 30px 0; text-align: center;"
      ></el-pagination>
    </div>
    <el-dialog title="添加/修改" :visible.sync="dialogVisible" width="40%">
      <el-form ref="dataForm" :model="sysRole" label-width="150px" size="small"
               style="padding-right: 40px;">
        <el-form-item label="角色名称">
          <el-input v-model="sysRole.roleName"/>
        </el-form-item>
        <el-form-item label="角色编码">
          <el-input v-model="sysRole.roleCode"/>
        </el-form-item>
      </el-form>
      <span slot="footer" class="dialog-footer">
<el-button @click="dialogVisible = false" size="small" icon="el-iconrefresh-right">取 消</el-button>
<el-button type="primary" icon="el-icon-check" @click="saveOrUpdate()"
           size="small">确 定</el-button>
</span>
    </el-dialog>
  </div>
</template>

<script>
import request from "@/api/system/sysRole";

//vue
export default {
  //定义数据模型
  data() {
    return {
      listLoading: true,//数据是否正在加载
      list: [], //角色列表
      page: 1, //页码
      limit: 5, //每页记录数
      total: 0, //总记录数
      searchObj: {}, //查询条件
      multipleSelection: [],// 批量删除选中的记录列表
      dialogVisible: false,
      sysRole: {},
      saveBtnDisabled: false
    };
  },
  //页面渲染之前获取数据
  created() {
    this.fetchData();
  },
  //定义方法
  methods: {
    // 修改页面容量
    handleSizeChange(val) {
      console.log(`每页 ${val} 条`);
      this.limit = val;
      this.fetchData();
    },
    // 分页查询
    fetchData(pageNum = this.page, pageSize = this.limit) {
      this.page = pageNum
      this.limit = pageSize
      //调用API
      request
        .getPageList(this.page, this.limit, this.searchObj)
        .then((response) => {
          this.listLoading = false
          this.list = response.data.records;
          this.total = response.data.total;
          this.page = response.data.current;
        });
    },
    // 根据id移除角色
    removeDataById(id) {
      this.$confirm('此操作将永久删除该文件, 是否继续?', '提示', {
        confirmButtonText: '确定',
        cancelButtonText: '取消',
        type: 'warning'
      }).then(() => {
        request.removeById(id).then(res => {
          this.fetchData(this.page)
          this.$message({
            type: 'success',
            message: '删除成功!'
          });
        })
      })
    },
    // 重置表单
    resetData() {
      console.log('重置查询表单')
      this.searchObj = {}
      this.fetchData()
    },
    // 角色修改
    edit(id) {
      this.dialogVisible = true
      request.getById(id).then(response => {
        this.sysRole = response.data
      })

    },
    //弹出添加的表单
    add() {
      this.dialogVisible = true
      this.sysRole = {}
    },
    //添加或更新
    saveOrUpdate() {
      if (!this.sysRole.id) {
        this.save()
      } else {
        this.update()
      }
    },
    //添加
    save() {
      request.save(this.sysRole).then(response => {
        this.$message.success(response.message || '操作成功')
        this.dialogVisible = false
        this.fetchData(this.page)
      })
    }
  },
  //批量删除
  batchRemove() {
    if (this.multipleSelection.length == 0) {
      this.$message.warning("请选择要删除的记录");
      return
    }
    this.$confirm('此操作将永久删除该文件, 是否继续?', '提示', {
      confirmButtonText: '确定',
      cancelButtonText: '取消',
      type: 'warning'
    }).then(() => {
      //定义数组
      var idList = []
      this.multipleSelection.forEach(item => {
        idList.push(item.id)
      });
      api.batchRemove(idList).then(response => {
        this.fetchData(this.page)
        this.$message({
          type: 'success',
          message: '删除成功!'
        });
      })
    })
  },
};
</script>
