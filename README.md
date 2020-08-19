## Connector  Introduction

Connector is a Java based backend extension for WaveMaker applications. Connectors are built as Java modules & exposes java based SDK to interact with the connector implementation.
Each connector is built for a specific purpose and can be integrated with one of the external services. Connectors are imported & used in the WaveMaker application. Each connector runs on its own container thereby providing the ability to have it’s own version of the third party dependencies.

## Features of Connectors

1. Connector is a java based extension which can be integrated with external services and reused in many Wavemaker applications.
1. Each connector can work as an SDK for an external system.
1. Connectors can be imported once in a WaveMaker application and used many times in the applications by creating multiple instances.
1. Connectors are executed in its own container in the WaveMaker application, as a result there are no dependency version conflict issues between connectors.

## About lambda Connector

## Introduction
With AWS Lambda, you can run code without provisioning or managing servers. You pay only for the compute time that you consume—there’s no charge when your code isn’t running. You can run code for virtually any type of application or backend service—all with zero administration. Just upload your code and Lambda takes care of everything required to run and scale your code with high availability. You can set up your code to automatically trigger from other AWS services or call it directly from any web or mobile app.

This connector exposes api to invoke lamda function hosted in AWS from WaveMaker application.

## Prerequisite

1. lambda function hosted in AWS
1. Java 1.8 or above
1. Maven 3.1.0 or above
1. Any java editor such as Eclipse, Intelij..etc
1. Internet connection


## Build
You can build this connector using following command
```
mvn clean install
```

## Deploy
You can import connector dist/lambda.zip artifact in WaveMaker studio application using file upload option.On after uploading into wavemaker, you can update your profile properties such as AWS key and Secret.


## Use Lambda connector in WaveMaker

```

@Autowired
private AWSLambdaConnector awsLambdaConnector;

InvokeRequest req = new InvokeRequest()
                .withFunctionName("s3countlambdafun")
                .withPayload(inputParam);
String result = awsLambdaConnector.InvokeFunction(req);

```









