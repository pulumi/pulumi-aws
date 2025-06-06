# coding=utf-8
# *** WARNING: this file was generated by pulumi-language-python. ***
# *** Do not edit by hand unless you're certain you know what you are doing! ***

import builtins
import copy
import warnings
import sys
import pulumi
import pulumi.runtime
from typing import Any, Mapping, Optional, Sequence, Union, overload
if sys.version_info >= (3, 11):
    from typing import NotRequired, TypedDict, TypeAlias
else:
    from typing_extensions import NotRequired, TypedDict, TypeAlias
from .. import _utilities

__all__ = [
    'FeatureEvaluationRuleArgs',
    'FeatureEvaluationRuleArgsDict',
    'FeatureVariationArgs',
    'FeatureVariationArgsDict',
    'FeatureVariationValueArgs',
    'FeatureVariationValueArgsDict',
    'LaunchExecutionArgs',
    'LaunchExecutionArgsDict',
    'LaunchGroupArgs',
    'LaunchGroupArgsDict',
    'LaunchMetricMonitorArgs',
    'LaunchMetricMonitorArgsDict',
    'LaunchMetricMonitorMetricDefinitionArgs',
    'LaunchMetricMonitorMetricDefinitionArgsDict',
    'LaunchScheduledSplitsConfigArgs',
    'LaunchScheduledSplitsConfigArgsDict',
    'LaunchScheduledSplitsConfigStepArgs',
    'LaunchScheduledSplitsConfigStepArgsDict',
    'LaunchScheduledSplitsConfigStepSegmentOverrideArgs',
    'LaunchScheduledSplitsConfigStepSegmentOverrideArgsDict',
    'ProjectDataDeliveryArgs',
    'ProjectDataDeliveryArgsDict',
    'ProjectDataDeliveryCloudwatchLogsArgs',
    'ProjectDataDeliveryCloudwatchLogsArgsDict',
    'ProjectDataDeliveryS3DestinationArgs',
    'ProjectDataDeliveryS3DestinationArgsDict',
]

MYPY = False

if not MYPY:
    class FeatureEvaluationRuleArgsDict(TypedDict):
        name: NotRequired[pulumi.Input[builtins.str]]
        """
        The name for the new feature. Minimum length of `1`. Maximum length of `127`.
        """
        type: NotRequired[pulumi.Input[builtins.str]]
        """
        This value is `aws.evidently.splits` if this is an evaluation rule for a launch, and it is `aws.evidently.onlineab` if this is an evaluation rule for an experiment.
        """
elif False:
    FeatureEvaluationRuleArgsDict: TypeAlias = Mapping[str, Any]

@pulumi.input_type
class FeatureEvaluationRuleArgs:
    def __init__(__self__, *,
                 name: Optional[pulumi.Input[builtins.str]] = None,
                 type: Optional[pulumi.Input[builtins.str]] = None):
        """
        :param pulumi.Input[builtins.str] name: The name for the new feature. Minimum length of `1`. Maximum length of `127`.
        :param pulumi.Input[builtins.str] type: This value is `aws.evidently.splits` if this is an evaluation rule for a launch, and it is `aws.evidently.onlineab` if this is an evaluation rule for an experiment.
        """
        if name is not None:
            pulumi.set(__self__, "name", name)
        if type is not None:
            pulumi.set(__self__, "type", type)

    @property
    @pulumi.getter
    def name(self) -> Optional[pulumi.Input[builtins.str]]:
        """
        The name for the new feature. Minimum length of `1`. Maximum length of `127`.
        """
        return pulumi.get(self, "name")

    @name.setter
    def name(self, value: Optional[pulumi.Input[builtins.str]]):
        pulumi.set(self, "name", value)

    @property
    @pulumi.getter
    def type(self) -> Optional[pulumi.Input[builtins.str]]:
        """
        This value is `aws.evidently.splits` if this is an evaluation rule for a launch, and it is `aws.evidently.onlineab` if this is an evaluation rule for an experiment.
        """
        return pulumi.get(self, "type")

    @type.setter
    def type(self, value: Optional[pulumi.Input[builtins.str]]):
        pulumi.set(self, "type", value)


if not MYPY:
    class FeatureVariationArgsDict(TypedDict):
        name: pulumi.Input[builtins.str]
        """
        The name of the variation. Minimum length of `1`. Maximum length of `127`.
        """
        value: pulumi.Input['FeatureVariationValueArgsDict']
        """
        A block that specifies the value assigned to this variation. Detailed below
        """
elif False:
    FeatureVariationArgsDict: TypeAlias = Mapping[str, Any]

@pulumi.input_type
class FeatureVariationArgs:
    def __init__(__self__, *,
                 name: pulumi.Input[builtins.str],
                 value: pulumi.Input['FeatureVariationValueArgs']):
        """
        :param pulumi.Input[builtins.str] name: The name of the variation. Minimum length of `1`. Maximum length of `127`.
        :param pulumi.Input['FeatureVariationValueArgs'] value: A block that specifies the value assigned to this variation. Detailed below
        """
        pulumi.set(__self__, "name", name)
        pulumi.set(__self__, "value", value)

    @property
    @pulumi.getter
    def name(self) -> pulumi.Input[builtins.str]:
        """
        The name of the variation. Minimum length of `1`. Maximum length of `127`.
        """
        return pulumi.get(self, "name")

    @name.setter
    def name(self, value: pulumi.Input[builtins.str]):
        pulumi.set(self, "name", value)

    @property
    @pulumi.getter
    def value(self) -> pulumi.Input['FeatureVariationValueArgs']:
        """
        A block that specifies the value assigned to this variation. Detailed below
        """
        return pulumi.get(self, "value")

    @value.setter
    def value(self, value: pulumi.Input['FeatureVariationValueArgs']):
        pulumi.set(self, "value", value)


if not MYPY:
    class FeatureVariationValueArgsDict(TypedDict):
        bool_value: NotRequired[pulumi.Input[builtins.str]]
        """
        If this feature uses the Boolean variation type, this field contains the Boolean value of this variation.
        """
        double_value: NotRequired[pulumi.Input[builtins.str]]
        """
        If this feature uses the double integer variation type, this field contains the double integer value of this variation.
        """
        long_value: NotRequired[pulumi.Input[builtins.str]]
        """
        If this feature uses the long variation type, this field contains the long value of this variation. Minimum value of `-9007199254740991`. Maximum value of `9007199254740991`.
        """
        string_value: NotRequired[pulumi.Input[builtins.str]]
        """
        If this feature uses the string variation type, this field contains the string value of this variation. Minimum length of `0`. Maximum length of `512`.
        """
elif False:
    FeatureVariationValueArgsDict: TypeAlias = Mapping[str, Any]

@pulumi.input_type
class FeatureVariationValueArgs:
    def __init__(__self__, *,
                 bool_value: Optional[pulumi.Input[builtins.str]] = None,
                 double_value: Optional[pulumi.Input[builtins.str]] = None,
                 long_value: Optional[pulumi.Input[builtins.str]] = None,
                 string_value: Optional[pulumi.Input[builtins.str]] = None):
        """
        :param pulumi.Input[builtins.str] bool_value: If this feature uses the Boolean variation type, this field contains the Boolean value of this variation.
        :param pulumi.Input[builtins.str] double_value: If this feature uses the double integer variation type, this field contains the double integer value of this variation.
        :param pulumi.Input[builtins.str] long_value: If this feature uses the long variation type, this field contains the long value of this variation. Minimum value of `-9007199254740991`. Maximum value of `9007199254740991`.
        :param pulumi.Input[builtins.str] string_value: If this feature uses the string variation type, this field contains the string value of this variation. Minimum length of `0`. Maximum length of `512`.
        """
        if bool_value is not None:
            pulumi.set(__self__, "bool_value", bool_value)
        if double_value is not None:
            pulumi.set(__self__, "double_value", double_value)
        if long_value is not None:
            pulumi.set(__self__, "long_value", long_value)
        if string_value is not None:
            pulumi.set(__self__, "string_value", string_value)

    @property
    @pulumi.getter(name="boolValue")
    def bool_value(self) -> Optional[pulumi.Input[builtins.str]]:
        """
        If this feature uses the Boolean variation type, this field contains the Boolean value of this variation.
        """
        return pulumi.get(self, "bool_value")

    @bool_value.setter
    def bool_value(self, value: Optional[pulumi.Input[builtins.str]]):
        pulumi.set(self, "bool_value", value)

    @property
    @pulumi.getter(name="doubleValue")
    def double_value(self) -> Optional[pulumi.Input[builtins.str]]:
        """
        If this feature uses the double integer variation type, this field contains the double integer value of this variation.
        """
        return pulumi.get(self, "double_value")

    @double_value.setter
    def double_value(self, value: Optional[pulumi.Input[builtins.str]]):
        pulumi.set(self, "double_value", value)

    @property
    @pulumi.getter(name="longValue")
    def long_value(self) -> Optional[pulumi.Input[builtins.str]]:
        """
        If this feature uses the long variation type, this field contains the long value of this variation. Minimum value of `-9007199254740991`. Maximum value of `9007199254740991`.
        """
        return pulumi.get(self, "long_value")

    @long_value.setter
    def long_value(self, value: Optional[pulumi.Input[builtins.str]]):
        pulumi.set(self, "long_value", value)

    @property
    @pulumi.getter(name="stringValue")
    def string_value(self) -> Optional[pulumi.Input[builtins.str]]:
        """
        If this feature uses the string variation type, this field contains the string value of this variation. Minimum length of `0`. Maximum length of `512`.
        """
        return pulumi.get(self, "string_value")

    @string_value.setter
    def string_value(self, value: Optional[pulumi.Input[builtins.str]]):
        pulumi.set(self, "string_value", value)


if not MYPY:
    class LaunchExecutionArgsDict(TypedDict):
        ended_time: NotRequired[pulumi.Input[builtins.str]]
        """
        The date and time that the launch ended.
        """
        started_time: NotRequired[pulumi.Input[builtins.str]]
        """
        The date and time that the launch started.
        """
elif False:
    LaunchExecutionArgsDict: TypeAlias = Mapping[str, Any]

@pulumi.input_type
class LaunchExecutionArgs:
    def __init__(__self__, *,
                 ended_time: Optional[pulumi.Input[builtins.str]] = None,
                 started_time: Optional[pulumi.Input[builtins.str]] = None):
        """
        :param pulumi.Input[builtins.str] ended_time: The date and time that the launch ended.
        :param pulumi.Input[builtins.str] started_time: The date and time that the launch started.
        """
        if ended_time is not None:
            pulumi.set(__self__, "ended_time", ended_time)
        if started_time is not None:
            pulumi.set(__self__, "started_time", started_time)

    @property
    @pulumi.getter(name="endedTime")
    def ended_time(self) -> Optional[pulumi.Input[builtins.str]]:
        """
        The date and time that the launch ended.
        """
        return pulumi.get(self, "ended_time")

    @ended_time.setter
    def ended_time(self, value: Optional[pulumi.Input[builtins.str]]):
        pulumi.set(self, "ended_time", value)

    @property
    @pulumi.getter(name="startedTime")
    def started_time(self) -> Optional[pulumi.Input[builtins.str]]:
        """
        The date and time that the launch started.
        """
        return pulumi.get(self, "started_time")

    @started_time.setter
    def started_time(self, value: Optional[pulumi.Input[builtins.str]]):
        pulumi.set(self, "started_time", value)


if not MYPY:
    class LaunchGroupArgsDict(TypedDict):
        feature: pulumi.Input[builtins.str]
        """
        Specifies the name of the feature that the launch is using.
        """
        name: pulumi.Input[builtins.str]
        """
        Specifies the name of the lahnch group.
        """
        variation: pulumi.Input[builtins.str]
        """
        Specifies the feature variation to use for this launch group.
        """
        description: NotRequired[pulumi.Input[builtins.str]]
        """
        Specifies the description of the launch group.
        """
elif False:
    LaunchGroupArgsDict: TypeAlias = Mapping[str, Any]

@pulumi.input_type
class LaunchGroupArgs:
    def __init__(__self__, *,
                 feature: pulumi.Input[builtins.str],
                 name: pulumi.Input[builtins.str],
                 variation: pulumi.Input[builtins.str],
                 description: Optional[pulumi.Input[builtins.str]] = None):
        """
        :param pulumi.Input[builtins.str] feature: Specifies the name of the feature that the launch is using.
        :param pulumi.Input[builtins.str] name: Specifies the name of the lahnch group.
        :param pulumi.Input[builtins.str] variation: Specifies the feature variation to use for this launch group.
        :param pulumi.Input[builtins.str] description: Specifies the description of the launch group.
        """
        pulumi.set(__self__, "feature", feature)
        pulumi.set(__self__, "name", name)
        pulumi.set(__self__, "variation", variation)
        if description is not None:
            pulumi.set(__self__, "description", description)

    @property
    @pulumi.getter
    def feature(self) -> pulumi.Input[builtins.str]:
        """
        Specifies the name of the feature that the launch is using.
        """
        return pulumi.get(self, "feature")

    @feature.setter
    def feature(self, value: pulumi.Input[builtins.str]):
        pulumi.set(self, "feature", value)

    @property
    @pulumi.getter
    def name(self) -> pulumi.Input[builtins.str]:
        """
        Specifies the name of the lahnch group.
        """
        return pulumi.get(self, "name")

    @name.setter
    def name(self, value: pulumi.Input[builtins.str]):
        pulumi.set(self, "name", value)

    @property
    @pulumi.getter
    def variation(self) -> pulumi.Input[builtins.str]:
        """
        Specifies the feature variation to use for this launch group.
        """
        return pulumi.get(self, "variation")

    @variation.setter
    def variation(self, value: pulumi.Input[builtins.str]):
        pulumi.set(self, "variation", value)

    @property
    @pulumi.getter
    def description(self) -> Optional[pulumi.Input[builtins.str]]:
        """
        Specifies the description of the launch group.
        """
        return pulumi.get(self, "description")

    @description.setter
    def description(self, value: Optional[pulumi.Input[builtins.str]]):
        pulumi.set(self, "description", value)


if not MYPY:
    class LaunchMetricMonitorArgsDict(TypedDict):
        metric_definition: pulumi.Input['LaunchMetricMonitorMetricDefinitionArgsDict']
        """
        A block that defines the metric. Detailed below.
        """
elif False:
    LaunchMetricMonitorArgsDict: TypeAlias = Mapping[str, Any]

@pulumi.input_type
class LaunchMetricMonitorArgs:
    def __init__(__self__, *,
                 metric_definition: pulumi.Input['LaunchMetricMonitorMetricDefinitionArgs']):
        """
        :param pulumi.Input['LaunchMetricMonitorMetricDefinitionArgs'] metric_definition: A block that defines the metric. Detailed below.
        """
        pulumi.set(__self__, "metric_definition", metric_definition)

    @property
    @pulumi.getter(name="metricDefinition")
    def metric_definition(self) -> pulumi.Input['LaunchMetricMonitorMetricDefinitionArgs']:
        """
        A block that defines the metric. Detailed below.
        """
        return pulumi.get(self, "metric_definition")

    @metric_definition.setter
    def metric_definition(self, value: pulumi.Input['LaunchMetricMonitorMetricDefinitionArgs']):
        pulumi.set(self, "metric_definition", value)


if not MYPY:
    class LaunchMetricMonitorMetricDefinitionArgsDict(TypedDict):
        entity_id_key: pulumi.Input[builtins.str]
        """
        Specifies the entity, such as a user or session, that does an action that causes a metric value to be recorded. An example is `userDetails.userID`.
        """
        name: pulumi.Input[builtins.str]
        """
        Specifies the name for the metric.
        """
        value_key: pulumi.Input[builtins.str]
        """
        Specifies the value that is tracked to produce the metric.
        """
        event_pattern: NotRequired[pulumi.Input[builtins.str]]
        """
        Specifies The EventBridge event pattern that defines how the metric is recorded.
        """
        unit_label: NotRequired[pulumi.Input[builtins.str]]
        """
        Specifies a label for the units that the metric is measuring.
        """
elif False:
    LaunchMetricMonitorMetricDefinitionArgsDict: TypeAlias = Mapping[str, Any]

@pulumi.input_type
class LaunchMetricMonitorMetricDefinitionArgs:
    def __init__(__self__, *,
                 entity_id_key: pulumi.Input[builtins.str],
                 name: pulumi.Input[builtins.str],
                 value_key: pulumi.Input[builtins.str],
                 event_pattern: Optional[pulumi.Input[builtins.str]] = None,
                 unit_label: Optional[pulumi.Input[builtins.str]] = None):
        """
        :param pulumi.Input[builtins.str] entity_id_key: Specifies the entity, such as a user or session, that does an action that causes a metric value to be recorded. An example is `userDetails.userID`.
        :param pulumi.Input[builtins.str] name: Specifies the name for the metric.
        :param pulumi.Input[builtins.str] value_key: Specifies the value that is tracked to produce the metric.
        :param pulumi.Input[builtins.str] event_pattern: Specifies The EventBridge event pattern that defines how the metric is recorded.
        :param pulumi.Input[builtins.str] unit_label: Specifies a label for the units that the metric is measuring.
        """
        pulumi.set(__self__, "entity_id_key", entity_id_key)
        pulumi.set(__self__, "name", name)
        pulumi.set(__self__, "value_key", value_key)
        if event_pattern is not None:
            pulumi.set(__self__, "event_pattern", event_pattern)
        if unit_label is not None:
            pulumi.set(__self__, "unit_label", unit_label)

    @property
    @pulumi.getter(name="entityIdKey")
    def entity_id_key(self) -> pulumi.Input[builtins.str]:
        """
        Specifies the entity, such as a user or session, that does an action that causes a metric value to be recorded. An example is `userDetails.userID`.
        """
        return pulumi.get(self, "entity_id_key")

    @entity_id_key.setter
    def entity_id_key(self, value: pulumi.Input[builtins.str]):
        pulumi.set(self, "entity_id_key", value)

    @property
    @pulumi.getter
    def name(self) -> pulumi.Input[builtins.str]:
        """
        Specifies the name for the metric.
        """
        return pulumi.get(self, "name")

    @name.setter
    def name(self, value: pulumi.Input[builtins.str]):
        pulumi.set(self, "name", value)

    @property
    @pulumi.getter(name="valueKey")
    def value_key(self) -> pulumi.Input[builtins.str]:
        """
        Specifies the value that is tracked to produce the metric.
        """
        return pulumi.get(self, "value_key")

    @value_key.setter
    def value_key(self, value: pulumi.Input[builtins.str]):
        pulumi.set(self, "value_key", value)

    @property
    @pulumi.getter(name="eventPattern")
    def event_pattern(self) -> Optional[pulumi.Input[builtins.str]]:
        """
        Specifies The EventBridge event pattern that defines how the metric is recorded.
        """
        return pulumi.get(self, "event_pattern")

    @event_pattern.setter
    def event_pattern(self, value: Optional[pulumi.Input[builtins.str]]):
        pulumi.set(self, "event_pattern", value)

    @property
    @pulumi.getter(name="unitLabel")
    def unit_label(self) -> Optional[pulumi.Input[builtins.str]]:
        """
        Specifies a label for the units that the metric is measuring.
        """
        return pulumi.get(self, "unit_label")

    @unit_label.setter
    def unit_label(self, value: Optional[pulumi.Input[builtins.str]]):
        pulumi.set(self, "unit_label", value)


if not MYPY:
    class LaunchScheduledSplitsConfigArgsDict(TypedDict):
        steps: pulumi.Input[Sequence[pulumi.Input['LaunchScheduledSplitsConfigStepArgsDict']]]
        """
        One or up to six blocks that define the traffic allocation percentages among the feature variations during each step of the launch. This also defines the start time of each step. Detailed below.
        """
elif False:
    LaunchScheduledSplitsConfigArgsDict: TypeAlias = Mapping[str, Any]

@pulumi.input_type
class LaunchScheduledSplitsConfigArgs:
    def __init__(__self__, *,
                 steps: pulumi.Input[Sequence[pulumi.Input['LaunchScheduledSplitsConfigStepArgs']]]):
        """
        :param pulumi.Input[Sequence[pulumi.Input['LaunchScheduledSplitsConfigStepArgs']]] steps: One or up to six blocks that define the traffic allocation percentages among the feature variations during each step of the launch. This also defines the start time of each step. Detailed below.
        """
        pulumi.set(__self__, "steps", steps)

    @property
    @pulumi.getter
    def steps(self) -> pulumi.Input[Sequence[pulumi.Input['LaunchScheduledSplitsConfigStepArgs']]]:
        """
        One or up to six blocks that define the traffic allocation percentages among the feature variations during each step of the launch. This also defines the start time of each step. Detailed below.
        """
        return pulumi.get(self, "steps")

    @steps.setter
    def steps(self, value: pulumi.Input[Sequence[pulumi.Input['LaunchScheduledSplitsConfigStepArgs']]]):
        pulumi.set(self, "steps", value)


if not MYPY:
    class LaunchScheduledSplitsConfigStepArgsDict(TypedDict):
        group_weights: pulumi.Input[Mapping[str, pulumi.Input[builtins.int]]]
        """
        The traffic allocation percentages among the feature variations during one step of a launch. This is a set of key-value pairs. The keys are variation names. The values represent the percentage of traffic to allocate to that variation during this step. For more information, refer to the [AWS documentation for ScheduledSplitConfig groupWeights](https://docs.aws.amazon.com/cloudwatchevidently/latest/APIReference/API_ScheduledSplitConfig.html).
        """
        start_time: pulumi.Input[builtins.str]
        """
        Specifies the date and time that this step of the launch starts.
        """
        segment_overrides: NotRequired[pulumi.Input[Sequence[pulumi.Input['LaunchScheduledSplitsConfigStepSegmentOverrideArgsDict']]]]
        """
        One or up to six blocks that specify different traffic splits for one or more audience segments. A segment is a portion of your audience that share one or more characteristics. Examples could be Chrome browser users, users in Europe, or Firefox browser users in Europe who also fit other criteria that your application collects, such as age. Detailed below.
        """
elif False:
    LaunchScheduledSplitsConfigStepArgsDict: TypeAlias = Mapping[str, Any]

@pulumi.input_type
class LaunchScheduledSplitsConfigStepArgs:
    def __init__(__self__, *,
                 group_weights: pulumi.Input[Mapping[str, pulumi.Input[builtins.int]]],
                 start_time: pulumi.Input[builtins.str],
                 segment_overrides: Optional[pulumi.Input[Sequence[pulumi.Input['LaunchScheduledSplitsConfigStepSegmentOverrideArgs']]]] = None):
        """
        :param pulumi.Input[Mapping[str, pulumi.Input[builtins.int]]] group_weights: The traffic allocation percentages among the feature variations during one step of a launch. This is a set of key-value pairs. The keys are variation names. The values represent the percentage of traffic to allocate to that variation during this step. For more information, refer to the [AWS documentation for ScheduledSplitConfig groupWeights](https://docs.aws.amazon.com/cloudwatchevidently/latest/APIReference/API_ScheduledSplitConfig.html).
        :param pulumi.Input[builtins.str] start_time: Specifies the date and time that this step of the launch starts.
        :param pulumi.Input[Sequence[pulumi.Input['LaunchScheduledSplitsConfigStepSegmentOverrideArgs']]] segment_overrides: One or up to six blocks that specify different traffic splits for one or more audience segments. A segment is a portion of your audience that share one or more characteristics. Examples could be Chrome browser users, users in Europe, or Firefox browser users in Europe who also fit other criteria that your application collects, such as age. Detailed below.
        """
        pulumi.set(__self__, "group_weights", group_weights)
        pulumi.set(__self__, "start_time", start_time)
        if segment_overrides is not None:
            pulumi.set(__self__, "segment_overrides", segment_overrides)

    @property
    @pulumi.getter(name="groupWeights")
    def group_weights(self) -> pulumi.Input[Mapping[str, pulumi.Input[builtins.int]]]:
        """
        The traffic allocation percentages among the feature variations during one step of a launch. This is a set of key-value pairs. The keys are variation names. The values represent the percentage of traffic to allocate to that variation during this step. For more information, refer to the [AWS documentation for ScheduledSplitConfig groupWeights](https://docs.aws.amazon.com/cloudwatchevidently/latest/APIReference/API_ScheduledSplitConfig.html).
        """
        return pulumi.get(self, "group_weights")

    @group_weights.setter
    def group_weights(self, value: pulumi.Input[Mapping[str, pulumi.Input[builtins.int]]]):
        pulumi.set(self, "group_weights", value)

    @property
    @pulumi.getter(name="startTime")
    def start_time(self) -> pulumi.Input[builtins.str]:
        """
        Specifies the date and time that this step of the launch starts.
        """
        return pulumi.get(self, "start_time")

    @start_time.setter
    def start_time(self, value: pulumi.Input[builtins.str]):
        pulumi.set(self, "start_time", value)

    @property
    @pulumi.getter(name="segmentOverrides")
    def segment_overrides(self) -> Optional[pulumi.Input[Sequence[pulumi.Input['LaunchScheduledSplitsConfigStepSegmentOverrideArgs']]]]:
        """
        One or up to six blocks that specify different traffic splits for one or more audience segments. A segment is a portion of your audience that share one or more characteristics. Examples could be Chrome browser users, users in Europe, or Firefox browser users in Europe who also fit other criteria that your application collects, such as age. Detailed below.
        """
        return pulumi.get(self, "segment_overrides")

    @segment_overrides.setter
    def segment_overrides(self, value: Optional[pulumi.Input[Sequence[pulumi.Input['LaunchScheduledSplitsConfigStepSegmentOverrideArgs']]]]):
        pulumi.set(self, "segment_overrides", value)


if not MYPY:
    class LaunchScheduledSplitsConfigStepSegmentOverrideArgsDict(TypedDict):
        evaluation_order: pulumi.Input[builtins.int]
        """
        Specifies a number indicating the order to use to evaluate segment overrides, if there are more than one. Segment overrides with lower numbers are evaluated first.
        """
        segment: pulumi.Input[builtins.str]
        """
        The name or ARN of the segment to use.
        """
        weights: pulumi.Input[Mapping[str, pulumi.Input[builtins.int]]]
        """
        The traffic allocation percentages among the feature variations to assign to this segment. This is a set of key-value pairs. The keys are variation names. The values represent the amount of traffic to allocate to that variation for this segment. This is expressed in thousandths of a percent, so a weight of 50000 represents 50% of traffic.
        """
elif False:
    LaunchScheduledSplitsConfigStepSegmentOverrideArgsDict: TypeAlias = Mapping[str, Any]

@pulumi.input_type
class LaunchScheduledSplitsConfigStepSegmentOverrideArgs:
    def __init__(__self__, *,
                 evaluation_order: pulumi.Input[builtins.int],
                 segment: pulumi.Input[builtins.str],
                 weights: pulumi.Input[Mapping[str, pulumi.Input[builtins.int]]]):
        """
        :param pulumi.Input[builtins.int] evaluation_order: Specifies a number indicating the order to use to evaluate segment overrides, if there are more than one. Segment overrides with lower numbers are evaluated first.
        :param pulumi.Input[builtins.str] segment: The name or ARN of the segment to use.
        :param pulumi.Input[Mapping[str, pulumi.Input[builtins.int]]] weights: The traffic allocation percentages among the feature variations to assign to this segment. This is a set of key-value pairs. The keys are variation names. The values represent the amount of traffic to allocate to that variation for this segment. This is expressed in thousandths of a percent, so a weight of 50000 represents 50% of traffic.
        """
        pulumi.set(__self__, "evaluation_order", evaluation_order)
        pulumi.set(__self__, "segment", segment)
        pulumi.set(__self__, "weights", weights)

    @property
    @pulumi.getter(name="evaluationOrder")
    def evaluation_order(self) -> pulumi.Input[builtins.int]:
        """
        Specifies a number indicating the order to use to evaluate segment overrides, if there are more than one. Segment overrides with lower numbers are evaluated first.
        """
        return pulumi.get(self, "evaluation_order")

    @evaluation_order.setter
    def evaluation_order(self, value: pulumi.Input[builtins.int]):
        pulumi.set(self, "evaluation_order", value)

    @property
    @pulumi.getter
    def segment(self) -> pulumi.Input[builtins.str]:
        """
        The name or ARN of the segment to use.
        """
        return pulumi.get(self, "segment")

    @segment.setter
    def segment(self, value: pulumi.Input[builtins.str]):
        pulumi.set(self, "segment", value)

    @property
    @pulumi.getter
    def weights(self) -> pulumi.Input[Mapping[str, pulumi.Input[builtins.int]]]:
        """
        The traffic allocation percentages among the feature variations to assign to this segment. This is a set of key-value pairs. The keys are variation names. The values represent the amount of traffic to allocate to that variation for this segment. This is expressed in thousandths of a percent, so a weight of 50000 represents 50% of traffic.
        """
        return pulumi.get(self, "weights")

    @weights.setter
    def weights(self, value: pulumi.Input[Mapping[str, pulumi.Input[builtins.int]]]):
        pulumi.set(self, "weights", value)


if not MYPY:
    class ProjectDataDeliveryArgsDict(TypedDict):
        cloudwatch_logs: NotRequired[pulumi.Input['ProjectDataDeliveryCloudwatchLogsArgsDict']]
        """
        A block that defines the CloudWatch Log Group that stores the evaluation events. See below.
        """
        s3_destination: NotRequired[pulumi.Input['ProjectDataDeliveryS3DestinationArgsDict']]
        """
        A block that defines the S3 bucket and prefix that stores the evaluation events. See below.
        """
elif False:
    ProjectDataDeliveryArgsDict: TypeAlias = Mapping[str, Any]

@pulumi.input_type
class ProjectDataDeliveryArgs:
    def __init__(__self__, *,
                 cloudwatch_logs: Optional[pulumi.Input['ProjectDataDeliveryCloudwatchLogsArgs']] = None,
                 s3_destination: Optional[pulumi.Input['ProjectDataDeliveryS3DestinationArgs']] = None):
        """
        :param pulumi.Input['ProjectDataDeliveryCloudwatchLogsArgs'] cloudwatch_logs: A block that defines the CloudWatch Log Group that stores the evaluation events. See below.
        :param pulumi.Input['ProjectDataDeliveryS3DestinationArgs'] s3_destination: A block that defines the S3 bucket and prefix that stores the evaluation events. See below.
        """
        if cloudwatch_logs is not None:
            pulumi.set(__self__, "cloudwatch_logs", cloudwatch_logs)
        if s3_destination is not None:
            pulumi.set(__self__, "s3_destination", s3_destination)

    @property
    @pulumi.getter(name="cloudwatchLogs")
    def cloudwatch_logs(self) -> Optional[pulumi.Input['ProjectDataDeliveryCloudwatchLogsArgs']]:
        """
        A block that defines the CloudWatch Log Group that stores the evaluation events. See below.
        """
        return pulumi.get(self, "cloudwatch_logs")

    @cloudwatch_logs.setter
    def cloudwatch_logs(self, value: Optional[pulumi.Input['ProjectDataDeliveryCloudwatchLogsArgs']]):
        pulumi.set(self, "cloudwatch_logs", value)

    @property
    @pulumi.getter(name="s3Destination")
    def s3_destination(self) -> Optional[pulumi.Input['ProjectDataDeliveryS3DestinationArgs']]:
        """
        A block that defines the S3 bucket and prefix that stores the evaluation events. See below.
        """
        return pulumi.get(self, "s3_destination")

    @s3_destination.setter
    def s3_destination(self, value: Optional[pulumi.Input['ProjectDataDeliveryS3DestinationArgs']]):
        pulumi.set(self, "s3_destination", value)


if not MYPY:
    class ProjectDataDeliveryCloudwatchLogsArgsDict(TypedDict):
        log_group: NotRequired[pulumi.Input[builtins.str]]
        """
        The name of the log group where the project stores evaluation events.
        """
elif False:
    ProjectDataDeliveryCloudwatchLogsArgsDict: TypeAlias = Mapping[str, Any]

@pulumi.input_type
class ProjectDataDeliveryCloudwatchLogsArgs:
    def __init__(__self__, *,
                 log_group: Optional[pulumi.Input[builtins.str]] = None):
        """
        :param pulumi.Input[builtins.str] log_group: The name of the log group where the project stores evaluation events.
        """
        if log_group is not None:
            pulumi.set(__self__, "log_group", log_group)

    @property
    @pulumi.getter(name="logGroup")
    def log_group(self) -> Optional[pulumi.Input[builtins.str]]:
        """
        The name of the log group where the project stores evaluation events.
        """
        return pulumi.get(self, "log_group")

    @log_group.setter
    def log_group(self, value: Optional[pulumi.Input[builtins.str]]):
        pulumi.set(self, "log_group", value)


if not MYPY:
    class ProjectDataDeliveryS3DestinationArgsDict(TypedDict):
        bucket: NotRequired[pulumi.Input[builtins.str]]
        """
        The name of the bucket in which Evidently stores evaluation events.
        """
        prefix: NotRequired[pulumi.Input[builtins.str]]
        """
        The bucket prefix in which Evidently stores evaluation events.
        """
elif False:
    ProjectDataDeliveryS3DestinationArgsDict: TypeAlias = Mapping[str, Any]

@pulumi.input_type
class ProjectDataDeliveryS3DestinationArgs:
    def __init__(__self__, *,
                 bucket: Optional[pulumi.Input[builtins.str]] = None,
                 prefix: Optional[pulumi.Input[builtins.str]] = None):
        """
        :param pulumi.Input[builtins.str] bucket: The name of the bucket in which Evidently stores evaluation events.
        :param pulumi.Input[builtins.str] prefix: The bucket prefix in which Evidently stores evaluation events.
        """
        if bucket is not None:
            pulumi.set(__self__, "bucket", bucket)
        if prefix is not None:
            pulumi.set(__self__, "prefix", prefix)

    @property
    @pulumi.getter
    def bucket(self) -> Optional[pulumi.Input[builtins.str]]:
        """
        The name of the bucket in which Evidently stores evaluation events.
        """
        return pulumi.get(self, "bucket")

    @bucket.setter
    def bucket(self, value: Optional[pulumi.Input[builtins.str]]):
        pulumi.set(self, "bucket", value)

    @property
    @pulumi.getter
    def prefix(self) -> Optional[pulumi.Input[builtins.str]]:
        """
        The bucket prefix in which Evidently stores evaluation events.
        """
        return pulumi.get(self, "prefix")

    @prefix.setter
    def prefix(self, value: Optional[pulumi.Input[builtins.str]]):
        pulumi.set(self, "prefix", value)


