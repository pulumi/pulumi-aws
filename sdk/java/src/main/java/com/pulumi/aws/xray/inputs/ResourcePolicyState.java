// *** WARNING: this file was generated by pulumi-java-gen. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

package com.pulumi.aws.xray.inputs;

import com.pulumi.core.Output;
import com.pulumi.core.annotations.Import;
import java.lang.Boolean;
import java.lang.String;
import java.util.Objects;
import java.util.Optional;
import javax.annotation.Nullable;


public final class ResourcePolicyState extends com.pulumi.resources.ResourceArgs {

    public static final ResourcePolicyState Empty = new ResourcePolicyState();

    /**
     * Flag to indicate whether to bypass the resource policy lockout safety check. Setting this value to true increases the risk that the policy becomes unmanageable. Do not set this value to true indiscriminately. Use this parameter only when you include a policy in the request and you intend to prevent the principal that is making the request from making a subsequent PutResourcePolicy request. The default value is `false`.
     * 
     */
    @Import(name="bypassPolicyLockoutCheck")
    private @Nullable Output<Boolean> bypassPolicyLockoutCheck;

    /**
     * @return Flag to indicate whether to bypass the resource policy lockout safety check. Setting this value to true increases the risk that the policy becomes unmanageable. Do not set this value to true indiscriminately. Use this parameter only when you include a policy in the request and you intend to prevent the principal that is making the request from making a subsequent PutResourcePolicy request. The default value is `false`.
     * 
     */
    public Optional<Output<Boolean>> bypassPolicyLockoutCheck() {
        return Optional.ofNullable(this.bypassPolicyLockoutCheck);
    }

    /**
     * When the policy was last updated, in Unix time seconds.
     * 
     */
    @Import(name="lastUpdatedTime")
    private @Nullable Output<String> lastUpdatedTime;

    /**
     * @return When the policy was last updated, in Unix time seconds.
     * 
     */
    public Optional<Output<String>> lastUpdatedTime() {
        return Optional.ofNullable(this.lastUpdatedTime);
    }

    /**
     * JSON string of the resource policy or resource policy document, which can be up to 5kb in size.
     * 
     * The following arguments are optional:
     * 
     */
    @Import(name="policyDocument")
    private @Nullable Output<String> policyDocument;

    /**
     * @return JSON string of the resource policy or resource policy document, which can be up to 5kb in size.
     * 
     * The following arguments are optional:
     * 
     */
    public Optional<Output<String>> policyDocument() {
        return Optional.ofNullable(this.policyDocument);
    }

    /**
     * name of the resource policy. Must be unique within a specific Amazon Web Services account.
     * 
     */
    @Import(name="policyName")
    private @Nullable Output<String> policyName;

    /**
     * @return name of the resource policy. Must be unique within a specific Amazon Web Services account.
     * 
     */
    public Optional<Output<String>> policyName() {
        return Optional.ofNullable(this.policyName);
    }

    /**
     * Specifies a specific policy revision, to ensure an atomic create operation. By default the resource policy is created if it does not exist, or updated with an incremented revision id. The revision id is unique to each policy in the account. If the policy revision id does not match the latest revision id, the operation will fail with an InvalidPolicyRevisionIdException exception. You can also provide a PolicyRevisionId of 0. In this case, the operation will fail with an InvalidPolicyRevisionIdException exception if a resource policy with the same name already exists.
     * 
     */
    @Import(name="policyRevisionId")
    private @Nullable Output<String> policyRevisionId;

    /**
     * @return Specifies a specific policy revision, to ensure an atomic create operation. By default the resource policy is created if it does not exist, or updated with an incremented revision id. The revision id is unique to each policy in the account. If the policy revision id does not match the latest revision id, the operation will fail with an InvalidPolicyRevisionIdException exception. You can also provide a PolicyRevisionId of 0. In this case, the operation will fail with an InvalidPolicyRevisionIdException exception if a resource policy with the same name already exists.
     * 
     */
    public Optional<Output<String>> policyRevisionId() {
        return Optional.ofNullable(this.policyRevisionId);
    }

    private ResourcePolicyState() {}

    private ResourcePolicyState(ResourcePolicyState $) {
        this.bypassPolicyLockoutCheck = $.bypassPolicyLockoutCheck;
        this.lastUpdatedTime = $.lastUpdatedTime;
        this.policyDocument = $.policyDocument;
        this.policyName = $.policyName;
        this.policyRevisionId = $.policyRevisionId;
    }

    public static Builder builder() {
        return new Builder();
    }
    public static Builder builder(ResourcePolicyState defaults) {
        return new Builder(defaults);
    }

    public static final class Builder {
        private ResourcePolicyState $;

        public Builder() {
            $ = new ResourcePolicyState();
        }

        public Builder(ResourcePolicyState defaults) {
            $ = new ResourcePolicyState(Objects.requireNonNull(defaults));
        }

        /**
         * @param bypassPolicyLockoutCheck Flag to indicate whether to bypass the resource policy lockout safety check. Setting this value to true increases the risk that the policy becomes unmanageable. Do not set this value to true indiscriminately. Use this parameter only when you include a policy in the request and you intend to prevent the principal that is making the request from making a subsequent PutResourcePolicy request. The default value is `false`.
         * 
         * @return builder
         * 
         */
        public Builder bypassPolicyLockoutCheck(@Nullable Output<Boolean> bypassPolicyLockoutCheck) {
            $.bypassPolicyLockoutCheck = bypassPolicyLockoutCheck;
            return this;
        }

        /**
         * @param bypassPolicyLockoutCheck Flag to indicate whether to bypass the resource policy lockout safety check. Setting this value to true increases the risk that the policy becomes unmanageable. Do not set this value to true indiscriminately. Use this parameter only when you include a policy in the request and you intend to prevent the principal that is making the request from making a subsequent PutResourcePolicy request. The default value is `false`.
         * 
         * @return builder
         * 
         */
        public Builder bypassPolicyLockoutCheck(Boolean bypassPolicyLockoutCheck) {
            return bypassPolicyLockoutCheck(Output.of(bypassPolicyLockoutCheck));
        }

        /**
         * @param lastUpdatedTime When the policy was last updated, in Unix time seconds.
         * 
         * @return builder
         * 
         */
        public Builder lastUpdatedTime(@Nullable Output<String> lastUpdatedTime) {
            $.lastUpdatedTime = lastUpdatedTime;
            return this;
        }

        /**
         * @param lastUpdatedTime When the policy was last updated, in Unix time seconds.
         * 
         * @return builder
         * 
         */
        public Builder lastUpdatedTime(String lastUpdatedTime) {
            return lastUpdatedTime(Output.of(lastUpdatedTime));
        }

        /**
         * @param policyDocument JSON string of the resource policy or resource policy document, which can be up to 5kb in size.
         * 
         * The following arguments are optional:
         * 
         * @return builder
         * 
         */
        public Builder policyDocument(@Nullable Output<String> policyDocument) {
            $.policyDocument = policyDocument;
            return this;
        }

        /**
         * @param policyDocument JSON string of the resource policy or resource policy document, which can be up to 5kb in size.
         * 
         * The following arguments are optional:
         * 
         * @return builder
         * 
         */
        public Builder policyDocument(String policyDocument) {
            return policyDocument(Output.of(policyDocument));
        }

        /**
         * @param policyName name of the resource policy. Must be unique within a specific Amazon Web Services account.
         * 
         * @return builder
         * 
         */
        public Builder policyName(@Nullable Output<String> policyName) {
            $.policyName = policyName;
            return this;
        }

        /**
         * @param policyName name of the resource policy. Must be unique within a specific Amazon Web Services account.
         * 
         * @return builder
         * 
         */
        public Builder policyName(String policyName) {
            return policyName(Output.of(policyName));
        }

        /**
         * @param policyRevisionId Specifies a specific policy revision, to ensure an atomic create operation. By default the resource policy is created if it does not exist, or updated with an incremented revision id. The revision id is unique to each policy in the account. If the policy revision id does not match the latest revision id, the operation will fail with an InvalidPolicyRevisionIdException exception. You can also provide a PolicyRevisionId of 0. In this case, the operation will fail with an InvalidPolicyRevisionIdException exception if a resource policy with the same name already exists.
         * 
         * @return builder
         * 
         */
        public Builder policyRevisionId(@Nullable Output<String> policyRevisionId) {
            $.policyRevisionId = policyRevisionId;
            return this;
        }

        /**
         * @param policyRevisionId Specifies a specific policy revision, to ensure an atomic create operation. By default the resource policy is created if it does not exist, or updated with an incremented revision id. The revision id is unique to each policy in the account. If the policy revision id does not match the latest revision id, the operation will fail with an InvalidPolicyRevisionIdException exception. You can also provide a PolicyRevisionId of 0. In this case, the operation will fail with an InvalidPolicyRevisionIdException exception if a resource policy with the same name already exists.
         * 
         * @return builder
         * 
         */
        public Builder policyRevisionId(String policyRevisionId) {
            return policyRevisionId(Output.of(policyRevisionId));
        }

        public ResourcePolicyState build() {
            return $;
        }
    }

}
