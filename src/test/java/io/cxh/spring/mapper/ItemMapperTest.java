package io.cxh.spring.mapper;

import io.cxh.spring.po.Item;
import junit.framework.TestCase;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.InputStream;

/**
 * Created by Administrator on 2017/3/13.
 */
public class ItemMapperTest extends TestCase {
    public void testSelectById() throws Exception {

        InputStream inputStream = ItemMapperTest.class.getResourceAsStream("/SqlMapConfig.xml");
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession sqlSession = factory.openSession();
        ItemMapper mapper = sqlSession.getMapper(ItemMapper.class);
        Item item = mapper.selectById(3);
        sqlSession.close();
        System.out.println(item);
    }

}