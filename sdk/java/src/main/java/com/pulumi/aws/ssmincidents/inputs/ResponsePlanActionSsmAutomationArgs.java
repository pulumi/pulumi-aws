// *** WARNING: this file was generated by pulumi-java-gen. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

package com.pulumi.aws.ssmincidents.inputs;

import com.pulumi.aws.ssmincidents.inputs.ResponsePlanActionSsmAutomationParameterArgs;
import com.pulumi.core.Output;
import com.pulumi.core.annotations.Import;
import java.lang.String;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import javax.annotation.Nullable;


public final class ResponsePlanActionSsmAutomationArgs extends com.pulumi.resources.ResourceArgs {

    public static final ResponsePlanActionSsmAutomationArgs Empty = new ResponsePlanActionSsmAutomationArgs();

    /**
     * The automation document&#39;s name.
     * 
     */
    @Import(name="documentName", required=true)
    private Output<String> documentName;

    /**
     * @return The automation document&#39;s name.
     * 
     */
    public Output<String> documentName() {
        return this.documentName;
    }

    /**
     * The version of the automation document to use at runtime.
     * 
     */
    @Import(name="documentVersion")
    private @Nullable Output<String> documentVersion;

    /**
     * @return The version of the automation document to use at runtime.
     * 
     */
    public Optional<Output<String>> documentVersion() {
        return Optional.ofNullable(this.documentVersion);
    }

    /**
     * The key-value pair to resolve dynamic parameter values when processing a Systems Manager Automation runbook.
     * 
     */
    @Import(name="dynamicParameters")
    private @Nullable Output<Map<String,String>> dynamicParameters;

    /**
     * @return The key-value pair to resolve dynamic parameter values when processing a Systems Manager Automation runbook.
     * 
     */
    public Optional<Output<Map<String,String>>> dynamicParameters() {
        return Optional.ofNullable(this.dynamicParameters);
    }

    /**
     * The key-value pair parameters to use when the automation document runs. The following values are supported:
     * 
     */
    @Import(name="parameters")
    private @Nullable Output<List<ResponsePlanActionSsmAutomationParameterArgs>> parameters;

    /**
     * @return The key-value pair parameters to use when the automation document runs. The following values are supported:
     * 
     */
    public Optional<Output<List<ResponsePlanActionSsmAutomationParameterArgs>>> parameters() {
        return Optional.ofNullable(this.parameters);
    }

    /**
     * The Amazon Resource Name (ARN) of the role that the automation document assumes when it runs commands.
     * 
     */
    @Import(name="roleArn", required=true)
    private Output<String> roleArn;

    /**
     * @return The Amazon Resource Name (ARN) of the role that the automation document assumes when it runs commands.
     * 
     */
    public Output<String> roleArn() {
        return this.roleArn;
    }

    /**
     * The account that the automation document runs in. This can be in either the management account or an application account.
     * 
     */
    @Import(name="targetAccount")
    private @Nullable Output<String> targetAccount;

    /**
     * @return The account that the automation document runs in. This can be in either the management account or an application account.
     * 
     */
    public Optional<Output<String>> targetAccount() {
        return Optional.ofNullable(this.targetAccount);
    }

    private ResponsePlanActionSsmAutomationArgs() {}

    private ResponsePlanActionSsmAutomationArgs(ResponsePlanActionSsmAutomationArgs $) {
        this.documentName = $.documentName;
        this.documentVersion = $.documentVersion;
        this.dynamicParameters = $.dynamicParameters;
        this.parameters = $.parameters;
        this.roleArn = $.roleArn;
        this.targetAccount = $.targetAccount;
    }

    public static Builder builder() {
        return new Builder();
    }
    public static Builder builder(ResponsePlanActionSsmAutomationArgs defaults) {
        return new Builder(defaults);
    }

    public static final class Builder {
        private ResponsePlanActionSsmAutomationArgs $;

        public Builder() {
            $ = new ResponsePlanActionSsmAutomationArgs();
        }

        public Builder(ResponsePlanActionSsmAutomationArgs defaults) {
            $ = new ResponsePlanActionSsmAutomationArgs(Objects.requireNonNull(defaults));
        }

        /**
         * @param documentName The automation document&#39;s name.
         * 
         * @return builder
         * 
         */
        public Builder documentName(Output<String> documentName) {
            $.documentName = documentName;
            return this;
        }

        /**
         * @param documentName The automation document&#39;s name.
         * 
         * @return builder
         * 
         */
        public Builder documentName(String documentName) {
            return documentName(Output.of(documentName));
        }

        /**
         * @param documentVersion The version of the automation document to use at runtime.
         * 
         * @return builder
         * 
         */
        public Builder documentVersion(@Nullable Output<String> documentVersion) {
            $.documentVersion = documentVersion;
            return this;
        }

        /**
         * @param documentVersion The version of the automation document to use at runtime.
         * 
         * @return builder
         * 
         */
        public Builder documentVersion(String documentVersion) {
            return documentVersion(Output.of(documentVersion));
        }

        /**
         * @param dynamicParameters The key-value pair to resolve dynamic parameter values when processing a Systems Manager Automation runbook.
         * 
         * @return builder
         * 
         */
        public Builder dynamicParameters(@Nullable Output<Map<String,String>> dynamicParameters) {
            $.dynamicParameters = dynamicParameters;
            return this;
        }

        /**
         * @param dynamicParameters The key-value pair to resolve dynamic parameter values when processing a Systems Manager Automation runbook.
         * 
         * @return builder
         * 
         */
        public Builder dynamicParameters(Map<String,String> dynamicParameters) {
            return dynamicParameters(Output.of(dynamicParameters));
        }

        /**
         * @param parameters The key-value pair parameters to use when the automation document runs. The following values are supported:
         * 
         * @return builder
         * 
         */
        public Builder parameters(@Nullable Output<List<ResponsePlanActionSsmAutomationParameterArgs>> parameters) {
            $.parameters = parameters;
            return this;
        }

        /**
         * @param parameters The key-value pair parameters to use when the automation document runs. The following values are supported:
         * 
         * @return builder
         * 
         */
        public Builder parameters(List<ResponsePlanActionSsmAutomationParameterArgs> parameters) {
            return parameters(Output.of(parameters));
        }

        /**
         * @param parameters The key-value pair parameters to use when the automation document runs. The following values are supported:
         * 
         * @return builder
         * 
         */
        public Builder parameters(ResponsePlanActionSsmAutomationParameterArgs... parameters) {
            return parameters(List.of(parameters));
        }

        /**
         * @param roleArn The Amazon Resource Name (ARN) of the role that the automation document assumes when it runs commands.
         * 
         * @return builder
         * 
         */
        public Builder roleArn(Output<String> roleArn) {
            $.roleArn = roleArn;
            return this;
        }

        /**
         * @param roleArn The Amazon Resource Name (ARN) of the role that the automation document assumes when it runs commands.
         * 
         * @return builder
         * 
         */
        public Builder roleArn(String roleArn) {
            return roleArn(Output.of(roleArn));
        }

        /**
         * @param targetAccount The account that the automation document runs in. This can be in either the management account or an application account.
         * 
         * @return builder
         * 
         */
        public Builder targetAccount(@Nullable Output<String> targetAccount) {
            $.targetAccount = targetAccount;
            return this;
        }

        /**
         * @param targetAccount The account that the automation document runs in. This can be in either the management account or an application account.
         * 
         * @return builder
         * 
         */
        public Builder targetAccount(String targetAccount) {
            return targetAccount(Output.of(targetAccount));
        }

        public ResponsePlanActionSsmAutomationArgs build() {
            $.documentName = Objects.requireNonNull($.documentName, "expected parameter 'documentName' to be non-null");
            $.roleArn = Objects.requireNonNull($.roleArn, "expected parameter 'roleArn' to be non-null");
            return $;
        }
    }

}