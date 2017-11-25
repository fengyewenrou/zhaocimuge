package com.zhaoci.share.user.service;


import com.zhaoci.framework.base.page.Page;
import com.zhaoci.share.user.po.UserInfo;

import java.util.List;

public interface UserInfoService {

	List<UserInfo> selectList(UserInfo userInfo);
	
	Page<UserInfo> queryListPage(Page<UserInfo> page);
	
	UserInfo queryById(Integer id);
	
	void add(UserInfo userInfo);

	void delete(Integer id);
	
	void update(UserInfo userInfo);
	
	void batchUpdate(List<UserInfo> userInfoList);
}