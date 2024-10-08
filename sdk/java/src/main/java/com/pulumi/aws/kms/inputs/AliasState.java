// *** WARNING: this file was generated by pulumi-java-gen. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

package com.pulumi.aws.kms.inputs;

import com.pulumi.core.Output;
import com.pulumi.core.annotations.Import;
import java.lang.String;
import java.util.Objects;
import java.util.Optional;
import javax.annotation.Nullable;


public final class AliasState extends com.pulumi.resources.ResourceArgs {

    public static final AliasState Empty = new AliasState();

    /**
     * The Amazon Resource Name (ARN) of the key alias.
     * 
     */
    @Import(name="arn")
    private @Nullable Output<String> arn;

    /**
     * @return The Amazon Resource Name (ARN) of the key alias.
     * 
     */
    public Optional<Output<String>> arn() {
        return Optional.ofNullable(this.arn);
    }

    /**
     * The display name of the alias. The name must start with the word &#34;alias&#34; followed by a forward slash (alias/)
     * 
     */
    @Import(name="name")
    private @Nullable Output<String> name;

    /**
     * @return The display name of the alias. The name must start with the word &#34;alias&#34; followed by a forward slash (alias/)
     * 
     */
    public Optional<Output<String>> name() {
        return Optional.ofNullable(this.name);
    }

    /**
     * Creates an unique alias beginning with the specified prefix.
     * The name must start with the word &#34;alias&#34; followed by a forward slash (alias/).  Conflicts with `name`.
     * 
     */
    @Import(name="namePrefix")
    private @Nullable Output<String> namePrefix;

    /**
     * @return Creates an unique alias beginning with the specified prefix.
     * The name must start with the word &#34;alias&#34; followed by a forward slash (alias/).  Conflicts with `name`.
     * 
     */
    public Optional<Output<String>> namePrefix() {
        return Optional.ofNullable(this.namePrefix);
    }

    /**
     * The Amazon Resource Name (ARN) of the target key identifier.
     * 
     */
    @Import(name="targetKeyArn")
    private @Nullable Output<String> targetKeyArn;

    /**
     * @return The Amazon Resource Name (ARN) of the target key identifier.
     * 
     */
    public Optional<Output<String>> targetKeyArn() {
        return Optional.ofNullable(this.targetKeyArn);
    }

    /**
     * Identifier for the key for which the alias is for, can be either an ARN or key_id.
     * 
     */
    @Import(name="targetKeyId")
    private @Nullable Output<String> targetKeyId;

    /**
     * @return Identifier for the key for which the alias is for, can be either an ARN or key_id.
     * 
     */
    public Optional<Output<String>> targetKeyId() {
        return Optional.ofNullable(this.targetKeyId);
    }

    private AliasState() {}

    private AliasState(AliasState $) {
        this.arn = $.arn;
        this.name = $.name;
        this.namePrefix = $.namePrefix;
        this.targetKeyArn = $.targetKeyArn;
        this.targetKeyId = $.targetKeyId;
    }

    public static Builder builder() {
        return new Builder();
    }
    public static Builder builder(AliasState defaults) {
        return new Builder(defaults);
    }

    public static final class Builder {
        private AliasState $;

        public Builder() {
            $ = new AliasState();
        }

        public Builder(AliasState defaults) {
            $ = new AliasState(Objects.requireNonNull(defaults));
        }

        /**
         * @param arn The Amazon Resource Name (ARN) of the key alias.
         * 
         * @return builder
         * 
         */
        public Builder arn(@Nullable Output<String> arn) {
            $.arn = arn;
            return this;
        }

        /**
         * @param arn The Amazon Resource Name (ARN) of the key alias.
         * 
         * @return builder
         * 
         */
        public Builder arn(String arn) {
            return arn(Output.of(arn));
        }

        /**
         * @param name The display name of the alias. The name must start with the word &#34;alias&#34; followed by a forward slash (alias/)
         * 
         * @return builder
         * 
         */
        public Builder name(@Nullable Output<String> name) {
            $.name = name;
            return this;
        }

        /**
         * @param name The display name of the alias. The name must start with the word &#34;alias&#34; followed by a forward slash (alias/)
         * 
         * @return builder
         * 
         */
        public Builder name(String name) {
            return name(Output.of(name));
        }

        /**
         * @param namePrefix Creates an unique alias beginning with the specified prefix.
         * The name must start with the word &#34;alias&#34; followed by a forward slash (alias/).  Conflicts with `name`.
         * 
         * @return builder
         * 
         */
        public Builder namePrefix(@Nullable Output<String> namePrefix) {
            $.namePrefix = namePrefix;
            return this;
        }

        /**
         * @param namePrefix Creates an unique alias beginning with the specified prefix.
         * The name must start with the word &#34;alias&#34; followed by a forward slash (alias/).  Conflicts with `name`.
         * 
         * @return builder
         * 
         */
        public Builder namePrefix(String namePrefix) {
            return namePrefix(Output.of(namePrefix));
        }

        /**
         * @param targetKeyArn The Amazon Resource Name (ARN) of the target key identifier.
         * 
         * @return builder
         * 
         */
        public Builder targetKeyArn(@Nullable Output<String> targetKeyArn) {
            $.targetKeyArn = targetKeyArn;
            return this;
        }

        /**
         * @param targetKeyArn The Amazon Resource Name (ARN) of the target key identifier.
         * 
         * @return builder
         * 
         */
        public Builder targetKeyArn(String targetKeyArn) {
            return targetKeyArn(Output.of(targetKeyArn));
        }

        /**
         * @param targetKeyId Identifier for the key for which the alias is for, can be either an ARN or key_id.
         * 
         * @return builder
         * 
         */
        public Builder targetKeyId(@Nullable Output<String> targetKeyId) {
            $.targetKeyId = targetKeyId;
            return this;
        }

        /**
         * @param targetKeyId Identifier for the key for which the alias is for, can be either an ARN or key_id.
         * 
         * @return builder
         * 
         */
        public Builder targetKeyId(String targetKeyId) {
            return targetKeyId(Output.of(targetKeyId));
        }

        public AliasState build() {
            return $;
        }
    }

}
