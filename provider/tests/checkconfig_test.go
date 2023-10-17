package test

import (
	"testing"
)

func TestSlowCheckConfig(t *testing.T) {

	request := ` [{
  "method": "/pulumirpc.ResourceProvider/CheckConfig",
  "request": {
    "urn": "urn:pulumi:dev::aws-2880::pulumi:providers:aws::default_6_5_0",
    "olds": {},
    "news": {
      "accessKey": "test",
      "endpoints": "[{\"accessanalyzer\":\"http://localhost:4566\"},{\"account\":\"http://localhost:4566\"},{\"acm\":\"http://localhost:4566\"},{\"acmpca\":\"http://localhost:4566\"},{\"amg\":\"http://localhost:4566\"},{\"amp\":\"http://localhost:4566\"},{\"amplify\":\"http://localhost:4566\"},{\"apigateway\":\"http://localhost:4566\"},{\"apigatewayv2\":\"http://localhost:4566\"},{\"appautoscaling\":\"http://localhost:4566\"},{\"appconfig\":\"http://localhost:4566\"},{\"appflow\":\"http://localhost:4566\"}]",
      "region": "us-east-1",
      "s3UsePathStyle": "true",
      "secretKey": "test",
      "skipCredentialsValidation": "true",
      "skipRequestingAccountId": "true",
      "version": "6.5.0"
    }
  },
  "response": {
    "inputs": {
      "accessKey": "test",
      "endpoints": "[{\"accessanalyzer\":\"http://localhost:4566\"},{\"account\":\"http://localhost:4566\"},{\"acm\":\"http://localhost:4566\"},{\"acmpca\":\"http://localhost:4566\"},{\"amg\":\"http://localhost:4566\"},{\"amp\":\"http://localhost:4566\"},{\"amplify\":\"http://localhost:4566\"},{\"apigateway\":\"http://localhost:4566\"},{\"apigatewayv2\":\"http://localhost:4566\"},{\"appautoscaling\":\"http://localhost:4566\"},{\"appconfig\":\"http://localhost:4566\"},{\"appflow\":\"http://localhost:4566\"}]",
      "region": "us-east-1",
      "s3UsePathStyle": "true",
      "secretKey": "test",
      "skipCredentialsValidation": "true",
      "skipMetadataApiCheck": "true",
      "skipRegionValidation": "true",
      "skipRequestingAccountId": "true",
      "version": "6.5.0"
    }
  }
}]

	`

	replaySequence(t, request)
}
