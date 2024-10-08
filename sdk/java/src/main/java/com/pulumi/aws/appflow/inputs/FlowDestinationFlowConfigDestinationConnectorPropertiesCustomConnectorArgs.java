// *** WARNING: this file was generated by pulumi-java-gen. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

package com.pulumi.aws.appflow.inputs;

import com.pulumi.aws.appflow.inputs.FlowDestinationFlowConfigDestinationConnectorPropertiesCustomConnectorErrorHandlingConfigArgs;
import com.pulumi.core.Output;
import com.pulumi.core.annotations.Import;
import com.pulumi.exceptions.MissingRequiredPropertyException;
import java.lang.String;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import javax.annotation.Nullable;


public final class FlowDestinationFlowConfigDestinationConnectorPropertiesCustomConnectorArgs extends com.pulumi.resources.ResourceArgs {

    public static final FlowDestinationFlowConfigDestinationConnectorPropertiesCustomConnectorArgs Empty = new FlowDestinationFlowConfigDestinationConnectorPropertiesCustomConnectorArgs();

    @Import(name="customProperties")
    private @Nullable Output<Map<String,String>> customProperties;

    public Optional<Output<Map<String,String>>> customProperties() {
        return Optional.ofNullable(this.customProperties);
    }

    @Import(name="entityName", required=true)
    private Output<String> entityName;

    public Output<String> entityName() {
        return this.entityName;
    }

    @Import(name="errorHandlingConfig")
    private @Nullable Output<FlowDestinationFlowConfigDestinationConnectorPropertiesCustomConnectorErrorHandlingConfigArgs> errorHandlingConfig;

    public Optional<Output<FlowDestinationFlowConfigDestinationConnectorPropertiesCustomConnectorErrorHandlingConfigArgs>> errorHandlingConfig() {
        return Optional.ofNullable(this.errorHandlingConfig);
    }

    @Import(name="idFieldNames")
    private @Nullable Output<List<String>> idFieldNames;

    public Optional<Output<List<String>>> idFieldNames() {
        return Optional.ofNullable(this.idFieldNames);
    }

    @Import(name="writeOperationType")
    private @Nullable Output<String> writeOperationType;

    public Optional<Output<String>> writeOperationType() {
        return Optional.ofNullable(this.writeOperationType);
    }

    private FlowDestinationFlowConfigDestinationConnectorPropertiesCustomConnectorArgs() {}

    private FlowDestinationFlowConfigDestinationConnectorPropertiesCustomConnectorArgs(FlowDestinationFlowConfigDestinationConnectorPropertiesCustomConnectorArgs $) {
        this.customProperties = $.customProperties;
        this.entityName = $.entityName;
        this.errorHandlingConfig = $.errorHandlingConfig;
        this.idFieldNames = $.idFieldNames;
        this.writeOperationType = $.writeOperationType;
    }

    public static Builder builder() {
        return new Builder();
    }
    public static Builder builder(FlowDestinationFlowConfigDestinationConnectorPropertiesCustomConnectorArgs defaults) {
        return new Builder(defaults);
    }

    public static final class Builder {
        private FlowDestinationFlowConfigDestinationConnectorPropertiesCustomConnectorArgs $;

        public Builder() {
            $ = new FlowDestinationFlowConfigDestinationConnectorPropertiesCustomConnectorArgs();
        }

        public Builder(FlowDestinationFlowConfigDestinationConnectorPropertiesCustomConnectorArgs defaults) {
            $ = new FlowDestinationFlowConfigDestinationConnectorPropertiesCustomConnectorArgs(Objects.requireNonNull(defaults));
        }

        public Builder customProperties(@Nullable Output<Map<String,String>> customProperties) {
            $.customProperties = customProperties;
            return this;
        }

        public Builder customProperties(Map<String,String> customProperties) {
            return customProperties(Output.of(customProperties));
        }

        public Builder entityName(Output<String> entityName) {
            $.entityName = entityName;
            return this;
        }

        public Builder entityName(String entityName) {
            return entityName(Output.of(entityName));
        }

        public Builder errorHandlingConfig(@Nullable Output<FlowDestinationFlowConfigDestinationConnectorPropertiesCustomConnectorErrorHandlingConfigArgs> errorHandlingConfig) {
            $.errorHandlingConfig = errorHandlingConfig;
            return this;
        }

        public Builder errorHandlingConfig(FlowDestinationFlowConfigDestinationConnectorPropertiesCustomConnectorErrorHandlingConfigArgs errorHandlingConfig) {
            return errorHandlingConfig(Output.of(errorHandlingConfig));
        }

        public Builder idFieldNames(@Nullable Output<List<String>> idFieldNames) {
            $.idFieldNames = idFieldNames;
            return this;
        }

        public Builder idFieldNames(List<String> idFieldNames) {
            return idFieldNames(Output.of(idFieldNames));
        }

        public Builder idFieldNames(String... idFieldNames) {
            return idFieldNames(List.of(idFieldNames));
        }

        public Builder writeOperationType(@Nullable Output<String> writeOperationType) {
            $.writeOperationType = writeOperationType;
            return this;
        }

        public Builder writeOperationType(String writeOperationType) {
            return writeOperationType(Output.of(writeOperationType));
        }

        public FlowDestinationFlowConfigDestinationConnectorPropertiesCustomConnectorArgs build() {
            if ($.entityName == null) {
                throw new MissingRequiredPropertyException("FlowDestinationFlowConfigDestinationConnectorPropertiesCustomConnectorArgs", "entityName");
            }
            return $;
        }
    }

}
