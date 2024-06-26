// *** WARNING: this file was generated by pulumi-java-gen. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

package com.pulumi.aws.quicksight.outputs;

import com.pulumi.aws.quicksight.outputs.GetDataSetLogicalTableMapDataTransform;
import com.pulumi.aws.quicksight.outputs.GetDataSetLogicalTableMapSource;
import com.pulumi.core.annotations.CustomType;
import com.pulumi.exceptions.MissingRequiredPropertyException;
import java.lang.String;
import java.util.List;
import java.util.Objects;

@CustomType
public final class GetDataSetLogicalTableMap {
    private String alias;
    private List<GetDataSetLogicalTableMapDataTransform> dataTransforms;
    private String logicalTableMapId;
    private List<GetDataSetLogicalTableMapSource> sources;

    private GetDataSetLogicalTableMap() {}
    public String alias() {
        return this.alias;
    }
    public List<GetDataSetLogicalTableMapDataTransform> dataTransforms() {
        return this.dataTransforms;
    }
    public String logicalTableMapId() {
        return this.logicalTableMapId;
    }
    public List<GetDataSetLogicalTableMapSource> sources() {
        return this.sources;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static Builder builder(GetDataSetLogicalTableMap defaults) {
        return new Builder(defaults);
    }
    @CustomType.Builder
    public static final class Builder {
        private String alias;
        private List<GetDataSetLogicalTableMapDataTransform> dataTransforms;
        private String logicalTableMapId;
        private List<GetDataSetLogicalTableMapSource> sources;
        public Builder() {}
        public Builder(GetDataSetLogicalTableMap defaults) {
    	      Objects.requireNonNull(defaults);
    	      this.alias = defaults.alias;
    	      this.dataTransforms = defaults.dataTransforms;
    	      this.logicalTableMapId = defaults.logicalTableMapId;
    	      this.sources = defaults.sources;
        }

        @CustomType.Setter
        public Builder alias(String alias) {
            if (alias == null) {
              throw new MissingRequiredPropertyException("GetDataSetLogicalTableMap", "alias");
            }
            this.alias = alias;
            return this;
        }
        @CustomType.Setter
        public Builder dataTransforms(List<GetDataSetLogicalTableMapDataTransform> dataTransforms) {
            if (dataTransforms == null) {
              throw new MissingRequiredPropertyException("GetDataSetLogicalTableMap", "dataTransforms");
            }
            this.dataTransforms = dataTransforms;
            return this;
        }
        public Builder dataTransforms(GetDataSetLogicalTableMapDataTransform... dataTransforms) {
            return dataTransforms(List.of(dataTransforms));
        }
        @CustomType.Setter
        public Builder logicalTableMapId(String logicalTableMapId) {
            if (logicalTableMapId == null) {
              throw new MissingRequiredPropertyException("GetDataSetLogicalTableMap", "logicalTableMapId");
            }
            this.logicalTableMapId = logicalTableMapId;
            return this;
        }
        @CustomType.Setter
        public Builder sources(List<GetDataSetLogicalTableMapSource> sources) {
            if (sources == null) {
              throw new MissingRequiredPropertyException("GetDataSetLogicalTableMap", "sources");
            }
            this.sources = sources;
            return this;
        }
        public Builder sources(GetDataSetLogicalTableMapSource... sources) {
            return sources(List.of(sources));
        }
        public GetDataSetLogicalTableMap build() {
            final var _resultValue = new GetDataSetLogicalTableMap();
            _resultValue.alias = alias;
            _resultValue.dataTransforms = dataTransforms;
            _resultValue.logicalTableMapId = logicalTableMapId;
            _resultValue.sources = sources;
            return _resultValue;
        }
    }
}
