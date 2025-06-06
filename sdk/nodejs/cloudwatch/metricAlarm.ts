// *** WARNING: this file was generated by pulumi-language-nodejs. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

import * as pulumi from "@pulumi/pulumi";
import * as inputs from "../types/input";
import * as outputs from "../types/output";
import * as enums from "../types/enums";
import * as utilities from "../utilities";

import {Topic} from "../sns";

/**
 * Provides a CloudWatch Metric Alarm resource.
 *
 * ## Example Usage
 *
 * ```typescript
 * import * as pulumi from "@pulumi/pulumi";
 * import * as aws from "@pulumi/aws";
 *
 * const foobar = new aws.cloudwatch.MetricAlarm("foobar", {
 *     name: "test-foobar5",
 *     comparisonOperator: "GreaterThanOrEqualToThreshold",
 *     evaluationPeriods: 2,
 *     metricName: "CPUUtilization",
 *     namespace: "AWS/EC2",
 *     period: 120,
 *     statistic: "Average",
 *     threshold: 80,
 *     alarmDescription: "This metric monitors ec2 cpu utilization",
 *     insufficientDataActions: [],
 * });
 * ```
 *
 * ## Example in Conjunction with Scaling Policies
 *
 * ```typescript
 * import * as pulumi from "@pulumi/pulumi";
 * import * as aws from "@pulumi/aws";
 *
 * const bat = new aws.autoscaling.Policy("bat", {
 *     name: "foobar3-test",
 *     scalingAdjustment: 4,
 *     adjustmentType: "ChangeInCapacity",
 *     cooldown: 300,
 *     autoscalingGroupName: bar.name,
 * });
 * const batMetricAlarm = new aws.cloudwatch.MetricAlarm("bat", {
 *     name: "test-foobar5",
 *     comparisonOperator: "GreaterThanOrEqualToThreshold",
 *     evaluationPeriods: 2,
 *     metricName: "CPUUtilization",
 *     namespace: "AWS/EC2",
 *     period: 120,
 *     statistic: "Average",
 *     threshold: 80,
 *     dimensions: {
 *         AutoScalingGroupName: bar.name,
 *     },
 *     alarmDescription: "This metric monitors ec2 cpu utilization",
 *     alarmActions: [bat.arn],
 * });
 * ```
 *
 * ## Example with an Expression
 *
 * ```typescript
 * import * as pulumi from "@pulumi/pulumi";
 * import * as aws from "@pulumi/aws";
 *
 * const foobar = new aws.cloudwatch.MetricAlarm("foobar", {
 *     name: "test-foobar",
 *     comparisonOperator: "GreaterThanOrEqualToThreshold",
 *     evaluationPeriods: 2,
 *     threshold: 10,
 *     alarmDescription: "Request error rate has exceeded 10%",
 *     insufficientDataActions: [],
 *     metricQueries: [
 *         {
 *             id: "e1",
 *             expression: "m2/m1*100",
 *             label: "Error Rate",
 *             returnData: true,
 *         },
 *         {
 *             id: "m1",
 *             metric: {
 *                 metricName: "RequestCount",
 *                 namespace: "AWS/ApplicationELB",
 *                 period: 120,
 *                 stat: "Sum",
 *                 unit: "Count",
 *                 dimensions: {
 *                     LoadBalancer: "app/web",
 *                 },
 *             },
 *         },
 *         {
 *             id: "m2",
 *             metric: {
 *                 metricName: "HTTPCode_ELB_5XX_Count",
 *                 namespace: "AWS/ApplicationELB",
 *                 period: 120,
 *                 stat: "Sum",
 *                 unit: "Count",
 *                 dimensions: {
 *                     LoadBalancer: "app/web",
 *                 },
 *             },
 *         },
 *     ],
 * });
 * ```
 *
 * ```typescript
 * import * as pulumi from "@pulumi/pulumi";
 * import * as aws from "@pulumi/aws";
 *
 * const xxAnomalyDetection = new aws.cloudwatch.MetricAlarm("xx_anomaly_detection", {
 *     name: "test-foobar",
 *     comparisonOperator: "GreaterThanUpperThreshold",
 *     evaluationPeriods: 2,
 *     thresholdMetricId: "e1",
 *     alarmDescription: "This metric monitors ec2 cpu utilization",
 *     insufficientDataActions: [],
 *     metricQueries: [
 *         {
 *             id: "e1",
 *             returnData: true,
 *             expression: "ANOMALY_DETECTION_BAND(m1)",
 *             label: "CPUUtilization (Expected)",
 *         },
 *         {
 *             id: "m1",
 *             returnData: true,
 *             metric: {
 *                 metricName: "CPUUtilization",
 *                 namespace: "AWS/EC2",
 *                 period: 120,
 *                 stat: "Average",
 *                 unit: "Count",
 *                 dimensions: {
 *                     InstanceId: "i-abc123",
 *                 },
 *             },
 *         },
 *     ],
 * });
 * ```
 *
 * ## Example of monitoring Healthy Hosts on NLB using Target Group and NLB
 *
 * ```typescript
 * import * as pulumi from "@pulumi/pulumi";
 * import * as aws from "@pulumi/aws";
 *
 * const nlbHealthyhosts = new aws.cloudwatch.MetricAlarm("nlb_healthyhosts", {
 *     name: "alarmname",
 *     comparisonOperator: "LessThanThreshold",
 *     evaluationPeriods: 1,
 *     metricName: "HealthyHostCount",
 *     namespace: "AWS/NetworkELB",
 *     period: 60,
 *     statistic: "Average",
 *     threshold: logstashServersCount,
 *     alarmDescription: "Number of healthy nodes in Target Group",
 *     actionsEnabled: true,
 *     alarmActions: [sns.arn],
 *     okActions: [sns.arn],
 *     dimensions: {
 *         TargetGroup: lb_tg.arnSuffix,
 *         LoadBalancer: lb.arnSuffix,
 *     },
 * });
 * ```
 *
 * > **NOTE:**  You cannot create a metric alarm consisting of both `statistic` and `extendedStatistic` parameters.
 * You must choose one or the other
 *
 * ## Import
 *
 * Using `pulumi import`, import CloudWatch Metric Alarm using the `alarm_name`. For example:
 *
 * ```sh
 * $ pulumi import aws:cloudwatch/metricAlarm:MetricAlarm test alarm-12345
 * ```
 */
export class MetricAlarm extends pulumi.CustomResource {
    /**
     * Get an existing MetricAlarm resource's state with the given name, ID, and optional extra
     * properties used to qualify the lookup.
     *
     * @param name The _unique_ name of the resulting resource.
     * @param id The _unique_ provider ID of the resource to lookup.
     * @param state Any extra arguments used during the lookup.
     * @param opts Optional settings to control the behavior of the CustomResource.
     */
    public static get(name: string, id: pulumi.Input<pulumi.ID>, state?: MetricAlarmState, opts?: pulumi.CustomResourceOptions): MetricAlarm {
        return new MetricAlarm(name, <any>state, { ...opts, id: id });
    }

    /** @internal */
    public static readonly __pulumiType = 'aws:cloudwatch/metricAlarm:MetricAlarm';

    /**
     * Returns true if the given object is an instance of MetricAlarm.  This is designed to work even
     * when multiple copies of the Pulumi SDK have been loaded into the same process.
     */
    public static isInstance(obj: any): obj is MetricAlarm {
        if (obj === undefined || obj === null) {
            return false;
        }
        return obj['__pulumiType'] === MetricAlarm.__pulumiType;
    }

    /**
     * Indicates whether or not actions should be executed during any changes to the alarm's state. Defaults to `true`.
     */
    public readonly actionsEnabled!: pulumi.Output<boolean | undefined>;
    /**
     * The list of actions to execute when this alarm transitions into an ALARM state from any other state. Each action is specified as an Amazon Resource Name (ARN).
     */
    public readonly alarmActions!: pulumi.Output<string[] | undefined>;
    /**
     * The description for the alarm.
     */
    public readonly alarmDescription!: pulumi.Output<string | undefined>;
    /**
     * The ARN of the CloudWatch Metric Alarm.
     */
    public /*out*/ readonly arn!: pulumi.Output<string>;
    /**
     * The arithmetic operation to use when comparing the specified Statistic and Threshold. The specified Statistic value is used as the first operand. Either of the following is supported: `GreaterThanOrEqualToThreshold`, `GreaterThanThreshold`, `LessThanThreshold`, `LessThanOrEqualToThreshold`. Additionally, the values  `LessThanLowerOrGreaterThanUpperThreshold`, `LessThanLowerThreshold`, and `GreaterThanUpperThreshold` are used only for alarms based on anomaly detection models.
     */
    public readonly comparisonOperator!: pulumi.Output<string>;
    /**
     * The number of datapoints that must be breaching to trigger the alarm.
     */
    public readonly datapointsToAlarm!: pulumi.Output<number | undefined>;
    /**
     * The dimensions for the alarm's associated metric.  For the list of available dimensions see the AWS documentation [here](http://docs.aws.amazon.com/AmazonCloudWatch/latest/DeveloperGuide/CW_Support_For_AWS.html).
     */
    public readonly dimensions!: pulumi.Output<{[key: string]: string} | undefined>;
    /**
     * Used only for alarms based on percentiles.
     * If you specify `ignore`, the alarm state will not change during periods with too few data points to be statistically significant.
     * If you specify `evaluate` or omit this parameter, the alarm will always be evaluated and possibly change state no matter how many data points are available.
     * The following values are supported: `ignore`, and `evaluate`.
     */
    public readonly evaluateLowSampleCountPercentiles!: pulumi.Output<string>;
    /**
     * The number of periods over which data is compared to the specified threshold.
     */
    public readonly evaluationPeriods!: pulumi.Output<number>;
    /**
     * The percentile statistic for the metric associated with the alarm. Specify a value between p0.0 and p100.
     */
    public readonly extendedStatistic!: pulumi.Output<string | undefined>;
    /**
     * The list of actions to execute when this alarm transitions into an INSUFFICIENT_DATA state from any other state. Each action is specified as an Amazon Resource Name (ARN).
     */
    public readonly insufficientDataActions!: pulumi.Output<string[] | undefined>;
    /**
     * The name for the alarm's associated metric.
     * See docs for [supported metrics](https://docs.aws.amazon.com/AmazonCloudWatch/latest/DeveloperGuide/CW_Support_For_AWS.html).
     */
    public readonly metricName!: pulumi.Output<string | undefined>;
    /**
     * Enables you to create an alarm based on a metric math expression. You may specify at most 20.
     */
    public readonly metricQueries!: pulumi.Output<outputs.cloudwatch.MetricAlarmMetricQuery[] | undefined>;
    /**
     * The descriptive name for the alarm. This name must be unique within the user's AWS account
     */
    public readonly name!: pulumi.Output<string>;
    /**
     * The namespace for the alarm's associated metric. See docs for the [list of namespaces](https://docs.aws.amazon.com/AmazonCloudWatch/latest/DeveloperGuide/aws-namespaces.html).
     * See docs for [supported metrics](https://docs.aws.amazon.com/AmazonCloudWatch/latest/DeveloperGuide/CW_Support_For_AWS.html).
     */
    public readonly namespace!: pulumi.Output<string | undefined>;
    /**
     * The list of actions to execute when this alarm transitions into an OK state from any other state. Each action is specified as an Amazon Resource Name (ARN).
     */
    public readonly okActions!: pulumi.Output<string[] | undefined>;
    /**
     * The period in seconds over which the specified `statistic` is applied.
     * Valid values are `10`, `20`, `30`, or any multiple of `60`.
     */
    public readonly period!: pulumi.Output<number | undefined>;
    /**
     * The statistic to apply to the alarm's associated metric.
     * Either of the following is supported: `SampleCount`, `Average`, `Sum`, `Minimum`, `Maximum`
     */
    public readonly statistic!: pulumi.Output<string | undefined>;
    /**
     * A map of tags to assign to the resource. .If configured with a provider `defaultTags` configuration block present, tags with matching keys will overwrite those defined at the provider-level.
     *
     * See [related part of AWS Docs](https://docs.aws.amazon.com/AmazonCloudWatch/latest/APIReference/API_PutMetricAlarm.html)
     * for details about valid values.
     *
     * > **NOTE:**  If you specify at least one `metricQuery`, you may not specify a `metricName`, `namespace`, `period` or `statistic`. If you do not specify a `metricQuery`, you must specify each of these (although you may use `extendedStatistic` instead of `statistic`).
     */
    public readonly tags!: pulumi.Output<{[key: string]: string} | undefined>;
    /**
     * A map of tags assigned to the resource, including those inherited from the provider `defaultTags` configuration block.
     *
     * @deprecated Please use `tags` instead.
     */
    public /*out*/ readonly tagsAll!: pulumi.Output<{[key: string]: string}>;
    /**
     * The value against which the specified statistic is compared. This parameter is required for alarms based on static thresholds, but should not be used for alarms based on anomaly detection models.
     */
    public readonly threshold!: pulumi.Output<number | undefined>;
    /**
     * If this is an alarm based on an anomaly detection model, make this value match the ID of the ANOMALY_DETECTION_BAND function.
     */
    public readonly thresholdMetricId!: pulumi.Output<string | undefined>;
    /**
     * Sets how this alarm is to handle missing data points. The following values are supported: `missing`, `ignore`, `breaching` and `notBreaching`. Defaults to `missing`.
     */
    public readonly treatMissingData!: pulumi.Output<string | undefined>;
    /**
     * The unit for the alarm's associated metric.
     */
    public readonly unit!: pulumi.Output<string | undefined>;

    /**
     * Create a MetricAlarm resource with the given unique name, arguments, and options.
     *
     * @param name The _unique_ name of the resource.
     * @param args The arguments to use to populate this resource's properties.
     * @param opts A bag of options that control this resource's behavior.
     */
    constructor(name: string, args: MetricAlarmArgs, opts?: pulumi.CustomResourceOptions)
    constructor(name: string, argsOrState?: MetricAlarmArgs | MetricAlarmState, opts?: pulumi.CustomResourceOptions) {
        let resourceInputs: pulumi.Inputs = {};
        opts = opts || {};
        if (opts.id) {
            const state = argsOrState as MetricAlarmState | undefined;
            resourceInputs["actionsEnabled"] = state ? state.actionsEnabled : undefined;
            resourceInputs["alarmActions"] = state ? state.alarmActions : undefined;
            resourceInputs["alarmDescription"] = state ? state.alarmDescription : undefined;
            resourceInputs["arn"] = state ? state.arn : undefined;
            resourceInputs["comparisonOperator"] = state ? state.comparisonOperator : undefined;
            resourceInputs["datapointsToAlarm"] = state ? state.datapointsToAlarm : undefined;
            resourceInputs["dimensions"] = state ? state.dimensions : undefined;
            resourceInputs["evaluateLowSampleCountPercentiles"] = state ? state.evaluateLowSampleCountPercentiles : undefined;
            resourceInputs["evaluationPeriods"] = state ? state.evaluationPeriods : undefined;
            resourceInputs["extendedStatistic"] = state ? state.extendedStatistic : undefined;
            resourceInputs["insufficientDataActions"] = state ? state.insufficientDataActions : undefined;
            resourceInputs["metricName"] = state ? state.metricName : undefined;
            resourceInputs["metricQueries"] = state ? state.metricQueries : undefined;
            resourceInputs["name"] = state ? state.name : undefined;
            resourceInputs["namespace"] = state ? state.namespace : undefined;
            resourceInputs["okActions"] = state ? state.okActions : undefined;
            resourceInputs["period"] = state ? state.period : undefined;
            resourceInputs["statistic"] = state ? state.statistic : undefined;
            resourceInputs["tags"] = state ? state.tags : undefined;
            resourceInputs["tagsAll"] = state ? state.tagsAll : undefined;
            resourceInputs["threshold"] = state ? state.threshold : undefined;
            resourceInputs["thresholdMetricId"] = state ? state.thresholdMetricId : undefined;
            resourceInputs["treatMissingData"] = state ? state.treatMissingData : undefined;
            resourceInputs["unit"] = state ? state.unit : undefined;
        } else {
            const args = argsOrState as MetricAlarmArgs | undefined;
            if ((!args || args.comparisonOperator === undefined) && !opts.urn) {
                throw new Error("Missing required property 'comparisonOperator'");
            }
            if ((!args || args.evaluationPeriods === undefined) && !opts.urn) {
                throw new Error("Missing required property 'evaluationPeriods'");
            }
            resourceInputs["actionsEnabled"] = args ? args.actionsEnabled : undefined;
            resourceInputs["alarmActions"] = args ? args.alarmActions : undefined;
            resourceInputs["alarmDescription"] = args ? args.alarmDescription : undefined;
            resourceInputs["comparisonOperator"] = args ? args.comparisonOperator : undefined;
            resourceInputs["datapointsToAlarm"] = args ? args.datapointsToAlarm : undefined;
            resourceInputs["dimensions"] = args ? args.dimensions : undefined;
            resourceInputs["evaluateLowSampleCountPercentiles"] = args ? args.evaluateLowSampleCountPercentiles : undefined;
            resourceInputs["evaluationPeriods"] = args ? args.evaluationPeriods : undefined;
            resourceInputs["extendedStatistic"] = args ? args.extendedStatistic : undefined;
            resourceInputs["insufficientDataActions"] = args ? args.insufficientDataActions : undefined;
            resourceInputs["metricName"] = args ? args.metricName : undefined;
            resourceInputs["metricQueries"] = args ? args.metricQueries : undefined;
            resourceInputs["name"] = args ? args.name : undefined;
            resourceInputs["namespace"] = args ? args.namespace : undefined;
            resourceInputs["okActions"] = args ? args.okActions : undefined;
            resourceInputs["period"] = args ? args.period : undefined;
            resourceInputs["statistic"] = args ? args.statistic : undefined;
            resourceInputs["tags"] = args ? args.tags : undefined;
            resourceInputs["threshold"] = args ? args.threshold : undefined;
            resourceInputs["thresholdMetricId"] = args ? args.thresholdMetricId : undefined;
            resourceInputs["treatMissingData"] = args ? args.treatMissingData : undefined;
            resourceInputs["unit"] = args ? args.unit : undefined;
            resourceInputs["arn"] = undefined /*out*/;
            resourceInputs["tagsAll"] = undefined /*out*/;
        }
        opts = pulumi.mergeOptions(utilities.resourceOptsDefaults(), opts);
        super(MetricAlarm.__pulumiType, name, resourceInputs, opts);
    }
}

/**
 * Input properties used for looking up and filtering MetricAlarm resources.
 */
export interface MetricAlarmState {
    /**
     * Indicates whether or not actions should be executed during any changes to the alarm's state. Defaults to `true`.
     */
    actionsEnabled?: pulumi.Input<boolean>;
    /**
     * The list of actions to execute when this alarm transitions into an ALARM state from any other state. Each action is specified as an Amazon Resource Name (ARN).
     */
    alarmActions?: pulumi.Input<pulumi.Input<string | Topic>[]>;
    /**
     * The description for the alarm.
     */
    alarmDescription?: pulumi.Input<string>;
    /**
     * The ARN of the CloudWatch Metric Alarm.
     */
    arn?: pulumi.Input<string>;
    /**
     * The arithmetic operation to use when comparing the specified Statistic and Threshold. The specified Statistic value is used as the first operand. Either of the following is supported: `GreaterThanOrEqualToThreshold`, `GreaterThanThreshold`, `LessThanThreshold`, `LessThanOrEqualToThreshold`. Additionally, the values  `LessThanLowerOrGreaterThanUpperThreshold`, `LessThanLowerThreshold`, and `GreaterThanUpperThreshold` are used only for alarms based on anomaly detection models.
     */
    comparisonOperator?: pulumi.Input<string>;
    /**
     * The number of datapoints that must be breaching to trigger the alarm.
     */
    datapointsToAlarm?: pulumi.Input<number>;
    /**
     * The dimensions for the alarm's associated metric.  For the list of available dimensions see the AWS documentation [here](http://docs.aws.amazon.com/AmazonCloudWatch/latest/DeveloperGuide/CW_Support_For_AWS.html).
     */
    dimensions?: pulumi.Input<{[key: string]: pulumi.Input<string>}>;
    /**
     * Used only for alarms based on percentiles.
     * If you specify `ignore`, the alarm state will not change during periods with too few data points to be statistically significant.
     * If you specify `evaluate` or omit this parameter, the alarm will always be evaluated and possibly change state no matter how many data points are available.
     * The following values are supported: `ignore`, and `evaluate`.
     */
    evaluateLowSampleCountPercentiles?: pulumi.Input<string>;
    /**
     * The number of periods over which data is compared to the specified threshold.
     */
    evaluationPeriods?: pulumi.Input<number>;
    /**
     * The percentile statistic for the metric associated with the alarm. Specify a value between p0.0 and p100.
     */
    extendedStatistic?: pulumi.Input<string>;
    /**
     * The list of actions to execute when this alarm transitions into an INSUFFICIENT_DATA state from any other state. Each action is specified as an Amazon Resource Name (ARN).
     */
    insufficientDataActions?: pulumi.Input<pulumi.Input<string | Topic>[]>;
    /**
     * The name for the alarm's associated metric.
     * See docs for [supported metrics](https://docs.aws.amazon.com/AmazonCloudWatch/latest/DeveloperGuide/CW_Support_For_AWS.html).
     */
    metricName?: pulumi.Input<string>;
    /**
     * Enables you to create an alarm based on a metric math expression. You may specify at most 20.
     */
    metricQueries?: pulumi.Input<pulumi.Input<inputs.cloudwatch.MetricAlarmMetricQuery>[]>;
    /**
     * The descriptive name for the alarm. This name must be unique within the user's AWS account
     */
    name?: pulumi.Input<string>;
    /**
     * The namespace for the alarm's associated metric. See docs for the [list of namespaces](https://docs.aws.amazon.com/AmazonCloudWatch/latest/DeveloperGuide/aws-namespaces.html).
     * See docs for [supported metrics](https://docs.aws.amazon.com/AmazonCloudWatch/latest/DeveloperGuide/CW_Support_For_AWS.html).
     */
    namespace?: pulumi.Input<string>;
    /**
     * The list of actions to execute when this alarm transitions into an OK state from any other state. Each action is specified as an Amazon Resource Name (ARN).
     */
    okActions?: pulumi.Input<pulumi.Input<string | Topic>[]>;
    /**
     * The period in seconds over which the specified `statistic` is applied.
     * Valid values are `10`, `20`, `30`, or any multiple of `60`.
     */
    period?: pulumi.Input<number>;
    /**
     * The statistic to apply to the alarm's associated metric.
     * Either of the following is supported: `SampleCount`, `Average`, `Sum`, `Minimum`, `Maximum`
     */
    statistic?: pulumi.Input<string>;
    /**
     * A map of tags to assign to the resource. .If configured with a provider `defaultTags` configuration block present, tags with matching keys will overwrite those defined at the provider-level.
     *
     * See [related part of AWS Docs](https://docs.aws.amazon.com/AmazonCloudWatch/latest/APIReference/API_PutMetricAlarm.html)
     * for details about valid values.
     *
     * > **NOTE:**  If you specify at least one `metricQuery`, you may not specify a `metricName`, `namespace`, `period` or `statistic`. If you do not specify a `metricQuery`, you must specify each of these (although you may use `extendedStatistic` instead of `statistic`).
     */
    tags?: pulumi.Input<{[key: string]: pulumi.Input<string>}>;
    /**
     * A map of tags assigned to the resource, including those inherited from the provider `defaultTags` configuration block.
     *
     * @deprecated Please use `tags` instead.
     */
    tagsAll?: pulumi.Input<{[key: string]: pulumi.Input<string>}>;
    /**
     * The value against which the specified statistic is compared. This parameter is required for alarms based on static thresholds, but should not be used for alarms based on anomaly detection models.
     */
    threshold?: pulumi.Input<number>;
    /**
     * If this is an alarm based on an anomaly detection model, make this value match the ID of the ANOMALY_DETECTION_BAND function.
     */
    thresholdMetricId?: pulumi.Input<string>;
    /**
     * Sets how this alarm is to handle missing data points. The following values are supported: `missing`, `ignore`, `breaching` and `notBreaching`. Defaults to `missing`.
     */
    treatMissingData?: pulumi.Input<string>;
    /**
     * The unit for the alarm's associated metric.
     */
    unit?: pulumi.Input<string>;
}

/**
 * The set of arguments for constructing a MetricAlarm resource.
 */
export interface MetricAlarmArgs {
    /**
     * Indicates whether or not actions should be executed during any changes to the alarm's state. Defaults to `true`.
     */
    actionsEnabled?: pulumi.Input<boolean>;
    /**
     * The list of actions to execute when this alarm transitions into an ALARM state from any other state. Each action is specified as an Amazon Resource Name (ARN).
     */
    alarmActions?: pulumi.Input<pulumi.Input<string | Topic>[]>;
    /**
     * The description for the alarm.
     */
    alarmDescription?: pulumi.Input<string>;
    /**
     * The arithmetic operation to use when comparing the specified Statistic and Threshold. The specified Statistic value is used as the first operand. Either of the following is supported: `GreaterThanOrEqualToThreshold`, `GreaterThanThreshold`, `LessThanThreshold`, `LessThanOrEqualToThreshold`. Additionally, the values  `LessThanLowerOrGreaterThanUpperThreshold`, `LessThanLowerThreshold`, and `GreaterThanUpperThreshold` are used only for alarms based on anomaly detection models.
     */
    comparisonOperator: pulumi.Input<string>;
    /**
     * The number of datapoints that must be breaching to trigger the alarm.
     */
    datapointsToAlarm?: pulumi.Input<number>;
    /**
     * The dimensions for the alarm's associated metric.  For the list of available dimensions see the AWS documentation [here](http://docs.aws.amazon.com/AmazonCloudWatch/latest/DeveloperGuide/CW_Support_For_AWS.html).
     */
    dimensions?: pulumi.Input<{[key: string]: pulumi.Input<string>}>;
    /**
     * Used only for alarms based on percentiles.
     * If you specify `ignore`, the alarm state will not change during periods with too few data points to be statistically significant.
     * If you specify `evaluate` or omit this parameter, the alarm will always be evaluated and possibly change state no matter how many data points are available.
     * The following values are supported: `ignore`, and `evaluate`.
     */
    evaluateLowSampleCountPercentiles?: pulumi.Input<string>;
    /**
     * The number of periods over which data is compared to the specified threshold.
     */
    evaluationPeriods: pulumi.Input<number>;
    /**
     * The percentile statistic for the metric associated with the alarm. Specify a value between p0.0 and p100.
     */
    extendedStatistic?: pulumi.Input<string>;
    /**
     * The list of actions to execute when this alarm transitions into an INSUFFICIENT_DATA state from any other state. Each action is specified as an Amazon Resource Name (ARN).
     */
    insufficientDataActions?: pulumi.Input<pulumi.Input<string | Topic>[]>;
    /**
     * The name for the alarm's associated metric.
     * See docs for [supported metrics](https://docs.aws.amazon.com/AmazonCloudWatch/latest/DeveloperGuide/CW_Support_For_AWS.html).
     */
    metricName?: pulumi.Input<string>;
    /**
     * Enables you to create an alarm based on a metric math expression. You may specify at most 20.
     */
    metricQueries?: pulumi.Input<pulumi.Input<inputs.cloudwatch.MetricAlarmMetricQuery>[]>;
    /**
     * The descriptive name for the alarm. This name must be unique within the user's AWS account
     */
    name?: pulumi.Input<string>;
    /**
     * The namespace for the alarm's associated metric. See docs for the [list of namespaces](https://docs.aws.amazon.com/AmazonCloudWatch/latest/DeveloperGuide/aws-namespaces.html).
     * See docs for [supported metrics](https://docs.aws.amazon.com/AmazonCloudWatch/latest/DeveloperGuide/CW_Support_For_AWS.html).
     */
    namespace?: pulumi.Input<string>;
    /**
     * The list of actions to execute when this alarm transitions into an OK state from any other state. Each action is specified as an Amazon Resource Name (ARN).
     */
    okActions?: pulumi.Input<pulumi.Input<string | Topic>[]>;
    /**
     * The period in seconds over which the specified `statistic` is applied.
     * Valid values are `10`, `20`, `30`, or any multiple of `60`.
     */
    period?: pulumi.Input<number>;
    /**
     * The statistic to apply to the alarm's associated metric.
     * Either of the following is supported: `SampleCount`, `Average`, `Sum`, `Minimum`, `Maximum`
     */
    statistic?: pulumi.Input<string>;
    /**
     * A map of tags to assign to the resource. .If configured with a provider `defaultTags` configuration block present, tags with matching keys will overwrite those defined at the provider-level.
     *
     * See [related part of AWS Docs](https://docs.aws.amazon.com/AmazonCloudWatch/latest/APIReference/API_PutMetricAlarm.html)
     * for details about valid values.
     *
     * > **NOTE:**  If you specify at least one `metricQuery`, you may not specify a `metricName`, `namespace`, `period` or `statistic`. If you do not specify a `metricQuery`, you must specify each of these (although you may use `extendedStatistic` instead of `statistic`).
     */
    tags?: pulumi.Input<{[key: string]: pulumi.Input<string>}>;
    /**
     * The value against which the specified statistic is compared. This parameter is required for alarms based on static thresholds, but should not be used for alarms based on anomaly detection models.
     */
    threshold?: pulumi.Input<number>;
    /**
     * If this is an alarm based on an anomaly detection model, make this value match the ID of the ANOMALY_DETECTION_BAND function.
     */
    thresholdMetricId?: pulumi.Input<string>;
    /**
     * Sets how this alarm is to handle missing data points. The following values are supported: `missing`, `ignore`, `breaching` and `notBreaching`. Defaults to `missing`.
     */
    treatMissingData?: pulumi.Input<string>;
    /**
     * The unit for the alarm's associated metric.
     */
    unit?: pulumi.Input<string>;
}
