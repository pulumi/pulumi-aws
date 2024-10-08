// *** WARNING: this file was generated by pulumi-java-gen. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

package com.pulumi.aws.lex.inputs;

import com.pulumi.aws.lex.inputs.IntentConclusionStatementMessageArgs;
import com.pulumi.core.Output;
import com.pulumi.core.annotations.Import;
import com.pulumi.exceptions.MissingRequiredPropertyException;
import java.lang.String;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import javax.annotation.Nullable;


public final class IntentConclusionStatementArgs extends com.pulumi.resources.ResourceArgs {

    public static final IntentConclusionStatementArgs Empty = new IntentConclusionStatementArgs();

    @Import(name="messages", required=true)
    private Output<List<IntentConclusionStatementMessageArgs>> messages;

    public Output<List<IntentConclusionStatementMessageArgs>> messages() {
        return this.messages;
    }

    @Import(name="responseCard")
    private @Nullable Output<String> responseCard;

    public Optional<Output<String>> responseCard() {
        return Optional.ofNullable(this.responseCard);
    }

    private IntentConclusionStatementArgs() {}

    private IntentConclusionStatementArgs(IntentConclusionStatementArgs $) {
        this.messages = $.messages;
        this.responseCard = $.responseCard;
    }

    public static Builder builder() {
        return new Builder();
    }
    public static Builder builder(IntentConclusionStatementArgs defaults) {
        return new Builder(defaults);
    }

    public static final class Builder {
        private IntentConclusionStatementArgs $;

        public Builder() {
            $ = new IntentConclusionStatementArgs();
        }

        public Builder(IntentConclusionStatementArgs defaults) {
            $ = new IntentConclusionStatementArgs(Objects.requireNonNull(defaults));
        }

        public Builder messages(Output<List<IntentConclusionStatementMessageArgs>> messages) {
            $.messages = messages;
            return this;
        }

        public Builder messages(List<IntentConclusionStatementMessageArgs> messages) {
            return messages(Output.of(messages));
        }

        public Builder messages(IntentConclusionStatementMessageArgs... messages) {
            return messages(List.of(messages));
        }

        public Builder responseCard(@Nullable Output<String> responseCard) {
            $.responseCard = responseCard;
            return this;
        }

        public Builder responseCard(String responseCard) {
            return responseCard(Output.of(responseCard));
        }

        public IntentConclusionStatementArgs build() {
            if ($.messages == null) {
                throw new MissingRequiredPropertyException("IntentConclusionStatementArgs", "messages");
            }
            return $;
        }
    }

}
