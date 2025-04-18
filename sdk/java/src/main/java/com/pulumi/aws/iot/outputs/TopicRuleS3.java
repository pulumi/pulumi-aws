// *** WARNING: this file was generated by pulumi-java-gen. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

package com.pulumi.aws.iot.outputs;

import com.pulumi.core.annotations.CustomType;
import com.pulumi.exceptions.MissingRequiredPropertyException;
import java.lang.String;
import java.util.Objects;
import java.util.Optional;
import javax.annotation.Nullable;

@CustomType
public final class TopicRuleS3 {
    /**
     * @return The Amazon S3 bucket name.
     * 
     */
    private String bucketName;
    /**
     * @return The Amazon S3 canned ACL that controls access to the object identified by the object key. [Valid values](https://docs.aws.amazon.com/AmazonS3/latest/userguide/acl-overview.html#canned-acl).
     * 
     */
    private @Nullable String cannedAcl;
    /**
     * @return The object key.
     * 
     */
    private String key;
    /**
     * @return The ARN of the IAM role that grants access.
     * 
     */
    private String roleArn;

    private TopicRuleS3() {}
    /**
     * @return The Amazon S3 bucket name.
     * 
     */
    public String bucketName() {
        return this.bucketName;
    }
    /**
     * @return The Amazon S3 canned ACL that controls access to the object identified by the object key. [Valid values](https://docs.aws.amazon.com/AmazonS3/latest/userguide/acl-overview.html#canned-acl).
     * 
     */
    public Optional<String> cannedAcl() {
        return Optional.ofNullable(this.cannedAcl);
    }
    /**
     * @return The object key.
     * 
     */
    public String key() {
        return this.key;
    }
    /**
     * @return The ARN of the IAM role that grants access.
     * 
     */
    public String roleArn() {
        return this.roleArn;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static Builder builder(TopicRuleS3 defaults) {
        return new Builder(defaults);
    }
    @CustomType.Builder
    public static final class Builder {
        private String bucketName;
        private @Nullable String cannedAcl;
        private String key;
        private String roleArn;
        public Builder() {}
        public Builder(TopicRuleS3 defaults) {
    	      Objects.requireNonNull(defaults);
    	      this.bucketName = defaults.bucketName;
    	      this.cannedAcl = defaults.cannedAcl;
    	      this.key = defaults.key;
    	      this.roleArn = defaults.roleArn;
        }

        @CustomType.Setter
        public Builder bucketName(String bucketName) {
            if (bucketName == null) {
              throw new MissingRequiredPropertyException("TopicRuleS3", "bucketName");
            }
            this.bucketName = bucketName;
            return this;
        }
        @CustomType.Setter
        public Builder cannedAcl(@Nullable String cannedAcl) {

            this.cannedAcl = cannedAcl;
            return this;
        }
        @CustomType.Setter
        public Builder key(String key) {
            if (key == null) {
              throw new MissingRequiredPropertyException("TopicRuleS3", "key");
            }
            this.key = key;
            return this;
        }
        @CustomType.Setter
        public Builder roleArn(String roleArn) {
            if (roleArn == null) {
              throw new MissingRequiredPropertyException("TopicRuleS3", "roleArn");
            }
            this.roleArn = roleArn;
            return this;
        }
        public TopicRuleS3 build() {
            final var _resultValue = new TopicRuleS3();
            _resultValue.bucketName = bucketName;
            _resultValue.cannedAcl = cannedAcl;
            _resultValue.key = key;
            _resultValue.roleArn = roleArn;
            return _resultValue;
        }
    }
}
