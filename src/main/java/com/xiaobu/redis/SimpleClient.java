package com.xiaobu.redis;

import org.junit.Test;

public class SimpleClient {
	@Test
	public void userCache(){
		
		//�򻺴��б������
		UserDO zhuoxuan = new UserDO();
		zhuoxuan.setUserId(113445);
		zhuoxuan.setSex(1);
		zhuoxuan.setUname("׿��");
		zhuoxuan.setUnick("zhuoxuan");
		zhuoxuan.setEmail("zhuoxuan@mogujie.com");
		//���÷�������
		boolean reusltCache = RedisClient.set("zhuoxuan", zhuoxuan);
		if (reusltCache) {
			System.out.println("�򻺴��б������ɹ���");
		}else{
			System.out.println("�򻺴��б������ʧ�ܡ�");
		}
	}
	
	
	@Test
	public void getUserInfo(){
		
		UserDO zhuoxuan = RedisClient.get("xiao",UserDO.class);
		if(zhuoxuan != null){
			System.out.println("�ӻ����л�ȡ�Ķ���" + zhuoxuan.getUname() + "@" + zhuoxuan.getEmail());
		}else{
			System.out.println("δ��ѯ���û�");
		}
	}
}
