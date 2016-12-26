package com.gmail.volodymyrdotsenko.routing.frontend.config;

import liquibase.integration.spring.SpringLiquibase;
import liquibase.servicelocator.ServiceLocator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.boot.autoconfigure.liquibase.LiquibaseProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.liquibase.CommonsLoggingLiquibaseLogger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.DefaultResourceLoader;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.util.Assert;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;

/**
 * Created by dotsenko-vv on 26.02.16.
 */
@Configuration
//@ConditionalOnClass(SpringLiquibase.class)
//@ConditionalOnBean(DataSource.class)
//@ConditionalOnMissingBean(SpringLiquibase.class)
@EnableConfigurationProperties(LiquibaseProperties.class)
@ConditionalOnProperty(prefix = "liquibase", name = "enabled", matchIfMissing = true)
//@AutoConfigureAfter({DataSourceAutoConfiguration.class,
//        HibernateJpaAutoConfiguration.class})
public class LiquibaseConfiguration {
    @Autowired
    private LiquibaseProperties properties = new LiquibaseProperties();

    @Autowired
    private ResourceLoader resourceLoader = new DefaultResourceLoader();

    @Autowired
    private DataSource dataSource;

    @PostConstruct
    public void checkChangelogExists() {
        if (this.properties.isCheckChangeLogLocation()) {
            Resource resource = this.resourceLoader
                    .getResource(this.properties.getChangeLog());
            Assert.state(resource.exists(),
                    "Cannot find changelog location: " + resource
                            + " (please add changelog or check your Liquibase "
                            + "configuration)");
        }
        ServiceLocator serviceLocator = ServiceLocator.getInstance();
        serviceLocator.addPackageToScan(
                CommonsLoggingLiquibaseLogger.class.getPackage().getName());
    }

    @Bean
    public SpringLiquibase liquibase() {
        SpringLiquibase liquibase = new SpringLiquibase();
        liquibase.setChangeLog(this.properties.getChangeLog());
        liquibase.setContexts(this.properties.getContexts());
        liquibase.setDataSource(getDataSource());
        liquibase.setDefaultSchema(this.properties.getDefaultSchema());
        liquibase.setDropFirst(this.properties.isDropFirst());
        liquibase.setShouldRun(this.properties.isEnabled());
        liquibase.setLabels(this.properties.getLabels());
        liquibase.setChangeLogParameters(this.properties.getParameters());
        return liquibase;
    }

    private DataSource getDataSource() {
        if (this.properties.getUrl() == null) {
            return this.dataSource;
        }
        return DataSourceBuilder.create().url(this.properties.getUrl())
                .username(this.properties.getUser())
                .password(this.properties.getPassword()).build();
    }
}
