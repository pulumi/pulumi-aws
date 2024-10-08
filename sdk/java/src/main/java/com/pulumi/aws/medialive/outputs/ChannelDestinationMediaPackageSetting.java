// *** WARNING: this file was generated by pulumi-java-gen. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

package com.pulumi.aws.medialive.outputs;

import com.pulumi.core.annotations.CustomType;
import com.pulumi.exceptions.MissingRequiredPropertyException;
import java.lang.String;
import java.util.Objects;

@CustomType
public final class ChannelDestinationMediaPackageSetting {
    /**
     * @return ID of the channel in MediaPackage that is the destination for this output group.
     * 
     */
    private String channelId;

    private ChannelDestinationMediaPackageSetting() {}
    /**
     * @return ID of the channel in MediaPackage that is the destination for this output group.
     * 
     */
    public String channelId() {
        return this.channelId;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static Builder builder(ChannelDestinationMediaPackageSetting defaults) {
        return new Builder(defaults);
    }
    @CustomType.Builder
    public static final class Builder {
        private String channelId;
        public Builder() {}
        public Builder(ChannelDestinationMediaPackageSetting defaults) {
    	      Objects.requireNonNull(defaults);
    	      this.channelId = defaults.channelId;
        }

        @CustomType.Setter
        public Builder channelId(String channelId) {
            if (channelId == null) {
              throw new MissingRequiredPropertyException("ChannelDestinationMediaPackageSetting", "channelId");
            }
            this.channelId = channelId;
            return this;
        }
        public ChannelDestinationMediaPackageSetting build() {
            final var _resultValue = new ChannelDestinationMediaPackageSetting();
            _resultValue.channelId = channelId;
            return _resultValue;
        }
    }
}
