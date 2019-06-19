import * as aws from "@pulumi/aws";
import * as pulumi from "@pulumi/pulumi";

const awsConfig = new pulumi.Config("aws");
const providerOpts = { provider: new aws.Provider("prov", { region: awsConfig.require("envRegion") }) };

const config = new pulumi.Config();
const unprivilegedUsername = config.require("unprivilegedUsername");

const unprivilegedUser = new aws.iam.User("unprivileged-user", {
    name: unprivilegedUsername,
}, providerOpts);

const unprivilegedUserCreds = new aws.iam.AccessKey("unprivileged-user-key", {
    user: unprivilegedUser.name,
}, providerOpts);

const allowS3ManagementRole = new aws.iam.Role("allow-s3-management", {
    description: "Allow management of S3 buckets",
    assumeRolePolicy: unprivilegedUser.arn.apply(arn => {
        return aws.iam.assumeRolePolicyForPrincipal({AWS: arn})
    }),
}, providerOpts);

new aws.iam.RolePolicy("allow-s3-management-policy", {
    role: allowS3ManagementRole,
    policy: {
        Version: "2012-10-17",
        Statement: [{
            Sid: "AllowS3Management",
            Effect: "Allow",
            Resource: "*",
            Action: "s3:*",
        }]
    }
}, { parent: allowS3ManagementRole });

export const roleArn = allowS3ManagementRole.arn;
export const accessKeyId = unprivilegedUserCreds.id;
export const secretAccessKey = unprivilegedUserCreds.secret;
