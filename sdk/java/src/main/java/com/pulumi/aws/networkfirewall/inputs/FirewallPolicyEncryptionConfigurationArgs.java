// *** WARNING: this file was generated by pulumi-java-gen. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

package com.pulumi.aws.networkfirewall.inputs;

import com.pulumi.core.Output;
import com.pulumi.core.annotations.Import;
import com.pulumi.exceptions.MissingRequiredPropertyException;
import java.lang.String;
import java.util.Objects;
import java.util.Optional;
import javax.annotation.Nullable;


public final class FirewallPolicyEncryptionConfigurationArgs extends com.pulumi.resources.ResourceArgs {

    public static final FirewallPolicyEncryptionConfigurationArgs Empty = new FirewallPolicyEncryptionConfigurationArgs();

    /**
     * The ID of the customer managed key. You can use any of the [key identifiers](https://docs.aws.amazon.com/kms/latest/developerguide/concepts.html#key-id) that KMS supports, unless you&#39;re using a key that&#39;s managed by another account. If you&#39;re using a key managed by another account, then specify the key ARN.
     * 
     */
    @Import(name="keyId")
    private @Nullable Output<String> keyId;

    /**
     * @return The ID of the customer managed key. You can use any of the [key identifiers](https://docs.aws.amazon.com/kms/latest/developerguide/concepts.html#key-id) that KMS supports, unless you&#39;re using a key that&#39;s managed by another account. If you&#39;re using a key managed by another account, then specify the key ARN.
     * 
     */
    public Optional<Output<String>> keyId() {
        return Optional.ofNullable(this.keyId);
    }

    /**
     * The type of AWS KMS key to use for encryption of your Network Firewall resources. Valid values are `CUSTOMER_KMS` and `AWS_OWNED_KMS_KEY`.
     * 
     */
    @Import(name="type", required=true)
    private Output<String> type;

    /**
     * @return The type of AWS KMS key to use for encryption of your Network Firewall resources. Valid values are `CUSTOMER_KMS` and `AWS_OWNED_KMS_KEY`.
     * 
     */
    public Output<String> type() {
        return this.type;
    }

    private FirewallPolicyEncryptionConfigurationArgs() {}

    private FirewallPolicyEncryptionConfigurationArgs(FirewallPolicyEncryptionConfigurationArgs $) {
        this.keyId = $.keyId;
        this.type = $.type;
    }

    public static Builder builder() {
        return new Builder();
    }
    public static Builder builder(FirewallPolicyEncryptionConfigurationArgs defaults) {
        return new Builder(defaults);
    }

    public static final class Builder {
        private FirewallPolicyEncryptionConfigurationArgs $;

        public Builder() {
            $ = new FirewallPolicyEncryptionConfigurationArgs();
        }

        public Builder(FirewallPolicyEncryptionConfigurationArgs defaults) {
            $ = new FirewallPolicyEncryptionConfigurationArgs(Objects.requireNonNull(defaults));
        }

        /**
         * @param keyId The ID of the customer managed key. You can use any of the [key identifiers](https://docs.aws.amazon.com/kms/latest/developerguide/concepts.html#key-id) that KMS supports, unless you&#39;re using a key that&#39;s managed by another account. If you&#39;re using a key managed by another account, then specify the key ARN.
         * 
         * @return builder
         * 
         */
        public Builder keyId(@Nullable Output<String> keyId) {
            $.keyId = keyId;
            return this;
        }

        /**
         * @param keyId The ID of the customer managed key. You can use any of the [key identifiers](https://docs.aws.amazon.com/kms/latest/developerguide/concepts.html#key-id) that KMS supports, unless you&#39;re using a key that&#39;s managed by another account. If you&#39;re using a key managed by another account, then specify the key ARN.
         * 
         * @return builder
         * 
         */
        public Builder keyId(String keyId) {
            return keyId(Output.of(keyId));
        }

        /**
         * @param type The type of AWS KMS key to use for encryption of your Network Firewall resources. Valid values are `CUSTOMER_KMS` and `AWS_OWNED_KMS_KEY`.
         * 
         * @return builder
         * 
         */
        public Builder type(Output<String> type) {
            $.type = type;
            return this;
        }

        /**
         * @param type The type of AWS KMS key to use for encryption of your Network Firewall resources. Valid values are `CUSTOMER_KMS` and `AWS_OWNED_KMS_KEY`.
         * 
         * @return builder
         * 
         */
        public Builder type(String type) {
            return type(Output.of(type));
        }

        public FirewallPolicyEncryptionConfigurationArgs build() {
            if ($.type == null) {
                throw new MissingRequiredPropertyException("FirewallPolicyEncryptionConfigurationArgs", "type");
            }
            return $;
        }
    }

}
