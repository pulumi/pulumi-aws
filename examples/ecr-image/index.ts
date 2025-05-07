import * as pulumi from "@pulumi/pulumi";
import * as aws from "@pulumi/aws";
import * as docker from "@pulumi/docker-build";

const config = new pulumi.Config("aws");
const providerOpts = { provider: new aws.Provider("prov", { region: <aws.Region>config.require("envRegion") }) };

const repository = new aws.ecr.Repository("myrepository", {
    forceDelete: true,
}, providerOpts);

// Get registry info (credentials and endpoint) so we can publish to it.
const credentials = aws.ecr.getAuthorizationTokenOutput({ registryId: repository.registryId }, providerOpts);

const image = new docker.Image("myimage", {
    push: true,
    tags: [pulumi.interpolate`${repository.repositoryUrl}:latest`],
    context: {
        location: "./app",
    },
    registries: [{
        address: credentials.proxyEndpoint,
        username: credentials.userName,
        password: credentials.password,
    }],
});

export const digest = image.digest;
