package com.quan.core.service;

import com.quan.core.constant.model.SysClient;
import com.quan.core.constant.model.SysService;

import java.util.List;

@SuppressWarnings("all")
public interface SysClientService {

	SysClient findClientByClientId(String clientId);
	
	List<SysService> findAllClientByClientId(Long clientId);
}
