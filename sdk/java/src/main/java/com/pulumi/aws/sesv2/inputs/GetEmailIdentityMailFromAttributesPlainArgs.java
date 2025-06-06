// *** WARNING: this file was generated by pulumi-java-gen. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

package com.pulumi.aws.sesv2.inputs;

import com.pulumi.core.annotations.Import;
import com.pulumi.exceptions.MissingRequiredPropertyException;
import java.lang.String;
import java.util.Objects;


public final class GetEmailIdentityMailFromAttributesPlainArgs extends com.pulumi.resources.InvokeArgs {

    public static final GetEmailIdentityMailFromAttributesPlainArgs Empty = new GetEmailIdentityMailFromAttributesPlainArgs();

    /**
     * The name of the email identity.
     * 
     */
    @Import(name="emailIdentity", required=true)
    private String emailIdentity;

    /**
     * @return The name of the email identity.
     * 
     */
    public String emailIdentity() {
        return this.emailIdentity;
    }

    private GetEmailIdentityMailFromAttributesPlainArgs() {}

    private GetEmailIdentityMailFromAttributesPlainArgs(GetEmailIdentityMailFromAttributesPlainArgs $) {
        this.emailIdentity = $.emailIdentity;
    }

    public static Builder builder() {
        return new Builder();
    }
    public static Builder builder(GetEmailIdentityMailFromAttributesPlainArgs defaults) {
        return new Builder(defaults);
    }

    public static final class Builder {
        private GetEmailIdentityMailFromAttributesPlainArgs $;

        public Builder() {
            $ = new GetEmailIdentityMailFromAttributesPlainArgs();
        }

        public Builder(GetEmailIdentityMailFromAttributesPlainArgs defaults) {
            $ = new GetEmailIdentityMailFromAttributesPlainArgs(Objects.requireNonNull(defaults));
        }

        /**
         * @param emailIdentity The name of the email identity.
         * 
         * @return builder
         * 
         */
        public Builder emailIdentity(String emailIdentity) {
            $.emailIdentity = emailIdentity;
            return this;
        }

        public GetEmailIdentityMailFromAttributesPlainArgs build() {
            if ($.emailIdentity == null) {
                throw new MissingRequiredPropertyException("GetEmailIdentityMailFromAttributesPlainArgs", "emailIdentity");
            }
            return $;
        }
    }

}
