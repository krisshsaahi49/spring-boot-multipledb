package com.multiple_db.multiple_db.dbconfig;
import jakarta.persistence.EntityManagerFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import javax.sql.DataSource;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(
        basePackages = "com.multiple_db.multiple_db.repository.third",
        entityManagerFactoryRef = "thirdEntityManager",
        transactionManagerRef = "thirdTransactionManager"
)
public class ThirdDatabaseConfig {

    @Bean(name = "thirdDataSource")
    @ConfigurationProperties(prefix = "spring.datasource.third")
    public DataSource dataSource(){
        return DataSourceBuilder.create().build();
    }

    @Bean(name = "thirdEntityManager")
    public LocalContainerEntityManagerFactoryBean entityManagerFactory(
            EntityManagerFactoryBuilder builder,
            @Qualifier("thirdDataSource") DataSource dataSource){
        return builder
                .dataSource(dataSource)
                .packages("com.multiple_db.multiple_db.model.third")
                .persistenceUnit("third")
                .build();
    }

    @Bean(name = "thirdTransactionManager")
    public PlatformTransactionManager platformTransactionManager(
            @Qualifier("thirdEntityManager") EntityManagerFactory entityManagerFactory){
        return new JpaTransactionManager(entityManagerFactory);
    }
}
