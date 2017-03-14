package com.xiaobu.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xiaobu.dao.MemberMapper;
import com.xiaobu.model.Member;
import com.xiaobu.service.IMemberService;

@Service
public class MemberServiceImpl implements IMemberService {

	@Autowired
	private MemberMapper memberMapper;

	@Override
	public List<Member> queryData(Map<String, Object> params) {
		return memberMapper.queryData(params);
	}

	@Override
	public int countData(Map<String, Object> params) {
		return memberMapper.countData(params);
	}
	@Override
	public  Member findMemberByPhone(String phoneNumber){
		return memberMapper.findMemberByPhone(phoneNumber);
	}
	@Override
	public void insert(Member member) {
		memberMapper.insert(member);
	}
}
