// *** WARNING: this file was generated by pulumi-java-gen. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

package com.pulumi.aws.workspaces.outputs;

import com.pulumi.core.annotations.CustomType;
import com.pulumi.exceptions.MissingRequiredPropertyException;
import java.lang.Boolean;
import java.lang.String;
import java.util.Objects;

@CustomType
public final class GetDirectoryWorkspaceCreationProperty {
    /**
     * @return The identifier of your custom security group. Should relate to the same VPC, where workspaces reside in.
     * 
     */
    private String customSecurityGroupId;
    /**
     * @return The default organizational unit (OU) for your WorkSpace directories.
     * 
     */
    private String defaultOu;
    /**
     * @return Indicates whether internet access is enabled for your WorkSpaces.
     * 
     */
    private Boolean enableInternetAccess;
    /**
     * @return Indicates whether maintenance mode is enabled for your WorkSpaces. For more information, see [WorkSpace Maintenance](https://docs.aws.amazon.com/workspaces/latest/adminguide/workspace-maintenance.html).
     * 
     */
    private Boolean enableMaintenanceMode;
    /**
     * @return Indicates whether users are local administrators of their WorkSpaces.
     * 
     */
    private Boolean userEnabledAsLocalAdministrator;

    private GetDirectoryWorkspaceCreationProperty() {}
    /**
     * @return The identifier of your custom security group. Should relate to the same VPC, where workspaces reside in.
     * 
     */
    public String customSecurityGroupId() {
        return this.customSecurityGroupId;
    }
    /**
     * @return The default organizational unit (OU) for your WorkSpace directories.
     * 
     */
    public String defaultOu() {
        return this.defaultOu;
    }
    /**
     * @return Indicates whether internet access is enabled for your WorkSpaces.
     * 
     */
    public Boolean enableInternetAccess() {
        return this.enableInternetAccess;
    }
    /**
     * @return Indicates whether maintenance mode is enabled for your WorkSpaces. For more information, see [WorkSpace Maintenance](https://docs.aws.amazon.com/workspaces/latest/adminguide/workspace-maintenance.html).
     * 
     */
    public Boolean enableMaintenanceMode() {
        return this.enableMaintenanceMode;
    }
    /**
     * @return Indicates whether users are local administrators of their WorkSpaces.
     * 
     */
    public Boolean userEnabledAsLocalAdministrator() {
        return this.userEnabledAsLocalAdministrator;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static Builder builder(GetDirectoryWorkspaceCreationProperty defaults) {
        return new Builder(defaults);
    }
    @CustomType.Builder
    public static final class Builder {
        private String customSecurityGroupId;
        private String defaultOu;
        private Boolean enableInternetAccess;
        private Boolean enableMaintenanceMode;
        private Boolean userEnabledAsLocalAdministrator;
        public Builder() {}
        public Builder(GetDirectoryWorkspaceCreationProperty defaults) {
    	      Objects.requireNonNull(defaults);
    	      this.customSecurityGroupId = defaults.customSecurityGroupId;
    	      this.defaultOu = defaults.defaultOu;
    	      this.enableInternetAccess = defaults.enableInternetAccess;
    	      this.enableMaintenanceMode = defaults.enableMaintenanceMode;
    	      this.userEnabledAsLocalAdministrator = defaults.userEnabledAsLocalAdministrator;
        }

        @CustomType.Setter
        public Builder customSecurityGroupId(String customSecurityGroupId) {
            if (customSecurityGroupId == null) {
              throw new MissingRequiredPropertyException("GetDirectoryWorkspaceCreationProperty", "customSecurityGroupId");
            }
            this.customSecurityGroupId = customSecurityGroupId;
            return this;
        }
        @CustomType.Setter
        public Builder defaultOu(String defaultOu) {
            if (defaultOu == null) {
              throw new MissingRequiredPropertyException("GetDirectoryWorkspaceCreationProperty", "defaultOu");
            }
            this.defaultOu = defaultOu;
            return this;
        }
        @CustomType.Setter
        public Builder enableInternetAccess(Boolean enableInternetAccess) {
            if (enableInternetAccess == null) {
              throw new MissingRequiredPropertyException("GetDirectoryWorkspaceCreationProperty", "enableInternetAccess");
            }
            this.enableInternetAccess = enableInternetAccess;
            return this;
        }
        @CustomType.Setter
        public Builder enableMaintenanceMode(Boolean enableMaintenanceMode) {
            if (enableMaintenanceMode == null) {
              throw new MissingRequiredPropertyException("GetDirectoryWorkspaceCreationProperty", "enableMaintenanceMode");
            }
            this.enableMaintenanceMode = enableMaintenanceMode;
            return this;
        }
        @CustomType.Setter
        public Builder userEnabledAsLocalAdministrator(Boolean userEnabledAsLocalAdministrator) {
            if (userEnabledAsLocalAdministrator == null) {
              throw new MissingRequiredPropertyException("GetDirectoryWorkspaceCreationProperty", "userEnabledAsLocalAdministrator");
            }
            this.userEnabledAsLocalAdministrator = userEnabledAsLocalAdministrator;
            return this;
        }
        public GetDirectoryWorkspaceCreationProperty build() {
            final var _resultValue = new GetDirectoryWorkspaceCreationProperty();
            _resultValue.customSecurityGroupId = customSecurityGroupId;
            _resultValue.defaultOu = defaultOu;
            _resultValue.enableInternetAccess = enableInternetAccess;
            _resultValue.enableMaintenanceMode = enableMaintenanceMode;
            _resultValue.userEnabledAsLocalAdministrator = userEnabledAsLocalAdministrator;
            return _resultValue;
        }
    }
}
