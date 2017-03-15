package com.xiaobu.redis.message;

import java.io.IOException;
import java.util.List;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.xiaobu.redis.message.Person;

/**
 * Created by Kinglf on 2016/10/17.
 */
public class TestRedisQueue {
    public static byte[] redisKey = "key".getBytes();
    public static JSONArray jsonArray=new JSONArray();
   /* static {
        try {
            init();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }*/

    private static void init() throws IOException {
        for (int i = 0; i < 100; i++) {
        	jsonArray.clear();
        	Person person=new Person();
        	person.setAge(i);
        	person.setName("PING"+i);
        	jsonArray.add(person);
            Message message = new Message(i, jsonArray.toJSONString());
            JedisUtil.lpush(redisKey, ObjectUtil.object2Bytes(message));
        }

    }

    public static void main(String[] args) {
        try {
        		  pop();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void pop() throws Exception {
        byte[] bytes = JedisUtil.rpop(redisKey);
        if(bytes == null){
        	return;
        }
        Message msg = (Message) ObjectUtil.bytes2Object(bytes);
        if (msg != null) {
        	List<Person> persons=JSON.parseArray(msg.getContent(), Person.class);
            System.out.println(msg.getId() + "----" + persons.get(0).getName());
        }
    }
}