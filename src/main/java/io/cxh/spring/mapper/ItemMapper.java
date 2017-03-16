package io.cxh.spring.mapper;

import io.cxh.spring.po.Item;
import org.apache.ibatis.annotations.Mapper;

/**
 * Created by Administrator on 2017/3/13.
 */
@Mapper
public interface ItemMapper {

    Item selectById(int id);

    int updateById(Item item);


}

