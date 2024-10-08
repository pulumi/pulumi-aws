// *** WARNING: this file was generated by pulumi-java-gen. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

package com.pulumi.aws.dms.outputs;

import com.pulumi.core.annotations.CustomType;
import java.lang.Boolean;
import java.lang.Integer;
import java.lang.String;
import java.util.Objects;
import java.util.Optional;
import javax.annotation.Nullable;

@CustomType
public final class EndpointPostgresSettings {
    /**
     * @return For use with change data capture (CDC) only, this attribute has AWS DMS bypass foreign keys and user triggers to reduce the time it takes to bulk load data.
     * 
     */
    private @Nullable String afterConnectScript;
    /**
     * @return The Babelfish for Aurora PostgreSQL database name for the endpoint.
     * 
     */
    private @Nullable String babelfishDatabaseName;
    /**
     * @return To capture DDL events, AWS DMS creates various artifacts in the PostgreSQL database when the task starts.
     * 
     */
    private @Nullable Boolean captureDdls;
    /**
     * @return Specifies the default behavior of the replication&#39;s handling of PostgreSQL- compatible endpoints that require some additional configuration, such as Babelfish endpoints.
     * 
     */
    private @Nullable String databaseMode;
    /**
     * @return Sets the schema in which the operational DDL database artifacts are created. Default is `public`.
     * 
     */
    private @Nullable String ddlArtifactsSchema;
    /**
     * @return Sets the client statement timeout for the PostgreSQL instance, in seconds. Default value is `60`.
     * 
     */
    private @Nullable Integer executeTimeout;
    /**
     * @return When set to `true`, this value causes a task to fail if the actual size of a LOB column is greater than the specified `LobMaxSize`. Default is `false`.
     * 
     */
    private @Nullable Boolean failTasksOnLobTruncation;
    /**
     * @return The write-ahead log (WAL) heartbeat feature mimics a dummy transaction. By doing this, it prevents idle logical replication slots from holding onto old WAL logs, which can result in storage full situations on the source.
     * 
     */
    private @Nullable Boolean heartbeatEnable;
    /**
     * @return Sets the WAL heartbeat frequency (in minutes). Default value is `5`.
     * 
     */
    private @Nullable Integer heartbeatFrequency;
    /**
     * @return Sets the schema in which the heartbeat artifacts are created. Default value is `public`.
     * 
     */
    private @Nullable String heartbeatSchema;
    /**
     * @return You can use PostgreSQL endpoint settings to map a boolean as a boolean from your PostgreSQL source to a Amazon Redshift target. Default value is `false`.
     * 
     */
    private @Nullable Boolean mapBooleanAsBoolean;
    /**
     * @return Optional When true, DMS migrates JSONB values as CLOB.
     * 
     */
    private @Nullable Boolean mapJsonbAsClob;
    /**
     * @return Optional When true, DMS migrates LONG values as VARCHAR.
     * 
     */
    private @Nullable String mapLongVarcharAs;
    /**
     * @return Specifies the maximum size (in KB) of any .csv file used to transfer data to PostgreSQL. Default is `32,768 KB`.
     * 
     */
    private @Nullable Integer maxFileSize;
    /**
     * @return Specifies the plugin to use to create a replication slot. Valid values: `pglogical`, `test_decoding`.
     * 
     */
    private @Nullable String pluginName;
    /**
     * @return Sets the name of a previously created logical replication slot for a CDC load of the PostgreSQL source instance.
     * 
     */
    private @Nullable String slotName;

    private EndpointPostgresSettings() {}
    /**
     * @return For use with change data capture (CDC) only, this attribute has AWS DMS bypass foreign keys and user triggers to reduce the time it takes to bulk load data.
     * 
     */
    public Optional<String> afterConnectScript() {
        return Optional.ofNullable(this.afterConnectScript);
    }
    /**
     * @return The Babelfish for Aurora PostgreSQL database name for the endpoint.
     * 
     */
    public Optional<String> babelfishDatabaseName() {
        return Optional.ofNullable(this.babelfishDatabaseName);
    }
    /**
     * @return To capture DDL events, AWS DMS creates various artifacts in the PostgreSQL database when the task starts.
     * 
     */
    public Optional<Boolean> captureDdls() {
        return Optional.ofNullable(this.captureDdls);
    }
    /**
     * @return Specifies the default behavior of the replication&#39;s handling of PostgreSQL- compatible endpoints that require some additional configuration, such as Babelfish endpoints.
     * 
     */
    public Optional<String> databaseMode() {
        return Optional.ofNullable(this.databaseMode);
    }
    /**
     * @return Sets the schema in which the operational DDL database artifacts are created. Default is `public`.
     * 
     */
    public Optional<String> ddlArtifactsSchema() {
        return Optional.ofNullable(this.ddlArtifactsSchema);
    }
    /**
     * @return Sets the client statement timeout for the PostgreSQL instance, in seconds. Default value is `60`.
     * 
     */
    public Optional<Integer> executeTimeout() {
        return Optional.ofNullable(this.executeTimeout);
    }
    /**
     * @return When set to `true`, this value causes a task to fail if the actual size of a LOB column is greater than the specified `LobMaxSize`. Default is `false`.
     * 
     */
    public Optional<Boolean> failTasksOnLobTruncation() {
        return Optional.ofNullable(this.failTasksOnLobTruncation);
    }
    /**
     * @return The write-ahead log (WAL) heartbeat feature mimics a dummy transaction. By doing this, it prevents idle logical replication slots from holding onto old WAL logs, which can result in storage full situations on the source.
     * 
     */
    public Optional<Boolean> heartbeatEnable() {
        return Optional.ofNullable(this.heartbeatEnable);
    }
    /**
     * @return Sets the WAL heartbeat frequency (in minutes). Default value is `5`.
     * 
     */
    public Optional<Integer> heartbeatFrequency() {
        return Optional.ofNullable(this.heartbeatFrequency);
    }
    /**
     * @return Sets the schema in which the heartbeat artifacts are created. Default value is `public`.
     * 
     */
    public Optional<String> heartbeatSchema() {
        return Optional.ofNullable(this.heartbeatSchema);
    }
    /**
     * @return You can use PostgreSQL endpoint settings to map a boolean as a boolean from your PostgreSQL source to a Amazon Redshift target. Default value is `false`.
     * 
     */
    public Optional<Boolean> mapBooleanAsBoolean() {
        return Optional.ofNullable(this.mapBooleanAsBoolean);
    }
    /**
     * @return Optional When true, DMS migrates JSONB values as CLOB.
     * 
     */
    public Optional<Boolean> mapJsonbAsClob() {
        return Optional.ofNullable(this.mapJsonbAsClob);
    }
    /**
     * @return Optional When true, DMS migrates LONG values as VARCHAR.
     * 
     */
    public Optional<String> mapLongVarcharAs() {
        return Optional.ofNullable(this.mapLongVarcharAs);
    }
    /**
     * @return Specifies the maximum size (in KB) of any .csv file used to transfer data to PostgreSQL. Default is `32,768 KB`.
     * 
     */
    public Optional<Integer> maxFileSize() {
        return Optional.ofNullable(this.maxFileSize);
    }
    /**
     * @return Specifies the plugin to use to create a replication slot. Valid values: `pglogical`, `test_decoding`.
     * 
     */
    public Optional<String> pluginName() {
        return Optional.ofNullable(this.pluginName);
    }
    /**
     * @return Sets the name of a previously created logical replication slot for a CDC load of the PostgreSQL source instance.
     * 
     */
    public Optional<String> slotName() {
        return Optional.ofNullable(this.slotName);
    }

    public static Builder builder() {
        return new Builder();
    }

    public static Builder builder(EndpointPostgresSettings defaults) {
        return new Builder(defaults);
    }
    @CustomType.Builder
    public static final class Builder {
        private @Nullable String afterConnectScript;
        private @Nullable String babelfishDatabaseName;
        private @Nullable Boolean captureDdls;
        private @Nullable String databaseMode;
        private @Nullable String ddlArtifactsSchema;
        private @Nullable Integer executeTimeout;
        private @Nullable Boolean failTasksOnLobTruncation;
        private @Nullable Boolean heartbeatEnable;
        private @Nullable Integer heartbeatFrequency;
        private @Nullable String heartbeatSchema;
        private @Nullable Boolean mapBooleanAsBoolean;
        private @Nullable Boolean mapJsonbAsClob;
        private @Nullable String mapLongVarcharAs;
        private @Nullable Integer maxFileSize;
        private @Nullable String pluginName;
        private @Nullable String slotName;
        public Builder() {}
        public Builder(EndpointPostgresSettings defaults) {
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
        public Builder afterConnectScript(@Nullable String afterConnectScript) {

            this.afterConnectScript = afterConnectScript;
            return this;
        }
        @CustomType.Setter
        public Builder babelfishDatabaseName(@Nullable String babelfishDatabaseName) {

            this.babelfishDatabaseName = babelfishDatabaseName;
            return this;
        }
        @CustomType.Setter
        public Builder captureDdls(@Nullable Boolean captureDdls) {

            this.captureDdls = captureDdls;
            return this;
        }
        @CustomType.Setter
        public Builder databaseMode(@Nullable String databaseMode) {

            this.databaseMode = databaseMode;
            return this;
        }
        @CustomType.Setter
        public Builder ddlArtifactsSchema(@Nullable String ddlArtifactsSchema) {

            this.ddlArtifactsSchema = ddlArtifactsSchema;
            return this;
        }
        @CustomType.Setter
        public Builder executeTimeout(@Nullable Integer executeTimeout) {

            this.executeTimeout = executeTimeout;
            return this;
        }
        @CustomType.Setter
        public Builder failTasksOnLobTruncation(@Nullable Boolean failTasksOnLobTruncation) {

            this.failTasksOnLobTruncation = failTasksOnLobTruncation;
            return this;
        }
        @CustomType.Setter
        public Builder heartbeatEnable(@Nullable Boolean heartbeatEnable) {

            this.heartbeatEnable = heartbeatEnable;
            return this;
        }
        @CustomType.Setter
        public Builder heartbeatFrequency(@Nullable Integer heartbeatFrequency) {

            this.heartbeatFrequency = heartbeatFrequency;
            return this;
        }
        @CustomType.Setter
        public Builder heartbeatSchema(@Nullable String heartbeatSchema) {

            this.heartbeatSchema = heartbeatSchema;
            return this;
        }
        @CustomType.Setter
        public Builder mapBooleanAsBoolean(@Nullable Boolean mapBooleanAsBoolean) {

            this.mapBooleanAsBoolean = mapBooleanAsBoolean;
            return this;
        }
        @CustomType.Setter
        public Builder mapJsonbAsClob(@Nullable Boolean mapJsonbAsClob) {

            this.mapJsonbAsClob = mapJsonbAsClob;
            return this;
        }
        @CustomType.Setter
        public Builder mapLongVarcharAs(@Nullable String mapLongVarcharAs) {

            this.mapLongVarcharAs = mapLongVarcharAs;
            return this;
        }
        @CustomType.Setter
        public Builder maxFileSize(@Nullable Integer maxFileSize) {

            this.maxFileSize = maxFileSize;
            return this;
        }
        @CustomType.Setter
        public Builder pluginName(@Nullable String pluginName) {

            this.pluginName = pluginName;
            return this;
        }
        @CustomType.Setter
        public Builder slotName(@Nullable String slotName) {

            this.slotName = slotName;
            return this;
        }
        public EndpointPostgresSettings build() {
            final var _resultValue = new EndpointPostgresSettings();
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
