// *** WARNING: this file was generated by pulumi-java-gen. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

package com.pulumi.aws.quicksight.outputs;

import com.pulumi.aws.quicksight.outputs.GetThemeConfiguration;
import com.pulumi.aws.quicksight.outputs.GetThemePermission;
import com.pulumi.core.annotations.CustomType;
import com.pulumi.exceptions.MissingRequiredPropertyException;
import java.lang.Integer;
import java.lang.String;
import java.util.List;
import java.util.Map;
import java.util.Objects;

@CustomType
public final class GetThemeResult {
    /**
     * @return ARN of the theme.
     * 
     */
    private String arn;
    private String awsAccountId;
    /**
     * @return The ID of the theme that a custom theme will inherit from. All themes inherit from one of the starting themes defined by Amazon QuickSight.
     * 
     */
    private String baseThemeId;
    /**
     * @return The theme configuration, which contains the theme display properties. See configuration.
     * 
     */
    private List<GetThemeConfiguration> configurations;
    /**
     * @return The time that the theme was created.
     * 
     */
    private String createdTime;
    /**
     * @return The provider-assigned unique ID for this managed resource.
     * 
     */
    private String id;
    /**
     * @return The time that the theme was last updated.
     * 
     */
    private String lastUpdatedTime;
    /**
     * @return Display name of the theme.
     * 
     */
    private String name;
    /**
     * @return A set of resource permissions on the theme. See permissions.
     * 
     */
    private List<GetThemePermission> permissions;
    /**
     * @return The theme creation status.
     * 
     */
    private String status;
    /**
     * @return A map of tags assigned to the resource, including those inherited from the provider `default_tags` configuration block.
     * 
     */
    private Map<String,String> tags;
    private String themeId;
    /**
     * @return A description of the current theme version being created/updated.
     * 
     */
    private String versionDescription;
    /**
     * @return The version number of the theme version.
     * 
     */
    private Integer versionNumber;

    private GetThemeResult() {}
    /**
     * @return ARN of the theme.
     * 
     */
    public String arn() {
        return this.arn;
    }
    public String awsAccountId() {
        return this.awsAccountId;
    }
    /**
     * @return The ID of the theme that a custom theme will inherit from. All themes inherit from one of the starting themes defined by Amazon QuickSight.
     * 
     */
    public String baseThemeId() {
        return this.baseThemeId;
    }
    /**
     * @return The theme configuration, which contains the theme display properties. See configuration.
     * 
     */
    public List<GetThemeConfiguration> configurations() {
        return this.configurations;
    }
    /**
     * @return The time that the theme was created.
     * 
     */
    public String createdTime() {
        return this.createdTime;
    }
    /**
     * @return The provider-assigned unique ID for this managed resource.
     * 
     */
    public String id() {
        return this.id;
    }
    /**
     * @return The time that the theme was last updated.
     * 
     */
    public String lastUpdatedTime() {
        return this.lastUpdatedTime;
    }
    /**
     * @return Display name of the theme.
     * 
     */
    public String name() {
        return this.name;
    }
    /**
     * @return A set of resource permissions on the theme. See permissions.
     * 
     */
    public List<GetThemePermission> permissions() {
        return this.permissions;
    }
    /**
     * @return The theme creation status.
     * 
     */
    public String status() {
        return this.status;
    }
    /**
     * @return A map of tags assigned to the resource, including those inherited from the provider `default_tags` configuration block.
     * 
     */
    public Map<String,String> tags() {
        return this.tags;
    }
    public String themeId() {
        return this.themeId;
    }
    /**
     * @return A description of the current theme version being created/updated.
     * 
     */
    public String versionDescription() {
        return this.versionDescription;
    }
    /**
     * @return The version number of the theme version.
     * 
     */
    public Integer versionNumber() {
        return this.versionNumber;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static Builder builder(GetThemeResult defaults) {
        return new Builder(defaults);
    }
    @CustomType.Builder
    public static final class Builder {
        private String arn;
        private String awsAccountId;
        private String baseThemeId;
        private List<GetThemeConfiguration> configurations;
        private String createdTime;
        private String id;
        private String lastUpdatedTime;
        private String name;
        private List<GetThemePermission> permissions;
        private String status;
        private Map<String,String> tags;
        private String themeId;
        private String versionDescription;
        private Integer versionNumber;
        public Builder() {}
        public Builder(GetThemeResult defaults) {
    	      Objects.requireNonNull(defaults);
    	      this.arn = defaults.arn;
    	      this.awsAccountId = defaults.awsAccountId;
    	      this.baseThemeId = defaults.baseThemeId;
    	      this.configurations = defaults.configurations;
    	      this.createdTime = defaults.createdTime;
    	      this.id = defaults.id;
    	      this.lastUpdatedTime = defaults.lastUpdatedTime;
    	      this.name = defaults.name;
    	      this.permissions = defaults.permissions;
    	      this.status = defaults.status;
    	      this.tags = defaults.tags;
    	      this.themeId = defaults.themeId;
    	      this.versionDescription = defaults.versionDescription;
    	      this.versionNumber = defaults.versionNumber;
        }

        @CustomType.Setter
        public Builder arn(String arn) {
            if (arn == null) {
              throw new MissingRequiredPropertyException("GetThemeResult", "arn");
            }
            this.arn = arn;
            return this;
        }
        @CustomType.Setter
        public Builder awsAccountId(String awsAccountId) {
            if (awsAccountId == null) {
              throw new MissingRequiredPropertyException("GetThemeResult", "awsAccountId");
            }
            this.awsAccountId = awsAccountId;
            return this;
        }
        @CustomType.Setter
        public Builder baseThemeId(String baseThemeId) {
            if (baseThemeId == null) {
              throw new MissingRequiredPropertyException("GetThemeResult", "baseThemeId");
            }
            this.baseThemeId = baseThemeId;
            return this;
        }
        @CustomType.Setter
        public Builder configurations(List<GetThemeConfiguration> configurations) {
            if (configurations == null) {
              throw new MissingRequiredPropertyException("GetThemeResult", "configurations");
            }
            this.configurations = configurations;
            return this;
        }
        public Builder configurations(GetThemeConfiguration... configurations) {
            return configurations(List.of(configurations));
        }
        @CustomType.Setter
        public Builder createdTime(String createdTime) {
            if (createdTime == null) {
              throw new MissingRequiredPropertyException("GetThemeResult", "createdTime");
            }
            this.createdTime = createdTime;
            return this;
        }
        @CustomType.Setter
        public Builder id(String id) {
            if (id == null) {
              throw new MissingRequiredPropertyException("GetThemeResult", "id");
            }
            this.id = id;
            return this;
        }
        @CustomType.Setter
        public Builder lastUpdatedTime(String lastUpdatedTime) {
            if (lastUpdatedTime == null) {
              throw new MissingRequiredPropertyException("GetThemeResult", "lastUpdatedTime");
            }
            this.lastUpdatedTime = lastUpdatedTime;
            return this;
        }
        @CustomType.Setter
        public Builder name(String name) {
            if (name == null) {
              throw new MissingRequiredPropertyException("GetThemeResult", "name");
            }
            this.name = name;
            return this;
        }
        @CustomType.Setter
        public Builder permissions(List<GetThemePermission> permissions) {
            if (permissions == null) {
              throw new MissingRequiredPropertyException("GetThemeResult", "permissions");
            }
            this.permissions = permissions;
            return this;
        }
        public Builder permissions(GetThemePermission... permissions) {
            return permissions(List.of(permissions));
        }
        @CustomType.Setter
        public Builder status(String status) {
            if (status == null) {
              throw new MissingRequiredPropertyException("GetThemeResult", "status");
            }
            this.status = status;
            return this;
        }
        @CustomType.Setter
        public Builder tags(Map<String,String> tags) {
            if (tags == null) {
              throw new MissingRequiredPropertyException("GetThemeResult", "tags");
            }
            this.tags = tags;
            return this;
        }
        @CustomType.Setter
        public Builder themeId(String themeId) {
            if (themeId == null) {
              throw new MissingRequiredPropertyException("GetThemeResult", "themeId");
            }
            this.themeId = themeId;
            return this;
        }
        @CustomType.Setter
        public Builder versionDescription(String versionDescription) {
            if (versionDescription == null) {
              throw new MissingRequiredPropertyException("GetThemeResult", "versionDescription");
            }
            this.versionDescription = versionDescription;
            return this;
        }
        @CustomType.Setter
        public Builder versionNumber(Integer versionNumber) {
            if (versionNumber == null) {
              throw new MissingRequiredPropertyException("GetThemeResult", "versionNumber");
            }
            this.versionNumber = versionNumber;
            return this;
        }
        public GetThemeResult build() {
            final var _resultValue = new GetThemeResult();
            _resultValue.arn = arn;
            _resultValue.awsAccountId = awsAccountId;
            _resultValue.baseThemeId = baseThemeId;
            _resultValue.configurations = configurations;
            _resultValue.createdTime = createdTime;
            _resultValue.id = id;
            _resultValue.lastUpdatedTime = lastUpdatedTime;
            _resultValue.name = name;
            _resultValue.permissions = permissions;
            _resultValue.status = status;
            _resultValue.tags = tags;
            _resultValue.themeId = themeId;
            _resultValue.versionDescription = versionDescription;
            _resultValue.versionNumber = versionNumber;
            return _resultValue;
        }
    }
}
