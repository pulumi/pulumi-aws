// Code generated by pulumi-language-go DO NOT EDIT.
// *** WARNING: Do not edit by hand unless you're certain you know what you are doing! ***

package rum

import (
	"context"
	"reflect"

	"github.com/pulumi/pulumi-aws/sdk/v6/go/aws/internal"
	"github.com/pulumi/pulumi/sdk/v3/go/pulumi"
)

var _ = internal.GetEnvOrDefault

type AppMonitorAppMonitorConfiguration struct {
	// If you set this to `true`, RUM web client sets two cookies, a session cookie and a user cookie. The cookies allow the RUM web client to collect data relating to the number of users an application has and the behavior of the application across a sequence of events. Cookies are stored in the top-level domain of the current page.
	AllowCookies *bool `pulumi:"allowCookies"`
	// If you set this to `true`, RUM enables X-Ray tracing for the user sessions that RUM samples. RUM adds an X-Ray trace header to allowed HTTP requests. It also records an X-Ray segment for allowed HTTP requests.
	EnableXray *bool `pulumi:"enableXray"`
	// A list of URLs in your website or application to exclude from RUM data collection.
	ExcludedPages []string `pulumi:"excludedPages"`
	// A list of pages in the CloudWatch RUM console that are to be displayed with a "favorite" icon.
	FavoritePages []string `pulumi:"favoritePages"`
	// The ARN of the guest IAM role that is attached to the Amazon Cognito identity pool that is used to authorize the sending of data to RUM.
	GuestRoleArn *string `pulumi:"guestRoleArn"`
	// The ID of the Amazon Cognito identity pool that is used to authorize the sending of data to RUM.
	IdentityPoolId *string `pulumi:"identityPoolId"`
	// If this app monitor is to collect data from only certain pages in your application, this structure lists those pages.
	IncludedPages []string `pulumi:"includedPages"`
	// Specifies the percentage of user sessions to use for RUM data collection. Choosing a higher percentage gives you more data but also incurs more costs. The number you specify is the percentage of user sessions that will be used. Default value is `0.1`.
	SessionSampleRate *float64 `pulumi:"sessionSampleRate"`
	// An array that lists the types of telemetry data that this app monitor is to collect. Valid values are `errors`, `performance`, and `http`.
	Telemetries []string `pulumi:"telemetries"`
}

// AppMonitorAppMonitorConfigurationInput is an input type that accepts AppMonitorAppMonitorConfigurationArgs and AppMonitorAppMonitorConfigurationOutput values.
// You can construct a concrete instance of `AppMonitorAppMonitorConfigurationInput` via:
//
//	AppMonitorAppMonitorConfigurationArgs{...}
type AppMonitorAppMonitorConfigurationInput interface {
	pulumi.Input

	ToAppMonitorAppMonitorConfigurationOutput() AppMonitorAppMonitorConfigurationOutput
	ToAppMonitorAppMonitorConfigurationOutputWithContext(context.Context) AppMonitorAppMonitorConfigurationOutput
}

type AppMonitorAppMonitorConfigurationArgs struct {
	// If you set this to `true`, RUM web client sets two cookies, a session cookie and a user cookie. The cookies allow the RUM web client to collect data relating to the number of users an application has and the behavior of the application across a sequence of events. Cookies are stored in the top-level domain of the current page.
	AllowCookies pulumi.BoolPtrInput `pulumi:"allowCookies"`
	// If you set this to `true`, RUM enables X-Ray tracing for the user sessions that RUM samples. RUM adds an X-Ray trace header to allowed HTTP requests. It also records an X-Ray segment for allowed HTTP requests.
	EnableXray pulumi.BoolPtrInput `pulumi:"enableXray"`
	// A list of URLs in your website or application to exclude from RUM data collection.
	ExcludedPages pulumi.StringArrayInput `pulumi:"excludedPages"`
	// A list of pages in the CloudWatch RUM console that are to be displayed with a "favorite" icon.
	FavoritePages pulumi.StringArrayInput `pulumi:"favoritePages"`
	// The ARN of the guest IAM role that is attached to the Amazon Cognito identity pool that is used to authorize the sending of data to RUM.
	GuestRoleArn pulumi.StringPtrInput `pulumi:"guestRoleArn"`
	// The ID of the Amazon Cognito identity pool that is used to authorize the sending of data to RUM.
	IdentityPoolId pulumi.StringPtrInput `pulumi:"identityPoolId"`
	// If this app monitor is to collect data from only certain pages in your application, this structure lists those pages.
	IncludedPages pulumi.StringArrayInput `pulumi:"includedPages"`
	// Specifies the percentage of user sessions to use for RUM data collection. Choosing a higher percentage gives you more data but also incurs more costs. The number you specify is the percentage of user sessions that will be used. Default value is `0.1`.
	SessionSampleRate pulumi.Float64PtrInput `pulumi:"sessionSampleRate"`
	// An array that lists the types of telemetry data that this app monitor is to collect. Valid values are `errors`, `performance`, and `http`.
	Telemetries pulumi.StringArrayInput `pulumi:"telemetries"`
}

func (AppMonitorAppMonitorConfigurationArgs) ElementType() reflect.Type {
	return reflect.TypeOf((*AppMonitorAppMonitorConfiguration)(nil)).Elem()
}

func (i AppMonitorAppMonitorConfigurationArgs) ToAppMonitorAppMonitorConfigurationOutput() AppMonitorAppMonitorConfigurationOutput {
	return i.ToAppMonitorAppMonitorConfigurationOutputWithContext(context.Background())
}

func (i AppMonitorAppMonitorConfigurationArgs) ToAppMonitorAppMonitorConfigurationOutputWithContext(ctx context.Context) AppMonitorAppMonitorConfigurationOutput {
	return pulumi.ToOutputWithContext(ctx, i).(AppMonitorAppMonitorConfigurationOutput)
}

func (i AppMonitorAppMonitorConfigurationArgs) ToAppMonitorAppMonitorConfigurationPtrOutput() AppMonitorAppMonitorConfigurationPtrOutput {
	return i.ToAppMonitorAppMonitorConfigurationPtrOutputWithContext(context.Background())
}

func (i AppMonitorAppMonitorConfigurationArgs) ToAppMonitorAppMonitorConfigurationPtrOutputWithContext(ctx context.Context) AppMonitorAppMonitorConfigurationPtrOutput {
	return pulumi.ToOutputWithContext(ctx, i).(AppMonitorAppMonitorConfigurationOutput).ToAppMonitorAppMonitorConfigurationPtrOutputWithContext(ctx)
}

// AppMonitorAppMonitorConfigurationPtrInput is an input type that accepts AppMonitorAppMonitorConfigurationArgs, AppMonitorAppMonitorConfigurationPtr and AppMonitorAppMonitorConfigurationPtrOutput values.
// You can construct a concrete instance of `AppMonitorAppMonitorConfigurationPtrInput` via:
//
//	        AppMonitorAppMonitorConfigurationArgs{...}
//
//	or:
//
//	        nil
type AppMonitorAppMonitorConfigurationPtrInput interface {
	pulumi.Input

	ToAppMonitorAppMonitorConfigurationPtrOutput() AppMonitorAppMonitorConfigurationPtrOutput
	ToAppMonitorAppMonitorConfigurationPtrOutputWithContext(context.Context) AppMonitorAppMonitorConfigurationPtrOutput
}

type appMonitorAppMonitorConfigurationPtrType AppMonitorAppMonitorConfigurationArgs

func AppMonitorAppMonitorConfigurationPtr(v *AppMonitorAppMonitorConfigurationArgs) AppMonitorAppMonitorConfigurationPtrInput {
	return (*appMonitorAppMonitorConfigurationPtrType)(v)
}

func (*appMonitorAppMonitorConfigurationPtrType) ElementType() reflect.Type {
	return reflect.TypeOf((**AppMonitorAppMonitorConfiguration)(nil)).Elem()
}

func (i *appMonitorAppMonitorConfigurationPtrType) ToAppMonitorAppMonitorConfigurationPtrOutput() AppMonitorAppMonitorConfigurationPtrOutput {
	return i.ToAppMonitorAppMonitorConfigurationPtrOutputWithContext(context.Background())
}

func (i *appMonitorAppMonitorConfigurationPtrType) ToAppMonitorAppMonitorConfigurationPtrOutputWithContext(ctx context.Context) AppMonitorAppMonitorConfigurationPtrOutput {
	return pulumi.ToOutputWithContext(ctx, i).(AppMonitorAppMonitorConfigurationPtrOutput)
}

type AppMonitorAppMonitorConfigurationOutput struct{ *pulumi.OutputState }

func (AppMonitorAppMonitorConfigurationOutput) ElementType() reflect.Type {
	return reflect.TypeOf((*AppMonitorAppMonitorConfiguration)(nil)).Elem()
}

func (o AppMonitorAppMonitorConfigurationOutput) ToAppMonitorAppMonitorConfigurationOutput() AppMonitorAppMonitorConfigurationOutput {
	return o
}

func (o AppMonitorAppMonitorConfigurationOutput) ToAppMonitorAppMonitorConfigurationOutputWithContext(ctx context.Context) AppMonitorAppMonitorConfigurationOutput {
	return o
}

func (o AppMonitorAppMonitorConfigurationOutput) ToAppMonitorAppMonitorConfigurationPtrOutput() AppMonitorAppMonitorConfigurationPtrOutput {
	return o.ToAppMonitorAppMonitorConfigurationPtrOutputWithContext(context.Background())
}

func (o AppMonitorAppMonitorConfigurationOutput) ToAppMonitorAppMonitorConfigurationPtrOutputWithContext(ctx context.Context) AppMonitorAppMonitorConfigurationPtrOutput {
	return o.ApplyTWithContext(ctx, func(_ context.Context, v AppMonitorAppMonitorConfiguration) *AppMonitorAppMonitorConfiguration {
		return &v
	}).(AppMonitorAppMonitorConfigurationPtrOutput)
}

// If you set this to `true`, RUM web client sets two cookies, a session cookie and a user cookie. The cookies allow the RUM web client to collect data relating to the number of users an application has and the behavior of the application across a sequence of events. Cookies are stored in the top-level domain of the current page.
func (o AppMonitorAppMonitorConfigurationOutput) AllowCookies() pulumi.BoolPtrOutput {
	return o.ApplyT(func(v AppMonitorAppMonitorConfiguration) *bool { return v.AllowCookies }).(pulumi.BoolPtrOutput)
}

// If you set this to `true`, RUM enables X-Ray tracing for the user sessions that RUM samples. RUM adds an X-Ray trace header to allowed HTTP requests. It also records an X-Ray segment for allowed HTTP requests.
func (o AppMonitorAppMonitorConfigurationOutput) EnableXray() pulumi.BoolPtrOutput {
	return o.ApplyT(func(v AppMonitorAppMonitorConfiguration) *bool { return v.EnableXray }).(pulumi.BoolPtrOutput)
}

// A list of URLs in your website or application to exclude from RUM data collection.
func (o AppMonitorAppMonitorConfigurationOutput) ExcludedPages() pulumi.StringArrayOutput {
	return o.ApplyT(func(v AppMonitorAppMonitorConfiguration) []string { return v.ExcludedPages }).(pulumi.StringArrayOutput)
}

// A list of pages in the CloudWatch RUM console that are to be displayed with a "favorite" icon.
func (o AppMonitorAppMonitorConfigurationOutput) FavoritePages() pulumi.StringArrayOutput {
	return o.ApplyT(func(v AppMonitorAppMonitorConfiguration) []string { return v.FavoritePages }).(pulumi.StringArrayOutput)
}

// The ARN of the guest IAM role that is attached to the Amazon Cognito identity pool that is used to authorize the sending of data to RUM.
func (o AppMonitorAppMonitorConfigurationOutput) GuestRoleArn() pulumi.StringPtrOutput {
	return o.ApplyT(func(v AppMonitorAppMonitorConfiguration) *string { return v.GuestRoleArn }).(pulumi.StringPtrOutput)
}

// The ID of the Amazon Cognito identity pool that is used to authorize the sending of data to RUM.
func (o AppMonitorAppMonitorConfigurationOutput) IdentityPoolId() pulumi.StringPtrOutput {
	return o.ApplyT(func(v AppMonitorAppMonitorConfiguration) *string { return v.IdentityPoolId }).(pulumi.StringPtrOutput)
}

// If this app monitor is to collect data from only certain pages in your application, this structure lists those pages.
func (o AppMonitorAppMonitorConfigurationOutput) IncludedPages() pulumi.StringArrayOutput {
	return o.ApplyT(func(v AppMonitorAppMonitorConfiguration) []string { return v.IncludedPages }).(pulumi.StringArrayOutput)
}

// Specifies the percentage of user sessions to use for RUM data collection. Choosing a higher percentage gives you more data but also incurs more costs. The number you specify is the percentage of user sessions that will be used. Default value is `0.1`.
func (o AppMonitorAppMonitorConfigurationOutput) SessionSampleRate() pulumi.Float64PtrOutput {
	return o.ApplyT(func(v AppMonitorAppMonitorConfiguration) *float64 { return v.SessionSampleRate }).(pulumi.Float64PtrOutput)
}

// An array that lists the types of telemetry data that this app monitor is to collect. Valid values are `errors`, `performance`, and `http`.
func (o AppMonitorAppMonitorConfigurationOutput) Telemetries() pulumi.StringArrayOutput {
	return o.ApplyT(func(v AppMonitorAppMonitorConfiguration) []string { return v.Telemetries }).(pulumi.StringArrayOutput)
}

type AppMonitorAppMonitorConfigurationPtrOutput struct{ *pulumi.OutputState }

func (AppMonitorAppMonitorConfigurationPtrOutput) ElementType() reflect.Type {
	return reflect.TypeOf((**AppMonitorAppMonitorConfiguration)(nil)).Elem()
}

func (o AppMonitorAppMonitorConfigurationPtrOutput) ToAppMonitorAppMonitorConfigurationPtrOutput() AppMonitorAppMonitorConfigurationPtrOutput {
	return o
}

func (o AppMonitorAppMonitorConfigurationPtrOutput) ToAppMonitorAppMonitorConfigurationPtrOutputWithContext(ctx context.Context) AppMonitorAppMonitorConfigurationPtrOutput {
	return o
}

func (o AppMonitorAppMonitorConfigurationPtrOutput) Elem() AppMonitorAppMonitorConfigurationOutput {
	return o.ApplyT(func(v *AppMonitorAppMonitorConfiguration) AppMonitorAppMonitorConfiguration {
		if v != nil {
			return *v
		}
		var ret AppMonitorAppMonitorConfiguration
		return ret
	}).(AppMonitorAppMonitorConfigurationOutput)
}

// If you set this to `true`, RUM web client sets two cookies, a session cookie and a user cookie. The cookies allow the RUM web client to collect data relating to the number of users an application has and the behavior of the application across a sequence of events. Cookies are stored in the top-level domain of the current page.
func (o AppMonitorAppMonitorConfigurationPtrOutput) AllowCookies() pulumi.BoolPtrOutput {
	return o.ApplyT(func(v *AppMonitorAppMonitorConfiguration) *bool {
		if v == nil {
			return nil
		}
		return v.AllowCookies
	}).(pulumi.BoolPtrOutput)
}

// If you set this to `true`, RUM enables X-Ray tracing for the user sessions that RUM samples. RUM adds an X-Ray trace header to allowed HTTP requests. It also records an X-Ray segment for allowed HTTP requests.
func (o AppMonitorAppMonitorConfigurationPtrOutput) EnableXray() pulumi.BoolPtrOutput {
	return o.ApplyT(func(v *AppMonitorAppMonitorConfiguration) *bool {
		if v == nil {
			return nil
		}
		return v.EnableXray
	}).(pulumi.BoolPtrOutput)
}

// A list of URLs in your website or application to exclude from RUM data collection.
func (o AppMonitorAppMonitorConfigurationPtrOutput) ExcludedPages() pulumi.StringArrayOutput {
	return o.ApplyT(func(v *AppMonitorAppMonitorConfiguration) []string {
		if v == nil {
			return nil
		}
		return v.ExcludedPages
	}).(pulumi.StringArrayOutput)
}

// A list of pages in the CloudWatch RUM console that are to be displayed with a "favorite" icon.
func (o AppMonitorAppMonitorConfigurationPtrOutput) FavoritePages() pulumi.StringArrayOutput {
	return o.ApplyT(func(v *AppMonitorAppMonitorConfiguration) []string {
		if v == nil {
			return nil
		}
		return v.FavoritePages
	}).(pulumi.StringArrayOutput)
}

// The ARN of the guest IAM role that is attached to the Amazon Cognito identity pool that is used to authorize the sending of data to RUM.
func (o AppMonitorAppMonitorConfigurationPtrOutput) GuestRoleArn() pulumi.StringPtrOutput {
	return o.ApplyT(func(v *AppMonitorAppMonitorConfiguration) *string {
		if v == nil {
			return nil
		}
		return v.GuestRoleArn
	}).(pulumi.StringPtrOutput)
}

// The ID of the Amazon Cognito identity pool that is used to authorize the sending of data to RUM.
func (o AppMonitorAppMonitorConfigurationPtrOutput) IdentityPoolId() pulumi.StringPtrOutput {
	return o.ApplyT(func(v *AppMonitorAppMonitorConfiguration) *string {
		if v == nil {
			return nil
		}
		return v.IdentityPoolId
	}).(pulumi.StringPtrOutput)
}

// If this app monitor is to collect data from only certain pages in your application, this structure lists those pages.
func (o AppMonitorAppMonitorConfigurationPtrOutput) IncludedPages() pulumi.StringArrayOutput {
	return o.ApplyT(func(v *AppMonitorAppMonitorConfiguration) []string {
		if v == nil {
			return nil
		}
		return v.IncludedPages
	}).(pulumi.StringArrayOutput)
}

// Specifies the percentage of user sessions to use for RUM data collection. Choosing a higher percentage gives you more data but also incurs more costs. The number you specify is the percentage of user sessions that will be used. Default value is `0.1`.
func (o AppMonitorAppMonitorConfigurationPtrOutput) SessionSampleRate() pulumi.Float64PtrOutput {
	return o.ApplyT(func(v *AppMonitorAppMonitorConfiguration) *float64 {
		if v == nil {
			return nil
		}
		return v.SessionSampleRate
	}).(pulumi.Float64PtrOutput)
}

// An array that lists the types of telemetry data that this app monitor is to collect. Valid values are `errors`, `performance`, and `http`.
func (o AppMonitorAppMonitorConfigurationPtrOutput) Telemetries() pulumi.StringArrayOutput {
	return o.ApplyT(func(v *AppMonitorAppMonitorConfiguration) []string {
		if v == nil {
			return nil
		}
		return v.Telemetries
	}).(pulumi.StringArrayOutput)
}

type AppMonitorCustomEvents struct {
	// Specifies whether this app monitor allows the web client to define and send custom events. The default is for custom events to be `DISABLED`. Valid values are `DISABLED` and `ENABLED`.
	Status *string `pulumi:"status"`
}

// AppMonitorCustomEventsInput is an input type that accepts AppMonitorCustomEventsArgs and AppMonitorCustomEventsOutput values.
// You can construct a concrete instance of `AppMonitorCustomEventsInput` via:
//
//	AppMonitorCustomEventsArgs{...}
type AppMonitorCustomEventsInput interface {
	pulumi.Input

	ToAppMonitorCustomEventsOutput() AppMonitorCustomEventsOutput
	ToAppMonitorCustomEventsOutputWithContext(context.Context) AppMonitorCustomEventsOutput
}

type AppMonitorCustomEventsArgs struct {
	// Specifies whether this app monitor allows the web client to define and send custom events. The default is for custom events to be `DISABLED`. Valid values are `DISABLED` and `ENABLED`.
	Status pulumi.StringPtrInput `pulumi:"status"`
}

func (AppMonitorCustomEventsArgs) ElementType() reflect.Type {
	return reflect.TypeOf((*AppMonitorCustomEvents)(nil)).Elem()
}

func (i AppMonitorCustomEventsArgs) ToAppMonitorCustomEventsOutput() AppMonitorCustomEventsOutput {
	return i.ToAppMonitorCustomEventsOutputWithContext(context.Background())
}

func (i AppMonitorCustomEventsArgs) ToAppMonitorCustomEventsOutputWithContext(ctx context.Context) AppMonitorCustomEventsOutput {
	return pulumi.ToOutputWithContext(ctx, i).(AppMonitorCustomEventsOutput)
}

func (i AppMonitorCustomEventsArgs) ToAppMonitorCustomEventsPtrOutput() AppMonitorCustomEventsPtrOutput {
	return i.ToAppMonitorCustomEventsPtrOutputWithContext(context.Background())
}

func (i AppMonitorCustomEventsArgs) ToAppMonitorCustomEventsPtrOutputWithContext(ctx context.Context) AppMonitorCustomEventsPtrOutput {
	return pulumi.ToOutputWithContext(ctx, i).(AppMonitorCustomEventsOutput).ToAppMonitorCustomEventsPtrOutputWithContext(ctx)
}

// AppMonitorCustomEventsPtrInput is an input type that accepts AppMonitorCustomEventsArgs, AppMonitorCustomEventsPtr and AppMonitorCustomEventsPtrOutput values.
// You can construct a concrete instance of `AppMonitorCustomEventsPtrInput` via:
//
//	        AppMonitorCustomEventsArgs{...}
//
//	or:
//
//	        nil
type AppMonitorCustomEventsPtrInput interface {
	pulumi.Input

	ToAppMonitorCustomEventsPtrOutput() AppMonitorCustomEventsPtrOutput
	ToAppMonitorCustomEventsPtrOutputWithContext(context.Context) AppMonitorCustomEventsPtrOutput
}

type appMonitorCustomEventsPtrType AppMonitorCustomEventsArgs

func AppMonitorCustomEventsPtr(v *AppMonitorCustomEventsArgs) AppMonitorCustomEventsPtrInput {
	return (*appMonitorCustomEventsPtrType)(v)
}

func (*appMonitorCustomEventsPtrType) ElementType() reflect.Type {
	return reflect.TypeOf((**AppMonitorCustomEvents)(nil)).Elem()
}

func (i *appMonitorCustomEventsPtrType) ToAppMonitorCustomEventsPtrOutput() AppMonitorCustomEventsPtrOutput {
	return i.ToAppMonitorCustomEventsPtrOutputWithContext(context.Background())
}

func (i *appMonitorCustomEventsPtrType) ToAppMonitorCustomEventsPtrOutputWithContext(ctx context.Context) AppMonitorCustomEventsPtrOutput {
	return pulumi.ToOutputWithContext(ctx, i).(AppMonitorCustomEventsPtrOutput)
}

type AppMonitorCustomEventsOutput struct{ *pulumi.OutputState }

func (AppMonitorCustomEventsOutput) ElementType() reflect.Type {
	return reflect.TypeOf((*AppMonitorCustomEvents)(nil)).Elem()
}

func (o AppMonitorCustomEventsOutput) ToAppMonitorCustomEventsOutput() AppMonitorCustomEventsOutput {
	return o
}

func (o AppMonitorCustomEventsOutput) ToAppMonitorCustomEventsOutputWithContext(ctx context.Context) AppMonitorCustomEventsOutput {
	return o
}

func (o AppMonitorCustomEventsOutput) ToAppMonitorCustomEventsPtrOutput() AppMonitorCustomEventsPtrOutput {
	return o.ToAppMonitorCustomEventsPtrOutputWithContext(context.Background())
}

func (o AppMonitorCustomEventsOutput) ToAppMonitorCustomEventsPtrOutputWithContext(ctx context.Context) AppMonitorCustomEventsPtrOutput {
	return o.ApplyTWithContext(ctx, func(_ context.Context, v AppMonitorCustomEvents) *AppMonitorCustomEvents {
		return &v
	}).(AppMonitorCustomEventsPtrOutput)
}

// Specifies whether this app monitor allows the web client to define and send custom events. The default is for custom events to be `DISABLED`. Valid values are `DISABLED` and `ENABLED`.
func (o AppMonitorCustomEventsOutput) Status() pulumi.StringPtrOutput {
	return o.ApplyT(func(v AppMonitorCustomEvents) *string { return v.Status }).(pulumi.StringPtrOutput)
}

type AppMonitorCustomEventsPtrOutput struct{ *pulumi.OutputState }

func (AppMonitorCustomEventsPtrOutput) ElementType() reflect.Type {
	return reflect.TypeOf((**AppMonitorCustomEvents)(nil)).Elem()
}

func (o AppMonitorCustomEventsPtrOutput) ToAppMonitorCustomEventsPtrOutput() AppMonitorCustomEventsPtrOutput {
	return o
}

func (o AppMonitorCustomEventsPtrOutput) ToAppMonitorCustomEventsPtrOutputWithContext(ctx context.Context) AppMonitorCustomEventsPtrOutput {
	return o
}

func (o AppMonitorCustomEventsPtrOutput) Elem() AppMonitorCustomEventsOutput {
	return o.ApplyT(func(v *AppMonitorCustomEvents) AppMonitorCustomEvents {
		if v != nil {
			return *v
		}
		var ret AppMonitorCustomEvents
		return ret
	}).(AppMonitorCustomEventsOutput)
}

// Specifies whether this app monitor allows the web client to define and send custom events. The default is for custom events to be `DISABLED`. Valid values are `DISABLED` and `ENABLED`.
func (o AppMonitorCustomEventsPtrOutput) Status() pulumi.StringPtrOutput {
	return o.ApplyT(func(v *AppMonitorCustomEvents) *string {
		if v == nil {
			return nil
		}
		return v.Status
	}).(pulumi.StringPtrOutput)
}

func init() {
	pulumi.RegisterInputType(reflect.TypeOf((*AppMonitorAppMonitorConfigurationInput)(nil)).Elem(), AppMonitorAppMonitorConfigurationArgs{})
	pulumi.RegisterInputType(reflect.TypeOf((*AppMonitorAppMonitorConfigurationPtrInput)(nil)).Elem(), AppMonitorAppMonitorConfigurationArgs{})
	pulumi.RegisterInputType(reflect.TypeOf((*AppMonitorCustomEventsInput)(nil)).Elem(), AppMonitorCustomEventsArgs{})
	pulumi.RegisterInputType(reflect.TypeOf((*AppMonitorCustomEventsPtrInput)(nil)).Elem(), AppMonitorCustomEventsArgs{})
	pulumi.RegisterOutputType(AppMonitorAppMonitorConfigurationOutput{})
	pulumi.RegisterOutputType(AppMonitorAppMonitorConfigurationPtrOutput{})
	pulumi.RegisterOutputType(AppMonitorCustomEventsOutput{})
	pulumi.RegisterOutputType(AppMonitorCustomEventsPtrOutput{})
}
