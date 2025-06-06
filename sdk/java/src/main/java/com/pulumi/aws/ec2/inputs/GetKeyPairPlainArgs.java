// *** WARNING: this file was generated by pulumi-java-gen. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

package com.pulumi.aws.ec2.inputs;

import com.pulumi.aws.ec2.inputs.GetKeyPairFilter;
import com.pulumi.core.annotations.Import;
import java.lang.Boolean;
import java.lang.String;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import javax.annotation.Nullable;


public final class GetKeyPairPlainArgs extends com.pulumi.resources.InvokeArgs {

    public static final GetKeyPairPlainArgs Empty = new GetKeyPairPlainArgs();

    /**
     * Custom filter block as described below.
     * 
     * The arguments of this data source act as filters for querying the available
     * Key Pairs. The given filters must match exactly one Key Pair
     * whose data will be exported as attributes.
     * 
     */
    @Import(name="filters")
    private @Nullable List<GetKeyPairFilter> filters;

    /**
     * @return Custom filter block as described below.
     * 
     * The arguments of this data source act as filters for querying the available
     * Key Pairs. The given filters must match exactly one Key Pair
     * whose data will be exported as attributes.
     * 
     */
    public Optional<List<GetKeyPairFilter>> filters() {
        return Optional.ofNullable(this.filters);
    }

    /**
     * Whether to include the public key material in the response.
     * 
     */
    @Import(name="includePublicKey")
    private @Nullable Boolean includePublicKey;

    /**
     * @return Whether to include the public key material in the response.
     * 
     */
    public Optional<Boolean> includePublicKey() {
        return Optional.ofNullable(this.includePublicKey);
    }

    /**
     * Key Pair name.
     * 
     */
    @Import(name="keyName")
    private @Nullable String keyName;

    /**
     * @return Key Pair name.
     * 
     */
    public Optional<String> keyName() {
        return Optional.ofNullable(this.keyName);
    }

    /**
     * Key Pair ID.
     * 
     */
    @Import(name="keyPairId")
    private @Nullable String keyPairId;

    /**
     * @return Key Pair ID.
     * 
     */
    public Optional<String> keyPairId() {
        return Optional.ofNullable(this.keyPairId);
    }

    /**
     * Any tags assigned to the Key Pair.
     * 
     */
    @Import(name="tags")
    private @Nullable Map<String,String> tags;

    /**
     * @return Any tags assigned to the Key Pair.
     * 
     */
    public Optional<Map<String,String>> tags() {
        return Optional.ofNullable(this.tags);
    }

    private GetKeyPairPlainArgs() {}

    private GetKeyPairPlainArgs(GetKeyPairPlainArgs $) {
        this.filters = $.filters;
        this.includePublicKey = $.includePublicKey;
        this.keyName = $.keyName;
        this.keyPairId = $.keyPairId;
        this.tags = $.tags;
    }

    public static Builder builder() {
        return new Builder();
    }
    public static Builder builder(GetKeyPairPlainArgs defaults) {
        return new Builder(defaults);
    }

    public static final class Builder {
        private GetKeyPairPlainArgs $;

        public Builder() {
            $ = new GetKeyPairPlainArgs();
        }

        public Builder(GetKeyPairPlainArgs defaults) {
            $ = new GetKeyPairPlainArgs(Objects.requireNonNull(defaults));
        }

        /**
         * @param filters Custom filter block as described below.
         * 
         * The arguments of this data source act as filters for querying the available
         * Key Pairs. The given filters must match exactly one Key Pair
         * whose data will be exported as attributes.
         * 
         * @return builder
         * 
         */
        public Builder filters(@Nullable List<GetKeyPairFilter> filters) {
            $.filters = filters;
            return this;
        }

        /**
         * @param filters Custom filter block as described below.
         * 
         * The arguments of this data source act as filters for querying the available
         * Key Pairs. The given filters must match exactly one Key Pair
         * whose data will be exported as attributes.
         * 
         * @return builder
         * 
         */
        public Builder filters(GetKeyPairFilter... filters) {
            return filters(List.of(filters));
        }

        /**
         * @param includePublicKey Whether to include the public key material in the response.
         * 
         * @return builder
         * 
         */
        public Builder includePublicKey(@Nullable Boolean includePublicKey) {
            $.includePublicKey = includePublicKey;
            return this;
        }

        /**
         * @param keyName Key Pair name.
         * 
         * @return builder
         * 
         */
        public Builder keyName(@Nullable String keyName) {
            $.keyName = keyName;
            return this;
        }

        /**
         * @param keyPairId Key Pair ID.
         * 
         * @return builder
         * 
         */
        public Builder keyPairId(@Nullable String keyPairId) {
            $.keyPairId = keyPairId;
            return this;
        }

        /**
         * @param tags Any tags assigned to the Key Pair.
         * 
         * @return builder
         * 
         */
        public Builder tags(@Nullable Map<String,String> tags) {
            $.tags = tags;
            return this;
        }

        public GetKeyPairPlainArgs build() {
            return $;
        }
    }

}
