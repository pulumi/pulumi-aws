// *** WARNING: this file was generated by pulumi-java-gen. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

package com.pulumi.aws.verifiedpermissions.outputs;

import com.pulumi.core.annotations.CustomType;
import com.pulumi.exceptions.MissingRequiredPropertyException;
import java.lang.String;
import java.util.Objects;

@CustomType
public final class PolicyDefinitionTemplateLinkedPrincipal {
    /**
     * @return The entity ID of the principal.
     * 
     */
    private String entityId;
    /**
     * @return The entity type of the principal.
     * 
     */
    private String entityType;

    private PolicyDefinitionTemplateLinkedPrincipal() {}
    /**
     * @return The entity ID of the principal.
     * 
     */
    public String entityId() {
        return this.entityId;
    }
    /**
     * @return The entity type of the principal.
     * 
     */
    public String entityType() {
        return this.entityType;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static Builder builder(PolicyDefinitionTemplateLinkedPrincipal defaults) {
        return new Builder(defaults);
    }
    @CustomType.Builder
    public static final class Builder {
        private String entityId;
        private String entityType;
        public Builder() {}
        public Builder(PolicyDefinitionTemplateLinkedPrincipal defaults) {
    	      Objects.requireNonNull(defaults);
    	      this.entityId = defaults.entityId;
    	      this.entityType = defaults.entityType;
        }

        @CustomType.Setter
        public Builder entityId(String entityId) {
            if (entityId == null) {
              throw new MissingRequiredPropertyException("PolicyDefinitionTemplateLinkedPrincipal", "entityId");
            }
            this.entityId = entityId;
            return this;
        }
        @CustomType.Setter
        public Builder entityType(String entityType) {
            if (entityType == null) {
              throw new MissingRequiredPropertyException("PolicyDefinitionTemplateLinkedPrincipal", "entityType");
            }
            this.entityType = entityType;
            return this;
        }
        public PolicyDefinitionTemplateLinkedPrincipal build() {
            final var _resultValue = new PolicyDefinitionTemplateLinkedPrincipal();
            _resultValue.entityId = entityId;
            _resultValue.entityType = entityType;
            return _resultValue;
        }
    }
}
