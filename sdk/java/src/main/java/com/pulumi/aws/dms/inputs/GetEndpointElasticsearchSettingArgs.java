// *** WARNING: this file was generated by pulumi-java-gen. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

package com.pulumi.aws.dms.inputs;

import com.pulumi.core.Output;
import com.pulumi.core.annotations.Import;
import java.lang.Integer;
import java.lang.String;
import java.util.Objects;


public final class GetEndpointElasticsearchSettingArgs extends com.pulumi.resources.ResourceArgs {

    public static final GetEndpointElasticsearchSettingArgs Empty = new GetEndpointElasticsearchSettingArgs();

    @Import(name="endpointUri", required=true)
    private Output<String> endpointUri;

    public Output<String> endpointUri() {
        return this.endpointUri;
    }

    @Import(name="errorRetryDuration", required=true)
    private Output<Integer> errorRetryDuration;

    public Output<Integer> errorRetryDuration() {
        return this.errorRetryDuration;
    }

    @Import(name="fullLoadErrorPercentage", required=true)
    private Output<Integer> fullLoadErrorPercentage;

    public Output<Integer> fullLoadErrorPercentage() {
        return this.fullLoadErrorPercentage;
    }

    @Import(name="serviceAccessRoleArn", required=true)
    private Output<String> serviceAccessRoleArn;

    public Output<String> serviceAccessRoleArn() {
        return this.serviceAccessRoleArn;
    }

    private GetEndpointElasticsearchSettingArgs() {}

    private GetEndpointElasticsearchSettingArgs(GetEndpointElasticsearchSettingArgs $) {
        this.endpointUri = $.endpointUri;
        this.errorRetryDuration = $.errorRetryDuration;
        this.fullLoadErrorPercentage = $.fullLoadErrorPercentage;
        this.serviceAccessRoleArn = $.serviceAccessRoleArn;
    }

    public static Builder builder() {
        return new Builder();
    }
    public static Builder builder(GetEndpointElasticsearchSettingArgs defaults) {
        return new Builder(defaults);
    }

    public static final class Builder {
        private GetEndpointElasticsearchSettingArgs $;

        public Builder() {
            $ = new GetEndpointElasticsearchSettingArgs();
        }

        public Builder(GetEndpointElasticsearchSettingArgs defaults) {
            $ = new GetEndpointElasticsearchSettingArgs(Objects.requireNonNull(defaults));
        }

        public Builder endpointUri(Output<String> endpointUri) {
            $.endpointUri = endpointUri;
            return this;
        }

        public Builder endpointUri(String endpointUri) {
            return endpointUri(Output.of(endpointUri));
        }

        public Builder errorRetryDuration(Output<Integer> errorRetryDuration) {
            $.errorRetryDuration = errorRetryDuration;
            return this;
        }

        public Builder errorRetryDuration(Integer errorRetryDuration) {
            return errorRetryDuration(Output.of(errorRetryDuration));
        }

        public Builder fullLoadErrorPercentage(Output<Integer> fullLoadErrorPercentage) {
            $.fullLoadErrorPercentage = fullLoadErrorPercentage;
            return this;
        }

        public Builder fullLoadErrorPercentage(Integer fullLoadErrorPercentage) {
            return fullLoadErrorPercentage(Output.of(fullLoadErrorPercentage));
        }

        public Builder serviceAccessRoleArn(Output<String> serviceAccessRoleArn) {
            $.serviceAccessRoleArn = serviceAccessRoleArn;
            return this;
        }

        public Builder serviceAccessRoleArn(String serviceAccessRoleArn) {
            return serviceAccessRoleArn(Output.of(serviceAccessRoleArn));
        }

        public GetEndpointElasticsearchSettingArgs build() {
            $.endpointUri = Objects.requireNonNull($.endpointUri, "expected parameter 'endpointUri' to be non-null");
            $.errorRetryDuration = Objects.requireNonNull($.errorRetryDuration, "expected parameter 'errorRetryDuration' to be non-null");
            $.fullLoadErrorPercentage = Objects.requireNonNull($.fullLoadErrorPercentage, "expected parameter 'fullLoadErrorPercentage' to be non-null");
            $.serviceAccessRoleArn = Objects.requireNonNull($.serviceAccessRoleArn, "expected parameter 'serviceAccessRoleArn' to be non-null");
            return $;
        }
    }

}