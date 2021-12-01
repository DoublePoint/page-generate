import request from '@/utils/request'

// 查询缓存详细
export function getTable() {
  return request({
    url: '/config/table/all',
    method: 'get'
  })
}

export function createTable(data){
    return request({
        url: '/config/table/',
        method: 'post',
        data: data
    })
}
export function deleteTable(ids){
    return request({
        url: '/config/table/batch',
        method: 'delete',
        data:ids
    })
}
export function updateTable(){
    return request({
        url: '/config/table/',
        method: 'put'
    })
}

export function getTableField(query) {
    return request({
      url: '/config/table/field',
      method: 'get',
      params: query
    })
  }

  
export function createTableField(data){
    return request({
        url: '/config/table/field',
        method: 'post',
        data: data
    })
}
export function deleteTableField(ids){
    return request({
        url: '/config/table/field/batch',
        method: 'delete',
        data:ids
    })
}
export function updateTableField(){
    return request({
        url: '/config/table/field',
        method: 'put'
    })
}
