package org.hkex.owbookmanage.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@MapperScan("org.hkex.owbookmanage.dao")
public class WebConfiguration implements WebMvcConfigurer {


}
