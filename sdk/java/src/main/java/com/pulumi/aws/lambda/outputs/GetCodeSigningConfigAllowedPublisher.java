// *** WARNING: this file was generated by pulumi-java-gen. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

package com.pulumi.aws.lambda.outputs;

import com.pulumi.core.annotations.CustomType;
import com.pulumi.exceptions.MissingRequiredPropertyException;
import java.lang.String;
import java.util.List;
import java.util.Objects;

@CustomType
public final class GetCodeSigningConfigAllowedPublisher {
    /**
     * @return The ARN for each of the signing profiles. A signing profile defines a trusted user who can sign a code package.
     * 
     */
    private List<String> signingProfileVersionArns;

    private GetCodeSigningConfigAllowedPublisher() {}
    /**
     * @return The ARN for each of the signing profiles. A signing profile defines a trusted user who can sign a code package.
     * 
     */
    public List<String> signingProfileVersionArns() {
        return this.signingProfileVersionArns;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static Builder builder(GetCodeSigningConfigAllowedPublisher defaults) {
        return new Builder(defaults);
    }
    @CustomType.Builder
    public static final class Builder {
        private List<String> signingProfileVersionArns;
        public Builder() {}
        public Builder(GetCodeSigningConfigAllowedPublisher defaults) {
    	      Objects.requireNonNull(defaults);
    	      this.signingProfileVersionArns = defaults.signingProfileVersionArns;
        }

        @CustomType.Setter
        public Builder signingProfileVersionArns(List<String> signingProfileVersionArns) {
            if (signingProfileVersionArns == null) {
              throw new MissingRequiredPropertyException("GetCodeSigningConfigAllowedPublisher", "signingProfileVersionArns");
            }
            this.signingProfileVersionArns = signingProfileVersionArns;
            return this;
        }
        public Builder signingProfileVersionArns(String... signingProfileVersionArns) {
            return signingProfileVersionArns(List.of(signingProfileVersionArns));
        }
        public GetCodeSigningConfigAllowedPublisher build() {
            final var _resultValue = new GetCodeSigningConfigAllowedPublisher();
            _resultValue.signingProfileVersionArns = signingProfileVersionArns;
            return _resultValue;
        }
    }
}
