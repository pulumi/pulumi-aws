// *** WARNING: this file was generated by pulumi-java-gen. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

package com.pulumi.aws.ssmincidents.outputs;

import com.pulumi.core.annotations.CustomType;
import java.lang.String;
import java.util.List;
import java.util.Objects;

@CustomType
public final class GetResponsePlanActionSsmAutomationParameter {
    /**
     * @return The name of the PagerDuty configuration.
     * 
     */
    private String name;
    /**
     * @return The values for the associated parameter name.
     * 
     */
    private List<String> values;

    private GetResponsePlanActionSsmAutomationParameter() {}
    /**
     * @return The name of the PagerDuty configuration.
     * 
     */
    public String name() {
        return this.name;
    }
    /**
     * @return The values for the associated parameter name.
     * 
     */
    public List<String> values() {
        return this.values;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static Builder builder(GetResponsePlanActionSsmAutomationParameter defaults) {
        return new Builder(defaults);
    }
    @CustomType.Builder
    public static final class Builder {
        private String name;
        private List<String> values;
        public Builder() {}
        public Builder(GetResponsePlanActionSsmAutomationParameter defaults) {
    	      Objects.requireNonNull(defaults);
    	      this.name = defaults.name;
    	      this.values = defaults.values;
        }

        @CustomType.Setter
        public Builder name(String name) {
            this.name = Objects.requireNonNull(name);
            return this;
        }
        @CustomType.Setter
        public Builder values(List<String> values) {
            this.values = Objects.requireNonNull(values);
            return this;
        }
        public Builder values(String... values) {
            return values(List.of(values));
        }
        public GetResponsePlanActionSsmAutomationParameter build() {
            final var o = new GetResponsePlanActionSsmAutomationParameter();
            o.name = name;
            o.values = values;
            return o;
        }
    }
}