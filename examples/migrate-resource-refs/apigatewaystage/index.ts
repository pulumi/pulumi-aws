import * as aws from "@pulumi/aws";
import * as pulumi from "@pulumi/pulumi";

// Create the API Gateway REST API
const api = new aws.apigateway.RestApi("test-api", {
    description: "Test API Gateway",
});

const resource = new aws.apigateway.Resource("test-resource", {
    restApi: api,
    parentId: api.rootResourceId,
    pathPart: "test",
});

const method = new aws.apigateway.Method("test-method", {
    restApi: api,
    resourceId: resource.id,
    httpMethod: "GET",
    authorization: "NONE",
});

const integration = new aws.apigateway.Integration("test-integration", {
    restApi: api,
    resourceId: resource.id,
    httpMethod: method.httpMethod,
    type: "MOCK",
    requestTemplates: {
        "application/json": '{"statusCode": 200}',
    },
});

const methodResponse = new aws.apigateway.MethodResponse("test-method-response", {
    restApi: api,
    resourceId: resource.id,
    httpMethod: method.httpMethod,
    statusCode: "200",
    responseModels: {
        "application/json": "Empty",
    },
});

const integrationResponse = new aws.apigateway.IntegrationResponse("test-integration-response", {
    restApi: api,
    resourceId: resource.id,
    httpMethod: method.httpMethod,
    statusCode: methodResponse.statusCode,
    responseTemplates: {
        "application/json": '{"message": "Hello from API Gateway!"}',
    },
});

const deployment = new aws.apigateway.Deployment("test-deployment", {
    restApi: api,
    triggers: {
        redeployment: pulumi.all([resource.id, method.id, integration.id])
            .apply(([resourceId, methodId, integrationId]) =>
                JSON.stringify([resourceId, methodId, integrationId])),
    },
});

const stage = new aws.apigateway.Stage("test-stage", {
    deployment: deployment,
    restApi: api,
    stageName: "test",
});

export const apiUrl = pulumi.interpolate`${api.executionArn}${stage.stageName}/test`;