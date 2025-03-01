// *** WARNING: this file was generated by pulumi-java-gen. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

package com.pulumi.aws.cognito.inputs;

import com.pulumi.core.annotations.Import;
import com.pulumi.exceptions.MissingRequiredPropertyException;
import java.lang.String;
import java.util.Objects;


public final class GetUserPoolSigningCertificatePlainArgs extends com.pulumi.resources.InvokeArgs {

    public static final GetUserPoolSigningCertificatePlainArgs Empty = new GetUserPoolSigningCertificatePlainArgs();

    /**
     * Cognito user pool ID.
     * 
     */
    @Import(name="userPoolId", required=true)
    private String userPoolId;

    /**
     * @return Cognito user pool ID.
     * 
     */
    public String userPoolId() {
        return this.userPoolId;
    }

    private GetUserPoolSigningCertificatePlainArgs() {}

    private GetUserPoolSigningCertificatePlainArgs(GetUserPoolSigningCertificatePlainArgs $) {
        this.userPoolId = $.userPoolId;
    }

    public static Builder builder() {
        return new Builder();
    }
    public static Builder builder(GetUserPoolSigningCertificatePlainArgs defaults) {
        return new Builder(defaults);
    }

    public static final class Builder {
        private GetUserPoolSigningCertificatePlainArgs $;

        public Builder() {
            $ = new GetUserPoolSigningCertificatePlainArgs();
        }

        public Builder(GetUserPoolSigningCertificatePlainArgs defaults) {
            $ = new GetUserPoolSigningCertificatePlainArgs(Objects.requireNonNull(defaults));
        }

        /**
         * @param userPoolId Cognito user pool ID.
         * 
         * @return builder
         * 
         */
        public Builder userPoolId(String userPoolId) {
            $.userPoolId = userPoolId;
            return this;
        }

        public GetUserPoolSigningCertificatePlainArgs build() {
            if ($.userPoolId == null) {
                throw new MissingRequiredPropertyException("GetUserPoolSigningCertificatePlainArgs", "userPoolId");
            }
            return $;
        }
    }

}
