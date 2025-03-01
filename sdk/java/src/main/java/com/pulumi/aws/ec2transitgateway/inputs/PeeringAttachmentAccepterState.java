// *** WARNING: this file was generated by pulumi-java-gen. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

package com.pulumi.aws.ec2transitgateway.inputs;

import com.pulumi.core.Output;
import com.pulumi.core.annotations.Import;
import java.lang.String;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import javax.annotation.Nullable;


public final class PeeringAttachmentAccepterState extends com.pulumi.resources.ResourceArgs {

    public static final PeeringAttachmentAccepterState Empty = new PeeringAttachmentAccepterState();

    /**
     * Identifier of the AWS account that owns the EC2 TGW peering.
     * 
     */
    @Import(name="peerAccountId")
    private @Nullable Output<String> peerAccountId;

    /**
     * @return Identifier of the AWS account that owns the EC2 TGW peering.
     * 
     */
    public Optional<Output<String>> peerAccountId() {
        return Optional.ofNullable(this.peerAccountId);
    }

    @Import(name="peerRegion")
    private @Nullable Output<String> peerRegion;

    public Optional<Output<String>> peerRegion() {
        return Optional.ofNullable(this.peerRegion);
    }

    /**
     * Identifier of EC2 Transit Gateway to peer with.
     * 
     */
    @Import(name="peerTransitGatewayId")
    private @Nullable Output<String> peerTransitGatewayId;

    /**
     * @return Identifier of EC2 Transit Gateway to peer with.
     * 
     */
    public Optional<Output<String>> peerTransitGatewayId() {
        return Optional.ofNullable(this.peerTransitGatewayId);
    }

    /**
     * Key-value tags for the EC2 Transit Gateway Peering Attachment. If configured with a provider `default_tags` configuration block present, tags with matching keys will overwrite those defined at the provider-level.
     * 
     */
    @Import(name="tags")
    private @Nullable Output<Map<String,String>> tags;

    /**
     * @return Key-value tags for the EC2 Transit Gateway Peering Attachment. If configured with a provider `default_tags` configuration block present, tags with matching keys will overwrite those defined at the provider-level.
     * 
     */
    public Optional<Output<Map<String,String>>> tags() {
        return Optional.ofNullable(this.tags);
    }

    /**
     * A map of tags assigned to the resource, including those inherited from the provider `default_tags` configuration block.
     * 
     * @deprecated
     * Please use `tags` instead.
     * 
     */
    @Deprecated /* Please use `tags` instead. */
    @Import(name="tagsAll")
    private @Nullable Output<Map<String,String>> tagsAll;

    /**
     * @return A map of tags assigned to the resource, including those inherited from the provider `default_tags` configuration block.
     * 
     * @deprecated
     * Please use `tags` instead.
     * 
     */
    @Deprecated /* Please use `tags` instead. */
    public Optional<Output<Map<String,String>>> tagsAll() {
        return Optional.ofNullable(this.tagsAll);
    }

    /**
     * The ID of the EC2 Transit Gateway Peering Attachment to manage.
     * 
     */
    @Import(name="transitGatewayAttachmentId")
    private @Nullable Output<String> transitGatewayAttachmentId;

    /**
     * @return The ID of the EC2 Transit Gateway Peering Attachment to manage.
     * 
     */
    public Optional<Output<String>> transitGatewayAttachmentId() {
        return Optional.ofNullable(this.transitGatewayAttachmentId);
    }

    /**
     * Identifier of EC2 Transit Gateway.
     * 
     */
    @Import(name="transitGatewayId")
    private @Nullable Output<String> transitGatewayId;

    /**
     * @return Identifier of EC2 Transit Gateway.
     * 
     */
    public Optional<Output<String>> transitGatewayId() {
        return Optional.ofNullable(this.transitGatewayId);
    }

    private PeeringAttachmentAccepterState() {}

    private PeeringAttachmentAccepterState(PeeringAttachmentAccepterState $) {
        this.peerAccountId = $.peerAccountId;
        this.peerRegion = $.peerRegion;
        this.peerTransitGatewayId = $.peerTransitGatewayId;
        this.tags = $.tags;
        this.tagsAll = $.tagsAll;
        this.transitGatewayAttachmentId = $.transitGatewayAttachmentId;
        this.transitGatewayId = $.transitGatewayId;
    }

    public static Builder builder() {
        return new Builder();
    }
    public static Builder builder(PeeringAttachmentAccepterState defaults) {
        return new Builder(defaults);
    }

    public static final class Builder {
        private PeeringAttachmentAccepterState $;

        public Builder() {
            $ = new PeeringAttachmentAccepterState();
        }

        public Builder(PeeringAttachmentAccepterState defaults) {
            $ = new PeeringAttachmentAccepterState(Objects.requireNonNull(defaults));
        }

        /**
         * @param peerAccountId Identifier of the AWS account that owns the EC2 TGW peering.
         * 
         * @return builder
         * 
         */
        public Builder peerAccountId(@Nullable Output<String> peerAccountId) {
            $.peerAccountId = peerAccountId;
            return this;
        }

        /**
         * @param peerAccountId Identifier of the AWS account that owns the EC2 TGW peering.
         * 
         * @return builder
         * 
         */
        public Builder peerAccountId(String peerAccountId) {
            return peerAccountId(Output.of(peerAccountId));
        }

        public Builder peerRegion(@Nullable Output<String> peerRegion) {
            $.peerRegion = peerRegion;
            return this;
        }

        public Builder peerRegion(String peerRegion) {
            return peerRegion(Output.of(peerRegion));
        }

        /**
         * @param peerTransitGatewayId Identifier of EC2 Transit Gateway to peer with.
         * 
         * @return builder
         * 
         */
        public Builder peerTransitGatewayId(@Nullable Output<String> peerTransitGatewayId) {
            $.peerTransitGatewayId = peerTransitGatewayId;
            return this;
        }

        /**
         * @param peerTransitGatewayId Identifier of EC2 Transit Gateway to peer with.
         * 
         * @return builder
         * 
         */
        public Builder peerTransitGatewayId(String peerTransitGatewayId) {
            return peerTransitGatewayId(Output.of(peerTransitGatewayId));
        }

        /**
         * @param tags Key-value tags for the EC2 Transit Gateway Peering Attachment. If configured with a provider `default_tags` configuration block present, tags with matching keys will overwrite those defined at the provider-level.
         * 
         * @return builder
         * 
         */
        public Builder tags(@Nullable Output<Map<String,String>> tags) {
            $.tags = tags;
            return this;
        }

        /**
         * @param tags Key-value tags for the EC2 Transit Gateway Peering Attachment. If configured with a provider `default_tags` configuration block present, tags with matching keys will overwrite those defined at the provider-level.
         * 
         * @return builder
         * 
         */
        public Builder tags(Map<String,String> tags) {
            return tags(Output.of(tags));
        }

        /**
         * @param tagsAll A map of tags assigned to the resource, including those inherited from the provider `default_tags` configuration block.
         * 
         * @return builder
         * 
         * @deprecated
         * Please use `tags` instead.
         * 
         */
        @Deprecated /* Please use `tags` instead. */
        public Builder tagsAll(@Nullable Output<Map<String,String>> tagsAll) {
            $.tagsAll = tagsAll;
            return this;
        }

        /**
         * @param tagsAll A map of tags assigned to the resource, including those inherited from the provider `default_tags` configuration block.
         * 
         * @return builder
         * 
         * @deprecated
         * Please use `tags` instead.
         * 
         */
        @Deprecated /* Please use `tags` instead. */
        public Builder tagsAll(Map<String,String> tagsAll) {
            return tagsAll(Output.of(tagsAll));
        }

        /**
         * @param transitGatewayAttachmentId The ID of the EC2 Transit Gateway Peering Attachment to manage.
         * 
         * @return builder
         * 
         */
        public Builder transitGatewayAttachmentId(@Nullable Output<String> transitGatewayAttachmentId) {
            $.transitGatewayAttachmentId = transitGatewayAttachmentId;
            return this;
        }

        /**
         * @param transitGatewayAttachmentId The ID of the EC2 Transit Gateway Peering Attachment to manage.
         * 
         * @return builder
         * 
         */
        public Builder transitGatewayAttachmentId(String transitGatewayAttachmentId) {
            return transitGatewayAttachmentId(Output.of(transitGatewayAttachmentId));
        }

        /**
         * @param transitGatewayId Identifier of EC2 Transit Gateway.
         * 
         * @return builder
         * 
         */
        public Builder transitGatewayId(@Nullable Output<String> transitGatewayId) {
            $.transitGatewayId = transitGatewayId;
            return this;
        }

        /**
         * @param transitGatewayId Identifier of EC2 Transit Gateway.
         * 
         * @return builder
         * 
         */
        public Builder transitGatewayId(String transitGatewayId) {
            return transitGatewayId(Output.of(transitGatewayId));
        }

        public PeeringAttachmentAccepterState build() {
            return $;
        }
    }

}
