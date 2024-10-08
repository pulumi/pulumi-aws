// *** WARNING: this file was generated by pulumi-java-gen. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

package com.pulumi.aws.verifiedpermissions.inputs;

import com.pulumi.core.Output;
import com.pulumi.core.annotations.Import;
import com.pulumi.exceptions.MissingRequiredPropertyException;
import java.lang.String;
import java.util.Objects;


public final class IdentitySourceConfigurationCognitoUserPoolConfigurationGroupConfigurationArgs extends com.pulumi.resources.ResourceArgs {

    public static final IdentitySourceConfigurationCognitoUserPoolConfigurationGroupConfigurationArgs Empty = new IdentitySourceConfigurationCognitoUserPoolConfigurationGroupConfigurationArgs();

    /**
     * The name of the schema entity type that&#39;s mapped to the user pool group. Defaults to `AWS::CognitoGroup`.
     * 
     */
    @Import(name="groupEntityType", required=true)
    private Output<String> groupEntityType;

    /**
     * @return The name of the schema entity type that&#39;s mapped to the user pool group. Defaults to `AWS::CognitoGroup`.
     * 
     */
    public Output<String> groupEntityType() {
        return this.groupEntityType;
    }

    private IdentitySourceConfigurationCognitoUserPoolConfigurationGroupConfigurationArgs() {}

    private IdentitySourceConfigurationCognitoUserPoolConfigurationGroupConfigurationArgs(IdentitySourceConfigurationCognitoUserPoolConfigurationGroupConfigurationArgs $) {
        this.groupEntityType = $.groupEntityType;
    }

    public static Builder builder() {
        return new Builder();
    }
    public static Builder builder(IdentitySourceConfigurationCognitoUserPoolConfigurationGroupConfigurationArgs defaults) {
        return new Builder(defaults);
    }

    public static final class Builder {
        private IdentitySourceConfigurationCognitoUserPoolConfigurationGroupConfigurationArgs $;

        public Builder() {
            $ = new IdentitySourceConfigurationCognitoUserPoolConfigurationGroupConfigurationArgs();
        }

        public Builder(IdentitySourceConfigurationCognitoUserPoolConfigurationGroupConfigurationArgs defaults) {
            $ = new IdentitySourceConfigurationCognitoUserPoolConfigurationGroupConfigurationArgs(Objects.requireNonNull(defaults));
        }

        /**
         * @param groupEntityType The name of the schema entity type that&#39;s mapped to the user pool group. Defaults to `AWS::CognitoGroup`.
         * 
         * @return builder
         * 
         */
        public Builder groupEntityType(Output<String> groupEntityType) {
            $.groupEntityType = groupEntityType;
            return this;
        }

        /**
         * @param groupEntityType The name of the schema entity type that&#39;s mapped to the user pool group. Defaults to `AWS::CognitoGroup`.
         * 
         * @return builder
         * 
         */
        public Builder groupEntityType(String groupEntityType) {
            return groupEntityType(Output.of(groupEntityType));
        }

        public IdentitySourceConfigurationCognitoUserPoolConfigurationGroupConfigurationArgs build() {
            if ($.groupEntityType == null) {
                throw new MissingRequiredPropertyException("IdentitySourceConfigurationCognitoUserPoolConfigurationGroupConfigurationArgs", "groupEntityType");
            }
            return $;
        }
    }

}
