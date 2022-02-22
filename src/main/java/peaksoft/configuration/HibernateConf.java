package peaksoft.configuration;

import org.apache.tomcat.dbcp.dbcp2.BasicDataSource;
import org.hibernate.cfg.Environment;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import java.util.Properties;

/**
 * project : SpringMVC-CRUD
 */
@Configuration
@EnableTransactionManagement
public class HibernateConf {

    //define LocalSessionFactoryBean
    @Bean
    public LocalSessionFactoryBean factoryBean() {
        LocalSessionFactoryBean factoryBean = new LocalSessionFactoryBean();
        factoryBean.setDataSource(dataSource());
        factoryBean.setPackagesToScan("peaksoft");
        factoryBean.setHibernateProperties(hibernateProperties());
        return factoryBean;
    }

    //define DataSource
    @Bean
    public DataSource dataSource() {
        BasicDataSource dataSource = new BasicDataSource();
        dataSource.setDriverClassName("org.postgresql.Driver");
        dataSource.setUrl("jdbc:postgresql://localhost:5432/postgres");
        dataSource.setUsername("postgres");
        dataSource.setPassword("2303");
        return dataSource;
    }

    //define HibernateTransactionManager
    @Bean
    public PlatformTransactionManager transactionManager() {
        HibernateTransactionManager transactionManager = new HibernateTransactionManager();
        transactionManager.setSessionFactory(factoryBean().getObject());
        return transactionManager;
    }

    //define properties
    private Properties hibernateProperties() {
        Properties properties = new Properties();
        properties.setProperty(Environment.HBM2DDL_AUTO , "create");
        properties.setProperty(Environment.DIALECT, "org.hibernate.dialect.PostgreSQL10Dialect");
        return properties;
    }
}
