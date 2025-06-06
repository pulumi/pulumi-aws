// *** WARNING: this file was generated by pulumi-language-nodejs. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

import * as pulumi from "@pulumi/pulumi";
import * as inputs from "../types/input";
import * as outputs from "../types/output";
import * as enums from "../types/enums";
import * as utilities from "../utilities";

/**
 * Retrieve information about an EKS Cluster.
 *
 * ## Example Usage
 *
 * ```typescript
 * import * as pulumi from "@pulumi/pulumi";
 * import * as aws from "@pulumi/aws";
 *
 * export = async () => {
 *     const example = await aws.eks.getCluster({
 *         name: "example",
 *     });
 *     return {
 *         endpoint: example.endpoint,
 *         "kubeconfig-certificate-authority-data": example.certificateAuthorities?.[0]?.data,
 *     };
 * }
 * ```
 */
export function getCluster(args: GetClusterArgs, opts?: pulumi.InvokeOptions): Promise<GetClusterResult> {
    opts = pulumi.mergeOptions(utilities.resourceOptsDefaults(), opts || {});
    return pulumi.runtime.invoke("aws:eks/getCluster:getCluster", {
        "name": args.name,
        "tags": args.tags,
    }, opts);
}

/**
 * A collection of arguments for invoking getCluster.
 */
export interface GetClusterArgs {
    /**
     * Name of the cluster.
     */
    name: string;
    /**
     * Key-value map of resource tags.
     */
    tags?: {[key: string]: string};
}

/**
 * A collection of values returned by getCluster.
 */
export interface GetClusterResult {
    /**
     * Configuration block for access config.
     */
    readonly accessConfigs: outputs.eks.GetClusterAccessConfig[];
    /**
     * ARN of the cluster.
     */
    readonly arn: string;
    /**
     * Nested attribute containing `certificate-authority-data` for your cluster.
     */
    readonly certificateAuthorities: outputs.eks.GetClusterCertificateAuthority[];
    /**
     * The ID of your local Amazon EKS cluster on the AWS Outpost. This attribute isn't available for an AWS EKS cluster on AWS cloud.
     */
    readonly clusterId: string;
    /**
     * Nested attribute containing compute capability configuration for EKS Auto Mode enabled cluster.
     */
    readonly computeConfigs: outputs.eks.GetClusterComputeConfig[];
    /**
     * Unix epoch time stamp in seconds for when the cluster was created.
     */
    readonly createdAt: string;
    /**
     * The enabled control plane logs.
     */
    readonly enabledClusterLogTypes: string[];
    /**
     * Endpoint for your Kubernetes API server.
     */
    readonly endpoint: string;
    /**
     * The provider-assigned unique ID for this managed resource.
     */
    readonly id: string;
    /**
     * Nested attribute containing identity provider information for your cluster. Only available on Kubernetes version 1.13 and 1.14 clusters created or upgraded on or after September 3, 2019. For an example using this information to enable IAM Roles for Service Accounts, see the `aws.eks.Cluster` resource documentation.
     */
    readonly identities: outputs.eks.GetClusterIdentity[];
    /**
     * Nested list containing Kubernetes Network Configuration.
     */
    readonly kubernetesNetworkConfigs: outputs.eks.GetClusterKubernetesNetworkConfig[];
    readonly name: string;
    /**
     * Contains Outpost Configuration.
     */
    readonly outpostConfigs: outputs.eks.GetClusterOutpostConfig[];
    /**
     * Platform version for the cluster.
     */
    readonly platformVersion: string;
    /**
     * Contains remote network configuration for EKS Hybrid Nodes.
     */
    readonly remoteNetworkConfigs: outputs.eks.GetClusterRemoteNetworkConfig[];
    /**
     * ARN of the IAM role that provides permissions for the Kubernetes control plane to make calls to AWS API operations on your behalf.
     */
    readonly roleArn: string;
    /**
     * Status of the EKS cluster. One of `CREATING`, `ACTIVE`, `DELETING`, `FAILED`.
     */
    readonly status: string;
    /**
     * Contains storage configuration for EKS Auto Mode enabled cluster.
     */
    readonly storageConfigs: outputs.eks.GetClusterStorageConfig[];
    /**
     * Key-value map of resource tags.
     */
    readonly tags: {[key: string]: string};
    /**
     * Configuration block for the support policy to use for the cluster.
     */
    readonly upgradePolicies: outputs.eks.GetClusterUpgradePolicy[];
    /**
     * Kubernetes server version for the cluster.
     */
    readonly version: string;
    /**
     * Nested list containing VPC configuration for the cluster.
     */
    readonly vpcConfig: outputs.eks.GetClusterVpcConfig;
    /**
     * Contains Zonal Shift Configuration.
     */
    readonly zonalShiftConfigs: outputs.eks.GetClusterZonalShiftConfig[];
}
/**
 * Retrieve information about an EKS Cluster.
 *
 * ## Example Usage
 *
 * ```typescript
 * import * as pulumi from "@pulumi/pulumi";
 * import * as aws from "@pulumi/aws";
 *
 * export = async () => {
 *     const example = await aws.eks.getCluster({
 *         name: "example",
 *     });
 *     return {
 *         endpoint: example.endpoint,
 *         "kubeconfig-certificate-authority-data": example.certificateAuthorities?.[0]?.data,
 *     };
 * }
 * ```
 */
export function getClusterOutput(args: GetClusterOutputArgs, opts?: pulumi.InvokeOutputOptions): pulumi.Output<GetClusterResult> {
    opts = pulumi.mergeOptions(utilities.resourceOptsDefaults(), opts || {});
    return pulumi.runtime.invokeOutput("aws:eks/getCluster:getCluster", {
        "name": args.name,
        "tags": args.tags,
    }, opts);
}

/**
 * A collection of arguments for invoking getCluster.
 */
export interface GetClusterOutputArgs {
    /**
     * Name of the cluster.
     */
    name: pulumi.Input<string>;
    /**
     * Key-value map of resource tags.
     */
    tags?: pulumi.Input<{[key: string]: pulumi.Input<string>}>;
}
