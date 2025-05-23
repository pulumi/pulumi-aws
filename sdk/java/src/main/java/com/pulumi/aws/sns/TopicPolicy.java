// *** WARNING: this file was generated by pulumi-java-gen. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

package com.pulumi.aws.sns;

import com.pulumi.aws.Utilities;
import com.pulumi.aws.sns.TopicPolicyArgs;
import com.pulumi.aws.sns.inputs.TopicPolicyState;
import com.pulumi.core.Output;
import com.pulumi.core.annotations.Export;
import com.pulumi.core.annotations.ResourceType;
import com.pulumi.core.internal.Codegen;
import java.lang.String;
import javax.annotation.Nullable;

/**
 * Provides an SNS topic policy resource
 * 
 * &gt; **NOTE:** If a Principal is specified as just an AWS account ID rather than an ARN, AWS silently converts it to the ARN for the root user, causing future deployments to differ. To avoid this problem, just specify the full ARN, e.g. `arn:aws:iam::123456789012:root`
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
 * import com.pulumi.aws.sns.Topic;
 * import com.pulumi.aws.sns.TopicArgs;
 * import com.pulumi.aws.iam.IamFunctions;
 * import com.pulumi.aws.iam.inputs.GetPolicyDocumentArgs;
 * import com.pulumi.aws.sns.TopicPolicy;
 * import com.pulumi.aws.sns.TopicPolicyArgs;
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
 *         var test = new Topic("test", TopicArgs.builder()
 *             .name("my-topic-with-policy")
 *             .build());
 * 
 *         final var snsTopicPolicy = test.arn().applyValue(_arn -> IamFunctions.getPolicyDocument(GetPolicyDocumentArgs.builder()
 *             .policyId("__default_policy_ID")
 *             .statements(GetPolicyDocumentStatementArgs.builder()
 *                 .actions(                
 *                     "SNS:Subscribe",
 *                     "SNS:SetTopicAttributes",
 *                     "SNS:RemovePermission",
 *                     "SNS:Receive",
 *                     "SNS:Publish",
 *                     "SNS:ListSubscriptionsByTopic",
 *                     "SNS:GetTopicAttributes",
 *                     "SNS:DeleteTopic",
 *                     "SNS:AddPermission")
 *                 .conditions(GetPolicyDocumentStatementConditionArgs.builder()
 *                     .test("StringEquals")
 *                     .variable("AWS:SourceOwner")
 *                     .values(account_id)
 *                     .build())
 *                 .effect("Allow")
 *                 .principals(GetPolicyDocumentStatementPrincipalArgs.builder()
 *                     .type("AWS")
 *                     .identifiers("*")
 *                     .build())
 *                 .resources(_arn)
 *                 .sid("__default_statement_ID")
 *                 .build())
 *             .build()));
 * 
 *         var default_ = new TopicPolicy("default", TopicPolicyArgs.builder()
 *             .arn(test.arn())
 *             .policy(snsTopicPolicy.applyValue(_snsTopicPolicy -> _snsTopicPolicy.json()))
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
 * Using `pulumi import`, import SNS Topic Policy using the topic ARN. For example:
 * 
 * ```sh
 * $ pulumi import aws:sns/topicPolicy:TopicPolicy user_updates arn:aws:sns:us-west-2:123456789012:my-topic
 * ```
 * 
 */
@ResourceType(type="aws:sns/topicPolicy:TopicPolicy")
public class TopicPolicy extends com.pulumi.resources.CustomResource {
    /**
     * The ARN of the SNS topic
     * 
     */
    @Export(name="arn", refs={String.class}, tree="[0]")
    private Output<String> arn;

    /**
     * @return The ARN of the SNS topic
     * 
     */
    public Output<String> arn() {
        return this.arn;
    }
    /**
     * The AWS Account ID of the SNS topic owner
     * 
     */
    @Export(name="owner", refs={String.class}, tree="[0]")
    private Output<String> owner;

    /**
     * @return The AWS Account ID of the SNS topic owner
     * 
     */
    public Output<String> owner() {
        return this.owner;
    }
    /**
     * The fully-formed AWS policy as JSON.
     * 
     */
    @Export(name="policy", refs={String.class}, tree="[0]")
    private Output<String> policy;

    /**
     * @return The fully-formed AWS policy as JSON.
     * 
     */
    public Output<String> policy() {
        return this.policy;
    }

    /**
     *
     * @param name The _unique_ name of the resulting resource.
     */
    public TopicPolicy(java.lang.String name) {
        this(name, TopicPolicyArgs.Empty);
    }
    /**
     *
     * @param name The _unique_ name of the resulting resource.
     * @param args The arguments to use to populate this resource's properties.
     */
    public TopicPolicy(java.lang.String name, TopicPolicyArgs args) {
        this(name, args, null);
    }
    /**
     *
     * @param name The _unique_ name of the resulting resource.
     * @param args The arguments to use to populate this resource's properties.
     * @param options A bag of options that control this resource's behavior.
     */
    public TopicPolicy(java.lang.String name, TopicPolicyArgs args, @Nullable com.pulumi.resources.CustomResourceOptions options) {
        super("aws:sns/topicPolicy:TopicPolicy", name, makeArgs(args, options), makeResourceOptions(options, Codegen.empty()), false);
    }

    private TopicPolicy(java.lang.String name, Output<java.lang.String> id, @Nullable TopicPolicyState state, @Nullable com.pulumi.resources.CustomResourceOptions options) {
        super("aws:sns/topicPolicy:TopicPolicy", name, state, makeResourceOptions(options, id), false);
    }

    private static TopicPolicyArgs makeArgs(TopicPolicyArgs args, @Nullable com.pulumi.resources.CustomResourceOptions options) {
        if (options != null && options.getUrn().isPresent()) {
            return null;
        }
        return args == null ? TopicPolicyArgs.Empty : args;
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
    public static TopicPolicy get(java.lang.String name, Output<java.lang.String> id, @Nullable TopicPolicyState state, @Nullable com.pulumi.resources.CustomResourceOptions options) {
        return new TopicPolicy(name, id, state, options);
    }
}
