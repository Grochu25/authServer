package com.grochu.authserver;

import com.zaxxer.hikari.HikariDataSource;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;

@Configuration(proxyBeanMethods = false)
public class DataSourceConfig
{
    @Bean
    @Primary
    @ConfigurationProperties("app.datasource.credentials")
    public DataSourceProperties credentialDataSourceProperties(){
        return new DataSourceProperties();
    }

    @Bean
    @Primary
    public DataSource credentialDataSource(DataSourceProperties credentialDataSourceProperties){
        return DataSourceBuilder.create() //hikari needs this 3 properties
                .url(credentialDataSourceProperties.getUrl())
                .username(credentialDataSourceProperties.getUsername())
                .password(credentialDataSourceProperties.getPassword())
                .build();
    }

    @Bean
    public JdbcTemplate credentialJdbcTemplate(@Qualifier("credentialDataSource") DataSource credentialDataSource){
        return new JdbcTemplate(credentialDataSource);
    }

    @Bean
    @ConfigurationProperties("app.datasource.details")
    public DataSourceProperties registerUserDetailsDataSource() {
        return new DataSourceProperties();
    }

    @Bean
    public DataSource userDetailsDataSource(@Qualifier("registerUserDetailsDataSource") DataSourceProperties registerUserDetailsDataSourceProperties) {
        return DataSourceBuilder.create()
                .url(registerUserDetailsDataSourceProperties.getUrl())
                .username(registerUserDetailsDataSourceProperties.getUsername())
                .password(registerUserDetailsDataSourceProperties.getPassword())
                .build();
    }

    @Bean
    public JdbcTemplate userDetailsJdbcTemplate(@Qualifier("userDetailsDataSource") DataSource userDetailsDataSource){
        return new JdbcTemplate(userDetailsDataSource);
    }
}
