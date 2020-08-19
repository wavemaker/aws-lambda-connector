package com.wavemaker.connector.properties;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.amazonaws.regions.Regions;

/**
 * @author <a href="mailto:sunil.pulugula@wavemaker.com">Sunil Kumar</a>
 * @since 10/6/20
 */

@Service
public class AWSLambdaPropertiesService {

    @Value("${aws.clientRegion}")
    private Regions clientRegion;

    @Value("${aws.accessKey}")
    private String accessKey;

    @Value("${aws.accessSecret}")
    private String accessSecret;

    public Regions getClientRegion() {
        return clientRegion;
    }

    public AWSLambdaPropertiesService setClientRegion(Regions clientRegion) {
        this.clientRegion = clientRegion;
        return this;
    }

    public String getAccessKey() {
        return accessKey;
    }

    public AWSLambdaPropertiesService setAccessKey(String accessKey) {
        this.accessKey = accessKey;
        return this;
    }

    public String getAccessSecret() {
        return accessSecret;
    }

    public AWSLambdaPropertiesService setAccessSecret(String accessSecret) {
        this.accessSecret = accessSecret;
        return this;
    }
}
