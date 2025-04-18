// *** WARNING: this file was generated by pulumi-java-gen. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

package com.pulumi.aws.pinpoint;

import com.pulumi.aws.Utilities;
import com.pulumi.aws.pinpoint.BaiduChannelArgs;
import com.pulumi.aws.pinpoint.inputs.BaiduChannelState;
import com.pulumi.core.Output;
import com.pulumi.core.annotations.Export;
import com.pulumi.core.annotations.ResourceType;
import com.pulumi.core.internal.Codegen;
import java.lang.Boolean;
import java.lang.String;
import java.util.List;
import java.util.Optional;
import javax.annotation.Nullable;

/**
 * Provides a Pinpoint Baidu Channel resource.
 * 
 * &gt; **Note:** All arguments including the Api Key and Secret Key will be stored in the raw state as plain-text.
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
 * import com.pulumi.aws.pinpoint.App;
 * import com.pulumi.aws.pinpoint.BaiduChannel;
 * import com.pulumi.aws.pinpoint.BaiduChannelArgs;
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
 *         var app = new App("app");
 * 
 *         var channel = new BaiduChannel("channel", BaiduChannelArgs.builder()
 *             .applicationId(app.applicationId())
 *             .apiKey("")
 *             .secretKey("")
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
 * Using `pulumi import`, import Pinpoint Baidu Channel using the `application-id`. For example:
 * 
 * ```sh
 * $ pulumi import aws:pinpoint/baiduChannel:BaiduChannel channel application-id
 * ```
 * 
 */
@ResourceType(type="aws:pinpoint/baiduChannel:BaiduChannel")
public class BaiduChannel extends com.pulumi.resources.CustomResource {
    /**
     * Platform credential API key from Baidu.
     * 
     */
    @Export(name="apiKey", refs={String.class}, tree="[0]")
    private Output<String> apiKey;

    /**
     * @return Platform credential API key from Baidu.
     * 
     */
    public Output<String> apiKey() {
        return this.apiKey;
    }
    /**
     * The application ID.
     * 
     */
    @Export(name="applicationId", refs={String.class}, tree="[0]")
    private Output<String> applicationId;

    /**
     * @return The application ID.
     * 
     */
    public Output<String> applicationId() {
        return this.applicationId;
    }
    /**
     * Specifies whether to enable the channel. Defaults to `true`.
     * 
     */
    @Export(name="enabled", refs={Boolean.class}, tree="[0]")
    private Output</* @Nullable */ Boolean> enabled;

    /**
     * @return Specifies whether to enable the channel. Defaults to `true`.
     * 
     */
    public Output<Optional<Boolean>> enabled() {
        return Codegen.optional(this.enabled);
    }
    /**
     * Platform credential Secret key from Baidu.
     * 
     */
    @Export(name="secretKey", refs={String.class}, tree="[0]")
    private Output<String> secretKey;

    /**
     * @return Platform credential Secret key from Baidu.
     * 
     */
    public Output<String> secretKey() {
        return this.secretKey;
    }

    /**
     *
     * @param name The _unique_ name of the resulting resource.
     */
    public BaiduChannel(java.lang.String name) {
        this(name, BaiduChannelArgs.Empty);
    }
    /**
     *
     * @param name The _unique_ name of the resulting resource.
     * @param args The arguments to use to populate this resource's properties.
     */
    public BaiduChannel(java.lang.String name, BaiduChannelArgs args) {
        this(name, args, null);
    }
    /**
     *
     * @param name The _unique_ name of the resulting resource.
     * @param args The arguments to use to populate this resource's properties.
     * @param options A bag of options that control this resource's behavior.
     */
    public BaiduChannel(java.lang.String name, BaiduChannelArgs args, @Nullable com.pulumi.resources.CustomResourceOptions options) {
        super("aws:pinpoint/baiduChannel:BaiduChannel", name, makeArgs(args, options), makeResourceOptions(options, Codegen.empty()), false);
    }

    private BaiduChannel(java.lang.String name, Output<java.lang.String> id, @Nullable BaiduChannelState state, @Nullable com.pulumi.resources.CustomResourceOptions options) {
        super("aws:pinpoint/baiduChannel:BaiduChannel", name, state, makeResourceOptions(options, id), false);
    }

    private static BaiduChannelArgs makeArgs(BaiduChannelArgs args, @Nullable com.pulumi.resources.CustomResourceOptions options) {
        if (options != null && options.getUrn().isPresent()) {
            return null;
        }
        return args == null ? BaiduChannelArgs.Empty : args;
    }

    private static com.pulumi.resources.CustomResourceOptions makeResourceOptions(@Nullable com.pulumi.resources.CustomResourceOptions options, @Nullable Output<java.lang.String> id) {
        var defaultOptions = com.pulumi.resources.CustomResourceOptions.builder()
            .version(Utilities.getVersion())
            .additionalSecretOutputs(List.of(
                "apiKey",
                "secretKey"
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
    public static BaiduChannel get(java.lang.String name, Output<java.lang.String> id, @Nullable BaiduChannelState state, @Nullable com.pulumi.resources.CustomResourceOptions options) {
        return new BaiduChannel(name, id, state, options);
    }
}
