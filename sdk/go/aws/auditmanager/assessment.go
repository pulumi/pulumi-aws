// Code generated by pulumi-language-go DO NOT EDIT.
// *** WARNING: Do not edit by hand unless you're certain you know what you are doing! ***

package auditmanager

import (
	"context"
	"reflect"

	"errors"
	"github.com/pulumi/pulumi-aws/sdk/v6/go/aws/internal"
	"github.com/pulumi/pulumi/sdk/v3/go/pulumi"
)

// Resource for managing an AWS Audit Manager Assessment.
//
// ## Example Usage
//
// ### Basic Usage
//
// ```go
// package main
//
// import (
//
//	"fmt"
//
//	"github.com/pulumi/pulumi-aws/sdk/v6/go/aws/auditmanager"
//	"github.com/pulumi/pulumi/sdk/v3/go/pulumi"
//
// )
//
//	func main() {
//		pulumi.Run(func(ctx *pulumi.Context) error {
//			_, err := auditmanager.NewAssessment(ctx, "test", &auditmanager.AssessmentArgs{
//				Name: pulumi.String("example"),
//				AssessmentReportsDestination: &auditmanager.AssessmentAssessmentReportsDestinationArgs{
//					Destination:     pulumi.Sprintf("s3://%v", testAwsS3Bucket.Id),
//					DestinationType: pulumi.String("S3"),
//				},
//				FrameworkId: pulumi.Any(testAwsAuditmanagerFramework.Id),
//				Roles: auditmanager.AssessmentRoleArray{
//					&auditmanager.AssessmentRoleArgs{
//						RoleArn:  pulumi.Any(testAwsIamRole.Arn),
//						RoleType: pulumi.String("PROCESS_OWNER"),
//					},
//				},
//				Scope: &auditmanager.AssessmentScopeArgs{
//					AwsAccounts: auditmanager.AssessmentScopeAwsAccountArray{
//						&auditmanager.AssessmentScopeAwsAccountArgs{
//							Id: pulumi.Any(current.AccountId),
//						},
//					},
//					AwsServices: auditmanager.AssessmentScopeAwsServiceArray{
//						&auditmanager.AssessmentScopeAwsServiceArgs{
//							ServiceName: pulumi.String("S3"),
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
// Using `pulumi import`, import Audit Manager Assessments using the assessment `id`. For example:
//
// ```sh
// $ pulumi import aws:auditmanager/assessment:Assessment example abc123-de45
// ```
type Assessment struct {
	pulumi.CustomResourceState

	// Amazon Resource Name (ARN) of the assessment.
	Arn pulumi.StringOutput `pulumi:"arn"`
	// Assessment report storage destination configuration. See `assessmentReportsDestination` below.
	AssessmentReportsDestination AssessmentAssessmentReportsDestinationPtrOutput `pulumi:"assessmentReportsDestination"`
	// Description of the assessment.
	Description pulumi.StringPtrOutput `pulumi:"description"`
	// Unique identifier of the framework the assessment will be created from.
	FrameworkId pulumi.StringOutput `pulumi:"frameworkId"`
	// Name of the assessment.
	Name pulumi.StringOutput `pulumi:"name"`
	// List of roles for the assessment. See `roles` below.
	Roles AssessmentRoleArrayOutput `pulumi:"roles"`
	// Complete list of all roles with access to the assessment. This includes both roles explicitly configured via the `roles` block, and any roles which have access to all Audit Manager assessments by default.
	RolesAlls AssessmentRolesAllArrayOutput `pulumi:"rolesAlls"`
	// Amazon Web Services accounts and services that are in scope for the assessment. See `scope` below.
	//
	// The following arguments are optional:
	Scope AssessmentScopePtrOutput `pulumi:"scope"`
	// Status of the assessment. Valid values are `ACTIVE` and `INACTIVE`.
	Status pulumi.StringOutput `pulumi:"status"`
	// A map of tags to assign to the assessment. If configured with a provider `defaultTags` configuration block present, tags with matching keys will overwrite those defined at the provider-level.
	Tags pulumi.StringMapOutput `pulumi:"tags"`
	// Deprecated: Please use `tags` instead.
	TagsAll pulumi.StringMapOutput `pulumi:"tagsAll"`
}

// NewAssessment registers a new resource with the given unique name, arguments, and options.
func NewAssessment(ctx *pulumi.Context,
	name string, args *AssessmentArgs, opts ...pulumi.ResourceOption) (*Assessment, error) {
	if args == nil {
		return nil, errors.New("missing one or more required arguments")
	}

	if args.FrameworkId == nil {
		return nil, errors.New("invalid value for required argument 'FrameworkId'")
	}
	if args.Roles == nil {
		return nil, errors.New("invalid value for required argument 'Roles'")
	}
	opts = internal.PkgResourceDefaultOpts(opts)
	var resource Assessment
	err := ctx.RegisterResource("aws:auditmanager/assessment:Assessment", name, args, &resource, opts...)
	if err != nil {
		return nil, err
	}
	return &resource, nil
}

// GetAssessment gets an existing Assessment resource's state with the given name, ID, and optional
// state properties that are used to uniquely qualify the lookup (nil if not required).
func GetAssessment(ctx *pulumi.Context,
	name string, id pulumi.IDInput, state *AssessmentState, opts ...pulumi.ResourceOption) (*Assessment, error) {
	var resource Assessment
	err := ctx.ReadResource("aws:auditmanager/assessment:Assessment", name, id, state, &resource, opts...)
	if err != nil {
		return nil, err
	}
	return &resource, nil
}

// Input properties used for looking up and filtering Assessment resources.
type assessmentState struct {
	// Amazon Resource Name (ARN) of the assessment.
	Arn *string `pulumi:"arn"`
	// Assessment report storage destination configuration. See `assessmentReportsDestination` below.
	AssessmentReportsDestination *AssessmentAssessmentReportsDestination `pulumi:"assessmentReportsDestination"`
	// Description of the assessment.
	Description *string `pulumi:"description"`
	// Unique identifier of the framework the assessment will be created from.
	FrameworkId *string `pulumi:"frameworkId"`
	// Name of the assessment.
	Name *string `pulumi:"name"`
	// List of roles for the assessment. See `roles` below.
	Roles []AssessmentRole `pulumi:"roles"`
	// Complete list of all roles with access to the assessment. This includes both roles explicitly configured via the `roles` block, and any roles which have access to all Audit Manager assessments by default.
	RolesAlls []AssessmentRolesAll `pulumi:"rolesAlls"`
	// Amazon Web Services accounts and services that are in scope for the assessment. See `scope` below.
	//
	// The following arguments are optional:
	Scope *AssessmentScope `pulumi:"scope"`
	// Status of the assessment. Valid values are `ACTIVE` and `INACTIVE`.
	Status *string `pulumi:"status"`
	// A map of tags to assign to the assessment. If configured with a provider `defaultTags` configuration block present, tags with matching keys will overwrite those defined at the provider-level.
	Tags map[string]string `pulumi:"tags"`
	// Deprecated: Please use `tags` instead.
	TagsAll map[string]string `pulumi:"tagsAll"`
}

type AssessmentState struct {
	// Amazon Resource Name (ARN) of the assessment.
	Arn pulumi.StringPtrInput
	// Assessment report storage destination configuration. See `assessmentReportsDestination` below.
	AssessmentReportsDestination AssessmentAssessmentReportsDestinationPtrInput
	// Description of the assessment.
	Description pulumi.StringPtrInput
	// Unique identifier of the framework the assessment will be created from.
	FrameworkId pulumi.StringPtrInput
	// Name of the assessment.
	Name pulumi.StringPtrInput
	// List of roles for the assessment. See `roles` below.
	Roles AssessmentRoleArrayInput
	// Complete list of all roles with access to the assessment. This includes both roles explicitly configured via the `roles` block, and any roles which have access to all Audit Manager assessments by default.
	RolesAlls AssessmentRolesAllArrayInput
	// Amazon Web Services accounts and services that are in scope for the assessment. See `scope` below.
	//
	// The following arguments are optional:
	Scope AssessmentScopePtrInput
	// Status of the assessment. Valid values are `ACTIVE` and `INACTIVE`.
	Status pulumi.StringPtrInput
	// A map of tags to assign to the assessment. If configured with a provider `defaultTags` configuration block present, tags with matching keys will overwrite those defined at the provider-level.
	Tags pulumi.StringMapInput
	// Deprecated: Please use `tags` instead.
	TagsAll pulumi.StringMapInput
}

func (AssessmentState) ElementType() reflect.Type {
	return reflect.TypeOf((*assessmentState)(nil)).Elem()
}

type assessmentArgs struct {
	// Assessment report storage destination configuration. See `assessmentReportsDestination` below.
	AssessmentReportsDestination *AssessmentAssessmentReportsDestination `pulumi:"assessmentReportsDestination"`
	// Description of the assessment.
	Description *string `pulumi:"description"`
	// Unique identifier of the framework the assessment will be created from.
	FrameworkId string `pulumi:"frameworkId"`
	// Name of the assessment.
	Name *string `pulumi:"name"`
	// List of roles for the assessment. See `roles` below.
	Roles []AssessmentRole `pulumi:"roles"`
	// Amazon Web Services accounts and services that are in scope for the assessment. See `scope` below.
	//
	// The following arguments are optional:
	Scope *AssessmentScope `pulumi:"scope"`
	// A map of tags to assign to the assessment. If configured with a provider `defaultTags` configuration block present, tags with matching keys will overwrite those defined at the provider-level.
	Tags map[string]string `pulumi:"tags"`
}

// The set of arguments for constructing a Assessment resource.
type AssessmentArgs struct {
	// Assessment report storage destination configuration. See `assessmentReportsDestination` below.
	AssessmentReportsDestination AssessmentAssessmentReportsDestinationPtrInput
	// Description of the assessment.
	Description pulumi.StringPtrInput
	// Unique identifier of the framework the assessment will be created from.
	FrameworkId pulumi.StringInput
	// Name of the assessment.
	Name pulumi.StringPtrInput
	// List of roles for the assessment. See `roles` below.
	Roles AssessmentRoleArrayInput
	// Amazon Web Services accounts and services that are in scope for the assessment. See `scope` below.
	//
	// The following arguments are optional:
	Scope AssessmentScopePtrInput
	// A map of tags to assign to the assessment. If configured with a provider `defaultTags` configuration block present, tags with matching keys will overwrite those defined at the provider-level.
	Tags pulumi.StringMapInput
}

func (AssessmentArgs) ElementType() reflect.Type {
	return reflect.TypeOf((*assessmentArgs)(nil)).Elem()
}

type AssessmentInput interface {
	pulumi.Input

	ToAssessmentOutput() AssessmentOutput
	ToAssessmentOutputWithContext(ctx context.Context) AssessmentOutput
}

func (*Assessment) ElementType() reflect.Type {
	return reflect.TypeOf((**Assessment)(nil)).Elem()
}

func (i *Assessment) ToAssessmentOutput() AssessmentOutput {
	return i.ToAssessmentOutputWithContext(context.Background())
}

func (i *Assessment) ToAssessmentOutputWithContext(ctx context.Context) AssessmentOutput {
	return pulumi.ToOutputWithContext(ctx, i).(AssessmentOutput)
}

// AssessmentArrayInput is an input type that accepts AssessmentArray and AssessmentArrayOutput values.
// You can construct a concrete instance of `AssessmentArrayInput` via:
//
//	AssessmentArray{ AssessmentArgs{...} }
type AssessmentArrayInput interface {
	pulumi.Input

	ToAssessmentArrayOutput() AssessmentArrayOutput
	ToAssessmentArrayOutputWithContext(context.Context) AssessmentArrayOutput
}

type AssessmentArray []AssessmentInput

func (AssessmentArray) ElementType() reflect.Type {
	return reflect.TypeOf((*[]*Assessment)(nil)).Elem()
}

func (i AssessmentArray) ToAssessmentArrayOutput() AssessmentArrayOutput {
	return i.ToAssessmentArrayOutputWithContext(context.Background())
}

func (i AssessmentArray) ToAssessmentArrayOutputWithContext(ctx context.Context) AssessmentArrayOutput {
	return pulumi.ToOutputWithContext(ctx, i).(AssessmentArrayOutput)
}

// AssessmentMapInput is an input type that accepts AssessmentMap and AssessmentMapOutput values.
// You can construct a concrete instance of `AssessmentMapInput` via:
//
//	AssessmentMap{ "key": AssessmentArgs{...} }
type AssessmentMapInput interface {
	pulumi.Input

	ToAssessmentMapOutput() AssessmentMapOutput
	ToAssessmentMapOutputWithContext(context.Context) AssessmentMapOutput
}

type AssessmentMap map[string]AssessmentInput

func (AssessmentMap) ElementType() reflect.Type {
	return reflect.TypeOf((*map[string]*Assessment)(nil)).Elem()
}

func (i AssessmentMap) ToAssessmentMapOutput() AssessmentMapOutput {
	return i.ToAssessmentMapOutputWithContext(context.Background())
}

func (i AssessmentMap) ToAssessmentMapOutputWithContext(ctx context.Context) AssessmentMapOutput {
	return pulumi.ToOutputWithContext(ctx, i).(AssessmentMapOutput)
}

type AssessmentOutput struct{ *pulumi.OutputState }

func (AssessmentOutput) ElementType() reflect.Type {
	return reflect.TypeOf((**Assessment)(nil)).Elem()
}

func (o AssessmentOutput) ToAssessmentOutput() AssessmentOutput {
	return o
}

func (o AssessmentOutput) ToAssessmentOutputWithContext(ctx context.Context) AssessmentOutput {
	return o
}

// Amazon Resource Name (ARN) of the assessment.
func (o AssessmentOutput) Arn() pulumi.StringOutput {
	return o.ApplyT(func(v *Assessment) pulumi.StringOutput { return v.Arn }).(pulumi.StringOutput)
}

// Assessment report storage destination configuration. See `assessmentReportsDestination` below.
func (o AssessmentOutput) AssessmentReportsDestination() AssessmentAssessmentReportsDestinationPtrOutput {
	return o.ApplyT(func(v *Assessment) AssessmentAssessmentReportsDestinationPtrOutput {
		return v.AssessmentReportsDestination
	}).(AssessmentAssessmentReportsDestinationPtrOutput)
}

// Description of the assessment.
func (o AssessmentOutput) Description() pulumi.StringPtrOutput {
	return o.ApplyT(func(v *Assessment) pulumi.StringPtrOutput { return v.Description }).(pulumi.StringPtrOutput)
}

// Unique identifier of the framework the assessment will be created from.
func (o AssessmentOutput) FrameworkId() pulumi.StringOutput {
	return o.ApplyT(func(v *Assessment) pulumi.StringOutput { return v.FrameworkId }).(pulumi.StringOutput)
}

// Name of the assessment.
func (o AssessmentOutput) Name() pulumi.StringOutput {
	return o.ApplyT(func(v *Assessment) pulumi.StringOutput { return v.Name }).(pulumi.StringOutput)
}

// List of roles for the assessment. See `roles` below.
func (o AssessmentOutput) Roles() AssessmentRoleArrayOutput {
	return o.ApplyT(func(v *Assessment) AssessmentRoleArrayOutput { return v.Roles }).(AssessmentRoleArrayOutput)
}

// Complete list of all roles with access to the assessment. This includes both roles explicitly configured via the `roles` block, and any roles which have access to all Audit Manager assessments by default.
func (o AssessmentOutput) RolesAlls() AssessmentRolesAllArrayOutput {
	return o.ApplyT(func(v *Assessment) AssessmentRolesAllArrayOutput { return v.RolesAlls }).(AssessmentRolesAllArrayOutput)
}

// Amazon Web Services accounts and services that are in scope for the assessment. See `scope` below.
//
// The following arguments are optional:
func (o AssessmentOutput) Scope() AssessmentScopePtrOutput {
	return o.ApplyT(func(v *Assessment) AssessmentScopePtrOutput { return v.Scope }).(AssessmentScopePtrOutput)
}

// Status of the assessment. Valid values are `ACTIVE` and `INACTIVE`.
func (o AssessmentOutput) Status() pulumi.StringOutput {
	return o.ApplyT(func(v *Assessment) pulumi.StringOutput { return v.Status }).(pulumi.StringOutput)
}

// A map of tags to assign to the assessment. If configured with a provider `defaultTags` configuration block present, tags with matching keys will overwrite those defined at the provider-level.
func (o AssessmentOutput) Tags() pulumi.StringMapOutput {
	return o.ApplyT(func(v *Assessment) pulumi.StringMapOutput { return v.Tags }).(pulumi.StringMapOutput)
}

// Deprecated: Please use `tags` instead.
func (o AssessmentOutput) TagsAll() pulumi.StringMapOutput {
	return o.ApplyT(func(v *Assessment) pulumi.StringMapOutput { return v.TagsAll }).(pulumi.StringMapOutput)
}

type AssessmentArrayOutput struct{ *pulumi.OutputState }

func (AssessmentArrayOutput) ElementType() reflect.Type {
	return reflect.TypeOf((*[]*Assessment)(nil)).Elem()
}

func (o AssessmentArrayOutput) ToAssessmentArrayOutput() AssessmentArrayOutput {
	return o
}

func (o AssessmentArrayOutput) ToAssessmentArrayOutputWithContext(ctx context.Context) AssessmentArrayOutput {
	return o
}

func (o AssessmentArrayOutput) Index(i pulumi.IntInput) AssessmentOutput {
	return pulumi.All(o, i).ApplyT(func(vs []interface{}) *Assessment {
		return vs[0].([]*Assessment)[vs[1].(int)]
	}).(AssessmentOutput)
}

type AssessmentMapOutput struct{ *pulumi.OutputState }

func (AssessmentMapOutput) ElementType() reflect.Type {
	return reflect.TypeOf((*map[string]*Assessment)(nil)).Elem()
}

func (o AssessmentMapOutput) ToAssessmentMapOutput() AssessmentMapOutput {
	return o
}

func (o AssessmentMapOutput) ToAssessmentMapOutputWithContext(ctx context.Context) AssessmentMapOutput {
	return o
}

func (o AssessmentMapOutput) MapIndex(k pulumi.StringInput) AssessmentOutput {
	return pulumi.All(o, k).ApplyT(func(vs []interface{}) *Assessment {
		return vs[0].(map[string]*Assessment)[vs[1].(string)]
	}).(AssessmentOutput)
}

func init() {
	pulumi.RegisterInputType(reflect.TypeOf((*AssessmentInput)(nil)).Elem(), &Assessment{})
	pulumi.RegisterInputType(reflect.TypeOf((*AssessmentArrayInput)(nil)).Elem(), AssessmentArray{})
	pulumi.RegisterInputType(reflect.TypeOf((*AssessmentMapInput)(nil)).Elem(), AssessmentMap{})
	pulumi.RegisterOutputType(AssessmentOutput{})
	pulumi.RegisterOutputType(AssessmentArrayOutput{})
	pulumi.RegisterOutputType(AssessmentMapOutput{})
}
