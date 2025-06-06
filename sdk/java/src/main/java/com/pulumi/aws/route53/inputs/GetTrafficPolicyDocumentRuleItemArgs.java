// *** WARNING: this file was generated by pulumi-java-gen. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

package com.pulumi.aws.route53.inputs;

import com.pulumi.core.Output;
import com.pulumi.core.annotations.Import;
import java.lang.String;
import java.util.Objects;
import java.util.Optional;
import javax.annotation.Nullable;


public final class GetTrafficPolicyDocumentRuleItemArgs extends com.pulumi.resources.ResourceArgs {

    public static final GetTrafficPolicyDocumentRuleItemArgs Empty = new GetTrafficPolicyDocumentRuleItemArgs();

    @Import(name="endpointReference")
    private @Nullable Output<String> endpointReference;

    public Optional<Output<String>> endpointReference() {
        return Optional.ofNullable(this.endpointReference);
    }

    @Import(name="healthCheck")
    private @Nullable Output<String> healthCheck;

    public Optional<Output<String>> healthCheck() {
        return Optional.ofNullable(this.healthCheck);
    }

    private GetTrafficPolicyDocumentRuleItemArgs() {}

    private GetTrafficPolicyDocumentRuleItemArgs(GetTrafficPolicyDocumentRuleItemArgs $) {
        this.endpointReference = $.endpointReference;
        this.healthCheck = $.healthCheck;
    }

    public static Builder builder() {
        return new Builder();
    }
    public static Builder builder(GetTrafficPolicyDocumentRuleItemArgs defaults) {
        return new Builder(defaults);
    }

    public static final class Builder {
        private GetTrafficPolicyDocumentRuleItemArgs $;

        public Builder() {
            $ = new GetTrafficPolicyDocumentRuleItemArgs();
        }

        public Builder(GetTrafficPolicyDocumentRuleItemArgs defaults) {
            $ = new GetTrafficPolicyDocumentRuleItemArgs(Objects.requireNonNull(defaults));
        }

        public Builder endpointReference(@Nullable Output<String> endpointReference) {
            $.endpointReference = endpointReference;
            return this;
        }

        public Builder endpointReference(String endpointReference) {
            return endpointReference(Output.of(endpointReference));
        }

        public Builder healthCheck(@Nullable Output<String> healthCheck) {
            $.healthCheck = healthCheck;
            return this;
        }

        public Builder healthCheck(String healthCheck) {
            return healthCheck(Output.of(healthCheck));
        }

        public GetTrafficPolicyDocumentRuleItemArgs build() {
            return $;
        }
    }

}
