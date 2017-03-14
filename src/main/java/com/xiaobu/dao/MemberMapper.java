package com.xiaobu.dao;

import java.util.List;
import java.util.Map;

import com.xiaobu.model.Member;

public interface MemberMapper {
	
	public List<Member> queryData(Map<String,Object> params);
	
	public Integer countData(Map<String,Object> params);
	public Member findMemberByPhone(String phoneNumber);
	public void insert(Member member);
}