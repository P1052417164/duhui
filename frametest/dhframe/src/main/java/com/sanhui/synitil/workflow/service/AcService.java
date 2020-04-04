package com.sanhui.synitil.workflow.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.Caching;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sanhui.synitil.util.RedisUtil;
import com.sanhui.synitil.workflow.dao.AcMapper;
import com.sanhui.synitil.workflow.dto.AcDto;

@Service("acService")
@CacheConfig(cacheNames = "user")
public class AcService {
	@Resource
	private AcMapper acMapper;
	@Autowired
	private RedisUtil redisUtil;

	@SuppressWarnings("unused")
	@Cacheable(cacheNames = "user", key = "'user:id:'+#dto.id")
	public AcDto getUserById(AcDto dto) {

		Object d = new Object();
		List<AcDto> dd = acMapper.getUserById(dto);
		Map<String, Object> result = new HashMap<String, Object>();
		result.put("sdd", dd);
		return dd.get(0);
	}

	@Cacheable(cacheNames = "user", key = "'user:name:'+#dto.name")
	public AcDto getUserByName(AcDto dto) {
		// 
		List<AcDto> dd = acMapper.getUserByName(dto);

		return dd.get(0);
	}

	// @Transactional
	// @Caching(put = {
	// @CachePut(value = "user", key = "'user:name:'+#result.name"),
	// @CachePut(value = "user", key = "'user:id:'+#result.id")})
	// public AcDto updateUser(AcDto dto) {
	// // 
	// acMapper.updateUser(dto);
	// return dto;
	// }
	@Transactional
	@Caching(put = { @CachePut(value = "user", key = "'user:name:'+#dto.name"), @CachePut(value = "user", key = "'user:id:'+#dto.id") })
	public AcDto saveUser(AcDto dto) {

		acMapper.saveUser(dto);
		return dto;
	}

	@Caching(evict = { @CacheEvict(value = "user", key = "'user:name:'+#dto.name"), @CacheEvict(value = "user", key = "'user:id:'+#dto.id") })
	public void deleteUser(AcDto dto) {

		acMapper.deleteUser(dto);
		redisUtil.del("user:name:hh");
	}

	@Transactional
	public AcDto updateUser(AcDto dto) {
		acMapper.updateUser(dto);
		redisUtil.set("user:id:" + dto.getId(), dto);
		return dto;
	}
}
