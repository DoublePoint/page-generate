export function getDropName(obj) {
  //return pGetFieldObjPro(obj, 'dropname');
  return pGetFieldObjPro(obj, 'SELECT_DROP_NAME');
};

export function getFieldLabel(obj) {
  return pGetFieldObjPro(obj, 'LABEL');
};

export function getDomType(obj) {
  return pGetFieldObjPro(obj, 'DOM_TYPE');
};

export function getFieldBindProp(obj){
  return obj.propCode;
}

export function getFieldDefaultValue(obj){
  return pGetFieldObjPro(obj, 'DEFAULT_VALUE')
}

export function isDefaultValueProp(obj){
  return getFieldBindProp(obj)=='DEFAULT_VALUE';
}

export function getFieldAlign(obj){
  return pGetFieldObjPro(obj,'ALIGN');
}
export function getTableSort(obj){
  return pGetFieldObjPro(obj,'TABLE_SORT');
}
export function getFormSort(obj){
  return pGetFieldObjPro(obj,'FORM_SORT');
}
export function getQueryItemSort(obj){
  return pGetFieldObjPro(obj,'QUERY_ITEM_SORT');
}

export function getIsQueryItem(obj){
  return pGetFieldObjPro(obj,'IS_QUERY_ITEM');
}

export function getQueryItemDefaultValue(obj){
  return pGetFieldObjPro(obj,'QUERY_ITEM_DEFAULT_VALUE');
}


export function getWidth(obj){
  return this.pGetFieldObjPro(obj,'WIDTH');
}
export function getRelProp(obj){
  var relObjectProp = obj.relObjectProp;
  if(relObjectProp == null){
    // console.log(`obj.relObjectProp为空.`);
  }
  else{
    return relObjectProp;
  }
  if (obj.relDefaultDomain == null) {
    // console.log(`obj.relDomain为空.`);
    return ''
  }
  if (obj.relDefaultDomain.relObjectProp == null) {
    // console.log(`obj.relDomain.relObjectProp为空`);
    return ''
  }
  return obj.relDefaultDomain.relObjectProp;
}

export function getExtDomain(obj){
  if (obj.relExtDomain == null) {
    // console.log(`obj.relDomain为空.`);
    return null
  }
  return obj.relExtDomain.relObjectProp;
}

export function pGetFieldObjPro(obj, propName) {
  var relObjectProp = getRelProp(obj);
  if (relObjectProp[propName] == null) {
    // console.log(`relObjectProp.${propName}为空`);
    return ''
  }
  return relObjectProp[propName].propValue;
};

export function isSelect(obj) {
  return getDropName(obj) != "";
};

// export function isDict(obj) {
//   return getDictName(obj) != "";
// };

// export function isDrop(obj) {
//   return getDropName(obj) != "";
// };

export function isTextarea(obj){
  return pGetFieldObjPro(obj, 'DOM_TYPE')=="05";
}