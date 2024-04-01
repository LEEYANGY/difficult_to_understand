import request from '@/utils/request';

const api_name = '/api/v1/user';

// 登录
export function login(data) {
  return request({
    url: '/api/v1/user/login',
    method: 'post',
    data
  })
}

// 获取用户信息
export function getInfo(token) {
  return request({
    url: '/api/v1/user/info',
    method: 'get',
    params: {token}
  })
}

// 注销登录
export function logout() {
  return request({
    url: '/api/v1/user/logout',
    // url: '/vue-admin-template/user/logout',
    method: 'post'
  })
}

export default {
  getPageList(page, limit, searchObj) {
    return request({
      url: `${api_name}/${page}/${limit}`,
      method: 'get',
      params: searchObj // url查询字符串或表单键值对
    })
  },
  getById(id) {
    return request({
      url: `${api_name}/get/${id}`,
      method: 'get'
    })
  },
  save(role) {
    return request({
      url: `${api_name}/save`,
      method: 'post',
      data: role
    })
  },
  updateById(role) {
    return request({
      url: `${api_name}/update`,
      method: 'put',
      data: role
    })
  },
  removeById(id) {
    return request({
      url: `${api_name}/remove/${id}`,
      method: 'delete'
    })
  },
  //更新用户状态
  updateStatus(id, status) {
    return request({
      url: `${api_name}/updateStatus/${id}/${status}`,
      method: 'get'
    })
  },

}
