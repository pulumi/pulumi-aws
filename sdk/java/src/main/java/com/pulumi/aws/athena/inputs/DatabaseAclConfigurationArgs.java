// *** WARNING: this file was generated by pulumi-java-gen. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

package com.pulumi.aws.athena.inputs;

import com.pulumi.core.Output;
import com.pulumi.core.annotations.Import;
import com.pulumi.exceptions.MissingRequiredPropertyException;
import java.lang.String;
import java.util.Objects;


public final class DatabaseAclConfigurationArgs extends com.pulumi.resources.ResourceArgs {

    public static final DatabaseAclConfigurationArgs Empty = new DatabaseAclConfigurationArgs();

    /**
     * Amazon S3 canned ACL that Athena should specify when storing query results. Valid value is `BUCKET_OWNER_FULL_CONTROL`.
     * 
     * &gt; **NOTE:** When Athena queries are executed, result files may be created in the specified bucket. Consider using `force_destroy` on the bucket too in order to avoid any problems when destroying the bucket.
     * 
     */
    @Import(name="s3AclOption", required=true)
    private Output<String> s3AclOption;

    /**
     * @return Amazon S3 canned ACL that Athena should specify when storing query results. Valid value is `BUCKET_OWNER_FULL_CONTROL`.
     * 
     * &gt; **NOTE:** When Athena queries are executed, result files may be created in the specified bucket. Consider using `force_destroy` on the bucket too in order to avoid any problems when destroying the bucket.
     * 
     */
    public Output<String> s3AclOption() {
        return this.s3AclOption;
    }

    private DatabaseAclConfigurationArgs() {}

    private DatabaseAclConfigurationArgs(DatabaseAclConfigurationArgs $) {
        this.s3AclOption = $.s3AclOption;
    }

    public static Builder builder() {
        return new Builder();
    }
    public static Builder builder(DatabaseAclConfigurationArgs defaults) {
        return new Builder(defaults);
    }

    public static final class Builder {
        private DatabaseAclConfigurationArgs $;

        public Builder() {
            $ = new DatabaseAclConfigurationArgs();
        }

        public Builder(DatabaseAclConfigurationArgs defaults) {
            $ = new DatabaseAclConfigurationArgs(Objects.requireNonNull(defaults));
        }

        /**
         * @param s3AclOption Amazon S3 canned ACL that Athena should specify when storing query results. Valid value is `BUCKET_OWNER_FULL_CONTROL`.
         * 
         * &gt; **NOTE:** When Athena queries are executed, result files may be created in the specified bucket. Consider using `force_destroy` on the bucket too in order to avoid any problems when destroying the bucket.
         * 
         * @return builder
         * 
         */
        public Builder s3AclOption(Output<String> s3AclOption) {
            $.s3AclOption = s3AclOption;
            return this;
        }

        /**
         * @param s3AclOption Amazon S3 canned ACL that Athena should specify when storing query results. Valid value is `BUCKET_OWNER_FULL_CONTROL`.
         * 
         * &gt; **NOTE:** When Athena queries are executed, result files may be created in the specified bucket. Consider using `force_destroy` on the bucket too in order to avoid any problems when destroying the bucket.
         * 
         * @return builder
         * 
         */
        public Builder s3AclOption(String s3AclOption) {
            return s3AclOption(Output.of(s3AclOption));
        }

        public DatabaseAclConfigurationArgs build() {
            if ($.s3AclOption == null) {
                throw new MissingRequiredPropertyException("DatabaseAclConfigurationArgs", "s3AclOption");
            }
            return $;
        }
    }

}
