package com.zhaoci.share.customer.po;

import java.io.Serializable;

public class Customer implements Serializable {
	private static final long serialVersionUID = 1L;

	/**  */
	private Integer id;

	/**  */
	private String name;

	/**  */
	private String phone;

	/**  */
	private String address;

	/**  */
	private String email;
	private  Integer sex;
	private  Integer age;
	private String synopsis;
	private String createDate;
	private String updateDate;

	public String getCreateDate() {
		return createDate;
	}

	public void setCreateDate(String createDate) {
		this.createDate = createDate;
	}

	public String getUpdateDate() {
		return updateDate;
	}

	public void setUpdateDate(String updateDate) {
		this.updateDate = updateDate;
	}

	public String getSynopsis() {
		return synopsis;
	}

	public void setSynopsis(String synopsis) {
		this.synopsis = synopsis;
	}

	public Integer getSex() {
		return sex;
	}

	public void setSex(Integer sex) {
		this.sex = sex;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	
	public Integer getId() {
		return this.id;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public String getName() {
		return this.name;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	public String getPhone() {
		return this.phone;
	}

	public void setAddress(String adress) {
		this.address = adress;
	}
	
	public String getAddress() {
		return this.address;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getEmail() {
		return this.email;
	}

}