package com.shui.client.config;

import com.alibaba.druid.filter.config.ConfigTools;
import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.support.http.StatViewServlet;
import com.alibaba.druid.support.http.WebStatFilter;

import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

/**
 * Druid配置类
 * 1、可以监控数据库访问性能，内置了插件：StatFilter，能够详细统计SQL执行性能，用于线上分析数据库访问性能。
 * 2、替换DBCP、C3P0数据库连接池，提供了一个高效稳定的扩展性能好的数据库连接池DruidDataSource。
 * 3、数据库加密，DruidDriuiver和DruidDataSource都支持PasswordCallback。
 * 4、SQL执行日志。
 * 5、扩展JDBC，如果你要对JDBC层有编程的需求，可以通过Druid提供的Filter-Chain机制，很方便编写JDBC层的扩展插件
 * Druid是一个阿里开源的数据库连接池框架，有可视化界面。
 * http://localhost:8080/druid/login.html
 * 可以查看sql访问速度等等很多信息，感觉还是比较有用的。集成进来试试
 * @author maybe
 */
@Configuration
@Slf4j
public class DruidConfig {

    //使用@value注入配置文件中信息
    @Value("${spring.datasource.url}")
    private String dbUrl;

    @Value("${spring.datasource.username}")
    private String username;

    @Value("${spring.datasource.password}")
    private String password;

    @Value("${spring.datasource.publicKey}")
    private String publicKey;

    @Value("${spring.datasource.driver-class-name}")
    private String driverClassName;

    @Value("${spring.datasource.initialSize}")
    private int initialSize;

    @Value("${spring.datasource.minIdle}")
    private int minIdle;

    @Value("${spring.datasource.maxActive}")
    private int maxActive;

    @Value("${spring.datasource.maxWait}")
    private int maxWait;

    @Value("${spring.datasource.timeBetweenEvictionRunsMillis}")
    private int timeBetweenEvictionRunsMillis;

    @Value("${spring.datasource.minEvictableIdleTimeMillis}")
    private int minEvictableIdleTimeMillis;

    @Value("${spring.datasource.validationQuery}")
    private String validationQuery;

    @Value("${spring.datasource.testWhileIdle}")
    private boolean testWhileIdle;

    @Value("${spring.datasource.testOnBorrow}")
    private boolean testOnBorrow;

    @Value("${spring.datasource.testOnReturn}")
    private boolean testOnReturn;

    @Value("${spring.datasource.filters}")
    private String filters;

    @Value("${spring.datasource.logSlowSql}")
    private String logSlowSql;

    @Value("${spring.datasource.connectionProperties}")
    private String connectionProperties;

    @Bean
    public ServletRegistrationBean druidServlet() throws Exception {
        ServletRegistrationBean reg = new ServletRegistrationBean();
        reg.setServlet(new StatViewServlet());
        reg.addUrlMappings("/druid/*");//配置访问URL
        reg.addInitParameter("loginUsername", username);  //配置用户名，这里使用数据库账号。
        reg.addInitParameter("loginPassword", ConfigTools.decrypt(publicKey,password));  //配置用户名，这里使用数据库密码
        reg.addInitParameter("logSlowSql", logSlowSql);   //是否启用慢sql
        return reg;
    }


    /**
     * 这个应该是数据库连接池配置
     * @return
     * @throws Exception
     */
    @Bean
    public DataSource druidDataSource() throws Exception {
        DruidDataSource datasource = new DruidDataSource();
        datasource.setUrl(dbUrl);
        datasource.setUsername(username);
        datasource.setPassword(ConfigTools.decrypt(publicKey,password));
        datasource.setDriverClassName(driverClassName);
        //datasource.set...
        return datasource;
    }

}
