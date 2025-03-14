// *** WARNING: this file was generated by pulumi-java-gen. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

package com.pulumi.aws.globalaccelerator;

import com.pulumi.aws.Utilities;
import com.pulumi.aws.globalaccelerator.EndpointGroupArgs;
import com.pulumi.aws.globalaccelerator.inputs.EndpointGroupState;
import com.pulumi.aws.globalaccelerator.outputs.EndpointGroupEndpointConfiguration;
import com.pulumi.aws.globalaccelerator.outputs.EndpointGroupPortOverride;
import com.pulumi.core.Output;
import com.pulumi.core.annotations.Export;
import com.pulumi.core.annotations.ResourceType;
import com.pulumi.core.internal.Codegen;
import java.lang.Double;
import java.lang.Integer;
import java.lang.String;
import java.util.List;
import java.util.Optional;
import javax.annotation.Nullable;

/**
 * Provides a Global Accelerator endpoint group.
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
 * import com.pulumi.aws.globalaccelerator.EndpointGroup;
 * import com.pulumi.aws.globalaccelerator.EndpointGroupArgs;
 * import com.pulumi.aws.globalaccelerator.inputs.EndpointGroupEndpointConfigurationArgs;
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
 *         var example = new EndpointGroup("example", EndpointGroupArgs.builder()
 *             .listenerArn(exampleAwsGlobalacceleratorListener.arn())
 *             .endpointConfigurations(EndpointGroupEndpointConfigurationArgs.builder()
 *                 .endpointId(exampleAwsLb.arn())
 *                 .weight(100)
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
 * Using `pulumi import`, import Global Accelerator endpoint groups using the `id`. For example:
 * 
 * ```sh
 * $ pulumi import aws:globalaccelerator/endpointGroup:EndpointGroup example arn:aws:globalaccelerator::111111111111:accelerator/xxxxxxxx-xxxx-xxxx-xxxx-xxxxxxxxxxxx/listener/xxxxxxx/endpoint-group/xxxxxxxx
 * ```
 * 
 */
@ResourceType(type="aws:globalaccelerator/endpointGroup:EndpointGroup")
public class EndpointGroup extends com.pulumi.resources.CustomResource {
    /**
     * The Amazon Resource Name (ARN) of the endpoint group.
     * 
     */
    @Export(name="arn", refs={String.class}, tree="[0]")
    private Output<String> arn;

    /**
     * @return The Amazon Resource Name (ARN) of the endpoint group.
     * 
     */
    public Output<String> arn() {
        return this.arn;
    }
    /**
     * The list of endpoint objects. Fields documented below.
     * 
     */
    @Export(name="endpointConfigurations", refs={List.class,EndpointGroupEndpointConfiguration.class}, tree="[0,1]")
    private Output</* @Nullable */ List<EndpointGroupEndpointConfiguration>> endpointConfigurations;

    /**
     * @return The list of endpoint objects. Fields documented below.
     * 
     */
    public Output<Optional<List<EndpointGroupEndpointConfiguration>>> endpointConfigurations() {
        return Codegen.optional(this.endpointConfigurations);
    }
    /**
     * The name of the AWS Region where the endpoint group is located.
     * 
     */
    @Export(name="endpointGroupRegion", refs={String.class}, tree="[0]")
    private Output<String> endpointGroupRegion;

    /**
     * @return The name of the AWS Region where the endpoint group is located.
     * 
     */
    public Output<String> endpointGroupRegion() {
        return this.endpointGroupRegion;
    }
    /**
     * The time—10 seconds or 30 seconds—between each health check for an endpoint. The default value is 30.
     * 
     */
    @Export(name="healthCheckIntervalSeconds", refs={Integer.class}, tree="[0]")
    private Output</* @Nullable */ Integer> healthCheckIntervalSeconds;

    /**
     * @return The time—10 seconds or 30 seconds—between each health check for an endpoint. The default value is 30.
     * 
     */
    public Output<Optional<Integer>> healthCheckIntervalSeconds() {
        return Codegen.optional(this.healthCheckIntervalSeconds);
    }
    /**
     * If the protocol is HTTP/S, then this specifies the path that is the destination for health check targets. The default value is slash (`/`). the provider will only perform drift detection of its value when present in a configuration.
     * 
     */
    @Export(name="healthCheckPath", refs={String.class}, tree="[0]")
    private Output<String> healthCheckPath;

    /**
     * @return If the protocol is HTTP/S, then this specifies the path that is the destination for health check targets. The default value is slash (`/`). the provider will only perform drift detection of its value when present in a configuration.
     * 
     */
    public Output<String> healthCheckPath() {
        return this.healthCheckPath;
    }
    /**
     * The port that AWS Global Accelerator uses to check the health of endpoints that are part of this endpoint group. The default port is the listener port that this endpoint group is associated with. If listener port is a list of ports, Global Accelerator uses the first port in the list.
     * the provider will only perform drift detection of its value when present in a configuration.
     * 
     */
    @Export(name="healthCheckPort", refs={Integer.class}, tree="[0]")
    private Output<Integer> healthCheckPort;

    /**
     * @return The port that AWS Global Accelerator uses to check the health of endpoints that are part of this endpoint group. The default port is the listener port that this endpoint group is associated with. If listener port is a list of ports, Global Accelerator uses the first port in the list.
     * the provider will only perform drift detection of its value when present in a configuration.
     * 
     */
    public Output<Integer> healthCheckPort() {
        return this.healthCheckPort;
    }
    /**
     * The protocol that AWS Global Accelerator uses to check the health of endpoints that are part of this endpoint group. The default value is TCP.
     * 
     */
    @Export(name="healthCheckProtocol", refs={String.class}, tree="[0]")
    private Output</* @Nullable */ String> healthCheckProtocol;

    /**
     * @return The protocol that AWS Global Accelerator uses to check the health of endpoints that are part of this endpoint group. The default value is TCP.
     * 
     */
    public Output<Optional<String>> healthCheckProtocol() {
        return Codegen.optional(this.healthCheckProtocol);
    }
    /**
     * The Amazon Resource Name (ARN) of the listener.
     * 
     */
    @Export(name="listenerArn", refs={String.class}, tree="[0]")
    private Output<String> listenerArn;

    /**
     * @return The Amazon Resource Name (ARN) of the listener.
     * 
     */
    public Output<String> listenerArn() {
        return this.listenerArn;
    }
    /**
     * Override specific listener ports used to route traffic to endpoints that are part of this endpoint group. Fields documented below.
     * 
     */
    @Export(name="portOverrides", refs={List.class,EndpointGroupPortOverride.class}, tree="[0,1]")
    private Output</* @Nullable */ List<EndpointGroupPortOverride>> portOverrides;

    /**
     * @return Override specific listener ports used to route traffic to endpoints that are part of this endpoint group. Fields documented below.
     * 
     */
    public Output<Optional<List<EndpointGroupPortOverride>>> portOverrides() {
        return Codegen.optional(this.portOverrides);
    }
    /**
     * The number of consecutive health checks required to set the state of a healthy endpoint to unhealthy, or to set an unhealthy endpoint to healthy. The default value is 3.
     * 
     */
    @Export(name="thresholdCount", refs={Integer.class}, tree="[0]")
    private Output</* @Nullable */ Integer> thresholdCount;

    /**
     * @return The number of consecutive health checks required to set the state of a healthy endpoint to unhealthy, or to set an unhealthy endpoint to healthy. The default value is 3.
     * 
     */
    public Output<Optional<Integer>> thresholdCount() {
        return Codegen.optional(this.thresholdCount);
    }
    /**
     * The percentage of traffic to send to an AWS Region. Additional traffic is distributed to other endpoint groups for this listener. The default value is 100.
     * 
     */
    @Export(name="trafficDialPercentage", refs={Double.class}, tree="[0]")
    private Output</* @Nullable */ Double> trafficDialPercentage;

    /**
     * @return The percentage of traffic to send to an AWS Region. Additional traffic is distributed to other endpoint groups for this listener. The default value is 100.
     * 
     */
    public Output<Optional<Double>> trafficDialPercentage() {
        return Codegen.optional(this.trafficDialPercentage);
    }

    /**
     *
     * @param name The _unique_ name of the resulting resource.
     */
    public EndpointGroup(java.lang.String name) {
        this(name, EndpointGroupArgs.Empty);
    }
    /**
     *
     * @param name The _unique_ name of the resulting resource.
     * @param args The arguments to use to populate this resource's properties.
     */
    public EndpointGroup(java.lang.String name, EndpointGroupArgs args) {
        this(name, args, null);
    }
    /**
     *
     * @param name The _unique_ name of the resulting resource.
     * @param args The arguments to use to populate this resource's properties.
     * @param options A bag of options that control this resource's behavior.
     */
    public EndpointGroup(java.lang.String name, EndpointGroupArgs args, @Nullable com.pulumi.resources.CustomResourceOptions options) {
        super("aws:globalaccelerator/endpointGroup:EndpointGroup", name, makeArgs(args, options), makeResourceOptions(options, Codegen.empty()), false);
    }

    private EndpointGroup(java.lang.String name, Output<java.lang.String> id, @Nullable EndpointGroupState state, @Nullable com.pulumi.resources.CustomResourceOptions options) {
        super("aws:globalaccelerator/endpointGroup:EndpointGroup", name, state, makeResourceOptions(options, id), false);
    }

    private static EndpointGroupArgs makeArgs(EndpointGroupArgs args, @Nullable com.pulumi.resources.CustomResourceOptions options) {
        if (options != null && options.getUrn().isPresent()) {
            return null;
        }
        return args == null ? EndpointGroupArgs.Empty : args;
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
    public static EndpointGroup get(java.lang.String name, Output<java.lang.String> id, @Nullable EndpointGroupState state, @Nullable com.pulumi.resources.CustomResourceOptions options) {
        return new EndpointGroup(name, id, state, options);
    }
}
