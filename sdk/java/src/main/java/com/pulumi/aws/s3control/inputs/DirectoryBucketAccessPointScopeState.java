// *** WARNING: this file was generated by pulumi-java-gen. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

package com.pulumi.aws.s3control.inputs;

import com.pulumi.aws.s3control.inputs.DirectoryBucketAccessPointScopeScopeArgs;
import com.pulumi.core.Output;
import com.pulumi.core.annotations.Import;
import java.lang.String;
import java.util.Objects;
import java.util.Optional;
import javax.annotation.Nullable;


public final class DirectoryBucketAccessPointScopeState extends com.pulumi.resources.ResourceArgs {

    public static final DirectoryBucketAccessPointScopeState Empty = new DirectoryBucketAccessPointScopeState();

    /**
     * The AWS account ID that owns the specified access point.
     * 
     */
    @Import(name="accountId")
    private @Nullable Output<String> accountId;

    /**
     * @return The AWS account ID that owns the specified access point.
     * 
     */
    public Optional<Output<String>> accountId() {
        return Optional.ofNullable(this.accountId);
    }

    /**
     * The name of the access point that you want to apply the scope to.
     * 
     */
    @Import(name="name")
    private @Nullable Output<String> name;

    /**
     * @return The name of the access point that you want to apply the scope to.
     * 
     */
    public Optional<Output<String>> name() {
        return Optional.ofNullable(this.name);
    }

    /**
     * . Scope is used to restrict access to specific prefixes, API operations, or a combination of both. To remove the `scope`, set it to `{permissions=[] prefixes=[]}`. The default scope is `{permissions=[] prefixes=[]}`.
     * 
     */
    @Import(name="scope")
    private @Nullable Output<DirectoryBucketAccessPointScopeScopeArgs> scope;

    /**
     * @return . Scope is used to restrict access to specific prefixes, API operations, or a combination of both. To remove the `scope`, set it to `{permissions=[] prefixes=[]}`. The default scope is `{permissions=[] prefixes=[]}`.
     * 
     */
    public Optional<Output<DirectoryBucketAccessPointScopeScopeArgs>> scope() {
        return Optional.ofNullable(this.scope);
    }

    private DirectoryBucketAccessPointScopeState() {}

    private DirectoryBucketAccessPointScopeState(DirectoryBucketAccessPointScopeState $) {
        this.accountId = $.accountId;
        this.name = $.name;
        this.scope = $.scope;
    }

    public static Builder builder() {
        return new Builder();
    }
    public static Builder builder(DirectoryBucketAccessPointScopeState defaults) {
        return new Builder(defaults);
    }

    public static final class Builder {
        private DirectoryBucketAccessPointScopeState $;

        public Builder() {
            $ = new DirectoryBucketAccessPointScopeState();
        }

        public Builder(DirectoryBucketAccessPointScopeState defaults) {
            $ = new DirectoryBucketAccessPointScopeState(Objects.requireNonNull(defaults));
        }

        /**
         * @param accountId The AWS account ID that owns the specified access point.
         * 
         * @return builder
         * 
         */
        public Builder accountId(@Nullable Output<String> accountId) {
            $.accountId = accountId;
            return this;
        }

        /**
         * @param accountId The AWS account ID that owns the specified access point.
         * 
         * @return builder
         * 
         */
        public Builder accountId(String accountId) {
            return accountId(Output.of(accountId));
        }

        /**
         * @param name The name of the access point that you want to apply the scope to.
         * 
         * @return builder
         * 
         */
        public Builder name(@Nullable Output<String> name) {
            $.name = name;
            return this;
        }

        /**
         * @param name The name of the access point that you want to apply the scope to.
         * 
         * @return builder
         * 
         */
        public Builder name(String name) {
            return name(Output.of(name));
        }

        /**
         * @param scope . Scope is used to restrict access to specific prefixes, API operations, or a combination of both. To remove the `scope`, set it to `{permissions=[] prefixes=[]}`. The default scope is `{permissions=[] prefixes=[]}`.
         * 
         * @return builder
         * 
         */
        public Builder scope(@Nullable Output<DirectoryBucketAccessPointScopeScopeArgs> scope) {
            $.scope = scope;
            return this;
        }

        /**
         * @param scope . Scope is used to restrict access to specific prefixes, API operations, or a combination of both. To remove the `scope`, set it to `{permissions=[] prefixes=[]}`. The default scope is `{permissions=[] prefixes=[]}`.
         * 
         * @return builder
         * 
         */
        public Builder scope(DirectoryBucketAccessPointScopeScopeArgs scope) {
            return scope(Output.of(scope));
        }

        public DirectoryBucketAccessPointScopeState build() {
            return $;
        }
    }

}
