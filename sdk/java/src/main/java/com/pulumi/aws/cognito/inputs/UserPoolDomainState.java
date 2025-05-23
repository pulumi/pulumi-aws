// *** WARNING: this file was generated by pulumi-java-gen. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

package com.pulumi.aws.cognito.inputs;

import com.pulumi.core.Output;
import com.pulumi.core.annotations.Import;
import java.lang.Integer;
import java.lang.String;
import java.util.Objects;
import java.util.Optional;
import javax.annotation.Nullable;


public final class UserPoolDomainState extends com.pulumi.resources.ResourceArgs {

    public static final UserPoolDomainState Empty = new UserPoolDomainState();

    /**
     * The AWS account ID for the user pool owner.
     * 
     */
    @Import(name="awsAccountId")
    private @Nullable Output<String> awsAccountId;

    /**
     * @return The AWS account ID for the user pool owner.
     * 
     */
    public Optional<Output<String>> awsAccountId() {
        return Optional.ofNullable(this.awsAccountId);
    }

    /**
     * The ARN of an ISSUED ACM certificate in us-east-1 for a custom domain.
     * 
     */
    @Import(name="certificateArn")
    private @Nullable Output<String> certificateArn;

    /**
     * @return The ARN of an ISSUED ACM certificate in us-east-1 for a custom domain.
     * 
     */
    public Optional<Output<String>> certificateArn() {
        return Optional.ofNullable(this.certificateArn);
    }

    /**
     * The Amazon CloudFront endpoint (e.g. `dpp0gtxikpq3y.cloudfront.net`) that you use as the target of the alias that you set up with your Domain Name Service (DNS) provider.
     * 
     */
    @Import(name="cloudfrontDistribution")
    private @Nullable Output<String> cloudfrontDistribution;

    /**
     * @return The Amazon CloudFront endpoint (e.g. `dpp0gtxikpq3y.cloudfront.net`) that you use as the target of the alias that you set up with your Domain Name Service (DNS) provider.
     * 
     */
    public Optional<Output<String>> cloudfrontDistribution() {
        return Optional.ofNullable(this.cloudfrontDistribution);
    }

    /**
     * The URL of the CloudFront distribution. This is required to generate the ALIAS `aws.route53.Record`
     * 
     */
    @Import(name="cloudfrontDistributionArn")
    private @Nullable Output<String> cloudfrontDistributionArn;

    /**
     * @return The URL of the CloudFront distribution. This is required to generate the ALIAS `aws.route53.Record`
     * 
     */
    public Optional<Output<String>> cloudfrontDistributionArn() {
        return Optional.ofNullable(this.cloudfrontDistributionArn);
    }

    /**
     * The Route 53 hosted zone ID of the CloudFront distribution.
     * 
     */
    @Import(name="cloudfrontDistributionZoneId")
    private @Nullable Output<String> cloudfrontDistributionZoneId;

    /**
     * @return The Route 53 hosted zone ID of the CloudFront distribution.
     * 
     */
    public Optional<Output<String>> cloudfrontDistributionZoneId() {
        return Optional.ofNullable(this.cloudfrontDistributionZoneId);
    }

    /**
     * For custom domains, this is the fully-qualified domain name, such as auth.example.com. For Amazon Cognito prefix domains, this is the prefix alone, such as auth.
     * 
     */
    @Import(name="domain")
    private @Nullable Output<String> domain;

    /**
     * @return For custom domains, this is the fully-qualified domain name, such as auth.example.com. For Amazon Cognito prefix domains, this is the prefix alone, such as auth.
     * 
     */
    public Optional<Output<String>> domain() {
        return Optional.ofNullable(this.domain);
    }

    /**
     * A version number that indicates the state of managed login for your domain. Valid values: `1` for hosted UI (classic), `2` for the newer managed login with the branding designer.
     * 
     */
    @Import(name="managedLoginVersion")
    private @Nullable Output<Integer> managedLoginVersion;

    /**
     * @return A version number that indicates the state of managed login for your domain. Valid values: `1` for hosted UI (classic), `2` for the newer managed login with the branding designer.
     * 
     */
    public Optional<Output<Integer>> managedLoginVersion() {
        return Optional.ofNullable(this.managedLoginVersion);
    }

    /**
     * The S3 bucket where the static files for this domain are stored.
     * 
     */
    @Import(name="s3Bucket")
    private @Nullable Output<String> s3Bucket;

    /**
     * @return The S3 bucket where the static files for this domain are stored.
     * 
     */
    public Optional<Output<String>> s3Bucket() {
        return Optional.ofNullable(this.s3Bucket);
    }

    /**
     * The user pool ID.
     * 
     */
    @Import(name="userPoolId")
    private @Nullable Output<String> userPoolId;

    /**
     * @return The user pool ID.
     * 
     */
    public Optional<Output<String>> userPoolId() {
        return Optional.ofNullable(this.userPoolId);
    }

    /**
     * The app version.
     * 
     */
    @Import(name="version")
    private @Nullable Output<String> version;

    /**
     * @return The app version.
     * 
     */
    public Optional<Output<String>> version() {
        return Optional.ofNullable(this.version);
    }

    private UserPoolDomainState() {}

    private UserPoolDomainState(UserPoolDomainState $) {
        this.awsAccountId = $.awsAccountId;
        this.certificateArn = $.certificateArn;
        this.cloudfrontDistribution = $.cloudfrontDistribution;
        this.cloudfrontDistributionArn = $.cloudfrontDistributionArn;
        this.cloudfrontDistributionZoneId = $.cloudfrontDistributionZoneId;
        this.domain = $.domain;
        this.managedLoginVersion = $.managedLoginVersion;
        this.s3Bucket = $.s3Bucket;
        this.userPoolId = $.userPoolId;
        this.version = $.version;
    }

    public static Builder builder() {
        return new Builder();
    }
    public static Builder builder(UserPoolDomainState defaults) {
        return new Builder(defaults);
    }

    public static final class Builder {
        private UserPoolDomainState $;

        public Builder() {
            $ = new UserPoolDomainState();
        }

        public Builder(UserPoolDomainState defaults) {
            $ = new UserPoolDomainState(Objects.requireNonNull(defaults));
        }

        /**
         * @param awsAccountId The AWS account ID for the user pool owner.
         * 
         * @return builder
         * 
         */
        public Builder awsAccountId(@Nullable Output<String> awsAccountId) {
            $.awsAccountId = awsAccountId;
            return this;
        }

        /**
         * @param awsAccountId The AWS account ID for the user pool owner.
         * 
         * @return builder
         * 
         */
        public Builder awsAccountId(String awsAccountId) {
            return awsAccountId(Output.of(awsAccountId));
        }

        /**
         * @param certificateArn The ARN of an ISSUED ACM certificate in us-east-1 for a custom domain.
         * 
         * @return builder
         * 
         */
        public Builder certificateArn(@Nullable Output<String> certificateArn) {
            $.certificateArn = certificateArn;
            return this;
        }

        /**
         * @param certificateArn The ARN of an ISSUED ACM certificate in us-east-1 for a custom domain.
         * 
         * @return builder
         * 
         */
        public Builder certificateArn(String certificateArn) {
            return certificateArn(Output.of(certificateArn));
        }

        /**
         * @param cloudfrontDistribution The Amazon CloudFront endpoint (e.g. `dpp0gtxikpq3y.cloudfront.net`) that you use as the target of the alias that you set up with your Domain Name Service (DNS) provider.
         * 
         * @return builder
         * 
         */
        public Builder cloudfrontDistribution(@Nullable Output<String> cloudfrontDistribution) {
            $.cloudfrontDistribution = cloudfrontDistribution;
            return this;
        }

        /**
         * @param cloudfrontDistribution The Amazon CloudFront endpoint (e.g. `dpp0gtxikpq3y.cloudfront.net`) that you use as the target of the alias that you set up with your Domain Name Service (DNS) provider.
         * 
         * @return builder
         * 
         */
        public Builder cloudfrontDistribution(String cloudfrontDistribution) {
            return cloudfrontDistribution(Output.of(cloudfrontDistribution));
        }

        /**
         * @param cloudfrontDistributionArn The URL of the CloudFront distribution. This is required to generate the ALIAS `aws.route53.Record`
         * 
         * @return builder
         * 
         */
        public Builder cloudfrontDistributionArn(@Nullable Output<String> cloudfrontDistributionArn) {
            $.cloudfrontDistributionArn = cloudfrontDistributionArn;
            return this;
        }

        /**
         * @param cloudfrontDistributionArn The URL of the CloudFront distribution. This is required to generate the ALIAS `aws.route53.Record`
         * 
         * @return builder
         * 
         */
        public Builder cloudfrontDistributionArn(String cloudfrontDistributionArn) {
            return cloudfrontDistributionArn(Output.of(cloudfrontDistributionArn));
        }

        /**
         * @param cloudfrontDistributionZoneId The Route 53 hosted zone ID of the CloudFront distribution.
         * 
         * @return builder
         * 
         */
        public Builder cloudfrontDistributionZoneId(@Nullable Output<String> cloudfrontDistributionZoneId) {
            $.cloudfrontDistributionZoneId = cloudfrontDistributionZoneId;
            return this;
        }

        /**
         * @param cloudfrontDistributionZoneId The Route 53 hosted zone ID of the CloudFront distribution.
         * 
         * @return builder
         * 
         */
        public Builder cloudfrontDistributionZoneId(String cloudfrontDistributionZoneId) {
            return cloudfrontDistributionZoneId(Output.of(cloudfrontDistributionZoneId));
        }

        /**
         * @param domain For custom domains, this is the fully-qualified domain name, such as auth.example.com. For Amazon Cognito prefix domains, this is the prefix alone, such as auth.
         * 
         * @return builder
         * 
         */
        public Builder domain(@Nullable Output<String> domain) {
            $.domain = domain;
            return this;
        }

        /**
         * @param domain For custom domains, this is the fully-qualified domain name, such as auth.example.com. For Amazon Cognito prefix domains, this is the prefix alone, such as auth.
         * 
         * @return builder
         * 
         */
        public Builder domain(String domain) {
            return domain(Output.of(domain));
        }

        /**
         * @param managedLoginVersion A version number that indicates the state of managed login for your domain. Valid values: `1` for hosted UI (classic), `2` for the newer managed login with the branding designer.
         * 
         * @return builder
         * 
         */
        public Builder managedLoginVersion(@Nullable Output<Integer> managedLoginVersion) {
            $.managedLoginVersion = managedLoginVersion;
            return this;
        }

        /**
         * @param managedLoginVersion A version number that indicates the state of managed login for your domain. Valid values: `1` for hosted UI (classic), `2` for the newer managed login with the branding designer.
         * 
         * @return builder
         * 
         */
        public Builder managedLoginVersion(Integer managedLoginVersion) {
            return managedLoginVersion(Output.of(managedLoginVersion));
        }

        /**
         * @param s3Bucket The S3 bucket where the static files for this domain are stored.
         * 
         * @return builder
         * 
         */
        public Builder s3Bucket(@Nullable Output<String> s3Bucket) {
            $.s3Bucket = s3Bucket;
            return this;
        }

        /**
         * @param s3Bucket The S3 bucket where the static files for this domain are stored.
         * 
         * @return builder
         * 
         */
        public Builder s3Bucket(String s3Bucket) {
            return s3Bucket(Output.of(s3Bucket));
        }

        /**
         * @param userPoolId The user pool ID.
         * 
         * @return builder
         * 
         */
        public Builder userPoolId(@Nullable Output<String> userPoolId) {
            $.userPoolId = userPoolId;
            return this;
        }

        /**
         * @param userPoolId The user pool ID.
         * 
         * @return builder
         * 
         */
        public Builder userPoolId(String userPoolId) {
            return userPoolId(Output.of(userPoolId));
        }

        /**
         * @param version The app version.
         * 
         * @return builder
         * 
         */
        public Builder version(@Nullable Output<String> version) {
            $.version = version;
            return this;
        }

        /**
         * @param version The app version.
         * 
         * @return builder
         * 
         */
        public Builder version(String version) {
            return version(Output.of(version));
        }

        public UserPoolDomainState build() {
            return $;
        }
    }

}
