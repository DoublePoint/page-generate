import request from '@/utils/request'


export function getTableMeta(tableId){
    return request({
        url: '/config/table/'+tableId,
        method: 'get',
    })
}

export function getFieldsMeta(tableId){
    return request({
        url: '/config/table/field?tableId='+tableId,
        method: 'get',
    })
}

export function saveData(data){
    return request({
        url:'/cg/single/table/data',
        method: 'post',
        data
    })
}

export function deleteData(data){
    return request({
        url:`/cg/single/table/data/`,
        method:"delete",
        data
    })
}