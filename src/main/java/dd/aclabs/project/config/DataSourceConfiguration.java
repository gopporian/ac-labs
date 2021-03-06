package dd.aclabs.project.config;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.orm.hibernate4.HibernateTransactionManager;
import org.springframework.orm.hibernate4.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.mysql.jdbc.jdbc2.optional.MysqlConnectionPoolDataSource;

/**
 * Created by lcondescu on 03.06.2015.
 */
@Configuration
@EnableTransactionManagement
@EnableAspectJAutoProxy(proxyTargetClass = true) 
public class DataSourceConfiguration {

    @Bean
    public LocalSessionFactoryBean sessionFactory() {
        final LocalSessionFactoryBean localSessionFactoryBean = new LocalSessionFactoryBean();
        localSessionFactoryBean.setDataSource(this.dataSource());
        localSessionFactoryBean.setPackagesToScan("dd.aclabs.project");
        localSessionFactoryBean.getHibernateProperties().setProperty("hibernate.hbm2ddl.auto","update");
        return localSessionFactoryBean;
    }

    @Bean
    public DataSource dataSource() {
        MysqlConnectionPoolDataSource dataSource = new MysqlConnectionPoolDataSource();
        dataSource.setPassword("root");
        dataSource.setUser("root");
        dataSource.setUrl("jdbc:mysql://localhost:3306/realEstate");

        return dataSource;
    }

    @Bean
    public HibernateTransactionManager transactionManager() {
        return new HibernateTransactionManager(this.sessionFactory().getObject());
    }
}
