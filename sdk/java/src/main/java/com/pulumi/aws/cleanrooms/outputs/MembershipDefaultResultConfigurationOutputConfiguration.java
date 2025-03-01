// *** WARNING: this file was generated by pulumi-java-gen. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

package com.pulumi.aws.cleanrooms.outputs;

import com.pulumi.aws.cleanrooms.outputs.MembershipDefaultResultConfigurationOutputConfigurationS3;
import com.pulumi.core.annotations.CustomType;
import java.util.Objects;
import java.util.Optional;
import javax.annotation.Nullable;

@CustomType
public final class MembershipDefaultResultConfigurationOutputConfiguration {
    private @Nullable MembershipDefaultResultConfigurationOutputConfigurationS3 s3;

    private MembershipDefaultResultConfigurationOutputConfiguration() {}
    public Optional<MembershipDefaultResultConfigurationOutputConfigurationS3> s3() {
        return Optional.ofNullable(this.s3);
    }

    public static Builder builder() {
        return new Builder();
    }

    public static Builder builder(MembershipDefaultResultConfigurationOutputConfiguration defaults) {
        return new Builder(defaults);
    }
    @CustomType.Builder
    public static final class Builder {
        private @Nullable MembershipDefaultResultConfigurationOutputConfigurationS3 s3;
        public Builder() {}
        public Builder(MembershipDefaultResultConfigurationOutputConfiguration defaults) {
    	      Objects.requireNonNull(defaults);
    	      this.s3 = defaults.s3;
        }

        @CustomType.Setter
        public Builder s3(@Nullable MembershipDefaultResultConfigurationOutputConfigurationS3 s3) {

            this.s3 = s3;
            return this;
        }
        public MembershipDefaultResultConfigurationOutputConfiguration build() {
            final var _resultValue = new MembershipDefaultResultConfigurationOutputConfiguration();
            _resultValue.s3 = s3;
            return _resultValue;
        }
    }
}
