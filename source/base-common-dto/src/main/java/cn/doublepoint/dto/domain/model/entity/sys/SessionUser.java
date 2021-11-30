package cn.doublepoint.dto.domain.model.entity.sys;

import java.io.Serializable;
import java.util.Date;


public class SessionUser  implements Serializable {
	private static final long serialVersionUID = 1L;

	private Integer id;

	private Date createTime;

	private String loginAccountNo;

	private String loginPassword;

	private Date modifyTime;

	private String name;
	
	private Integer iconId;

	public SessionUser() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Date getCreateTime() {
		return this.createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public String getLoginAccountNo() {
		return this.loginAccountNo;
	}

	public void setLoginAccountNo(String loginAccountNo) {
		this.loginAccountNo = loginAccountNo;
	}

	public String getLoginPassword() {
		return this.loginPassword;
	}

	public void setLoginPassword(String loginPassword) {
		this.loginPassword = loginPassword;
	}

	public Date getModifyTime() {
		return this.modifyTime;
	}

	public void setModifyTime(Date modifyTime) {
		this.modifyTime = modifyTime;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getIconId() {
		return iconId;
	}

	public void setIconId(Integer iconId) {
		this.iconId = iconId;
	}

}