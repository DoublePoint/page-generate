import request from '@/utils/request'

// 查询缓存详细
export function analize() {
  return request({
    url: '/cg/analize?sql=select * from sys_menu',
    method: 'post'
  })
}

// 查询缓存详细
export function getInput(id) {
  return request({
    url: '/cg/meta/queryform?id='+id,
    method: 'post'
  })
}
