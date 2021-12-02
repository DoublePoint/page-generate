import request from '@/utils/request'



// 查询Input的所有属性信息
export function getInput(id) {
  return request({
    url: '/cg/meta/queryform?id='+id,
    method: 'post'
  })
}
