// *** WARNING: this file was generated by pulumi-java-gen. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

package com.pulumi.aws.lex.outputs;

import com.pulumi.core.annotations.CustomType;
import com.pulumi.exceptions.MissingRequiredPropertyException;
import java.lang.String;
import java.util.Objects;

@CustomType
public final class V2modelsSlotObfuscationSetting {
    /**
     * @return Whether Amazon Lex obscures slot values in conversation logs. Valid values are `DefaultObfuscation` and `None`.
     * 
     */
    private String obfuscationSettingType;

    private V2modelsSlotObfuscationSetting() {}
    /**
     * @return Whether Amazon Lex obscures slot values in conversation logs. Valid values are `DefaultObfuscation` and `None`.
     * 
     */
    public String obfuscationSettingType() {
        return this.obfuscationSettingType;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static Builder builder(V2modelsSlotObfuscationSetting defaults) {
        return new Builder(defaults);
    }
    @CustomType.Builder
    public static final class Builder {
        private String obfuscationSettingType;
        public Builder() {}
        public Builder(V2modelsSlotObfuscationSetting defaults) {
    	      Objects.requireNonNull(defaults);
    	      this.obfuscationSettingType = defaults.obfuscationSettingType;
        }

        @CustomType.Setter
        public Builder obfuscationSettingType(String obfuscationSettingType) {
            if (obfuscationSettingType == null) {
              throw new MissingRequiredPropertyException("V2modelsSlotObfuscationSetting", "obfuscationSettingType");
            }
            this.obfuscationSettingType = obfuscationSettingType;
            return this;
        }
        public V2modelsSlotObfuscationSetting build() {
            final var _resultValue = new V2modelsSlotObfuscationSetting();
            _resultValue.obfuscationSettingType = obfuscationSettingType;
            return _resultValue;
        }
    }
}
