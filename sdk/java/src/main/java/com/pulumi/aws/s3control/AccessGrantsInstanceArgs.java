// *** WARNING: this file was generated by pulumi-java-gen. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

package com.pulumi.aws.s3control;

import com.pulumi.core.Output;
import com.pulumi.core.annotations.Import;
import java.lang.String;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import javax.annotation.Nullable;


public final class AccessGrantsInstanceArgs extends com.pulumi.resources.ResourceArgs {

    public static final AccessGrantsInstanceArgs Empty = new AccessGrantsInstanceArgs();

    @Import(name="accountId")
    private @Nullable Output<String> accountId;

    public Optional<Output<String>> accountId() {
        return Optional.ofNullable(this.accountId);
    }

    /**
     * The ARN of the AWS IAM Identity Center instance associated with the S3 Access Grants instance.
     * 
     */
    @Import(name="identityCenterArn")
    private @Nullable Output<String> identityCenterArn;

    /**
     * @return The ARN of the AWS IAM Identity Center instance associated with the S3 Access Grants instance.
     * 
     */
    public Optional<Output<String>> identityCenterArn() {
        return Optional.ofNullable(this.identityCenterArn);
    }

    /**
     * Key-value map of resource tags. If configured with a provider `default_tags` configuration block present, tags with matching keys will overwrite those defined at the provider-level.
     * 
     */
    @Import(name="tags")
    private @Nullable Output<Map<String,String>> tags;

    /**
     * @return Key-value map of resource tags. If configured with a provider `default_tags` configuration block present, tags with matching keys will overwrite those defined at the provider-level.
     * 
     */
    public Optional<Output<Map<String,String>>> tags() {
        return Optional.ofNullable(this.tags);
    }

    private AccessGrantsInstanceArgs() {}

    private AccessGrantsInstanceArgs(AccessGrantsInstanceArgs $) {
        this.accountId = $.accountId;
        this.identityCenterArn = $.identityCenterArn;
        this.tags = $.tags;
    }

    public static Builder builder() {
        return new Builder();
    }
    public static Builder builder(AccessGrantsInstanceArgs defaults) {
        return new Builder(defaults);
    }

    public static final class Builder {
        private AccessGrantsInstanceArgs $;

        public Builder() {
            $ = new AccessGrantsInstanceArgs();
        }

        public Builder(AccessGrantsInstanceArgs defaults) {
            $ = new AccessGrantsInstanceArgs(Objects.requireNonNull(defaults));
        }

        public Builder accountId(@Nullable Output<String> accountId) {
            $.accountId = accountId;
            return this;
        }

        public Builder accountId(String accountId) {
            return accountId(Output.of(accountId));
        }

        /**
         * @param identityCenterArn The ARN of the AWS IAM Identity Center instance associated with the S3 Access Grants instance.
         * 
         * @return builder
         * 
         */
        public Builder identityCenterArn(@Nullable Output<String> identityCenterArn) {
            $.identityCenterArn = identityCenterArn;
            return this;
        }

        /**
         * @param identityCenterArn The ARN of the AWS IAM Identity Center instance associated with the S3 Access Grants instance.
         * 
         * @return builder
         * 
         */
        public Builder identityCenterArn(String identityCenterArn) {
            return identityCenterArn(Output.of(identityCenterArn));
        }

        /**
         * @param tags Key-value map of resource tags. If configured with a provider `default_tags` configuration block present, tags with matching keys will overwrite those defined at the provider-level.
         * 
         * @return builder
         * 
         */
        public Builder tags(@Nullable Output<Map<String,String>> tags) {
            $.tags = tags;
            return this;
        }

        /**
         * @param tags Key-value map of resource tags. If configured with a provider `default_tags` configuration block present, tags with matching keys will overwrite those defined at the provider-level.
         * 
         * @return builder
         * 
         */
        public Builder tags(Map<String,String> tags) {
            return tags(Output.of(tags));
        }

        public AccessGrantsInstanceArgs build() {
            return $;
        }
    }

}
