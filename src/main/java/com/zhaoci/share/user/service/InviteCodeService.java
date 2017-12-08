package com.zhaoci.share.user.service;

import com.zhaoci.framework.base.page.Page;
import com.zhaoci.share.user.po.InviteCode;

import java.util.List;

public interface InviteCodeService {

	List<InviteCode> selectList(InviteCode inviteCode);
	
	Page<InviteCode> queryListPage(Page<InviteCode> page);
	
	InviteCode queryById(Integer id);
	
	void add(InviteCode inviteCode);

	void delete(Integer id);
	
	void update(InviteCode inviteCode);
	
	void batchUpdate(List<InviteCode> inviteCodeList);
}