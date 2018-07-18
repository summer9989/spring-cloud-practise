package org.xplatform.springcloudpractise;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RefreshScope
public class ConfigClientController {

    @Value("${config1}")
    private String config;

    @GetMapping("/config")
    public String getConfig() {
        return this.config;
    }
}
