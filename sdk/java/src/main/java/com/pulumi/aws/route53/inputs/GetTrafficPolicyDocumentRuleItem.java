// *** WARNING: this file was generated by pulumi-java-gen. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

package com.pulumi.aws.route53.inputs;

import com.pulumi.core.annotations.Import;
import java.lang.String;
import java.util.Objects;
import java.util.Optional;
import javax.annotation.Nullable;


public final class GetTrafficPolicyDocumentRuleItem extends com.pulumi.resources.InvokeArgs {

    public static final GetTrafficPolicyDocumentRuleItem Empty = new GetTrafficPolicyDocumentRuleItem();

    /**
     * References to an endpoint.
     * 
     */
    @Import(name="endpointReference")
    private @Nullable String endpointReference;

    /**
     * @return References to an endpoint.
     * 
     */
    public Optional<String> endpointReference() {
        return Optional.ofNullable(this.endpointReference);
    }

    /**
     * If you want to associate a health check with the endpoint or rule.
     * 
     */
    @Import(name="healthCheck")
    private @Nullable String healthCheck;

    /**
     * @return If you want to associate a health check with the endpoint or rule.
     * 
     */
    public Optional<String> healthCheck() {
        return Optional.ofNullable(this.healthCheck);
    }

    private GetTrafficPolicyDocumentRuleItem() {}

    private GetTrafficPolicyDocumentRuleItem(GetTrafficPolicyDocumentRuleItem $) {
        this.endpointReference = $.endpointReference;
        this.healthCheck = $.healthCheck;
    }

    public static Builder builder() {
        return new Builder();
    }
    public static Builder builder(GetTrafficPolicyDocumentRuleItem defaults) {
        return new Builder(defaults);
    }

    public static final class Builder {
        private GetTrafficPolicyDocumentRuleItem $;

        public Builder() {
            $ = new GetTrafficPolicyDocumentRuleItem();
        }

        public Builder(GetTrafficPolicyDocumentRuleItem defaults) {
            $ = new GetTrafficPolicyDocumentRuleItem(Objects.requireNonNull(defaults));
        }

        /**
         * @param endpointReference References to an endpoint.
         * 
         * @return builder
         * 
         */
        public Builder endpointReference(@Nullable String endpointReference) {
            $.endpointReference = endpointReference;
            return this;
        }

        /**
         * @param healthCheck If you want to associate a health check with the endpoint or rule.
         * 
         * @return builder
         * 
         */
        public Builder healthCheck(@Nullable String healthCheck) {
            $.healthCheck = healthCheck;
            return this;
        }

        public GetTrafficPolicyDocumentRuleItem build() {
            return $;
        }
    }

}
