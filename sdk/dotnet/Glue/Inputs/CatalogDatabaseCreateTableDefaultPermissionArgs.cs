// *** WARNING: this file was generated by pulumi-language-dotnet. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

using System;
using System.Collections.Generic;
using System.Collections.Immutable;
using System.Threading.Tasks;
using Pulumi.Serialization;

namespace Pulumi.Aws.Glue.Inputs
{

    public sealed class CatalogDatabaseCreateTableDefaultPermissionArgs : global::Pulumi.ResourceArgs
    {
        [Input("permissions")]
        private InputList<string>? _permissions;

        /// <summary>
        /// The permissions that are granted to the principal.
        /// </summary>
        public InputList<string> Permissions
        {
            get => _permissions ?? (_permissions = new InputList<string>());
            set => _permissions = value;
        }

        /// <summary>
        /// The principal who is granted permissions.. See `principal` below.
        /// </summary>
        [Input("principal")]
        public Input<Inputs.CatalogDatabaseCreateTableDefaultPermissionPrincipalArgs>? Principal { get; set; }

        public CatalogDatabaseCreateTableDefaultPermissionArgs()
        {
        }
        public static new CatalogDatabaseCreateTableDefaultPermissionArgs Empty => new CatalogDatabaseCreateTableDefaultPermissionArgs();
    }
}
