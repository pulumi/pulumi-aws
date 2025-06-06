// *** WARNING: this file was generated by pulumi-language-dotnet. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

using System;
using System.Collections.Generic;
using System.Collections.Immutable;
using System.Threading.Tasks;
using Pulumi.Serialization;

namespace Pulumi.Aws.Auditmanager
{
    public static class GetControl
    {
        /// <summary>
        /// Data source for managing an AWS Audit Manager Control.
        /// 
        /// ## Example Usage
        /// 
        /// ### Basic Usage
        /// 
        /// ```csharp
        /// using System.Collections.Generic;
        /// using System.Linq;
        /// using Pulumi;
        /// using Aws = Pulumi.Aws;
        /// 
        /// return await Deployment.RunAsync(() =&gt; 
        /// {
        ///     var example = Aws.Auditmanager.GetControl.Invoke(new()
        ///     {
        ///         Name = "1. Risk Management",
        ///         Type = "Standard",
        ///     });
        /// 
        /// });
        /// ```
        /// 
        /// ### With Framework Resource
        /// 
        /// ```csharp
        /// using System.Collections.Generic;
        /// using System.Linq;
        /// using Pulumi;
        /// using Aws = Pulumi.Aws;
        /// 
        /// return await Deployment.RunAsync(() =&gt; 
        /// {
        ///     var example = Aws.Auditmanager.GetControl.Invoke(new()
        ///     {
        ///         Name = "1. Risk Management",
        ///         Type = "Standard",
        ///     });
        /// 
        ///     var example2 = Aws.Auditmanager.GetControl.Invoke(new()
        ///     {
        ///         Name = "2. Personnel",
        ///         Type = "Standard",
        ///     });
        /// 
        ///     var exampleFramework = new Aws.Auditmanager.Framework("example", new()
        ///     {
        ///         Name = "example",
        ///         ControlSets = new[]
        ///         {
        ///             new Aws.Auditmanager.Inputs.FrameworkControlSetArgs
        ///             {
        ///                 Name = "example",
        ///                 Controls = new[]
        ///                 {
        ///                     new Aws.Auditmanager.Inputs.FrameworkControlSetControlArgs
        ///                     {
        ///                         Id = example.Apply(getControlResult =&gt; getControlResult.Id),
        ///                     },
        ///                 },
        ///             },
        ///             new Aws.Auditmanager.Inputs.FrameworkControlSetArgs
        ///             {
        ///                 Name = "example2",
        ///                 Controls = new[]
        ///                 {
        ///                     new Aws.Auditmanager.Inputs.FrameworkControlSetControlArgs
        ///                     {
        ///                         Id = example2.Apply(getControlResult =&gt; getControlResult.Id),
        ///                     },
        ///                 },
        ///             },
        ///         },
        ///     });
        /// 
        /// });
        /// ```
        /// </summary>
        public static Task<GetControlResult> InvokeAsync(GetControlArgs args, InvokeOptions? options = null)
            => global::Pulumi.Deployment.Instance.InvokeAsync<GetControlResult>("aws:auditmanager/getControl:getControl", args ?? new GetControlArgs(), options.WithDefaults());

        /// <summary>
        /// Data source for managing an AWS Audit Manager Control.
        /// 
        /// ## Example Usage
        /// 
        /// ### Basic Usage
        /// 
        /// ```csharp
        /// using System.Collections.Generic;
        /// using System.Linq;
        /// using Pulumi;
        /// using Aws = Pulumi.Aws;
        /// 
        /// return await Deployment.RunAsync(() =&gt; 
        /// {
        ///     var example = Aws.Auditmanager.GetControl.Invoke(new()
        ///     {
        ///         Name = "1. Risk Management",
        ///         Type = "Standard",
        ///     });
        /// 
        /// });
        /// ```
        /// 
        /// ### With Framework Resource
        /// 
        /// ```csharp
        /// using System.Collections.Generic;
        /// using System.Linq;
        /// using Pulumi;
        /// using Aws = Pulumi.Aws;
        /// 
        /// return await Deployment.RunAsync(() =&gt; 
        /// {
        ///     var example = Aws.Auditmanager.GetControl.Invoke(new()
        ///     {
        ///         Name = "1. Risk Management",
        ///         Type = "Standard",
        ///     });
        /// 
        ///     var example2 = Aws.Auditmanager.GetControl.Invoke(new()
        ///     {
        ///         Name = "2. Personnel",
        ///         Type = "Standard",
        ///     });
        /// 
        ///     var exampleFramework = new Aws.Auditmanager.Framework("example", new()
        ///     {
        ///         Name = "example",
        ///         ControlSets = new[]
        ///         {
        ///             new Aws.Auditmanager.Inputs.FrameworkControlSetArgs
        ///             {
        ///                 Name = "example",
        ///                 Controls = new[]
        ///                 {
        ///                     new Aws.Auditmanager.Inputs.FrameworkControlSetControlArgs
        ///                     {
        ///                         Id = example.Apply(getControlResult =&gt; getControlResult.Id),
        ///                     },
        ///                 },
        ///             },
        ///             new Aws.Auditmanager.Inputs.FrameworkControlSetArgs
        ///             {
        ///                 Name = "example2",
        ///                 Controls = new[]
        ///                 {
        ///                     new Aws.Auditmanager.Inputs.FrameworkControlSetControlArgs
        ///                     {
        ///                         Id = example2.Apply(getControlResult =&gt; getControlResult.Id),
        ///                     },
        ///                 },
        ///             },
        ///         },
        ///     });
        /// 
        /// });
        /// ```
        /// </summary>
        public static Output<GetControlResult> Invoke(GetControlInvokeArgs args, InvokeOptions? options = null)
            => global::Pulumi.Deployment.Instance.Invoke<GetControlResult>("aws:auditmanager/getControl:getControl", args ?? new GetControlInvokeArgs(), options.WithDefaults());

        /// <summary>
        /// Data source for managing an AWS Audit Manager Control.
        /// 
        /// ## Example Usage
        /// 
        /// ### Basic Usage
        /// 
        /// ```csharp
        /// using System.Collections.Generic;
        /// using System.Linq;
        /// using Pulumi;
        /// using Aws = Pulumi.Aws;
        /// 
        /// return await Deployment.RunAsync(() =&gt; 
        /// {
        ///     var example = Aws.Auditmanager.GetControl.Invoke(new()
        ///     {
        ///         Name = "1. Risk Management",
        ///         Type = "Standard",
        ///     });
        /// 
        /// });
        /// ```
        /// 
        /// ### With Framework Resource
        /// 
        /// ```csharp
        /// using System.Collections.Generic;
        /// using System.Linq;
        /// using Pulumi;
        /// using Aws = Pulumi.Aws;
        /// 
        /// return await Deployment.RunAsync(() =&gt; 
        /// {
        ///     var example = Aws.Auditmanager.GetControl.Invoke(new()
        ///     {
        ///         Name = "1. Risk Management",
        ///         Type = "Standard",
        ///     });
        /// 
        ///     var example2 = Aws.Auditmanager.GetControl.Invoke(new()
        ///     {
        ///         Name = "2. Personnel",
        ///         Type = "Standard",
        ///     });
        /// 
        ///     var exampleFramework = new Aws.Auditmanager.Framework("example", new()
        ///     {
        ///         Name = "example",
        ///         ControlSets = new[]
        ///         {
        ///             new Aws.Auditmanager.Inputs.FrameworkControlSetArgs
        ///             {
        ///                 Name = "example",
        ///                 Controls = new[]
        ///                 {
        ///                     new Aws.Auditmanager.Inputs.FrameworkControlSetControlArgs
        ///                     {
        ///                         Id = example.Apply(getControlResult =&gt; getControlResult.Id),
        ///                     },
        ///                 },
        ///             },
        ///             new Aws.Auditmanager.Inputs.FrameworkControlSetArgs
        ///             {
        ///                 Name = "example2",
        ///                 Controls = new[]
        ///                 {
        ///                     new Aws.Auditmanager.Inputs.FrameworkControlSetControlArgs
        ///                     {
        ///                         Id = example2.Apply(getControlResult =&gt; getControlResult.Id),
        ///                     },
        ///                 },
        ///             },
        ///         },
        ///     });
        /// 
        /// });
        /// ```
        /// </summary>
        public static Output<GetControlResult> Invoke(GetControlInvokeArgs args, InvokeOutputOptions options)
            => global::Pulumi.Deployment.Instance.Invoke<GetControlResult>("aws:auditmanager/getControl:getControl", args ?? new GetControlInvokeArgs(), options.WithDefaults());
    }


    public sealed class GetControlArgs : global::Pulumi.InvokeArgs
    {
        [Input("controlMappingSources")]
        private List<Inputs.GetControlControlMappingSourceArgs>? _controlMappingSources;
        public List<Inputs.GetControlControlMappingSourceArgs> ControlMappingSources
        {
            get => _controlMappingSources ?? (_controlMappingSources = new List<Inputs.GetControlControlMappingSourceArgs>());
            set => _controlMappingSources = value;
        }

        /// <summary>
        /// Name of the control.
        /// </summary>
        [Input("name", required: true)]
        public string Name { get; set; } = null!;

        /// <summary>
        /// Type of control. Valid values are `Custom` and `Standard`.
        /// </summary>
        [Input("type", required: true)]
        public string Type { get; set; } = null!;

        public GetControlArgs()
        {
        }
        public static new GetControlArgs Empty => new GetControlArgs();
    }

    public sealed class GetControlInvokeArgs : global::Pulumi.InvokeArgs
    {
        [Input("controlMappingSources")]
        private InputList<Inputs.GetControlControlMappingSourceInputArgs>? _controlMappingSources;
        public InputList<Inputs.GetControlControlMappingSourceInputArgs> ControlMappingSources
        {
            get => _controlMappingSources ?? (_controlMappingSources = new InputList<Inputs.GetControlControlMappingSourceInputArgs>());
            set => _controlMappingSources = value;
        }

        /// <summary>
        /// Name of the control.
        /// </summary>
        [Input("name", required: true)]
        public Input<string> Name { get; set; } = null!;

        /// <summary>
        /// Type of control. Valid values are `Custom` and `Standard`.
        /// </summary>
        [Input("type", required: true)]
        public Input<string> Type { get; set; } = null!;

        public GetControlInvokeArgs()
        {
        }
        public static new GetControlInvokeArgs Empty => new GetControlInvokeArgs();
    }


    [OutputType]
    public sealed class GetControlResult
    {
        public readonly string ActionPlanInstructions;
        public readonly string ActionPlanTitle;
        public readonly string Arn;
        public readonly ImmutableArray<Outputs.GetControlControlMappingSourceResult> ControlMappingSources;
        public readonly string Description;
        public readonly string Id;
        public readonly string Name;
        public readonly ImmutableDictionary<string, string> Tags;
        public readonly string TestingInformation;
        public readonly string Type;

        [OutputConstructor]
        private GetControlResult(
            string actionPlanInstructions,

            string actionPlanTitle,

            string arn,

            ImmutableArray<Outputs.GetControlControlMappingSourceResult> controlMappingSources,

            string description,

            string id,

            string name,

            ImmutableDictionary<string, string> tags,

            string testingInformation,

            string type)
        {
            ActionPlanInstructions = actionPlanInstructions;
            ActionPlanTitle = actionPlanTitle;
            Arn = arn;
            ControlMappingSources = controlMappingSources;
            Description = description;
            Id = id;
            Name = name;
            Tags = tags;
            TestingInformation = testingInformation;
            Type = type;
        }
    }
}
