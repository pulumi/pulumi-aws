// *** WARNING: this file was generated by pulumi-java-gen. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

package com.pulumi.aws.apigateway;

import com.pulumi.aws.Utilities;
import com.pulumi.aws.apigateway.RestApiPolicyArgs;
import com.pulumi.aws.apigateway.inputs.RestApiPolicyState;
import com.pulumi.core.Output;
import com.pulumi.core.annotations.Export;
import com.pulumi.core.annotations.ResourceType;
import com.pulumi.core.internal.Codegen;
import java.lang.String;
import javax.annotation.Nullable;

/**
 * Provides an API Gateway REST API Policy.
 * 
 * &gt; **Note:** Amazon API Gateway Version 1 resources are used for creating and deploying REST APIs. To create and deploy WebSocket and HTTP APIs, use Amazon API Gateway Version 2 resources.
 * 
 * ## Example Usage
 * 
 * ### Basic
 * 
 * &lt;!--Start PulumiCodeChooser --&gt;
 * <pre>
 * {@code
 * package generated_program;
 * 
 * import com.pulumi.Context;
 * import com.pulumi.Pulumi;
 * import com.pulumi.core.Output;
 * import com.pulumi.aws.apigateway.RestApi;
 * import com.pulumi.aws.apigateway.RestApiArgs;
 * import com.pulumi.aws.iam.IamFunctions;
 * import com.pulumi.aws.iam.inputs.GetPolicyDocumentArgs;
 * import com.pulumi.aws.apigateway.RestApiPolicy;
 * import com.pulumi.aws.apigateway.RestApiPolicyArgs;
 * import java.util.List;
 * import java.util.ArrayList;
 * import java.util.Map;
 * import java.io.File;
 * import java.nio.file.Files;
 * import java.nio.file.Paths;
 * 
 * public class App {
 *     public static void main(String[] args) {
 *         Pulumi.run(App::stack);
 *     }
 * 
 *     public static void stack(Context ctx) {
 *         var testRestApi = new RestApi("testRestApi", RestApiArgs.builder()
 *             .name("example-rest-api")
 *             .build());
 * 
 *         final var test = IamFunctions.getPolicyDocument(GetPolicyDocumentArgs.builder()
 *             .statements(GetPolicyDocumentStatementArgs.builder()
 *                 .effect("Allow")
 *                 .principals(GetPolicyDocumentStatementPrincipalArgs.builder()
 *                     .type("AWS")
 *                     .identifiers("*")
 *                     .build())
 *                 .actions("execute-api:Invoke")
 *                 .resources(testRestApi.executionArn().applyValue(_executionArn -> String.format("%s/*", _executionArn)))
 *                 .conditions(GetPolicyDocumentStatementConditionArgs.builder()
 *                     .test("IpAddress")
 *                     .variable("aws:SourceIp")
 *                     .values("123.123.123.123/32")
 *                     .build())
 *                 .build())
 *             .build());
 * 
 *         var testRestApiPolicy = new RestApiPolicy("testRestApiPolicy", RestApiPolicyArgs.builder()
 *             .restApiId(testRestApi.id())
 *             .policy(test.applyValue(_test -> _test.json()))
 *             .build());
 * 
 *     }
 * }
 * }
 * </pre>
 * &lt;!--End PulumiCodeChooser --&gt;
 * 
 * ## Import
 * 
 * Using `pulumi import`, import `aws_api_gateway_rest_api_policy` using the REST API ID. For example:
 * 
 * ```sh
 * $ pulumi import aws:apigateway/restApiPolicy:RestApiPolicy example 12345abcde
 * ```
 * 
 */
@ResourceType(type="aws:apigateway/restApiPolicy:RestApiPolicy")
public class RestApiPolicy extends com.pulumi.resources.CustomResource {
    /**
     * JSON formatted policy document that controls access to the API Gateway.
     * 
     */
    @Export(name="policy", refs={String.class}, tree="[0]")
    private Output<String> policy;

    /**
     * @return JSON formatted policy document that controls access to the API Gateway.
     * 
     */
    public Output<String> policy() {
        return this.policy;
    }
    /**
     * ID of the REST API.
     * 
     */
    @Export(name="restApiId", refs={String.class}, tree="[0]")
    private Output<String> restApiId;

    /**
     * @return ID of the REST API.
     * 
     */
    public Output<String> restApiId() {
        return this.restApiId;
    }

    /**
     *
     * @param name The _unique_ name of the resulting resource.
     */
    public RestApiPolicy(java.lang.String name) {
        this(name, RestApiPolicyArgs.Empty);
    }
    /**
     *
     * @param name The _unique_ name of the resulting resource.
     * @param args The arguments to use to populate this resource's properties.
     */
    public RestApiPolicy(java.lang.String name, RestApiPolicyArgs args) {
        this(name, args, null);
    }
    /**
     *
     * @param name The _unique_ name of the resulting resource.
     * @param args The arguments to use to populate this resource's properties.
     * @param options A bag of options that control this resource's behavior.
     */
    public RestApiPolicy(java.lang.String name, RestApiPolicyArgs args, @Nullable com.pulumi.resources.CustomResourceOptions options) {
        super("aws:apigateway/restApiPolicy:RestApiPolicy", name, makeArgs(args, options), makeResourceOptions(options, Codegen.empty()), false);
    }

    private RestApiPolicy(java.lang.String name, Output<java.lang.String> id, @Nullable RestApiPolicyState state, @Nullable com.pulumi.resources.CustomResourceOptions options) {
        super("aws:apigateway/restApiPolicy:RestApiPolicy", name, state, makeResourceOptions(options, id), false);
    }

    private static RestApiPolicyArgs makeArgs(RestApiPolicyArgs args, @Nullable com.pulumi.resources.CustomResourceOptions options) {
        if (options != null && options.getUrn().isPresent()) {
            return null;
        }
        return args == null ? RestApiPolicyArgs.Empty : args;
    }

    private static com.pulumi.resources.CustomResourceOptions makeResourceOptions(@Nullable com.pulumi.resources.CustomResourceOptions options, @Nullable Output<java.lang.String> id) {
        var defaultOptions = com.pulumi.resources.CustomResourceOptions.builder()
            .version(Utilities.getVersion())
            .build();
        return com.pulumi.resources.CustomResourceOptions.merge(defaultOptions, options, id);
    }

    /**
     * Get an existing Host resource's state with the given name, ID, and optional extra
     * properties used to qualify the lookup.
     *
     * @param name The _unique_ name of the resulting resource.
     * @param id The _unique_ provider ID of the resource to lookup.
     * @param state
     * @param options Optional settings to control the behavior of the CustomResource.
     */
    public static RestApiPolicy get(java.lang.String name, Output<java.lang.String> id, @Nullable RestApiPolicyState state, @Nullable com.pulumi.resources.CustomResourceOptions options) {
        return new RestApiPolicy(name, id, state, options);
    }
}
