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
@MapperScan(basePackages = FirstDatasource.PACKAGE,sqlSessionFactoryRef = "firstSqlSessionFactory")
public class FirstDatasource {
    //精确到对应的包和其他数据源隔离
    static final String PACKAGE = "com.test.first.mapper.firstdata";
    static final String MAPPER_LOCATION = "classpath:mapper/firstmapper/*.xml";

    @Value("${first.spring.datasource.url}")
    private String url;

    @Value("${first.spring.datasource.username}")
    private String user;

    @Value("${first.spring.datasource.password}")
    private String password;

    @Value("${first.spring.datasource.driver-class-name}")
    private String driverClass;

    @Bean(name = "firstDataSource")
    public DataSource firstDataSource() {
        DruidDataSource dataSource = new DruidDataSource();
        dataSource.setDriverClassName(driverClass);
        dataSource.setUrl(url);
        dataSource.setUsername(user);
        dataSource.setPassword(password);
        return dataSource;
    }

    @Bean(name = "firstTransactionManager")
    public DataSourceTransactionManager firstTransactionManager() {
        return new DataSourceTransactionManager(firstDataSource());
    }

    @Bean(name = "firstSqlSessionFactory")
    public SqlSessionFactory firstSqlSessionFactory(@Qualifier("firstDataSource") DataSource masterDataSource)
            throws Exception {
        final SqlSessionFactoryBean sessionFactory = new SqlSessionFactoryBean();
        sessionFactory.setDataSource(masterDataSource);
        sessionFactory.setMapperLocations(new PathMatchingResourcePatternResolver()
                .getResources(FirstDatasource.MAPPER_LOCATION));
        return sessionFactory.getObject();
    }
}
