// *** WARNING: this file was generated by pulumi-java-gen. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

package com.pulumi.aws.xray.inputs;

import com.pulumi.core.Output;
import com.pulumi.core.annotations.Import;
import java.lang.String;
import java.util.Objects;
import java.util.Optional;
import javax.annotation.Nullable;


public final class EncryptionConfigState extends com.pulumi.resources.ResourceArgs {

    public static final EncryptionConfigState Empty = new EncryptionConfigState();

    /**
     * An AWS KMS customer master key (CMK) ARN.
     * 
     */
    @Import(name="keyId")
    private @Nullable Output<String> keyId;

    /**
     * @return An AWS KMS customer master key (CMK) ARN.
     * 
     */
    public Optional<Output<String>> keyId() {
        return Optional.ofNullable(this.keyId);
    }

    /**
     * The type of encryption. Set to `KMS` to use your own key for encryption. Set to `NONE` for default encryption.
     * 
     */
    @Import(name="type")
    private @Nullable Output<String> type;

    /**
     * @return The type of encryption. Set to `KMS` to use your own key for encryption. Set to `NONE` for default encryption.
     * 
     */
    public Optional<Output<String>> type() {
        return Optional.ofNullable(this.type);
    }

    private EncryptionConfigState() {}

    private EncryptionConfigState(EncryptionConfigState $) {
        this.keyId = $.keyId;
        this.type = $.type;
    }

    public static Builder builder() {
        return new Builder();
    }
    public static Builder builder(EncryptionConfigState defaults) {
        return new Builder(defaults);
    }

    public static final class Builder {
        private EncryptionConfigState $;

        public Builder() {
            $ = new EncryptionConfigState();
        }

        public Builder(EncryptionConfigState defaults) {
            $ = new EncryptionConfigState(Objects.requireNonNull(defaults));
        }

        /**
         * @param keyId An AWS KMS customer master key (CMK) ARN.
         * 
         * @return builder
         * 
         */
        public Builder keyId(@Nullable Output<String> keyId) {
            $.keyId = keyId;
            return this;
        }

        /**
         * @param keyId An AWS KMS customer master key (CMK) ARN.
         * 
         * @return builder
         * 
         */
        public Builder keyId(String keyId) {
            return keyId(Output.of(keyId));
        }

        /**
         * @param type The type of encryption. Set to `KMS` to use your own key for encryption. Set to `NONE` for default encryption.
         * 
         * @return builder
         * 
         */
        public Builder type(@Nullable Output<String> type) {
            $.type = type;
            return this;
        }

        /**
         * @param type The type of encryption. Set to `KMS` to use your own key for encryption. Set to `NONE` for default encryption.
         * 
         * @return builder
         * 
         */
        public Builder type(String type) {
            return type(Output.of(type));
        }

        public EncryptionConfigState build() {
            return $;
        }
    }

}
