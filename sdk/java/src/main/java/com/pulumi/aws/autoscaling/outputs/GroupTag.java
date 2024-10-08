// *** WARNING: this file was generated by pulumi-java-gen. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

package com.pulumi.aws.autoscaling.outputs;

import com.pulumi.core.annotations.CustomType;
import com.pulumi.exceptions.MissingRequiredPropertyException;
import java.lang.Boolean;
import java.lang.String;
import java.util.Objects;

@CustomType
public final class GroupTag {
    /**
     * @return Key
     * 
     */
    private String key;
    /**
     * @return Enables propagation of the tag to
     * Amazon EC2 instances launched via this ASG
     * 
     * To declare multiple tags, additional `tag` blocks can be specified.
     * 
     * &gt; **NOTE:** Other AWS APIs may automatically add special tags to their associated Auto Scaling Group for management purposes, such as ECS Capacity Providers adding the `AmazonECSManaged` tag. These generally should be included in the configuration so the provider does not attempt to remove them and so if the `min_size` was greater than zero on creation, that these tag(s) are applied to any initial EC2 Instances in the Auto Scaling Group. If these tag(s) were missing in the Auto Scaling Group configuration on creation, affected EC2 Instances missing the tags may require manual intervention of adding the tags to ensure they work properly with the other AWS service.
     * 
     */
    private Boolean propagateAtLaunch;
    /**
     * @return Value
     * 
     */
    private String value;

    private GroupTag() {}
    /**
     * @return Key
     * 
     */
    public String key() {
        return this.key;
    }
    /**
     * @return Enables propagation of the tag to
     * Amazon EC2 instances launched via this ASG
     * 
     * To declare multiple tags, additional `tag` blocks can be specified.
     * 
     * &gt; **NOTE:** Other AWS APIs may automatically add special tags to their associated Auto Scaling Group for management purposes, such as ECS Capacity Providers adding the `AmazonECSManaged` tag. These generally should be included in the configuration so the provider does not attempt to remove them and so if the `min_size` was greater than zero on creation, that these tag(s) are applied to any initial EC2 Instances in the Auto Scaling Group. If these tag(s) were missing in the Auto Scaling Group configuration on creation, affected EC2 Instances missing the tags may require manual intervention of adding the tags to ensure they work properly with the other AWS service.
     * 
     */
    public Boolean propagateAtLaunch() {
        return this.propagateAtLaunch;
    }
    /**
     * @return Value
     * 
     */
    public String value() {
        return this.value;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static Builder builder(GroupTag defaults) {
        return new Builder(defaults);
    }
    @CustomType.Builder
    public static final class Builder {
        private String key;
        private Boolean propagateAtLaunch;
        private String value;
        public Builder() {}
        public Builder(GroupTag defaults) {
    	      Objects.requireNonNull(defaults);
    	      this.key = defaults.key;
    	      this.propagateAtLaunch = defaults.propagateAtLaunch;
    	      this.value = defaults.value;
        }

        @CustomType.Setter
        public Builder key(String key) {
            if (key == null) {
              throw new MissingRequiredPropertyException("GroupTag", "key");
            }
            this.key = key;
            return this;
        }
        @CustomType.Setter
        public Builder propagateAtLaunch(Boolean propagateAtLaunch) {
            if (propagateAtLaunch == null) {
              throw new MissingRequiredPropertyException("GroupTag", "propagateAtLaunch");
            }
            this.propagateAtLaunch = propagateAtLaunch;
            return this;
        }
        @CustomType.Setter
        public Builder value(String value) {
            if (value == null) {
              throw new MissingRequiredPropertyException("GroupTag", "value");
            }
            this.value = value;
            return this;
        }
        public GroupTag build() {
            final var _resultValue = new GroupTag();
            _resultValue.key = key;
            _resultValue.propagateAtLaunch = propagateAtLaunch;
            _resultValue.value = value;
            return _resultValue;
        }
    }
}
