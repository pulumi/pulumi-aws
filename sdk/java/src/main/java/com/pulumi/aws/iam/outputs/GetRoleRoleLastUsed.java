// *** WARNING: this file was generated by pulumi-java-gen. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

package com.pulumi.aws.iam.outputs;

import com.pulumi.core.annotations.CustomType;
import java.lang.String;
import java.util.Objects;

@CustomType
public final class GetRoleRoleLastUsed {
    private String lastUsedDate;
    /**
     * @return The name of the AWS Region in which the role was last used.
     * 
     */
    private String region;

    private GetRoleRoleLastUsed() {}
    public String lastUsedDate() {
        return this.lastUsedDate;
    }
    /**
     * @return The name of the AWS Region in which the role was last used.
     * 
     */
    public String region() {
        return this.region;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static Builder builder(GetRoleRoleLastUsed defaults) {
        return new Builder(defaults);
    }
    @CustomType.Builder
    public static final class Builder {
        private String lastUsedDate;
        private String region;
        public Builder() {}
        public Builder(GetRoleRoleLastUsed defaults) {
    	      Objects.requireNonNull(defaults);
    	      this.lastUsedDate = defaults.lastUsedDate;
    	      this.region = defaults.region;
        }

        @CustomType.Setter
        public Builder lastUsedDate(String lastUsedDate) {
            this.lastUsedDate = Objects.requireNonNull(lastUsedDate);
            return this;
        }
        @CustomType.Setter
        public Builder region(String region) {
            this.region = Objects.requireNonNull(region);
            return this;
        }
        public GetRoleRoleLastUsed build() {
            final var o = new GetRoleRoleLastUsed();
            o.lastUsedDate = lastUsedDate;
            o.region = region;
            return o;
        }
    }
}