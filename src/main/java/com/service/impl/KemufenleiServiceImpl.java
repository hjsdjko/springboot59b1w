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


import com.dao.KemufenleiDao;
import com.entity.KemufenleiEntity;
import com.service.KemufenleiService;
import com.entity.vo.KemufenleiVO;
import com.entity.view.KemufenleiView;

@Service("kemufenleiService")
public class KemufenleiServiceImpl extends ServiceImpl<KemufenleiDao, KemufenleiEntity> implements KemufenleiService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<KemufenleiEntity> page = this.selectPage(
                new Query<KemufenleiEntity>(params).getPage(),
                new EntityWrapper<KemufenleiEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<KemufenleiEntity> wrapper) {
		  Page<KemufenleiView> page =new Query<KemufenleiView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
    @Override
	public List<KemufenleiVO> selectListVO(Wrapper<KemufenleiEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public KemufenleiVO selectVO(Wrapper<KemufenleiEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<KemufenleiView> selectListView(Wrapper<KemufenleiEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public KemufenleiView selectView(Wrapper<KemufenleiEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}

}
