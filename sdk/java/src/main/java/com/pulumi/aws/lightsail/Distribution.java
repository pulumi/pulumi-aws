// *** WARNING: this file was generated by pulumi-java-gen. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

package com.pulumi.aws.lightsail;

import com.pulumi.aws.Utilities;
import com.pulumi.aws.lightsail.DistributionArgs;
import com.pulumi.aws.lightsail.inputs.DistributionState;
import com.pulumi.aws.lightsail.outputs.DistributionCacheBehavior;
import com.pulumi.aws.lightsail.outputs.DistributionCacheBehaviorSettings;
import com.pulumi.aws.lightsail.outputs.DistributionDefaultCacheBehavior;
import com.pulumi.aws.lightsail.outputs.DistributionLocation;
import com.pulumi.aws.lightsail.outputs.DistributionOrigin;
import com.pulumi.core.Output;
import com.pulumi.core.annotations.Export;
import com.pulumi.core.annotations.ResourceType;
import com.pulumi.core.internal.Codegen;
import java.lang.Boolean;
import java.lang.String;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import javax.annotation.Nullable;

/**
 * Resource for managing an AWS Lightsail Distribution.
 * 
 * ## Example Usage
 * 
 * ### Basic Usage
 * 
 * Below is a basic example with a bucket as an origin.
 * 
 * &lt;!--Start PulumiCodeChooser --&gt;
 * <pre>
 * {@code
 * package generated_program;
 * 
 * import com.pulumi.Context;
 * import com.pulumi.Pulumi;
 * import com.pulumi.core.Output;
 * import com.pulumi.aws.lightsail.Bucket;
 * import com.pulumi.aws.lightsail.BucketArgs;
 * import com.pulumi.aws.lightsail.Distribution;
 * import com.pulumi.aws.lightsail.DistributionArgs;
 * import com.pulumi.aws.lightsail.inputs.DistributionOriginArgs;
 * import com.pulumi.aws.lightsail.inputs.DistributionDefaultCacheBehaviorArgs;
 * import com.pulumi.aws.lightsail.inputs.DistributionCacheBehaviorSettingsArgs;
 * import com.pulumi.aws.lightsail.inputs.DistributionCacheBehaviorSettingsForwardedCookiesArgs;
 * import com.pulumi.aws.lightsail.inputs.DistributionCacheBehaviorSettingsForwardedHeadersArgs;
 * import com.pulumi.aws.lightsail.inputs.DistributionCacheBehaviorSettingsForwardedQueryStringsArgs;
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
 *         var test = new Bucket("test", BucketArgs.builder()
 *             .name("test-bucket")
 *             .bundleId("small_1_0")
 *             .build());
 * 
 *         var testDistribution = new Distribution("testDistribution", DistributionArgs.builder()
 *             .name("test-distribution")
 *             .bundleId("small_1_0")
 *             .origin(DistributionOriginArgs.builder()
 *                 .name(test.name())
 *                 .regionName(test.region())
 *                 .build())
 *             .defaultCacheBehavior(DistributionDefaultCacheBehaviorArgs.builder()
 *                 .behavior("cache")
 *                 .build())
 *             .cacheBehaviorSettings(DistributionCacheBehaviorSettingsArgs.builder()
 *                 .allowedHttpMethods("GET,HEAD,OPTIONS,PUT,PATCH,POST,DELETE")
 *                 .cachedHttpMethods("GET,HEAD")
 *                 .defaultTtl(86400)
 *                 .maximumTtl(31536000)
 *                 .minimumTtl(0)
 *                 .forwardedCookies(DistributionCacheBehaviorSettingsForwardedCookiesArgs.builder()
 *                     .option("none")
 *                     .build())
 *                 .forwardedHeaders(DistributionCacheBehaviorSettingsForwardedHeadersArgs.builder()
 *                     .option("default")
 *                     .build())
 *                 .forwardedQueryStrings(DistributionCacheBehaviorSettingsForwardedQueryStringsArgs.builder()
 *                     .option(false)
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
 * ### instance origin example
 * 
 * Below is an example of an instance as the origin.
 * 
 * &lt;!--Start PulumiCodeChooser --&gt;
 * <pre>
 * {@code
 * package generated_program;
 * 
 * import com.pulumi.Context;
 * import com.pulumi.Pulumi;
 * import com.pulumi.core.Output;
 * import com.pulumi.aws.AwsFunctions;
 * import com.pulumi.aws.inputs.GetAvailabilityZonesArgs;
 * import com.pulumi.aws.lightsail.StaticIp;
 * import com.pulumi.aws.lightsail.StaticIpArgs;
 * import com.pulumi.aws.lightsail.Instance;
 * import com.pulumi.aws.lightsail.InstanceArgs;
 * import com.pulumi.aws.lightsail.StaticIpAttachment;
 * import com.pulumi.aws.lightsail.StaticIpAttachmentArgs;
 * import com.pulumi.aws.lightsail.Distribution;
 * import com.pulumi.aws.lightsail.DistributionArgs;
 * import com.pulumi.aws.lightsail.inputs.DistributionOriginArgs;
 * import com.pulumi.aws.lightsail.inputs.DistributionDefaultCacheBehaviorArgs;
 * import com.pulumi.resources.CustomResourceOptions;
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
 *         final var available = AwsFunctions.getAvailabilityZones(GetAvailabilityZonesArgs.builder()
 *             .state("available")
 *             .filters(GetAvailabilityZonesFilterArgs.builder()
 *                 .name("opt-in-status")
 *                 .values("opt-in-not-required")
 *                 .build())
 *             .build());
 * 
 *         var testStaticIp = new StaticIp("testStaticIp", StaticIpArgs.builder()
 *             .name("test-static-ip")
 *             .build());
 * 
 *         var testInstance = new Instance("testInstance", InstanceArgs.builder()
 *             .name("test-instance")
 *             .availabilityZone(available.names()[0])
 *             .blueprintId("amazon_linux_2")
 *             .bundleId("micro_1_0")
 *             .build());
 * 
 *         var test = new StaticIpAttachment("test", StaticIpAttachmentArgs.builder()
 *             .staticIpName(testStaticIp.name())
 *             .instanceName(testInstance.name())
 *             .build());
 * 
 *         var testDistribution = new Distribution("testDistribution", DistributionArgs.builder()
 *             .name("test-distribution")
 *             .bundleId("small_1_0")
 *             .origin(DistributionOriginArgs.builder()
 *                 .name(testInstance.name())
 *                 .regionName(available.id())
 *                 .build())
 *             .defaultCacheBehavior(DistributionDefaultCacheBehaviorArgs.builder()
 *                 .behavior("cache")
 *                 .build())
 *             .build(), CustomResourceOptions.builder()
 *                 .dependsOn(test)
 *                 .build());
 * 
 *     }
 * }
 * }
 * </pre>
 * &lt;!--End PulumiCodeChooser --&gt;
 * 
 * ### lb origin example
 * 
 * Below is an example with a load balancer as an origin
 * 
 * &lt;!--Start PulumiCodeChooser --&gt;
 * <pre>
 * {@code
 * package generated_program;
 * 
 * import com.pulumi.Context;
 * import com.pulumi.Pulumi;
 * import com.pulumi.core.Output;
 * import com.pulumi.aws.AwsFunctions;
 * import com.pulumi.aws.inputs.GetAvailabilityZonesArgs;
 * import com.pulumi.aws.lightsail.Lb;
 * import com.pulumi.aws.lightsail.LbArgs;
 * import com.pulumi.aws.lightsail.Instance;
 * import com.pulumi.aws.lightsail.InstanceArgs;
 * import com.pulumi.aws.lightsail.LbAttachment;
 * import com.pulumi.aws.lightsail.LbAttachmentArgs;
 * import com.pulumi.aws.lightsail.Distribution;
 * import com.pulumi.aws.lightsail.DistributionArgs;
 * import com.pulumi.aws.lightsail.inputs.DistributionOriginArgs;
 * import com.pulumi.aws.lightsail.inputs.DistributionDefaultCacheBehaviorArgs;
 * import com.pulumi.resources.CustomResourceOptions;
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
 *         final var available = AwsFunctions.getAvailabilityZones(GetAvailabilityZonesArgs.builder()
 *             .state("available")
 *             .filters(GetAvailabilityZonesFilterArgs.builder()
 *                 .name("opt-in-status")
 *                 .values("opt-in-not-required")
 *                 .build())
 *             .build());
 * 
 *         var test = new Lb("test", LbArgs.builder()
 *             .name("test-load-balancer")
 *             .healthCheckPath("/")
 *             .instancePort(80)
 *             .tags(Map.of("foo", "bar"))
 *             .build());
 * 
 *         var testInstance = new Instance("testInstance", InstanceArgs.builder()
 *             .name("test-instance")
 *             .availabilityZone(available.names()[0])
 *             .blueprintId("amazon_linux_2")
 *             .bundleId("nano_3_0")
 *             .build());
 * 
 *         var testLbAttachment = new LbAttachment("testLbAttachment", LbAttachmentArgs.builder()
 *             .lbName(test.name())
 *             .instanceName(testInstance.name())
 *             .build());
 * 
 *         var testDistribution = new Distribution("testDistribution", DistributionArgs.builder()
 *             .name("test-distribution")
 *             .bundleId("small_1_0")
 *             .origin(DistributionOriginArgs.builder()
 *                 .name(test.name())
 *                 .regionName(available.id())
 *                 .build())
 *             .defaultCacheBehavior(DistributionDefaultCacheBehaviorArgs.builder()
 *                 .behavior("cache")
 *                 .build())
 *             .build(), CustomResourceOptions.builder()
 *                 .dependsOn(testLbAttachment)
 *                 .build());
 * 
 *     }
 * }
 * }
 * </pre>
 * &lt;!--End PulumiCodeChooser --&gt;
 * 
 * ## Import
 * 
 * Using `pulumi import`, import Lightsail Distribution using the `id`. For example:
 * 
 * ```sh
 * $ pulumi import aws:lightsail/distribution:Distribution example rft-8012925589
 * ```
 * 
 */
@ResourceType(type="aws:lightsail/distribution:Distribution")
public class Distribution extends com.pulumi.resources.CustomResource {
    /**
     * The alternate domain names of the distribution.
     * 
     */
    @Export(name="alternativeDomainNames", refs={List.class,String.class}, tree="[0,1]")
    private Output<List<String>> alternativeDomainNames;

    /**
     * @return The alternate domain names of the distribution.
     * 
     */
    public Output<List<String>> alternativeDomainNames() {
        return this.alternativeDomainNames;
    }
    /**
     * The Amazon Resource Name (ARN) of the distribution.
     * 
     */
    @Export(name="arn", refs={String.class}, tree="[0]")
    private Output<String> arn;

    /**
     * @return The Amazon Resource Name (ARN) of the distribution.
     * 
     */
    public Output<String> arn() {
        return this.arn;
    }
    /**
     * Bundle ID to use for the distribution.
     * 
     */
    @Export(name="bundleId", refs={String.class}, tree="[0]")
    private Output<String> bundleId;

    /**
     * @return Bundle ID to use for the distribution.
     * 
     */
    public Output<String> bundleId() {
        return this.bundleId;
    }
    /**
     * An object that describes the cache behavior settings of the distribution. Detailed below
     * 
     * The following arguments are optional:
     * 
     */
    @Export(name="cacheBehaviorSettings", refs={DistributionCacheBehaviorSettings.class}, tree="[0]")
    private Output</* @Nullable */ DistributionCacheBehaviorSettings> cacheBehaviorSettings;

    /**
     * @return An object that describes the cache behavior settings of the distribution. Detailed below
     * 
     * The following arguments are optional:
     * 
     */
    public Output<Optional<DistributionCacheBehaviorSettings>> cacheBehaviorSettings() {
        return Codegen.optional(this.cacheBehaviorSettings);
    }
    /**
     * A set of configuration blocks that describe the per-path cache behavior of the distribution. Detailed below
     * 
     */
    @Export(name="cacheBehaviors", refs={List.class,DistributionCacheBehavior.class}, tree="[0,1]")
    private Output</* @Nullable */ List<DistributionCacheBehavior>> cacheBehaviors;

    /**
     * @return A set of configuration blocks that describe the per-path cache behavior of the distribution. Detailed below
     * 
     */
    public Output<Optional<List<DistributionCacheBehavior>>> cacheBehaviors() {
        return Codegen.optional(this.cacheBehaviors);
    }
    /**
     * The name of the SSL/TLS certificate attached to the distribution, if any.
     * 
     */
    @Export(name="certificateName", refs={String.class}, tree="[0]")
    private Output</* @Nullable */ String> certificateName;

    /**
     * @return The name of the SSL/TLS certificate attached to the distribution, if any.
     * 
     */
    public Output<Optional<String>> certificateName() {
        return Codegen.optional(this.certificateName);
    }
    /**
     * The timestamp when the distribution was created.
     * 
     */
    @Export(name="createdAt", refs={String.class}, tree="[0]")
    private Output<String> createdAt;

    /**
     * @return The timestamp when the distribution was created.
     * 
     */
    public Output<String> createdAt() {
        return this.createdAt;
    }
    /**
     * Object that describes the default cache behavior of the distribution. Detailed below
     * 
     */
    @Export(name="defaultCacheBehavior", refs={DistributionDefaultCacheBehavior.class}, tree="[0]")
    private Output<DistributionDefaultCacheBehavior> defaultCacheBehavior;

    /**
     * @return Object that describes the default cache behavior of the distribution. Detailed below
     * 
     */
    public Output<DistributionDefaultCacheBehavior> defaultCacheBehavior() {
        return this.defaultCacheBehavior;
    }
    /**
     * The domain name of the distribution.
     * 
     */
    @Export(name="domainName", refs={String.class}, tree="[0]")
    private Output<String> domainName;

    /**
     * @return The domain name of the distribution.
     * 
     */
    public Output<String> domainName() {
        return this.domainName;
    }
    /**
     * The IP address type of the distribution. Default: `dualstack`.
     * 
     */
    @Export(name="ipAddressType", refs={String.class}, tree="[0]")
    private Output</* @Nullable */ String> ipAddressType;

    /**
     * @return The IP address type of the distribution. Default: `dualstack`.
     * 
     */
    public Output<Optional<String>> ipAddressType() {
        return Codegen.optional(this.ipAddressType);
    }
    /**
     * Indicates whether the distribution is enabled. Default: `true`.
     * 
     */
    @Export(name="isEnabled", refs={Boolean.class}, tree="[0]")
    private Output</* @Nullable */ Boolean> isEnabled;

    /**
     * @return Indicates whether the distribution is enabled. Default: `true`.
     * 
     */
    public Output<Optional<Boolean>> isEnabled() {
        return Codegen.optional(this.isEnabled);
    }
    /**
     * An object that describes the location of the distribution, such as the AWS Region and Availability Zone. Detailed below
     * 
     */
    @Export(name="locations", refs={List.class,DistributionLocation.class}, tree="[0,1]")
    private Output<List<DistributionLocation>> locations;

    /**
     * @return An object that describes the location of the distribution, such as the AWS Region and Availability Zone. Detailed below
     * 
     */
    public Output<List<DistributionLocation>> locations() {
        return this.locations;
    }
    /**
     * Name of the distribution.
     * 
     */
    @Export(name="name", refs={String.class}, tree="[0]")
    private Output<String> name;

    /**
     * @return Name of the distribution.
     * 
     */
    public Output<String> name() {
        return this.name;
    }
    /**
     * Object that describes the origin resource of the distribution, such as a Lightsail instance, bucket, or load balancer. Detailed below
     * 
     */
    @Export(name="origin", refs={DistributionOrigin.class}, tree="[0]")
    private Output<DistributionOrigin> origin;

    /**
     * @return Object that describes the origin resource of the distribution, such as a Lightsail instance, bucket, or load balancer. Detailed below
     * 
     */
    public Output<DistributionOrigin> origin() {
        return this.origin;
    }
    /**
     * The public DNS of the origin.
     * 
     */
    @Export(name="originPublicDns", refs={String.class}, tree="[0]")
    private Output<String> originPublicDns;

    /**
     * @return The public DNS of the origin.
     * 
     */
    public Output<String> originPublicDns() {
        return this.originPublicDns;
    }
    /**
     * The Lightsail resource type (e.g., Distribution).
     * 
     */
    @Export(name="resourceType", refs={String.class}, tree="[0]")
    private Output<String> resourceType;

    /**
     * @return The Lightsail resource type (e.g., Distribution).
     * 
     */
    public Output<String> resourceType() {
        return this.resourceType;
    }
    /**
     * The status of the distribution.
     * 
     */
    @Export(name="status", refs={String.class}, tree="[0]")
    private Output<String> status;

    /**
     * @return The status of the distribution.
     * 
     */
    public Output<String> status() {
        return this.status;
    }
    /**
     * The support code. Include this code in your email to support when you have questions about your Lightsail distribution. This code enables our support team to look up your Lightsail information more easily.
     * 
     */
    @Export(name="supportCode", refs={String.class}, tree="[0]")
    private Output<String> supportCode;

    /**
     * @return The support code. Include this code in your email to support when you have questions about your Lightsail distribution. This code enables our support team to look up your Lightsail information more easily.
     * 
     */
    public Output<String> supportCode() {
        return this.supportCode;
    }
    /**
     * Map of tags for the Lightsail Distribution. To create a key-only tag, use an empty string as the value. If configured with a provider `default_tags` configuration block present, tags with matching keys will overwrite those defined at the provider-level.
     * 
     */
    @Export(name="tags", refs={Map.class,String.class}, tree="[0,1,1]")
    private Output</* @Nullable */ Map<String,String>> tags;

    /**
     * @return Map of tags for the Lightsail Distribution. To create a key-only tag, use an empty string as the value. If configured with a provider `default_tags` configuration block present, tags with matching keys will overwrite those defined at the provider-level.
     * 
     */
    public Output<Optional<Map<String,String>>> tags() {
        return Codegen.optional(this.tags);
    }
    /**
     * A map of tags assigned to the resource, including those inherited from the provider `default_tags` configuration block.
     * 
     * @deprecated
     * Please use `tags` instead.
     * 
     */
    @Deprecated /* Please use `tags` instead. */
    @Export(name="tagsAll", refs={Map.class,String.class}, tree="[0,1,1]")
    private Output<Map<String,String>> tagsAll;

    /**
     * @return A map of tags assigned to the resource, including those inherited from the provider `default_tags` configuration block.
     * 
     */
    public Output<Map<String,String>> tagsAll() {
        return this.tagsAll;
    }

    /**
     *
     * @param name The _unique_ name of the resulting resource.
     */
    public Distribution(java.lang.String name) {
        this(name, DistributionArgs.Empty);
    }
    /**
     *
     * @param name The _unique_ name of the resulting resource.
     * @param args The arguments to use to populate this resource's properties.
     */
    public Distribution(java.lang.String name, DistributionArgs args) {
        this(name, args, null);
    }
    /**
     *
     * @param name The _unique_ name of the resulting resource.
     * @param args The arguments to use to populate this resource's properties.
     * @param options A bag of options that control this resource's behavior.
     */
    public Distribution(java.lang.String name, DistributionArgs args, @Nullable com.pulumi.resources.CustomResourceOptions options) {
        super("aws:lightsail/distribution:Distribution", name, makeArgs(args, options), makeResourceOptions(options, Codegen.empty()), false);
    }

    private Distribution(java.lang.String name, Output<java.lang.String> id, @Nullable DistributionState state, @Nullable com.pulumi.resources.CustomResourceOptions options) {
        super("aws:lightsail/distribution:Distribution", name, state, makeResourceOptions(options, id), false);
    }

    private static DistributionArgs makeArgs(DistributionArgs args, @Nullable com.pulumi.resources.CustomResourceOptions options) {
        if (options != null && options.getUrn().isPresent()) {
            return null;
        }
        return args == null ? DistributionArgs.Empty : args;
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
    public static Distribution get(java.lang.String name, Output<java.lang.String> id, @Nullable DistributionState state, @Nullable com.pulumi.resources.CustomResourceOptions options) {
        return new Distribution(name, id, state, options);
    }
}
