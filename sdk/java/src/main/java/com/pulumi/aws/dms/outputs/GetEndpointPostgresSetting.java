// *** WARNING: this file was generated by pulumi-java-gen. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

package com.pulumi.aws.dms.outputs;

import com.pulumi.core.annotations.CustomType;
import com.pulumi.exceptions.MissingRequiredPropertyException;
import java.lang.Boolean;
import java.lang.Integer;
import java.lang.String;
import java.util.Objects;

@CustomType
public final class GetEndpointPostgresSetting {
    private String afterConnectScript;
    private String babelfishDatabaseName;
    private Boolean captureDdls;
    private String databaseMode;
    private String ddlArtifactsSchema;
    private Integer executeTimeout;
    private Boolean failTasksOnLobTruncation;
    private Boolean heartbeatEnable;
    private Integer heartbeatFrequency;
    private String heartbeatSchema;
    private Boolean mapBooleanAsBoolean;
    private Boolean mapJsonbAsClob;
    private String mapLongVarcharAs;
    private Integer maxFileSize;
    private String pluginName;
    private String slotName;

    private GetEndpointPostgresSetting() {}
    public String afterConnectScript() {
        return this.afterConnectScript;
    }
    public String babelfishDatabaseName() {
        return this.babelfishDatabaseName;
    }
    public Boolean captureDdls() {
        return this.captureDdls;
    }
    public String databaseMode() {
        return this.databaseMode;
    }
    public String ddlArtifactsSchema() {
        return this.ddlArtifactsSchema;
    }
    public Integer executeTimeout() {
        return this.executeTimeout;
    }
    public Boolean failTasksOnLobTruncation() {
        return this.failTasksOnLobTruncation;
    }
    public Boolean heartbeatEnable() {
        return this.heartbeatEnable;
    }
    public Integer heartbeatFrequency() {
        return this.heartbeatFrequency;
    }
    public String heartbeatSchema() {
        return this.heartbeatSchema;
    }
    public Boolean mapBooleanAsBoolean() {
        return this.mapBooleanAsBoolean;
    }
    public Boolean mapJsonbAsClob() {
        return this.mapJsonbAsClob;
    }
    public String mapLongVarcharAs() {
        return this.mapLongVarcharAs;
    }
    public Integer maxFileSize() {
        return this.maxFileSize;
    }
    public String pluginName() {
        return this.pluginName;
    }
    public String slotName() {
        return this.slotName;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static Builder builder(GetEndpointPostgresSetting defaults) {
        return new Builder(defaults);
    }
    @CustomType.Builder
    public static final class Builder {
        private String afterConnectScript;
        private String babelfishDatabaseName;
        private Boolean captureDdls;
        private String databaseMode;
        private String ddlArtifactsSchema;
        private Integer executeTimeout;
        private Boolean failTasksOnLobTruncation;
        private Boolean heartbeatEnable;
        private Integer heartbeatFrequency;
        private String heartbeatSchema;
        private Boolean mapBooleanAsBoolean;
        private Boolean mapJsonbAsClob;
        private String mapLongVarcharAs;
        private Integer maxFileSize;
        private String pluginName;
        private String slotName;
        public Builder() {}
        public Builder(GetEndpointPostgresSetting defaults) {
    	      Objects.requireNonNull(defaults);
    	      this.afterConnectScript = defaults.afterConnectScript;
    	      this.babelfishDatabaseName = defaults.babelfishDatabaseName;
    	      this.captureDdls = defaults.captureDdls;
    	      this.databaseMode = defaults.databaseMode;
    	      this.ddlArtifactsSchema = defaults.ddlArtifactsSchema;
    	      this.executeTimeout = defaults.executeTimeout;
    	      this.failTasksOnLobTruncation = defaults.failTasksOnLobTruncation;
    	      this.heartbeatEnable = defaults.heartbeatEnable;
    	      this.heartbeatFrequency = defaults.heartbeatFrequency;
    	      this.heartbeatSchema = defaults.heartbeatSchema;
    	      this.mapBooleanAsBoolean = defaults.mapBooleanAsBoolean;
    	      this.mapJsonbAsClob = defaults.mapJsonbAsClob;
    	      this.mapLongVarcharAs = defaults.mapLongVarcharAs;
    	      this.maxFileSize = defaults.maxFileSize;
    	      this.pluginName = defaults.pluginName;
    	      this.slotName = defaults.slotName;
        }

        @CustomType.Setter
        public Builder afterConnectScript(String afterConnectScript) {
            if (afterConnectScript == null) {
              throw new MissingRequiredPropertyException("GetEndpointPostgresSetting", "afterConnectScript");
            }
            this.afterConnectScript = afterConnectScript;
            return this;
        }
        @CustomType.Setter
        public Builder babelfishDatabaseName(String babelfishDatabaseName) {
            if (babelfishDatabaseName == null) {
              throw new MissingRequiredPropertyException("GetEndpointPostgresSetting", "babelfishDatabaseName");
            }
            this.babelfishDatabaseName = babelfishDatabaseName;
            return this;
        }
        @CustomType.Setter
        public Builder captureDdls(Boolean captureDdls) {
            if (captureDdls == null) {
              throw new MissingRequiredPropertyException("GetEndpointPostgresSetting", "captureDdls");
            }
            this.captureDdls = captureDdls;
            return this;
        }
        @CustomType.Setter
        public Builder databaseMode(String databaseMode) {
            if (databaseMode == null) {
              throw new MissingRequiredPropertyException("GetEndpointPostgresSetting", "databaseMode");
            }
            this.databaseMode = databaseMode;
            return this;
        }
        @CustomType.Setter
        public Builder ddlArtifactsSchema(String ddlArtifactsSchema) {
            if (ddlArtifactsSchema == null) {
              throw new MissingRequiredPropertyException("GetEndpointPostgresSetting", "ddlArtifactsSchema");
            }
            this.ddlArtifactsSchema = ddlArtifactsSchema;
            return this;
        }
        @CustomType.Setter
        public Builder executeTimeout(Integer executeTimeout) {
            if (executeTimeout == null) {
              throw new MissingRequiredPropertyException("GetEndpointPostgresSetting", "executeTimeout");
            }
            this.executeTimeout = executeTimeout;
            return this;
        }
        @CustomType.Setter
        public Builder failTasksOnLobTruncation(Boolean failTasksOnLobTruncation) {
            if (failTasksOnLobTruncation == null) {
              throw new MissingRequiredPropertyException("GetEndpointPostgresSetting", "failTasksOnLobTruncation");
            }
            this.failTasksOnLobTruncation = failTasksOnLobTruncation;
            return this;
        }
        @CustomType.Setter
        public Builder heartbeatEnable(Boolean heartbeatEnable) {
            if (heartbeatEnable == null) {
              throw new MissingRequiredPropertyException("GetEndpointPostgresSetting", "heartbeatEnable");
            }
            this.heartbeatEnable = heartbeatEnable;
            return this;
        }
        @CustomType.Setter
        public Builder heartbeatFrequency(Integer heartbeatFrequency) {
            if (heartbeatFrequency == null) {
              throw new MissingRequiredPropertyException("GetEndpointPostgresSetting", "heartbeatFrequency");
            }
            this.heartbeatFrequency = heartbeatFrequency;
            return this;
        }
        @CustomType.Setter
        public Builder heartbeatSchema(String heartbeatSchema) {
            if (heartbeatSchema == null) {
              throw new MissingRequiredPropertyException("GetEndpointPostgresSetting", "heartbeatSchema");
            }
            this.heartbeatSchema = heartbeatSchema;
            return this;
        }
        @CustomType.Setter
        public Builder mapBooleanAsBoolean(Boolean mapBooleanAsBoolean) {
            if (mapBooleanAsBoolean == null) {
              throw new MissingRequiredPropertyException("GetEndpointPostgresSetting", "mapBooleanAsBoolean");
            }
            this.mapBooleanAsBoolean = mapBooleanAsBoolean;
            return this;
        }
        @CustomType.Setter
        public Builder mapJsonbAsClob(Boolean mapJsonbAsClob) {
            if (mapJsonbAsClob == null) {
              throw new MissingRequiredPropertyException("GetEndpointPostgresSetting", "mapJsonbAsClob");
            }
            this.mapJsonbAsClob = mapJsonbAsClob;
            return this;
        }
        @CustomType.Setter
        public Builder mapLongVarcharAs(String mapLongVarcharAs) {
            if (mapLongVarcharAs == null) {
              throw new MissingRequiredPropertyException("GetEndpointPostgresSetting", "mapLongVarcharAs");
            }
            this.mapLongVarcharAs = mapLongVarcharAs;
            return this;
        }
        @CustomType.Setter
        public Builder maxFileSize(Integer maxFileSize) {
            if (maxFileSize == null) {
              throw new MissingRequiredPropertyException("GetEndpointPostgresSetting", "maxFileSize");
            }
            this.maxFileSize = maxFileSize;
            return this;
        }
        @CustomType.Setter
        public Builder pluginName(String pluginName) {
            if (pluginName == null) {
              throw new MissingRequiredPropertyException("GetEndpointPostgresSetting", "pluginName");
            }
            this.pluginName = pluginName;
            return this;
        }
        @CustomType.Setter
        public Builder slotName(String slotName) {
            if (slotName == null) {
              throw new MissingRequiredPropertyException("GetEndpointPostgresSetting", "slotName");
            }
            this.slotName = slotName;
            return this;
        }
        public GetEndpointPostgresSetting build() {
            final var _resultValue = new GetEndpointPostgresSetting();
            _resultValue.afterConnectScript = afterConnectScript;
            _resultValue.babelfishDatabaseName = babelfishDatabaseName;
            _resultValue.captureDdls = captureDdls;
            _resultValue.databaseMode = databaseMode;
            _resultValue.ddlArtifactsSchema = ddlArtifactsSchema;
            _resultValue.executeTimeout = executeTimeout;
            _resultValue.failTasksOnLobTruncation = failTasksOnLobTruncation;
            _resultValue.heartbeatEnable = heartbeatEnable;
            _resultValue.heartbeatFrequency = heartbeatFrequency;
            _resultValue.heartbeatSchema = heartbeatSchema;
            _resultValue.mapBooleanAsBoolean = mapBooleanAsBoolean;
            _resultValue.mapJsonbAsClob = mapJsonbAsClob;
            _resultValue.mapLongVarcharAs = mapLongVarcharAs;
            _resultValue.maxFileSize = maxFileSize;
            _resultValue.pluginName = pluginName;
            _resultValue.slotName = slotName;
            return _resultValue;
        }
    }
}
