// *** WARNING: this file was generated by pulumi-java-gen. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

package com.pulumi.aws.iot.outputs;

import com.pulumi.core.annotations.CustomType;
import com.pulumi.exceptions.MissingRequiredPropertyException;
import java.lang.String;
import java.util.Objects;
import java.util.Optional;
import javax.annotation.Nullable;

@CustomType
public final class GetEndpointResult {
    /**
     * @return Endpoint based on `endpoint_type`:
     * * No `endpoint_type`: Either `iot:Data` or `iot:Data-ATS` [depending on region](https://aws.amazon.com/blogs/iot/aws-iot-core-ats-endpoints/)
     * * `iot:CredentialsProvider`: `IDENTIFIER.credentials.iot.REGION.amazonaws.com`
     * * `iot:Data`: `IDENTIFIER.iot.REGION.amazonaws.com`
     * * `iot:Data-ATS`: `IDENTIFIER-ats.iot.REGION.amazonaws.com`
     * * `iot:Jobs`: `IDENTIFIER.jobs.iot.REGION.amazonaws.com`
     * 
     */
    private String endpointAddress;
    private @Nullable String endpointType;
    /**
     * @return The provider-assigned unique ID for this managed resource.
     * 
     */
    private String id;

    private GetEndpointResult() {}
    /**
     * @return Endpoint based on `endpoint_type`:
     * * No `endpoint_type`: Either `iot:Data` or `iot:Data-ATS` [depending on region](https://aws.amazon.com/blogs/iot/aws-iot-core-ats-endpoints/)
     * * `iot:CredentialsProvider`: `IDENTIFIER.credentials.iot.REGION.amazonaws.com`
     * * `iot:Data`: `IDENTIFIER.iot.REGION.amazonaws.com`
     * * `iot:Data-ATS`: `IDENTIFIER-ats.iot.REGION.amazonaws.com`
     * * `iot:Jobs`: `IDENTIFIER.jobs.iot.REGION.amazonaws.com`
     * 
     */
    public String endpointAddress() {
        return this.endpointAddress;
    }
    public Optional<String> endpointType() {
        return Optional.ofNullable(this.endpointType);
    }
    /**
     * @return The provider-assigned unique ID for this managed resource.
     * 
     */
    public String id() {
        return this.id;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static Builder builder(GetEndpointResult defaults) {
        return new Builder(defaults);
    }
    @CustomType.Builder
    public static final class Builder {
        private String endpointAddress;
        private @Nullable String endpointType;
        private String id;
        public Builder() {}
        public Builder(GetEndpointResult defaults) {
    	      Objects.requireNonNull(defaults);
    	      this.endpointAddress = defaults.endpointAddress;
    	      this.endpointType = defaults.endpointType;
    	      this.id = defaults.id;
        }

        @CustomType.Setter
        public Builder endpointAddress(String endpointAddress) {
            if (endpointAddress == null) {
              throw new MissingRequiredPropertyException("GetEndpointResult", "endpointAddress");
            }
            this.endpointAddress = endpointAddress;
            return this;
        }
        @CustomType.Setter
        public Builder endpointType(@Nullable String endpointType) {

            this.endpointType = endpointType;
            return this;
        }
        @CustomType.Setter
        public Builder id(String id) {
            if (id == null) {
              throw new MissingRequiredPropertyException("GetEndpointResult", "id");
            }
            this.id = id;
            return this;
        }
        public GetEndpointResult build() {
            final var _resultValue = new GetEndpointResult();
            _resultValue.endpointAddress = endpointAddress;
            _resultValue.endpointType = endpointType;
            _resultValue.id = id;
            return _resultValue;
        }
    }
}
