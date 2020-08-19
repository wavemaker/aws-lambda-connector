package com.wavemaker.connector.lambda;

import java.nio.ByteBuffer;
import java.nio.charset.StandardCharsets;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import com.amazonaws.services.lambda.model.InvokeRequest;
import com.amazonaws.services.lambda.model.InvokeResult;
import com.wavemaker.connector.lambda.AWSLambdaConnector;
import com.wavemaker.connector.properties.AWSLambdaPropertiesService;


@Service
@Primary
public class AWSLambdaConnectorImpl extends AbstractAWSLambdaConnector{

    private static final Logger logger = LoggerFactory.getLogger(AWSLambdaConnectorImpl.class);

    @Autowired
    private AWSLambdaPropertiesService lambdaPropertiesService;


    public AWSLambdaConnectorImpl(AWSLambdaPropertiesService lambdaPropertiesService) {
        super(lambdaPropertiesService);
    }

    @Override
    public String InvokeFunction(InvokeRequest invokeRequest) {
        String output = null;
        logger.info("Invoking lambda function ", invokeRequest.getFunctionName());
        InvokeResult result = getAWSLambdaClient().invoke(invokeRequest);
        ByteBuffer byteBuf = result.getPayload();
        if (byteBuf != null) {
            output = StandardCharsets.UTF_8.decode(byteBuf).toString();
        }

        logger.info("Lambda function result", output);
        return output;
    }
}