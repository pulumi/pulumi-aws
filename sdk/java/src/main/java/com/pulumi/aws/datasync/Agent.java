// *** WARNING: this file was generated by pulumi-java-gen. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

package com.pulumi.aws.datasync;

import com.pulumi.aws.Utilities;
import com.pulumi.aws.datasync.AgentArgs;
import com.pulumi.aws.datasync.inputs.AgentState;
import com.pulumi.core.Output;
import com.pulumi.core.annotations.Export;
import com.pulumi.core.annotations.ResourceType;
import com.pulumi.core.internal.Codegen;
import java.lang.String;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import javax.annotation.Nullable;

/**
 * Manages an AWS DataSync Agent deployed on premises.
 * 
 * &gt; **NOTE:** One of `activation_key` or `ip_address` must be provided for resource creation (agent activation). Neither is required for resource import. If using `ip_address`, this provider must be able to make an HTTP (port 80) GET request to the specified IP address from where it is running. The agent will turn off that HTTP server after activation.
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
 * import com.pulumi.aws.datasync.Agent;
 * import com.pulumi.aws.datasync.AgentArgs;
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
 *         var example = new Agent("example", AgentArgs.builder()
 *             .ipAddress("1.2.3.4")
 *             .name("example")
 *             .build());
 * 
 *     }
 * }
 * }
 * </pre>
 * &lt;!--End PulumiCodeChooser --&gt;
 * 
 * ### With VPC Endpoints
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
 * import com.pulumi.aws.ec2.VpcEndpoint;
 * import com.pulumi.aws.ec2.VpcEndpointArgs;
 * import com.pulumi.aws.ec2.Ec2Functions;
 * import com.pulumi.aws.ec2.inputs.GetNetworkInterfaceArgs;
 * import com.pulumi.aws.datasync.Agent;
 * import com.pulumi.aws.datasync.AgentArgs;
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
 *         var exampleVpcEndpoint = new VpcEndpoint("exampleVpcEndpoint", VpcEndpointArgs.builder()
 *             .serviceName(String.format("com.amazonaws.%s.datasync", current.name()))
 *             .vpcId(exampleAwsVpc.id())
 *             .securityGroupIds(exampleAwsSecurityGroup.id())
 *             .subnetIds(exampleAwsSubnet.id())
 *             .vpcEndpointType("Interface")
 *             .build());
 * 
 *         final var example = Ec2Functions.getNetworkInterface(GetNetworkInterfaceArgs.builder()
 *             .id(exampleVpcEndpoint.networkInterfaceIds().applyValue(_networkInterfaceIds -> _networkInterfaceIds[0]))
 *             .build());
 * 
 *         var exampleAgent = new Agent("exampleAgent", AgentArgs.builder()
 *             .ipAddress("1.2.3.4")
 *             .securityGroupArns(exampleAwsSecurityGroup.arn())
 *             .subnetArns(exampleAwsSubnet.arn())
 *             .vpcEndpointId(exampleVpcEndpoint.id())
 *             .privateLinkEndpoint(example.applyValue(_example -> _example.privateIp()))
 *             .name("example")
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
 * Using `pulumi import`, import `aws_datasync_agent` using the DataSync Agent Amazon Resource Name (ARN). For example:
 * 
 * ```sh
 * $ pulumi import aws:datasync/agent:Agent example arn:aws:datasync:us-east-1:123456789012:agent/agent-12345678901234567
 * ```
 * 
 */
@ResourceType(type="aws:datasync/agent:Agent")
public class Agent extends com.pulumi.resources.CustomResource {
    /**
     * DataSync Agent activation key during resource creation. Conflicts with `ip_address`. If an `ip_address` is provided instead, the provider will retrieve the `activation_key` as part of the resource creation.
     * 
     */
    @Export(name="activationKey", refs={String.class}, tree="[0]")
    private Output<String> activationKey;

    /**
     * @return DataSync Agent activation key during resource creation. Conflicts with `ip_address`. If an `ip_address` is provided instead, the provider will retrieve the `activation_key` as part of the resource creation.
     * 
     */
    public Output<String> activationKey() {
        return this.activationKey;
    }
    /**
     * Amazon Resource Name (ARN) of the DataSync Agent.
     * 
     */
    @Export(name="arn", refs={String.class}, tree="[0]")
    private Output<String> arn;

    /**
     * @return Amazon Resource Name (ARN) of the DataSync Agent.
     * 
     */
    public Output<String> arn() {
        return this.arn;
    }
    /**
     * DataSync Agent IP address to retrieve activation key during resource creation. Conflicts with `activation_key`. DataSync Agent must be accessible on port 80 from where the provider is running.
     * 
     */
    @Export(name="ipAddress", refs={String.class}, tree="[0]")
    private Output<String> ipAddress;

    /**
     * @return DataSync Agent IP address to retrieve activation key during resource creation. Conflicts with `activation_key`. DataSync Agent must be accessible on port 80 from where the provider is running.
     * 
     */
    public Output<String> ipAddress() {
        return this.ipAddress;
    }
    /**
     * Name of the DataSync Agent.
     * 
     */
    @Export(name="name", refs={String.class}, tree="[0]")
    private Output<String> name;

    /**
     * @return Name of the DataSync Agent.
     * 
     */
    public Output<String> name() {
        return this.name;
    }
    /**
     * The IP address of the VPC endpoint the agent should connect to when retrieving an activation key during resource creation. Conflicts with `activation_key`.
     * 
     */
    @Export(name="privateLinkEndpoint", refs={String.class}, tree="[0]")
    private Output<String> privateLinkEndpoint;

    /**
     * @return The IP address of the VPC endpoint the agent should connect to when retrieving an activation key during resource creation. Conflicts with `activation_key`.
     * 
     */
    public Output<String> privateLinkEndpoint() {
        return this.privateLinkEndpoint;
    }
    /**
     * The ARNs of the security groups used to protect your data transfer task subnets.
     * 
     */
    @Export(name="securityGroupArns", refs={List.class,String.class}, tree="[0,1]")
    private Output</* @Nullable */ List<String>> securityGroupArns;

    /**
     * @return The ARNs of the security groups used to protect your data transfer task subnets.
     * 
     */
    public Output<Optional<List<String>>> securityGroupArns() {
        return Codegen.optional(this.securityGroupArns);
    }
    /**
     * The Amazon Resource Names (ARNs) of the subnets in which DataSync will create elastic network interfaces for each data transfer task.
     * 
     */
    @Export(name="subnetArns", refs={List.class,String.class}, tree="[0,1]")
    private Output</* @Nullable */ List<String>> subnetArns;

    /**
     * @return The Amazon Resource Names (ARNs) of the subnets in which DataSync will create elastic network interfaces for each data transfer task.
     * 
     */
    public Output<Optional<List<String>>> subnetArns() {
        return Codegen.optional(this.subnetArns);
    }
    /**
     * Key-value pairs of resource tags to assign to the DataSync Agent. If configured with a provider `default_tags` configuration block present, tags with matching keys will overwrite those defined at the provider-level.
     * 
     */
    @Export(name="tags", refs={Map.class,String.class}, tree="[0,1,1]")
    private Output</* @Nullable */ Map<String,String>> tags;

    /**
     * @return Key-value pairs of resource tags to assign to the DataSync Agent. If configured with a provider `default_tags` configuration block present, tags with matching keys will overwrite those defined at the provider-level.
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
     * The ID of the VPC (virtual private cloud) endpoint that the agent has access to.
     * 
     */
    @Export(name="vpcEndpointId", refs={String.class}, tree="[0]")
    private Output</* @Nullable */ String> vpcEndpointId;

    /**
     * @return The ID of the VPC (virtual private cloud) endpoint that the agent has access to.
     * 
     */
    public Output<Optional<String>> vpcEndpointId() {
        return Codegen.optional(this.vpcEndpointId);
    }

    /**
     *
     * @param name The _unique_ name of the resulting resource.
     */
    public Agent(java.lang.String name) {
        this(name, AgentArgs.Empty);
    }
    /**
     *
     * @param name The _unique_ name of the resulting resource.
     * @param args The arguments to use to populate this resource's properties.
     */
    public Agent(java.lang.String name, @Nullable AgentArgs args) {
        this(name, args, null);
    }
    /**
     *
     * @param name The _unique_ name of the resulting resource.
     * @param args The arguments to use to populate this resource's properties.
     * @param options A bag of options that control this resource's behavior.
     */
    public Agent(java.lang.String name, @Nullable AgentArgs args, @Nullable com.pulumi.resources.CustomResourceOptions options) {
        super("aws:datasync/agent:Agent", name, makeArgs(args, options), makeResourceOptions(options, Codegen.empty()), false);
    }

    private Agent(java.lang.String name, Output<java.lang.String> id, @Nullable AgentState state, @Nullable com.pulumi.resources.CustomResourceOptions options) {
        super("aws:datasync/agent:Agent", name, state, makeResourceOptions(options, id), false);
    }

    private static AgentArgs makeArgs(@Nullable AgentArgs args, @Nullable com.pulumi.resources.CustomResourceOptions options) {
        if (options != null && options.getUrn().isPresent()) {
            return null;
        }
        return args == null ? AgentArgs.Empty : args;
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
    public static Agent get(java.lang.String name, Output<java.lang.String> id, @Nullable AgentState state, @Nullable com.pulumi.resources.CustomResourceOptions options) {
        return new Agent(name, id, state, options);
    }
}
