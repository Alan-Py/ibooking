import axios from 'axios'
 
const http = axios.create({
    // 通用请求的地址前缀
    baseURL: '/api',
    timeout: 10000, // 超时时间
})
 


// // Add a request interceptor
// axios.interceptors.request.use(function (config) {
//     // Do something before request is sent
//     return config;
//   }, function (error) {
//     // Do something with request error
//     return Promise.reject(error);
//   });

// // Add a response interceptor
// axios.interceptors.response.use(function (response) {
//     // Do something with response data
//     return response;
//   }, function (error) {
//     // Do something with response error
//     return Promise.reject(error);
//   });


// 导出自定义的axios方法, 供外面调用传参发请求
export default http