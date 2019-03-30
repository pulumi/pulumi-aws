const aws = require("@pulumi/aws");
const apiKey = new aws.apigateway.ApiKey("key", {});
const usagePlan = new aws.apigateway.UsagePlan("plan", {});
exports.usagePlanKey = new aws.apigateway.UsagePlanKey('MyUsagePlanKey',{
    keyId: apiKey.id,
    keyType: 'API_KEY',
    usagePlanId: usagePlan.id
});