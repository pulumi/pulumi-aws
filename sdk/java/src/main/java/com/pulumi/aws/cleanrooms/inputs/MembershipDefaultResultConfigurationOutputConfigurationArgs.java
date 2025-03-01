// *** WARNING: this file was generated by pulumi-java-gen. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

package com.pulumi.aws.cleanrooms.inputs;

import com.pulumi.aws.cleanrooms.inputs.MembershipDefaultResultConfigurationOutputConfigurationS3Args;
import com.pulumi.core.Output;
import com.pulumi.core.annotations.Import;
import java.util.Objects;
import java.util.Optional;
import javax.annotation.Nullable;


public final class MembershipDefaultResultConfigurationOutputConfigurationArgs extends com.pulumi.resources.ResourceArgs {

    public static final MembershipDefaultResultConfigurationOutputConfigurationArgs Empty = new MembershipDefaultResultConfigurationOutputConfigurationArgs();

    @Import(name="s3")
    private @Nullable Output<MembershipDefaultResultConfigurationOutputConfigurationS3Args> s3;

    public Optional<Output<MembershipDefaultResultConfigurationOutputConfigurationS3Args>> s3() {
        return Optional.ofNullable(this.s3);
    }

    private MembershipDefaultResultConfigurationOutputConfigurationArgs() {}

    private MembershipDefaultResultConfigurationOutputConfigurationArgs(MembershipDefaultResultConfigurationOutputConfigurationArgs $) {
        this.s3 = $.s3;
    }

    public static Builder builder() {
        return new Builder();
    }
    public static Builder builder(MembershipDefaultResultConfigurationOutputConfigurationArgs defaults) {
        return new Builder(defaults);
    }

    public static final class Builder {
        private MembershipDefaultResultConfigurationOutputConfigurationArgs $;

        public Builder() {
            $ = new MembershipDefaultResultConfigurationOutputConfigurationArgs();
        }

        public Builder(MembershipDefaultResultConfigurationOutputConfigurationArgs defaults) {
            $ = new MembershipDefaultResultConfigurationOutputConfigurationArgs(Objects.requireNonNull(defaults));
        }

        public Builder s3(@Nullable Output<MembershipDefaultResultConfigurationOutputConfigurationS3Args> s3) {
            $.s3 = s3;
            return this;
        }

        public Builder s3(MembershipDefaultResultConfigurationOutputConfigurationS3Args s3) {
            return s3(Output.of(s3));
        }

        public MembershipDefaultResultConfigurationOutputConfigurationArgs build() {
            return $;
        }
    }

}
