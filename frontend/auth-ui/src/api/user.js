import request from '@/utils/request'

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
