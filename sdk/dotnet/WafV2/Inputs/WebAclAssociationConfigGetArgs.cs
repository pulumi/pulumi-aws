// *** WARNING: this file was generated by pulumi-language-dotnet. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

using System;
using System.Collections.Generic;
using System.Collections.Immutable;
using System.Threading.Tasks;
using Pulumi.Serialization;

namespace Pulumi.Aws.WafV2.Inputs
{

    public sealed class WebAclAssociationConfigGetArgs : global::Pulumi.ResourceArgs
    {
        [Input("requestBodies")]
        private InputList<Inputs.WebAclAssociationConfigRequestBodyGetArgs>? _requestBodies;

        /// <summary>
        /// Customizes the request body that your protected resource forward to AWS WAF for inspection. See `request_body` below for details.
        /// </summary>
        public InputList<Inputs.WebAclAssociationConfigRequestBodyGetArgs> RequestBodies
        {
            get => _requestBodies ?? (_requestBodies = new InputList<Inputs.WebAclAssociationConfigRequestBodyGetArgs>());
            set => _requestBodies = value;
        }

        public WebAclAssociationConfigGetArgs()
        {
        }
        public static new WebAclAssociationConfigGetArgs Empty => new WebAclAssociationConfigGetArgs();
    }
}
