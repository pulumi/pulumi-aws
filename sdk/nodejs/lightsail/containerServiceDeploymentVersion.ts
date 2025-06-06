// *** WARNING: this file was generated by pulumi-language-nodejs. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

import * as pulumi from "@pulumi/pulumi";
import * as inputs from "../types/input";
import * as outputs from "../types/output";
import * as enums from "../types/enums";
import * as utilities from "../utilities";

/**
 * Provides a resource to manage a deployment version for your Amazon Lightsail container service.
 *
 * > **NOTE:** The Amazon Lightsail container service must be enabled to create a deployment.
 *
 * > **NOTE:** This resource allows you to manage an Amazon Lightsail container service deployment version but the provider cannot destroy it. Removing this resource from your configuration will remove it from your statefile.
 *
 * ## Example Usage
 *
 * ### Basic Usage
 *
 * ```typescript
 * import * as pulumi from "@pulumi/pulumi";
 * import * as aws from "@pulumi/aws";
 *
 * const example = new aws.lightsail.ContainerServiceDeploymentVersion("example", {
 *     containers: [{
 *         containerName: "hello-world",
 *         image: "amazon/amazon-lightsail:hello-world",
 *         commands: [],
 *         environment: {
 *             MY_ENVIRONMENT_VARIABLE: "my_value",
 *         },
 *         ports: {
 *             "80": "HTTP",
 *         },
 *     }],
 *     publicEndpoint: {
 *         containerName: "hello-world",
 *         containerPort: 80,
 *         healthCheck: {
 *             healthyThreshold: 2,
 *             unhealthyThreshold: 2,
 *             timeoutSeconds: 2,
 *             intervalSeconds: 5,
 *             path: "/",
 *             successCodes: "200-499",
 *         },
 *     },
 *     serviceName: exampleAwsLightsailContainerService.name,
 * });
 * ```
 *
 * ## Import
 *
 * Using `pulumi import`, import Lightsail Container Service Deployment Version using the `service_name` and `version` separated by a slash (`/`). For example:
 *
 * ```sh
 * $ pulumi import aws:lightsail/containerServiceDeploymentVersion:ContainerServiceDeploymentVersion example container-service-1/1
 * ```
 */
export class ContainerServiceDeploymentVersion extends pulumi.CustomResource {
    /**
     * Get an existing ContainerServiceDeploymentVersion resource's state with the given name, ID, and optional extra
     * properties used to qualify the lookup.
     *
     * @param name The _unique_ name of the resulting resource.
     * @param id The _unique_ provider ID of the resource to lookup.
     * @param state Any extra arguments used during the lookup.
     * @param opts Optional settings to control the behavior of the CustomResource.
     */
    public static get(name: string, id: pulumi.Input<pulumi.ID>, state?: ContainerServiceDeploymentVersionState, opts?: pulumi.CustomResourceOptions): ContainerServiceDeploymentVersion {
        return new ContainerServiceDeploymentVersion(name, <any>state, { ...opts, id: id });
    }

    /** @internal */
    public static readonly __pulumiType = 'aws:lightsail/containerServiceDeploymentVersion:ContainerServiceDeploymentVersion';

    /**
     * Returns true if the given object is an instance of ContainerServiceDeploymentVersion.  This is designed to work even
     * when multiple copies of the Pulumi SDK have been loaded into the same process.
     */
    public static isInstance(obj: any): obj is ContainerServiceDeploymentVersion {
        if (obj === undefined || obj === null) {
            return false;
        }
        return obj['__pulumiType'] === ContainerServiceDeploymentVersion.__pulumiType;
    }

    /**
     * A set of configuration blocks that describe the settings of the containers that will be launched on the container service. Maximum of 53. Detailed below.
     */
    public readonly containers!: pulumi.Output<outputs.lightsail.ContainerServiceDeploymentVersionContainer[]>;
    /**
     * The timestamp when the deployment was created.
     */
    public /*out*/ readonly createdAt!: pulumi.Output<string>;
    /**
     * A configuration block that describes the settings of the public endpoint for the container service. Detailed below.
     */
    public readonly publicEndpoint!: pulumi.Output<outputs.lightsail.ContainerServiceDeploymentVersionPublicEndpoint | undefined>;
    /**
     * The name for the container service.
     */
    public readonly serviceName!: pulumi.Output<string>;
    /**
     * The current state of the container service.
     */
    public /*out*/ readonly state!: pulumi.Output<string>;
    /**
     * The version number of the deployment.
     */
    public /*out*/ readonly version!: pulumi.Output<number>;

    /**
     * Create a ContainerServiceDeploymentVersion resource with the given unique name, arguments, and options.
     *
     * @param name The _unique_ name of the resource.
     * @param args The arguments to use to populate this resource's properties.
     * @param opts A bag of options that control this resource's behavior.
     */
    constructor(name: string, args: ContainerServiceDeploymentVersionArgs, opts?: pulumi.CustomResourceOptions)
    constructor(name: string, argsOrState?: ContainerServiceDeploymentVersionArgs | ContainerServiceDeploymentVersionState, opts?: pulumi.CustomResourceOptions) {
        let resourceInputs: pulumi.Inputs = {};
        opts = opts || {};
        if (opts.id) {
            const state = argsOrState as ContainerServiceDeploymentVersionState | undefined;
            resourceInputs["containers"] = state ? state.containers : undefined;
            resourceInputs["createdAt"] = state ? state.createdAt : undefined;
            resourceInputs["publicEndpoint"] = state ? state.publicEndpoint : undefined;
            resourceInputs["serviceName"] = state ? state.serviceName : undefined;
            resourceInputs["state"] = state ? state.state : undefined;
            resourceInputs["version"] = state ? state.version : undefined;
        } else {
            const args = argsOrState as ContainerServiceDeploymentVersionArgs | undefined;
            if ((!args || args.containers === undefined) && !opts.urn) {
                throw new Error("Missing required property 'containers'");
            }
            if ((!args || args.serviceName === undefined) && !opts.urn) {
                throw new Error("Missing required property 'serviceName'");
            }
            resourceInputs["containers"] = args ? args.containers : undefined;
            resourceInputs["publicEndpoint"] = args ? args.publicEndpoint : undefined;
            resourceInputs["serviceName"] = args ? args.serviceName : undefined;
            resourceInputs["createdAt"] = undefined /*out*/;
            resourceInputs["state"] = undefined /*out*/;
            resourceInputs["version"] = undefined /*out*/;
        }
        opts = pulumi.mergeOptions(utilities.resourceOptsDefaults(), opts);
        super(ContainerServiceDeploymentVersion.__pulumiType, name, resourceInputs, opts);
    }
}

/**
 * Input properties used for looking up and filtering ContainerServiceDeploymentVersion resources.
 */
export interface ContainerServiceDeploymentVersionState {
    /**
     * A set of configuration blocks that describe the settings of the containers that will be launched on the container service. Maximum of 53. Detailed below.
     */
    containers?: pulumi.Input<pulumi.Input<inputs.lightsail.ContainerServiceDeploymentVersionContainer>[]>;
    /**
     * The timestamp when the deployment was created.
     */
    createdAt?: pulumi.Input<string>;
    /**
     * A configuration block that describes the settings of the public endpoint for the container service. Detailed below.
     */
    publicEndpoint?: pulumi.Input<inputs.lightsail.ContainerServiceDeploymentVersionPublicEndpoint>;
    /**
     * The name for the container service.
     */
    serviceName?: pulumi.Input<string>;
    /**
     * The current state of the container service.
     */
    state?: pulumi.Input<string>;
    /**
     * The version number of the deployment.
     */
    version?: pulumi.Input<number>;
}

/**
 * The set of arguments for constructing a ContainerServiceDeploymentVersion resource.
 */
export interface ContainerServiceDeploymentVersionArgs {
    /**
     * A set of configuration blocks that describe the settings of the containers that will be launched on the container service. Maximum of 53. Detailed below.
     */
    containers: pulumi.Input<pulumi.Input<inputs.lightsail.ContainerServiceDeploymentVersionContainer>[]>;
    /**
     * A configuration block that describes the settings of the public endpoint for the container service. Detailed below.
     */
    publicEndpoint?: pulumi.Input<inputs.lightsail.ContainerServiceDeploymentVersionPublicEndpoint>;
    /**
     * The name for the container service.
     */
    serviceName: pulumi.Input<string>;
}
