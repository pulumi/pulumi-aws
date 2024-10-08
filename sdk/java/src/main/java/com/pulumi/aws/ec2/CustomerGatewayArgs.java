// *** WARNING: this file was generated by pulumi-java-gen. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

package com.pulumi.aws.ec2;

import com.pulumi.core.Output;
import com.pulumi.core.annotations.Import;
import com.pulumi.exceptions.MissingRequiredPropertyException;
import java.lang.String;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import javax.annotation.Nullable;


public final class CustomerGatewayArgs extends com.pulumi.resources.ResourceArgs {

    public static final CustomerGatewayArgs Empty = new CustomerGatewayArgs();

    /**
     * The gateway&#39;s Border Gateway Protocol (BGP) Autonomous System Number (ASN). Valid values are from  `1` to `2147483647`. Conflicts with `bgp_asn_extended`.
     * 
     */
    @Import(name="bgpAsn")
    private @Nullable Output<String> bgpAsn;

    /**
     * @return The gateway&#39;s Border Gateway Protocol (BGP) Autonomous System Number (ASN). Valid values are from  `1` to `2147483647`. Conflicts with `bgp_asn_extended`.
     * 
     */
    public Optional<Output<String>> bgpAsn() {
        return Optional.ofNullable(this.bgpAsn);
    }

    /**
     * The gateway&#39;s Border Gateway Protocol (BGP) Autonomous System Number (ASN). Valid values are from  `2147483648` to `4294967295` Conflicts with `bgp_asn`.
     * 
     */
    @Import(name="bgpAsnExtended")
    private @Nullable Output<String> bgpAsnExtended;

    /**
     * @return The gateway&#39;s Border Gateway Protocol (BGP) Autonomous System Number (ASN). Valid values are from  `2147483648` to `4294967295` Conflicts with `bgp_asn`.
     * 
     */
    public Optional<Output<String>> bgpAsnExtended() {
        return Optional.ofNullable(this.bgpAsnExtended);
    }

    /**
     * The Amazon Resource Name (ARN) for the customer gateway certificate.
     * 
     */
    @Import(name="certificateArn")
    private @Nullable Output<String> certificateArn;

    /**
     * @return The Amazon Resource Name (ARN) for the customer gateway certificate.
     * 
     */
    public Optional<Output<String>> certificateArn() {
        return Optional.ofNullable(this.certificateArn);
    }

    /**
     * A name for the customer gateway device.
     * 
     */
    @Import(name="deviceName")
    private @Nullable Output<String> deviceName;

    /**
     * @return A name for the customer gateway device.
     * 
     */
    public Optional<Output<String>> deviceName() {
        return Optional.ofNullable(this.deviceName);
    }

    /**
     * The IPv4 address for the customer gateway device&#39;s outside interface.
     * 
     */
    @Import(name="ipAddress")
    private @Nullable Output<String> ipAddress;

    /**
     * @return The IPv4 address for the customer gateway device&#39;s outside interface.
     * 
     */
    public Optional<Output<String>> ipAddress() {
        return Optional.ofNullable(this.ipAddress);
    }

    /**
     * Tags to apply to the gateway. If configured with a provider `default_tags` configuration block present, tags with matching keys will overwrite those defined at the provider-level.
     * 
     */
    @Import(name="tags")
    private @Nullable Output<Map<String,String>> tags;

    /**
     * @return Tags to apply to the gateway. If configured with a provider `default_tags` configuration block present, tags with matching keys will overwrite those defined at the provider-level.
     * 
     */
    public Optional<Output<Map<String,String>>> tags() {
        return Optional.ofNullable(this.tags);
    }

    /**
     * The type of customer gateway. The only type AWS
     * supports at this time is &#34;ipsec.1&#34;.
     * 
     */
    @Import(name="type", required=true)
    private Output<String> type;

    /**
     * @return The type of customer gateway. The only type AWS
     * supports at this time is &#34;ipsec.1&#34;.
     * 
     */
    public Output<String> type() {
        return this.type;
    }

    private CustomerGatewayArgs() {}

    private CustomerGatewayArgs(CustomerGatewayArgs $) {
        this.bgpAsn = $.bgpAsn;
        this.bgpAsnExtended = $.bgpAsnExtended;
        this.certificateArn = $.certificateArn;
        this.deviceName = $.deviceName;
        this.ipAddress = $.ipAddress;
        this.tags = $.tags;
        this.type = $.type;
    }

    public static Builder builder() {
        return new Builder();
    }
    public static Builder builder(CustomerGatewayArgs defaults) {
        return new Builder(defaults);
    }

    public static final class Builder {
        private CustomerGatewayArgs $;

        public Builder() {
            $ = new CustomerGatewayArgs();
        }

        public Builder(CustomerGatewayArgs defaults) {
            $ = new CustomerGatewayArgs(Objects.requireNonNull(defaults));
        }

        /**
         * @param bgpAsn The gateway&#39;s Border Gateway Protocol (BGP) Autonomous System Number (ASN). Valid values are from  `1` to `2147483647`. Conflicts with `bgp_asn_extended`.
         * 
         * @return builder
         * 
         */
        public Builder bgpAsn(@Nullable Output<String> bgpAsn) {
            $.bgpAsn = bgpAsn;
            return this;
        }

        /**
         * @param bgpAsn The gateway&#39;s Border Gateway Protocol (BGP) Autonomous System Number (ASN). Valid values are from  `1` to `2147483647`. Conflicts with `bgp_asn_extended`.
         * 
         * @return builder
         * 
         */
        public Builder bgpAsn(String bgpAsn) {
            return bgpAsn(Output.of(bgpAsn));
        }

        /**
         * @param bgpAsnExtended The gateway&#39;s Border Gateway Protocol (BGP) Autonomous System Number (ASN). Valid values are from  `2147483648` to `4294967295` Conflicts with `bgp_asn`.
         * 
         * @return builder
         * 
         */
        public Builder bgpAsnExtended(@Nullable Output<String> bgpAsnExtended) {
            $.bgpAsnExtended = bgpAsnExtended;
            return this;
        }

        /**
         * @param bgpAsnExtended The gateway&#39;s Border Gateway Protocol (BGP) Autonomous System Number (ASN). Valid values are from  `2147483648` to `4294967295` Conflicts with `bgp_asn`.
         * 
         * @return builder
         * 
         */
        public Builder bgpAsnExtended(String bgpAsnExtended) {
            return bgpAsnExtended(Output.of(bgpAsnExtended));
        }

        /**
         * @param certificateArn The Amazon Resource Name (ARN) for the customer gateway certificate.
         * 
         * @return builder
         * 
         */
        public Builder certificateArn(@Nullable Output<String> certificateArn) {
            $.certificateArn = certificateArn;
            return this;
        }

        /**
         * @param certificateArn The Amazon Resource Name (ARN) for the customer gateway certificate.
         * 
         * @return builder
         * 
         */
        public Builder certificateArn(String certificateArn) {
            return certificateArn(Output.of(certificateArn));
        }

        /**
         * @param deviceName A name for the customer gateway device.
         * 
         * @return builder
         * 
         */
        public Builder deviceName(@Nullable Output<String> deviceName) {
            $.deviceName = deviceName;
            return this;
        }

        /**
         * @param deviceName A name for the customer gateway device.
         * 
         * @return builder
         * 
         */
        public Builder deviceName(String deviceName) {
            return deviceName(Output.of(deviceName));
        }

        /**
         * @param ipAddress The IPv4 address for the customer gateway device&#39;s outside interface.
         * 
         * @return builder
         * 
         */
        public Builder ipAddress(@Nullable Output<String> ipAddress) {
            $.ipAddress = ipAddress;
            return this;
        }

        /**
         * @param ipAddress The IPv4 address for the customer gateway device&#39;s outside interface.
         * 
         * @return builder
         * 
         */
        public Builder ipAddress(String ipAddress) {
            return ipAddress(Output.of(ipAddress));
        }

        /**
         * @param tags Tags to apply to the gateway. If configured with a provider `default_tags` configuration block present, tags with matching keys will overwrite those defined at the provider-level.
         * 
         * @return builder
         * 
         */
        public Builder tags(@Nullable Output<Map<String,String>> tags) {
            $.tags = tags;
            return this;
        }

        /**
         * @param tags Tags to apply to the gateway. If configured with a provider `default_tags` configuration block present, tags with matching keys will overwrite those defined at the provider-level.
         * 
         * @return builder
         * 
         */
        public Builder tags(Map<String,String> tags) {
            return tags(Output.of(tags));
        }

        /**
         * @param type The type of customer gateway. The only type AWS
         * supports at this time is &#34;ipsec.1&#34;.
         * 
         * @return builder
         * 
         */
        public Builder type(Output<String> type) {
            $.type = type;
            return this;
        }

        /**
         * @param type The type of customer gateway. The only type AWS
         * supports at this time is &#34;ipsec.1&#34;.
         * 
         * @return builder
         * 
         */
        public Builder type(String type) {
            return type(Output.of(type));
        }

        public CustomerGatewayArgs build() {
            if ($.type == null) {
                throw new MissingRequiredPropertyException("CustomerGatewayArgs", "type");
            }
            return $;
        }
    }

}
