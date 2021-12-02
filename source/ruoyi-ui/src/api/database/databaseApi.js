import request from '@/utils/request'

// 查询缓存详细
export function getTableDataAll(tableCode) {
  return request({
    url: `/database/all/${tableCode}`,
    method: 'get'
  })
}
