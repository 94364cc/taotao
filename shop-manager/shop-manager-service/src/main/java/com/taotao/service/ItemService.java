package com.taotao.service;

import com.taotao.pojo.EUDataGridResult;
import com.taotao.pojo.TbItem;

/**
 * Created by Administrator on 2017/8/6.
 */
public interface ItemService {
    TbItem getItemById(long itemId);

    public EUDataGridResult getItemList(int page,int rows);
}