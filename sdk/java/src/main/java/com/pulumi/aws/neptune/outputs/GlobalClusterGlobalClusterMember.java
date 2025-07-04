// *** WARNING: this file was generated by pulumi-java-gen. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

package com.pulumi.aws.neptune.outputs;

import com.pulumi.core.annotations.CustomType;
import java.lang.Boolean;
import java.lang.String;
import java.util.Objects;
import java.util.Optional;
import javax.annotation.Nullable;

@CustomType
public final class GlobalClusterGlobalClusterMember {
    /**
     * @return ARN of member DB Cluster.
     * 
     */
    private @Nullable String dbClusterArn;
    /**
     * @return Whether the member is the primary DB Cluster.
     * 
     */
    private @Nullable Boolean isWriter;

    private GlobalClusterGlobalClusterMember() {}
    /**
     * @return ARN of member DB Cluster.
     * 
     */
    public Optional<String> dbClusterArn() {
        return Optional.ofNullable(this.dbClusterArn);
    }
    /**
     * @return Whether the member is the primary DB Cluster.
     * 
     */
    public Optional<Boolean> isWriter() {
        return Optional.ofNullable(this.isWriter);
    }

    public static Builder builder() {
        return new Builder();
    }

    public static Builder builder(GlobalClusterGlobalClusterMember defaults) {
        return new Builder(defaults);
    }
    @CustomType.Builder
    public static final class Builder {
        private @Nullable String dbClusterArn;
        private @Nullable Boolean isWriter;
        public Builder() {}
        public Builder(GlobalClusterGlobalClusterMember defaults) {
    	      Objects.requireNonNull(defaults);
    	      this.dbClusterArn = defaults.dbClusterArn;
    	      this.isWriter = defaults.isWriter;
        }

        @CustomType.Setter
        public Builder dbClusterArn(@Nullable String dbClusterArn) {

            this.dbClusterArn = dbClusterArn;
            return this;
        }
        @CustomType.Setter
        public Builder isWriter(@Nullable Boolean isWriter) {

            this.isWriter = isWriter;
            return this;
        }
        public GlobalClusterGlobalClusterMember build() {
            final var _resultValue = new GlobalClusterGlobalClusterMember();
            _resultValue.dbClusterArn = dbClusterArn;
            _resultValue.isWriter = isWriter;
            return _resultValue;
        }
    }
}
