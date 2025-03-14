// *** WARNING: this file was generated by pulumi-java-gen. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

package com.pulumi.aws.cognito;

import com.pulumi.aws.Utilities;
import com.pulumi.aws.cognito.RiskConfigurationArgs;
import com.pulumi.aws.cognito.inputs.RiskConfigurationState;
import com.pulumi.aws.cognito.outputs.RiskConfigurationAccountTakeoverRiskConfiguration;
import com.pulumi.aws.cognito.outputs.RiskConfigurationCompromisedCredentialsRiskConfiguration;
import com.pulumi.aws.cognito.outputs.RiskConfigurationRiskExceptionConfiguration;
import com.pulumi.core.Output;
import com.pulumi.core.annotations.Export;
import com.pulumi.core.annotations.ResourceType;
import com.pulumi.core.internal.Codegen;
import java.lang.String;
import java.util.Optional;
import javax.annotation.Nullable;

/**
 * Provides a Cognito Risk Configuration resource.
 * 
 * ## Example Usage
 * 
 * &lt;!--Start PulumiCodeChooser --&gt;
 * <pre>
 * {@code
 * package generated_program;
 * 
 * import com.pulumi.Context;
 * import com.pulumi.Pulumi;
 * import com.pulumi.core.Output;
 * import com.pulumi.aws.cognito.RiskConfiguration;
 * import com.pulumi.aws.cognito.RiskConfigurationArgs;
 * import com.pulumi.aws.cognito.inputs.RiskConfigurationRiskExceptionConfigurationArgs;
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
 *         var example = new RiskConfiguration("example", RiskConfigurationArgs.builder()
 *             .userPoolId(exampleAwsCognitoUserPool.id())
 *             .riskExceptionConfiguration(RiskConfigurationRiskExceptionConfigurationArgs.builder()
 *                 .blockedIpRangeLists("10.10.10.10/32")
 *                 .build())
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
 * Import using the user pool ID and Client ID separated by a `:`:
 * 
 * __Using `pulumi import` to import__ Cognito Risk Configurations using the user pool ID or the user pool ID and Client Id separated by a `:`. For example:
 * 
 * Import using the user pool ID:
 * 
 * ```sh
 * $ pulumi import aws:cognito/riskConfiguration:RiskConfiguration main example
 * ```
 * Import using the user pool ID and Client ID separated by a `:`:
 * 
 * ```sh
 * $ pulumi import aws:cognito/riskConfiguration:RiskConfiguration main example:example
 * ```
 * 
 */
@ResourceType(type="aws:cognito/riskConfiguration:RiskConfiguration")
public class RiskConfiguration extends com.pulumi.resources.CustomResource {
    /**
     * The account takeover risk configuration. See details below.
     * 
     */
    @Export(name="accountTakeoverRiskConfiguration", refs={RiskConfigurationAccountTakeoverRiskConfiguration.class}, tree="[0]")
    private Output</* @Nullable */ RiskConfigurationAccountTakeoverRiskConfiguration> accountTakeoverRiskConfiguration;

    /**
     * @return The account takeover risk configuration. See details below.
     * 
     */
    public Output<Optional<RiskConfigurationAccountTakeoverRiskConfiguration>> accountTakeoverRiskConfiguration() {
        return Codegen.optional(this.accountTakeoverRiskConfiguration);
    }
    /**
     * The app client ID. When the client ID is not provided, the same risk configuration is applied to all the clients in the User Pool.
     * 
     */
    @Export(name="clientId", refs={String.class}, tree="[0]")
    private Output</* @Nullable */ String> clientId;

    /**
     * @return The app client ID. When the client ID is not provided, the same risk configuration is applied to all the clients in the User Pool.
     * 
     */
    public Output<Optional<String>> clientId() {
        return Codegen.optional(this.clientId);
    }
    /**
     * The compromised credentials risk configuration. See details below.
     * 
     */
    @Export(name="compromisedCredentialsRiskConfiguration", refs={RiskConfigurationCompromisedCredentialsRiskConfiguration.class}, tree="[0]")
    private Output</* @Nullable */ RiskConfigurationCompromisedCredentialsRiskConfiguration> compromisedCredentialsRiskConfiguration;

    /**
     * @return The compromised credentials risk configuration. See details below.
     * 
     */
    public Output<Optional<RiskConfigurationCompromisedCredentialsRiskConfiguration>> compromisedCredentialsRiskConfiguration() {
        return Codegen.optional(this.compromisedCredentialsRiskConfiguration);
    }
    /**
     * The configuration to override the risk decision. See details below.
     * 
     */
    @Export(name="riskExceptionConfiguration", refs={RiskConfigurationRiskExceptionConfiguration.class}, tree="[0]")
    private Output</* @Nullable */ RiskConfigurationRiskExceptionConfiguration> riskExceptionConfiguration;

    /**
     * @return The configuration to override the risk decision. See details below.
     * 
     */
    public Output<Optional<RiskConfigurationRiskExceptionConfiguration>> riskExceptionConfiguration() {
        return Codegen.optional(this.riskExceptionConfiguration);
    }
    /**
     * The user pool ID.
     * 
     */
    @Export(name="userPoolId", refs={String.class}, tree="[0]")
    private Output<String> userPoolId;

    /**
     * @return The user pool ID.
     * 
     */
    public Output<String> userPoolId() {
        return this.userPoolId;
    }

    /**
     *
     * @param name The _unique_ name of the resulting resource.
     */
    public RiskConfiguration(java.lang.String name) {
        this(name, RiskConfigurationArgs.Empty);
    }
    /**
     *
     * @param name The _unique_ name of the resulting resource.
     * @param args The arguments to use to populate this resource's properties.
     */
    public RiskConfiguration(java.lang.String name, RiskConfigurationArgs args) {
        this(name, args, null);
    }
    /**
     *
     * @param name The _unique_ name of the resulting resource.
     * @param args The arguments to use to populate this resource's properties.
     * @param options A bag of options that control this resource's behavior.
     */
    public RiskConfiguration(java.lang.String name, RiskConfigurationArgs args, @Nullable com.pulumi.resources.CustomResourceOptions options) {
        super("aws:cognito/riskConfiguration:RiskConfiguration", name, makeArgs(args, options), makeResourceOptions(options, Codegen.empty()), false);
    }

    private RiskConfiguration(java.lang.String name, Output<java.lang.String> id, @Nullable RiskConfigurationState state, @Nullable com.pulumi.resources.CustomResourceOptions options) {
        super("aws:cognito/riskConfiguration:RiskConfiguration", name, state, makeResourceOptions(options, id), false);
    }

    private static RiskConfigurationArgs makeArgs(RiskConfigurationArgs args, @Nullable com.pulumi.resources.CustomResourceOptions options) {
        if (options != null && options.getUrn().isPresent()) {
            return null;
        }
        return args == null ? RiskConfigurationArgs.Empty : args;
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
    public static RiskConfiguration get(java.lang.String name, Output<java.lang.String> id, @Nullable RiskConfigurationState state, @Nullable com.pulumi.resources.CustomResourceOptions options) {
        return new RiskConfiguration(name, id, state, options);
    }
}
