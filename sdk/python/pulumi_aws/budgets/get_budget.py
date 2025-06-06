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
from . import outputs

__all__ = [
    'GetBudgetResult',
    'AwaitableGetBudgetResult',
    'get_budget',
    'get_budget_output',
]

@pulumi.output_type
class GetBudgetResult:
    """
    A collection of values returned by getBudget.
    """
    def __init__(__self__, account_id=None, arn=None, auto_adjust_datas=None, budget_exceeded=None, budget_limits=None, budget_type=None, calculated_spends=None, cost_filters=None, cost_types=None, id=None, name=None, name_prefix=None, notifications=None, planned_limits=None, tags=None, time_period_end=None, time_period_start=None, time_unit=None):
        if account_id and not isinstance(account_id, str):
            raise TypeError("Expected argument 'account_id' to be a str")
        pulumi.set(__self__, "account_id", account_id)
        if arn and not isinstance(arn, str):
            raise TypeError("Expected argument 'arn' to be a str")
        pulumi.set(__self__, "arn", arn)
        if auto_adjust_datas and not isinstance(auto_adjust_datas, list):
            raise TypeError("Expected argument 'auto_adjust_datas' to be a list")
        pulumi.set(__self__, "auto_adjust_datas", auto_adjust_datas)
        if budget_exceeded and not isinstance(budget_exceeded, bool):
            raise TypeError("Expected argument 'budget_exceeded' to be a bool")
        pulumi.set(__self__, "budget_exceeded", budget_exceeded)
        if budget_limits and not isinstance(budget_limits, list):
            raise TypeError("Expected argument 'budget_limits' to be a list")
        pulumi.set(__self__, "budget_limits", budget_limits)
        if budget_type and not isinstance(budget_type, str):
            raise TypeError("Expected argument 'budget_type' to be a str")
        pulumi.set(__self__, "budget_type", budget_type)
        if calculated_spends and not isinstance(calculated_spends, list):
            raise TypeError("Expected argument 'calculated_spends' to be a list")
        pulumi.set(__self__, "calculated_spends", calculated_spends)
        if cost_filters and not isinstance(cost_filters, list):
            raise TypeError("Expected argument 'cost_filters' to be a list")
        pulumi.set(__self__, "cost_filters", cost_filters)
        if cost_types and not isinstance(cost_types, list):
            raise TypeError("Expected argument 'cost_types' to be a list")
        pulumi.set(__self__, "cost_types", cost_types)
        if id and not isinstance(id, str):
            raise TypeError("Expected argument 'id' to be a str")
        pulumi.set(__self__, "id", id)
        if name and not isinstance(name, str):
            raise TypeError("Expected argument 'name' to be a str")
        pulumi.set(__self__, "name", name)
        if name_prefix and not isinstance(name_prefix, str):
            raise TypeError("Expected argument 'name_prefix' to be a str")
        pulumi.set(__self__, "name_prefix", name_prefix)
        if notifications and not isinstance(notifications, list):
            raise TypeError("Expected argument 'notifications' to be a list")
        pulumi.set(__self__, "notifications", notifications)
        if planned_limits and not isinstance(planned_limits, list):
            raise TypeError("Expected argument 'planned_limits' to be a list")
        pulumi.set(__self__, "planned_limits", planned_limits)
        if tags and not isinstance(tags, dict):
            raise TypeError("Expected argument 'tags' to be a dict")
        pulumi.set(__self__, "tags", tags)
        if time_period_end and not isinstance(time_period_end, str):
            raise TypeError("Expected argument 'time_period_end' to be a str")
        pulumi.set(__self__, "time_period_end", time_period_end)
        if time_period_start and not isinstance(time_period_start, str):
            raise TypeError("Expected argument 'time_period_start' to be a str")
        pulumi.set(__self__, "time_period_start", time_period_start)
        if time_unit and not isinstance(time_unit, str):
            raise TypeError("Expected argument 'time_unit' to be a str")
        pulumi.set(__self__, "time_unit", time_unit)

    @property
    @pulumi.getter(name="accountId")
    def account_id(self) -> builtins.str:
        return pulumi.get(self, "account_id")

    @property
    @pulumi.getter
    def arn(self) -> builtins.str:
        return pulumi.get(self, "arn")

    @property
    @pulumi.getter(name="autoAdjustDatas")
    def auto_adjust_datas(self) -> Sequence['outputs.GetBudgetAutoAdjustDataResult']:
        """
        Object containing [AutoAdjustData] which determines the budget amount for an auto-adjusting budget.
        """
        return pulumi.get(self, "auto_adjust_datas")

    @property
    @pulumi.getter(name="budgetExceeded")
    def budget_exceeded(self) -> builtins.bool:
        """
        Boolean indicating whether this budget has been exceeded.
        """
        return pulumi.get(self, "budget_exceeded")

    @property
    @pulumi.getter(name="budgetLimits")
    def budget_limits(self) -> Sequence['outputs.GetBudgetBudgetLimitResult']:
        """
        The total amount of cost, usage, RI utilization, RI coverage, Savings Plans utilization, or Savings Plans coverage that you want to track with your budget. Contains object Spend.
        """
        return pulumi.get(self, "budget_limits")

    @property
    @pulumi.getter(name="budgetType")
    def budget_type(self) -> builtins.str:
        """
        Whether this budget tracks monetary cost or usage.
        """
        return pulumi.get(self, "budget_type")

    @property
    @pulumi.getter(name="calculatedSpends")
    def calculated_spends(self) -> Sequence['outputs.GetBudgetCalculatedSpendResult']:
        """
        The spend objects that are associated with this budget. The actualSpend tracks how much you've used, cost, usage, RI units, or Savings Plans units and the forecastedSpend tracks how much that you're predicted to spend based on your historical usage profile.
        """
        return pulumi.get(self, "calculated_spends")

    @property
    @pulumi.getter(name="costFilters")
    def cost_filters(self) -> Sequence['outputs.GetBudgetCostFilterResult']:
        """
        A list of CostFilter name/values pair to apply to budget.
        """
        return pulumi.get(self, "cost_filters")

    @property
    @pulumi.getter(name="costTypes")
    def cost_types(self) -> Sequence['outputs.GetBudgetCostTypeResult']:
        """
        Object containing CostTypes The types of cost included in a budget, such as tax and subscriptions.
        """
        return pulumi.get(self, "cost_types")

    @property
    @pulumi.getter
    def id(self) -> builtins.str:
        """
        The provider-assigned unique ID for this managed resource.
        """
        return pulumi.get(self, "id")

    @property
    @pulumi.getter
    def name(self) -> builtins.str:
        return pulumi.get(self, "name")

    @property
    @pulumi.getter(name="namePrefix")
    def name_prefix(self) -> Optional[builtins.str]:
        return pulumi.get(self, "name_prefix")

    @property
    @pulumi.getter
    def notifications(self) -> Sequence['outputs.GetBudgetNotificationResult']:
        """
        Object containing Budget Notifications. Can be used multiple times to define more than one budget notification.
        """
        return pulumi.get(self, "notifications")

    @property
    @pulumi.getter(name="plannedLimits")
    def planned_limits(self) -> Sequence['outputs.GetBudgetPlannedLimitResult']:
        """
        Object containing Planned Budget Limits. Can be used multiple times to plan more than one budget limit. See [PlannedBudgetLimits](https://docs.aws.amazon.com/aws-cost-management/latest/APIReference/API_budgets_Budget.html#awscostmanagement-Type-budgets_Budget-PlannedBudgetLimits) documentation.
        """
        return pulumi.get(self, "planned_limits")

    @property
    @pulumi.getter
    def tags(self) -> Mapping[str, builtins.str]:
        """
        Map of tags assigned to the resource.
        """
        return pulumi.get(self, "tags")

    @property
    @pulumi.getter(name="timePeriodEnd")
    def time_period_end(self) -> builtins.str:
        """
        The end of the time period covered by the budget. There are no restrictions on the end date. Format: `2017-01-01_12:00`.
        """
        return pulumi.get(self, "time_period_end")

    @property
    @pulumi.getter(name="timePeriodStart")
    def time_period_start(self) -> builtins.str:
        """
        The start of the time period covered by the budget. If you don't specify a start date, AWS defaults to the start of your chosen time period. The start date must come before the end date. Format: `2017-01-01_12:00`.
        """
        return pulumi.get(self, "time_period_start")

    @property
    @pulumi.getter(name="timeUnit")
    def time_unit(self) -> builtins.str:
        """
        The length of time until a budget resets the actual and forecasted spend. Valid values: `MONTHLY`, `QUARTERLY`, `ANNUALLY`, and `DAILY`.
        """
        return pulumi.get(self, "time_unit")


class AwaitableGetBudgetResult(GetBudgetResult):
    # pylint: disable=using-constant-test
    def __await__(self):
        if False:
            yield self
        return GetBudgetResult(
            account_id=self.account_id,
            arn=self.arn,
            auto_adjust_datas=self.auto_adjust_datas,
            budget_exceeded=self.budget_exceeded,
            budget_limits=self.budget_limits,
            budget_type=self.budget_type,
            calculated_spends=self.calculated_spends,
            cost_filters=self.cost_filters,
            cost_types=self.cost_types,
            id=self.id,
            name=self.name,
            name_prefix=self.name_prefix,
            notifications=self.notifications,
            planned_limits=self.planned_limits,
            tags=self.tags,
            time_period_end=self.time_period_end,
            time_period_start=self.time_period_start,
            time_unit=self.time_unit)


def get_budget(account_id: Optional[builtins.str] = None,
               name: Optional[builtins.str] = None,
               name_prefix: Optional[builtins.str] = None,
               tags: Optional[Mapping[str, builtins.str]] = None,
               opts: Optional[pulumi.InvokeOptions] = None) -> AwaitableGetBudgetResult:
    """
    Data source for managing an AWS Web Services Budgets Budget.

    ## Example Usage

    ### Basic Usage

    ```python
    import pulumi
    import pulumi_aws as aws

    test = aws.budgets.get_budget(name=test_aws_budgets_budget["name"])
    ```


    :param builtins.str account_id: The ID of the target account for budget. Will use current user's account_id by default if omitted.
    :param builtins.str name: The name of a budget. Unique within accounts.
           
           The following arguments are optional:
    :param builtins.str name_prefix: The prefix of the name of a budget. Unique within accounts.
    :param Mapping[str, builtins.str] tags: Map of tags assigned to the resource.
    """
    __args__ = dict()
    __args__['accountId'] = account_id
    __args__['name'] = name
    __args__['namePrefix'] = name_prefix
    __args__['tags'] = tags
    opts = pulumi.InvokeOptions.merge(_utilities.get_invoke_opts_defaults(), opts)
    __ret__ = pulumi.runtime.invoke('aws:budgets/getBudget:getBudget', __args__, opts=opts, typ=GetBudgetResult).value

    return AwaitableGetBudgetResult(
        account_id=pulumi.get(__ret__, 'account_id'),
        arn=pulumi.get(__ret__, 'arn'),
        auto_adjust_datas=pulumi.get(__ret__, 'auto_adjust_datas'),
        budget_exceeded=pulumi.get(__ret__, 'budget_exceeded'),
        budget_limits=pulumi.get(__ret__, 'budget_limits'),
        budget_type=pulumi.get(__ret__, 'budget_type'),
        calculated_spends=pulumi.get(__ret__, 'calculated_spends'),
        cost_filters=pulumi.get(__ret__, 'cost_filters'),
        cost_types=pulumi.get(__ret__, 'cost_types'),
        id=pulumi.get(__ret__, 'id'),
        name=pulumi.get(__ret__, 'name'),
        name_prefix=pulumi.get(__ret__, 'name_prefix'),
        notifications=pulumi.get(__ret__, 'notifications'),
        planned_limits=pulumi.get(__ret__, 'planned_limits'),
        tags=pulumi.get(__ret__, 'tags'),
        time_period_end=pulumi.get(__ret__, 'time_period_end'),
        time_period_start=pulumi.get(__ret__, 'time_period_start'),
        time_unit=pulumi.get(__ret__, 'time_unit'))
def get_budget_output(account_id: Optional[pulumi.Input[Optional[builtins.str]]] = None,
                      name: Optional[pulumi.Input[builtins.str]] = None,
                      name_prefix: Optional[pulumi.Input[Optional[builtins.str]]] = None,
                      tags: Optional[pulumi.Input[Optional[Mapping[str, builtins.str]]]] = None,
                      opts: Optional[Union[pulumi.InvokeOptions, pulumi.InvokeOutputOptions]] = None) -> pulumi.Output[GetBudgetResult]:
    """
    Data source for managing an AWS Web Services Budgets Budget.

    ## Example Usage

    ### Basic Usage

    ```python
    import pulumi
    import pulumi_aws as aws

    test = aws.budgets.get_budget(name=test_aws_budgets_budget["name"])
    ```


    :param builtins.str account_id: The ID of the target account for budget. Will use current user's account_id by default if omitted.
    :param builtins.str name: The name of a budget. Unique within accounts.
           
           The following arguments are optional:
    :param builtins.str name_prefix: The prefix of the name of a budget. Unique within accounts.
    :param Mapping[str, builtins.str] tags: Map of tags assigned to the resource.
    """
    __args__ = dict()
    __args__['accountId'] = account_id
    __args__['name'] = name
    __args__['namePrefix'] = name_prefix
    __args__['tags'] = tags
    opts = pulumi.InvokeOutputOptions.merge(_utilities.get_invoke_opts_defaults(), opts)
    __ret__ = pulumi.runtime.invoke_output('aws:budgets/getBudget:getBudget', __args__, opts=opts, typ=GetBudgetResult)
    return __ret__.apply(lambda __response__: GetBudgetResult(
        account_id=pulumi.get(__response__, 'account_id'),
        arn=pulumi.get(__response__, 'arn'),
        auto_adjust_datas=pulumi.get(__response__, 'auto_adjust_datas'),
        budget_exceeded=pulumi.get(__response__, 'budget_exceeded'),
        budget_limits=pulumi.get(__response__, 'budget_limits'),
        budget_type=pulumi.get(__response__, 'budget_type'),
        calculated_spends=pulumi.get(__response__, 'calculated_spends'),
        cost_filters=pulumi.get(__response__, 'cost_filters'),
        cost_types=pulumi.get(__response__, 'cost_types'),
        id=pulumi.get(__response__, 'id'),
        name=pulumi.get(__response__, 'name'),
        name_prefix=pulumi.get(__response__, 'name_prefix'),
        notifications=pulumi.get(__response__, 'notifications'),
        planned_limits=pulumi.get(__response__, 'planned_limits'),
        tags=pulumi.get(__response__, 'tags'),
        time_period_end=pulumi.get(__response__, 'time_period_end'),
        time_period_start=pulumi.get(__response__, 'time_period_start'),
        time_unit=pulumi.get(__response__, 'time_unit')))
