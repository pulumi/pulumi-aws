// *** WARNING: this file was generated by pulumi-java-gen. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

package com.pulumi.aws.emr.inputs;

import com.pulumi.aws.emr.inputs.GetSupportedInstanceTypesSupportedInstanceTypeArgs;
import com.pulumi.core.Output;
import com.pulumi.core.annotations.Import;
import com.pulumi.exceptions.MissingRequiredPropertyException;
import java.lang.String;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import javax.annotation.Nullable;


public final class GetSupportedInstanceTypesArgs extends com.pulumi.resources.InvokeArgs {

    public static final GetSupportedInstanceTypesArgs Empty = new GetSupportedInstanceTypesArgs();

    /**
     * Amazon EMR release label. For more information about Amazon EMR releases and their included application versions and features, see the [Amazon EMR Release Guide](https://docs.aws.amazon.com/emr/latest/ReleaseGuide/emr-release-components.html).
     * 
     */
    @Import(name="releaseLabel", required=true)
    private Output<String> releaseLabel;

    /**
     * @return Amazon EMR release label. For more information about Amazon EMR releases and their included application versions and features, see the [Amazon EMR Release Guide](https://docs.aws.amazon.com/emr/latest/ReleaseGuide/emr-release-components.html).
     * 
     */
    public Output<String> releaseLabel() {
        return this.releaseLabel;
    }

    /**
     * List of supported instance types. See `supported_instance_types` below.
     * 
     */
    @Import(name="supportedInstanceTypes")
    private @Nullable Output<List<GetSupportedInstanceTypesSupportedInstanceTypeArgs>> supportedInstanceTypes;

    /**
     * @return List of supported instance types. See `supported_instance_types` below.
     * 
     */
    public Optional<Output<List<GetSupportedInstanceTypesSupportedInstanceTypeArgs>>> supportedInstanceTypes() {
        return Optional.ofNullable(this.supportedInstanceTypes);
    }

    private GetSupportedInstanceTypesArgs() {}

    private GetSupportedInstanceTypesArgs(GetSupportedInstanceTypesArgs $) {
        this.releaseLabel = $.releaseLabel;
        this.supportedInstanceTypes = $.supportedInstanceTypes;
    }

    public static Builder builder() {
        return new Builder();
    }
    public static Builder builder(GetSupportedInstanceTypesArgs defaults) {
        return new Builder(defaults);
    }

    public static final class Builder {
        private GetSupportedInstanceTypesArgs $;

        public Builder() {
            $ = new GetSupportedInstanceTypesArgs();
        }

        public Builder(GetSupportedInstanceTypesArgs defaults) {
            $ = new GetSupportedInstanceTypesArgs(Objects.requireNonNull(defaults));
        }

        /**
         * @param releaseLabel Amazon EMR release label. For more information about Amazon EMR releases and their included application versions and features, see the [Amazon EMR Release Guide](https://docs.aws.amazon.com/emr/latest/ReleaseGuide/emr-release-components.html).
         * 
         * @return builder
         * 
         */
        public Builder releaseLabel(Output<String> releaseLabel) {
            $.releaseLabel = releaseLabel;
            return this;
        }

        /**
         * @param releaseLabel Amazon EMR release label. For more information about Amazon EMR releases and their included application versions and features, see the [Amazon EMR Release Guide](https://docs.aws.amazon.com/emr/latest/ReleaseGuide/emr-release-components.html).
         * 
         * @return builder
         * 
         */
        public Builder releaseLabel(String releaseLabel) {
            return releaseLabel(Output.of(releaseLabel));
        }

        /**
         * @param supportedInstanceTypes List of supported instance types. See `supported_instance_types` below.
         * 
         * @return builder
         * 
         */
        public Builder supportedInstanceTypes(@Nullable Output<List<GetSupportedInstanceTypesSupportedInstanceTypeArgs>> supportedInstanceTypes) {
            $.supportedInstanceTypes = supportedInstanceTypes;
            return this;
        }

        /**
         * @param supportedInstanceTypes List of supported instance types. See `supported_instance_types` below.
         * 
         * @return builder
         * 
         */
        public Builder supportedInstanceTypes(List<GetSupportedInstanceTypesSupportedInstanceTypeArgs> supportedInstanceTypes) {
            return supportedInstanceTypes(Output.of(supportedInstanceTypes));
        }

        /**
         * @param supportedInstanceTypes List of supported instance types. See `supported_instance_types` below.
         * 
         * @return builder
         * 
         */
        public Builder supportedInstanceTypes(GetSupportedInstanceTypesSupportedInstanceTypeArgs... supportedInstanceTypes) {
            return supportedInstanceTypes(List.of(supportedInstanceTypes));
        }

        public GetSupportedInstanceTypesArgs build() {
            if ($.releaseLabel == null) {
                throw new MissingRequiredPropertyException("GetSupportedInstanceTypesArgs", "releaseLabel");
            }
            return $;
        }
    }

}
