
package com.cigreja.employeewebsite.config;

import java.io.IOException;
import java.util.Properties;
import javax.sql.DataSource;
import org.apache.commons.dbcp.BasicDataSource;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.hibernate4.HibernateTransactionManager;
import org.springframework.orm.hibernate4.LocalSessionFactoryBean;
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

        try {
            LocalSessionFactoryBean lsfb = new LocalSessionFactoryBean();
            lsfb.setDataSource(dataSource);
            String[] packagesToScan = {"com.cigreja.employeewebsite.business"};
            lsfb.setAnnotatedPackages(packagesToScan);
            
            // this sets hibernate properties
            Properties hibernateProperties = new Properties();
            String hibernateDialect = "org.hibernate.dialect.MySQL5Dialect";
            hibernateProperties.setProperty("hibernate.dialect", hibernateDialect);
            hibernateProperties.setProperty("hibernate.show_sql", "true");
            hibernateProperties.setProperty("hibernate.hbm2ddl.auto", "create");
            hibernateProperties.setProperty("hibernate.id.new_generator_mappings", "false");
            lsfb.setHibernateProperties(hibernateProperties);
            lsfb.afterPropertiesSet();
            SessionFactory sessionFactory = lsfb.getObject();
            return sessionFactory;
        } catch (IOException e) {
            return null;
        }
    }
    
    @Autowired
    @Bean(name = "transactionManager")
    public HibernateTransactionManager transactionManager(SessionFactory sessionFactory) {
        return new HibernateTransactionManager(sessionFactory);
    }
}
