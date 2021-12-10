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

export function getWidth(obj){
  return this.pGetFieldObjPro(obj,'WIDTH');
}
export function getRelProp(obj){
  var relObjectProp = obj.relObjectProp;
  if(relObjectProp == null){
    console.log(`${JSON.stringify(obj)}: obj.relObjectProp为空.`);
  }
  else{
    return relObjectProp;
  }
  if (obj.relDomain == null) {
    console.log(`${JSON.stringify(obj)}:obj.relDomain为空.`);
    return ''
  }
  if (obj.relDomain.relObjectProp == null) {
    console.log(`${JSON.stringify(obj)}:obj.relDomain.relObjectProp为空`);
    return ''
  }
  return obj.relDomain.relObjectProp;
}

export function pGetFieldObjPro(obj, propName) {
  var relObjectProp = getRelProp(obj);
  if (relObjectProp[propName] == null) {
    console.log(`${JSON.stringify(obj)}:relObjectProp.${propName}为空`);
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