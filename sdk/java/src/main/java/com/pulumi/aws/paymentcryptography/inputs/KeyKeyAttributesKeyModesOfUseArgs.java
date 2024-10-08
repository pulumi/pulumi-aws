// *** WARNING: this file was generated by pulumi-java-gen. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

package com.pulumi.aws.paymentcryptography.inputs;

import com.pulumi.core.Output;
import com.pulumi.core.annotations.Import;
import java.lang.Boolean;
import java.util.Objects;
import java.util.Optional;
import javax.annotation.Nullable;


public final class KeyKeyAttributesKeyModesOfUseArgs extends com.pulumi.resources.ResourceArgs {

    public static final KeyKeyAttributesKeyModesOfUseArgs Empty = new KeyKeyAttributesKeyModesOfUseArgs();

    /**
     * Whether an AWS Payment Cryptography key can be used to decrypt data.
     * 
     */
    @Import(name="decrypt")
    private @Nullable Output<Boolean> decrypt;

    /**
     * @return Whether an AWS Payment Cryptography key can be used to decrypt data.
     * 
     */
    public Optional<Output<Boolean>> decrypt() {
        return Optional.ofNullable(this.decrypt);
    }

    /**
     * Whether an AWS Payment Cryptography key can be used to derive new keys.
     * 
     */
    @Import(name="deriveKey")
    private @Nullable Output<Boolean> deriveKey;

    /**
     * @return Whether an AWS Payment Cryptography key can be used to derive new keys.
     * 
     */
    public Optional<Output<Boolean>> deriveKey() {
        return Optional.ofNullable(this.deriveKey);
    }

    /**
     * Whether an AWS Payment Cryptography key can be used to encrypt data.
     * 
     */
    @Import(name="encrypt")
    private @Nullable Output<Boolean> encrypt;

    /**
     * @return Whether an AWS Payment Cryptography key can be used to encrypt data.
     * 
     */
    public Optional<Output<Boolean>> encrypt() {
        return Optional.ofNullable(this.encrypt);
    }

    /**
     * Whether an AWS Payment Cryptography key can be used to generate and verify other card and PIN verification keys.
     * 
     */
    @Import(name="generate")
    private @Nullable Output<Boolean> generate;

    /**
     * @return Whether an AWS Payment Cryptography key can be used to generate and verify other card and PIN verification keys.
     * 
     */
    public Optional<Output<Boolean>> generate() {
        return Optional.ofNullable(this.generate);
    }

    /**
     * Whether an AWS Payment Cryptography key has no special restrictions other than the restrictions implied by KeyUsage.
     * 
     */
    @Import(name="noRestrictions")
    private @Nullable Output<Boolean> noRestrictions;

    /**
     * @return Whether an AWS Payment Cryptography key has no special restrictions other than the restrictions implied by KeyUsage.
     * 
     */
    public Optional<Output<Boolean>> noRestrictions() {
        return Optional.ofNullable(this.noRestrictions);
    }

    /**
     * Whether an AWS Payment Cryptography key can be used for signing.
     * 
     */
    @Import(name="sign")
    private @Nullable Output<Boolean> sign;

    /**
     * @return Whether an AWS Payment Cryptography key can be used for signing.
     * 
     */
    public Optional<Output<Boolean>> sign() {
        return Optional.ofNullable(this.sign);
    }

    /**
     * Whether an AWS Payment Cryptography key can be used to unwrap other keys.
     * 
     */
    @Import(name="unwrap")
    private @Nullable Output<Boolean> unwrap;

    /**
     * @return Whether an AWS Payment Cryptography key can be used to unwrap other keys.
     * 
     */
    public Optional<Output<Boolean>> unwrap() {
        return Optional.ofNullable(this.unwrap);
    }

    /**
     * Whether an AWS Payment Cryptography key can be used to verify signatures.
     * 
     */
    @Import(name="verify")
    private @Nullable Output<Boolean> verify;

    /**
     * @return Whether an AWS Payment Cryptography key can be used to verify signatures.
     * 
     */
    public Optional<Output<Boolean>> verify() {
        return Optional.ofNullable(this.verify);
    }

    /**
     * Whether an AWS Payment Cryptography key can be used to wrap other keys.
     * 
     */
    @Import(name="wrap")
    private @Nullable Output<Boolean> wrap;

    /**
     * @return Whether an AWS Payment Cryptography key can be used to wrap other keys.
     * 
     */
    public Optional<Output<Boolean>> wrap() {
        return Optional.ofNullable(this.wrap);
    }

    private KeyKeyAttributesKeyModesOfUseArgs() {}

    private KeyKeyAttributesKeyModesOfUseArgs(KeyKeyAttributesKeyModesOfUseArgs $) {
        this.decrypt = $.decrypt;
        this.deriveKey = $.deriveKey;
        this.encrypt = $.encrypt;
        this.generate = $.generate;
        this.noRestrictions = $.noRestrictions;
        this.sign = $.sign;
        this.unwrap = $.unwrap;
        this.verify = $.verify;
        this.wrap = $.wrap;
    }

    public static Builder builder() {
        return new Builder();
    }
    public static Builder builder(KeyKeyAttributesKeyModesOfUseArgs defaults) {
        return new Builder(defaults);
    }

    public static final class Builder {
        private KeyKeyAttributesKeyModesOfUseArgs $;

        public Builder() {
            $ = new KeyKeyAttributesKeyModesOfUseArgs();
        }

        public Builder(KeyKeyAttributesKeyModesOfUseArgs defaults) {
            $ = new KeyKeyAttributesKeyModesOfUseArgs(Objects.requireNonNull(defaults));
        }

        /**
         * @param decrypt Whether an AWS Payment Cryptography key can be used to decrypt data.
         * 
         * @return builder
         * 
         */
        public Builder decrypt(@Nullable Output<Boolean> decrypt) {
            $.decrypt = decrypt;
            return this;
        }

        /**
         * @param decrypt Whether an AWS Payment Cryptography key can be used to decrypt data.
         * 
         * @return builder
         * 
         */
        public Builder decrypt(Boolean decrypt) {
            return decrypt(Output.of(decrypt));
        }

        /**
         * @param deriveKey Whether an AWS Payment Cryptography key can be used to derive new keys.
         * 
         * @return builder
         * 
         */
        public Builder deriveKey(@Nullable Output<Boolean> deriveKey) {
            $.deriveKey = deriveKey;
            return this;
        }

        /**
         * @param deriveKey Whether an AWS Payment Cryptography key can be used to derive new keys.
         * 
         * @return builder
         * 
         */
        public Builder deriveKey(Boolean deriveKey) {
            return deriveKey(Output.of(deriveKey));
        }

        /**
         * @param encrypt Whether an AWS Payment Cryptography key can be used to encrypt data.
         * 
         * @return builder
         * 
         */
        public Builder encrypt(@Nullable Output<Boolean> encrypt) {
            $.encrypt = encrypt;
            return this;
        }

        /**
         * @param encrypt Whether an AWS Payment Cryptography key can be used to encrypt data.
         * 
         * @return builder
         * 
         */
        public Builder encrypt(Boolean encrypt) {
            return encrypt(Output.of(encrypt));
        }

        /**
         * @param generate Whether an AWS Payment Cryptography key can be used to generate and verify other card and PIN verification keys.
         * 
         * @return builder
         * 
         */
        public Builder generate(@Nullable Output<Boolean> generate) {
            $.generate = generate;
            return this;
        }

        /**
         * @param generate Whether an AWS Payment Cryptography key can be used to generate and verify other card and PIN verification keys.
         * 
         * @return builder
         * 
         */
        public Builder generate(Boolean generate) {
            return generate(Output.of(generate));
        }

        /**
         * @param noRestrictions Whether an AWS Payment Cryptography key has no special restrictions other than the restrictions implied by KeyUsage.
         * 
         * @return builder
         * 
         */
        public Builder noRestrictions(@Nullable Output<Boolean> noRestrictions) {
            $.noRestrictions = noRestrictions;
            return this;
        }

        /**
         * @param noRestrictions Whether an AWS Payment Cryptography key has no special restrictions other than the restrictions implied by KeyUsage.
         * 
         * @return builder
         * 
         */
        public Builder noRestrictions(Boolean noRestrictions) {
            return noRestrictions(Output.of(noRestrictions));
        }

        /**
         * @param sign Whether an AWS Payment Cryptography key can be used for signing.
         * 
         * @return builder
         * 
         */
        public Builder sign(@Nullable Output<Boolean> sign) {
            $.sign = sign;
            return this;
        }

        /**
         * @param sign Whether an AWS Payment Cryptography key can be used for signing.
         * 
         * @return builder
         * 
         */
        public Builder sign(Boolean sign) {
            return sign(Output.of(sign));
        }

        /**
         * @param unwrap Whether an AWS Payment Cryptography key can be used to unwrap other keys.
         * 
         * @return builder
         * 
         */
        public Builder unwrap(@Nullable Output<Boolean> unwrap) {
            $.unwrap = unwrap;
            return this;
        }

        /**
         * @param unwrap Whether an AWS Payment Cryptography key can be used to unwrap other keys.
         * 
         * @return builder
         * 
         */
        public Builder unwrap(Boolean unwrap) {
            return unwrap(Output.of(unwrap));
        }

        /**
         * @param verify Whether an AWS Payment Cryptography key can be used to verify signatures.
         * 
         * @return builder
         * 
         */
        public Builder verify(@Nullable Output<Boolean> verify) {
            $.verify = verify;
            return this;
        }

        /**
         * @param verify Whether an AWS Payment Cryptography key can be used to verify signatures.
         * 
         * @return builder
         * 
         */
        public Builder verify(Boolean verify) {
            return verify(Output.of(verify));
        }

        /**
         * @param wrap Whether an AWS Payment Cryptography key can be used to wrap other keys.
         * 
         * @return builder
         * 
         */
        public Builder wrap(@Nullable Output<Boolean> wrap) {
            $.wrap = wrap;
            return this;
        }

        /**
         * @param wrap Whether an AWS Payment Cryptography key can be used to wrap other keys.
         * 
         * @return builder
         * 
         */
        public Builder wrap(Boolean wrap) {
            return wrap(Output.of(wrap));
        }

        public KeyKeyAttributesKeyModesOfUseArgs build() {
            return $;
        }
    }

}
