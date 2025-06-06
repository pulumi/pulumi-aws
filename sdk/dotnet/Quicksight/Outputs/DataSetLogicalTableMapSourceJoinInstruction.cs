// *** WARNING: this file was generated by pulumi-language-dotnet. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

using System;
using System.Collections.Generic;
using System.Collections.Immutable;
using System.Threading.Tasks;
using Pulumi.Serialization;

namespace Pulumi.Aws.Quicksight.Outputs
{

    [OutputType]
    public sealed class DataSetLogicalTableMapSourceJoinInstruction
    {
        /// <summary>
        /// Join key properties of the left operand. See left_join_key_properties.
        /// </summary>
        public readonly Outputs.DataSetLogicalTableMapSourceJoinInstructionLeftJoinKeyProperties? LeftJoinKeyProperties;
        /// <summary>
        /// Operand on the left side of a join.
        /// </summary>
        public readonly string LeftOperand;
        /// <summary>
        /// Join instructions provided in the ON clause of a join.
        /// </summary>
        public readonly string OnClause;
        /// <summary>
        /// Join key properties of the right operand. See right_join_key_properties.
        /// </summary>
        public readonly Outputs.DataSetLogicalTableMapSourceJoinInstructionRightJoinKeyProperties? RightJoinKeyProperties;
        /// <summary>
        /// Operand on the right side of a join.
        /// </summary>
        public readonly string RightOperand;
        /// <summary>
        /// Type of join. Valid values are `INNER`, `OUTER`, `LEFT`, and `RIGHT`.
        /// </summary>
        public readonly string Type;

        [OutputConstructor]
        private DataSetLogicalTableMapSourceJoinInstruction(
            Outputs.DataSetLogicalTableMapSourceJoinInstructionLeftJoinKeyProperties? leftJoinKeyProperties,

            string leftOperand,

            string onClause,

            Outputs.DataSetLogicalTableMapSourceJoinInstructionRightJoinKeyProperties? rightJoinKeyProperties,

            string rightOperand,

            string type)
        {
            LeftJoinKeyProperties = leftJoinKeyProperties;
            LeftOperand = leftOperand;
            OnClause = onClause;
            RightJoinKeyProperties = rightJoinKeyProperties;
            RightOperand = rightOperand;
            Type = type;
        }
    }
}
