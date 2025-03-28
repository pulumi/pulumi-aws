// *** WARNING: this file was generated by pulumi-java-gen. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

package com.pulumi.aws.ec2transitgateway.outputs;

import com.pulumi.aws.ec2transitgateway.outputs.GetAttachmentsFilter;
import com.pulumi.core.annotations.CustomType;
import com.pulumi.exceptions.MissingRequiredPropertyException;
import java.lang.String;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import javax.annotation.Nullable;

@CustomType
public final class GetAttachmentsResult {
    private @Nullable List<GetAttachmentsFilter> filters;
    /**
     * @return The provider-assigned unique ID for this managed resource.
     * 
     */
    private String id;
    /**
     * @return A list of all attachments ids matching the filter. You can retrieve more information about the attachment using the [aws.ec2transitgateway.getAttachment][2] data source, searching by identifier.
     * 
     */
    private List<String> ids;
    private Map<String,String> tags;

    private GetAttachmentsResult() {}
    public List<GetAttachmentsFilter> filters() {
        return this.filters == null ? List.of() : this.filters;
    }
    /**
     * @return The provider-assigned unique ID for this managed resource.
     * 
     */
    public String id() {
        return this.id;
    }
    /**
     * @return A list of all attachments ids matching the filter. You can retrieve more information about the attachment using the [aws.ec2transitgateway.getAttachment][2] data source, searching by identifier.
     * 
     */
    public List<String> ids() {
        return this.ids;
    }
    public Map<String,String> tags() {
        return this.tags;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static Builder builder(GetAttachmentsResult defaults) {
        return new Builder(defaults);
    }
    @CustomType.Builder
    public static final class Builder {
        private @Nullable List<GetAttachmentsFilter> filters;
        private String id;
        private List<String> ids;
        private Map<String,String> tags;
        public Builder() {}
        public Builder(GetAttachmentsResult defaults) {
    	      Objects.requireNonNull(defaults);
    	      this.filters = defaults.filters;
    	      this.id = defaults.id;
    	      this.ids = defaults.ids;
    	      this.tags = defaults.tags;
        }

        @CustomType.Setter
        public Builder filters(@Nullable List<GetAttachmentsFilter> filters) {

            this.filters = filters;
            return this;
        }
        public Builder filters(GetAttachmentsFilter... filters) {
            return filters(List.of(filters));
        }
        @CustomType.Setter
        public Builder id(String id) {
            if (id == null) {
              throw new MissingRequiredPropertyException("GetAttachmentsResult", "id");
            }
            this.id = id;
            return this;
        }
        @CustomType.Setter
        public Builder ids(List<String> ids) {
            if (ids == null) {
              throw new MissingRequiredPropertyException("GetAttachmentsResult", "ids");
            }
            this.ids = ids;
            return this;
        }
        public Builder ids(String... ids) {
            return ids(List.of(ids));
        }
        @CustomType.Setter
        public Builder tags(Map<String,String> tags) {
            if (tags == null) {
              throw new MissingRequiredPropertyException("GetAttachmentsResult", "tags");
            }
            this.tags = tags;
            return this;
        }
        public GetAttachmentsResult build() {
            final var _resultValue = new GetAttachmentsResult();
            _resultValue.filters = filters;
            _resultValue.id = id;
            _resultValue.ids = ids;
            _resultValue.tags = tags;
            return _resultValue;
        }
    }
}
