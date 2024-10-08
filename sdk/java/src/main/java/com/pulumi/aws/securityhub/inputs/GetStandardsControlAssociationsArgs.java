// *** WARNING: this file was generated by pulumi-java-gen. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

package com.pulumi.aws.securityhub.inputs;

import com.pulumi.core.Output;
import com.pulumi.core.annotations.Import;
import com.pulumi.exceptions.MissingRequiredPropertyException;
import java.lang.String;
import java.util.Objects;


public final class GetStandardsControlAssociationsArgs extends com.pulumi.resources.InvokeArgs {

    public static final GetStandardsControlAssociationsArgs Empty = new GetStandardsControlAssociationsArgs();

    /**
     * The identifier of the control (identified with `SecurityControlId`, `SecurityControlArn`, or a mix of both parameters).
     * 
     */
    @Import(name="securityControlId", required=true)
    private Output<String> securityControlId;

    /**
     * @return The identifier of the control (identified with `SecurityControlId`, `SecurityControlArn`, or a mix of both parameters).
     * 
     */
    public Output<String> securityControlId() {
        return this.securityControlId;
    }

    private GetStandardsControlAssociationsArgs() {}

    private GetStandardsControlAssociationsArgs(GetStandardsControlAssociationsArgs $) {
        this.securityControlId = $.securityControlId;
    }

    public static Builder builder() {
        return new Builder();
    }
    public static Builder builder(GetStandardsControlAssociationsArgs defaults) {
        return new Builder(defaults);
    }

    public static final class Builder {
        private GetStandardsControlAssociationsArgs $;

        public Builder() {
            $ = new GetStandardsControlAssociationsArgs();
        }

        public Builder(GetStandardsControlAssociationsArgs defaults) {
            $ = new GetStandardsControlAssociationsArgs(Objects.requireNonNull(defaults));
        }

        /**
         * @param securityControlId The identifier of the control (identified with `SecurityControlId`, `SecurityControlArn`, or a mix of both parameters).
         * 
         * @return builder
         * 
         */
        public Builder securityControlId(Output<String> securityControlId) {
            $.securityControlId = securityControlId;
            return this;
        }

        /**
         * @param securityControlId The identifier of the control (identified with `SecurityControlId`, `SecurityControlArn`, or a mix of both parameters).
         * 
         * @return builder
         * 
         */
        public Builder securityControlId(String securityControlId) {
            return securityControlId(Output.of(securityControlId));
        }

        public GetStandardsControlAssociationsArgs build() {
            if ($.securityControlId == null) {
                throw new MissingRequiredPropertyException("GetStandardsControlAssociationsArgs", "securityControlId");
            }
            return $;
        }
    }

}
