package com.quan.core.service;

import com.quan.core.common.model.SysClient;
import com.quan.core.common.model.SysService;

import java.util.List;
import java.util.Map;

@SuppressWarnings("all")
public interface SysClientService {

	SysClient findClientByClientId(String clientId);
	
	List<SysService> findAllClientByClientId(Long clientId);
}
