// *** WARNING: this file was generated by pulumi-java-gen. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

package com.pulumi.aws.transfer.outputs;

import com.pulumi.core.annotations.CustomType;
import com.pulumi.exceptions.MissingRequiredPropertyException;
import java.lang.String;
import java.util.Objects;

@CustomType
public final class ServerWorkflowDetailsOnPartialUpload {
    /**
     * @return Includes the necessary permissions for S3, EFS, and Lambda operations that Transfer can assume, so that all workflow steps can operate on the required resources.
     * 
     */
    private String executionRole;
    /**
     * @return A unique identifier for the workflow.
     * 
     */
    private String workflowId;

    private ServerWorkflowDetailsOnPartialUpload() {}
    /**
     * @return Includes the necessary permissions for S3, EFS, and Lambda operations that Transfer can assume, so that all workflow steps can operate on the required resources.
     * 
     */
    public String executionRole() {
        return this.executionRole;
    }
    /**
     * @return A unique identifier for the workflow.
     * 
     */
    public String workflowId() {
        return this.workflowId;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static Builder builder(ServerWorkflowDetailsOnPartialUpload defaults) {
        return new Builder(defaults);
    }
    @CustomType.Builder
    public static final class Builder {
        private String executionRole;
        private String workflowId;
        public Builder() {}
        public Builder(ServerWorkflowDetailsOnPartialUpload defaults) {
    	      Objects.requireNonNull(defaults);
    	      this.executionRole = defaults.executionRole;
    	      this.workflowId = defaults.workflowId;
        }

        @CustomType.Setter
        public Builder executionRole(String executionRole) {
            if (executionRole == null) {
              throw new MissingRequiredPropertyException("ServerWorkflowDetailsOnPartialUpload", "executionRole");
            }
            this.executionRole = executionRole;
            return this;
        }
        @CustomType.Setter
        public Builder workflowId(String workflowId) {
            if (workflowId == null) {
              throw new MissingRequiredPropertyException("ServerWorkflowDetailsOnPartialUpload", "workflowId");
            }
            this.workflowId = workflowId;
            return this;
        }
        public ServerWorkflowDetailsOnPartialUpload build() {
            final var _resultValue = new ServerWorkflowDetailsOnPartialUpload();
            _resultValue.executionRole = executionRole;
            _resultValue.workflowId = workflowId;
            return _resultValue;
        }
    }
}
