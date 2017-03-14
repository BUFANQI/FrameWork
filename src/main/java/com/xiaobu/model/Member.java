package com.xiaobu.model;

import java.util.Date;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Member implements java.io.Serializable{
	private static final long serialVersionUID = 1L;
	private int id;
	private int industryId;
	private String industry;
	private String phoneNumber;
	private int status;
	private String userCode;
	private String name;
	private Date createDate;
	private int gender;
	private String avatarUrl;
	private int idType;
	private String idNumber;
	private String birthDate;
	private String email;
	private String address;
}
