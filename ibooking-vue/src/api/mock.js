import Mock from 'mockjs'
import user from './mockServeData/user'

// 定义mock请求拦截

// 用户列表的数据
Mock.mock('/api/user/add', 'post', user.createUser)
Mock.mock('/api/user/edit', 'post', user.updateUser)
Mock.mock('/api/user/del', 'post', user.deleteUser)
Mock.mock('/api/user/getUser', user.getUserList)