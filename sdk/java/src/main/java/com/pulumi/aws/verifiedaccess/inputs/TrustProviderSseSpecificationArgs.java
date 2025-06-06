// *** WARNING: this file was generated by pulumi-java-gen. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

package com.pulumi.aws.verifiedaccess.inputs;

import com.pulumi.core.Output;
import com.pulumi.core.annotations.Import;
import java.lang.Boolean;
import java.lang.String;
import java.util.Objects;
import java.util.Optional;
import javax.annotation.Nullable;


public final class TrustProviderSseSpecificationArgs extends com.pulumi.resources.ResourceArgs {

    public static final TrustProviderSseSpecificationArgs Empty = new TrustProviderSseSpecificationArgs();

    @Import(name="customerManagedKeyEnabled")
    private @Nullable Output<Boolean> customerManagedKeyEnabled;

    public Optional<Output<Boolean>> customerManagedKeyEnabled() {
        return Optional.ofNullable(this.customerManagedKeyEnabled);
    }

    @Import(name="kmsKeyArn")
    private @Nullable Output<String> kmsKeyArn;

    public Optional<Output<String>> kmsKeyArn() {
        return Optional.ofNullable(this.kmsKeyArn);
    }

    private TrustProviderSseSpecificationArgs() {}

    private TrustProviderSseSpecificationArgs(TrustProviderSseSpecificationArgs $) {
        this.customerManagedKeyEnabled = $.customerManagedKeyEnabled;
        this.kmsKeyArn = $.kmsKeyArn;
    }

    public static Builder builder() {
        return new Builder();
    }
    public static Builder builder(TrustProviderSseSpecificationArgs defaults) {
        return new Builder(defaults);
    }

    public static final class Builder {
        private TrustProviderSseSpecificationArgs $;

        public Builder() {
            $ = new TrustProviderSseSpecificationArgs();
        }

        public Builder(TrustProviderSseSpecificationArgs defaults) {
            $ = new TrustProviderSseSpecificationArgs(Objects.requireNonNull(defaults));
        }

        public Builder customerManagedKeyEnabled(@Nullable Output<Boolean> customerManagedKeyEnabled) {
            $.customerManagedKeyEnabled = customerManagedKeyEnabled;
            return this;
        }

        public Builder customerManagedKeyEnabled(Boolean customerManagedKeyEnabled) {
            return customerManagedKeyEnabled(Output.of(customerManagedKeyEnabled));
        }

        public Builder kmsKeyArn(@Nullable Output<String> kmsKeyArn) {
            $.kmsKeyArn = kmsKeyArn;
            return this;
        }

        public Builder kmsKeyArn(String kmsKeyArn) {
            return kmsKeyArn(Output.of(kmsKeyArn));
        }

        public TrustProviderSseSpecificationArgs build() {
            return $;
        }
    }

}
