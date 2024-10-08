// *** WARNING: this file was generated by pulumi-java-gen. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

package com.pulumi.aws.outposts.inputs;

import com.pulumi.core.annotations.Import;
import java.lang.String;
import java.util.Objects;
import java.util.Optional;
import javax.annotation.Nullable;


public final class GetOutpostsPlainArgs extends com.pulumi.resources.InvokeArgs {

    public static final GetOutpostsPlainArgs Empty = new GetOutpostsPlainArgs();

    /**
     * Availability Zone name.
     * 
     */
    @Import(name="availabilityZone")
    private @Nullable String availabilityZone;

    /**
     * @return Availability Zone name.
     * 
     */
    public Optional<String> availabilityZone() {
        return Optional.ofNullable(this.availabilityZone);
    }

    /**
     * Availability Zone identifier.
     * 
     */
    @Import(name="availabilityZoneId")
    private @Nullable String availabilityZoneId;

    /**
     * @return Availability Zone identifier.
     * 
     */
    public Optional<String> availabilityZoneId() {
        return Optional.ofNullable(this.availabilityZoneId);
    }

    /**
     * AWS Account identifier of the Outpost owner.
     * 
     */
    @Import(name="ownerId")
    private @Nullable String ownerId;

    /**
     * @return AWS Account identifier of the Outpost owner.
     * 
     */
    public Optional<String> ownerId() {
        return Optional.ofNullable(this.ownerId);
    }

    /**
     * Site identifier.
     * 
     */
    @Import(name="siteId")
    private @Nullable String siteId;

    /**
     * @return Site identifier.
     * 
     */
    public Optional<String> siteId() {
        return Optional.ofNullable(this.siteId);
    }

    private GetOutpostsPlainArgs() {}

    private GetOutpostsPlainArgs(GetOutpostsPlainArgs $) {
        this.availabilityZone = $.availabilityZone;
        this.availabilityZoneId = $.availabilityZoneId;
        this.ownerId = $.ownerId;
        this.siteId = $.siteId;
    }

    public static Builder builder() {
        return new Builder();
    }
    public static Builder builder(GetOutpostsPlainArgs defaults) {
        return new Builder(defaults);
    }

    public static final class Builder {
        private GetOutpostsPlainArgs $;

        public Builder() {
            $ = new GetOutpostsPlainArgs();
        }

        public Builder(GetOutpostsPlainArgs defaults) {
            $ = new GetOutpostsPlainArgs(Objects.requireNonNull(defaults));
        }

        /**
         * @param availabilityZone Availability Zone name.
         * 
         * @return builder
         * 
         */
        public Builder availabilityZone(@Nullable String availabilityZone) {
            $.availabilityZone = availabilityZone;
            return this;
        }

        /**
         * @param availabilityZoneId Availability Zone identifier.
         * 
         * @return builder
         * 
         */
        public Builder availabilityZoneId(@Nullable String availabilityZoneId) {
            $.availabilityZoneId = availabilityZoneId;
            return this;
        }

        /**
         * @param ownerId AWS Account identifier of the Outpost owner.
         * 
         * @return builder
         * 
         */
        public Builder ownerId(@Nullable String ownerId) {
            $.ownerId = ownerId;
            return this;
        }

        /**
         * @param siteId Site identifier.
         * 
         * @return builder
         * 
         */
        public Builder siteId(@Nullable String siteId) {
            $.siteId = siteId;
            return this;
        }

        public GetOutpostsPlainArgs build() {
            return $;
        }
    }

}
