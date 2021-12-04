import request from '@/utils/request'


export function saveDomainObject(data){
    return request({
        url: '/cg/domain/object/prop',
        method: 'post',
        data
    })
}

