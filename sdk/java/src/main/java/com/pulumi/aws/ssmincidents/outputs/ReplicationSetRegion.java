// *** WARNING: this file was generated by pulumi-java-gen. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

package com.pulumi.aws.ssmincidents.outputs;

import com.pulumi.core.annotations.CustomType;
import com.pulumi.exceptions.MissingRequiredPropertyException;
import java.lang.String;
import java.util.Objects;
import java.util.Optional;
import javax.annotation.Nullable;

@CustomType
public final class ReplicationSetRegion {
    /**
     * @return The Amazon Resource name (ARN) of the customer managed key. If omitted, AWS manages the AWS KMS keys for you, using an AWS owned key, as indicated by a default value of `DefaultKey`.
     * 
     */
    private @Nullable String kmsKeyArn;
    /**
     * @return The name of the Region, such as `ap-southeast-2`.
     * 
     */
    private String name;
    /**
     * @return The current status of the Region.
     * * Valid Values: `ACTIVE` | `CREATING` | `UPDATING` | `DELETING` | `FAILED`
     * 
     */
    private @Nullable String status;
    /**
     * @return More information about the status of a Region.
     * 
     */
    private @Nullable String statusMessage;

    private ReplicationSetRegion() {}
    /**
     * @return The Amazon Resource name (ARN) of the customer managed key. If omitted, AWS manages the AWS KMS keys for you, using an AWS owned key, as indicated by a default value of `DefaultKey`.
     * 
     */
    public Optional<String> kmsKeyArn() {
        return Optional.ofNullable(this.kmsKeyArn);
    }
    /**
     * @return The name of the Region, such as `ap-southeast-2`.
     * 
     */
    public String name() {
        return this.name;
    }
    /**
     * @return The current status of the Region.
     * * Valid Values: `ACTIVE` | `CREATING` | `UPDATING` | `DELETING` | `FAILED`
     * 
     */
    public Optional<String> status() {
        return Optional.ofNullable(this.status);
    }
    /**
     * @return More information about the status of a Region.
     * 
     */
    public Optional<String> statusMessage() {
        return Optional.ofNullable(this.statusMessage);
    }

    public static Builder builder() {
        return new Builder();
    }

    public static Builder builder(ReplicationSetRegion defaults) {
        return new Builder(defaults);
    }
    @CustomType.Builder
    public static final class Builder {
        private @Nullable String kmsKeyArn;
        private String name;
        private @Nullable String status;
        private @Nullable String statusMessage;
        public Builder() {}
        public Builder(ReplicationSetRegion defaults) {
    	      Objects.requireNonNull(defaults);
    	      this.kmsKeyArn = defaults.kmsKeyArn;
    	      this.name = defaults.name;
    	      this.status = defaults.status;
    	      this.statusMessage = defaults.statusMessage;
        }

        @CustomType.Setter
        public Builder kmsKeyArn(@Nullable String kmsKeyArn) {

            this.kmsKeyArn = kmsKeyArn;
            return this;
        }
        @CustomType.Setter
        public Builder name(String name) {
            if (name == null) {
              throw new MissingRequiredPropertyException("ReplicationSetRegion", "name");
            }
            this.name = name;
            return this;
        }
        @CustomType.Setter
        public Builder status(@Nullable String status) {

            this.status = status;
            return this;
        }
        @CustomType.Setter
        public Builder statusMessage(@Nullable String statusMessage) {

            this.statusMessage = statusMessage;
            return this;
        }
        public ReplicationSetRegion build() {
            final var _resultValue = new ReplicationSetRegion();
            _resultValue.kmsKeyArn = kmsKeyArn;
            _resultValue.name = name;
            _resultValue.status = status;
            _resultValue.statusMessage = statusMessage;
            return _resultValue;
        }
    }
}
