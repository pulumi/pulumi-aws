// *** WARNING: this file was generated by pulumi-java-gen. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

package com.pulumi.aws.dataexchange.outputs;

import com.pulumi.core.annotations.CustomType;
import com.pulumi.exceptions.MissingRequiredPropertyException;
import java.lang.String;
import java.util.Objects;

@CustomType
public final class RevisionAssetsAssetImportAssetsFromSignedUrl {
    /**
     * @return The name of the file to import.
     * 
     */
    private String filename;

    private RevisionAssetsAssetImportAssetsFromSignedUrl() {}
    /**
     * @return The name of the file to import.
     * 
     */
    public String filename() {
        return this.filename;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static Builder builder(RevisionAssetsAssetImportAssetsFromSignedUrl defaults) {
        return new Builder(defaults);
    }
    @CustomType.Builder
    public static final class Builder {
        private String filename;
        public Builder() {}
        public Builder(RevisionAssetsAssetImportAssetsFromSignedUrl defaults) {
    	      Objects.requireNonNull(defaults);
    	      this.filename = defaults.filename;
        }

        @CustomType.Setter
        public Builder filename(String filename) {
            if (filename == null) {
              throw new MissingRequiredPropertyException("RevisionAssetsAssetImportAssetsFromSignedUrl", "filename");
            }
            this.filename = filename;
            return this;
        }
        public RevisionAssetsAssetImportAssetsFromSignedUrl build() {
            final var _resultValue = new RevisionAssetsAssetImportAssetsFromSignedUrl();
            _resultValue.filename = filename;
            return _resultValue;
        }
    }
}
