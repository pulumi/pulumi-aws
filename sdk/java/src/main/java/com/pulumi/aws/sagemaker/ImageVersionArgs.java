// *** WARNING: this file was generated by pulumi-java-gen. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

package com.pulumi.aws.sagemaker;

import com.pulumi.core.Output;
import com.pulumi.core.annotations.Import;
import com.pulumi.exceptions.MissingRequiredPropertyException;
import java.lang.Boolean;
import java.lang.String;
import java.util.Objects;
import java.util.Optional;
import javax.annotation.Nullable;


public final class ImageVersionArgs extends com.pulumi.resources.ResourceArgs {

    public static final ImageVersionArgs Empty = new ImageVersionArgs();

    /**
     * The registry path of the container image on which this image version is based.
     * 
     */
    @Import(name="baseImage", required=true)
    private Output<String> baseImage;

    /**
     * @return The registry path of the container image on which this image version is based.
     * 
     */
    public Output<String> baseImage() {
        return this.baseImage;
    }

    /**
     * Indicates Horovod compatibility.
     * 
     */
    @Import(name="horovod")
    private @Nullable Output<Boolean> horovod;

    /**
     * @return Indicates Horovod compatibility.
     * 
     */
    public Optional<Output<Boolean>> horovod() {
        return Optional.ofNullable(this.horovod);
    }

    /**
     * The name of the image. Must be unique to your account.
     * 
     */
    @Import(name="imageName", required=true)
    private Output<String> imageName;

    /**
     * @return The name of the image. Must be unique to your account.
     * 
     */
    public Output<String> imageName() {
        return this.imageName;
    }

    /**
     * Indicates SageMaker AI job type compatibility. Valid values are: `TRAINING`, `INFERENCE`, and `NOTEBOOK_KERNEL`.
     * 
     */
    @Import(name="jobType")
    private @Nullable Output<String> jobType;

    /**
     * @return Indicates SageMaker AI job type compatibility. Valid values are: `TRAINING`, `INFERENCE`, and `NOTEBOOK_KERNEL`.
     * 
     */
    public Optional<Output<String>> jobType() {
        return Optional.ofNullable(this.jobType);
    }

    /**
     * The machine learning framework vended in the image version.
     * 
     */
    @Import(name="mlFramework")
    private @Nullable Output<String> mlFramework;

    /**
     * @return The machine learning framework vended in the image version.
     * 
     */
    public Optional<Output<String>> mlFramework() {
        return Optional.ofNullable(this.mlFramework);
    }

    /**
     * Indicates CPU or GPU compatibility. Valid values are: `CPU` and `GPU`.
     * 
     */
    @Import(name="processor")
    private @Nullable Output<String> processor;

    /**
     * @return Indicates CPU or GPU compatibility. Valid values are: `CPU` and `GPU`.
     * 
     */
    public Optional<Output<String>> processor() {
        return Optional.ofNullable(this.processor);
    }

    /**
     * The supported programming language and its version.
     * 
     */
    @Import(name="programmingLang")
    private @Nullable Output<String> programmingLang;

    /**
     * @return The supported programming language and its version.
     * 
     */
    public Optional<Output<String>> programmingLang() {
        return Optional.ofNullable(this.programmingLang);
    }

    /**
     * The maintainer description of the image version.
     * 
     */
    @Import(name="releaseNotes")
    private @Nullable Output<String> releaseNotes;

    /**
     * @return The maintainer description of the image version.
     * 
     */
    public Optional<Output<String>> releaseNotes() {
        return Optional.ofNullable(this.releaseNotes);
    }

    /**
     * The stability of the image version, specified by the maintainer. Valid values are: `NOT_PROVIDED`, `STABLE`, `TO_BE_ARCHIVED`, and `ARCHIVED`.
     * 
     */
    @Import(name="vendorGuidance")
    private @Nullable Output<String> vendorGuidance;

    /**
     * @return The stability of the image version, specified by the maintainer. Valid values are: `NOT_PROVIDED`, `STABLE`, `TO_BE_ARCHIVED`, and `ARCHIVED`.
     * 
     */
    public Optional<Output<String>> vendorGuidance() {
        return Optional.ofNullable(this.vendorGuidance);
    }

    private ImageVersionArgs() {}

    private ImageVersionArgs(ImageVersionArgs $) {
        this.baseImage = $.baseImage;
        this.horovod = $.horovod;
        this.imageName = $.imageName;
        this.jobType = $.jobType;
        this.mlFramework = $.mlFramework;
        this.processor = $.processor;
        this.programmingLang = $.programmingLang;
        this.releaseNotes = $.releaseNotes;
        this.vendorGuidance = $.vendorGuidance;
    }

    public static Builder builder() {
        return new Builder();
    }
    public static Builder builder(ImageVersionArgs defaults) {
        return new Builder(defaults);
    }

    public static final class Builder {
        private ImageVersionArgs $;

        public Builder() {
            $ = new ImageVersionArgs();
        }

        public Builder(ImageVersionArgs defaults) {
            $ = new ImageVersionArgs(Objects.requireNonNull(defaults));
        }

        /**
         * @param baseImage The registry path of the container image on which this image version is based.
         * 
         * @return builder
         * 
         */
        public Builder baseImage(Output<String> baseImage) {
            $.baseImage = baseImage;
            return this;
        }

        /**
         * @param baseImage The registry path of the container image on which this image version is based.
         * 
         * @return builder
         * 
         */
        public Builder baseImage(String baseImage) {
            return baseImage(Output.of(baseImage));
        }

        /**
         * @param horovod Indicates Horovod compatibility.
         * 
         * @return builder
         * 
         */
        public Builder horovod(@Nullable Output<Boolean> horovod) {
            $.horovod = horovod;
            return this;
        }

        /**
         * @param horovod Indicates Horovod compatibility.
         * 
         * @return builder
         * 
         */
        public Builder horovod(Boolean horovod) {
            return horovod(Output.of(horovod));
        }

        /**
         * @param imageName The name of the image. Must be unique to your account.
         * 
         * @return builder
         * 
         */
        public Builder imageName(Output<String> imageName) {
            $.imageName = imageName;
            return this;
        }

        /**
         * @param imageName The name of the image. Must be unique to your account.
         * 
         * @return builder
         * 
         */
        public Builder imageName(String imageName) {
            return imageName(Output.of(imageName));
        }

        /**
         * @param jobType Indicates SageMaker AI job type compatibility. Valid values are: `TRAINING`, `INFERENCE`, and `NOTEBOOK_KERNEL`.
         * 
         * @return builder
         * 
         */
        public Builder jobType(@Nullable Output<String> jobType) {
            $.jobType = jobType;
            return this;
        }

        /**
         * @param jobType Indicates SageMaker AI job type compatibility. Valid values are: `TRAINING`, `INFERENCE`, and `NOTEBOOK_KERNEL`.
         * 
         * @return builder
         * 
         */
        public Builder jobType(String jobType) {
            return jobType(Output.of(jobType));
        }

        /**
         * @param mlFramework The machine learning framework vended in the image version.
         * 
         * @return builder
         * 
         */
        public Builder mlFramework(@Nullable Output<String> mlFramework) {
            $.mlFramework = mlFramework;
            return this;
        }

        /**
         * @param mlFramework The machine learning framework vended in the image version.
         * 
         * @return builder
         * 
         */
        public Builder mlFramework(String mlFramework) {
            return mlFramework(Output.of(mlFramework));
        }

        /**
         * @param processor Indicates CPU or GPU compatibility. Valid values are: `CPU` and `GPU`.
         * 
         * @return builder
         * 
         */
        public Builder processor(@Nullable Output<String> processor) {
            $.processor = processor;
            return this;
        }

        /**
         * @param processor Indicates CPU or GPU compatibility. Valid values are: `CPU` and `GPU`.
         * 
         * @return builder
         * 
         */
        public Builder processor(String processor) {
            return processor(Output.of(processor));
        }

        /**
         * @param programmingLang The supported programming language and its version.
         * 
         * @return builder
         * 
         */
        public Builder programmingLang(@Nullable Output<String> programmingLang) {
            $.programmingLang = programmingLang;
            return this;
        }

        /**
         * @param programmingLang The supported programming language and its version.
         * 
         * @return builder
         * 
         */
        public Builder programmingLang(String programmingLang) {
            return programmingLang(Output.of(programmingLang));
        }

        /**
         * @param releaseNotes The maintainer description of the image version.
         * 
         * @return builder
         * 
         */
        public Builder releaseNotes(@Nullable Output<String> releaseNotes) {
            $.releaseNotes = releaseNotes;
            return this;
        }

        /**
         * @param releaseNotes The maintainer description of the image version.
         * 
         * @return builder
         * 
         */
        public Builder releaseNotes(String releaseNotes) {
            return releaseNotes(Output.of(releaseNotes));
        }

        /**
         * @param vendorGuidance The stability of the image version, specified by the maintainer. Valid values are: `NOT_PROVIDED`, `STABLE`, `TO_BE_ARCHIVED`, and `ARCHIVED`.
         * 
         * @return builder
         * 
         */
        public Builder vendorGuidance(@Nullable Output<String> vendorGuidance) {
            $.vendorGuidance = vendorGuidance;
            return this;
        }

        /**
         * @param vendorGuidance The stability of the image version, specified by the maintainer. Valid values are: `NOT_PROVIDED`, `STABLE`, `TO_BE_ARCHIVED`, and `ARCHIVED`.
         * 
         * @return builder
         * 
         */
        public Builder vendorGuidance(String vendorGuidance) {
            return vendorGuidance(Output.of(vendorGuidance));
        }

        public ImageVersionArgs build() {
            if ($.baseImage == null) {
                throw new MissingRequiredPropertyException("ImageVersionArgs", "baseImage");
            }
            if ($.imageName == null) {
                throw new MissingRequiredPropertyException("ImageVersionArgs", "imageName");
            }
            return $;
        }
    }

}
