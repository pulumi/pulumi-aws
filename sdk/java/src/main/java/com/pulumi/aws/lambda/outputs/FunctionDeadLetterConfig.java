// *** WARNING: this file was generated by pulumi-java-gen. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

package com.pulumi.aws.lambda.outputs;

import com.pulumi.core.annotations.CustomType;
import com.pulumi.exceptions.MissingRequiredPropertyException;
import java.lang.String;
import java.util.Objects;

@CustomType
public final class FunctionDeadLetterConfig {
    /**
     * @return ARN of an SNS topic or SQS queue to notify when an invocation fails. If this option is used, the function&#39;s IAM role must be granted suitable access to write to the target object, which means allowing either the `sns:Publish` or `sqs:SendMessage` action on this ARN, depending on which service is targeted.
     * 
     */
    private String targetArn;

    private FunctionDeadLetterConfig() {}
    /**
     * @return ARN of an SNS topic or SQS queue to notify when an invocation fails. If this option is used, the function&#39;s IAM role must be granted suitable access to write to the target object, which means allowing either the `sns:Publish` or `sqs:SendMessage` action on this ARN, depending on which service is targeted.
     * 
     */
    public String targetArn() {
        return this.targetArn;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static Builder builder(FunctionDeadLetterConfig defaults) {
        return new Builder(defaults);
    }
    @CustomType.Builder
    public static final class Builder {
        private String targetArn;
        public Builder() {}
        public Builder(FunctionDeadLetterConfig defaults) {
    	      Objects.requireNonNull(defaults);
    	      this.targetArn = defaults.targetArn;
        }

        @CustomType.Setter
        public Builder targetArn(String targetArn) {
            if (targetArn == null) {
              throw new MissingRequiredPropertyException("FunctionDeadLetterConfig", "targetArn");
            }
            this.targetArn = targetArn;
            return this;
        }
        public FunctionDeadLetterConfig build() {
            final var _resultValue = new FunctionDeadLetterConfig();
            _resultValue.targetArn = targetArn;
            return _resultValue;
        }
    }
}
