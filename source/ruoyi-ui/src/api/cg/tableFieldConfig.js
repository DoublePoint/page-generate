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

export function clearFieldDomainCode(fieldId){
    return request({
        url: `/config/table/field/${fieldId}/domaincode`,
        method: 'delete'
    })
}


export function changeFieldDomainCode(domainCode,fieldId){
    return request({
        url: `cg/domain/${domainCode}/to/field/${fieldId}`,
        method: 'post',
    })
}

export function saveFieldExtendProp(data){
    return request({
        url: `config/table/field/prop`,
        method: 'post',
        data
    })
}

export function queryData(data){
    return request({
        url:'/cg/single/table/query/data',
        method: 'post',
        data
    })
}

export function deleteFieldPrivateProp(data){
    return request({
        url:   `config/table/field/private/prop`,
        method: `delete`,
        data
    })
}