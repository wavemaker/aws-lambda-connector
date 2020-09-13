package com.wavemaker.connector.lambda;

import com.amazonaws.services.lambda.model.InvokeRequest;
import com.wavemaker.runtime.connector.annotation.WMConnector;


@WMConnector(name = "aws-lambda-connector",
        description = "This connector provides apis to invoke AWS lambda function")
public interface AWSLambdaConnector {

    public String InvokeFunction(InvokeRequest invokeRequest);

}