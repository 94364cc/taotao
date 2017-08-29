package com.taotao.service.com.taoao.impl;


import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.taotao.mapper.TbItemDescMapper;
import com.taotao.mapper.TbItemMapper;
import com.taotao.pojo.*;
import com.taotao.service.ItemService;
import com.taotao.service.util.Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * Created by Administrator on 2017/8/6.
 */
@Service
public class ItemServiceImpl implements ItemService {

    @Autowired
    private TbItemMapper itemMapper;

    @Autowired
    private TbItemDescMapper itemDescMapper;

    @Override
    public TbItem getItemById(long itemId) {
        TbItem item=itemMapper.selectByPrimaryKey(itemId);
        return item;
    }

    @Override
    public EUDataGridResult getItemList(int page, int rows) {
        TbItemExample itemExample=new TbItemExample();
        PageHelper.startPage(page, rows);
        List<TbItem> list=itemMapper.selectByExample(itemExample);
        EUDataGridResult result=new EUDataGridResult();
        result.setRows(list);
        PageInfo<TbItem> pageInfo=new PageInfo<>(list);
        result.setTotal(pageInfo.getTotal());
        return result;

    }

    @Override
    public TaotaoResult insertItemDesc(long itemId,String desc) {
        TbItemDesc itemDesc=new TbItemDesc();
        itemDesc.setItemId(itemId);
        itemDesc.setItemDesc(desc);
        itemDesc.setCreated(new Date());
        itemDesc.setUpdated(new Date());
        return TaotaoResult.ok();
    }

    @Override
    public TaotaoResult createItem(TbItem item, String desc) throws Exception {
        long itemId= Util.getItemId();
        item.setCreated(new Date());
        item.setUpdated(new Date());
        //插入商品描述
        TaotaoResult result=insertItemDesc(itemId,desc);
        if (result.getStatus()!=200){
            //Spring 如果抛异常会自动回滚事务
            throw new Exception();
        }
        return TaotaoResult.ok();
    }
}