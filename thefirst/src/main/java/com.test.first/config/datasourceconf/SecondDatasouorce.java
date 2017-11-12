package com.test.first.config.datasourceconf;

import com.alibaba.druid.pool.DruidDataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import javax.sql.DataSource;

/**
 * Created by liuning on 2017/9/21.
 */
@Configuration
@MapperScan(basePackages = SecondDatasouorce.PACKAGE,sqlSessionFactoryRef = "secondSqlSessionFactory")
public class SecondDatasouorce {

    //精确到对应的包和其他数据源隔离
    static final String PACKAGE = "com.test.first.mapper.seconddata";
    static final String MAPPER_LOCATION = "classpath:mapper/secondmapper/*.xml";

    @Value("${second.spring.datasource.url}")
    private String url;

    @Value("${second.spring.datasource.username}")
    private String user;

    @Value("${second.spring.datasource.password}")
    private String password;

    @Value("${second.spring.datasource.driver-class-name}")
    private String driverClass;

    @Bean(name = "secondDataSource1")
    @Primary
    public DataSource secondDataSource() {
        DruidDataSource dataSource = new DruidDataSource();
        dataSource.setDriverClassName(driverClass);
        dataSource.setUrl(url);
        dataSource.setUsername(user);
        dataSource.setPassword(password);
        return dataSource;
    }

    @Bean(name = "secondTransactionManager")
    @Primary
    public DataSourceTransactionManager secondTransactionManager() {
        return new DataSourceTransactionManager(secondDataSource());
    }

    @Bean(name = "secondSqlSessionFactory")
    @Primary
    public SqlSessionFactory secondSqlSessionFactory(@Qualifier("secondDataSource1") DataSource masterDataSource)
            throws Exception {
        final SqlSessionFactoryBean sessionFactory = new SqlSessionFactoryBean();
        sessionFactory.setDataSource(masterDataSource);
        sessionFactory.setMapperLocations(new PathMatchingResourcePatternResolver()
                .getResources(SecondDatasouorce.MAPPER_LOCATION));
        return sessionFactory.getObject();
    }
}
