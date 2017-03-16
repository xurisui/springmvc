package io.cxh.spring;

import com.jolbox.bonecp.BoneCPDataSource;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import javax.sql.DataSource;

/**
 * Created by Administrator on 2017/3/14.
 */

@Configuration
@MapperScan(basePackages = "io.cxh.spring.mapper", annotationClass = Mapper.class)
public class MybatisConfig {

    // c3p0, bonecp ->连接池
    @Bean
    public DataSource dataSource() {
        BoneCPDataSource dataSource = new BoneCPDataSource();
        dataSource.setDriverClass("com.mysql.cj.jdbc.Driver");
        dataSource.setJdbcUrl("jdbc:mysql://localhost:3306/cxh_jdbc?serverTimezone=GMT");
        dataSource.setUsername("root");
        dataSource.setPassword("root");
        return dataSource;
    }



    @Bean
    public DataSourceTransactionManager transactionManager() {
        return new DataSourceTransactionManager(dataSource());
    }



    private String mapperLocationPattern = "/mapper/*.xml";

    @Bean
    public SqlSessionFactory getSqlSession() throws Exception {

        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
        sqlSessionFactoryBean.setDataSource(dataSource());

        PathMatchingResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();

        sqlSessionFactoryBean.setMapperLocations(resolver.getResources(mapperLocationPattern));

        return sqlSessionFactoryBean.getObject();

    }

}
