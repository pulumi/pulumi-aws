// *** WARNING: this file was generated by pulumi-java-gen. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

package com.pulumi.aws.sagemaker;

import com.pulumi.aws.Utilities;
import com.pulumi.aws.sagemaker.DeviceArgs;
import com.pulumi.aws.sagemaker.inputs.DeviceState;
import com.pulumi.aws.sagemaker.outputs.DeviceDevice;
import com.pulumi.core.Output;
import com.pulumi.core.annotations.Export;
import com.pulumi.core.annotations.ResourceType;
import com.pulumi.core.internal.Codegen;
import java.lang.String;
import javax.annotation.Nullable;

/**
 * Provides a SageMaker AI Device resource.
 * 
 * ## Example Usage
 * 
 * ### Basic usage
 * 
 * &lt;!--Start PulumiCodeChooser --&gt;
 * <pre>
 * {@code
 * package generated_program;
 * 
 * import com.pulumi.Context;
 * import com.pulumi.Pulumi;
 * import com.pulumi.core.Output;
 * import com.pulumi.aws.sagemaker.Device;
 * import com.pulumi.aws.sagemaker.DeviceArgs;
 * import com.pulumi.aws.sagemaker.inputs.DeviceDeviceArgs;
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
 *         var example = new Device("example", DeviceArgs.builder()
 *             .deviceFleetName(exampleAwsSagemakerDeviceFleet.deviceFleetName())
 *             .device(DeviceDeviceArgs.builder()
 *                 .deviceName("example")
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
 * Using `pulumi import`, import SageMaker AI Devices using the `device-fleet-name/device-name`. For example:
 * 
 * ```sh
 * $ pulumi import aws:sagemaker/device:Device example my-fleet/my-device
 * ```
 * 
 */
@ResourceType(type="aws:sagemaker/device:Device")
public class Device extends com.pulumi.resources.CustomResource {
    @Export(name="agentVersion", refs={String.class}, tree="[0]")
    private Output<String> agentVersion;

    public Output<String> agentVersion() {
        return this.agentVersion;
    }
    /**
     * The Amazon Resource Name (ARN) assigned by AWS to this Device.
     * 
     */
    @Export(name="arn", refs={String.class}, tree="[0]")
    private Output<String> arn;

    /**
     * @return The Amazon Resource Name (ARN) assigned by AWS to this Device.
     * 
     */
    public Output<String> arn() {
        return this.arn;
    }
    /**
     * The device to register with SageMaker AI Edge Manager. See Device details below.
     * 
     */
    @Export(name="device", refs={DeviceDevice.class}, tree="[0]")
    private Output<DeviceDevice> device;

    /**
     * @return The device to register with SageMaker AI Edge Manager. See Device details below.
     * 
     */
    public Output<DeviceDevice> device() {
        return this.device;
    }
    /**
     * The name of the Device Fleet.
     * 
     */
    @Export(name="deviceFleetName", refs={String.class}, tree="[0]")
    private Output<String> deviceFleetName;

    /**
     * @return The name of the Device Fleet.
     * 
     */
    public Output<String> deviceFleetName() {
        return this.deviceFleetName;
    }

    /**
     *
     * @param name The _unique_ name of the resulting resource.
     */
    public Device(java.lang.String name) {
        this(name, DeviceArgs.Empty);
    }
    /**
     *
     * @param name The _unique_ name of the resulting resource.
     * @param args The arguments to use to populate this resource's properties.
     */
    public Device(java.lang.String name, DeviceArgs args) {
        this(name, args, null);
    }
    /**
     *
     * @param name The _unique_ name of the resulting resource.
     * @param args The arguments to use to populate this resource's properties.
     * @param options A bag of options that control this resource's behavior.
     */
    public Device(java.lang.String name, DeviceArgs args, @Nullable com.pulumi.resources.CustomResourceOptions options) {
        super("aws:sagemaker/device:Device", name, makeArgs(args, options), makeResourceOptions(options, Codegen.empty()), false);
    }

    private Device(java.lang.String name, Output<java.lang.String> id, @Nullable DeviceState state, @Nullable com.pulumi.resources.CustomResourceOptions options) {
        super("aws:sagemaker/device:Device", name, state, makeResourceOptions(options, id), false);
    }

    private static DeviceArgs makeArgs(DeviceArgs args, @Nullable com.pulumi.resources.CustomResourceOptions options) {
        if (options != null && options.getUrn().isPresent()) {
            return null;
        }
        return args == null ? DeviceArgs.Empty : args;
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
    public static Device get(java.lang.String name, Output<java.lang.String> id, @Nullable DeviceState state, @Nullable com.pulumi.resources.CustomResourceOptions options) {
        return new Device(name, id, state, options);
    }
}
