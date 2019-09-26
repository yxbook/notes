package com.iamlook;

import com.zaxxer.hikari.HikariDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

/**
 * 描述.
 *
 * @author yx
 * @version 1.0
 * @since 19-9-25下午3:14
 */
@Component
public class Runner implements CommandLineRunner {


    @Autowired
    private HikariDataSource dataSource;

    @Override
    public void run(String... args) throws Exception {

       // System.out.println("type:" + dataSource.get);
        System.out.println("getDriverClassName:" + dataSource.getDriverClassName());
        System.out.println("getPoolName:" + dataSource.getPoolName());
        System.out.println("getMaxLifetime:" + dataSource.getMaxLifetime());
        System.out.println("getConnectionTimeout:" + dataSource.getConnectionTimeout());
        System.out.println("getValidationTimeout:" + dataSource.getValidationTimeout());
        System.out.println("getIdleTimeout:" + dataSource.getIdleTimeout());

    }
}