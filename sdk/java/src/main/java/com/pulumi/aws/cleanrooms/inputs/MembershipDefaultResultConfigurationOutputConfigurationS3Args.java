// *** WARNING: this file was generated by pulumi-java-gen. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

package com.pulumi.aws.cleanrooms.inputs;

import com.pulumi.core.Output;
import com.pulumi.core.annotations.Import;
import com.pulumi.exceptions.MissingRequiredPropertyException;
import java.lang.String;
import java.util.Objects;
import java.util.Optional;
import javax.annotation.Nullable;


public final class MembershipDefaultResultConfigurationOutputConfigurationS3Args extends com.pulumi.resources.ResourceArgs {

    public static final MembershipDefaultResultConfigurationOutputConfigurationS3Args Empty = new MembershipDefaultResultConfigurationOutputConfigurationS3Args();

    @Import(name="bucket", required=true)
    private Output<String> bucket;

    public Output<String> bucket() {
        return this.bucket;
    }

    @Import(name="keyPrefix")
    private @Nullable Output<String> keyPrefix;

    public Optional<Output<String>> keyPrefix() {
        return Optional.ofNullable(this.keyPrefix);
    }

    @Import(name="resultFormat", required=true)
    private Output<String> resultFormat;

    public Output<String> resultFormat() {
        return this.resultFormat;
    }

    private MembershipDefaultResultConfigurationOutputConfigurationS3Args() {}

    private MembershipDefaultResultConfigurationOutputConfigurationS3Args(MembershipDefaultResultConfigurationOutputConfigurationS3Args $) {
        this.bucket = $.bucket;
        this.keyPrefix = $.keyPrefix;
        this.resultFormat = $.resultFormat;
    }

    public static Builder builder() {
        return new Builder();
    }
    public static Builder builder(MembershipDefaultResultConfigurationOutputConfigurationS3Args defaults) {
        return new Builder(defaults);
    }

    public static final class Builder {
        private MembershipDefaultResultConfigurationOutputConfigurationS3Args $;

        public Builder() {
            $ = new MembershipDefaultResultConfigurationOutputConfigurationS3Args();
        }

        public Builder(MembershipDefaultResultConfigurationOutputConfigurationS3Args defaults) {
            $ = new MembershipDefaultResultConfigurationOutputConfigurationS3Args(Objects.requireNonNull(defaults));
        }

        public Builder bucket(Output<String> bucket) {
            $.bucket = bucket;
            return this;
        }

        public Builder bucket(String bucket) {
            return bucket(Output.of(bucket));
        }

        public Builder keyPrefix(@Nullable Output<String> keyPrefix) {
            $.keyPrefix = keyPrefix;
            return this;
        }

        public Builder keyPrefix(String keyPrefix) {
            return keyPrefix(Output.of(keyPrefix));
        }

        public Builder resultFormat(Output<String> resultFormat) {
            $.resultFormat = resultFormat;
            return this;
        }

        public Builder resultFormat(String resultFormat) {
            return resultFormat(Output.of(resultFormat));
        }

        public MembershipDefaultResultConfigurationOutputConfigurationS3Args build() {
            if ($.bucket == null) {
                throw new MissingRequiredPropertyException("MembershipDefaultResultConfigurationOutputConfigurationS3Args", "bucket");
            }
            if ($.resultFormat == null) {
                throw new MissingRequiredPropertyException("MembershipDefaultResultConfigurationOutputConfigurationS3Args", "resultFormat");
            }
            return $;
        }
    }

}
