// *** WARNING: this file was generated by pulumi-java-gen. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

package com.pulumi.aws.kendra.inputs;

import com.pulumi.core.Output;
import com.pulumi.core.annotations.Import;
import java.lang.String;
import java.util.Objects;
import java.util.Optional;
import javax.annotation.Nullable;


public final class DataSourceConfigurationS3ConfigurationAccessControlListConfigurationArgs extends com.pulumi.resources.ResourceArgs {

    public static final DataSourceConfigurationS3ConfigurationAccessControlListConfigurationArgs Empty = new DataSourceConfigurationS3ConfigurationAccessControlListConfigurationArgs();

    /**
     * Path to the AWS S3 bucket that contains the ACL files.
     * 
     */
    @Import(name="keyPath")
    private @Nullable Output<String> keyPath;

    /**
     * @return Path to the AWS S3 bucket that contains the ACL files.
     * 
     */
    public Optional<Output<String>> keyPath() {
        return Optional.ofNullable(this.keyPath);
    }

    private DataSourceConfigurationS3ConfigurationAccessControlListConfigurationArgs() {}

    private DataSourceConfigurationS3ConfigurationAccessControlListConfigurationArgs(DataSourceConfigurationS3ConfigurationAccessControlListConfigurationArgs $) {
        this.keyPath = $.keyPath;
    }

    public static Builder builder() {
        return new Builder();
    }
    public static Builder builder(DataSourceConfigurationS3ConfigurationAccessControlListConfigurationArgs defaults) {
        return new Builder(defaults);
    }

    public static final class Builder {
        private DataSourceConfigurationS3ConfigurationAccessControlListConfigurationArgs $;

        public Builder() {
            $ = new DataSourceConfigurationS3ConfigurationAccessControlListConfigurationArgs();
        }

        public Builder(DataSourceConfigurationS3ConfigurationAccessControlListConfigurationArgs defaults) {
            $ = new DataSourceConfigurationS3ConfigurationAccessControlListConfigurationArgs(Objects.requireNonNull(defaults));
        }

        /**
         * @param keyPath Path to the AWS S3 bucket that contains the ACL files.
         * 
         * @return builder
         * 
         */
        public Builder keyPath(@Nullable Output<String> keyPath) {
            $.keyPath = keyPath;
            return this;
        }

        /**
         * @param keyPath Path to the AWS S3 bucket that contains the ACL files.
         * 
         * @return builder
         * 
         */
        public Builder keyPath(String keyPath) {
            return keyPath(Output.of(keyPath));
        }

        public DataSourceConfigurationS3ConfigurationAccessControlListConfigurationArgs build() {
            return $;
        }
    }

}
