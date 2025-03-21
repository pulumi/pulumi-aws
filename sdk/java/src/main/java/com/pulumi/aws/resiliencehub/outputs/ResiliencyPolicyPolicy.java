// *** WARNING: this file was generated by pulumi-java-gen. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

package com.pulumi.aws.resiliencehub.outputs;

import com.pulumi.aws.resiliencehub.outputs.ResiliencyPolicyPolicyAz;
import com.pulumi.aws.resiliencehub.outputs.ResiliencyPolicyPolicyHardware;
import com.pulumi.aws.resiliencehub.outputs.ResiliencyPolicyPolicyRegion;
import com.pulumi.aws.resiliencehub.outputs.ResiliencyPolicyPolicySoftware;
import com.pulumi.core.annotations.CustomType;
import java.util.Objects;
import java.util.Optional;
import javax.annotation.Nullable;

@CustomType
public final class ResiliencyPolicyPolicy {
    /**
     * @return Specifies Availability Zone failure policy. See `policy.az`
     * 
     */
    private @Nullable ResiliencyPolicyPolicyAz az;
    /**
     * @return Specifies Infrastructure failure policy. See `policy.hardware`
     * 
     */
    private @Nullable ResiliencyPolicyPolicyHardware hardware;
    /**
     * @return Specifies Region failure policy. `policy.region`
     * 
     */
    private @Nullable ResiliencyPolicyPolicyRegion region;
    /**
     * @return Specifies Application failure policy. See `policy.software`
     * 
     * The following arguments are optional:
     * 
     */
    private @Nullable ResiliencyPolicyPolicySoftware software;

    private ResiliencyPolicyPolicy() {}
    /**
     * @return Specifies Availability Zone failure policy. See `policy.az`
     * 
     */
    public Optional<ResiliencyPolicyPolicyAz> az() {
        return Optional.ofNullable(this.az);
    }
    /**
     * @return Specifies Infrastructure failure policy. See `policy.hardware`
     * 
     */
    public Optional<ResiliencyPolicyPolicyHardware> hardware() {
        return Optional.ofNullable(this.hardware);
    }
    /**
     * @return Specifies Region failure policy. `policy.region`
     * 
     */
    public Optional<ResiliencyPolicyPolicyRegion> region() {
        return Optional.ofNullable(this.region);
    }
    /**
     * @return Specifies Application failure policy. See `policy.software`
     * 
     * The following arguments are optional:
     * 
     */
    public Optional<ResiliencyPolicyPolicySoftware> software() {
        return Optional.ofNullable(this.software);
    }

    public static Builder builder() {
        return new Builder();
    }

    public static Builder builder(ResiliencyPolicyPolicy defaults) {
        return new Builder(defaults);
    }
    @CustomType.Builder
    public static final class Builder {
        private @Nullable ResiliencyPolicyPolicyAz az;
        private @Nullable ResiliencyPolicyPolicyHardware hardware;
        private @Nullable ResiliencyPolicyPolicyRegion region;
        private @Nullable ResiliencyPolicyPolicySoftware software;
        public Builder() {}
        public Builder(ResiliencyPolicyPolicy defaults) {
    	      Objects.requireNonNull(defaults);
    	      this.az = defaults.az;
    	      this.hardware = defaults.hardware;
    	      this.region = defaults.region;
    	      this.software = defaults.software;
        }

        @CustomType.Setter
        public Builder az(@Nullable ResiliencyPolicyPolicyAz az) {

            this.az = az;
            return this;
        }
        @CustomType.Setter
        public Builder hardware(@Nullable ResiliencyPolicyPolicyHardware hardware) {

            this.hardware = hardware;
            return this;
        }
        @CustomType.Setter
        public Builder region(@Nullable ResiliencyPolicyPolicyRegion region) {

            this.region = region;
            return this;
        }
        @CustomType.Setter
        public Builder software(@Nullable ResiliencyPolicyPolicySoftware software) {

            this.software = software;
            return this;
        }
        public ResiliencyPolicyPolicy build() {
            final var _resultValue = new ResiliencyPolicyPolicy();
            _resultValue.az = az;
            _resultValue.hardware = hardware;
            _resultValue.region = region;
            _resultValue.software = software;
            return _resultValue;
        }
    }
}
