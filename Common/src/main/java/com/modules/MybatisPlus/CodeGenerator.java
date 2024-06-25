package com.modules.MybatisPlus;

import com.baomidou.mybatisplus.generator.FastAutoGenerator;
import com.baomidou.mybatisplus.generator.config.OutputFile;
import com.baomidou.mybatisplus.generator.config.rules.DbColumnType;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;

import java.sql.Types;
import java.util.Collections;

public class CodeGenerator {

    public static void main(String[] args) {
        FastAutoGenerator.create("url", "username", "password")
                // 自定义类型转换
//                .dataSourceConfig(builder -> {
//                    builder.typeConvertHandler((globalConfig, typeRegistry, metaInfo) -> {
//
//                        if (Types.SMALLINT == metaInfo.getJdbcType()) {
//                            return DbColumnType.INTEGER;
//                        }
//                        return typeRegistry.getColumnType(metaInfo);
//                    });
//                })
                .globalConfig(builder -> builder
                        .author("Baomidou")
                        .enableSwagger()
                        .outputDir("E://CodeGenerator")
                        .commentDate("yyyy-MM-dd")
                )
                .packageConfig(builder -> builder
                        .parent("com.baomidou.mybatisplus")
                        .entity("entity")
                        .mapper("mapper")
                        .service("service")
                        .serviceImpl("service.impl")
                        .xml("mapper.xml")
                        .pathInfo(Collections.singletonMap(OutputFile.xml, "E://CodeGenerator"))
                )
                .strategyConfig(builder -> builder
                        .entityBuilder()
                        .enableLombok()
                )
                .templateEngine(new FreemarkerTemplateEngine())
                .execute();
    }
}
