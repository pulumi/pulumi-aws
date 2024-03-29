// *** WARNING: this file was generated by pulumi-java-gen. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

package com.pulumi.aws.redshift.outputs;

import com.pulumi.aws.redshift.outputs.GetProducerDataSharesDataShare;
import com.pulumi.core.annotations.CustomType;
import com.pulumi.exceptions.MissingRequiredPropertyException;
import java.lang.String;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import javax.annotation.Nullable;

@CustomType
public final class GetProducerDataSharesResult {
    /**
     * @return An array of all data shares in the producer. See `data_shares` below.
     * 
     */
    private @Nullable List<GetProducerDataSharesDataShare> dataShares;
    /**
     * @return Producer ARN.
     * 
     */
    private String id;
    /**
     * @return ARN (Amazon Resource Name) of the producer.
     * 
     */
    private String producerArn;
    private @Nullable String status;

    private GetProducerDataSharesResult() {}
    /**
     * @return An array of all data shares in the producer. See `data_shares` below.
     * 
     */
    public List<GetProducerDataSharesDataShare> dataShares() {
        return this.dataShares == null ? List.of() : this.dataShares;
    }
    /**
     * @return Producer ARN.
     * 
     */
    public String id() {
        return this.id;
    }
    /**
     * @return ARN (Amazon Resource Name) of the producer.
     * 
     */
    public String producerArn() {
        return this.producerArn;
    }
    public Optional<String> status() {
        return Optional.ofNullable(this.status);
    }

    public static Builder builder() {
        return new Builder();
    }

    public static Builder builder(GetProducerDataSharesResult defaults) {
        return new Builder(defaults);
    }
    @CustomType.Builder
    public static final class Builder {
        private @Nullable List<GetProducerDataSharesDataShare> dataShares;
        private String id;
        private String producerArn;
        private @Nullable String status;
        public Builder() {}
        public Builder(GetProducerDataSharesResult defaults) {
    	      Objects.requireNonNull(defaults);
    	      this.dataShares = defaults.dataShares;
    	      this.id = defaults.id;
    	      this.producerArn = defaults.producerArn;
    	      this.status = defaults.status;
        }

        @CustomType.Setter
        public Builder dataShares(@Nullable List<GetProducerDataSharesDataShare> dataShares) {

            this.dataShares = dataShares;
            return this;
        }
        public Builder dataShares(GetProducerDataSharesDataShare... dataShares) {
            return dataShares(List.of(dataShares));
        }
        @CustomType.Setter
        public Builder id(String id) {
            if (id == null) {
              throw new MissingRequiredPropertyException("GetProducerDataSharesResult", "id");
            }
            this.id = id;
            return this;
        }
        @CustomType.Setter
        public Builder producerArn(String producerArn) {
            if (producerArn == null) {
              throw new MissingRequiredPropertyException("GetProducerDataSharesResult", "producerArn");
            }
            this.producerArn = producerArn;
            return this;
        }
        @CustomType.Setter
        public Builder status(@Nullable String status) {

            this.status = status;
            return this;
        }
        public GetProducerDataSharesResult build() {
            final var _resultValue = new GetProducerDataSharesResult();
            _resultValue.dataShares = dataShares;
            _resultValue.id = id;
            _resultValue.producerArn = producerArn;
            _resultValue.status = status;
            return _resultValue;
        }
    }
}
