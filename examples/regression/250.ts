const pulumi = require("@pulumi/pulumi");
const aws = require("@pulumi/aws");

const config = new pulumi.Config("aws");
const providerOpts = { provider: new aws.Provider("prov", { region: <aws.Region>config.require("envRegion") }) };

const apiKey = new aws.apigateway.ApiKey("key", {}, providerOpts);
const usagePlan = new aws.apigateway.UsagePlan("plan", {}, providerOpts);
exports.usagePlanKey = new aws.apigateway.UsagePlanKey('MyUsagePlanKey',{
    keyId: apiKey.id,
    keyType: 'API_KEY',
    usagePlanId: usagePlan.id
}, providerOpts);