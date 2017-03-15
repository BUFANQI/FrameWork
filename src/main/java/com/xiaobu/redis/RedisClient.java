package com.xiaobu.redis;

import java.util.ResourceBundle;

import com.alibaba.fastjson.JSON;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

/***
 * <p>
 * 		Redis�ͻ��˷���
 * </p>
 *@author Administrator
 *@version:1.0
 */
public class RedisClient {
	public  static  JedisPool jedisPool; // �ػ�����jedis���ӳ�
static {
		
		//��ȡ��ص�����
		ResourceBundle resourceBundle = ResourceBundle.getBundle("redis");
		int maxActive = Integer.parseInt(resourceBundle.getString("redis.pool.maxActive"));
		int maxIdle = Integer.parseInt(resourceBundle.getString("redis.pool.maxIdle"));
		int maxWait = Integer.parseInt(resourceBundle.getString("redis.pool.maxWait"));
		
		String ip = resourceBundle.getString("redis.ip");
		int port = Integer.parseInt(resourceBundle.getString("redis.port"));
		
		JedisPoolConfig config = new JedisPoolConfig();  
		//�������������
		config.setMaxTotal(maxActive);
		//������������
		config.setMaxIdle(maxIdle);
		//���ó�ʱʱ��
		config.setMaxWaitMillis(maxWait);
		
		//��ʼ�����ӳ�
		jedisPool = new JedisPool(config, ip, port); 
	}
	
	/**
	 * �򻺴��������ַ�������
	 * @param key key
	 * @param value value
	 * @return
	 * @throws Exception
	 */
	public static boolean  set(String key,String value) throws Exception{
		Jedis jedis = null;
		try {
			jedis = jedisPool.getResource();
			jedis.set(key, value);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}finally{
			jedisPool.returnResource(jedis);
		}
	}
	
	/**
	 * �򻺴������ö���
	 * @param key 
	 * @param value
	 * @return
	 */
	public static boolean  set(String key,Object value){
		Jedis jedis = null;
		try {
			String objectJson = JSON.toJSONString(value);
			jedis = jedisPool.getResource();
			jedis.set(key, objectJson);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}finally{
			jedisPool.returnResource(jedis);
		}
	}
	
	/**
	 * ɾ�������еö��󣬸���key
	 * @param key
	 * @return
	 */
	public static boolean del(String key){
		Jedis jedis = null;
		try {
			jedis = jedisPool.getResource();
			jedis.del(key);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}finally{
			jedisPool.returnResource(jedis);
		}
	}
	
	/**
	 * ����key ��ȡ����
	 * @param key
	 * @return
	 */
	public static Object get(String key){
		Jedis jedis = null;
		try {
			jedis = jedisPool.getResource();
			Object value = jedis.get(key);
			return value;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}finally{
			jedisPool.returnResource(jedis);
		}
	}
	

	/**
	 * ����key ��ȡ����
	 * @param key
	 * @return
	 */
	public static <T> T get(String key,Class<T> clazz){
		Jedis jedis = null;
		try {
			jedis = jedisPool.getResource();
			String value = jedis.get(key);
			return JSON.parseObject(value, clazz);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}finally{
			jedisPool.returnResource(jedis);
		}
	}
}
