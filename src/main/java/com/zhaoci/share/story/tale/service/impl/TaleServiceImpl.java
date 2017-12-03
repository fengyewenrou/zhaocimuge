package com.zhaoci.share.story.tale.service.impl;

import java.util.List;

import javax.annotation.Resource;

import com.zhaoci.framework.base.Constants;
import com.zhaoci.framework.base.datasource.DataSource;
import com.zhaoci.framework.base.datasource.DataSourceEnum;
import com.zhaoci.framework.base.page.Page;
import com.zhaoci.share.story.po.TaleLable;
import com.zhaoci.share.story.po.TaleType;
import com.zhaoci.share.story.service.TaleLableService;
import com.zhaoci.share.story.service.TaleTypeService;
import com.zhaoci.share.utils.DateUtil;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.zhaoci.share.story.tale.dao.TaleDao;
import com.zhaoci.share.story.tale.po.Tale;
import com.zhaoci.share.story.tale.service.TaleService;

@DataSource(DataSourceEnum.MASTER)
@Service("tale")
public class TaleServiceImpl implements TaleService {
	@Resource(name="taleDao")
	private TaleDao taleDao;
	@Resource
	private TaleLableService taleLableService;
	@Resource
	private TaleTypeService taleTypeService;

	@Override
	public List<Tale> selectList(Tale tale) {
		return taleDao.selectList(tale);
	}

	@Override
	public Page<Tale> queryListPage(Page<Tale> page) {
	    page.setResultList(taleDao.queryListPage(page));
		return page;
	}

	@Override
	public Page<Tale> queryListPage2(Page<Tale> page) {
		page.setResultList(taleDao.queryListPage2(page));
		return page;
	}

	@Override
	public Tale queryById(Integer id) {
		return taleDao.queryById(id);
	}
	
	@Override
	@Transactional(propagation=Propagation.REQUIRED,rollbackFor={RuntimeException.class, Exception.class})
	public void add(Tale tale) {
		taleDao.insert(tale);
	}
	@Override
	@Transactional(propagation=Propagation.REQUIRED,rollbackFor={RuntimeException.class, Exception.class})
	public void delete(Integer id) {
		taleDao.delete(id);
	}
	
	@Override
	@Transactional(propagation=Propagation.REQUIRED,rollbackFor={RuntimeException.class, Exception.class})
	public void update(Tale tale) {
		taleDao.update(tale);
	}

	@Override
	@Transactional(propagation=Propagation.REQUIRED,rollbackFor={RuntimeException.class, Exception.class})
	public void insertTale(Tale tale) {
		taleDao.insert(tale);
		//故事和类型关联
		TaleType taleType = new TaleType();
		taleType.setTaleId(tale.getId());
		taleType.setTypeId(Integer.parseInt(tale.getAssortment()));
		taleType.setIsUsed(Constants.TRUE);
		taleType.setCreateDate(DateUtil.getCurrDate(DateUtil.DATETIME_FORMAT));
		//故事和标签关联
		TaleLable taleLable = new TaleLable();
		taleLable.setTaleId(tale.getId());
		taleLable.setLableId(Integer.parseInt(tale.getLabel()));
		taleLable.setIsUsed(Constants.TRUE);
		taleLable.setCreateDate(DateUtil.getCurrDate(DateUtil.DATETIME_FORMAT));



	}

	@Override
  @Transactional(propagation=Propagation.REQUIRED,rollbackFor={RuntimeException.class, Exception.class})
	public void batchUpdate(List<Tale> taleList) {
		taleDao.batchUpdate(taleList);
	}
}