/** 
* 创   建   人： 刘磊
* 
* 创   建   时   间 ： 2018年4月3日
* 
* 类   说   明 ：
* 
* 修   改   人：          修   改   日   期：
*/
package cn.doublepoint.commonutil.ajaxmodel;

import cn.doublepoint.dto.domain.model.entity.BaseModel;

public class DropBean extends BaseModel{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String label;
	private String value;
	private String filter;
	
	public DropBean(){
		
	}
	
	public DropBean(String label, String value, String filter) {
		super();
		this.label = label;
		this.value = value;
		this.filter = filter;
	}


	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
	public String getFilter() {
		return filter;
	}
	public void setFilter(String filter) {
		this.filter = filter;
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}
	
	
}
