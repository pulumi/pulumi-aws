// *** WARNING: this file was generated by pulumi-java-gen. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

package com.pulumi.aws.redshift.inputs;

import com.pulumi.aws.redshift.inputs.GetDataSharesDataShareArgs;
import com.pulumi.core.Output;
import com.pulumi.core.annotations.Import;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import javax.annotation.Nullable;


public final class GetDataSharesArgs extends com.pulumi.resources.InvokeArgs {

    public static final GetDataSharesArgs Empty = new GetDataSharesArgs();

    /**
     * An array of all data shares in the current region. See `data_shares` below.
     * 
     */
    @Import(name="dataShares")
    private @Nullable Output<List<GetDataSharesDataShareArgs>> dataShares;

    /**
     * @return An array of all data shares in the current region. See `data_shares` below.
     * 
     */
    public Optional<Output<List<GetDataSharesDataShareArgs>>> dataShares() {
        return Optional.ofNullable(this.dataShares);
    }

    private GetDataSharesArgs() {}

    private GetDataSharesArgs(GetDataSharesArgs $) {
        this.dataShares = $.dataShares;
    }

    public static Builder builder() {
        return new Builder();
    }
    public static Builder builder(GetDataSharesArgs defaults) {
        return new Builder(defaults);
    }

    public static final class Builder {
        private GetDataSharesArgs $;

        public Builder() {
            $ = new GetDataSharesArgs();
        }

        public Builder(GetDataSharesArgs defaults) {
            $ = new GetDataSharesArgs(Objects.requireNonNull(defaults));
        }

        /**
         * @param dataShares An array of all data shares in the current region. See `data_shares` below.
         * 
         * @return builder
         * 
         */
        public Builder dataShares(@Nullable Output<List<GetDataSharesDataShareArgs>> dataShares) {
            $.dataShares = dataShares;
            return this;
        }

        /**
         * @param dataShares An array of all data shares in the current region. See `data_shares` below.
         * 
         * @return builder
         * 
         */
        public Builder dataShares(List<GetDataSharesDataShareArgs> dataShares) {
            return dataShares(Output.of(dataShares));
        }

        /**
         * @param dataShares An array of all data shares in the current region. See `data_shares` below.
         * 
         * @return builder
         * 
         */
        public Builder dataShares(GetDataSharesDataShareArgs... dataShares) {
            return dataShares(List.of(dataShares));
        }

        public GetDataSharesArgs build() {
            return $;
        }
    }

}
