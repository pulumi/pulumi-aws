// *** WARNING: this file was generated by pulumi-java-gen. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

package com.pulumi.aws.lex;

import com.pulumi.aws.Utilities;
import com.pulumi.aws.lex.V2modelsIntentArgs;
import com.pulumi.aws.lex.inputs.V2modelsIntentState;
import com.pulumi.aws.lex.outputs.V2modelsIntentClosingSetting;
import com.pulumi.aws.lex.outputs.V2modelsIntentConfirmationSetting;
import com.pulumi.aws.lex.outputs.V2modelsIntentDialogCodeHook;
import com.pulumi.aws.lex.outputs.V2modelsIntentFulfillmentCodeHook;
import com.pulumi.aws.lex.outputs.V2modelsIntentInitialResponseSetting;
import com.pulumi.aws.lex.outputs.V2modelsIntentInputContext;
import com.pulumi.aws.lex.outputs.V2modelsIntentKendraConfiguration;
import com.pulumi.aws.lex.outputs.V2modelsIntentOutputContext;
import com.pulumi.aws.lex.outputs.V2modelsIntentSampleUtterance;
import com.pulumi.aws.lex.outputs.V2modelsIntentSlotPriority;
import com.pulumi.aws.lex.outputs.V2modelsIntentTimeouts;
import com.pulumi.core.Output;
import com.pulumi.core.annotations.Export;
import com.pulumi.core.annotations.ResourceType;
import com.pulumi.core.internal.Codegen;
import java.lang.String;
import java.util.List;
import java.util.Optional;
import javax.annotation.Nullable;

/**
 * ## Import
 * 
 * Using `pulumi import`, import Lex V2 Models Intent using the `intent_id:bot_id:bot_version:locale_id`. For example:
 * 
 * ```sh
 * $ pulumi import aws:lex/v2modelsIntent:V2modelsIntent example intent-42874:bot-11376:DRAFT:en_US
 * ```
 * 
 */
@ResourceType(type="aws:lex/v2modelsIntent:V2modelsIntent")
public class V2modelsIntent extends com.pulumi.resources.CustomResource {
    /**
     * Identifier of the bot associated with this intent.
     * 
     */
    @Export(name="botId", refs={String.class}, tree="[0]")
    private Output<String> botId;

    /**
     * @return Identifier of the bot associated with this intent.
     * 
     */
    public Output<String> botId() {
        return this.botId;
    }
    /**
     * Version of the bot associated with this intent.
     * 
     */
    @Export(name="botVersion", refs={String.class}, tree="[0]")
    private Output<String> botVersion;

    /**
     * @return Version of the bot associated with this intent.
     * 
     */
    public Output<String> botVersion() {
        return this.botVersion;
    }
    /**
     * Configuration block for the response that Amazon Lex sends to the user when the intent is closed. See `closing_setting`.
     * 
     */
    @Export(name="closingSetting", refs={V2modelsIntentClosingSetting.class}, tree="[0]")
    private Output</* @Nullable */ V2modelsIntentClosingSetting> closingSetting;

    /**
     * @return Configuration block for the response that Amazon Lex sends to the user when the intent is closed. See `closing_setting`.
     * 
     */
    public Output<Optional<V2modelsIntentClosingSetting>> closingSetting() {
        return Codegen.optional(this.closingSetting);
    }
    @Export(name="confirmationSetting", refs={V2modelsIntentConfirmationSetting.class}, tree="[0]")
    private Output</* @Nullable */ V2modelsIntentConfirmationSetting> confirmationSetting;

    public Output<Optional<V2modelsIntentConfirmationSetting>> confirmationSetting() {
        return Codegen.optional(this.confirmationSetting);
    }
    /**
     * Timestamp of the date and time that the intent was created.
     * 
     */
    @Export(name="creationDateTime", refs={String.class}, tree="[0]")
    private Output<String> creationDateTime;

    /**
     * @return Timestamp of the date and time that the intent was created.
     * 
     */
    public Output<String> creationDateTime() {
        return this.creationDateTime;
    }
    /**
     * Description of the intent. Use the description to help identify the intent in lists.
     * 
     */
    @Export(name="description", refs={String.class}, tree="[0]")
    private Output</* @Nullable */ String> description;

    /**
     * @return Description of the intent. Use the description to help identify the intent in lists.
     * 
     */
    public Output<Optional<String>> description() {
        return Codegen.optional(this.description);
    }
    /**
     * Configuration block for invoking the alias Lambda function for each user input. You can invoke this Lambda function to personalize user interaction. See `dialog_code_hook`.
     * 
     */
    @Export(name="dialogCodeHook", refs={V2modelsIntentDialogCodeHook.class}, tree="[0]")
    private Output</* @Nullable */ V2modelsIntentDialogCodeHook> dialogCodeHook;

    /**
     * @return Configuration block for invoking the alias Lambda function for each user input. You can invoke this Lambda function to personalize user interaction. See `dialog_code_hook`.
     * 
     */
    public Output<Optional<V2modelsIntentDialogCodeHook>> dialogCodeHook() {
        return Codegen.optional(this.dialogCodeHook);
    }
    /**
     * Configuration block for invoking the alias Lambda function when the intent is ready for fulfillment. You can invoke this function to complete the bot&#39;s transaction with the user. See `fulfillment_code_hook`.
     * 
     */
    @Export(name="fulfillmentCodeHook", refs={V2modelsIntentFulfillmentCodeHook.class}, tree="[0]")
    private Output</* @Nullable */ V2modelsIntentFulfillmentCodeHook> fulfillmentCodeHook;

    /**
     * @return Configuration block for invoking the alias Lambda function when the intent is ready for fulfillment. You can invoke this function to complete the bot&#39;s transaction with the user. See `fulfillment_code_hook`.
     * 
     */
    public Output<Optional<V2modelsIntentFulfillmentCodeHook>> fulfillmentCodeHook() {
        return Codegen.optional(this.fulfillmentCodeHook);
    }
    /**
     * Configuration block for the response that is sent to the user at the beginning of a conversation, before eliciting slot values. See `initial_response_setting`.
     * 
     */
    @Export(name="initialResponseSetting", refs={V2modelsIntentInitialResponseSetting.class}, tree="[0]")
    private Output</* @Nullable */ V2modelsIntentInitialResponseSetting> initialResponseSetting;

    /**
     * @return Configuration block for the response that is sent to the user at the beginning of a conversation, before eliciting slot values. See `initial_response_setting`.
     * 
     */
    public Output<Optional<V2modelsIntentInitialResponseSetting>> initialResponseSetting() {
        return Codegen.optional(this.initialResponseSetting);
    }
    /**
     * Configuration blocks for contexts that must be active for this intent to be considered by Amazon Lex. When an intent has an input context list, Amazon Lex only considers using the intent in an interaction with the user when the specified contexts are included in the active context list for the session. If the contexts are not active, then Amazon Lex will not use the intent. A context can be automatically activated using the outputContexts property or it can be set at runtime. See `input_context`.
     * 
     */
    @Export(name="inputContexts", refs={List.class,V2modelsIntentInputContext.class}, tree="[0,1]")
    private Output</* @Nullable */ List<V2modelsIntentInputContext>> inputContexts;

    /**
     * @return Configuration blocks for contexts that must be active for this intent to be considered by Amazon Lex. When an intent has an input context list, Amazon Lex only considers using the intent in an interaction with the user when the specified contexts are included in the active context list for the session. If the contexts are not active, then Amazon Lex will not use the intent. A context can be automatically activated using the outputContexts property or it can be set at runtime. See `input_context`.
     * 
     */
    public Output<Optional<List<V2modelsIntentInputContext>>> inputContexts() {
        return Codegen.optional(this.inputContexts);
    }
    /**
     * Unique identifier for the intent.
     * 
     */
    @Export(name="intentId", refs={String.class}, tree="[0]")
    private Output<String> intentId;

    /**
     * @return Unique identifier for the intent.
     * 
     */
    public Output<String> intentId() {
        return this.intentId;
    }
    /**
     * Configuration block for information required to use the AMAZON.KendraSearchIntent intent to connect to an Amazon Kendra index. The AMAZON.KendraSearchIntent intent is called when Amazon Lex can&#39;t determine another intent to invoke. See `kendra_configuration`.
     * 
     */
    @Export(name="kendraConfiguration", refs={V2modelsIntentKendraConfiguration.class}, tree="[0]")
    private Output</* @Nullable */ V2modelsIntentKendraConfiguration> kendraConfiguration;

    /**
     * @return Configuration block for information required to use the AMAZON.KendraSearchIntent intent to connect to an Amazon Kendra index. The AMAZON.KendraSearchIntent intent is called when Amazon Lex can&#39;t determine another intent to invoke. See `kendra_configuration`.
     * 
     */
    public Output<Optional<V2modelsIntentKendraConfiguration>> kendraConfiguration() {
        return Codegen.optional(this.kendraConfiguration);
    }
    /**
     * Timestamp of the last time that the intent was modified.
     * 
     */
    @Export(name="lastUpdatedDateTime", refs={String.class}, tree="[0]")
    private Output<String> lastUpdatedDateTime;

    /**
     * @return Timestamp of the last time that the intent was modified.
     * 
     */
    public Output<String> lastUpdatedDateTime() {
        return this.lastUpdatedDateTime;
    }
    /**
     * Identifier of the language and locale where this intent is used. All of the bots, slot types, and slots used by the intent must have the same locale.
     * 
     */
    @Export(name="localeId", refs={String.class}, tree="[0]")
    private Output<String> localeId;

    /**
     * @return Identifier of the language and locale where this intent is used. All of the bots, slot types, and slots used by the intent must have the same locale.
     * 
     */
    public Output<String> localeId() {
        return this.localeId;
    }
    /**
     * Name of the intent. Intent names must be unique in the locale that contains the intent and cannot match the name of any built-in intent.
     * 
     * The following arguments are optional:
     * 
     */
    @Export(name="name", refs={String.class}, tree="[0]")
    private Output<String> name;

    /**
     * @return Name of the intent. Intent names must be unique in the locale that contains the intent and cannot match the name of any built-in intent.
     * 
     * The following arguments are optional:
     * 
     */
    public Output<String> name() {
        return this.name;
    }
    /**
     * Configuration blocks for contexts that the intent activates when it is fulfilled. You can use an output context to indicate the intents that Amazon Lex should consider for the next turn of the conversation with a customer. When you use the outputContextsList property, all of the contexts specified in the list are activated when the intent is fulfilled. You can set up to 10 output contexts. You can also set the number of conversation turns that the context should be active, or the length of time that the context should be active. See `output_context`.
     * 
     */
    @Export(name="outputContexts", refs={List.class,V2modelsIntentOutputContext.class}, tree="[0,1]")
    private Output</* @Nullable */ List<V2modelsIntentOutputContext>> outputContexts;

    /**
     * @return Configuration blocks for contexts that the intent activates when it is fulfilled. You can use an output context to indicate the intents that Amazon Lex should consider for the next turn of the conversation with a customer. When you use the outputContextsList property, all of the contexts specified in the list are activated when the intent is fulfilled. You can set up to 10 output contexts. You can also set the number of conversation turns that the context should be active, or the length of time that the context should be active. See `output_context`.
     * 
     */
    public Output<Optional<List<V2modelsIntentOutputContext>>> outputContexts() {
        return Codegen.optional(this.outputContexts);
    }
    /**
     * Identifier for the built-in intent to base this intent on.
     * 
     */
    @Export(name="parentIntentSignature", refs={String.class}, tree="[0]")
    private Output</* @Nullable */ String> parentIntentSignature;

    /**
     * @return Identifier for the built-in intent to base this intent on.
     * 
     */
    public Output<Optional<String>> parentIntentSignature() {
        return Codegen.optional(this.parentIntentSignature);
    }
    /**
     * Configuration block for strings that a user might say to signal the intent. See `sample_utterance`.
     * 
     */
    @Export(name="sampleUtterances", refs={List.class,V2modelsIntentSampleUtterance.class}, tree="[0,1]")
    private Output</* @Nullable */ List<V2modelsIntentSampleUtterance>> sampleUtterances;

    /**
     * @return Configuration block for strings that a user might say to signal the intent. See `sample_utterance`.
     * 
     */
    public Output<Optional<List<V2modelsIntentSampleUtterance>>> sampleUtterances() {
        return Codegen.optional(this.sampleUtterances);
    }
    /**
     * Configuration block for a new list of slots and their priorities that are contained by the intent. This is ignored on create and only valid for updates. See `slot_priority`.
     * 
     */
    @Export(name="slotPriorities", refs={List.class,V2modelsIntentSlotPriority.class}, tree="[0,1]")
    private Output</* @Nullable */ List<V2modelsIntentSlotPriority>> slotPriorities;

    /**
     * @return Configuration block for a new list of slots and their priorities that are contained by the intent. This is ignored on create and only valid for updates. See `slot_priority`.
     * 
     */
    public Output<Optional<List<V2modelsIntentSlotPriority>>> slotPriorities() {
        return Codegen.optional(this.slotPriorities);
    }
    @Export(name="timeouts", refs={V2modelsIntentTimeouts.class}, tree="[0]")
    private Output</* @Nullable */ V2modelsIntentTimeouts> timeouts;

    public Output<Optional<V2modelsIntentTimeouts>> timeouts() {
        return Codegen.optional(this.timeouts);
    }

    /**
     *
     * @param name The _unique_ name of the resulting resource.
     */
    public V2modelsIntent(java.lang.String name) {
        this(name, V2modelsIntentArgs.Empty);
    }
    /**
     *
     * @param name The _unique_ name of the resulting resource.
     * @param args The arguments to use to populate this resource's properties.
     */
    public V2modelsIntent(java.lang.String name, V2modelsIntentArgs args) {
        this(name, args, null);
    }
    /**
     *
     * @param name The _unique_ name of the resulting resource.
     * @param args The arguments to use to populate this resource's properties.
     * @param options A bag of options that control this resource's behavior.
     */
    public V2modelsIntent(java.lang.String name, V2modelsIntentArgs args, @Nullable com.pulumi.resources.CustomResourceOptions options) {
        super("aws:lex/v2modelsIntent:V2modelsIntent", name, makeArgs(args, options), makeResourceOptions(options, Codegen.empty()), false);
    }

    private V2modelsIntent(java.lang.String name, Output<java.lang.String> id, @Nullable V2modelsIntentState state, @Nullable com.pulumi.resources.CustomResourceOptions options) {
        super("aws:lex/v2modelsIntent:V2modelsIntent", name, state, makeResourceOptions(options, id), false);
    }

    private static V2modelsIntentArgs makeArgs(V2modelsIntentArgs args, @Nullable com.pulumi.resources.CustomResourceOptions options) {
        if (options != null && options.getUrn().isPresent()) {
            return null;
        }
        return args == null ? V2modelsIntentArgs.Empty : args;
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
    public static V2modelsIntent get(java.lang.String name, Output<java.lang.String> id, @Nullable V2modelsIntentState state, @Nullable com.pulumi.resources.CustomResourceOptions options) {
        return new V2modelsIntent(name, id, state, options);
    }
}
