package com.kiran.digitalreceipts.config;

import com.kiran.digitalreceipts.service.RetrieveService;
import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.context.annotation.Configuration;

@Configuration
public class JerseyConfig extends ResourceConfig {

    public JerseyConfig() {
        register(RetrieveService.class);
    }
}