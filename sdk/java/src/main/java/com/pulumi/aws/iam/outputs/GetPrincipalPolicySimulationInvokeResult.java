// *** WARNING: this file was generated by pulumi-java-gen. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

package com.pulumi.aws.iam.outputs;

import com.pulumi.aws.iam.outputs.GetPrincipalPolicySimulationContext;
import com.pulumi.aws.iam.outputs.GetPrincipalPolicySimulationResult;
import com.pulumi.core.annotations.CustomType;
import com.pulumi.exceptions.MissingRequiredPropertyException;
import java.lang.Boolean;
import java.lang.String;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import javax.annotation.Nullable;

@CustomType
public final class GetPrincipalPolicySimulationInvokeResult {
    private List<String> actionNames;
    private @Nullable List<String> additionalPoliciesJsons;
    /**
     * @return `true` if all of the simulation results have decision &#34;allowed&#34;, or `false` otherwise.
     * 
     */
    private Boolean allAllowed;
    private @Nullable String callerArn;
    private @Nullable List<GetPrincipalPolicySimulationContext> contexts;
    private String id;
    private @Nullable List<String> permissionsBoundaryPoliciesJsons;
    private String policySourceArn;
    private @Nullable List<String> resourceArns;
    private @Nullable String resourceHandlingOption;
    private @Nullable String resourceOwnerAccountId;
    private @Nullable String resourcePolicyJson;
    /**
     * @return A set of result objects, one for each of the simulated requests, with the following nested attributes:
     * 
     */
    private List<GetPrincipalPolicySimulationResult> results;

    private GetPrincipalPolicySimulationInvokeResult() {}
    public List<String> actionNames() {
        return this.actionNames;
    }
    public List<String> additionalPoliciesJsons() {
        return this.additionalPoliciesJsons == null ? List.of() : this.additionalPoliciesJsons;
    }
    /**
     * @return `true` if all of the simulation results have decision &#34;allowed&#34;, or `false` otherwise.
     * 
     */
    public Boolean allAllowed() {
        return this.allAllowed;
    }
    public Optional<String> callerArn() {
        return Optional.ofNullable(this.callerArn);
    }
    public List<GetPrincipalPolicySimulationContext> contexts() {
        return this.contexts == null ? List.of() : this.contexts;
    }
    public String id() {
        return this.id;
    }
    public List<String> permissionsBoundaryPoliciesJsons() {
        return this.permissionsBoundaryPoliciesJsons == null ? List.of() : this.permissionsBoundaryPoliciesJsons;
    }
    public String policySourceArn() {
        return this.policySourceArn;
    }
    public List<String> resourceArns() {
        return this.resourceArns == null ? List.of() : this.resourceArns;
    }
    public Optional<String> resourceHandlingOption() {
        return Optional.ofNullable(this.resourceHandlingOption);
    }
    public Optional<String> resourceOwnerAccountId() {
        return Optional.ofNullable(this.resourceOwnerAccountId);
    }
    public Optional<String> resourcePolicyJson() {
        return Optional.ofNullable(this.resourcePolicyJson);
    }
    /**
     * @return A set of result objects, one for each of the simulated requests, with the following nested attributes:
     * 
     */
    public List<GetPrincipalPolicySimulationResult> results() {
        return this.results;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static Builder builder(GetPrincipalPolicySimulationInvokeResult defaults) {
        return new Builder(defaults);
    }
    @CustomType.Builder
    public static final class Builder {
        private List<String> actionNames;
        private @Nullable List<String> additionalPoliciesJsons;
        private Boolean allAllowed;
        private @Nullable String callerArn;
        private @Nullable List<GetPrincipalPolicySimulationContext> contexts;
        private String id;
        private @Nullable List<String> permissionsBoundaryPoliciesJsons;
        private String policySourceArn;
        private @Nullable List<String> resourceArns;
        private @Nullable String resourceHandlingOption;
        private @Nullable String resourceOwnerAccountId;
        private @Nullable String resourcePolicyJson;
        private List<GetPrincipalPolicySimulationResult> results;
        public Builder() {}
        public Builder(GetPrincipalPolicySimulationInvokeResult defaults) {
    	      Objects.requireNonNull(defaults);
    	      this.actionNames = defaults.actionNames;
    	      this.additionalPoliciesJsons = defaults.additionalPoliciesJsons;
    	      this.allAllowed = defaults.allAllowed;
    	      this.callerArn = defaults.callerArn;
    	      this.contexts = defaults.contexts;
    	      this.id = defaults.id;
    	      this.permissionsBoundaryPoliciesJsons = defaults.permissionsBoundaryPoliciesJsons;
    	      this.policySourceArn = defaults.policySourceArn;
    	      this.resourceArns = defaults.resourceArns;
    	      this.resourceHandlingOption = defaults.resourceHandlingOption;
    	      this.resourceOwnerAccountId = defaults.resourceOwnerAccountId;
    	      this.resourcePolicyJson = defaults.resourcePolicyJson;
    	      this.results = defaults.results;
        }

        @CustomType.Setter
        public Builder actionNames(List<String> actionNames) {
            if (actionNames == null) {
              throw new MissingRequiredPropertyException("GetPrincipalPolicySimulationInvokeResult", "actionNames");
            }
            this.actionNames = actionNames;
            return this;
        }
        public Builder actionNames(String... actionNames) {
            return actionNames(List.of(actionNames));
        }
        @CustomType.Setter
        public Builder additionalPoliciesJsons(@Nullable List<String> additionalPoliciesJsons) {

            this.additionalPoliciesJsons = additionalPoliciesJsons;
            return this;
        }
        public Builder additionalPoliciesJsons(String... additionalPoliciesJsons) {
            return additionalPoliciesJsons(List.of(additionalPoliciesJsons));
        }
        @CustomType.Setter
        public Builder allAllowed(Boolean allAllowed) {
            if (allAllowed == null) {
              throw new MissingRequiredPropertyException("GetPrincipalPolicySimulationInvokeResult", "allAllowed");
            }
            this.allAllowed = allAllowed;
            return this;
        }
        @CustomType.Setter
        public Builder callerArn(@Nullable String callerArn) {

            this.callerArn = callerArn;
            return this;
        }
        @CustomType.Setter
        public Builder contexts(@Nullable List<GetPrincipalPolicySimulationContext> contexts) {

            this.contexts = contexts;
            return this;
        }
        public Builder contexts(GetPrincipalPolicySimulationContext... contexts) {
            return contexts(List.of(contexts));
        }
        @CustomType.Setter
        public Builder id(String id) {
            if (id == null) {
              throw new MissingRequiredPropertyException("GetPrincipalPolicySimulationInvokeResult", "id");
            }
            this.id = id;
            return this;
        }
        @CustomType.Setter
        public Builder permissionsBoundaryPoliciesJsons(@Nullable List<String> permissionsBoundaryPoliciesJsons) {

            this.permissionsBoundaryPoliciesJsons = permissionsBoundaryPoliciesJsons;
            return this;
        }
        public Builder permissionsBoundaryPoliciesJsons(String... permissionsBoundaryPoliciesJsons) {
            return permissionsBoundaryPoliciesJsons(List.of(permissionsBoundaryPoliciesJsons));
        }
        @CustomType.Setter
        public Builder policySourceArn(String policySourceArn) {
            if (policySourceArn == null) {
              throw new MissingRequiredPropertyException("GetPrincipalPolicySimulationInvokeResult", "policySourceArn");
            }
            this.policySourceArn = policySourceArn;
            return this;
        }
        @CustomType.Setter
        public Builder resourceArns(@Nullable List<String> resourceArns) {

            this.resourceArns = resourceArns;
            return this;
        }
        public Builder resourceArns(String... resourceArns) {
            return resourceArns(List.of(resourceArns));
        }
        @CustomType.Setter
        public Builder resourceHandlingOption(@Nullable String resourceHandlingOption) {

            this.resourceHandlingOption = resourceHandlingOption;
            return this;
        }
        @CustomType.Setter
        public Builder resourceOwnerAccountId(@Nullable String resourceOwnerAccountId) {

            this.resourceOwnerAccountId = resourceOwnerAccountId;
            return this;
        }
        @CustomType.Setter
        public Builder resourcePolicyJson(@Nullable String resourcePolicyJson) {

            this.resourcePolicyJson = resourcePolicyJson;
            return this;
        }
        @CustomType.Setter
        public Builder results(List<GetPrincipalPolicySimulationResult> results) {
            if (results == null) {
              throw new MissingRequiredPropertyException("GetPrincipalPolicySimulationInvokeResult", "results");
            }
            this.results = results;
            return this;
        }
        public Builder results(GetPrincipalPolicySimulationResult... results) {
            return results(List.of(results));
        }
        public GetPrincipalPolicySimulationInvokeResult build() {
            final var _resultValue = new GetPrincipalPolicySimulationInvokeResult();
            _resultValue.actionNames = actionNames;
            _resultValue.additionalPoliciesJsons = additionalPoliciesJsons;
            _resultValue.allAllowed = allAllowed;
            _resultValue.callerArn = callerArn;
            _resultValue.contexts = contexts;
            _resultValue.id = id;
            _resultValue.permissionsBoundaryPoliciesJsons = permissionsBoundaryPoliciesJsons;
            _resultValue.policySourceArn = policySourceArn;
            _resultValue.resourceArns = resourceArns;
            _resultValue.resourceHandlingOption = resourceHandlingOption;
            _resultValue.resourceOwnerAccountId = resourceOwnerAccountId;
            _resultValue.resourcePolicyJson = resourcePolicyJson;
            _resultValue.results = results;
            return _resultValue;
        }
    }
}
