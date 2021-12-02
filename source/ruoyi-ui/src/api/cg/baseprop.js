import request from '@/utils/request'


export function getBaseProp(){
    return request({
        url: '/cg/field/base',
        method: 'post'
    })
}