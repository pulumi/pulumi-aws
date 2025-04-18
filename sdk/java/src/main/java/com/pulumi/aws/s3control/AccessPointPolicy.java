// *** WARNING: this file was generated by pulumi-java-gen. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

package com.pulumi.aws.s3control;

import com.pulumi.aws.Utilities;
import com.pulumi.aws.s3control.AccessPointPolicyArgs;
import com.pulumi.aws.s3control.inputs.AccessPointPolicyState;
import com.pulumi.core.Output;
import com.pulumi.core.annotations.Export;
import com.pulumi.core.annotations.ResourceType;
import com.pulumi.core.internal.Codegen;
import java.lang.Boolean;
import java.lang.String;
import javax.annotation.Nullable;

/**
 * Provides a resource to manage an S3 Access Point resource policy.
 * 
 * &gt; **NOTE on Access Points and Access Point Policies:** The provider provides both a standalone Access Point Policy resource and an Access Point resource with a resource policy defined in-line. You cannot use an Access Point with in-line resource policy in conjunction with an Access Point Policy resource. Doing so will cause a conflict of policies and will overwrite the access point&#39;s resource policy.
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
 * import com.pulumi.aws.s3.BucketV2;
 * import com.pulumi.aws.s3.BucketV2Args;
 * import com.pulumi.aws.s3.AccessPoint;
 * import com.pulumi.aws.s3.AccessPointArgs;
 * import com.pulumi.aws.s3.inputs.AccessPointPublicAccessBlockConfigurationArgs;
 * import com.pulumi.aws.s3control.AccessPointPolicy;
 * import com.pulumi.aws.s3control.AccessPointPolicyArgs;
 * import static com.pulumi.codegen.internal.Serialization.*;
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
 *         var example = new BucketV2("example", BucketV2Args.builder()
 *             .bucket("example")
 *             .build());
 * 
 *         var exampleAccessPoint = new AccessPoint("exampleAccessPoint", AccessPointArgs.builder()
 *             .bucket(example.id())
 *             .name("example")
 *             .publicAccessBlockConfiguration(AccessPointPublicAccessBlockConfigurationArgs.builder()
 *                 .blockPublicAcls(true)
 *                 .blockPublicPolicy(false)
 *                 .ignorePublicAcls(true)
 *                 .restrictPublicBuckets(false)
 *                 .build())
 *             .build());
 * 
 *         var exampleAccessPointPolicy = new AccessPointPolicy("exampleAccessPointPolicy", AccessPointPolicyArgs.builder()
 *             .accessPointArn(exampleAccessPoint.arn())
 *             .policy(exampleAccessPoint.arn().applyValue(_arn -> serializeJson(
 *                 jsonObject(
 *                     jsonProperty("Version", "2008-10-17"),
 *                     jsonProperty("Statement", jsonArray(jsonObject(
 *                         jsonProperty("Effect", "Allow"),
 *                         jsonProperty("Action", "s3:GetObjectTagging"),
 *                         jsonProperty("Principal", jsonObject(
 *                             jsonProperty("AWS", "*")
 *                         )),
 *                         jsonProperty("Resource", String.format("%s/object/*", _arn))
 *                     )))
 *                 ))))
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
 * Using `pulumi import`, import Access Point policies using the `access_point_arn`. For example:
 * 
 * ```sh
 * $ pulumi import aws:s3control/accessPointPolicy:AccessPointPolicy example arn:aws:s3:us-west-2:123456789012:accesspoint/example
 * ```
 * 
 */
@ResourceType(type="aws:s3control/accessPointPolicy:AccessPointPolicy")
public class AccessPointPolicy extends com.pulumi.resources.CustomResource {
    /**
     * The ARN of the access point that you want to associate with the specified policy.
     * 
     */
    @Export(name="accessPointArn", refs={String.class}, tree="[0]")
    private Output<String> accessPointArn;

    /**
     * @return The ARN of the access point that you want to associate with the specified policy.
     * 
     */
    public Output<String> accessPointArn() {
        return this.accessPointArn;
    }
    /**
     * Indicates whether this access point currently has a policy that allows public access.
     * 
     */
    @Export(name="hasPublicAccessPolicy", refs={Boolean.class}, tree="[0]")
    private Output<Boolean> hasPublicAccessPolicy;

    /**
     * @return Indicates whether this access point currently has a policy that allows public access.
     * 
     */
    public Output<Boolean> hasPublicAccessPolicy() {
        return this.hasPublicAccessPolicy;
    }
    /**
     * The policy that you want to apply to the specified access point.
     * 
     */
    @Export(name="policy", refs={String.class}, tree="[0]")
    private Output<String> policy;

    /**
     * @return The policy that you want to apply to the specified access point.
     * 
     */
    public Output<String> policy() {
        return this.policy;
    }

    /**
     *
     * @param name The _unique_ name of the resulting resource.
     */
    public AccessPointPolicy(java.lang.String name) {
        this(name, AccessPointPolicyArgs.Empty);
    }
    /**
     *
     * @param name The _unique_ name of the resulting resource.
     * @param args The arguments to use to populate this resource's properties.
     */
    public AccessPointPolicy(java.lang.String name, AccessPointPolicyArgs args) {
        this(name, args, null);
    }
    /**
     *
     * @param name The _unique_ name of the resulting resource.
     * @param args The arguments to use to populate this resource's properties.
     * @param options A bag of options that control this resource's behavior.
     */
    public AccessPointPolicy(java.lang.String name, AccessPointPolicyArgs args, @Nullable com.pulumi.resources.CustomResourceOptions options) {
        super("aws:s3control/accessPointPolicy:AccessPointPolicy", name, makeArgs(args, options), makeResourceOptions(options, Codegen.empty()), false);
    }

    private AccessPointPolicy(java.lang.String name, Output<java.lang.String> id, @Nullable AccessPointPolicyState state, @Nullable com.pulumi.resources.CustomResourceOptions options) {
        super("aws:s3control/accessPointPolicy:AccessPointPolicy", name, state, makeResourceOptions(options, id), false);
    }

    private static AccessPointPolicyArgs makeArgs(AccessPointPolicyArgs args, @Nullable com.pulumi.resources.CustomResourceOptions options) {
        if (options != null && options.getUrn().isPresent()) {
            return null;
        }
        return args == null ? AccessPointPolicyArgs.Empty : args;
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
    public static AccessPointPolicy get(java.lang.String name, Output<java.lang.String> id, @Nullable AccessPointPolicyState state, @Nullable com.pulumi.resources.CustomResourceOptions options) {
        return new AccessPointPolicy(name, id, state, options);
    }
}
