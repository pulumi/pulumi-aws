// *** WARNING: this file was generated by pulumi-java-gen. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

package com.pulumi.aws.redshift.inputs;

import com.pulumi.core.Output;
import com.pulumi.core.annotations.Import;
import java.lang.Boolean;
import java.lang.String;
import java.util.Objects;
import java.util.Optional;
import javax.annotation.Nullable;


public final class DataShareAuthorizationState extends com.pulumi.resources.ResourceArgs {

    public static final DataShareAuthorizationState Empty = new DataShareAuthorizationState();

    /**
     * Whether to allow write operations for a datashare.
     * 
     */
    @Import(name="allowWrites")
    private @Nullable Output<Boolean> allowWrites;

    /**
     * @return Whether to allow write operations for a datashare.
     * 
     */
    public Optional<Output<Boolean>> allowWrites() {
        return Optional.ofNullable(this.allowWrites);
    }

    /**
     * Identifier of the data consumer that is authorized to access the datashare. This identifier is an AWS account ID or a keyword, such as `ADX`.
     * 
     */
    @Import(name="consumerIdentifier")
    private @Nullable Output<String> consumerIdentifier;

    /**
     * @return Identifier of the data consumer that is authorized to access the datashare. This identifier is an AWS account ID or a keyword, such as `ADX`.
     * 
     */
    public Optional<Output<String>> consumerIdentifier() {
        return Optional.ofNullable(this.consumerIdentifier);
    }

    /**
     * Amazon Resource Name (ARN) of the datashare that producers are to authorize sharing for.
     * 
     * The following arguments are optional:
     * 
     */
    @Import(name="dataShareArn")
    private @Nullable Output<String> dataShareArn;

    /**
     * @return Amazon Resource Name (ARN) of the datashare that producers are to authorize sharing for.
     * 
     * The following arguments are optional:
     * 
     */
    public Optional<Output<String>> dataShareArn() {
        return Optional.ofNullable(this.dataShareArn);
    }

    /**
     * Identifier of a datashare to show its managing entity.
     * 
     */
    @Import(name="managedBy")
    private @Nullable Output<String> managedBy;

    /**
     * @return Identifier of a datashare to show its managing entity.
     * 
     */
    public Optional<Output<String>> managedBy() {
        return Optional.ofNullable(this.managedBy);
    }

    /**
     * Amazon Resource Name (ARN) of the producer.
     * 
     */
    @Import(name="producerArn")
    private @Nullable Output<String> producerArn;

    /**
     * @return Amazon Resource Name (ARN) of the producer.
     * 
     */
    public Optional<Output<String>> producerArn() {
        return Optional.ofNullable(this.producerArn);
    }

    private DataShareAuthorizationState() {}

    private DataShareAuthorizationState(DataShareAuthorizationState $) {
        this.allowWrites = $.allowWrites;
        this.consumerIdentifier = $.consumerIdentifier;
        this.dataShareArn = $.dataShareArn;
        this.managedBy = $.managedBy;
        this.producerArn = $.producerArn;
    }

    public static Builder builder() {
        return new Builder();
    }
    public static Builder builder(DataShareAuthorizationState defaults) {
        return new Builder(defaults);
    }

    public static final class Builder {
        private DataShareAuthorizationState $;

        public Builder() {
            $ = new DataShareAuthorizationState();
        }

        public Builder(DataShareAuthorizationState defaults) {
            $ = new DataShareAuthorizationState(Objects.requireNonNull(defaults));
        }

        /**
         * @param allowWrites Whether to allow write operations for a datashare.
         * 
         * @return builder
         * 
         */
        public Builder allowWrites(@Nullable Output<Boolean> allowWrites) {
            $.allowWrites = allowWrites;
            return this;
        }

        /**
         * @param allowWrites Whether to allow write operations for a datashare.
         * 
         * @return builder
         * 
         */
        public Builder allowWrites(Boolean allowWrites) {
            return allowWrites(Output.of(allowWrites));
        }

        /**
         * @param consumerIdentifier Identifier of the data consumer that is authorized to access the datashare. This identifier is an AWS account ID or a keyword, such as `ADX`.
         * 
         * @return builder
         * 
         */
        public Builder consumerIdentifier(@Nullable Output<String> consumerIdentifier) {
            $.consumerIdentifier = consumerIdentifier;
            return this;
        }

        /**
         * @param consumerIdentifier Identifier of the data consumer that is authorized to access the datashare. This identifier is an AWS account ID or a keyword, such as `ADX`.
         * 
         * @return builder
         * 
         */
        public Builder consumerIdentifier(String consumerIdentifier) {
            return consumerIdentifier(Output.of(consumerIdentifier));
        }

        /**
         * @param dataShareArn Amazon Resource Name (ARN) of the datashare that producers are to authorize sharing for.
         * 
         * The following arguments are optional:
         * 
         * @return builder
         * 
         */
        public Builder dataShareArn(@Nullable Output<String> dataShareArn) {
            $.dataShareArn = dataShareArn;
            return this;
        }

        /**
         * @param dataShareArn Amazon Resource Name (ARN) of the datashare that producers are to authorize sharing for.
         * 
         * The following arguments are optional:
         * 
         * @return builder
         * 
         */
        public Builder dataShareArn(String dataShareArn) {
            return dataShareArn(Output.of(dataShareArn));
        }

        /**
         * @param managedBy Identifier of a datashare to show its managing entity.
         * 
         * @return builder
         * 
         */
        public Builder managedBy(@Nullable Output<String> managedBy) {
            $.managedBy = managedBy;
            return this;
        }

        /**
         * @param managedBy Identifier of a datashare to show its managing entity.
         * 
         * @return builder
         * 
         */
        public Builder managedBy(String managedBy) {
            return managedBy(Output.of(managedBy));
        }

        /**
         * @param producerArn Amazon Resource Name (ARN) of the producer.
         * 
         * @return builder
         * 
         */
        public Builder producerArn(@Nullable Output<String> producerArn) {
            $.producerArn = producerArn;
            return this;
        }

        /**
         * @param producerArn Amazon Resource Name (ARN) of the producer.
         * 
         * @return builder
         * 
         */
        public Builder producerArn(String producerArn) {
            return producerArn(Output.of(producerArn));
        }

        public DataShareAuthorizationState build() {
            return $;
        }
    }

}
