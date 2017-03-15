package com.xiaobu.redis;

import org.junit.Test;

public class SimpleClient {
	@Test
	public void userCache(){
		
		//向缓存中保存对象
		UserDO zhuoxuan = new UserDO();
		zhuoxuan.setUserId(113445);
		zhuoxuan.setSex(1);
		zhuoxuan.setUname("卓轩");
		zhuoxuan.setUnick("zhuoxuan");
		zhuoxuan.setEmail("zhuoxuan@mogujie.com");
		//调用方法处理
		boolean reusltCache = RedisClient.set("zhuoxuan", zhuoxuan);
		if (reusltCache) {
			System.out.println("向缓存中保存对象成功。");
		}else{
			System.out.println("向缓存中保存对象失败。");
		}
	}
	
	
	@Test
	public void getUserInfo(){
		
		UserDO zhuoxuan = RedisClient.get("xiao",UserDO.class);
		if(zhuoxuan != null){
			System.out.println("从缓存中获取的对象，" + zhuoxuan.getUname() + "@" + zhuoxuan.getEmail());
		}else{
			System.out.println("未查询到用户");
		}
	}
}
