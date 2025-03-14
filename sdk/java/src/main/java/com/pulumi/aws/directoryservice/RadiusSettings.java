// *** WARNING: this file was generated by pulumi-java-gen. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

package com.pulumi.aws.directoryservice;

import com.pulumi.aws.Utilities;
import com.pulumi.aws.directoryservice.RadiusSettingsArgs;
import com.pulumi.aws.directoryservice.inputs.RadiusSettingsState;
import com.pulumi.core.Output;
import com.pulumi.core.annotations.Export;
import com.pulumi.core.annotations.ResourceType;
import com.pulumi.core.internal.Codegen;
import java.lang.Boolean;
import java.lang.Integer;
import java.lang.String;
import java.util.List;
import java.util.Optional;
import javax.annotation.Nullable;

/**
 * Manages a directory&#39;s multi-factor authentication (MFA) using a Remote Authentication Dial In User Service (RADIUS) server.
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
 * import com.pulumi.aws.directoryservice.RadiusSettings;
 * import com.pulumi.aws.directoryservice.RadiusSettingsArgs;
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
 *         var example = new RadiusSettings("example", RadiusSettingsArgs.builder()
 *             .directoryId(exampleAwsDirectoryServiceDirectory.id())
 *             .authenticationProtocol("PAP")
 *             .displayLabel("example")
 *             .radiusPort(1812)
 *             .radiusRetries(4)
 *             .radiusServers("10.0.1.5")
 *             .radiusTimeout(1)
 *             .sharedSecret("12345678")
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
 * Using `pulumi import`, import RADIUS settings using the directory ID. For example:
 * 
 * ```sh
 * $ pulumi import aws:directoryservice/radiusSettings:RadiusSettings example d-926724cf57
 * ```
 * 
 */
@ResourceType(type="aws:directoryservice/radiusSettings:RadiusSettings")
public class RadiusSettings extends com.pulumi.resources.CustomResource {
    /**
     * The protocol specified for your RADIUS endpoints. Valid values: `PAP`, `CHAP`, `MS-CHAPv1`, `MS-CHAPv2`.
     * 
     */
    @Export(name="authenticationProtocol", refs={String.class}, tree="[0]")
    private Output<String> authenticationProtocol;

    /**
     * @return The protocol specified for your RADIUS endpoints. Valid values: `PAP`, `CHAP`, `MS-CHAPv1`, `MS-CHAPv2`.
     * 
     */
    public Output<String> authenticationProtocol() {
        return this.authenticationProtocol;
    }
    /**
     * The identifier of the directory for which you want to manager RADIUS settings.
     * 
     */
    @Export(name="directoryId", refs={String.class}, tree="[0]")
    private Output<String> directoryId;

    /**
     * @return The identifier of the directory for which you want to manager RADIUS settings.
     * 
     */
    public Output<String> directoryId() {
        return this.directoryId;
    }
    /**
     * Display label.
     * 
     */
    @Export(name="displayLabel", refs={String.class}, tree="[0]")
    private Output<String> displayLabel;

    /**
     * @return Display label.
     * 
     */
    public Output<String> displayLabel() {
        return this.displayLabel;
    }
    /**
     * The port that your RADIUS server is using for communications. Your self-managed network must allow inbound traffic over this port from the AWS Directory Service servers.
     * 
     */
    @Export(name="radiusPort", refs={Integer.class}, tree="[0]")
    private Output<Integer> radiusPort;

    /**
     * @return The port that your RADIUS server is using for communications. Your self-managed network must allow inbound traffic over this port from the AWS Directory Service servers.
     * 
     */
    public Output<Integer> radiusPort() {
        return this.radiusPort;
    }
    /**
     * The maximum number of times that communication with the RADIUS server is attempted. Minimum value of `0`. Maximum value of `10`.
     * 
     */
    @Export(name="radiusRetries", refs={Integer.class}, tree="[0]")
    private Output<Integer> radiusRetries;

    /**
     * @return The maximum number of times that communication with the RADIUS server is attempted. Minimum value of `0`. Maximum value of `10`.
     * 
     */
    public Output<Integer> radiusRetries() {
        return this.radiusRetries;
    }
    /**
     * An array of strings that contains the fully qualified domain name (FQDN) or IP addresses of the RADIUS server endpoints, or the FQDN or IP addresses of your RADIUS server load balancer.
     * 
     */
    @Export(name="radiusServers", refs={List.class,String.class}, tree="[0,1]")
    private Output<List<String>> radiusServers;

    /**
     * @return An array of strings that contains the fully qualified domain name (FQDN) or IP addresses of the RADIUS server endpoints, or the FQDN or IP addresses of your RADIUS server load balancer.
     * 
     */
    public Output<List<String>> radiusServers() {
        return this.radiusServers;
    }
    /**
     * The amount of time, in seconds, to wait for the RADIUS server to respond. Minimum value of `1`. Maximum value of `50`.
     * 
     */
    @Export(name="radiusTimeout", refs={Integer.class}, tree="[0]")
    private Output<Integer> radiusTimeout;

    /**
     * @return The amount of time, in seconds, to wait for the RADIUS server to respond. Minimum value of `1`. Maximum value of `50`.
     * 
     */
    public Output<Integer> radiusTimeout() {
        return this.radiusTimeout;
    }
    /**
     * Required for enabling RADIUS on the directory.
     * 
     */
    @Export(name="sharedSecret", refs={String.class}, tree="[0]")
    private Output<String> sharedSecret;

    /**
     * @return Required for enabling RADIUS on the directory.
     * 
     */
    public Output<String> sharedSecret() {
        return this.sharedSecret;
    }
    /**
     * Not currently used.
     * 
     */
    @Export(name="useSameUsername", refs={Boolean.class}, tree="[0]")
    private Output</* @Nullable */ Boolean> useSameUsername;

    /**
     * @return Not currently used.
     * 
     */
    public Output<Optional<Boolean>> useSameUsername() {
        return Codegen.optional(this.useSameUsername);
    }

    /**
     *
     * @param name The _unique_ name of the resulting resource.
     */
    public RadiusSettings(java.lang.String name) {
        this(name, RadiusSettingsArgs.Empty);
    }
    /**
     *
     * @param name The _unique_ name of the resulting resource.
     * @param args The arguments to use to populate this resource's properties.
     */
    public RadiusSettings(java.lang.String name, RadiusSettingsArgs args) {
        this(name, args, null);
    }
    /**
     *
     * @param name The _unique_ name of the resulting resource.
     * @param args The arguments to use to populate this resource's properties.
     * @param options A bag of options that control this resource's behavior.
     */
    public RadiusSettings(java.lang.String name, RadiusSettingsArgs args, @Nullable com.pulumi.resources.CustomResourceOptions options) {
        super("aws:directoryservice/radiusSettings:RadiusSettings", name, makeArgs(args, options), makeResourceOptions(options, Codegen.empty()), false);
    }

    private RadiusSettings(java.lang.String name, Output<java.lang.String> id, @Nullable RadiusSettingsState state, @Nullable com.pulumi.resources.CustomResourceOptions options) {
        super("aws:directoryservice/radiusSettings:RadiusSettings", name, state, makeResourceOptions(options, id), false);
    }

    private static RadiusSettingsArgs makeArgs(RadiusSettingsArgs args, @Nullable com.pulumi.resources.CustomResourceOptions options) {
        if (options != null && options.getUrn().isPresent()) {
            return null;
        }
        return args == null ? RadiusSettingsArgs.Empty : args;
    }

    private static com.pulumi.resources.CustomResourceOptions makeResourceOptions(@Nullable com.pulumi.resources.CustomResourceOptions options, @Nullable Output<java.lang.String> id) {
        var defaultOptions = com.pulumi.resources.CustomResourceOptions.builder()
            .version(Utilities.getVersion())
            .additionalSecretOutputs(List.of(
                "sharedSecret"
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
    public static RadiusSettings get(java.lang.String name, Output<java.lang.String> id, @Nullable RadiusSettingsState state, @Nullable com.pulumi.resources.CustomResourceOptions options) {
        return new RadiusSettings(name, id, state, options);
    }
}
