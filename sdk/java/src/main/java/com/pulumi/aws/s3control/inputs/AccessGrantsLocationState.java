// *** WARNING: this file was generated by pulumi-java-gen. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

package com.pulumi.aws.s3control.inputs;

import com.pulumi.core.Output;
import com.pulumi.core.annotations.Import;
import java.lang.String;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import javax.annotation.Nullable;


public final class AccessGrantsLocationState extends com.pulumi.resources.ResourceArgs {

    public static final AccessGrantsLocationState Empty = new AccessGrantsLocationState();

    /**
     * Amazon Resource Name (ARN) of the S3 Access Grants location.
     * 
     */
    @Import(name="accessGrantsLocationArn")
    private @Nullable Output<String> accessGrantsLocationArn;

    /**
     * @return Amazon Resource Name (ARN) of the S3 Access Grants location.
     * 
     */
    public Optional<Output<String>> accessGrantsLocationArn() {
        return Optional.ofNullable(this.accessGrantsLocationArn);
    }

    /**
     * Unique ID of the S3 Access Grants location.
     * 
     */
    @Import(name="accessGrantsLocationId")
    private @Nullable Output<String> accessGrantsLocationId;

    /**
     * @return Unique ID of the S3 Access Grants location.
     * 
     */
    public Optional<Output<String>> accessGrantsLocationId() {
        return Optional.ofNullable(this.accessGrantsLocationId);
    }

    @Import(name="accountId")
    private @Nullable Output<String> accountId;

    public Optional<Output<String>> accountId() {
        return Optional.ofNullable(this.accountId);
    }

    /**
     * The ARN of the IAM role that S3 Access Grants should use when fulfilling runtime access
     * requests to the location.
     * 
     */
    @Import(name="iamRoleArn")
    private @Nullable Output<String> iamRoleArn;

    /**
     * @return The ARN of the IAM role that S3 Access Grants should use when fulfilling runtime access
     * requests to the location.
     * 
     */
    public Optional<Output<String>> iamRoleArn() {
        return Optional.ofNullable(this.iamRoleArn);
    }

    /**
     * The default S3 URI `s3://` or the URI to a custom location, a specific bucket or prefix.
     * 
     */
    @Import(name="locationScope")
    private @Nullable Output<String> locationScope;

    /**
     * @return The default S3 URI `s3://` or the URI to a custom location, a specific bucket or prefix.
     * 
     */
    public Optional<Output<String>> locationScope() {
        return Optional.ofNullable(this.locationScope);
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

    /**
     * A map of tags assigned to the resource, including those inherited from the provider `default_tags` configuration block.
     * 
     * @deprecated
     * Please use `tags` instead.
     * 
     */
    @Deprecated /* Please use `tags` instead. */
    @Import(name="tagsAll")
    private @Nullable Output<Map<String,String>> tagsAll;

    /**
     * @return A map of tags assigned to the resource, including those inherited from the provider `default_tags` configuration block.
     * 
     * @deprecated
     * Please use `tags` instead.
     * 
     */
    @Deprecated /* Please use `tags` instead. */
    public Optional<Output<Map<String,String>>> tagsAll() {
        return Optional.ofNullable(this.tagsAll);
    }

    private AccessGrantsLocationState() {}

    private AccessGrantsLocationState(AccessGrantsLocationState $) {
        this.accessGrantsLocationArn = $.accessGrantsLocationArn;
        this.accessGrantsLocationId = $.accessGrantsLocationId;
        this.accountId = $.accountId;
        this.iamRoleArn = $.iamRoleArn;
        this.locationScope = $.locationScope;
        this.tags = $.tags;
        this.tagsAll = $.tagsAll;
    }

    public static Builder builder() {
        return new Builder();
    }
    public static Builder builder(AccessGrantsLocationState defaults) {
        return new Builder(defaults);
    }

    public static final class Builder {
        private AccessGrantsLocationState $;

        public Builder() {
            $ = new AccessGrantsLocationState();
        }

        public Builder(AccessGrantsLocationState defaults) {
            $ = new AccessGrantsLocationState(Objects.requireNonNull(defaults));
        }

        /**
         * @param accessGrantsLocationArn Amazon Resource Name (ARN) of the S3 Access Grants location.
         * 
         * @return builder
         * 
         */
        public Builder accessGrantsLocationArn(@Nullable Output<String> accessGrantsLocationArn) {
            $.accessGrantsLocationArn = accessGrantsLocationArn;
            return this;
        }

        /**
         * @param accessGrantsLocationArn Amazon Resource Name (ARN) of the S3 Access Grants location.
         * 
         * @return builder
         * 
         */
        public Builder accessGrantsLocationArn(String accessGrantsLocationArn) {
            return accessGrantsLocationArn(Output.of(accessGrantsLocationArn));
        }

        /**
         * @param accessGrantsLocationId Unique ID of the S3 Access Grants location.
         * 
         * @return builder
         * 
         */
        public Builder accessGrantsLocationId(@Nullable Output<String> accessGrantsLocationId) {
            $.accessGrantsLocationId = accessGrantsLocationId;
            return this;
        }

        /**
         * @param accessGrantsLocationId Unique ID of the S3 Access Grants location.
         * 
         * @return builder
         * 
         */
        public Builder accessGrantsLocationId(String accessGrantsLocationId) {
            return accessGrantsLocationId(Output.of(accessGrantsLocationId));
        }

        public Builder accountId(@Nullable Output<String> accountId) {
            $.accountId = accountId;
            return this;
        }

        public Builder accountId(String accountId) {
            return accountId(Output.of(accountId));
        }

        /**
         * @param iamRoleArn The ARN of the IAM role that S3 Access Grants should use when fulfilling runtime access
         * requests to the location.
         * 
         * @return builder
         * 
         */
        public Builder iamRoleArn(@Nullable Output<String> iamRoleArn) {
            $.iamRoleArn = iamRoleArn;
            return this;
        }

        /**
         * @param iamRoleArn The ARN of the IAM role that S3 Access Grants should use when fulfilling runtime access
         * requests to the location.
         * 
         * @return builder
         * 
         */
        public Builder iamRoleArn(String iamRoleArn) {
            return iamRoleArn(Output.of(iamRoleArn));
        }

        /**
         * @param locationScope The default S3 URI `s3://` or the URI to a custom location, a specific bucket or prefix.
         * 
         * @return builder
         * 
         */
        public Builder locationScope(@Nullable Output<String> locationScope) {
            $.locationScope = locationScope;
            return this;
        }

        /**
         * @param locationScope The default S3 URI `s3://` or the URI to a custom location, a specific bucket or prefix.
         * 
         * @return builder
         * 
         */
        public Builder locationScope(String locationScope) {
            return locationScope(Output.of(locationScope));
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

        /**
         * @param tagsAll A map of tags assigned to the resource, including those inherited from the provider `default_tags` configuration block.
         * 
         * @return builder
         * 
         * @deprecated
         * Please use `tags` instead.
         * 
         */
        @Deprecated /* Please use `tags` instead. */
        public Builder tagsAll(@Nullable Output<Map<String,String>> tagsAll) {
            $.tagsAll = tagsAll;
            return this;
        }

        /**
         * @param tagsAll A map of tags assigned to the resource, including those inherited from the provider `default_tags` configuration block.
         * 
         * @return builder
         * 
         * @deprecated
         * Please use `tags` instead.
         * 
         */
        @Deprecated /* Please use `tags` instead. */
        public Builder tagsAll(Map<String,String> tagsAll) {
            return tagsAll(Output.of(tagsAll));
        }

        public AccessGrantsLocationState build() {
            return $;
        }
    }

}
