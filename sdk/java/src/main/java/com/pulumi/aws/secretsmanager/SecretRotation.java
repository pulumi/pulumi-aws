// *** WARNING: this file was generated by pulumi-java-gen. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

package com.pulumi.aws.secretsmanager;

import com.pulumi.aws.Utilities;
import com.pulumi.aws.secretsmanager.SecretRotationArgs;
import com.pulumi.aws.secretsmanager.inputs.SecretRotationState;
import com.pulumi.aws.secretsmanager.outputs.SecretRotationRotationRules;
import com.pulumi.core.Output;
import com.pulumi.core.annotations.Export;
import com.pulumi.core.annotations.ResourceType;
import com.pulumi.core.internal.Codegen;
import java.lang.Boolean;
import java.lang.String;
import java.util.Optional;
import javax.annotation.Nullable;

/**
 * Provides a resource to manage AWS Secrets Manager secret rotation. To manage a secret, see the `aws.secretsmanager.Secret` resource. To manage a secret value, see the `aws.secretsmanager.SecretVersion` resource.
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
 * import com.pulumi.aws.secretsmanager.SecretRotation;
 * import com.pulumi.aws.secretsmanager.SecretRotationArgs;
 * import com.pulumi.aws.secretsmanager.inputs.SecretRotationRotationRulesArgs;
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
 *         var example = new SecretRotation("example", SecretRotationArgs.builder()
 *             .secretId(exampleAwsSecretsmanagerSecret.id())
 *             .rotationLambdaArn(exampleAwsLambdaFunction.arn())
 *             .rotationRules(SecretRotationRotationRulesArgs.builder()
 *                 .automaticallyAfterDays(30)
 *                 .build())
 *             .build());
 * 
 *     }
 * }
 * }
 * </pre>
 * &lt;!--End PulumiCodeChooser --&gt;
 * 
 * ### Rotation Configuration
 * 
 * To enable automatic secret rotation, the Secrets Manager service requires usage of a Lambda function. The [Rotate Secrets section in the Secrets Manager User Guide](https://docs.aws.amazon.com/secretsmanager/latest/userguide/rotating-secrets.html) provides additional information about deploying a prebuilt Lambda functions for supported credential rotation (e.g., RDS) or deploying a custom Lambda function.
 * 
 * &gt; **NOTE:** Configuring rotation causes the secret to rotate once as soon as you enable rotation. Before you do this, you must ensure that all of your applications that use the credentials stored in the secret are updated to retrieve the secret from AWS Secrets Manager. The old credentials might no longer be usable after the initial rotation and any applications that you fail to update will break as soon as the old credentials are no longer valid.
 * 
 * &gt; **NOTE:** If you cancel a rotation that is in progress (by removing the `rotation` configuration), it can leave the VersionStage labels in an unexpected state. Depending on what step of the rotation was in progress, you might need to remove the staging label AWSPENDING from the partially created version, specified by the SecretVersionId response value. You should also evaluate the partially rotated new version to see if it should be deleted, which you can do by removing all staging labels from the new version&#39;s VersionStage field.
 * 
 * ## Import
 * 
 * Using `pulumi import`, import `aws_secretsmanager_secret_rotation` using the secret Amazon Resource Name (ARN). For example:
 * 
 * ```sh
 * $ pulumi import aws:secretsmanager/secretRotation:SecretRotation example arn:aws:secretsmanager:us-east-1:123456789012:secret:example-123456
 * ```
 * 
 */
@ResourceType(type="aws:secretsmanager/secretRotation:SecretRotation")
public class SecretRotation extends com.pulumi.resources.CustomResource {
    /**
     * Specifies whether to rotate the secret immediately or wait until the next scheduled rotation window. The rotation schedule is defined in `rotation_rules`. For secrets that use a Lambda rotation function to rotate, if you don&#39;t immediately rotate the secret, Secrets Manager tests the rotation configuration by running the testSecret step (https://docs.aws.amazon.com/secretsmanager/latest/userguide/rotate-secrets_how.html) of the Lambda rotation function. The test creates an AWSPENDING version of the secret and then removes it. Defaults to `true`.
     * 
     */
    @Export(name="rotateImmediately", refs={Boolean.class}, tree="[0]")
    private Output</* @Nullable */ Boolean> rotateImmediately;

    /**
     * @return Specifies whether to rotate the secret immediately or wait until the next scheduled rotation window. The rotation schedule is defined in `rotation_rules`. For secrets that use a Lambda rotation function to rotate, if you don&#39;t immediately rotate the secret, Secrets Manager tests the rotation configuration by running the testSecret step (https://docs.aws.amazon.com/secretsmanager/latest/userguide/rotate-secrets_how.html) of the Lambda rotation function. The test creates an AWSPENDING version of the secret and then removes it. Defaults to `true`.
     * 
     */
    public Output<Optional<Boolean>> rotateImmediately() {
        return Codegen.optional(this.rotateImmediately);
    }
    /**
     * Specifies whether automatic rotation is enabled for this secret.
     * 
     */
    @Export(name="rotationEnabled", refs={Boolean.class}, tree="[0]")
    private Output<Boolean> rotationEnabled;

    /**
     * @return Specifies whether automatic rotation is enabled for this secret.
     * 
     */
    public Output<Boolean> rotationEnabled() {
        return this.rotationEnabled;
    }
    /**
     * Specifies the ARN of the Lambda function that can rotate the secret. Must be supplied if the secret is not managed by AWS.
     * 
     */
    @Export(name="rotationLambdaArn", refs={String.class}, tree="[0]")
    private Output</* @Nullable */ String> rotationLambdaArn;

    /**
     * @return Specifies the ARN of the Lambda function that can rotate the secret. Must be supplied if the secret is not managed by AWS.
     * 
     */
    public Output<Optional<String>> rotationLambdaArn() {
        return Codegen.optional(this.rotationLambdaArn);
    }
    /**
     * A structure that defines the rotation configuration for this secret. Defined below.
     * 
     */
    @Export(name="rotationRules", refs={SecretRotationRotationRules.class}, tree="[0]")
    private Output<SecretRotationRotationRules> rotationRules;

    /**
     * @return A structure that defines the rotation configuration for this secret. Defined below.
     * 
     */
    public Output<SecretRotationRotationRules> rotationRules() {
        return this.rotationRules;
    }
    /**
     * Specifies the secret to which you want to add a new version. You can specify either the Amazon Resource Name (ARN) or the friendly name of the secret. The secret must already exist.
     * 
     */
    @Export(name="secretId", refs={String.class}, tree="[0]")
    private Output<String> secretId;

    /**
     * @return Specifies the secret to which you want to add a new version. You can specify either the Amazon Resource Name (ARN) or the friendly name of the secret. The secret must already exist.
     * 
     */
    public Output<String> secretId() {
        return this.secretId;
    }

    /**
     *
     * @param name The _unique_ name of the resulting resource.
     */
    public SecretRotation(java.lang.String name) {
        this(name, SecretRotationArgs.Empty);
    }
    /**
     *
     * @param name The _unique_ name of the resulting resource.
     * @param args The arguments to use to populate this resource's properties.
     */
    public SecretRotation(java.lang.String name, SecretRotationArgs args) {
        this(name, args, null);
    }
    /**
     *
     * @param name The _unique_ name of the resulting resource.
     * @param args The arguments to use to populate this resource's properties.
     * @param options A bag of options that control this resource's behavior.
     */
    public SecretRotation(java.lang.String name, SecretRotationArgs args, @Nullable com.pulumi.resources.CustomResourceOptions options) {
        super("aws:secretsmanager/secretRotation:SecretRotation", name, makeArgs(args, options), makeResourceOptions(options, Codegen.empty()), false);
    }

    private SecretRotation(java.lang.String name, Output<java.lang.String> id, @Nullable SecretRotationState state, @Nullable com.pulumi.resources.CustomResourceOptions options) {
        super("aws:secretsmanager/secretRotation:SecretRotation", name, state, makeResourceOptions(options, id), false);
    }

    private static SecretRotationArgs makeArgs(SecretRotationArgs args, @Nullable com.pulumi.resources.CustomResourceOptions options) {
        if (options != null && options.getUrn().isPresent()) {
            return null;
        }
        return args == null ? SecretRotationArgs.Empty : args;
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
    public static SecretRotation get(java.lang.String name, Output<java.lang.String> id, @Nullable SecretRotationState state, @Nullable com.pulumi.resources.CustomResourceOptions options) {
        return new SecretRotation(name, id, state, options);
    }
}
