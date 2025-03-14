// *** WARNING: this file was generated by pulumi-java-gen. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

package com.pulumi.aws.cloudfront.inputs;

import com.pulumi.aws.cloudfront.inputs.FieldLevelEncryptionConfigContentTypeProfileConfigArgs;
import com.pulumi.aws.cloudfront.inputs.FieldLevelEncryptionConfigQueryArgProfileConfigArgs;
import com.pulumi.core.Output;
import com.pulumi.core.annotations.Import;
import java.lang.String;
import java.util.Objects;
import java.util.Optional;
import javax.annotation.Nullable;


public final class FieldLevelEncryptionConfigState extends com.pulumi.resources.ResourceArgs {

    public static final FieldLevelEncryptionConfigState Empty = new FieldLevelEncryptionConfigState();

    /**
     * The Field Level Encryption Config ARN.
     * 
     */
    @Import(name="arn")
    private @Nullable Output<String> arn;

    /**
     * @return The Field Level Encryption Config ARN.
     * 
     */
    public Optional<Output<String>> arn() {
        return Optional.ofNullable(this.arn);
    }

    /**
     * Internal value used by CloudFront to allow future updates to the Field Level Encryption Config.
     * 
     */
    @Import(name="callerReference")
    private @Nullable Output<String> callerReference;

    /**
     * @return Internal value used by CloudFront to allow future updates to the Field Level Encryption Config.
     * 
     */
    public Optional<Output<String>> callerReference() {
        return Optional.ofNullable(this.callerReference);
    }

    /**
     * An optional comment about the Field Level Encryption Config.
     * 
     */
    @Import(name="comment")
    private @Nullable Output<String> comment;

    /**
     * @return An optional comment about the Field Level Encryption Config.
     * 
     */
    public Optional<Output<String>> comment() {
        return Optional.ofNullable(this.comment);
    }

    /**
     * Content Type Profile Config specifies when to forward content if a content type isn&#39;t recognized and profiles to use as by default in a request if a query argument doesn&#39;t specify a profile to use.
     * 
     */
    @Import(name="contentTypeProfileConfig")
    private @Nullable Output<FieldLevelEncryptionConfigContentTypeProfileConfigArgs> contentTypeProfileConfig;

    /**
     * @return Content Type Profile Config specifies when to forward content if a content type isn&#39;t recognized and profiles to use as by default in a request if a query argument doesn&#39;t specify a profile to use.
     * 
     */
    public Optional<Output<FieldLevelEncryptionConfigContentTypeProfileConfigArgs>> contentTypeProfileConfig() {
        return Optional.ofNullable(this.contentTypeProfileConfig);
    }

    /**
     * The current version of the Field Level Encryption Config. For example: `E2QWRUHAPOMQZL`.
     * 
     */
    @Import(name="etag")
    private @Nullable Output<String> etag;

    /**
     * @return The current version of the Field Level Encryption Config. For example: `E2QWRUHAPOMQZL`.
     * 
     */
    public Optional<Output<String>> etag() {
        return Optional.ofNullable(this.etag);
    }

    /**
     * Query Arg Profile Config that specifies when to forward content if a profile isn&#39;t found and the profile that can be provided as a query argument in a request.
     * 
     */
    @Import(name="queryArgProfileConfig")
    private @Nullable Output<FieldLevelEncryptionConfigQueryArgProfileConfigArgs> queryArgProfileConfig;

    /**
     * @return Query Arg Profile Config that specifies when to forward content if a profile isn&#39;t found and the profile that can be provided as a query argument in a request.
     * 
     */
    public Optional<Output<FieldLevelEncryptionConfigQueryArgProfileConfigArgs>> queryArgProfileConfig() {
        return Optional.ofNullable(this.queryArgProfileConfig);
    }

    private FieldLevelEncryptionConfigState() {}

    private FieldLevelEncryptionConfigState(FieldLevelEncryptionConfigState $) {
        this.arn = $.arn;
        this.callerReference = $.callerReference;
        this.comment = $.comment;
        this.contentTypeProfileConfig = $.contentTypeProfileConfig;
        this.etag = $.etag;
        this.queryArgProfileConfig = $.queryArgProfileConfig;
    }

    public static Builder builder() {
        return new Builder();
    }
    public static Builder builder(FieldLevelEncryptionConfigState defaults) {
        return new Builder(defaults);
    }

    public static final class Builder {
        private FieldLevelEncryptionConfigState $;

        public Builder() {
            $ = new FieldLevelEncryptionConfigState();
        }

        public Builder(FieldLevelEncryptionConfigState defaults) {
            $ = new FieldLevelEncryptionConfigState(Objects.requireNonNull(defaults));
        }

        /**
         * @param arn The Field Level Encryption Config ARN.
         * 
         * @return builder
         * 
         */
        public Builder arn(@Nullable Output<String> arn) {
            $.arn = arn;
            return this;
        }

        /**
         * @param arn The Field Level Encryption Config ARN.
         * 
         * @return builder
         * 
         */
        public Builder arn(String arn) {
            return arn(Output.of(arn));
        }

        /**
         * @param callerReference Internal value used by CloudFront to allow future updates to the Field Level Encryption Config.
         * 
         * @return builder
         * 
         */
        public Builder callerReference(@Nullable Output<String> callerReference) {
            $.callerReference = callerReference;
            return this;
        }

        /**
         * @param callerReference Internal value used by CloudFront to allow future updates to the Field Level Encryption Config.
         * 
         * @return builder
         * 
         */
        public Builder callerReference(String callerReference) {
            return callerReference(Output.of(callerReference));
        }

        /**
         * @param comment An optional comment about the Field Level Encryption Config.
         * 
         * @return builder
         * 
         */
        public Builder comment(@Nullable Output<String> comment) {
            $.comment = comment;
            return this;
        }

        /**
         * @param comment An optional comment about the Field Level Encryption Config.
         * 
         * @return builder
         * 
         */
        public Builder comment(String comment) {
            return comment(Output.of(comment));
        }

        /**
         * @param contentTypeProfileConfig Content Type Profile Config specifies when to forward content if a content type isn&#39;t recognized and profiles to use as by default in a request if a query argument doesn&#39;t specify a profile to use.
         * 
         * @return builder
         * 
         */
        public Builder contentTypeProfileConfig(@Nullable Output<FieldLevelEncryptionConfigContentTypeProfileConfigArgs> contentTypeProfileConfig) {
            $.contentTypeProfileConfig = contentTypeProfileConfig;
            return this;
        }

        /**
         * @param contentTypeProfileConfig Content Type Profile Config specifies when to forward content if a content type isn&#39;t recognized and profiles to use as by default in a request if a query argument doesn&#39;t specify a profile to use.
         * 
         * @return builder
         * 
         */
        public Builder contentTypeProfileConfig(FieldLevelEncryptionConfigContentTypeProfileConfigArgs contentTypeProfileConfig) {
            return contentTypeProfileConfig(Output.of(contentTypeProfileConfig));
        }

        /**
         * @param etag The current version of the Field Level Encryption Config. For example: `E2QWRUHAPOMQZL`.
         * 
         * @return builder
         * 
         */
        public Builder etag(@Nullable Output<String> etag) {
            $.etag = etag;
            return this;
        }

        /**
         * @param etag The current version of the Field Level Encryption Config. For example: `E2QWRUHAPOMQZL`.
         * 
         * @return builder
         * 
         */
        public Builder etag(String etag) {
            return etag(Output.of(etag));
        }

        /**
         * @param queryArgProfileConfig Query Arg Profile Config that specifies when to forward content if a profile isn&#39;t found and the profile that can be provided as a query argument in a request.
         * 
         * @return builder
         * 
         */
        public Builder queryArgProfileConfig(@Nullable Output<FieldLevelEncryptionConfigQueryArgProfileConfigArgs> queryArgProfileConfig) {
            $.queryArgProfileConfig = queryArgProfileConfig;
            return this;
        }

        /**
         * @param queryArgProfileConfig Query Arg Profile Config that specifies when to forward content if a profile isn&#39;t found and the profile that can be provided as a query argument in a request.
         * 
         * @return builder
         * 
         */
        public Builder queryArgProfileConfig(FieldLevelEncryptionConfigQueryArgProfileConfigArgs queryArgProfileConfig) {
            return queryArgProfileConfig(Output.of(queryArgProfileConfig));
        }

        public FieldLevelEncryptionConfigState build() {
            return $;
        }
    }

}
