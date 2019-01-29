package com.example.demo.stmpSend;

import java.util.Properties;

public class PropertiesGetUtils {
    private Properties prop;

    public PropertiesGetUtils(Properties prop) {
        this.prop = prop;
    }

    public String getTypeFromPropStr(String key){
        return prop.getProperty(key);
    }

    public Long getTypeFromPropLong(String key){
        return Long.parseLong(prop.getProperty(key));
    }
}
