// *** WARNING: this file was generated by pulumi-java-gen. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

package com.pulumi.aws.lex.outputs;

import com.pulumi.aws.lex.outputs.V2modelsSlotSubSlotSettingSlotSpecificationValueElicitationSettingPromptSpecificationMessageGroupVariationImageResponseCardButton;
import com.pulumi.core.annotations.CustomType;
import com.pulumi.exceptions.MissingRequiredPropertyException;
import java.lang.String;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import javax.annotation.Nullable;

@CustomType
public final class V2modelsSlotSubSlotSettingSlotSpecificationValueElicitationSettingPromptSpecificationMessageGroupVariationImageResponseCard {
    private @Nullable List<V2modelsSlotSubSlotSettingSlotSpecificationValueElicitationSettingPromptSpecificationMessageGroupVariationImageResponseCardButton> buttons;
    private @Nullable String imageUrl;
    private @Nullable String subtitle;
    private String title;

    private V2modelsSlotSubSlotSettingSlotSpecificationValueElicitationSettingPromptSpecificationMessageGroupVariationImageResponseCard() {}
    public List<V2modelsSlotSubSlotSettingSlotSpecificationValueElicitationSettingPromptSpecificationMessageGroupVariationImageResponseCardButton> buttons() {
        return this.buttons == null ? List.of() : this.buttons;
    }
    public Optional<String> imageUrl() {
        return Optional.ofNullable(this.imageUrl);
    }
    public Optional<String> subtitle() {
        return Optional.ofNullable(this.subtitle);
    }
    public String title() {
        return this.title;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static Builder builder(V2modelsSlotSubSlotSettingSlotSpecificationValueElicitationSettingPromptSpecificationMessageGroupVariationImageResponseCard defaults) {
        return new Builder(defaults);
    }
    @CustomType.Builder
    public static final class Builder {
        private @Nullable List<V2modelsSlotSubSlotSettingSlotSpecificationValueElicitationSettingPromptSpecificationMessageGroupVariationImageResponseCardButton> buttons;
        private @Nullable String imageUrl;
        private @Nullable String subtitle;
        private String title;
        public Builder() {}
        public Builder(V2modelsSlotSubSlotSettingSlotSpecificationValueElicitationSettingPromptSpecificationMessageGroupVariationImageResponseCard defaults) {
    	      Objects.requireNonNull(defaults);
    	      this.buttons = defaults.buttons;
    	      this.imageUrl = defaults.imageUrl;
    	      this.subtitle = defaults.subtitle;
    	      this.title = defaults.title;
        }

        @CustomType.Setter
        public Builder buttons(@Nullable List<V2modelsSlotSubSlotSettingSlotSpecificationValueElicitationSettingPromptSpecificationMessageGroupVariationImageResponseCardButton> buttons) {

            this.buttons = buttons;
            return this;
        }
        public Builder buttons(V2modelsSlotSubSlotSettingSlotSpecificationValueElicitationSettingPromptSpecificationMessageGroupVariationImageResponseCardButton... buttons) {
            return buttons(List.of(buttons));
        }
        @CustomType.Setter
        public Builder imageUrl(@Nullable String imageUrl) {

            this.imageUrl = imageUrl;
            return this;
        }
        @CustomType.Setter
        public Builder subtitle(@Nullable String subtitle) {

            this.subtitle = subtitle;
            return this;
        }
        @CustomType.Setter
        public Builder title(String title) {
            if (title == null) {
              throw new MissingRequiredPropertyException("V2modelsSlotSubSlotSettingSlotSpecificationValueElicitationSettingPromptSpecificationMessageGroupVariationImageResponseCard", "title");
            }
            this.title = title;
            return this;
        }
        public V2modelsSlotSubSlotSettingSlotSpecificationValueElicitationSettingPromptSpecificationMessageGroupVariationImageResponseCard build() {
            final var _resultValue = new V2modelsSlotSubSlotSettingSlotSpecificationValueElicitationSettingPromptSpecificationMessageGroupVariationImageResponseCard();
            _resultValue.buttons = buttons;
            _resultValue.imageUrl = imageUrl;
            _resultValue.subtitle = subtitle;
            _resultValue.title = title;
            return _resultValue;
        }
    }
}
