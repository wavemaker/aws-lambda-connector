package com.wavemaker.connector.lambda;

import com.amazonaws.SdkClientException;
import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.services.lambda.AWSLambda;
import com.amazonaws.services.lambda.AWSLambdaClientBuilder;
import com.wavemaker.connector.properties.AWSLambdaPropertiesService;

/**
 * @author <a href="mailto:sunil.pulugula@wavemaker.com">Sunil Kumar</a>
 * @since 18/2/20
 */
public abstract class AbstractAWSLambdaConnector implements AWSLambdaConnector {

    private AWSLambda awsLambda;

    private AWSLambdaPropertiesService lambdaPropertiesService;

    public AbstractAWSLambdaConnector(AWSLambdaPropertiesService lambdaPropertiesService) {
        this.lambdaPropertiesService = lambdaPropertiesService;
    }

    public AWSLambda getAWSLambdaClient() throws SdkClientException {
        if (awsLambda == null) {

            try {
                BasicAWSCredentials credentials = new
                        BasicAWSCredentials(getLambdaPropertiesService().getAccessKey(), getLambdaPropertiesService().getAccessSecret());
                awsLambda = AWSLambdaClientBuilder.standard()
                        .withCredentials(new AWSStaticCredentialsProvider(credentials))
                        .withRegion(getLambdaPropertiesService().getClientRegion()).build();
            } catch (RuntimeException e) {
                throw new RuntimeException("Failed to build aws lambda client builder", e);
            }

        }
        return awsLambda;
    }

    public AWSLambdaPropertiesService getLambdaPropertiesService() {
        return lambdaPropertiesService;
    }

}
