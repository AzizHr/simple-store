package org.aziz.springbootrestapi.configs;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GlobalConfig {

    public ModelMapper modelMapper() {
        return new ModelMapper();
    }

}
