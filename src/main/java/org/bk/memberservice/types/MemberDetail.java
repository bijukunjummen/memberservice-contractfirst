package org.bk.memberservice.types;

import javax.activation.DataHandler;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "MemberDetail", namespace="http://bk.org/memberservice/" )
@Entity
@Table(name="memberdetails")
public class MemberDetail {
	public MemberDetail() {

	}

	public MemberDetail(String name, String phone, String city, String state) {
		this.name = name;
		this.phone = phone;
		this.city = city;
		this.state = state;
	}

	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    @XmlElement(name="id", namespace="http://bk.org/memberservice/")
    private Long id;

	@XmlElement(name="name", namespace="http://bk.org/memberservice/")
	private String name;
	
	@XmlElement(name="phone", namespace="http://bk.org/memberservice/")
	private String phone;
	
	@XmlElement(name="city", namespace="http://bk.org/memberservice/")
	private String city;
	
	@XmlElement(name="state", namespace="http://bk.org/memberservice/")
	private String state;
	

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    
    @XmlElement(name="picture", namespace="http://bk.org/memberservice/")
    @Transient
    private Picture picture;

	public Picture getPicture() {
		return picture;
	}

	public void setPicture(Picture picture) {
		this.picture = picture;
	}
    
    
}
