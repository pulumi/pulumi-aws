// *** WARNING: this file was generated by pulumi-java-gen. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

package com.pulumi.aws.pipes.inputs;

import com.pulumi.aws.pipes.inputs.PipeEnrichmentParametersArgs;
import com.pulumi.aws.pipes.inputs.PipeLogConfigurationArgs;
import com.pulumi.aws.pipes.inputs.PipeSourceParametersArgs;
import com.pulumi.aws.pipes.inputs.PipeTargetParametersArgs;
import com.pulumi.core.Output;
import com.pulumi.core.annotations.Import;
import java.lang.String;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import javax.annotation.Nullable;


public final class PipeState extends com.pulumi.resources.ResourceArgs {

    public static final PipeState Empty = new PipeState();

    /**
     * ARN of this pipe.
     * 
     */
    @Import(name="arn")
    private @Nullable Output<String> arn;

    /**
     * @return ARN of this pipe.
     * 
     */
    public Optional<Output<String>> arn() {
        return Optional.ofNullable(this.arn);
    }

    /**
     * A description of the pipe. At most 512 characters.
     * 
     */
    @Import(name="description")
    private @Nullable Output<String> description;

    /**
     * @return A description of the pipe. At most 512 characters.
     * 
     */
    public Optional<Output<String>> description() {
        return Optional.ofNullable(this.description);
    }

    /**
     * The state the pipe should be in. One of: `RUNNING`, `STOPPED`.
     * 
     */
    @Import(name="desiredState")
    private @Nullable Output<String> desiredState;

    /**
     * @return The state the pipe should be in. One of: `RUNNING`, `STOPPED`.
     * 
     */
    public Optional<Output<String>> desiredState() {
        return Optional.ofNullable(this.desiredState);
    }

    /**
     * Enrichment resource of the pipe (typically an ARN). Read more about enrichment in the [User Guide](https://docs.aws.amazon.com/eventbridge/latest/userguide/eb-pipes.html#pipes-enrichment).
     * 
     */
    @Import(name="enrichment")
    private @Nullable Output<String> enrichment;

    /**
     * @return Enrichment resource of the pipe (typically an ARN). Read more about enrichment in the [User Guide](https://docs.aws.amazon.com/eventbridge/latest/userguide/eb-pipes.html#pipes-enrichment).
     * 
     */
    public Optional<Output<String>> enrichment() {
        return Optional.ofNullable(this.enrichment);
    }

    /**
     * Parameters to configure enrichment for your pipe. Detailed below.
     * 
     */
    @Import(name="enrichmentParameters")
    private @Nullable Output<PipeEnrichmentParametersArgs> enrichmentParameters;

    /**
     * @return Parameters to configure enrichment for your pipe. Detailed below.
     * 
     */
    public Optional<Output<PipeEnrichmentParametersArgs>> enrichmentParameters() {
        return Optional.ofNullable(this.enrichmentParameters);
    }

    /**
     * Identifier of the AWS KMS customer managed key for EventBridge to use, if you choose to use a customer managed key to encrypt pipe data. The identifier can be the key Amazon Resource Name (ARN), KeyId, key alias, or key alias ARN. If not set, EventBridge uses an AWS owned key to encrypt pipe data.
     * 
     */
    @Import(name="kmsKeyIdentifier")
    private @Nullable Output<String> kmsKeyIdentifier;

    /**
     * @return Identifier of the AWS KMS customer managed key for EventBridge to use, if you choose to use a customer managed key to encrypt pipe data. The identifier can be the key Amazon Resource Name (ARN), KeyId, key alias, or key alias ARN. If not set, EventBridge uses an AWS owned key to encrypt pipe data.
     * 
     */
    public Optional<Output<String>> kmsKeyIdentifier() {
        return Optional.ofNullable(this.kmsKeyIdentifier);
    }

    /**
     * Logging configuration settings for the pipe. Detailed below.
     * 
     */
    @Import(name="logConfiguration")
    private @Nullable Output<PipeLogConfigurationArgs> logConfiguration;

    /**
     * @return Logging configuration settings for the pipe. Detailed below.
     * 
     */
    public Optional<Output<PipeLogConfigurationArgs>> logConfiguration() {
        return Optional.ofNullable(this.logConfiguration);
    }

    /**
     * Name of the pipe. If omitted, the provider will assign a random, unique name. Conflicts with `name_prefix`.
     * 
     */
    @Import(name="name")
    private @Nullable Output<String> name;

    /**
     * @return Name of the pipe. If omitted, the provider will assign a random, unique name. Conflicts with `name_prefix`.
     * 
     */
    public Optional<Output<String>> name() {
        return Optional.ofNullable(this.name);
    }

    /**
     * Creates a unique name beginning with the specified prefix. Conflicts with `name`.
     * 
     */
    @Import(name="namePrefix")
    private @Nullable Output<String> namePrefix;

    /**
     * @return Creates a unique name beginning with the specified prefix. Conflicts with `name`.
     * 
     */
    public Optional<Output<String>> namePrefix() {
        return Optional.ofNullable(this.namePrefix);
    }

    /**
     * ARN of the role that allows the pipe to send data to the target.
     * 
     */
    @Import(name="roleArn")
    private @Nullable Output<String> roleArn;

    /**
     * @return ARN of the role that allows the pipe to send data to the target.
     * 
     */
    public Optional<Output<String>> roleArn() {
        return Optional.ofNullable(this.roleArn);
    }

    /**
     * Source resource of the pipe. This field typically requires an ARN (Amazon Resource Name). However, when using a self-managed Kafka cluster, you should use a different format. Instead of an ARN, use &#39;smk://&#39; followed by the bootstrap server&#39;s address.
     * 
     */
    @Import(name="source")
    private @Nullable Output<String> source;

    /**
     * @return Source resource of the pipe. This field typically requires an ARN (Amazon Resource Name). However, when using a self-managed Kafka cluster, you should use a different format. Instead of an ARN, use &#39;smk://&#39; followed by the bootstrap server&#39;s address.
     * 
     */
    public Optional<Output<String>> source() {
        return Optional.ofNullable(this.source);
    }

    /**
     * Parameters to configure a source for the pipe. Detailed below.
     * 
     */
    @Import(name="sourceParameters")
    private @Nullable Output<PipeSourceParametersArgs> sourceParameters;

    /**
     * @return Parameters to configure a source for the pipe. Detailed below.
     * 
     */
    public Optional<Output<PipeSourceParametersArgs>> sourceParameters() {
        return Optional.ofNullable(this.sourceParameters);
    }

    /**
     * Key-value mapping of resource tags. If configured with a provider `default_tags` configuration block present, tags with matching keys will overwrite those defined at the provider-level.
     * 
     */
    @Import(name="tags")
    private @Nullable Output<Map<String,String>> tags;

    /**
     * @return Key-value mapping of resource tags. If configured with a provider `default_tags` configuration block present, tags with matching keys will overwrite those defined at the provider-level.
     * 
     */
    public Optional<Output<Map<String,String>>> tags() {
        return Optional.ofNullable(this.tags);
    }

    /**
     * Map of tags assigned to the resource, including those inherited from the provider `default_tags` configuration block.
     * 
     * @deprecated
     * Please use `tags` instead.
     * 
     */
    @Deprecated /* Please use `tags` instead. */
    @Import(name="tagsAll")
    private @Nullable Output<Map<String,String>> tagsAll;

    /**
     * @return Map of tags assigned to the resource, including those inherited from the provider `default_tags` configuration block.
     * 
     * @deprecated
     * Please use `tags` instead.
     * 
     */
    @Deprecated /* Please use `tags` instead. */
    public Optional<Output<Map<String,String>>> tagsAll() {
        return Optional.ofNullable(this.tagsAll);
    }

    /**
     * Target resource of the pipe (typically an ARN).
     * 
     * The following arguments are optional:
     * 
     */
    @Import(name="target")
    private @Nullable Output<String> target;

    /**
     * @return Target resource of the pipe (typically an ARN).
     * 
     * The following arguments are optional:
     * 
     */
    public Optional<Output<String>> target() {
        return Optional.ofNullable(this.target);
    }

    /**
     * Parameters to configure a target for your pipe. Detailed below.
     * 
     */
    @Import(name="targetParameters")
    private @Nullable Output<PipeTargetParametersArgs> targetParameters;

    /**
     * @return Parameters to configure a target for your pipe. Detailed below.
     * 
     */
    public Optional<Output<PipeTargetParametersArgs>> targetParameters() {
        return Optional.ofNullable(this.targetParameters);
    }

    private PipeState() {}

    private PipeState(PipeState $) {
        this.arn = $.arn;
        this.description = $.description;
        this.desiredState = $.desiredState;
        this.enrichment = $.enrichment;
        this.enrichmentParameters = $.enrichmentParameters;
        this.kmsKeyIdentifier = $.kmsKeyIdentifier;
        this.logConfiguration = $.logConfiguration;
        this.name = $.name;
        this.namePrefix = $.namePrefix;
        this.roleArn = $.roleArn;
        this.source = $.source;
        this.sourceParameters = $.sourceParameters;
        this.tags = $.tags;
        this.tagsAll = $.tagsAll;
        this.target = $.target;
        this.targetParameters = $.targetParameters;
    }

    public static Builder builder() {
        return new Builder();
    }
    public static Builder builder(PipeState defaults) {
        return new Builder(defaults);
    }

    public static final class Builder {
        private PipeState $;

        public Builder() {
            $ = new PipeState();
        }

        public Builder(PipeState defaults) {
            $ = new PipeState(Objects.requireNonNull(defaults));
        }

        /**
         * @param arn ARN of this pipe.
         * 
         * @return builder
         * 
         */
        public Builder arn(@Nullable Output<String> arn) {
            $.arn = arn;
            return this;
        }

        /**
         * @param arn ARN of this pipe.
         * 
         * @return builder
         * 
         */
        public Builder arn(String arn) {
            return arn(Output.of(arn));
        }

        /**
         * @param description A description of the pipe. At most 512 characters.
         * 
         * @return builder
         * 
         */
        public Builder description(@Nullable Output<String> description) {
            $.description = description;
            return this;
        }

        /**
         * @param description A description of the pipe. At most 512 characters.
         * 
         * @return builder
         * 
         */
        public Builder description(String description) {
            return description(Output.of(description));
        }

        /**
         * @param desiredState The state the pipe should be in. One of: `RUNNING`, `STOPPED`.
         * 
         * @return builder
         * 
         */
        public Builder desiredState(@Nullable Output<String> desiredState) {
            $.desiredState = desiredState;
            return this;
        }

        /**
         * @param desiredState The state the pipe should be in. One of: `RUNNING`, `STOPPED`.
         * 
         * @return builder
         * 
         */
        public Builder desiredState(String desiredState) {
            return desiredState(Output.of(desiredState));
        }

        /**
         * @param enrichment Enrichment resource of the pipe (typically an ARN). Read more about enrichment in the [User Guide](https://docs.aws.amazon.com/eventbridge/latest/userguide/eb-pipes.html#pipes-enrichment).
         * 
         * @return builder
         * 
         */
        public Builder enrichment(@Nullable Output<String> enrichment) {
            $.enrichment = enrichment;
            return this;
        }

        /**
         * @param enrichment Enrichment resource of the pipe (typically an ARN). Read more about enrichment in the [User Guide](https://docs.aws.amazon.com/eventbridge/latest/userguide/eb-pipes.html#pipes-enrichment).
         * 
         * @return builder
         * 
         */
        public Builder enrichment(String enrichment) {
            return enrichment(Output.of(enrichment));
        }

        /**
         * @param enrichmentParameters Parameters to configure enrichment for your pipe. Detailed below.
         * 
         * @return builder
         * 
         */
        public Builder enrichmentParameters(@Nullable Output<PipeEnrichmentParametersArgs> enrichmentParameters) {
            $.enrichmentParameters = enrichmentParameters;
            return this;
        }

        /**
         * @param enrichmentParameters Parameters to configure enrichment for your pipe. Detailed below.
         * 
         * @return builder
         * 
         */
        public Builder enrichmentParameters(PipeEnrichmentParametersArgs enrichmentParameters) {
            return enrichmentParameters(Output.of(enrichmentParameters));
        }

        /**
         * @param kmsKeyIdentifier Identifier of the AWS KMS customer managed key for EventBridge to use, if you choose to use a customer managed key to encrypt pipe data. The identifier can be the key Amazon Resource Name (ARN), KeyId, key alias, or key alias ARN. If not set, EventBridge uses an AWS owned key to encrypt pipe data.
         * 
         * @return builder
         * 
         */
        public Builder kmsKeyIdentifier(@Nullable Output<String> kmsKeyIdentifier) {
            $.kmsKeyIdentifier = kmsKeyIdentifier;
            return this;
        }

        /**
         * @param kmsKeyIdentifier Identifier of the AWS KMS customer managed key for EventBridge to use, if you choose to use a customer managed key to encrypt pipe data. The identifier can be the key Amazon Resource Name (ARN), KeyId, key alias, or key alias ARN. If not set, EventBridge uses an AWS owned key to encrypt pipe data.
         * 
         * @return builder
         * 
         */
        public Builder kmsKeyIdentifier(String kmsKeyIdentifier) {
            return kmsKeyIdentifier(Output.of(kmsKeyIdentifier));
        }

        /**
         * @param logConfiguration Logging configuration settings for the pipe. Detailed below.
         * 
         * @return builder
         * 
         */
        public Builder logConfiguration(@Nullable Output<PipeLogConfigurationArgs> logConfiguration) {
            $.logConfiguration = logConfiguration;
            return this;
        }

        /**
         * @param logConfiguration Logging configuration settings for the pipe. Detailed below.
         * 
         * @return builder
         * 
         */
        public Builder logConfiguration(PipeLogConfigurationArgs logConfiguration) {
            return logConfiguration(Output.of(logConfiguration));
        }

        /**
         * @param name Name of the pipe. If omitted, the provider will assign a random, unique name. Conflicts with `name_prefix`.
         * 
         * @return builder
         * 
         */
        public Builder name(@Nullable Output<String> name) {
            $.name = name;
            return this;
        }

        /**
         * @param name Name of the pipe. If omitted, the provider will assign a random, unique name. Conflicts with `name_prefix`.
         * 
         * @return builder
         * 
         */
        public Builder name(String name) {
            return name(Output.of(name));
        }

        /**
         * @param namePrefix Creates a unique name beginning with the specified prefix. Conflicts with `name`.
         * 
         * @return builder
         * 
         */
        public Builder namePrefix(@Nullable Output<String> namePrefix) {
            $.namePrefix = namePrefix;
            return this;
        }

        /**
         * @param namePrefix Creates a unique name beginning with the specified prefix. Conflicts with `name`.
         * 
         * @return builder
         * 
         */
        public Builder namePrefix(String namePrefix) {
            return namePrefix(Output.of(namePrefix));
        }

        /**
         * @param roleArn ARN of the role that allows the pipe to send data to the target.
         * 
         * @return builder
         * 
         */
        public Builder roleArn(@Nullable Output<String> roleArn) {
            $.roleArn = roleArn;
            return this;
        }

        /**
         * @param roleArn ARN of the role that allows the pipe to send data to the target.
         * 
         * @return builder
         * 
         */
        public Builder roleArn(String roleArn) {
            return roleArn(Output.of(roleArn));
        }

        /**
         * @param source Source resource of the pipe. This field typically requires an ARN (Amazon Resource Name). However, when using a self-managed Kafka cluster, you should use a different format. Instead of an ARN, use &#39;smk://&#39; followed by the bootstrap server&#39;s address.
         * 
         * @return builder
         * 
         */
        public Builder source(@Nullable Output<String> source) {
            $.source = source;
            return this;
        }

        /**
         * @param source Source resource of the pipe. This field typically requires an ARN (Amazon Resource Name). However, when using a self-managed Kafka cluster, you should use a different format. Instead of an ARN, use &#39;smk://&#39; followed by the bootstrap server&#39;s address.
         * 
         * @return builder
         * 
         */
        public Builder source(String source) {
            return source(Output.of(source));
        }

        /**
         * @param sourceParameters Parameters to configure a source for the pipe. Detailed below.
         * 
         * @return builder
         * 
         */
        public Builder sourceParameters(@Nullable Output<PipeSourceParametersArgs> sourceParameters) {
            $.sourceParameters = sourceParameters;
            return this;
        }

        /**
         * @param sourceParameters Parameters to configure a source for the pipe. Detailed below.
         * 
         * @return builder
         * 
         */
        public Builder sourceParameters(PipeSourceParametersArgs sourceParameters) {
            return sourceParameters(Output.of(sourceParameters));
        }

        /**
         * @param tags Key-value mapping of resource tags. If configured with a provider `default_tags` configuration block present, tags with matching keys will overwrite those defined at the provider-level.
         * 
         * @return builder
         * 
         */
        public Builder tags(@Nullable Output<Map<String,String>> tags) {
            $.tags = tags;
            return this;
        }

        /**
         * @param tags Key-value mapping of resource tags. If configured with a provider `default_tags` configuration block present, tags with matching keys will overwrite those defined at the provider-level.
         * 
         * @return builder
         * 
         */
        public Builder tags(Map<String,String> tags) {
            return tags(Output.of(tags));
        }

        /**
         * @param tagsAll Map of tags assigned to the resource, including those inherited from the provider `default_tags` configuration block.
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
         * @param tagsAll Map of tags assigned to the resource, including those inherited from the provider `default_tags` configuration block.
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

        /**
         * @param target Target resource of the pipe (typically an ARN).
         * 
         * The following arguments are optional:
         * 
         * @return builder
         * 
         */
        public Builder target(@Nullable Output<String> target) {
            $.target = target;
            return this;
        }

        /**
         * @param target Target resource of the pipe (typically an ARN).
         * 
         * The following arguments are optional:
         * 
         * @return builder
         * 
         */
        public Builder target(String target) {
            return target(Output.of(target));
        }

        /**
         * @param targetParameters Parameters to configure a target for your pipe. Detailed below.
         * 
         * @return builder
         * 
         */
        public Builder targetParameters(@Nullable Output<PipeTargetParametersArgs> targetParameters) {
            $.targetParameters = targetParameters;
            return this;
        }

        /**
         * @param targetParameters Parameters to configure a target for your pipe. Detailed below.
         * 
         * @return builder
         * 
         */
        public Builder targetParameters(PipeTargetParametersArgs targetParameters) {
            return targetParameters(Output.of(targetParameters));
        }

        public PipeState build() {
            return $;
        }
    }

}
