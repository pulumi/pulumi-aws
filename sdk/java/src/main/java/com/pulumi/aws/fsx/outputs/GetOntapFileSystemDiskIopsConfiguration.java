// *** WARNING: this file was generated by pulumi-java-gen. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

package com.pulumi.aws.fsx.outputs;

import com.pulumi.core.annotations.CustomType;
import com.pulumi.exceptions.MissingRequiredPropertyException;
import java.lang.Integer;
import java.lang.String;
import java.util.Objects;

@CustomType
public final class GetOntapFileSystemDiskIopsConfiguration {
    /**
     * @return The total number of SSD IOPS provisioned for the file system.
     * 
     */
    private Integer iops;
    /**
     * @return Specifies whether the file system is using the `AUTOMATIC` setting of SSD IOPS of 3 IOPS per GB of storage capacity, or if it using a `USER_PROVISIONED` value.
     * 
     */
    private String mode;

    private GetOntapFileSystemDiskIopsConfiguration() {}
    /**
     * @return The total number of SSD IOPS provisioned for the file system.
     * 
     */
    public Integer iops() {
        return this.iops;
    }
    /**
     * @return Specifies whether the file system is using the `AUTOMATIC` setting of SSD IOPS of 3 IOPS per GB of storage capacity, or if it using a `USER_PROVISIONED` value.
     * 
     */
    public String mode() {
        return this.mode;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static Builder builder(GetOntapFileSystemDiskIopsConfiguration defaults) {
        return new Builder(defaults);
    }
    @CustomType.Builder
    public static final class Builder {
        private Integer iops;
        private String mode;
        public Builder() {}
        public Builder(GetOntapFileSystemDiskIopsConfiguration defaults) {
    	      Objects.requireNonNull(defaults);
    	      this.iops = defaults.iops;
    	      this.mode = defaults.mode;
        }

        @CustomType.Setter
        public Builder iops(Integer iops) {
            if (iops == null) {
              throw new MissingRequiredPropertyException("GetOntapFileSystemDiskIopsConfiguration", "iops");
            }
            this.iops = iops;
            return this;
        }
        @CustomType.Setter
        public Builder mode(String mode) {
            if (mode == null) {
              throw new MissingRequiredPropertyException("GetOntapFileSystemDiskIopsConfiguration", "mode");
            }
            this.mode = mode;
            return this;
        }
        public GetOntapFileSystemDiskIopsConfiguration build() {
            final var _resultValue = new GetOntapFileSystemDiskIopsConfiguration();
            _resultValue.iops = iops;
            _resultValue.mode = mode;
            return _resultValue;
        }
    }
}
