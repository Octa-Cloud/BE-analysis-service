package com.project.analysis.global.properties;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.boot.context.properties.ConfigurationProperties;

@Getter
@AllArgsConstructor
@ConfigurationProperties("jwt-properties")
public class JwtProperties {

    private final String key;
    private final String accessTokenSubject;
    private final String tokenHeader;
    private final String bearer;
    private final String id;

}
