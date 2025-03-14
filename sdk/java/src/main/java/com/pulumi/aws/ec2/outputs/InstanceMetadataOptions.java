// *** WARNING: this file was generated by pulumi-java-gen. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

package com.pulumi.aws.ec2.outputs;

import com.pulumi.core.annotations.CustomType;
import java.lang.Integer;
import java.lang.String;
import java.util.Objects;
import java.util.Optional;
import javax.annotation.Nullable;

@CustomType
public final class InstanceMetadataOptions {
    /**
     * @return Whether the metadata service is available. Valid values include `enabled` or `disabled`. Defaults to `enabled`.
     * 
     */
    private @Nullable String httpEndpoint;
    /**
     * @return Whether the IPv6 endpoint for the instance metadata service is enabled. Defaults to `disabled`.
     * 
     */
    private @Nullable String httpProtocolIpv6;
    /**
     * @return Desired HTTP PUT response hop limit for instance metadata requests. The larger the number, the further instance metadata requests can travel. Valid values are integer from `1` to `64`. Defaults to `1`.
     * 
     */
    private @Nullable Integer httpPutResponseHopLimit;
    /**
     * @return Whether or not the metadata service requires session tokens, also referred to as _Instance Metadata Service Version 2 (IMDSv2)_. Valid values include `optional` or `required`.
     * 
     */
    private @Nullable String httpTokens;
    /**
     * @return Enables or disables access to instance tags from the instance metadata service. Valid values include `enabled` or `disabled`. Defaults to `disabled`.
     * 
     * For more information, see the documentation on the [Instance Metadata Service](https://docs.aws.amazon.com/AWSEC2/latest/UserGuide/ec2-instance-metadata.html).
     * 
     */
    private @Nullable String instanceMetadataTags;

    private InstanceMetadataOptions() {}
    /**
     * @return Whether the metadata service is available. Valid values include `enabled` or `disabled`. Defaults to `enabled`.
     * 
     */
    public Optional<String> httpEndpoint() {
        return Optional.ofNullable(this.httpEndpoint);
    }
    /**
     * @return Whether the IPv6 endpoint for the instance metadata service is enabled. Defaults to `disabled`.
     * 
     */
    public Optional<String> httpProtocolIpv6() {
        return Optional.ofNullable(this.httpProtocolIpv6);
    }
    /**
     * @return Desired HTTP PUT response hop limit for instance metadata requests. The larger the number, the further instance metadata requests can travel. Valid values are integer from `1` to `64`. Defaults to `1`.
     * 
     */
    public Optional<Integer> httpPutResponseHopLimit() {
        return Optional.ofNullable(this.httpPutResponseHopLimit);
    }
    /**
     * @return Whether or not the metadata service requires session tokens, also referred to as _Instance Metadata Service Version 2 (IMDSv2)_. Valid values include `optional` or `required`.
     * 
     */
    public Optional<String> httpTokens() {
        return Optional.ofNullable(this.httpTokens);
    }
    /**
     * @return Enables or disables access to instance tags from the instance metadata service. Valid values include `enabled` or `disabled`. Defaults to `disabled`.
     * 
     * For more information, see the documentation on the [Instance Metadata Service](https://docs.aws.amazon.com/AWSEC2/latest/UserGuide/ec2-instance-metadata.html).
     * 
     */
    public Optional<String> instanceMetadataTags() {
        return Optional.ofNullable(this.instanceMetadataTags);
    }

    public static Builder builder() {
        return new Builder();
    }

    public static Builder builder(InstanceMetadataOptions defaults) {
        return new Builder(defaults);
    }
    @CustomType.Builder
    public static final class Builder {
        private @Nullable String httpEndpoint;
        private @Nullable String httpProtocolIpv6;
        private @Nullable Integer httpPutResponseHopLimit;
        private @Nullable String httpTokens;
        private @Nullable String instanceMetadataTags;
        public Builder() {}
        public Builder(InstanceMetadataOptions defaults) {
    	      Objects.requireNonNull(defaults);
    	      this.httpEndpoint = defaults.httpEndpoint;
    	      this.httpProtocolIpv6 = defaults.httpProtocolIpv6;
    	      this.httpPutResponseHopLimit = defaults.httpPutResponseHopLimit;
    	      this.httpTokens = defaults.httpTokens;
    	      this.instanceMetadataTags = defaults.instanceMetadataTags;
        }

        @CustomType.Setter
        public Builder httpEndpoint(@Nullable String httpEndpoint) {

            this.httpEndpoint = httpEndpoint;
            return this;
        }
        @CustomType.Setter
        public Builder httpProtocolIpv6(@Nullable String httpProtocolIpv6) {

            this.httpProtocolIpv6 = httpProtocolIpv6;
            return this;
        }
        @CustomType.Setter
        public Builder httpPutResponseHopLimit(@Nullable Integer httpPutResponseHopLimit) {

            this.httpPutResponseHopLimit = httpPutResponseHopLimit;
            return this;
        }
        @CustomType.Setter
        public Builder httpTokens(@Nullable String httpTokens) {

            this.httpTokens = httpTokens;
            return this;
        }
        @CustomType.Setter
        public Builder instanceMetadataTags(@Nullable String instanceMetadataTags) {

            this.instanceMetadataTags = instanceMetadataTags;
            return this;
        }
        public InstanceMetadataOptions build() {
            final var _resultValue = new InstanceMetadataOptions();
            _resultValue.httpEndpoint = httpEndpoint;
            _resultValue.httpProtocolIpv6 = httpProtocolIpv6;
            _resultValue.httpPutResponseHopLimit = httpPutResponseHopLimit;
            _resultValue.httpTokens = httpTokens;
            _resultValue.instanceMetadataTags = instanceMetadataTags;
            return _resultValue;
        }
    }
}
