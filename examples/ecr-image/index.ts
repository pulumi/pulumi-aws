import * as pulumi from "@pulumi/pulumi";
import * as aws from "@pulumi/aws";
import * as docker from "@pulumi/docker-build";

const config = new pulumi.Config("aws");
const providerOpts = { provider: new aws.Provider("prov", { region: <aws.Region>config.require("envRegion") }) };

const repository = new aws.ecr.Repository("myrepository", {
    forceDelete: true,
}, providerOpts);

// Get registry info (credentials and endpoint) so we can publish to it.
const credentials = aws.ecr.getCredentialsOutput({ registryId: repository.registryId }, providerOpts);
const decodedCredentials = credentials.authorizationToken.apply(tok => Buffer.from(tok, "base64").toString());
const registryInfo = decodedCredentials.apply(creds => {
    const [username, password] = creds.split(":");
    if (!password || !username) {
        throw new Error("Invalid credentials");
    }
    return {
        address: credentials.proxyEndpoint,
        username: username,
        password: password,
    };
});

const image = new docker.Image("myimage", {
    push: true,
    tags: [pulumi.interpolate`${repository.repositoryUrl}:latest`],
    context: {
        location: "./app",
    },
    registries: [registryInfo],
});

export const digest = image.digest;
