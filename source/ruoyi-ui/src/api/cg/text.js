import request from '@/utils/request'

// 查询缓存详细
export function testGet() {
  return request({
    url: '/cg/analize?sql=select * from cg_meta_com_prop_rel',
    method: 'post'
  })
}
