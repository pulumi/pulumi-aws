// *** WARNING: this file was generated by pulumi-java-gen. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

package com.pulumi.aws.iam.outputs;

import com.pulumi.aws.iam.outputs.GetAccessKeysAccessKey;
import com.pulumi.core.annotations.CustomType;
import java.lang.String;
import java.util.List;
import java.util.Objects;

@CustomType
public final class GetAccessKeysResult {
    /**
     * @return List of the IAM access keys associated with the specified user. See below.
     * 
     */
    private List<GetAccessKeysAccessKey> accessKeys;
    /**
     * @return The provider-assigned unique ID for this managed resource.
     * 
     */
    private String id;
    private String user;

    private GetAccessKeysResult() {}
    /**
     * @return List of the IAM access keys associated with the specified user. See below.
     * 
     */
    public List<GetAccessKeysAccessKey> accessKeys() {
        return this.accessKeys;
    }
    /**
     * @return The provider-assigned unique ID for this managed resource.
     * 
     */
    public String id() {
        return this.id;
    }
    public String user() {
        return this.user;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static Builder builder(GetAccessKeysResult defaults) {
        return new Builder(defaults);
    }
    @CustomType.Builder
    public static final class Builder {
        private List<GetAccessKeysAccessKey> accessKeys;
        private String id;
        private String user;
        public Builder() {}
        public Builder(GetAccessKeysResult defaults) {
    	      Objects.requireNonNull(defaults);
    	      this.accessKeys = defaults.accessKeys;
    	      this.id = defaults.id;
    	      this.user = defaults.user;
        }

        @CustomType.Setter
        public Builder accessKeys(List<GetAccessKeysAccessKey> accessKeys) {
            this.accessKeys = Objects.requireNonNull(accessKeys);
            return this;
        }
        public Builder accessKeys(GetAccessKeysAccessKey... accessKeys) {
            return accessKeys(List.of(accessKeys));
        }
        @CustomType.Setter
        public Builder id(String id) {
            this.id = Objects.requireNonNull(id);
            return this;
        }
        @CustomType.Setter
        public Builder user(String user) {
            this.user = Objects.requireNonNull(user);
            return this;
        }
        public GetAccessKeysResult build() {
            final var o = new GetAccessKeysResult();
            o.accessKeys = accessKeys;
            o.id = id;
            o.user = user;
            return o;
        }
    }
}