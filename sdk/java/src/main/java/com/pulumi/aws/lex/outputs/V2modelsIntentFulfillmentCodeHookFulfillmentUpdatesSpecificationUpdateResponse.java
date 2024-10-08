// *** WARNING: this file was generated by pulumi-java-gen. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

package com.pulumi.aws.lex.outputs;

import com.pulumi.aws.lex.outputs.V2modelsIntentFulfillmentCodeHookFulfillmentUpdatesSpecificationUpdateResponseMessageGroup;
import com.pulumi.core.annotations.CustomType;
import com.pulumi.exceptions.MissingRequiredPropertyException;
import java.lang.Boolean;
import java.lang.Integer;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import javax.annotation.Nullable;

@CustomType
public final class V2modelsIntentFulfillmentCodeHookFulfillmentUpdatesSpecificationUpdateResponse {
    /**
     * @return Whether the user can interrupt the start message while it is playing.
     * 
     */
    private @Nullable Boolean allowInterrupt;
    /**
     * @return Frequency that a message is sent to the user. When the period ends, Amazon Lex chooses a message from the message groups and plays it to the user. If the fulfillment Lambda returns before the first period ends, an update message is not played to the user.
     * 
     */
    private Integer frequencyInSeconds;
    /**
     * @return Between 1-5 configuration block message groups that contain start messages. Amazon Lex chooses one of the messages to play to the user. See `message_group`.
     * 
     */
    private @Nullable List<V2modelsIntentFulfillmentCodeHookFulfillmentUpdatesSpecificationUpdateResponseMessageGroup> messageGroups;

    private V2modelsIntentFulfillmentCodeHookFulfillmentUpdatesSpecificationUpdateResponse() {}
    /**
     * @return Whether the user can interrupt the start message while it is playing.
     * 
     */
    public Optional<Boolean> allowInterrupt() {
        return Optional.ofNullable(this.allowInterrupt);
    }
    /**
     * @return Frequency that a message is sent to the user. When the period ends, Amazon Lex chooses a message from the message groups and plays it to the user. If the fulfillment Lambda returns before the first period ends, an update message is not played to the user.
     * 
     */
    public Integer frequencyInSeconds() {
        return this.frequencyInSeconds;
    }
    /**
     * @return Between 1-5 configuration block message groups that contain start messages. Amazon Lex chooses one of the messages to play to the user. See `message_group`.
     * 
     */
    public List<V2modelsIntentFulfillmentCodeHookFulfillmentUpdatesSpecificationUpdateResponseMessageGroup> messageGroups() {
        return this.messageGroups == null ? List.of() : this.messageGroups;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static Builder builder(V2modelsIntentFulfillmentCodeHookFulfillmentUpdatesSpecificationUpdateResponse defaults) {
        return new Builder(defaults);
    }
    @CustomType.Builder
    public static final class Builder {
        private @Nullable Boolean allowInterrupt;
        private Integer frequencyInSeconds;
        private @Nullable List<V2modelsIntentFulfillmentCodeHookFulfillmentUpdatesSpecificationUpdateResponseMessageGroup> messageGroups;
        public Builder() {}
        public Builder(V2modelsIntentFulfillmentCodeHookFulfillmentUpdatesSpecificationUpdateResponse defaults) {
    	      Objects.requireNonNull(defaults);
    	      this.allowInterrupt = defaults.allowInterrupt;
    	      this.frequencyInSeconds = defaults.frequencyInSeconds;
    	      this.messageGroups = defaults.messageGroups;
        }

        @CustomType.Setter
        public Builder allowInterrupt(@Nullable Boolean allowInterrupt) {

            this.allowInterrupt = allowInterrupt;
            return this;
        }
        @CustomType.Setter
        public Builder frequencyInSeconds(Integer frequencyInSeconds) {
            if (frequencyInSeconds == null) {
              throw new MissingRequiredPropertyException("V2modelsIntentFulfillmentCodeHookFulfillmentUpdatesSpecificationUpdateResponse", "frequencyInSeconds");
            }
            this.frequencyInSeconds = frequencyInSeconds;
            return this;
        }
        @CustomType.Setter
        public Builder messageGroups(@Nullable List<V2modelsIntentFulfillmentCodeHookFulfillmentUpdatesSpecificationUpdateResponseMessageGroup> messageGroups) {

            this.messageGroups = messageGroups;
            return this;
        }
        public Builder messageGroups(V2modelsIntentFulfillmentCodeHookFulfillmentUpdatesSpecificationUpdateResponseMessageGroup... messageGroups) {
            return messageGroups(List.of(messageGroups));
        }
        public V2modelsIntentFulfillmentCodeHookFulfillmentUpdatesSpecificationUpdateResponse build() {
            final var _resultValue = new V2modelsIntentFulfillmentCodeHookFulfillmentUpdatesSpecificationUpdateResponse();
            _resultValue.allowInterrupt = allowInterrupt;
            _resultValue.frequencyInSeconds = frequencyInSeconds;
            _resultValue.messageGroups = messageGroups;
            return _resultValue;
        }
    }
}
