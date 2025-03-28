// *** WARNING: this file was generated by pulumi-java-gen. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

package com.pulumi.aws.lex;

import com.pulumi.aws.Utilities;
import com.pulumi.aws.lex.V2modelsBotArgs;
import com.pulumi.aws.lex.inputs.V2modelsBotState;
import com.pulumi.aws.lex.outputs.V2modelsBotDataPrivacy;
import com.pulumi.aws.lex.outputs.V2modelsBotMember;
import com.pulumi.aws.lex.outputs.V2modelsBotTimeouts;
import com.pulumi.core.Output;
import com.pulumi.core.annotations.Export;
import com.pulumi.core.annotations.ResourceType;
import com.pulumi.core.internal.Codegen;
import java.lang.Integer;
import java.lang.String;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import javax.annotation.Nullable;

/**
 * Resource for managing an AWS Lex V2 Models Bot.
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
 * import com.pulumi.aws.iam.Role;
 * import com.pulumi.aws.iam.RoleArgs;
 * import com.pulumi.aws.lex.V2modelsBot;
 * import com.pulumi.aws.lex.V2modelsBotArgs;
 * import com.pulumi.aws.lex.inputs.V2modelsBotDataPrivacyArgs;
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
 *         var exampleRole = new Role("exampleRole", RoleArgs.builder()
 *             .name("example")
 *             .assumeRolePolicy(serializeJson(
 *                 jsonObject(
 *                     jsonProperty("Version", "2012-10-17"),
 *                     jsonProperty("Statement", jsonArray(jsonObject(
 *                         jsonProperty("Action", "sts:AssumeRole"),
 *                         jsonProperty("Effect", "Allow"),
 *                         jsonProperty("Sid", ""),
 *                         jsonProperty("Principal", jsonObject(
 *                             jsonProperty("Service", "lexv2.amazonaws.com")
 *                         ))
 *                     )))
 *                 )))
 *             .tags(Map.of("created_by", "aws"))
 *             .build());
 * 
 *         var example = new V2modelsBot("example", V2modelsBotArgs.builder()
 *             .name("example")
 *             .description("Example description")
 *             .dataPrivacies(V2modelsBotDataPrivacyArgs.builder()
 *                 .childDirected(false)
 *                 .build())
 *             .idleSessionTtlInSeconds(60)
 *             .roleArn(exampleRole.arn())
 *             .type("Bot")
 *             .tags(Map.of("foo", "bar"))
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
 * Using `pulumi import`, import Lex V2 Models Bot using the `id`. For example:
 * 
 * ```sh
 * $ pulumi import aws:lex/v2modelsBot:V2modelsBot example bot-id-12345678
 * ```
 * 
 */
@ResourceType(type="aws:lex/v2modelsBot:V2modelsBot")
public class V2modelsBot extends com.pulumi.resources.CustomResource {
    @Export(name="arn", refs={String.class}, tree="[0]")
    private Output<String> arn;

    public Output<String> arn() {
        return this.arn;
    }
    /**
     * Provides information on additional privacy protections Amazon Lex should use with the bot&#39;s data. See `data_privacy`
     * 
     */
    @Export(name="dataPrivacies", refs={List.class,V2modelsBotDataPrivacy.class}, tree="[0,1]")
    private Output</* @Nullable */ List<V2modelsBotDataPrivacy>> dataPrivacies;

    /**
     * @return Provides information on additional privacy protections Amazon Lex should use with the bot&#39;s data. See `data_privacy`
     * 
     */
    public Output<Optional<List<V2modelsBotDataPrivacy>>> dataPrivacies() {
        return Codegen.optional(this.dataPrivacies);
    }
    /**
     * Description of the bot. It appears in lists to help you identify a particular bot.
     * 
     */
    @Export(name="description", refs={String.class}, tree="[0]")
    private Output</* @Nullable */ String> description;

    /**
     * @return Description of the bot. It appears in lists to help you identify a particular bot.
     * 
     */
    public Output<Optional<String>> description() {
        return Codegen.optional(this.description);
    }
    /**
     * Time, in seconds, that Amazon Lex should keep information about a user&#39;s conversation with the bot. You can specify between 60 (1 minute) and 86,400 (24 hours) seconds.
     * 
     */
    @Export(name="idleSessionTtlInSeconds", refs={Integer.class}, tree="[0]")
    private Output<Integer> idleSessionTtlInSeconds;

    /**
     * @return Time, in seconds, that Amazon Lex should keep information about a user&#39;s conversation with the bot. You can specify between 60 (1 minute) and 86,400 (24 hours) seconds.
     * 
     */
    public Output<Integer> idleSessionTtlInSeconds() {
        return this.idleSessionTtlInSeconds;
    }
    /**
     * List of bot members in a network to be created. See `bot_members`.
     * 
     */
    @Export(name="members", refs={List.class,V2modelsBotMember.class}, tree="[0,1]")
    private Output</* @Nullable */ List<V2modelsBotMember>> members;

    /**
     * @return List of bot members in a network to be created. See `bot_members`.
     * 
     */
    public Output<Optional<List<V2modelsBotMember>>> members() {
        return Codegen.optional(this.members);
    }
    /**
     * Name of the bot. The bot name must be unique in the account that creates the bot. Type String. Length Constraints: Minimum length of 1. Maximum length of 100.
     * 
     */
    @Export(name="name", refs={String.class}, tree="[0]")
    private Output<String> name;

    /**
     * @return Name of the bot. The bot name must be unique in the account that creates the bot. Type String. Length Constraints: Minimum length of 1. Maximum length of 100.
     * 
     */
    public Output<String> name() {
        return this.name;
    }
    /**
     * ARN of an IAM role that has permission to access the bot.
     * 
     * The following arguments are optional:
     * 
     */
    @Export(name="roleArn", refs={String.class}, tree="[0]")
    private Output<String> roleArn;

    /**
     * @return ARN of an IAM role that has permission to access the bot.
     * 
     * The following arguments are optional:
     * 
     */
    public Output<String> roleArn() {
        return this.roleArn;
    }
    /**
     * List of tags to add to the bot. You can only add tags when you create a bot.
     * 
     */
    @Export(name="tags", refs={Map.class,String.class}, tree="[0,1,1]")
    private Output</* @Nullable */ Map<String,String>> tags;

    /**
     * @return List of tags to add to the bot. You can only add tags when you create a bot.
     * 
     */
    public Output<Optional<Map<String,String>>> tags() {
        return Codegen.optional(this.tags);
    }
    /**
     * @deprecated
     * Please use `tags` instead.
     * 
     */
    @Deprecated /* Please use `tags` instead. */
    @Export(name="tagsAll", refs={Map.class,String.class}, tree="[0,1,1]")
    private Output<Map<String,String>> tagsAll;

    public Output<Map<String,String>> tagsAll() {
        return this.tagsAll;
    }
    /**
     * List of tags to add to the test alias for a bot. You can only add tags when you create a bot.
     * 
     */
    @Export(name="testBotAliasTags", refs={Map.class,String.class}, tree="[0,1,1]")
    private Output</* @Nullable */ Map<String,String>> testBotAliasTags;

    /**
     * @return List of tags to add to the test alias for a bot. You can only add tags when you create a bot.
     * 
     */
    public Output<Optional<Map<String,String>>> testBotAliasTags() {
        return Codegen.optional(this.testBotAliasTags);
    }
    @Export(name="timeouts", refs={V2modelsBotTimeouts.class}, tree="[0]")
    private Output</* @Nullable */ V2modelsBotTimeouts> timeouts;

    public Output<Optional<V2modelsBotTimeouts>> timeouts() {
        return Codegen.optional(this.timeouts);
    }
    /**
     * Type of a bot to create. Possible values are `&#34;Bot&#34;` and `&#34;BotNetwork&#34;`.
     * 
     */
    @Export(name="type", refs={String.class}, tree="[0]")
    private Output<String> type;

    /**
     * @return Type of a bot to create. Possible values are `&#34;Bot&#34;` and `&#34;BotNetwork&#34;`.
     * 
     */
    public Output<String> type() {
        return this.type;
    }

    /**
     *
     * @param name The _unique_ name of the resulting resource.
     */
    public V2modelsBot(java.lang.String name) {
        this(name, V2modelsBotArgs.Empty);
    }
    /**
     *
     * @param name The _unique_ name of the resulting resource.
     * @param args The arguments to use to populate this resource's properties.
     */
    public V2modelsBot(java.lang.String name, V2modelsBotArgs args) {
        this(name, args, null);
    }
    /**
     *
     * @param name The _unique_ name of the resulting resource.
     * @param args The arguments to use to populate this resource's properties.
     * @param options A bag of options that control this resource's behavior.
     */
    public V2modelsBot(java.lang.String name, V2modelsBotArgs args, @Nullable com.pulumi.resources.CustomResourceOptions options) {
        super("aws:lex/v2modelsBot:V2modelsBot", name, makeArgs(args, options), makeResourceOptions(options, Codegen.empty()), false);
    }

    private V2modelsBot(java.lang.String name, Output<java.lang.String> id, @Nullable V2modelsBotState state, @Nullable com.pulumi.resources.CustomResourceOptions options) {
        super("aws:lex/v2modelsBot:V2modelsBot", name, state, makeResourceOptions(options, id), false);
    }

    private static V2modelsBotArgs makeArgs(V2modelsBotArgs args, @Nullable com.pulumi.resources.CustomResourceOptions options) {
        if (options != null && options.getUrn().isPresent()) {
            return null;
        }
        return args == null ? V2modelsBotArgs.Empty : args;
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
    public static V2modelsBot get(java.lang.String name, Output<java.lang.String> id, @Nullable V2modelsBotState state, @Nullable com.pulumi.resources.CustomResourceOptions options) {
        return new V2modelsBot(name, id, state, options);
    }
}
