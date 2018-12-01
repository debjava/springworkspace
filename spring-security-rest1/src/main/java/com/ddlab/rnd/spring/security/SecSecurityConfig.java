package com.ddlab.rnd.spring.security;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

@Configuration
@ImportResource({ "classpath:webSecurityConfig.xml" })
@ComponentScan("com.ddlab.rnd.spring")
public class SecSecurityConfig {

    public SecSecurityConfig() {
        super();
    }

}
