// *** WARNING: this file was generated by pulumi-language-dotnet. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

using System;
using System.Collections.Generic;
using System.Collections.Immutable;
using System.Threading.Tasks;
using Pulumi.Serialization;

namespace Pulumi.Aws.NetworkFirewall.Inputs
{

    public sealed class RuleGroupRuleGroupRulesSourceStatelessRulesAndCustomActionsStatelessRuleRuleDefinitionMatchAttributesArgs : global::Pulumi.ResourceArgs
    {
        [Input("destinationPorts")]
        private InputList<Inputs.RuleGroupRuleGroupRulesSourceStatelessRulesAndCustomActionsStatelessRuleRuleDefinitionMatchAttributesDestinationPortArgs>? _destinationPorts;

        /// <summary>
        /// Set of configuration blocks describing the destination ports to inspect for. If not specified, this matches with any destination port. See Destination Port below for details.
        /// </summary>
        public InputList<Inputs.RuleGroupRuleGroupRulesSourceStatelessRulesAndCustomActionsStatelessRuleRuleDefinitionMatchAttributesDestinationPortArgs> DestinationPorts
        {
            get => _destinationPorts ?? (_destinationPorts = new InputList<Inputs.RuleGroupRuleGroupRulesSourceStatelessRulesAndCustomActionsStatelessRuleRuleDefinitionMatchAttributesDestinationPortArgs>());
            set => _destinationPorts = value;
        }

        [Input("destinations")]
        private InputList<Inputs.RuleGroupRuleGroupRulesSourceStatelessRulesAndCustomActionsStatelessRuleRuleDefinitionMatchAttributesDestinationArgs>? _destinations;

        /// <summary>
        /// Set of configuration blocks describing the destination IP address and address ranges to inspect for, in CIDR notation. If not specified, this matches with any destination address. See Destination below for details.
        /// </summary>
        public InputList<Inputs.RuleGroupRuleGroupRulesSourceStatelessRulesAndCustomActionsStatelessRuleRuleDefinitionMatchAttributesDestinationArgs> Destinations
        {
            get => _destinations ?? (_destinations = new InputList<Inputs.RuleGroupRuleGroupRulesSourceStatelessRulesAndCustomActionsStatelessRuleRuleDefinitionMatchAttributesDestinationArgs>());
            set => _destinations = value;
        }

        [Input("protocols")]
        private InputList<int>? _protocols;

        /// <summary>
        /// Set of protocols to inspect for, specified using the protocol's assigned internet protocol number (IANA). If not specified, this matches with any protocol.
        /// </summary>
        public InputList<int> Protocols
        {
            get => _protocols ?? (_protocols = new InputList<int>());
            set => _protocols = value;
        }

        [Input("sourcePorts")]
        private InputList<Inputs.RuleGroupRuleGroupRulesSourceStatelessRulesAndCustomActionsStatelessRuleRuleDefinitionMatchAttributesSourcePortArgs>? _sourcePorts;

        /// <summary>
        /// Set of configuration blocks describing the source ports to inspect for. If not specified, this matches with any source port. See Source Port below for details.
        /// </summary>
        public InputList<Inputs.RuleGroupRuleGroupRulesSourceStatelessRulesAndCustomActionsStatelessRuleRuleDefinitionMatchAttributesSourcePortArgs> SourcePorts
        {
            get => _sourcePorts ?? (_sourcePorts = new InputList<Inputs.RuleGroupRuleGroupRulesSourceStatelessRulesAndCustomActionsStatelessRuleRuleDefinitionMatchAttributesSourcePortArgs>());
            set => _sourcePorts = value;
        }

        [Input("sources")]
        private InputList<Inputs.RuleGroupRuleGroupRulesSourceStatelessRulesAndCustomActionsStatelessRuleRuleDefinitionMatchAttributesSourceArgs>? _sources;

        /// <summary>
        /// Set of configuration blocks describing the source IP address and address ranges to inspect for, in CIDR notation. If not specified, this matches with any source address. See Source below for details.
        /// </summary>
        public InputList<Inputs.RuleGroupRuleGroupRulesSourceStatelessRulesAndCustomActionsStatelessRuleRuleDefinitionMatchAttributesSourceArgs> Sources
        {
            get => _sources ?? (_sources = new InputList<Inputs.RuleGroupRuleGroupRulesSourceStatelessRulesAndCustomActionsStatelessRuleRuleDefinitionMatchAttributesSourceArgs>());
            set => _sources = value;
        }

        [Input("tcpFlags")]
        private InputList<Inputs.RuleGroupRuleGroupRulesSourceStatelessRulesAndCustomActionsStatelessRuleRuleDefinitionMatchAttributesTcpFlagArgs>? _tcpFlags;

        /// <summary>
        /// Set of configuration blocks containing the TCP flags and masks to inspect for. If not specified, this matches with any settings.
        /// </summary>
        public InputList<Inputs.RuleGroupRuleGroupRulesSourceStatelessRulesAndCustomActionsStatelessRuleRuleDefinitionMatchAttributesTcpFlagArgs> TcpFlags
        {
            get => _tcpFlags ?? (_tcpFlags = new InputList<Inputs.RuleGroupRuleGroupRulesSourceStatelessRulesAndCustomActionsStatelessRuleRuleDefinitionMatchAttributesTcpFlagArgs>());
            set => _tcpFlags = value;
        }

        public RuleGroupRuleGroupRulesSourceStatelessRulesAndCustomActionsStatelessRuleRuleDefinitionMatchAttributesArgs()
        {
        }
        public static new RuleGroupRuleGroupRulesSourceStatelessRulesAndCustomActionsStatelessRuleRuleDefinitionMatchAttributesArgs Empty => new RuleGroupRuleGroupRulesSourceStatelessRulesAndCustomActionsStatelessRuleRuleDefinitionMatchAttributesArgs();
    }
}
