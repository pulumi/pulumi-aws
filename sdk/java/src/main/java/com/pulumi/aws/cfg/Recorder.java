// *** WARNING: this file was generated by pulumi-java-gen. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

package com.pulumi.aws.cfg;

import com.pulumi.aws.Utilities;
import com.pulumi.aws.cfg.RecorderArgs;
import com.pulumi.aws.cfg.inputs.RecorderState;
import com.pulumi.aws.cfg.outputs.RecorderRecordingGroup;
import com.pulumi.aws.cfg.outputs.RecorderRecordingMode;
import com.pulumi.core.Output;
import com.pulumi.core.annotations.Export;
import com.pulumi.core.annotations.ResourceType;
import com.pulumi.core.internal.Codegen;
import java.lang.String;
import javax.annotation.Nullable;

/**
 * Provides an AWS Config Configuration Recorder. Please note that this resource **does not start** the created recorder automatically.
 * 
 * &gt; **Note:** _Starting_ the Configuration Recorder requires a delivery channel (while delivery channel creation requires Configuration Recorder). This is why `aws.cfg.RecorderStatus` is a separate resource.
 * 
 * ## Example Usage
 * 
 * ### Basic Usage
 * 
 * &lt;!--Start PulumiCodeChooser --&gt;
 * <pre>
 * {@code
 * package generated_program;
 * 
 * import com.pulumi.Context;
 * import com.pulumi.Pulumi;
 * import com.pulumi.core.Output;
 * import com.pulumi.aws.iam.IamFunctions;
 * import com.pulumi.aws.iam.inputs.GetPolicyDocumentArgs;
 * import com.pulumi.aws.iam.Role;
 * import com.pulumi.aws.iam.RoleArgs;
 * import com.pulumi.aws.cfg.Recorder;
 * import com.pulumi.aws.cfg.RecorderArgs;
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
 *         final var assumeRole = IamFunctions.getPolicyDocument(GetPolicyDocumentArgs.builder()
 *             .statements(GetPolicyDocumentStatementArgs.builder()
 *                 .effect("Allow")
 *                 .principals(GetPolicyDocumentStatementPrincipalArgs.builder()
 *                     .type("Service")
 *                     .identifiers("config.amazonaws.com")
 *                     .build())
 *                 .actions("sts:AssumeRole")
 *                 .build())
 *             .build());
 * 
 *         var r = new Role("r", RoleArgs.builder()
 *             .name("awsconfig-example")
 *             .assumeRolePolicy(assumeRole.json())
 *             .build());
 * 
 *         var foo = new Recorder("foo", RecorderArgs.builder()
 *             .name("example")
 *             .roleArn(r.arn())
 *             .build());
 * 
 *     }
 * }
 * }
 * </pre>
 * &lt;!--End PulumiCodeChooser --&gt;
 * 
 * ### Exclude Resources Types Usage
 * 
 * &lt;!--Start PulumiCodeChooser --&gt;
 * <pre>
 * {@code
 * package generated_program;
 * 
 * import com.pulumi.Context;
 * import com.pulumi.Pulumi;
 * import com.pulumi.core.Output;
 * import com.pulumi.aws.cfg.Recorder;
 * import com.pulumi.aws.cfg.RecorderArgs;
 * import com.pulumi.aws.cfg.inputs.RecorderRecordingGroupArgs;
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
 *         var foo = new Recorder("foo", RecorderArgs.builder()
 *             .name("example")
 *             .roleArn(r.arn())
 *             .recordingGroup(RecorderRecordingGroupArgs.builder()
 *                 .allSupported(false)
 *                 .exclusionByResourceTypes(RecorderRecordingGroupExclusionByResourceTypeArgs.builder()
 *                     .resourceTypes("AWS::EC2::Instance")
 *                     .build())
 *                 .recordingStrategies(RecorderRecordingGroupRecordingStrategyArgs.builder()
 *                     .useOnly("EXCLUSION_BY_RESOURCE_TYPES")
 *                     .build())
 *                 .build())
 *             .build());
 * 
 *     }
 * }
 * }
 * </pre>
 * &lt;!--End PulumiCodeChooser --&gt;
 * 
 * ### Periodic Recording
 * 
 * &lt;!--Start PulumiCodeChooser --&gt;
 * <pre>
 * {@code
 * package generated_program;
 * 
 * import com.pulumi.Context;
 * import com.pulumi.Pulumi;
 * import com.pulumi.core.Output;
 * import com.pulumi.aws.cfg.Recorder;
 * import com.pulumi.aws.cfg.RecorderArgs;
 * import com.pulumi.aws.cfg.inputs.RecorderRecordingGroupArgs;
 * import com.pulumi.aws.cfg.inputs.RecorderRecordingModeArgs;
 * import com.pulumi.aws.cfg.inputs.RecorderRecordingModeRecordingModeOverrideArgs;
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
 *         var foo = new Recorder("foo", RecorderArgs.builder()
 *             .name("example")
 *             .roleArn(r.arn())
 *             .recordingGroup(RecorderRecordingGroupArgs.builder()
 *                 .allSupported(false)
 *                 .includeGlobalResourceTypes(false)
 *                 .resourceTypes(                
 *                     "AWS::EC2::Instance",
 *                     "AWS::EC2::NetworkInterface")
 *                 .build())
 *             .recordingMode(RecorderRecordingModeArgs.builder()
 *                 .recordingFrequency("CONTINUOUS")
 *                 .recordingModeOverride(RecorderRecordingModeRecordingModeOverrideArgs.builder()
 *                     .description("Only record EC2 network interfaces daily")
 *                     .resourceTypes("AWS::EC2::NetworkInterface")
 *                     .recordingFrequency("DAILY")
 *                     .build())
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
 * Using `pulumi import`, import Configuration Recorder using the name. For example:
 * 
 * ```sh
 * $ pulumi import aws:cfg/recorder:Recorder foo example
 * ```
 * 
 */
@ResourceType(type="aws:cfg/recorder:Recorder")
public class Recorder extends com.pulumi.resources.CustomResource {
    /**
     * The name of the recorder. Defaults to `default`. Changing it recreates the resource.
     * 
     */
    @Export(name="name", refs={String.class}, tree="[0]")
    private Output<String> name;

    /**
     * @return The name of the recorder. Defaults to `default`. Changing it recreates the resource.
     * 
     */
    public Output<String> name() {
        return this.name;
    }
    /**
     * Recording group - see below.
     * 
     */
    @Export(name="recordingGroup", refs={RecorderRecordingGroup.class}, tree="[0]")
    private Output<RecorderRecordingGroup> recordingGroup;

    /**
     * @return Recording group - see below.
     * 
     */
    public Output<RecorderRecordingGroup> recordingGroup() {
        return this.recordingGroup;
    }
    /**
     * Recording mode - see below.
     * 
     */
    @Export(name="recordingMode", refs={RecorderRecordingMode.class}, tree="[0]")
    private Output<RecorderRecordingMode> recordingMode;

    /**
     * @return Recording mode - see below.
     * 
     */
    public Output<RecorderRecordingMode> recordingMode() {
        return this.recordingMode;
    }
    /**
     * Amazon Resource Name (ARN) of the IAM role. Used to make read or write requests to the delivery channel and to describe the AWS resources associated with the account. See [AWS Docs](http://docs.aws.amazon.com/config/latest/developerguide/iamrole-permissions.html) for more details.
     * 
     */
    @Export(name="roleArn", refs={String.class}, tree="[0]")
    private Output<String> roleArn;

    /**
     * @return Amazon Resource Name (ARN) of the IAM role. Used to make read or write requests to the delivery channel and to describe the AWS resources associated with the account. See [AWS Docs](http://docs.aws.amazon.com/config/latest/developerguide/iamrole-permissions.html) for more details.
     * 
     */
    public Output<String> roleArn() {
        return this.roleArn;
    }

    /**
     *
     * @param name The _unique_ name of the resulting resource.
     */
    public Recorder(java.lang.String name) {
        this(name, RecorderArgs.Empty);
    }
    /**
     *
     * @param name The _unique_ name of the resulting resource.
     * @param args The arguments to use to populate this resource's properties.
     */
    public Recorder(java.lang.String name, RecorderArgs args) {
        this(name, args, null);
    }
    /**
     *
     * @param name The _unique_ name of the resulting resource.
     * @param args The arguments to use to populate this resource's properties.
     * @param options A bag of options that control this resource's behavior.
     */
    public Recorder(java.lang.String name, RecorderArgs args, @Nullable com.pulumi.resources.CustomResourceOptions options) {
        super("aws:cfg/recorder:Recorder", name, makeArgs(args, options), makeResourceOptions(options, Codegen.empty()), false);
    }

    private Recorder(java.lang.String name, Output<java.lang.String> id, @Nullable RecorderState state, @Nullable com.pulumi.resources.CustomResourceOptions options) {
        super("aws:cfg/recorder:Recorder", name, state, makeResourceOptions(options, id), false);
    }

    private static RecorderArgs makeArgs(RecorderArgs args, @Nullable com.pulumi.resources.CustomResourceOptions options) {
        if (options != null && options.getUrn().isPresent()) {
            return null;
        }
        return args == null ? RecorderArgs.Empty : args;
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
    public static Recorder get(java.lang.String name, Output<java.lang.String> id, @Nullable RecorderState state, @Nullable com.pulumi.resources.CustomResourceOptions options) {
        return new Recorder(name, id, state, options);
    }
}
