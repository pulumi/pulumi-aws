// *** WARNING: this file was generated by pulumi-java-gen. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

package com.pulumi.aws.auditmanager.outputs;

import com.pulumi.aws.auditmanager.outputs.GetControlControlMappingSource;
import com.pulumi.core.annotations.CustomType;
import com.pulumi.exceptions.MissingRequiredPropertyException;
import java.lang.String;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import javax.annotation.Nullable;

@CustomType
public final class GetControlResult {
    private String actionPlanInstructions;
    private String actionPlanTitle;
    private String arn;
    private @Nullable List<GetControlControlMappingSource> controlMappingSources;
    private String description;
    private String id;
    private String name;
    private Map<String,String> tags;
    private String testingInformation;
    private String type;

    private GetControlResult() {}
    public String actionPlanInstructions() {
        return this.actionPlanInstructions;
    }
    public String actionPlanTitle() {
        return this.actionPlanTitle;
    }
    public String arn() {
        return this.arn;
    }
    public List<GetControlControlMappingSource> controlMappingSources() {
        return this.controlMappingSources == null ? List.of() : this.controlMappingSources;
    }
    public String description() {
        return this.description;
    }
    public String id() {
        return this.id;
    }
    public String name() {
        return this.name;
    }
    public Map<String,String> tags() {
        return this.tags;
    }
    public String testingInformation() {
        return this.testingInformation;
    }
    public String type() {
        return this.type;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static Builder builder(GetControlResult defaults) {
        return new Builder(defaults);
    }
    @CustomType.Builder
    public static final class Builder {
        private String actionPlanInstructions;
        private String actionPlanTitle;
        private String arn;
        private @Nullable List<GetControlControlMappingSource> controlMappingSources;
        private String description;
        private String id;
        private String name;
        private Map<String,String> tags;
        private String testingInformation;
        private String type;
        public Builder() {}
        public Builder(GetControlResult defaults) {
    	      Objects.requireNonNull(defaults);
    	      this.actionPlanInstructions = defaults.actionPlanInstructions;
    	      this.actionPlanTitle = defaults.actionPlanTitle;
    	      this.arn = defaults.arn;
    	      this.controlMappingSources = defaults.controlMappingSources;
    	      this.description = defaults.description;
    	      this.id = defaults.id;
    	      this.name = defaults.name;
    	      this.tags = defaults.tags;
    	      this.testingInformation = defaults.testingInformation;
    	      this.type = defaults.type;
        }

        @CustomType.Setter
        public Builder actionPlanInstructions(String actionPlanInstructions) {
            if (actionPlanInstructions == null) {
              throw new MissingRequiredPropertyException("GetControlResult", "actionPlanInstructions");
            }
            this.actionPlanInstructions = actionPlanInstructions;
            return this;
        }
        @CustomType.Setter
        public Builder actionPlanTitle(String actionPlanTitle) {
            if (actionPlanTitle == null) {
              throw new MissingRequiredPropertyException("GetControlResult", "actionPlanTitle");
            }
            this.actionPlanTitle = actionPlanTitle;
            return this;
        }
        @CustomType.Setter
        public Builder arn(String arn) {
            if (arn == null) {
              throw new MissingRequiredPropertyException("GetControlResult", "arn");
            }
            this.arn = arn;
            return this;
        }
        @CustomType.Setter
        public Builder controlMappingSources(@Nullable List<GetControlControlMappingSource> controlMappingSources) {

            this.controlMappingSources = controlMappingSources;
            return this;
        }
        public Builder controlMappingSources(GetControlControlMappingSource... controlMappingSources) {
            return controlMappingSources(List.of(controlMappingSources));
        }
        @CustomType.Setter
        public Builder description(String description) {
            if (description == null) {
              throw new MissingRequiredPropertyException("GetControlResult", "description");
            }
            this.description = description;
            return this;
        }
        @CustomType.Setter
        public Builder id(String id) {
            if (id == null) {
              throw new MissingRequiredPropertyException("GetControlResult", "id");
            }
            this.id = id;
            return this;
        }
        @CustomType.Setter
        public Builder name(String name) {
            if (name == null) {
              throw new MissingRequiredPropertyException("GetControlResult", "name");
            }
            this.name = name;
            return this;
        }
        @CustomType.Setter
        public Builder tags(Map<String,String> tags) {
            if (tags == null) {
              throw new MissingRequiredPropertyException("GetControlResult", "tags");
            }
            this.tags = tags;
            return this;
        }
        @CustomType.Setter
        public Builder testingInformation(String testingInformation) {
            if (testingInformation == null) {
              throw new MissingRequiredPropertyException("GetControlResult", "testingInformation");
            }
            this.testingInformation = testingInformation;
            return this;
        }
        @CustomType.Setter
        public Builder type(String type) {
            if (type == null) {
              throw new MissingRequiredPropertyException("GetControlResult", "type");
            }
            this.type = type;
            return this;
        }
        public GetControlResult build() {
            final var _resultValue = new GetControlResult();
            _resultValue.actionPlanInstructions = actionPlanInstructions;
            _resultValue.actionPlanTitle = actionPlanTitle;
            _resultValue.arn = arn;
            _resultValue.controlMappingSources = controlMappingSources;
            _resultValue.description = description;
            _resultValue.id = id;
            _resultValue.name = name;
            _resultValue.tags = tags;
            _resultValue.testingInformation = testingInformation;
            _resultValue.type = type;
            return _resultValue;
        }
    }
}
