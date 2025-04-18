// *** WARNING: this file was generated by pulumi-java-gen. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

package com.pulumi.aws.ses;

import com.pulumi.aws.Utilities;
import com.pulumi.aws.ses.DomainIdentityVerificationArgs;
import com.pulumi.aws.ses.inputs.DomainIdentityVerificationState;
import com.pulumi.core.Output;
import com.pulumi.core.annotations.Export;
import com.pulumi.core.annotations.ResourceType;
import com.pulumi.core.internal.Codegen;
import java.lang.String;
import javax.annotation.Nullable;

/**
 * Represents a successful verification of an SES domain identity.
 * 
 * Most commonly, this resource is used together with `aws.route53.Record` and
 * `aws.ses.DomainIdentity` to request an SES domain identity,
 * deploy the required DNS verification records, and wait for verification to complete.
 * 
 * &gt; **WARNING:** This resource implements a part of the verification workflow. It does not represent a real-world entity in AWS, therefore changing or deleting this resource on its own has no immediate effect.
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
 * import com.pulumi.aws.ses.DomainIdentity;
 * import com.pulumi.aws.ses.DomainIdentityArgs;
 * import com.pulumi.aws.route53.Record;
 * import com.pulumi.aws.route53.RecordArgs;
 * import com.pulumi.aws.ses.DomainIdentityVerification;
 * import com.pulumi.aws.ses.DomainIdentityVerificationArgs;
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
 *         var example = new DomainIdentity("example", DomainIdentityArgs.builder()
 *             .domain("example.com")
 *             .build());
 * 
 *         var exampleAmazonsesVerificationRecord = new Record("exampleAmazonsesVerificationRecord", RecordArgs.builder()
 *             .zoneId(exampleAwsRoute53Zone.zoneId())
 *             .name(example.domain().applyValue(_domain -> String.format("_amazonses.%s", _domain)))
 *             .type("TXT")
 *             .ttl(600)
 *             .records(example.verificationToken())
 *             .build());
 * 
 *         var exampleVerification = new DomainIdentityVerification("exampleVerification", DomainIdentityVerificationArgs.builder()
 *             .domain(example.domain())
 *             .build(), CustomResourceOptions.builder()
 *                 .dependsOn(exampleAmazonsesVerificationRecord)
 *                 .build());
 * 
 *     }
 * }
 * }
 * </pre>
 * &lt;!--End PulumiCodeChooser --&gt;
 * 
 */
@ResourceType(type="aws:ses/domainIdentityVerification:DomainIdentityVerification")
public class DomainIdentityVerification extends com.pulumi.resources.CustomResource {
    /**
     * The ARN of the domain identity.
     * 
     */
    @Export(name="arn", refs={String.class}, tree="[0]")
    private Output<String> arn;

    /**
     * @return The ARN of the domain identity.
     * 
     */
    public Output<String> arn() {
        return this.arn;
    }
    /**
     * The domain name of the SES domain identity to verify.
     * 
     */
    @Export(name="domain", refs={String.class}, tree="[0]")
    private Output<String> domain;

    /**
     * @return The domain name of the SES domain identity to verify.
     * 
     */
    public Output<String> domain() {
        return this.domain;
    }

    /**
     *
     * @param name The _unique_ name of the resulting resource.
     */
    public DomainIdentityVerification(java.lang.String name) {
        this(name, DomainIdentityVerificationArgs.Empty);
    }
    /**
     *
     * @param name The _unique_ name of the resulting resource.
     * @param args The arguments to use to populate this resource's properties.
     */
    public DomainIdentityVerification(java.lang.String name, DomainIdentityVerificationArgs args) {
        this(name, args, null);
    }
    /**
     *
     * @param name The _unique_ name of the resulting resource.
     * @param args The arguments to use to populate this resource's properties.
     * @param options A bag of options that control this resource's behavior.
     */
    public DomainIdentityVerification(java.lang.String name, DomainIdentityVerificationArgs args, @Nullable com.pulumi.resources.CustomResourceOptions options) {
        super("aws:ses/domainIdentityVerification:DomainIdentityVerification", name, makeArgs(args, options), makeResourceOptions(options, Codegen.empty()), false);
    }

    private DomainIdentityVerification(java.lang.String name, Output<java.lang.String> id, @Nullable DomainIdentityVerificationState state, @Nullable com.pulumi.resources.CustomResourceOptions options) {
        super("aws:ses/domainIdentityVerification:DomainIdentityVerification", name, state, makeResourceOptions(options, id), false);
    }

    private static DomainIdentityVerificationArgs makeArgs(DomainIdentityVerificationArgs args, @Nullable com.pulumi.resources.CustomResourceOptions options) {
        if (options != null && options.getUrn().isPresent()) {
            return null;
        }
        return args == null ? DomainIdentityVerificationArgs.Empty : args;
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
    public static DomainIdentityVerification get(java.lang.String name, Output<java.lang.String> id, @Nullable DomainIdentityVerificationState state, @Nullable com.pulumi.resources.CustomResourceOptions options) {
        return new DomainIdentityVerification(name, id, state, options);
    }
}
