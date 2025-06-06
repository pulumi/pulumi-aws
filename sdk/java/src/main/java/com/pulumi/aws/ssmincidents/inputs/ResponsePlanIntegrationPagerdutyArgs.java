// *** WARNING: this file was generated by pulumi-java-gen. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

package com.pulumi.aws.ssmincidents.inputs;

import com.pulumi.core.Output;
import com.pulumi.core.annotations.Import;
import com.pulumi.exceptions.MissingRequiredPropertyException;
import java.lang.String;
import java.util.Objects;


public final class ResponsePlanIntegrationPagerdutyArgs extends com.pulumi.resources.ResourceArgs {

    public static final ResponsePlanIntegrationPagerdutyArgs Empty = new ResponsePlanIntegrationPagerdutyArgs();

    /**
     * The name of the PagerDuty configuration.
     * 
     */
    @Import(name="name", required=true)
    private Output<String> name;

    /**
     * @return The name of the PagerDuty configuration.
     * 
     */
    public Output<String> name() {
        return this.name;
    }

    /**
     * The ID of the AWS Secrets Manager secret that stores your PagerDuty key &amp;mdash; either a General Access REST API Key or User Token REST API Key &amp;mdash; and other user credentials.
     * 
     * For more information about the constraints for each field, see [CreateResponsePlan](https://docs.aws.amazon.com/incident-manager/latest/APIReference/API_CreateResponsePlan.html) in the *AWS Systems Manager Incident Manager API Reference*.
     * 
     */
    @Import(name="secretId", required=true)
    private Output<String> secretId;

    /**
     * @return The ID of the AWS Secrets Manager secret that stores your PagerDuty key &amp;mdash; either a General Access REST API Key or User Token REST API Key &amp;mdash; and other user credentials.
     * 
     * For more information about the constraints for each field, see [CreateResponsePlan](https://docs.aws.amazon.com/incident-manager/latest/APIReference/API_CreateResponsePlan.html) in the *AWS Systems Manager Incident Manager API Reference*.
     * 
     */
    public Output<String> secretId() {
        return this.secretId;
    }

    /**
     * The ID of the PagerDuty service that the response plan associated with the incident at launch.
     * 
     */
    @Import(name="serviceId", required=true)
    private Output<String> serviceId;

    /**
     * @return The ID of the PagerDuty service that the response plan associated with the incident at launch.
     * 
     */
    public Output<String> serviceId() {
        return this.serviceId;
    }

    private ResponsePlanIntegrationPagerdutyArgs() {}

    private ResponsePlanIntegrationPagerdutyArgs(ResponsePlanIntegrationPagerdutyArgs $) {
        this.name = $.name;
        this.secretId = $.secretId;
        this.serviceId = $.serviceId;
    }

    public static Builder builder() {
        return new Builder();
    }
    public static Builder builder(ResponsePlanIntegrationPagerdutyArgs defaults) {
        return new Builder(defaults);
    }

    public static final class Builder {
        private ResponsePlanIntegrationPagerdutyArgs $;

        public Builder() {
            $ = new ResponsePlanIntegrationPagerdutyArgs();
        }

        public Builder(ResponsePlanIntegrationPagerdutyArgs defaults) {
            $ = new ResponsePlanIntegrationPagerdutyArgs(Objects.requireNonNull(defaults));
        }

        /**
         * @param name The name of the PagerDuty configuration.
         * 
         * @return builder
         * 
         */
        public Builder name(Output<String> name) {
            $.name = name;
            return this;
        }

        /**
         * @param name The name of the PagerDuty configuration.
         * 
         * @return builder
         * 
         */
        public Builder name(String name) {
            return name(Output.of(name));
        }

        /**
         * @param secretId The ID of the AWS Secrets Manager secret that stores your PagerDuty key &amp;mdash; either a General Access REST API Key or User Token REST API Key &amp;mdash; and other user credentials.
         * 
         * For more information about the constraints for each field, see [CreateResponsePlan](https://docs.aws.amazon.com/incident-manager/latest/APIReference/API_CreateResponsePlan.html) in the *AWS Systems Manager Incident Manager API Reference*.
         * 
         * @return builder
         * 
         */
        public Builder secretId(Output<String> secretId) {
            $.secretId = secretId;
            return this;
        }

        /**
         * @param secretId The ID of the AWS Secrets Manager secret that stores your PagerDuty key &amp;mdash; either a General Access REST API Key or User Token REST API Key &amp;mdash; and other user credentials.
         * 
         * For more information about the constraints for each field, see [CreateResponsePlan](https://docs.aws.amazon.com/incident-manager/latest/APIReference/API_CreateResponsePlan.html) in the *AWS Systems Manager Incident Manager API Reference*.
         * 
         * @return builder
         * 
         */
        public Builder secretId(String secretId) {
            return secretId(Output.of(secretId));
        }

        /**
         * @param serviceId The ID of the PagerDuty service that the response plan associated with the incident at launch.
         * 
         * @return builder
         * 
         */
        public Builder serviceId(Output<String> serviceId) {
            $.serviceId = serviceId;
            return this;
        }

        /**
         * @param serviceId The ID of the PagerDuty service that the response plan associated with the incident at launch.
         * 
         * @return builder
         * 
         */
        public Builder serviceId(String serviceId) {
            return serviceId(Output.of(serviceId));
        }

        public ResponsePlanIntegrationPagerdutyArgs build() {
            if ($.name == null) {
                throw new MissingRequiredPropertyException("ResponsePlanIntegrationPagerdutyArgs", "name");
            }
            if ($.secretId == null) {
                throw new MissingRequiredPropertyException("ResponsePlanIntegrationPagerdutyArgs", "secretId");
            }
            if ($.serviceId == null) {
                throw new MissingRequiredPropertyException("ResponsePlanIntegrationPagerdutyArgs", "serviceId");
            }
            return $;
        }
    }

}
