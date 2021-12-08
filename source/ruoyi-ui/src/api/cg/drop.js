import request from '@/utils/request'

export function getDrop(dropCode) {
  return request({
    url: `sys/extend/drop?dropCode=${dropCode}`,
    methods: 'get'
  })
}
