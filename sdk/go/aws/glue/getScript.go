// Code generated by pulumi-language-go DO NOT EDIT.
// *** WARNING: Do not edit by hand unless you're certain you know what you are doing! ***

package glue

import (
	"context"
	"reflect"

	"github.com/pulumi/pulumi-aws/sdk/v6/go/aws/internal"
	"github.com/pulumi/pulumi/sdk/v3/go/pulumi"
)

// Use this data source to generate a Glue script from a Directed Acyclic Graph (DAG).
//
// ## Example Usage
//
// ### Generate Python Script
//
// ```go
// package main
//
// import (
//
//	"fmt"
//
//	"github.com/pulumi/pulumi-aws/sdk/v6/go/aws/glue"
//	"github.com/pulumi/pulumi/sdk/v3/go/pulumi"
//
// )
//
//	func main() {
//		pulumi.Run(func(ctx *pulumi.Context) error {
//			example, err := glue.GetScript(ctx, &glue.GetScriptArgs{
//				Language: pulumi.StringRef("PYTHON"),
//				DagEdges: []glue.GetScriptDagEdge{
//					{
//						Source: "datasource0",
//						Target: "applymapping1",
//					},
//					{
//						Source: "applymapping1",
//						Target: "selectfields2",
//					},
//					{
//						Source: "selectfields2",
//						Target: "resolvechoice3",
//					},
//					{
//						Source: "resolvechoice3",
//						Target: "datasink4",
//					},
//				},
//				DagNodes: []glue.GetScriptDagNode{
//					{
//						Id:       "datasource0",
//						NodeType: "DataSource",
//						Args: []glue.GetScriptDagNodeArg{
//							{
//								Name:  "database",
//								Value: fmt.Sprintf("\"%v\"", source.Name),
//							},
//							{
//								Name:  "table_name",
//								Value: fmt.Sprintf("\"%v\"", sourceAwsGlueCatalogTable.Name),
//							},
//						},
//					},
//					{
//						Id:       "applymapping1",
//						NodeType: "ApplyMapping",
//						Args: []glue.GetScriptDagNodeArg{
//							{
//								Name:  "mapping",
//								Value: "[(\"column1\", \"string\", \"column1\", \"string\")]",
//							},
//						},
//					},
//					{
//						Id:       "selectfields2",
//						NodeType: "SelectFields",
//						Args: []glue.GetScriptDagNodeArg{
//							{
//								Name:  "paths",
//								Value: "[\"column1\"]",
//							},
//						},
//					},
//					{
//						Id:       "resolvechoice3",
//						NodeType: "ResolveChoice",
//						Args: []glue.GetScriptDagNodeArg{
//							{
//								Name:  "choice",
//								Value: "\"MATCH_CATALOG\"",
//							},
//							{
//								Name:  "database",
//								Value: fmt.Sprintf("\"%v\"", destination.Name),
//							},
//							{
//								Name:  "table_name",
//								Value: fmt.Sprintf("\"%v\"", destinationAwsGlueCatalogTable.Name),
//							},
//						},
//					},
//					{
//						Id:       "datasink4",
//						NodeType: "DataSink",
//						Args: []glue.GetScriptDagNodeArg{
//							{
//								Name:  "database",
//								Value: fmt.Sprintf("\"%v\"", destination.Name),
//							},
//							{
//								Name:  "table_name",
//								Value: fmt.Sprintf("\"%v\"", destinationAwsGlueCatalogTable.Name),
//							},
//						},
//					},
//				},
//			}, nil)
//			if err != nil {
//				return err
//			}
//			ctx.Export("pythonScript", example.PythonScript)
//			return nil
//		})
//	}
//
// ```
//
// ### Generate Scala Code
//
// ```go
// package main
//
// import (
//
//	"fmt"
//
//	"github.com/pulumi/pulumi-aws/sdk/v6/go/aws/glue"
//	"github.com/pulumi/pulumi/sdk/v3/go/pulumi"
//
// )
//
//	func main() {
//		pulumi.Run(func(ctx *pulumi.Context) error {
//			example, err := glue.GetScript(ctx, &glue.GetScriptArgs{
//				Language: pulumi.StringRef("SCALA"),
//				DagEdges: []glue.GetScriptDagEdge{
//					{
//						Source: "datasource0",
//						Target: "applymapping1",
//					},
//					{
//						Source: "applymapping1",
//						Target: "selectfields2",
//					},
//					{
//						Source: "selectfields2",
//						Target: "resolvechoice3",
//					},
//					{
//						Source: "resolvechoice3",
//						Target: "datasink4",
//					},
//				},
//				DagNodes: []glue.GetScriptDagNode{
//					{
//						Id:       "datasource0",
//						NodeType: "DataSource",
//						Args: []glue.GetScriptDagNodeArg{
//							{
//								Name:  "database",
//								Value: fmt.Sprintf("\"%v\"", source.Name),
//							},
//							{
//								Name:  "table_name",
//								Value: fmt.Sprintf("\"%v\"", sourceAwsGlueCatalogTable.Name),
//							},
//						},
//					},
//					{
//						Id:       "applymapping1",
//						NodeType: "ApplyMapping",
//						Args: []glue.GetScriptDagNodeArg{
//							{
//								Name:  "mappings",
//								Value: "[(\"column1\", \"string\", \"column1\", \"string\")]",
//							},
//						},
//					},
//					{
//						Id:       "selectfields2",
//						NodeType: "SelectFields",
//						Args: []glue.GetScriptDagNodeArg{
//							{
//								Name:  "paths",
//								Value: "[\"column1\"]",
//							},
//						},
//					},
//					{
//						Id:       "resolvechoice3",
//						NodeType: "ResolveChoice",
//						Args: []glue.GetScriptDagNodeArg{
//							{
//								Name:  "choice",
//								Value: "\"MATCH_CATALOG\"",
//							},
//							{
//								Name:  "database",
//								Value: fmt.Sprintf("\"%v\"", destination.Name),
//							},
//							{
//								Name:  "table_name",
//								Value: fmt.Sprintf("\"%v\"", destinationAwsGlueCatalogTable.Name),
//							},
//						},
//					},
//					{
//						Id:       "datasink4",
//						NodeType: "DataSink",
//						Args: []glue.GetScriptDagNodeArg{
//							{
//								Name:  "database",
//								Value: fmt.Sprintf("\"%v\"", destination.Name),
//							},
//							{
//								Name:  "table_name",
//								Value: fmt.Sprintf("\"%v\"", destinationAwsGlueCatalogTable.Name),
//							},
//						},
//					},
//				},
//			}, nil)
//			if err != nil {
//				return err
//			}
//			ctx.Export("scalaCode", example.ScalaCode)
//			return nil
//		})
//	}
//
// ```
func GetScript(ctx *pulumi.Context, args *GetScriptArgs, opts ...pulumi.InvokeOption) (*GetScriptResult, error) {
	opts = internal.PkgInvokeDefaultOpts(opts)
	var rv GetScriptResult
	err := ctx.Invoke("aws:glue/getScript:getScript", args, &rv, opts...)
	if err != nil {
		return nil, err
	}
	return &rv, nil
}

// A collection of arguments for invoking getScript.
type GetScriptArgs struct {
	// List of the edges in the DAG. Defined below.
	DagEdges []GetScriptDagEdge `pulumi:"dagEdges"`
	// List of the nodes in the DAG. Defined below.
	DagNodes []GetScriptDagNode `pulumi:"dagNodes"`
	// Programming language of the resulting code from the DAG. Defaults to `PYTHON`. Valid values are `PYTHON` and `SCALA`.
	Language *string `pulumi:"language"`
}

// A collection of values returned by getScript.
type GetScriptResult struct {
	DagEdges []GetScriptDagEdge `pulumi:"dagEdges"`
	DagNodes []GetScriptDagNode `pulumi:"dagNodes"`
	// The provider-assigned unique ID for this managed resource.
	Id       string  `pulumi:"id"`
	Language *string `pulumi:"language"`
	// Python script generated from the DAG when the `language` argument is set to `PYTHON`.
	PythonScript string `pulumi:"pythonScript"`
	// Scala code generated from the DAG when the `language` argument is set to `SCALA`.
	ScalaCode string `pulumi:"scalaCode"`
}

func GetScriptOutput(ctx *pulumi.Context, args GetScriptOutputArgs, opts ...pulumi.InvokeOption) GetScriptResultOutput {
	return pulumi.ToOutputWithContext(ctx.Context(), args).
		ApplyT(func(v interface{}) (GetScriptResultOutput, error) {
			args := v.(GetScriptArgs)
			options := pulumi.InvokeOutputOptions{InvokeOptions: internal.PkgInvokeDefaultOpts(opts)}
			return ctx.InvokeOutput("aws:glue/getScript:getScript", args, GetScriptResultOutput{}, options).(GetScriptResultOutput), nil
		}).(GetScriptResultOutput)
}

// A collection of arguments for invoking getScript.
type GetScriptOutputArgs struct {
	// List of the edges in the DAG. Defined below.
	DagEdges GetScriptDagEdgeArrayInput `pulumi:"dagEdges"`
	// List of the nodes in the DAG. Defined below.
	DagNodes GetScriptDagNodeArrayInput `pulumi:"dagNodes"`
	// Programming language of the resulting code from the DAG. Defaults to `PYTHON`. Valid values are `PYTHON` and `SCALA`.
	Language pulumi.StringPtrInput `pulumi:"language"`
}

func (GetScriptOutputArgs) ElementType() reflect.Type {
	return reflect.TypeOf((*GetScriptArgs)(nil)).Elem()
}

// A collection of values returned by getScript.
type GetScriptResultOutput struct{ *pulumi.OutputState }

func (GetScriptResultOutput) ElementType() reflect.Type {
	return reflect.TypeOf((*GetScriptResult)(nil)).Elem()
}

func (o GetScriptResultOutput) ToGetScriptResultOutput() GetScriptResultOutput {
	return o
}

func (o GetScriptResultOutput) ToGetScriptResultOutputWithContext(ctx context.Context) GetScriptResultOutput {
	return o
}

func (o GetScriptResultOutput) DagEdges() GetScriptDagEdgeArrayOutput {
	return o.ApplyT(func(v GetScriptResult) []GetScriptDagEdge { return v.DagEdges }).(GetScriptDagEdgeArrayOutput)
}

func (o GetScriptResultOutput) DagNodes() GetScriptDagNodeArrayOutput {
	return o.ApplyT(func(v GetScriptResult) []GetScriptDagNode { return v.DagNodes }).(GetScriptDagNodeArrayOutput)
}

// The provider-assigned unique ID for this managed resource.
func (o GetScriptResultOutput) Id() pulumi.StringOutput {
	return o.ApplyT(func(v GetScriptResult) string { return v.Id }).(pulumi.StringOutput)
}

func (o GetScriptResultOutput) Language() pulumi.StringPtrOutput {
	return o.ApplyT(func(v GetScriptResult) *string { return v.Language }).(pulumi.StringPtrOutput)
}

// Python script generated from the DAG when the `language` argument is set to `PYTHON`.
func (o GetScriptResultOutput) PythonScript() pulumi.StringOutput {
	return o.ApplyT(func(v GetScriptResult) string { return v.PythonScript }).(pulumi.StringOutput)
}

// Scala code generated from the DAG when the `language` argument is set to `SCALA`.
func (o GetScriptResultOutput) ScalaCode() pulumi.StringOutput {
	return o.ApplyT(func(v GetScriptResult) string { return v.ScalaCode }).(pulumi.StringOutput)
}

func init() {
	pulumi.RegisterOutputType(GetScriptResultOutput{})
}
