// *** WARNING: this file was generated by pulumi-java-gen. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

package com.pulumi.aws.elb;

import com.pulumi.aws.Utilities;
import com.pulumi.aws.elb.LoadBalancerArgs;
import com.pulumi.aws.elb.inputs.LoadBalancerState;
import com.pulumi.aws.elb.outputs.LoadBalancerAccessLogs;
import com.pulumi.aws.elb.outputs.LoadBalancerHealthCheck;
import com.pulumi.aws.elb.outputs.LoadBalancerListener;
import com.pulumi.core.Alias;
import com.pulumi.core.Output;
import com.pulumi.core.annotations.Export;
import com.pulumi.core.annotations.ResourceType;
import com.pulumi.core.internal.Codegen;
import java.lang.Boolean;
import java.lang.Integer;
import java.lang.String;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import javax.annotation.Nullable;

/**
 * Provides an Elastic Load Balancer resource, also known as a &#34;Classic
 * Load Balancer&#34; after the release of
 * Application/Network Load Balancers.
 * 
 * &gt; **NOTE on ELB Instances and ELB Attachments:** This provider currently
 * provides both a standalone ELB Attachment resource
 * (describing an instance attached to an ELB), and an ELB resource with
 * `instances` defined in-line. At this time you cannot use an ELB with in-line
 * instances in conjunction with a ELB Attachment resources. Doing so will cause a
 * conflict and will overwrite attachments.
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
 * import com.pulumi.aws.elb.LoadBalancer;
 * import com.pulumi.aws.elb.LoadBalancerArgs;
 * import com.pulumi.aws.elb.inputs.LoadBalancerAccessLogsArgs;
 * import com.pulumi.aws.elb.inputs.LoadBalancerListenerArgs;
 * import com.pulumi.aws.elb.inputs.LoadBalancerHealthCheckArgs;
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
 *         // Create a new load balancer
 *         var bar = new LoadBalancer("bar", LoadBalancerArgs.builder()
 *             .name("foobar-elb")
 *             .availabilityZones(            
 *                 "us-west-2a",
 *                 "us-west-2b",
 *                 "us-west-2c")
 *             .accessLogs(LoadBalancerAccessLogsArgs.builder()
 *                 .bucket("foo")
 *                 .bucketPrefix("bar")
 *                 .interval(60)
 *                 .build())
 *             .listeners(            
 *                 LoadBalancerListenerArgs.builder()
 *                     .instancePort(8000)
 *                     .instanceProtocol("http")
 *                     .lbPort(80)
 *                     .lbProtocol("http")
 *                     .build(),
 *                 LoadBalancerListenerArgs.builder()
 *                     .instancePort(8000)
 *                     .instanceProtocol("http")
 *                     .lbPort(443)
 *                     .lbProtocol("https")
 *                     .sslCertificateId("arn:aws:iam::123456789012:server-certificate/certName")
 *                     .build())
 *             .healthCheck(LoadBalancerHealthCheckArgs.builder()
 *                 .healthyThreshold(2)
 *                 .unhealthyThreshold(2)
 *                 .timeout(3)
 *                 .target("HTTP:8000/")
 *                 .interval(30)
 *                 .build())
 *             .instances(foo.id())
 *             .crossZoneLoadBalancing(true)
 *             .idleTimeout(400)
 *             .connectionDraining(true)
 *             .connectionDrainingTimeout(400)
 *             .tags(Map.of("Name", "foobar-elb"))
 *             .build());
 * 
 *     }
 * }
 * }
 * </pre>
 * &lt;!--End PulumiCodeChooser --&gt;
 * 
 * ## Note on ECDSA Key Algorithm
 * 
 * If the ARN of the `ssl_certificate_id` that is pointed to references a
 * certificate that was signed by an ECDSA key, note that ELB only supports the
 * P256 and P384 curves.  Using a certificate signed by a key using a different
 * curve could produce the error `ERR_SSL_VERSION_OR_CIPHER_MISMATCH` in your
 * browser.
 * 
 * ## Import
 * 
 * Using `pulumi import`, import ELBs using the `name`. For example:
 * 
 * ```sh
 * $ pulumi import aws:elb/loadBalancer:LoadBalancer bar elb-production-12345
 * ```
 * 
 */
@ResourceType(type="aws:elb/loadBalancer:LoadBalancer")
public class LoadBalancer extends com.pulumi.resources.CustomResource {
    /**
     * An Access Logs block. Access Logs documented below.
     * 
     */
    @Export(name="accessLogs", refs={LoadBalancerAccessLogs.class}, tree="[0]")
    private Output</* @Nullable */ LoadBalancerAccessLogs> accessLogs;

    /**
     * @return An Access Logs block. Access Logs documented below.
     * 
     */
    public Output<Optional<LoadBalancerAccessLogs>> accessLogs() {
        return Codegen.optional(this.accessLogs);
    }
    /**
     * The ARN of the ELB
     * 
     */
    @Export(name="arn", refs={String.class}, tree="[0]")
    private Output<String> arn;

    /**
     * @return The ARN of the ELB
     * 
     */
    public Output<String> arn() {
        return this.arn;
    }
    /**
     * The AZ&#39;s to serve traffic in.
     * 
     */
    @Export(name="availabilityZones", refs={List.class,String.class}, tree="[0,1]")
    private Output<List<String>> availabilityZones;

    /**
     * @return The AZ&#39;s to serve traffic in.
     * 
     */
    public Output<List<String>> availabilityZones() {
        return this.availabilityZones;
    }
    /**
     * Boolean to enable connection draining. Default: `false`
     * 
     */
    @Export(name="connectionDraining", refs={Boolean.class}, tree="[0]")
    private Output</* @Nullable */ Boolean> connectionDraining;

    /**
     * @return Boolean to enable connection draining. Default: `false`
     * 
     */
    public Output<Optional<Boolean>> connectionDraining() {
        return Codegen.optional(this.connectionDraining);
    }
    /**
     * The time in seconds to allow for connections to drain. Default: `300`
     * 
     */
    @Export(name="connectionDrainingTimeout", refs={Integer.class}, tree="[0]")
    private Output</* @Nullable */ Integer> connectionDrainingTimeout;

    /**
     * @return The time in seconds to allow for connections to drain. Default: `300`
     * 
     */
    public Output<Optional<Integer>> connectionDrainingTimeout() {
        return Codegen.optional(this.connectionDrainingTimeout);
    }
    /**
     * Enable cross-zone load balancing. Default: `true`
     * 
     */
    @Export(name="crossZoneLoadBalancing", refs={Boolean.class}, tree="[0]")
    private Output</* @Nullable */ Boolean> crossZoneLoadBalancing;

    /**
     * @return Enable cross-zone load balancing. Default: `true`
     * 
     */
    public Output<Optional<Boolean>> crossZoneLoadBalancing() {
        return Codegen.optional(this.crossZoneLoadBalancing);
    }
    /**
     * Determines how the load balancer handles requests that might pose a security risk to an application due to HTTP desync. Valid values are `monitor`, `defensive` (default), `strictest`.
     * 
     */
    @Export(name="desyncMitigationMode", refs={String.class}, tree="[0]")
    private Output</* @Nullable */ String> desyncMitigationMode;

    /**
     * @return Determines how the load balancer handles requests that might pose a security risk to an application due to HTTP desync. Valid values are `monitor`, `defensive` (default), `strictest`.
     * 
     */
    public Output<Optional<String>> desyncMitigationMode() {
        return Codegen.optional(this.desyncMitigationMode);
    }
    /**
     * The DNS name of the ELB
     * 
     */
    @Export(name="dnsName", refs={String.class}, tree="[0]")
    private Output<String> dnsName;

    /**
     * @return The DNS name of the ELB
     * 
     */
    public Output<String> dnsName() {
        return this.dnsName;
    }
    /**
     * A health_check block. Health Check documented below.
     * 
     */
    @Export(name="healthCheck", refs={LoadBalancerHealthCheck.class}, tree="[0]")
    private Output<LoadBalancerHealthCheck> healthCheck;

    /**
     * @return A health_check block. Health Check documented below.
     * 
     */
    public Output<LoadBalancerHealthCheck> healthCheck() {
        return this.healthCheck;
    }
    /**
     * The time in seconds that the connection is allowed to be idle. Default: `60`
     * 
     */
    @Export(name="idleTimeout", refs={Integer.class}, tree="[0]")
    private Output</* @Nullable */ Integer> idleTimeout;

    /**
     * @return The time in seconds that the connection is allowed to be idle. Default: `60`
     * 
     */
    public Output<Optional<Integer>> idleTimeout() {
        return Codegen.optional(this.idleTimeout);
    }
    /**
     * A list of instance ids to place in the ELB pool.
     * 
     */
    @Export(name="instances", refs={List.class,String.class}, tree="[0,1]")
    private Output<List<String>> instances;

    /**
     * @return A list of instance ids to place in the ELB pool.
     * 
     */
    public Output<List<String>> instances() {
        return this.instances;
    }
    /**
     * If true, ELB will be an internal ELB.
     * 
     */
    @Export(name="internal", refs={Boolean.class}, tree="[0]")
    private Output<Boolean> internal;

    /**
     * @return If true, ELB will be an internal ELB.
     * 
     */
    public Output<Boolean> internal() {
        return this.internal;
    }
    /**
     * A list of listener blocks. Listeners documented below.
     * 
     */
    @Export(name="listeners", refs={List.class,LoadBalancerListener.class}, tree="[0,1]")
    private Output<List<LoadBalancerListener>> listeners;

    /**
     * @return A list of listener blocks. Listeners documented below.
     * 
     */
    public Output<List<LoadBalancerListener>> listeners() {
        return this.listeners;
    }
    /**
     * The name of the ELB. By default generated by this provider.
     * 
     */
    @Export(name="name", refs={String.class}, tree="[0]")
    private Output<String> name;

    /**
     * @return The name of the ELB. By default generated by this provider.
     * 
     */
    public Output<String> name() {
        return this.name;
    }
    /**
     * Creates a unique name beginning with the specified
     * prefix. Conflicts with `name`.
     * 
     */
    @Export(name="namePrefix", refs={String.class}, tree="[0]")
    private Output<String> namePrefix;

    /**
     * @return Creates a unique name beginning with the specified
     * prefix. Conflicts with `name`.
     * 
     */
    public Output<String> namePrefix() {
        return this.namePrefix;
    }
    /**
     * A list of security group IDs to assign to the ELB.
     * Only valid if creating an ELB within a VPC
     * 
     */
    @Export(name="securityGroups", refs={List.class,String.class}, tree="[0,1]")
    private Output<List<String>> securityGroups;

    /**
     * @return A list of security group IDs to assign to the ELB.
     * Only valid if creating an ELB within a VPC
     * 
     */
    public Output<List<String>> securityGroups() {
        return this.securityGroups;
    }
    /**
     * The name of the security group that you can use as
     * part of your inbound rules for your load balancer&#39;s back-end application
     * instances. Use this for Classic or Default VPC only.
     * 
     */
    @Export(name="sourceSecurityGroup", refs={String.class}, tree="[0]")
    private Output<String> sourceSecurityGroup;

    /**
     * @return The name of the security group that you can use as
     * part of your inbound rules for your load balancer&#39;s back-end application
     * instances. Use this for Classic or Default VPC only.
     * 
     */
    public Output<String> sourceSecurityGroup() {
        return this.sourceSecurityGroup;
    }
    /**
     * The ID of the security group that you can use as
     * part of your inbound rules for your load balancer&#39;s back-end application
     * instances. Only available on ELBs launched in a VPC.
     * 
     */
    @Export(name="sourceSecurityGroupId", refs={String.class}, tree="[0]")
    private Output<String> sourceSecurityGroupId;

    /**
     * @return The ID of the security group that you can use as
     * part of your inbound rules for your load balancer&#39;s back-end application
     * instances. Only available on ELBs launched in a VPC.
     * 
     */
    public Output<String> sourceSecurityGroupId() {
        return this.sourceSecurityGroupId;
    }
    /**
     * A list of subnet IDs to attach to the ELB. When an update to subnets will remove all current subnets, this will force a new resource.
     * 
     */
    @Export(name="subnets", refs={List.class,String.class}, tree="[0,1]")
    private Output<List<String>> subnets;

    /**
     * @return A list of subnet IDs to attach to the ELB. When an update to subnets will remove all current subnets, this will force a new resource.
     * 
     */
    public Output<List<String>> subnets() {
        return this.subnets;
    }
    /**
     * A map of tags to assign to the resource. If configured with a provider `default_tags` configuration block present, tags with matching keys will overwrite those defined at the provider-level.
     * 
     * Exactly one of `availability_zones` or `subnets` must be specified: this
     * determines if the ELB exists in a VPC or in EC2-classic.
     * 
     */
    @Export(name="tags", refs={Map.class,String.class}, tree="[0,1,1]")
    private Output</* @Nullable */ Map<String,String>> tags;

    /**
     * @return A map of tags to assign to the resource. If configured with a provider `default_tags` configuration block present, tags with matching keys will overwrite those defined at the provider-level.
     * 
     * Exactly one of `availability_zones` or `subnets` must be specified: this
     * determines if the ELB exists in a VPC or in EC2-classic.
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
     * The canonical hosted zone ID of the ELB (to be used in a Route 53 Alias record)
     * 
     */
    @Export(name="zoneId", refs={String.class}, tree="[0]")
    private Output<String> zoneId;

    /**
     * @return The canonical hosted zone ID of the ELB (to be used in a Route 53 Alias record)
     * 
     */
    public Output<String> zoneId() {
        return this.zoneId;
    }

    /**
     *
     * @param name The _unique_ name of the resulting resource.
     */
    public LoadBalancer(java.lang.String name) {
        this(name, LoadBalancerArgs.Empty);
    }
    /**
     *
     * @param name The _unique_ name of the resulting resource.
     * @param args The arguments to use to populate this resource's properties.
     */
    public LoadBalancer(java.lang.String name, LoadBalancerArgs args) {
        this(name, args, null);
    }
    /**
     *
     * @param name The _unique_ name of the resulting resource.
     * @param args The arguments to use to populate this resource's properties.
     * @param options A bag of options that control this resource's behavior.
     */
    public LoadBalancer(java.lang.String name, LoadBalancerArgs args, @Nullable com.pulumi.resources.CustomResourceOptions options) {
        super("aws:elb/loadBalancer:LoadBalancer", name, makeArgs(args, options), makeResourceOptions(options, Codegen.empty()), false);
    }

    private LoadBalancer(java.lang.String name, Output<java.lang.String> id, @Nullable LoadBalancerState state, @Nullable com.pulumi.resources.CustomResourceOptions options) {
        super("aws:elb/loadBalancer:LoadBalancer", name, state, makeResourceOptions(options, id), false);
    }

    private static LoadBalancerArgs makeArgs(LoadBalancerArgs args, @Nullable com.pulumi.resources.CustomResourceOptions options) {
        if (options != null && options.getUrn().isPresent()) {
            return null;
        }
        return args == null ? LoadBalancerArgs.Empty : args;
    }

    private static com.pulumi.resources.CustomResourceOptions makeResourceOptions(@Nullable com.pulumi.resources.CustomResourceOptions options, @Nullable Output<java.lang.String> id) {
        var defaultOptions = com.pulumi.resources.CustomResourceOptions.builder()
            .version(Utilities.getVersion())
            .aliases(List.of(
                Output.of(Alias.builder().type("aws:elasticloadbalancing/loadBalancer:LoadBalancer").build())
            ))
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
    public static LoadBalancer get(java.lang.String name, Output<java.lang.String> id, @Nullable LoadBalancerState state, @Nullable com.pulumi.resources.CustomResourceOptions options) {
        return new LoadBalancer(name, id, state, options);
    }
}
