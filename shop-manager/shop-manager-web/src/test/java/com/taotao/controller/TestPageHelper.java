package com.taotao.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.taotao.mapper.TbItemMapper;
import com.taotao.pojo.TbItem;
import com.taotao.pojo.TbItemExample;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

/**
 * Created by Administrator on 2017/8/6.
 */
public class TestPageHelper {

    @Test
    public void  testPageHelper(){
        //创建一个spring容器
        ApplicationContext applicationContext=new ClassPathXmlApplicationContext("classpath:spring/applicationContext-*.xml");
        //从spring容器中获得Mapper的代理对象
        TbItemMapper mapper=applicationContext.getBean(TbItemMapper.class);
        //执行查询，并且分页
        TbItemExample example=new TbItemExample();
        PageHelper.startPage(1,10);
        List<TbItem> list=mapper.selectByExample(example);
        for(TbItem item:list){
            System.out.println(item.getTitle());
        }
        //取分页信息
        PageInfo<TbItem> pageInfo=new PageInfo<TbItem>(list);
        long total=pageInfo.getTotal();
        System.out.println("共有商品"+total);

    }
}
