// *** WARNING: this file was generated by pulumi-java-gen. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

package com.pulumi.aws.workspaces.inputs;

import com.pulumi.core.Output;
import com.pulumi.core.annotations.Import;
import com.pulumi.exceptions.MissingRequiredPropertyException;
import java.lang.String;
import java.util.Objects;


public final class DirectoryActiveDirectoryConfigArgs extends com.pulumi.resources.ResourceArgs {

    public static final DirectoryActiveDirectoryConfigArgs Empty = new DirectoryActiveDirectoryConfigArgs();

    /**
     * Fully qualified domain name of the AWS Directory Service directory.
     * 
     */
    @Import(name="domainName", required=true)
    private Output<String> domainName;

    /**
     * @return Fully qualified domain name of the AWS Directory Service directory.
     * 
     */
    public Output<String> domainName() {
        return this.domainName;
    }

    /**
     * ARN of the Secrets Manager secret that contains the credentials for the service account. For more information, see [Service Account Details](https://docs.aws.amazon.com/workspaces/latest/adminguide/pools-service-account-details.html).
     * 
     */
    @Import(name="serviceAccountSecretArn", required=true)
    private Output<String> serviceAccountSecretArn;

    /**
     * @return ARN of the Secrets Manager secret that contains the credentials for the service account. For more information, see [Service Account Details](https://docs.aws.amazon.com/workspaces/latest/adminguide/pools-service-account-details.html).
     * 
     */
    public Output<String> serviceAccountSecretArn() {
        return this.serviceAccountSecretArn;
    }

    private DirectoryActiveDirectoryConfigArgs() {}

    private DirectoryActiveDirectoryConfigArgs(DirectoryActiveDirectoryConfigArgs $) {
        this.domainName = $.domainName;
        this.serviceAccountSecretArn = $.serviceAccountSecretArn;
    }

    public static Builder builder() {
        return new Builder();
    }
    public static Builder builder(DirectoryActiveDirectoryConfigArgs defaults) {
        return new Builder(defaults);
    }

    public static final class Builder {
        private DirectoryActiveDirectoryConfigArgs $;

        public Builder() {
            $ = new DirectoryActiveDirectoryConfigArgs();
        }

        public Builder(DirectoryActiveDirectoryConfigArgs defaults) {
            $ = new DirectoryActiveDirectoryConfigArgs(Objects.requireNonNull(defaults));
        }

        /**
         * @param domainName Fully qualified domain name of the AWS Directory Service directory.
         * 
         * @return builder
         * 
         */
        public Builder domainName(Output<String> domainName) {
            $.domainName = domainName;
            return this;
        }

        /**
         * @param domainName Fully qualified domain name of the AWS Directory Service directory.
         * 
         * @return builder
         * 
         */
        public Builder domainName(String domainName) {
            return domainName(Output.of(domainName));
        }

        /**
         * @param serviceAccountSecretArn ARN of the Secrets Manager secret that contains the credentials for the service account. For more information, see [Service Account Details](https://docs.aws.amazon.com/workspaces/latest/adminguide/pools-service-account-details.html).
         * 
         * @return builder
         * 
         */
        public Builder serviceAccountSecretArn(Output<String> serviceAccountSecretArn) {
            $.serviceAccountSecretArn = serviceAccountSecretArn;
            return this;
        }

        /**
         * @param serviceAccountSecretArn ARN of the Secrets Manager secret that contains the credentials for the service account. For more information, see [Service Account Details](https://docs.aws.amazon.com/workspaces/latest/adminguide/pools-service-account-details.html).
         * 
         * @return builder
         * 
         */
        public Builder serviceAccountSecretArn(String serviceAccountSecretArn) {
            return serviceAccountSecretArn(Output.of(serviceAccountSecretArn));
        }

        public DirectoryActiveDirectoryConfigArgs build() {
            if ($.domainName == null) {
                throw new MissingRequiredPropertyException("DirectoryActiveDirectoryConfigArgs", "domainName");
            }
            if ($.serviceAccountSecretArn == null) {
                throw new MissingRequiredPropertyException("DirectoryActiveDirectoryConfigArgs", "serviceAccountSecretArn");
            }
            return $;
        }
    }

}
