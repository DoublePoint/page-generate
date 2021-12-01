import request from '@/utils/request'


export function getBaseProp(){
    console.log("123");
    return request({
        url: '/cg/field/base',
        method: 'post'
    })
}