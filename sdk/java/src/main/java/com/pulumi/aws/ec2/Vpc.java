// *** WARNING: this file was generated by pulumi-java-gen. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

package com.pulumi.aws.ec2;

import com.pulumi.aws.Utilities;
import com.pulumi.aws.ec2.VpcArgs;
import com.pulumi.aws.ec2.inputs.VpcState;
import com.pulumi.core.Output;
import com.pulumi.core.annotations.Export;
import com.pulumi.core.annotations.ResourceType;
import com.pulumi.core.internal.Codegen;
import java.lang.Boolean;
import java.lang.Integer;
import java.lang.String;
import java.util.Map;
import java.util.Optional;
import javax.annotation.Nullable;

/**
 * Provides a VPC resource.
 * 
 * ## Example Usage
 * 
 * Basic usage:
 * 
 * &lt;!--Start PulumiCodeChooser --&gt;
 * <pre>
 * {@code
 * package generated_program;
 * 
 * import com.pulumi.Context;
 * import com.pulumi.Pulumi;
 * import com.pulumi.core.Output;
 * import com.pulumi.aws.ec2.Vpc;
 * import com.pulumi.aws.ec2.VpcArgs;
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
 *         var main = new Vpc("main", VpcArgs.builder()
 *             .cidrBlock("10.0.0.0/16")
 *             .build());
 * 
 *     }
 * }
 * }
 * </pre>
 * &lt;!--End PulumiCodeChooser --&gt;
 * 
 * Basic usage with tags:
 * 
 * &lt;!--Start PulumiCodeChooser --&gt;
 * <pre>
 * {@code
 * package generated_program;
 * 
 * import com.pulumi.Context;
 * import com.pulumi.Pulumi;
 * import com.pulumi.core.Output;
 * import com.pulumi.aws.ec2.Vpc;
 * import com.pulumi.aws.ec2.VpcArgs;
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
 *         var main = new Vpc("main", VpcArgs.builder()
 *             .cidrBlock("10.0.0.0/16")
 *             .instanceTenancy("default")
 *             .tags(Map.of("Name", "main"))
 *             .build());
 * 
 *     }
 * }
 * }
 * </pre>
 * &lt;!--End PulumiCodeChooser --&gt;
 * 
 * VPC with CIDR from AWS IPAM:
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
 * import com.pulumi.aws.inputs.GetRegionArgs;
 * import com.pulumi.aws.ec2.VpcIpam;
 * import com.pulumi.aws.ec2.VpcIpamArgs;
 * import com.pulumi.aws.ec2.inputs.VpcIpamOperatingRegionArgs;
 * import com.pulumi.aws.ec2.VpcIpamPool;
 * import com.pulumi.aws.ec2.VpcIpamPoolArgs;
 * import com.pulumi.aws.ec2.VpcIpamPoolCidr;
 * import com.pulumi.aws.ec2.VpcIpamPoolCidrArgs;
 * import com.pulumi.aws.ec2.Vpc;
 * import com.pulumi.aws.ec2.VpcArgs;
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
 *         final var current = AwsFunctions.getRegion(GetRegionArgs.builder()
 *             .build());
 * 
 *         var test = new VpcIpam("test", VpcIpamArgs.builder()
 *             .operatingRegions(VpcIpamOperatingRegionArgs.builder()
 *                 .regionName(current.name())
 *                 .build())
 *             .build());
 * 
 *         var testVpcIpamPool = new VpcIpamPool("testVpcIpamPool", VpcIpamPoolArgs.builder()
 *             .addressFamily("ipv4")
 *             .ipamScopeId(test.privateDefaultScopeId())
 *             .locale(current.name())
 *             .build());
 * 
 *         var testVpcIpamPoolCidr = new VpcIpamPoolCidr("testVpcIpamPoolCidr", VpcIpamPoolCidrArgs.builder()
 *             .ipamPoolId(testVpcIpamPool.id())
 *             .cidr("172.20.0.0/16")
 *             .build());
 * 
 *         var testVpc = new Vpc("testVpc", VpcArgs.builder()
 *             .ipv4IpamPoolId(testVpcIpamPool.id())
 *             .ipv4NetmaskLength(28)
 *             .build(), CustomResourceOptions.builder()
 *                 .dependsOn(testVpcIpamPoolCidr)
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
 * Using `pulumi import`, import VPCs using the VPC `id`. For example:
 * 
 * ```sh
 * $ pulumi import aws:ec2/vpc:Vpc test_vpc vpc-a01106c2
 * ```
 * 
 */
@ResourceType(type="aws:ec2/vpc:Vpc")
public class Vpc extends com.pulumi.resources.CustomResource {
    /**
     * Amazon Resource Name (ARN) of VPC
     * 
     */
    @Export(name="arn", refs={String.class}, tree="[0]")
    private Output<String> arn;

    /**
     * @return Amazon Resource Name (ARN) of VPC
     * 
     */
    public Output<String> arn() {
        return this.arn;
    }
    /**
     * Requests an Amazon-provided IPv6 CIDR block with a /56 prefix length for the VPC. You cannot specify the range of IP addresses, or the size of the CIDR block. Default is `false`. Conflicts with `ipv6_ipam_pool_id`
     * 
     */
    @Export(name="assignGeneratedIpv6CidrBlock", refs={Boolean.class}, tree="[0]")
    private Output</* @Nullable */ Boolean> assignGeneratedIpv6CidrBlock;

    /**
     * @return Requests an Amazon-provided IPv6 CIDR block with a /56 prefix length for the VPC. You cannot specify the range of IP addresses, or the size of the CIDR block. Default is `false`. Conflicts with `ipv6_ipam_pool_id`
     * 
     */
    public Output<Optional<Boolean>> assignGeneratedIpv6CidrBlock() {
        return Codegen.optional(this.assignGeneratedIpv6CidrBlock);
    }
    /**
     * The IPv4 CIDR block for the VPC. CIDR can be explicitly set or it can be derived from IPAM using `ipv4_netmask_length`.
     * 
     */
    @Export(name="cidrBlock", refs={String.class}, tree="[0]")
    private Output<String> cidrBlock;

    /**
     * @return The IPv4 CIDR block for the VPC. CIDR can be explicitly set or it can be derived from IPAM using `ipv4_netmask_length`.
     * 
     */
    public Output<String> cidrBlock() {
        return this.cidrBlock;
    }
    /**
     * The ID of the network ACL created by default on VPC creation
     * 
     */
    @Export(name="defaultNetworkAclId", refs={String.class}, tree="[0]")
    private Output<String> defaultNetworkAclId;

    /**
     * @return The ID of the network ACL created by default on VPC creation
     * 
     */
    public Output<String> defaultNetworkAclId() {
        return this.defaultNetworkAclId;
    }
    /**
     * The ID of the route table created by default on VPC creation
     * 
     */
    @Export(name="defaultRouteTableId", refs={String.class}, tree="[0]")
    private Output<String> defaultRouteTableId;

    /**
     * @return The ID of the route table created by default on VPC creation
     * 
     */
    public Output<String> defaultRouteTableId() {
        return this.defaultRouteTableId;
    }
    /**
     * The ID of the security group created by default on VPC creation
     * 
     */
    @Export(name="defaultSecurityGroupId", refs={String.class}, tree="[0]")
    private Output<String> defaultSecurityGroupId;

    /**
     * @return The ID of the security group created by default on VPC creation
     * 
     */
    public Output<String> defaultSecurityGroupId() {
        return this.defaultSecurityGroupId;
    }
    /**
     * DHCP options id of the desired VPC.
     * 
     */
    @Export(name="dhcpOptionsId", refs={String.class}, tree="[0]")
    private Output<String> dhcpOptionsId;

    /**
     * @return DHCP options id of the desired VPC.
     * 
     */
    public Output<String> dhcpOptionsId() {
        return this.dhcpOptionsId;
    }
    /**
     * A boolean flag to enable/disable DNS hostnames in the VPC. Defaults false.
     * 
     */
    @Export(name="enableDnsHostnames", refs={Boolean.class}, tree="[0]")
    private Output<Boolean> enableDnsHostnames;

    /**
     * @return A boolean flag to enable/disable DNS hostnames in the VPC. Defaults false.
     * 
     */
    public Output<Boolean> enableDnsHostnames() {
        return this.enableDnsHostnames;
    }
    /**
     * A boolean flag to enable/disable DNS support in the VPC. Defaults to true.
     * 
     */
    @Export(name="enableDnsSupport", refs={Boolean.class}, tree="[0]")
    private Output</* @Nullable */ Boolean> enableDnsSupport;

    /**
     * @return A boolean flag to enable/disable DNS support in the VPC. Defaults to true.
     * 
     */
    public Output<Optional<Boolean>> enableDnsSupport() {
        return Codegen.optional(this.enableDnsSupport);
    }
    /**
     * Indicates whether Network Address Usage metrics are enabled for your VPC. Defaults to false.
     * 
     */
    @Export(name="enableNetworkAddressUsageMetrics", refs={Boolean.class}, tree="[0]")
    private Output<Boolean> enableNetworkAddressUsageMetrics;

    /**
     * @return Indicates whether Network Address Usage metrics are enabled for your VPC. Defaults to false.
     * 
     */
    public Output<Boolean> enableNetworkAddressUsageMetrics() {
        return this.enableNetworkAddressUsageMetrics;
    }
    /**
     * A tenancy option for instances launched into the VPC. Default is `default`, which ensures that EC2 instances launched in this VPC use the EC2 instance tenancy attribute specified when the EC2 instance is launched. The only other option is `dedicated`, which ensures that EC2 instances launched in this VPC are run on dedicated tenancy instances regardless of the tenancy attribute specified at launch. This has a dedicated per region fee of $2 per hour, plus an hourly per instance usage fee.
     * 
     */
    @Export(name="instanceTenancy", refs={String.class}, tree="[0]")
    private Output</* @Nullable */ String> instanceTenancy;

    /**
     * @return A tenancy option for instances launched into the VPC. Default is `default`, which ensures that EC2 instances launched in this VPC use the EC2 instance tenancy attribute specified when the EC2 instance is launched. The only other option is `dedicated`, which ensures that EC2 instances launched in this VPC are run on dedicated tenancy instances regardless of the tenancy attribute specified at launch. This has a dedicated per region fee of $2 per hour, plus an hourly per instance usage fee.
     * 
     */
    public Output<Optional<String>> instanceTenancy() {
        return Codegen.optional(this.instanceTenancy);
    }
    /**
     * The ID of an IPv4 IPAM pool you want to use for allocating this VPC&#39;s CIDR. IPAM is a VPC feature that you can use to automate your IP address management workflows including assigning, tracking, troubleshooting, and auditing IP addresses across AWS Regions and accounts. Using IPAM you can monitor IP address usage throughout your AWS Organization.
     * 
     */
    @Export(name="ipv4IpamPoolId", refs={String.class}, tree="[0]")
    private Output</* @Nullable */ String> ipv4IpamPoolId;

    /**
     * @return The ID of an IPv4 IPAM pool you want to use for allocating this VPC&#39;s CIDR. IPAM is a VPC feature that you can use to automate your IP address management workflows including assigning, tracking, troubleshooting, and auditing IP addresses across AWS Regions and accounts. Using IPAM you can monitor IP address usage throughout your AWS Organization.
     * 
     */
    public Output<Optional<String>> ipv4IpamPoolId() {
        return Codegen.optional(this.ipv4IpamPoolId);
    }
    /**
     * The netmask length of the IPv4 CIDR you want to allocate to this VPC. Requires specifying a `ipv4_ipam_pool_id`.
     * 
     */
    @Export(name="ipv4NetmaskLength", refs={Integer.class}, tree="[0]")
    private Output</* @Nullable */ Integer> ipv4NetmaskLength;

    /**
     * @return The netmask length of the IPv4 CIDR you want to allocate to this VPC. Requires specifying a `ipv4_ipam_pool_id`.
     * 
     */
    public Output<Optional<Integer>> ipv4NetmaskLength() {
        return Codegen.optional(this.ipv4NetmaskLength);
    }
    /**
     * The association ID for the IPv6 CIDR block.
     * 
     */
    @Export(name="ipv6AssociationId", refs={String.class}, tree="[0]")
    private Output<String> ipv6AssociationId;

    /**
     * @return The association ID for the IPv6 CIDR block.
     * 
     */
    public Output<String> ipv6AssociationId() {
        return this.ipv6AssociationId;
    }
    /**
     * IPv6 CIDR block to request from an IPAM Pool. Can be set explicitly or derived from IPAM using `ipv6_netmask_length`.
     * 
     */
    @Export(name="ipv6CidrBlock", refs={String.class}, tree="[0]")
    private Output<String> ipv6CidrBlock;

    /**
     * @return IPv6 CIDR block to request from an IPAM Pool. Can be set explicitly or derived from IPAM using `ipv6_netmask_length`.
     * 
     */
    public Output<String> ipv6CidrBlock() {
        return this.ipv6CidrBlock;
    }
    /**
     * By default when an IPv6 CIDR is assigned to a VPC a default ipv6_cidr_block_network_border_group will be set to the region of the VPC. This can be changed to restrict advertisement of public addresses to specific Network Border Groups such as LocalZones.
     * 
     */
    @Export(name="ipv6CidrBlockNetworkBorderGroup", refs={String.class}, tree="[0]")
    private Output<String> ipv6CidrBlockNetworkBorderGroup;

    /**
     * @return By default when an IPv6 CIDR is assigned to a VPC a default ipv6_cidr_block_network_border_group will be set to the region of the VPC. This can be changed to restrict advertisement of public addresses to specific Network Border Groups such as LocalZones.
     * 
     */
    public Output<String> ipv6CidrBlockNetworkBorderGroup() {
        return this.ipv6CidrBlockNetworkBorderGroup;
    }
    /**
     * IPAM Pool ID for a IPv6 pool. Conflicts with `assign_generated_ipv6_cidr_block`.
     * 
     */
    @Export(name="ipv6IpamPoolId", refs={String.class}, tree="[0]")
    private Output</* @Nullable */ String> ipv6IpamPoolId;

    /**
     * @return IPAM Pool ID for a IPv6 pool. Conflicts with `assign_generated_ipv6_cidr_block`.
     * 
     */
    public Output<Optional<String>> ipv6IpamPoolId() {
        return Codegen.optional(this.ipv6IpamPoolId);
    }
    /**
     * Netmask length to request from IPAM Pool. Conflicts with `ipv6_cidr_block`. This can be omitted if IPAM pool as a `allocation_default_netmask_length` set. Valid values are from `44` to `60` in increments of 4.
     * 
     */
    @Export(name="ipv6NetmaskLength", refs={Integer.class}, tree="[0]")
    private Output</* @Nullable */ Integer> ipv6NetmaskLength;

    /**
     * @return Netmask length to request from IPAM Pool. Conflicts with `ipv6_cidr_block`. This can be omitted if IPAM pool as a `allocation_default_netmask_length` set. Valid values are from `44` to `60` in increments of 4.
     * 
     */
    public Output<Optional<Integer>> ipv6NetmaskLength() {
        return Codegen.optional(this.ipv6NetmaskLength);
    }
    /**
     * The ID of the main route table associated with
     * this VPC. Note that you can change a VPC&#39;s main route table by using an
     * `aws.ec2.MainRouteTableAssociation`.
     * 
     */
    @Export(name="mainRouteTableId", refs={String.class}, tree="[0]")
    private Output<String> mainRouteTableId;

    /**
     * @return The ID of the main route table associated with
     * this VPC. Note that you can change a VPC&#39;s main route table by using an
     * `aws.ec2.MainRouteTableAssociation`.
     * 
     */
    public Output<String> mainRouteTableId() {
        return this.mainRouteTableId;
    }
    /**
     * The ID of the AWS account that owns the VPC.
     * 
     */
    @Export(name="ownerId", refs={String.class}, tree="[0]")
    private Output<String> ownerId;

    /**
     * @return The ID of the AWS account that owns the VPC.
     * 
     */
    public Output<String> ownerId() {
        return this.ownerId;
    }
    /**
     * A map of tags to assign to the resource. If configured with a provider `default_tags` configuration block present, tags with matching keys will overwrite those defined at the provider-level.
     * 
     */
    @Export(name="tags", refs={Map.class,String.class}, tree="[0,1,1]")
    private Output</* @Nullable */ Map<String,String>> tags;

    /**
     * @return A map of tags to assign to the resource. If configured with a provider `default_tags` configuration block present, tags with matching keys will overwrite those defined at the provider-level.
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
    public Vpc(java.lang.String name) {
        this(name, VpcArgs.Empty);
    }
    /**
     *
     * @param name The _unique_ name of the resulting resource.
     * @param args The arguments to use to populate this resource's properties.
     */
    public Vpc(java.lang.String name, @Nullable VpcArgs args) {
        this(name, args, null);
    }
    /**
     *
     * @param name The _unique_ name of the resulting resource.
     * @param args The arguments to use to populate this resource's properties.
     * @param options A bag of options that control this resource's behavior.
     */
    public Vpc(java.lang.String name, @Nullable VpcArgs args, @Nullable com.pulumi.resources.CustomResourceOptions options) {
        super("aws:ec2/vpc:Vpc", name, makeArgs(args, options), makeResourceOptions(options, Codegen.empty()), false);
    }

    private Vpc(java.lang.String name, Output<java.lang.String> id, @Nullable VpcState state, @Nullable com.pulumi.resources.CustomResourceOptions options) {
        super("aws:ec2/vpc:Vpc", name, state, makeResourceOptions(options, id), false);
    }

    private static VpcArgs makeArgs(@Nullable VpcArgs args, @Nullable com.pulumi.resources.CustomResourceOptions options) {
        if (options != null && options.getUrn().isPresent()) {
            return null;
        }
        return args == null ? VpcArgs.Empty : args;
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
    public static Vpc get(java.lang.String name, Output<java.lang.String> id, @Nullable VpcState state, @Nullable com.pulumi.resources.CustomResourceOptions options) {
        return new Vpc(name, id, state, options);
    }
}
