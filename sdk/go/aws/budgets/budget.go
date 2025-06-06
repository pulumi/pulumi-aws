// Code generated by pulumi-language-go DO NOT EDIT.
// *** WARNING: Do not edit by hand unless you're certain you know what you are doing! ***

package budgets

import (
	"context"
	"reflect"

	"errors"
	"github.com/pulumi/pulumi-aws/sdk/v6/go/aws/internal"
	"github.com/pulumi/pulumi/sdk/v3/go/pulumi"
)

// Provides a budgets budget resource. Budgets use the cost visualization provided by Cost Explorer to show you the status of your budgets, to provide forecasts of your estimated costs, and to track your AWS usage, including your free tier usage.
//
// ## Example Usage
//
// ```go
// package main
//
// import (
//
//	"github.com/pulumi/pulumi-aws/sdk/v6/go/aws/budgets"
//	"github.com/pulumi/pulumi/sdk/v3/go/pulumi"
//
// )
//
//	func main() {
//		pulumi.Run(func(ctx *pulumi.Context) error {
//			_, err := budgets.NewBudget(ctx, "ec2", &budgets.BudgetArgs{
//				Name:            pulumi.String("budget-ec2-monthly"),
//				BudgetType:      pulumi.String("COST"),
//				LimitAmount:     pulumi.String("1200"),
//				LimitUnit:       pulumi.String("USD"),
//				TimePeriodEnd:   pulumi.String("2087-06-15_00:00"),
//				TimePeriodStart: pulumi.String("2017-07-01_00:00"),
//				TimeUnit:        pulumi.String("MONTHLY"),
//				CostFilters: budgets.BudgetCostFilterArray{
//					&budgets.BudgetCostFilterArgs{
//						Name: pulumi.String("Service"),
//						Values: pulumi.StringArray{
//							pulumi.String("Amazon Elastic Compute Cloud - Compute"),
//						},
//					},
//				},
//				Notifications: budgets.BudgetNotificationArray{
//					&budgets.BudgetNotificationArgs{
//						ComparisonOperator: pulumi.String("GREATER_THAN"),
//						Threshold:          pulumi.Float64(100),
//						ThresholdType:      pulumi.String("PERCENTAGE"),
//						NotificationType:   pulumi.String("FORECASTED"),
//						SubscriberEmailAddresses: pulumi.StringArray{
//							pulumi.String("test@example.com"),
//						},
//					},
//				},
//				Tags: pulumi.StringMap{
//					"Tag1": pulumi.String("Value1"),
//					"Tag2": pulumi.String("Value2"),
//				},
//			})
//			if err != nil {
//				return err
//			}
//			return nil
//		})
//	}
//
// ```
//
// Create a budget for *$100*.
//
// ```go
// package main
//
// import (
//
//	"github.com/pulumi/pulumi-aws/sdk/v6/go/aws/budgets"
//	"github.com/pulumi/pulumi/sdk/v3/go/pulumi"
//
// )
//
//	func main() {
//		pulumi.Run(func(ctx *pulumi.Context) error {
//			_, err := budgets.NewBudget(ctx, "cost", &budgets.BudgetArgs{
//				BudgetType:  pulumi.String("COST"),
//				LimitAmount: pulumi.String("100"),
//				LimitUnit:   pulumi.String("USD"),
//			})
//			if err != nil {
//				return err
//			}
//			return nil
//		})
//	}
//
// ```
//
// Create a budget with planned budget limits.
//
// ```go
// package main
//
// import (
//
//	"github.com/pulumi/pulumi-aws/sdk/v6/go/aws/budgets"
//	"github.com/pulumi/pulumi/sdk/v3/go/pulumi"
//
// )
//
//	func main() {
//		pulumi.Run(func(ctx *pulumi.Context) error {
//			_, err := budgets.NewBudget(ctx, "cost", &budgets.BudgetArgs{
//				PlannedLimits: budgets.BudgetPlannedLimitArray{
//					&budgets.BudgetPlannedLimitArgs{
//						StartTime: pulumi.String("2017-07-01_00:00"),
//						Amount:    pulumi.String("100"),
//						Unit:      pulumi.String("USD"),
//					},
//					&budgets.BudgetPlannedLimitArgs{
//						StartTime: pulumi.String("2017-08-01_00:00"),
//						Amount:    pulumi.String("200"),
//						Unit:      pulumi.String("USD"),
//					},
//				},
//			})
//			if err != nil {
//				return err
//			}
//			return nil
//		})
//	}
//
// ```
//
// Create a budget for s3 with a limit of *3 GB* of storage.
//
// ```go
// package main
//
// import (
//
//	"github.com/pulumi/pulumi-aws/sdk/v6/go/aws/budgets"
//	"github.com/pulumi/pulumi/sdk/v3/go/pulumi"
//
// )
//
//	func main() {
//		pulumi.Run(func(ctx *pulumi.Context) error {
//			_, err := budgets.NewBudget(ctx, "s3", &budgets.BudgetArgs{
//				BudgetType:  pulumi.String("USAGE"),
//				LimitAmount: pulumi.String("3"),
//				LimitUnit:   pulumi.String("GB"),
//			})
//			if err != nil {
//				return err
//			}
//			return nil
//		})
//	}
//
// ```
//
// # Create a Savings Plan Utilization Budget
//
// ```go
// package main
//
// import (
//
//	"github.com/pulumi/pulumi-aws/sdk/v6/go/aws/budgets"
//	"github.com/pulumi/pulumi/sdk/v3/go/pulumi"
//
// )
//
//	func main() {
//		pulumi.Run(func(ctx *pulumi.Context) error {
//			_, err := budgets.NewBudget(ctx, "savings_plan_utilization", &budgets.BudgetArgs{
//				BudgetType:  pulumi.String("SAVINGS_PLANS_UTILIZATION"),
//				LimitAmount: pulumi.String("100.0"),
//				LimitUnit:   pulumi.String("PERCENTAGE"),
//				CostTypes: &budgets.BudgetCostTypesArgs{
//					IncludeCredit:            pulumi.Bool(false),
//					IncludeDiscount:          pulumi.Bool(false),
//					IncludeOtherSubscription: pulumi.Bool(false),
//					IncludeRecurring:         pulumi.Bool(false),
//					IncludeRefund:            pulumi.Bool(false),
//					IncludeSubscription:      pulumi.Bool(true),
//					IncludeSupport:           pulumi.Bool(false),
//					IncludeTax:               pulumi.Bool(false),
//					IncludeUpfront:           pulumi.Bool(false),
//					UseBlended:               pulumi.Bool(false),
//				},
//			})
//			if err != nil {
//				return err
//			}
//			return nil
//		})
//	}
//
// ```
//
// # Create a RI Utilization Budget
//
// ```go
// package main
//
// import (
//
//	"github.com/pulumi/pulumi-aws/sdk/v6/go/aws/budgets"
//	"github.com/pulumi/pulumi/sdk/v3/go/pulumi"
//
// )
//
//	func main() {
//		pulumi.Run(func(ctx *pulumi.Context) error {
//			_, err := budgets.NewBudget(ctx, "ri_utilization", &budgets.BudgetArgs{
//				BudgetType:  pulumi.String("RI_UTILIZATION"),
//				LimitAmount: pulumi.String("100.0"),
//				LimitUnit:   pulumi.String("PERCENTAGE"),
//				CostTypes: &budgets.BudgetCostTypesArgs{
//					IncludeCredit:            pulumi.Bool(false),
//					IncludeDiscount:          pulumi.Bool(false),
//					IncludeOtherSubscription: pulumi.Bool(false),
//					IncludeRecurring:         pulumi.Bool(false),
//					IncludeRefund:            pulumi.Bool(false),
//					IncludeSubscription:      pulumi.Bool(true),
//					IncludeSupport:           pulumi.Bool(false),
//					IncludeTax:               pulumi.Bool(false),
//					IncludeUpfront:           pulumi.Bool(false),
//					UseBlended:               pulumi.Bool(false),
//				},
//				CostFilters: budgets.BudgetCostFilterArray{
//					&budgets.BudgetCostFilterArgs{
//						Name: pulumi.String("Service"),
//						Values: pulumi.StringArray{
//							pulumi.String("Amazon Relational Database Service"),
//						},
//					},
//				},
//			})
//			if err != nil {
//				return err
//			}
//			return nil
//		})
//	}
//
// ```
//
// # Create a cost filter using resource tags
//
// ```go
// package main
//
// import (
//
//	"github.com/pulumi/pulumi-aws/sdk/v6/go/aws/budgets"
//	"github.com/pulumi/pulumi/sdk/v3/go/pulumi"
//
// )
//
//	func main() {
//		pulumi.Run(func(ctx *pulumi.Context) error {
//			_, err := budgets.NewBudget(ctx, "cost", &budgets.BudgetArgs{
//				CostFilters: budgets.BudgetCostFilterArray{
//					&budgets.BudgetCostFilterArgs{
//						Name: pulumi.String("TagKeyValue"),
//						Values: pulumi.StringArray{
//							pulumi.String("aws:createdBy$Pulumi"),
//							pulumi.String("user:business-unit$human_resources"),
//						},
//					},
//				},
//			})
//			if err != nil {
//				return err
//			}
//			return nil
//		})
//	}
//
// ```
//
// # Create a cost filter using resource tags, obtaining the tag value from a variable
//
// ```go
// package main
//
// import (
//
//	"fmt"
//
//	"github.com/pulumi/pulumi-aws/sdk/v6/go/aws/budgets"
//	"github.com/pulumi/pulumi/sdk/v3/go/pulumi"
//
// )
//
//	func main() {
//		pulumi.Run(func(ctx *pulumi.Context) error {
//			_, err := budgets.NewBudget(ctx, "cost", &budgets.BudgetArgs{
//				CostFilters: budgets.BudgetCostFilterArray{
//					&budgets.BudgetCostFilterArgs{
//						Name: pulumi.String("TagKeyValue"),
//						Values: pulumi.StringArray{
//							pulumi.Sprintf("TagKey%v%v", "$", tagValue),
//						},
//					},
//				},
//			})
//			if err != nil {
//				return err
//			}
//			return nil
//		})
//	}
//
// ```
//
// ## Import
//
// Using `pulumi import`, import budgets using `AccountID:BudgetName`. For example:
//
// ```sh
// $ pulumi import aws:budgets/budget:Budget myBudget 123456789012:myBudget
// ```
type Budget struct {
	pulumi.CustomResourceState

	// The ID of the target account for budget. Will use current user's accountId by default if omitted.
	AccountId pulumi.StringOutput `pulumi:"accountId"`
	// The ARN of the budget.
	Arn pulumi.StringOutput `pulumi:"arn"`
	// Object containing AutoAdjustData which determines the budget amount for an auto-adjusting budget.
	AutoAdjustData BudgetAutoAdjustDataPtrOutput `pulumi:"autoAdjustData"`
	// Whether this budget tracks monetary cost or usage.
	BudgetType pulumi.StringOutput `pulumi:"budgetType"`
	// A list of CostFilter name/values pair to apply to budget.
	CostFilters BudgetCostFilterArrayOutput `pulumi:"costFilters"`
	// Object containing CostTypes The types of cost included in a budget, such as tax and subscriptions.
	CostTypes BudgetCostTypesOutput `pulumi:"costTypes"`
	// The amount of cost or usage being measured for a budget.
	LimitAmount pulumi.StringOutput `pulumi:"limitAmount"`
	// The unit of measurement used for the budget forecast, actual spend, or budget threshold, such as dollars or GB. See [Spend](http://docs.aws.amazon.com/awsaccountbilling/latest/aboutv2/data-type-spend.html) documentation.
	LimitUnit pulumi.StringOutput `pulumi:"limitUnit"`
	// The name of a budget. Unique within accounts.
	Name pulumi.StringOutput `pulumi:"name"`
	// The prefix of the name of a budget. Unique within accounts.
	NamePrefix pulumi.StringOutput `pulumi:"namePrefix"`
	// Object containing Budget Notifications. Can be used multiple times to define more than one budget notification.
	Notifications BudgetNotificationArrayOutput `pulumi:"notifications"`
	// Object containing Planned Budget Limits. Can be used multiple times to plan more than one budget limit. See [PlannedBudgetLimits](https://docs.aws.amazon.com/aws-cost-management/latest/APIReference/API_budgets_Budget.html#awscostmanagement-Type-budgets_Budget-PlannedBudgetLimits) documentation.
	PlannedLimits BudgetPlannedLimitArrayOutput `pulumi:"plannedLimits"`
	// Map of tags assigned to the resource. If configured with a provider `defaultTags` configuration block present, tags with matching keys will overwrite those defined at the provider-level.
	Tags pulumi.StringMapOutput `pulumi:"tags"`
	// Map of tags assigned to the resource, including those inherited from the provider `defaultTags` configuration block.
	//
	// Deprecated: Please use `tags` instead.
	TagsAll pulumi.StringMapOutput `pulumi:"tagsAll"`
	// The end of the time period covered by the budget. There are no restrictions on the end date. Format: `2017-01-01_12:00`.
	TimePeriodEnd pulumi.StringPtrOutput `pulumi:"timePeriodEnd"`
	// The start of the time period covered by the budget. If you don't specify a start date, AWS defaults to the start of your chosen time period. The start date must come before the end date. Format: `2017-01-01_12:00`.
	//
	// For more detailed documentation about each argument, refer to the [AWS official
	// documentation](http://docs.aws.amazon.com/awsaccountbilling/latest/aboutv2/data-type-budget.html).
	TimePeriodStart pulumi.StringOutput `pulumi:"timePeriodStart"`
	// The length of time until a budget resets the actual and forecasted spend. Valid values: `MONTHLY`, `QUARTERLY`, `ANNUALLY`, and `DAILY`.
	//
	// The following arguments are optional:
	TimeUnit pulumi.StringOutput `pulumi:"timeUnit"`
}

// NewBudget registers a new resource with the given unique name, arguments, and options.
func NewBudget(ctx *pulumi.Context,
	name string, args *BudgetArgs, opts ...pulumi.ResourceOption) (*Budget, error) {
	if args == nil {
		return nil, errors.New("missing one or more required arguments")
	}

	if args.BudgetType == nil {
		return nil, errors.New("invalid value for required argument 'BudgetType'")
	}
	if args.TimeUnit == nil {
		return nil, errors.New("invalid value for required argument 'TimeUnit'")
	}
	opts = internal.PkgResourceDefaultOpts(opts)
	var resource Budget
	err := ctx.RegisterResource("aws:budgets/budget:Budget", name, args, &resource, opts...)
	if err != nil {
		return nil, err
	}
	return &resource, nil
}

// GetBudget gets an existing Budget resource's state with the given name, ID, and optional
// state properties that are used to uniquely qualify the lookup (nil if not required).
func GetBudget(ctx *pulumi.Context,
	name string, id pulumi.IDInput, state *BudgetState, opts ...pulumi.ResourceOption) (*Budget, error) {
	var resource Budget
	err := ctx.ReadResource("aws:budgets/budget:Budget", name, id, state, &resource, opts...)
	if err != nil {
		return nil, err
	}
	return &resource, nil
}

// Input properties used for looking up and filtering Budget resources.
type budgetState struct {
	// The ID of the target account for budget. Will use current user's accountId by default if omitted.
	AccountId *string `pulumi:"accountId"`
	// The ARN of the budget.
	Arn *string `pulumi:"arn"`
	// Object containing AutoAdjustData which determines the budget amount for an auto-adjusting budget.
	AutoAdjustData *BudgetAutoAdjustData `pulumi:"autoAdjustData"`
	// Whether this budget tracks monetary cost or usage.
	BudgetType *string `pulumi:"budgetType"`
	// A list of CostFilter name/values pair to apply to budget.
	CostFilters []BudgetCostFilter `pulumi:"costFilters"`
	// Object containing CostTypes The types of cost included in a budget, such as tax and subscriptions.
	CostTypes *BudgetCostTypes `pulumi:"costTypes"`
	// The amount of cost or usage being measured for a budget.
	LimitAmount *string `pulumi:"limitAmount"`
	// The unit of measurement used for the budget forecast, actual spend, or budget threshold, such as dollars or GB. See [Spend](http://docs.aws.amazon.com/awsaccountbilling/latest/aboutv2/data-type-spend.html) documentation.
	LimitUnit *string `pulumi:"limitUnit"`
	// The name of a budget. Unique within accounts.
	Name *string `pulumi:"name"`
	// The prefix of the name of a budget. Unique within accounts.
	NamePrefix *string `pulumi:"namePrefix"`
	// Object containing Budget Notifications. Can be used multiple times to define more than one budget notification.
	Notifications []BudgetNotification `pulumi:"notifications"`
	// Object containing Planned Budget Limits. Can be used multiple times to plan more than one budget limit. See [PlannedBudgetLimits](https://docs.aws.amazon.com/aws-cost-management/latest/APIReference/API_budgets_Budget.html#awscostmanagement-Type-budgets_Budget-PlannedBudgetLimits) documentation.
	PlannedLimits []BudgetPlannedLimit `pulumi:"plannedLimits"`
	// Map of tags assigned to the resource. If configured with a provider `defaultTags` configuration block present, tags with matching keys will overwrite those defined at the provider-level.
	Tags map[string]string `pulumi:"tags"`
	// Map of tags assigned to the resource, including those inherited from the provider `defaultTags` configuration block.
	//
	// Deprecated: Please use `tags` instead.
	TagsAll map[string]string `pulumi:"tagsAll"`
	// The end of the time period covered by the budget. There are no restrictions on the end date. Format: `2017-01-01_12:00`.
	TimePeriodEnd *string `pulumi:"timePeriodEnd"`
	// The start of the time period covered by the budget. If you don't specify a start date, AWS defaults to the start of your chosen time period. The start date must come before the end date. Format: `2017-01-01_12:00`.
	//
	// For more detailed documentation about each argument, refer to the [AWS official
	// documentation](http://docs.aws.amazon.com/awsaccountbilling/latest/aboutv2/data-type-budget.html).
	TimePeriodStart *string `pulumi:"timePeriodStart"`
	// The length of time until a budget resets the actual and forecasted spend. Valid values: `MONTHLY`, `QUARTERLY`, `ANNUALLY`, and `DAILY`.
	//
	// The following arguments are optional:
	TimeUnit *string `pulumi:"timeUnit"`
}

type BudgetState struct {
	// The ID of the target account for budget. Will use current user's accountId by default if omitted.
	AccountId pulumi.StringPtrInput
	// The ARN of the budget.
	Arn pulumi.StringPtrInput
	// Object containing AutoAdjustData which determines the budget amount for an auto-adjusting budget.
	AutoAdjustData BudgetAutoAdjustDataPtrInput
	// Whether this budget tracks monetary cost or usage.
	BudgetType pulumi.StringPtrInput
	// A list of CostFilter name/values pair to apply to budget.
	CostFilters BudgetCostFilterArrayInput
	// Object containing CostTypes The types of cost included in a budget, such as tax and subscriptions.
	CostTypes BudgetCostTypesPtrInput
	// The amount of cost or usage being measured for a budget.
	LimitAmount pulumi.StringPtrInput
	// The unit of measurement used for the budget forecast, actual spend, or budget threshold, such as dollars or GB. See [Spend](http://docs.aws.amazon.com/awsaccountbilling/latest/aboutv2/data-type-spend.html) documentation.
	LimitUnit pulumi.StringPtrInput
	// The name of a budget. Unique within accounts.
	Name pulumi.StringPtrInput
	// The prefix of the name of a budget. Unique within accounts.
	NamePrefix pulumi.StringPtrInput
	// Object containing Budget Notifications. Can be used multiple times to define more than one budget notification.
	Notifications BudgetNotificationArrayInput
	// Object containing Planned Budget Limits. Can be used multiple times to plan more than one budget limit. See [PlannedBudgetLimits](https://docs.aws.amazon.com/aws-cost-management/latest/APIReference/API_budgets_Budget.html#awscostmanagement-Type-budgets_Budget-PlannedBudgetLimits) documentation.
	PlannedLimits BudgetPlannedLimitArrayInput
	// Map of tags assigned to the resource. If configured with a provider `defaultTags` configuration block present, tags with matching keys will overwrite those defined at the provider-level.
	Tags pulumi.StringMapInput
	// Map of tags assigned to the resource, including those inherited from the provider `defaultTags` configuration block.
	//
	// Deprecated: Please use `tags` instead.
	TagsAll pulumi.StringMapInput
	// The end of the time period covered by the budget. There are no restrictions on the end date. Format: `2017-01-01_12:00`.
	TimePeriodEnd pulumi.StringPtrInput
	// The start of the time period covered by the budget. If you don't specify a start date, AWS defaults to the start of your chosen time period. The start date must come before the end date. Format: `2017-01-01_12:00`.
	//
	// For more detailed documentation about each argument, refer to the [AWS official
	// documentation](http://docs.aws.amazon.com/awsaccountbilling/latest/aboutv2/data-type-budget.html).
	TimePeriodStart pulumi.StringPtrInput
	// The length of time until a budget resets the actual and forecasted spend. Valid values: `MONTHLY`, `QUARTERLY`, `ANNUALLY`, and `DAILY`.
	//
	// The following arguments are optional:
	TimeUnit pulumi.StringPtrInput
}

func (BudgetState) ElementType() reflect.Type {
	return reflect.TypeOf((*budgetState)(nil)).Elem()
}

type budgetArgs struct {
	// The ID of the target account for budget. Will use current user's accountId by default if omitted.
	AccountId *string `pulumi:"accountId"`
	// Object containing AutoAdjustData which determines the budget amount for an auto-adjusting budget.
	AutoAdjustData *BudgetAutoAdjustData `pulumi:"autoAdjustData"`
	// Whether this budget tracks monetary cost or usage.
	BudgetType string `pulumi:"budgetType"`
	// A list of CostFilter name/values pair to apply to budget.
	CostFilters []BudgetCostFilter `pulumi:"costFilters"`
	// Object containing CostTypes The types of cost included in a budget, such as tax and subscriptions.
	CostTypes *BudgetCostTypes `pulumi:"costTypes"`
	// The amount of cost or usage being measured for a budget.
	LimitAmount *string `pulumi:"limitAmount"`
	// The unit of measurement used for the budget forecast, actual spend, or budget threshold, such as dollars or GB. See [Spend](http://docs.aws.amazon.com/awsaccountbilling/latest/aboutv2/data-type-spend.html) documentation.
	LimitUnit *string `pulumi:"limitUnit"`
	// The name of a budget. Unique within accounts.
	Name *string `pulumi:"name"`
	// The prefix of the name of a budget. Unique within accounts.
	NamePrefix *string `pulumi:"namePrefix"`
	// Object containing Budget Notifications. Can be used multiple times to define more than one budget notification.
	Notifications []BudgetNotification `pulumi:"notifications"`
	// Object containing Planned Budget Limits. Can be used multiple times to plan more than one budget limit. See [PlannedBudgetLimits](https://docs.aws.amazon.com/aws-cost-management/latest/APIReference/API_budgets_Budget.html#awscostmanagement-Type-budgets_Budget-PlannedBudgetLimits) documentation.
	PlannedLimits []BudgetPlannedLimit `pulumi:"plannedLimits"`
	// Map of tags assigned to the resource. If configured with a provider `defaultTags` configuration block present, tags with matching keys will overwrite those defined at the provider-level.
	Tags map[string]string `pulumi:"tags"`
	// The end of the time period covered by the budget. There are no restrictions on the end date. Format: `2017-01-01_12:00`.
	TimePeriodEnd *string `pulumi:"timePeriodEnd"`
	// The start of the time period covered by the budget. If you don't specify a start date, AWS defaults to the start of your chosen time period. The start date must come before the end date. Format: `2017-01-01_12:00`.
	//
	// For more detailed documentation about each argument, refer to the [AWS official
	// documentation](http://docs.aws.amazon.com/awsaccountbilling/latest/aboutv2/data-type-budget.html).
	TimePeriodStart *string `pulumi:"timePeriodStart"`
	// The length of time until a budget resets the actual and forecasted spend. Valid values: `MONTHLY`, `QUARTERLY`, `ANNUALLY`, and `DAILY`.
	//
	// The following arguments are optional:
	TimeUnit string `pulumi:"timeUnit"`
}

// The set of arguments for constructing a Budget resource.
type BudgetArgs struct {
	// The ID of the target account for budget. Will use current user's accountId by default if omitted.
	AccountId pulumi.StringPtrInput
	// Object containing AutoAdjustData which determines the budget amount for an auto-adjusting budget.
	AutoAdjustData BudgetAutoAdjustDataPtrInput
	// Whether this budget tracks monetary cost or usage.
	BudgetType pulumi.StringInput
	// A list of CostFilter name/values pair to apply to budget.
	CostFilters BudgetCostFilterArrayInput
	// Object containing CostTypes The types of cost included in a budget, such as tax and subscriptions.
	CostTypes BudgetCostTypesPtrInput
	// The amount of cost or usage being measured for a budget.
	LimitAmount pulumi.StringPtrInput
	// The unit of measurement used for the budget forecast, actual spend, or budget threshold, such as dollars or GB. See [Spend](http://docs.aws.amazon.com/awsaccountbilling/latest/aboutv2/data-type-spend.html) documentation.
	LimitUnit pulumi.StringPtrInput
	// The name of a budget. Unique within accounts.
	Name pulumi.StringPtrInput
	// The prefix of the name of a budget. Unique within accounts.
	NamePrefix pulumi.StringPtrInput
	// Object containing Budget Notifications. Can be used multiple times to define more than one budget notification.
	Notifications BudgetNotificationArrayInput
	// Object containing Planned Budget Limits. Can be used multiple times to plan more than one budget limit. See [PlannedBudgetLimits](https://docs.aws.amazon.com/aws-cost-management/latest/APIReference/API_budgets_Budget.html#awscostmanagement-Type-budgets_Budget-PlannedBudgetLimits) documentation.
	PlannedLimits BudgetPlannedLimitArrayInput
	// Map of tags assigned to the resource. If configured with a provider `defaultTags` configuration block present, tags with matching keys will overwrite those defined at the provider-level.
	Tags pulumi.StringMapInput
	// The end of the time period covered by the budget. There are no restrictions on the end date. Format: `2017-01-01_12:00`.
	TimePeriodEnd pulumi.StringPtrInput
	// The start of the time period covered by the budget. If you don't specify a start date, AWS defaults to the start of your chosen time period. The start date must come before the end date. Format: `2017-01-01_12:00`.
	//
	// For more detailed documentation about each argument, refer to the [AWS official
	// documentation](http://docs.aws.amazon.com/awsaccountbilling/latest/aboutv2/data-type-budget.html).
	TimePeriodStart pulumi.StringPtrInput
	// The length of time until a budget resets the actual and forecasted spend. Valid values: `MONTHLY`, `QUARTERLY`, `ANNUALLY`, and `DAILY`.
	//
	// The following arguments are optional:
	TimeUnit pulumi.StringInput
}

func (BudgetArgs) ElementType() reflect.Type {
	return reflect.TypeOf((*budgetArgs)(nil)).Elem()
}

type BudgetInput interface {
	pulumi.Input

	ToBudgetOutput() BudgetOutput
	ToBudgetOutputWithContext(ctx context.Context) BudgetOutput
}

func (*Budget) ElementType() reflect.Type {
	return reflect.TypeOf((**Budget)(nil)).Elem()
}

func (i *Budget) ToBudgetOutput() BudgetOutput {
	return i.ToBudgetOutputWithContext(context.Background())
}

func (i *Budget) ToBudgetOutputWithContext(ctx context.Context) BudgetOutput {
	return pulumi.ToOutputWithContext(ctx, i).(BudgetOutput)
}

// BudgetArrayInput is an input type that accepts BudgetArray and BudgetArrayOutput values.
// You can construct a concrete instance of `BudgetArrayInput` via:
//
//	BudgetArray{ BudgetArgs{...} }
type BudgetArrayInput interface {
	pulumi.Input

	ToBudgetArrayOutput() BudgetArrayOutput
	ToBudgetArrayOutputWithContext(context.Context) BudgetArrayOutput
}

type BudgetArray []BudgetInput

func (BudgetArray) ElementType() reflect.Type {
	return reflect.TypeOf((*[]*Budget)(nil)).Elem()
}

func (i BudgetArray) ToBudgetArrayOutput() BudgetArrayOutput {
	return i.ToBudgetArrayOutputWithContext(context.Background())
}

func (i BudgetArray) ToBudgetArrayOutputWithContext(ctx context.Context) BudgetArrayOutput {
	return pulumi.ToOutputWithContext(ctx, i).(BudgetArrayOutput)
}

// BudgetMapInput is an input type that accepts BudgetMap and BudgetMapOutput values.
// You can construct a concrete instance of `BudgetMapInput` via:
//
//	BudgetMap{ "key": BudgetArgs{...} }
type BudgetMapInput interface {
	pulumi.Input

	ToBudgetMapOutput() BudgetMapOutput
	ToBudgetMapOutputWithContext(context.Context) BudgetMapOutput
}

type BudgetMap map[string]BudgetInput

func (BudgetMap) ElementType() reflect.Type {
	return reflect.TypeOf((*map[string]*Budget)(nil)).Elem()
}

func (i BudgetMap) ToBudgetMapOutput() BudgetMapOutput {
	return i.ToBudgetMapOutputWithContext(context.Background())
}

func (i BudgetMap) ToBudgetMapOutputWithContext(ctx context.Context) BudgetMapOutput {
	return pulumi.ToOutputWithContext(ctx, i).(BudgetMapOutput)
}

type BudgetOutput struct{ *pulumi.OutputState }

func (BudgetOutput) ElementType() reflect.Type {
	return reflect.TypeOf((**Budget)(nil)).Elem()
}

func (o BudgetOutput) ToBudgetOutput() BudgetOutput {
	return o
}

func (o BudgetOutput) ToBudgetOutputWithContext(ctx context.Context) BudgetOutput {
	return o
}

// The ID of the target account for budget. Will use current user's accountId by default if omitted.
func (o BudgetOutput) AccountId() pulumi.StringOutput {
	return o.ApplyT(func(v *Budget) pulumi.StringOutput { return v.AccountId }).(pulumi.StringOutput)
}

// The ARN of the budget.
func (o BudgetOutput) Arn() pulumi.StringOutput {
	return o.ApplyT(func(v *Budget) pulumi.StringOutput { return v.Arn }).(pulumi.StringOutput)
}

// Object containing AutoAdjustData which determines the budget amount for an auto-adjusting budget.
func (o BudgetOutput) AutoAdjustData() BudgetAutoAdjustDataPtrOutput {
	return o.ApplyT(func(v *Budget) BudgetAutoAdjustDataPtrOutput { return v.AutoAdjustData }).(BudgetAutoAdjustDataPtrOutput)
}

// Whether this budget tracks monetary cost or usage.
func (o BudgetOutput) BudgetType() pulumi.StringOutput {
	return o.ApplyT(func(v *Budget) pulumi.StringOutput { return v.BudgetType }).(pulumi.StringOutput)
}

// A list of CostFilter name/values pair to apply to budget.
func (o BudgetOutput) CostFilters() BudgetCostFilterArrayOutput {
	return o.ApplyT(func(v *Budget) BudgetCostFilterArrayOutput { return v.CostFilters }).(BudgetCostFilterArrayOutput)
}

// Object containing CostTypes The types of cost included in a budget, such as tax and subscriptions.
func (o BudgetOutput) CostTypes() BudgetCostTypesOutput {
	return o.ApplyT(func(v *Budget) BudgetCostTypesOutput { return v.CostTypes }).(BudgetCostTypesOutput)
}

// The amount of cost or usage being measured for a budget.
func (o BudgetOutput) LimitAmount() pulumi.StringOutput {
	return o.ApplyT(func(v *Budget) pulumi.StringOutput { return v.LimitAmount }).(pulumi.StringOutput)
}

// The unit of measurement used for the budget forecast, actual spend, or budget threshold, such as dollars or GB. See [Spend](http://docs.aws.amazon.com/awsaccountbilling/latest/aboutv2/data-type-spend.html) documentation.
func (o BudgetOutput) LimitUnit() pulumi.StringOutput {
	return o.ApplyT(func(v *Budget) pulumi.StringOutput { return v.LimitUnit }).(pulumi.StringOutput)
}

// The name of a budget. Unique within accounts.
func (o BudgetOutput) Name() pulumi.StringOutput {
	return o.ApplyT(func(v *Budget) pulumi.StringOutput { return v.Name }).(pulumi.StringOutput)
}

// The prefix of the name of a budget. Unique within accounts.
func (o BudgetOutput) NamePrefix() pulumi.StringOutput {
	return o.ApplyT(func(v *Budget) pulumi.StringOutput { return v.NamePrefix }).(pulumi.StringOutput)
}

// Object containing Budget Notifications. Can be used multiple times to define more than one budget notification.
func (o BudgetOutput) Notifications() BudgetNotificationArrayOutput {
	return o.ApplyT(func(v *Budget) BudgetNotificationArrayOutput { return v.Notifications }).(BudgetNotificationArrayOutput)
}

// Object containing Planned Budget Limits. Can be used multiple times to plan more than one budget limit. See [PlannedBudgetLimits](https://docs.aws.amazon.com/aws-cost-management/latest/APIReference/API_budgets_Budget.html#awscostmanagement-Type-budgets_Budget-PlannedBudgetLimits) documentation.
func (o BudgetOutput) PlannedLimits() BudgetPlannedLimitArrayOutput {
	return o.ApplyT(func(v *Budget) BudgetPlannedLimitArrayOutput { return v.PlannedLimits }).(BudgetPlannedLimitArrayOutput)
}

// Map of tags assigned to the resource. If configured with a provider `defaultTags` configuration block present, tags with matching keys will overwrite those defined at the provider-level.
func (o BudgetOutput) Tags() pulumi.StringMapOutput {
	return o.ApplyT(func(v *Budget) pulumi.StringMapOutput { return v.Tags }).(pulumi.StringMapOutput)
}

// Map of tags assigned to the resource, including those inherited from the provider `defaultTags` configuration block.
//
// Deprecated: Please use `tags` instead.
func (o BudgetOutput) TagsAll() pulumi.StringMapOutput {
	return o.ApplyT(func(v *Budget) pulumi.StringMapOutput { return v.TagsAll }).(pulumi.StringMapOutput)
}

// The end of the time period covered by the budget. There are no restrictions on the end date. Format: `2017-01-01_12:00`.
func (o BudgetOutput) TimePeriodEnd() pulumi.StringPtrOutput {
	return o.ApplyT(func(v *Budget) pulumi.StringPtrOutput { return v.TimePeriodEnd }).(pulumi.StringPtrOutput)
}

// The start of the time period covered by the budget. If you don't specify a start date, AWS defaults to the start of your chosen time period. The start date must come before the end date. Format: `2017-01-01_12:00`.
//
// For more detailed documentation about each argument, refer to the [AWS official
// documentation](http://docs.aws.amazon.com/awsaccountbilling/latest/aboutv2/data-type-budget.html).
func (o BudgetOutput) TimePeriodStart() pulumi.StringOutput {
	return o.ApplyT(func(v *Budget) pulumi.StringOutput { return v.TimePeriodStart }).(pulumi.StringOutput)
}

// The length of time until a budget resets the actual and forecasted spend. Valid values: `MONTHLY`, `QUARTERLY`, `ANNUALLY`, and `DAILY`.
//
// The following arguments are optional:
func (o BudgetOutput) TimeUnit() pulumi.StringOutput {
	return o.ApplyT(func(v *Budget) pulumi.StringOutput { return v.TimeUnit }).(pulumi.StringOutput)
}

type BudgetArrayOutput struct{ *pulumi.OutputState }

func (BudgetArrayOutput) ElementType() reflect.Type {
	return reflect.TypeOf((*[]*Budget)(nil)).Elem()
}

func (o BudgetArrayOutput) ToBudgetArrayOutput() BudgetArrayOutput {
	return o
}

func (o BudgetArrayOutput) ToBudgetArrayOutputWithContext(ctx context.Context) BudgetArrayOutput {
	return o
}

func (o BudgetArrayOutput) Index(i pulumi.IntInput) BudgetOutput {
	return pulumi.All(o, i).ApplyT(func(vs []interface{}) *Budget {
		return vs[0].([]*Budget)[vs[1].(int)]
	}).(BudgetOutput)
}

type BudgetMapOutput struct{ *pulumi.OutputState }

func (BudgetMapOutput) ElementType() reflect.Type {
	return reflect.TypeOf((*map[string]*Budget)(nil)).Elem()
}

func (o BudgetMapOutput) ToBudgetMapOutput() BudgetMapOutput {
	return o
}

func (o BudgetMapOutput) ToBudgetMapOutputWithContext(ctx context.Context) BudgetMapOutput {
	return o
}

func (o BudgetMapOutput) MapIndex(k pulumi.StringInput) BudgetOutput {
	return pulumi.All(o, k).ApplyT(func(vs []interface{}) *Budget {
		return vs[0].(map[string]*Budget)[vs[1].(string)]
	}).(BudgetOutput)
}

func init() {
	pulumi.RegisterInputType(reflect.TypeOf((*BudgetInput)(nil)).Elem(), &Budget{})
	pulumi.RegisterInputType(reflect.TypeOf((*BudgetArrayInput)(nil)).Elem(), BudgetArray{})
	pulumi.RegisterInputType(reflect.TypeOf((*BudgetMapInput)(nil)).Elem(), BudgetMap{})
	pulumi.RegisterOutputType(BudgetOutput{})
	pulumi.RegisterOutputType(BudgetArrayOutput{})
	pulumi.RegisterOutputType(BudgetMapOutput{})
}
