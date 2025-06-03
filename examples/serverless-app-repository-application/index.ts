import * as pulumi from "@pulumi/pulumi";
import * as aws from "@pulumi/aws";

const awsConfig = new pulumi.Config("aws");
const providerOpts = { provider: new aws.Provider("prov", { region: <aws.Region>awsConfig.require("envRegion") }) };
const config = new pulumi.Config();

const athenaConnectorApp = aws.serverlessrepository.getApplication({
    applicationId: "arn:aws:serverlessrepo:us-east-1:292517598671:applications/AthenaCloudwatchConnector",
}, providerOpts);

const spillBucket = new aws.s3.Bucket("spill-bucket", {
    bucketPrefix: "spill-bucket",
    forceDestroy: true,
}, providerOpts);

const functionName = config.require("functionName").toLowerCase();
const athenaConnector = new aws.serverlessrepository.CloudFormationStack("athena-connector", {
    applicationId: athenaConnectorApp.then(app => app.applicationId),
    semanticVersion: athenaConnectorApp.then(app => app.semanticVersion),
    capabilities: athenaConnectorApp.then(app => app.requiredCapabilities),

    parameters: {
        AthenaCatalogName: functionName,
        SpillBucket: spillBucket.bucket,
    },
}, providerOpts);

const region = aws.getRegionOutput({}, providerOpts);
const identity = aws.getCallerIdentityOutput({}, providerOpts);
const partition = aws.getPartitionOutput({}, providerOpts);

const catalog = new aws.athena.DataCatalog("cloudwatch-catalog", {
    name: "cloudwatch-catalog",
    description: "Example CloudWatch data catalog",
    type: "LAMBDA",
    parameters: {
        "function": pulumi.interpolate`arn:${partition.id}:lambda:${region.name}:${identity.accountId}:function:${functionName}`,
    },
}, { ...providerOpts, dependsOn: athenaConnector });
