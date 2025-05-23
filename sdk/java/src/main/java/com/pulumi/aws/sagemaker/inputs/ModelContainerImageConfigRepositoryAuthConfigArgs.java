// *** WARNING: this file was generated by pulumi-java-gen. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

package com.pulumi.aws.sagemaker.inputs;

import com.pulumi.core.Output;
import com.pulumi.core.annotations.Import;
import com.pulumi.exceptions.MissingRequiredPropertyException;
import java.lang.String;
import java.util.Objects;


public final class ModelContainerImageConfigRepositoryAuthConfigArgs extends com.pulumi.resources.ResourceArgs {

    public static final ModelContainerImageConfigRepositoryAuthConfigArgs Empty = new ModelContainerImageConfigRepositoryAuthConfigArgs();

    /**
     * The Amazon Resource Name (ARN) of an AWS Lambda function that provides credentials to authenticate to the private Docker registry where your model image is hosted. For information about how to create an AWS Lambda function, see [Create a Lambda function with the console](https://docs.aws.amazon.com/lambda/latest/dg/getting-started-create-function.html) in the _AWS Lambda Developer Guide_.
     * 
     */
    @Import(name="repositoryCredentialsProviderArn", required=true)
    private Output<String> repositoryCredentialsProviderArn;

    /**
     * @return The Amazon Resource Name (ARN) of an AWS Lambda function that provides credentials to authenticate to the private Docker registry where your model image is hosted. For information about how to create an AWS Lambda function, see [Create a Lambda function with the console](https://docs.aws.amazon.com/lambda/latest/dg/getting-started-create-function.html) in the _AWS Lambda Developer Guide_.
     * 
     */
    public Output<String> repositoryCredentialsProviderArn() {
        return this.repositoryCredentialsProviderArn;
    }

    private ModelContainerImageConfigRepositoryAuthConfigArgs() {}

    private ModelContainerImageConfigRepositoryAuthConfigArgs(ModelContainerImageConfigRepositoryAuthConfigArgs $) {
        this.repositoryCredentialsProviderArn = $.repositoryCredentialsProviderArn;
    }

    public static Builder builder() {
        return new Builder();
    }
    public static Builder builder(ModelContainerImageConfigRepositoryAuthConfigArgs defaults) {
        return new Builder(defaults);
    }

    public static final class Builder {
        private ModelContainerImageConfigRepositoryAuthConfigArgs $;

        public Builder() {
            $ = new ModelContainerImageConfigRepositoryAuthConfigArgs();
        }

        public Builder(ModelContainerImageConfigRepositoryAuthConfigArgs defaults) {
            $ = new ModelContainerImageConfigRepositoryAuthConfigArgs(Objects.requireNonNull(defaults));
        }

        /**
         * @param repositoryCredentialsProviderArn The Amazon Resource Name (ARN) of an AWS Lambda function that provides credentials to authenticate to the private Docker registry where your model image is hosted. For information about how to create an AWS Lambda function, see [Create a Lambda function with the console](https://docs.aws.amazon.com/lambda/latest/dg/getting-started-create-function.html) in the _AWS Lambda Developer Guide_.
         * 
         * @return builder
         * 
         */
        public Builder repositoryCredentialsProviderArn(Output<String> repositoryCredentialsProviderArn) {
            $.repositoryCredentialsProviderArn = repositoryCredentialsProviderArn;
            return this;
        }

        /**
         * @param repositoryCredentialsProviderArn The Amazon Resource Name (ARN) of an AWS Lambda function that provides credentials to authenticate to the private Docker registry where your model image is hosted. For information about how to create an AWS Lambda function, see [Create a Lambda function with the console](https://docs.aws.amazon.com/lambda/latest/dg/getting-started-create-function.html) in the _AWS Lambda Developer Guide_.
         * 
         * @return builder
         * 
         */
        public Builder repositoryCredentialsProviderArn(String repositoryCredentialsProviderArn) {
            return repositoryCredentialsProviderArn(Output.of(repositoryCredentialsProviderArn));
        }

        public ModelContainerImageConfigRepositoryAuthConfigArgs build() {
            if ($.repositoryCredentialsProviderArn == null) {
                throw new MissingRequiredPropertyException("ModelContainerImageConfigRepositoryAuthConfigArgs", "repositoryCredentialsProviderArn");
            }
            return $;
        }
    }

}
