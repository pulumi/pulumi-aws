// *** WARNING: this file was generated by pulumi-java-gen. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

package com.pulumi.aws.lex;

import com.pulumi.aws.Utilities;
import com.pulumi.aws.lex.IntentArgs;
import com.pulumi.aws.lex.inputs.IntentState;
import com.pulumi.aws.lex.outputs.IntentConclusionStatement;
import com.pulumi.aws.lex.outputs.IntentConfirmationPrompt;
import com.pulumi.aws.lex.outputs.IntentDialogCodeHook;
import com.pulumi.aws.lex.outputs.IntentFollowUpPrompt;
import com.pulumi.aws.lex.outputs.IntentFulfillmentActivity;
import com.pulumi.aws.lex.outputs.IntentRejectionStatement;
import com.pulumi.aws.lex.outputs.IntentSlot;
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
 * Provides an Amazon Lex Intent resource. For more information see
 * [Amazon Lex: How It Works](https://docs.aws.amazon.com/lex/latest/dg/how-it-works.html)
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
 * import com.pulumi.aws.lex.Intent;
 * import com.pulumi.aws.lex.IntentArgs;
 * import com.pulumi.aws.lex.inputs.IntentConfirmationPromptArgs;
 * import com.pulumi.aws.lex.inputs.IntentFulfillmentActivityArgs;
 * import com.pulumi.aws.lex.inputs.IntentRejectionStatementArgs;
 * import com.pulumi.aws.lex.inputs.IntentSlotArgs;
 * import com.pulumi.aws.lex.inputs.IntentSlotValueElicitationPromptArgs;
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
 *         var orderFlowersIntent = new Intent("orderFlowersIntent", IntentArgs.builder()
 *             .confirmationPrompt(IntentConfirmationPromptArgs.builder()
 *                 .maxAttempts(2)
 *                 .messages(IntentConfirmationPromptMessageArgs.builder()
 *                     .content("Okay, your {FlowerType} will be ready for pickup by {PickupTime} on {PickupDate}.  Does this sound okay?")
 *                     .contentType("PlainText")
 *                     .build())
 *                 .build())
 *             .createVersion(false)
 *             .name("OrderFlowers")
 *             .description("Intent to order a bouquet of flowers for pick up")
 *             .fulfillmentActivity(IntentFulfillmentActivityArgs.builder()
 *                 .type("ReturnIntent")
 *                 .build())
 *             .rejectionStatement(IntentRejectionStatementArgs.builder()
 *                 .messages(IntentRejectionStatementMessageArgs.builder()
 *                     .content("Okay, I will not place your order.")
 *                     .contentType("PlainText")
 *                     .build())
 *                 .build())
 *             .sampleUtterances(            
 *                 "I would like to order some flowers",
 *                 "I would like to pick up flowers")
 *             .slots(            
 *                 IntentSlotArgs.builder()
 *                     .description("The type of flowers to pick up")
 *                     .name("FlowerType")
 *                     .priority(1)
 *                     .sampleUtterances("I would like to order {FlowerType}")
 *                     .slotConstraint("Required")
 *                     .slotType("FlowerTypes")
 *                     .slotTypeVersion("$$LATEST")
 *                     .valueElicitationPrompt(IntentSlotValueElicitationPromptArgs.builder()
 *                         .maxAttempts(2)
 *                         .messages(IntentSlotValueElicitationPromptMessageArgs.builder()
 *                             .content("What type of flowers would you like to order?")
 *                             .contentType("PlainText")
 *                             .build())
 *                         .build())
 *                     .build(),
 *                 IntentSlotArgs.builder()
 *                     .description("The date to pick up the flowers")
 *                     .name("PickupDate")
 *                     .priority(2)
 *                     .sampleUtterances("I would like to order {FlowerType}")
 *                     .slotConstraint("Required")
 *                     .slotType("AMAZON.DATE")
 *                     .slotTypeVersion("$$LATEST")
 *                     .valueElicitationPrompt(IntentSlotValueElicitationPromptArgs.builder()
 *                         .maxAttempts(2)
 *                         .messages(IntentSlotValueElicitationPromptMessageArgs.builder()
 *                             .content("What day do you want the {FlowerType} to be picked up?")
 *                             .contentType("PlainText")
 *                             .build())
 *                         .build())
 *                     .build(),
 *                 IntentSlotArgs.builder()
 *                     .description("The time to pick up the flowers")
 *                     .name("PickupTime")
 *                     .priority(3)
 *                     .sampleUtterances("I would like to order {FlowerType}")
 *                     .slotConstraint("Required")
 *                     .slotType("AMAZON.TIME")
 *                     .slotTypeVersion("$$LATEST")
 *                     .valueElicitationPrompt(IntentSlotValueElicitationPromptArgs.builder()
 *                         .maxAttempts(2)
 *                         .messages(IntentSlotValueElicitationPromptMessageArgs.builder()
 *                             .content("Pick up the {FlowerType} at what time on {PickupDate}?")
 *                             .contentType("PlainText")
 *                             .build())
 *                         .build())
 *                     .build())
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
 * Using `pulumi import`, import intents using their name. For example:
 * 
 * ```sh
 * $ pulumi import aws:lex/intent:Intent order_flowers_intent OrderFlowers
 * ```
 * 
 */
@ResourceType(type="aws:lex/intent:Intent")
public class Intent extends com.pulumi.resources.CustomResource {
    /**
     * The ARN of the Lex intent.
     * 
     */
    @Export(name="arn", refs={String.class}, tree="[0]")
    private Output<String> arn;

    /**
     * @return The ARN of the Lex intent.
     * 
     */
    public Output<String> arn() {
        return this.arn;
    }
    /**
     * Checksum identifying the version of the intent that was created. The checksum is not
     * included as an argument because the resource will add it automatically when updating the intent.
     * 
     */
    @Export(name="checksum", refs={String.class}, tree="[0]")
    private Output<String> checksum;

    /**
     * @return Checksum identifying the version of the intent that was created. The checksum is not
     * included as an argument because the resource will add it automatically when updating the intent.
     * 
     */
    public Output<String> checksum() {
        return this.checksum;
    }
    /**
     * The statement that you want Amazon Lex to convey to the user
     * after the intent is successfully fulfilled by the Lambda function. This element is relevant only if
     * you provide a Lambda function in the `fulfillment_activity`. If you return the intent to the client
     * application, you can&#39;t specify this element. The `follow_up_prompt` and `conclusion_statement` are
     * mutually exclusive. You can specify only one. Attributes are documented under statement.
     * 
     */
    @Export(name="conclusionStatement", refs={IntentConclusionStatement.class}, tree="[0]")
    private Output</* @Nullable */ IntentConclusionStatement> conclusionStatement;

    /**
     * @return The statement that you want Amazon Lex to convey to the user
     * after the intent is successfully fulfilled by the Lambda function. This element is relevant only if
     * you provide a Lambda function in the `fulfillment_activity`. If you return the intent to the client
     * application, you can&#39;t specify this element. The `follow_up_prompt` and `conclusion_statement` are
     * mutually exclusive. You can specify only one. Attributes are documented under statement.
     * 
     */
    public Output<Optional<IntentConclusionStatement>> conclusionStatement() {
        return Codegen.optional(this.conclusionStatement);
    }
    /**
     * Prompts the user to confirm the intent. This question should
     * have a yes or no answer. You you must provide both the `rejection_statement` and `confirmation_prompt`,
     * or neither. Attributes are documented under prompt.
     * 
     */
    @Export(name="confirmationPrompt", refs={IntentConfirmationPrompt.class}, tree="[0]")
    private Output</* @Nullable */ IntentConfirmationPrompt> confirmationPrompt;

    /**
     * @return Prompts the user to confirm the intent. This question should
     * have a yes or no answer. You you must provide both the `rejection_statement` and `confirmation_prompt`,
     * or neither. Attributes are documented under prompt.
     * 
     */
    public Output<Optional<IntentConfirmationPrompt>> confirmationPrompt() {
        return Codegen.optional(this.confirmationPrompt);
    }
    /**
     * Determines if a new slot type version is created when the initial
     * resource is created and on each update. Defaults to `false`.
     * 
     */
    @Export(name="createVersion", refs={Boolean.class}, tree="[0]")
    private Output</* @Nullable */ Boolean> createVersion;

    /**
     * @return Determines if a new slot type version is created when the initial
     * resource is created and on each update. Defaults to `false`.
     * 
     */
    public Output<Optional<Boolean>> createVersion() {
        return Codegen.optional(this.createVersion);
    }
    /**
     * The date when the intent version was created.
     * 
     */
    @Export(name="createdDate", refs={String.class}, tree="[0]")
    private Output<String> createdDate;

    /**
     * @return The date when the intent version was created.
     * 
     */
    public Output<String> createdDate() {
        return this.createdDate;
    }
    /**
     * A description of the intent. Must be less than or equal to 200 characters in length.
     * 
     */
    @Export(name="description", refs={String.class}, tree="[0]")
    private Output</* @Nullable */ String> description;

    /**
     * @return A description of the intent. Must be less than or equal to 200 characters in length.
     * 
     */
    public Output<Optional<String>> description() {
        return Codegen.optional(this.description);
    }
    /**
     * Specifies a Lambda function to invoke for each user input. You can
     * invoke this Lambda function to personalize user interaction. Attributes are documented under code_hook.
     * 
     */
    @Export(name="dialogCodeHook", refs={IntentDialogCodeHook.class}, tree="[0]")
    private Output</* @Nullable */ IntentDialogCodeHook> dialogCodeHook;

    /**
     * @return Specifies a Lambda function to invoke for each user input. You can
     * invoke this Lambda function to personalize user interaction. Attributes are documented under code_hook.
     * 
     */
    public Output<Optional<IntentDialogCodeHook>> dialogCodeHook() {
        return Codegen.optional(this.dialogCodeHook);
    }
    /**
     * Amazon Lex uses this prompt to solicit additional activity after
     * fulfilling an intent. For example, after the OrderPizza intent is fulfilled, you might prompt the
     * user to order a drink. The `follow_up_prompt` field and the `conclusion_statement` field are mutually
     * exclusive. You can specify only one. Attributes are documented under follow_up_prompt.
     * 
     */
    @Export(name="followUpPrompt", refs={IntentFollowUpPrompt.class}, tree="[0]")
    private Output</* @Nullable */ IntentFollowUpPrompt> followUpPrompt;

    /**
     * @return Amazon Lex uses this prompt to solicit additional activity after
     * fulfilling an intent. For example, after the OrderPizza intent is fulfilled, you might prompt the
     * user to order a drink. The `follow_up_prompt` field and the `conclusion_statement` field are mutually
     * exclusive. You can specify only one. Attributes are documented under follow_up_prompt.
     * 
     */
    public Output<Optional<IntentFollowUpPrompt>> followUpPrompt() {
        return Codegen.optional(this.followUpPrompt);
    }
    /**
     * Describes how the intent is fulfilled. For example, after a
     * user provides all of the information for a pizza order, `fulfillment_activity` defines how the bot
     * places an order with a local pizza store. Attributes are documented under fulfillment_activity.
     * 
     */
    @Export(name="fulfillmentActivity", refs={IntentFulfillmentActivity.class}, tree="[0]")
    private Output<IntentFulfillmentActivity> fulfillmentActivity;

    /**
     * @return Describes how the intent is fulfilled. For example, after a
     * user provides all of the information for a pizza order, `fulfillment_activity` defines how the bot
     * places an order with a local pizza store. Attributes are documented under fulfillment_activity.
     * 
     */
    public Output<IntentFulfillmentActivity> fulfillmentActivity() {
        return this.fulfillmentActivity;
    }
    /**
     * The date when the $LATEST version of this intent was updated.
     * 
     */
    @Export(name="lastUpdatedDate", refs={String.class}, tree="[0]")
    private Output<String> lastUpdatedDate;

    /**
     * @return The date when the $LATEST version of this intent was updated.
     * 
     */
    public Output<String> lastUpdatedDate() {
        return this.lastUpdatedDate;
    }
    /**
     * The name of the intent, not case sensitive. Must be less than or equal to 100 characters in length.
     * 
     */
    @Export(name="name", refs={String.class}, tree="[0]")
    private Output<String> name;

    /**
     * @return The name of the intent, not case sensitive. Must be less than or equal to 100 characters in length.
     * 
     */
    public Output<String> name() {
        return this.name;
    }
    /**
     * A unique identifier for the built-in intent to base this
     * intent on. To find the signature for an intent, see
     * [Standard Built-in Intents](https://developer.amazon.com/public/solutions/alexa/alexa-skills-kit/docs/built-in-intent-ref/standard-intents)
     * in the Alexa Skills Kit.
     * 
     */
    @Export(name="parentIntentSignature", refs={String.class}, tree="[0]")
    private Output</* @Nullable */ String> parentIntentSignature;

    /**
     * @return A unique identifier for the built-in intent to base this
     * intent on. To find the signature for an intent, see
     * [Standard Built-in Intents](https://developer.amazon.com/public/solutions/alexa/alexa-skills-kit/docs/built-in-intent-ref/standard-intents)
     * in the Alexa Skills Kit.
     * 
     */
    public Output<Optional<String>> parentIntentSignature() {
        return Codegen.optional(this.parentIntentSignature);
    }
    /**
     * When the user answers &#34;no&#34; to the question defined in
     * `confirmation_prompt`, Amazon Lex responds with this statement to acknowledge that the intent was
     * canceled. You must provide both the `rejection_statement` and the `confirmation_prompt`, or neither.
     * Attributes are documented under statement.
     * 
     */
    @Export(name="rejectionStatement", refs={IntentRejectionStatement.class}, tree="[0]")
    private Output</* @Nullable */ IntentRejectionStatement> rejectionStatement;

    /**
     * @return When the user answers &#34;no&#34; to the question defined in
     * `confirmation_prompt`, Amazon Lex responds with this statement to acknowledge that the intent was
     * canceled. You must provide both the `rejection_statement` and the `confirmation_prompt`, or neither.
     * Attributes are documented under statement.
     * 
     */
    public Output<Optional<IntentRejectionStatement>> rejectionStatement() {
        return Codegen.optional(this.rejectionStatement);
    }
    /**
     * An array of utterances (strings) that a user might say to signal
     * the intent. For example, &#34;I want {PizzaSize} pizza&#34;, &#34;Order {Quantity} {PizzaSize} pizzas&#34;.
     * In each utterance, a slot name is enclosed in curly braces. Must have between 1 and 10 items in the list, and each item must be less than or equal to 200 characters in length.
     * 
     */
    @Export(name="sampleUtterances", refs={List.class,String.class}, tree="[0,1]")
    private Output</* @Nullable */ List<String>> sampleUtterances;

    /**
     * @return An array of utterances (strings) that a user might say to signal
     * the intent. For example, &#34;I want {PizzaSize} pizza&#34;, &#34;Order {Quantity} {PizzaSize} pizzas&#34;.
     * In each utterance, a slot name is enclosed in curly braces. Must have between 1 and 10 items in the list, and each item must be less than or equal to 200 characters in length.
     * 
     */
    public Output<Optional<List<String>>> sampleUtterances() {
        return Codegen.optional(this.sampleUtterances);
    }
    /**
     * An list of intent slots. At runtime, Amazon Lex elicits required slot values
     * from the user using prompts defined in the slots. Attributes are documented under slot.
     * 
     */
    @Export(name="slots", refs={List.class,IntentSlot.class}, tree="[0,1]")
    private Output</* @Nullable */ List<IntentSlot>> slots;

    /**
     * @return An list of intent slots. At runtime, Amazon Lex elicits required slot values
     * from the user using prompts defined in the slots. Attributes are documented under slot.
     * 
     */
    public Output<Optional<List<IntentSlot>>> slots() {
        return Codegen.optional(this.slots);
    }
    /**
     * The version of the bot.
     * 
     */
    @Export(name="version", refs={String.class}, tree="[0]")
    private Output<String> version;

    /**
     * @return The version of the bot.
     * 
     */
    public Output<String> version() {
        return this.version;
    }

    /**
     *
     * @param name The _unique_ name of the resulting resource.
     */
    public Intent(java.lang.String name) {
        this(name, IntentArgs.Empty);
    }
    /**
     *
     * @param name The _unique_ name of the resulting resource.
     * @param args The arguments to use to populate this resource's properties.
     */
    public Intent(java.lang.String name, IntentArgs args) {
        this(name, args, null);
    }
    /**
     *
     * @param name The _unique_ name of the resulting resource.
     * @param args The arguments to use to populate this resource's properties.
     * @param options A bag of options that control this resource's behavior.
     */
    public Intent(java.lang.String name, IntentArgs args, @Nullable com.pulumi.resources.CustomResourceOptions options) {
        super("aws:lex/intent:Intent", name, makeArgs(args, options), makeResourceOptions(options, Codegen.empty()), false);
    }

    private Intent(java.lang.String name, Output<java.lang.String> id, @Nullable IntentState state, @Nullable com.pulumi.resources.CustomResourceOptions options) {
        super("aws:lex/intent:Intent", name, state, makeResourceOptions(options, id), false);
    }

    private static IntentArgs makeArgs(IntentArgs args, @Nullable com.pulumi.resources.CustomResourceOptions options) {
        if (options != null && options.getUrn().isPresent()) {
            return null;
        }
        return args == null ? IntentArgs.Empty : args;
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
    public static Intent get(java.lang.String name, Output<java.lang.String> id, @Nullable IntentState state, @Nullable com.pulumi.resources.CustomResourceOptions options) {
        return new Intent(name, id, state, options);
    }
}
