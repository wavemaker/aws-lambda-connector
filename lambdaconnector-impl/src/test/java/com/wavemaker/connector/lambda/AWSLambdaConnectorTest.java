package com.wavemaker.connector.lambda;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.amazonaws.services.lambda.model.InvokeRequest;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = AWSLambdaConnectorTestConfiguration.class)
public class AWSLambdaConnectorTest {

    @Autowired
    private AWSLambdaConnector awsLambdaConnector;

    @Test
    public void InvokeFunction() {
        String inputParam = "30";
        InvokeRequest req = new InvokeRequest()
                .withFunctionName("s3countlambdafun")
                .withPayload(inputParam);

        String result = awsLambdaConnector.InvokeFunction(req);

        Assert.assertNotNull(result);

    }
}