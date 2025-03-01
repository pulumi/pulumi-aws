// *** WARNING: this file was generated by pulumi-java-gen. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

package com.pulumi.aws.synthetics.inputs;

import com.pulumi.core.annotations.Import;
import com.pulumi.exceptions.MissingRequiredPropertyException;
import java.lang.String;
import java.util.Objects;


public final class GetRuntimeVersionsRuntimeVersion extends com.pulumi.resources.InvokeArgs {

    public static final GetRuntimeVersionsRuntimeVersion Empty = new GetRuntimeVersionsRuntimeVersion();

    /**
     * Date of deprecation if the runtme version is deprecated.
     * 
     */
    @Import(name="deprecationDate", required=true)
    private String deprecationDate;

    /**
     * @return Date of deprecation if the runtme version is deprecated.
     * 
     */
    public String deprecationDate() {
        return this.deprecationDate;
    }

    /**
     * Description of the runtime version, created by Amazon.
     * 
     */
    @Import(name="description", required=true)
    private String description;

    /**
     * @return Description of the runtime version, created by Amazon.
     * 
     */
    public String description() {
        return this.description;
    }

    /**
     * Date that the runtime version was released.
     * 
     */
    @Import(name="releaseDate", required=true)
    private String releaseDate;

    /**
     * @return Date that the runtime version was released.
     * 
     */
    public String releaseDate() {
        return this.releaseDate;
    }

    /**
     * Name of the runtime version.
     * For a list of valid runtime versions, see [Canary Runtime Versions](https://docs.aws.amazon.com/AmazonCloudWatch/latest/monitoring/CloudWatch_Synthetics_Canaries_Library.html).
     * 
     */
    @Import(name="versionName", required=true)
    private String versionName;

    /**
     * @return Name of the runtime version.
     * For a list of valid runtime versions, see [Canary Runtime Versions](https://docs.aws.amazon.com/AmazonCloudWatch/latest/monitoring/CloudWatch_Synthetics_Canaries_Library.html).
     * 
     */
    public String versionName() {
        return this.versionName;
    }

    private GetRuntimeVersionsRuntimeVersion() {}

    private GetRuntimeVersionsRuntimeVersion(GetRuntimeVersionsRuntimeVersion $) {
        this.deprecationDate = $.deprecationDate;
        this.description = $.description;
        this.releaseDate = $.releaseDate;
        this.versionName = $.versionName;
    }

    public static Builder builder() {
        return new Builder();
    }
    public static Builder builder(GetRuntimeVersionsRuntimeVersion defaults) {
        return new Builder(defaults);
    }

    public static final class Builder {
        private GetRuntimeVersionsRuntimeVersion $;

        public Builder() {
            $ = new GetRuntimeVersionsRuntimeVersion();
        }

        public Builder(GetRuntimeVersionsRuntimeVersion defaults) {
            $ = new GetRuntimeVersionsRuntimeVersion(Objects.requireNonNull(defaults));
        }

        /**
         * @param deprecationDate Date of deprecation if the runtme version is deprecated.
         * 
         * @return builder
         * 
         */
        public Builder deprecationDate(String deprecationDate) {
            $.deprecationDate = deprecationDate;
            return this;
        }

        /**
         * @param description Description of the runtime version, created by Amazon.
         * 
         * @return builder
         * 
         */
        public Builder description(String description) {
            $.description = description;
            return this;
        }

        /**
         * @param releaseDate Date that the runtime version was released.
         * 
         * @return builder
         * 
         */
        public Builder releaseDate(String releaseDate) {
            $.releaseDate = releaseDate;
            return this;
        }

        /**
         * @param versionName Name of the runtime version.
         * For a list of valid runtime versions, see [Canary Runtime Versions](https://docs.aws.amazon.com/AmazonCloudWatch/latest/monitoring/CloudWatch_Synthetics_Canaries_Library.html).
         * 
         * @return builder
         * 
         */
        public Builder versionName(String versionName) {
            $.versionName = versionName;
            return this;
        }

        public GetRuntimeVersionsRuntimeVersion build() {
            if ($.deprecationDate == null) {
                throw new MissingRequiredPropertyException("GetRuntimeVersionsRuntimeVersion", "deprecationDate");
            }
            if ($.description == null) {
                throw new MissingRequiredPropertyException("GetRuntimeVersionsRuntimeVersion", "description");
            }
            if ($.releaseDate == null) {
                throw new MissingRequiredPropertyException("GetRuntimeVersionsRuntimeVersion", "releaseDate");
            }
            if ($.versionName == null) {
                throw new MissingRequiredPropertyException("GetRuntimeVersionsRuntimeVersion", "versionName");
            }
            return $;
        }
    }

}
