// *** WARNING: this file was generated by pulumi-java-gen. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

package com.pulumi.aws.route53.inputs;

import com.pulumi.aws.route53.inputs.RecordGeoproximityRoutingPolicyCoordinateArgs;
import com.pulumi.core.Output;
import com.pulumi.core.annotations.Import;
import java.lang.Integer;
import java.lang.String;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import javax.annotation.Nullable;


public final class RecordGeoproximityRoutingPolicyArgs extends com.pulumi.resources.ResourceArgs {

    public static final RecordGeoproximityRoutingPolicyArgs Empty = new RecordGeoproximityRoutingPolicyArgs();

    /**
     * A AWS region where the resource is present.
     * 
     */
    @Import(name="awsRegion")
    private @Nullable Output<String> awsRegion;

    /**
     * @return A AWS region where the resource is present.
     * 
     */
    public Optional<Output<String>> awsRegion() {
        return Optional.ofNullable(this.awsRegion);
    }

    /**
     * Route more traffic or less traffic to the resource by specifying a value ranges between -90 to 90. See https://docs.aws.amazon.com/Route53/latest/DeveloperGuide/routing-policy-geoproximity.html for bias details.
     * 
     */
    @Import(name="bias")
    private @Nullable Output<Integer> bias;

    /**
     * @return Route more traffic or less traffic to the resource by specifying a value ranges between -90 to 90. See https://docs.aws.amazon.com/Route53/latest/DeveloperGuide/routing-policy-geoproximity.html for bias details.
     * 
     */
    public Optional<Output<Integer>> bias() {
        return Optional.ofNullable(this.bias);
    }

    /**
     * Specify `latitude` and `longitude` for routing traffic to non-AWS resources.
     * 
     */
    @Import(name="coordinates")
    private @Nullable Output<List<RecordGeoproximityRoutingPolicyCoordinateArgs>> coordinates;

    /**
     * @return Specify `latitude` and `longitude` for routing traffic to non-AWS resources.
     * 
     */
    public Optional<Output<List<RecordGeoproximityRoutingPolicyCoordinateArgs>>> coordinates() {
        return Optional.ofNullable(this.coordinates);
    }

    /**
     * A AWS local zone group where the resource is present. See https://docs.aws.amazon.com/local-zones/latest/ug/available-local-zones.html for local zone group list.
     * 
     */
    @Import(name="localZoneGroup")
    private @Nullable Output<String> localZoneGroup;

    /**
     * @return A AWS local zone group where the resource is present. See https://docs.aws.amazon.com/local-zones/latest/ug/available-local-zones.html for local zone group list.
     * 
     */
    public Optional<Output<String>> localZoneGroup() {
        return Optional.ofNullable(this.localZoneGroup);
    }

    private RecordGeoproximityRoutingPolicyArgs() {}

    private RecordGeoproximityRoutingPolicyArgs(RecordGeoproximityRoutingPolicyArgs $) {
        this.awsRegion = $.awsRegion;
        this.bias = $.bias;
        this.coordinates = $.coordinates;
        this.localZoneGroup = $.localZoneGroup;
    }

    public static Builder builder() {
        return new Builder();
    }
    public static Builder builder(RecordGeoproximityRoutingPolicyArgs defaults) {
        return new Builder(defaults);
    }

    public static final class Builder {
        private RecordGeoproximityRoutingPolicyArgs $;

        public Builder() {
            $ = new RecordGeoproximityRoutingPolicyArgs();
        }

        public Builder(RecordGeoproximityRoutingPolicyArgs defaults) {
            $ = new RecordGeoproximityRoutingPolicyArgs(Objects.requireNonNull(defaults));
        }

        /**
         * @param awsRegion A AWS region where the resource is present.
         * 
         * @return builder
         * 
         */
        public Builder awsRegion(@Nullable Output<String> awsRegion) {
            $.awsRegion = awsRegion;
            return this;
        }

        /**
         * @param awsRegion A AWS region where the resource is present.
         * 
         * @return builder
         * 
         */
        public Builder awsRegion(String awsRegion) {
            return awsRegion(Output.of(awsRegion));
        }

        /**
         * @param bias Route more traffic or less traffic to the resource by specifying a value ranges between -90 to 90. See https://docs.aws.amazon.com/Route53/latest/DeveloperGuide/routing-policy-geoproximity.html for bias details.
         * 
         * @return builder
         * 
         */
        public Builder bias(@Nullable Output<Integer> bias) {
            $.bias = bias;
            return this;
        }

        /**
         * @param bias Route more traffic or less traffic to the resource by specifying a value ranges between -90 to 90. See https://docs.aws.amazon.com/Route53/latest/DeveloperGuide/routing-policy-geoproximity.html for bias details.
         * 
         * @return builder
         * 
         */
        public Builder bias(Integer bias) {
            return bias(Output.of(bias));
        }

        /**
         * @param coordinates Specify `latitude` and `longitude` for routing traffic to non-AWS resources.
         * 
         * @return builder
         * 
         */
        public Builder coordinates(@Nullable Output<List<RecordGeoproximityRoutingPolicyCoordinateArgs>> coordinates) {
            $.coordinates = coordinates;
            return this;
        }

        /**
         * @param coordinates Specify `latitude` and `longitude` for routing traffic to non-AWS resources.
         * 
         * @return builder
         * 
         */
        public Builder coordinates(List<RecordGeoproximityRoutingPolicyCoordinateArgs> coordinates) {
            return coordinates(Output.of(coordinates));
        }

        /**
         * @param coordinates Specify `latitude` and `longitude` for routing traffic to non-AWS resources.
         * 
         * @return builder
         * 
         */
        public Builder coordinates(RecordGeoproximityRoutingPolicyCoordinateArgs... coordinates) {
            return coordinates(List.of(coordinates));
        }

        /**
         * @param localZoneGroup A AWS local zone group where the resource is present. See https://docs.aws.amazon.com/local-zones/latest/ug/available-local-zones.html for local zone group list.
         * 
         * @return builder
         * 
         */
        public Builder localZoneGroup(@Nullable Output<String> localZoneGroup) {
            $.localZoneGroup = localZoneGroup;
            return this;
        }

        /**
         * @param localZoneGroup A AWS local zone group where the resource is present. See https://docs.aws.amazon.com/local-zones/latest/ug/available-local-zones.html for local zone group list.
         * 
         * @return builder
         * 
         */
        public Builder localZoneGroup(String localZoneGroup) {
            return localZoneGroup(Output.of(localZoneGroup));
        }

        public RecordGeoproximityRoutingPolicyArgs build() {
            return $;
        }
    }

}
