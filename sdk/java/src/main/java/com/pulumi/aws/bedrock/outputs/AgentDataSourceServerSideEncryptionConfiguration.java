// *** WARNING: this file was generated by pulumi-java-gen. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

package com.pulumi.aws.bedrock.outputs;

import com.pulumi.core.annotations.CustomType;
import java.lang.String;
import java.util.Objects;
import java.util.Optional;
import javax.annotation.Nullable;

@CustomType
public final class AgentDataSourceServerSideEncryptionConfiguration {
    /**
     * @return ARN of the AWS KMS key used to encrypt the resource.
     * 
     */
    private @Nullable String kmsKeyArn;

    private AgentDataSourceServerSideEncryptionConfiguration() {}
    /**
     * @return ARN of the AWS KMS key used to encrypt the resource.
     * 
     */
    public Optional<String> kmsKeyArn() {
        return Optional.ofNullable(this.kmsKeyArn);
    }

    public static Builder builder() {
        return new Builder();
    }

    public static Builder builder(AgentDataSourceServerSideEncryptionConfiguration defaults) {
        return new Builder(defaults);
    }
    @CustomType.Builder
    public static final class Builder {
        private @Nullable String kmsKeyArn;
        public Builder() {}
        public Builder(AgentDataSourceServerSideEncryptionConfiguration defaults) {
    	      Objects.requireNonNull(defaults);
    	      this.kmsKeyArn = defaults.kmsKeyArn;
        }

        @CustomType.Setter
        public Builder kmsKeyArn(@Nullable String kmsKeyArn) {

            this.kmsKeyArn = kmsKeyArn;
            return this;
        }
        public AgentDataSourceServerSideEncryptionConfiguration build() {
            final var _resultValue = new AgentDataSourceServerSideEncryptionConfiguration();
            _resultValue.kmsKeyArn = kmsKeyArn;
            return _resultValue;
        }
    }
}
