// *** WARNING: this file was generated by pulumi-java-gen. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

package com.pulumi.aws.ssm.inputs;

import com.pulumi.core.Output;
import com.pulumi.core.annotations.Import;
import com.pulumi.exceptions.MissingRequiredPropertyException;
import java.lang.String;
import java.util.Objects;


public final class GetContactsRotationArgs extends com.pulumi.resources.InvokeArgs {

    public static final GetContactsRotationArgs Empty = new GetContactsRotationArgs();

    /**
     * The Amazon Resource Name (ARN) of the rotation.
     * 
     */
    @Import(name="arn", required=true)
    private Output<String> arn;

    /**
     * @return The Amazon Resource Name (ARN) of the rotation.
     * 
     */
    public Output<String> arn() {
        return this.arn;
    }

    private GetContactsRotationArgs() {}

    private GetContactsRotationArgs(GetContactsRotationArgs $) {
        this.arn = $.arn;
    }

    public static Builder builder() {
        return new Builder();
    }
    public static Builder builder(GetContactsRotationArgs defaults) {
        return new Builder(defaults);
    }

    public static final class Builder {
        private GetContactsRotationArgs $;

        public Builder() {
            $ = new GetContactsRotationArgs();
        }

        public Builder(GetContactsRotationArgs defaults) {
            $ = new GetContactsRotationArgs(Objects.requireNonNull(defaults));
        }

        /**
         * @param arn The Amazon Resource Name (ARN) of the rotation.
         * 
         * @return builder
         * 
         */
        public Builder arn(Output<String> arn) {
            $.arn = arn;
            return this;
        }

        /**
         * @param arn The Amazon Resource Name (ARN) of the rotation.
         * 
         * @return builder
         * 
         */
        public Builder arn(String arn) {
            return arn(Output.of(arn));
        }

        public GetContactsRotationArgs build() {
            if ($.arn == null) {
                throw new MissingRequiredPropertyException("GetContactsRotationArgs", "arn");
            }
            return $;
        }
    }

}
