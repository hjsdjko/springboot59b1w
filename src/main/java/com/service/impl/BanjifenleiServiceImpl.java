package com.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import java.util.List;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.utils.PageUtils;
import com.utils.Query;


import com.dao.BanjifenleiDao;
import com.entity.BanjifenleiEntity;
import com.service.BanjifenleiService;
import com.entity.vo.BanjifenleiVO;
import com.entity.view.BanjifenleiView;

@Service("banjifenleiService")
public class BanjifenleiServiceImpl extends ServiceImpl<BanjifenleiDao, BanjifenleiEntity> implements BanjifenleiService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<BanjifenleiEntity> page = this.selectPage(
                new Query<BanjifenleiEntity>(params).getPage(),
                new EntityWrapper<BanjifenleiEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<BanjifenleiEntity> wrapper) {
		  Page<BanjifenleiView> page =new Query<BanjifenleiView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
    @Override
	public List<BanjifenleiVO> selectListVO(Wrapper<BanjifenleiEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public BanjifenleiVO selectVO(Wrapper<BanjifenleiEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<BanjifenleiView> selectListView(Wrapper<BanjifenleiEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public BanjifenleiView selectView(Wrapper<BanjifenleiEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}

}
