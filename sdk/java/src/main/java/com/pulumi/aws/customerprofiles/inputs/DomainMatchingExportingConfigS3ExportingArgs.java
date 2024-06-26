// *** WARNING: this file was generated by pulumi-java-gen. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

package com.pulumi.aws.customerprofiles.inputs;

import com.pulumi.core.Output;
import com.pulumi.core.annotations.Import;
import com.pulumi.exceptions.MissingRequiredPropertyException;
import java.lang.String;
import java.util.Objects;
import java.util.Optional;
import javax.annotation.Nullable;


public final class DomainMatchingExportingConfigS3ExportingArgs extends com.pulumi.resources.ResourceArgs {

    public static final DomainMatchingExportingConfigS3ExportingArgs Empty = new DomainMatchingExportingConfigS3ExportingArgs();

    @Import(name="s3BucketName", required=true)
    private Output<String> s3BucketName;

    public Output<String> s3BucketName() {
        return this.s3BucketName;
    }

    @Import(name="s3KeyName")
    private @Nullable Output<String> s3KeyName;

    public Optional<Output<String>> s3KeyName() {
        return Optional.ofNullable(this.s3KeyName);
    }

    private DomainMatchingExportingConfigS3ExportingArgs() {}

    private DomainMatchingExportingConfigS3ExportingArgs(DomainMatchingExportingConfigS3ExportingArgs $) {
        this.s3BucketName = $.s3BucketName;
        this.s3KeyName = $.s3KeyName;
    }

    public static Builder builder() {
        return new Builder();
    }
    public static Builder builder(DomainMatchingExportingConfigS3ExportingArgs defaults) {
        return new Builder(defaults);
    }

    public static final class Builder {
        private DomainMatchingExportingConfigS3ExportingArgs $;

        public Builder() {
            $ = new DomainMatchingExportingConfigS3ExportingArgs();
        }

        public Builder(DomainMatchingExportingConfigS3ExportingArgs defaults) {
            $ = new DomainMatchingExportingConfigS3ExportingArgs(Objects.requireNonNull(defaults));
        }

        public Builder s3BucketName(Output<String> s3BucketName) {
            $.s3BucketName = s3BucketName;
            return this;
        }

        public Builder s3BucketName(String s3BucketName) {
            return s3BucketName(Output.of(s3BucketName));
        }

        public Builder s3KeyName(@Nullable Output<String> s3KeyName) {
            $.s3KeyName = s3KeyName;
            return this;
        }

        public Builder s3KeyName(String s3KeyName) {
            return s3KeyName(Output.of(s3KeyName));
        }

        public DomainMatchingExportingConfigS3ExportingArgs build() {
            if ($.s3BucketName == null) {
                throw new MissingRequiredPropertyException("DomainMatchingExportingConfigS3ExportingArgs", "s3BucketName");
            }
            return $;
        }
    }

}
