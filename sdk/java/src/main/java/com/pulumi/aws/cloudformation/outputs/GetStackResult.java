// *** WARNING: this file was generated by pulumi-java-gen. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

package com.pulumi.aws.cloudformation.outputs;

import com.pulumi.core.annotations.CustomType;
import com.pulumi.exceptions.MissingRequiredPropertyException;
import java.lang.Boolean;
import java.lang.Integer;
import java.lang.String;
import java.util.List;
import java.util.Map;
import java.util.Objects;

@CustomType
public final class GetStackResult {
    /**
     * @return List of capabilities
     * 
     */
    private List<String> capabilities;
    /**
     * @return Description of the stack
     * 
     */
    private String description;
    /**
     * @return Whether the rollback of the stack is disabled when stack creation fails
     * 
     */
    private Boolean disableRollback;
    /**
     * @return ARN of the IAM role used to create the stack.
     * 
     */
    private String iamRoleArn;
    /**
     * @return The provider-assigned unique ID for this managed resource.
     * 
     */
    private String id;
    private String name;
    /**
     * @return List of SNS topic ARNs to publish stack related events
     * 
     */
    private List<String> notificationArns;
    /**
     * @return Map of outputs from the stack.
     * 
     */
    private Map<String,String> outputs;
    /**
     * @return Map of parameters that specify input parameters for the stack.
     * 
     */
    private Map<String,String> parameters;
    /**
     * @return Map of tags associated with this stack.
     * 
     */
    private Map<String,String> tags;
    /**
     * @return Structure containing the template body.
     * 
     */
    private String templateBody;
    /**
     * @return Amount of time that can pass before the stack status becomes `CREATE_FAILED`
     * 
     */
    private Integer timeoutInMinutes;

    private GetStackResult() {}
    /**
     * @return List of capabilities
     * 
     */
    public List<String> capabilities() {
        return this.capabilities;
    }
    /**
     * @return Description of the stack
     * 
     */
    public String description() {
        return this.description;
    }
    /**
     * @return Whether the rollback of the stack is disabled when stack creation fails
     * 
     */
    public Boolean disableRollback() {
        return this.disableRollback;
    }
    /**
     * @return ARN of the IAM role used to create the stack.
     * 
     */
    public String iamRoleArn() {
        return this.iamRoleArn;
    }
    /**
     * @return The provider-assigned unique ID for this managed resource.
     * 
     */
    public String id() {
        return this.id;
    }
    public String name() {
        return this.name;
    }
    /**
     * @return List of SNS topic ARNs to publish stack related events
     * 
     */
    public List<String> notificationArns() {
        return this.notificationArns;
    }
    /**
     * @return Map of outputs from the stack.
     * 
     */
    public Map<String,String> outputs() {
        return this.outputs;
    }
    /**
     * @return Map of parameters that specify input parameters for the stack.
     * 
     */
    public Map<String,String> parameters() {
        return this.parameters;
    }
    /**
     * @return Map of tags associated with this stack.
     * 
     */
    public Map<String,String> tags() {
        return this.tags;
    }
    /**
     * @return Structure containing the template body.
     * 
     */
    public String templateBody() {
        return this.templateBody;
    }
    /**
     * @return Amount of time that can pass before the stack status becomes `CREATE_FAILED`
     * 
     */
    public Integer timeoutInMinutes() {
        return this.timeoutInMinutes;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static Builder builder(GetStackResult defaults) {
        return new Builder(defaults);
    }
    @CustomType.Builder
    public static final class Builder {
        private List<String> capabilities;
        private String description;
        private Boolean disableRollback;
        private String iamRoleArn;
        private String id;
        private String name;
        private List<String> notificationArns;
        private Map<String,String> outputs;
        private Map<String,String> parameters;
        private Map<String,String> tags;
        private String templateBody;
        private Integer timeoutInMinutes;
        public Builder() {}
        public Builder(GetStackResult defaults) {
    	      Objects.requireNonNull(defaults);
    	      this.capabilities = defaults.capabilities;
    	      this.description = defaults.description;
    	      this.disableRollback = defaults.disableRollback;
    	      this.iamRoleArn = defaults.iamRoleArn;
    	      this.id = defaults.id;
    	      this.name = defaults.name;
    	      this.notificationArns = defaults.notificationArns;
    	      this.outputs = defaults.outputs;
    	      this.parameters = defaults.parameters;
    	      this.tags = defaults.tags;
    	      this.templateBody = defaults.templateBody;
    	      this.timeoutInMinutes = defaults.timeoutInMinutes;
        }

        @CustomType.Setter
        public Builder capabilities(List<String> capabilities) {
            if (capabilities == null) {
              throw new MissingRequiredPropertyException("GetStackResult", "capabilities");
            }
            this.capabilities = capabilities;
            return this;
        }
        public Builder capabilities(String... capabilities) {
            return capabilities(List.of(capabilities));
        }
        @CustomType.Setter
        public Builder description(String description) {
            if (description == null) {
              throw new MissingRequiredPropertyException("GetStackResult", "description");
            }
            this.description = description;
            return this;
        }
        @CustomType.Setter
        public Builder disableRollback(Boolean disableRollback) {
            if (disableRollback == null) {
              throw new MissingRequiredPropertyException("GetStackResult", "disableRollback");
            }
            this.disableRollback = disableRollback;
            return this;
        }
        @CustomType.Setter
        public Builder iamRoleArn(String iamRoleArn) {
            if (iamRoleArn == null) {
              throw new MissingRequiredPropertyException("GetStackResult", "iamRoleArn");
            }
            this.iamRoleArn = iamRoleArn;
            return this;
        }
        @CustomType.Setter
        public Builder id(String id) {
            if (id == null) {
              throw new MissingRequiredPropertyException("GetStackResult", "id");
            }
            this.id = id;
            return this;
        }
        @CustomType.Setter
        public Builder name(String name) {
            if (name == null) {
              throw new MissingRequiredPropertyException("GetStackResult", "name");
            }
            this.name = name;
            return this;
        }
        @CustomType.Setter
        public Builder notificationArns(List<String> notificationArns) {
            if (notificationArns == null) {
              throw new MissingRequiredPropertyException("GetStackResult", "notificationArns");
            }
            this.notificationArns = notificationArns;
            return this;
        }
        public Builder notificationArns(String... notificationArns) {
            return notificationArns(List.of(notificationArns));
        }
        @CustomType.Setter
        public Builder outputs(Map<String,String> outputs) {
            if (outputs == null) {
              throw new MissingRequiredPropertyException("GetStackResult", "outputs");
            }
            this.outputs = outputs;
            return this;
        }
        @CustomType.Setter
        public Builder parameters(Map<String,String> parameters) {
            if (parameters == null) {
              throw new MissingRequiredPropertyException("GetStackResult", "parameters");
            }
            this.parameters = parameters;
            return this;
        }
        @CustomType.Setter
        public Builder tags(Map<String,String> tags) {
            if (tags == null) {
              throw new MissingRequiredPropertyException("GetStackResult", "tags");
            }
            this.tags = tags;
            return this;
        }
        @CustomType.Setter
        public Builder templateBody(String templateBody) {
            if (templateBody == null) {
              throw new MissingRequiredPropertyException("GetStackResult", "templateBody");
            }
            this.templateBody = templateBody;
            return this;
        }
        @CustomType.Setter
        public Builder timeoutInMinutes(Integer timeoutInMinutes) {
            if (timeoutInMinutes == null) {
              throw new MissingRequiredPropertyException("GetStackResult", "timeoutInMinutes");
            }
            this.timeoutInMinutes = timeoutInMinutes;
            return this;
        }
        public GetStackResult build() {
            final var _resultValue = new GetStackResult();
            _resultValue.capabilities = capabilities;
            _resultValue.description = description;
            _resultValue.disableRollback = disableRollback;
            _resultValue.iamRoleArn = iamRoleArn;
            _resultValue.id = id;
            _resultValue.name = name;
            _resultValue.notificationArns = notificationArns;
            _resultValue.outputs = outputs;
            _resultValue.parameters = parameters;
            _resultValue.tags = tags;
            _resultValue.templateBody = templateBody;
            _resultValue.timeoutInMinutes = timeoutInMinutes;
            return _resultValue;
        }
    }
}
