package org.xplatform.springcloudpractise;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class ConfigClientRefreshApplication {

    public static void main(String[] args) {
        SpringApplication.run(ConfigClientRefreshApplication.class, args);
    }

    //    @Configuration
    //    static class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    //
    //        @Override
    //        protected void configure(HttpSecurity http) throws Exception {
    //            http.authorizeRequests().requestMatchers(EndpointRequest.to("health", "info")).permitAll();
    //        }
    //    }
}
