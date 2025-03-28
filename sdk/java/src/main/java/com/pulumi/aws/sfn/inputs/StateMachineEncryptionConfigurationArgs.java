// *** WARNING: this file was generated by pulumi-java-gen. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

package com.pulumi.aws.sfn.inputs;

import com.pulumi.core.Output;
import com.pulumi.core.annotations.Import;
import java.lang.Integer;
import java.lang.String;
import java.util.Objects;
import java.util.Optional;
import javax.annotation.Nullable;


public final class StateMachineEncryptionConfigurationArgs extends com.pulumi.resources.ResourceArgs {

    public static final StateMachineEncryptionConfigurationArgs Empty = new StateMachineEncryptionConfigurationArgs();

    /**
     * Maximum duration for which Step Functions will reuse data keys. When the period expires, Step Functions will call GenerateDataKey. This setting only applies to customer managed KMS key and does not apply when `type` is `AWS_OWNED_KEY`.
     * 
     */
    @Import(name="kmsDataKeyReusePeriodSeconds")
    private @Nullable Output<Integer> kmsDataKeyReusePeriodSeconds;

    /**
     * @return Maximum duration for which Step Functions will reuse data keys. When the period expires, Step Functions will call GenerateDataKey. This setting only applies to customer managed KMS key and does not apply when `type` is `AWS_OWNED_KEY`.
     * 
     */
    public Optional<Output<Integer>> kmsDataKeyReusePeriodSeconds() {
        return Optional.ofNullable(this.kmsDataKeyReusePeriodSeconds);
    }

    /**
     * The alias, alias ARN, key ID, or key ARN of the symmetric encryption KMS key that encrypts the data key. To specify a KMS key in a different AWS account, the customer must use the key ARN or alias ARN. For more information regarding kms_key_id, see [KeyId](https://docs.aws.amazon.com/kms/latest/APIReference/API_DescribeKey.html#API_DescribeKey_RequestParameters) in the KMS documentation.
     * 
     */
    @Import(name="kmsKeyId")
    private @Nullable Output<String> kmsKeyId;

    /**
     * @return The alias, alias ARN, key ID, or key ARN of the symmetric encryption KMS key that encrypts the data key. To specify a KMS key in a different AWS account, the customer must use the key ARN or alias ARN. For more information regarding kms_key_id, see [KeyId](https://docs.aws.amazon.com/kms/latest/APIReference/API_DescribeKey.html#API_DescribeKey_RequestParameters) in the KMS documentation.
     * 
     */
    public Optional<Output<String>> kmsKeyId() {
        return Optional.ofNullable(this.kmsKeyId);
    }

    /**
     * The encryption option specified for the state machine. Valid values: `AWS_OWNED_KEY`, `CUSTOMER_MANAGED_KMS_KEY`
     * 
     */
    @Import(name="type")
    private @Nullable Output<String> type;

    /**
     * @return The encryption option specified for the state machine. Valid values: `AWS_OWNED_KEY`, `CUSTOMER_MANAGED_KMS_KEY`
     * 
     */
    public Optional<Output<String>> type() {
        return Optional.ofNullable(this.type);
    }

    private StateMachineEncryptionConfigurationArgs() {}

    private StateMachineEncryptionConfigurationArgs(StateMachineEncryptionConfigurationArgs $) {
        this.kmsDataKeyReusePeriodSeconds = $.kmsDataKeyReusePeriodSeconds;
        this.kmsKeyId = $.kmsKeyId;
        this.type = $.type;
    }

    public static Builder builder() {
        return new Builder();
    }
    public static Builder builder(StateMachineEncryptionConfigurationArgs defaults) {
        return new Builder(defaults);
    }

    public static final class Builder {
        private StateMachineEncryptionConfigurationArgs $;

        public Builder() {
            $ = new StateMachineEncryptionConfigurationArgs();
        }

        public Builder(StateMachineEncryptionConfigurationArgs defaults) {
            $ = new StateMachineEncryptionConfigurationArgs(Objects.requireNonNull(defaults));
        }

        /**
         * @param kmsDataKeyReusePeriodSeconds Maximum duration for which Step Functions will reuse data keys. When the period expires, Step Functions will call GenerateDataKey. This setting only applies to customer managed KMS key and does not apply when `type` is `AWS_OWNED_KEY`.
         * 
         * @return builder
         * 
         */
        public Builder kmsDataKeyReusePeriodSeconds(@Nullable Output<Integer> kmsDataKeyReusePeriodSeconds) {
            $.kmsDataKeyReusePeriodSeconds = kmsDataKeyReusePeriodSeconds;
            return this;
        }

        /**
         * @param kmsDataKeyReusePeriodSeconds Maximum duration for which Step Functions will reuse data keys. When the period expires, Step Functions will call GenerateDataKey. This setting only applies to customer managed KMS key and does not apply when `type` is `AWS_OWNED_KEY`.
         * 
         * @return builder
         * 
         */
        public Builder kmsDataKeyReusePeriodSeconds(Integer kmsDataKeyReusePeriodSeconds) {
            return kmsDataKeyReusePeriodSeconds(Output.of(kmsDataKeyReusePeriodSeconds));
        }

        /**
         * @param kmsKeyId The alias, alias ARN, key ID, or key ARN of the symmetric encryption KMS key that encrypts the data key. To specify a KMS key in a different AWS account, the customer must use the key ARN or alias ARN. For more information regarding kms_key_id, see [KeyId](https://docs.aws.amazon.com/kms/latest/APIReference/API_DescribeKey.html#API_DescribeKey_RequestParameters) in the KMS documentation.
         * 
         * @return builder
         * 
         */
        public Builder kmsKeyId(@Nullable Output<String> kmsKeyId) {
            $.kmsKeyId = kmsKeyId;
            return this;
        }

        /**
         * @param kmsKeyId The alias, alias ARN, key ID, or key ARN of the symmetric encryption KMS key that encrypts the data key. To specify a KMS key in a different AWS account, the customer must use the key ARN or alias ARN. For more information regarding kms_key_id, see [KeyId](https://docs.aws.amazon.com/kms/latest/APIReference/API_DescribeKey.html#API_DescribeKey_RequestParameters) in the KMS documentation.
         * 
         * @return builder
         * 
         */
        public Builder kmsKeyId(String kmsKeyId) {
            return kmsKeyId(Output.of(kmsKeyId));
        }

        /**
         * @param type The encryption option specified for the state machine. Valid values: `AWS_OWNED_KEY`, `CUSTOMER_MANAGED_KMS_KEY`
         * 
         * @return builder
         * 
         */
        public Builder type(@Nullable Output<String> type) {
            $.type = type;
            return this;
        }

        /**
         * @param type The encryption option specified for the state machine. Valid values: `AWS_OWNED_KEY`, `CUSTOMER_MANAGED_KMS_KEY`
         * 
         * @return builder
         * 
         */
        public Builder type(String type) {
            return type(Output.of(type));
        }

        public StateMachineEncryptionConfigurationArgs build() {
            return $;
        }
    }

}
