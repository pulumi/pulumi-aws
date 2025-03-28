// *** WARNING: this file was generated by pulumi-java-gen. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

package com.pulumi.aws.s3.inputs;

import com.pulumi.core.Output;
import com.pulumi.core.annotations.Import;
import com.pulumi.exceptions.MissingRequiredPropertyException;
import java.lang.String;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import javax.annotation.Nullable;


public final class ObjectCopyGrantArgs extends com.pulumi.resources.ResourceArgs {

    public static final ObjectCopyGrantArgs Empty = new ObjectCopyGrantArgs();

    /**
     * Email address of the grantee. Used only when `type` is `AmazonCustomerByEmail`.
     * 
     */
    @Import(name="email")
    private @Nullable Output<String> email;

    /**
     * @return Email address of the grantee. Used only when `type` is `AmazonCustomerByEmail`.
     * 
     */
    public Optional<Output<String>> email() {
        return Optional.ofNullable(this.email);
    }

    /**
     * Canonical user ID of the grantee. Used only when `type` is `CanonicalUser`.
     * 
     */
    @Import(name="id")
    private @Nullable Output<String> id;

    /**
     * @return Canonical user ID of the grantee. Used only when `type` is `CanonicalUser`.
     * 
     */
    public Optional<Output<String>> id() {
        return Optional.ofNullable(this.id);
    }

    /**
     * List of permissions to grant to grantee. Valid values are `READ`, `READ_ACP`, `WRITE_ACP`, `FULL_CONTROL`.
     * 
     */
    @Import(name="permissions", required=true)
    private Output<List<String>> permissions;

    /**
     * @return List of permissions to grant to grantee. Valid values are `READ`, `READ_ACP`, `WRITE_ACP`, `FULL_CONTROL`.
     * 
     */
    public Output<List<String>> permissions() {
        return this.permissions;
    }

    /**
     * Type of grantee. Valid values are `CanonicalUser`, `Group`, and `AmazonCustomerByEmail`.
     * 
     * This configuration block has the following optional arguments (one of the three is required):
     * 
     */
    @Import(name="type", required=true)
    private Output<String> type;

    /**
     * @return Type of grantee. Valid values are `CanonicalUser`, `Group`, and `AmazonCustomerByEmail`.
     * 
     * This configuration block has the following optional arguments (one of the three is required):
     * 
     */
    public Output<String> type() {
        return this.type;
    }

    /**
     * URI of the grantee group. Used only when `type` is `Group`.
     * 
     */
    @Import(name="uri")
    private @Nullable Output<String> uri;

    /**
     * @return URI of the grantee group. Used only when `type` is `Group`.
     * 
     */
    public Optional<Output<String>> uri() {
        return Optional.ofNullable(this.uri);
    }

    private ObjectCopyGrantArgs() {}

    private ObjectCopyGrantArgs(ObjectCopyGrantArgs $) {
        this.email = $.email;
        this.id = $.id;
        this.permissions = $.permissions;
        this.type = $.type;
        this.uri = $.uri;
    }

    public static Builder builder() {
        return new Builder();
    }
    public static Builder builder(ObjectCopyGrantArgs defaults) {
        return new Builder(defaults);
    }

    public static final class Builder {
        private ObjectCopyGrantArgs $;

        public Builder() {
            $ = new ObjectCopyGrantArgs();
        }

        public Builder(ObjectCopyGrantArgs defaults) {
            $ = new ObjectCopyGrantArgs(Objects.requireNonNull(defaults));
        }

        /**
         * @param email Email address of the grantee. Used only when `type` is `AmazonCustomerByEmail`.
         * 
         * @return builder
         * 
         */
        public Builder email(@Nullable Output<String> email) {
            $.email = email;
            return this;
        }

        /**
         * @param email Email address of the grantee. Used only when `type` is `AmazonCustomerByEmail`.
         * 
         * @return builder
         * 
         */
        public Builder email(String email) {
            return email(Output.of(email));
        }

        /**
         * @param id Canonical user ID of the grantee. Used only when `type` is `CanonicalUser`.
         * 
         * @return builder
         * 
         */
        public Builder id(@Nullable Output<String> id) {
            $.id = id;
            return this;
        }

        /**
         * @param id Canonical user ID of the grantee. Used only when `type` is `CanonicalUser`.
         * 
         * @return builder
         * 
         */
        public Builder id(String id) {
            return id(Output.of(id));
        }

        /**
         * @param permissions List of permissions to grant to grantee. Valid values are `READ`, `READ_ACP`, `WRITE_ACP`, `FULL_CONTROL`.
         * 
         * @return builder
         * 
         */
        public Builder permissions(Output<List<String>> permissions) {
            $.permissions = permissions;
            return this;
        }

        /**
         * @param permissions List of permissions to grant to grantee. Valid values are `READ`, `READ_ACP`, `WRITE_ACP`, `FULL_CONTROL`.
         * 
         * @return builder
         * 
         */
        public Builder permissions(List<String> permissions) {
            return permissions(Output.of(permissions));
        }

        /**
         * @param permissions List of permissions to grant to grantee. Valid values are `READ`, `READ_ACP`, `WRITE_ACP`, `FULL_CONTROL`.
         * 
         * @return builder
         * 
         */
        public Builder permissions(String... permissions) {
            return permissions(List.of(permissions));
        }

        /**
         * @param type Type of grantee. Valid values are `CanonicalUser`, `Group`, and `AmazonCustomerByEmail`.
         * 
         * This configuration block has the following optional arguments (one of the three is required):
         * 
         * @return builder
         * 
         */
        public Builder type(Output<String> type) {
            $.type = type;
            return this;
        }

        /**
         * @param type Type of grantee. Valid values are `CanonicalUser`, `Group`, and `AmazonCustomerByEmail`.
         * 
         * This configuration block has the following optional arguments (one of the three is required):
         * 
         * @return builder
         * 
         */
        public Builder type(String type) {
            return type(Output.of(type));
        }

        /**
         * @param uri URI of the grantee group. Used only when `type` is `Group`.
         * 
         * @return builder
         * 
         */
        public Builder uri(@Nullable Output<String> uri) {
            $.uri = uri;
            return this;
        }

        /**
         * @param uri URI of the grantee group. Used only when `type` is `Group`.
         * 
         * @return builder
         * 
         */
        public Builder uri(String uri) {
            return uri(Output.of(uri));
        }

        public ObjectCopyGrantArgs build() {
            if ($.permissions == null) {
                throw new MissingRequiredPropertyException("ObjectCopyGrantArgs", "permissions");
            }
            if ($.type == null) {
                throw new MissingRequiredPropertyException("ObjectCopyGrantArgs", "type");
            }
            return $;
        }
    }

}
