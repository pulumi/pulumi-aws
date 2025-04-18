// *** WARNING: this file was generated by pulumi-java-gen. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

package com.pulumi.aws.customerprofiles;

import com.pulumi.aws.Utilities;
import com.pulumi.aws.customerprofiles.DomainArgs;
import com.pulumi.aws.customerprofiles.inputs.DomainState;
import com.pulumi.aws.customerprofiles.outputs.DomainMatching;
import com.pulumi.aws.customerprofiles.outputs.DomainRuleBasedMatching;
import com.pulumi.core.Output;
import com.pulumi.core.annotations.Export;
import com.pulumi.core.annotations.ResourceType;
import com.pulumi.core.internal.Codegen;
import java.lang.Integer;
import java.lang.String;
import java.util.Map;
import java.util.Optional;
import javax.annotation.Nullable;

/**
 * Resource for managing an Amazon Customer Profiles Domain.
 * See the [Create Domain](https://docs.aws.amazon.com/customerprofiles/latest/APIReference/API_CreateDomain.html) for more information.
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
 * import com.pulumi.aws.customerprofiles.Domain;
 * import com.pulumi.aws.customerprofiles.DomainArgs;
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
 *         var example = new Domain("example", DomainArgs.builder()
 *             .domainName("example")
 *             .build());
 * 
 *     }
 * }
 * }
 * </pre>
 * &lt;!--End PulumiCodeChooser --&gt;
 * 
 * ### With SQS DLQ and KMS set
 * 
 * &lt;!--Start PulumiCodeChooser --&gt;
 * <pre>
 * {@code
 * package generated_program;
 * 
 * import com.pulumi.Context;
 * import com.pulumi.Pulumi;
 * import com.pulumi.core.Output;
 * import com.pulumi.aws.sqs.Queue;
 * import com.pulumi.aws.sqs.QueueArgs;
 * import com.pulumi.aws.kms.Key;
 * import com.pulumi.aws.kms.KeyArgs;
 * import com.pulumi.aws.s3.BucketV2;
 * import com.pulumi.aws.s3.BucketV2Args;
 * import com.pulumi.aws.s3.BucketPolicy;
 * import com.pulumi.aws.s3.BucketPolicyArgs;
 * import com.pulumi.aws.customerprofiles.Domain;
 * import com.pulumi.aws.customerprofiles.DomainArgs;
 * import static com.pulumi.codegen.internal.Serialization.*;
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
 *         var example = new Queue("example", QueueArgs.builder()
 *             .name("example")
 *             .policy(serializeJson(
 *                 jsonObject(
 *                     jsonProperty("Version", "2012-10-17"),
 *                     jsonProperty("Statement", jsonArray(jsonObject(
 *                         jsonProperty("Sid", "Customer Profiles SQS policy"),
 *                         jsonProperty("Effect", "Allow"),
 *                         jsonProperty("Action", jsonArray("sqs:SendMessage")),
 *                         jsonProperty("Resource", "*"),
 *                         jsonProperty("Principal", jsonObject(
 *                             jsonProperty("Service", "profile.amazonaws.com")
 *                         ))
 *                     )))
 *                 )))
 *             .build());
 * 
 *         var exampleKey = new Key("exampleKey", KeyArgs.builder()
 *             .description("example")
 *             .deletionWindowInDays(10)
 *             .build());
 * 
 *         var exampleBucketV2 = new BucketV2("exampleBucketV2", BucketV2Args.builder()
 *             .bucket("example")
 *             .forceDestroy(true)
 *             .build());
 * 
 *         var exampleBucketPolicy = new BucketPolicy("exampleBucketPolicy", BucketPolicyArgs.builder()
 *             .bucket(exampleBucketV2.id())
 *             .policy(Output.tuple(exampleBucketV2.arn(), exampleBucketV2.arn()).applyValue(values -> {
 *                 var exampleBucketV2Arn = values.t1;
 *                 var exampleBucketV2Arn1 = values.t2;
 *                 return serializeJson(
 *                     jsonObject(
 *                         jsonProperty("Version", "2012-10-17"),
 *                         jsonProperty("Statement", jsonArray(jsonObject(
 *                             jsonProperty("Sid", "Customer Profiles S3 policy"),
 *                             jsonProperty("Effect", "Allow"),
 *                             jsonProperty("Action", jsonArray(
 *                                 "s3:GetObject", 
 *                                 "s3:PutObject", 
 *                                 "s3:ListBucket"
 *                             )),
 *                             jsonProperty("Resource", jsonArray(
 *                                 exampleBucketV2Arn, 
 *                                 String.format("%s/*", exampleBucketV2Arn1)
 *                             )),
 *                             jsonProperty("Principal", jsonObject(
 *                                 jsonProperty("Service", "profile.amazonaws.com")
 *                             ))
 *                         )))
 *                     ));
 *             }))
 *             .build());
 * 
 *         var test = new Domain("test", DomainArgs.builder()
 *             .domainName(example)
 *             .deadLetterQueueUrl(example.id())
 *             .defaultEncryptionKey(exampleKey.arn())
 *             .defaultExpirationDays(365)
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
 * Using `pulumi import`, import Amazon Customer Profiles Domain using the resource `id`. For example:
 * 
 * ```sh
 * $ pulumi import aws:customerprofiles/domain:Domain example e6f777be-22d0-4b40-b307-5d2720ef16b2
 * ```
 * 
 */
@ResourceType(type="aws:customerprofiles/domain:Domain")
public class Domain extends com.pulumi.resources.CustomResource {
    /**
     * The Amazon Resource Name (ARN) of the Customer Profiles Domain.
     * 
     */
    @Export(name="arn", refs={String.class}, tree="[0]")
    private Output<String> arn;

    /**
     * @return The Amazon Resource Name (ARN) of the Customer Profiles Domain.
     * 
     */
    public Output<String> arn() {
        return this.arn;
    }
    /**
     * The URL of the SQS dead letter queue, which is used for reporting errors associated with ingesting data from third party applications.
     * 
     */
    @Export(name="deadLetterQueueUrl", refs={String.class}, tree="[0]")
    private Output</* @Nullable */ String> deadLetterQueueUrl;

    /**
     * @return The URL of the SQS dead letter queue, which is used for reporting errors associated with ingesting data from third party applications.
     * 
     */
    public Output<Optional<String>> deadLetterQueueUrl() {
        return Codegen.optional(this.deadLetterQueueUrl);
    }
    /**
     * The default encryption key, which is an AWS managed key, is used when no specific type of encryption key is specified. It is used to encrypt all data before it is placed in permanent or semi-permanent storage.
     * 
     */
    @Export(name="defaultEncryptionKey", refs={String.class}, tree="[0]")
    private Output</* @Nullable */ String> defaultEncryptionKey;

    /**
     * @return The default encryption key, which is an AWS managed key, is used when no specific type of encryption key is specified. It is used to encrypt all data before it is placed in permanent or semi-permanent storage.
     * 
     */
    public Output<Optional<String>> defaultEncryptionKey() {
        return Codegen.optional(this.defaultEncryptionKey);
    }
    /**
     * The default number of days until the data within the domain expires.
     * 
     * The following arguments are optional:
     * 
     */
    @Export(name="defaultExpirationDays", refs={Integer.class}, tree="[0]")
    private Output<Integer> defaultExpirationDays;

    /**
     * @return The default number of days until the data within the domain expires.
     * 
     * The following arguments are optional:
     * 
     */
    public Output<Integer> defaultExpirationDays() {
        return this.defaultExpirationDays;
    }
    /**
     * The name for your Customer Profile domain. It must be unique for your AWS account.
     * 
     */
    @Export(name="domainName", refs={String.class}, tree="[0]")
    private Output<String> domainName;

    /**
     * @return The name for your Customer Profile domain. It must be unique for your AWS account.
     * 
     */
    public Output<String> domainName() {
        return this.domainName;
    }
    /**
     * A block that specifies the process of matching duplicate profiles. Documented below.
     * 
     */
    @Export(name="matching", refs={DomainMatching.class}, tree="[0]")
    private Output</* @Nullable */ DomainMatching> matching;

    /**
     * @return A block that specifies the process of matching duplicate profiles. Documented below.
     * 
     */
    public Output<Optional<DomainMatching>> matching() {
        return Codegen.optional(this.matching);
    }
    /**
     * A block that specifies the process of matching duplicate profiles using the Rule-Based matching. Documented below.
     * 
     */
    @Export(name="ruleBasedMatching", refs={DomainRuleBasedMatching.class}, tree="[0]")
    private Output</* @Nullable */ DomainRuleBasedMatching> ruleBasedMatching;

    /**
     * @return A block that specifies the process of matching duplicate profiles using the Rule-Based matching. Documented below.
     * 
     */
    public Output<Optional<DomainRuleBasedMatching>> ruleBasedMatching() {
        return Codegen.optional(this.ruleBasedMatching);
    }
    /**
     * Tags to apply to the domain. If configured with a provider `default_tags` configuration block present, tags with matching keys will overwrite those defined at the provider-level.
     * 
     */
    @Export(name="tags", refs={Map.class,String.class}, tree="[0,1,1]")
    private Output</* @Nullable */ Map<String,String>> tags;

    /**
     * @return Tags to apply to the domain. If configured with a provider `default_tags` configuration block present, tags with matching keys will overwrite those defined at the provider-level.
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
    public Domain(java.lang.String name) {
        this(name, DomainArgs.Empty);
    }
    /**
     *
     * @param name The _unique_ name of the resulting resource.
     * @param args The arguments to use to populate this resource's properties.
     */
    public Domain(java.lang.String name, DomainArgs args) {
        this(name, args, null);
    }
    /**
     *
     * @param name The _unique_ name of the resulting resource.
     * @param args The arguments to use to populate this resource's properties.
     * @param options A bag of options that control this resource's behavior.
     */
    public Domain(java.lang.String name, DomainArgs args, @Nullable com.pulumi.resources.CustomResourceOptions options) {
        super("aws:customerprofiles/domain:Domain", name, makeArgs(args, options), makeResourceOptions(options, Codegen.empty()), false);
    }

    private Domain(java.lang.String name, Output<java.lang.String> id, @Nullable DomainState state, @Nullable com.pulumi.resources.CustomResourceOptions options) {
        super("aws:customerprofiles/domain:Domain", name, state, makeResourceOptions(options, id), false);
    }

    private static DomainArgs makeArgs(DomainArgs args, @Nullable com.pulumi.resources.CustomResourceOptions options) {
        if (options != null && options.getUrn().isPresent()) {
            return null;
        }
        return args == null ? DomainArgs.Empty : args;
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
    public static Domain get(java.lang.String name, Output<java.lang.String> id, @Nullable DomainState state, @Nullable com.pulumi.resources.CustomResourceOptions options) {
        return new Domain(name, id, state, options);
    }
}
