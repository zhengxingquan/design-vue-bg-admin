package com.quan.core.service;


import com.quan.core.common.model.SysClient;
import com.quan.core.common.web.PageResult;
import com.quan.core.common.web.JsonResult;

import java.util.List;
import java.util.Map;

@SuppressWarnings("all")
public interface SysClientService {

	
	JsonResult saveOrUpdate(SysClient clientDto);
	
	void delete(Long id);
	
	JsonResult updateEnabled(Map<String, Object> params);
	
	SysClient getById(Long id) ;

  
    
    public PageResult<SysClient> list(Map<String, Object> params);
    
    List<SysClient> findList(Map<String, Object> params) ;
    

	
    
}
