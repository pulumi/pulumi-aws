// *** WARNING: this file was generated by pulumi-java-gen. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

package com.pulumi.aws.directconnect;

import com.pulumi.aws.Utilities;
import com.pulumi.aws.directconnect.MacsecKeyAssociationArgs;
import com.pulumi.aws.directconnect.inputs.MacsecKeyAssociationState;
import com.pulumi.core.Output;
import com.pulumi.core.annotations.Export;
import com.pulumi.core.annotations.ResourceType;
import com.pulumi.core.internal.Codegen;
import java.lang.String;
import java.util.Optional;
import javax.annotation.Nullable;

/**
 * Provides a MAC Security (MACSec) secret key resource for use with Direct Connect. See [MACsec prerequisites](https://docs.aws.amazon.com/directconnect/latest/UserGuide/direct-connect-mac-sec-getting-started.html#mac-sec-prerequisites) for information about MAC Security (MACsec) prerequisites.
 * 
 * Creating this resource will also create a resource of type `aws.secretsmanager.Secret` which is managed by Direct Connect. While you can import this resource into your state, because this secret is managed by Direct Connect, you will not be able to make any modifications to it. See [How AWS Direct Connect uses AWS Secrets Manager](https://docs.aws.amazon.com/secretsmanager/latest/userguide/integrating_how-services-use-secrets_directconnect.html) for details.
 * 
 * &gt; **Note:** All arguments including `ckn` and `cak` will be stored in the raw state as plain-text.
 * **Note:** The `secret_arn` argument can only be used to reference a previously created MACSec key. You cannot associate a Secrets Manager secret created outside of the `aws.directconnect.MacsecKeyAssociation` resource.
 * 
 * ## Example Usage
 * 
 * ### Create MACSec key with CKN and CAK
 * 
 * &lt;!--Start PulumiCodeChooser --&gt;
 * <pre>
 * {@code
 * package generated_program;
 * 
 * import com.pulumi.Context;
 * import com.pulumi.Pulumi;
 * import com.pulumi.core.Output;
 * import com.pulumi.aws.directconnect.DirectconnectFunctions;
 * import com.pulumi.aws.directconnect.inputs.GetConnectionArgs;
 * import com.pulumi.aws.directconnect.MacsecKeyAssociation;
 * import com.pulumi.aws.directconnect.MacsecKeyAssociationArgs;
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
 *         final var example = DirectconnectFunctions.getConnection(GetConnectionArgs.builder()
 *             .name("tf-dx-connection")
 *             .build());
 * 
 *         var test = new MacsecKeyAssociation("test", MacsecKeyAssociationArgs.builder()
 *             .connectionId(example.id())
 *             .ckn("0123456789abcdef0123456789abcdef0123456789abcdef0123456789abcdef")
 *             .cak("abcdef0123456789abcdef0123456789abcdef0123456789abcdef0123456789")
 *             .build());
 * 
 *     }
 * }
 * }
 * </pre>
 * &lt;!--End PulumiCodeChooser --&gt;
 * 
 * ### Create MACSec key with existing Secrets Manager secret
 * 
 * &lt;!--Start PulumiCodeChooser --&gt;
 * <pre>
 * {@code
 * package generated_program;
 * 
 * import com.pulumi.Context;
 * import com.pulumi.Pulumi;
 * import com.pulumi.core.Output;
 * import com.pulumi.aws.directconnect.DirectconnectFunctions;
 * import com.pulumi.aws.directconnect.inputs.GetConnectionArgs;
 * import com.pulumi.aws.secretsmanager.SecretsmanagerFunctions;
 * import com.pulumi.aws.secretsmanager.inputs.GetSecretArgs;
 * import com.pulumi.aws.directconnect.MacsecKeyAssociation;
 * import com.pulumi.aws.directconnect.MacsecKeyAssociationArgs;
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
 *         final var example = DirectconnectFunctions.getConnection(GetConnectionArgs.builder()
 *             .name("tf-dx-connection")
 *             .build());
 * 
 *         final var exampleGetSecret = SecretsmanagerFunctions.getSecret(GetSecretArgs.builder()
 *             .name("directconnect!prod/us-east-1/directconnect/0123456789abcdef0123456789abcdef0123456789abcdef0123456789abcdef")
 *             .build());
 * 
 *         var test = new MacsecKeyAssociation("test", MacsecKeyAssociationArgs.builder()
 *             .connectionId(example.id())
 *             .secretArn(exampleGetSecret.arn())
 *             .build());
 * 
 *     }
 * }
 * }
 * </pre>
 * &lt;!--End PulumiCodeChooser --&gt;
 * 
 */
@ResourceType(type="aws:directconnect/macsecKeyAssociation:MacsecKeyAssociation")
public class MacsecKeyAssociation extends com.pulumi.resources.CustomResource {
    /**
     * The MAC Security (MACsec) CAK to associate with the dedicated connection. The valid values are 64 hexadecimal characters (0-9, A-E). Required if using `ckn`.
     * 
     */
    @Export(name="cak", refs={String.class}, tree="[0]")
    private Output</* @Nullable */ String> cak;

    /**
     * @return The MAC Security (MACsec) CAK to associate with the dedicated connection. The valid values are 64 hexadecimal characters (0-9, A-E). Required if using `ckn`.
     * 
     */
    public Output<Optional<String>> cak() {
        return Codegen.optional(this.cak);
    }
    /**
     * The MAC Security (MACsec) CKN to associate with the dedicated connection. The valid values are 64 hexadecimal characters (0-9, A-E). Required if using `cak`.
     * 
     */
    @Export(name="ckn", refs={String.class}, tree="[0]")
    private Output<String> ckn;

    /**
     * @return The MAC Security (MACsec) CKN to associate with the dedicated connection. The valid values are 64 hexadecimal characters (0-9, A-E). Required if using `cak`.
     * 
     */
    public Output<String> ckn() {
        return this.ckn;
    }
    /**
     * The ID of the dedicated Direct Connect connection. The connection must be a dedicated connection in the `AVAILABLE` state.
     * 
     */
    @Export(name="connectionId", refs={String.class}, tree="[0]")
    private Output<String> connectionId;

    /**
     * @return The ID of the dedicated Direct Connect connection. The connection must be a dedicated connection in the `AVAILABLE` state.
     * 
     */
    public Output<String> connectionId() {
        return this.connectionId;
    }
    /**
     * The Amazon Resource Name (ARN) of the MAC Security (MACsec) secret key to associate with the dedicated connection.
     * 
     * &gt; **Note:** `ckn` and `cak` are mutually exclusive with `secret_arn` - these arguments cannot be used together. If you use `ckn` and `cak`, you should not use `secret_arn`. If you use the `secret_arn` argument to reference an existing MAC Security (MACSec) secret key, you should not use `ckn` or `cak`.
     * 
     */
    @Export(name="secretArn", refs={String.class}, tree="[0]")
    private Output<String> secretArn;

    /**
     * @return The Amazon Resource Name (ARN) of the MAC Security (MACsec) secret key to associate with the dedicated connection.
     * 
     * &gt; **Note:** `ckn` and `cak` are mutually exclusive with `secret_arn` - these arguments cannot be used together. If you use `ckn` and `cak`, you should not use `secret_arn`. If you use the `secret_arn` argument to reference an existing MAC Security (MACSec) secret key, you should not use `ckn` or `cak`.
     * 
     */
    public Output<String> secretArn() {
        return this.secretArn;
    }
    /**
     * The date in UTC format that the MAC Security (MACsec) secret key takes effect.
     * 
     */
    @Export(name="startOn", refs={String.class}, tree="[0]")
    private Output<String> startOn;

    /**
     * @return The date in UTC format that the MAC Security (MACsec) secret key takes effect.
     * 
     */
    public Output<String> startOn() {
        return this.startOn;
    }
    /**
     * The state of the MAC Security (MACsec) secret key. The possible values are: associating, associated, disassociating, disassociated. See [MacSecKey](https://docs.aws.amazon.com/directconnect/latest/APIReference/API_MacSecKey.html#DX-Type-MacSecKey-state) for descriptions of each state.
     * 
     */
    @Export(name="state", refs={String.class}, tree="[0]")
    private Output<String> state;

    /**
     * @return The state of the MAC Security (MACsec) secret key. The possible values are: associating, associated, disassociating, disassociated. See [MacSecKey](https://docs.aws.amazon.com/directconnect/latest/APIReference/API_MacSecKey.html#DX-Type-MacSecKey-state) for descriptions of each state.
     * 
     */
    public Output<String> state() {
        return this.state;
    }

    /**
     *
     * @param name The _unique_ name of the resulting resource.
     */
    public MacsecKeyAssociation(java.lang.String name) {
        this(name, MacsecKeyAssociationArgs.Empty);
    }
    /**
     *
     * @param name The _unique_ name of the resulting resource.
     * @param args The arguments to use to populate this resource's properties.
     */
    public MacsecKeyAssociation(java.lang.String name, MacsecKeyAssociationArgs args) {
        this(name, args, null);
    }
    /**
     *
     * @param name The _unique_ name of the resulting resource.
     * @param args The arguments to use to populate this resource's properties.
     * @param options A bag of options that control this resource's behavior.
     */
    public MacsecKeyAssociation(java.lang.String name, MacsecKeyAssociationArgs args, @Nullable com.pulumi.resources.CustomResourceOptions options) {
        super("aws:directconnect/macsecKeyAssociation:MacsecKeyAssociation", name, makeArgs(args, options), makeResourceOptions(options, Codegen.empty()), false);
    }

    private MacsecKeyAssociation(java.lang.String name, Output<java.lang.String> id, @Nullable MacsecKeyAssociationState state, @Nullable com.pulumi.resources.CustomResourceOptions options) {
        super("aws:directconnect/macsecKeyAssociation:MacsecKeyAssociation", name, state, makeResourceOptions(options, id), false);
    }

    private static MacsecKeyAssociationArgs makeArgs(MacsecKeyAssociationArgs args, @Nullable com.pulumi.resources.CustomResourceOptions options) {
        if (options != null && options.getUrn().isPresent()) {
            return null;
        }
        return args == null ? MacsecKeyAssociationArgs.Empty : args;
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
    public static MacsecKeyAssociation get(java.lang.String name, Output<java.lang.String> id, @Nullable MacsecKeyAssociationState state, @Nullable com.pulumi.resources.CustomResourceOptions options) {
        return new MacsecKeyAssociation(name, id, state, options);
    }
}
