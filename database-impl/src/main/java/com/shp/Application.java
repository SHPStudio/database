package com.shp;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;

/**
 * Created by Shape on 2018/4/2.
 */
@SpringBootApplication
@MapperScan("com.shp.mapper")
@ImportResource(locations = {"classpath:spring/*.xml"})
public class Application  implements CommandLineRunner{
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Override
    public void run(String... strings) throws Exception {
        Thread.currentThread().join();
    }
}
//@SpringBootApplication
//@MapperScan("com.shp.mapper")
//public class Application{
//    public static void main(String[] args) {
//        SpringApplication.run(Application.class, args);
//    }
//}
