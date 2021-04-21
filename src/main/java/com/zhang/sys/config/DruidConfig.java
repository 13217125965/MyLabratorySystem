package com.zhang.sys.config;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.support.http.StatViewServlet;
import com.alibaba.druid.support.http.WebStatFilter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;


@Component
@Configuration
public class DruidConfig {


    @Bean(initMethod = "init")
    @ConfigurationProperties(prefix = "spring.datasource")//配置这个目地是读取配置文件里面的数据
    public DruidDataSource getDruidDataSource() {
        return new DruidDataSource();
    }

    /**
     * 配置监控的servlet
     *
     * @return
     */

    @Bean
    public ServletRegistrationBean<StatViewServlet> statViewServlet() {
        ServletRegistrationBean<StatViewServlet> bean = new ServletRegistrationBean<>();
        bean.setServlet(new StatViewServlet());
        bean.addUrlMappings("/druid/*");
        Map<String, String> initParams = new HashMap<>();
        initParams.put("loginUsername", "admin");
        initParams.put("loginPassword", "123456");
        initParams.put("allow", "");//允许所有ip访问
        initParams.put("deny", "192.168.1.1");//排除哪些IP
        //是否可以重置数据
        initParams.put("resetEnable", "false");
        bean.setInitParameters(initParams);
        return bean;
    }

    /**
     * 配置监控的过滤器
     *
     * @return
     */
    @Bean
    public FilterRegistrationBean<WebStatFilter> getWebStatFilter() {
        FilterRegistrationBean<WebStatFilter> registrationBean = new FilterRegistrationBean<>();
        registrationBean.setFilter(new WebStatFilter());
        Map<String, String> initParameters = new HashMap<>();
        initParameters.put("exclusions", "*.js,*.gif,*.jpg,*.png,*.css,*.ico,/druid/*");
        registrationBean.setInitParameters(initParameters);
        registrationBean.addUrlPatterns("/*");
        return registrationBean;
    }


}
