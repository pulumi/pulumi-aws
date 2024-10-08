// *** WARNING: this file was generated by pulumi-java-gen. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

package com.pulumi.aws.timestreamwrite.outputs;

import com.pulumi.core.annotations.CustomType;
import com.pulumi.exceptions.MissingRequiredPropertyException;
import java.lang.String;
import java.util.Objects;

@CustomType
public final class GetTableSchemaCompositePartitionKey {
    private String enforcementInRecord;
    /**
     * @return Name of the Timestream table.
     * 
     */
    private String name;
    /**
     * @return Type of partition key.
     * 
     */
    private String type;

    private GetTableSchemaCompositePartitionKey() {}
    public String enforcementInRecord() {
        return this.enforcementInRecord;
    }
    /**
     * @return Name of the Timestream table.
     * 
     */
    public String name() {
        return this.name;
    }
    /**
     * @return Type of partition key.
     * 
     */
    public String type() {
        return this.type;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static Builder builder(GetTableSchemaCompositePartitionKey defaults) {
        return new Builder(defaults);
    }
    @CustomType.Builder
    public static final class Builder {
        private String enforcementInRecord;
        private String name;
        private String type;
        public Builder() {}
        public Builder(GetTableSchemaCompositePartitionKey defaults) {
    	      Objects.requireNonNull(defaults);
    	      this.enforcementInRecord = defaults.enforcementInRecord;
    	      this.name = defaults.name;
    	      this.type = defaults.type;
        }

        @CustomType.Setter
        public Builder enforcementInRecord(String enforcementInRecord) {
            if (enforcementInRecord == null) {
              throw new MissingRequiredPropertyException("GetTableSchemaCompositePartitionKey", "enforcementInRecord");
            }
            this.enforcementInRecord = enforcementInRecord;
            return this;
        }
        @CustomType.Setter
        public Builder name(String name) {
            if (name == null) {
              throw new MissingRequiredPropertyException("GetTableSchemaCompositePartitionKey", "name");
            }
            this.name = name;
            return this;
        }
        @CustomType.Setter
        public Builder type(String type) {
            if (type == null) {
              throw new MissingRequiredPropertyException("GetTableSchemaCompositePartitionKey", "type");
            }
            this.type = type;
            return this;
        }
        public GetTableSchemaCompositePartitionKey build() {
            final var _resultValue = new GetTableSchemaCompositePartitionKey();
            _resultValue.enforcementInRecord = enforcementInRecord;
            _resultValue.name = name;
            _resultValue.type = type;
            return _resultValue;
        }
    }
}
