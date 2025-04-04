// *** WARNING: this file was generated by pulumi-java-gen. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

package com.pulumi.aws.oam.outputs;

import com.pulumi.aws.oam.outputs.GetLinkLinkConfiguration;
import com.pulumi.core.annotations.CustomType;
import com.pulumi.exceptions.MissingRequiredPropertyException;
import java.lang.String;
import java.util.List;
import java.util.Map;
import java.util.Objects;

@CustomType
public final class GetLinkResult {
    /**
     * @return ARN of the link.
     * 
     */
    private String arn;
    /**
     * @return The provider-assigned unique ID for this managed resource.
     * 
     */
    private String id;
    /**
     * @return Label that is assigned to this link.
     * 
     */
    private String label;
    /**
     * @return Human-readable name used to identify this source account when you are viewing data from it in the monitoring account.
     * 
     */
    private String labelTemplate;
    /**
     * @return Configuration for creating filters that specify that only some metric namespaces or log groups are to be shared from the source account to the monitoring account. See `link_configuration` Block for details.
     * 
     */
    private List<GetLinkLinkConfiguration> linkConfigurations;
    /**
     * @return ID string that AWS generated as part of the link ARN.
     * 
     */
    private String linkId;
    private String linkIdentifier;
    /**
     * @return Types of data that the source account shares with the monitoring account.
     * 
     */
    private List<String> resourceTypes;
    /**
     * @return ARN of the sink that is used for this link.
     * 
     */
    private String sinkArn;
    private Map<String,String> tags;

    private GetLinkResult() {}
    /**
     * @return ARN of the link.
     * 
     */
    public String arn() {
        return this.arn;
    }
    /**
     * @return The provider-assigned unique ID for this managed resource.
     * 
     */
    public String id() {
        return this.id;
    }
    /**
     * @return Label that is assigned to this link.
     * 
     */
    public String label() {
        return this.label;
    }
    /**
     * @return Human-readable name used to identify this source account when you are viewing data from it in the monitoring account.
     * 
     */
    public String labelTemplate() {
        return this.labelTemplate;
    }
    /**
     * @return Configuration for creating filters that specify that only some metric namespaces or log groups are to be shared from the source account to the monitoring account. See `link_configuration` Block for details.
     * 
     */
    public List<GetLinkLinkConfiguration> linkConfigurations() {
        return this.linkConfigurations;
    }
    /**
     * @return ID string that AWS generated as part of the link ARN.
     * 
     */
    public String linkId() {
        return this.linkId;
    }
    public String linkIdentifier() {
        return this.linkIdentifier;
    }
    /**
     * @return Types of data that the source account shares with the monitoring account.
     * 
     */
    public List<String> resourceTypes() {
        return this.resourceTypes;
    }
    /**
     * @return ARN of the sink that is used for this link.
     * 
     */
    public String sinkArn() {
        return this.sinkArn;
    }
    public Map<String,String> tags() {
        return this.tags;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static Builder builder(GetLinkResult defaults) {
        return new Builder(defaults);
    }
    @CustomType.Builder
    public static final class Builder {
        private String arn;
        private String id;
        private String label;
        private String labelTemplate;
        private List<GetLinkLinkConfiguration> linkConfigurations;
        private String linkId;
        private String linkIdentifier;
        private List<String> resourceTypes;
        private String sinkArn;
        private Map<String,String> tags;
        public Builder() {}
        public Builder(GetLinkResult defaults) {
    	      Objects.requireNonNull(defaults);
    	      this.arn = defaults.arn;
    	      this.id = defaults.id;
    	      this.label = defaults.label;
    	      this.labelTemplate = defaults.labelTemplate;
    	      this.linkConfigurations = defaults.linkConfigurations;
    	      this.linkId = defaults.linkId;
    	      this.linkIdentifier = defaults.linkIdentifier;
    	      this.resourceTypes = defaults.resourceTypes;
    	      this.sinkArn = defaults.sinkArn;
    	      this.tags = defaults.tags;
        }

        @CustomType.Setter
        public Builder arn(String arn) {
            if (arn == null) {
              throw new MissingRequiredPropertyException("GetLinkResult", "arn");
            }
            this.arn = arn;
            return this;
        }
        @CustomType.Setter
        public Builder id(String id) {
            if (id == null) {
              throw new MissingRequiredPropertyException("GetLinkResult", "id");
            }
            this.id = id;
            return this;
        }
        @CustomType.Setter
        public Builder label(String label) {
            if (label == null) {
              throw new MissingRequiredPropertyException("GetLinkResult", "label");
            }
            this.label = label;
            return this;
        }
        @CustomType.Setter
        public Builder labelTemplate(String labelTemplate) {
            if (labelTemplate == null) {
              throw new MissingRequiredPropertyException("GetLinkResult", "labelTemplate");
            }
            this.labelTemplate = labelTemplate;
            return this;
        }
        @CustomType.Setter
        public Builder linkConfigurations(List<GetLinkLinkConfiguration> linkConfigurations) {
            if (linkConfigurations == null) {
              throw new MissingRequiredPropertyException("GetLinkResult", "linkConfigurations");
            }
            this.linkConfigurations = linkConfigurations;
            return this;
        }
        public Builder linkConfigurations(GetLinkLinkConfiguration... linkConfigurations) {
            return linkConfigurations(List.of(linkConfigurations));
        }
        @CustomType.Setter
        public Builder linkId(String linkId) {
            if (linkId == null) {
              throw new MissingRequiredPropertyException("GetLinkResult", "linkId");
            }
            this.linkId = linkId;
            return this;
        }
        @CustomType.Setter
        public Builder linkIdentifier(String linkIdentifier) {
            if (linkIdentifier == null) {
              throw new MissingRequiredPropertyException("GetLinkResult", "linkIdentifier");
            }
            this.linkIdentifier = linkIdentifier;
            return this;
        }
        @CustomType.Setter
        public Builder resourceTypes(List<String> resourceTypes) {
            if (resourceTypes == null) {
              throw new MissingRequiredPropertyException("GetLinkResult", "resourceTypes");
            }
            this.resourceTypes = resourceTypes;
            return this;
        }
        public Builder resourceTypes(String... resourceTypes) {
            return resourceTypes(List.of(resourceTypes));
        }
        @CustomType.Setter
        public Builder sinkArn(String sinkArn) {
            if (sinkArn == null) {
              throw new MissingRequiredPropertyException("GetLinkResult", "sinkArn");
            }
            this.sinkArn = sinkArn;
            return this;
        }
        @CustomType.Setter
        public Builder tags(Map<String,String> tags) {
            if (tags == null) {
              throw new MissingRequiredPropertyException("GetLinkResult", "tags");
            }
            this.tags = tags;
            return this;
        }
        public GetLinkResult build() {
            final var _resultValue = new GetLinkResult();
            _resultValue.arn = arn;
            _resultValue.id = id;
            _resultValue.label = label;
            _resultValue.labelTemplate = labelTemplate;
            _resultValue.linkConfigurations = linkConfigurations;
            _resultValue.linkId = linkId;
            _resultValue.linkIdentifier = linkIdentifier;
            _resultValue.resourceTypes = resourceTypes;
            _resultValue.sinkArn = sinkArn;
            _resultValue.tags = tags;
            return _resultValue;
        }
    }
}
