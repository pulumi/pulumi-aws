// *** WARNING: this file was generated by pulumi-java-gen. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

package com.pulumi.aws.medialive.inputs;

import com.pulumi.aws.medialive.inputs.ChannelEncoderSettingsCaptionDescriptionDestinationSettingsDvbSubDestinationSettingsFontArgs;
import com.pulumi.core.Output;
import com.pulumi.core.annotations.Import;
import java.lang.Integer;
import java.lang.String;
import java.util.Objects;
import java.util.Optional;
import javax.annotation.Nullable;


public final class ChannelEncoderSettingsCaptionDescriptionDestinationSettingsDvbSubDestinationSettingsArgs extends com.pulumi.resources.ResourceArgs {

    public static final ChannelEncoderSettingsCaptionDescriptionDestinationSettingsDvbSubDestinationSettingsArgs Empty = new ChannelEncoderSettingsCaptionDescriptionDestinationSettingsDvbSubDestinationSettingsArgs();

    /**
     * If no explicit xPosition or yPosition is provided, setting alignment to centered will place the captions at the bottom center of the output. Similarly, setting a left alignment will align captions to the bottom left of the output. If x and y positions are given in conjunction with the alignment parameter, the font will be justified (either left or centered) relative to those coordinates. Selecting “smart” justification will left-justify live subtitles and center-justify pre-recorded subtitles. This option is not valid for source captions that are STL or 608/embedded. These source settings are already pre-defined by the caption stream. All burn-in and DVB-Sub font settings must match.
     * 
     */
    @Import(name="alignment")
    private @Nullable Output<String> alignment;

    /**
     * @return If no explicit xPosition or yPosition is provided, setting alignment to centered will place the captions at the bottom center of the output. Similarly, setting a left alignment will align captions to the bottom left of the output. If x and y positions are given in conjunction with the alignment parameter, the font will be justified (either left or centered) relative to those coordinates. Selecting “smart” justification will left-justify live subtitles and center-justify pre-recorded subtitles. This option is not valid for source captions that are STL or 608/embedded. These source settings are already pre-defined by the caption stream. All burn-in and DVB-Sub font settings must match.
     * 
     */
    public Optional<Output<String>> alignment() {
        return Optional.ofNullable(this.alignment);
    }

    /**
     * Specifies the color of the rectangle behind the captions. All burn-in and DVB-Sub font settings must match.
     * 
     */
    @Import(name="backgroundColor")
    private @Nullable Output<String> backgroundColor;

    /**
     * @return Specifies the color of the rectangle behind the captions. All burn-in and DVB-Sub font settings must match.
     * 
     */
    public Optional<Output<String>> backgroundColor() {
        return Optional.ofNullable(this.backgroundColor);
    }

    /**
     * Specifies the opacity of the background rectangle. 255 is opaque; 0 is transparent. Leaving this parameter blank is equivalent to setting it to 0 (transparent). All burn-in and DVB-Sub font settings must match.
     * 
     */
    @Import(name="backgroundOpacity")
    private @Nullable Output<Integer> backgroundOpacity;

    /**
     * @return Specifies the opacity of the background rectangle. 255 is opaque; 0 is transparent. Leaving this parameter blank is equivalent to setting it to 0 (transparent). All burn-in and DVB-Sub font settings must match.
     * 
     */
    public Optional<Output<Integer>> backgroundOpacity() {
        return Optional.ofNullable(this.backgroundOpacity);
    }

    /**
     * External font file used for caption burn-in. File extension must be ‘ttf’ or ‘tte’. Although the user can select output fonts for many different types of input captions, embedded, STL and teletext sources use a strict grid system. Using external fonts with these caption sources could cause unexpected display of proportional fonts. All burn-in and DVB-Sub font settings must match. See Font for more details.
     * 
     */
    @Import(name="font")
    private @Nullable Output<ChannelEncoderSettingsCaptionDescriptionDestinationSettingsDvbSubDestinationSettingsFontArgs> font;

    /**
     * @return External font file used for caption burn-in. File extension must be ‘ttf’ or ‘tte’. Although the user can select output fonts for many different types of input captions, embedded, STL and teletext sources use a strict grid system. Using external fonts with these caption sources could cause unexpected display of proportional fonts. All burn-in and DVB-Sub font settings must match. See Font for more details.
     * 
     */
    public Optional<Output<ChannelEncoderSettingsCaptionDescriptionDestinationSettingsDvbSubDestinationSettingsFontArgs>> font() {
        return Optional.ofNullable(this.font);
    }

    /**
     * Specifies the color of the burned-in captions. This option is not valid for source captions that are STL, 608/embedded or teletext. These source settings are already pre-defined by the caption stream. All burn-in and DVB-Sub font settings must match.
     * 
     */
    @Import(name="fontColor")
    private @Nullable Output<String> fontColor;

    /**
     * @return Specifies the color of the burned-in captions. This option is not valid for source captions that are STL, 608/embedded or teletext. These source settings are already pre-defined by the caption stream. All burn-in and DVB-Sub font settings must match.
     * 
     */
    public Optional<Output<String>> fontColor() {
        return Optional.ofNullable(this.fontColor);
    }

    /**
     * Specifies the opacity of the burned-in captions. 255 is opaque; 0 is transparent. All burn-in and DVB-Sub font settings must match.
     * 
     */
    @Import(name="fontOpacity")
    private @Nullable Output<Integer> fontOpacity;

    /**
     * @return Specifies the opacity of the burned-in captions. 255 is opaque; 0 is transparent. All burn-in and DVB-Sub font settings must match.
     * 
     */
    public Optional<Output<Integer>> fontOpacity() {
        return Optional.ofNullable(this.fontOpacity);
    }

    /**
     * Font resolution in DPI (dots per inch); default is 96 dpi. All burn-in and DVB-Sub font settings must match.
     * 
     */
    @Import(name="fontResolution")
    private @Nullable Output<Integer> fontResolution;

    /**
     * @return Font resolution in DPI (dots per inch); default is 96 dpi. All burn-in and DVB-Sub font settings must match.
     * 
     */
    public Optional<Output<Integer>> fontResolution() {
        return Optional.ofNullable(this.fontResolution);
    }

    /**
     * When set to auto fontSize will scale depending on the size of the output. Giving a positive integer will specify the exact font size in points. All burn-in and DVB-Sub font settings must match.
     * 
     */
    @Import(name="fontSize")
    private @Nullable Output<String> fontSize;

    /**
     * @return When set to auto fontSize will scale depending on the size of the output. Giving a positive integer will specify the exact font size in points. All burn-in and DVB-Sub font settings must match.
     * 
     */
    public Optional<Output<String>> fontSize() {
        return Optional.ofNullable(this.fontSize);
    }

    /**
     * Specifies font outline color. This option is not valid for source captions that are either 608/embedded or teletext. These source settings are already pre-defined by the caption stream. All burn-in and DVB-Sub font settings must match.
     * 
     */
    @Import(name="outlineColor")
    private @Nullable Output<String> outlineColor;

    /**
     * @return Specifies font outline color. This option is not valid for source captions that are either 608/embedded or teletext. These source settings are already pre-defined by the caption stream. All burn-in and DVB-Sub font settings must match.
     * 
     */
    public Optional<Output<String>> outlineColor() {
        return Optional.ofNullable(this.outlineColor);
    }

    /**
     * Specifies font outline size in pixels. This option is not valid for source captions that are either 608/embedded or teletext. These source settings are already pre-defined by the caption stream. All burn-in and DVB-Sub font settings must match.
     * 
     */
    @Import(name="outlineSize")
    private @Nullable Output<Integer> outlineSize;

    /**
     * @return Specifies font outline size in pixels. This option is not valid for source captions that are either 608/embedded or teletext. These source settings are already pre-defined by the caption stream. All burn-in and DVB-Sub font settings must match.
     * 
     */
    public Optional<Output<Integer>> outlineSize() {
        return Optional.ofNullable(this.outlineSize);
    }

    /**
     * Specifies the color of the shadow cast by the captions. All burn-in and DVB-Sub font settings must match.
     * 
     */
    @Import(name="shadowColor")
    private @Nullable Output<String> shadowColor;

    /**
     * @return Specifies the color of the shadow cast by the captions. All burn-in and DVB-Sub font settings must match.
     * 
     */
    public Optional<Output<String>> shadowColor() {
        return Optional.ofNullable(this.shadowColor);
    }

    /**
     * Specifies the opacity of the shadow. 255 is opaque; 0 is transparent. Leaving this parameter blank is equivalent to setting it to 0 (transparent). All burn-in and DVB-Sub font settings must match.
     * 
     */
    @Import(name="shadowOpacity")
    private @Nullable Output<Integer> shadowOpacity;

    /**
     * @return Specifies the opacity of the shadow. 255 is opaque; 0 is transparent. Leaving this parameter blank is equivalent to setting it to 0 (transparent). All burn-in and DVB-Sub font settings must match.
     * 
     */
    public Optional<Output<Integer>> shadowOpacity() {
        return Optional.ofNullable(this.shadowOpacity);
    }

    /**
     * Specifies the horizontal offset of the shadow relative to the captions in pixels. A value of -2 would result in a shadow offset 2 pixels to the left. All burn-in and DVB-Sub font settings must match.
     * 
     */
    @Import(name="shadowXOffset")
    private @Nullable Output<Integer> shadowXOffset;

    /**
     * @return Specifies the horizontal offset of the shadow relative to the captions in pixels. A value of -2 would result in a shadow offset 2 pixels to the left. All burn-in and DVB-Sub font settings must match.
     * 
     */
    public Optional<Output<Integer>> shadowXOffset() {
        return Optional.ofNullable(this.shadowXOffset);
    }

    /**
     * Specifies the vertical offset of the shadow relative to the captions in pixels. A value of -2 would result in a shadow offset 2 pixels above the text. All burn-in and DVB-Sub font settings must match.
     * 
     */
    @Import(name="shadowYOffset")
    private @Nullable Output<Integer> shadowYOffset;

    /**
     * @return Specifies the vertical offset of the shadow relative to the captions in pixels. A value of -2 would result in a shadow offset 2 pixels above the text. All burn-in and DVB-Sub font settings must match.
     * 
     */
    public Optional<Output<Integer>> shadowYOffset() {
        return Optional.ofNullable(this.shadowYOffset);
    }

    /**
     * Controls whether a fixed grid size will be used to generate the output subtitles bitmap. Only applicable for Teletext inputs and DVB-Sub/Burn-in outputs.
     * 
     */
    @Import(name="teletextGridControl")
    private @Nullable Output<String> teletextGridControl;

    /**
     * @return Controls whether a fixed grid size will be used to generate the output subtitles bitmap. Only applicable for Teletext inputs and DVB-Sub/Burn-in outputs.
     * 
     */
    public Optional<Output<String>> teletextGridControl() {
        return Optional.ofNullable(this.teletextGridControl);
    }

    /**
     * Specifies the horizontal position of the caption relative to the left side of the output in pixels. A value of 10 would result in the captions starting 10 pixels from the left of the output. If no explicit xPosition is provided, the horizontal caption position will be determined by the alignment parameter. This option is not valid for source captions that are STL, 608/embedded or teletext. These source settings are already pre-defined by the caption stream. All burn-in and DVB-Sub font settings must match.
     * 
     */
    @Import(name="xPosition")
    private @Nullable Output<Integer> xPosition;

    /**
     * @return Specifies the horizontal position of the caption relative to the left side of the output in pixels. A value of 10 would result in the captions starting 10 pixels from the left of the output. If no explicit xPosition is provided, the horizontal caption position will be determined by the alignment parameter. This option is not valid for source captions that are STL, 608/embedded or teletext. These source settings are already pre-defined by the caption stream. All burn-in and DVB-Sub font settings must match.
     * 
     */
    public Optional<Output<Integer>> xPosition() {
        return Optional.ofNullable(this.xPosition);
    }

    /**
     * Specifies the vertical position of the caption relative to the top of the output in pixels. A value of 10 would result in the captions starting 10 pixels from the top of the output. If no explicit yPosition is provided, the caption will be positioned towards the bottom of the output. This option is not valid for source captions that are STL, 608/embedded or teletext. These source settings are already pre-defined by the caption stream. All burn-in and DVB-Sub font settings must match.
     * 
     */
    @Import(name="yPosition")
    private @Nullable Output<Integer> yPosition;

    /**
     * @return Specifies the vertical position of the caption relative to the top of the output in pixels. A value of 10 would result in the captions starting 10 pixels from the top of the output. If no explicit yPosition is provided, the caption will be positioned towards the bottom of the output. This option is not valid for source captions that are STL, 608/embedded or teletext. These source settings are already pre-defined by the caption stream. All burn-in and DVB-Sub font settings must match.
     * 
     */
    public Optional<Output<Integer>> yPosition() {
        return Optional.ofNullable(this.yPosition);
    }

    private ChannelEncoderSettingsCaptionDescriptionDestinationSettingsDvbSubDestinationSettingsArgs() {}

    private ChannelEncoderSettingsCaptionDescriptionDestinationSettingsDvbSubDestinationSettingsArgs(ChannelEncoderSettingsCaptionDescriptionDestinationSettingsDvbSubDestinationSettingsArgs $) {
        this.alignment = $.alignment;
        this.backgroundColor = $.backgroundColor;
        this.backgroundOpacity = $.backgroundOpacity;
        this.font = $.font;
        this.fontColor = $.fontColor;
        this.fontOpacity = $.fontOpacity;
        this.fontResolution = $.fontResolution;
        this.fontSize = $.fontSize;
        this.outlineColor = $.outlineColor;
        this.outlineSize = $.outlineSize;
        this.shadowColor = $.shadowColor;
        this.shadowOpacity = $.shadowOpacity;
        this.shadowXOffset = $.shadowXOffset;
        this.shadowYOffset = $.shadowYOffset;
        this.teletextGridControl = $.teletextGridControl;
        this.xPosition = $.xPosition;
        this.yPosition = $.yPosition;
    }

    public static Builder builder() {
        return new Builder();
    }
    public static Builder builder(ChannelEncoderSettingsCaptionDescriptionDestinationSettingsDvbSubDestinationSettingsArgs defaults) {
        return new Builder(defaults);
    }

    public static final class Builder {
        private ChannelEncoderSettingsCaptionDescriptionDestinationSettingsDvbSubDestinationSettingsArgs $;

        public Builder() {
            $ = new ChannelEncoderSettingsCaptionDescriptionDestinationSettingsDvbSubDestinationSettingsArgs();
        }

        public Builder(ChannelEncoderSettingsCaptionDescriptionDestinationSettingsDvbSubDestinationSettingsArgs defaults) {
            $ = new ChannelEncoderSettingsCaptionDescriptionDestinationSettingsDvbSubDestinationSettingsArgs(Objects.requireNonNull(defaults));
        }

        /**
         * @param alignment If no explicit xPosition or yPosition is provided, setting alignment to centered will place the captions at the bottom center of the output. Similarly, setting a left alignment will align captions to the bottom left of the output. If x and y positions are given in conjunction with the alignment parameter, the font will be justified (either left or centered) relative to those coordinates. Selecting “smart” justification will left-justify live subtitles and center-justify pre-recorded subtitles. This option is not valid for source captions that are STL or 608/embedded. These source settings are already pre-defined by the caption stream. All burn-in and DVB-Sub font settings must match.
         * 
         * @return builder
         * 
         */
        public Builder alignment(@Nullable Output<String> alignment) {
            $.alignment = alignment;
            return this;
        }

        /**
         * @param alignment If no explicit xPosition or yPosition is provided, setting alignment to centered will place the captions at the bottom center of the output. Similarly, setting a left alignment will align captions to the bottom left of the output. If x and y positions are given in conjunction with the alignment parameter, the font will be justified (either left or centered) relative to those coordinates. Selecting “smart” justification will left-justify live subtitles and center-justify pre-recorded subtitles. This option is not valid for source captions that are STL or 608/embedded. These source settings are already pre-defined by the caption stream. All burn-in and DVB-Sub font settings must match.
         * 
         * @return builder
         * 
         */
        public Builder alignment(String alignment) {
            return alignment(Output.of(alignment));
        }

        /**
         * @param backgroundColor Specifies the color of the rectangle behind the captions. All burn-in and DVB-Sub font settings must match.
         * 
         * @return builder
         * 
         */
        public Builder backgroundColor(@Nullable Output<String> backgroundColor) {
            $.backgroundColor = backgroundColor;
            return this;
        }

        /**
         * @param backgroundColor Specifies the color of the rectangle behind the captions. All burn-in and DVB-Sub font settings must match.
         * 
         * @return builder
         * 
         */
        public Builder backgroundColor(String backgroundColor) {
            return backgroundColor(Output.of(backgroundColor));
        }

        /**
         * @param backgroundOpacity Specifies the opacity of the background rectangle. 255 is opaque; 0 is transparent. Leaving this parameter blank is equivalent to setting it to 0 (transparent). All burn-in and DVB-Sub font settings must match.
         * 
         * @return builder
         * 
         */
        public Builder backgroundOpacity(@Nullable Output<Integer> backgroundOpacity) {
            $.backgroundOpacity = backgroundOpacity;
            return this;
        }

        /**
         * @param backgroundOpacity Specifies the opacity of the background rectangle. 255 is opaque; 0 is transparent. Leaving this parameter blank is equivalent to setting it to 0 (transparent). All burn-in and DVB-Sub font settings must match.
         * 
         * @return builder
         * 
         */
        public Builder backgroundOpacity(Integer backgroundOpacity) {
            return backgroundOpacity(Output.of(backgroundOpacity));
        }

        /**
         * @param font External font file used for caption burn-in. File extension must be ‘ttf’ or ‘tte’. Although the user can select output fonts for many different types of input captions, embedded, STL and teletext sources use a strict grid system. Using external fonts with these caption sources could cause unexpected display of proportional fonts. All burn-in and DVB-Sub font settings must match. See Font for more details.
         * 
         * @return builder
         * 
         */
        public Builder font(@Nullable Output<ChannelEncoderSettingsCaptionDescriptionDestinationSettingsDvbSubDestinationSettingsFontArgs> font) {
            $.font = font;
            return this;
        }

        /**
         * @param font External font file used for caption burn-in. File extension must be ‘ttf’ or ‘tte’. Although the user can select output fonts for many different types of input captions, embedded, STL and teletext sources use a strict grid system. Using external fonts with these caption sources could cause unexpected display of proportional fonts. All burn-in and DVB-Sub font settings must match. See Font for more details.
         * 
         * @return builder
         * 
         */
        public Builder font(ChannelEncoderSettingsCaptionDescriptionDestinationSettingsDvbSubDestinationSettingsFontArgs font) {
            return font(Output.of(font));
        }

        /**
         * @param fontColor Specifies the color of the burned-in captions. This option is not valid for source captions that are STL, 608/embedded or teletext. These source settings are already pre-defined by the caption stream. All burn-in and DVB-Sub font settings must match.
         * 
         * @return builder
         * 
         */
        public Builder fontColor(@Nullable Output<String> fontColor) {
            $.fontColor = fontColor;
            return this;
        }

        /**
         * @param fontColor Specifies the color of the burned-in captions. This option is not valid for source captions that are STL, 608/embedded or teletext. These source settings are already pre-defined by the caption stream. All burn-in and DVB-Sub font settings must match.
         * 
         * @return builder
         * 
         */
        public Builder fontColor(String fontColor) {
            return fontColor(Output.of(fontColor));
        }

        /**
         * @param fontOpacity Specifies the opacity of the burned-in captions. 255 is opaque; 0 is transparent. All burn-in and DVB-Sub font settings must match.
         * 
         * @return builder
         * 
         */
        public Builder fontOpacity(@Nullable Output<Integer> fontOpacity) {
            $.fontOpacity = fontOpacity;
            return this;
        }

        /**
         * @param fontOpacity Specifies the opacity of the burned-in captions. 255 is opaque; 0 is transparent. All burn-in and DVB-Sub font settings must match.
         * 
         * @return builder
         * 
         */
        public Builder fontOpacity(Integer fontOpacity) {
            return fontOpacity(Output.of(fontOpacity));
        }

        /**
         * @param fontResolution Font resolution in DPI (dots per inch); default is 96 dpi. All burn-in and DVB-Sub font settings must match.
         * 
         * @return builder
         * 
         */
        public Builder fontResolution(@Nullable Output<Integer> fontResolution) {
            $.fontResolution = fontResolution;
            return this;
        }

        /**
         * @param fontResolution Font resolution in DPI (dots per inch); default is 96 dpi. All burn-in and DVB-Sub font settings must match.
         * 
         * @return builder
         * 
         */
        public Builder fontResolution(Integer fontResolution) {
            return fontResolution(Output.of(fontResolution));
        }

        /**
         * @param fontSize When set to auto fontSize will scale depending on the size of the output. Giving a positive integer will specify the exact font size in points. All burn-in and DVB-Sub font settings must match.
         * 
         * @return builder
         * 
         */
        public Builder fontSize(@Nullable Output<String> fontSize) {
            $.fontSize = fontSize;
            return this;
        }

        /**
         * @param fontSize When set to auto fontSize will scale depending on the size of the output. Giving a positive integer will specify the exact font size in points. All burn-in and DVB-Sub font settings must match.
         * 
         * @return builder
         * 
         */
        public Builder fontSize(String fontSize) {
            return fontSize(Output.of(fontSize));
        }

        /**
         * @param outlineColor Specifies font outline color. This option is not valid for source captions that are either 608/embedded or teletext. These source settings are already pre-defined by the caption stream. All burn-in and DVB-Sub font settings must match.
         * 
         * @return builder
         * 
         */
        public Builder outlineColor(@Nullable Output<String> outlineColor) {
            $.outlineColor = outlineColor;
            return this;
        }

        /**
         * @param outlineColor Specifies font outline color. This option is not valid for source captions that are either 608/embedded or teletext. These source settings are already pre-defined by the caption stream. All burn-in and DVB-Sub font settings must match.
         * 
         * @return builder
         * 
         */
        public Builder outlineColor(String outlineColor) {
            return outlineColor(Output.of(outlineColor));
        }

        /**
         * @param outlineSize Specifies font outline size in pixels. This option is not valid for source captions that are either 608/embedded or teletext. These source settings are already pre-defined by the caption stream. All burn-in and DVB-Sub font settings must match.
         * 
         * @return builder
         * 
         */
        public Builder outlineSize(@Nullable Output<Integer> outlineSize) {
            $.outlineSize = outlineSize;
            return this;
        }

        /**
         * @param outlineSize Specifies font outline size in pixels. This option is not valid for source captions that are either 608/embedded or teletext. These source settings are already pre-defined by the caption stream. All burn-in and DVB-Sub font settings must match.
         * 
         * @return builder
         * 
         */
        public Builder outlineSize(Integer outlineSize) {
            return outlineSize(Output.of(outlineSize));
        }

        /**
         * @param shadowColor Specifies the color of the shadow cast by the captions. All burn-in and DVB-Sub font settings must match.
         * 
         * @return builder
         * 
         */
        public Builder shadowColor(@Nullable Output<String> shadowColor) {
            $.shadowColor = shadowColor;
            return this;
        }

        /**
         * @param shadowColor Specifies the color of the shadow cast by the captions. All burn-in and DVB-Sub font settings must match.
         * 
         * @return builder
         * 
         */
        public Builder shadowColor(String shadowColor) {
            return shadowColor(Output.of(shadowColor));
        }

        /**
         * @param shadowOpacity Specifies the opacity of the shadow. 255 is opaque; 0 is transparent. Leaving this parameter blank is equivalent to setting it to 0 (transparent). All burn-in and DVB-Sub font settings must match.
         * 
         * @return builder
         * 
         */
        public Builder shadowOpacity(@Nullable Output<Integer> shadowOpacity) {
            $.shadowOpacity = shadowOpacity;
            return this;
        }

        /**
         * @param shadowOpacity Specifies the opacity of the shadow. 255 is opaque; 0 is transparent. Leaving this parameter blank is equivalent to setting it to 0 (transparent). All burn-in and DVB-Sub font settings must match.
         * 
         * @return builder
         * 
         */
        public Builder shadowOpacity(Integer shadowOpacity) {
            return shadowOpacity(Output.of(shadowOpacity));
        }

        /**
         * @param shadowXOffset Specifies the horizontal offset of the shadow relative to the captions in pixels. A value of -2 would result in a shadow offset 2 pixels to the left. All burn-in and DVB-Sub font settings must match.
         * 
         * @return builder
         * 
         */
        public Builder shadowXOffset(@Nullable Output<Integer> shadowXOffset) {
            $.shadowXOffset = shadowXOffset;
            return this;
        }

        /**
         * @param shadowXOffset Specifies the horizontal offset of the shadow relative to the captions in pixels. A value of -2 would result in a shadow offset 2 pixels to the left. All burn-in and DVB-Sub font settings must match.
         * 
         * @return builder
         * 
         */
        public Builder shadowXOffset(Integer shadowXOffset) {
            return shadowXOffset(Output.of(shadowXOffset));
        }

        /**
         * @param shadowYOffset Specifies the vertical offset of the shadow relative to the captions in pixels. A value of -2 would result in a shadow offset 2 pixels above the text. All burn-in and DVB-Sub font settings must match.
         * 
         * @return builder
         * 
         */
        public Builder shadowYOffset(@Nullable Output<Integer> shadowYOffset) {
            $.shadowYOffset = shadowYOffset;
            return this;
        }

        /**
         * @param shadowYOffset Specifies the vertical offset of the shadow relative to the captions in pixels. A value of -2 would result in a shadow offset 2 pixels above the text. All burn-in and DVB-Sub font settings must match.
         * 
         * @return builder
         * 
         */
        public Builder shadowYOffset(Integer shadowYOffset) {
            return shadowYOffset(Output.of(shadowYOffset));
        }

        /**
         * @param teletextGridControl Controls whether a fixed grid size will be used to generate the output subtitles bitmap. Only applicable for Teletext inputs and DVB-Sub/Burn-in outputs.
         * 
         * @return builder
         * 
         */
        public Builder teletextGridControl(@Nullable Output<String> teletextGridControl) {
            $.teletextGridControl = teletextGridControl;
            return this;
        }

        /**
         * @param teletextGridControl Controls whether a fixed grid size will be used to generate the output subtitles bitmap. Only applicable for Teletext inputs and DVB-Sub/Burn-in outputs.
         * 
         * @return builder
         * 
         */
        public Builder teletextGridControl(String teletextGridControl) {
            return teletextGridControl(Output.of(teletextGridControl));
        }

        /**
         * @param xPosition Specifies the horizontal position of the caption relative to the left side of the output in pixels. A value of 10 would result in the captions starting 10 pixels from the left of the output. If no explicit xPosition is provided, the horizontal caption position will be determined by the alignment parameter. This option is not valid for source captions that are STL, 608/embedded or teletext. These source settings are already pre-defined by the caption stream. All burn-in and DVB-Sub font settings must match.
         * 
         * @return builder
         * 
         */
        public Builder xPosition(@Nullable Output<Integer> xPosition) {
            $.xPosition = xPosition;
            return this;
        }

        /**
         * @param xPosition Specifies the horizontal position of the caption relative to the left side of the output in pixels. A value of 10 would result in the captions starting 10 pixels from the left of the output. If no explicit xPosition is provided, the horizontal caption position will be determined by the alignment parameter. This option is not valid for source captions that are STL, 608/embedded or teletext. These source settings are already pre-defined by the caption stream. All burn-in and DVB-Sub font settings must match.
         * 
         * @return builder
         * 
         */
        public Builder xPosition(Integer xPosition) {
            return xPosition(Output.of(xPosition));
        }

        /**
         * @param yPosition Specifies the vertical position of the caption relative to the top of the output in pixels. A value of 10 would result in the captions starting 10 pixels from the top of the output. If no explicit yPosition is provided, the caption will be positioned towards the bottom of the output. This option is not valid for source captions that are STL, 608/embedded or teletext. These source settings are already pre-defined by the caption stream. All burn-in and DVB-Sub font settings must match.
         * 
         * @return builder
         * 
         */
        public Builder yPosition(@Nullable Output<Integer> yPosition) {
            $.yPosition = yPosition;
            return this;
        }

        /**
         * @param yPosition Specifies the vertical position of the caption relative to the top of the output in pixels. A value of 10 would result in the captions starting 10 pixels from the top of the output. If no explicit yPosition is provided, the caption will be positioned towards the bottom of the output. This option is not valid for source captions that are STL, 608/embedded or teletext. These source settings are already pre-defined by the caption stream. All burn-in and DVB-Sub font settings must match.
         * 
         * @return builder
         * 
         */
        public Builder yPosition(Integer yPosition) {
            return yPosition(Output.of(yPosition));
        }

        public ChannelEncoderSettingsCaptionDescriptionDestinationSettingsDvbSubDestinationSettingsArgs build() {
            return $;
        }
    }

}
