// *** WARNING: this file was generated by pulumi-language-nodejs. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

import * as pulumi from "@pulumi/pulumi";
import * as inputs from "../types/input";
import * as outputs from "../types/output";
import * as enums from "../types/enums";
import * as utilities from "../utilities";

/**
 * Provides a CodeDeploy Deployment Group for a CodeDeploy Application
 *
 * > **NOTE on blue/green deployments:** When using `greenFleetProvisioningOption` with the `COPY_AUTO_SCALING_GROUP` action, CodeDeploy will create a new ASG with a different name. This ASG is _not_ managed by this provider and will conflict with existing configuration and state. You may want to use a different approach to managing deployments that involve multiple ASG, such as `DISCOVER_EXISTING` with separate blue and green ASG.
 *
 * ## Example Usage
 *
 * ```typescript
 * import * as pulumi from "@pulumi/pulumi";
 * import * as aws from "@pulumi/aws";
 *
 * const assumeRole = aws.iam.getPolicyDocument({
 *     statements: [{
 *         effect: "Allow",
 *         principals: [{
 *             type: "Service",
 *             identifiers: ["codedeploy.amazonaws.com"],
 *         }],
 *         actions: ["sts:AssumeRole"],
 *     }],
 * });
 * const example = new aws.iam.Role("example", {
 *     name: "example-role",
 *     assumeRolePolicy: assumeRole.then(assumeRole => assumeRole.json),
 * });
 * const aWSCodeDeployRole = new aws.iam.RolePolicyAttachment("AWSCodeDeployRole", {
 *     policyArn: "arn:aws:iam::aws:policy/service-role/AWSCodeDeployRole",
 *     role: example.name,
 * });
 * const exampleApplication = new aws.codedeploy.Application("example", {name: "example-app"});
 * const exampleTopic = new aws.sns.Topic("example", {name: "example-topic"});
 * const exampleDeploymentGroup = new aws.codedeploy.DeploymentGroup("example", {
 *     appName: exampleApplication.name,
 *     deploymentGroupName: "example-group",
 *     serviceRoleArn: example.arn,
 *     ec2TagSets: [{
 *         ec2TagFilters: [
 *             {
 *                 key: "filterkey1",
 *                 type: "KEY_AND_VALUE",
 *                 value: "filtervalue",
 *             },
 *             {
 *                 key: "filterkey2",
 *                 type: "KEY_AND_VALUE",
 *                 value: "filtervalue",
 *             },
 *         ],
 *     }],
 *     triggerConfigurations: [{
 *         triggerEvents: ["DeploymentFailure"],
 *         triggerName: "example-trigger",
 *         triggerTargetArn: exampleTopic.arn,
 *     }],
 *     autoRollbackConfiguration: {
 *         enabled: true,
 *         events: ["DEPLOYMENT_FAILURE"],
 *     },
 *     alarmConfiguration: {
 *         alarms: ["my-alarm-name"],
 *         enabled: true,
 *     },
 *     outdatedInstancesStrategy: "UPDATE",
 * });
 * ```
 *
 * ### Blue Green Deployments with ECS
 *
 * ```typescript
 * import * as pulumi from "@pulumi/pulumi";
 * import * as aws from "@pulumi/aws";
 *
 * const example = new aws.codedeploy.Application("example", {
 *     computePlatform: "ECS",
 *     name: "example",
 * });
 * const exampleDeploymentGroup = new aws.codedeploy.DeploymentGroup("example", {
 *     appName: example.name,
 *     deploymentConfigName: "CodeDeployDefault.ECSAllAtOnce",
 *     deploymentGroupName: "example",
 *     serviceRoleArn: exampleAwsIamRole.arn,
 *     autoRollbackConfiguration: {
 *         enabled: true,
 *         events: ["DEPLOYMENT_FAILURE"],
 *     },
 *     blueGreenDeploymentConfig: {
 *         deploymentReadyOption: {
 *             actionOnTimeout: "CONTINUE_DEPLOYMENT",
 *         },
 *         terminateBlueInstancesOnDeploymentSuccess: {
 *             action: "TERMINATE",
 *             terminationWaitTimeInMinutes: 5,
 *         },
 *     },
 *     deploymentStyle: {
 *         deploymentOption: "WITH_TRAFFIC_CONTROL",
 *         deploymentType: "BLUE_GREEN",
 *     },
 *     ecsService: {
 *         clusterName: exampleAwsEcsCluster.name,
 *         serviceName: exampleAwsEcsService.name,
 *     },
 *     loadBalancerInfo: {
 *         targetGroupPairInfo: {
 *             prodTrafficRoute: {
 *                 listenerArns: [exampleAwsLbListener.arn],
 *             },
 *             targetGroups: [
 *                 {
 *                     name: blue.name,
 *                 },
 *                 {
 *                     name: green.name,
 *                 },
 *             ],
 *         },
 *     },
 * });
 * ```
 *
 * ### Blue Green Deployments with Servers and Classic ELB
 *
 * ```typescript
 * import * as pulumi from "@pulumi/pulumi";
 * import * as aws from "@pulumi/aws";
 *
 * const example = new aws.codedeploy.Application("example", {name: "example-app"});
 * const exampleDeploymentGroup = new aws.codedeploy.DeploymentGroup("example", {
 *     appName: example.name,
 *     deploymentGroupName: "example-group",
 *     serviceRoleArn: exampleAwsIamRole.arn,
 *     deploymentStyle: {
 *         deploymentOption: "WITH_TRAFFIC_CONTROL",
 *         deploymentType: "BLUE_GREEN",
 *     },
 *     loadBalancerInfo: {
 *         elbInfos: [{
 *             name: exampleAwsElb.name,
 *         }],
 *     },
 *     blueGreenDeploymentConfig: {
 *         deploymentReadyOption: {
 *             actionOnTimeout: "STOP_DEPLOYMENT",
 *             waitTimeInMinutes: 60,
 *         },
 *         greenFleetProvisioningOption: {
 *             action: "DISCOVER_EXISTING",
 *         },
 *         terminateBlueInstancesOnDeploymentSuccess: {
 *             action: "KEEP_ALIVE",
 *         },
 *     },
 * });
 * ```
 *
 * ## Import
 *
 * Using `pulumi import`, import CodeDeploy Deployment Groups using `app_name`, a colon, and `deployment_group_name`. For example:
 *
 * ```sh
 * $ pulumi import aws:codedeploy/deploymentGroup:DeploymentGroup example my-application:my-deployment-group
 * ```
 */
export class DeploymentGroup extends pulumi.CustomResource {
    /**
     * Get an existing DeploymentGroup resource's state with the given name, ID, and optional extra
     * properties used to qualify the lookup.
     *
     * @param name The _unique_ name of the resulting resource.
     * @param id The _unique_ provider ID of the resource to lookup.
     * @param state Any extra arguments used during the lookup.
     * @param opts Optional settings to control the behavior of the CustomResource.
     */
    public static get(name: string, id: pulumi.Input<pulumi.ID>, state?: DeploymentGroupState, opts?: pulumi.CustomResourceOptions): DeploymentGroup {
        return new DeploymentGroup(name, <any>state, { ...opts, id: id });
    }

    /** @internal */
    public static readonly __pulumiType = 'aws:codedeploy/deploymentGroup:DeploymentGroup';

    /**
     * Returns true if the given object is an instance of DeploymentGroup.  This is designed to work even
     * when multiple copies of the Pulumi SDK have been loaded into the same process.
     */
    public static isInstance(obj: any): obj is DeploymentGroup {
        if (obj === undefined || obj === null) {
            return false;
        }
        return obj['__pulumiType'] === DeploymentGroup.__pulumiType;
    }

    /**
     * Configuration block of alarms associated with the deployment group (documented below).
     */
    public readonly alarmConfiguration!: pulumi.Output<outputs.codedeploy.DeploymentGroupAlarmConfiguration | undefined>;
    /**
     * The name of the application.
     */
    public readonly appName!: pulumi.Output<string>;
    /**
     * The ARN of the CodeDeploy deployment group.
     */
    public /*out*/ readonly arn!: pulumi.Output<string>;
    /**
     * Configuration block of the automatic rollback configuration associated with the deployment group (documented below).
     */
    public readonly autoRollbackConfiguration!: pulumi.Output<outputs.codedeploy.DeploymentGroupAutoRollbackConfiguration | undefined>;
    /**
     * Autoscaling groups associated with the deployment group.
     */
    public readonly autoscalingGroups!: pulumi.Output<string[] | undefined>;
    /**
     * Configuration block of the blue/green deployment options for a deployment group (documented below).
     */
    public readonly blueGreenDeploymentConfig!: pulumi.Output<outputs.codedeploy.DeploymentGroupBlueGreenDeploymentConfig>;
    /**
     * The destination platform type for the deployment.
     */
    public /*out*/ readonly computePlatform!: pulumi.Output<string>;
    /**
     * The name of the group's deployment config. The default is "CodeDeployDefault.OneAtATime".
     */
    public readonly deploymentConfigName!: pulumi.Output<string | undefined>;
    /**
     * The ID of the CodeDeploy deployment group.
     */
    public /*out*/ readonly deploymentGroupId!: pulumi.Output<string>;
    /**
     * The name of the deployment group.
     */
    public readonly deploymentGroupName!: pulumi.Output<string>;
    /**
     * Configuration block of the type of deployment, either in-place or blue/green, you want to run and whether to route deployment traffic behind a load balancer (documented below).
     */
    public readonly deploymentStyle!: pulumi.Output<outputs.codedeploy.DeploymentGroupDeploymentStyle | undefined>;
    /**
     * Tag filters associated with the deployment group. See the AWS docs for details.
     */
    public readonly ec2TagFilters!: pulumi.Output<outputs.codedeploy.DeploymentGroupEc2TagFilter[] | undefined>;
    /**
     * Configuration block(s) of Tag filters associated with the deployment group, which are also referred to as tag groups (documented below). See the AWS docs for details.
     */
    public readonly ec2TagSets!: pulumi.Output<outputs.codedeploy.DeploymentGroupEc2TagSet[] | undefined>;
    /**
     * Configuration block(s) of the ECS services for a deployment group (documented below).
     */
    public readonly ecsService!: pulumi.Output<outputs.codedeploy.DeploymentGroupEcsService | undefined>;
    /**
     * Single configuration block of the load balancer to use in a blue/green deployment (documented below).
     */
    public readonly loadBalancerInfo!: pulumi.Output<outputs.codedeploy.DeploymentGroupLoadBalancerInfo | undefined>;
    /**
     * On premise tag filters associated with the group. See the AWS docs for details.
     */
    public readonly onPremisesInstanceTagFilters!: pulumi.Output<outputs.codedeploy.DeploymentGroupOnPremisesInstanceTagFilter[] | undefined>;
    /**
     * Configuration block of Indicates what happens when new Amazon EC2 instances are launched mid-deployment and do not receive the deployed application revision. Valid values are `UPDATE` and `IGNORE`. Defaults to `UPDATE`.
     */
    public readonly outdatedInstancesStrategy!: pulumi.Output<string | undefined>;
    /**
     * The service role ARN that allows deployments.
     */
    public readonly serviceRoleArn!: pulumi.Output<string>;
    /**
     * Key-value map of resource tags. .If configured with a provider `defaultTags` configuration block present, tags with matching keys will overwrite those defined at the provider-level.
     */
    public readonly tags!: pulumi.Output<{[key: string]: string} | undefined>;
    /**
     * A map of tags assigned to the resource, including those inherited from the provider `defaultTags` configuration block.
     *
     * @deprecated Please use `tags` instead.
     */
    public /*out*/ readonly tagsAll!: pulumi.Output<{[key: string]: string}>;
    /**
     * Indicates whether the deployment group was configured to have CodeDeploy install a termination hook into an Auto Scaling group.
     */
    public readonly terminationHookEnabled!: pulumi.Output<boolean | undefined>;
    /**
     * Configuration block(s) of the triggers for the deployment group (documented below).
     */
    public readonly triggerConfigurations!: pulumi.Output<outputs.codedeploy.DeploymentGroupTriggerConfiguration[] | undefined>;

    /**
     * Create a DeploymentGroup resource with the given unique name, arguments, and options.
     *
     * @param name The _unique_ name of the resource.
     * @param args The arguments to use to populate this resource's properties.
     * @param opts A bag of options that control this resource's behavior.
     */
    constructor(name: string, args: DeploymentGroupArgs, opts?: pulumi.CustomResourceOptions)
    constructor(name: string, argsOrState?: DeploymentGroupArgs | DeploymentGroupState, opts?: pulumi.CustomResourceOptions) {
        let resourceInputs: pulumi.Inputs = {};
        opts = opts || {};
        if (opts.id) {
            const state = argsOrState as DeploymentGroupState | undefined;
            resourceInputs["alarmConfiguration"] = state ? state.alarmConfiguration : undefined;
            resourceInputs["appName"] = state ? state.appName : undefined;
            resourceInputs["arn"] = state ? state.arn : undefined;
            resourceInputs["autoRollbackConfiguration"] = state ? state.autoRollbackConfiguration : undefined;
            resourceInputs["autoscalingGroups"] = state ? state.autoscalingGroups : undefined;
            resourceInputs["blueGreenDeploymentConfig"] = state ? state.blueGreenDeploymentConfig : undefined;
            resourceInputs["computePlatform"] = state ? state.computePlatform : undefined;
            resourceInputs["deploymentConfigName"] = state ? state.deploymentConfigName : undefined;
            resourceInputs["deploymentGroupId"] = state ? state.deploymentGroupId : undefined;
            resourceInputs["deploymentGroupName"] = state ? state.deploymentGroupName : undefined;
            resourceInputs["deploymentStyle"] = state ? state.deploymentStyle : undefined;
            resourceInputs["ec2TagFilters"] = state ? state.ec2TagFilters : undefined;
            resourceInputs["ec2TagSets"] = state ? state.ec2TagSets : undefined;
            resourceInputs["ecsService"] = state ? state.ecsService : undefined;
            resourceInputs["loadBalancerInfo"] = state ? state.loadBalancerInfo : undefined;
            resourceInputs["onPremisesInstanceTagFilters"] = state ? state.onPremisesInstanceTagFilters : undefined;
            resourceInputs["outdatedInstancesStrategy"] = state ? state.outdatedInstancesStrategy : undefined;
            resourceInputs["serviceRoleArn"] = state ? state.serviceRoleArn : undefined;
            resourceInputs["tags"] = state ? state.tags : undefined;
            resourceInputs["tagsAll"] = state ? state.tagsAll : undefined;
            resourceInputs["terminationHookEnabled"] = state ? state.terminationHookEnabled : undefined;
            resourceInputs["triggerConfigurations"] = state ? state.triggerConfigurations : undefined;
        } else {
            const args = argsOrState as DeploymentGroupArgs | undefined;
            if ((!args || args.appName === undefined) && !opts.urn) {
                throw new Error("Missing required property 'appName'");
            }
            if ((!args || args.deploymentGroupName === undefined) && !opts.urn) {
                throw new Error("Missing required property 'deploymentGroupName'");
            }
            if ((!args || args.serviceRoleArn === undefined) && !opts.urn) {
                throw new Error("Missing required property 'serviceRoleArn'");
            }
            resourceInputs["alarmConfiguration"] = args ? args.alarmConfiguration : undefined;
            resourceInputs["appName"] = args ? args.appName : undefined;
            resourceInputs["autoRollbackConfiguration"] = args ? args.autoRollbackConfiguration : undefined;
            resourceInputs["autoscalingGroups"] = args ? args.autoscalingGroups : undefined;
            resourceInputs["blueGreenDeploymentConfig"] = args ? args.blueGreenDeploymentConfig : undefined;
            resourceInputs["deploymentConfigName"] = args ? args.deploymentConfigName : undefined;
            resourceInputs["deploymentGroupName"] = args ? args.deploymentGroupName : undefined;
            resourceInputs["deploymentStyle"] = args ? args.deploymentStyle : undefined;
            resourceInputs["ec2TagFilters"] = args ? args.ec2TagFilters : undefined;
            resourceInputs["ec2TagSets"] = args ? args.ec2TagSets : undefined;
            resourceInputs["ecsService"] = args ? args.ecsService : undefined;
            resourceInputs["loadBalancerInfo"] = args ? args.loadBalancerInfo : undefined;
            resourceInputs["onPremisesInstanceTagFilters"] = args ? args.onPremisesInstanceTagFilters : undefined;
            resourceInputs["outdatedInstancesStrategy"] = args ? args.outdatedInstancesStrategy : undefined;
            resourceInputs["serviceRoleArn"] = args ? args.serviceRoleArn : undefined;
            resourceInputs["tags"] = args ? args.tags : undefined;
            resourceInputs["terminationHookEnabled"] = args ? args.terminationHookEnabled : undefined;
            resourceInputs["triggerConfigurations"] = args ? args.triggerConfigurations : undefined;
            resourceInputs["arn"] = undefined /*out*/;
            resourceInputs["computePlatform"] = undefined /*out*/;
            resourceInputs["deploymentGroupId"] = undefined /*out*/;
            resourceInputs["tagsAll"] = undefined /*out*/;
        }
        opts = pulumi.mergeOptions(utilities.resourceOptsDefaults(), opts);
        super(DeploymentGroup.__pulumiType, name, resourceInputs, opts);
    }
}

/**
 * Input properties used for looking up and filtering DeploymentGroup resources.
 */
export interface DeploymentGroupState {
    /**
     * Configuration block of alarms associated with the deployment group (documented below).
     */
    alarmConfiguration?: pulumi.Input<inputs.codedeploy.DeploymentGroupAlarmConfiguration>;
    /**
     * The name of the application.
     */
    appName?: pulumi.Input<string>;
    /**
     * The ARN of the CodeDeploy deployment group.
     */
    arn?: pulumi.Input<string>;
    /**
     * Configuration block of the automatic rollback configuration associated with the deployment group (documented below).
     */
    autoRollbackConfiguration?: pulumi.Input<inputs.codedeploy.DeploymentGroupAutoRollbackConfiguration>;
    /**
     * Autoscaling groups associated with the deployment group.
     */
    autoscalingGroups?: pulumi.Input<pulumi.Input<string>[]>;
    /**
     * Configuration block of the blue/green deployment options for a deployment group (documented below).
     */
    blueGreenDeploymentConfig?: pulumi.Input<inputs.codedeploy.DeploymentGroupBlueGreenDeploymentConfig>;
    /**
     * The destination platform type for the deployment.
     */
    computePlatform?: pulumi.Input<string>;
    /**
     * The name of the group's deployment config. The default is "CodeDeployDefault.OneAtATime".
     */
    deploymentConfigName?: pulumi.Input<string>;
    /**
     * The ID of the CodeDeploy deployment group.
     */
    deploymentGroupId?: pulumi.Input<string>;
    /**
     * The name of the deployment group.
     */
    deploymentGroupName?: pulumi.Input<string>;
    /**
     * Configuration block of the type of deployment, either in-place or blue/green, you want to run and whether to route deployment traffic behind a load balancer (documented below).
     */
    deploymentStyle?: pulumi.Input<inputs.codedeploy.DeploymentGroupDeploymentStyle>;
    /**
     * Tag filters associated with the deployment group. See the AWS docs for details.
     */
    ec2TagFilters?: pulumi.Input<pulumi.Input<inputs.codedeploy.DeploymentGroupEc2TagFilter>[]>;
    /**
     * Configuration block(s) of Tag filters associated with the deployment group, which are also referred to as tag groups (documented below). See the AWS docs for details.
     */
    ec2TagSets?: pulumi.Input<pulumi.Input<inputs.codedeploy.DeploymentGroupEc2TagSet>[]>;
    /**
     * Configuration block(s) of the ECS services for a deployment group (documented below).
     */
    ecsService?: pulumi.Input<inputs.codedeploy.DeploymentGroupEcsService>;
    /**
     * Single configuration block of the load balancer to use in a blue/green deployment (documented below).
     */
    loadBalancerInfo?: pulumi.Input<inputs.codedeploy.DeploymentGroupLoadBalancerInfo>;
    /**
     * On premise tag filters associated with the group. See the AWS docs for details.
     */
    onPremisesInstanceTagFilters?: pulumi.Input<pulumi.Input<inputs.codedeploy.DeploymentGroupOnPremisesInstanceTagFilter>[]>;
    /**
     * Configuration block of Indicates what happens when new Amazon EC2 instances are launched mid-deployment and do not receive the deployed application revision. Valid values are `UPDATE` and `IGNORE`. Defaults to `UPDATE`.
     */
    outdatedInstancesStrategy?: pulumi.Input<string>;
    /**
     * The service role ARN that allows deployments.
     */
    serviceRoleArn?: pulumi.Input<string>;
    /**
     * Key-value map of resource tags. .If configured with a provider `defaultTags` configuration block present, tags with matching keys will overwrite those defined at the provider-level.
     */
    tags?: pulumi.Input<{[key: string]: pulumi.Input<string>}>;
    /**
     * A map of tags assigned to the resource, including those inherited from the provider `defaultTags` configuration block.
     *
     * @deprecated Please use `tags` instead.
     */
    tagsAll?: pulumi.Input<{[key: string]: pulumi.Input<string>}>;
    /**
     * Indicates whether the deployment group was configured to have CodeDeploy install a termination hook into an Auto Scaling group.
     */
    terminationHookEnabled?: pulumi.Input<boolean>;
    /**
     * Configuration block(s) of the triggers for the deployment group (documented below).
     */
    triggerConfigurations?: pulumi.Input<pulumi.Input<inputs.codedeploy.DeploymentGroupTriggerConfiguration>[]>;
}

/**
 * The set of arguments for constructing a DeploymentGroup resource.
 */
export interface DeploymentGroupArgs {
    /**
     * Configuration block of alarms associated with the deployment group (documented below).
     */
    alarmConfiguration?: pulumi.Input<inputs.codedeploy.DeploymentGroupAlarmConfiguration>;
    /**
     * The name of the application.
     */
    appName: pulumi.Input<string>;
    /**
     * Configuration block of the automatic rollback configuration associated with the deployment group (documented below).
     */
    autoRollbackConfiguration?: pulumi.Input<inputs.codedeploy.DeploymentGroupAutoRollbackConfiguration>;
    /**
     * Autoscaling groups associated with the deployment group.
     */
    autoscalingGroups?: pulumi.Input<pulumi.Input<string>[]>;
    /**
     * Configuration block of the blue/green deployment options for a deployment group (documented below).
     */
    blueGreenDeploymentConfig?: pulumi.Input<inputs.codedeploy.DeploymentGroupBlueGreenDeploymentConfig>;
    /**
     * The name of the group's deployment config. The default is "CodeDeployDefault.OneAtATime".
     */
    deploymentConfigName?: pulumi.Input<string>;
    /**
     * The name of the deployment group.
     */
    deploymentGroupName: pulumi.Input<string>;
    /**
     * Configuration block of the type of deployment, either in-place or blue/green, you want to run and whether to route deployment traffic behind a load balancer (documented below).
     */
    deploymentStyle?: pulumi.Input<inputs.codedeploy.DeploymentGroupDeploymentStyle>;
    /**
     * Tag filters associated with the deployment group. See the AWS docs for details.
     */
    ec2TagFilters?: pulumi.Input<pulumi.Input<inputs.codedeploy.DeploymentGroupEc2TagFilter>[]>;
    /**
     * Configuration block(s) of Tag filters associated with the deployment group, which are also referred to as tag groups (documented below). See the AWS docs for details.
     */
    ec2TagSets?: pulumi.Input<pulumi.Input<inputs.codedeploy.DeploymentGroupEc2TagSet>[]>;
    /**
     * Configuration block(s) of the ECS services for a deployment group (documented below).
     */
    ecsService?: pulumi.Input<inputs.codedeploy.DeploymentGroupEcsService>;
    /**
     * Single configuration block of the load balancer to use in a blue/green deployment (documented below).
     */
    loadBalancerInfo?: pulumi.Input<inputs.codedeploy.DeploymentGroupLoadBalancerInfo>;
    /**
     * On premise tag filters associated with the group. See the AWS docs for details.
     */
    onPremisesInstanceTagFilters?: pulumi.Input<pulumi.Input<inputs.codedeploy.DeploymentGroupOnPremisesInstanceTagFilter>[]>;
    /**
     * Configuration block of Indicates what happens when new Amazon EC2 instances are launched mid-deployment and do not receive the deployed application revision. Valid values are `UPDATE` and `IGNORE`. Defaults to `UPDATE`.
     */
    outdatedInstancesStrategy?: pulumi.Input<string>;
    /**
     * The service role ARN that allows deployments.
     */
    serviceRoleArn: pulumi.Input<string>;
    /**
     * Key-value map of resource tags. .If configured with a provider `defaultTags` configuration block present, tags with matching keys will overwrite those defined at the provider-level.
     */
    tags?: pulumi.Input<{[key: string]: pulumi.Input<string>}>;
    /**
     * Indicates whether the deployment group was configured to have CodeDeploy install a termination hook into an Auto Scaling group.
     */
    terminationHookEnabled?: pulumi.Input<boolean>;
    /**
     * Configuration block(s) of the triggers for the deployment group (documented below).
     */
    triggerConfigurations?: pulumi.Input<pulumi.Input<inputs.codedeploy.DeploymentGroupTriggerConfiguration>[]>;
}
