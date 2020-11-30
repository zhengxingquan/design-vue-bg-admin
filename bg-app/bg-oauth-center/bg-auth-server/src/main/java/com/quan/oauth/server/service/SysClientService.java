package com.quan.oauth.server.service;


import com.quam.common.model.SysClient;
import com.quam.common.web.PageResult;
import com.quam.common.web.Result;

import java.util.List;
import java.util.Map;

@SuppressWarnings("all")
public interface SysClientService {

	
	Result saveOrUpdate(SysClient clientDto);
	
	void delete(Long id);
	
	Result updateEnabled(Map<String, Object> params);
	
	SysClient getById(Long id) ;

  
    
    public PageResult<SysClient> list(Map<String, Object> params);
    
    List<SysClient> findList(Map<String, Object> params) ;
    

	
    
}
