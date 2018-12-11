package com.asiainfo.qm;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.context.annotation.ImportResource;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

//验证：http://localhost:8080/swagger-ui.html
//http://localhost:8080/hystrix//输入：http://localhost:8080/hystrix.stream
@EnableHystrix
@EnableHystrixDashboard
@ImportResource("classpath:config/transaction.xml")
@SpringBootApplication
@EnableSwagger2
@MapperScan("com.asiainfo.qm.**.dao.**")//指定要扫描的Mapper类的包的路径
public class Application {
          
   
    public static void main(String[] args) {
        SpringApplication app = new SpringApplication(Application.class);
        app.setBannerMode(Banner.Mode.OFF);
        app.setAddCommandLineProperties(false);//不允许命令行传递参数，所有参数通过配置文件设置
        app.run(args);
    }
 
}