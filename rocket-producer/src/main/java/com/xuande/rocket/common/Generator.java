package com.xuande.rocket.common;

import com.baomidou.mybatisplus.generator.FastAutoGenerator;
import com.baomidou.mybatisplus.generator.config.*;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;
import java.util.Collections;

/**
 * @author : xuande
 * @date : 2022-05-03 13:06
 **/
public class Generator {


    public static void main(String[] args) {
        FastAutoGenerator.create("jdbc:mysql://localhost:3306/huahua?useUnicode=true&useSSL=false&characterEncoding=utf8&serverTimezone=UTC", "root", "123456")
                .globalConfig(builder -> {
                    builder.author("xuande") // 设置作者
                            //.enableSwagger() // 开启 swagger 模式
                            .fileOverride() // 覆盖已生成文件
                            .outputDir("E:\\ideaProject\\RocketMQ-DEMO\\rocket-producer\\src\\main\\java");
                })
                .packageConfig(builder -> {
                    builder.parent("com.xuande.rocket") // 设置父包名
                           // .moduleName("system") // 设置父包模块名
                            .pathInfo(Collections.singletonMap(OutputFile.xml, "E:\\ideaProject\\RocketMQ-DEMO\\rocket-producer\\src\\main\\resources\\mapper")); // 设置mapperXml生成路径
                })
                .strategyConfig(builder -> {
                    builder.addInclude("message_log") // 设置需要生成的表名
                            .addTablePrefix("t_", "c_"); // 设置过滤表前缀
                })
                .templateEngine(new FreemarkerTemplateEngine()) // 使用Freemarker引擎模板，默认的是Velocity引擎模板
                .execute();
    }
}
