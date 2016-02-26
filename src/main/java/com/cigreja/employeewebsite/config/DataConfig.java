
package com.cigreja.employeewebsite.config;

import java.util.Properties;
import javax.sql.DataSource;
import org.apache.commons.dbcp.BasicDataSource;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.hibernate5.LocalSessionFactoryBuilder;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * DataConfig
 * @author Carlos Igreja
 * @since  Feb 21, 2016
 */
@Configuration
@EnableTransactionManagement
public class DataConfig {

    @Bean(name = "datasource")
    public DataSource datasource(){
        
        BasicDataSource dataSource = new BasicDataSource();
        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://localhost:3306/hibernateDB");
        dataSource.setUsername("root");
        dataSource.setPassword("");
        
        return dataSource;
    }
    
    @Autowired
    @Bean(name = "sessionFactory")
    public SessionFactory sessionFactory(DataSource dataSource){
        
        String[] packagesToScan = {"com.cigreja.employeewebsite.business"};  
        
        String hibernateDialect = "org.hibernate.dialect.MySQL5Dialect";
        
        // this sets hibernate properties
        Properties hibernateProperties = new Properties();
        hibernateProperties.setProperty("hibernate.dialect", hibernateDialect);
        hibernateProperties.setProperty("hibernate.show_sql", "true");
        hibernateProperties.setProperty("hibernate.hbm2ddl.auto", "create");
        hibernateProperties.setProperty("hibernate.id.new_generator_mappings", "false");

        LocalSessionFactoryBuilder sessionFactoryBuilder;
        sessionFactoryBuilder = new LocalSessionFactoryBuilder(dataSource);
        sessionFactoryBuilder.scanPackages(packagesToScan);
        sessionFactoryBuilder.addProperties(hibernateProperties);
        return sessionFactoryBuilder.buildSessionFactory();
    }
}
