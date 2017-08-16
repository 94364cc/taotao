package com.taotao.service;

import com.taotao.pojo.EUDataGridResult;
import com.taotao.pojo.TbItem;
import com.taotao.pojo.TbItemCat;

import java.util.List;

/**
 * Created by Administrator on 2017/8/6.
 */
public interface ItemCatService {
    public List<TbItemCat> getItemCatList(long parentId);
}