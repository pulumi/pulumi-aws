// Copyright 2016-2024, Pulumi Corporation.
//
// Licensed under the Apache License, Version 2.0 (the "License");
// you may not use this file except in compliance with the License.
// You may obtain a copy of the License at
//
//     http://www.apache.org/licenses/LICENSE-2.0
//
// Unless required by applicable law or agreed to in writing, software
// distributed under the License is distributed on an "AS IS" BASIS,
// WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
// See the License for the specific language governing permissions and
// limitations under the License.

package provider

import (
	_ "embed" // Needed to support go:embed directive
	"fmt"
	"maps"

	"github.com/pulumi/pulumi/pkg/v3/codegen/schema"
	"github.com/pulumi/pulumi/sdk/v3/go/common/util/contract"
)

const (
	callbackFunctionTok = "aws:lambda/callbackFunction:CallbackFunction"
	codePathOptionsTok  = "aws:lambda/CodePathOptions:CodePathOptions"
)

var arnToken = fmt.Sprintf("#/types/%s", awsTypeDefaultFile(awsMod, "ARN"))

// resourceOverlays augment the resources defined by the upstream AWS provider
var resourceOverlays = map[string]schema.ResourceSpec{}

// typeOverlays augment the types defined by the upstream AWS provider
var typeOverlays = map[string]schema.ComplexTypeSpec{}

//go:embed pkg/overlays/examples/callbackFunction.md
var callbackFunctionMD string

var callbackFunction = schema.ResourceSpec{
	ObjectTypeSpec: schema.ObjectTypeSpec{
		IsOverlay:                 true,
		OverlaySupportedLanguages: []string{"nodejs"},
		Description:               callbackFunctionMD,
		Properties: map[string]schema.PropertySpec{
			"roleInstance": {
				TypeSpec: schema.TypeSpec{
					Type: "string",
				},
				Description: "The IAM role assigned to this Lambda function. Will be undefined if an ARN was provided for the role input property.",
			},
		},
		Type: "object",
	},
	InputProperties: map[string]schema.PropertySpec{
		"role": {
			TypeSpec: schema.TypeSpec{
				OneOf: []schema.TypeSpec{
					{
						Ref: "#/types/aws:iam/Role:Role",
					},
					{
						Type: "string",
						Ref:  arnToken,
					},
				},
			},
			Description: "The execution role for the Lambda Function. The role provides the function's identity and access to AWS services and resources. Only one of `role` or `policies` can be provided. If neither is provided, the default policies will be used instead.",
		},
		"policies": {
			TypeSpec: schema.TypeSpec{
				OneOf: []schema.TypeSpec{
					{
						Type: "object",
						AdditionalProperties: &schema.TypeSpec{
							Type: "string",
							Ref:  arnToken,
						},
					},
					{
						Type: "array",
						Items: &schema.TypeSpec{
							Type: "string",
							Ref:  arnToken,
						},
					},
				},
			},
			Description: "A list of IAM policy ARNs to attach to the Function. Only one of `role` or `policies` can be provided. If neither is provided, the default policies will be used instead.",
		},
		"runtime": {
			TypeSpec: schema.TypeSpec{
				Ref: "#/types/aws:lambda/Runtime:Runtime",
			},
			Description: "The Lambda runtime to use. If not provided, will default to `NodeJS20dX`.",
		},
		"codePathOptions": {
			TypeSpec: schema.TypeSpec{
				Ref: "#/types/" + codePathOptionsTok,
			},
			Description: "Options to control which paths/packages should be included or excluded in the zip file containing the code for the AWS lambda.",
		},
		"callback": {
			TypeSpec: schema.TypeSpec{
				Ref: "pulumi.json#/Any",
			},
			Description: "The Javascript function to use as the entrypoint for the AWS Lambda out of. Either callback or callbackFactory must be provided.",
		},
		"callbackFactory": {
			TypeSpec: schema.TypeSpec{
				Ref: "pulumi.json#/Any",
			},
			Description: "The Javascript function that will be called to produce the callback function that is the entrypoint for the AWS Lambda. Either callback or callbackFactory must be provided.",
		},
	},
}

var codePathOptions = schema.ComplexTypeSpec{
	ObjectTypeSpec: schema.ObjectTypeSpec{
		IsOverlay:   true,
		Description: "Options to control which paths/packages should be included or excluded in the zip file containing the code for the AWS lambda.",
		Properties: map[string]schema.PropertySpec{
			"extraIncludePaths": {
				TypeSpec: schema.TypeSpec{
					Type: "array",
					Items: &schema.TypeSpec{
						Type: "string",
					},
				},
				Description: "Local file/directory paths that should be included when producing the Assets for a serialized closure.",
			},
			"extraIncludePackages": {
				TypeSpec: schema.TypeSpec{
					Type: "array",
					Items: &schema.TypeSpec{
						Type: "string",
					},
				},
				Description: "Extra packages to include when producing the Assets for a serialized closure. This can be useful if the packages are acquired in a way that the serialization code does not understand. For example, if there was some sort of module that was pulled in based off of a computed string.",
			},
			"extraExcludePackages": {
				TypeSpec: schema.TypeSpec{
					Type: "array",
					Items: &schema.TypeSpec{
						Type: "string",
					},
				},
				Description: "Packages to explicitly exclude from the Assets for a serialized closure. This can be used when clients want to trim down the size of a closure, and they know that some package won't ever actually be needed at runtime, but is still a dependency of some package that is being used at runtime.",
			},
		},
		Type: "object",
	},
}

// postProcessCallbackFunction post-processes the CallbackFunction resource of the given PackageSpec.
// It updates the ResourceSpec of the CallbackFunction by copying input properties and properties from lambda/Function.
// Props defined in the CallbackFunction resource will take precedence over props defined in the Function resource.
// Additionally it removes the "code" and "handler" input properties because those do not exist for CallbackFunctions.
func postProcessCallbackFunction(spec *schema.PackageSpec) {
	lambdaSpec, ok := spec.Resources["aws:lambda/function:Function"]
	contract.Assertf(ok, "could not find lambda:Function")

	callbackFunctionSpec, ok := spec.Resources[callbackFunctionTok]
	contract.Assertf(ok, "could not find lambda/callbackFunction")

	inputProps := maps.Clone(lambdaSpec.InputProperties)
	delete(inputProps, "code")
	delete(inputProps, "handler")
	maps.Copy(inputProps, callbackFunctionSpec.InputProperties)
	callbackFunctionSpec.InputProperties = inputProps

	props := maps.Clone(lambdaSpec.Properties)
	maps.Copy(props, callbackFunctionSpec.Properties)
	callbackFunctionSpec.Properties = props
	spec.Resources[callbackFunctionTok] = callbackFunctionSpec
}

// postProcessOverlays performs post-processing on the given package specification.
// It applies post processing steps to overlays. e.g. copying input properties from another resource
func postProcessOverlays(spec *schema.PackageSpec) {
	postProcessCallbackFunction(spec)
}

func init() {
	resourceOverlays[callbackFunctionTok] = callbackFunction

	typeOverlays[codePathOptionsTok] = codePathOptions
}
