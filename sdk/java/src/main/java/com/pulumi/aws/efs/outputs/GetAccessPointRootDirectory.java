// *** WARNING: this file was generated by pulumi-java-gen. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

package com.pulumi.aws.efs.outputs;

import com.pulumi.aws.efs.outputs.GetAccessPointRootDirectoryCreationInfo;
import com.pulumi.core.annotations.CustomType;
import com.pulumi.exceptions.MissingRequiredPropertyException;
import java.lang.String;
import java.util.List;
import java.util.Objects;

@CustomType
public final class GetAccessPointRootDirectory {
    /**
     * @return Single element list containing information on the creation permissions of the directory
     * 
     */
    private List<GetAccessPointRootDirectoryCreationInfo> creationInfos;
    /**
     * @return Path exposed as the root directory
     * 
     */
    private String path;

    private GetAccessPointRootDirectory() {}
    /**
     * @return Single element list containing information on the creation permissions of the directory
     * 
     */
    public List<GetAccessPointRootDirectoryCreationInfo> creationInfos() {
        return this.creationInfos;
    }
    /**
     * @return Path exposed as the root directory
     * 
     */
    public String path() {
        return this.path;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static Builder builder(GetAccessPointRootDirectory defaults) {
        return new Builder(defaults);
    }
    @CustomType.Builder
    public static final class Builder {
        private List<GetAccessPointRootDirectoryCreationInfo> creationInfos;
        private String path;
        public Builder() {}
        public Builder(GetAccessPointRootDirectory defaults) {
    	      Objects.requireNonNull(defaults);
    	      this.creationInfos = defaults.creationInfos;
    	      this.path = defaults.path;
        }

        @CustomType.Setter
        public Builder creationInfos(List<GetAccessPointRootDirectoryCreationInfo> creationInfos) {
            if (creationInfos == null) {
              throw new MissingRequiredPropertyException("GetAccessPointRootDirectory", "creationInfos");
            }
            this.creationInfos = creationInfos;
            return this;
        }
        public Builder creationInfos(GetAccessPointRootDirectoryCreationInfo... creationInfos) {
            return creationInfos(List.of(creationInfos));
        }
        @CustomType.Setter
        public Builder path(String path) {
            if (path == null) {
              throw new MissingRequiredPropertyException("GetAccessPointRootDirectory", "path");
            }
            this.path = path;
            return this;
        }
        public GetAccessPointRootDirectory build() {
            final var _resultValue = new GetAccessPointRootDirectory();
            _resultValue.creationInfos = creationInfos;
            _resultValue.path = path;
            return _resultValue;
        }
    }
}
