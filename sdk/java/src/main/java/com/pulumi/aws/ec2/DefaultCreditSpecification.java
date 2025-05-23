// *** WARNING: this file was generated by pulumi-java-gen. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

package com.pulumi.aws.ec2;

import com.pulumi.aws.Utilities;
import com.pulumi.aws.ec2.DefaultCreditSpecificationArgs;
import com.pulumi.aws.ec2.inputs.DefaultCreditSpecificationState;
import com.pulumi.aws.ec2.outputs.DefaultCreditSpecificationTimeouts;
import com.pulumi.core.Output;
import com.pulumi.core.annotations.Export;
import com.pulumi.core.annotations.ResourceType;
import com.pulumi.core.internal.Codegen;
import java.lang.String;
import java.util.Optional;
import javax.annotation.Nullable;

/**
 * Resource for managing an AWS EC2 (Elastic Compute Cloud) Default Credit Specification.
 * 
 * ## Example Usage
 * 
 * ### Basic Usage
 * 
 * &lt;!--Start PulumiCodeChooser --&gt;
 * <pre>
 * {@code
 * package generated_program;
 * 
 * import com.pulumi.Context;
 * import com.pulumi.Pulumi;
 * import com.pulumi.core.Output;
 * import com.pulumi.aws.ec2.DefaultCreditSpecification;
 * import com.pulumi.aws.ec2.DefaultCreditSpecificationArgs;
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
 *         var example = new DefaultCreditSpecification("example", DefaultCreditSpecificationArgs.builder()
 *             .instanceFamily("t2")
 *             .cpuCredits("standard")
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
 * Using `pulumi import`, import EC2 (Elastic Compute Cloud) Default Credit Specification using the `instance_family`. For example:
 * 
 * console
 * 
 * % pulumi import aws_ec2_default_credit_specification.example t2
 * 
 */
@ResourceType(type="aws:ec2/defaultCreditSpecification:DefaultCreditSpecification")
public class DefaultCreditSpecification extends com.pulumi.resources.CustomResource {
    /**
     * Credit option for CPU usage of the instance family. Valid values: `standard`, `unlimited`.
     * 
     */
    @Export(name="cpuCredits", refs={String.class}, tree="[0]")
    private Output<String> cpuCredits;

    /**
     * @return Credit option for CPU usage of the instance family. Valid values: `standard`, `unlimited`.
     * 
     */
    public Output<String> cpuCredits() {
        return this.cpuCredits;
    }
    /**
     * Instance family. Valid values are `t2`, `t3`, `t3a`, `t4g`.
     * 
     */
    @Export(name="instanceFamily", refs={String.class}, tree="[0]")
    private Output<String> instanceFamily;

    /**
     * @return Instance family. Valid values are `t2`, `t3`, `t3a`, `t4g`.
     * 
     */
    public Output<String> instanceFamily() {
        return this.instanceFamily;
    }
    @Export(name="timeouts", refs={DefaultCreditSpecificationTimeouts.class}, tree="[0]")
    private Output</* @Nullable */ DefaultCreditSpecificationTimeouts> timeouts;

    public Output<Optional<DefaultCreditSpecificationTimeouts>> timeouts() {
        return Codegen.optional(this.timeouts);
    }

    /**
     *
     * @param name The _unique_ name of the resulting resource.
     */
    public DefaultCreditSpecification(java.lang.String name) {
        this(name, DefaultCreditSpecificationArgs.Empty);
    }
    /**
     *
     * @param name The _unique_ name of the resulting resource.
     * @param args The arguments to use to populate this resource's properties.
     */
    public DefaultCreditSpecification(java.lang.String name, DefaultCreditSpecificationArgs args) {
        this(name, args, null);
    }
    /**
     *
     * @param name The _unique_ name of the resulting resource.
     * @param args The arguments to use to populate this resource's properties.
     * @param options A bag of options that control this resource's behavior.
     */
    public DefaultCreditSpecification(java.lang.String name, DefaultCreditSpecificationArgs args, @Nullable com.pulumi.resources.CustomResourceOptions options) {
        super("aws:ec2/defaultCreditSpecification:DefaultCreditSpecification", name, makeArgs(args, options), makeResourceOptions(options, Codegen.empty()), false);
    }

    private DefaultCreditSpecification(java.lang.String name, Output<java.lang.String> id, @Nullable DefaultCreditSpecificationState state, @Nullable com.pulumi.resources.CustomResourceOptions options) {
        super("aws:ec2/defaultCreditSpecification:DefaultCreditSpecification", name, state, makeResourceOptions(options, id), false);
    }

    private static DefaultCreditSpecificationArgs makeArgs(DefaultCreditSpecificationArgs args, @Nullable com.pulumi.resources.CustomResourceOptions options) {
        if (options != null && options.getUrn().isPresent()) {
            return null;
        }
        return args == null ? DefaultCreditSpecificationArgs.Empty : args;
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
    public static DefaultCreditSpecification get(java.lang.String name, Output<java.lang.String> id, @Nullable DefaultCreditSpecificationState state, @Nullable com.pulumi.resources.CustomResourceOptions options) {
        return new DefaultCreditSpecification(name, id, state, options);
    }
}
