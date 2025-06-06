// *** WARNING: this file was generated by pulumi-language-dotnet. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

using System;
using System.Collections.Generic;
using System.Collections.Immutable;
using System.Threading.Tasks;
using Pulumi.Serialization;

namespace Pulumi.Aws.Ec2
{
    /// <summary>
    /// Provides a subnet CIDR reservation resource.
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
    ///     var example = new Aws.Ec2.SubnetCidrReservation("example", new()
    ///     {
    ///         CidrBlock = "10.0.0.16/28",
    ///         ReservationType = "prefix",
    ///         SubnetId = exampleAwsSubnet.Id,
    ///     });
    /// 
    /// });
    /// ```
    /// 
    /// ## Import
    /// 
    /// Using `pulumi import`, import Existing CIDR reservations using `SUBNET_ID:RESERVATION_ID`. For example:
    /// 
    /// ```sh
    /// $ pulumi import aws:ec2/subnetCidrReservation:SubnetCidrReservation example subnet-01llsxvsxabqiymcz:scr-4mnvz6wb7otksjcs9
    /// ```
    /// </summary>
    [AwsResourceType("aws:ec2/subnetCidrReservation:SubnetCidrReservation")]
    public partial class SubnetCidrReservation : global::Pulumi.CustomResource
    {
        /// <summary>
        /// The CIDR block for the reservation.
        /// </summary>
        [Output("cidrBlock")]
        public Output<string> CidrBlock { get; private set; } = null!;

        /// <summary>
        /// A brief description of the reservation.
        /// </summary>
        [Output("description")]
        public Output<string?> Description { get; private set; } = null!;

        /// <summary>
        /// ID of the AWS account that owns this CIDR reservation.
        /// </summary>
        [Output("ownerId")]
        public Output<string> OwnerId { get; private set; } = null!;

        /// <summary>
        /// The type of reservation to create. Valid values: `explicit`, `prefix`
        /// </summary>
        [Output("reservationType")]
        public Output<string> ReservationType { get; private set; } = null!;

        /// <summary>
        /// The ID of the subnet to create the reservation for.
        /// </summary>
        [Output("subnetId")]
        public Output<string> SubnetId { get; private set; } = null!;


        /// <summary>
        /// Create a SubnetCidrReservation resource with the given unique name, arguments, and options.
        /// </summary>
        ///
        /// <param name="name">The unique name of the resource</param>
        /// <param name="args">The arguments used to populate this resource's properties</param>
        /// <param name="options">A bag of options that control this resource's behavior</param>
        public SubnetCidrReservation(string name, SubnetCidrReservationArgs args, CustomResourceOptions? options = null)
            : base("aws:ec2/subnetCidrReservation:SubnetCidrReservation", name, args ?? new SubnetCidrReservationArgs(), MakeResourceOptions(options, ""))
        {
        }

        private SubnetCidrReservation(string name, Input<string> id, SubnetCidrReservationState? state = null, CustomResourceOptions? options = null)
            : base("aws:ec2/subnetCidrReservation:SubnetCidrReservation", name, state, MakeResourceOptions(options, id))
        {
        }

        private static CustomResourceOptions MakeResourceOptions(CustomResourceOptions? options, Input<string>? id)
        {
            var defaultOptions = new CustomResourceOptions
            {
                Version = Utilities.Version,
            };
            var merged = CustomResourceOptions.Merge(defaultOptions, options);
            // Override the ID if one was specified for consistency with other language SDKs.
            merged.Id = id ?? merged.Id;
            return merged;
        }
        /// <summary>
        /// Get an existing SubnetCidrReservation resource's state with the given name, ID, and optional extra
        /// properties used to qualify the lookup.
        /// </summary>
        ///
        /// <param name="name">The unique name of the resulting resource.</param>
        /// <param name="id">The unique provider ID of the resource to lookup.</param>
        /// <param name="state">Any extra arguments used during the lookup.</param>
        /// <param name="options">A bag of options that control this resource's behavior</param>
        public static SubnetCidrReservation Get(string name, Input<string> id, SubnetCidrReservationState? state = null, CustomResourceOptions? options = null)
        {
            return new SubnetCidrReservation(name, id, state, options);
        }
    }

    public sealed class SubnetCidrReservationArgs : global::Pulumi.ResourceArgs
    {
        /// <summary>
        /// The CIDR block for the reservation.
        /// </summary>
        [Input("cidrBlock", required: true)]
        public Input<string> CidrBlock { get; set; } = null!;

        /// <summary>
        /// A brief description of the reservation.
        /// </summary>
        [Input("description")]
        public Input<string>? Description { get; set; }

        /// <summary>
        /// The type of reservation to create. Valid values: `explicit`, `prefix`
        /// </summary>
        [Input("reservationType", required: true)]
        public Input<string> ReservationType { get; set; } = null!;

        /// <summary>
        /// The ID of the subnet to create the reservation for.
        /// </summary>
        [Input("subnetId", required: true)]
        public Input<string> SubnetId { get; set; } = null!;

        public SubnetCidrReservationArgs()
        {
        }
        public static new SubnetCidrReservationArgs Empty => new SubnetCidrReservationArgs();
    }

    public sealed class SubnetCidrReservationState : global::Pulumi.ResourceArgs
    {
        /// <summary>
        /// The CIDR block for the reservation.
        /// </summary>
        [Input("cidrBlock")]
        public Input<string>? CidrBlock { get; set; }

        /// <summary>
        /// A brief description of the reservation.
        /// </summary>
        [Input("description")]
        public Input<string>? Description { get; set; }

        /// <summary>
        /// ID of the AWS account that owns this CIDR reservation.
        /// </summary>
        [Input("ownerId")]
        public Input<string>? OwnerId { get; set; }

        /// <summary>
        /// The type of reservation to create. Valid values: `explicit`, `prefix`
        /// </summary>
        [Input("reservationType")]
        public Input<string>? ReservationType { get; set; }

        /// <summary>
        /// The ID of the subnet to create the reservation for.
        /// </summary>
        [Input("subnetId")]
        public Input<string>? SubnetId { get; set; }

        public SubnetCidrReservationState()
        {
        }
        public static new SubnetCidrReservationState Empty => new SubnetCidrReservationState();
    }
}
