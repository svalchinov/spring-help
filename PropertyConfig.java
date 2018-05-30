package com.company.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.core.env.MapPropertySource;

import javax.annotation.PostConstruct;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

@Configuration
public class PropertySource {

    private final ConfigurableEnvironment env;

    @Autowired
    public PropertySource(ConfigurableEnvironment env) {
        this.env = env;
    }

    @PostConstruct
    public void setup() {

        Map<String, Object> propertyResolvers = new HashMap<>();
        propertyResolvers.put("placeholder.name", Calendar.getInstance().get(Calendar.YEAR));

        env.getPropertySources().addLast(new MapPropertySource("propertyResolvers", propertyResolvers));
    }
}
