// *** WARNING: this file was generated by pulumi-language-dotnet. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

using System;
using System.Collections.Generic;
using System.Collections.Immutable;
using System.Threading.Tasks;
using Pulumi.Serialization;

namespace Pulumi.Aws.MediaLive.Inputs
{

    public sealed class ChannelEncoderSettingsOutputGroupOutputGroupSettingsHlsGroupSettingsKeyProviderSettingsGetArgs : global::Pulumi.ResourceArgs
    {
        [Input("staticKeySettings")]
        private InputList<Inputs.ChannelEncoderSettingsOutputGroupOutputGroupSettingsHlsGroupSettingsKeyProviderSettingsStaticKeySettingGetArgs>? _staticKeySettings;
        public InputList<Inputs.ChannelEncoderSettingsOutputGroupOutputGroupSettingsHlsGroupSettingsKeyProviderSettingsStaticKeySettingGetArgs> StaticKeySettings
        {
            get => _staticKeySettings ?? (_staticKeySettings = new InputList<Inputs.ChannelEncoderSettingsOutputGroupOutputGroupSettingsHlsGroupSettingsKeyProviderSettingsStaticKeySettingGetArgs>());
            set => _staticKeySettings = value;
        }

        public ChannelEncoderSettingsOutputGroupOutputGroupSettingsHlsGroupSettingsKeyProviderSettingsGetArgs()
        {
        }
        public static new ChannelEncoderSettingsOutputGroupOutputGroupSettingsHlsGroupSettingsKeyProviderSettingsGetArgs Empty => new ChannelEncoderSettingsOutputGroupOutputGroupSettingsHlsGroupSettingsKeyProviderSettingsGetArgs();
    }
}
