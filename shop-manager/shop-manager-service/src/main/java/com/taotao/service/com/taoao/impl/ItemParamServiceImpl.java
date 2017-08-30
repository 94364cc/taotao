package com.taotao.service.com.taoao.impl;

import com.taotao.mapper.TbItemParamMapper;
import com.taotao.pojo.TaotaoResult;
import com.taotao.pojo.TbItemParam;
import com.taotao.pojo.TbItemParamExample;
import com.taotao.service.ItemParamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Administrator on 2017/8/30.
 */
@Service
public class ItemParamServiceImpl implements ItemParamService{

    @Autowired
    private TbItemParamMapper itemParamMapper;
    @Override
    public TaotaoResult getItemParamByCid(long cid) {
        TbItemParamExample example=new TbItemParamExample();
        TbItemParamExample.Criteria criteria =example.createCriteria();
        criteria.andItemCatIdEqualTo(cid);
        List<TbItemParam> list = itemParamMapper.selectByExample(example);
        if(list!=null && list.size()>0){
            return TaotaoResult.ok(0);
        }

        return TaotaoResult.ok();
    }
}
