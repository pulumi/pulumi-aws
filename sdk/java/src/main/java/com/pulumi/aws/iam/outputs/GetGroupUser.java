// *** WARNING: this file was generated by pulumi-java-gen. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

package com.pulumi.aws.iam.outputs;

import com.pulumi.core.annotations.CustomType;
import com.pulumi.exceptions.MissingRequiredPropertyException;
import java.lang.String;
import java.util.Objects;

@CustomType
public final class GetGroupUser {
    /**
     * @return User ARN.
     * 
     */
    private String arn;
    /**
     * @return Path to the IAM user.
     * 
     */
    private String path;
    /**
     * @return Stable and unique string identifying the IAM user.
     * 
     */
    private String userId;
    /**
     * @return Name of the IAM user.
     * 
     */
    private String userName;

    private GetGroupUser() {}
    /**
     * @return User ARN.
     * 
     */
    public String arn() {
        return this.arn;
    }
    /**
     * @return Path to the IAM user.
     * 
     */
    public String path() {
        return this.path;
    }
    /**
     * @return Stable and unique string identifying the IAM user.
     * 
     */
    public String userId() {
        return this.userId;
    }
    /**
     * @return Name of the IAM user.
     * 
     */
    public String userName() {
        return this.userName;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static Builder builder(GetGroupUser defaults) {
        return new Builder(defaults);
    }
    @CustomType.Builder
    public static final class Builder {
        private String arn;
        private String path;
        private String userId;
        private String userName;
        public Builder() {}
        public Builder(GetGroupUser defaults) {
    	      Objects.requireNonNull(defaults);
    	      this.arn = defaults.arn;
    	      this.path = defaults.path;
    	      this.userId = defaults.userId;
    	      this.userName = defaults.userName;
        }

        @CustomType.Setter
        public Builder arn(String arn) {
            if (arn == null) {
              throw new MissingRequiredPropertyException("GetGroupUser", "arn");
            }
            this.arn = arn;
            return this;
        }
        @CustomType.Setter
        public Builder path(String path) {
            if (path == null) {
              throw new MissingRequiredPropertyException("GetGroupUser", "path");
            }
            this.path = path;
            return this;
        }
        @CustomType.Setter
        public Builder userId(String userId) {
            if (userId == null) {
              throw new MissingRequiredPropertyException("GetGroupUser", "userId");
            }
            this.userId = userId;
            return this;
        }
        @CustomType.Setter
        public Builder userName(String userName) {
            if (userName == null) {
              throw new MissingRequiredPropertyException("GetGroupUser", "userName");
            }
            this.userName = userName;
            return this;
        }
        public GetGroupUser build() {
            final var _resultValue = new GetGroupUser();
            _resultValue.arn = arn;
            _resultValue.path = path;
            _resultValue.userId = userId;
            _resultValue.userName = userName;
            return _resultValue;
        }
    }
}
