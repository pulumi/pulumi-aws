// *** WARNING: this file was generated by pulumi-java-gen. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

package com.pulumi.aws.ecrpublic;

import com.pulumi.core.Output;
import com.pulumi.core.annotations.Import;
import com.pulumi.exceptions.MissingRequiredPropertyException;
import java.lang.String;
import java.util.Objects;


public final class RepositoryPolicyArgs extends com.pulumi.resources.ResourceArgs {

    public static final RepositoryPolicyArgs Empty = new RepositoryPolicyArgs();

    /**
     * The policy document. This is a JSON formatted string.
     * 
     */
    @Import(name="policy", required=true)
    private Output<String> policy;

    /**
     * @return The policy document. This is a JSON formatted string.
     * 
     */
    public Output<String> policy() {
        return this.policy;
    }

    /**
     * Name of the repository to apply the policy.
     * 
     */
    @Import(name="repositoryName", required=true)
    private Output<String> repositoryName;

    /**
     * @return Name of the repository to apply the policy.
     * 
     */
    public Output<String> repositoryName() {
        return this.repositoryName;
    }

    private RepositoryPolicyArgs() {}

    private RepositoryPolicyArgs(RepositoryPolicyArgs $) {
        this.policy = $.policy;
        this.repositoryName = $.repositoryName;
    }

    public static Builder builder() {
        return new Builder();
    }
    public static Builder builder(RepositoryPolicyArgs defaults) {
        return new Builder(defaults);
    }

    public static final class Builder {
        private RepositoryPolicyArgs $;

        public Builder() {
            $ = new RepositoryPolicyArgs();
        }

        public Builder(RepositoryPolicyArgs defaults) {
            $ = new RepositoryPolicyArgs(Objects.requireNonNull(defaults));
        }

        /**
         * @param policy The policy document. This is a JSON formatted string.
         * 
         * @return builder
         * 
         */
        public Builder policy(Output<String> policy) {
            $.policy = policy;
            return this;
        }

        /**
         * @param policy The policy document. This is a JSON formatted string.
         * 
         * @return builder
         * 
         */
        public Builder policy(String policy) {
            return policy(Output.of(policy));
        }

        /**
         * @param repositoryName Name of the repository to apply the policy.
         * 
         * @return builder
         * 
         */
        public Builder repositoryName(Output<String> repositoryName) {
            $.repositoryName = repositoryName;
            return this;
        }

        /**
         * @param repositoryName Name of the repository to apply the policy.
         * 
         * @return builder
         * 
         */
        public Builder repositoryName(String repositoryName) {
            return repositoryName(Output.of(repositoryName));
        }

        public RepositoryPolicyArgs build() {
            if ($.policy == null) {
                throw new MissingRequiredPropertyException("RepositoryPolicyArgs", "policy");
            }
            if ($.repositoryName == null) {
                throw new MissingRequiredPropertyException("RepositoryPolicyArgs", "repositoryName");
            }
            return $;
        }
    }

}
