// *** WARNING: this file was generated by pulumi-language-nodejs. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

import * as pulumi from "@pulumi/pulumi";
import * as utilities from "../utilities";

// Export members:
export { GetRandomPasswordArgs, GetRandomPasswordResult, GetRandomPasswordOutputArgs } from "./getRandomPassword";
export const getRandomPassword: typeof import("./getRandomPassword").getRandomPassword = null as any;
export const getRandomPasswordOutput: typeof import("./getRandomPassword").getRandomPasswordOutput = null as any;
utilities.lazyLoad(exports, ["getRandomPassword","getRandomPasswordOutput"], () => require("./getRandomPassword"));

export { GetSecretArgs, GetSecretResult, GetSecretOutputArgs } from "./getSecret";
export const getSecret: typeof import("./getSecret").getSecret = null as any;
export const getSecretOutput: typeof import("./getSecret").getSecretOutput = null as any;
utilities.lazyLoad(exports, ["getSecret","getSecretOutput"], () => require("./getSecret"));

export { GetSecretRotationArgs, GetSecretRotationResult, GetSecretRotationOutputArgs } from "./getSecretRotation";
export const getSecretRotation: typeof import("./getSecretRotation").getSecretRotation = null as any;
export const getSecretRotationOutput: typeof import("./getSecretRotation").getSecretRotationOutput = null as any;
utilities.lazyLoad(exports, ["getSecretRotation","getSecretRotationOutput"], () => require("./getSecretRotation"));

export { GetSecretVersionArgs, GetSecretVersionResult, GetSecretVersionOutputArgs } from "./getSecretVersion";
export const getSecretVersion: typeof import("./getSecretVersion").getSecretVersion = null as any;
export const getSecretVersionOutput: typeof import("./getSecretVersion").getSecretVersionOutput = null as any;
utilities.lazyLoad(exports, ["getSecretVersion","getSecretVersionOutput"], () => require("./getSecretVersion"));

export { GetSecretVersionsArgs, GetSecretVersionsResult, GetSecretVersionsOutputArgs } from "./getSecretVersions";
export const getSecretVersions: typeof import("./getSecretVersions").getSecretVersions = null as any;
export const getSecretVersionsOutput: typeof import("./getSecretVersions").getSecretVersionsOutput = null as any;
utilities.lazyLoad(exports, ["getSecretVersions","getSecretVersionsOutput"], () => require("./getSecretVersions"));

export { GetSecretsArgs, GetSecretsResult, GetSecretsOutputArgs } from "./getSecrets";
export const getSecrets: typeof import("./getSecrets").getSecrets = null as any;
export const getSecretsOutput: typeof import("./getSecrets").getSecretsOutput = null as any;
utilities.lazyLoad(exports, ["getSecrets","getSecretsOutput"], () => require("./getSecrets"));

export { SecretArgs, SecretState } from "./secret";
export type Secret = import("./secret").Secret;
export const Secret: typeof import("./secret").Secret = null as any;
utilities.lazyLoad(exports, ["Secret"], () => require("./secret"));

export { SecretPolicyArgs, SecretPolicyState } from "./secretPolicy";
export type SecretPolicy = import("./secretPolicy").SecretPolicy;
export const SecretPolicy: typeof import("./secretPolicy").SecretPolicy = null as any;
utilities.lazyLoad(exports, ["SecretPolicy"], () => require("./secretPolicy"));

export { SecretRotationArgs, SecretRotationState } from "./secretRotation";
export type SecretRotation = import("./secretRotation").SecretRotation;
export const SecretRotation: typeof import("./secretRotation").SecretRotation = null as any;
utilities.lazyLoad(exports, ["SecretRotation"], () => require("./secretRotation"));

export { SecretVersionArgs, SecretVersionState } from "./secretVersion";
export type SecretVersion = import("./secretVersion").SecretVersion;
export const SecretVersion: typeof import("./secretVersion").SecretVersion = null as any;
utilities.lazyLoad(exports, ["SecretVersion"], () => require("./secretVersion"));


const _module = {
    version: utilities.getVersion(),
    construct: (name: string, type: string, urn: string): pulumi.Resource => {
        switch (type) {
            case "aws:secretsmanager/secret:Secret":
                return new Secret(name, <any>undefined, { urn })
            case "aws:secretsmanager/secretPolicy:SecretPolicy":
                return new SecretPolicy(name, <any>undefined, { urn })
            case "aws:secretsmanager/secretRotation:SecretRotation":
                return new SecretRotation(name, <any>undefined, { urn })
            case "aws:secretsmanager/secretVersion:SecretVersion":
                return new SecretVersion(name, <any>undefined, { urn })
            default:
                throw new Error(`unknown resource type ${type}`);
        }
    },
};
pulumi.runtime.registerResourceModule("aws", "secretsmanager/secret", _module)
pulumi.runtime.registerResourceModule("aws", "secretsmanager/secretPolicy", _module)
pulumi.runtime.registerResourceModule("aws", "secretsmanager/secretRotation", _module)
pulumi.runtime.registerResourceModule("aws", "secretsmanager/secretVersion", _module)
