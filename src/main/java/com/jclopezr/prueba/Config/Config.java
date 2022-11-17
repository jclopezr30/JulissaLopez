package com.jclopezr.prueba.Config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
public class Config {
    @Value("${usr}")
    private String usr;

    @Value("${cls}")
    private String cls;

    @Bean
    public DataSource dataSource() {
        DataSourceBuilder dataSourceBuilder = DataSourceBuilder.create();
        dataSourceBuilder.url("jdbc:sqlserver://192.168.10.136;database=hoy;trustServerCertificate=true");
        dataSourceBuilder.username(usr);
        dataSourceBuilder.password(cls);
        return dataSourceBuilder.build();
    }

}
