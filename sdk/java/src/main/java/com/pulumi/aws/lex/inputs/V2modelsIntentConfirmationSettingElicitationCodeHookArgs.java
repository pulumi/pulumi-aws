// *** WARNING: this file was generated by pulumi-java-gen. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

package com.pulumi.aws.lex.inputs;

import com.pulumi.core.Output;
import com.pulumi.core.annotations.Import;
import java.lang.Boolean;
import java.lang.String;
import java.util.Objects;
import java.util.Optional;
import javax.annotation.Nullable;


public final class V2modelsIntentConfirmationSettingElicitationCodeHookArgs extends com.pulumi.resources.ResourceArgs {

    public static final V2modelsIntentConfirmationSettingElicitationCodeHookArgs Empty = new V2modelsIntentConfirmationSettingElicitationCodeHookArgs();

    /**
     * Whether a Lambda function should be invoked for the dialog.
     * 
     */
    @Import(name="enableCodeHookInvocation")
    private @Nullable Output<Boolean> enableCodeHookInvocation;

    /**
     * @return Whether a Lambda function should be invoked for the dialog.
     * 
     */
    public Optional<Output<Boolean>> enableCodeHookInvocation() {
        return Optional.ofNullable(this.enableCodeHookInvocation);
    }

    /**
     * Label that indicates the dialog step from which the dialog code hook is happening.
     * 
     */
    @Import(name="invocationLabel")
    private @Nullable Output<String> invocationLabel;

    /**
     * @return Label that indicates the dialog step from which the dialog code hook is happening.
     * 
     */
    public Optional<Output<String>> invocationLabel() {
        return Optional.ofNullable(this.invocationLabel);
    }

    private V2modelsIntentConfirmationSettingElicitationCodeHookArgs() {}

    private V2modelsIntentConfirmationSettingElicitationCodeHookArgs(V2modelsIntentConfirmationSettingElicitationCodeHookArgs $) {
        this.enableCodeHookInvocation = $.enableCodeHookInvocation;
        this.invocationLabel = $.invocationLabel;
    }

    public static Builder builder() {
        return new Builder();
    }
    public static Builder builder(V2modelsIntentConfirmationSettingElicitationCodeHookArgs defaults) {
        return new Builder(defaults);
    }

    public static final class Builder {
        private V2modelsIntentConfirmationSettingElicitationCodeHookArgs $;

        public Builder() {
            $ = new V2modelsIntentConfirmationSettingElicitationCodeHookArgs();
        }

        public Builder(V2modelsIntentConfirmationSettingElicitationCodeHookArgs defaults) {
            $ = new V2modelsIntentConfirmationSettingElicitationCodeHookArgs(Objects.requireNonNull(defaults));
        }

        /**
         * @param enableCodeHookInvocation Whether a Lambda function should be invoked for the dialog.
         * 
         * @return builder
         * 
         */
        public Builder enableCodeHookInvocation(@Nullable Output<Boolean> enableCodeHookInvocation) {
            $.enableCodeHookInvocation = enableCodeHookInvocation;
            return this;
        }

        /**
         * @param enableCodeHookInvocation Whether a Lambda function should be invoked for the dialog.
         * 
         * @return builder
         * 
         */
        public Builder enableCodeHookInvocation(Boolean enableCodeHookInvocation) {
            return enableCodeHookInvocation(Output.of(enableCodeHookInvocation));
        }

        /**
         * @param invocationLabel Label that indicates the dialog step from which the dialog code hook is happening.
         * 
         * @return builder
         * 
         */
        public Builder invocationLabel(@Nullable Output<String> invocationLabel) {
            $.invocationLabel = invocationLabel;
            return this;
        }

        /**
         * @param invocationLabel Label that indicates the dialog step from which the dialog code hook is happening.
         * 
         * @return builder
         * 
         */
        public Builder invocationLabel(String invocationLabel) {
            return invocationLabel(Output.of(invocationLabel));
        }

        public V2modelsIntentConfirmationSettingElicitationCodeHookArgs build() {
            return $;
        }
    }

}
