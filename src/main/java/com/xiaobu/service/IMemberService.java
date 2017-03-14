package com.xiaobu.service;

import java.util.List;
import java.util.Map;

import com.xiaobu.model.Member;

public interface IMemberService {

	public List<Member> queryData(Map<String,Object> params);
	
	public int countData(Map<String,Object> params) ;
	public Member findMemberByPhone(String phoneNumber);
	public void insert(Member member);
}
