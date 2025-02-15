// *** WARNING: this file was generated by pulumi-java-gen. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

package com.pulumi.aws.iot.inputs;

import com.pulumi.core.Output;
import com.pulumi.core.annotations.Import;
import com.pulumi.exceptions.MissingRequiredPropertyException;
import java.lang.String;
import java.util.Objects;


public final class BillingGroupMetadataArgs extends com.pulumi.resources.ResourceArgs {

    public static final BillingGroupMetadataArgs Empty = new BillingGroupMetadataArgs();

    @Import(name="creationDate", required=true)
    private Output<String> creationDate;

    public Output<String> creationDate() {
        return this.creationDate;
    }

    private BillingGroupMetadataArgs() {}

    private BillingGroupMetadataArgs(BillingGroupMetadataArgs $) {
        this.creationDate = $.creationDate;
    }

    public static Builder builder() {
        return new Builder();
    }
    public static Builder builder(BillingGroupMetadataArgs defaults) {
        return new Builder(defaults);
    }

    public static final class Builder {
        private BillingGroupMetadataArgs $;

        public Builder() {
            $ = new BillingGroupMetadataArgs();
        }

        public Builder(BillingGroupMetadataArgs defaults) {
            $ = new BillingGroupMetadataArgs(Objects.requireNonNull(defaults));
        }

        public Builder creationDate(Output<String> creationDate) {
            $.creationDate = creationDate;
            return this;
        }

        public Builder creationDate(String creationDate) {
            return creationDate(Output.of(creationDate));
        }

        public BillingGroupMetadataArgs build() {
            if ($.creationDate == null) {
                throw new MissingRequiredPropertyException("BillingGroupMetadataArgs", "creationDate");
            }
            return $;
        }
    }

}
