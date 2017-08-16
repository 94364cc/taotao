package com.taotao.controller;

import com.taotao.pojo.EUDataGridResult;
import com.taotao.pojo.TbItem;
import com.taotao.pojo.TbItemCat;
import com.taotao.service.ItemCatService;
import com.taotao.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2017/8/6.
 */
@Controller
@RequestMapping("/item/cat")
public class ItemCatController {
    @Autowired
    private ItemCatService itemCatService;

    @RequestMapping("/list")
    @ResponseBody
    public List<TbItemCat> categoryList(@RequestParam(value="id",defaultValue="0") long parentId){
        List catList=new ArrayList();
        //查询数据库
        List<TbItemCat> list=itemCatService.getItemCatList(parentId);
        for(TbItemCat itemCat:list){
            Map node=new HashMap();
            node.put("id",itemCat.getId());
            node.put("text",itemCat.getName());
            node.put("state",itemCat.getIsParent()?"closed":"open");
            catList.add(node);
        }
        return catList;
    }



}
