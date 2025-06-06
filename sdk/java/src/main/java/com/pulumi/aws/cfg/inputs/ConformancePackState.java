// *** WARNING: this file was generated by pulumi-java-gen. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

package com.pulumi.aws.cfg.inputs;

import com.pulumi.aws.cfg.inputs.ConformancePackInputParameterArgs;
import com.pulumi.core.Output;
import com.pulumi.core.annotations.Import;
import java.lang.String;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import javax.annotation.Nullable;


public final class ConformancePackState extends com.pulumi.resources.ResourceArgs {

    public static final ConformancePackState Empty = new ConformancePackState();

    /**
     * Amazon Resource Name (ARN) of the conformance pack.
     * 
     */
    @Import(name="arn")
    private @Nullable Output<String> arn;

    /**
     * @return Amazon Resource Name (ARN) of the conformance pack.
     * 
     */
    public Optional<Output<String>> arn() {
        return Optional.ofNullable(this.arn);
    }

    /**
     * Amazon S3 bucket where AWS Config stores conformance pack templates. Maximum length of 63.
     * 
     */
    @Import(name="deliveryS3Bucket")
    private @Nullable Output<String> deliveryS3Bucket;

    /**
     * @return Amazon S3 bucket where AWS Config stores conformance pack templates. Maximum length of 63.
     * 
     */
    public Optional<Output<String>> deliveryS3Bucket() {
        return Optional.ofNullable(this.deliveryS3Bucket);
    }

    /**
     * The prefix for the Amazon S3 bucket. Maximum length of 1024.
     * 
     */
    @Import(name="deliveryS3KeyPrefix")
    private @Nullable Output<String> deliveryS3KeyPrefix;

    /**
     * @return The prefix for the Amazon S3 bucket. Maximum length of 1024.
     * 
     */
    public Optional<Output<String>> deliveryS3KeyPrefix() {
        return Optional.ofNullable(this.deliveryS3KeyPrefix);
    }

    /**
     * Set of configuration blocks describing input parameters passed to the conformance pack template. Documented below. When configured, the parameters must also be included in the `template_body` or in the template stored in Amazon S3 if using `template_s3_uri`.
     * 
     */
    @Import(name="inputParameters")
    private @Nullable Output<List<ConformancePackInputParameterArgs>> inputParameters;

    /**
     * @return Set of configuration blocks describing input parameters passed to the conformance pack template. Documented below. When configured, the parameters must also be included in the `template_body` or in the template stored in Amazon S3 if using `template_s3_uri`.
     * 
     */
    public Optional<Output<List<ConformancePackInputParameterArgs>>> inputParameters() {
        return Optional.ofNullable(this.inputParameters);
    }

    /**
     * The name of the conformance pack. Must begin with a letter and contain from 1 to 256 alphanumeric characters and hyphens.
     * 
     */
    @Import(name="name")
    private @Nullable Output<String> name;

    /**
     * @return The name of the conformance pack. Must begin with a letter and contain from 1 to 256 alphanumeric characters and hyphens.
     * 
     */
    public Optional<Output<String>> name() {
        return Optional.ofNullable(this.name);
    }

    /**
     * A string containing full conformance pack template body. Maximum length of 51200. Drift detection is not possible with this argument.
     * 
     */
    @Import(name="templateBody")
    private @Nullable Output<String> templateBody;

    /**
     * @return A string containing full conformance pack template body. Maximum length of 51200. Drift detection is not possible with this argument.
     * 
     */
    public Optional<Output<String>> templateBody() {
        return Optional.ofNullable(this.templateBody);
    }

    /**
     * Location of file, e.g., `s3://bucketname/prefix`, containing the template body. The uri must point to the conformance pack template that is located in an Amazon S3 bucket in the same region as the conformance pack. Maximum length of 1024. Drift detection is not possible with this argument.
     * 
     * &gt; **Note:** If both `template_body` and `template_s3_uri` are specified, AWS Config uses the `template_s3_uri` and ignores the `template_body`.
     * 
     */
    @Import(name="templateS3Uri")
    private @Nullable Output<String> templateS3Uri;

    /**
     * @return Location of file, e.g., `s3://bucketname/prefix`, containing the template body. The uri must point to the conformance pack template that is located in an Amazon S3 bucket in the same region as the conformance pack. Maximum length of 1024. Drift detection is not possible with this argument.
     * 
     * &gt; **Note:** If both `template_body` and `template_s3_uri` are specified, AWS Config uses the `template_s3_uri` and ignores the `template_body`.
     * 
     */
    public Optional<Output<String>> templateS3Uri() {
        return Optional.ofNullable(this.templateS3Uri);
    }

    private ConformancePackState() {}

    private ConformancePackState(ConformancePackState $) {
        this.arn = $.arn;
        this.deliveryS3Bucket = $.deliveryS3Bucket;
        this.deliveryS3KeyPrefix = $.deliveryS3KeyPrefix;
        this.inputParameters = $.inputParameters;
        this.name = $.name;
        this.templateBody = $.templateBody;
        this.templateS3Uri = $.templateS3Uri;
    }

    public static Builder builder() {
        return new Builder();
    }
    public static Builder builder(ConformancePackState defaults) {
        return new Builder(defaults);
    }

    public static final class Builder {
        private ConformancePackState $;

        public Builder() {
            $ = new ConformancePackState();
        }

        public Builder(ConformancePackState defaults) {
            $ = new ConformancePackState(Objects.requireNonNull(defaults));
        }

        /**
         * @param arn Amazon Resource Name (ARN) of the conformance pack.
         * 
         * @return builder
         * 
         */
        public Builder arn(@Nullable Output<String> arn) {
            $.arn = arn;
            return this;
        }

        /**
         * @param arn Amazon Resource Name (ARN) of the conformance pack.
         * 
         * @return builder
         * 
         */
        public Builder arn(String arn) {
            return arn(Output.of(arn));
        }

        /**
         * @param deliveryS3Bucket Amazon S3 bucket where AWS Config stores conformance pack templates. Maximum length of 63.
         * 
         * @return builder
         * 
         */
        public Builder deliveryS3Bucket(@Nullable Output<String> deliveryS3Bucket) {
            $.deliveryS3Bucket = deliveryS3Bucket;
            return this;
        }

        /**
         * @param deliveryS3Bucket Amazon S3 bucket where AWS Config stores conformance pack templates. Maximum length of 63.
         * 
         * @return builder
         * 
         */
        public Builder deliveryS3Bucket(String deliveryS3Bucket) {
            return deliveryS3Bucket(Output.of(deliveryS3Bucket));
        }

        /**
         * @param deliveryS3KeyPrefix The prefix for the Amazon S3 bucket. Maximum length of 1024.
         * 
         * @return builder
         * 
         */
        public Builder deliveryS3KeyPrefix(@Nullable Output<String> deliveryS3KeyPrefix) {
            $.deliveryS3KeyPrefix = deliveryS3KeyPrefix;
            return this;
        }

        /**
         * @param deliveryS3KeyPrefix The prefix for the Amazon S3 bucket. Maximum length of 1024.
         * 
         * @return builder
         * 
         */
        public Builder deliveryS3KeyPrefix(String deliveryS3KeyPrefix) {
            return deliveryS3KeyPrefix(Output.of(deliveryS3KeyPrefix));
        }

        /**
         * @param inputParameters Set of configuration blocks describing input parameters passed to the conformance pack template. Documented below. When configured, the parameters must also be included in the `template_body` or in the template stored in Amazon S3 if using `template_s3_uri`.
         * 
         * @return builder
         * 
         */
        public Builder inputParameters(@Nullable Output<List<ConformancePackInputParameterArgs>> inputParameters) {
            $.inputParameters = inputParameters;
            return this;
        }

        /**
         * @param inputParameters Set of configuration blocks describing input parameters passed to the conformance pack template. Documented below. When configured, the parameters must also be included in the `template_body` or in the template stored in Amazon S3 if using `template_s3_uri`.
         * 
         * @return builder
         * 
         */
        public Builder inputParameters(List<ConformancePackInputParameterArgs> inputParameters) {
            return inputParameters(Output.of(inputParameters));
        }

        /**
         * @param inputParameters Set of configuration blocks describing input parameters passed to the conformance pack template. Documented below. When configured, the parameters must also be included in the `template_body` or in the template stored in Amazon S3 if using `template_s3_uri`.
         * 
         * @return builder
         * 
         */
        public Builder inputParameters(ConformancePackInputParameterArgs... inputParameters) {
            return inputParameters(List.of(inputParameters));
        }

        /**
         * @param name The name of the conformance pack. Must begin with a letter and contain from 1 to 256 alphanumeric characters and hyphens.
         * 
         * @return builder
         * 
         */
        public Builder name(@Nullable Output<String> name) {
            $.name = name;
            return this;
        }

        /**
         * @param name The name of the conformance pack. Must begin with a letter and contain from 1 to 256 alphanumeric characters and hyphens.
         * 
         * @return builder
         * 
         */
        public Builder name(String name) {
            return name(Output.of(name));
        }

        /**
         * @param templateBody A string containing full conformance pack template body. Maximum length of 51200. Drift detection is not possible with this argument.
         * 
         * @return builder
         * 
         */
        public Builder templateBody(@Nullable Output<String> templateBody) {
            $.templateBody = templateBody;
            return this;
        }

        /**
         * @param templateBody A string containing full conformance pack template body. Maximum length of 51200. Drift detection is not possible with this argument.
         * 
         * @return builder
         * 
         */
        public Builder templateBody(String templateBody) {
            return templateBody(Output.of(templateBody));
        }

        /**
         * @param templateS3Uri Location of file, e.g., `s3://bucketname/prefix`, containing the template body. The uri must point to the conformance pack template that is located in an Amazon S3 bucket in the same region as the conformance pack. Maximum length of 1024. Drift detection is not possible with this argument.
         * 
         * &gt; **Note:** If both `template_body` and `template_s3_uri` are specified, AWS Config uses the `template_s3_uri` and ignores the `template_body`.
         * 
         * @return builder
         * 
         */
        public Builder templateS3Uri(@Nullable Output<String> templateS3Uri) {
            $.templateS3Uri = templateS3Uri;
            return this;
        }

        /**
         * @param templateS3Uri Location of file, e.g., `s3://bucketname/prefix`, containing the template body. The uri must point to the conformance pack template that is located in an Amazon S3 bucket in the same region as the conformance pack. Maximum length of 1024. Drift detection is not possible with this argument.
         * 
         * &gt; **Note:** If both `template_body` and `template_s3_uri` are specified, AWS Config uses the `template_s3_uri` and ignores the `template_body`.
         * 
         * @return builder
         * 
         */
        public Builder templateS3Uri(String templateS3Uri) {
            return templateS3Uri(Output.of(templateS3Uri));
        }

        public ConformancePackState build() {
            return $;
        }
    }

}
