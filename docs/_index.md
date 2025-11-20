---
title: AWS
meta_desc: Learn how you can use Pulumi's AWS Provider to reduce the complexity of provisioning and managing resources on AWS.
layout: package
---

The Amazon Web Services (AWS) provider for Pulumi can provision many of the cloud resources available in [AWS](https://aws.amazon.com/). It uses the AWS SDK to manage and provision resources.

The AWS provider must be configured with credentials to deploy and update resources in AWS; see [Installation & Configuration](./installation-configuration/) for instructions.

**New to Pulumi and AWS?** [Get started with AWS using our tutorial](/docs/get-started/aws).

## Example

{{< chooser language "typescript,python,go,csharp,java,yaml" >}}

{{% choosable language typescript %}}

```typescript
const aws = require("@pulumi/aws");

const bucket = new aws.s3.Bucket("mybucket");
```

{{% /choosable %}}

{{% choosable language python %}}

```python
import pulumi
import pulumi_aws as aws

bucket = aws.s3.Bucket("bucket")
```

{{% /choosable %}}

{{% choosable language go %}}

```go
package main

import (
	"github.com/pulumi/pulumi-aws/sdk/v7/go/aws/s3"
	"github.com/pulumi/pulumi/sdk/v3/go/pulumi"
)

func main() {
	pulumi.Run(func(ctx *pulumi.Context) error {
		_, err := s3.NewBucket(ctx, "bucket", &s3.BucketArgs{})
		if err != nil {
			return err
		}
		return nil
	})
}

```

{{% /choosable %}}

{{% choosable language csharp %}}

```csharp
using Pulumi;
using Aws = Pulumi.Aws;

await Deployment.RunAsync(() =>
{
    var bucket = new Aws.S3.Bucket("bucket");
});
```

{{% /choosable %}}

{{% choosable language java %}}

```java
import com.pulumi.Context;
import com.pulumi.Pulumi;
import com.pulumi.aws.s3.Bucket;

public class App {
    public static void main(String[] args) {
        Pulumi.run(App::stack);
    }

    private static void stack(Context ctx) {
        final var bucket = new Bucket("my-bucket");
        ctx.export("bucketName", bucket.name());
  }
}
```

{{% /choosable %}}

{{% choosable language yaml %}}

```yaml
resources:
  mybucket:
    type: aws:s3:Bucket
outputs:
  bucketName: ${mybucket.name}
```

{{% /choosable %}}

{{< /chooser >}}

Visit the [How-to Guides](./how-to-guides) to find step-by-step guides for specific scenarios like creating a serverless application or setting up Athena search.

## Components

Pulumi offers Components that provide simpler interfaces and higher-productivity APIs for many areas of AWS:

* [Amazon EKS](/registry/packages/eks)
* [Crosswalk for AWS](/docs/guides/crosswalk/aws), which includes API Gateway, CloudWatch, Elastic Container Registry, Elastic Container Service, Elastic Kubernetes Service, Elastic Load Balancing, Identity & Access Management, Lambda, Virtual Private Cloud, and more

## Migrations

Information about updating the major versions of the AWS Provider, along with any breaking changes that you should be aware of can be found on the following pages:

* [Migrating to v6.x.x guide](/registry/packages/aws/how-to-guides/6-0-migration/)
* [Migrating to v7.x.x guide](/registry/packages/aws/how-to-guides/7-0-migration/)
