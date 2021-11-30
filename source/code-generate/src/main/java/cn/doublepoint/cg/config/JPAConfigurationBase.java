package cn.doublepoint.cg.config;

import java.util.Map;

import javax.persistence.EntityManager;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateProperties;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateSettings;
import org.springframework.boot.autoconfigure.orm.jpa.JpaProperties;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * 
 * @author liulei
 *
 */
@Configuration
@EnableTransactionManagement

public class JPAConfigurationBase {

	@Autowired
	private DataSource masterDataSource;

	@Bean(name = "entityManager")
	@Primary
	public EntityManager entityManager(EntityManagerFactoryBuilder builder) {
		return entityManagerFactoryPrimary(builder).getObject().createEntityManager();
	}

	@Bean(name = "entityManagerFactory")
	@Primary
	public LocalContainerEntityManagerFactoryBean entityManagerFactoryPrimary(
			EntityManagerFactoryBuilder builder) {
		return builder
				.dataSource(masterDataSource)
				.properties(getVendorProperties(masterDataSource))
				.packages("cn.doublepoint")
				.build();
	}

	@Autowired
	private JpaProperties jpaProperties;

	@Autowired
	private HibernateProperties hibernateProperties;

	private Map<String, Object> getVendorProperties(DataSource dataSource) {
		return hibernateProperties.determineHibernateProperties(jpaProperties.getProperties(), new HibernateSettings());
//		return jpaProperties.getHibernateProperties(dataSource);
	}

	@Bean(name = "transactionManager")
	@Primary
	public PlatformTransactionManager transactionManager(EntityManagerFactoryBuilder builder)
			throws Throwable {
		return new JpaTransactionManager(entityManagerFactoryPrimary(builder).getObject());
	}
}
