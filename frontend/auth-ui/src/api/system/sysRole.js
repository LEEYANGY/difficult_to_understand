/*
角色管理相关的API请求函数
*/
import request from '@/utils/request'

const api_name = '/api/v1/role/getRoleByPage'

export default {
  /*
  分页查询(带搜索)
  */
  getPageList(page, limit, roleName) {
    return request({
      url: `${api_name}/${page}/${limit}`,
      method: 'get',
      params: {roleName}
    })
  },
  // 根据id移除角色  TODO
  removeById(id) {
    return request({
      url: `${api_name}/remove/${id}`,
      method: 'delete'
    })
  },
  // 保存  TODO
  save(role) {
    return request({
      url: `${api_name}/save`,
      method: 'post',
      data: role
    })
  },
  //编辑  TODO
  getById(id) {
    return request({
      url: `${api_name}/get/${id}`,
      method: 'get'
    })
  },
  //更新  TODO
  updateById(role) {
    return request({
      url: `${api_name}/update`,
      method: 'put',
      data: role
    })
  },
  // 批量删除  TODO
  batchRemove(idList) {
    return request({
      url: `${api_name}/batchRemove`,
      method: `delete`,
      data: idList
    })
  },
}
