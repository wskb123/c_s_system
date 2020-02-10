package com.kb.c_s_system.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@MapperScan("com.kb.c_s_system.dao")
public class MybatisConfig {
}
