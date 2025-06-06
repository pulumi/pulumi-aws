// *** WARNING: this file was generated by pulumi-java-gen. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

package com.pulumi.aws.redshiftserverless.inputs;

import com.pulumi.core.Output;
import com.pulumi.core.annotations.Import;
import java.lang.Boolean;
import java.lang.String;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import javax.annotation.Nullable;


public final class NamespaceState extends com.pulumi.resources.ResourceArgs {

    public static final NamespaceState Empty = new NamespaceState();

    /**
     * Amazon Resource Name (ARN) of namespace&#39;s admin user credentials secret.
     * 
     */
    @Import(name="adminPasswordSecretArn")
    private @Nullable Output<String> adminPasswordSecretArn;

    /**
     * @return Amazon Resource Name (ARN) of namespace&#39;s admin user credentials secret.
     * 
     */
    public Optional<Output<String>> adminPasswordSecretArn() {
        return Optional.ofNullable(this.adminPasswordSecretArn);
    }

    /**
     * ID of the KMS key used to encrypt the namespace&#39;s admin credentials secret.
     * 
     */
    @Import(name="adminPasswordSecretKmsKeyId")
    private @Nullable Output<String> adminPasswordSecretKmsKeyId;

    /**
     * @return ID of the KMS key used to encrypt the namespace&#39;s admin credentials secret.
     * 
     */
    public Optional<Output<String>> adminPasswordSecretKmsKeyId() {
        return Optional.ofNullable(this.adminPasswordSecretKmsKeyId);
    }

    /**
     * The password of the administrator for the first database created in the namespace.
     * Conflicts with `manage_admin_password` and `admin_user_password_wo`.
     * 
     */
    @Import(name="adminUserPassword")
    private @Nullable Output<String> adminUserPassword;

    /**
     * @return The password of the administrator for the first database created in the namespace.
     * Conflicts with `manage_admin_password` and `admin_user_password_wo`.
     * 
     */
    public Optional<Output<String>> adminUserPassword() {
        return Optional.ofNullable(this.adminUserPassword);
    }

    /**
     * The username of the administrator for the first database created in the namespace.
     * 
     */
    @Import(name="adminUsername")
    private @Nullable Output<String> adminUsername;

    /**
     * @return The username of the administrator for the first database created in the namespace.
     * 
     */
    public Optional<Output<String>> adminUsername() {
        return Optional.ofNullable(this.adminUsername);
    }

    /**
     * Amazon Resource Name (ARN) of the Redshift Serverless Namespace.
     * 
     */
    @Import(name="arn")
    private @Nullable Output<String> arn;

    /**
     * @return Amazon Resource Name (ARN) of the Redshift Serverless Namespace.
     * 
     */
    public Optional<Output<String>> arn() {
        return Optional.ofNullable(this.arn);
    }

    /**
     * The name of the first database created in the namespace.
     * 
     */
    @Import(name="dbName")
    private @Nullable Output<String> dbName;

    /**
     * @return The name of the first database created in the namespace.
     * 
     */
    public Optional<Output<String>> dbName() {
        return Optional.ofNullable(this.dbName);
    }

    /**
     * The Amazon Resource Name (ARN) of the IAM role to set as a default in the namespace. When specifying `default_iam_role_arn`, it also must be part of `iam_roles`.
     * 
     */
    @Import(name="defaultIamRoleArn")
    private @Nullable Output<String> defaultIamRoleArn;

    /**
     * @return The Amazon Resource Name (ARN) of the IAM role to set as a default in the namespace. When specifying `default_iam_role_arn`, it also must be part of `iam_roles`.
     * 
     */
    public Optional<Output<String>> defaultIamRoleArn() {
        return Optional.ofNullable(this.defaultIamRoleArn);
    }

    /**
     * A list of IAM roles to associate with the namespace.
     * 
     */
    @Import(name="iamRoles")
    private @Nullable Output<List<String>> iamRoles;

    /**
     * @return A list of IAM roles to associate with the namespace.
     * 
     */
    public Optional<Output<List<String>>> iamRoles() {
        return Optional.ofNullable(this.iamRoles);
    }

    /**
     * The ARN of the Amazon Web Services Key Management Service key used to encrypt your data.
     * 
     */
    @Import(name="kmsKeyId")
    private @Nullable Output<String> kmsKeyId;

    /**
     * @return The ARN of the Amazon Web Services Key Management Service key used to encrypt your data.
     * 
     */
    public Optional<Output<String>> kmsKeyId() {
        return Optional.ofNullable(this.kmsKeyId);
    }

    /**
     * The types of logs the namespace can export. Available export types are `userlog`, `connectionlog`, and `useractivitylog`.
     * 
     */
    @Import(name="logExports")
    private @Nullable Output<List<String>> logExports;

    /**
     * @return The types of logs the namespace can export. Available export types are `userlog`, `connectionlog`, and `useractivitylog`.
     * 
     */
    public Optional<Output<List<String>>> logExports() {
        return Optional.ofNullable(this.logExports);
    }

    /**
     * Whether to use AWS SecretManager to manage namespace&#39;s admin credentials.
     * Conflicts with `admin_user_password` and `admin_user_password_wo`.
     * 
     */
    @Import(name="manageAdminPassword")
    private @Nullable Output<Boolean> manageAdminPassword;

    /**
     * @return Whether to use AWS SecretManager to manage namespace&#39;s admin credentials.
     * Conflicts with `admin_user_password` and `admin_user_password_wo`.
     * 
     */
    public Optional<Output<Boolean>> manageAdminPassword() {
        return Optional.ofNullable(this.manageAdminPassword);
    }

    /**
     * The Redshift Namespace ID.
     * 
     */
    @Import(name="namespaceId")
    private @Nullable Output<String> namespaceId;

    /**
     * @return The Redshift Namespace ID.
     * 
     */
    public Optional<Output<String>> namespaceId() {
        return Optional.ofNullable(this.namespaceId);
    }

    /**
     * The name of the namespace.
     * 
     */
    @Import(name="namespaceName")
    private @Nullable Output<String> namespaceName;

    /**
     * @return The name of the namespace.
     * 
     */
    public Optional<Output<String>> namespaceName() {
        return Optional.ofNullable(this.namespaceName);
    }

    /**
     * A map of tags to assign to the resource. If configured with a provider `default_tags` configuration block present, tags with matching keys will overwrite those defined at the provider-level.
     * 
     */
    @Import(name="tags")
    private @Nullable Output<Map<String,String>> tags;

    /**
     * @return A map of tags to assign to the resource. If configured with a provider `default_tags` configuration block present, tags with matching keys will overwrite those defined at the provider-level.
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

    private NamespaceState() {}

    private NamespaceState(NamespaceState $) {
        this.adminPasswordSecretArn = $.adminPasswordSecretArn;
        this.adminPasswordSecretKmsKeyId = $.adminPasswordSecretKmsKeyId;
        this.adminUserPassword = $.adminUserPassword;
        this.adminUsername = $.adminUsername;
        this.arn = $.arn;
        this.dbName = $.dbName;
        this.defaultIamRoleArn = $.defaultIamRoleArn;
        this.iamRoles = $.iamRoles;
        this.kmsKeyId = $.kmsKeyId;
        this.logExports = $.logExports;
        this.manageAdminPassword = $.manageAdminPassword;
        this.namespaceId = $.namespaceId;
        this.namespaceName = $.namespaceName;
        this.tags = $.tags;
        this.tagsAll = $.tagsAll;
    }

    public static Builder builder() {
        return new Builder();
    }
    public static Builder builder(NamespaceState defaults) {
        return new Builder(defaults);
    }

    public static final class Builder {
        private NamespaceState $;

        public Builder() {
            $ = new NamespaceState();
        }

        public Builder(NamespaceState defaults) {
            $ = new NamespaceState(Objects.requireNonNull(defaults));
        }

        /**
         * @param adminPasswordSecretArn Amazon Resource Name (ARN) of namespace&#39;s admin user credentials secret.
         * 
         * @return builder
         * 
         */
        public Builder adminPasswordSecretArn(@Nullable Output<String> adminPasswordSecretArn) {
            $.adminPasswordSecretArn = adminPasswordSecretArn;
            return this;
        }

        /**
         * @param adminPasswordSecretArn Amazon Resource Name (ARN) of namespace&#39;s admin user credentials secret.
         * 
         * @return builder
         * 
         */
        public Builder adminPasswordSecretArn(String adminPasswordSecretArn) {
            return adminPasswordSecretArn(Output.of(adminPasswordSecretArn));
        }

        /**
         * @param adminPasswordSecretKmsKeyId ID of the KMS key used to encrypt the namespace&#39;s admin credentials secret.
         * 
         * @return builder
         * 
         */
        public Builder adminPasswordSecretKmsKeyId(@Nullable Output<String> adminPasswordSecretKmsKeyId) {
            $.adminPasswordSecretKmsKeyId = adminPasswordSecretKmsKeyId;
            return this;
        }

        /**
         * @param adminPasswordSecretKmsKeyId ID of the KMS key used to encrypt the namespace&#39;s admin credentials secret.
         * 
         * @return builder
         * 
         */
        public Builder adminPasswordSecretKmsKeyId(String adminPasswordSecretKmsKeyId) {
            return adminPasswordSecretKmsKeyId(Output.of(adminPasswordSecretKmsKeyId));
        }

        /**
         * @param adminUserPassword The password of the administrator for the first database created in the namespace.
         * Conflicts with `manage_admin_password` and `admin_user_password_wo`.
         * 
         * @return builder
         * 
         */
        public Builder adminUserPassword(@Nullable Output<String> adminUserPassword) {
            $.adminUserPassword = adminUserPassword;
            return this;
        }

        /**
         * @param adminUserPassword The password of the administrator for the first database created in the namespace.
         * Conflicts with `manage_admin_password` and `admin_user_password_wo`.
         * 
         * @return builder
         * 
         */
        public Builder adminUserPassword(String adminUserPassword) {
            return adminUserPassword(Output.of(adminUserPassword));
        }

        /**
         * @param adminUsername The username of the administrator for the first database created in the namespace.
         * 
         * @return builder
         * 
         */
        public Builder adminUsername(@Nullable Output<String> adminUsername) {
            $.adminUsername = adminUsername;
            return this;
        }

        /**
         * @param adminUsername The username of the administrator for the first database created in the namespace.
         * 
         * @return builder
         * 
         */
        public Builder adminUsername(String adminUsername) {
            return adminUsername(Output.of(adminUsername));
        }

        /**
         * @param arn Amazon Resource Name (ARN) of the Redshift Serverless Namespace.
         * 
         * @return builder
         * 
         */
        public Builder arn(@Nullable Output<String> arn) {
            $.arn = arn;
            return this;
        }

        /**
         * @param arn Amazon Resource Name (ARN) of the Redshift Serverless Namespace.
         * 
         * @return builder
         * 
         */
        public Builder arn(String arn) {
            return arn(Output.of(arn));
        }

        /**
         * @param dbName The name of the first database created in the namespace.
         * 
         * @return builder
         * 
         */
        public Builder dbName(@Nullable Output<String> dbName) {
            $.dbName = dbName;
            return this;
        }

        /**
         * @param dbName The name of the first database created in the namespace.
         * 
         * @return builder
         * 
         */
        public Builder dbName(String dbName) {
            return dbName(Output.of(dbName));
        }

        /**
         * @param defaultIamRoleArn The Amazon Resource Name (ARN) of the IAM role to set as a default in the namespace. When specifying `default_iam_role_arn`, it also must be part of `iam_roles`.
         * 
         * @return builder
         * 
         */
        public Builder defaultIamRoleArn(@Nullable Output<String> defaultIamRoleArn) {
            $.defaultIamRoleArn = defaultIamRoleArn;
            return this;
        }

        /**
         * @param defaultIamRoleArn The Amazon Resource Name (ARN) of the IAM role to set as a default in the namespace. When specifying `default_iam_role_arn`, it also must be part of `iam_roles`.
         * 
         * @return builder
         * 
         */
        public Builder defaultIamRoleArn(String defaultIamRoleArn) {
            return defaultIamRoleArn(Output.of(defaultIamRoleArn));
        }

        /**
         * @param iamRoles A list of IAM roles to associate with the namespace.
         * 
         * @return builder
         * 
         */
        public Builder iamRoles(@Nullable Output<List<String>> iamRoles) {
            $.iamRoles = iamRoles;
            return this;
        }

        /**
         * @param iamRoles A list of IAM roles to associate with the namespace.
         * 
         * @return builder
         * 
         */
        public Builder iamRoles(List<String> iamRoles) {
            return iamRoles(Output.of(iamRoles));
        }

        /**
         * @param iamRoles A list of IAM roles to associate with the namespace.
         * 
         * @return builder
         * 
         */
        public Builder iamRoles(String... iamRoles) {
            return iamRoles(List.of(iamRoles));
        }

        /**
         * @param kmsKeyId The ARN of the Amazon Web Services Key Management Service key used to encrypt your data.
         * 
         * @return builder
         * 
         */
        public Builder kmsKeyId(@Nullable Output<String> kmsKeyId) {
            $.kmsKeyId = kmsKeyId;
            return this;
        }

        /**
         * @param kmsKeyId The ARN of the Amazon Web Services Key Management Service key used to encrypt your data.
         * 
         * @return builder
         * 
         */
        public Builder kmsKeyId(String kmsKeyId) {
            return kmsKeyId(Output.of(kmsKeyId));
        }

        /**
         * @param logExports The types of logs the namespace can export. Available export types are `userlog`, `connectionlog`, and `useractivitylog`.
         * 
         * @return builder
         * 
         */
        public Builder logExports(@Nullable Output<List<String>> logExports) {
            $.logExports = logExports;
            return this;
        }

        /**
         * @param logExports The types of logs the namespace can export. Available export types are `userlog`, `connectionlog`, and `useractivitylog`.
         * 
         * @return builder
         * 
         */
        public Builder logExports(List<String> logExports) {
            return logExports(Output.of(logExports));
        }

        /**
         * @param logExports The types of logs the namespace can export. Available export types are `userlog`, `connectionlog`, and `useractivitylog`.
         * 
         * @return builder
         * 
         */
        public Builder logExports(String... logExports) {
            return logExports(List.of(logExports));
        }

        /**
         * @param manageAdminPassword Whether to use AWS SecretManager to manage namespace&#39;s admin credentials.
         * Conflicts with `admin_user_password` and `admin_user_password_wo`.
         * 
         * @return builder
         * 
         */
        public Builder manageAdminPassword(@Nullable Output<Boolean> manageAdminPassword) {
            $.manageAdminPassword = manageAdminPassword;
            return this;
        }

        /**
         * @param manageAdminPassword Whether to use AWS SecretManager to manage namespace&#39;s admin credentials.
         * Conflicts with `admin_user_password` and `admin_user_password_wo`.
         * 
         * @return builder
         * 
         */
        public Builder manageAdminPassword(Boolean manageAdminPassword) {
            return manageAdminPassword(Output.of(manageAdminPassword));
        }

        /**
         * @param namespaceId The Redshift Namespace ID.
         * 
         * @return builder
         * 
         */
        public Builder namespaceId(@Nullable Output<String> namespaceId) {
            $.namespaceId = namespaceId;
            return this;
        }

        /**
         * @param namespaceId The Redshift Namespace ID.
         * 
         * @return builder
         * 
         */
        public Builder namespaceId(String namespaceId) {
            return namespaceId(Output.of(namespaceId));
        }

        /**
         * @param namespaceName The name of the namespace.
         * 
         * @return builder
         * 
         */
        public Builder namespaceName(@Nullable Output<String> namespaceName) {
            $.namespaceName = namespaceName;
            return this;
        }

        /**
         * @param namespaceName The name of the namespace.
         * 
         * @return builder
         * 
         */
        public Builder namespaceName(String namespaceName) {
            return namespaceName(Output.of(namespaceName));
        }

        /**
         * @param tags A map of tags to assign to the resource. If configured with a provider `default_tags` configuration block present, tags with matching keys will overwrite those defined at the provider-level.
         * 
         * @return builder
         * 
         */
        public Builder tags(@Nullable Output<Map<String,String>> tags) {
            $.tags = tags;
            return this;
        }

        /**
         * @param tags A map of tags to assign to the resource. If configured with a provider `default_tags` configuration block present, tags with matching keys will overwrite those defined at the provider-level.
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

        public NamespaceState build() {
            return $;
        }
    }

}
