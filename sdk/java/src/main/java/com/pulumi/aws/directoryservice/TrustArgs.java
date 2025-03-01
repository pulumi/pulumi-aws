// *** WARNING: this file was generated by pulumi-java-gen. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

package com.pulumi.aws.directoryservice;

import com.pulumi.core.Output;
import com.pulumi.core.annotations.Import;
import com.pulumi.exceptions.MissingRequiredPropertyException;
import java.lang.Boolean;
import java.lang.String;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import javax.annotation.Nullable;


public final class TrustArgs extends com.pulumi.resources.ResourceArgs {

    public static final TrustArgs Empty = new TrustArgs();

    /**
     * Set of IPv4 addresses for the DNS server associated with the remote Directory.
     * Can contain between 1 and 4 values.
     * 
     */
    @Import(name="conditionalForwarderIpAddrs")
    private @Nullable Output<List<String>> conditionalForwarderIpAddrs;

    /**
     * @return Set of IPv4 addresses for the DNS server associated with the remote Directory.
     * Can contain between 1 and 4 values.
     * 
     */
    public Optional<Output<List<String>>> conditionalForwarderIpAddrs() {
        return Optional.ofNullable(this.conditionalForwarderIpAddrs);
    }

    /**
     * Whether to delete the conditional forwarder when deleting the Trust relationship.
     * 
     */
    @Import(name="deleteAssociatedConditionalForwarder")
    private @Nullable Output<Boolean> deleteAssociatedConditionalForwarder;

    /**
     * @return Whether to delete the conditional forwarder when deleting the Trust relationship.
     * 
     */
    public Optional<Output<Boolean>> deleteAssociatedConditionalForwarder() {
        return Optional.ofNullable(this.deleteAssociatedConditionalForwarder);
    }

    /**
     * ID of the Directory.
     * 
     */
    @Import(name="directoryId", required=true)
    private Output<String> directoryId;

    /**
     * @return ID of the Directory.
     * 
     */
    public Output<String> directoryId() {
        return this.directoryId;
    }

    /**
     * Fully qualified domain name of the remote Directory.
     * 
     */
    @Import(name="remoteDomainName", required=true)
    private Output<String> remoteDomainName;

    /**
     * @return Fully qualified domain name of the remote Directory.
     * 
     */
    public Output<String> remoteDomainName() {
        return this.remoteDomainName;
    }

    /**
     * Whether to enable selective authentication.
     * Valid values are `Enabled` and `Disabled`.
     * Default value is `Disabled`.
     * 
     */
    @Import(name="selectiveAuth")
    private @Nullable Output<String> selectiveAuth;

    /**
     * @return Whether to enable selective authentication.
     * Valid values are `Enabled` and `Disabled`.
     * Default value is `Disabled`.
     * 
     */
    public Optional<Output<String>> selectiveAuth() {
        return Optional.ofNullable(this.selectiveAuth);
    }

    /**
     * The direction of the Trust relationship.
     * Valid values are `One-Way: Outgoing`, `One-Way: Incoming`, and `Two-Way`.
     * 
     */
    @Import(name="trustDirection", required=true)
    private Output<String> trustDirection;

    /**
     * @return The direction of the Trust relationship.
     * Valid values are `One-Way: Outgoing`, `One-Way: Incoming`, and `Two-Way`.
     * 
     */
    public Output<String> trustDirection() {
        return this.trustDirection;
    }

    /**
     * Password for the Trust.
     * Does not need to match the passwords for either Directory.
     * Can contain upper- and lower-case letters, numbers, and punctuation characters.
     * May be up to 128 characters long.
     * 
     */
    @Import(name="trustPassword", required=true)
    private Output<String> trustPassword;

    /**
     * @return Password for the Trust.
     * Does not need to match the passwords for either Directory.
     * Can contain upper- and lower-case letters, numbers, and punctuation characters.
     * May be up to 128 characters long.
     * 
     */
    public Output<String> trustPassword() {
        return this.trustPassword;
    }

    /**
     * Type of the Trust relationship.
     * Valid values are `Forest` and `External`.
     * Default value is `Forest`.
     * 
     */
    @Import(name="trustType")
    private @Nullable Output<String> trustType;

    /**
     * @return Type of the Trust relationship.
     * Valid values are `Forest` and `External`.
     * Default value is `Forest`.
     * 
     */
    public Optional<Output<String>> trustType() {
        return Optional.ofNullable(this.trustType);
    }

    private TrustArgs() {}

    private TrustArgs(TrustArgs $) {
        this.conditionalForwarderIpAddrs = $.conditionalForwarderIpAddrs;
        this.deleteAssociatedConditionalForwarder = $.deleteAssociatedConditionalForwarder;
        this.directoryId = $.directoryId;
        this.remoteDomainName = $.remoteDomainName;
        this.selectiveAuth = $.selectiveAuth;
        this.trustDirection = $.trustDirection;
        this.trustPassword = $.trustPassword;
        this.trustType = $.trustType;
    }

    public static Builder builder() {
        return new Builder();
    }
    public static Builder builder(TrustArgs defaults) {
        return new Builder(defaults);
    }

    public static final class Builder {
        private TrustArgs $;

        public Builder() {
            $ = new TrustArgs();
        }

        public Builder(TrustArgs defaults) {
            $ = new TrustArgs(Objects.requireNonNull(defaults));
        }

        /**
         * @param conditionalForwarderIpAddrs Set of IPv4 addresses for the DNS server associated with the remote Directory.
         * Can contain between 1 and 4 values.
         * 
         * @return builder
         * 
         */
        public Builder conditionalForwarderIpAddrs(@Nullable Output<List<String>> conditionalForwarderIpAddrs) {
            $.conditionalForwarderIpAddrs = conditionalForwarderIpAddrs;
            return this;
        }

        /**
         * @param conditionalForwarderIpAddrs Set of IPv4 addresses for the DNS server associated with the remote Directory.
         * Can contain between 1 and 4 values.
         * 
         * @return builder
         * 
         */
        public Builder conditionalForwarderIpAddrs(List<String> conditionalForwarderIpAddrs) {
            return conditionalForwarderIpAddrs(Output.of(conditionalForwarderIpAddrs));
        }

        /**
         * @param conditionalForwarderIpAddrs Set of IPv4 addresses for the DNS server associated with the remote Directory.
         * Can contain between 1 and 4 values.
         * 
         * @return builder
         * 
         */
        public Builder conditionalForwarderIpAddrs(String... conditionalForwarderIpAddrs) {
            return conditionalForwarderIpAddrs(List.of(conditionalForwarderIpAddrs));
        }

        /**
         * @param deleteAssociatedConditionalForwarder Whether to delete the conditional forwarder when deleting the Trust relationship.
         * 
         * @return builder
         * 
         */
        public Builder deleteAssociatedConditionalForwarder(@Nullable Output<Boolean> deleteAssociatedConditionalForwarder) {
            $.deleteAssociatedConditionalForwarder = deleteAssociatedConditionalForwarder;
            return this;
        }

        /**
         * @param deleteAssociatedConditionalForwarder Whether to delete the conditional forwarder when deleting the Trust relationship.
         * 
         * @return builder
         * 
         */
        public Builder deleteAssociatedConditionalForwarder(Boolean deleteAssociatedConditionalForwarder) {
            return deleteAssociatedConditionalForwarder(Output.of(deleteAssociatedConditionalForwarder));
        }

        /**
         * @param directoryId ID of the Directory.
         * 
         * @return builder
         * 
         */
        public Builder directoryId(Output<String> directoryId) {
            $.directoryId = directoryId;
            return this;
        }

        /**
         * @param directoryId ID of the Directory.
         * 
         * @return builder
         * 
         */
        public Builder directoryId(String directoryId) {
            return directoryId(Output.of(directoryId));
        }

        /**
         * @param remoteDomainName Fully qualified domain name of the remote Directory.
         * 
         * @return builder
         * 
         */
        public Builder remoteDomainName(Output<String> remoteDomainName) {
            $.remoteDomainName = remoteDomainName;
            return this;
        }

        /**
         * @param remoteDomainName Fully qualified domain name of the remote Directory.
         * 
         * @return builder
         * 
         */
        public Builder remoteDomainName(String remoteDomainName) {
            return remoteDomainName(Output.of(remoteDomainName));
        }

        /**
         * @param selectiveAuth Whether to enable selective authentication.
         * Valid values are `Enabled` and `Disabled`.
         * Default value is `Disabled`.
         * 
         * @return builder
         * 
         */
        public Builder selectiveAuth(@Nullable Output<String> selectiveAuth) {
            $.selectiveAuth = selectiveAuth;
            return this;
        }

        /**
         * @param selectiveAuth Whether to enable selective authentication.
         * Valid values are `Enabled` and `Disabled`.
         * Default value is `Disabled`.
         * 
         * @return builder
         * 
         */
        public Builder selectiveAuth(String selectiveAuth) {
            return selectiveAuth(Output.of(selectiveAuth));
        }

        /**
         * @param trustDirection The direction of the Trust relationship.
         * Valid values are `One-Way: Outgoing`, `One-Way: Incoming`, and `Two-Way`.
         * 
         * @return builder
         * 
         */
        public Builder trustDirection(Output<String> trustDirection) {
            $.trustDirection = trustDirection;
            return this;
        }

        /**
         * @param trustDirection The direction of the Trust relationship.
         * Valid values are `One-Way: Outgoing`, `One-Way: Incoming`, and `Two-Way`.
         * 
         * @return builder
         * 
         */
        public Builder trustDirection(String trustDirection) {
            return trustDirection(Output.of(trustDirection));
        }

        /**
         * @param trustPassword Password for the Trust.
         * Does not need to match the passwords for either Directory.
         * Can contain upper- and lower-case letters, numbers, and punctuation characters.
         * May be up to 128 characters long.
         * 
         * @return builder
         * 
         */
        public Builder trustPassword(Output<String> trustPassword) {
            $.trustPassword = trustPassword;
            return this;
        }

        /**
         * @param trustPassword Password for the Trust.
         * Does not need to match the passwords for either Directory.
         * Can contain upper- and lower-case letters, numbers, and punctuation characters.
         * May be up to 128 characters long.
         * 
         * @return builder
         * 
         */
        public Builder trustPassword(String trustPassword) {
            return trustPassword(Output.of(trustPassword));
        }

        /**
         * @param trustType Type of the Trust relationship.
         * Valid values are `Forest` and `External`.
         * Default value is `Forest`.
         * 
         * @return builder
         * 
         */
        public Builder trustType(@Nullable Output<String> trustType) {
            $.trustType = trustType;
            return this;
        }

        /**
         * @param trustType Type of the Trust relationship.
         * Valid values are `Forest` and `External`.
         * Default value is `Forest`.
         * 
         * @return builder
         * 
         */
        public Builder trustType(String trustType) {
            return trustType(Output.of(trustType));
        }

        public TrustArgs build() {
            if ($.directoryId == null) {
                throw new MissingRequiredPropertyException("TrustArgs", "directoryId");
            }
            if ($.remoteDomainName == null) {
                throw new MissingRequiredPropertyException("TrustArgs", "remoteDomainName");
            }
            if ($.trustDirection == null) {
                throw new MissingRequiredPropertyException("TrustArgs", "trustDirection");
            }
            if ($.trustPassword == null) {
                throw new MissingRequiredPropertyException("TrustArgs", "trustPassword");
            }
            return $;
        }
    }

}
