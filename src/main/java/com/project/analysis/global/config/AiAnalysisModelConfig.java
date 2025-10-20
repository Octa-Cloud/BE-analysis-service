package com.project.analysis.global.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.ClientHttpRequestFactory;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.web.client.RestClient;

@Configuration
public class AiAnalysisModelConfig {

    @Value("${ai-analysis.model.base-url}")
    private String baseUrl;

    @Value("${ai-analysis.model.timeout}")
    private int timeout;

    @Bean
    public RestClient aiAnalysisModelRestClient() {
        return RestClient.builder()
                .baseUrl(baseUrl)
                .requestFactory(clientHttpRequestFactory())
                .build();
    }

    @Bean
    public ClientHttpRequestFactory clientHttpRequestFactory() {
        SimpleClientHttpRequestFactory factory = new SimpleClientHttpRequestFactory();
        factory.setConnectTimeout(timeout);
        factory.setReadTimeout(timeout);
        return factory;
    }
}
