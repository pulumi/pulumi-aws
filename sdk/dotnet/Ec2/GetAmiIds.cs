// *** WARNING: this file was generated by pulumi-language-dotnet. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

using System;
using System.Collections.Generic;
using System.Collections.Immutable;
using System.Threading.Tasks;
using Pulumi.Serialization;

namespace Pulumi.Aws.Ec2
{
    public static class GetAmiIds
    {
        /// <summary>
        /// Use this data source to get a list of AMI IDs matching the specified criteria.
        /// 
        /// ## Example Usage
        /// 
        /// ```csharp
        /// using System.Collections.Generic;
        /// using System.Linq;
        /// using Pulumi;
        /// using Aws = Pulumi.Aws;
        /// 
        /// return await Deployment.RunAsync(() =&gt; 
        /// {
        ///     var ubuntu = Aws.Ec2.GetAmiIds.Invoke(new()
        ///     {
        ///         Owners = new[]
        ///         {
        ///             "099720109477",
        ///         },
        ///         Filters = new[]
        ///         {
        ///             new Aws.Ec2.Inputs.GetAmiIdsFilterInputArgs
        ///             {
        ///                 Name = "name",
        ///                 Values = new[]
        ///                 {
        ///                     "ubuntu/images/ubuntu-*-*-amd64-server-*",
        ///                 },
        ///             },
        ///         },
        ///     });
        /// 
        /// });
        /// ```
        /// </summary>
        public static Task<GetAmiIdsResult> InvokeAsync(GetAmiIdsArgs args, InvokeOptions? options = null)
            => global::Pulumi.Deployment.Instance.InvokeAsync<GetAmiIdsResult>("aws:ec2/getAmiIds:getAmiIds", args ?? new GetAmiIdsArgs(), options.WithDefaults());

        /// <summary>
        /// Use this data source to get a list of AMI IDs matching the specified criteria.
        /// 
        /// ## Example Usage
        /// 
        /// ```csharp
        /// using System.Collections.Generic;
        /// using System.Linq;
        /// using Pulumi;
        /// using Aws = Pulumi.Aws;
        /// 
        /// return await Deployment.RunAsync(() =&gt; 
        /// {
        ///     var ubuntu = Aws.Ec2.GetAmiIds.Invoke(new()
        ///     {
        ///         Owners = new[]
        ///         {
        ///             "099720109477",
        ///         },
        ///         Filters = new[]
        ///         {
        ///             new Aws.Ec2.Inputs.GetAmiIdsFilterInputArgs
        ///             {
        ///                 Name = "name",
        ///                 Values = new[]
        ///                 {
        ///                     "ubuntu/images/ubuntu-*-*-amd64-server-*",
        ///                 },
        ///             },
        ///         },
        ///     });
        /// 
        /// });
        /// ```
        /// </summary>
        public static Output<GetAmiIdsResult> Invoke(GetAmiIdsInvokeArgs args, InvokeOptions? options = null)
            => global::Pulumi.Deployment.Instance.Invoke<GetAmiIdsResult>("aws:ec2/getAmiIds:getAmiIds", args ?? new GetAmiIdsInvokeArgs(), options.WithDefaults());

        /// <summary>
        /// Use this data source to get a list of AMI IDs matching the specified criteria.
        /// 
        /// ## Example Usage
        /// 
        /// ```csharp
        /// using System.Collections.Generic;
        /// using System.Linq;
        /// using Pulumi;
        /// using Aws = Pulumi.Aws;
        /// 
        /// return await Deployment.RunAsync(() =&gt; 
        /// {
        ///     var ubuntu = Aws.Ec2.GetAmiIds.Invoke(new()
        ///     {
        ///         Owners = new[]
        ///         {
        ///             "099720109477",
        ///         },
        ///         Filters = new[]
        ///         {
        ///             new Aws.Ec2.Inputs.GetAmiIdsFilterInputArgs
        ///             {
        ///                 Name = "name",
        ///                 Values = new[]
        ///                 {
        ///                     "ubuntu/images/ubuntu-*-*-amd64-server-*",
        ///                 },
        ///             },
        ///         },
        ///     });
        /// 
        /// });
        /// ```
        /// </summary>
        public static Output<GetAmiIdsResult> Invoke(GetAmiIdsInvokeArgs args, InvokeOutputOptions options)
            => global::Pulumi.Deployment.Instance.Invoke<GetAmiIdsResult>("aws:ec2/getAmiIds:getAmiIds", args ?? new GetAmiIdsInvokeArgs(), options.WithDefaults());
    }


    public sealed class GetAmiIdsArgs : global::Pulumi.InvokeArgs
    {
        [Input("executableUsers")]
        private List<string>? _executableUsers;

        /// <summary>
        /// Limit search to users with *explicit* launch
        /// permission on  the image. Valid items are the numeric account ID or `self`.
        /// </summary>
        public List<string> ExecutableUsers
        {
            get => _executableUsers ?? (_executableUsers = new List<string>());
            set => _executableUsers = value;
        }

        [Input("filters")]
        private List<Inputs.GetAmiIdsFilterArgs>? _filters;

        /// <summary>
        /// One or more name/value pairs to filter off of. There
        /// are several valid keys, for a full reference, check out
        /// [describe-images in the AWS CLI reference][1].
        /// </summary>
        public List<Inputs.GetAmiIdsFilterArgs> Filters
        {
            get => _filters ?? (_filters = new List<Inputs.GetAmiIdsFilterArgs>());
            set => _filters = value;
        }

        /// <summary>
        /// If true, all deprecated AMIs are included in the response.
        /// If false, no deprecated AMIs are included in the response. If no value is specified, the default value is `false`.
        /// </summary>
        [Input("includeDeprecated")]
        public bool? IncludeDeprecated { get; set; }

        /// <summary>
        /// Regex string to apply to the AMI list returned
        /// by AWS. This allows more advanced filtering not supported from the AWS API.
        /// This filtering is done locally on what AWS returns, and could have a performance
        /// impact if the result is large. Combine this with other
        /// options to narrow down the list AWS returns.
        /// </summary>
        [Input("nameRegex")]
        public string? NameRegex { get; set; }

        [Input("owners", required: true)]
        private List<string>? _owners;

        /// <summary>
        /// List of AMI owners to limit search. At least 1 value must be specified. Valid values: an AWS account ID, `self` (the current account), or an AWS owner alias (e.g., `amazon`, `aws-marketplace`, `microsoft`).
        /// </summary>
        public List<string> Owners
        {
            get => _owners ?? (_owners = new List<string>());
            set => _owners = value;
        }

        /// <summary>
        /// Used to sort AMIs by creation time.
        /// If no value is specified, the default value is `false`.
        /// </summary>
        [Input("sortAscending")]
        public bool? SortAscending { get; set; }

        public GetAmiIdsArgs()
        {
        }
        public static new GetAmiIdsArgs Empty => new GetAmiIdsArgs();
    }

    public sealed class GetAmiIdsInvokeArgs : global::Pulumi.InvokeArgs
    {
        [Input("executableUsers")]
        private InputList<string>? _executableUsers;

        /// <summary>
        /// Limit search to users with *explicit* launch
        /// permission on  the image. Valid items are the numeric account ID or `self`.
        /// </summary>
        public InputList<string> ExecutableUsers
        {
            get => _executableUsers ?? (_executableUsers = new InputList<string>());
            set => _executableUsers = value;
        }

        [Input("filters")]
        private InputList<Inputs.GetAmiIdsFilterInputArgs>? _filters;

        /// <summary>
        /// One or more name/value pairs to filter off of. There
        /// are several valid keys, for a full reference, check out
        /// [describe-images in the AWS CLI reference][1].
        /// </summary>
        public InputList<Inputs.GetAmiIdsFilterInputArgs> Filters
        {
            get => _filters ?? (_filters = new InputList<Inputs.GetAmiIdsFilterInputArgs>());
            set => _filters = value;
        }

        /// <summary>
        /// If true, all deprecated AMIs are included in the response.
        /// If false, no deprecated AMIs are included in the response. If no value is specified, the default value is `false`.
        /// </summary>
        [Input("includeDeprecated")]
        public Input<bool>? IncludeDeprecated { get; set; }

        /// <summary>
        /// Regex string to apply to the AMI list returned
        /// by AWS. This allows more advanced filtering not supported from the AWS API.
        /// This filtering is done locally on what AWS returns, and could have a performance
        /// impact if the result is large. Combine this with other
        /// options to narrow down the list AWS returns.
        /// </summary>
        [Input("nameRegex")]
        public Input<string>? NameRegex { get; set; }

        [Input("owners", required: true)]
        private InputList<string>? _owners;

        /// <summary>
        /// List of AMI owners to limit search. At least 1 value must be specified. Valid values: an AWS account ID, `self` (the current account), or an AWS owner alias (e.g., `amazon`, `aws-marketplace`, `microsoft`).
        /// </summary>
        public InputList<string> Owners
        {
            get => _owners ?? (_owners = new InputList<string>());
            set => _owners = value;
        }

        /// <summary>
        /// Used to sort AMIs by creation time.
        /// If no value is specified, the default value is `false`.
        /// </summary>
        [Input("sortAscending")]
        public Input<bool>? SortAscending { get; set; }

        public GetAmiIdsInvokeArgs()
        {
        }
        public static new GetAmiIdsInvokeArgs Empty => new GetAmiIdsInvokeArgs();
    }


    [OutputType]
    public sealed class GetAmiIdsResult
    {
        public readonly ImmutableArray<string> ExecutableUsers;
        public readonly ImmutableArray<Outputs.GetAmiIdsFilterResult> Filters;
        /// <summary>
        /// The provider-assigned unique ID for this managed resource.
        /// </summary>
        public readonly string Id;
        /// <summary>
        /// is set to the list of AMI IDs, sorted by creation time according to `sort_ascending`.
        /// </summary>
        public readonly ImmutableArray<string> Ids;
        public readonly bool? IncludeDeprecated;
        public readonly string? NameRegex;
        public readonly ImmutableArray<string> Owners;
        public readonly bool? SortAscending;

        [OutputConstructor]
        private GetAmiIdsResult(
            ImmutableArray<string> executableUsers,

            ImmutableArray<Outputs.GetAmiIdsFilterResult> filters,

            string id,

            ImmutableArray<string> ids,

            bool? includeDeprecated,

            string? nameRegex,

            ImmutableArray<string> owners,

            bool? sortAscending)
        {
            ExecutableUsers = executableUsers;
            Filters = filters;
            Id = id;
            Ids = ids;
            IncludeDeprecated = includeDeprecated;
            NameRegex = nameRegex;
            Owners = owners;
            SortAscending = sortAscending;
        }
    }
}
