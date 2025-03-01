// *** WARNING: this file was generated by pulumi-java-gen. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

package com.pulumi.aws.ec2;

import com.pulumi.core.Output;
import com.pulumi.core.annotations.Import;
import com.pulumi.exceptions.MissingRequiredPropertyException;
import java.lang.String;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import javax.annotation.Nullable;


public final class KeyPairArgs extends com.pulumi.resources.ResourceArgs {

    public static final KeyPairArgs Empty = new KeyPairArgs();

    /**
     * The name for the key pair. If neither `key_name` nor `key_name_prefix` is provided, the provider will create a unique key name.
     * 
     */
    @Import(name="keyName")
    private @Nullable Output<String> keyName;

    /**
     * @return The name for the key pair. If neither `key_name` nor `key_name_prefix` is provided, the provider will create a unique key name.
     * 
     */
    public Optional<Output<String>> keyName() {
        return Optional.ofNullable(this.keyName);
    }

    /**
     * Creates a unique name beginning with the specified prefix. Conflicts with `key_name`. If neither `key_name` nor `key_name_prefix` is provided, the provider will create a unique key name.
     * 
     */
    @Import(name="keyNamePrefix")
    private @Nullable Output<String> keyNamePrefix;

    /**
     * @return Creates a unique name beginning with the specified prefix. Conflicts with `key_name`. If neither `key_name` nor `key_name_prefix` is provided, the provider will create a unique key name.
     * 
     */
    public Optional<Output<String>> keyNamePrefix() {
        return Optional.ofNullable(this.keyNamePrefix);
    }

    /**
     * The public key material.
     * 
     */
    @Import(name="publicKey", required=true)
    private Output<String> publicKey;

    /**
     * @return The public key material.
     * 
     */
    public Output<String> publicKey() {
        return this.publicKey;
    }

    /**
     * Key-value map of resource tags. If configured with a provider `default_tags` configuration block present, tags with matching keys will overwrite those defined at the provider-level.
     * 
     */
    @Import(name="tags")
    private @Nullable Output<Map<String,String>> tags;

    /**
     * @return Key-value map of resource tags. If configured with a provider `default_tags` configuration block present, tags with matching keys will overwrite those defined at the provider-level.
     * 
     */
    public Optional<Output<Map<String,String>>> tags() {
        return Optional.ofNullable(this.tags);
    }

    private KeyPairArgs() {}

    private KeyPairArgs(KeyPairArgs $) {
        this.keyName = $.keyName;
        this.keyNamePrefix = $.keyNamePrefix;
        this.publicKey = $.publicKey;
        this.tags = $.tags;
    }

    public static Builder builder() {
        return new Builder();
    }
    public static Builder builder(KeyPairArgs defaults) {
        return new Builder(defaults);
    }

    public static final class Builder {
        private KeyPairArgs $;

        public Builder() {
            $ = new KeyPairArgs();
        }

        public Builder(KeyPairArgs defaults) {
            $ = new KeyPairArgs(Objects.requireNonNull(defaults));
        }

        /**
         * @param keyName The name for the key pair. If neither `key_name` nor `key_name_prefix` is provided, the provider will create a unique key name.
         * 
         * @return builder
         * 
         */
        public Builder keyName(@Nullable Output<String> keyName) {
            $.keyName = keyName;
            return this;
        }

        /**
         * @param keyName The name for the key pair. If neither `key_name` nor `key_name_prefix` is provided, the provider will create a unique key name.
         * 
         * @return builder
         * 
         */
        public Builder keyName(String keyName) {
            return keyName(Output.of(keyName));
        }

        /**
         * @param keyNamePrefix Creates a unique name beginning with the specified prefix. Conflicts with `key_name`. If neither `key_name` nor `key_name_prefix` is provided, the provider will create a unique key name.
         * 
         * @return builder
         * 
         */
        public Builder keyNamePrefix(@Nullable Output<String> keyNamePrefix) {
            $.keyNamePrefix = keyNamePrefix;
            return this;
        }

        /**
         * @param keyNamePrefix Creates a unique name beginning with the specified prefix. Conflicts with `key_name`. If neither `key_name` nor `key_name_prefix` is provided, the provider will create a unique key name.
         * 
         * @return builder
         * 
         */
        public Builder keyNamePrefix(String keyNamePrefix) {
            return keyNamePrefix(Output.of(keyNamePrefix));
        }

        /**
         * @param publicKey The public key material.
         * 
         * @return builder
         * 
         */
        public Builder publicKey(Output<String> publicKey) {
            $.publicKey = publicKey;
            return this;
        }

        /**
         * @param publicKey The public key material.
         * 
         * @return builder
         * 
         */
        public Builder publicKey(String publicKey) {
            return publicKey(Output.of(publicKey));
        }

        /**
         * @param tags Key-value map of resource tags. If configured with a provider `default_tags` configuration block present, tags with matching keys will overwrite those defined at the provider-level.
         * 
         * @return builder
         * 
         */
        public Builder tags(@Nullable Output<Map<String,String>> tags) {
            $.tags = tags;
            return this;
        }

        /**
         * @param tags Key-value map of resource tags. If configured with a provider `default_tags` configuration block present, tags with matching keys will overwrite those defined at the provider-level.
         * 
         * @return builder
         * 
         */
        public Builder tags(Map<String,String> tags) {
            return tags(Output.of(tags));
        }

        public KeyPairArgs build() {
            if ($.publicKey == null) {
                throw new MissingRequiredPropertyException("KeyPairArgs", "publicKey");
            }
            return $;
        }
    }

}
