package com.cricket.scoretrackingservice.config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
@Configuration
public class ScoreTrackerConfig {
	@Bean
	public ModelMapper modelMapper() {
        return new ModelMapper();
    }
}
