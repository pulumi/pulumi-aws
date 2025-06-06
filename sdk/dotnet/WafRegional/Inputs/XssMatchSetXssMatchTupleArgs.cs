// *** WARNING: this file was generated by pulumi-language-dotnet. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

using System;
using System.Collections.Generic;
using System.Collections.Immutable;
using System.Threading.Tasks;
using Pulumi.Serialization;

namespace Pulumi.Aws.WafRegional.Inputs
{

    public sealed class XssMatchSetXssMatchTupleArgs : global::Pulumi.ResourceArgs
    {
        /// <summary>
        /// Specifies where in a web request to look for cross-site scripting attacks.
        /// </summary>
        [Input("fieldToMatch", required: true)]
        public Input<Inputs.XssMatchSetXssMatchTupleFieldToMatchArgs> FieldToMatch { get; set; } = null!;

        /// <summary>
        /// Which text transformation, if any, to perform on the web request before inspecting the request for cross-site scripting attacks.
        /// </summary>
        [Input("textTransformation", required: true)]
        public Input<string> TextTransformation { get; set; } = null!;

        public XssMatchSetXssMatchTupleArgs()
        {
        }
        public static new XssMatchSetXssMatchTupleArgs Empty => new XssMatchSetXssMatchTupleArgs();
    }
}
