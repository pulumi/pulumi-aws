// *** WARNING: this file was generated by pulumi-java-gen. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

package com.pulumi.aws.pinpoint.inputs;

import com.pulumi.aws.pinpoint.inputs.Smsvoicev2PhoneNumberTimeoutsArgs;
import com.pulumi.core.Output;
import com.pulumi.core.annotations.Import;
import java.lang.Boolean;
import java.lang.String;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import javax.annotation.Nullable;


public final class Smsvoicev2PhoneNumberState extends com.pulumi.resources.ResourceArgs {

    public static final Smsvoicev2PhoneNumberState Empty = new Smsvoicev2PhoneNumberState();

    /**
     * ARN of the phone number.
     * 
     */
    @Import(name="arn")
    private @Nullable Output<String> arn;

    /**
     * @return ARN of the phone number.
     * 
     */
    public Optional<Output<String>> arn() {
        return Optional.ofNullable(this.arn);
    }

    /**
     * By default this is set to `false`. When set to true the phone number can’t be deleted.
     * 
     */
    @Import(name="deletionProtectionEnabled")
    private @Nullable Output<Boolean> deletionProtectionEnabled;

    /**
     * @return By default this is set to `false`. When set to true the phone number can’t be deleted.
     * 
     */
    public Optional<Output<Boolean>> deletionProtectionEnabled() {
        return Optional.ofNullable(this.deletionProtectionEnabled);
    }

    /**
     * The two-character code, in ISO 3166-1 alpha-2 format, for the country or region.
     * 
     */
    @Import(name="isoCountryCode")
    private @Nullable Output<String> isoCountryCode;

    /**
     * @return The two-character code, in ISO 3166-1 alpha-2 format, for the country or region.
     * 
     */
    public Optional<Output<String>> isoCountryCode() {
        return Optional.ofNullable(this.isoCountryCode);
    }

    /**
     * The type of message. Valid values are `TRANSACTIONAL` for messages that are critical or time-sensitive and `PROMOTIONAL` for messages that aren’t critical or time-sensitive.
     * 
     */
    @Import(name="messageType")
    private @Nullable Output<String> messageType;

    /**
     * @return The type of message. Valid values are `TRANSACTIONAL` for messages that are critical or time-sensitive and `PROMOTIONAL` for messages that aren’t critical or time-sensitive.
     * 
     */
    public Optional<Output<String>> messageType() {
        return Optional.ofNullable(this.messageType);
    }

    /**
     * The monthly price, in US dollars, to lease the phone number.
     * 
     */
    @Import(name="monthlyLeasingPrice")
    private @Nullable Output<String> monthlyLeasingPrice;

    /**
     * @return The monthly price, in US dollars, to lease the phone number.
     * 
     */
    public Optional<Output<String>> monthlyLeasingPrice() {
        return Optional.ofNullable(this.monthlyLeasingPrice);
    }

    /**
     * Describes if the origination identity can be used for text messages, voice calls or both. valid values are `SMS` and `VOICE`.
     * 
     */
    @Import(name="numberCapabilities")
    private @Nullable Output<List<String>> numberCapabilities;

    /**
     * @return Describes if the origination identity can be used for text messages, voice calls or both. valid values are `SMS` and `VOICE`.
     * 
     */
    public Optional<Output<List<String>>> numberCapabilities() {
        return Optional.ofNullable(this.numberCapabilities);
    }

    /**
     * The type of phone number to request. Possible values are `LONG_CODE`, `TOLL_FREE`, `TEN_DLC`, or `SIMULATOR`.
     * 
     */
    @Import(name="numberType")
    private @Nullable Output<String> numberType;

    /**
     * @return The type of phone number to request. Possible values are `LONG_CODE`, `TOLL_FREE`, `TEN_DLC`, or `SIMULATOR`.
     * 
     */
    public Optional<Output<String>> numberType() {
        return Optional.ofNullable(this.numberType);
    }

    /**
     * The name of the opt-out list to associate with the phone number.
     * 
     */
    @Import(name="optOutListName")
    private @Nullable Output<String> optOutListName;

    /**
     * @return The name of the opt-out list to associate with the phone number.
     * 
     */
    public Optional<Output<String>> optOutListName() {
        return Optional.ofNullable(this.optOutListName);
    }

    /**
     * The new phone number that was requested.
     * 
     */
    @Import(name="phoneNumber")
    private @Nullable Output<String> phoneNumber;

    /**
     * @return The new phone number that was requested.
     * 
     */
    public Optional<Output<String>> phoneNumber() {
        return Optional.ofNullable(this.phoneNumber);
    }

    /**
     * Use this field to attach your phone number for an external registration process.
     * 
     */
    @Import(name="registrationId")
    private @Nullable Output<String> registrationId;

    /**
     * @return Use this field to attach your phone number for an external registration process.
     * 
     */
    public Optional<Output<String>> registrationId() {
        return Optional.ofNullable(this.registrationId);
    }

    /**
     * When set to `false` an end recipient sends a message that begins with HELP or STOP to one of your dedicated numbers, AWS End User Messaging SMS and Voice automatically replies with a customizable message and adds the end recipient to the opt-out list. When set to true you’re responsible for responding to HELP and STOP requests. You’re also responsible for tracking and honoring opt-out request.
     * 
     */
    @Import(name="selfManagedOptOutsEnabled")
    private @Nullable Output<Boolean> selfManagedOptOutsEnabled;

    /**
     * @return When set to `false` an end recipient sends a message that begins with HELP or STOP to one of your dedicated numbers, AWS End User Messaging SMS and Voice automatically replies with a customizable message and adds the end recipient to the opt-out list. When set to true you’re responsible for responding to HELP and STOP requests. You’re also responsible for tracking and honoring opt-out request.
     * 
     */
    public Optional<Output<Boolean>> selfManagedOptOutsEnabled() {
        return Optional.ofNullable(this.selfManagedOptOutsEnabled);
    }

    @Import(name="tags")
    private @Nullable Output<Map<String,String>> tags;

    public Optional<Output<Map<String,String>>> tags() {
        return Optional.ofNullable(this.tags);
    }

    /**
     * A map of tags assigned to the resource, including those inherited from the provider `default_tags` configuration block.
     * 
     * @deprecated
     * Please use `tags` instead.
     * 
     */
    @Deprecated /* Please use `tags` instead. */
    @Import(name="tagsAll")
    private @Nullable Output<Map<String,String>> tagsAll;

    /**
     * @return A map of tags assigned to the resource, including those inherited from the provider `default_tags` configuration block.
     * 
     * @deprecated
     * Please use `tags` instead.
     * 
     */
    @Deprecated /* Please use `tags` instead. */
    public Optional<Output<Map<String,String>>> tagsAll() {
        return Optional.ofNullable(this.tagsAll);
    }

    @Import(name="timeouts")
    private @Nullable Output<Smsvoicev2PhoneNumberTimeoutsArgs> timeouts;

    public Optional<Output<Smsvoicev2PhoneNumberTimeoutsArgs>> timeouts() {
        return Optional.ofNullable(this.timeouts);
    }

    /**
     * The Amazon Resource Name (ARN) of the two way channel.
     * 
     */
    @Import(name="twoWayChannelArn")
    private @Nullable Output<String> twoWayChannelArn;

    /**
     * @return The Amazon Resource Name (ARN) of the two way channel.
     * 
     */
    public Optional<Output<String>> twoWayChannelArn() {
        return Optional.ofNullable(this.twoWayChannelArn);
    }

    /**
     * By default this is set to `false`. When set to `true` you can receive incoming text messages from your end recipients.
     * 
     */
    @Import(name="twoWayChannelEnabled")
    private @Nullable Output<Boolean> twoWayChannelEnabled;

    /**
     * @return By default this is set to `false`. When set to `true` you can receive incoming text messages from your end recipients.
     * 
     */
    public Optional<Output<Boolean>> twoWayChannelEnabled() {
        return Optional.ofNullable(this.twoWayChannelEnabled);
    }

    /**
     * IAM Role ARN for a service to assume, to be able to post inbound SMS messages.
     * 
     */
    @Import(name="twoWayChannelRole")
    private @Nullable Output<String> twoWayChannelRole;

    /**
     * @return IAM Role ARN for a service to assume, to be able to post inbound SMS messages.
     * 
     */
    public Optional<Output<String>> twoWayChannelRole() {
        return Optional.ofNullable(this.twoWayChannelRole);
    }

    private Smsvoicev2PhoneNumberState() {}

    private Smsvoicev2PhoneNumberState(Smsvoicev2PhoneNumberState $) {
        this.arn = $.arn;
        this.deletionProtectionEnabled = $.deletionProtectionEnabled;
        this.isoCountryCode = $.isoCountryCode;
        this.messageType = $.messageType;
        this.monthlyLeasingPrice = $.monthlyLeasingPrice;
        this.numberCapabilities = $.numberCapabilities;
        this.numberType = $.numberType;
        this.optOutListName = $.optOutListName;
        this.phoneNumber = $.phoneNumber;
        this.registrationId = $.registrationId;
        this.selfManagedOptOutsEnabled = $.selfManagedOptOutsEnabled;
        this.tags = $.tags;
        this.tagsAll = $.tagsAll;
        this.timeouts = $.timeouts;
        this.twoWayChannelArn = $.twoWayChannelArn;
        this.twoWayChannelEnabled = $.twoWayChannelEnabled;
        this.twoWayChannelRole = $.twoWayChannelRole;
    }

    public static Builder builder() {
        return new Builder();
    }
    public static Builder builder(Smsvoicev2PhoneNumberState defaults) {
        return new Builder(defaults);
    }

    public static final class Builder {
        private Smsvoicev2PhoneNumberState $;

        public Builder() {
            $ = new Smsvoicev2PhoneNumberState();
        }

        public Builder(Smsvoicev2PhoneNumberState defaults) {
            $ = new Smsvoicev2PhoneNumberState(Objects.requireNonNull(defaults));
        }

        /**
         * @param arn ARN of the phone number.
         * 
         * @return builder
         * 
         */
        public Builder arn(@Nullable Output<String> arn) {
            $.arn = arn;
            return this;
        }

        /**
         * @param arn ARN of the phone number.
         * 
         * @return builder
         * 
         */
        public Builder arn(String arn) {
            return arn(Output.of(arn));
        }

        /**
         * @param deletionProtectionEnabled By default this is set to `false`. When set to true the phone number can’t be deleted.
         * 
         * @return builder
         * 
         */
        public Builder deletionProtectionEnabled(@Nullable Output<Boolean> deletionProtectionEnabled) {
            $.deletionProtectionEnabled = deletionProtectionEnabled;
            return this;
        }

        /**
         * @param deletionProtectionEnabled By default this is set to `false`. When set to true the phone number can’t be deleted.
         * 
         * @return builder
         * 
         */
        public Builder deletionProtectionEnabled(Boolean deletionProtectionEnabled) {
            return deletionProtectionEnabled(Output.of(deletionProtectionEnabled));
        }

        /**
         * @param isoCountryCode The two-character code, in ISO 3166-1 alpha-2 format, for the country or region.
         * 
         * @return builder
         * 
         */
        public Builder isoCountryCode(@Nullable Output<String> isoCountryCode) {
            $.isoCountryCode = isoCountryCode;
            return this;
        }

        /**
         * @param isoCountryCode The two-character code, in ISO 3166-1 alpha-2 format, for the country or region.
         * 
         * @return builder
         * 
         */
        public Builder isoCountryCode(String isoCountryCode) {
            return isoCountryCode(Output.of(isoCountryCode));
        }

        /**
         * @param messageType The type of message. Valid values are `TRANSACTIONAL` for messages that are critical or time-sensitive and `PROMOTIONAL` for messages that aren’t critical or time-sensitive.
         * 
         * @return builder
         * 
         */
        public Builder messageType(@Nullable Output<String> messageType) {
            $.messageType = messageType;
            return this;
        }

        /**
         * @param messageType The type of message. Valid values are `TRANSACTIONAL` for messages that are critical or time-sensitive and `PROMOTIONAL` for messages that aren’t critical or time-sensitive.
         * 
         * @return builder
         * 
         */
        public Builder messageType(String messageType) {
            return messageType(Output.of(messageType));
        }

        /**
         * @param monthlyLeasingPrice The monthly price, in US dollars, to lease the phone number.
         * 
         * @return builder
         * 
         */
        public Builder monthlyLeasingPrice(@Nullable Output<String> monthlyLeasingPrice) {
            $.monthlyLeasingPrice = monthlyLeasingPrice;
            return this;
        }

        /**
         * @param monthlyLeasingPrice The monthly price, in US dollars, to lease the phone number.
         * 
         * @return builder
         * 
         */
        public Builder monthlyLeasingPrice(String monthlyLeasingPrice) {
            return monthlyLeasingPrice(Output.of(monthlyLeasingPrice));
        }

        /**
         * @param numberCapabilities Describes if the origination identity can be used for text messages, voice calls or both. valid values are `SMS` and `VOICE`.
         * 
         * @return builder
         * 
         */
        public Builder numberCapabilities(@Nullable Output<List<String>> numberCapabilities) {
            $.numberCapabilities = numberCapabilities;
            return this;
        }

        /**
         * @param numberCapabilities Describes if the origination identity can be used for text messages, voice calls or both. valid values are `SMS` and `VOICE`.
         * 
         * @return builder
         * 
         */
        public Builder numberCapabilities(List<String> numberCapabilities) {
            return numberCapabilities(Output.of(numberCapabilities));
        }

        /**
         * @param numberCapabilities Describes if the origination identity can be used for text messages, voice calls or both. valid values are `SMS` and `VOICE`.
         * 
         * @return builder
         * 
         */
        public Builder numberCapabilities(String... numberCapabilities) {
            return numberCapabilities(List.of(numberCapabilities));
        }

        /**
         * @param numberType The type of phone number to request. Possible values are `LONG_CODE`, `TOLL_FREE`, `TEN_DLC`, or `SIMULATOR`.
         * 
         * @return builder
         * 
         */
        public Builder numberType(@Nullable Output<String> numberType) {
            $.numberType = numberType;
            return this;
        }

        /**
         * @param numberType The type of phone number to request. Possible values are `LONG_CODE`, `TOLL_FREE`, `TEN_DLC`, or `SIMULATOR`.
         * 
         * @return builder
         * 
         */
        public Builder numberType(String numberType) {
            return numberType(Output.of(numberType));
        }

        /**
         * @param optOutListName The name of the opt-out list to associate with the phone number.
         * 
         * @return builder
         * 
         */
        public Builder optOutListName(@Nullable Output<String> optOutListName) {
            $.optOutListName = optOutListName;
            return this;
        }

        /**
         * @param optOutListName The name of the opt-out list to associate with the phone number.
         * 
         * @return builder
         * 
         */
        public Builder optOutListName(String optOutListName) {
            return optOutListName(Output.of(optOutListName));
        }

        /**
         * @param phoneNumber The new phone number that was requested.
         * 
         * @return builder
         * 
         */
        public Builder phoneNumber(@Nullable Output<String> phoneNumber) {
            $.phoneNumber = phoneNumber;
            return this;
        }

        /**
         * @param phoneNumber The new phone number that was requested.
         * 
         * @return builder
         * 
         */
        public Builder phoneNumber(String phoneNumber) {
            return phoneNumber(Output.of(phoneNumber));
        }

        /**
         * @param registrationId Use this field to attach your phone number for an external registration process.
         * 
         * @return builder
         * 
         */
        public Builder registrationId(@Nullable Output<String> registrationId) {
            $.registrationId = registrationId;
            return this;
        }

        /**
         * @param registrationId Use this field to attach your phone number for an external registration process.
         * 
         * @return builder
         * 
         */
        public Builder registrationId(String registrationId) {
            return registrationId(Output.of(registrationId));
        }

        /**
         * @param selfManagedOptOutsEnabled When set to `false` an end recipient sends a message that begins with HELP or STOP to one of your dedicated numbers, AWS End User Messaging SMS and Voice automatically replies with a customizable message and adds the end recipient to the opt-out list. When set to true you’re responsible for responding to HELP and STOP requests. You’re also responsible for tracking and honoring opt-out request.
         * 
         * @return builder
         * 
         */
        public Builder selfManagedOptOutsEnabled(@Nullable Output<Boolean> selfManagedOptOutsEnabled) {
            $.selfManagedOptOutsEnabled = selfManagedOptOutsEnabled;
            return this;
        }

        /**
         * @param selfManagedOptOutsEnabled When set to `false` an end recipient sends a message that begins with HELP or STOP to one of your dedicated numbers, AWS End User Messaging SMS and Voice automatically replies with a customizable message and adds the end recipient to the opt-out list. When set to true you’re responsible for responding to HELP and STOP requests. You’re also responsible for tracking and honoring opt-out request.
         * 
         * @return builder
         * 
         */
        public Builder selfManagedOptOutsEnabled(Boolean selfManagedOptOutsEnabled) {
            return selfManagedOptOutsEnabled(Output.of(selfManagedOptOutsEnabled));
        }

        public Builder tags(@Nullable Output<Map<String,String>> tags) {
            $.tags = tags;
            return this;
        }

        public Builder tags(Map<String,String> tags) {
            return tags(Output.of(tags));
        }

        /**
         * @param tagsAll A map of tags assigned to the resource, including those inherited from the provider `default_tags` configuration block.
         * 
         * @return builder
         * 
         * @deprecated
         * Please use `tags` instead.
         * 
         */
        @Deprecated /* Please use `tags` instead. */
        public Builder tagsAll(@Nullable Output<Map<String,String>> tagsAll) {
            $.tagsAll = tagsAll;
            return this;
        }

        /**
         * @param tagsAll A map of tags assigned to the resource, including those inherited from the provider `default_tags` configuration block.
         * 
         * @return builder
         * 
         * @deprecated
         * Please use `tags` instead.
         * 
         */
        @Deprecated /* Please use `tags` instead. */
        public Builder tagsAll(Map<String,String> tagsAll) {
            return tagsAll(Output.of(tagsAll));
        }

        public Builder timeouts(@Nullable Output<Smsvoicev2PhoneNumberTimeoutsArgs> timeouts) {
            $.timeouts = timeouts;
            return this;
        }

        public Builder timeouts(Smsvoicev2PhoneNumberTimeoutsArgs timeouts) {
            return timeouts(Output.of(timeouts));
        }

        /**
         * @param twoWayChannelArn The Amazon Resource Name (ARN) of the two way channel.
         * 
         * @return builder
         * 
         */
        public Builder twoWayChannelArn(@Nullable Output<String> twoWayChannelArn) {
            $.twoWayChannelArn = twoWayChannelArn;
            return this;
        }

        /**
         * @param twoWayChannelArn The Amazon Resource Name (ARN) of the two way channel.
         * 
         * @return builder
         * 
         */
        public Builder twoWayChannelArn(String twoWayChannelArn) {
            return twoWayChannelArn(Output.of(twoWayChannelArn));
        }

        /**
         * @param twoWayChannelEnabled By default this is set to `false`. When set to `true` you can receive incoming text messages from your end recipients.
         * 
         * @return builder
         * 
         */
        public Builder twoWayChannelEnabled(@Nullable Output<Boolean> twoWayChannelEnabled) {
            $.twoWayChannelEnabled = twoWayChannelEnabled;
            return this;
        }

        /**
         * @param twoWayChannelEnabled By default this is set to `false`. When set to `true` you can receive incoming text messages from your end recipients.
         * 
         * @return builder
         * 
         */
        public Builder twoWayChannelEnabled(Boolean twoWayChannelEnabled) {
            return twoWayChannelEnabled(Output.of(twoWayChannelEnabled));
        }

        /**
         * @param twoWayChannelRole IAM Role ARN for a service to assume, to be able to post inbound SMS messages.
         * 
         * @return builder
         * 
         */
        public Builder twoWayChannelRole(@Nullable Output<String> twoWayChannelRole) {
            $.twoWayChannelRole = twoWayChannelRole;
            return this;
        }

        /**
         * @param twoWayChannelRole IAM Role ARN for a service to assume, to be able to post inbound SMS messages.
         * 
         * @return builder
         * 
         */
        public Builder twoWayChannelRole(String twoWayChannelRole) {
            return twoWayChannelRole(Output.of(twoWayChannelRole));
        }

        public Smsvoicev2PhoneNumberState build() {
            return $;
        }
    }

}
