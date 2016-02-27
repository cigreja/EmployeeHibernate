package com.cigreja.employeewebsite.config;

import com.cigreja.employeewebsite.business.Address;
import com.cigreja.employeewebsite.business.Employee;
import java.io.IOException;
import java.util.Properties;

import javax.inject.Inject;
import javax.sql.DataSource;
import org.apache.commons.dbcp.BasicDataSource;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.hibernate4.HibernateTransactionManager;
import org.springframework.orm.hibernate4.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
public class RepositoryTestConfig {

    @Bean
    public DataSource dataSource() {

        BasicDataSource dataSource = new BasicDataSource();
        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://localhost:3306/hibernateDB");
        dataSource.setUsername("root");
        dataSource.setPassword("");

        return dataSource;
    }

    @Bean
    @Autowired
    public SessionFactory sessionFactoryBean(DataSource dataSource) {
        try {
            LocalSessionFactoryBean lsfb = new LocalSessionFactoryBean();
            //lsfb.setDataSource(dataSource());
            lsfb.setDataSource(dataSource);
            //lsfb.setPackagesToScan("spittr.domain");
            lsfb.setAnnotatedClasses(new Class<?>[]{Employee.class, Address.class});
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

    @Bean
    @Autowired
    public HibernateTransactionManager transactionManager(SessionFactory sessionFactory) {
        return new HibernateTransactionManager(sessionFactory);
    }
}
