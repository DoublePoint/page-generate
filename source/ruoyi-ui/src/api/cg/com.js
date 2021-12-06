import request from '@/utils/request'

// 查询Input的所有属性信息
export function getAllExtendProp(id) {
  return request({
    url: '/cg/meta/com/prop?id='+id,
    method: 'get'
  })
}

export function getComMetaByComCode(comCode){
  return request({
    url: `/cg/meta/com/prop?code=${comCode}`,
    method: 'get'
  })
}