---
title: AWS Installation & Configuration
meta_desc: How to set up credentials to use the Pulumi AWS Provider and choose configuration options to tailor the provider to suit your use case.
layout: package
---

{{< aws-resource-note >}}

## Installation

The AWS provider is available as a package in all Pulumi languages:

* JavaScript/TypeScript: [`@pulumi/aws`](https://www.npmjs.com/package/@pulumi/aws)
* Python: [`pulumi-aws`](https://pypi.org/project/pulumi-aws/)
* Go: [`github.com/pulumi/pulumi-aws/sdk/v6`](https://github.com/pulumi/pulumi-aws#go)
* .NET: [`Pulumi.Aws`](https://www.nuget.org/packages/Pulumi.Aws)
* Java: [`com.pulumi.aws`](https://search.maven.org/search?q=com.pulumi.aws)

## Credentials

1. [Create an IAM user in the AWS console](https://docs.aws.amazon.com/IAM/latest/UserGuide/id_users_create.html#id_users_create_console) with programmatic access and ensure it has sufficient permissions to deploy and manage your Pulumi program’s resources.
2. [Set up AWS credentials](https://docs.aws.amazon.com/general/latest/gr/aws-sec-cred-types.html#access-keys-and-secret-access-keys) for your user.

{{% notes "info" %}}
If you are using [temporary security credentials](https://docs.aws.amazon.com/IAM/latest/UserGuide/id_credentials_temp_use-resources.html), you will also have to supply an `AWS_SESSION_TOKEN` value before you can use Pulumi to create resources on your behalf.
{{% /notes %}}

Your AWS credentials are never sent to pulumi.com. Pulumi uses the AWS SDK and the credentials in your environment to authenticate requests from your computer to AWS.

## Configuration

There are a few different ways you can configure your AWS credentials to work with Pulumi.

### Set credentials as environment variables

We recommend using a shared credentials file for most development. However, if you need to [temporarily override your credentials file](https://docs.aws.amazon.com/cli/latest/userguide/cli-configure-quickstart.html#cli-configure-quickstart-precedence), you can use environment variables. You can do this to quickly switch to a different access key or to configure AWS access from within an environment that might not have an AWS CLI, such as a continuous integration/continuous delivery (CI/CD) system.

To authenticate using environment variables, set them in your terminal:

{{< chooser os "linux,macos,windows" >}}
{{% choosable os linux %}}

```bash
$ export AWS_ACCESS_KEY_ID=<YOUR_ACCESS_KEY_ID>
$ export AWS_SECRET_ACCESS_KEY=<YOUR_SECRET_ACCESS_KEY>
$ export AWS_REGION=<YOUR_AWS_REGION> # e.g.`ap-south-1`
```

{{% /choosable %}}

{{% choosable os macos %}}

```bash
$ export AWS_ACCESS_KEY_ID=<YOUR_ACCESS_KEY_ID>
$ export AWS_SECRET_ACCESS_KEY=<YOUR_SECRET_ACCESS_KEY>
$ export AWS_REGION=<YOUR_AWS_REGION> # e.g.`ap-south-1`
```

{{% /choosable %}}

{{% choosable os windows %}}

```powershell
> $env:AWS_ACCESS_KEY_ID = "<YOUR_ACCESS_KEY_ID>"
> $env:AWS_SECRET_ACCESS_KEY = "<YOUR_SECRET_ACCESS_KEY>"
> $env:AWS_REGION = "<YOUR_AWS_REGION>"
```

{{% /choosable %}}
{{< /chooser >}}

You may alternatively set the AWS region in your `Pulumi.<stack-name>.yaml` file:

```bash
$ pulumi config set aws:region <your-region> # e.g.`ap-south-1`
```

### Create a shared credentials file

A credentials file is a plaintext file on your machine that contains your access keys. The file must be named `credentials` and is located underneath `.aws/` directory in your home directory.  We recommend this approach because it supports Amazon's recommended approach for securely managing multiple roles.

#### Option 1: Use the CLI

To create this file using the CLI, [install the AWS CLI](https://docs.aws.amazon.com/cli/latest/userguide/installing.html). If you're using
[Homebrew](https://brew.sh/) on macOS, you can use the community-managed [awscli](http://formulae.brew.sh/formula/awscli) via `brew install awscli`.

After installing the CLI, configure it with your IAM credentials, typically using the `aws configure` command. For other configuration options, see the AWS article [Configuring the AWS CLI](https://docs.aws.amazon.com/cli/latest/userguide/cli-chap-getting-started.html).

```bash
$ aws configure
AWS Access Key ID [None]: <YOUR_ACCESS_KEY_ID>
AWS Secret Access Key [None]: <YOUR_SECRET_ACCESS_KEY>
Default region name [None]:
Default output format [None]:
```

Now you've created the `~/.aws/credentials` file and populated it with the expected settings.

#### Option 2: Create by hand

You can also create the shared credentials file by hand.  For example:

```ini
[default]
aws_access_key_id = <YOUR_ACCESS_KEY_ID>
aws_secret_access_key = <YOUR_SECRET_ACCESS_KEY>
```

If you want to specify multiple profiles, those are listed in different sections:

```ini
[default]
aws_access_key_id = <YOUR_DEFAULT_ACCESS_KEY_ID>
aws_secret_access_key = <YOUR_DEFAULT_SECRET_ACCESS_KEY>

[test-account]
aws_access_key_id = <YOUR_TEST_ACCESS_KEY_ID>
aws_secret_access_key = <YOUR_TEST_SECRET_ACCESS_KEY>

[prod-account]
aws_access_key_id = <YOUR_PROD_ACCESS_KEY_ID>
aws_secret_access_key = <YOUR_PROD_SECRET_ACCESS_KEY>
```

In this case, you will need to set the `AWS_PROFILE` environment variable to the name of the profile to use.

### Set up multiple profiles

As an optional step, you can [set up multiple profiles](https://docs.aws.amazon.com/cli/latest/userguide/cli-configure-quickstart.html#cli-configure-quickstart-profiles).

Here’s what that looks like in your ~/.aws/credentials file:

```ini
[default]
aws_access_key_id = <YOUR_DEFAULT_ACCESS_KEY_ID>
aws_secret_access_key = <YOUR_DEFAULT_SECRET_ACCESS_KEY>

[test-account]
aws_access_key_id = <YOUR_TEST_ACCESS_KEY_ID>
aws_secret_access_key = <YOUR_TEST_SECRET_ACCESS_KEY>

[prod-account]
aws_access_key_id = <YOUR_PROD_ACCESS_KEY_ID>
aws_secret_access_key = <YOUR_PROD_SECRET_ACCESS_KEY>
```

You can specify which profile to use with Pulumi through one of the following methods:

* Set AWS_PROFILE as an environment variable

    ```bash
    $ export AWS_PROFILE=<YOUR_PROFILE_NAME>
    ```

* Set `aws:profile` in your Pulumi.yaml

    ```bash
    pulumi config set aws:profile <profilename>
    ```

### Authenticating via EC2 Instance Metadata

As of pulumi-aws v3.28.1, the default behaviour for the provider [was changed](https://github.com/pulumi/pulumi-aws/blob/master/CHANGELOG_OLD.md#3281-2021-02-10) to disable MetadataApiCheck by default. This means,
you need to do either of the following

1. When using the default provider:

    ```
    pulumi config set aws:skipMetadataApiCheck false
    ```

1. When using a named provider

    ```typescript
    const myProvider = new aws.Provider("named-provider", {
      // other config
      skipMetadataApiCheck: false,
    });
    ```

    ```csharp
    var provider = new Aws.Provider("named-provider", new Aws.ProviderArgs
    {
      // other config
      SkipMetadataApiCheck = false,
    });
    ```

    ```go
    provider, err := aws.NewProvider(ctx, "named-provider", &aws.ProviderArgs{
        // other config
        SkipMetadataApiCheck: pulumi.Bool(false),
    })
    ```

    ```python
    provider = pulumi_aws.Provider('named-provider', skip_metadata_api_check=False)
    ```


### Authenticate with WebIdentity and OpenID Connect (OIDC)

In this approach, you configure an AWS role to assume and a source for a web identity token, which is an OIDC ID token. The token is used to authenticate with AWS and obtain temporary credentials. The temporary credentials are then used to access AWS resources. This mode of authentication allows you to run Pulumi on a service that supports OIDC like GitHub, GitLab, or Azure DevOps, and access AWS without storing credentials.

Please refer to the AWS docs [About web identity federation](https://docs.aws.amazon.com/IAM/latest/UserGuide/id_roles_providers_oidc.html) and [Assume role with web identity](https://docs.aws.amazon.com/cli/latest/userguide/cli-configure-role.html#cli-configure-role-oidc) for more details. Also, refer to the particular service's documentation for how to configure the OIDC trust relationship, which is a one-time setup.

If your Pulumi program runs on GitHub, you don't need to configure the identity token in most cases. Amazon have published [GitHub workflows action `configure-aws-credentials`](https://github.com/aws-actions/configure-aws-credentials/tree/v4/#OIDC) which handles the token. You only configure the role to assume in your GitHub workflow definition:
```yaml
  uses: aws-actions/configure-aws-credentials@v4
  with:
    aws-region: ${{ env.AWS_REGION }}
    role-session-name: <NAME>
    role-to-assume: arn:aws:iam::<ACCOUNT_ID>:role/<ROLE_NAME>
```

In other cases, you will need to configure the `assumeRoleWithWebIdentity` object documented in the [Configuration options](#configuration-options) section of this page. At a minimum, you will need to define the role to assume and the source of the token. In Pulumi config it should look this:
```yaml
config:
  aws:assumeRoleWithWebIdentity:
    roleArn: arn:aws:iam::<ACCOUNT_ID>:role/<ROLE_NAME>
    # Define either webIdentityToken or webIdentityTokenFile
    webIdentityToken: <your-web-identity-token>
    webIdentityTokenFile: webidentitytokenfile.txt
```


### Dynamically generate credentials via Pulumi ESC

In addition to configuring the AWS provider locally, you also have the option to centralize your configurations using [Pulumi ESC (Environments, Secrets, and Configuration)](/docs/pulumi-cloud/esc/). Using this service will enable you to run AWS or Pulumi CLI commands with dynamically generated credentials, removing the need to configure and manage your credentials locally.

To do this, you will need to complete the following steps:

#### Configure OIDC between Pulumi and AWS

Refer to the [Configuring OpenID Connect for AWS Guide](/docs/pulumi-cloud/oidc/aws/) for the step-by-step process on how to do this. Note that when adding your configuration to your environment file, you can also define your AWS region in the `environmentVariables` section:

```yaml
values:
  aws:
    login:
      fn::open::aws-login:
        oidc:
          duration: 1h
          roleArn: <your-oidc-iam-role-arn>
          sessionName: pulumi-environments-session
  environmentVariables:
    AWS_ACCESS_KEY_ID: ${aws.login.accessKeyId}
    AWS_SECRET_ACCESS_KEY: ${aws.login.secretAccessKey}
    AWS_SESSION_TOKEN: ${aws.login.sessionToken}
    AWS_REGION: <YOUR_AWS_REGION> # e.g.`ap-south-1`
```

#### [Optional] Move Pulumi config to your ESC environment

It was mentioned earlier in this guide that you can also set your AWS region as a Pulumi configuration value in your project's stack settings file (`Pulumi.<stack-name>.yaml`). In addition to this, there may be other values that you have defined in this file, and these values can also be centralized using Pulumi ESC. To [expose these values to Pulumi IaC](/docs/pulumi-cloud/esc/environments/#using-environments-with-pulumi-iac), you will need to add a second-level key called `pulumiConfig` and nest any desired values underneath it as shown below:

```yaml
values:
  aws:
    login:
      fn::open::aws-login:
        oidc:
          duration: 1h
          roleArn: <your-oidc-iam-role-arn>
          sessionName: pulumi-environments-session
  environmentVariables:
    AWS_ACCESS_KEY_ID: ${aws.login.accessKeyId}
    AWS_SECRET_ACCESS_KEY: ${aws.login.secretAccessKey}
    AWS_SESSION_TOKEN: ${aws.login.sessionToken}
    AWS_REGION: <YOUR_AWS_REGION>
  pulumiConfig: # exposes Pulumi config values to the Pulumi CLI
    project:environment: 'dev'
    aws:assumeRole:
      roleArn: 'arn:aws:iam::058111598222:role/OrganizationAccountAccessRole'
    aws:dynamodbEndpoint: 'dynamodb.us-east-2.amazonaws.com'
```

If your workflow does not require the exposure of environment variables, you can also define those variables under the `pulumiConfig` block so that they are scoped only to your `pulumi` run.

```yaml
values:
  aws:
    login:
      fn::open::aws-login:
        oidc:
          duration: 1h
          roleArn: <your-oidc-iam-role-arn>
          sessionName: pulumi-environments-session
  pulumiConfig:
    aws:region: <YOUR_AWS_REGION>
    aws:accessKey: ${aws.login.accessKeyId}
    aws:secretKey: ${aws.login.secretAccessKey}
    aws:token: ${aws.login.sessionToken}
    project:environment: 'dev'
    aws:assumeRole:
      roleArn: 'arn:aws:iam::058111598222:role/OrganizationAccountAccessRole'
    aws:dynamodbEndpoint: 'dynamodb.us-east-2.amazonaws.com'
```

{{< notes type="info" >}}
The configuration values under `pulumiConfig` can also be referenced directly from within your Pulumi program code. This is done using the same method to reference values from your project's stack settings file. You can see examples of how to do this in the [Accessing Configuration from Code](/docs/concepts/config/#code) section of the Pulumi documentation.
{{< /notes >}}

#### Import your environment

The last step is to update your project's stack settings file (`Pulumi.<stack-name>.yaml`) to import your ESC environment as shown below:

```yaml
environment:
  - <your-environment-name>
```

Make sure to replace `<your-environment-name>` with the name of the ESC environment you created in the previous steps.

You can test that your configuration is working by running the `pulumi preview` command. This will validate that your AWS resources can be deployed using the dynamically generated credentials in your environment file.

{{< notes type="info" >}}
Make sure that your local environment does not have AWS credentials configured before running this command. You can check by running something like the `aws s3 ls` command which should return the following:

'Unable to locate credentials. You can configure credentials by running "aws configure".'
{{< /notes >}}

To learn more about projecting environment variables in Pulumi ESC, refer to the [relevant Pulumi ESC documentation](/docs/pulumi-cloud/esc/environments/#projecting-environment-variables).


## Configuration options

Use `pulumi config set aws:<option>` or pass options to the [constructor of `new aws.Provider`](../api-docs/provider).

| Option | Required? | Description |
| - | - | - |
| `region` | Required | The region where AWS operations will take place. Examples are `us-east-1`, `us-west-2`, etc. |
| `allowedAccountIds` | Optional | List of allowed AWS account IDs to prevent you from mistakenly using an incorrect one (and potentially end up destroying a live environment). Conflicts with `forbiddenAccountIds`. |
| `accessKey` | Optional | The access key for API operations. You can retrieve this from the ‘Security & Credentials’ section of the AWS console. |
| `assumeRole` | Optional | A JSON object representing an IAM role to assume.  To set these nested properties, see docs on [structured configuration](/docs/concepts/config#structured-configuration), for example `pulumi config set --path aws:assumeRole.roleArn arn:aws:iam::058111598222:role/OrganizationAccountAccessRole`. The object contains the properties marked with a ↳ below: |
| ↳ `durationSeconds` | Optional |  Number of seconds to restrict the assume role session duration. |
| ↳ `externalId` | Optional | External identifier to use when assuming the role. |
| ↳ `policy` | Optional | IAM Policy JSON describing further restricting permissions for the IAM Role being assumed. |
| ↳ `policyArns` | Optional | Set of Amazon Resource Names (ARNs) of IAM Policies describing further restricting permissions for the IAM Role being assumed. |
| ↳ `roleArn` | Optional | Amazon Resource Name (ARN) of the IAM Role to assume. |
| ↳ `sessionName` | Optional | Session name to use when assuming the role. |
| ↳ `tags` | Optional | Map of assume role session tags. |
| ↳ `transitiveTagKeys` | Optional | Set of assume role session tag keys to pass to any subsequent sessions. |
| `assumeRoleWithWebIdentity` | Optional | A JSON object representing an IAM role to assume using web identity/OIDC.  To set these nested properties, see docs on [structured configuration](/docs/concepts/config#structured-configuration), for example `pulumi config set --path aws:assumeRole.roleArn arn:aws:iam::058111598222:role/OrganizationAccountAccessRole`. The object contains the properties marked with a ↳ below: |
| ↳ `durationSeconds` | Optional |  Number of seconds to restrict the assume role session duration. |
| ↳ `policy` | Optional | IAM Policy JSON describing further restricting permissions for the IAM Role being assumed. |
| ↳ `policyArns` | Optional | Set of Amazon Resource Names (ARNs) of IAM Policies describing further restricting permissions for the IAM Role being assumed. |
| ↳ `roleArn` | Optional | Amazon Resource Name (ARN) of the IAM Role to assume. |
| ↳ `sessionName` | Optional | Session name to use when assuming the role. |
| ↳ `webIdentityToken` | Optional | Web Identity (OIDC ID) token value. |
| ↳ `webIdentityTokenFile` | Optional | File containing the Web Identity (OIDC ID) token. |
| `dynamodbEndpoint` | Optional | Use this to override the default endpoint URL constructed from the `region`. It’s typically used to connect to dynamodb-local. |
| `forbiddenAccountIds` | Optional | List of forbidden AWS account IDs to prevent you from mistakenly using the wrong one (and potentially end up destroying a live environment). Conflicts with `allowedAccountIds`. |
| `defaultTags` | Optional | A JSON block with resource tag settings to apply across all resources handled by this provider. Additional tags can be added/overridden at a per resource level. The object contains the properties marked with a ↳ below: |
| ↳ `tags` | Optional | A key value pair of tags to apply across all resources. |
| `ignoreTags` | Optional | A JSON block with resource tag settings to ignore across all resources handled by this provider (except any individual service tag resources such as `aws.ec2.Tag`) for situations where external systems are managing certain resource tags. The object contains the properties marked with a ↳ below: |
| ↳ `keys` | Optional | A list of exact resource tag keys to ignore across all resources handled by this provider. This configuration prevents Pulumi from returning the tag in any `tags` properties and displaying any diffs for the tag value. If any resource still has this tag key configured in the `tags` argument, it will display a perpetual diff until the tag is removed from the argument or `ignoreChanges` is also used. |
| ↳ `keyPrefixes` | Optional | A list of resource tag key prefixes to ignore across all resources handled by this provider. This configuration prevents Pulumi from returning the tag in any `tags` properties and displaying any diffs for the tag value. If any resource still has this tag key configured in the `tags` argument, it will display a perpetual diff until the tag is removed from the argument or `ignoreChanges` is also used. |
| `insecure` | Optional | Explicitly allow the provider to perform "insecure" SSL requests. If omitted, the default value is `false`. |
| `kinesisEndpoint` | Optional | Use this to override the default endpoint URL constructed from the `region`. It's typically used to connect to kinesalite. |
| `maxRetries` | Optional | The maximum number of times an AWS API request is being executed. If the API request still fails, an error is thrown. |
| `profile` | Optional | The profile for API operations. If not set, the default profile created with `aws configure` will be used. |
| `retryMode` | Optional | Specifies how retries are attempted. Valid values are `standard` and `adaptive`. Can also be configured using the `AWS_RETRY_MODE` environment variable. |
| `s3ForcePathStyle` | Optional | Set this to true to force the request to use path-style addressing, i.e., `http://s3.amazonaws.com/BUCKET/KEY`. By default, the S3 client will use virtual hosted bucket addressing when possible (`http://BUCKET.s3.amazonaws.com/KEY`). Specific to the Amazon S3 service. |
| `secretKey` |  Optional | The secret key for API operations. You can retrieve this from the 'Security & Credentials' section of the AWS console. |
| `sharedCredentialsFile` | Optional | The path to the shared credentials file. If not set this defaults to `~/.aws/credentials`. |
| `skipCredentialsValidation` | Optional | Skip the credentials validation via STS API. Used for AWS API implementations that do not have STS available/implemented. |
| `skipMetadataApiCheck` | Optional | Skip the AWS Metadata API check. Useful for AWS API implementations that do not have a metadata API endpoint. Setting to true prevents Pulumi from authenticating via the Metadata API. You may need to use other authentication methods like static credentials, configuration variables, or environment variables. |
| `skipRegionValidation` | Optional | Skip static validation of region name. Used by users of alternative AWS-like APIs or users w/ access to regions that are not public (yet). |
| `skipRequestingAccountId` | Optional | Skip requesting the account ID. Used for AWS API implementations that do not have IAM/STS API and/or metadata API. |
| `token` | Optional | Use this to set an MFA token. It can also be sourced from the `AWS_SESSION_TOKEN` environment variable. |
