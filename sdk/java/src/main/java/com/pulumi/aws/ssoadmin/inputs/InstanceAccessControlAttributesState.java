// *** WARNING: this file was generated by pulumi-java-gen. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

package com.pulumi.aws.ssoadmin.inputs;

import com.pulumi.aws.ssoadmin.inputs.InstanceAccessControlAttributesAttributeArgs;
import com.pulumi.core.Output;
import com.pulumi.core.annotations.Import;
import java.lang.String;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import javax.annotation.Nullable;


public final class InstanceAccessControlAttributesState extends com.pulumi.resources.ResourceArgs {

    public static final InstanceAccessControlAttributesState Empty = new InstanceAccessControlAttributesState();

    /**
     * See AccessControlAttribute for more details.
     * 
     */
    @Import(name="attributes")
    private @Nullable Output<List<InstanceAccessControlAttributesAttributeArgs>> attributes;

    /**
     * @return See AccessControlAttribute for more details.
     * 
     */
    public Optional<Output<List<InstanceAccessControlAttributesAttributeArgs>>> attributes() {
        return Optional.ofNullable(this.attributes);
    }

    /**
     * The Amazon Resource Name (ARN) of the SSO Instance.
     * 
     */
    @Import(name="instanceArn")
    private @Nullable Output<String> instanceArn;

    /**
     * @return The Amazon Resource Name (ARN) of the SSO Instance.
     * 
     */
    public Optional<Output<String>> instanceArn() {
        return Optional.ofNullable(this.instanceArn);
    }

    @Import(name="status")
    private @Nullable Output<String> status;

    public Optional<Output<String>> status() {
        return Optional.ofNullable(this.status);
    }

    @Import(name="statusReason")
    private @Nullable Output<String> statusReason;

    public Optional<Output<String>> statusReason() {
        return Optional.ofNullable(this.statusReason);
    }

    private InstanceAccessControlAttributesState() {}

    private InstanceAccessControlAttributesState(InstanceAccessControlAttributesState $) {
        this.attributes = $.attributes;
        this.instanceArn = $.instanceArn;
        this.status = $.status;
        this.statusReason = $.statusReason;
    }

    public static Builder builder() {
        return new Builder();
    }
    public static Builder builder(InstanceAccessControlAttributesState defaults) {
        return new Builder(defaults);
    }

    public static final class Builder {
        private InstanceAccessControlAttributesState $;

        public Builder() {
            $ = new InstanceAccessControlAttributesState();
        }

        public Builder(InstanceAccessControlAttributesState defaults) {
            $ = new InstanceAccessControlAttributesState(Objects.requireNonNull(defaults));
        }

        /**
         * @param attributes See AccessControlAttribute for more details.
         * 
         * @return builder
         * 
         */
        public Builder attributes(@Nullable Output<List<InstanceAccessControlAttributesAttributeArgs>> attributes) {
            $.attributes = attributes;
            return this;
        }

        /**
         * @param attributes See AccessControlAttribute for more details.
         * 
         * @return builder
         * 
         */
        public Builder attributes(List<InstanceAccessControlAttributesAttributeArgs> attributes) {
            return attributes(Output.of(attributes));
        }

        /**
         * @param attributes See AccessControlAttribute for more details.
         * 
         * @return builder
         * 
         */
        public Builder attributes(InstanceAccessControlAttributesAttributeArgs... attributes) {
            return attributes(List.of(attributes));
        }

        /**
         * @param instanceArn The Amazon Resource Name (ARN) of the SSO Instance.
         * 
         * @return builder
         * 
         */
        public Builder instanceArn(@Nullable Output<String> instanceArn) {
            $.instanceArn = instanceArn;
            return this;
        }

        /**
         * @param instanceArn The Amazon Resource Name (ARN) of the SSO Instance.
         * 
         * @return builder
         * 
         */
        public Builder instanceArn(String instanceArn) {
            return instanceArn(Output.of(instanceArn));
        }

        public Builder status(@Nullable Output<String> status) {
            $.status = status;
            return this;
        }

        public Builder status(String status) {
            return status(Output.of(status));
        }

        public Builder statusReason(@Nullable Output<String> statusReason) {
            $.statusReason = statusReason;
            return this;
        }

        public Builder statusReason(String statusReason) {
            return statusReason(Output.of(statusReason));
        }

        public InstanceAccessControlAttributesState build() {
            return $;
        }
    }

}
