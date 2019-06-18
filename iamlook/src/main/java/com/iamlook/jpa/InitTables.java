package com.iamlook.jpa;

import cn.com.larunda.utils.ConfigurationUtil;
import jdk.nashorn.internal.ir.annotations.Ignore;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.spi.MetadataImplementor;
import org.hibernate.cfg.Configuration;
import org.hibernate.tool.hbm2ddl.SchemaExport;
import org.hibernate.tool.schema.TargetType;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

import javax.persistence.EntityManager;
import java.time.Instant;
import java.util.EnumSet;

public class InitTables extends AbstractBaseTest {

    @Value("${spring.datasource.driverClassName}")
    String driver;
    @Value("${spring.datasource.druid.url}")
    String url;
    @Value("${spring.datasource.druid.username}")
    String username;
    @Value("${spring.datasource.druid.password}")
    String password;
    @Autowired
    private EntityManager entityManager;

    @Test
    public void createOnly() {
        SchemaExport schemaExport = new SchemaExport();
        schemaExport.setHaltOnError(true);
        schemaExport.createOnly(EnumSet.of(TargetType.DATABASE), getMetadata().buildMetadata());
    }

    @Test
    @Ignore
    public void generateDDL() {
        SchemaExport export = new SchemaExport();
        export.setHaltOnError(true);
        export.setFormat(true);
        export.setDelimiter(";");
        String filename = "/home/sddt/test" + Instant.now() + ".sql";
        export.setOutputFile(filename);
        EnumSet<TargetType> enumSet = EnumSet.of(TargetType.SCRIPT);

        MetadataImplementor metadataImplementor = (MetadataImplementor) getMetadata().buildMetadata();
        export.execute(enumSet, SchemaExport.Action.CREATE, metadataImplementor);
        System.out.println("文件已保存至:" + filename);
    }

    private MetadataSources getMetadata() {
        Configuration cfg = new Configuration();
        cfg.setProperty("hibernate.connection.driver_class", driver)
                .setProperty("hibernate.connection.url", url)
                .setProperty("hibernate.connection.username", username)
                .setProperty("hibernate.connection.password", password)
                .setProperty("hibernate.dialect", "org.hibernate.dialect.MySQL5Dialect");
        return ConfigurationUtil.init(entityManager, cfg);
    }

}
