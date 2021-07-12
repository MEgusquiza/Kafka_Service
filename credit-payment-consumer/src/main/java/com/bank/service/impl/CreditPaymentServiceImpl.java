package com.bank.service.impl;

import java.util.Map;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.bank.model.CreditPayment;
import com.bank.service.CreditPaymentService;

@Repository
public class CreditPaymentServiceImpl implements CreditPaymentService{

	@Autowired
	  private RedisTemplate<String, Object> redisTemplate;
	  private HashOperations<String,String,CreditPayment> hashOperations;

	  @Autowired
	public CreditPaymentServiceImpl(RedisTemplate<String, Object> redisTemplate) {
	        this.redisTemplate = redisTemplate;
	        hashOperations = redisTemplate.opsForHash();
	 } 
	  
	@Override
	public CreditPayment findById(String id) {
	 return (CreditPayment)hashOperations.get("CreditPayment", id);
	}

	@Override
	public Map<String, CreditPayment> findAll() {
    return hashOperations.entries("CreditPayment");
	}

	@Override
	public void update(CreditPayment creditPayment) {
		save(creditPayment);
	}

	@Override
	public void save(CreditPayment creditPayment) {
    hashOperations.put("CreditPayment", creditPayment.getId(), creditPayment);
	}

	@Override
	public void delete(String id) {
	hashOperations.delete("CreditPayment", id);		
	}

}
