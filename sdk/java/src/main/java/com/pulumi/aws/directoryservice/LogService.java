// *** WARNING: this file was generated by pulumi-java-gen. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

package com.pulumi.aws.directoryservice;

import com.pulumi.aws.Utilities;
import com.pulumi.aws.directoryservice.LogServiceArgs;
import com.pulumi.aws.directoryservice.inputs.LogServiceState;
import com.pulumi.core.Output;
import com.pulumi.core.annotations.Export;
import com.pulumi.core.annotations.ResourceType;
import com.pulumi.core.internal.Codegen;
import java.lang.String;
import javax.annotation.Nullable;

/**
 * Provides a Log subscription for AWS Directory Service that pushes logs to cloudwatch.
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
 * import com.pulumi.aws.cloudwatch.LogGroup;
 * import com.pulumi.aws.cloudwatch.LogGroupArgs;
 * import com.pulumi.aws.iam.IamFunctions;
 * import com.pulumi.aws.iam.inputs.GetPolicyDocumentArgs;
 * import com.pulumi.aws.cloudwatch.LogResourcePolicy;
 * import com.pulumi.aws.cloudwatch.LogResourcePolicyArgs;
 * import com.pulumi.aws.directoryservice.LogSubscription;
 * import com.pulumi.aws.directoryservice.LogSubscriptionArgs;
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
 *         var example = new LogGroup("example", LogGroupArgs.builder()
 *             .name(String.format("/aws/directoryservice/%s", exampleAwsDirectoryServiceDirectory.id()))
 *             .retentionInDays(14)
 *             .build());
 * 
 *         final var ad-log-policy = IamFunctions.getPolicyDocument(GetPolicyDocumentArgs.builder()
 *             .statements(GetPolicyDocumentStatementArgs.builder()
 *                 .actions(                
 *                     "logs:CreateLogStream",
 *                     "logs:PutLogEvents")
 *                 .principals(GetPolicyDocumentStatementPrincipalArgs.builder()
 *                     .identifiers("ds.amazonaws.com")
 *                     .type("Service")
 *                     .build())
 *                 .resources(example.arn().applyValue(_arn -> String.format("%s:*", _arn)))
 *                 .effect("Allow")
 *                 .build())
 *             .build());
 * 
 *         var ad_log_policyLogResourcePolicy = new LogResourcePolicy("ad-log-policyLogResourcePolicy", LogResourcePolicyArgs.builder()
 *             .policyDocument(ad_log_policy.applyValue(_ad_log_policy -> _ad_log_policy.json()))
 *             .policyName("ad-log-policy")
 *             .build());
 * 
 *         var exampleLogSubscription = new LogSubscription("exampleLogSubscription", LogSubscriptionArgs.builder()
 *             .directoryId(exampleAwsDirectoryServiceDirectory.id())
 *             .logGroupName(example.name())
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
 * Using `pulumi import`, import Directory Service Log Subscriptions using the directory id. For example:
 * 
 * ```sh
 * $ pulumi import aws:directoryservice/logService:LogService msad d-1234567890
 * ```
 * 
 * @deprecated
 * aws.directoryservice/logservice.LogService has been deprecated in favor of aws.directoryservice/logsubscription.LogSubscription
 * 
 */
@Deprecated /* aws.directoryservice/logservice.LogService has been deprecated in favor of aws.directoryservice/logsubscription.LogSubscription */
@ResourceType(type="aws:directoryservice/logService:LogService")
public class LogService extends com.pulumi.resources.CustomResource {
    /**
     * ID of directory.
     * 
     */
    @Export(name="directoryId", refs={String.class}, tree="[0]")
    private Output<String> directoryId;

    /**
     * @return ID of directory.
     * 
     */
    public Output<String> directoryId() {
        return this.directoryId;
    }
    /**
     * Name of the cloudwatch log group to which the logs should be published. The log group should be already created and the directory service principal should be provided with required permission to create stream and publish logs. Changing this value would delete the current subscription and create a new one. A directory can only have one log subscription at a time.
     * 
     */
    @Export(name="logGroupName", refs={String.class}, tree="[0]")
    private Output<String> logGroupName;

    /**
     * @return Name of the cloudwatch log group to which the logs should be published. The log group should be already created and the directory service principal should be provided with required permission to create stream and publish logs. Changing this value would delete the current subscription and create a new one. A directory can only have one log subscription at a time.
     * 
     */
    public Output<String> logGroupName() {
        return this.logGroupName;
    }

    /**
     *
     * @param name The _unique_ name of the resulting resource.
     */
    public LogService(java.lang.String name) {
        this(name, LogServiceArgs.Empty);
    }
    /**
     *
     * @param name The _unique_ name of the resulting resource.
     * @param args The arguments to use to populate this resource's properties.
     */
    public LogService(java.lang.String name, LogServiceArgs args) {
        this(name, args, null);
    }
    /**
     *
     * @param name The _unique_ name of the resulting resource.
     * @param args The arguments to use to populate this resource's properties.
     * @param options A bag of options that control this resource's behavior.
     */
    public LogService(java.lang.String name, LogServiceArgs args, @Nullable com.pulumi.resources.CustomResourceOptions options) {
        super("aws:directoryservice/logService:LogService", name, makeArgs(args, options), makeResourceOptions(options, Codegen.empty()), false);
    }

    private LogService(java.lang.String name, Output<java.lang.String> id, @Nullable LogServiceState state, @Nullable com.pulumi.resources.CustomResourceOptions options) {
        super("aws:directoryservice/logService:LogService", name, state, makeResourceOptions(options, id), false);
    }

    private static LogServiceArgs makeArgs(LogServiceArgs args, @Nullable com.pulumi.resources.CustomResourceOptions options) {
        if (options != null && options.getUrn().isPresent()) {
            return null;
        }
        return args == null ? LogServiceArgs.Empty : args;
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
    public static LogService get(java.lang.String name, Output<java.lang.String> id, @Nullable LogServiceState state, @Nullable com.pulumi.resources.CustomResourceOptions options) {
        return new LogService(name, id, state, options);
    }
}
