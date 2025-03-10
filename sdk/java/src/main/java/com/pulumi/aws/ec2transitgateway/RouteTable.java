// *** WARNING: this file was generated by pulumi-java-gen. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

package com.pulumi.aws.ec2transitgateway;

import com.pulumi.aws.Utilities;
import com.pulumi.aws.ec2transitgateway.RouteTableArgs;
import com.pulumi.aws.ec2transitgateway.inputs.RouteTableState;
import com.pulumi.core.Output;
import com.pulumi.core.annotations.Export;
import com.pulumi.core.annotations.ResourceType;
import com.pulumi.core.internal.Codegen;
import java.lang.Boolean;
import java.lang.String;
import java.util.Map;
import java.util.Optional;
import javax.annotation.Nullable;

/**
 * Manages an EC2 Transit Gateway Route Table.
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
 * import com.pulumi.aws.ec2transitgateway.RouteTable;
 * import com.pulumi.aws.ec2transitgateway.RouteTableArgs;
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
 *         var example = new RouteTable("example", RouteTableArgs.builder()
 *             .transitGatewayId(exampleAwsEc2TransitGateway.id())
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
 * Using `pulumi import`, import `aws_ec2_transit_gateway_route_table` using the EC2 Transit Gateway Route Table identifier. For example:
 * 
 * ```sh
 * $ pulumi import aws:ec2transitgateway/routeTable:RouteTable example tgw-rtb-12345678
 * ```
 * 
 */
@ResourceType(type="aws:ec2transitgateway/routeTable:RouteTable")
public class RouteTable extends com.pulumi.resources.CustomResource {
    /**
     * EC2 Transit Gateway Route Table Amazon Resource Name (ARN).
     * 
     */
    @Export(name="arn", refs={String.class}, tree="[0]")
    private Output<String> arn;

    /**
     * @return EC2 Transit Gateway Route Table Amazon Resource Name (ARN).
     * 
     */
    public Output<String> arn() {
        return this.arn;
    }
    /**
     * Boolean whether this is the default association route table for the EC2 Transit Gateway.
     * 
     */
    @Export(name="defaultAssociationRouteTable", refs={Boolean.class}, tree="[0]")
    private Output<Boolean> defaultAssociationRouteTable;

    /**
     * @return Boolean whether this is the default association route table for the EC2 Transit Gateway.
     * 
     */
    public Output<Boolean> defaultAssociationRouteTable() {
        return this.defaultAssociationRouteTable;
    }
    /**
     * Boolean whether this is the default propagation route table for the EC2 Transit Gateway.
     * 
     */
    @Export(name="defaultPropagationRouteTable", refs={Boolean.class}, tree="[0]")
    private Output<Boolean> defaultPropagationRouteTable;

    /**
     * @return Boolean whether this is the default propagation route table for the EC2 Transit Gateway.
     * 
     */
    public Output<Boolean> defaultPropagationRouteTable() {
        return this.defaultPropagationRouteTable;
    }
    /**
     * Key-value tags for the EC2 Transit Gateway Route Table. If configured with a provider `default_tags` configuration block present, tags with matching keys will overwrite those defined at the provider-level.
     * 
     */
    @Export(name="tags", refs={Map.class,String.class}, tree="[0,1,1]")
    private Output</* @Nullable */ Map<String,String>> tags;

    /**
     * @return Key-value tags for the EC2 Transit Gateway Route Table. If configured with a provider `default_tags` configuration block present, tags with matching keys will overwrite those defined at the provider-level.
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
     * Identifier of EC2 Transit Gateway.
     * 
     */
    @Export(name="transitGatewayId", refs={String.class}, tree="[0]")
    private Output<String> transitGatewayId;

    /**
     * @return Identifier of EC2 Transit Gateway.
     * 
     */
    public Output<String> transitGatewayId() {
        return this.transitGatewayId;
    }

    /**
     *
     * @param name The _unique_ name of the resulting resource.
     */
    public RouteTable(java.lang.String name) {
        this(name, RouteTableArgs.Empty);
    }
    /**
     *
     * @param name The _unique_ name of the resulting resource.
     * @param args The arguments to use to populate this resource's properties.
     */
    public RouteTable(java.lang.String name, RouteTableArgs args) {
        this(name, args, null);
    }
    /**
     *
     * @param name The _unique_ name of the resulting resource.
     * @param args The arguments to use to populate this resource's properties.
     * @param options A bag of options that control this resource's behavior.
     */
    public RouteTable(java.lang.String name, RouteTableArgs args, @Nullable com.pulumi.resources.CustomResourceOptions options) {
        super("aws:ec2transitgateway/routeTable:RouteTable", name, makeArgs(args, options), makeResourceOptions(options, Codegen.empty()), false);
    }

    private RouteTable(java.lang.String name, Output<java.lang.String> id, @Nullable RouteTableState state, @Nullable com.pulumi.resources.CustomResourceOptions options) {
        super("aws:ec2transitgateway/routeTable:RouteTable", name, state, makeResourceOptions(options, id), false);
    }

    private static RouteTableArgs makeArgs(RouteTableArgs args, @Nullable com.pulumi.resources.CustomResourceOptions options) {
        if (options != null && options.getUrn().isPresent()) {
            return null;
        }
        return args == null ? RouteTableArgs.Empty : args;
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
    public static RouteTable get(java.lang.String name, Output<java.lang.String> id, @Nullable RouteTableState state, @Nullable com.pulumi.resources.CustomResourceOptions options) {
        return new RouteTable(name, id, state, options);
    }
}
