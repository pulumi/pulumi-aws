// Copyright 2016-2019, Pulumi Corporation.  All rights reserved.

using System.Collections.Generic;
using System.Threading.Tasks;

using Pulumi;

class Program
{
    static Task<int> Main()
    {
        return Deployment.RunAsync(() =>
        {

            // Create an IAM role with PolicyDocument for assume role policy
            var role = new Pulumi.Aws.Iam.Role("example-role", new Pulumi.Aws.Iam.RoleArgs
            {
                Name = "example-role",
                AssumeRolePolicy = new Pulumi.Aws.Iam.Inputs.PolicyDocumentArgs
                {
                    Version = Pulumi.Aws.Iam.PolicyDocumentVersion.PolicyDocumentVersion_2012_10_17,
                    Statement = new Pulumi.Aws.Iam.Inputs.PolicyStatementArgs[]
                    {
                        new Pulumi.Aws.Iam.Inputs.PolicyStatementArgs
                        {
                            Effect = Pulumi.Aws.Iam.PolicyStatementEffect.ALLOW,
                            Action =  "sts:AssumeRole",
                            Principal = new Pulumi.Aws.Iam.Inputs.ServicePrincipalArgs
                                {
                                    Service = "ec2.amazonaws.com"
                                }
                        }
                    }
                },
                Tags = new Dictionary<string, string>
                {
                    { "Environment", "Development" },
                    { "Purpose", "Example" }
                }
            });

            return new Dictionary<string, object>
            {
                { "roleArn", role.Arn },
                { "roleName", role.Name }
            };
        });
    }
}



