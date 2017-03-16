package io.cxh.spring.service;

import io.cxh.spring.mapper.ItemMapper;
import io.cxh.spring.po.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * Created by Administrator on 2017/3/14.
 */
@Service
public class ItemService {
    //注入dao，dao对象是通过动态代理生成的
    @Autowired
    private ItemMapper itemMapper;

    //根据id查询商品
    public Item getById(int id) {

        return itemMapper.selectById(id);
    }

    //根据id查询商品
    public Item findItemById(int id) {

        Item item = itemMapper.selectById(id);
        return item;
    }

    //根据id修改商品信息
    public void update(Item item) {
        itemMapper.updateById(item);
        return ;
    }
}
