// *** WARNING: this file was generated by pulumi-java-gen. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

package com.pulumi.aws.efs.outputs;

import com.pulumi.aws.efs.outputs.GetAccessPointPosixUser;
import com.pulumi.aws.efs.outputs.GetAccessPointRootDirectory;
import com.pulumi.core.annotations.CustomType;
import com.pulumi.exceptions.MissingRequiredPropertyException;
import java.lang.String;
import java.util.List;
import java.util.Map;
import java.util.Objects;

@CustomType
public final class GetAccessPointResult {
    private String accessPointId;
    /**
     * @return Amazon Resource Name of the file system.
     * 
     */
    private String arn;
    /**
     * @return Amazon Resource Name of the file system.
     * 
     */
    private String fileSystemArn;
    /**
     * @return ID of the file system for which the access point is intended.
     * 
     */
    private String fileSystemId;
    /**
     * @return The provider-assigned unique ID for this managed resource.
     * 
     */
    private String id;
    private String ownerId;
    /**
     * @return Single element list containing operating system user and group applied to all file system requests made using the access point.
     * 
     */
    private List<GetAccessPointPosixUser> posixUsers;
    /**
     * @return Single element list containing information on the directory on the Amazon EFS file system that the access point provides access to.
     * 
     */
    private List<GetAccessPointRootDirectory> rootDirectories;
    /**
     * @return Key-value mapping of resource tags.
     * 
     */
    private Map<String,String> tags;

    private GetAccessPointResult() {}
    public String accessPointId() {
        return this.accessPointId;
    }
    /**
     * @return Amazon Resource Name of the file system.
     * 
     */
    public String arn() {
        return this.arn;
    }
    /**
     * @return Amazon Resource Name of the file system.
     * 
     */
    public String fileSystemArn() {
        return this.fileSystemArn;
    }
    /**
     * @return ID of the file system for which the access point is intended.
     * 
     */
    public String fileSystemId() {
        return this.fileSystemId;
    }
    /**
     * @return The provider-assigned unique ID for this managed resource.
     * 
     */
    public String id() {
        return this.id;
    }
    public String ownerId() {
        return this.ownerId;
    }
    /**
     * @return Single element list containing operating system user and group applied to all file system requests made using the access point.
     * 
     */
    public List<GetAccessPointPosixUser> posixUsers() {
        return this.posixUsers;
    }
    /**
     * @return Single element list containing information on the directory on the Amazon EFS file system that the access point provides access to.
     * 
     */
    public List<GetAccessPointRootDirectory> rootDirectories() {
        return this.rootDirectories;
    }
    /**
     * @return Key-value mapping of resource tags.
     * 
     */
    public Map<String,String> tags() {
        return this.tags;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static Builder builder(GetAccessPointResult defaults) {
        return new Builder(defaults);
    }
    @CustomType.Builder
    public static final class Builder {
        private String accessPointId;
        private String arn;
        private String fileSystemArn;
        private String fileSystemId;
        private String id;
        private String ownerId;
        private List<GetAccessPointPosixUser> posixUsers;
        private List<GetAccessPointRootDirectory> rootDirectories;
        private Map<String,String> tags;
        public Builder() {}
        public Builder(GetAccessPointResult defaults) {
    	      Objects.requireNonNull(defaults);
    	      this.accessPointId = defaults.accessPointId;
    	      this.arn = defaults.arn;
    	      this.fileSystemArn = defaults.fileSystemArn;
    	      this.fileSystemId = defaults.fileSystemId;
    	      this.id = defaults.id;
    	      this.ownerId = defaults.ownerId;
    	      this.posixUsers = defaults.posixUsers;
    	      this.rootDirectories = defaults.rootDirectories;
    	      this.tags = defaults.tags;
        }

        @CustomType.Setter
        public Builder accessPointId(String accessPointId) {
            if (accessPointId == null) {
              throw new MissingRequiredPropertyException("GetAccessPointResult", "accessPointId");
            }
            this.accessPointId = accessPointId;
            return this;
        }
        @CustomType.Setter
        public Builder arn(String arn) {
            if (arn == null) {
              throw new MissingRequiredPropertyException("GetAccessPointResult", "arn");
            }
            this.arn = arn;
            return this;
        }
        @CustomType.Setter
        public Builder fileSystemArn(String fileSystemArn) {
            if (fileSystemArn == null) {
              throw new MissingRequiredPropertyException("GetAccessPointResult", "fileSystemArn");
            }
            this.fileSystemArn = fileSystemArn;
            return this;
        }
        @CustomType.Setter
        public Builder fileSystemId(String fileSystemId) {
            if (fileSystemId == null) {
              throw new MissingRequiredPropertyException("GetAccessPointResult", "fileSystemId");
            }
            this.fileSystemId = fileSystemId;
            return this;
        }
        @CustomType.Setter
        public Builder id(String id) {
            if (id == null) {
              throw new MissingRequiredPropertyException("GetAccessPointResult", "id");
            }
            this.id = id;
            return this;
        }
        @CustomType.Setter
        public Builder ownerId(String ownerId) {
            if (ownerId == null) {
              throw new MissingRequiredPropertyException("GetAccessPointResult", "ownerId");
            }
            this.ownerId = ownerId;
            return this;
        }
        @CustomType.Setter
        public Builder posixUsers(List<GetAccessPointPosixUser> posixUsers) {
            if (posixUsers == null) {
              throw new MissingRequiredPropertyException("GetAccessPointResult", "posixUsers");
            }
            this.posixUsers = posixUsers;
            return this;
        }
        public Builder posixUsers(GetAccessPointPosixUser... posixUsers) {
            return posixUsers(List.of(posixUsers));
        }
        @CustomType.Setter
        public Builder rootDirectories(List<GetAccessPointRootDirectory> rootDirectories) {
            if (rootDirectories == null) {
              throw new MissingRequiredPropertyException("GetAccessPointResult", "rootDirectories");
            }
            this.rootDirectories = rootDirectories;
            return this;
        }
        public Builder rootDirectories(GetAccessPointRootDirectory... rootDirectories) {
            return rootDirectories(List.of(rootDirectories));
        }
        @CustomType.Setter
        public Builder tags(Map<String,String> tags) {
            if (tags == null) {
              throw new MissingRequiredPropertyException("GetAccessPointResult", "tags");
            }
            this.tags = tags;
            return this;
        }
        public GetAccessPointResult build() {
            final var _resultValue = new GetAccessPointResult();
            _resultValue.accessPointId = accessPointId;
            _resultValue.arn = arn;
            _resultValue.fileSystemArn = fileSystemArn;
            _resultValue.fileSystemId = fileSystemId;
            _resultValue.id = id;
            _resultValue.ownerId = ownerId;
            _resultValue.posixUsers = posixUsers;
            _resultValue.rootDirectories = rootDirectories;
            _resultValue.tags = tags;
            return _resultValue;
        }
    }
}
