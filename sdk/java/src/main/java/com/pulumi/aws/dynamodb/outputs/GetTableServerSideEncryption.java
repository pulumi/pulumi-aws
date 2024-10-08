// *** WARNING: this file was generated by pulumi-java-gen. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

package com.pulumi.aws.dynamodb.outputs;

import com.pulumi.core.annotations.CustomType;
import com.pulumi.exceptions.MissingRequiredPropertyException;
import java.lang.Boolean;
import java.lang.String;
import java.util.Objects;

@CustomType
public final class GetTableServerSideEncryption {
    private Boolean enabled;
    private String kmsKeyArn;

    private GetTableServerSideEncryption() {}
    public Boolean enabled() {
        return this.enabled;
    }
    public String kmsKeyArn() {
        return this.kmsKeyArn;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static Builder builder(GetTableServerSideEncryption defaults) {
        return new Builder(defaults);
    }
    @CustomType.Builder
    public static final class Builder {
        private Boolean enabled;
        private String kmsKeyArn;
        public Builder() {}
        public Builder(GetTableServerSideEncryption defaults) {
    	      Objects.requireNonNull(defaults);
    	      this.enabled = defaults.enabled;
    	      this.kmsKeyArn = defaults.kmsKeyArn;
        }

        @CustomType.Setter
        public Builder enabled(Boolean enabled) {
            if (enabled == null) {
              throw new MissingRequiredPropertyException("GetTableServerSideEncryption", "enabled");
            }
            this.enabled = enabled;
            return this;
        }
        @CustomType.Setter
        public Builder kmsKeyArn(String kmsKeyArn) {
            if (kmsKeyArn == null) {
              throw new MissingRequiredPropertyException("GetTableServerSideEncryption", "kmsKeyArn");
            }
            this.kmsKeyArn = kmsKeyArn;
            return this;
        }
        public GetTableServerSideEncryption build() {
            final var _resultValue = new GetTableServerSideEncryption();
            _resultValue.enabled = enabled;
            _resultValue.kmsKeyArn = kmsKeyArn;
            return _resultValue;
        }
    }
}
