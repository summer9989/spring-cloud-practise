package org.xplatform.springcloudpractise;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ConfigClientController {

    @Value("${config1}")
    private String config;

    @GetMapping("/config")
    public String getConfig() {
        return this.config;
    }
}
