// *** WARNING: this file was generated by pulumi-language-dotnet. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

using System;
using System.Collections.Generic;
using System.Collections.Immutable;
using System.Threading.Tasks;
using Pulumi.Serialization;

namespace Pulumi.Aws.Macie.Inputs
{

    public sealed class FindingsFilterFindingCriteriaGetArgs : global::Pulumi.ResourceArgs
    {
        [Input("criterions")]
        private InputList<Inputs.FindingsFilterFindingCriteriaCriterionGetArgs>? _criterions;

        /// <summary>
        /// A condition that specifies the property, operator, and one or more values to use to filter the results.  (documented below)
        /// </summary>
        public InputList<Inputs.FindingsFilterFindingCriteriaCriterionGetArgs> Criterions
        {
            get => _criterions ?? (_criterions = new InputList<Inputs.FindingsFilterFindingCriteriaCriterionGetArgs>());
            set => _criterions = value;
        }

        public FindingsFilterFindingCriteriaGetArgs()
        {
        }
        public static new FindingsFilterFindingCriteriaGetArgs Empty => new FindingsFilterFindingCriteriaGetArgs();
    }
}
