
## [*partial failure*] #/resources/aws:wafv2/webAclAssociation:WebAclAssociation

### HCL

```terraform
resource "aws_api_gateway_rest_api" "example" {
  body = jsonencode({
    openapi = "3.0.1"
    info = {
      title   = "example"
      version = "1.0"
    }
    paths = {
      "/path1" = {
        get = {
          x-amazon-apigateway-integration = {
            httpMethod           = "GET"
            payloadFormatVersion = "1.0"
            type                 = "HTTP_PROXY"
            uri                  = "https://ip-ranges.amazonaws.com/ip-ranges.json"
          }
        }
      }
    }
  })

  name = "example"
}

resource "aws_api_gateway_deployment" "example" {
  rest_api_id = aws_api_gateway_rest_api.example.id

  triggers = {
    redeployment = sha1(jsonencode(aws_api_gateway_rest_api.example.body))
  }

  lifecycle {
    create_before_destroy = true
  }
}

resource "aws_api_gateway_stage" "example" {
  deployment_id = aws_api_gateway_deployment.example.id
  rest_api_id   = aws_api_gateway_rest_api.example.id
  stage_name    = "example"
}

resource "aws_wafv2_web_acl" "example" {
  name  = "web-acl-association-example"
  scope = "REGIONAL"

  default_action {
    allow {}
  }

  visibility_config {
    cloudwatch_metrics_enabled = false
    metric_name                = "friendly-metric-name"
    sampled_requests_enabled   = false
  }
}

resource "aws_wafv2_web_acl_association" "example" {
  resource_arn = aws_api_gateway_stage.example.arn
  web_acl_arn  = aws_wafv2_web_acl.example.arn
}

```

### Failed Languages

#### yaml

```text
.pp:24,20-53: Failed to generate YAML program: Unknown Function; YAML does not support Fn::sha1.
```

### Successes

<details>

<summary>python</summary>

```python
import pulumi
import hashlib
import json
import pulumi_aws as aws

example_rest_api = aws.apigateway.RestApi("exampleRestApi", body=json.dumps({
    "openapi": "3.0.1",
    "info": {
        "title": "example",
        "version": "1.0",
    },
    "paths": {
        "/path1": {
            "get": {
                "x-amazon-apigateway-integration": {
                    "httpMethod": "GET",
                    "payloadFormatVersion": "1.0",
                    "type": "HTTP_PROXY",
                    "uri": "https://ip-ranges.amazonaws.com/ip-ranges.json",
                },
            },
        },
    },
}))
example_deployment = aws.apigateway.Deployment("exampleDeployment",
    rest_api=example_rest_api.id,
    triggers={
        "redeployment": example_rest_api.body.apply(lambda body: json.dumps(body)).apply(lambda to_json: hashlib.sha1(to_json.encode()).hexdigest()),
    })
example_stage = aws.apigateway.Stage("exampleStage",
    deployment=example_deployment.id,
    rest_api=example_rest_api.id,
    stage_name="example")
example_web_acl = aws.wafv2.WebAcl("exampleWebAcl",
    scope="REGIONAL",
    default_action=aws.wafv2.WebAclDefaultActionArgs(
        allow=aws.wafv2.WebAclDefaultActionAllowArgs(),
    ),
    visibility_config=aws.wafv2.WebAclVisibilityConfigArgs(
        cloudwatch_metrics_enabled=False,
        metric_name="friendly-metric-name",
        sampled_requests_enabled=False,
    ))
example_web_acl_association = aws.wafv2.WebAclAssociation("exampleWebAclAssociation",
    resource_arn=example_stage.arn,
    web_acl_arn=example_web_acl.arn)
```

</details>

<details>

<summary>csharp</summary>

```csharp
using System.Collections.Generic;
using System.Security.Cryptography;
using System.Text;
using System.Text.Json;
using Pulumi;
using Aws = Pulumi.Aws;

	private static string ComputeSHA1(string input) {
		return BitConverter.ToString(
			SHA1.Create().ComputeHash(Encoding.UTF8.GetBytes(input))
		).Replace("-","").ToLowerInvariant());
	}

return await Deployment.RunAsync(() => 
{
    var exampleRestApi = new Aws.ApiGateway.RestApi("exampleRestApi", new()
    {
        Body = JsonSerializer.Serialize(new Dictionary<string, object?>
        {
            ["openapi"] = "3.0.1",
            ["info"] = new Dictionary<string, object?>
            {
                ["title"] = "example",
                ["version"] = "1.0",
            },
            ["paths"] = new Dictionary<string, object?>
            {
                ["/path1"] = new Dictionary<string, object?>
                {
                    ["get"] = new Dictionary<string, object?>
                    {
                        ["x-amazon-apigateway-integration"] = new Dictionary<string, object?>
                        {
                            ["httpMethod"] = "GET",
                            ["payloadFormatVersion"] = "1.0",
                            ["type"] = "HTTP_PROXY",
                            ["uri"] = "https://ip-ranges.amazonaws.com/ip-ranges.json",
                        },
                    },
                },
            },
        }),
    });

    var exampleDeployment = new Aws.ApiGateway.Deployment("exampleDeployment", new()
    {
        RestApi = exampleRestApi.Id,
        Triggers = 
        {
            { "redeployment", exampleRestApi.Body.Apply(body => JsonSerializer.Serialize(body)).Apply(toJSON => ComputeSHA1(toJSON)) },
        },
    });

    var exampleStage = new Aws.ApiGateway.Stage("exampleStage", new()
    {
        Deployment = exampleDeployment.Id,
        RestApi = exampleRestApi.Id,
        StageName = "example",
    });

    var exampleWebAcl = new Aws.WafV2.WebAcl("exampleWebAcl", new()
    {
        Scope = "REGIONAL",
        DefaultAction = new Aws.WafV2.Inputs.WebAclDefaultActionArgs
        {
            Allow = ,
        },
        VisibilityConfig = new Aws.WafV2.Inputs.WebAclVisibilityConfigArgs
        {
            CloudwatchMetricsEnabled = false,
            MetricName = "friendly-metric-name",
            SampledRequestsEnabled = false,
        },
    });

    var exampleWebAclAssociation = new Aws.WafV2.WebAclAssociation("exampleWebAclAssociation", new()
    {
        ResourceArn = exampleStage.Arn,
        WebAclArn = exampleWebAcl.Arn,
    });

});
```

</details>

<details>

<summary>go</summary>

```go
package main

import (
	"crypto/sha1"
	"encoding/json"
	"fmt"

	"github.com/pulumi/pulumi-aws/sdk/v5/go/aws/apigateway"
	"github.com/pulumi/pulumi-aws/sdk/v5/go/aws/wafv2"
	"github.com/pulumi/pulumi/sdk/v3/go/pulumi"
)

func sha1Hash(input string) string {
	hash := sha1.Sum([]byte(input))
	return hex.EncodeToString(hash[:])
}

func main() {
	pulumi.Run(func(ctx *pulumi.Context) error {
		tmpJSON0, err := json.Marshal(map[string]interface{}{
			"openapi": "3.0.1",
			"info": map[string]interface{}{
				"title":   "example",
				"version": "1.0",
			},
			"paths": map[string]interface{}{
				"/path1": map[string]interface{}{
					"get": map[string]interface{}{
						"x-amazon-apigateway-integration": map[string]interface{}{
							"httpMethod":           "GET",
							"payloadFormatVersion": "1.0",
							"type":                 "HTTP_PROXY",
							"uri":                  "https://ip-ranges.amazonaws.com/ip-ranges.json",
						},
					},
				},
			},
		})
		if err != nil {
			return err
		}
		json0 := string(tmpJSON0)
		exampleRestApi, err := apigateway.NewRestApi(ctx, "exampleRestApi", &apigateway.RestApiArgs{
			Body: pulumi.String(json0),
		})
		if err != nil {
			return err
		}
		exampleDeployment, err := apigateway.NewDeployment(ctx, "exampleDeployment", &apigateway.DeploymentArgs{
			RestApi: exampleRestApi.ID(),
			Triggers: pulumi.StringMap{
				"redeployment": exampleRestApi.Body.ApplyT(func(body string) (pulumi.String, error) {
					var _zero pulumi.String
					tmpJSON1, err := json.Marshal(body)
					if err != nil {
						return _zero, err
					}
					json1 := string(tmpJSON1)
					return json1, nil
				}).(pulumi.StringOutput).ApplyT(func(toJSON string) (pulumi.String, error) {
					return sha1Hash(toJSON), nil
				}).(pulumi.StringOutput),
			},
		})
		if err != nil {
			return err
		}
		exampleStage, err := apigateway.NewStage(ctx, "exampleStage", &apigateway.StageArgs{
			Deployment: exampleDeployment.ID(),
			RestApi:    exampleRestApi.ID(),
			StageName:  pulumi.String("example"),
		})
		if err != nil {
			return err
		}
		exampleWebAcl, err := wafv2.NewWebAcl(ctx, "exampleWebAcl", &wafv2.WebAclArgs{
			Scope: pulumi.String("REGIONAL"),
			DefaultAction: &wafv2.WebAclDefaultActionArgs{
				Allow: nil,
			},
			VisibilityConfig: &wafv2.WebAclVisibilityConfigArgs{
				CloudwatchMetricsEnabled: pulumi.Bool(false),
				MetricName:               pulumi.String("friendly-metric-name"),
				SampledRequestsEnabled:   pulumi.Bool(false),
			},
		})
		if err != nil {
			return err
		}
		_, err = wafv2.NewWebAclAssociation(ctx, "exampleWebAclAssociation", &wafv2.WebAclAssociationArgs{
			ResourceArn: exampleStage.Arn,
			WebAclArn:   exampleWebAcl.Arn,
		})
		if err != nil {
			return err
		}
		return nil
	})
}
```

</details>

<details>

<summary>java</summary>

```java
package generated_program;

import com.pulumi.Context;
import com.pulumi.Pulumi;
import com.pulumi.core.Output;
import com.pulumi.aws.apigateway.RestApi;
import com.pulumi.aws.apigateway.RestApiArgs;
import com.pulumi.aws.apigateway.Deployment;
import com.pulumi.aws.apigateway.DeploymentArgs;
import com.pulumi.aws.apigateway.Stage;
import com.pulumi.aws.apigateway.StageArgs;
import com.pulumi.aws.wafv2.WebAcl;
import com.pulumi.aws.wafv2.WebAclArgs;
import com.pulumi.aws.wafv2.inputs.WebAclDefaultActionArgs;
import com.pulumi.aws.wafv2.inputs.WebAclDefaultActionAllowArgs;
import com.pulumi.aws.wafv2.inputs.WebAclVisibilityConfigArgs;
import com.pulumi.aws.wafv2.WebAclAssociation;
import com.pulumi.aws.wafv2.WebAclAssociationArgs;
import static com.pulumi.codegen.internal.Serialization.*;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;

public class App {
    public static void main(String[] args) {
        Pulumi.run(App::stack);
    }

    public static void stack(Context ctx) {
        var exampleRestApi = new RestApi("exampleRestApi", RestApiArgs.builder()        
            .body(serializeJson(
                jsonObject(
                    jsonProperty("openapi", "3.0.1"),
                    jsonProperty("info", jsonObject(
                        jsonProperty("title", "example"),
                        jsonProperty("version", "1.0")
                    )),
                    jsonProperty("paths", jsonObject(
                        jsonProperty("/path1", jsonObject(
                            jsonProperty("get", jsonObject(
                                jsonProperty("x-amazon-apigateway-integration", jsonObject(
                                    jsonProperty("httpMethod", "GET"),
                                    jsonProperty("payloadFormatVersion", "1.0"),
                                    jsonProperty("type", "HTTP_PROXY"),
                                    jsonProperty("uri", "https://ip-ranges.amazonaws.com/ip-ranges.json")
                                ))
                            ))
                        ))
                    ))
                )))
            .build());

        var exampleDeployment = new Deployment("exampleDeployment", DeploymentArgs.builder()        
            .restApi(exampleRestApi.id())
            .triggers(Map.of("redeployment", exampleRestApi.body().applyValue(body -> serializeJson(
                body)).applyValue(toJSON -> computeSHA1(toJSON))))
            .build());

        var exampleStage = new Stage("exampleStage", StageArgs.builder()        
            .deployment(exampleDeployment.id())
            .restApi(exampleRestApi.id())
            .stageName("example")
            .build());

        var exampleWebAcl = new WebAcl("exampleWebAcl", WebAclArgs.builder()        
            .scope("REGIONAL")
            .defaultAction(WebAclDefaultActionArgs.builder()
                .allow()
                .build())
            .visibilityConfig(WebAclVisibilityConfigArgs.builder()
                .cloudwatchMetricsEnabled(false)
                .metricName("friendly-metric-name")
                .sampledRequestsEnabled(false)
                .build())
            .build());

        var exampleWebAclAssociation = new WebAclAssociation("exampleWebAclAssociation", WebAclAssociationArgs.builder()        
            .resourceArn(exampleStage.arn())
            .webAclArn(exampleWebAcl.arn())
            .build());

    }
}
```

</details>

<details>

<summary>typescript</summary>

```typescript
import * as pulumi from "@pulumi/pulumi";
import * as aws from "@pulumi/aws";
import * as crypto from "crypto";

const exampleRestApi = new aws.apigateway.RestApi("exampleRestApi", {body: JSON.stringify({
    openapi: "3.0.1",
    info: {
        title: "example",
        version: "1.0",
    },
    paths: {
        "/path1": {
            get: {
                "x-amazon-apigateway-integration": {
                    httpMethod: "GET",
                    payloadFormatVersion: "1.0",
                    type: "HTTP_PROXY",
                    uri: "https://ip-ranges.amazonaws.com/ip-ranges.json",
                },
            },
        },
    },
})});
const exampleDeployment = new aws.apigateway.Deployment("exampleDeployment", {
    restApi: exampleRestApi.id,
    triggers: {
        redeployment: exampleRestApi.body.apply(body => JSON.stringify(body)).apply(toJSON => crypto.createHash('sha1').update(toJSON).digest('hex')),
    },
});
const exampleStage = new aws.apigateway.Stage("exampleStage", {
    deployment: exampleDeployment.id,
    restApi: exampleRestApi.id,
    stageName: "example",
});
const exampleWebAcl = new aws.wafv2.WebAcl("exampleWebAcl", {
    scope: "REGIONAL",
    defaultAction: {
        allow: {},
    },
    visibilityConfig: {
        cloudwatchMetricsEnabled: false,
        metricName: "friendly-metric-name",
        sampledRequestsEnabled: false,
    },
});
const exampleWebAclAssociation = new aws.wafv2.WebAclAssociation("exampleWebAclAssociation", {
    resourceArn: exampleStage.arn,
    webAclArn: exampleWebAcl.arn,
});
```

</details>

## [**complete failure**] Basic usage

### HCL

```terraform
data "aws_caller_identity" "current" {}

data "aws_iam_policy_document" "example" {
  statement {
    sid       = "AddPermModelPackageGroup"
    actions   = ["sagemaker:DescribeModelPackage", "sagemaker:ListModelPackages"]
    resources = [aws_sagemaker_model_package_group.example.arn]
    principals {
      identifiers = [data.aws_caller_identity.current.account_id]
      type        = "AWS"
    }
  }
}

resource "aws_sagemaker_model_package_group" "example" {
  model_package_group_name = "example"
}

resource "aws_sagemaker_model_package_group_policy" "example" {
  model_package_group_name = aws_sagemaker_model_package_group.example.model_package_group_name
  resource_policy          = jsonencode(jsondecode(data.aws_iam_policy_document.example.json))
}

```

### Failed Languages

#### python

```text
:20,41-51: unknown function 'jsondecode'; , and 1 other diagnostic(s)
```

#### csharp

```text
:20,41-51: unknown function 'jsondecode'; , and 1 other diagnostic(s)
```

#### go

```text
:20,41-51: unknown function 'jsondecode'; , and 1 other diagnostic(s)
```

#### yaml

```text
:20,41-51: unknown function 'jsondecode'; , and 1 other diagnostic(s)
```

#### java

```text
:20,41-51: unknown function 'jsondecode'; , and 1 other diagnostic(s)
```

#### typescript

```text
:20,41-51: unknown function 'jsondecode'; , and 1 other diagnostic(s)
```

## [*partial failure*] Existing Public Key Import

### HCL

```terraform
resource "aws_lightsail_key_pair" "lg_key_pair" {
  name       = "importing"
  public_key = file("~/.ssh/id_rsa.pub")
}

```

### Failed Languages

#### yaml

```text
.pp:1,15-44: Failed to generate YAML program: Unknown Function; YAML does not support Fn::readFile.
```

### Successes

<details>

<summary>typescript</summary>

```typescript
import * as pulumi from "@pulumi/pulumi";
import * as aws from "@pulumi/aws";
import * as fs from "fs";

const lgKeyPair = new aws.lightsail.KeyPair("lgKeyPair", {publicKey: fs.readFileSync("~/.ssh/id_rsa.pub")});
```

</details>

<details>

<summary>python</summary>

```python
import pulumi
import pulumi_aws as aws

lg_key_pair = aws.lightsail.KeyPair("lgKeyPair", public_key=(lambda path: open(path).read())("~/.ssh/id_rsa.pub"))
```

</details>

<details>

<summary>csharp</summary>

```csharp
using System.Collections.Generic;
using System.IO;
using Pulumi;
using Aws = Pulumi.Aws;

return await Deployment.RunAsync(() => 
{
    var lgKeyPair = new Aws.LightSail.KeyPair("lgKeyPair", new()
    {
        PublicKey = File.ReadAllText("~/.ssh/id_rsa.pub"),
    });

});
```

</details>

<details>

<summary>go</summary>

```go
package main

import (
	"io/ioutil"

	"github.com/pulumi/pulumi-aws/sdk/v5/go/aws/lightsail"
	"github.com/pulumi/pulumi/sdk/v3/go/pulumi"
)

func readFileOrPanic(path string) pulumi.StringPtrInput {
	data, err := ioutil.ReadFile(path)
	if err != nil {
		panic(err.Error())
	}
	return pulumi.String(string(data))
}

func main() {
	pulumi.Run(func(ctx *pulumi.Context) error {
		_, err := lightsail.NewKeyPair(ctx, "lgKeyPair", &lightsail.KeyPairArgs{
			PublicKey: readFileOrPanic("~/.ssh/id_rsa.pub"),
		})
		if err != nil {
			return err
		}
		return nil
	})
}
```

</details>

<details>

<summary>java</summary>

```java
package generated_program;

import com.pulumi.Context;
import com.pulumi.Pulumi;
import com.pulumi.core.Output;
import com.pulumi.aws.lightsail.KeyPair;
import com.pulumi.aws.lightsail.KeyPairArgs;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;

public class App {
    public static void main(String[] args) {
        Pulumi.run(App::stack);
    }

    public static void stack(Context ctx) {
        var lgKeyPair = new KeyPair("lgKeyPair", KeyPairArgs.builder()        
            .publicKey(Files.readString(Paths.get("~/.ssh/id_rsa.pub")))
            .build());

    }
}
```

</details>

## [*partial failure*] OpenAPI Specification

### HCL

```terraform
resource "aws_api_gateway_rest_api" "example" {
  body = jsonencode({
    openapi = "3.0.1"
    info = {
      title   = "example"
      version = "1.0"
    }
    paths = {
      "/path1" = {
        get = {
          x-amazon-apigateway-integration = {
            httpMethod           = "GET"
            payloadFormatVersion = "1.0"
            type                 = "HTTP_PROXY"
            uri                  = "https://ip-ranges.amazonaws.com/ip-ranges.json"
          }
        }
      }
    }
  })

  name = "example"
}

resource "aws_api_gateway_deployment" "example" {
  rest_api_id = aws_api_gateway_rest_api.example.id

  triggers = {
    redeployment = sha1(jsonencode(aws_api_gateway_rest_api.example.body))
  }

  lifecycle {
    create_before_destroy = true
  }
}

resource "aws_api_gateway_stage" "example" {
  deployment_id = aws_api_gateway_deployment.example.id
  rest_api_id   = aws_api_gateway_rest_api.example.id
  stage_name    = "example"
}

```

### Failed Languages

#### yaml

```text
.pp:24,20-53: Failed to generate YAML program: Unknown Function; YAML does not support Fn::sha1.
```

### Successes

<details>

<summary>java</summary>

```java
package generated_program;

import com.pulumi.Context;
import com.pulumi.Pulumi;
import com.pulumi.core.Output;
import com.pulumi.aws.apigateway.RestApi;
import com.pulumi.aws.apigateway.RestApiArgs;
import com.pulumi.aws.apigateway.Deployment;
import com.pulumi.aws.apigateway.DeploymentArgs;
import com.pulumi.aws.apigateway.Stage;
import com.pulumi.aws.apigateway.StageArgs;
import static com.pulumi.codegen.internal.Serialization.*;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;

public class App {
    public static void main(String[] args) {
        Pulumi.run(App::stack);
    }

    public static void stack(Context ctx) {
        var exampleRestApi = new RestApi("exampleRestApi", RestApiArgs.builder()        
            .body(serializeJson(
                jsonObject(
                    jsonProperty("openapi", "3.0.1"),
                    jsonProperty("info", jsonObject(
                        jsonProperty("title", "example"),
                        jsonProperty("version", "1.0")
                    )),
                    jsonProperty("paths", jsonObject(
                        jsonProperty("/path1", jsonObject(
                            jsonProperty("get", jsonObject(
                                jsonProperty("x-amazon-apigateway-integration", jsonObject(
                                    jsonProperty("httpMethod", "GET"),
                                    jsonProperty("payloadFormatVersion", "1.0"),
                                    jsonProperty("type", "HTTP_PROXY"),
                                    jsonProperty("uri", "https://ip-ranges.amazonaws.com/ip-ranges.json")
                                ))
                            ))
                        ))
                    ))
                )))
            .build());

        var exampleDeployment = new Deployment("exampleDeployment", DeploymentArgs.builder()        
            .restApi(exampleRestApi.id())
            .triggers(Map.of("redeployment", exampleRestApi.body().applyValue(body -> serializeJson(
                body)).applyValue(toJSON -> computeSHA1(toJSON))))
            .build());

        var exampleStage = new Stage("exampleStage", StageArgs.builder()        
            .deployment(exampleDeployment.id())
            .restApi(exampleRestApi.id())
            .stageName("example")
            .build());

    }
}
```

</details>

<details>

<summary>typescript</summary>

```typescript
import * as pulumi from "@pulumi/pulumi";
import * as aws from "@pulumi/aws";
import * as crypto from "crypto";

const exampleRestApi = new aws.apigateway.RestApi("exampleRestApi", {body: JSON.stringify({
    openapi: "3.0.1",
    info: {
        title: "example",
        version: "1.0",
    },
    paths: {
        "/path1": {
            get: {
                "x-amazon-apigateway-integration": {
                    httpMethod: "GET",
                    payloadFormatVersion: "1.0",
                    type: "HTTP_PROXY",
                    uri: "https://ip-ranges.amazonaws.com/ip-ranges.json",
                },
            },
        },
    },
})});
const exampleDeployment = new aws.apigateway.Deployment("exampleDeployment", {
    restApi: exampleRestApi.id,
    triggers: {
        redeployment: exampleRestApi.body.apply(body => JSON.stringify(body)).apply(toJSON => crypto.createHash('sha1').update(toJSON).digest('hex')),
    },
});
const exampleStage = new aws.apigateway.Stage("exampleStage", {
    deployment: exampleDeployment.id,
    restApi: exampleRestApi.id,
    stageName: "example",
});
```

</details>

<details>

<summary>python</summary>

```python
import pulumi
import hashlib
import json
import pulumi_aws as aws

example_rest_api = aws.apigateway.RestApi("exampleRestApi", body=json.dumps({
    "openapi": "3.0.1",
    "info": {
        "title": "example",
        "version": "1.0",
    },
    "paths": {
        "/path1": {
            "get": {
                "x-amazon-apigateway-integration": {
                    "httpMethod": "GET",
                    "payloadFormatVersion": "1.0",
                    "type": "HTTP_PROXY",
                    "uri": "https://ip-ranges.amazonaws.com/ip-ranges.json",
                },
            },
        },
    },
}))
example_deployment = aws.apigateway.Deployment("exampleDeployment",
    rest_api=example_rest_api.id,
    triggers={
        "redeployment": example_rest_api.body.apply(lambda body: json.dumps(body)).apply(lambda to_json: hashlib.sha1(to_json.encode()).hexdigest()),
    })
example_stage = aws.apigateway.Stage("exampleStage",
    deployment=example_deployment.id,
    rest_api=example_rest_api.id,
    stage_name="example")
```

</details>

<details>

<summary>csharp</summary>

```csharp
using System.Collections.Generic;
using System.Security.Cryptography;
using System.Text;
using System.Text.Json;
using Pulumi;
using Aws = Pulumi.Aws;

	private static string ComputeSHA1(string input) {
		return BitConverter.ToString(
			SHA1.Create().ComputeHash(Encoding.UTF8.GetBytes(input))
		).Replace("-","").ToLowerInvariant());
	}

return await Deployment.RunAsync(() => 
{
    var exampleRestApi = new Aws.ApiGateway.RestApi("exampleRestApi", new()
    {
        Body = JsonSerializer.Serialize(new Dictionary<string, object?>
        {
            ["openapi"] = "3.0.1",
            ["info"] = new Dictionary<string, object?>
            {
                ["title"] = "example",
                ["version"] = "1.0",
            },
            ["paths"] = new Dictionary<string, object?>
            {
                ["/path1"] = new Dictionary<string, object?>
                {
                    ["get"] = new Dictionary<string, object?>
                    {
                        ["x-amazon-apigateway-integration"] = new Dictionary<string, object?>
                        {
                            ["httpMethod"] = "GET",
                            ["payloadFormatVersion"] = "1.0",
                            ["type"] = "HTTP_PROXY",
                            ["uri"] = "https://ip-ranges.amazonaws.com/ip-ranges.json",
                        },
                    },
                },
            },
        }),
    });

    var exampleDeployment = new Aws.ApiGateway.Deployment("exampleDeployment", new()
    {
        RestApi = exampleRestApi.Id,
        Triggers = 
        {
            { "redeployment", exampleRestApi.Body.Apply(body => JsonSerializer.Serialize(body)).Apply(toJSON => ComputeSHA1(toJSON)) },
        },
    });

    var exampleStage = new Aws.ApiGateway.Stage("exampleStage", new()
    {
        Deployment = exampleDeployment.Id,
        RestApi = exampleRestApi.Id,
        StageName = "example",
    });

});
```

</details>

<details>

<summary>go</summary>

```go
package main

import (
	"crypto/sha1"
	"encoding/json"
	"fmt"

	"github.com/pulumi/pulumi-aws/sdk/v5/go/aws/apigateway"
	"github.com/pulumi/pulumi/sdk/v3/go/pulumi"
)

func sha1Hash(input string) string {
	hash := sha1.Sum([]byte(input))
	return hex.EncodeToString(hash[:])
}

func main() {
	pulumi.Run(func(ctx *pulumi.Context) error {
		tmpJSON0, err := json.Marshal(map[string]interface{}{
			"openapi": "3.0.1",
			"info": map[string]interface{}{
				"title":   "example",
				"version": "1.0",
			},
			"paths": map[string]interface{}{
				"/path1": map[string]interface{}{
					"get": map[string]interface{}{
						"x-amazon-apigateway-integration": map[string]interface{}{
							"httpMethod":           "GET",
							"payloadFormatVersion": "1.0",
							"type":                 "HTTP_PROXY",
							"uri":                  "https://ip-ranges.amazonaws.com/ip-ranges.json",
						},
					},
				},
			},
		})
		if err != nil {
			return err
		}
		json0 := string(tmpJSON0)
		exampleRestApi, err := apigateway.NewRestApi(ctx, "exampleRestApi", &apigateway.RestApiArgs{
			Body: pulumi.String(json0),
		})
		if err != nil {
			return err
		}
		exampleDeployment, err := apigateway.NewDeployment(ctx, "exampleDeployment", &apigateway.DeploymentArgs{
			RestApi: exampleRestApi.ID(),
			Triggers: pulumi.StringMap{
				"redeployment": exampleRestApi.Body.ApplyT(func(body string) (pulumi.String, error) {
					var _zero pulumi.String
					tmpJSON1, err := json.Marshal(body)
					if err != nil {
						return _zero, err
					}
					json1 := string(tmpJSON1)
					return json1, nil
				}).(pulumi.StringOutput).ApplyT(func(toJSON string) (pulumi.String, error) {
					return sha1Hash(toJSON), nil
				}).(pulumi.StringOutput),
			},
		})
		if err != nil {
			return err
		}
		_, err = apigateway.NewStage(ctx, "exampleStage", &apigateway.StageArgs{
			Deployment: exampleDeployment.ID(),
			RestApi:    exampleRestApi.ID(),
			StageName:  pulumi.String("example"),
		})
		if err != nil {
			return err
		}
		return nil
	})
}
```

</details>

## [*partial failure*] Resources

### HCL

```terraform
resource "aws_api_gateway_rest_api" "example" {
  name = "example"
}

resource "aws_api_gateway_resource" "example" {
  parent_id   = aws_api_gateway_rest_api.example.root_resource_id
  path_part   = "example"
  rest_api_id = aws_api_gateway_rest_api.example.id
}

resource "aws_api_gateway_method" "example" {
  authorization = "NONE"
  http_method   = "GET"
  resource_id   = aws_api_gateway_resource.example.id
  rest_api_id   = aws_api_gateway_rest_api.example.id
}

resource "aws_api_gateway_integration" "example" {
  http_method = aws_api_gateway_method.example.http_method
  resource_id = aws_api_gateway_resource.example.id
  rest_api_id = aws_api_gateway_rest_api.example.id
  type        = "MOCK"
}

resource "aws_api_gateway_deployment" "example" {
  rest_api_id = aws_api_gateway_rest_api.example.id

  triggers = {
    # NOTE: The configuration below will satisfy ordering considerations,
    #       but not pick up all future REST API changes. More advanced patterns
    #       are possible, such as using the filesha1() function against the
    #       configuration file(s) or removing the .id references to
    #       calculate a hash against whole resources. Be aware that using whole
    #       resources will show a difference after the initial implementation.
    #       It will stabilize to only change when resources change afterwards.
    redeployment = sha1(jsonencode([
      aws_api_gateway_resource.example.id,
      aws_api_gateway_method.example.id,
      aws_api_gateway_integration.example.id,
    ]))
  }

  lifecycle {
    create_before_destroy = true
  }
}

resource "aws_api_gateway_stage" "example" {
  deployment_id = aws_api_gateway_deployment.example.id
  rest_api_id   = aws_api_gateway_rest_api.example.id
  stage_name    = "example"
}

```

### Failed Languages

#### yaml

```text
.pp:29,20-32,35: Failed to generate YAML program: Unknown Function; YAML does not support Fn::sha1.
```

### Successes

<details>

<summary>typescript</summary>

```typescript
import * as pulumi from "@pulumi/pulumi";
import * as aws from "@pulumi/aws";
import * as crypto from "crypto";

const exampleRestApi = new aws.apigateway.RestApi("exampleRestApi", {});
const exampleResource = new aws.apigateway.Resource("exampleResource", {
    parentId: exampleRestApi.rootResourceId,
    pathPart: "example",
    restApi: exampleRestApi.id,
});
const exampleMethod = new aws.apigateway.Method("exampleMethod", {
    authorization: "NONE",
    httpMethod: "GET",
    resourceId: exampleResource.id,
    restApi: exampleRestApi.id,
});
const exampleIntegration = new aws.apigateway.Integration("exampleIntegration", {
    httpMethod: exampleMethod.httpMethod,
    resourceId: exampleResource.id,
    restApi: exampleRestApi.id,
    type: "MOCK",
});
const exampleDeployment = new aws.apigateway.Deployment("exampleDeployment", {
    restApi: exampleRestApi.id,
    triggers: {
        redeployment: pulumi.all([exampleResource.id, exampleMethod.id, exampleIntegration.id]).apply(([exampleResourceId, exampleMethodId, exampleIntegrationId]) => JSON.stringify([
            exampleResourceId,
            exampleMethodId,
            exampleIntegrationId,
        ])).apply(toJSON => crypto.createHash('sha1').update(toJSON).digest('hex')),
    },
});
const exampleStage = new aws.apigateway.Stage("exampleStage", {
    deployment: exampleDeployment.id,
    restApi: exampleRestApi.id,
    stageName: "example",
});
```

</details>

<details>

<summary>python</summary>

```python
import pulumi
import hashlib
import json
import pulumi_aws as aws

example_rest_api = aws.apigateway.RestApi("exampleRestApi")
example_resource = aws.apigateway.Resource("exampleResource",
    parent_id=example_rest_api.root_resource_id,
    path_part="example",
    rest_api=example_rest_api.id)
example_method = aws.apigateway.Method("exampleMethod",
    authorization="NONE",
    http_method="GET",
    resource_id=example_resource.id,
    rest_api=example_rest_api.id)
example_integration = aws.apigateway.Integration("exampleIntegration",
    http_method=example_method.http_method,
    resource_id=example_resource.id,
    rest_api=example_rest_api.id,
    type="MOCK")
example_deployment = aws.apigateway.Deployment("exampleDeployment",
    rest_api=example_rest_api.id,
    triggers={
        "redeployment": pulumi.Output.all(example_resource.id, example_method.id, example_integration.id).apply(lambda exampleResourceId, exampleMethodId, exampleIntegrationId: json.dumps([
            example_resource_id,
            example_method_id,
            example_integration_id,
        ])).apply(lambda to_json: hashlib.sha1(to_json.encode()).hexdigest()),
    })
example_stage = aws.apigateway.Stage("exampleStage",
    deployment=example_deployment.id,
    rest_api=example_rest_api.id,
    stage_name="example")
```

</details>

<details>

<summary>csharp</summary>

```csharp
using System.Collections.Generic;
using System.Security.Cryptography;
using System.Text;
using System.Text.Json;
using Pulumi;
using Aws = Pulumi.Aws;

	private static string ComputeSHA1(string input) {
		return BitConverter.ToString(
			SHA1.Create().ComputeHash(Encoding.UTF8.GetBytes(input))
		).Replace("-","").ToLowerInvariant());
	}

return await Deployment.RunAsync(() => 
{
    var exampleRestApi = new Aws.ApiGateway.RestApi("exampleRestApi");

    var exampleResource = new Aws.ApiGateway.Resource("exampleResource", new()
    {
        ParentId = exampleRestApi.RootResourceId,
        PathPart = "example",
        RestApi = exampleRestApi.Id,
    });

    var exampleMethod = new Aws.ApiGateway.Method("exampleMethod", new()
    {
        Authorization = "NONE",
        HttpMethod = "GET",
        ResourceId = exampleResource.Id,
        RestApi = exampleRestApi.Id,
    });

    var exampleIntegration = new Aws.ApiGateway.Integration("exampleIntegration", new()
    {
        HttpMethod = exampleMethod.HttpMethod,
        ResourceId = exampleResource.Id,
        RestApi = exampleRestApi.Id,
        Type = "MOCK",
    });

    var exampleDeployment = new Aws.ApiGateway.Deployment("exampleDeployment", new()
    {
        RestApi = exampleRestApi.Id,
        Triggers = 
        {
            { "redeployment", Output.Tuple(exampleResource.Id, exampleMethod.Id, exampleIntegration.Id).Apply(values =>
            {
                var exampleResourceId = values.Item1;
                var exampleMethodId = values.Item2;
                var exampleIntegrationId = values.Item3;
                return JsonSerializer.Serialize(new[]
                {
                    exampleResourceId,
                    exampleMethodId,
                    exampleIntegrationId,
                });
            }).Apply(toJSON => ComputeSHA1(toJSON)) },
        },
    });

    var exampleStage = new Aws.ApiGateway.Stage("exampleStage", new()
    {
        Deployment = exampleDeployment.Id,
        RestApi = exampleRestApi.Id,
        StageName = "example",
    });

});
```

</details>

<details>

<summary>go</summary>

```go
package main

import (
	"crypto/sha1"
	"encoding/json"
	"fmt"

	"github.com/pulumi/pulumi-aws/sdk/v5/go/aws/apigateway"
	"github.com/pulumi/pulumi/sdk/v3/go/pulumi"
)

func sha1Hash(input string) string {
	hash := sha1.Sum([]byte(input))
	return hex.EncodeToString(hash[:])
}

func main() {
	pulumi.Run(func(ctx *pulumi.Context) error {
		exampleRestApi, err := apigateway.NewRestApi(ctx, "exampleRestApi", nil)
		if err != nil {
			return err
		}
		exampleResource, err := apigateway.NewResource(ctx, "exampleResource", &apigateway.ResourceArgs{
			ParentId: exampleRestApi.RootResourceId,
			PathPart: pulumi.String("example"),
			RestApi:  exampleRestApi.ID(),
		})
		if err != nil {
			return err
		}
		exampleMethod, err := apigateway.NewMethod(ctx, "exampleMethod", &apigateway.MethodArgs{
			Authorization: pulumi.String("NONE"),
			HttpMethod:    pulumi.String("GET"),
			ResourceId:    exampleResource.ID(),
			RestApi:       exampleRestApi.ID(),
		})
		if err != nil {
			return err
		}
		exampleIntegration, err := apigateway.NewIntegration(ctx, "exampleIntegration", &apigateway.IntegrationArgs{
			HttpMethod: exampleMethod.HttpMethod,
			ResourceId: exampleResource.ID(),
			RestApi:    exampleRestApi.ID(),
			Type:       pulumi.String("MOCK"),
		})
		if err != nil {
			return err
		}
		exampleDeployment, err := apigateway.NewDeployment(ctx, "exampleDeployment", &apigateway.DeploymentArgs{
			RestApi: exampleRestApi.ID(),
			Triggers: pulumi.StringMap{
				"redeployment": pulumi.All(exampleResource.ID(), exampleMethod.ID(), exampleIntegration.ID()).ApplyT(func(_args []interface{}) (string, error) {
					exampleResourceId := _args[0].(string)
					exampleMethodId := _args[1].(string)
					exampleIntegrationId := _args[2].(string)
					var _zero string
					tmpJSON0, err := json.Marshal([]string{
						exampleResourceId,
						exampleMethodId,
						exampleIntegrationId,
					})
					if err != nil {
						return _zero, err
					}
					json0 := string(tmpJSON0)
					return json0, nil
				}).(pulumi.StringOutput).ApplyT(func(toJSON string) (pulumi.String, error) {
					return sha1Hash(toJSON), nil
				}).(pulumi.StringOutput),
			},
		})
		if err != nil {
			return err
		}
		_, err = apigateway.NewStage(ctx, "exampleStage", &apigateway.StageArgs{
			Deployment: exampleDeployment.ID(),
			RestApi:    exampleRestApi.ID(),
			StageName:  pulumi.String("example"),
		})
		if err != nil {
			return err
		}
		return nil
	})
}
```

</details>

<details>

<summary>java</summary>

```java
package generated_program;

import com.pulumi.Context;
import com.pulumi.Pulumi;
import com.pulumi.core.Output;
import com.pulumi.aws.apigateway.RestApi;
import com.pulumi.aws.apigateway.Resource;
import com.pulumi.aws.apigateway.ResourceArgs;
import com.pulumi.aws.apigateway.Method;
import com.pulumi.aws.apigateway.MethodArgs;
import com.pulumi.aws.apigateway.Integration;
import com.pulumi.aws.apigateway.IntegrationArgs;
import com.pulumi.aws.apigateway.Deployment;
import com.pulumi.aws.apigateway.DeploymentArgs;
import com.pulumi.aws.apigateway.Stage;
import com.pulumi.aws.apigateway.StageArgs;
import static com.pulumi.codegen.internal.Serialization.*;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;

public class App {
    public static void main(String[] args) {
        Pulumi.run(App::stack);
    }

    public static void stack(Context ctx) {
        var exampleRestApi = new RestApi("exampleRestApi");

        var exampleResource = new Resource("exampleResource", ResourceArgs.builder()        
            .parentId(exampleRestApi.rootResourceId())
            .pathPart("example")
            .restApi(exampleRestApi.id())
            .build());

        var exampleMethod = new Method("exampleMethod", MethodArgs.builder()        
            .authorization("NONE")
            .httpMethod("GET")
            .resourceId(exampleResource.id())
            .restApi(exampleRestApi.id())
            .build());

        var exampleIntegration = new Integration("exampleIntegration", IntegrationArgs.builder()        
            .httpMethod(exampleMethod.httpMethod())
            .resourceId(exampleResource.id())
            .restApi(exampleRestApi.id())
            .type("MOCK")
            .build());

        var exampleDeployment = new Deployment("exampleDeployment", DeploymentArgs.builder()        
            .restApi(exampleRestApi.id())
            .triggers(Map.of("redeployment", Output.tuple(exampleResource.id(), exampleMethod.id(), exampleIntegration.id()).applyValue(values -> {
                var exampleResourceId = values.t1;
                var exampleMethodId = values.t2;
                var exampleIntegrationId = values.t3;
                return serializeJson(
                    jsonArray(
                        exampleResourceId, 
                        exampleMethodId, 
                        exampleIntegrationId
                    ));
            }).applyValue(toJSON -> computeSHA1(toJSON))))
            .build());

        var exampleStage = new Stage("exampleStage", StageArgs.builder()        
            .deployment(exampleDeployment.id())
            .restApi(exampleRestApi.id())
            .stageName("example")
            .build());

    }
}
```

</details>

## [*partial failure*] Basic Usage

### HCL

```terraform
resource "aws_lightsail_container_service_deployment_version" "example" {
  container {
    container_name = "hello-world"
    image          = "amazon/amazon-lightsail:hello-world"

    command = []

    environment = {
      MY_ENVIRONMENT_VARIABLE = "my_value"
    }

    ports = {
      80 = "HTTP"
    }
  }

  public_endpoint {
    container_name = "hello-world"
    container_port = 80

    health_check {
      healthy_threshold   = 2
      unhealthy_threshold = 2
      timeout_seconds     = 2
      interval_seconds    = 5
      path                = "/"
      success_codes       = "200-499"
    }
  }

  service_name = aws_lightsail_container_service.example.name
}

```

### Failed Languages

#### yaml

```text
failed to convert HCL for #/resources/aws:lightsail/containerServiceDeploymentVersion:ContainerServiceDeploymentVersion to yaml: panic converting HCL: interface conversion: syntax.Node is *syntax.NumberNode, not *syntax.StringNode
```

### Successes

<details>

<summary>typescript</summary>

```typescript
import * as pulumi from "@pulumi/pulumi";
import * as aws from "@pulumi/aws";

const example = new aws.lightsail.ContainerServiceDeploymentVersion("example", {
    containers: [{
        containerName: "hello-world",
        image: "amazon/amazon-lightsail:hello-world",
        commands: [],
        environment: {
            MY_ENVIRONMENT_VARIABLE: "my_value",
        },
        ports: {
            "80": "HTTP",
        },
    }],
    publicEndpoint: {
        containerName: "hello-world",
        containerPort: 80,
        healthCheck: {
            healthyThreshold: 2,
            unhealthyThreshold: 2,
            timeoutSeconds: 2,
            intervalSeconds: 5,
            path: "/",
            successCodes: "200-499",
        },
    },
    serviceName: aws_lightsail_container_service.example.name,
});
```

</details>

<details>

<summary>python</summary>

```python
import pulumi
import pulumi_aws as aws

example = aws.lightsail.ContainerServiceDeploymentVersion("example",
    containers=[aws.lightsail.ContainerServiceDeploymentVersionContainerArgs(
        container_name="hello-world",
        image="amazon/amazon-lightsail:hello-world",
        commands=[],
        environment={
            "MY_ENVIRONMENT_VARIABLE": "my_value",
        },
        ports={
            "80": "HTTP",
        },
    )],
    public_endpoint=aws.lightsail.ContainerServiceDeploymentVersionPublicEndpointArgs(
        container_name="hello-world",
        container_port=80,
        health_check=aws.lightsail.ContainerServiceDeploymentVersionPublicEndpointHealthCheckArgs(
            healthy_threshold=2,
            unhealthy_threshold=2,
            timeout_seconds=2,
            interval_seconds=5,
            path="/",
            success_codes="200-499",
        ),
    ),
    service_name=aws_lightsail_container_service["example"]["name"])
```

</details>

<details>

<summary>csharp</summary>

```csharp
using System.Collections.Generic;
using Pulumi;
using Aws = Pulumi.Aws;

return await Deployment.RunAsync(() => 
{
    var example = new Aws.LightSail.ContainerServiceDeploymentVersion("example", new()
    {
        Containers = new[]
        {
            new Aws.LightSail.Inputs.ContainerServiceDeploymentVersionContainerArgs
            {
                ContainerName = "hello-world",
                Image = "amazon/amazon-lightsail:hello-world",
                Commands = new[] {},
                Environment = 
                {
                    { "MY_ENVIRONMENT_VARIABLE", "my_value" },
                },
                Ports = 
                {
                    { "80", "HTTP" },
                },
            },
        },
        PublicEndpoint = new Aws.LightSail.Inputs.ContainerServiceDeploymentVersionPublicEndpointArgs
        {
            ContainerName = "hello-world",
            ContainerPort = 80,
            HealthCheck = new Aws.LightSail.Inputs.ContainerServiceDeploymentVersionPublicEndpointHealthCheckArgs
            {
                HealthyThreshold = 2,
                UnhealthyThreshold = 2,
                TimeoutSeconds = 2,
                IntervalSeconds = 5,
                Path = "/",
                SuccessCodes = "200-499",
            },
        },
        ServiceName = aws_lightsail_container_service.Example.Name,
    });

});
```

</details>

<details>

<summary>go</summary>

```go
package main

import (
	"github.com/pulumi/pulumi-aws/sdk/v5/go/aws/lightsail"
	"github.com/pulumi/pulumi/sdk/v3/go/pulumi"
)

func main() {
	pulumi.Run(func(ctx *pulumi.Context) error {
		_, err := lightsail.NewContainerServiceDeploymentVersion(ctx, "example", &lightsail.ContainerServiceDeploymentVersionArgs{
			Containers: lightsail.ContainerServiceDeploymentVersionContainerArray{
				&lightsail.ContainerServiceDeploymentVersionContainerArgs{
					ContainerName: pulumi.String("hello-world"),
					Image:         pulumi.String("amazon/amazon-lightsail:hello-world"),
					Commands:      pulumi.StringArray{},
					Environment: pulumi.StringMap{
						"MY_ENVIRONMENT_VARIABLE": pulumi.String("my_value"),
					},
					Ports: pulumi.StringMap{
						"80": pulumi.String("HTTP"),
					},
				},
			},
			PublicEndpoint: &lightsail.ContainerServiceDeploymentVersionPublicEndpointArgs{
				ContainerName: pulumi.String("hello-world"),
				ContainerPort: pulumi.Int(80),
				HealthCheck: &lightsail.ContainerServiceDeploymentVersionPublicEndpointHealthCheckArgs{
					HealthyThreshold:   pulumi.Int(2),
					UnhealthyThreshold: pulumi.Int(2),
					TimeoutSeconds:     pulumi.Int(2),
					IntervalSeconds:    pulumi.Int(5),
					Path:               pulumi.String("/"),
					SuccessCodes:       pulumi.String("200-499"),
				},
			},
			ServiceName: pulumi.Any(aws_lightsail_container_service.Example.Name),
		})
		if err != nil {
			return err
		}
		return nil
	})
}
```

</details>

<details>

<summary>java</summary>

```java
package generated_program;

import com.pulumi.Context;
import com.pulumi.Pulumi;
import com.pulumi.core.Output;
import com.pulumi.aws.lightsail.ContainerServiceDeploymentVersion;
import com.pulumi.aws.lightsail.ContainerServiceDeploymentVersionArgs;
import com.pulumi.aws.lightsail.inputs.ContainerServiceDeploymentVersionContainerArgs;
import com.pulumi.aws.lightsail.inputs.ContainerServiceDeploymentVersionPublicEndpointArgs;
import com.pulumi.aws.lightsail.inputs.ContainerServiceDeploymentVersionPublicEndpointHealthCheckArgs;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;

public class App {
    public static void main(String[] args) {
        Pulumi.run(App::stack);
    }

    public static void stack(Context ctx) {
        var example = new ContainerServiceDeploymentVersion("example", ContainerServiceDeploymentVersionArgs.builder()        
            .containers(ContainerServiceDeploymentVersionContainerArgs.builder()
                .containerName("hello-world")
                .image("amazon/amazon-lightsail:hello-world")
                .commands()
                .environment(Map.of("MY_ENVIRONMENT_VARIABLE", "my_value"))
                .ports(Map.of("80", "HTTP"))
                .build())
            .publicEndpoint(ContainerServiceDeploymentVersionPublicEndpointArgs.builder()
                .containerName("hello-world")
                .containerPort(80)
                .healthCheck(ContainerServiceDeploymentVersionPublicEndpointHealthCheckArgs.builder()
                    .healthyThreshold(2)
                    .unhealthyThreshold(2)
                    .timeoutSeconds(2)
                    .intervalSeconds(5)
                    .path("/")
                    .successCodes("200-499")
                    .build())
                .build())
            .serviceName(aws_lightsail_container_service.example().name())
            .build());

    }
}
```

</details>

## [*partial failure*] #/resources/aws:directoryservice/sharedDirectory:SharedDirectory

### HCL

```terraform
resource "aws_directory_service_directory" "example" {
  name     = "tf-example"
  password = "SuperSecretPassw0rd"
  type     = "MicrosoftAD"
  edition  = "Standard"

  vpc_settings {
    vpc_id     = aws_vpc.example.id
    subnet_ids = aws_subnet.example[*].id
  }
}

resource "aws_directory_service_shared_directory" "example" {
  directory_id = aws_directory_service_directory.example.id
  notes        = "You wanna have a catch?"

  target {
    id = data.aws_caller_identity.receiver.account_id
  }
}

```

### Failed Languages

#### go

```text
failed to convert HCL for #/resources/aws:directoryservice/sharedDirectory:SharedDirectory to go: invalid Go source code:

package main

import (

"github.com/pulumi/pulumi/sdk/v3/go/pulumi"
"github.com/pulumi/pulumi-aws/sdk/v5/go/aws/directoryservice"
)
func main() {
pulumi.Run(func(ctx *pulumi.Context) error {
exampleDirectory, err := directoryservice.NewDirectory(ctx, "exampleDirectory", &directoryservice.DirectoryArgs{
Name: pulumi.String("tf-example"),
Password: pulumi.String("SuperSecretPassw0rd"),
Type: pulumi.String("MicrosoftAD"),
Edition: pulumi.String("Standard"),
VpcSettings: &directoryservice.DirectoryVpcSettingsArgs{
VpcId: pulumi.Any(aws_vpc.Example.Id),
SubnetIds: %!v(PANIC=Format method: fatal: A failure has occurred: unlowered splat expression @ #-resources-aws:directoryservice-sharedDirectory:SharedDirectory.tf.pp:7,17-41),
},
})
if err != nil {
return err
}
_, err = directoryservice.NewSharedDirectory(ctx, "exampleSharedDirectory", &directoryservice.SharedDirectoryArgs{
DirectoryId: exampleDirectory.ID(),
Notes: pulumi.String("You wanna have a catch?"),
Target: &directoryservice.SharedDirectoryTargetArgs{
Id: pulumi.Any(data.Aws_caller_identity.Receiver.Account_id),
},
})
if err != nil {
return err
}
return nil
})
}
: 17:12: expected operand, found '%' (and 10 more errors)
```

#### yaml

```text
.pp:7,17-41: Failed to generate YAML program: Splat; A 'Splat' expression is equivalent in expressive power to a 'for loop', and is not representable in YAML.
If the values of the function are known, you can manually unroll the loop, otherwise it is necessary to switch to a more expressive language.
```

### Successes

<details>

<summary>java</summary>

```java
package generated_program;

import com.pulumi.Context;
import com.pulumi.Pulumi;
import com.pulumi.core.Output;
import com.pulumi.aws.directoryservice.Directory;
import com.pulumi.aws.directoryservice.DirectoryArgs;
import com.pulumi.aws.directoryservice.inputs.DirectoryVpcSettingsArgs;
import com.pulumi.aws.directoryservice.SharedDirectory;
import com.pulumi.aws.directoryservice.SharedDirectoryArgs;
import com.pulumi.aws.directoryservice.inputs.SharedDirectoryTargetArgs;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;

public class App {
    public static void main(String[] args) {
        Pulumi.run(App::stack);
    }

    public static void stack(Context ctx) {
        var exampleDirectory = new Directory("exampleDirectory", DirectoryArgs.builder()        
            .name("tf-example")
            .password("SuperSecretPassw0rd")
            .type("MicrosoftAD")
            .edition("Standard")
            .vpcSettings(DirectoryVpcSettingsArgs.builder()
                .vpcId(aws_vpc.example().id())
                .subnetIds(aws_subnet.example().stream().map(element -> element.id()).collect(toList()))
                .build())
            .build());

        var exampleSharedDirectory = new SharedDirectory("exampleSharedDirectory", SharedDirectoryArgs.builder()        
            .directoryId(exampleDirectory.id())
            .notes("You wanna have a catch?")
            .target(SharedDirectoryTargetArgs.builder()
                .id(data.aws_caller_identity().receiver().account_id())
                .build())
            .build());

    }
}
```

</details>

<details>

<summary>typescript</summary>

```typescript
import * as pulumi from "@pulumi/pulumi";
import * as aws from "@pulumi/aws";

const exampleDirectory = new aws.directoryservice.Directory("exampleDirectory", {
    name: "tf-example",
    password: "SuperSecretPassw0rd",
    type: "MicrosoftAD",
    edition: "Standard",
    vpcSettings: {
        vpcId: aws_vpc.example.id,
        subnetIds: aws_subnet.example.map(__item => __item.id),
    },
});
const exampleSharedDirectory = new aws.directoryservice.SharedDirectory("exampleSharedDirectory", {
    directoryId: exampleDirectory.id,
    notes: "You wanna have a catch?",
    target: {
        id: data.aws_caller_identity.receiver.account_id,
    },
});
```

</details>

<details>

<summary>python</summary>

```python
import pulumi
import pulumi_aws as aws

example_directory = aws.directoryservice.Directory("exampleDirectory",
    name="tf-example",
    password="SuperSecretPassw0rd",
    type="MicrosoftAD",
    edition="Standard",
    vpc_settings=aws.directoryservice.DirectoryVpcSettingsArgs(
        vpc_id=aws_vpc["example"]["id"],
        subnet_ids=[__item["id"] for __item in aws_subnet["example"]],
    ))
example_shared_directory = aws.directoryservice.SharedDirectory("exampleSharedDirectory",
    directory_id=example_directory.id,
    notes="You wanna have a catch?",
    target=aws.directoryservice.SharedDirectoryTargetArgs(
        id=data["aws_caller_identity"]["receiver"]["account_id"],
    ))
```

</details>

<details>

<summary>csharp</summary>

```csharp
using System.Collections.Generic;
using System.Linq;
using Pulumi;
using Aws = Pulumi.Aws;

return await Deployment.RunAsync(() => 
{
    var exampleDirectory = new Aws.DirectoryService.Directory("exampleDirectory", new()
    {
        Name = "tf-example",
        Password = "SuperSecretPassw0rd",
        Type = "MicrosoftAD",
        Edition = "Standard",
        VpcSettings = new Aws.DirectoryService.Inputs.DirectoryVpcSettingsArgs
        {
            VpcId = aws_vpc.Example.Id,
            SubnetIds = aws_subnet.Example.Select(__item => __item.Id).ToList(),
        },
    });

    var exampleSharedDirectory = new Aws.DirectoryService.SharedDirectory("exampleSharedDirectory", new()
    {
        DirectoryId = exampleDirectory.Id,
        Notes = "You wanna have a catch?",
        Target = new Aws.DirectoryService.Inputs.SharedDirectoryTargetArgs
        {
            Id = data.Aws_caller_identity.Receiver.Account_id,
        },
    });

});
```

</details>

## [*partial failure*] #/resources/aws:cloudfront/fieldLevelEncryptionProfile:FieldLevelEncryptionProfile

### HCL

```terraform
resource "aws_cloudfront_public_key" "example" {
  comment     = "test public key"
  encoded_key = file("public_key.pem")
  name        = "test_key"
}

resource "aws_cloudfront_field_level_encryption_profile" "test" {
  comment = "test comment"
  name    = "test profile"

  encryption_entities {
    items {
      public_key_id = aws_cloudfront_public_key.example.id
      provider_id   = "test provider"

      field_patterns {
        items = ["DateOfBirth"]
      }
    }
  }
}

```

### Failed Languages

#### yaml

```text
.pp:2,16-42: Failed to generate YAML program: Unknown Function; YAML does not support Fn::readFile.
```

### Successes

<details>

<summary>typescript</summary>

```typescript
import * as pulumi from "@pulumi/pulumi";
import * as aws from "@pulumi/aws";
import * as fs from "fs";

const example = new aws.cloudfront.PublicKey("example", {
    comment: "test public key",
    encodedKey: fs.readFileSync("public_key.pem"),
});
const test = new aws.cloudfront.FieldLevelEncryptionProfile("test", {
    comment: "test comment",
    encryptionEntities: {
        items: [{
            publicKeyId: example.id,
            providerId: "test provider",
            fieldPatterns: {
                items: ["DateOfBirth"],
            },
        }],
    },
});
```

</details>

<details>

<summary>python</summary>

```python
import pulumi
import pulumi_aws as aws

example = aws.cloudfront.PublicKey("example",
    comment="test public key",
    encoded_key=(lambda path: open(path).read())("public_key.pem"))
test = aws.cloudfront.FieldLevelEncryptionProfile("test",
    comment="test comment",
    encryption_entities=aws.cloudfront.FieldLevelEncryptionProfileEncryptionEntitiesArgs(
        items=[aws.cloudfront.FieldLevelEncryptionProfileEncryptionEntitiesItemArgs(
            public_key_id=example.id,
            provider_id="test provider",
            field_patterns=aws.cloudfront.FieldLevelEncryptionProfileEncryptionEntitiesItemFieldPatternsArgs(
                items=["DateOfBirth"],
            ),
        )],
    ))
```

</details>

<details>

<summary>csharp</summary>

```csharp
using System.Collections.Generic;
using System.IO;
using Pulumi;
using Aws = Pulumi.Aws;

return await Deployment.RunAsync(() => 
{
    var example = new Aws.CloudFront.PublicKey("example", new()
    {
        Comment = "test public key",
        EncodedKey = File.ReadAllText("public_key.pem"),
    });

    var test = new Aws.CloudFront.FieldLevelEncryptionProfile("test", new()
    {
        Comment = "test comment",
        EncryptionEntities = new Aws.CloudFront.Inputs.FieldLevelEncryptionProfileEncryptionEntitiesArgs
        {
            Items = new[]
            {
                new Aws.CloudFront.Inputs.FieldLevelEncryptionProfileEncryptionEntitiesItemArgs
                {
                    PublicKeyId = example.Id,
                    ProviderId = "test provider",
                    FieldPatterns = new Aws.CloudFront.Inputs.FieldLevelEncryptionProfileEncryptionEntitiesItemFieldPatternsArgs
                    {
                        Items = new[]
                        {
                            "DateOfBirth",
                        },
                    },
                },
            },
        },
    });

});
```

</details>

<details>

<summary>go</summary>

```go
package main

import (
	"io/ioutil"

	"github.com/pulumi/pulumi-aws/sdk/v5/go/aws/cloudfront"
	"github.com/pulumi/pulumi/sdk/v3/go/pulumi"
)

func readFileOrPanic(path string) pulumi.StringPtrInput {
	data, err := ioutil.ReadFile(path)
	if err != nil {
		panic(err.Error())
	}
	return pulumi.String(string(data))
}

func main() {
	pulumi.Run(func(ctx *pulumi.Context) error {
		example, err := cloudfront.NewPublicKey(ctx, "example", &cloudfront.PublicKeyArgs{
			Comment:    pulumi.String("test public key"),
			EncodedKey: readFileOrPanic("public_key.pem"),
		})
		if err != nil {
			return err
		}
		_, err = cloudfront.NewFieldLevelEncryptionProfile(ctx, "test", &cloudfront.FieldLevelEncryptionProfileArgs{
			Comment: pulumi.String("test comment"),
			EncryptionEntities: &cloudfront.FieldLevelEncryptionProfileEncryptionEntitiesArgs{
				Items: cloudfront.FieldLevelEncryptionProfileEncryptionEntitiesItemArray{
					&cloudfront.FieldLevelEncryptionProfileEncryptionEntitiesItemArgs{
						PublicKeyId: example.ID(),
						ProviderId:  pulumi.String("test provider"),
						FieldPatterns: &cloudfront.FieldLevelEncryptionProfileEncryptionEntitiesItemFieldPatternsArgs{
							Items: pulumi.StringArray{
								pulumi.String("DateOfBirth"),
							},
						},
					},
				},
			},
		})
		if err != nil {
			return err
		}
		return nil
	})
}
```

</details>

<details>

<summary>java</summary>

```java
package generated_program;

import com.pulumi.Context;
import com.pulumi.Pulumi;
import com.pulumi.core.Output;
import com.pulumi.aws.cloudfront.PublicKey;
import com.pulumi.aws.cloudfront.PublicKeyArgs;
import com.pulumi.aws.cloudfront.FieldLevelEncryptionProfile;
import com.pulumi.aws.cloudfront.FieldLevelEncryptionProfileArgs;
import com.pulumi.aws.cloudfront.inputs.FieldLevelEncryptionProfileEncryptionEntitiesArgs;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;

public class App {
    public static void main(String[] args) {
        Pulumi.run(App::stack);
    }

    public static void stack(Context ctx) {
        var example = new PublicKey("example", PublicKeyArgs.builder()        
            .comment("test public key")
            .encodedKey(Files.readString(Paths.get("public_key.pem")))
            .build());

        var test = new FieldLevelEncryptionProfile("test", FieldLevelEncryptionProfileArgs.builder()        
            .comment("test comment")
            .encryptionEntities(FieldLevelEncryptionProfileEncryptionEntitiesArgs.builder()
                .items(FieldLevelEncryptionProfileEncryptionEntitiesItemArgs.builder()
                    .publicKeyId(example.id())
                    .providerId("test provider")
                    .fieldPatterns(FieldLevelEncryptionProfileEncryptionEntitiesItemFieldPatternsArgs.builder()
                        .items("DateOfBirth")
                        .build())
                    .build())
                .build())
            .build());

    }
}
```

</details>

## [*partial failure*] Static Website Hosting

### HCL

```terraform
resource "aws_s3_bucket_legacy" "b" {
  bucket = "s3-website-test.mydomain.com"
  acl    = "public-read"
  policy = file("policy.json")

  website {
    index_document = "index.html"
    error_document = "error.html"

    routing_rules = <<EOF
[{
    "Condition": {
        "KeyPrefixEquals": "docs/"
    },
    "Redirect": {
        "ReplaceKeyPrefixWith": "documents/"
    }
}]
EOF
  }
}

```

### Failed Languages

#### yaml

```text
.pp:2,12-35: Failed to generate YAML program: Unknown Function; YAML does not support Fn::readFile.
```

### Successes

<details>

<summary>python</summary>

```python
import pulumi
import pulumi_aws as aws

bucket = aws.s3.Bucket("bucket",
    acl="public-read",
    policy=(lambda path: open(path).read())("policy.json"),
    website=aws.s3.BucketWebsiteArgs(
        index_document="index.html",
        error_document="error.html",
        routing_rules="""[{
    "Condition": {
        "KeyPrefixEquals": "docs/"
    },
    "Redirect": {
        "ReplaceKeyPrefixWith": "documents/"
    }
}]
""",
    ))
```

</details>

<details>

<summary>csharp</summary>

```csharp
using System.Collections.Generic;
using System.IO;
using Pulumi;
using Aws = Pulumi.Aws;

return await Deployment.RunAsync(() => 
{
    var bucket = new Aws.S3.Bucket("bucket", new()
    {
        Acl = "public-read",
        Policy = File.ReadAllText("policy.json"),
        Website = new Aws.S3.Inputs.BucketWebsiteArgs
        {
            IndexDocument = "index.html",
            ErrorDocument = "error.html",
            RoutingRules = @"[{
    ""Condition"": {
        ""KeyPrefixEquals"": ""docs/""
    },
    ""Redirect"": {
        ""ReplaceKeyPrefixWith"": ""documents/""
    }
}]
",
        },
    });

});
```

</details>

<details>

<summary>go</summary>

```go
package main

import (
	"fmt"
	"io/ioutil"

	"github.com/pulumi/pulumi-aws/sdk/v5/go/aws/iam"
	"github.com/pulumi/pulumi-aws/sdk/v5/go/aws/s3"
	"github.com/pulumi/pulumi/sdk/v3/go/pulumi"
)

func readFileOrPanic(path string) pulumi.StringPtrInput {
	data, err := ioutil.ReadFile(path)
	if err != nil {
		panic(err.Error())
	}
	return pulumi.String(string(data))
}

func main() {
	pulumi.Run(func(ctx *pulumi.Context) error {
		_, err := s3.NewBucket(ctx, "bucket", &s3.BucketArgs{
			Acl:    pulumi.String("public-read"),
			Policy: readFileOrPanic("policy.json"),
			Website: &s3.BucketWebsiteArgs{
				IndexDocument: pulumi.String("index.html"),
				ErrorDocument: pulumi.String("error.html"),
				RoutingRules: pulumi.Any(fmt.Sprintf(`[{
    "Condition": {
        "KeyPrefixEquals": "docs/"
    },
    "Redirect": {
        "ReplaceKeyPrefixWith": "documents/"
    }
}]
`)),
			},
		})
		if err != nil {
			return err
		}
		return nil
	})
}
```

</details>

<details>

<summary>java</summary>

```java
package generated_program;

import com.pulumi.Context;
import com.pulumi.Pulumi;
import com.pulumi.core.Output;
import com.pulumi.aws.s3.Bucket;
import com.pulumi.aws.s3.BucketArgs;
import com.pulumi.aws.s3.inputs.BucketWebsiteArgs;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;

public class App {
    public static void main(String[] args) {
        Pulumi.run(App::stack);
    }

    public static void stack(Context ctx) {
        var bucket = new Bucket("bucket", BucketArgs.builder()        
            .acl("public-read")
            .policy(Files.readString(Paths.get("policy.json")))
            .website(BucketWebsiteArgs.builder()
                .indexDocument("index.html")
                .errorDocument("error.html")
                .routingRules("""
[{
    "Condition": {
        "KeyPrefixEquals": "docs/"
    },
    "Redirect": {
        "ReplaceKeyPrefixWith": "documents/"
    }
}]
                """)
                .build())
            .build());

    }
}
```

</details>

<details>

<summary>typescript</summary>

```typescript
import * as pulumi from "@pulumi/pulumi";
import * as aws from "@pulumi/aws";
import * as fs from "fs";

const bucket = new aws.s3.Bucket("bucket", {
    acl: "public-read",
    policy: fs.readFileSync("policy.json"),
    website: {
        indexDocument: "index.html",
        errorDocument: "error.html",
        routingRules: `[{
    "Condition": {
        "KeyPrefixEquals": "docs/"
    },
    "Redirect": {
        "ReplaceKeyPrefixWith": "documents/"
    }
}]
`,
    },
});
```

</details>

## [*partial failure*] #/resources/aws:apigateway/methodSettings:MethodSettings

### HCL

```terraform
resource "aws_api_gateway_rest_api" "example" {
  body = jsonencode({
    openapi = "3.0.1"
    info = {
      title   = "example"
      version = "1.0"
    }
    paths = {
      "/path1" = {
        get = {
          x-amazon-apigateway-integration = {
            httpMethod           = "GET"
            payloadFormatVersion = "1.0"
            type                 = "HTTP_PROXY"
            uri                  = "https://ip-ranges.amazonaws.com/ip-ranges.json"
          }
        }
      }
    }
  })

  name = "example"
}

resource "aws_api_gateway_deployment" "example" {
  rest_api_id = aws_api_gateway_rest_api.example.id

  triggers = {
    redeployment = sha1(jsonencode(aws_api_gateway_rest_api.example.body))
  }

  lifecycle {
    create_before_destroy = true
  }
}

resource "aws_api_gateway_stage" "example" {
  deployment_id = aws_api_gateway_deployment.example.id
  rest_api_id   = aws_api_gateway_rest_api.example.id
  stage_name    = "example"
}

resource "aws_api_gateway_method_settings" "all" {
  rest_api_id = aws_api_gateway_rest_api.example.id
  stage_name  = aws_api_gateway_stage.example.stage_name
  method_path = "*/*"

  settings {
    metrics_enabled = true
    logging_level   = "ERROR"
  }
}

resource "aws_api_gateway_method_settings" "path_specific" {
  rest_api_id = aws_api_gateway_rest_api.example.id
  stage_name  = aws_api_gateway_stage.example.stage_name
  method_path = "path1/GET"

  settings {
    metrics_enabled = true
    logging_level   = "INFO"
  }
}

```

### Failed Languages

#### yaml

```text
.pp:24,20-53: Failed to generate YAML program: Unknown Function; YAML does not support Fn::sha1.
```

### Successes

<details>

<summary>typescript</summary>

```typescript
import * as pulumi from "@pulumi/pulumi";
import * as aws from "@pulumi/aws";
import * as crypto from "crypto";

const exampleRestApi = new aws.apigateway.RestApi("exampleRestApi", {body: JSON.stringify({
    openapi: "3.0.1",
    info: {
        title: "example",
        version: "1.0",
    },
    paths: {
        "/path1": {
            get: {
                "x-amazon-apigateway-integration": {
                    httpMethod: "GET",
                    payloadFormatVersion: "1.0",
                    type: "HTTP_PROXY",
                    uri: "https://ip-ranges.amazonaws.com/ip-ranges.json",
                },
            },
        },
    },
})});
const exampleDeployment = new aws.apigateway.Deployment("exampleDeployment", {
    restApi: exampleRestApi.id,
    triggers: {
        redeployment: exampleRestApi.body.apply(body => JSON.stringify(body)).apply(toJSON => crypto.createHash('sha1').update(toJSON).digest('hex')),
    },
});
const exampleStage = new aws.apigateway.Stage("exampleStage", {
    deployment: exampleDeployment.id,
    restApi: exampleRestApi.id,
    stageName: "example",
});
const all = new aws.apigateway.MethodSettings("all", {
    restApi: exampleRestApi.id,
    stageName: exampleStage.stageName,
    methodPath: "*/*",
    settings: {
        metricsEnabled: true,
        loggingLevel: "ERROR",
    },
});
const pathSpecific = new aws.apigateway.MethodSettings("pathSpecific", {
    restApi: exampleRestApi.id,
    stageName: exampleStage.stageName,
    methodPath: "path1/GET",
    settings: {
        metricsEnabled: true,
        loggingLevel: "INFO",
    },
});
```

</details>

<details>

<summary>python</summary>

```python
import pulumi
import hashlib
import json
import pulumi_aws as aws

example_rest_api = aws.apigateway.RestApi("exampleRestApi", body=json.dumps({
    "openapi": "3.0.1",
    "info": {
        "title": "example",
        "version": "1.0",
    },
    "paths": {
        "/path1": {
            "get": {
                "x-amazon-apigateway-integration": {
                    "httpMethod": "GET",
                    "payloadFormatVersion": "1.0",
                    "type": "HTTP_PROXY",
                    "uri": "https://ip-ranges.amazonaws.com/ip-ranges.json",
                },
            },
        },
    },
}))
example_deployment = aws.apigateway.Deployment("exampleDeployment",
    rest_api=example_rest_api.id,
    triggers={
        "redeployment": example_rest_api.body.apply(lambda body: json.dumps(body)).apply(lambda to_json: hashlib.sha1(to_json.encode()).hexdigest()),
    })
example_stage = aws.apigateway.Stage("exampleStage",
    deployment=example_deployment.id,
    rest_api=example_rest_api.id,
    stage_name="example")
all = aws.apigateway.MethodSettings("all",
    rest_api=example_rest_api.id,
    stage_name=example_stage.stage_name,
    method_path="*/*",
    settings=aws.apigateway.MethodSettingsSettingsArgs(
        metrics_enabled=True,
        logging_level="ERROR",
    ))
path_specific = aws.apigateway.MethodSettings("pathSpecific",
    rest_api=example_rest_api.id,
    stage_name=example_stage.stage_name,
    method_path="path1/GET",
    settings=aws.apigateway.MethodSettingsSettingsArgs(
        metrics_enabled=True,
        logging_level="INFO",
    ))
```

</details>

<details>

<summary>csharp</summary>

```csharp
using System.Collections.Generic;
using System.Security.Cryptography;
using System.Text;
using System.Text.Json;
using Pulumi;
using Aws = Pulumi.Aws;

	private static string ComputeSHA1(string input) {
		return BitConverter.ToString(
			SHA1.Create().ComputeHash(Encoding.UTF8.GetBytes(input))
		).Replace("-","").ToLowerInvariant());
	}

return await Deployment.RunAsync(() => 
{
    var exampleRestApi = new Aws.ApiGateway.RestApi("exampleRestApi", new()
    {
        Body = JsonSerializer.Serialize(new Dictionary<string, object?>
        {
            ["openapi"] = "3.0.1",
            ["info"] = new Dictionary<string, object?>
            {
                ["title"] = "example",
                ["version"] = "1.0",
            },
            ["paths"] = new Dictionary<string, object?>
            {
                ["/path1"] = new Dictionary<string, object?>
                {
                    ["get"] = new Dictionary<string, object?>
                    {
                        ["x-amazon-apigateway-integration"] = new Dictionary<string, object?>
                        {
                            ["httpMethod"] = "GET",
                            ["payloadFormatVersion"] = "1.0",
                            ["type"] = "HTTP_PROXY",
                            ["uri"] = "https://ip-ranges.amazonaws.com/ip-ranges.json",
                        },
                    },
                },
            },
        }),
    });

    var exampleDeployment = new Aws.ApiGateway.Deployment("exampleDeployment", new()
    {
        RestApi = exampleRestApi.Id,
        Triggers = 
        {
            { "redeployment", exampleRestApi.Body.Apply(body => JsonSerializer.Serialize(body)).Apply(toJSON => ComputeSHA1(toJSON)) },
        },
    });

    var exampleStage = new Aws.ApiGateway.Stage("exampleStage", new()
    {
        Deployment = exampleDeployment.Id,
        RestApi = exampleRestApi.Id,
        StageName = "example",
    });

    var all = new Aws.ApiGateway.MethodSettings("all", new()
    {
        RestApi = exampleRestApi.Id,
        StageName = exampleStage.StageName,
        MethodPath = "*/*",
        Settings = new Aws.ApiGateway.Inputs.MethodSettingsSettingsArgs
        {
            MetricsEnabled = true,
            LoggingLevel = "ERROR",
        },
    });

    var pathSpecific = new Aws.ApiGateway.MethodSettings("pathSpecific", new()
    {
        RestApi = exampleRestApi.Id,
        StageName = exampleStage.StageName,
        MethodPath = "path1/GET",
        Settings = new Aws.ApiGateway.Inputs.MethodSettingsSettingsArgs
        {
            MetricsEnabled = true,
            LoggingLevel = "INFO",
        },
    });

});
```

</details>

<details>

<summary>go</summary>

```go
package main

import (
	"crypto/sha1"
	"encoding/json"
	"fmt"

	"github.com/pulumi/pulumi-aws/sdk/v5/go/aws/apigateway"
	"github.com/pulumi/pulumi/sdk/v3/go/pulumi"
)

func sha1Hash(input string) string {
	hash := sha1.Sum([]byte(input))
	return hex.EncodeToString(hash[:])
}

func main() {
	pulumi.Run(func(ctx *pulumi.Context) error {
		tmpJSON0, err := json.Marshal(map[string]interface{}{
			"openapi": "3.0.1",
			"info": map[string]interface{}{
				"title":   "example",
				"version": "1.0",
			},
			"paths": map[string]interface{}{
				"/path1": map[string]interface{}{
					"get": map[string]interface{}{
						"x-amazon-apigateway-integration": map[string]interface{}{
							"httpMethod":           "GET",
							"payloadFormatVersion": "1.0",
							"type":                 "HTTP_PROXY",
							"uri":                  "https://ip-ranges.amazonaws.com/ip-ranges.json",
						},
					},
				},
			},
		})
		if err != nil {
			return err
		}
		json0 := string(tmpJSON0)
		exampleRestApi, err := apigateway.NewRestApi(ctx, "exampleRestApi", &apigateway.RestApiArgs{
			Body: pulumi.String(json0),
		})
		if err != nil {
			return err
		}
		exampleDeployment, err := apigateway.NewDeployment(ctx, "exampleDeployment", &apigateway.DeploymentArgs{
			RestApi: exampleRestApi.ID(),
			Triggers: pulumi.StringMap{
				"redeployment": exampleRestApi.Body.ApplyT(func(body string) (pulumi.String, error) {
					var _zero pulumi.String
					tmpJSON1, err := json.Marshal(body)
					if err != nil {
						return _zero, err
					}
					json1 := string(tmpJSON1)
					return json1, nil
				}).(pulumi.StringOutput).ApplyT(func(toJSON string) (pulumi.String, error) {
					return sha1Hash(toJSON), nil
				}).(pulumi.StringOutput),
			},
		})
		if err != nil {
			return err
		}
		exampleStage, err := apigateway.NewStage(ctx, "exampleStage", &apigateway.StageArgs{
			Deployment: exampleDeployment.ID(),
			RestApi:    exampleRestApi.ID(),
			StageName:  pulumi.String("example"),
		})
		if err != nil {
			return err
		}
		_, err = apigateway.NewMethodSettings(ctx, "all", &apigateway.MethodSettingsArgs{
			RestApi:    exampleRestApi.ID(),
			StageName:  exampleStage.StageName,
			MethodPath: pulumi.String("*/*"),
			Settings: &apigateway.MethodSettingsSettingsArgs{
				MetricsEnabled: pulumi.Bool(true),
				LoggingLevel:   pulumi.String("ERROR"),
			},
		})
		if err != nil {
			return err
		}
		_, err = apigateway.NewMethodSettings(ctx, "pathSpecific", &apigateway.MethodSettingsArgs{
			RestApi:    exampleRestApi.ID(),
			StageName:  exampleStage.StageName,
			MethodPath: pulumi.String("path1/GET"),
			Settings: &apigateway.MethodSettingsSettingsArgs{
				MetricsEnabled: pulumi.Bool(true),
				LoggingLevel:   pulumi.String("INFO"),
			},
		})
		if err != nil {
			return err
		}
		return nil
	})
}
```

</details>

<details>

<summary>java</summary>

```java
package generated_program;

import com.pulumi.Context;
import com.pulumi.Pulumi;
import com.pulumi.core.Output;
import com.pulumi.aws.apigateway.RestApi;
import com.pulumi.aws.apigateway.RestApiArgs;
import com.pulumi.aws.apigateway.Deployment;
import com.pulumi.aws.apigateway.DeploymentArgs;
import com.pulumi.aws.apigateway.Stage;
import com.pulumi.aws.apigateway.StageArgs;
import com.pulumi.aws.apigateway.MethodSettings;
import com.pulumi.aws.apigateway.MethodSettingsArgs;
import com.pulumi.aws.apigateway.inputs.MethodSettingsSettingsArgs;
import static com.pulumi.codegen.internal.Serialization.*;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;

public class App {
    public static void main(String[] args) {
        Pulumi.run(App::stack);
    }

    public static void stack(Context ctx) {
        var exampleRestApi = new RestApi("exampleRestApi", RestApiArgs.builder()        
            .body(serializeJson(
                jsonObject(
                    jsonProperty("openapi", "3.0.1"),
                    jsonProperty("info", jsonObject(
                        jsonProperty("title", "example"),
                        jsonProperty("version", "1.0")
                    )),
                    jsonProperty("paths", jsonObject(
                        jsonProperty("/path1", jsonObject(
                            jsonProperty("get", jsonObject(
                                jsonProperty("x-amazon-apigateway-integration", jsonObject(
                                    jsonProperty("httpMethod", "GET"),
                                    jsonProperty("payloadFormatVersion", "1.0"),
                                    jsonProperty("type", "HTTP_PROXY"),
                                    jsonProperty("uri", "https://ip-ranges.amazonaws.com/ip-ranges.json")
                                ))
                            ))
                        ))
                    ))
                )))
            .build());

        var exampleDeployment = new Deployment("exampleDeployment", DeploymentArgs.builder()        
            .restApi(exampleRestApi.id())
            .triggers(Map.of("redeployment", exampleRestApi.body().applyValue(body -> serializeJson(
                body)).applyValue(toJSON -> computeSHA1(toJSON))))
            .build());

        var exampleStage = new Stage("exampleStage", StageArgs.builder()        
            .deployment(exampleDeployment.id())
            .restApi(exampleRestApi.id())
            .stageName("example")
            .build());

        var all = new MethodSettings("all", MethodSettingsArgs.builder()        
            .restApi(exampleRestApi.id())
            .stageName(exampleStage.stageName())
            .methodPath("*/*")
            .settings(MethodSettingsSettingsArgs.builder()
                .metricsEnabled(true)
                .loggingLevel("ERROR")
                .build())
            .build());

        var pathSpecific = new MethodSettings("pathSpecific", MethodSettingsArgs.builder()        
            .restApi(exampleRestApi.id())
            .stageName(exampleStage.stageName())
            .methodPath("path1/GET")
            .settings(MethodSettingsSettingsArgs.builder()
                .metricsEnabled(true)
                .loggingLevel("INFO")
                .build())
            .build());

    }
}
```

</details>

## [*partial failure*] ECS Service Autoscaling

### HCL

```terraform
resource "aws_appautoscaling_target" "ecs_target" {
  max_capacity       = 4
  min_capacity       = 1
  resource_id        = "service/clusterName/serviceName"
  scalable_dimension = "ecs:service:DesiredCount"
  service_namespace  = "ecs"
}

resource "aws_appautoscaling_policy" "ecs_policy" {
  name               = "scale-down"
  policy_type        = "StepScaling"
  resource_id        = aws_appautoscaling_target.ecs_target.resource_id
  scalable_dimension = aws_appautoscaling_target.ecs_target.scalable_dimension
  service_namespace  = aws_appautoscaling_target.ecs_target.service_namespace

  step_scaling_policy_configuration {
    adjustment_type         = "ChangeInCapacity"
    cooldown                = 60
    metric_aggregation_type = "Maximum"

    step_adjustment {
      metric_interval_upper_bound = 0
      scaling_adjustment          = -1
    }
  }
}

```

### Failed Languages

#### yaml

```text
.pp:18,36-38: Failed to generate YAML program: *model.UnaryOpExpression; Unimplemented! Needed for  -1

```

#### java

```text
<nil>: not yet implemented: GenUnaryOpExpression; not yet implemented: GenUnaryOpExpression
```

### Successes

<details>

<summary>csharp</summary>

```csharp
using System.Collections.Generic;
using Pulumi;
using Aws = Pulumi.Aws;

return await Deployment.RunAsync(() => 
{
    var ecsTarget = new Aws.AppAutoScaling.Target("ecsTarget", new()
    {
        MaxCapacity = 4,
        MinCapacity = 1,
        ResourceId = "service/clusterName/serviceName",
        ScalableDimension = "ecs:service:DesiredCount",
        ServiceNamespace = "ecs",
    });

    var ecsPolicy = new Aws.AppAutoScaling.Policy("ecsPolicy", new()
    {
        PolicyType = "StepScaling",
        ResourceId = ecsTarget.ResourceId,
        ScalableDimension = ecsTarget.ScalableDimension,
        ServiceNamespace = ecsTarget.ServiceNamespace,
        StepScalingPolicyConfiguration = new Aws.AppAutoScaling.Inputs.PolicyStepScalingPolicyConfigurationArgs
        {
            AdjustmentType = "ChangeInCapacity",
            Cooldown = 60,
            MetricAggregationType = "Maximum",
            StepAdjustments = new[]
            {
                new Aws.AppAutoScaling.Inputs.PolicyStepScalingPolicyConfigurationStepAdjustmentArgs
                {
                    MetricIntervalUpperBound = "0",
                    ScalingAdjustment = -1,
                },
            },
        },
    });

});
```

</details>

<details>

<summary>go</summary>

```go
package main

import (
	"github.com/pulumi/pulumi-aws/sdk/v5/go/aws/appautoscaling"
	"github.com/pulumi/pulumi/sdk/v3/go/pulumi"
)

func main() {
	pulumi.Run(func(ctx *pulumi.Context) error {
		ecsTarget, err := appautoscaling.NewTarget(ctx, "ecsTarget", &appautoscaling.TargetArgs{
			MaxCapacity:       pulumi.Int(4),
			MinCapacity:       pulumi.Int(1),
			ResourceId:        pulumi.String("service/clusterName/serviceName"),
			ScalableDimension: pulumi.String("ecs:service:DesiredCount"),
			ServiceNamespace:  pulumi.String("ecs"),
		})
		if err != nil {
			return err
		}
		_, err = appautoscaling.NewPolicy(ctx, "ecsPolicy", &appautoscaling.PolicyArgs{
			PolicyType:        pulumi.String("StepScaling"),
			ResourceId:        ecsTarget.ResourceId,
			ScalableDimension: ecsTarget.ScalableDimension,
			ServiceNamespace:  ecsTarget.ServiceNamespace,
			StepScalingPolicyConfiguration: &appautoscaling.PolicyStepScalingPolicyConfigurationArgs{
				AdjustmentType:        pulumi.String("ChangeInCapacity"),
				Cooldown:              pulumi.Int(60),
				MetricAggregationType: pulumi.String("Maximum"),
				StepAdjustments: appautoscaling.PolicyStepScalingPolicyConfigurationStepAdjustmentArray{
					&appautoscaling.PolicyStepScalingPolicyConfigurationStepAdjustmentArgs{
						MetricIntervalUpperBound: pulumi.String("0"),
						ScalingAdjustment:        -1,
					},
				},
			},
		})
		if err != nil {
			return err
		}
		return nil
	})
}
```

</details>

<details>

<summary>typescript</summary>

```typescript
import * as pulumi from "@pulumi/pulumi";
import * as aws from "@pulumi/aws";

const ecsTarget = new aws.appautoscaling.Target("ecsTarget", {
    maxCapacity: 4,
    minCapacity: 1,
    resourceId: "service/clusterName/serviceName",
    scalableDimension: "ecs:service:DesiredCount",
    serviceNamespace: "ecs",
});
const ecsPolicy = new aws.appautoscaling.Policy("ecsPolicy", {
    policyType: "StepScaling",
    resourceId: ecsTarget.resourceId,
    scalableDimension: ecsTarget.scalableDimension,
    serviceNamespace: ecsTarget.serviceNamespace,
    stepScalingPolicyConfiguration: {
        adjustmentType: "ChangeInCapacity",
        cooldown: 60,
        metricAggregationType: "Maximum",
        stepAdjustments: [{
            metricIntervalUpperBound: "0",
            scalingAdjustment: -1,
        }],
    },
});
```

</details>

<details>

<summary>python</summary>

```python
import pulumi
import pulumi_aws as aws

ecs_target = aws.appautoscaling.Target("ecsTarget",
    max_capacity=4,
    min_capacity=1,
    resource_id="service/clusterName/serviceName",
    scalable_dimension="ecs:service:DesiredCount",
    service_namespace="ecs")
ecs_policy = aws.appautoscaling.Policy("ecsPolicy",
    policy_type="StepScaling",
    resource_id=ecs_target.resource_id,
    scalable_dimension=ecs_target.scalable_dimension,
    service_namespace=ecs_target.service_namespace,
    step_scaling_policy_configuration=aws.appautoscaling.PolicyStepScalingPolicyConfigurationArgs(
        adjustment_type="ChangeInCapacity",
        cooldown=60,
        metric_aggregation_type="Maximum",
        step_adjustments=[aws.appautoscaling.PolicyStepScalingPolicyConfigurationStepAdjustmentArgs(
            metric_interval_upper_bound="0",
            scaling_adjustment=-1,
        )],
    ))
```

</details>

## [*partial failure*] New DocumentDB Global Cluster

### HCL

```terraform
provider "aws" {
  alias  = "primary"
  region = "us-east-2"
}

provider "aws" {
  alias  = "secondary"
  region = "us-east-1"
}

resource "aws_docdb_global_cluster" "example" {
  global_cluster_identifier = "global-test"
  engine                    = "docdb"
  engine_version            = "4.0.0"
}

resource "aws_docdb_cluster" "primary" {
  provider                  = aws.primary
  engine                    = aws_docdb_global_cluster.example.engine
  engine_version            = aws_docdb_global_cluster.example.engine_version
  cluster_identifier        = "test-primary-cluster"
  master_username           = "username"
  master_password           = "somepass123"
  global_cluster_identifier = aws_docdb_global_cluster.example.id
  db_subnet_group_name      = "default"
}

resource "aws_docdb_cluster_instance" "primary" {
  provider             = aws.primary
  engine               = aws_docdb_global_cluster.example.engine
  engine_version       = aws_docdb_global_cluster.example.engine_version
  identifier           = "test-primary-cluster-instance"
  cluster_identifier   = aws_docdb_cluster.primary.id
  instance_class       = "db.r5.large"
  db_subnet_group_name = "default"
}

resource "aws_docdb_cluster" "secondary" {
  provider                  = aws.secondary
  engine                    = aws_docdb_global_cluster.example.engine
  engine_version            = aws_docdb_global_cluster.example.engine_version
  cluster_identifier        = "test-secondary-cluster"
  global_cluster_identifier = aws_docdb_global_cluster.example.id
  db_subnet_group_name      = "default"
}

resource "aws_docdb_cluster_instance" "secondary" {
  provider             = aws.secondary
  engine               = aws_docdb_global_cluster.example.engine
  engine_version       = aws_docdb_global_cluster.example.engine_version
  identifier           = "test-secondary-cluster-instance"
  cluster_identifier   = aws_docdb_cluster.secondary.id
  instance_class       = "db.r5.large"
  db_subnet_group_name = "default"

  depends_on = [
    aws_docdb_cluster_instance.primary
  ]
}

```

### Failed Languages

#### python

```text
:0,0-0: unknown property 'engineVersion' among [preferredMaintenanceWindow applyImmediately availabilityZone caCertIdentifier clusterIdentifier instanceClass promotionTier tags autoMinorVersionUpgrade engine identifier identifierPrefix]; , and 3 other diagnostic(s)
```

#### csharp

```text
:0,0-0: unknown property 'engineVersion' among [identifier identifierPrefix instanceClass preferredMaintenanceWindow autoMinorVersionUpgrade caCertIdentifier clusterIdentifier engine promotionTier tags applyImmediately availabilityZone]; , and 3 other diagnostic(s)
```

#### go

```text
:0,0-0: unknown property 'engineVersion' among [autoMinorVersionUpgrade identifier instanceClass preferredMaintenanceWindow promotionTier applyImmediately caCertIdentifier clusterIdentifier engine identifierPrefix tags availabilityZone]; , and 3 other diagnostic(s)
```

#### typescript

```text
:0,0-0: unknown property 'engineVersion' among [instanceClass applyImmediately autoMinorVersionUpgrade availabilityZone caCertIdentifier clusterIdentifier tags engine identifier identifierPrefix preferredMaintenanceWindow promotionTier]; , and 3 other diagnostic(s)
```

### Successes

<details>

<summary>yaml</summary>

```yaml
resources:
  primary:
    type: pulumi:providers:aws
    properties:
      region: us-east-2
  secondary:
    type: pulumi:providers:aws
    properties:
      region: us-east-1
  example:
    type: aws:docdb:GlobalCluster
    properties:
      globalClusterIdentifier: global-test
      engine: docdb
      engineVersion: 4.0.0
  primaryCluster:
    type: aws:docdb:Cluster
    properties:
      engine: ${example.engine}
      engineVersion: ${example.engineVersion}
      clusterIdentifier: test-primary-cluster
      masterUsername: username
      masterPassword: somepass123
      globalClusterIdentifier: ${example.id}
      dbSubnetGroupName: default
    options:
      provider: ${aws.primary}
  primaryClusterInstance:
    type: aws:docdb:ClusterInstance
    properties:
      engine: ${example.engine}
      engineVersion: ${example.engineVersion}
      identifier: test-primary-cluster-instance
      clusterIdentifier: ${primaryCluster.id}
      instanceClass: db.r5.large
      dbSubnetGroupName: default
    options:
      provider: ${aws.primary}
  secondaryCluster:
    type: aws:docdb:Cluster
    properties:
      engine: ${example.engine}
      engineVersion: ${example.engineVersion}
      clusterIdentifier: test-secondary-cluster
      globalClusterIdentifier: ${example.id}
      dbSubnetGroupName: default
    options:
      provider: ${aws.secondary}
  secondaryClusterInstance:
    type: aws:docdb:ClusterInstance
    properties:
      engine: ${example.engine}
      engineVersion: ${example.engineVersion}
      identifier: test-secondary-cluster-instance
      clusterIdentifier: ${secondaryCluster.id}
      instanceClass: db.r5.large
      dbSubnetGroupName: default
    options:
      provider: ${aws.secondary}
      dependson:
        - ${primaryClusterInstance}
```

</details>

<details>

<summary>java</summary>

```java
package generated_program;

import com.pulumi.Context;
import com.pulumi.Pulumi;
import com.pulumi.core.Output;
import com.pulumi.aws.Provider;
import com.pulumi.aws.ProviderArgs;
import com.pulumi.aws.docdb.GlobalCluster;
import com.pulumi.aws.docdb.GlobalClusterArgs;
import com.pulumi.aws.docdb.Cluster;
import com.pulumi.aws.docdb.ClusterArgs;
import com.pulumi.aws.docdb.ClusterInstance;
import com.pulumi.aws.docdb.ClusterInstanceArgs;
import com.pulumi.resources.CustomResourceOptions;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;

public class App {
    public static void main(String[] args) {
        Pulumi.run(App::stack);
    }

    public static void stack(Context ctx) {
        var primary = new Provider("primary", ProviderArgs.builder()        
            .region("us-east-2")
            .build());

        var secondary = new Provider("secondary", ProviderArgs.builder()        
            .region("us-east-1")
            .build());

        var example = new GlobalCluster("example", GlobalClusterArgs.builder()        
            .globalClusterIdentifier("global-test")
            .engine("docdb")
            .engineVersion("4.0.0")
            .build());

        var primaryCluster = new Cluster("primaryCluster", ClusterArgs.builder()        
            .engine(example.engine())
            .engineVersion(example.engineVersion())
            .clusterIdentifier("test-primary-cluster")
            .masterUsername("username")
            .masterPassword("somepass123")
            .globalClusterIdentifier(example.id())
            .dbSubnetGroupName("default")
            .build(), CustomResourceOptions.builder()
                .provider(aws.primary())
                .build());

        var primaryClusterInstance = new ClusterInstance("primaryClusterInstance", ClusterInstanceArgs.builder()        
            .engine(example.engine())
            .engineVersion(example.engineVersion())
            .identifier("test-primary-cluster-instance")
            .clusterIdentifier(primaryCluster.id())
            .instanceClass("db.r5.large")
            .dbSubnetGroupName("default")
            .build(), CustomResourceOptions.builder()
                .provider(aws.primary())
                .build());

        var secondaryCluster = new Cluster("secondaryCluster", ClusterArgs.builder()        
            .engine(example.engine())
            .engineVersion(example.engineVersion())
            .clusterIdentifier("test-secondary-cluster")
            .globalClusterIdentifier(example.id())
            .dbSubnetGroupName("default")
            .build(), CustomResourceOptions.builder()
                .provider(aws.secondary())
                .build());

        var secondaryClusterInstance = new ClusterInstance("secondaryClusterInstance", ClusterInstanceArgs.builder()        
            .engine(example.engine())
            .engineVersion(example.engineVersion())
            .identifier("test-secondary-cluster-instance")
            .clusterIdentifier(secondaryCluster.id())
            .instanceClass("db.r5.large")
            .dbSubnetGroupName("default")
            .build(), CustomResourceOptions.builder()
                .provider(aws.secondary())
                .dependsOn(primaryClusterInstance)
                .build());

    }
}
```

</details>

## [*partial failure*] #/resources/aws:worklink/websiteCertificateAuthorityAssociation:WebsiteCertificateAuthorityAssociation

### HCL

```terraform
resource "aws_worklink_fleet" "example" {
  name = "example"
}

resource "aws_worklink_website_certificate_authority_association" "test" {
  fleet_arn   = aws_worklink_fleet.test.arn
  certificate = file("certificate.pem")
}

```

### Failed Languages

#### yaml

```text
.pp:4,17-44: Failed to generate YAML program: Unknown Function; YAML does not support Fn::readFile.
```

### Successes

<details>

<summary>typescript</summary>

```typescript
import * as pulumi from "@pulumi/pulumi";
import * as aws from "@pulumi/aws";
import * as fs from "fs";

const example = new aws.worklink.Fleet("example", {});
const test = new aws.worklink.WebsiteCertificateAuthorityAssociation("test", {
    fleetArn: aws_worklink_fleet.test.arn,
    certificate: fs.readFileSync("certificate.pem"),
});
```

</details>

<details>

<summary>python</summary>

```python
import pulumi
import pulumi_aws as aws

example = aws.worklink.Fleet("example")
test = aws.worklink.WebsiteCertificateAuthorityAssociation("test",
    fleet_arn=aws_worklink_fleet["test"]["arn"],
    certificate=(lambda path: open(path).read())("certificate.pem"))
```

</details>

<details>

<summary>csharp</summary>

```csharp
using System.Collections.Generic;
using System.IO;
using Pulumi;
using Aws = Pulumi.Aws;

return await Deployment.RunAsync(() => 
{
    var example = new Aws.WorkLink.Fleet("example");

    var test = new Aws.WorkLink.WebsiteCertificateAuthorityAssociation("test", new()
    {
        FleetArn = aws_worklink_fleet.Test.Arn,
        Certificate = File.ReadAllText("certificate.pem"),
    });

});
```

</details>

<details>

<summary>go</summary>

```go
package main

import (
	"io/ioutil"

	"github.com/pulumi/pulumi-aws/sdk/v5/go/aws/worklink"
	"github.com/pulumi/pulumi/sdk/v3/go/pulumi"
)

func readFileOrPanic(path string) pulumi.StringPtrInput {
	data, err := ioutil.ReadFile(path)
	if err != nil {
		panic(err.Error())
	}
	return pulumi.String(string(data))
}

func main() {
	pulumi.Run(func(ctx *pulumi.Context) error {
		_, err := worklink.NewFleet(ctx, "example", nil)
		if err != nil {
			return err
		}
		_, err = worklink.NewWebsiteCertificateAuthorityAssociation(ctx, "test", &worklink.WebsiteCertificateAuthorityAssociationArgs{
			FleetArn:    pulumi.Any(aws_worklink_fleet.Test.Arn),
			Certificate: readFileOrPanic("certificate.pem"),
		})
		if err != nil {
			return err
		}
		return nil
	})
}
```

</details>

<details>

<summary>java</summary>

```java
package generated_program;

import com.pulumi.Context;
import com.pulumi.Pulumi;
import com.pulumi.core.Output;
import com.pulumi.aws.worklink.Fleet;
import com.pulumi.aws.worklink.WebsiteCertificateAuthorityAssociation;
import com.pulumi.aws.worklink.WebsiteCertificateAuthorityAssociationArgs;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;

public class App {
    public static void main(String[] args) {
        Pulumi.run(App::stack);
    }

    public static void stack(Context ctx) {
        var example = new Fleet("example");

        var test = new WebsiteCertificateAuthorityAssociation("test", WebsiteCertificateAuthorityAssociationArgs.builder()        
            .fleetArn(aws_worklink_fleet.test().arn())
            .certificate(Files.readString(Paths.get("certificate.pem")))
            .build());

    }
}
```

</details>

## [*partial failure*] #/resources/aws:elb/loadBalancerPolicy:LoadBalancerPolicy

### HCL

```terraform
resource "aws_elb" "wu-tang" {
  name               = "wu-tang"
  availability_zones = ["us-east-1a"]

  listener {
    instance_port      = 443
    instance_protocol  = "http"
    lb_port            = 443
    lb_protocol        = "https"
    ssl_certificate_id = "arn:aws:iam::000000000000:server-certificate/wu-tang.net"
  }

  tags = {
    Name = "wu-tang"
  }
}

resource "aws_load_balancer_policy" "wu-tang-ca-pubkey-policy" {
  load_balancer_name = aws_elb.wu-tang.name
  policy_name        = "wu-tang-ca-pubkey-policy"
  policy_type_name   = "PublicKeyPolicyType"

  # The public key of a CA certificate file can be extracted with:
  # $ cat wu-tang-ca.pem | openssl x509 -pubkey -noout | grep -v '\-\-\-\-' | tr -d '\n' > wu-tang-pubkey
  policy_attribute {
    name  = "PublicKey"
    value = file("wu-tang-pubkey")
  }
}

resource "aws_load_balancer_policy" "wu-tang-root-ca-backend-auth-policy" {
  load_balancer_name = aws_elb.wu-tang.name
  policy_name        = "wu-tang-root-ca-backend-auth-policy"
  policy_type_name   = "BackendServerAuthenticationPolicyType"

  policy_attribute {
    name  = "PublicKeyPolicyName"
    value = aws_load_balancer_policy.wu-tang-root-ca-pubkey-policy.policy_name
  }
}

resource "aws_load_balancer_policy" "wu-tang-ssl" {
  load_balancer_name = aws_elb.wu-tang.name
  policy_name        = "wu-tang-ssl"
  policy_type_name   = "SSLNegotiationPolicyType"

  policy_attribute {
    name  = "ECDHE-ECDSA-AES128-GCM-SHA256"
    value = "true"
  }

  policy_attribute {
    name  = "Protocol-TLSv1.2"
    value = "true"
  }
}

resource "aws_load_balancer_policy" "wu-tang-ssl-tls-1-1" {
  load_balancer_name = aws_elb.wu-tang.name
  policy_name        = "wu-tang-ssl"
  policy_type_name   = "SSLNegotiationPolicyType"

  policy_attribute {
    name  = "Reference-Security-Policy"
    value = "ELBSecurityPolicy-TLS-1-1-2017-01"
  }
}

resource "aws_load_balancer_backend_server_policy" "wu-tang-backend-auth-policies-443" {
  load_balancer_name = aws_elb.wu-tang.name
  instance_port      = 443

  policy_names = [
    aws_load_balancer_policy.wu-tang-root-ca-backend-auth-policy.policy_name,
  ]
}

resource "aws_load_balancer_listener_policy" "wu-tang-listener-policies-443" {
  load_balancer_name = aws_elb.wu-tang.name
  load_balancer_port = 443

  policy_names = [
    aws_load_balancer_policy.wu-tang-ssl.policy_name,
  ]
}

```

### Failed Languages

#### yaml

```text
.pp:14,21-29: Invalid property name access; 'wu-tang' is not a valid property name access. It has been changed to a quoted key access., and 9 other diagnostic(s)
```

### Successes

<details>

<summary>typescript</summary>

```typescript
import * as pulumi from "@pulumi/pulumi";
import * as aws from "@pulumi/aws";
import * as fs from "fs";

const wu_tang = new aws.elb.LoadBalancer("wu-tang", {
    availabilityZones: ["us-east-1a"],
    listeners: [{
        instancePort: 443,
        instanceProtocol: "http",
        lbPort: 443,
        lbProtocol: "https",
        sslCertificateId: "arn:aws:iam::000000000000:server-certificate/wu-tang.net",
    }],
    tags: {
        Name: "wu-tang",
    },
});
const wu_tang_ca_pubkey_policy = new aws.elb.LoadBalancerPolicy("wu-tang-ca-pubkey-policy", {
    loadBalancerName: wu_tang.name,
    policyName: "wu-tang-ca-pubkey-policy",
    policyTypeName: "PublicKeyPolicyType",
    policyAttributes: [{
        name: "PublicKey",
        value: fs.readFileSync("wu-tang-pubkey"),
    }],
});
const wu_tang_root_ca_backend_auth_policy = new aws.elb.LoadBalancerPolicy("wu-tang-root-ca-backend-auth-policy", {
    loadBalancerName: wu_tang.name,
    policyName: "wu-tang-root-ca-backend-auth-policy",
    policyTypeName: "BackendServerAuthenticationPolicyType",
    policyAttributes: [{
        name: "PublicKeyPolicyName",
        value: aws_load_balancer_policy["wu-tang-root-ca-pubkey-policy"].policy_name,
    }],
});
const wu_tang_ssl = new aws.elb.LoadBalancerPolicy("wu-tang-ssl", {
    loadBalancerName: wu_tang.name,
    policyName: "wu-tang-ssl",
    policyTypeName: "SSLNegotiationPolicyType",
    policyAttributes: [
        {
            name: "ECDHE-ECDSA-AES128-GCM-SHA256",
            value: "true",
        },
        {
            name: "Protocol-TLSv1.2",
            value: "true",
        },
    ],
});
const wu_tang_ssl_tls_1_1 = new aws.elb.LoadBalancerPolicy("wu-tang-ssl-tls-1-1", {
    loadBalancerName: wu_tang.name,
    policyName: "wu-tang-ssl",
    policyTypeName: "SSLNegotiationPolicyType",
    policyAttributes: [{
        name: "Reference-Security-Policy",
        value: "ELBSecurityPolicy-TLS-1-1-2017-01",
    }],
});
const wu_tang_backend_auth_policies_443 = new aws.elb.LoadBalancerBackendServerPolicy("wu-tang-backend-auth-policies-443", {
    loadBalancerName: wu_tang.name,
    instancePort: 443,
    policyNames: [wu_tang_root_ca_backend_auth_policy.policyName],
});
const wu_tang_listener_policies_443 = new aws.elb.ListenerPolicy("wu-tang-listener-policies-443", {
    loadBalancerName: wu_tang.name,
    loadBalancerPort: 443,
    policyNames: [wu_tang_ssl.policyName],
});
```

</details>

<details>

<summary>python</summary>

```python
import pulumi
import pulumi_aws as aws

wu_tang = aws.elb.LoadBalancer("wu-tang",
    availability_zones=["us-east-1a"],
    listeners=[aws.elb.LoadBalancerListenerArgs(
        instance_port=443,
        instance_protocol="http",
        lb_port=443,
        lb_protocol="https",
        ssl_certificate_id="arn:aws:iam::000000000000:server-certificate/wu-tang.net",
    )],
    tags={
        "Name": "wu-tang",
    })
wu_tang_ca_pubkey_policy = aws.elb.LoadBalancerPolicy("wu-tang-ca-pubkey-policy",
    load_balancer_name=wu_tang.name,
    policy_name="wu-tang-ca-pubkey-policy",
    policy_type_name="PublicKeyPolicyType",
    policy_attributes=[aws.elb.LoadBalancerPolicyPolicyAttributeArgs(
        name="PublicKey",
        value=(lambda path: open(path).read())("wu-tang-pubkey"),
    )])
wu_tang_root_ca_backend_auth_policy = aws.elb.LoadBalancerPolicy("wu-tang-root-ca-backend-auth-policy",
    load_balancer_name=wu_tang.name,
    policy_name="wu-tang-root-ca-backend-auth-policy",
    policy_type_name="BackendServerAuthenticationPolicyType",
    policy_attributes=[aws.elb.LoadBalancerPolicyPolicyAttributeArgs(
        name="PublicKeyPolicyName",
        value=aws_load_balancer_policy["wu-tang-root-ca-pubkey-policy"]["policy_name"],
    )])
wu_tang_ssl = aws.elb.LoadBalancerPolicy("wu-tang-ssl",
    load_balancer_name=wu_tang.name,
    policy_name="wu-tang-ssl",
    policy_type_name="SSLNegotiationPolicyType",
    policy_attributes=[
        aws.elb.LoadBalancerPolicyPolicyAttributeArgs(
            name="ECDHE-ECDSA-AES128-GCM-SHA256",
            value="true",
        ),
        aws.elb.LoadBalancerPolicyPolicyAttributeArgs(
            name="Protocol-TLSv1.2",
            value="true",
        ),
    ])
wu_tang_ssl_tls_1_1 = aws.elb.LoadBalancerPolicy("wu-tang-ssl-tls-1-1",
    load_balancer_name=wu_tang.name,
    policy_name="wu-tang-ssl",
    policy_type_name="SSLNegotiationPolicyType",
    policy_attributes=[aws.elb.LoadBalancerPolicyPolicyAttributeArgs(
        name="Reference-Security-Policy",
        value="ELBSecurityPolicy-TLS-1-1-2017-01",
    )])
wu_tang_backend_auth_policies_443 = aws.elb.LoadBalancerBackendServerPolicy("wu-tang-backend-auth-policies-443",
    load_balancer_name=wu_tang.name,
    instance_port=443,
    policy_names=[wu_tang_root_ca_backend_auth_policy.policy_name])
wu_tang_listener_policies_443 = aws.elb.ListenerPolicy("wu-tang-listener-policies-443",
    load_balancer_name=wu_tang.name,
    load_balancer_port=443,
    policy_names=[wu_tang_ssl.policy_name])
```

</details>

<details>

<summary>csharp</summary>

```csharp
using System.Collections.Generic;
using System.IO;
using Pulumi;
using Aws = Pulumi.Aws;

return await Deployment.RunAsync(() => 
{
    var wu_tang = new Aws.Elb.LoadBalancer("wu-tang", new()
    {
        AvailabilityZones = new[]
        {
            "us-east-1a",
        },
        Listeners = new[]
        {
            new Aws.Elb.Inputs.LoadBalancerListenerArgs
            {
                InstancePort = 443,
                InstanceProtocol = "http",
                LbPort = 443,
                LbProtocol = "https",
                SslCertificateId = "arn:aws:iam::000000000000:server-certificate/wu-tang.net",
            },
        },
        Tags = 
        {
            { "Name", "wu-tang" },
        },
    });

    var wu_tang_ca_pubkey_policy = new Aws.Elb.LoadBalancerPolicy("wu-tang-ca-pubkey-policy", new()
    {
        LoadBalancerName = wu_tang.Name,
        PolicyName = "wu-tang-ca-pubkey-policy",
        PolicyTypeName = "PublicKeyPolicyType",
        PolicyAttributes = new[]
        {
            new Aws.Elb.Inputs.LoadBalancerPolicyPolicyAttributeArgs
            {
                Name = "PublicKey",
                Value = File.ReadAllText("wu-tang-pubkey"),
            },
        },
    });

    var wu_tang_root_ca_backend_auth_policy = new Aws.Elb.LoadBalancerPolicy("wu-tang-root-ca-backend-auth-policy", new()
    {
        LoadBalancerName = wu_tang.Name,
        PolicyName = "wu-tang-root-ca-backend-auth-policy",
        PolicyTypeName = "BackendServerAuthenticationPolicyType",
        PolicyAttributes = new[]
        {
            new Aws.Elb.Inputs.LoadBalancerPolicyPolicyAttributeArgs
            {
                Name = "PublicKeyPolicyName",
                Value = aws_load_balancer_policy.Wu_tang_root_ca_pubkey_policy.Policy_name,
            },
        },
    });

    var wu_tang_ssl = new Aws.Elb.LoadBalancerPolicy("wu-tang-ssl", new()
    {
        LoadBalancerName = wu_tang.Name,
        PolicyName = "wu-tang-ssl",
        PolicyTypeName = "SSLNegotiationPolicyType",
        PolicyAttributes = new[]
        {
            new Aws.Elb.Inputs.LoadBalancerPolicyPolicyAttributeArgs
            {
                Name = "ECDHE-ECDSA-AES128-GCM-SHA256",
                Value = "true",
            },
            new Aws.Elb.Inputs.LoadBalancerPolicyPolicyAttributeArgs
            {
                Name = "Protocol-TLSv1.2",
                Value = "true",
            },
        },
    });

    var wu_tang_ssl_tls_1_1 = new Aws.Elb.LoadBalancerPolicy("wu-tang-ssl-tls-1-1", new()
    {
        LoadBalancerName = wu_tang.Name,
        PolicyName = "wu-tang-ssl",
        PolicyTypeName = "SSLNegotiationPolicyType",
        PolicyAttributes = new[]
        {
            new Aws.Elb.Inputs.LoadBalancerPolicyPolicyAttributeArgs
            {
                Name = "Reference-Security-Policy",
                Value = "ELBSecurityPolicy-TLS-1-1-2017-01",
            },
        },
    });

    var wu_tang_backend_auth_policies_443 = new Aws.Elb.LoadBalancerBackendServerPolicy("wu-tang-backend-auth-policies-443", new()
    {
        LoadBalancerName = wu_tang.Name,
        InstancePort = 443,
        PolicyNames = new[]
        {
            wu_tang_root_ca_backend_auth_policy.PolicyName,
        },
    });

    var wu_tang_listener_policies_443 = new Aws.Elb.ListenerPolicy("wu-tang-listener-policies-443", new()
    {
        LoadBalancerName = wu_tang.Name,
        LoadBalancerPort = 443,
        PolicyNames = new[]
        {
            wu_tang_ssl.PolicyName,
        },
    });

});
```

</details>

<details>

<summary>go</summary>

```go
package main

import (
	"io/ioutil"

	"github.com/pulumi/pulumi-aws/sdk/v5/go/aws/elb"
	"github.com/pulumi/pulumi/sdk/v3/go/pulumi"
)

func readFileOrPanic(path string) pulumi.StringPtrInput {
	data, err := ioutil.ReadFile(path)
	if err != nil {
		panic(err.Error())
	}
	return pulumi.String(string(data))
}

func main() {
	pulumi.Run(func(ctx *pulumi.Context) error {
		_, err := elb.NewLoadBalancer(ctx, "wu-tang", &elb.LoadBalancerArgs{
			AvailabilityZones: pulumi.StringArray{
				pulumi.String("us-east-1a"),
			},
			Listeners: elb.LoadBalancerListenerArray{
				&elb.LoadBalancerListenerArgs{
					InstancePort:     pulumi.Int(443),
					InstanceProtocol: pulumi.String("http"),
					LbPort:           pulumi.Int(443),
					LbProtocol:       pulumi.String("https"),
					SslCertificateId: pulumi.String("arn:aws:iam::000000000000:server-certificate/wu-tang.net"),
				},
			},
			Tags: pulumi.StringMap{
				"Name": pulumi.String("wu-tang"),
			},
		})
		if err != nil {
			return err
		}
		_, err = elb.NewLoadBalancerPolicy(ctx, "wu-tang-ca-pubkey-policy", &elb.LoadBalancerPolicyArgs{
			LoadBalancerName: wu_tang.Name,
			PolicyName:       pulumi.String("wu-tang-ca-pubkey-policy"),
			PolicyTypeName:   pulumi.String("PublicKeyPolicyType"),
			PolicyAttributes: elb.LoadBalancerPolicyPolicyAttributeArray{
				&elb.LoadBalancerPolicyPolicyAttributeArgs{
					Name:  pulumi.String("PublicKey"),
					Value: readFileOrPanic("wu-tang-pubkey"),
				},
			},
		})
		if err != nil {
			return err
		}
		_, err = elb.NewLoadBalancerPolicy(ctx, "wu-tang-root-ca-backend-auth-policy", &elb.LoadBalancerPolicyArgs{
			LoadBalancerName: wu_tang.Name,
			PolicyName:       pulumi.String("wu-tang-root-ca-backend-auth-policy"),
			PolicyTypeName:   pulumi.String("BackendServerAuthenticationPolicyType"),
			PolicyAttributes: elb.LoadBalancerPolicyPolicyAttributeArray{
				&elb.LoadBalancerPolicyPolicyAttributeArgs{
					Name:  pulumi.String("PublicKeyPolicyName"),
					Value: pulumi.Any(aws_load_balancer_policy.Wu - tang - root - ca - pubkey - policy.Policy_name),
				},
			},
		})
		if err != nil {
			return err
		}
		_, err = elb.NewLoadBalancerPolicy(ctx, "wu-tang-ssl", &elb.LoadBalancerPolicyArgs{
			LoadBalancerName: wu_tang.Name,
			PolicyName:       pulumi.String("wu-tang-ssl"),
			PolicyTypeName:   pulumi.String("SSLNegotiationPolicyType"),
			PolicyAttributes: elb.LoadBalancerPolicyPolicyAttributeArray{
				&elb.LoadBalancerPolicyPolicyAttributeArgs{
					Name:  pulumi.String("ECDHE-ECDSA-AES128-GCM-SHA256"),
					Value: pulumi.String("true"),
				},
				&elb.LoadBalancerPolicyPolicyAttributeArgs{
					Name:  pulumi.String("Protocol-TLSv1.2"),
					Value: pulumi.String("true"),
				},
			},
		})
		if err != nil {
			return err
		}
		_, err = elb.NewLoadBalancerPolicy(ctx, "wu-tang-ssl-tls-1-1", &elb.LoadBalancerPolicyArgs{
			LoadBalancerName: wu_tang.Name,
			PolicyName:       pulumi.String("wu-tang-ssl"),
			PolicyTypeName:   pulumi.String("SSLNegotiationPolicyType"),
			PolicyAttributes: elb.LoadBalancerPolicyPolicyAttributeArray{
				&elb.LoadBalancerPolicyPolicyAttributeArgs{
					Name:  pulumi.String("Reference-Security-Policy"),
					Value: pulumi.String("ELBSecurityPolicy-TLS-1-1-2017-01"),
				},
			},
		})
		if err != nil {
			return err
		}
		_, err = elb.NewLoadBalancerBackendServerPolicy(ctx, "wu-tang-backend-auth-policies-443", &elb.LoadBalancerBackendServerPolicyArgs{
			LoadBalancerName: wu_tang.Name,
			InstancePort:     pulumi.Int(443),
			PolicyNames: pulumi.StringArray{
				wu_tang_root_ca_backend_auth_policy.PolicyName,
			},
		})
		if err != nil {
			return err
		}
		_, err = elb.NewListenerPolicy(ctx, "wu-tang-listener-policies-443", &elb.ListenerPolicyArgs{
			LoadBalancerName: wu_tang.Name,
			LoadBalancerPort: pulumi.Int(443),
			PolicyNames: pulumi.StringArray{
				wu_tang_ssl.PolicyName,
			},
		})
		if err != nil {
			return err
		}
		return nil
	})
}
```

</details>

<details>

<summary>java</summary>

```java
package generated_program;

import com.pulumi.Context;
import com.pulumi.Pulumi;
import com.pulumi.core.Output;
import com.pulumi.aws.elb.LoadBalancer;
import com.pulumi.aws.elb.LoadBalancerArgs;
import com.pulumi.aws.elb.inputs.LoadBalancerListenerArgs;
import com.pulumi.aws.elb.LoadBalancerPolicy;
import com.pulumi.aws.elb.LoadBalancerPolicyArgs;
import com.pulumi.aws.elb.inputs.LoadBalancerPolicyPolicyAttributeArgs;
import com.pulumi.aws.elb.LoadBalancerBackendServerPolicy;
import com.pulumi.aws.elb.LoadBalancerBackendServerPolicyArgs;
import com.pulumi.aws.elb.ListenerPolicy;
import com.pulumi.aws.elb.ListenerPolicyArgs;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;

public class App {
    public static void main(String[] args) {
        Pulumi.run(App::stack);
    }

    public static void stack(Context ctx) {
        var wu_tang = new LoadBalancer("wu-tang", LoadBalancerArgs.builder()        
            .availabilityZones("us-east-1a")
            .listeners(LoadBalancerListenerArgs.builder()
                .instancePort(443)
                .instanceProtocol("http")
                .lbPort(443)
                .lbProtocol("https")
                .sslCertificateId("arn:aws:iam::000000000000:server-certificate/wu-tang.net")
                .build())
            .tags(Map.of("Name", "wu-tang"))
            .build());

        var wu_tang_ca_pubkey_policy = new LoadBalancerPolicy("wu-tang-ca-pubkey-policy", LoadBalancerPolicyArgs.builder()        
            .loadBalancerName(wu_tang.name())
            .policyName("wu-tang-ca-pubkey-policy")
            .policyTypeName("PublicKeyPolicyType")
            .policyAttributes(LoadBalancerPolicyPolicyAttributeArgs.builder()
                .name("PublicKey")
                .value(Files.readString(Paths.get("wu-tang-pubkey")))
                .build())
            .build());

        var wu_tang_root_ca_backend_auth_policy = new LoadBalancerPolicy("wu-tang-root-ca-backend-auth-policy", LoadBalancerPolicyArgs.builder()        
            .loadBalancerName(wu_tang.name())
            .policyName("wu-tang-root-ca-backend-auth-policy")
            .policyTypeName("BackendServerAuthenticationPolicyType")
            .policyAttributes(LoadBalancerPolicyPolicyAttributeArgs.builder()
                .name("PublicKeyPolicyName")
                .value(aws_load_balancer_policy.wu-tang-root-ca-pubkey-policy().policy_name())
                .build())
            .build());

        var wu_tang_ssl = new LoadBalancerPolicy("wu-tang-ssl", LoadBalancerPolicyArgs.builder()        
            .loadBalancerName(wu_tang.name())
            .policyName("wu-tang-ssl")
            .policyTypeName("SSLNegotiationPolicyType")
            .policyAttributes(            
                LoadBalancerPolicyPolicyAttributeArgs.builder()
                    .name("ECDHE-ECDSA-AES128-GCM-SHA256")
                    .value("true")
                    .build(),
                LoadBalancerPolicyPolicyAttributeArgs.builder()
                    .name("Protocol-TLSv1.2")
                    .value("true")
                    .build())
            .build());

        var wu_tang_ssl_tls_1_1 = new LoadBalancerPolicy("wu-tang-ssl-tls-1-1", LoadBalancerPolicyArgs.builder()        
            .loadBalancerName(wu_tang.name())
            .policyName("wu-tang-ssl")
            .policyTypeName("SSLNegotiationPolicyType")
            .policyAttributes(LoadBalancerPolicyPolicyAttributeArgs.builder()
                .name("Reference-Security-Policy")
                .value("ELBSecurityPolicy-TLS-1-1-2017-01")
                .build())
            .build());

        var wu_tang_backend_auth_policies_443 = new LoadBalancerBackendServerPolicy("wu-tang-backend-auth-policies-443", LoadBalancerBackendServerPolicyArgs.builder()        
            .loadBalancerName(wu_tang.name())
            .instancePort(443)
            .policyNames(wu_tang_root_ca_backend_auth_policy.policyName())
            .build());

        var wu_tang_listener_policies_443 = new ListenerPolicy("wu-tang-listener-policies-443", ListenerPolicyArgs.builder()        
            .loadBalancerName(wu_tang.name())
            .loadBalancerPort(443)
            .policyNames(wu_tang_ssl.policyName())
            .build());

    }
}
```

</details>

## [*partial failure*] #/resources/aws:ec2/launchTemplate:LaunchTemplate

### HCL

```terraform
resource "aws_launch_template" "foo" {
  name = "foo"

  block_device_mappings {
    device_name = "/dev/sda1"

    ebs {
      volume_size = 20
    }
  }

  capacity_reservation_specification {
    capacity_reservation_preference = "open"
  }

  cpu_options {
    core_count       = 4
    threads_per_core = 2
  }

  credit_specification {
    cpu_credits = "standard"
  }

  disable_api_stop        = true
  disable_api_termination = true

  ebs_optimized = true

  elastic_gpu_specifications {
    type = "test"
  }

  elastic_inference_accelerator {
    type = "eia1.medium"
  }

  iam_instance_profile {
    name = "test"
  }

  image_id = "ami-test"

  instance_initiated_shutdown_behavior = "terminate"

  instance_market_options {
    market_type = "spot"
  }

  instance_type = "t2.micro"

  kernel_id = "test"

  key_name = "test"

  license_specification {
    license_configuration_arn = "arn:aws:license-manager:eu-west-1:123456789012:license-configuration:lic-0123456789abcdef0123456789abcdef"
  }

  metadata_options {
    http_endpoint               = "enabled"
    http_tokens                 = "required"
    http_put_response_hop_limit = 1
    instance_metadata_tags      = "enabled"
  }

  monitoring {
    enabled = true
  }

  network_interfaces {
    associate_public_ip_address = true
  }

  placement {
    availability_zone = "us-west-2a"
  }

  ram_disk_id = "test"

  vpc_security_group_ids = ["sg-12345678"]

  tag_specifications {
    resource_type = "instance"

    tags = {
      Name = "test"
    }
  }

  user_data = filebase64("${path.module}/example.sh")
}

```

### Failed Languages

#### yaml

```text
.pp:63,14-53: Failed to generate YAML program: Unknown Function; YAML does not support Fn::filebase64.
```

### Successes

<details>

<summary>typescript</summary>

```typescript
import * as pulumi from "@pulumi/pulumi";
import * as aws from "@pulumi/aws";
import * as fs from "fs";

const foo = new aws.ec2.LaunchTemplate("foo", {
    blockDeviceMappings: [{
        deviceName: "/dev/sda1",
        ebs: {
            volumeSize: 20,
        },
    }],
    capacityReservationSpecification: {
        capacityReservationPreference: "open",
    },
    cpuOptions: {
        coreCount: 4,
        threadsPerCore: 2,
    },
    creditSpecification: {
        cpuCredits: "standard",
    },
    disableApiStop: true,
    disableApiTermination: true,
    ebsOptimized: "true",
    elasticGpuSpecifications: [{
        type: "test",
    }],
    elasticInferenceAccelerator: {
        type: "eia1.medium",
    },
    iamInstanceProfile: {
        name: "test",
    },
    imageId: "ami-test",
    instanceInitiatedShutdownBehavior: "terminate",
    instanceMarketOptions: {
        marketType: "spot",
    },
    instanceType: "t2.micro",
    kernelId: "test",
    keyName: "test",
    licenseSpecifications: [{
        licenseConfigurationArn: "arn:aws:license-manager:eu-west-1:123456789012:license-configuration:lic-0123456789abcdef0123456789abcdef",
    }],
    metadataOptions: {
        httpEndpoint: "enabled",
        httpTokens: "required",
        httpPutResponseHopLimit: 1,
        instanceMetadataTags: "enabled",
    },
    monitoring: {
        enabled: true,
    },
    networkInterfaces: [{
        associatePublicIpAddress: "true",
    }],
    placement: {
        availabilityZone: "us-west-2a",
    },
    ramDiskId: "test",
    vpcSecurityGroupIds: ["sg-12345678"],
    tagSpecifications: [{
        resourceType: "instance",
        tags: {
            Name: "test",
        },
    }],
    userData: Buffer.from(fs.readFileSync(`${path.module}/example.sh`), 'binary').toString('base64'),
});
```

</details>

<details>

<summary>python</summary>

```python
import pulumi
import base64
import pulumi_aws as aws

foo = aws.ec2.LaunchTemplate("foo",
    block_device_mappings=[aws.ec2.LaunchTemplateBlockDeviceMappingArgs(
        device_name="/dev/sda1",
        ebs=aws.ec2.LaunchTemplateBlockDeviceMappingEbsArgs(
            volume_size=20,
        ),
    )],
    capacity_reservation_specification=aws.ec2.LaunchTemplateCapacityReservationSpecificationArgs(
        capacity_reservation_preference="open",
    ),
    cpu_options=aws.ec2.LaunchTemplateCpuOptionsArgs(
        core_count=4,
        threads_per_core=2,
    ),
    credit_specification=aws.ec2.LaunchTemplateCreditSpecificationArgs(
        cpu_credits="standard",
    ),
    disable_api_stop=True,
    disable_api_termination=True,
    ebs_optimized="true",
    elastic_gpu_specifications=[aws.ec2.LaunchTemplateElasticGpuSpecificationArgs(
        type="test",
    )],
    elastic_inference_accelerator=aws.ec2.LaunchTemplateElasticInferenceAcceleratorArgs(
        type="eia1.medium",
    ),
    iam_instance_profile=aws.ec2.LaunchTemplateIamInstanceProfileArgs(
        name="test",
    ),
    image_id="ami-test",
    instance_initiated_shutdown_behavior="terminate",
    instance_market_options=aws.ec2.LaunchTemplateInstanceMarketOptionsArgs(
        market_type="spot",
    ),
    instance_type="t2.micro",
    kernel_id="test",
    key_name="test",
    license_specifications=[aws.ec2.LaunchTemplateLicenseSpecificationArgs(
        license_configuration_arn="arn:aws:license-manager:eu-west-1:123456789012:license-configuration:lic-0123456789abcdef0123456789abcdef",
    )],
    metadata_options=aws.ec2.LaunchTemplateMetadataOptionsArgs(
        http_endpoint="enabled",
        http_tokens="required",
        http_put_response_hop_limit=1,
        instance_metadata_tags="enabled",
    ),
    monitoring=aws.ec2.LaunchTemplateMonitoringArgs(
        enabled=True,
    ),
    network_interfaces=[aws.ec2.LaunchTemplateNetworkInterfaceArgs(
        associate_public_ip_address="true",
    )],
    placement=aws.ec2.LaunchTemplatePlacementArgs(
        availability_zone="us-west-2a",
    ),
    ram_disk_id="test",
    vpc_security_group_ids=["sg-12345678"],
    tag_specifications=[aws.ec2.LaunchTemplateTagSpecificationArgs(
        resource_type="instance",
        tags={
            "Name": "test",
        },
    )],
    user_data=(lambda path: base64.b64encode(open(path).read().encode()).decode())(f"{path['module']}/example.sh"))
```

</details>

<details>

<summary>csharp</summary>

```csharp
using System;
using System.Collections.Generic;
using System.IO;
using Pulumi;
using Aws = Pulumi.Aws;

	private static string ReadFileBase64(string path) {
		return Convert.ToBase64String(Encoding.UTF8.GetBytes(File.ReadAllText(path)))
	}

return await Deployment.RunAsync(() => 
{
    var foo = new Aws.Ec2.LaunchTemplate("foo", new()
    {
        BlockDeviceMappings = new[]
        {
            new Aws.Ec2.Inputs.LaunchTemplateBlockDeviceMappingArgs
            {
                DeviceName = "/dev/sda1",
                Ebs = new Aws.Ec2.Inputs.LaunchTemplateBlockDeviceMappingEbsArgs
                {
                    VolumeSize = 20,
                },
            },
        },
        CapacityReservationSpecification = new Aws.Ec2.Inputs.LaunchTemplateCapacityReservationSpecificationArgs
        {
            CapacityReservationPreference = "open",
        },
        CpuOptions = new Aws.Ec2.Inputs.LaunchTemplateCpuOptionsArgs
        {
            CoreCount = 4,
            ThreadsPerCore = 2,
        },
        CreditSpecification = new Aws.Ec2.Inputs.LaunchTemplateCreditSpecificationArgs
        {
            CpuCredits = "standard",
        },
        DisableApiStop = true,
        DisableApiTermination = true,
        EbsOptimized = "true",
        ElasticGpuSpecifications = new[]
        {
            new Aws.Ec2.Inputs.LaunchTemplateElasticGpuSpecificationArgs
            {
                Type = "test",
            },
        },
        ElasticInferenceAccelerator = new Aws.Ec2.Inputs.LaunchTemplateElasticInferenceAcceleratorArgs
        {
            Type = "eia1.medium",
        },
        IamInstanceProfile = new Aws.Ec2.Inputs.LaunchTemplateIamInstanceProfileArgs
        {
            Name = "test",
        },
        ImageId = "ami-test",
        InstanceInitiatedShutdownBehavior = "terminate",
        InstanceMarketOptions = new Aws.Ec2.Inputs.LaunchTemplateInstanceMarketOptionsArgs
        {
            MarketType = "spot",
        },
        InstanceType = "t2.micro",
        KernelId = "test",
        KeyName = "test",
        LicenseSpecifications = new[]
        {
            new Aws.Ec2.Inputs.LaunchTemplateLicenseSpecificationArgs
            {
                LicenseConfigurationArn = "arn:aws:license-manager:eu-west-1:123456789012:license-configuration:lic-0123456789abcdef0123456789abcdef",
            },
        },
        MetadataOptions = new Aws.Ec2.Inputs.LaunchTemplateMetadataOptionsArgs
        {
            HttpEndpoint = "enabled",
            HttpTokens = "required",
            HttpPutResponseHopLimit = 1,
            InstanceMetadataTags = "enabled",
        },
        Monitoring = new Aws.Ec2.Inputs.LaunchTemplateMonitoringArgs
        {
            Enabled = true,
        },
        NetworkInterfaces = new[]
        {
            new Aws.Ec2.Inputs.LaunchTemplateNetworkInterfaceArgs
            {
                AssociatePublicIpAddress = "true",
            },
        },
        Placement = new Aws.Ec2.Inputs.LaunchTemplatePlacementArgs
        {
            AvailabilityZone = "us-west-2a",
        },
        RamDiskId = "test",
        VpcSecurityGroupIds = new[]
        {
            "sg-12345678",
        },
        TagSpecifications = new[]
        {
            new Aws.Ec2.Inputs.LaunchTemplateTagSpecificationArgs
            {
                ResourceType = "instance",
                Tags = 
                {
                    { "Name", "test" },
                },
            },
        },
        UserData = ReadFileBase64($"{path.Module}/example.sh"),
    });

});
```

</details>

<details>

<summary>go</summary>

```go
package main

import (
	"encoding/base64"
	"fmt"
	"io/ioutil"

	"github.com/pulumi/pulumi-aws/sdk/v5/go/aws/ec2"
	"github.com/pulumi/pulumi/sdk/v3/go/pulumi"
)

func filebase64OrPanic(path string) pulumi.StringPtrInput {
	if fileData, err := ioutil.ReadFile(path); err == nil {
		return pulumi.String(base64.StdEncoding.EncodeToString(fileData[:]))
	} else {
		panic(err.Error())
	}
}

func main() {
	pulumi.Run(func(ctx *pulumi.Context) error {
		_, err := ec2.NewLaunchTemplate(ctx, "foo", &ec2.LaunchTemplateArgs{
			BlockDeviceMappings: ec2.LaunchTemplateBlockDeviceMappingArray{
				&ec2.LaunchTemplateBlockDeviceMappingArgs{
					DeviceName: pulumi.String("/dev/sda1"),
					Ebs: &ec2.LaunchTemplateBlockDeviceMappingEbsArgs{
						VolumeSize: pulumi.Int(20),
					},
				},
			},
			CapacityReservationSpecification: &ec2.LaunchTemplateCapacityReservationSpecificationArgs{
				CapacityReservationPreference: pulumi.String("open"),
			},
			CpuOptions: &ec2.LaunchTemplateCpuOptionsArgs{
				CoreCount:      pulumi.Int(4),
				ThreadsPerCore: pulumi.Int(2),
			},
			CreditSpecification: &ec2.LaunchTemplateCreditSpecificationArgs{
				CpuCredits: pulumi.String("standard"),
			},
			DisableApiStop:        pulumi.Bool(true),
			DisableApiTermination: pulumi.Bool(true),
			EbsOptimized:          pulumi.String("true"),
			ElasticGpuSpecifications: ec2.LaunchTemplateElasticGpuSpecificationArray{
				&ec2.LaunchTemplateElasticGpuSpecificationArgs{
					Type: pulumi.String("test"),
				},
			},
			ElasticInferenceAccelerator: &ec2.LaunchTemplateElasticInferenceAcceleratorArgs{
				Type: pulumi.String("eia1.medium"),
			},
			IamInstanceProfile: &ec2.LaunchTemplateIamInstanceProfileArgs{
				Name: pulumi.String("test"),
			},
			ImageId:                           pulumi.String("ami-test"),
			InstanceInitiatedShutdownBehavior: pulumi.String("terminate"),
			InstanceMarketOptions: &ec2.LaunchTemplateInstanceMarketOptionsArgs{
				MarketType: pulumi.String("spot"),
			},
			InstanceType: pulumi.String("t2.micro"),
			KernelId:     pulumi.String("test"),
			KeyName:      pulumi.String("test"),
			LicenseSpecifications: ec2.LaunchTemplateLicenseSpecificationArray{
				&ec2.LaunchTemplateLicenseSpecificationArgs{
					LicenseConfigurationArn: pulumi.String("arn:aws:license-manager:eu-west-1:123456789012:license-configuration:lic-0123456789abcdef0123456789abcdef"),
				},
			},
			MetadataOptions: &ec2.LaunchTemplateMetadataOptionsArgs{
				HttpEndpoint:            pulumi.String("enabled"),
				HttpTokens:              pulumi.String("required"),
				HttpPutResponseHopLimit: pulumi.Int(1),
				InstanceMetadataTags:    pulumi.String("enabled"),
			},
			Monitoring: &ec2.LaunchTemplateMonitoringArgs{
				Enabled: pulumi.Bool(true),
			},
			NetworkInterfaces: ec2.LaunchTemplateNetworkInterfaceArray{
				&ec2.LaunchTemplateNetworkInterfaceArgs{
					AssociatePublicIpAddress: pulumi.String("true"),
				},
			},
			Placement: &ec2.LaunchTemplatePlacementArgs{
				AvailabilityZone: pulumi.String("us-west-2a"),
			},
			RamDiskId: pulumi.String("test"),
			VpcSecurityGroupIds: pulumi.StringArray{
				pulumi.String("sg-12345678"),
			},
			TagSpecifications: ec2.LaunchTemplateTagSpecificationArray{
				&ec2.LaunchTemplateTagSpecificationArgs{
					ResourceType: pulumi.String("instance"),
					Tags: pulumi.StringMap{
						"Name": pulumi.String("test"),
					},
				},
			},
			UserData: filebase64OrPanic(fmt.Sprintf("%v/example.sh", path.Module)),
		})
		if err != nil {
			return err
		}
		return nil
	})
}
```

</details>

<details>

<summary>java</summary>

```java
package generated_program;

import com.pulumi.Context;
import com.pulumi.Pulumi;
import com.pulumi.core.Output;
import com.pulumi.aws.ec2.LaunchTemplate;
import com.pulumi.aws.ec2.LaunchTemplateArgs;
import com.pulumi.aws.ec2.inputs.LaunchTemplateBlockDeviceMappingArgs;
import com.pulumi.aws.ec2.inputs.LaunchTemplateBlockDeviceMappingEbsArgs;
import com.pulumi.aws.ec2.inputs.LaunchTemplateCapacityReservationSpecificationArgs;
import com.pulumi.aws.ec2.inputs.LaunchTemplateCpuOptionsArgs;
import com.pulumi.aws.ec2.inputs.LaunchTemplateCreditSpecificationArgs;
import com.pulumi.aws.ec2.inputs.LaunchTemplateElasticGpuSpecificationArgs;
import com.pulumi.aws.ec2.inputs.LaunchTemplateElasticInferenceAcceleratorArgs;
import com.pulumi.aws.ec2.inputs.LaunchTemplateIamInstanceProfileArgs;
import com.pulumi.aws.ec2.inputs.LaunchTemplateInstanceMarketOptionsArgs;
import com.pulumi.aws.ec2.inputs.LaunchTemplateLicenseSpecificationArgs;
import com.pulumi.aws.ec2.inputs.LaunchTemplateMetadataOptionsArgs;
import com.pulumi.aws.ec2.inputs.LaunchTemplateMonitoringArgs;
import com.pulumi.aws.ec2.inputs.LaunchTemplateNetworkInterfaceArgs;
import com.pulumi.aws.ec2.inputs.LaunchTemplatePlacementArgs;
import com.pulumi.aws.ec2.inputs.LaunchTemplateTagSpecificationArgs;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;

public class App {
    public static void main(String[] args) {
        Pulumi.run(App::stack);
    }

    public static void stack(Context ctx) {
        var foo = new LaunchTemplate("foo", LaunchTemplateArgs.builder()        
            .blockDeviceMappings(LaunchTemplateBlockDeviceMappingArgs.builder()
                .deviceName("/dev/sda1")
                .ebs(LaunchTemplateBlockDeviceMappingEbsArgs.builder()
                    .volumeSize(20)
                    .build())
                .build())
            .capacityReservationSpecification(LaunchTemplateCapacityReservationSpecificationArgs.builder()
                .capacityReservationPreference("open")
                .build())
            .cpuOptions(LaunchTemplateCpuOptionsArgs.builder()
                .coreCount(4)
                .threadsPerCore(2)
                .build())
            .creditSpecification(LaunchTemplateCreditSpecificationArgs.builder()
                .cpuCredits("standard")
                .build())
            .disableApiStop(true)
            .disableApiTermination(true)
            .ebsOptimized(true)
            .elasticGpuSpecifications(LaunchTemplateElasticGpuSpecificationArgs.builder()
                .type("test")
                .build())
            .elasticInferenceAccelerator(LaunchTemplateElasticInferenceAcceleratorArgs.builder()
                .type("eia1.medium")
                .build())
            .iamInstanceProfile(LaunchTemplateIamInstanceProfileArgs.builder()
                .name("test")
                .build())
            .imageId("ami-test")
            .instanceInitiatedShutdownBehavior("terminate")
            .instanceMarketOptions(LaunchTemplateInstanceMarketOptionsArgs.builder()
                .marketType("spot")
                .build())
            .instanceType("t2.micro")
            .kernelId("test")
            .keyName("test")
            .licenseSpecifications(LaunchTemplateLicenseSpecificationArgs.builder()
                .licenseConfigurationArn("arn:aws:license-manager:eu-west-1:123456789012:license-configuration:lic-0123456789abcdef0123456789abcdef")
                .build())
            .metadataOptions(LaunchTemplateMetadataOptionsArgs.builder()
                .httpEndpoint("enabled")
                .httpTokens("required")
                .httpPutResponseHopLimit(1)
                .instanceMetadataTags("enabled")
                .build())
            .monitoring(LaunchTemplateMonitoringArgs.builder()
                .enabled(true)
                .build())
            .networkInterfaces(LaunchTemplateNetworkInterfaceArgs.builder()
                .associatePublicIpAddress(true)
                .build())
            .placement(LaunchTemplatePlacementArgs.builder()
                .availabilityZone("us-west-2a")
                .build())
            .ramDiskId("test")
            .vpcSecurityGroupIds("sg-12345678")
            .tagSpecifications(LaunchTemplateTagSpecificationArgs.builder()
                .resourceType("instance")
                .tags(Map.of("Name", "test"))
                .build())
            .userData(Base64.getEncoder().encodeToString(Files.readAllBytes(Paths.get(String.format("%s/example.sh", path.module())))))
            .build());

    }
}
```

</details>

## [*partial failure*] Basic Example

### HCL

```terraform
resource "aws_cloudfront_function" "test" {
  name    = "test"
  runtime = "cloudfront-js-1.0"
  comment = "my function"
  publish = true
  code    = file("${path.module}/function.js")
}

```

### Failed Languages

#### yaml

```text
.pp:4,13-51: Failed to generate YAML program: Unknown Function; YAML does not support Fn::readFile.
```

### Successes

<details>

<summary>typescript</summary>

```typescript
import * as pulumi from "@pulumi/pulumi";
import * as aws from "@pulumi/aws";
import * as fs from "fs";

const test = new aws.cloudfront.Function("test", {
    runtime: "cloudfront-js-1.0",
    comment: "my function",
    publish: true,
    code: fs.readFileSync(`${path.module}/function.js`),
});
```

</details>

<details>

<summary>python</summary>

```python
import pulumi
import pulumi_aws as aws

test = aws.cloudfront.Function("test",
    runtime="cloudfront-js-1.0",
    comment="my function",
    publish=True,
    code=(lambda path: open(path).read())(f"{path['module']}/function.js"))
```

</details>

<details>

<summary>csharp</summary>

```csharp
using System.Collections.Generic;
using System.IO;
using Pulumi;
using Aws = Pulumi.Aws;

return await Deployment.RunAsync(() => 
{
    var test = new Aws.CloudFront.Function("test", new()
    {
        Runtime = "cloudfront-js-1.0",
        Comment = "my function",
        Publish = true,
        Code = File.ReadAllText($"{path.Module}/function.js"),
    });

});
```

</details>

<details>

<summary>go</summary>

```go
package main

import (
	"fmt"
	"io/ioutil"

	"github.com/pulumi/pulumi-aws/sdk/v5/go/aws/cloudfront"
	"github.com/pulumi/pulumi/sdk/v3/go/pulumi"
)

func readFileOrPanic(path string) pulumi.StringPtrInput {
	data, err := ioutil.ReadFile(path)
	if err != nil {
		panic(err.Error())
	}
	return pulumi.String(string(data))
}

func main() {
	pulumi.Run(func(ctx *pulumi.Context) error {
		_, err := cloudfront.NewFunction(ctx, "test", &cloudfront.FunctionArgs{
			Runtime: pulumi.String("cloudfront-js-1.0"),
			Comment: pulumi.String("my function"),
			Publish: pulumi.Bool(true),
			Code:    readFileOrPanic(fmt.Sprintf("%v/function.js", path.Module)),
		})
		if err != nil {
			return err
		}
		return nil
	})
}
```

</details>

<details>

<summary>java</summary>

```java
package generated_program;

import com.pulumi.Context;
import com.pulumi.Pulumi;
import com.pulumi.core.Output;
import com.pulumi.aws.cloudfront.Function;
import com.pulumi.aws.cloudfront.FunctionArgs;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;

public class App {
    public static void main(String[] args) {
        Pulumi.run(App::stack);
    }

    public static void stack(Context ctx) {
        var test = new Function("test", FunctionArgs.builder()        
            .runtime("cloudfront-js-1.0")
            .comment("my function")
            .publish(true)
            .code(Files.readString(Paths.get(String.format("%s/function.js", path.module()))))
            .build());

    }
}
```

</details>

## [*partial failure*] #/resources/aws:apigateway/stage:Stage

### HCL

```terraform
resource "aws_api_gateway_rest_api" "example" {
  body = jsonencode({
    openapi = "3.0.1"
    info = {
      title   = "example"
      version = "1.0"
    }
    paths = {
      "/path1" = {
        get = {
          x-amazon-apigateway-integration = {
            httpMethod           = "GET"
            payloadFormatVersion = "1.0"
            type                 = "HTTP_PROXY"
            uri                  = "https://ip-ranges.amazonaws.com/ip-ranges.json"
          }
        }
      }
    }
  })

  name = "example"
}

resource "aws_api_gateway_deployment" "example" {
  rest_api_id = aws_api_gateway_rest_api.example.id

  triggers = {
    redeployment = sha1(jsonencode(aws_api_gateway_rest_api.example.body))
  }

  lifecycle {
    create_before_destroy = true
  }
}

resource "aws_api_gateway_stage" "example" {
  deployment_id = aws_api_gateway_deployment.example.id
  rest_api_id   = aws_api_gateway_rest_api.example.id
  stage_name    = "example"
}

resource "aws_api_gateway_method_settings" "example" {
  rest_api_id = aws_api_gateway_rest_api.example.id
  stage_name  = aws_api_gateway_stage.example.stage_name
  method_path = "*/*"

  settings {
    metrics_enabled = true
    logging_level   = "INFO"
  }
}

```

### Failed Languages

#### yaml

```text
.pp:24,20-53: Failed to generate YAML program: Unknown Function; YAML does not support Fn::sha1.
```

### Successes

<details>

<summary>typescript</summary>

```typescript
import * as pulumi from "@pulumi/pulumi";
import * as aws from "@pulumi/aws";
import * as crypto from "crypto";

const exampleRestApi = new aws.apigateway.RestApi("exampleRestApi", {body: JSON.stringify({
    openapi: "3.0.1",
    info: {
        title: "example",
        version: "1.0",
    },
    paths: {
        "/path1": {
            get: {
                "x-amazon-apigateway-integration": {
                    httpMethod: "GET",
                    payloadFormatVersion: "1.0",
                    type: "HTTP_PROXY",
                    uri: "https://ip-ranges.amazonaws.com/ip-ranges.json",
                },
            },
        },
    },
})});
const exampleDeployment = new aws.apigateway.Deployment("exampleDeployment", {
    restApi: exampleRestApi.id,
    triggers: {
        redeployment: exampleRestApi.body.apply(body => JSON.stringify(body)).apply(toJSON => crypto.createHash('sha1').update(toJSON).digest('hex')),
    },
});
const exampleStage = new aws.apigateway.Stage("exampleStage", {
    deployment: exampleDeployment.id,
    restApi: exampleRestApi.id,
    stageName: "example",
});
const exampleMethodSettings = new aws.apigateway.MethodSettings("exampleMethodSettings", {
    restApi: exampleRestApi.id,
    stageName: exampleStage.stageName,
    methodPath: "*/*",
    settings: {
        metricsEnabled: true,
        loggingLevel: "INFO",
    },
});
```

</details>

<details>

<summary>python</summary>

```python
import pulumi
import hashlib
import json
import pulumi_aws as aws

example_rest_api = aws.apigateway.RestApi("exampleRestApi", body=json.dumps({
    "openapi": "3.0.1",
    "info": {
        "title": "example",
        "version": "1.0",
    },
    "paths": {
        "/path1": {
            "get": {
                "x-amazon-apigateway-integration": {
                    "httpMethod": "GET",
                    "payloadFormatVersion": "1.0",
                    "type": "HTTP_PROXY",
                    "uri": "https://ip-ranges.amazonaws.com/ip-ranges.json",
                },
            },
        },
    },
}))
example_deployment = aws.apigateway.Deployment("exampleDeployment",
    rest_api=example_rest_api.id,
    triggers={
        "redeployment": example_rest_api.body.apply(lambda body: json.dumps(body)).apply(lambda to_json: hashlib.sha1(to_json.encode()).hexdigest()),
    })
example_stage = aws.apigateway.Stage("exampleStage",
    deployment=example_deployment.id,
    rest_api=example_rest_api.id,
    stage_name="example")
example_method_settings = aws.apigateway.MethodSettings("exampleMethodSettings",
    rest_api=example_rest_api.id,
    stage_name=example_stage.stage_name,
    method_path="*/*",
    settings=aws.apigateway.MethodSettingsSettingsArgs(
        metrics_enabled=True,
        logging_level="INFO",
    ))
```

</details>

<details>

<summary>csharp</summary>

```csharp
using System.Collections.Generic;
using System.Security.Cryptography;
using System.Text;
using System.Text.Json;
using Pulumi;
using Aws = Pulumi.Aws;

	private static string ComputeSHA1(string input) {
		return BitConverter.ToString(
			SHA1.Create().ComputeHash(Encoding.UTF8.GetBytes(input))
		).Replace("-","").ToLowerInvariant());
	}

return await Deployment.RunAsync(() => 
{
    var exampleRestApi = new Aws.ApiGateway.RestApi("exampleRestApi", new()
    {
        Body = JsonSerializer.Serialize(new Dictionary<string, object?>
        {
            ["openapi"] = "3.0.1",
            ["info"] = new Dictionary<string, object?>
            {
                ["title"] = "example",
                ["version"] = "1.0",
            },
            ["paths"] = new Dictionary<string, object?>
            {
                ["/path1"] = new Dictionary<string, object?>
                {
                    ["get"] = new Dictionary<string, object?>
                    {
                        ["x-amazon-apigateway-integration"] = new Dictionary<string, object?>
                        {
                            ["httpMethod"] = "GET",
                            ["payloadFormatVersion"] = "1.0",
                            ["type"] = "HTTP_PROXY",
                            ["uri"] = "https://ip-ranges.amazonaws.com/ip-ranges.json",
                        },
                    },
                },
            },
        }),
    });

    var exampleDeployment = new Aws.ApiGateway.Deployment("exampleDeployment", new()
    {
        RestApi = exampleRestApi.Id,
        Triggers = 
        {
            { "redeployment", exampleRestApi.Body.Apply(body => JsonSerializer.Serialize(body)).Apply(toJSON => ComputeSHA1(toJSON)) },
        },
    });

    var exampleStage = new Aws.ApiGateway.Stage("exampleStage", new()
    {
        Deployment = exampleDeployment.Id,
        RestApi = exampleRestApi.Id,
        StageName = "example",
    });

    var exampleMethodSettings = new Aws.ApiGateway.MethodSettings("exampleMethodSettings", new()
    {
        RestApi = exampleRestApi.Id,
        StageName = exampleStage.StageName,
        MethodPath = "*/*",
        Settings = new Aws.ApiGateway.Inputs.MethodSettingsSettingsArgs
        {
            MetricsEnabled = true,
            LoggingLevel = "INFO",
        },
    });

});
```

</details>

<details>

<summary>go</summary>

```go
package main

import (
	"crypto/sha1"
	"encoding/json"
	"fmt"

	"github.com/pulumi/pulumi-aws/sdk/v5/go/aws/apigateway"
	"github.com/pulumi/pulumi/sdk/v3/go/pulumi"
)

func sha1Hash(input string) string {
	hash := sha1.Sum([]byte(input))
	return hex.EncodeToString(hash[:])
}

func main() {
	pulumi.Run(func(ctx *pulumi.Context) error {
		tmpJSON0, err := json.Marshal(map[string]interface{}{
			"openapi": "3.0.1",
			"info": map[string]interface{}{
				"title":   "example",
				"version": "1.0",
			},
			"paths": map[string]interface{}{
				"/path1": map[string]interface{}{
					"get": map[string]interface{}{
						"x-amazon-apigateway-integration": map[string]interface{}{
							"httpMethod":           "GET",
							"payloadFormatVersion": "1.0",
							"type":                 "HTTP_PROXY",
							"uri":                  "https://ip-ranges.amazonaws.com/ip-ranges.json",
						},
					},
				},
			},
		})
		if err != nil {
			return err
		}
		json0 := string(tmpJSON0)
		exampleRestApi, err := apigateway.NewRestApi(ctx, "exampleRestApi", &apigateway.RestApiArgs{
			Body: pulumi.String(json0),
		})
		if err != nil {
			return err
		}
		exampleDeployment, err := apigateway.NewDeployment(ctx, "exampleDeployment", &apigateway.DeploymentArgs{
			RestApi: exampleRestApi.ID(),
			Triggers: pulumi.StringMap{
				"redeployment": exampleRestApi.Body.ApplyT(func(body string) (pulumi.String, error) {
					var _zero pulumi.String
					tmpJSON1, err := json.Marshal(body)
					if err != nil {
						return _zero, err
					}
					json1 := string(tmpJSON1)
					return json1, nil
				}).(pulumi.StringOutput).ApplyT(func(toJSON string) (pulumi.String, error) {
					return sha1Hash(toJSON), nil
				}).(pulumi.StringOutput),
			},
		})
		if err != nil {
			return err
		}
		exampleStage, err := apigateway.NewStage(ctx, "exampleStage", &apigateway.StageArgs{
			Deployment: exampleDeployment.ID(),
			RestApi:    exampleRestApi.ID(),
			StageName:  pulumi.String("example"),
		})
		if err != nil {
			return err
		}
		_, err = apigateway.NewMethodSettings(ctx, "exampleMethodSettings", &apigateway.MethodSettingsArgs{
			RestApi:    exampleRestApi.ID(),
			StageName:  exampleStage.StageName,
			MethodPath: pulumi.String("*/*"),
			Settings: &apigateway.MethodSettingsSettingsArgs{
				MetricsEnabled: pulumi.Bool(true),
				LoggingLevel:   pulumi.String("INFO"),
			},
		})
		if err != nil {
			return err
		}
		return nil
	})
}
```

</details>

<details>

<summary>java</summary>

```java
package generated_program;

import com.pulumi.Context;
import com.pulumi.Pulumi;
import com.pulumi.core.Output;
import com.pulumi.aws.apigateway.RestApi;
import com.pulumi.aws.apigateway.RestApiArgs;
import com.pulumi.aws.apigateway.Deployment;
import com.pulumi.aws.apigateway.DeploymentArgs;
import com.pulumi.aws.apigateway.Stage;
import com.pulumi.aws.apigateway.StageArgs;
import com.pulumi.aws.apigateway.MethodSettings;
import com.pulumi.aws.apigateway.MethodSettingsArgs;
import com.pulumi.aws.apigateway.inputs.MethodSettingsSettingsArgs;
import static com.pulumi.codegen.internal.Serialization.*;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;

public class App {
    public static void main(String[] args) {
        Pulumi.run(App::stack);
    }

    public static void stack(Context ctx) {
        var exampleRestApi = new RestApi("exampleRestApi", RestApiArgs.builder()        
            .body(serializeJson(
                jsonObject(
                    jsonProperty("openapi", "3.0.1"),
                    jsonProperty("info", jsonObject(
                        jsonProperty("title", "example"),
                        jsonProperty("version", "1.0")
                    )),
                    jsonProperty("paths", jsonObject(
                        jsonProperty("/path1", jsonObject(
                            jsonProperty("get", jsonObject(
                                jsonProperty("x-amazon-apigateway-integration", jsonObject(
                                    jsonProperty("httpMethod", "GET"),
                                    jsonProperty("payloadFormatVersion", "1.0"),
                                    jsonProperty("type", "HTTP_PROXY"),
                                    jsonProperty("uri", "https://ip-ranges.amazonaws.com/ip-ranges.json")
                                ))
                            ))
                        ))
                    ))
                )))
            .build());

        var exampleDeployment = new Deployment("exampleDeployment", DeploymentArgs.builder()        
            .restApi(exampleRestApi.id())
            .triggers(Map.of("redeployment", exampleRestApi.body().applyValue(body -> serializeJson(
                body)).applyValue(toJSON -> computeSHA1(toJSON))))
            .build());

        var exampleStage = new Stage("exampleStage", StageArgs.builder()        
            .deployment(exampleDeployment.id())
            .restApi(exampleRestApi.id())
            .stageName("example")
            .build());

        var exampleMethodSettings = new MethodSettings("exampleMethodSettings", MethodSettingsArgs.builder()        
            .restApi(exampleRestApi.id())
            .stageName(exampleStage.stageName())
            .methodPath("*/*")
            .settings(MethodSettingsSettingsArgs.builder()
                .metricsEnabled(true)
                .loggingLevel("INFO")
                .build())
            .build());

    }
}
```

</details>

## [*partial failure*] #/resources/aws:ec2/vpcIpam:VpcIpam

### HCL

```terraform
variable "ipam_regions" {
  type    = list
  default = ["us-east-1", "us-west-2"]
}

resource "aws_vpc_ipam" "example" {
  description = "test4"
  dynamic operating_regions {
    for_each = var.ipam_regions
    content {
      region_name = operating_regions.value
    }
  }
}

```

### Failed Languages

#### python

```text
:0,0-0: unknown property 'dynamic' among [cascade description operatingRegions tags]; 
```

#### csharp

```text
:0,0-0: unknown property 'dynamic' among [cascade description operatingRegions tags]; 
```

#### go

```text
:0,0-0: unknown property 'dynamic' among [tags cascade description operatingRegions]; 
```

#### typescript

```text
:0,0-0: unknown property 'dynamic' among [operatingRegions tags cascade description]; 
```

### Successes

<details>

<summary>yaml</summary>

```yaml
configuration:
  ipamRegions:
    type: dynamic
    default:
      - us-east-1
      - us-west-2
resources:
  example:
    type: aws:ec2:VpcIpam
    properties:
      description: test4
      dynamic:
        - forEach: ${ipamRegions}
          content:
            - regionName: ${operating_regions.value}
```

</details>

<details>

<summary>java</summary>

```java
package generated_program;

import com.pulumi.Context;
import com.pulumi.Pulumi;
import com.pulumi.core.Output;
import com.pulumi.aws.ec2.VpcIpam;
import com.pulumi.aws.ec2.VpcIpamArgs;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;

public class App {
    public static void main(String[] args) {
        Pulumi.run(App::stack);
    }

    public static void stack(Context ctx) {
        final var config = ctx.config();
        final var ipamRegions = config.get("ipamRegions").orElse(        
            "us-east-1",
            "us-west-2");
        var example = new VpcIpam("example", VpcIpamArgs.builder()        
            .description("test4")
            .dynamic(%!v(PANIC=Format method: runtime error: invalid memory address or nil pointer dereference))
            .build());

    }
}
```

</details>

## [*partial failure*] Edge Optimized (IAM Certificate)

### HCL

```terraform
resource "aws_api_gateway_domain_name" "example" {
  domain_name = "api.example.com"

  certificate_name        = "example-api"
  certificate_body        = file("${path.module}/example.com/example.crt")
  certificate_chain       = file("${path.module}/example.com/ca.crt")
  certificate_private_key = file("${path.module}/example.com/example.key")
}

# Example DNS record using Route53.
# Route53 is not specifically required; any DNS host can be used.
resource "aws_route53_record" "example" {
  zone_id = aws_route53_zone.example.id # See aws_route53_zone for how to create this

  name = aws_api_gateway_domain_name.example.domain_name
  type = "A"

  alias {
    name                   = aws_api_gateway_domain_name.example.cloudfront_domain_name
    zone_id                = aws_api_gateway_domain_name.example.cloudfront_zone_id
    evaluate_target_health = true
  }
}

```

### Failed Languages

#### yaml

```text
.pp:3,28-78: Failed to generate YAML program: Unknown Function; YAML does not support Fn::readFile., and 2 other diagnostic(s)
```

### Successes

<details>

<summary>java</summary>

```java
package generated_program;

import com.pulumi.Context;
import com.pulumi.Pulumi;
import com.pulumi.core.Output;
import com.pulumi.aws.apigateway.DomainName;
import com.pulumi.aws.apigateway.DomainNameArgs;
import com.pulumi.aws.route53.Record;
import com.pulumi.aws.route53.RecordArgs;
import com.pulumi.aws.route53.inputs.RecordAliasArgs;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;

public class App {
    public static void main(String[] args) {
        Pulumi.run(App::stack);
    }

    public static void stack(Context ctx) {
        var exampleDomainName = new DomainName("exampleDomainName", DomainNameArgs.builder()        
            .domainName("api.example.com")
            .certificateName("example-api")
            .certificateBody(Files.readString(Paths.get(String.format("%s/example.com/example.crt", path.module()))))
            .certificateChain(Files.readString(Paths.get(String.format("%s/example.com/ca.crt", path.module()))))
            .certificatePrivateKey(Files.readString(Paths.get(String.format("%s/example.com/example.key", path.module()))))
            .build());

        var exampleRecord = new Record("exampleRecord", RecordArgs.builder()        
            .zoneId(aws_route53_zone.example().id())
            .name(exampleDomainName.domainName())
            .type("A")
            .aliases(RecordAliasArgs.builder()
                .name(exampleDomainName.cloudfrontDomainName())
                .zoneId(exampleDomainName.cloudfrontZoneId())
                .evaluateTargetHealth(true)
                .build())
            .build());

    }
}
```

</details>

<details>

<summary>typescript</summary>

```typescript
import * as pulumi from "@pulumi/pulumi";
import * as aws from "@pulumi/aws";
import * as fs from "fs";

const exampleDomainName = new aws.apigateway.DomainName("exampleDomainName", {
    domainName: "api.example.com",
    certificateName: "example-api",
    certificateBody: fs.readFileSync(`${path.module}/example.com/example.crt`),
    certificateChain: fs.readFileSync(`${path.module}/example.com/ca.crt`),
    certificatePrivateKey: fs.readFileSync(`${path.module}/example.com/example.key`),
});
// Example DNS record using Route53.
// Route53 is not specifically required; any DNS host can be used.
const exampleRecord = new aws.route53.Record("exampleRecord", {
    zoneId: aws_route53_zone.example.id,
    name: exampleDomainName.domainName,
    type: "A",
    aliases: [{
        name: exampleDomainName.cloudfrontDomainName,
        zoneId: exampleDomainName.cloudfrontZoneId,
        evaluateTargetHealth: true,
    }],
});
```

</details>

<details>

<summary>python</summary>

```python
import pulumi
import pulumi_aws as aws

example_domain_name = aws.apigateway.DomainName("exampleDomainName",
    domain_name="api.example.com",
    certificate_name="example-api",
    certificate_body=(lambda path: open(path).read())(f"{path['module']}/example.com/example.crt"),
    certificate_chain=(lambda path: open(path).read())(f"{path['module']}/example.com/ca.crt"),
    certificate_private_key=(lambda path: open(path).read())(f"{path['module']}/example.com/example.key"))
# Example DNS record using Route53.
# Route53 is not specifically required; any DNS host can be used.
example_record = aws.route53.Record("exampleRecord",
    zone_id=aws_route53_zone["example"]["id"],
    name=example_domain_name.domain_name,
    type="A",
    aliases=[aws.route53.RecordAliasArgs(
        name=example_domain_name.cloudfront_domain_name,
        zone_id=example_domain_name.cloudfront_zone_id,
        evaluate_target_health=True,
    )])
```

</details>

<details>

<summary>csharp</summary>

```csharp
using System.Collections.Generic;
using System.IO;
using Pulumi;
using Aws = Pulumi.Aws;

return await Deployment.RunAsync(() => 
{
    var exampleDomainName = new Aws.ApiGateway.DomainName("exampleDomainName", new()
    {
        Domain = "api.example.com",
        CertificateName = "example-api",
        CertificateBody = File.ReadAllText($"{path.Module}/example.com/example.crt"),
        CertificateChain = File.ReadAllText($"{path.Module}/example.com/ca.crt"),
        CertificatePrivateKey = File.ReadAllText($"{path.Module}/example.com/example.key"),
    });

    // Example DNS record using Route53.
    // Route53 is not specifically required; any DNS host can be used.
    var exampleRecord = new Aws.Route53.Record("exampleRecord", new()
    {
        ZoneId = aws_route53_zone.Example.Id,
        Name = exampleDomainName.Domain,
        Type = "A",
        Aliases = new[]
        {
            new Aws.Route53.Inputs.RecordAliasArgs
            {
                Name = exampleDomainName.CloudfrontDomainName,
                ZoneId = exampleDomainName.CloudfrontZoneId,
                EvaluateTargetHealth = true,
            },
        },
    });

});
```

</details>

<details>

<summary>go</summary>

```go
package main

import (
	"fmt"
	"io/ioutil"

	"github.com/pulumi/pulumi-aws/sdk/v5/go/aws/apigateway"
	"github.com/pulumi/pulumi-aws/sdk/v5/go/aws/route53"
	"github.com/pulumi/pulumi/sdk/v3/go/pulumi"
)

func readFileOrPanic(path string) pulumi.StringPtrInput {
	data, err := ioutil.ReadFile(path)
	if err != nil {
		panic(err.Error())
	}
	return pulumi.String(string(data))
}

func main() {
	pulumi.Run(func(ctx *pulumi.Context) error {
		exampleDomainName, err := apigateway.NewDomainName(ctx, "exampleDomainName", &apigateway.DomainNameArgs{
			DomainName:            pulumi.String("api.example.com"),
			CertificateName:       pulumi.String("example-api"),
			CertificateBody:       readFileOrPanic(fmt.Sprintf("%v/example.com/example.crt", path.Module)),
			CertificateChain:      readFileOrPanic(fmt.Sprintf("%v/example.com/ca.crt", path.Module)),
			CertificatePrivateKey: readFileOrPanic(fmt.Sprintf("%v/example.com/example.key", path.Module)),
		})
		if err != nil {
			return err
		}
		_, err = route53.NewRecord(ctx, "exampleRecord", &route53.RecordArgs{
			ZoneId: pulumi.Any(aws_route53_zone.Example.Id),
			Name:   exampleDomainName.DomainName,
			Type:   pulumi.String("A"),
			Aliases: route53.RecordAliasArray{
				&route53.RecordAliasArgs{
					Name:                 exampleDomainName.CloudfrontDomainName,
					ZoneId:               exampleDomainName.CloudfrontZoneId,
					EvaluateTargetHealth: pulumi.Bool(true),
				},
			},
		})
		if err != nil {
			return err
		}
		return nil
	})
}
```

</details>

## [*partial failure*] Regional (ACM Certificate)

### HCL

```terraform
resource "aws_api_gateway_domain_name" "example" {
  domain_name              = "api.example.com"
  regional_certificate_arn = aws_acm_certificate_validation.example.certificate_arn

  endpoint_configuration {
    types = ["REGIONAL"]
  }
}

# Example DNS record using Route53.
# Route53 is not specifically required; any DNS host can be used.
resource "aws_route53_record" "example" {
  name    = aws_api_gateway_domain_name.example.domain_name
  type    = "A"
  zone_id = aws_route53_zone.example.id

  alias {
    evaluate_target_health = true
    name                   = aws_api_gateway_domain_name.example.regional_domain_name
    zone_id                = aws_api_gateway_domain_name.example.regional_zone_id
  }
}

```

### Failed Languages

#### typescript

```text
:0,0-0: cannot traverse value of type string; , and 4 other diagnostic(s)
```

#### python

```text
:0,0-0: cannot traverse value of type string; , and 4 other diagnostic(s)
```

#### csharp

```text
:0,0-0: cannot traverse value of type string; , and 4 other diagnostic(s)
```

#### go

```text
:0,0-0: cannot traverse value of type string; , and 4 other diagnostic(s)
```

### Successes

<details>

<summary>yaml</summary>

```yaml
resources:
  exampleDomainName:
    type: aws:apigateway:DomainName
    properties:
      domainName: api.example.com
      regionalCertificateArn: ${aws_acm_certificate_validation.example.certificate_arn}
      endpointConfiguration:
        types:
          - REGIONAL
  # Example DNS record using Route53.
  # Route53 is not specifically required; any DNS host can be used.
  exampleRecord:
    type: aws:route53:Record
    properties:
      name: ${exampleDomainName.domainName}
      type: A
      zoneId: ${aws_route53_zone.example.id}
      aliases:
        - evaluateTargetHealth: true
          name: ${exampleDomainName.regionalDomainName}
          zoneId: ${exampleDomainName.regionalZoneId}
```

</details>

<details>

<summary>java</summary>

```java
package generated_program;

import com.pulumi.Context;
import com.pulumi.Pulumi;
import com.pulumi.core.Output;
import com.pulumi.aws.apigateway.DomainName;
import com.pulumi.aws.apigateway.DomainNameArgs;
import com.pulumi.aws.apigateway.inputs.DomainNameEndpointConfigurationArgs;
import com.pulumi.aws.route53.Record;
import com.pulumi.aws.route53.RecordArgs;
import com.pulumi.aws.route53.inputs.RecordAliasArgs;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;

public class App {
    public static void main(String[] args) {
        Pulumi.run(App::stack);
    }

    public static void stack(Context ctx) {
        var exampleDomainName = new DomainName("exampleDomainName", DomainNameArgs.builder()        
            .domainName("api.example.com")
            .regionalCertificateArn(aws_acm_certificate_validation.example().certificate_arn())
            .endpointConfiguration(DomainNameEndpointConfigurationArgs.builder()
                .types("REGIONAL")
                .build())
            .build());

        var exampleRecord = new Record("exampleRecord", RecordArgs.builder()        
            .name(exampleDomainName.domainName())
            .type("A")
            .zoneId(aws_route53_zone.example().id())
            .aliases(RecordAliasArgs.builder()
                .evaluateTargetHealth(true)
                .name(exampleDomainName.regionalDomainName())
                .zoneId(exampleDomainName.regionalZoneId())
                .build())
            .build());

    }
}
```

</details>

## [*partial failure*] Regional (IAM Certificate)

### HCL

```terraform
resource "aws_api_gateway_domain_name" "example" {
  certificate_body          = file("${path.module}/example.com/example.crt")
  certificate_chain         = file("${path.module}/example.com/ca.crt")
  certificate_private_key   = file("${path.module}/example.com/example.key")
  domain_name               = "api.example.com"
  regional_certificate_name = "example-api"

  endpoint_configuration {
    types = ["REGIONAL"]
  }
}

# Example DNS record using Route53.
# Route53 is not specifically required; any DNS host can be used.
resource "aws_route53_record" "example" {
  name    = aws_api_gateway_domain_name.example.domain_name
  type    = "A"
  zone_id = aws_route53_zone.example.id

  alias {
    evaluate_target_health = true
    name                   = aws_api_gateway_domain_name.example.regional_domain_name
    zone_id                = aws_api_gateway_domain_name.example.regional_zone_id
  }
}

```

### Failed Languages

#### typescript

```text
:0,0-0: cannot traverse value of type string; , and 4 other diagnostic(s)
```

#### python

```text
:0,0-0: cannot traverse value of type string; , and 4 other diagnostic(s)
```

#### csharp

```text
:0,0-0: cannot traverse value of type string; , and 4 other diagnostic(s)
```

#### go

```text
:0,0-0: cannot traverse value of type string; , and 4 other diagnostic(s)
```

#### yaml

```text
.pp:1,30-80: Failed to generate YAML program: Unknown Function; YAML does not support Fn::readFile., and 2 other diagnostic(s)
```

### Successes

<details>

<summary>java</summary>

```java
package generated_program;

import com.pulumi.Context;
import com.pulumi.Pulumi;
import com.pulumi.core.Output;
import com.pulumi.aws.apigateway.DomainName;
import com.pulumi.aws.apigateway.DomainNameArgs;
import com.pulumi.aws.apigateway.inputs.DomainNameEndpointConfigurationArgs;
import com.pulumi.aws.route53.Record;
import com.pulumi.aws.route53.RecordArgs;
import com.pulumi.aws.route53.inputs.RecordAliasArgs;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;

public class App {
    public static void main(String[] args) {
        Pulumi.run(App::stack);
    }

    public static void stack(Context ctx) {
        var exampleDomainName = new DomainName("exampleDomainName", DomainNameArgs.builder()        
            .certificateBody(Files.readString(Paths.get(String.format("%s/example.com/example.crt", path.module()))))
            .certificateChain(Files.readString(Paths.get(String.format("%s/example.com/ca.crt", path.module()))))
            .certificatePrivateKey(Files.readString(Paths.get(String.format("%s/example.com/example.key", path.module()))))
            .domainName("api.example.com")
            .regionalCertificateName("example-api")
            .endpointConfiguration(DomainNameEndpointConfigurationArgs.builder()
                .types("REGIONAL")
                .build())
            .build());

        var exampleRecord = new Record("exampleRecord", RecordArgs.builder()        
            .name(exampleDomainName.domainName())
            .type("A")
            .zoneId(aws_route53_zone.example().id())
            .aliases(RecordAliasArgs.builder()
                .evaluateTargetHealth(true)
                .name(exampleDomainName.regionalDomainName())
                .zoneId(exampleDomainName.regionalZoneId())
                .build())
            .build());

    }
}
```

</details>

## [**complete failure**] #/resources/aws:autoscaling/tag:Tag

### HCL

```terraform
resource "aws_eks_node_group" "example" {
  cluster_name    = "example"
  node_group_name = "example"

  # ... other configuration ...
}

resource "aws_autoscaling_group_tag" "example" {
  for_each = toset(
    [for asg in flatten(
      [for resources in aws_eks_node_group.example.resources : resources.autoscaling_groups]
    ) : asg.name]
  )

  autoscaling_group_name = each.value

  tag {
    key   = "k8s.io/cluster-autoscaler/node-template/label/eks.amazonaws.com/capacityType"
    value = "SPOT"

    propagate_at_launch = false
  }
}

```

### Failed Languages

#### csharp

```text
:9,17-24: unknown function 'flatten'; , and 3 other diagnostic(s)
```

#### go

```text
:9,17-24: unknown function 'flatten'; , and 3 other diagnostic(s)
```

#### yaml

```text
:9,17-24: unknown function 'flatten'; , and 3 other diagnostic(s)
```

#### java

```text
:9,17-24: unknown function 'flatten'; , and 3 other diagnostic(s)
```

#### typescript

```text
:9,17-24: unknown function 'flatten'; , and 3 other diagnostic(s)
```

#### python

```text
:9,17-24: unknown function 'flatten'; , and 3 other diagnostic(s)
```

## [**complete failure**] Uploading a file to a bucket

### HCL

```terraform
resource "aws_s3_bucket_object" "object" {
  bucket = "your_bucket_name"
  key    = "new_object_key"
  source = "path/to/file"

  # The filemd5() function is available in this provider 0.11.12 and later
  # For this provider 0.11.11 and earlier, use the md5() function and the file() function:
  # etag = "${md5(file("path/to/file"))}"
  etag = filemd5("path/to/file")
}

```

### Failed Languages

#### java

```text
:8,10-17: unknown function 'filemd5'; , and 1 other diagnostic(s)
```

#### typescript

```text
:8,10-17: unknown function 'filemd5'; , and 1 other diagnostic(s)
```

#### python

```text
:8,10-17: unknown function 'filemd5'; , and 1 other diagnostic(s)
```

#### csharp

```text
:8,10-17: unknown function 'filemd5'; , and 1 other diagnostic(s)
```

#### go

```text
:8,10-17: unknown function 'filemd5'; , and 1 other diagnostic(s)
```

#### yaml

```text
:8,10-17: unknown function 'filemd5'; , and 1 other diagnostic(s)
```

## [**complete failure**] #/resources/aws:ssoadmin/permissionSetInlinePolicy:PermissionSetInlinePolicy

### HCL

```terraform
data "aws_ssoadmin_instances" "example" {}

resource "aws_ssoadmin_permission_set" "example" {
  name         = "Example"
  instance_arn = tolist(data.aws_ssoadmin_instances.example.arns)[0]
}

data "aws_iam_policy_document" "example" {
  statement {
    sid = "1"

    actions = [
      "s3:ListAllMyBuckets",
      "s3:GetBucketLocation",
    ]

    resources = [
      "arn:aws:s3:::*",
    ]
  }
}

resource "aws_ssoadmin_permission_set_inline_policy" "example" {
  inline_policy      = data.aws_iam_policy_document.example.json
  instance_arn       = aws_ssoadmin_permission_set.example.instance_arn
  permission_set_arn = aws_ssoadmin_permission_set.example.arn
}

```

### Failed Languages

#### java

```text
:4,18-24: unknown function 'tolist'; , and 1 other diagnostic(s)
```

#### typescript

```text
:4,18-24: unknown function 'tolist'; , and 1 other diagnostic(s)
```

#### python

```text
:4,18-24: unknown function 'tolist'; , and 1 other diagnostic(s)
```

#### csharp

```text
:4,18-24: unknown function 'tolist'; , and 1 other diagnostic(s)
```

#### go

```text
:4,18-24: unknown function 'tolist'; , and 1 other diagnostic(s)
```

#### yaml

```text
:4,18-24: unknown function 'tolist'; , and 1 other diagnostic(s)
```

## [*partial failure*] #/resources/aws:apigateway/integration:Integration

### HCL

```terraform
variable "name" {}
variable "subnet_id" {}

resource "aws_lb" "test" {
  name               = var.name
  internal           = true
  load_balancer_type = "network"
  subnets            = [var.subnet_id]
}

resource "aws_api_gateway_vpc_link" "test" {
  name        = var.name
  target_arns = [aws_lb.test.arn]
}

resource "aws_api_gateway_rest_api" "test" {
  name = var.name
}

resource "aws_api_gateway_resource" "test" {
  rest_api_id = aws_api_gateway_rest_api.test.id
  parent_id   = aws_api_gateway_rest_api.test.root_resource_id
  path_part   = "test"
}

resource "aws_api_gateway_method" "test" {
  rest_api_id   = aws_api_gateway_rest_api.test.id
  resource_id   = aws_api_gateway_resource.test.id
  http_method   = "GET"
  authorization = "NONE"

  request_models = {
    "application/json" = "Error"
  }
}

resource "aws_api_gateway_integration" "test" {
  rest_api_id = aws_api_gateway_rest_api.test.id
  resource_id = aws_api_gateway_resource.test.id
  http_method = aws_api_gateway_method.test.http_method

  request_templates = {
    "application/json" = ""
    "application/xml"  = "#set($inputRoot = $input.path('$'))\n{ }"
  }

  request_parameters = {
    "integration.request.header.X-Authorization" = "'static'"
    "integration.request.header.X-Foo"           = "'Bar'"
  }

  type                    = "HTTP"
  uri                     = "https://www.google.de"
  integration_http_method = "GET"
  passthrough_behavior    = "WHEN_NO_MATCH"
  content_handling        = "CONVERT_TO_TEXT"

  connection_type = "VPC_LINK"
  connection_id   = aws_api_gateway_vpc_link.test.id
}

```

### Failed Languages

#### python

```text
:0,0-0: cannot traverse value of type string; , and 2 other diagnostic(s)
```

#### csharp

```text
:0,0-0: cannot traverse value of type string; , and 2 other diagnostic(s)
```

#### go

```text
:0,0-0: cannot traverse value of type string; , and 2 other diagnostic(s)
```

#### typescript

```text
:0,0-0: cannot traverse value of type string; , and 2 other diagnostic(s)
```

### Successes

<details>

<summary>yaml</summary>

```yaml
configuration:
  name:
    type: dynamic
  subnetId:
    type: dynamic
resources:
  testLoadBalancer:
    type: aws:lb:LoadBalancer
    properties:
      internal: true
      loadBalancerType: network
      subnets:
        - ${subnetId}
  testVpcLink:
    type: aws:apigateway:VpcLink
    properties:
      targetArn:
        - ${testLoadBalancer.arn}
  testRestApi:
    type: aws:apigateway:RestApi
  testResource:
    type: aws:apigateway:Resource
    properties:
      restApi: ${testRestApi.id}
      parentId: ${testRestApi.rootResourceId}
      pathPart: test
  testMethod:
    type: aws:apigateway:Method
    properties:
      restApi: ${testRestApi.id}
      resourceId: ${testResource.id}
      httpMethod: GET
      authorization: NONE
      requestModels:
        application/json: Error
  testIntegration:
    type: aws:apigateway:Integration
    properties:
      restApi: ${testRestApi.id}
      resourceId: ${testResource.id}
      httpMethod: ${testMethod.httpMethod}
      requestTemplates:
        application/json:
        application/xml: |-
          #set($inputRoot = $input.path('$'))
          { }
      requestParameters:
        integration.request.header.X-Authorization: '''static'''
        integration.request.header.X-Foo: '''Bar'''
      type: HTTP
      uri: https://www.google.de
      integrationHttpMethod: GET
      passthroughBehavior: WHEN_NO_MATCH
      contentHandling: CONVERT_TO_TEXT
      connectionType: VPC_LINK
      connectionId: ${testVpcLink.id}
```

</details>

<details>

<summary>java</summary>

```java
package generated_program;

import com.pulumi.Context;
import com.pulumi.Pulumi;
import com.pulumi.core.Output;
import com.pulumi.aws.lb.LoadBalancer;
import com.pulumi.aws.lb.LoadBalancerArgs;
import com.pulumi.aws.apigateway.VpcLink;
import com.pulumi.aws.apigateway.VpcLinkArgs;
import com.pulumi.aws.apigateway.RestApi;
import com.pulumi.aws.apigateway.Resource;
import com.pulumi.aws.apigateway.ResourceArgs;
import com.pulumi.aws.apigateway.Method;
import com.pulumi.aws.apigateway.MethodArgs;
import com.pulumi.aws.apigateway.Integration;
import com.pulumi.aws.apigateway.IntegrationArgs;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;

public class App {
    public static void main(String[] args) {
        Pulumi.run(App::stack);
    }

    public static void stack(Context ctx) {
        final var config = ctx.config();
        final var name = config.get("name");
        final var subnetId = config.get("subnetId");
        var testLoadBalancer = new LoadBalancer("testLoadBalancer", LoadBalancerArgs.builder()        
            .internal(true)
            .loadBalancerType("network")
            .subnets(subnetId)
            .build());

        var testVpcLink = new VpcLink("testVpcLink", VpcLinkArgs.builder()        
            .targetArn(testLoadBalancer.arn())
            .build());

        var testRestApi = new RestApi("testRestApi");

        var testResource = new Resource("testResource", ResourceArgs.builder()        
            .restApi(testRestApi.id())
            .parentId(testRestApi.rootResourceId())
            .pathPart("test")
            .build());

        var testMethod = new Method("testMethod", MethodArgs.builder()        
            .restApi(testRestApi.id())
            .resourceId(testResource.id())
            .httpMethod("GET")
            .authorization("NONE")
            .requestModels(Map.of("application/json", "Error"))
            .build());

        var testIntegration = new Integration("testIntegration", IntegrationArgs.builder()        
            .restApi(testRestApi.id())
            .resourceId(testResource.id())
            .httpMethod(testMethod.httpMethod())
            .requestTemplates(Map.ofEntries(
                Map.entry("application/json", ""),
                Map.entry("application/xml", """
#set($inputRoot = $input.path('$'))
{ }                """)
            ))
            .requestParameters(Map.ofEntries(
                Map.entry("integration.request.header.X-Authorization", "'static'"),
                Map.entry("integration.request.header.X-Foo", "'Bar'")
            ))
            .type("HTTP")
            .uri("https://www.google.de")
            .integrationHttpMethod("GET")
            .passthroughBehavior("WHEN_NO_MATCH")
            .contentHandling("CONVERT_TO_TEXT")
            .connectionType("VPC_LINK")
            .connectionId(testVpcLink.id())
            .build());

    }
}
```

</details>

## [*partial failure*] OpenAPI Specification

### HCL

```terraform
resource "aws_api_gateway_rest_api" "example" {
  body = jsonencode({
    openapi = "3.0.1"
    info = {
      title   = "example"
      version = "1.0"
    }
    paths = {
      "/path1" = {
        get = {
          x-amazon-apigateway-integration = {
            httpMethod           = "GET"
            payloadFormatVersion = "1.0"
            type                 = "HTTP_PROXY"
            uri                  = "https://ip-ranges.amazonaws.com/ip-ranges.json"
          }
        }
      }
    }
  })

  name = "example"

  endpoint_configuration {
    types = ["REGIONAL"]
  }
}

resource "aws_api_gateway_deployment" "example" {
  rest_api_id = aws_api_gateway_rest_api.example.id

  triggers = {
    redeployment = sha1(jsonencode(aws_api_gateway_rest_api.example.body))
  }

  lifecycle {
    create_before_destroy = true
  }
}

resource "aws_api_gateway_stage" "example" {
  deployment_id = aws_api_gateway_deployment.example.id
  rest_api_id   = aws_api_gateway_rest_api.example.id
  stage_name    = "example"
}

```

### Failed Languages

#### typescript

```text
:0,0-0: cannot traverse value of type string; , and 4 other diagnostic(s)
```

#### python

```text
:0,0-0: cannot traverse value of type string; , and 4 other diagnostic(s)
```

#### csharp

```text
:0,0-0: cannot traverse value of type string; , and 4 other diagnostic(s)
```

#### go

```text
:0,0-0: cannot traverse value of type string; , and 4 other diagnostic(s)
```

#### yaml

```text
.pp:27,20-53: Failed to generate YAML program: Unknown Function; YAML does not support Fn::sha1.
```

### Successes

<details>

<summary>java</summary>

```java
package generated_program;

import com.pulumi.Context;
import com.pulumi.Pulumi;
import com.pulumi.core.Output;
import com.pulumi.aws.apigateway.RestApi;
import com.pulumi.aws.apigateway.RestApiArgs;
import com.pulumi.aws.apigateway.inputs.RestApiEndpointConfigurationArgs;
import com.pulumi.aws.apigateway.Deployment;
import com.pulumi.aws.apigateway.DeploymentArgs;
import com.pulumi.aws.apigateway.Stage;
import com.pulumi.aws.apigateway.StageArgs;
import static com.pulumi.codegen.internal.Serialization.*;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;

public class App {
    public static void main(String[] args) {
        Pulumi.run(App::stack);
    }

    public static void stack(Context ctx) {
        var exampleRestApi = new RestApi("exampleRestApi", RestApiArgs.builder()        
            .body(serializeJson(
                jsonObject(
                    jsonProperty("openapi", "3.0.1"),
                    jsonProperty("info", jsonObject(
                        jsonProperty("title", "example"),
                        jsonProperty("version", "1.0")
                    )),
                    jsonProperty("paths", jsonObject(
                        jsonProperty("/path1", jsonObject(
                            jsonProperty("get", jsonObject(
                                jsonProperty("x-amazon-apigateway-integration", jsonObject(
                                    jsonProperty("httpMethod", "GET"),
                                    jsonProperty("payloadFormatVersion", "1.0"),
                                    jsonProperty("type", "HTTP_PROXY"),
                                    jsonProperty("uri", "https://ip-ranges.amazonaws.com/ip-ranges.json")
                                ))
                            ))
                        ))
                    ))
                )))
            .endpointConfiguration(RestApiEndpointConfigurationArgs.builder()
                .types("REGIONAL")
                .build())
            .build());

        var exampleDeployment = new Deployment("exampleDeployment", DeploymentArgs.builder()        
            .restApi(exampleRestApi.id())
            .triggers(Map.of("redeployment", exampleRestApi.body().applyValue(body -> serializeJson(
                body)).applyValue(toJSON -> computeSHA1(toJSON))))
            .build());

        var exampleStage = new Stage("exampleStage", StageArgs.builder()        
            .deployment(exampleDeployment.id())
            .restApi(exampleRestApi.id())
            .stageName("example")
            .build());

    }
}
```

</details>

## [**complete failure**] OpenAPI Specification with Private Endpoints

### HCL

```terraform
data "aws_availability_zones" "available" {
  state = "available"

  filter {
    name   = "opt-in-status"
    values = ["opt-in-not-required"]
  }
}

data "aws_region" "current" {}

resource "aws_vpc" "test" {
  cidr_block           = "10.0.0.0/16"
  enable_dns_support   = true
  enable_dns_hostnames = true
}

resource "aws_default_security_group" "test" {
  vpc_id = aws_vpc.test.id
}

resource "aws_subnet" "test" {
  availability_zone = data.aws_availability_zones.available.names[0]
  cidr_block        = cidrsubnet(aws_vpc.test.cidr_block, 8, 0)
  vpc_id            = aws_vpc.test.id
}

resource "aws_vpc_endpoint" "test" {
  count = 3

  private_dns_enabled = false
  security_group_ids  = [aws_default_security_group.test.id]
  service_name        = "com.amazonaws.${data.aws_region.current.name}.execute-api"
  subnet_ids          = [aws_subnet.test.id]
  vpc_endpoint_type   = "Interface"
  vpc_id              = aws_vpc.test.id
}

resource "aws_api_gateway_rest_api" "example" {
  body = jsonencode({
    openapi = "3.0.1"
    info = {
      title   = "example"
      version = "1.0"
    }
    paths = {
      "/path1" = {
        get = {
          x-amazon-apigateway-integration = {
            httpMethod           = "GET"
            payloadFormatVersion = "1.0"
            type                 = "HTTP_PROXY"
            uri                  = "https://ip-ranges.amazonaws.com/ip-ranges.json"
          }
        }
      }
    }
  })

  name              = "example"
  put_rest_api_mode = "merge"

  endpoint_configuration {
    types            = ["PRIVATE"]
    vpc_endpoint_ids = [aws_vpc_endpoint.test.0.id, aws_vpc_endpoint.test.1.id, aws_vpc_endpoint.test.2.id]
  }
}

resource "aws_api_gateway_deployment" "example" {
  rest_api_id = aws_api_gateway_rest_api.example.id

  triggers = {
    redeployment = sha1(jsonencode(aws_api_gateway_rest_api.example.body))
  }

  lifecycle {
    create_before_destroy = true
  }
}

resource "aws_api_gateway_stage" "example" {
  deployment_id = aws_api_gateway_deployment.example.id
  rest_api_id   = aws_api_gateway_rest_api.example.id
  stage_name    = "example"
}

```

### Failed Languages

#### yaml

```text
.pp:18,22-32: unknown function 'cidrsubnet'; 
```

#### java

```text
.pp:18,22-32: unknown function 'cidrsubnet'; 
```

#### typescript

```text
.pp:18,22-32: unknown function 'cidrsubnet'; 
```

#### python

```text
.pp:18,22-32: unknown function 'cidrsubnet'; 
```

#### csharp

```text
.pp:18,22-32: unknown function 'cidrsubnet'; 
```

#### go

```text
.pp:18,22-32: unknown function 'cidrsubnet'; 
```

## [*partial failure*] Resources

### HCL

```terraform
resource "aws_api_gateway_rest_api" "example" {
  name = "example"
}

resource "aws_api_gateway_resource" "example" {
  parent_id   = aws_api_gateway_rest_api.example.root_resource_id
  path_part   = "example"
  rest_api_id = aws_api_gateway_rest_api.example.id
}

resource "aws_api_gateway_method" "example" {
  authorization = "NONE"
  http_method   = "GET"
  resource_id   = aws_api_gateway_resource.example.id
  rest_api_id   = aws_api_gateway_rest_api.example.id
}

resource "aws_api_gateway_integration" "example" {
  http_method = aws_api_gateway_method.example.http_method
  resource_id = aws_api_gateway_resource.example.id
  rest_api_id = aws_api_gateway_rest_api.example.id
  type        = "MOCK"
}

resource "aws_api_gateway_deployment" "example" {
  rest_api_id = aws_api_gateway_rest_api.example.id

  triggers = {
    # NOTE: The configuration below will satisfy ordering considerations,
    #       but not pick up all future REST API changes. More advanced patterns
    #       are possible, such as using the filesha1() function against the
    #       configuration file(s) or removing the .id references to
    #       calculate a hash against whole resources. Be aware that using whole
    #       resources will show a difference after the initial implementation.
    #       It will stabilize to only change when resources change afterwards.
    redeployment = sha1(jsonencode([
      aws_api_gateway_resource.example.id,
      aws_api_gateway_method.example.id,
      aws_api_gateway_integration.example.id,
    ]))
  }

  lifecycle {
    create_before_destroy = true
  }
}

resource "aws_api_gateway_stage" "example" {
  deployment_id = aws_api_gateway_deployment.example.id
  rest_api_id   = aws_api_gateway_rest_api.example.id
  stage_name    = "example"
}

```

### Failed Languages

#### yaml

```text
.pp:29,20-32,35: Failed to generate YAML program: Unknown Function; YAML does not support Fn::sha1.
```

### Successes

<details>

<summary>go</summary>

```go
package main

import (
	"crypto/sha1"
	"encoding/json"
	"fmt"

	"github.com/pulumi/pulumi-aws/sdk/v5/go/aws/apigateway"
	"github.com/pulumi/pulumi/sdk/v3/go/pulumi"
)

func sha1Hash(input string) string {
	hash := sha1.Sum([]byte(input))
	return hex.EncodeToString(hash[:])
}

func main() {
	pulumi.Run(func(ctx *pulumi.Context) error {
		exampleRestApi, err := apigateway.NewRestApi(ctx, "exampleRestApi", nil)
		if err != nil {
			return err
		}
		exampleResource, err := apigateway.NewResource(ctx, "exampleResource", &apigateway.ResourceArgs{
			ParentId: exampleRestApi.RootResourceId,
			PathPart: pulumi.String("example"),
			RestApi:  exampleRestApi.ID(),
		})
		if err != nil {
			return err
		}
		exampleMethod, err := apigateway.NewMethod(ctx, "exampleMethod", &apigateway.MethodArgs{
			Authorization: pulumi.String("NONE"),
			HttpMethod:    pulumi.String("GET"),
			ResourceId:    exampleResource.ID(),
			RestApi:       exampleRestApi.ID(),
		})
		if err != nil {
			return err
		}
		exampleIntegration, err := apigateway.NewIntegration(ctx, "exampleIntegration", &apigateway.IntegrationArgs{
			HttpMethod: exampleMethod.HttpMethod,
			ResourceId: exampleResource.ID(),
			RestApi:    exampleRestApi.ID(),
			Type:       pulumi.String("MOCK"),
		})
		if err != nil {
			return err
		}
		exampleDeployment, err := apigateway.NewDeployment(ctx, "exampleDeployment", &apigateway.DeploymentArgs{
			RestApi: exampleRestApi.ID(),
			Triggers: pulumi.StringMap{
				"redeployment": pulumi.All(exampleResource.ID(), exampleMethod.ID(), exampleIntegration.ID()).ApplyT(func(_args []interface{}) (string, error) {
					exampleResourceId := _args[0].(string)
					exampleMethodId := _args[1].(string)
					exampleIntegrationId := _args[2].(string)
					var _zero string
					tmpJSON0, err := json.Marshal([]string{
						exampleResourceId,
						exampleMethodId,
						exampleIntegrationId,
					})
					if err != nil {
						return _zero, err
					}
					json0 := string(tmpJSON0)
					return json0, nil
				}).(pulumi.StringOutput).ApplyT(func(toJSON string) (pulumi.String, error) {
					return sha1Hash(toJSON), nil
				}).(pulumi.StringOutput),
			},
		})
		if err != nil {
			return err
		}
		_, err = apigateway.NewStage(ctx, "exampleStage", &apigateway.StageArgs{
			Deployment: exampleDeployment.ID(),
			RestApi:    exampleRestApi.ID(),
			StageName:  pulumi.String("example"),
		})
		if err != nil {
			return err
		}
		return nil
	})
}
```

</details>

<details>

<summary>java</summary>

```java
package generated_program;

import com.pulumi.Context;
import com.pulumi.Pulumi;
import com.pulumi.core.Output;
import com.pulumi.aws.apigateway.RestApi;
import com.pulumi.aws.apigateway.Resource;
import com.pulumi.aws.apigateway.ResourceArgs;
import com.pulumi.aws.apigateway.Method;
import com.pulumi.aws.apigateway.MethodArgs;
import com.pulumi.aws.apigateway.Integration;
import com.pulumi.aws.apigateway.IntegrationArgs;
import com.pulumi.aws.apigateway.Deployment;
import com.pulumi.aws.apigateway.DeploymentArgs;
import com.pulumi.aws.apigateway.Stage;
import com.pulumi.aws.apigateway.StageArgs;
import static com.pulumi.codegen.internal.Serialization.*;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;

public class App {
    public static void main(String[] args) {
        Pulumi.run(App::stack);
    }

    public static void stack(Context ctx) {
        var exampleRestApi = new RestApi("exampleRestApi");

        var exampleResource = new Resource("exampleResource", ResourceArgs.builder()        
            .parentId(exampleRestApi.rootResourceId())
            .pathPart("example")
            .restApi(exampleRestApi.id())
            .build());

        var exampleMethod = new Method("exampleMethod", MethodArgs.builder()        
            .authorization("NONE")
            .httpMethod("GET")
            .resourceId(exampleResource.id())
            .restApi(exampleRestApi.id())
            .build());

        var exampleIntegration = new Integration("exampleIntegration", IntegrationArgs.builder()        
            .httpMethod(exampleMethod.httpMethod())
            .resourceId(exampleResource.id())
            .restApi(exampleRestApi.id())
            .type("MOCK")
            .build());

        var exampleDeployment = new Deployment("exampleDeployment", DeploymentArgs.builder()        
            .restApi(exampleRestApi.id())
            .triggers(Map.of("redeployment", Output.tuple(exampleResource.id(), exampleMethod.id(), exampleIntegration.id()).applyValue(values -> {
                var exampleResourceId = values.t1;
                var exampleMethodId = values.t2;
                var exampleIntegrationId = values.t3;
                return serializeJson(
                    jsonArray(
                        exampleResourceId, 
                        exampleMethodId, 
                        exampleIntegrationId
                    ));
            }).applyValue(toJSON -> computeSHA1(toJSON))))
            .build());

        var exampleStage = new Stage("exampleStage", StageArgs.builder()        
            .deployment(exampleDeployment.id())
            .restApi(exampleRestApi.id())
            .stageName("example")
            .build());

    }
}
```

</details>

<details>

<summary>typescript</summary>

```typescript
import * as pulumi from "@pulumi/pulumi";
import * as aws from "@pulumi/aws";
import * as crypto from "crypto";

const exampleRestApi = new aws.apigateway.RestApi("exampleRestApi", {});
const exampleResource = new aws.apigateway.Resource("exampleResource", {
    parentId: exampleRestApi.rootResourceId,
    pathPart: "example",
    restApi: exampleRestApi.id,
});
const exampleMethod = new aws.apigateway.Method("exampleMethod", {
    authorization: "NONE",
    httpMethod: "GET",
    resourceId: exampleResource.id,
    restApi: exampleRestApi.id,
});
const exampleIntegration = new aws.apigateway.Integration("exampleIntegration", {
    httpMethod: exampleMethod.httpMethod,
    resourceId: exampleResource.id,
    restApi: exampleRestApi.id,
    type: "MOCK",
});
const exampleDeployment = new aws.apigateway.Deployment("exampleDeployment", {
    restApi: exampleRestApi.id,
    triggers: {
        redeployment: pulumi.all([exampleResource.id, exampleMethod.id, exampleIntegration.id]).apply(([exampleResourceId, exampleMethodId, exampleIntegrationId]) => JSON.stringify([
            exampleResourceId,
            exampleMethodId,
            exampleIntegrationId,
        ])).apply(toJSON => crypto.createHash('sha1').update(toJSON).digest('hex')),
    },
});
const exampleStage = new aws.apigateway.Stage("exampleStage", {
    deployment: exampleDeployment.id,
    restApi: exampleRestApi.id,
    stageName: "example",
});
```

</details>

<details>

<summary>python</summary>

```python
import pulumi
import hashlib
import json
import pulumi_aws as aws

example_rest_api = aws.apigateway.RestApi("exampleRestApi")
example_resource = aws.apigateway.Resource("exampleResource",
    parent_id=example_rest_api.root_resource_id,
    path_part="example",
    rest_api=example_rest_api.id)
example_method = aws.apigateway.Method("exampleMethod",
    authorization="NONE",
    http_method="GET",
    resource_id=example_resource.id,
    rest_api=example_rest_api.id)
example_integration = aws.apigateway.Integration("exampleIntegration",
    http_method=example_method.http_method,
    resource_id=example_resource.id,
    rest_api=example_rest_api.id,
    type="MOCK")
example_deployment = aws.apigateway.Deployment("exampleDeployment",
    rest_api=example_rest_api.id,
    triggers={
        "redeployment": pulumi.Output.all(example_resource.id, example_method.id, example_integration.id).apply(lambda exampleResourceId, exampleMethodId, exampleIntegrationId: json.dumps([
            example_resource_id,
            example_method_id,
            example_integration_id,
        ])).apply(lambda to_json: hashlib.sha1(to_json.encode()).hexdigest()),
    })
example_stage = aws.apigateway.Stage("exampleStage",
    deployment=example_deployment.id,
    rest_api=example_rest_api.id,
    stage_name="example")
```

</details>

<details>

<summary>csharp</summary>

```csharp
using System.Collections.Generic;
using System.Security.Cryptography;
using System.Text;
using System.Text.Json;
using Pulumi;
using Aws = Pulumi.Aws;

	private static string ComputeSHA1(string input) {
		return BitConverter.ToString(
			SHA1.Create().ComputeHash(Encoding.UTF8.GetBytes(input))
		).Replace("-","").ToLowerInvariant());
	}

return await Deployment.RunAsync(() => 
{
    var exampleRestApi = new Aws.ApiGateway.RestApi("exampleRestApi");

    var exampleResource = new Aws.ApiGateway.Resource("exampleResource", new()
    {
        ParentId = exampleRestApi.RootResourceId,
        PathPart = "example",
        RestApi = exampleRestApi.Id,
    });

    var exampleMethod = new Aws.ApiGateway.Method("exampleMethod", new()
    {
        Authorization = "NONE",
        HttpMethod = "GET",
        ResourceId = exampleResource.Id,
        RestApi = exampleRestApi.Id,
    });

    var exampleIntegration = new Aws.ApiGateway.Integration("exampleIntegration", new()
    {
        HttpMethod = exampleMethod.HttpMethod,
        ResourceId = exampleResource.Id,
        RestApi = exampleRestApi.Id,
        Type = "MOCK",
    });

    var exampleDeployment = new Aws.ApiGateway.Deployment("exampleDeployment", new()
    {
        RestApi = exampleRestApi.Id,
        Triggers = 
        {
            { "redeployment", Output.Tuple(exampleResource.Id, exampleMethod.Id, exampleIntegration.Id).Apply(values =>
            {
                var exampleResourceId = values.Item1;
                var exampleMethodId = values.Item2;
                var exampleIntegrationId = values.Item3;
                return JsonSerializer.Serialize(new[]
                {
                    exampleResourceId,
                    exampleMethodId,
                    exampleIntegrationId,
                });
            }).Apply(toJSON => ComputeSHA1(toJSON)) },
        },
    });

    var exampleStage = new Aws.ApiGateway.Stage("exampleStage", new()
    {
        Deployment = exampleDeployment.Id,
        RestApi = exampleRestApi.Id,
        StageName = "example",
    });

});
```

</details>

## [*partial failure*] UI customization settings for a single client

### HCL

```terraform
resource "aws_cognito_user_pool" "example" {
  name = "example"
}

resource "aws_cognito_user_pool_domain" "example" {
  domain       = "example"
  user_pool_id = aws_cognito_user_pool.example.id
}

resource "aws_cognito_user_pool_client" "example" {
  name         = "example"
  user_pool_id = aws_cognito_user_pool.example.id
}

resource "aws_cognito_user_pool_ui_customization" "example" {
  client_id = aws_cognito_user_pool_client.example.id

  css        = ".label-customizable {font-weight: 400;}"
  image_file = filebase64("logo.png")

  # Refer to the aws_cognito_user_pool_domain resource's
  # user_pool_id attribute to ensure it is in an 'Active' state
  user_pool_id = aws_cognito_user_pool_domain.example.user_pool_id
}

```

### Failed Languages

#### yaml

```text
.pp:12,15-37: Failed to generate YAML program: Unknown Function; YAML does not support Fn::filebase64.
```

### Successes

<details>

<summary>python</summary>

```python
import pulumi
import base64
import pulumi_aws as aws

example_user_pool = aws.cognito.UserPool("exampleUserPool")
example_user_pool_domain = aws.cognito.UserPoolDomain("exampleUserPoolDomain",
    domain="example",
    user_pool_id=example_user_pool.id)
example_user_pool_client = aws.cognito.UserPoolClient("exampleUserPoolClient", user_pool_id=example_user_pool.id)
example_user_pool_ui_customization = aws.cognito.UserPoolUICustomization("exampleUserPoolUICustomization",
    client_id=example_user_pool_client.id,
    css=".label-customizable {font-weight: 400;}",
    image_file=(lambda path: base64.b64encode(open(path).read().encode()).decode())("logo.png"),
    user_pool_id=example_user_pool_domain.user_pool_id)
```

</details>

<details>

<summary>csharp</summary>

```csharp
using System;
using System.Collections.Generic;
using System.IO;
using Pulumi;
using Aws = Pulumi.Aws;

	private static string ReadFileBase64(string path) {
		return Convert.ToBase64String(Encoding.UTF8.GetBytes(File.ReadAllText(path)))
	}

return await Deployment.RunAsync(() => 
{
    var exampleUserPool = new Aws.Cognito.UserPool("exampleUserPool");

    var exampleUserPoolDomain = new Aws.Cognito.UserPoolDomain("exampleUserPoolDomain", new()
    {
        Domain = "example",
        UserPoolId = exampleUserPool.Id,
    });

    var exampleUserPoolClient = new Aws.Cognito.UserPoolClient("exampleUserPoolClient", new()
    {
        UserPoolId = exampleUserPool.Id,
    });

    var exampleUserPoolUICustomization = new Aws.Cognito.UserPoolUICustomization("exampleUserPoolUICustomization", new()
    {
        ClientId = exampleUserPoolClient.Id,
        Css = ".label-customizable {font-weight: 400;}",
        ImageFile = ReadFileBase64("logo.png"),
        UserPoolId = exampleUserPoolDomain.UserPoolId,
    });

});
```

</details>

<details>

<summary>go</summary>

```go
package main

import (
	"encoding/base64"
	"io/ioutil"

	"github.com/pulumi/pulumi-aws/sdk/v5/go/aws/cognito"
	"github.com/pulumi/pulumi/sdk/v3/go/pulumi"
)

func filebase64OrPanic(path string) pulumi.StringPtrInput {
	if fileData, err := ioutil.ReadFile(path); err == nil {
		return pulumi.String(base64.StdEncoding.EncodeToString(fileData[:]))
	} else {
		panic(err.Error())
	}
}

func main() {
	pulumi.Run(func(ctx *pulumi.Context) error {
		exampleUserPool, err := cognito.NewUserPool(ctx, "exampleUserPool", nil)
		if err != nil {
			return err
		}
		exampleUserPoolDomain, err := cognito.NewUserPoolDomain(ctx, "exampleUserPoolDomain", &cognito.UserPoolDomainArgs{
			Domain:     pulumi.String("example"),
			UserPoolId: exampleUserPool.ID(),
		})
		if err != nil {
			return err
		}
		exampleUserPoolClient, err := cognito.NewUserPoolClient(ctx, "exampleUserPoolClient", &cognito.UserPoolClientArgs{
			UserPoolId: exampleUserPool.ID(),
		})
		if err != nil {
			return err
		}
		_, err = cognito.NewUserPoolUICustomization(ctx, "exampleUserPoolUICustomization", &cognito.UserPoolUICustomizationArgs{
			ClientId:   exampleUserPoolClient.ID(),
			Css:        pulumi.String(".label-customizable {font-weight: 400;}"),
			ImageFile:  filebase64OrPanic("logo.png"),
			UserPoolId: exampleUserPoolDomain.UserPoolId,
		})
		if err != nil {
			return err
		}
		return nil
	})
}
```

</details>

<details>

<summary>java</summary>

```java
package generated_program;

import com.pulumi.Context;
import com.pulumi.Pulumi;
import com.pulumi.core.Output;
import com.pulumi.aws.cognito.UserPool;
import com.pulumi.aws.cognito.UserPoolDomain;
import com.pulumi.aws.cognito.UserPoolDomainArgs;
import com.pulumi.aws.cognito.UserPoolClient;
import com.pulumi.aws.cognito.UserPoolClientArgs;
import com.pulumi.aws.cognito.UserPoolUICustomization;
import com.pulumi.aws.cognito.UserPoolUICustomizationArgs;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;

public class App {
    public static void main(String[] args) {
        Pulumi.run(App::stack);
    }

    public static void stack(Context ctx) {
        var exampleUserPool = new UserPool("exampleUserPool");

        var exampleUserPoolDomain = new UserPoolDomain("exampleUserPoolDomain", UserPoolDomainArgs.builder()        
            .domain("example")
            .userPoolId(exampleUserPool.id())
            .build());

        var exampleUserPoolClient = new UserPoolClient("exampleUserPoolClient", UserPoolClientArgs.builder()        
            .userPoolId(exampleUserPool.id())
            .build());

        var exampleUserPoolUICustomization = new UserPoolUICustomization("exampleUserPoolUICustomization", UserPoolUICustomizationArgs.builder()        
            .clientId(exampleUserPoolClient.id())
            .css(".label-customizable {font-weight: 400;}")
            .imageFile(Base64.getEncoder().encodeToString(Files.readAllBytes(Paths.get("logo.png"))))
            .userPoolId(exampleUserPoolDomain.userPoolId())
            .build());

    }
}
```

</details>

<details>

<summary>typescript</summary>

```typescript
import * as pulumi from "@pulumi/pulumi";
import * as aws from "@pulumi/aws";
import * as fs from "fs";

const exampleUserPool = new aws.cognito.UserPool("exampleUserPool", {});
const exampleUserPoolDomain = new aws.cognito.UserPoolDomain("exampleUserPoolDomain", {
    domain: "example",
    userPoolId: exampleUserPool.id,
});
const exampleUserPoolClient = new aws.cognito.UserPoolClient("exampleUserPoolClient", {userPoolId: exampleUserPool.id});
const exampleUserPoolUICustomization = new aws.cognito.UserPoolUICustomization("exampleUserPoolUICustomization", {
    clientId: exampleUserPoolClient.id,
    css: ".label-customizable {font-weight: 400;}",
    imageFile: Buffer.from(fs.readFileSync("logo.png"), 'binary').toString('base64'),
    userPoolId: exampleUserPoolDomain.userPoolId,
});
```

</details>

## [*partial failure*] UI customization settings for all clients

### HCL

```terraform
resource "aws_cognito_user_pool" "example" {
  name = "example"
}

resource "aws_cognito_user_pool_domain" "example" {
  domain       = "example"
  user_pool_id = aws_cognito_user_pool.example.id
}

resource "aws_cognito_user_pool_ui_customization" "example" {
  css        = ".label-customizable {font-weight: 400;}"
  image_file = filebase64("logo.png")

  # Refer to the aws_cognito_user_pool_domain resource's
  # user_pool_id attribute to ensure it is in an 'Active' state
  user_pool_id = aws_cognito_user_pool_domain.example.user_pool_id
}

```

### Failed Languages

#### yaml

```text
.pp:8,15-37: Failed to generate YAML program: Unknown Function; YAML does not support Fn::filebase64.
```

### Successes

<details>

<summary>csharp</summary>

```csharp
using System;
using System.Collections.Generic;
using System.IO;
using Pulumi;
using Aws = Pulumi.Aws;

	private static string ReadFileBase64(string path) {
		return Convert.ToBase64String(Encoding.UTF8.GetBytes(File.ReadAllText(path)))
	}

return await Deployment.RunAsync(() => 
{
    var exampleUserPool = new Aws.Cognito.UserPool("exampleUserPool");

    var exampleUserPoolDomain = new Aws.Cognito.UserPoolDomain("exampleUserPoolDomain", new()
    {
        Domain = "example",
        UserPoolId = exampleUserPool.Id,
    });

    var exampleUserPoolUICustomization = new Aws.Cognito.UserPoolUICustomization("exampleUserPoolUICustomization", new()
    {
        Css = ".label-customizable {font-weight: 400;}",
        ImageFile = ReadFileBase64("logo.png"),
        UserPoolId = exampleUserPoolDomain.UserPoolId,
    });

});
```

</details>

<details>

<summary>go</summary>

```go
package main

import (
	"encoding/base64"
	"io/ioutil"

	"github.com/pulumi/pulumi-aws/sdk/v5/go/aws/cognito"
	"github.com/pulumi/pulumi/sdk/v3/go/pulumi"
)

func filebase64OrPanic(path string) pulumi.StringPtrInput {
	if fileData, err := ioutil.ReadFile(path); err == nil {
		return pulumi.String(base64.StdEncoding.EncodeToString(fileData[:]))
	} else {
		panic(err.Error())
	}
}

func main() {
	pulumi.Run(func(ctx *pulumi.Context) error {
		exampleUserPool, err := cognito.NewUserPool(ctx, "exampleUserPool", nil)
		if err != nil {
			return err
		}
		exampleUserPoolDomain, err := cognito.NewUserPoolDomain(ctx, "exampleUserPoolDomain", &cognito.UserPoolDomainArgs{
			Domain:     pulumi.String("example"),
			UserPoolId: exampleUserPool.ID(),
		})
		if err != nil {
			return err
		}
		_, err = cognito.NewUserPoolUICustomization(ctx, "exampleUserPoolUICustomization", &cognito.UserPoolUICustomizationArgs{
			Css:        pulumi.String(".label-customizable {font-weight: 400;}"),
			ImageFile:  filebase64OrPanic("logo.png"),
			UserPoolId: exampleUserPoolDomain.UserPoolId,
		})
		if err != nil {
			return err
		}
		return nil
	})
}
```

</details>

<details>

<summary>java</summary>

```java
package generated_program;

import com.pulumi.Context;
import com.pulumi.Pulumi;
import com.pulumi.core.Output;
import com.pulumi.aws.cognito.UserPool;
import com.pulumi.aws.cognito.UserPoolDomain;
import com.pulumi.aws.cognito.UserPoolDomainArgs;
import com.pulumi.aws.cognito.UserPoolUICustomization;
import com.pulumi.aws.cognito.UserPoolUICustomizationArgs;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;

public class App {
    public static void main(String[] args) {
        Pulumi.run(App::stack);
    }

    public static void stack(Context ctx) {
        var exampleUserPool = new UserPool("exampleUserPool");

        var exampleUserPoolDomain = new UserPoolDomain("exampleUserPoolDomain", UserPoolDomainArgs.builder()        
            .domain("example")
            .userPoolId(exampleUserPool.id())
            .build());

        var exampleUserPoolUICustomization = new UserPoolUICustomization("exampleUserPoolUICustomization", UserPoolUICustomizationArgs.builder()        
            .css(".label-customizable {font-weight: 400;}")
            .imageFile(Base64.getEncoder().encodeToString(Files.readAllBytes(Paths.get("logo.png"))))
            .userPoolId(exampleUserPoolDomain.userPoolId())
            .build());

    }
}
```

</details>

<details>

<summary>typescript</summary>

```typescript
import * as pulumi from "@pulumi/pulumi";
import * as aws from "@pulumi/aws";
import * as fs from "fs";

const exampleUserPool = new aws.cognito.UserPool("exampleUserPool", {});
const exampleUserPoolDomain = new aws.cognito.UserPoolDomain("exampleUserPoolDomain", {
    domain: "example",
    userPoolId: exampleUserPool.id,
});
const exampleUserPoolUICustomization = new aws.cognito.UserPoolUICustomization("exampleUserPoolUICustomization", {
    css: ".label-customizable {font-weight: 400;}",
    imageFile: Buffer.from(fs.readFileSync("logo.png"), 'binary').toString('base64'),
    userPoolId: exampleUserPoolDomain.userPoolId,
});
```

</details>

<details>

<summary>python</summary>

```python
import pulumi
import base64
import pulumi_aws as aws

example_user_pool = aws.cognito.UserPool("exampleUserPool")
example_user_pool_domain = aws.cognito.UserPoolDomain("exampleUserPoolDomain",
    domain="example",
    user_pool_id=example_user_pool.id)
example_user_pool_ui_customization = aws.cognito.UserPoolUICustomization("exampleUserPoolUICustomization",
    css=".label-customizable {font-weight: 400;}",
    image_file=(lambda path: base64.b64encode(open(path).read().encode()).decode())("logo.png"),
    user_pool_id=example_user_pool_domain.user_pool_id)
```

</details>

## [**complete failure**] Basic usage

### HCL

```terraform
resource "aws_sagemaker_studio_lifecycle_config" "example" {
  studio_lifecycle_config_name     = "example"
  studio_lifecycle_config_app_type = "JupyterServer"
  studio_lifecycle_config_content  = base64encode("echo Hello")
}

```

### Failed Languages

#### typescript

```text
:3,38-50: unknown function 'base64encode'; , and 1 other diagnostic(s)
```

#### python

```text
:3,38-50: unknown function 'base64encode'; , and 1 other diagnostic(s)
```

#### csharp

```text
:3,38-50: unknown function 'base64encode'; , and 1 other diagnostic(s)
```

#### go

```text
:3,38-50: unknown function 'base64encode'; , and 1 other diagnostic(s)
```

#### yaml

```text
:3,38-50: unknown function 'base64encode'; , and 1 other diagnostic(s)
```

#### java

```text
:3,38-50: unknown function 'base64encode'; , and 1 other diagnostic(s)
```

## [**complete failure**] #/resources/aws:msk/serverlessCluster:ServerlessCluster

### HCL

```terraform
resource "aws_msk_serverless_cluster" "example" {
  cluster_name = "Example"

  vpc_config {
    subnet_ids         = aws_subnet.example[*].id
    security_group_ids = [aws_security_group.example.id]
  }

  client_authentication {
    sasl {
      iam {
        enabled = true
      }
    }
  }
}

```

### Failed Languages

#### java

```text
failed to convert HCL for #/resources/aws:msk/serverlessCluster:ServerlessCluster to java: panic converting HCL: fatal: A failure has occurred
```

#### typescript

```text
failed to convert HCL for #/resources/aws:msk/serverlessCluster:ServerlessCluster to typescript: panic converting HCL: fatal: A failure has occurred
```

#### python

```text
failed to convert HCL for #/resources/aws:msk/serverlessCluster:ServerlessCluster to python: panic converting HCL: fatal: A failure has occurred
```

#### csharp

```text
failed to convert HCL for #/resources/aws:msk/serverlessCluster:ServerlessCluster to csharp: panic converting HCL: fatal: A failure has occurred
```

#### go

```text
failed to convert HCL for #/resources/aws:msk/serverlessCluster:ServerlessCluster to go: panic converting HCL: fatal: A failure has occurred
```

#### yaml

```text
failed to convert HCL for #/resources/aws:msk/serverlessCluster:ServerlessCluster to yaml: panic converting HCL: fatal: A failure has occurred
```

## [**complete failure**] #/resources/aws:devicefarm/testGridProject:TestGridProject

### HCL

```terraform
resource "aws_devicefarm_test_grid_project" "example" {
  name = "example"

  vpc_config {
    vpc_id             = aws_vpc.example.id
    subnet_ids         = aws_subnet.example.*.id
    security_group_ids = aws_security_group.example.*.id
  }
}

```

### Failed Languages

#### typescript

```text
failed to convert HCL for #/resources/aws:devicefarm/testGridProject:TestGridProject to typescript: panic converting HCL: fatal: A failure has occurred
```

#### python

```text
failed to convert HCL for #/resources/aws:devicefarm/testGridProject:TestGridProject to python: panic converting HCL: fatal: A failure has occurred
```

#### csharp

```text
failed to convert HCL for #/resources/aws:devicefarm/testGridProject:TestGridProject to csharp: panic converting HCL: fatal: A failure has occurred
```

#### go

```text
failed to convert HCL for #/resources/aws:devicefarm/testGridProject:TestGridProject to go: panic converting HCL: fatal: A failure has occurred
```

#### yaml

```text
failed to convert HCL for #/resources/aws:devicefarm/testGridProject:TestGridProject to yaml: panic converting HCL: fatal: A failure has occurred
```

#### java

```text
failed to convert HCL for #/resources/aws:devicefarm/testGridProject:TestGridProject to java: panic converting HCL: fatal: A failure has occurred
```

## [*partial failure*] #/resources/aws:fsx/dataRepositoryAssociation:DataRepositoryAssociation

### HCL

```terraform
resource "aws_s3_bucket" "example" {
  bucket = "my-bucket"
}

resource "aws_s3_bucket_acl" "example" {
  bucket = aws_s3_bucket.example.id
  acl    = "private"
}

resource "aws_fsx_lustre_file_system" "example" {
  storage_capacity = 1200
  subnet_ids       = [aws_subnet.example.id]
  deployment_type  = "PERSISTENT_2"

  per_unit_storage_throughput = 125
}

resource "aws_fsx_data_repository_association" "example" {
  file_system_id       = aws_fsx_lustre_file_system.example.id
  data_repository_path = "s3://${aws_s3_bucket.example.id}"
  file_system_path     = "/my-bucket"

  s3 {
    auto_export_policy {
      events = ["NEW", "CHANGED", "DELETED"]
    }

    auto_import_policy {
      events = ["NEW", "CHANGED", "DELETED"]
    }
  }
}

```

### Failed Languages

#### typescript

```text
:0,0-0: cannot traverse value of type string; , and 2 other diagnostic(s)
```

#### python

```text
:0,0-0: cannot traverse value of type string; , and 2 other diagnostic(s)
```

#### csharp

```text
:0,0-0: cannot traverse value of type string; , and 2 other diagnostic(s)
```

#### go

```text
:0,0-0: cannot traverse value of type string; , and 2 other diagnostic(s)
```

### Successes

<details>

<summary>yaml</summary>

```yaml
resources:
  exampleBucketV2:
    type: aws:s3:BucketV2
  exampleBucketAclV2:
    type: aws:s3:BucketAclV2
    properties:
      bucket: ${exampleBucketV2.id}
      acl: private
  exampleLustreFileSystem:
    type: aws:fsx:LustreFileSystem
    properties:
      storageCapacity: 1200
      subnetIds:
        - ${aws_subnet.example.id}
      deploymentType: PERSISTENT_2
      perUnitStorageThroughput: 125
  exampleDataRepositoryAssociation:
    type: aws:fsx:DataRepositoryAssociation
    properties:
      fileSystemId: ${exampleLustreFileSystem.id}
      dataRepositoryPath: s3://${exampleBucketV2.id}
      fileSystemPath: /my-bucket
      s3:
        autoExportPolicy:
          events:
            - NEW
            - CHANGED
            - DELETED
        autoImportPolicy:
          events:
            - NEW
            - CHANGED
            - DELETED
```

</details>

<details>

<summary>java</summary>

```java
package generated_program;

import com.pulumi.Context;
import com.pulumi.Pulumi;
import com.pulumi.core.Output;
import com.pulumi.aws.s3.BucketV2;
import com.pulumi.aws.s3.BucketAclV2;
import com.pulumi.aws.s3.BucketAclV2Args;
import com.pulumi.aws.fsx.LustreFileSystem;
import com.pulumi.aws.fsx.LustreFileSystemArgs;
import com.pulumi.aws.fsx.DataRepositoryAssociation;
import com.pulumi.aws.fsx.DataRepositoryAssociationArgs;
import com.pulumi.aws.fsx.inputs.DataRepositoryAssociationS3Args;
import com.pulumi.aws.fsx.inputs.DataRepositoryAssociationS3AutoExportPolicyArgs;
import com.pulumi.aws.fsx.inputs.DataRepositoryAssociationS3AutoImportPolicyArgs;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;

public class App {
    public static void main(String[] args) {
        Pulumi.run(App::stack);
    }

    public static void stack(Context ctx) {
        var exampleBucketV2 = new BucketV2("exampleBucketV2");

        var exampleBucketAclV2 = new BucketAclV2("exampleBucketAclV2", BucketAclV2Args.builder()        
            .bucket(exampleBucketV2.id())
            .acl("private")
            .build());

        var exampleLustreFileSystem = new LustreFileSystem("exampleLustreFileSystem", LustreFileSystemArgs.builder()        
            .storageCapacity(1200)
            .subnetIds(aws_subnet.example().id())
            .deploymentType("PERSISTENT_2")
            .perUnitStorageThroughput(125)
            .build());

        var exampleDataRepositoryAssociation = new DataRepositoryAssociation("exampleDataRepositoryAssociation", DataRepositoryAssociationArgs.builder()        
            .fileSystemId(exampleLustreFileSystem.id())
            .dataRepositoryPath(exampleBucketV2.id().applyValue(id -> String.format("s3://%s", id)))
            .fileSystemPath("/my-bucket")
            .s3(DataRepositoryAssociationS3Args.builder()
                .autoExportPolicy(DataRepositoryAssociationS3AutoExportPolicyArgs.builder()
                    .events(                    
                        "NEW",
                        "CHANGED",
                        "DELETED")
                    .build())
                .autoImportPolicy(DataRepositoryAssociationS3AutoImportPolicyArgs.builder()
                    .events(                    
                        "NEW",
                        "CHANGED",
                        "DELETED")
                    .build())
                .build())
            .build());

    }
}
```

</details>

## [*partial failure*] Application Load Balancer

### HCL

```terraform
resource "aws_lb" "test" {
  name               = "test-lb-tf"
  internal           = false
  load_balancer_type = "application"
  security_groups    = [aws_security_group.lb_sg.id]
  subnets            = [for subnet in aws_subnet.public : subnet.id]

  enable_deletion_protection = true

  access_logs {
    bucket  = aws_s3_bucket.lb_logs.bucket
    prefix  = "test-lb"
    enabled = true
  }

  tags = {
    Environment = "production"
  }
}

```

### Failed Languages

#### csharp

```text
<nil>: not yet implemented: ForExpression; not yet implemented: ForExpression
```

#### go

```text
<nil>: not yet implemented: For expression; not yet implemented: For expression
```

#### yaml

```text
.pp:4,24-69: Failed to generate YAML program: For; Pulumi YAML cannot represent for loops.If the values of the for loop are known, you can manually unroll the loop, otherwise it is necessary to switch to a more expressive language.
```

#### java

```text
<nil>: not yet implemented: ForExpression; not yet implemented: ForExpression
```

### Successes

<details>

<summary>typescript</summary>

```typescript
import * as pulumi from "@pulumi/pulumi";
import * as aws from "@pulumi/aws";

const test = new aws.lb.LoadBalancer("test", {
    internal: false,
    loadBalancerType: "application",
    securityGroups: [aws_security_group.lb_sg.id],
    subnets: .map(subnet => subnet.id),
    enableDeletionProtection: true,
    accessLogs: {
        bucket: aws_s3_bucket.lb_logs.bucket,
        prefix: "test-lb",
        enabled: true,
    },
    tags: {
        Environment: "production",
    },
});
```

</details>

<details>

<summary>python</summary>

```python
import pulumi
import pulumi_aws as aws

test = aws.lb.LoadBalancer("test",
    internal=False,
    load_balancer_type="application",
    security_groups=[aws_security_group["lb_sg"]["id"]],
    subnets=[subnet["id"] for subnet in aws_subnet["public"]],
    enable_deletion_protection=True,
    access_logs=aws.lb.LoadBalancerAccessLogsArgs(
        bucket=aws_s3_bucket["lb_logs"]["bucket"],
        prefix="test-lb",
        enabled=True,
    ),
    tags={
        "Environment": "production",
    })
```

</details>

## [*partial failure*] Network Load Balancer

### HCL

```terraform
resource "aws_lb" "test" {
  name               = "test-lb-tf"
  internal           = false
  load_balancer_type = "network"
  subnets            = [for subnet in aws_subnet.public : subnet.id]

  enable_deletion_protection = true

  tags = {
    Environment = "production"
  }
}

```

### Failed Languages

#### csharp

```text
<nil>: not yet implemented: ForExpression; not yet implemented: ForExpression
```

#### go

```text
<nil>: not yet implemented: For expression; not yet implemented: For expression
```

#### yaml

```text
.pp:3,24-69: Failed to generate YAML program: For; Pulumi YAML cannot represent for loops.If the values of the for loop are known, you can manually unroll the loop, otherwise it is necessary to switch to a more expressive language.
```

#### java

```text
<nil>: not yet implemented: ForExpression; not yet implemented: ForExpression
```

### Successes

<details>

<summary>typescript</summary>

```typescript
import * as pulumi from "@pulumi/pulumi";
import * as aws from "@pulumi/aws";

const test = new aws.lb.LoadBalancer("test", {
    internal: false,
    loadBalancerType: "network",
    subnets: .map(subnet => subnet.id),
    enableDeletionProtection: true,
    tags: {
        Environment: "production",
    },
});
```

</details>

<details>

<summary>python</summary>

```python
import pulumi
import pulumi_aws as aws

test = aws.lb.LoadBalancer("test",
    internal=False,
    load_balancer_type="network",
    subnets=[subnet["id"] for subnet in aws_subnet["public"]],
    enable_deletion_protection=True,
    tags={
        "Environment": "production",
    })
```

</details>

## [*partial failure*] Basic mysql blueprint

### HCL

```terraform
resource "aws_lightsail_database" "test" {
  name                 = "test"
  availability_zone    = "us-east-1a"
  master_database_name = "testdatabasename"
  master_password      = "testdatabasepassword"
  master_username      = "test"
  blueprint_id         = "mysql_8_0"
  bundle_id            = "micro_1_0"
}

```

### Failed Languages

#### python

```text
:0,0-0: unknown property 'name' among [preferredMaintenanceWindow preferredBackupWindow relationalDatabaseName skipFinalSnapshot bundleId finalSnapshotName masterDatabaseName masterPassword applyImmediately availabilityZone backupRetentionEnabled blueprintId masterUsername publiclyAccessible tags]; 
```

#### csharp

```text
:0,0-0: unknown property 'name' among [relationalDatabaseName skipFinalSnapshot tags availabilityZone backupRetentionEnabled masterDatabaseName masterUsername applyImmediately bundleId finalSnapshotName preferredBackupWindow blueprintId masterPassword preferredMaintenanceWindow publiclyAccessible]; 
```

#### go

```text
:0,0-0: unknown property 'name' among [publiclyAccessible tags masterUsername preferredMaintenanceWindow masterPassword availabilityZone masterDatabaseName applyImmediately backupRetentionEnabled finalSnapshotName preferredBackupWindow relationalDatabaseName skipFinalSnapshot blueprintId bundleId]; 
```

### Successes

<details>

<summary>typescript</summary>

```typescript
import * as pulumi from "@pulumi/pulumi";
import * as aws from "@pulumi/aws";

const test = new aws.lightsail.Database("test", {
    availabilityZone: "us-east-1a",
    blueprintId: "mysql_8_0",
    bundleId: "micro_1_0",
    masterDatabaseName: "testdatabasename",
    masterPassword: "testdatabasepassword",
    masterUsername: "test",
    name: "test",
});
```

</details>

<details>

<summary>yaml</summary>

```yaml
resources:
  test:
    type: aws:lightsail:Database
    properties:
      availabilityZone: us-east-1a
      blueprintId: mysql_8_0
      bundleId: micro_1_0
      masterDatabaseName: testdatabasename
      masterPassword: testdatabasepassword
      masterUsername: test
      name: test
```

</details>

<details>

<summary>java</summary>

```java
package generated_program;

import com.pulumi.Context;
import com.pulumi.Pulumi;
import com.pulumi.core.Output;
import com.pulumi.aws.lightsail.Database;
import com.pulumi.aws.lightsail.DatabaseArgs;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;

public class App {
    public static void main(String[] args) {
        Pulumi.run(App::stack);
    }

    public static void stack(Context ctx) {
        var test = new Database("test", DatabaseArgs.builder()        
            .availabilityZone("us-east-1a")
            .blueprintId("mysql_8_0")
            .bundleId("micro_1_0")
            .masterDatabaseName("testdatabasename")
            .masterPassword("testdatabasepassword")
            .masterUsername("test")
            .name("test")
            .build());

    }
}
```

</details>

## [*partial failure*] Basic postrgres blueprint

### HCL

```terraform
resource "aws_lightsail_database" "test" {
  name                 = "test"
  availability_zone    = "us-east-1a"
  master_database_name = "testdatabasename"
  master_password      = "testdatabasepassword"
  master_username      = "test"
  blueprint_id         = "postgres_12"
  bundle_id            = "micro_1_0"
}

```

### Failed Languages

#### python

```text
:0,0-0: unknown property 'name' among [masterDatabaseName masterUsername preferredBackupWindow blueprintId bundleId masterPassword publiclyAccessible skipFinalSnapshot applyImmediately relationalDatabaseName availabilityZone backupRetentionEnabled finalSnapshotName preferredMaintenanceWindow tags]; 
```

#### csharp

```text
:0,0-0: unknown property 'name' among [bundleId masterDatabaseName relationalDatabaseName tags availabilityZone masterUsername preferredMaintenanceWindow publiclyAccessible blueprintId masterPassword finalSnapshotName preferredBackupWindow skipFinalSnapshot applyImmediately backupRetentionEnabled]; 
```

#### go

```text
:0,0-0: unknown property 'name' among [masterUsername relationalDatabaseName bundleId masterDatabaseName preferredMaintenanceWindow tags availabilityZone backupRetentionEnabled blueprintId finalSnapshotName applyImmediately masterPassword preferredBackupWindow publiclyAccessible skipFinalSnapshot]; 
```

### Successes

<details>

<summary>yaml</summary>

```yaml
resources:
  test:
    type: aws:lightsail:Database
    properties:
      availabilityZone: us-east-1a
      blueprintId: postgres_12
      bundleId: micro_1_0
      masterDatabaseName: testdatabasename
      masterPassword: testdatabasepassword
      masterUsername: test
      name: test
```

</details>

<details>

<summary>java</summary>

```java
package generated_program;

import com.pulumi.Context;
import com.pulumi.Pulumi;
import com.pulumi.core.Output;
import com.pulumi.aws.lightsail.Database;
import com.pulumi.aws.lightsail.DatabaseArgs;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;

public class App {
    public static void main(String[] args) {
        Pulumi.run(App::stack);
    }

    public static void stack(Context ctx) {
        var test = new Database("test", DatabaseArgs.builder()        
            .availabilityZone("us-east-1a")
            .blueprintId("postgres_12")
            .bundleId("micro_1_0")
            .masterDatabaseName("testdatabasename")
            .masterPassword("testdatabasepassword")
            .masterUsername("test")
            .name("test")
            .build());

    }
}
```

</details>

<details>

<summary>typescript</summary>

```typescript
import * as pulumi from "@pulumi/pulumi";
import * as aws from "@pulumi/aws";

const test = new aws.lightsail.Database("test", {
    availabilityZone: "us-east-1a",
    blueprintId: "postgres_12",
    bundleId: "micro_1_0",
    masterDatabaseName: "testdatabasename",
    masterPassword: "testdatabasepassword",
    masterUsername: "test",
    name: "test",
});
```

</details>

## [*partial failure*] Custom backup and maintenance windows

### HCL

```terraform
resource "aws_lightsail_database" "test" {
  name                         = "test"
  availability_zone            = "us-east-1a"
  master_database_name         = "testdatabasename"
  master_password              = "testdatabasepassword"
  master_username              = "test"
  blueprint_id                 = "postgres_12"
  bundle_id                    = "micro_1_0"
  preferred_backup_window      = "16:00-16:30"
  preferred_maintenance_window = "Tue:17:00-Tue:17:30"
}

```

### Failed Languages

#### python

```text
:0,0-0: unknown property 'name' among [applyImmediately tags finalSnapshotName masterUsername publiclyAccessible skipFinalSnapshot availabilityZone backupRetentionEnabled blueprintId bundleId relationalDatabaseName masterDatabaseName masterPassword preferredBackupWindow preferredMaintenanceWindow]; 
```

#### csharp

```text
:0,0-0: unknown property 'name' among [blueprintId finalSnapshotName preferredMaintenanceWindow tags relationalDatabaseName applyImmediately availabilityZone backupRetentionEnabled masterDatabaseName masterPassword masterUsername skipFinalSnapshot bundleId preferredBackupWindow publiclyAccessible]; 
```

#### go

```text
:0,0-0: unknown property 'name' among [blueprintId preferredMaintenanceWindow masterDatabaseName publiclyAccessible finalSnapshotName preferredBackupWindow relationalDatabaseName masterUsername skipFinalSnapshot tags applyImmediately availabilityZone backupRetentionEnabled bundleId masterPassword]; 
```

### Successes

<details>

<summary>typescript</summary>

```typescript
import * as pulumi from "@pulumi/pulumi";
import * as aws from "@pulumi/aws";

const test = new aws.lightsail.Database("test", {
    availabilityZone: "us-east-1a",
    blueprintId: "postgres_12",
    bundleId: "micro_1_0",
    masterDatabaseName: "testdatabasename",
    masterPassword: "testdatabasepassword",
    masterUsername: "test",
    name: "test",
    preferredBackupWindow: "16:00-16:30",
    preferredMaintenanceWindow: "Tue:17:00-Tue:17:30",
});
```

</details>

<details>

<summary>yaml</summary>

```yaml
resources:
  test:
    type: aws:lightsail:Database
    properties:
      availabilityZone: us-east-1a
      blueprintId: postgres_12
      bundleId: micro_1_0
      masterDatabaseName: testdatabasename
      masterPassword: testdatabasepassword
      masterUsername: test
      name: test
      preferredBackupWindow: 16:00-16:30
      preferredMaintenanceWindow: Tue:17:00-Tue:17:30
```

</details>

<details>

<summary>java</summary>

```java
package generated_program;

import com.pulumi.Context;
import com.pulumi.Pulumi;
import com.pulumi.core.Output;
import com.pulumi.aws.lightsail.Database;
import com.pulumi.aws.lightsail.DatabaseArgs;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;

public class App {
    public static void main(String[] args) {
        Pulumi.run(App::stack);
    }

    public static void stack(Context ctx) {
        var test = new Database("test", DatabaseArgs.builder()        
            .availabilityZone("us-east-1a")
            .blueprintId("postgres_12")
            .bundleId("micro_1_0")
            .masterDatabaseName("testdatabasename")
            .masterPassword("testdatabasepassword")
            .masterUsername("test")
            .name("test")
            .preferredBackupWindow("16:00-16:30")
            .preferredMaintenanceWindow("Tue:17:00-Tue:17:30")
            .build());

    }
}
```

</details>

## [*partial failure*] Final Snapshots

### HCL

```terraform
resource "aws_lightsail_database" "test" {
  name                         = "test"
  availability_zone            = "us-east-1a"
  master_database_name         = "testdatabasename"
  master_password              = "testdatabasepassword"
  master_username              = "test"
  blueprint_id                 = "postgres_12"
  bundle_id                    = "micro_1_0"
  preferred_backup_window      = "16:00-16:30"
  preferred_maintenance_window = "Tue:17:00-Tue:17:30"
  final_snapshot_name          = "MyFinalSnapshot"
}

```

### Failed Languages

#### go

```text
:0,0-0: unknown property 'name' among [blueprintId bundleId finalSnapshotName masterPassword masterUsername preferredBackupWindow applyImmediately backupRetentionEnabled publiclyAccessible relationalDatabaseName skipFinalSnapshot tags availabilityZone masterDatabaseName preferredMaintenanceWindow]; 
```

#### python

```text
:0,0-0: unknown property 'name' among [availabilityZone blueprintId relationalDatabaseName skipFinalSnapshot backupRetentionEnabled masterPassword tags applyImmediately masterDatabaseName masterUsername preferredBackupWindow preferredMaintenanceWindow publiclyAccessible bundleId finalSnapshotName]; 
```

#### csharp

```text
:0,0-0: unknown property 'name' among [bundleId masterDatabaseName preferredBackupWindow preferredMaintenanceWindow skipFinalSnapshot tags availabilityZone backupRetentionEnabled finalSnapshotName publiclyAccessible applyImmediately blueprintId masterPassword masterUsername relationalDatabaseName]; 
```

### Successes

<details>

<summary>typescript</summary>

```typescript
import * as pulumi from "@pulumi/pulumi";
import * as aws from "@pulumi/aws";

const test = new aws.lightsail.Database("test", {
    availabilityZone: "us-east-1a",
    blueprintId: "postgres_12",
    bundleId: "micro_1_0",
    finalSnapshotName: "MyFinalSnapshot",
    masterDatabaseName: "testdatabasename",
    masterPassword: "testdatabasepassword",
    masterUsername: "test",
    name: "test",
    preferredBackupWindow: "16:00-16:30",
    preferredMaintenanceWindow: "Tue:17:00-Tue:17:30",
});
```

</details>

<details>

<summary>yaml</summary>

```yaml
resources:
  test:
    type: aws:lightsail:Database
    properties:
      availabilityZone: us-east-1a
      blueprintId: postgres_12
      bundleId: micro_1_0
      finalSnapshotName: MyFinalSnapshot
      masterDatabaseName: testdatabasename
      masterPassword: testdatabasepassword
      masterUsername: test
      name: test
      preferredBackupWindow: 16:00-16:30
      preferredMaintenanceWindow: Tue:17:00-Tue:17:30
```

</details>

<details>

<summary>java</summary>

```java
package generated_program;

import com.pulumi.Context;
import com.pulumi.Pulumi;
import com.pulumi.core.Output;
import com.pulumi.aws.lightsail.Database;
import com.pulumi.aws.lightsail.DatabaseArgs;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;

public class App {
    public static void main(String[] args) {
        Pulumi.run(App::stack);
    }

    public static void stack(Context ctx) {
        var test = new Database("test", DatabaseArgs.builder()        
            .availabilityZone("us-east-1a")
            .blueprintId("postgres_12")
            .bundleId("micro_1_0")
            .finalSnapshotName("MyFinalSnapshot")
            .masterDatabaseName("testdatabasename")
            .masterPassword("testdatabasepassword")
            .masterUsername("test")
            .name("test")
            .preferredBackupWindow("16:00-16:30")
            .preferredMaintenanceWindow("Tue:17:00-Tue:17:30")
            .build());

    }
}
```

</details>

## [*partial failure*] Apply Immediately

### HCL

```terraform
resource "aws_lightsail_database" "test" {
  name                 = "test"
  availability_zone    = "us-east-1a"
  master_database_name = "testdatabasename"
  master_password      = "testdatabasepassword"
  master_username      = "test"
  blueprint_id         = "postgres_12"
  bundle_id            = "micro_1_0"
  apply_immediately    = true
}

```

### Failed Languages

#### python

```text
:0,0-0: unknown property 'name' among [preferredBackupWindow preferredMaintenanceWindow skipFinalSnapshot tags finalSnapshotName masterPassword masterUsername applyImmediately bundleId backupRetentionEnabled blueprintId masterDatabaseName publiclyAccessible relationalDatabaseName availabilityZone]; 
```

#### csharp

```text
:0,0-0: unknown property 'name' among [tags backupRetentionEnabled bundleId finalSnapshotName publiclyAccessible skipFinalSnapshot blueprintId masterPassword preferredBackupWindow applyImmediately masterUsername relationalDatabaseName availabilityZone masterDatabaseName preferredMaintenanceWindow]; 
```

#### go

```text
:0,0-0: unknown property 'name' among [tags backupRetentionEnabled bundleId finalSnapshotName preferredMaintenanceWindow publiclyAccessible relationalDatabaseName applyImmediately masterDatabaseName masterUsername blueprintId masterPassword skipFinalSnapshot availabilityZone preferredBackupWindow]; 
```

### Successes

<details>

<summary>yaml</summary>

```yaml
resources:
  test:
    type: aws:lightsail:Database
    properties:
      applyImmediately: true
      availabilityZone: us-east-1a
      blueprintId: postgres_12
      bundleId: micro_1_0
      masterDatabaseName: testdatabasename
      masterPassword: testdatabasepassword
      masterUsername: test
      name: test
```

</details>

<details>

<summary>java</summary>

```java
package generated_program;

import com.pulumi.Context;
import com.pulumi.Pulumi;
import com.pulumi.core.Output;
import com.pulumi.aws.lightsail.Database;
import com.pulumi.aws.lightsail.DatabaseArgs;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;

public class App {
    public static void main(String[] args) {
        Pulumi.run(App::stack);
    }

    public static void stack(Context ctx) {
        var test = new Database("test", DatabaseArgs.builder()        
            .applyImmediately(true)
            .availabilityZone("us-east-1a")
            .blueprintId("postgres_12")
            .bundleId("micro_1_0")
            .masterDatabaseName("testdatabasename")
            .masterPassword("testdatabasepassword")
            .masterUsername("test")
            .name("test")
            .build());

    }
}
```

</details>

<details>

<summary>typescript</summary>

```typescript
import * as pulumi from "@pulumi/pulumi";
import * as aws from "@pulumi/aws";

const test = new aws.lightsail.Database("test", {
    applyImmediately: true,
    availabilityZone: "us-east-1a",
    blueprintId: "postgres_12",
    bundleId: "micro_1_0",
    masterDatabaseName: "testdatabasename",
    masterPassword: "testdatabasepassword",
    masterUsername: "test",
    name: "test",
});
```

</details>

## [*partial failure*] #/resources/aws:opsworks/application:Application

### HCL

```terraform
resource "aws_opsworks_application" "foo-app" {
  name        = "foobar application"
  short_name  = "foobar"
  stack_id    = aws_opsworks_stack.main.id
  type        = "rails"
  description = "This is a Rails application"

  domains = [
    "example.com",
    "sub.example.com",
  ]

  environment {
    key    = "key"
    value  = "value"
    secure = false
  }

  app_source {
    type     = "git"
    revision = "master"
    url      = "https://github.com/example.git"
  }

  enable_ssl = true

  ssl_configuration {
    private_key = file("./foobar.key")
    certificate = file("./foobar.crt")
  }

  document_root         = "public"
  auto_bundle_on_deploy = true
  rails_env             = "staging"
}

```

### Failed Languages

#### yaml

```text
.pp:20,18-42: Failed to generate YAML program: Unknown Function; YAML does not support Fn::readFile., and 1 other diagnostic(s)
```

### Successes

<details>

<summary>go</summary>

```go
package main

import (
	"io/ioutil"

	"github.com/pulumi/pulumi-aws/sdk/v5/go/aws/opsworks"
	"github.com/pulumi/pulumi/sdk/v3/go/pulumi"
)

func readFileOrPanic(path string) pulumi.StringPtrInput {
	data, err := ioutil.ReadFile(path)
	if err != nil {
		panic(err.Error())
	}
	return pulumi.String(string(data))
}

func main() {
	pulumi.Run(func(ctx *pulumi.Context) error {
		_, err := opsworks.NewApplication(ctx, "foo-app", &opsworks.ApplicationArgs{
			ShortName:   pulumi.String("foobar"),
			StackId:     pulumi.Any(aws_opsworks_stack.Main.Id),
			Type:        pulumi.String("rails"),
			Description: pulumi.String("This is a Rails application"),
			Domains: pulumi.StringArray{
				pulumi.String("example.com"),
				pulumi.String("sub.example.com"),
			},
			Environments: opsworks.ApplicationEnvironmentArray{
				&opsworks.ApplicationEnvironmentArgs{
					Key:    pulumi.String("key"),
					Value:  pulumi.String("value"),
					Secure: pulumi.Bool(false),
				},
			},
			AppSources: opsworks.ApplicationAppSourceArray{
				&opsworks.ApplicationAppSourceArgs{
					Type:     pulumi.String("git"),
					Revision: pulumi.String("master"),
					Url:      pulumi.String("https://github.com/example.git"),
				},
			},
			EnableSsl: pulumi.Bool(true),
			SslConfigurations: opsworks.ApplicationSslConfigurationArray{
				&opsworks.ApplicationSslConfigurationArgs{
					PrivateKey:  readFileOrPanic("./foobar.key"),
					Certificate: readFileOrPanic("./foobar.crt"),
				},
			},
			DocumentRoot:       pulumi.String("public"),
			AutoBundleOnDeploy: pulumi.String("true"),
			RailsEnv:           pulumi.String("staging"),
		})
		if err != nil {
			return err
		}
		return nil
	})
}
```

</details>

<details>

<summary>java</summary>

```java
package generated_program;

import com.pulumi.Context;
import com.pulumi.Pulumi;
import com.pulumi.core.Output;
import com.pulumi.aws.opsworks.Application;
import com.pulumi.aws.opsworks.ApplicationArgs;
import com.pulumi.aws.opsworks.inputs.ApplicationEnvironmentArgs;
import com.pulumi.aws.opsworks.inputs.ApplicationAppSourceArgs;
import com.pulumi.aws.opsworks.inputs.ApplicationSslConfigurationArgs;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;

public class App {
    public static void main(String[] args) {
        Pulumi.run(App::stack);
    }

    public static void stack(Context ctx) {
        var foo_app = new Application("foo-app", ApplicationArgs.builder()        
            .shortName("foobar")
            .stackId(aws_opsworks_stack.main().id())
            .type("rails")
            .description("This is a Rails application")
            .domains(            
                "example.com",
                "sub.example.com")
            .environments(ApplicationEnvironmentArgs.builder()
                .key("key")
                .value("value")
                .secure(false)
                .build())
            .appSources(ApplicationAppSourceArgs.builder()
                .type("git")
                .revision("master")
                .url("https://github.com/example.git")
                .build())
            .enableSsl(true)
            .sslConfigurations(ApplicationSslConfigurationArgs.builder()
                .privateKey(Files.readString(Paths.get("./foobar.key")))
                .certificate(Files.readString(Paths.get("./foobar.crt")))
                .build())
            .documentRoot("public")
            .autoBundleOnDeploy(true)
            .railsEnv("staging")
            .build());

    }
}
```

</details>

<details>

<summary>typescript</summary>

```typescript
import * as pulumi from "@pulumi/pulumi";
import * as aws from "@pulumi/aws";
import * as fs from "fs";

const foo_app = new aws.opsworks.Application("foo-app", {
    shortName: "foobar",
    stackId: aws_opsworks_stack.main.id,
    type: "rails",
    description: "This is a Rails application",
    domains: [
        "example.com",
        "sub.example.com",
    ],
    environments: [{
        key: "key",
        value: "value",
        secure: false,
    }],
    appSources: [{
        type: "git",
        revision: "master",
        url: "https://github.com/example.git",
    }],
    enableSsl: true,
    sslConfigurations: [{
        privateKey: fs.readFileSync("./foobar.key"),
        certificate: fs.readFileSync("./foobar.crt"),
    }],
    documentRoot: "public",
    autoBundleOnDeploy: "true",
    railsEnv: "staging",
});
```

</details>

<details>

<summary>python</summary>

```python
import pulumi
import pulumi_aws as aws

foo_app = aws.opsworks.Application("foo-app",
    short_name="foobar",
    stack_id=aws_opsworks_stack["main"]["id"],
    type="rails",
    description="This is a Rails application",
    domains=[
        "example.com",
        "sub.example.com",
    ],
    environments=[aws.opsworks.ApplicationEnvironmentArgs(
        key="key",
        value="value",
        secure=False,
    )],
    app_sources=[aws.opsworks.ApplicationAppSourceArgs(
        type="git",
        revision="master",
        url="https://github.com/example.git",
    )],
    enable_ssl=True,
    ssl_configurations=[aws.opsworks.ApplicationSslConfigurationArgs(
        private_key=(lambda path: open(path).read())("./foobar.key"),
        certificate=(lambda path: open(path).read())("./foobar.crt"),
    )],
    document_root="public",
    auto_bundle_on_deploy="true",
    rails_env="staging")
```

</details>

<details>

<summary>csharp</summary>

```csharp
using System.Collections.Generic;
using System.IO;
using Pulumi;
using Aws = Pulumi.Aws;

return await Deployment.RunAsync(() => 
{
    var foo_app = new Aws.OpsWorks.Application("foo-app", new()
    {
        ShortName = "foobar",
        StackId = aws_opsworks_stack.Main.Id,
        Type = "rails",
        Description = "This is a Rails application",
        Domains = new[]
        {
            "example.com",
            "sub.example.com",
        },
        Environments = new[]
        {
            new Aws.OpsWorks.Inputs.ApplicationEnvironmentArgs
            {
                Key = "key",
                Value = "value",
                Secure = false,
            },
        },
        AppSources = new[]
        {
            new Aws.OpsWorks.Inputs.ApplicationAppSourceArgs
            {
                Type = "git",
                Revision = "master",
                Url = "https://github.com/example.git",
            },
        },
        EnableSsl = true,
        SslConfigurations = new[]
        {
            new Aws.OpsWorks.Inputs.ApplicationSslConfigurationArgs
            {
                PrivateKey = File.ReadAllText("./foobar.key"),
                Certificate = File.ReadAllText("./foobar.crt"),
            },
        },
        DocumentRoot = "public",
        AutoBundleOnDeploy = "true",
        RailsEnv = "staging",
    });

});
```

</details>

## [*partial failure*] Static Website Hosting

### HCL

```terraform
resource "aws_s3_bucket" "b" {
  bucket = "s3-website-test.hashicorp.com"
  acl    = "public-read"
  policy = file("policy.json")

  website {
    index_document = "index.html"
    error_document = "error.html"

    routing_rules = <<EOF
[{
    "Condition": {
        "KeyPrefixEquals": "docs/"
    },
    "Redirect": {
        "ReplaceKeyPrefixWith": "documents/"
    }
}]
EOF
  }
}

```

### Failed Languages

#### yaml

```text
.pp:2,12-35: Failed to generate YAML program: Unknown Function; YAML does not support Fn::readFile.
```

### Successes

<details>

<summary>typescript</summary>

```typescript
import * as pulumi from "@pulumi/pulumi";
import * as aws from "@pulumi/aws";
import * as fs from "fs";

const bucketV2 = new aws.s3.BucketV2("bucketV2", {
    acl: "public-read",
    policy: fs.readFileSync("policy.json"),
    websites: [{
        indexDocument: "index.html",
        errorDocument: "error.html",
        routingRules: `[{
    "Condition": {
        "KeyPrefixEquals": "docs/"
    },
    "Redirect": {
        "ReplaceKeyPrefixWith": "documents/"
    }
}]
`,
    }],
});
```

</details>

<details>

<summary>python</summary>

```python
import pulumi
import pulumi_aws as aws

bucket_v2 = aws.s3.BucketV2("bucketV2",
    acl="public-read",
    policy=(lambda path: open(path).read())("policy.json"),
    websites=[aws.s3.BucketV2WebsiteArgs(
        index_document="index.html",
        error_document="error.html",
        routing_rules="""[{
    "Condition": {
        "KeyPrefixEquals": "docs/"
    },
    "Redirect": {
        "ReplaceKeyPrefixWith": "documents/"
    }
}]
""",
    )])
```

</details>

<details>

<summary>csharp</summary>

```csharp
using System.Collections.Generic;
using System.IO;
using Pulumi;
using Aws = Pulumi.Aws;

return await Deployment.RunAsync(() => 
{
    var bucketV2 = new Aws.S3.BucketV2("bucketV2", new()
    {
        Acl = "public-read",
        Policy = File.ReadAllText("policy.json"),
        Websites = new[]
        {
            new Aws.S3.Inputs.BucketV2WebsiteArgs
            {
                IndexDocument = "index.html",
                ErrorDocument = "error.html",
                RoutingRules = @"[{
    ""Condition"": {
        ""KeyPrefixEquals"": ""docs/""
    },
    ""Redirect"": {
        ""ReplaceKeyPrefixWith"": ""documents/""
    }
}]
",
            },
        },
    });

});
```

</details>

<details>

<summary>go</summary>

```go
package main

import (
	"fmt"
	"io/ioutil"

	"github.com/pulumi/pulumi-aws/sdk/v5/go/aws/s3"
	"github.com/pulumi/pulumi/sdk/v3/go/pulumi"
)

func readFileOrPanic(path string) pulumi.StringPtrInput {
	data, err := ioutil.ReadFile(path)
	if err != nil {
		panic(err.Error())
	}
	return pulumi.String(string(data))
}

func main() {
	pulumi.Run(func(ctx *pulumi.Context) error {
		_, err := s3.NewBucketV2(ctx, "bucketV2", &s3.BucketV2Args{
			Acl:    pulumi.String("public-read"),
			Policy: readFileOrPanic("policy.json"),
			Websites: s3.BucketV2WebsiteArray{
				&s3.BucketV2WebsiteArgs{
					IndexDocument: pulumi.String("index.html"),
					ErrorDocument: pulumi.String("error.html"),
					RoutingRules: pulumi.String(fmt.Sprintf(`[{
    "Condition": {
        "KeyPrefixEquals": "docs/"
    },
    "Redirect": {
        "ReplaceKeyPrefixWith": "documents/"
    }
}]
`)),
				},
			},
		})
		if err != nil {
			return err
		}
		return nil
	})
}
```

</details>

<details>

<summary>java</summary>

```java
package generated_program;

import com.pulumi.Context;
import com.pulumi.Pulumi;
import com.pulumi.core.Output;
import com.pulumi.aws.s3.BucketV2;
import com.pulumi.aws.s3.BucketV2Args;
import com.pulumi.aws.s3.inputs.BucketV2WebsiteArgs;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;

public class App {
    public static void main(String[] args) {
        Pulumi.run(App::stack);
    }

    public static void stack(Context ctx) {
        var bucketV2 = new BucketV2("bucketV2", BucketV2Args.builder()        
            .acl("public-read")
            .policy(Files.readString(Paths.get("policy.json")))
            .websites(BucketV2WebsiteArgs.builder()
                .indexDocument("index.html")
                .errorDocument("error.html")
                .routingRules("""
[{
    "Condition": {
        "KeyPrefixEquals": "docs/"
    },
    "Redirect": {
        "ReplaceKeyPrefixWith": "documents/"
    }
}]
                """)
                .build())
            .build());

    }
}
```

</details>

## [*partial failure*] Using object lock configuration

### HCL

```terraform
resource "aws_s3_bucket" "example" {
  bucket = "my-tf-example-bucket"

  object_lock_configuration {
    object_lock_enabled = "Enabled"

    rule {
      default_retention {
        mode = "COMPLIANCE"
        days = 5
      }
    }
  }
}

```

### Failed Languages

#### python

```text
:0,0-0: unknown property 'rule' among [objectLockEnabled rules]; , and 2 other diagnostic(s)
```

#### csharp

```text
:0,0-0: unknown property 'rule' among [objectLockEnabled rules]; , and 2 other diagnostic(s)
```

#### go

```text
:0,0-0: unknown property 'rule' among [objectLockEnabled rules]; , and 2 other diagnostic(s)
```

### Successes

<details>

<summary>java</summary>

```java
package generated_program;

import com.pulumi.Context;
import com.pulumi.Pulumi;
import com.pulumi.core.Output;
import com.pulumi.aws.s3.BucketV2;
import com.pulumi.aws.s3.BucketV2Args;
import com.pulumi.aws.s3.inputs.BucketV2ObjectLockConfigurationArgs;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;

public class App {
    public static void main(String[] args) {
        Pulumi.run(App::stack);
    }

    public static void stack(Context ctx) {
        var example = new BucketV2("example", BucketV2Args.builder()        
            .objectLockConfiguration(BucketV2ObjectLockConfigurationArgs.builder()
                .objectLockEnabled("Enabled")
                .rule(%!v(PANIC=Format method: runtime error: invalid memory address or nil pointer dereference))
                .build())
            .build());

    }
}
```

</details>

<details>

<summary>typescript</summary>

```typescript
import * as pulumi from "@pulumi/pulumi";
import * as aws from "@pulumi/aws";

const example = new aws.s3.BucketV2("example", {
    objectLockConfiguration: {
        objectLockEnabled: "Enabled",
        rules: [{
            defaultRetentions: [{
                days: 5,
                mode: "COMPLIANCE",
            }],
        }],
    },
});
```

</details>

<details>

<summary>yaml</summary>

```yaml
resources:
  example:
    type: aws:s3:BucketV2
    properties:
      objectLockConfiguration:
        objectLockEnabled: Enabled
        rule:
          - defaultRetention:
              - days: 5
                mode: COMPLIANCE
```

</details>

## [**complete failure**] ECS Run Task with Role and Task Override Usage

### HCL

```terraform
resource "aws_iam_role" "ecs_events" {
  name = "ecs_events"

  assume_role_policy = <<DOC
{
  "Version": "2012-10-17",
  "Statement": [
    {
      "Sid": "",
      "Effect": "Allow",
      "Principal": {
        "Service": "events.amazonaws.com"
      },
      "Action": "sts:AssumeRole"
    }
  ]
}
DOC
}

resource "aws_iam_role_policy" "ecs_events_run_task_with_any_role" {
  name = "ecs_events_run_task_with_any_role"
  role = aws_iam_role.ecs_events.id

  policy = <<DOC
{
    "Version": "2012-10-17",
    "Statement": [
        {
            "Effect": "Allow",
            "Action": "iam:PassRole",
            "Resource": "*"
        },
        {
            "Effect": "Allow",
            "Action": "ecs:RunTask",
            "Resource": "${replace(aws_ecs_task_definition.task_name.arn, "/:\\d+$/", ":*")}"
        }
    ]
}
DOC
}

resource "aws_cloudwatch_event_target" "ecs_scheduled_task" {
  target_id = "run-scheduled-task-every-hour"
  arn       = aws_ecs_cluster.cluster_name.arn
  rule      = aws_cloudwatch_event_rule.every_hour.name
  role_arn  = aws_iam_role.ecs_events.arn

  ecs_target {
    task_count          = 1
    task_definition_arn = aws_ecs_task_definition.task_name.arn
  }

  input = <<DOC
{
  "containerOverrides": [
    {
      "name": "name-of-container-to-override",
      "command": ["bin/console", "scheduled-task"]
    }
  ]
}
DOC
}

```

### Failed Languages

#### yaml

```text
:36,28-35: unknown function 'replace'; , and 1 other diagnostic(s)
```

#### java

```text
:36,28-35: unknown function 'replace'; , and 1 other diagnostic(s)
```

#### typescript

```text
:36,28-35: unknown function 'replace'; , and 1 other diagnostic(s)
```

#### python

```text
:36,28-35: unknown function 'replace'; , and 1 other diagnostic(s)
```

#### csharp

```text
:36,28-35: unknown function 'replace'; , and 1 other diagnostic(s)
```

#### go

```text
:36,28-35: unknown function 'replace'; , and 1 other diagnostic(s)
```

## [*partial failure*] #/resources/aws:cognito/identityPool:IdentityPool

### HCL

```terraform
resource "aws_iam_saml_provider" "default" {
  name                   = "my-saml-provider"
  saml_metadata_document = file("saml-metadata.xml")
}

resource "aws_cognito_identity_pool" "main" {
  identity_pool_name               = "identity pool"
  allow_unauthenticated_identities = false
  allow_classic_flow               = false

  cognito_identity_providers {
    client_id               = "6lhlkkfbfb4q5kpp90urffae"
    provider_name           = "cognito-idp.us-east-1.amazonaws.com/us-east-1_Tv0493apJ"
    server_side_token_check = false
  }

  cognito_identity_providers {
    client_id               = "7kodkvfqfb4qfkp39eurffae"
    provider_name           = "cognito-idp.us-east-1.amazonaws.com/eu-west-1_Zr231apJu"
    server_side_token_check = false
  }

  supported_login_providers = {
    "graph.facebook.com"  = "7346241598935552"
    "accounts.google.com" = "123456789012.apps.googleusercontent.com"
  }

  saml_provider_arns           = [aws_iam_saml_provider.default.arn]
  openid_connect_provider_arns = ["arn:aws:iam::123456789012:oidc-provider/id.example.com"]
}

```

### Failed Languages

#### yaml

```text
.pp:1,26-55: Failed to generate YAML program: Unknown Function; YAML does not support Fn::readFile.
```

### Successes

<details>

<summary>typescript</summary>

```typescript
import * as pulumi from "@pulumi/pulumi";
import * as aws from "@pulumi/aws";
import * as fs from "fs";

const _default = new aws.iam.SamlProvider("default", {samlMetadataDocument: fs.readFileSync("saml-metadata.xml")});
const main = new aws.cognito.IdentityPool("main", {
    identityPoolName: "identity pool",
    allowUnauthenticatedIdentities: false,
    allowClassicFlow: false,
    cognitoIdentityProviders: [
        {
            clientId: "6lhlkkfbfb4q5kpp90urffae",
            providerName: "cognito-idp.us-east-1.amazonaws.com/us-east-1_Tv0493apJ",
            serverSideTokenCheck: false,
        },
        {
            clientId: "7kodkvfqfb4qfkp39eurffae",
            providerName: "cognito-idp.us-east-1.amazonaws.com/eu-west-1_Zr231apJu",
            serverSideTokenCheck: false,
        },
    ],
    supportedLoginProviders: {
        "graph.facebook.com": "7346241598935552",
        "accounts.google.com": "123456789012.apps.googleusercontent.com",
    },
    samlProviderArns: [_default.arn],
    openidConnectProviderArns: ["arn:aws:iam::123456789012:oidc-provider/id.example.com"],
});
```

</details>

<details>

<summary>python</summary>

```python
import pulumi
import pulumi_aws as aws

default = aws.iam.SamlProvider("default", saml_metadata_document=(lambda path: open(path).read())("saml-metadata.xml"))
main = aws.cognito.IdentityPool("main",
    identity_pool_name="identity pool",
    allow_unauthenticated_identities=False,
    allow_classic_flow=False,
    cognito_identity_providers=[
        aws.cognito.IdentityPoolCognitoIdentityProviderArgs(
            client_id="6lhlkkfbfb4q5kpp90urffae",
            provider_name="cognito-idp.us-east-1.amazonaws.com/us-east-1_Tv0493apJ",
            server_side_token_check=False,
        ),
        aws.cognito.IdentityPoolCognitoIdentityProviderArgs(
            client_id="7kodkvfqfb4qfkp39eurffae",
            provider_name="cognito-idp.us-east-1.amazonaws.com/eu-west-1_Zr231apJu",
            server_side_token_check=False,
        ),
    ],
    supported_login_providers={
        "graph.facebook.com": "7346241598935552",
        "accounts.google.com": "123456789012.apps.googleusercontent.com",
    },
    saml_provider_arns=[default.arn],
    openid_connect_provider_arns=["arn:aws:iam::123456789012:oidc-provider/id.example.com"])
```

</details>

<details>

<summary>csharp</summary>

```csharp
using System.Collections.Generic;
using System.IO;
using Pulumi;
using Aws = Pulumi.Aws;

return await Deployment.RunAsync(() => 
{
    var @default = new Aws.Iam.SamlProvider("default", new()
    {
        SamlMetadataDocument = File.ReadAllText("saml-metadata.xml"),
    });

    var main = new Aws.Cognito.IdentityPool("main", new()
    {
        IdentityPoolName = "identity pool",
        AllowUnauthenticatedIdentities = false,
        AllowClassicFlow = false,
        CognitoIdentityProviders = new[]
        {
            new Aws.Cognito.Inputs.IdentityPoolCognitoIdentityProviderArgs
            {
                ClientId = "6lhlkkfbfb4q5kpp90urffae",
                ProviderName = "cognito-idp.us-east-1.amazonaws.com/us-east-1_Tv0493apJ",
                ServerSideTokenCheck = false,
            },
            new Aws.Cognito.Inputs.IdentityPoolCognitoIdentityProviderArgs
            {
                ClientId = "7kodkvfqfb4qfkp39eurffae",
                ProviderName = "cognito-idp.us-east-1.amazonaws.com/eu-west-1_Zr231apJu",
                ServerSideTokenCheck = false,
            },
        },
        SupportedLoginProviders = 
        {
            { "graph.facebook.com", "7346241598935552" },
            { "accounts.google.com", "123456789012.apps.googleusercontent.com" },
        },
        SamlProviderArns = new[]
        {
            @default.Arn,
        },
        OpenidConnectProviderArns = new[]
        {
            "arn:aws:iam::123456789012:oidc-provider/id.example.com",
        },
    });

});
```

</details>

<details>

<summary>go</summary>

```go
package main

import (
	"io/ioutil"

	"github.com/pulumi/pulumi-aws/sdk/v5/go/aws/cognito"
	"github.com/pulumi/pulumi-aws/sdk/v5/go/aws/iam"
	"github.com/pulumi/pulumi/sdk/v3/go/pulumi"
)

func readFileOrPanic(path string) pulumi.StringPtrInput {
	data, err := ioutil.ReadFile(path)
	if err != nil {
		panic(err.Error())
	}
	return pulumi.String(string(data))
}

func main() {
	pulumi.Run(func(ctx *pulumi.Context) error {
		_, err := iam.NewSamlProvider(ctx, "default", &iam.SamlProviderArgs{
			SamlMetadataDocument: readFileOrPanic("saml-metadata.xml"),
		})
		if err != nil {
			return err
		}
		_, err = cognito.NewIdentityPool(ctx, "main", &cognito.IdentityPoolArgs{
			IdentityPoolName:               pulumi.String("identity pool"),
			AllowUnauthenticatedIdentities: pulumi.Bool(false),
			AllowClassicFlow:               pulumi.Bool(false),
			CognitoIdentityProviders: cognito.IdentityPoolCognitoIdentityProviderArray{
				&cognito.IdentityPoolCognitoIdentityProviderArgs{
					ClientId:             pulumi.String("6lhlkkfbfb4q5kpp90urffae"),
					ProviderName:         pulumi.String("cognito-idp.us-east-1.amazonaws.com/us-east-1_Tv0493apJ"),
					ServerSideTokenCheck: pulumi.Bool(false),
				},
				&cognito.IdentityPoolCognitoIdentityProviderArgs{
					ClientId:             pulumi.String("7kodkvfqfb4qfkp39eurffae"),
					ProviderName:         pulumi.String("cognito-idp.us-east-1.amazonaws.com/eu-west-1_Zr231apJu"),
					ServerSideTokenCheck: pulumi.Bool(false),
				},
			},
			SupportedLoginProviders: pulumi.StringMap{
				"graph.facebook.com":  pulumi.String("7346241598935552"),
				"accounts.google.com": pulumi.String("123456789012.apps.googleusercontent.com"),
			},
			SamlProviderArns: pulumi.StringArray{
				_default.Arn,
			},
			OpenidConnectProviderArns: pulumi.StringArray{
				pulumi.String("arn:aws:iam::123456789012:oidc-provider/id.example.com"),
			},
		})
		if err != nil {
			return err
		}
		return nil
	})
}
```

</details>

<details>

<summary>java</summary>

```java
package generated_program;

import com.pulumi.Context;
import com.pulumi.Pulumi;
import com.pulumi.core.Output;
import com.pulumi.aws.iam.SamlProvider;
import com.pulumi.aws.iam.SamlProviderArgs;
import com.pulumi.aws.cognito.IdentityPool;
import com.pulumi.aws.cognito.IdentityPoolArgs;
import com.pulumi.aws.cognito.inputs.IdentityPoolCognitoIdentityProviderArgs;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;

public class App {
    public static void main(String[] args) {
        Pulumi.run(App::stack);
    }

    public static void stack(Context ctx) {
        var default_ = new SamlProvider("default", SamlProviderArgs.builder()        
            .samlMetadataDocument(Files.readString(Paths.get("saml-metadata.xml")))
            .build());

        var main = new IdentityPool("main", IdentityPoolArgs.builder()        
            .identityPoolName("identity pool")
            .allowUnauthenticatedIdentities(false)
            .allowClassicFlow(false)
            .cognitoIdentityProviders(            
                IdentityPoolCognitoIdentityProviderArgs.builder()
                    .clientId("6lhlkkfbfb4q5kpp90urffae")
                    .providerName("cognito-idp.us-east-1.amazonaws.com/us-east-1_Tv0493apJ")
                    .serverSideTokenCheck(false)
                    .build(),
                IdentityPoolCognitoIdentityProviderArgs.builder()
                    .clientId("7kodkvfqfb4qfkp39eurffae")
                    .providerName("cognito-idp.us-east-1.amazonaws.com/eu-west-1_Zr231apJu")
                    .serverSideTokenCheck(false)
                    .build())
            .supportedLoginProviders(Map.ofEntries(
                Map.entry("graph.facebook.com", "7346241598935552"),
                Map.entry("accounts.google.com", "123456789012.apps.googleusercontent.com")
            ))
            .samlProviderArns(default_.arn())
            .openidConnectProviderArns("arn:aws:iam::123456789012:oidc-provider/id.example.com")
            .build());

    }
}
```

</details>

## [*partial failure*] #/resources/aws:pinpoint/apnsVoipSandboxChannel:ApnsVoipSandboxChannel

### HCL

```terraform
resource "aws_pinpoint_apns_voip_sandbox_channel" "apns_voip_sandbox" {
  application_id = aws_pinpoint_app.app.application_id

  certificate = file("./certificate.pem")
  private_key = file("./private_key.key")
}

resource "aws_pinpoint_app" "app" {}

```

### Failed Languages

#### yaml

```text
.pp:2,17-46: Failed to generate YAML program: Unknown Function; YAML does not support Fn::readFile., and 1 other diagnostic(s)
```

### Successes

<details>

<summary>typescript</summary>

```typescript
import * as pulumi from "@pulumi/pulumi";
import * as aws from "@pulumi/aws";
import * as fs from "fs";

const app = new aws.pinpoint.App("app", {});
const apnsVoipSandbox = new aws.pinpoint.ApnsVoipSandboxChannel("apnsVoipSandbox", {
    applicationId: app.applicationId,
    certificate: fs.readFileSync("./certificate.pem"),
    privateKey: fs.readFileSync("./private_key.key"),
});
```

</details>

<details>

<summary>python</summary>

```python
import pulumi
import pulumi_aws as aws

app = aws.pinpoint.App("app")
apns_voip_sandbox = aws.pinpoint.ApnsVoipSandboxChannel("apnsVoipSandbox",
    application_id=app.application_id,
    certificate=(lambda path: open(path).read())("./certificate.pem"),
    private_key=(lambda path: open(path).read())("./private_key.key"))
```

</details>

<details>

<summary>csharp</summary>

```csharp
using System.Collections.Generic;
using System.IO;
using Pulumi;
using Aws = Pulumi.Aws;

return await Deployment.RunAsync(() => 
{
    var app = new Aws.Pinpoint.App("app");

    var apnsVoipSandbox = new Aws.Pinpoint.ApnsVoipSandboxChannel("apnsVoipSandbox", new()
    {
        ApplicationId = app.ApplicationId,
        Certificate = File.ReadAllText("./certificate.pem"),
        PrivateKey = File.ReadAllText("./private_key.key"),
    });

});
```

</details>

<details>

<summary>go</summary>

```go
package main

import (
	"io/ioutil"

	"github.com/pulumi/pulumi-aws/sdk/v5/go/aws/pinpoint"
	"github.com/pulumi/pulumi/sdk/v3/go/pulumi"
)

func readFileOrPanic(path string) pulumi.StringPtrInput {
	data, err := ioutil.ReadFile(path)
	if err != nil {
		panic(err.Error())
	}
	return pulumi.String(string(data))
}

func main() {
	pulumi.Run(func(ctx *pulumi.Context) error {
		app, err := pinpoint.NewApp(ctx, "app", nil)
		if err != nil {
			return err
		}
		_, err = pinpoint.NewApnsVoipSandboxChannel(ctx, "apnsVoipSandbox", &pinpoint.ApnsVoipSandboxChannelArgs{
			ApplicationId: app.ApplicationId,
			Certificate:   readFileOrPanic("./certificate.pem"),
			PrivateKey:    readFileOrPanic("./private_key.key"),
		})
		if err != nil {
			return err
		}
		return nil
	})
}
```

</details>

<details>

<summary>java</summary>

```java
package generated_program;

import com.pulumi.Context;
import com.pulumi.Pulumi;
import com.pulumi.core.Output;
import com.pulumi.aws.pinpoint.App;
import com.pulumi.aws.pinpoint.ApnsVoipSandboxChannel;
import com.pulumi.aws.pinpoint.ApnsVoipSandboxChannelArgs;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;

public class App {
    public static void main(String[] args) {
        Pulumi.run(App::stack);
    }

    public static void stack(Context ctx) {
        var app = new App("app");

        var apnsVoipSandbox = new ApnsVoipSandboxChannel("apnsVoipSandbox", ApnsVoipSandboxChannelArgs.builder()        
            .applicationId(app.applicationId())
            .certificate(Files.readString(Paths.get("./certificate.pem")))
            .privateKey(Files.readString(Paths.get("./private_key.key")))
            .build());

    }
}
```

</details>

## [*partial failure*] #/resources/aws:iam/signingCertificate:SigningCertificate

### HCL

```terraform
resource "aws_iam_signing_certificate" "test_cert" {
  username         = "some_test_cert"
  certificate_body = file("self-ca-cert.pem")
}

```

### Failed Languages

#### go

```text
:0,0-0: unknown property 'username' among [certificateBody status userName]; 
```

#### yaml

```text
.pp:2,21-49: Failed to generate YAML program: Unknown Function; YAML does not support Fn::readFile.
```

#### typescript

```text
:0,0-0: unknown property 'username' among [certificateBody status userName]; 
```

#### python

```text
:0,0-0: unknown property 'username' among [certificateBody status userName]; 
```

#### csharp

```text
:0,0-0: unknown property 'username' among [certificateBody status userName]; 
```

### Successes

<details>

<summary>java</summary>

```java
package generated_program;

import com.pulumi.Context;
import com.pulumi.Pulumi;
import com.pulumi.core.Output;
import com.pulumi.aws.iam.SigningCertificate;
import com.pulumi.aws.iam.SigningCertificateArgs;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;

public class App {
    public static void main(String[] args) {
        Pulumi.run(App::stack);
    }

    public static void stack(Context ctx) {
        var testCert = new SigningCertificate("testCert", SigningCertificateArgs.builder()        
            .username("some_test_cert")
            .certificateBody(Files.readString(Paths.get("self-ca-cert.pem")))
            .build());

    }
}
```

</details>

## [*partial failure*] #/resources/aws:iam/signingCertificate:SigningCertificate

### HCL

```terraform
resource "aws_iam_signing_certificate" "test_cert_alt" {
  username = "some_test_cert"

  certificate_body = <<EOF
-----BEGIN CERTIFICATE-----
[......] # cert contents
-----END CERTIFICATE-----
EOF
}

```

### Failed Languages

#### python

```text
:0,0-0: unknown property 'username' among [certificateBody status userName]; 
```

#### csharp

```text
:0,0-0: unknown property 'username' among [status userName certificateBody]; 
```

#### go

```text
:0,0-0: unknown property 'username' among [certificateBody status userName]; 
```

### Successes

<details>

<summary>typescript</summary>

```typescript
import * as pulumi from "@pulumi/pulumi";
import * as aws from "@pulumi/aws";

const testCertAlt = new aws.iam.SigningCertificate("test_cert_alt", {
    certificateBody: `-----BEGIN CERTIFICATE-----
[......] # cert contents
-----END CERTIFICATE-----
`,
    username: "some_test_cert",
});
```

</details>

<details>

<summary>yaml</summary>

```yaml
resources:
  testCertAlt:
    type: aws:iam:SigningCertificate
    properties:
      certificateBody: |+
        -----BEGIN CERTIFICATE-----
        [......] # cert contents
        -----END CERTIFICATE-----

      username: some_test_cert
```

</details>

<details>

<summary>java</summary>

```java
package generated_program;

import com.pulumi.Context;
import com.pulumi.Pulumi;
import com.pulumi.core.Output;
import com.pulumi.aws.iam.SigningCertificate;
import com.pulumi.aws.iam.SigningCertificateArgs;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;

public class App {
    public static void main(String[] args) {
        Pulumi.run(App::stack);
    }

    public static void stack(Context ctx) {
        var testCertAlt = new SigningCertificate("testCertAlt", SigningCertificateArgs.builder()        
            .certificateBody("""
-----BEGIN CERTIFICATE-----
[......] # cert contents
-----END CERTIFICATE-----

            """)
            .username("some_test_cert")
            .build());

    }
}
```

</details>

## [**complete failure**] Basic Authentication

### HCL

```terraform
resource "aws_amplify_app" "example" {
  name = "app"
}

resource "aws_amplify_branch" "master" {
  app_id      = aws_amplify_app.example.id
  branch_name = "master"

  enable_basic_auth      = true
  basic_auth_credentials = base64encode("username:password")
}

```

### Failed Languages

#### csharp

```text
:9,28-40: unknown function 'base64encode'; , and 1 other diagnostic(s)
```

#### go

```text
:9,28-40: unknown function 'base64encode'; , and 1 other diagnostic(s)
```

#### yaml

```text
:9,28-40: unknown function 'base64encode'; , and 1 other diagnostic(s)
```

#### java

```text
:9,28-40: unknown function 'base64encode'; , and 1 other diagnostic(s)
```

#### typescript

```text
:9,28-40: unknown function 'base64encode'; , and 1 other diagnostic(s)
```

#### python

```text
:9,28-40: unknown function 'base64encode'; , and 1 other diagnostic(s)
```

## [*partial failure*] Logging Individual S3 Buckets And Specific Event Names By Using Advanced Event Selectors

### HCL

```terraform
data "aws_s3_bucket" "important-bucket-1" {
  bucket = "important-bucket-1"
}

data "aws_s3_bucket" "important-bucket-2" {
  bucket = "important-bucket-2"
}

data "aws_s3_bucket" "important-bucket-3" {
  bucket = "important-bucket-3"
}

resource "aws_cloudtrail" "example" {
  # ... other configuration ...

  advanced_event_selector {
    name = "Log PutObject and DeleteObject events for two S3 buckets"

    field_selector {
      field  = "eventCategory"
      equals = ["Data"]
    }

    field_selector {
      field = "eventName"

      equals = [
        "PutObject",
        "DeleteObject"
      ]
    }

    field_selector {
      field = "resources.ARN"

      #The trailing slash is intentional; do not exclude it.
      equals = [
        "${data.aws_s3_bucket.important-bucket-1.arn}/",
        "${data.aws_s3_bucket.important-bucket-2.arn}/"
      ]
    }

    field_selector {
      field  = "readOnly"
      equals = ["false"]
    }

    field_selector {
      field  = "resources.type"
      equals = ["AWS::S3::Object"]
    }
  }

  advanced_event_selector {
    name = "Log Delete* events for one S3 bucket"

    field_selector {
      field  = "eventCategory"
      equals = ["Data"]
    }

    field_selector {
      field       = "eventName"
      starts_with = ["Delete"]
    }

    field_selector {
      field = "resources.ARN"

      #The trailing slash is intentional; do not exclude it.
      equals = [
        "${data.aws_s3_bucket.important-bucket-3.arn}/important-prefix"
      ]
    }

    field_selector {
      field  = "readOnly"
      equals = ["false"]
    }

    field_selector {
      field  = "resources.type"
      equals = ["AWS::S3::Object"]
    }
  }
}

```

### Failed Languages

#### python

```text
:0,0-0: unknown property 'startsWith' among [endsWiths equals field notEndsWiths notEquals notStartsWiths startsWiths]; , and 4 other diagnostic(s)
```

#### csharp

```text
:0,0-0: unknown property 'startsWith' among [startsWiths endsWiths equals field notEndsWiths notEquals notStartsWiths]; , and 4 other diagnostic(s)
```

#### go

```text
:0,0-0: unknown property 'startsWith' among [notEquals notStartsWiths startsWiths endsWiths equals field notEndsWiths]; , and 4 other diagnostic(s)
```

### Successes

<details>

<summary>yaml</summary>

```yaml
resources:
  example:
    type: aws:cloudtrail:Trail
    properties:
      advancedEventSelectors:
        - fieldSelectors:
            - equals:
                - Data
              field: eventCategory
            - equals:
                - PutObject
                - DeleteObject
              field: eventName
            - equals:
                - ${["important-bucket-1"].arn}/
                - ${["important-bucket-2"].arn}/
              field: resources.ARN
            - equals:
                - false
              field: readOnly
            - equals:
                - AWS::S3::Object
              field: resources.type
          name: Log PutObject and DeleteObject events for two S3 buckets
        - fieldSelectors:
            - equals:
                - Data
              field: eventCategory
            - field: eventName
              startsWith:
                - Delete
            - equals:
                - ${["important-bucket-3"].arn}/important-prefix
              field: resources.ARN
            - equals:
                - false
              field: readOnly
            - equals:
                - AWS::S3::Object
              field: resources.type
          name: Log Delete* events for one S3 bucket
variables:
  important-bucket-1:
    Fn::Invoke:
      Function: aws:s3:getBucket
      Arguments:
        bucket: important-bucket-1
  important-bucket-2:
    Fn::Invoke:
      Function: aws:s3:getBucket
      Arguments:
        bucket: important-bucket-2
  important-bucket-3:
    Fn::Invoke:
      Function: aws:s3:getBucket
      Arguments:
        bucket: important-bucket-3
```

</details>

<details>

<summary>java</summary>

```java
package generated_program;

import com.pulumi.Context;
import com.pulumi.Pulumi;
import com.pulumi.core.Output;
import com.pulumi.aws.s3.S3Functions;
import com.pulumi.aws.s3.inputs.GetBucketArgs;
import com.pulumi.aws.cloudtrail.Trail;
import com.pulumi.aws.cloudtrail.TrailArgs;
import com.pulumi.aws.cloudtrail.inputs.TrailAdvancedEventSelectorArgs;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;

public class App {
    public static void main(String[] args) {
        Pulumi.run(App::stack);
    }

    public static void stack(Context ctx) {
        final var important-bucket-1 = S3Functions.getBucket(GetBucketArgs.builder()
            .bucket("important-bucket-1")
            .build());

        final var important-bucket-2 = S3Functions.getBucket(GetBucketArgs.builder()
            .bucket("important-bucket-2")
            .build());

        final var important-bucket-3 = S3Functions.getBucket(GetBucketArgs.builder()
            .bucket("important-bucket-3")
            .build());

        var example = new Trail("example", TrailArgs.builder()        
            .advancedEventSelectors(            
                TrailAdvancedEventSelectorArgs.builder()
                    .fieldSelectors(                    
                        TrailAdvancedEventSelectorFieldSelectorArgs.builder()
                            .equals("Data")
                            .field("eventCategory")
                            .build(),
                        TrailAdvancedEventSelectorFieldSelectorArgs.builder()
                            .equals(                            
                                "PutObject",
                                "DeleteObject")
                            .field("eventName")
                            .build(),
                        TrailAdvancedEventSelectorFieldSelectorArgs.builder()
                            .equals(                            
                                String.format("%s/", important_bucket_1.arn()),
                                String.format("%s/", important_bucket_2.arn()))
                            .field("resources.ARN")
                            .build(),
                        TrailAdvancedEventSelectorFieldSelectorArgs.builder()
                            .equals("false")
                            .field("readOnly")
                            .build(),
                        TrailAdvancedEventSelectorFieldSelectorArgs.builder()
                            .equals("AWS::S3::Object")
                            .field("resources.type")
                            .build())
                    .name("Log PutObject and DeleteObject events for two S3 buckets")
                    .build(),
                TrailAdvancedEventSelectorArgs.builder()
                    .fieldSelectors(                    
                        TrailAdvancedEventSelectorFieldSelectorArgs.builder()
                            .equals("Data")
                            .field("eventCategory")
                            .build(),
                        TrailAdvancedEventSelectorFieldSelectorArgs.builder()
                            .field("eventName")
                            .startsWith("Delete")
                            .build(),
                        TrailAdvancedEventSelectorFieldSelectorArgs.builder()
                            .equals(String.format("%s/important-prefix", important_bucket_3.arn()))
                            .field("resources.ARN")
                            .build(),
                        TrailAdvancedEventSelectorFieldSelectorArgs.builder()
                            .equals("false")
                            .field("readOnly")
                            .build(),
                        TrailAdvancedEventSelectorFieldSelectorArgs.builder()
                            .equals("AWS::S3::Object")
                            .field("resources.type")
                            .build())
                    .name("Log Delete* events for one S3 bucket")
                    .build())
            .build());

    }
}
```

</details>

<details>

<summary>typescript</summary>

```typescript
import * as pulumi from "@pulumi/pulumi";
import * as aws from "@pulumi/aws";

const important_bucket_1 = pulumi.output(aws.s3.getBucket({
    bucket: "important-bucket-1",
}));
const important_bucket_2 = pulumi.output(aws.s3.getBucket({
    bucket: "important-bucket-2",
}));
const important_bucket_3 = pulumi.output(aws.s3.getBucket({
    bucket: "important-bucket-3",
}));
const example = new aws.cloudtrail.Trail("example", {
    advancedEventSelectors: [
        {
            fieldSelectors: [
                {
                    equals: ["Data"],
                    field: "eventCategory",
                },
                {
                    equals: [
                        "PutObject",
                        "DeleteObject",
                    ],
                    field: "eventName",
                },
                {
                    //The trailing slash is intentional; do not exclude it.
                    equals: [
                        pulumi.interpolate`${important_bucket_1.arn}/`,
                        pulumi.interpolate`${important_bucket_2.arn}/`,
                    ],
                    field: "resources.ARN",
                },
                {
                    equals: ["false"],
                    field: "readOnly",
                },
                {
                    equals: ["AWS::S3::Object"],
                    field: "resources.type",
                },
            ],
            name: "Log PutObject and DeleteObject events for two S3 buckets",
        },
        {
            fieldSelectors: [
                {
                    equals: ["Data"],
                    field: "eventCategory",
                },
                {
                    field: "eventName",
                    startsWiths: ["Delete"],
                },
                {
                    //The trailing slash is intentional; do not exclude it.
                    equals: [pulumi.interpolate`${important_bucket_3.arn}/important-prefix`],
                    field: "resources.ARN",
                },
                {
                    equals: ["false"],
                    field: "readOnly",
                },
                {
                    equals: ["AWS::S3::Object"],
                    field: "resources.type",
                },
            ],
            name: "Log Delete* events for one S3 bucket",
        },
    ],
});
```

</details>

## [*partial failure*] #/resources/aws:fsx/backup:Backup

### HCL

```terraform
resource "aws_fsx_backup" "example" {
  file_system_id = aws_fsx_lustre_file_system.example.id
}

resource "aws_fsx_lustre_file_system" "example" {
  storage_capacity            = 1200
  subnet_ids                  = [aws_subnet.example.id]
  deployment_type             = "PERSISTENT_1"
  per_unit_storage_throughput = 50
}

```

### Failed Languages

#### typescript

```text
:0,0-0: cannot traverse value of type string; , and 2 other diagnostic(s)
```

#### python

```text
:0,0-0: cannot traverse value of type string; , and 2 other diagnostic(s)
```

#### csharp

```text
:0,0-0: cannot traverse value of type string; , and 2 other diagnostic(s)
```

#### go

```text
:0,0-0: cannot traverse value of type string; , and 2 other diagnostic(s)
```

### Successes

<details>

<summary>yaml</summary>

```yaml
resources:
  exampleBackup:
    type: aws:fsx:Backup
    properties:
      fileSystemId: ${exampleLustreFileSystem.id}
  exampleLustreFileSystem:
    type: aws:fsx:LustreFileSystem
    properties:
      storageCapacity: 1200
      subnetIds:
        - ${aws_subnet.example.id}
      deploymentType: PERSISTENT_1
      perUnitStorageThroughput: 50
```

</details>

<details>

<summary>java</summary>

```java
package generated_program;

import com.pulumi.Context;
import com.pulumi.Pulumi;
import com.pulumi.core.Output;
import com.pulumi.aws.fsx.LustreFileSystem;
import com.pulumi.aws.fsx.LustreFileSystemArgs;
import com.pulumi.aws.fsx.Backup;
import com.pulumi.aws.fsx.BackupArgs;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;

public class App {
    public static void main(String[] args) {
        Pulumi.run(App::stack);
    }

    public static void stack(Context ctx) {
        var exampleLustreFileSystem = new LustreFileSystem("exampleLustreFileSystem", LustreFileSystemArgs.builder()        
            .storageCapacity(1200)
            .subnetIds(aws_subnet.example().id())
            .deploymentType("PERSISTENT_1")
            .perUnitStorageThroughput(50)
            .build());

        var exampleBackup = new Backup("exampleBackup", BackupArgs.builder()        
            .fileSystemId(exampleLustreFileSystem.id())
            .build());

    }
}
```

</details>

## [*partial failure*] #/resources/aws:fsx/backup:Backup

### HCL

```terraform
resource "aws_fsx_backup" "example" {
  file_system_id = aws_fsx_openzfs_file_system.example.id
}

resource "aws_fsx_openzfs_file_system" "example" {
  storage_capacity    = 64
  subnet_ids          = [aws_subnet.example.id]
  deployment_type     = "SINGLE_AZ_1"
  throughput_capacity = 64
}

```

### Failed Languages

#### go

```text
:0,0-0: cannot traverse value of type string; , and 2 other diagnostic(s)
```

#### typescript

```text
:0,0-0: cannot traverse value of type string; , and 2 other diagnostic(s)
```

#### python

```text
:0,0-0: cannot traverse value of type string; , and 2 other diagnostic(s)
```

#### csharp

```text
:0,0-0: cannot traverse value of type string; , and 2 other diagnostic(s)
```

### Successes

<details>

<summary>yaml</summary>

```yaml
resources:
  exampleBackup:
    type: aws:fsx:Backup
    properties:
      fileSystemId: ${exampleOpenZfsFileSystem.id}
  exampleOpenZfsFileSystem:
    type: aws:fsx:OpenZfsFileSystem
    properties:
      storageCapacity: 64
      subnetIds:
        - ${aws_subnet.example.id}
      deploymentType: SINGLE_AZ_1
      throughputCapacity: 64
```

</details>

<details>

<summary>java</summary>

```java
package generated_program;

import com.pulumi.Context;
import com.pulumi.Pulumi;
import com.pulumi.core.Output;
import com.pulumi.aws.fsx.OpenZfsFileSystem;
import com.pulumi.aws.fsx.OpenZfsFileSystemArgs;
import com.pulumi.aws.fsx.Backup;
import com.pulumi.aws.fsx.BackupArgs;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;

public class App {
    public static void main(String[] args) {
        Pulumi.run(App::stack);
    }

    public static void stack(Context ctx) {
        var exampleOpenZfsFileSystem = new OpenZfsFileSystem("exampleOpenZfsFileSystem", OpenZfsFileSystemArgs.builder()        
            .storageCapacity(64)
            .subnetIds(aws_subnet.example().id())
            .deploymentType("SINGLE_AZ_1")
            .throughputCapacity(64)
            .build());

        var exampleBackup = new Backup("exampleBackup", BackupArgs.builder()        
            .fileSystemId(exampleOpenZfsFileSystem.id())
            .build());

    }
}
```

</details>

## [**complete failure**] Non-AWS Service

### HCL

```terraform
resource "aws_vpc_endpoint" "ptfe_service" {
  vpc_id            = var.vpc_id
  service_name      = var.ptfe_service
  vpc_endpoint_type = "Interface"

  security_group_ids = [
    aws_security_group.ptfe_service.id,
  ]

  subnet_ids          = [local.subnet_ids]
  private_dns_enabled = false
}

data "aws_route53_zone" "internal" {
  name         = "vpc.internal."
  private_zone = true
  vpc_id       = var.vpc_id
}

resource "aws_route53_record" "ptfe_service" {
  zone_id = data.aws_route53_zone.internal.zone_id
  name    = "ptfe.${data.aws_route53_zone.internal.name}"
  type    = "CNAME"
  ttl     = "300"
  records = [aws_vpc_endpoint.ptfe_service.dns_entry[0]["dns_name"]]
}

```

### Failed Languages

#### typescript

```text
.pp:19,50-62: unknown property 'dns_name' among [dnsName hostedZoneId]; 
```

#### python

```text
.pp:19,50-62: unknown property 'dns_name' among [dnsName hostedZoneId]; 
```

#### csharp

```text
.pp:19,50-62: unknown property 'dns_name' among [hostedZoneId dnsName]; 
```

#### go

```text
.pp:19,50-62: unknown property 'dns_name' among [dnsName hostedZoneId]; 
```

#### yaml

```text
.pp:19,50-62: unknown property 'dns_name' among [dnsName hostedZoneId]; 
```

#### java

```text
.pp:19,50-62: unknown property 'dns_name' among [dnsName hostedZoneId]; 
```

## [*partial failure*] #/resources/aws:eks/nodeGroup:NodeGroup

### HCL

```terraform
resource "aws_eks_node_group" "example" {
  cluster_name    = aws_eks_cluster.example.name
  node_group_name = "example"
  node_role_arn   = aws_iam_role.example.arn
  subnet_ids      = aws_subnet.example[*].id

  scaling_config {
    desired_size = 1
    max_size     = 2
    min_size     = 1
  }

  update_config {
    max_unavailable = 1
  }

  # Ensure that IAM Role permissions are created before and deleted after EKS Node Group handling.
  # Otherwise, EKS will not be able to properly delete EC2 Instances and Elastic Network Interfaces.
  depends_on = [
    aws_iam_role_policy_attachment.example-AmazonEKSWorkerNodePolicy,
    aws_iam_role_policy_attachment.example-AmazonEKS_CNI_Policy,
    aws_iam_role_policy_attachment.example-AmazonEC2ContainerRegistryReadOnly,
  ]
}

```

### Failed Languages

#### go

```text
failed to convert HCL for #/resources/aws:eks/nodeGroup:NodeGroup to go: invalid Go source code:

package main

import (

"github.com/pulumi/pulumi/sdk/v3/go/pulumi"
"github.com/pulumi/pulumi-aws/sdk/v5/go/aws/eks"
)
func main() {
pulumi.Run(func(ctx *pulumi.Context) error {
_, err := eks.NewNodeGroup(ctx, "example", &eks.NodeGroupArgs{
ClusterName: pulumi.Any(aws_eks_cluster.Example.Name),
NodeRoleArn: pulumi.Any(aws_iam_role.Example.Arn),
SubnetIds: %!v(PANIC=Format method: fatal: A failure has occurred: unlowered splat expression @ #-resources-aws:eks-nodeGroup:NodeGroup.tf.pp:3,20-44),
ScalingConfig: &eks.NodeGroupScalingConfigArgs{
DesiredSize: pulumi.Int(1),
MaxSize: pulumi.Int(2),
MinSize: pulumi.Int(1),
},
UpdateConfig: &eks.NodeGroupUpdateConfigArgs{
MaxUnavailable: pulumi.Int(1),
},
}, pulumi.DependsOn([]pulumi.Resource{
aws_iam_role_policy_attachment.Example-AmazonEKSWorkerNodePolicy,
aws_iam_role_policy_attachment.Example-AmazonEKS_CNI_Policy,
aws_iam_role_policy_attachment.Example-AmazonEC2ContainerRegistryReadOnly,
}))
if err != nil {
return err
}
return nil
})
}
: 13:12: expected operand, found '%' (and 7 more errors)
```

#### yaml

```text
.pp:3,20-44: Failed to generate YAML program: Splat; A 'Splat' expression is equivalent in expressive power to a 'for loop', and is not representable in YAML.
If the values of the function are known, you can manually unroll the loop, otherwise it is necessary to switch to a more expressive language., and 3 other diagnostic(s)
```

### Successes

<details>

<summary>python</summary>

```python
import pulumi
import pulumi_aws as aws

example = aws.eks.NodeGroup("example",
    cluster_name=aws_eks_cluster["example"]["name"],
    node_role_arn=aws_iam_role["example"]["arn"],
    subnet_ids=[__item["id"] for __item in aws_subnet["example"]],
    scaling_config=aws.eks.NodeGroupScalingConfigArgs(
        desired_size=1,
        max_size=2,
        min_size=1,
    ),
    update_config=aws.eks.NodeGroupUpdateConfigArgs(
        max_unavailable=1,
    ),
    opts=pulumi.ResourceOptions(depends_on=[
            aws_iam_role_policy_attachment["example-AmazonEKSWorkerNodePolicy"],
            aws_iam_role_policy_attachment["example-AmazonEKS_CNI_Policy"],
            aws_iam_role_policy_attachment["example-AmazonEC2ContainerRegistryReadOnly"],
        ]))
```

</details>

<details>

<summary>csharp</summary>

```csharp
using System.Collections.Generic;
using System.Linq;
using Pulumi;
using Aws = Pulumi.Aws;

return await Deployment.RunAsync(() => 
{
    var example = new Aws.Eks.NodeGroup("example", new()
    {
        ClusterName = aws_eks_cluster.Example.Name,
        NodeRoleArn = aws_iam_role.Example.Arn,
        SubnetIds = aws_subnet.Example.Select(__item => __item.Id).ToList(),
        ScalingConfig = new Aws.Eks.Inputs.NodeGroupScalingConfigArgs
        {
            DesiredSize = 1,
            MaxSize = 2,
            MinSize = 1,
        },
        UpdateConfig = new Aws.Eks.Inputs.NodeGroupUpdateConfigArgs
        {
            MaxUnavailable = 1,
        },
    }, new CustomResourceOptions
    {
        DependsOn = new[]
        {
            aws_iam_role_policy_attachment.Example_AmazonEKSWorkerNodePolicy,
            aws_iam_role_policy_attachment.Example_AmazonEKS_CNI_Policy,
            aws_iam_role_policy_attachment.Example_AmazonEC2ContainerRegistryReadOnly,
        },
    });

});
```

</details>

<details>

<summary>java</summary>

```java
package generated_program;

import com.pulumi.Context;
import com.pulumi.Pulumi;
import com.pulumi.core.Output;
import com.pulumi.aws.eks.NodeGroup;
import com.pulumi.aws.eks.NodeGroupArgs;
import com.pulumi.aws.eks.inputs.NodeGroupScalingConfigArgs;
import com.pulumi.aws.eks.inputs.NodeGroupUpdateConfigArgs;
import com.pulumi.resources.CustomResourceOptions;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;

public class App {
    public static void main(String[] args) {
        Pulumi.run(App::stack);
    }

    public static void stack(Context ctx) {
        var example = new NodeGroup("example", NodeGroupArgs.builder()        
            .clusterName(aws_eks_cluster.example().name())
            .nodeRoleArn(aws_iam_role.example().arn())
            .subnetIds(aws_subnet.example().stream().map(element -> element.id()).collect(toList()))
            .scalingConfig(NodeGroupScalingConfigArgs.builder()
                .desiredSize(1)
                .maxSize(2)
                .minSize(1)
                .build())
            .updateConfig(NodeGroupUpdateConfigArgs.builder()
                .maxUnavailable(1)
                .build())
            .build(), CustomResourceOptions.builder()
                .dependsOn(                
                    aws_iam_role_policy_attachment.example-AmazonEKSWorkerNodePolicy(),
                    aws_iam_role_policy_attachment.example-AmazonEKS_CNI_Policy(),
                    aws_iam_role_policy_attachment.example-AmazonEC2ContainerRegistryReadOnly())
                .build());

    }
}
```

</details>

<details>

<summary>typescript</summary>

```typescript
import * as pulumi from "@pulumi/pulumi";
import * as aws from "@pulumi/aws";

const example = new aws.eks.NodeGroup("example", {
    clusterName: aws_eks_cluster.example.name,
    nodeRoleArn: aws_iam_role.example.arn,
    subnetIds: aws_subnet.example.map(__item => __item.id),
    scalingConfig: {
        desiredSize: 1,
        maxSize: 2,
        minSize: 1,
    },
    updateConfig: {
        maxUnavailable: 1,
    },
}, {
    dependsOn: [
        aws_iam_role_policy_attachment["example-AmazonEKSWorkerNodePolicy"],
        aws_iam_role_policy_attachment["example-AmazonEKS_CNI_Policy"],
        aws_iam_role_policy_attachment["example-AmazonEC2ContainerRegistryReadOnly"],
    ],
});
```

</details>

## [**complete failure**] Example Subnets for EKS Node Group

### HCL

```terraform
data "aws_availability_zones" "available" {
  state = "available"
}

resource "aws_subnet" "example" {
  count = 2

  availability_zone = data.aws_availability_zones.available.names[count.index]
  cidr_block        = cidrsubnet(aws_vpc.example.cidr_block, 8, count.index)
  vpc_id            = aws_vpc.example.id

  tags = {
    "kubernetes.io/cluster/${aws_eks_cluster.example.name}" = "shared"
  }
}

```

### Failed Languages

#### go

```text
.pp:8,22-37: cannot iterate over a value of type union(list(string), none); , and 1 other diagnostic(s)
```

#### yaml

```text
.pp:8,22-37: cannot iterate over a value of type union(list(string), none); , and 1 other diagnostic(s)
```

#### java

```text
.pp:8,22-37: cannot iterate over a value of type union(list(string), none); , and 1 other diagnostic(s)
```

#### typescript

```text
.pp:8,22-37: cannot iterate over a value of type union(list(string), none); , and 1 other diagnostic(s)
```

#### python

```text
.pp:8,22-37: cannot iterate over a value of type union(list(string), none); , and 1 other diagnostic(s)
```

#### csharp

```text
.pp:8,22-37: cannot iterate over a value of type union(list(string), none); , and 1 other diagnostic(s)
```

## [*partial failure*] #/resources/aws:glue/partition:Partition

### HCL

```terraform
resource "aws_glue_partition" "example" {
  database_name = "some-database"
  table_name    = "some-table"
  values        = ["some-value"]
}

```

### Failed Languages

#### python

```text
:0,0-0: unknown property 'values' among [parameters partitionValues storageDescriptor tableName catalogId databaseName]; 
```

#### csharp

```text
:0,0-0: unknown property 'values' among [catalogId databaseName parameters partitionValues storageDescriptor tableName]; 
```

#### go

```text
:0,0-0: unknown property 'values' among [parameters partitionValues storageDescriptor tableName catalogId databaseName]; 
```

### Successes

<details>

<summary>java</summary>

```java
package generated_program;

import com.pulumi.Context;
import com.pulumi.Pulumi;
import com.pulumi.core.Output;
import com.pulumi.aws.glue.Partition;
import com.pulumi.aws.glue.PartitionArgs;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;

public class App {
    public static void main(String[] args) {
        Pulumi.run(App::stack);
    }

    public static void stack(Context ctx) {
        var example = new Partition("example", PartitionArgs.builder()        
            .databaseName("some-database")
            .tableName("some-table")
            .values("some-value")
            .build());

    }
}
```

</details>

<details>

<summary>typescript</summary>

```typescript
import * as pulumi from "@pulumi/pulumi";
import * as aws from "@pulumi/aws";

const example = new aws.glue.Partition("example", {
    databaseName: "some-database",
    tableName: "some-table",
    values: ["some-value"],
});
```

</details>

<details>

<summary>yaml</summary>

```yaml
resources:
  example:
    type: aws:glue:Partition
    properties:
      databaseName: some-database
      tableName: some-table
      values:
        - some-value
```

</details>

## [**complete failure**] Enabling IAM Roles for Service Accounts

### HCL

```terraform
resource "aws_eks_cluster" "example" {
  # ... other configuration ...
}

data "tls_certificate" "example" {
  url = aws_eks_cluster.example.identity[0].oidc[0].issuer
}

resource "aws_iam_openid_connect_provider" "example" {
  client_id_list  = ["sts.amazonaws.com"]
  thumbprint_list = [data.tls_certificate.example.certificates[0].sha1_fingerprint]
  url             = aws_eks_cluster.example.identity[0].oidc[0].issuer
}

data "aws_iam_policy_document" "example_assume_role_policy" {
  statement {
    actions = ["sts:AssumeRoleWithWebIdentity"]
    effect  = "Allow"

    condition {
      test     = "StringEquals"
      variable = "${replace(aws_iam_openid_connect_provider.example.url, "https://", "")}:sub"
      values   = ["system:serviceaccount:kube-system:aws-node"]
    }

    principals {
      identifiers = [aws_iam_openid_connect_provider.example.arn]
      type        = "Federated"
    }
  }
}

resource "aws_iam_role" "example" {
  assume_role_policy = data.aws_iam_policy_document.example_assume_role_policy.json
  name               = "example"
}

```

### Failed Languages

#### typescript

```text
:21,21-28: unknown function 'replace'; , and 1 other diagnostic(s)
```

#### python

```text
:21,21-28: unknown function 'replace'; , and 1 other diagnostic(s)
```

#### csharp

```text
:21,21-28: unknown function 'replace'; , and 1 other diagnostic(s)
```

#### go

```text
:21,21-28: unknown function 'replace'; , and 1 other diagnostic(s)
```

#### yaml

```text
:21,21-28: unknown function 'replace'; , and 1 other diagnostic(s)
```

#### java

```text
:21,21-28: unknown function 'replace'; , and 1 other diagnostic(s)
```

## [*partial failure*] #/resources/aws:apigateway/vpcLink:VpcLink

### HCL

```terraform
resource "aws_lb" "example" {
  name               = "example"
  internal           = true
  load_balancer_type = "network"

  subnet_mapping {
    subnet_id = "12345"
  }
}

resource "aws_api_gateway_vpc_link" "example" {
  name        = "example"
  description = "example description"
  target_arns = [aws_lb.example.arn]
}

```

### Failed Languages

#### typescript

```text
:0,0-0: cannot traverse value of type string; , and 2 other diagnostic(s)
```

#### python

```text
:0,0-0: cannot traverse value of type string; , and 2 other diagnostic(s)
```

#### csharp

```text
:0,0-0: cannot traverse value of type string; , and 2 other diagnostic(s)
```

#### go

```text
:0,0-0: cannot traverse value of type string; , and 2 other diagnostic(s)
```

### Successes

<details>

<summary>yaml</summary>

```yaml
resources:
  exampleLoadBalancer:
    type: aws:lb:LoadBalancer
    properties:
      internal: true
      loadBalancerType: network
      subnetMappings:
        - subnetId: 12345
  exampleVpcLink:
    type: aws:apigateway:VpcLink
    properties:
      description: example description
      targetArn:
        - ${exampleLoadBalancer.arn}
```

</details>

<details>

<summary>java</summary>

```java
package generated_program;

import com.pulumi.Context;
import com.pulumi.Pulumi;
import com.pulumi.core.Output;
import com.pulumi.aws.lb.LoadBalancer;
import com.pulumi.aws.lb.LoadBalancerArgs;
import com.pulumi.aws.lb.inputs.LoadBalancerSubnetMappingArgs;
import com.pulumi.aws.apigateway.VpcLink;
import com.pulumi.aws.apigateway.VpcLinkArgs;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;

public class App {
    public static void main(String[] args) {
        Pulumi.run(App::stack);
    }

    public static void stack(Context ctx) {
        var exampleLoadBalancer = new LoadBalancer("exampleLoadBalancer", LoadBalancerArgs.builder()        
            .internal(true)
            .loadBalancerType("network")
            .subnetMappings(LoadBalancerSubnetMappingArgs.builder()
                .subnetId("12345")
                .build())
            .build());

        var exampleVpcLink = new VpcLink("exampleVpcLink", VpcLinkArgs.builder()        
            .description("example description")
            .targetArn(exampleLoadBalancer.arn())
            .build());

    }
}
```

</details>

## [*partial failure*] #/resources/aws:fsx/openZfsFileSystem:OpenZfsFileSystem

### HCL

```terraform
resource "aws_fsx_openzfs_file_system" "test" {
  storage_capacity    = 64
  subnet_ids          = [aws_subnet.test1.id]
  deployment_type     = "SINGLE_AZ_1"
  throughput_capacity = 64
}

```

### Failed Languages

#### go

```text
:0,0-0: cannot traverse value of type string; , and 2 other diagnostic(s)
```

#### typescript

```text
:0,0-0: cannot traverse value of type string; , and 2 other diagnostic(s)
```

#### python

```text
:0,0-0: cannot traverse value of type string; , and 2 other diagnostic(s)
```

#### csharp

```text
:0,0-0: cannot traverse value of type string; , and 2 other diagnostic(s)
```

### Successes

<details>

<summary>yaml</summary>

```yaml
resources:
  test:
    type: aws:fsx:OpenZfsFileSystem
    properties:
      storageCapacity: 64
      subnetIds:
        - ${aws_subnet.test1.id}
      deploymentType: SINGLE_AZ_1
      throughputCapacity: 64
```

</details>

<details>

<summary>java</summary>

```java
package generated_program;

import com.pulumi.Context;
import com.pulumi.Pulumi;
import com.pulumi.core.Output;
import com.pulumi.aws.fsx.OpenZfsFileSystem;
import com.pulumi.aws.fsx.OpenZfsFileSystemArgs;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;

public class App {
    public static void main(String[] args) {
        Pulumi.run(App::stack);
    }

    public static void stack(Context ctx) {
        var test = new OpenZfsFileSystem("test", OpenZfsFileSystemArgs.builder()        
            .storageCapacity(64)
            .subnetIds(aws_subnet.test1().id())
            .deploymentType("SINGLE_AZ_1")
            .throughputCapacity(64)
            .build());

    }
}
```

</details>

## [*partial failure*] Root volume Example

### HCL

```terraform
resource "aws_fsx_openzfs_snapshot" "example" {
  name      = "example"
  volume_id = aws_fsx_openzfs_file_system.example.root_volume_id
}

resource "aws_fsx_openzfs_file_system" "example" {
  storage_capacity    = 64
  subnet_ids          = [aws_subnet.example.id]
  deployment_type     = "SINGLE_AZ_1"
  throughput_capacity = 64
}

```

### Failed Languages

#### go

```text
:0,0-0: cannot traverse value of type string; , and 2 other diagnostic(s)
```

#### typescript

```text
:0,0-0: cannot traverse value of type string; , and 2 other diagnostic(s)
```

#### python

```text
:0,0-0: cannot traverse value of type string; , and 2 other diagnostic(s)
```

#### csharp

```text
:0,0-0: cannot traverse value of type string; , and 2 other diagnostic(s)
```

### Successes

<details>

<summary>yaml</summary>

```yaml
resources:
  exampleOpenZfsSnapshot:
    type: aws:fsx:OpenZfsSnapshot
    properties:
      volumeId: ${exampleOpenZfsFileSystem.rootVolumeId}
  exampleOpenZfsFileSystem:
    type: aws:fsx:OpenZfsFileSystem
    properties:
      storageCapacity: 64
      subnetIds:
        - ${aws_subnet.example.id}
      deploymentType: SINGLE_AZ_1
      throughputCapacity: 64
```

</details>

<details>

<summary>java</summary>

```java
package generated_program;

import com.pulumi.Context;
import com.pulumi.Pulumi;
import com.pulumi.core.Output;
import com.pulumi.aws.fsx.OpenZfsFileSystem;
import com.pulumi.aws.fsx.OpenZfsFileSystemArgs;
import com.pulumi.aws.fsx.OpenZfsSnapshot;
import com.pulumi.aws.fsx.OpenZfsSnapshotArgs;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;

public class App {
    public static void main(String[] args) {
        Pulumi.run(App::stack);
    }

    public static void stack(Context ctx) {
        var exampleOpenZfsFileSystem = new OpenZfsFileSystem("exampleOpenZfsFileSystem", OpenZfsFileSystemArgs.builder()        
            .storageCapacity(64)
            .subnetIds(aws_subnet.example().id())
            .deploymentType("SINGLE_AZ_1")
            .throughputCapacity(64)
            .build());

        var exampleOpenZfsSnapshot = new OpenZfsSnapshot("exampleOpenZfsSnapshot", OpenZfsSnapshotArgs.builder()        
            .volumeId(exampleOpenZfsFileSystem.rootVolumeId())
            .build());

    }
}
```

</details>

## [*partial failure*] Child volume Example

### HCL

```terraform
resource "aws_fsx_openzfs_snapshot" "example" {
  name      = "example"
  volume_id = aws_fsx_openzfs_volume.example.id
}

resource "aws_fsx_openzfs_volume" "example" {
  name             = "example"
  parent_volume_id = aws_fsx_openzfs_file_system.example.root_volume_id
}

resource "aws_fsx_openzfs_file_system" "example" {
  storage_capacity    = 64
  subnet_ids          = [aws_subnet.example.id]
  deployment_type     = "SINGLE_AZ_1"
  throughput_capacity = 64
}

```

### Failed Languages

#### typescript

```text
:0,0-0: cannot traverse value of type string; , and 2 other diagnostic(s)
```

#### python

```text
:0,0-0: cannot traverse value of type string; , and 2 other diagnostic(s)
```

#### csharp

```text
:0,0-0: cannot traverse value of type string; , and 2 other diagnostic(s)
```

#### go

```text
:0,0-0: cannot traverse value of type string; , and 2 other diagnostic(s)
```

### Successes

<details>

<summary>yaml</summary>

```yaml
resources:
  exampleOpenZfsSnapshot:
    type: aws:fsx:OpenZfsSnapshot
    properties:
      volumeId: ${exampleOpenZfsVolume.id}
  exampleOpenZfsVolume:
    type: aws:fsx:OpenZfsVolume
    properties:
      parentVolumeId: ${exampleOpenZfsFileSystem.rootVolumeId}
  exampleOpenZfsFileSystem:
    type: aws:fsx:OpenZfsFileSystem
    properties:
      storageCapacity: 64
      subnetIds:
        - ${aws_subnet.example.id}
      deploymentType: SINGLE_AZ_1
      throughputCapacity: 64
```

</details>

<details>

<summary>java</summary>

```java
package generated_program;

import com.pulumi.Context;
import com.pulumi.Pulumi;
import com.pulumi.core.Output;
import com.pulumi.aws.fsx.OpenZfsFileSystem;
import com.pulumi.aws.fsx.OpenZfsFileSystemArgs;
import com.pulumi.aws.fsx.OpenZfsVolume;
import com.pulumi.aws.fsx.OpenZfsVolumeArgs;
import com.pulumi.aws.fsx.OpenZfsSnapshot;
import com.pulumi.aws.fsx.OpenZfsSnapshotArgs;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;

public class App {
    public static void main(String[] args) {
        Pulumi.run(App::stack);
    }

    public static void stack(Context ctx) {
        var exampleOpenZfsFileSystem = new OpenZfsFileSystem("exampleOpenZfsFileSystem", OpenZfsFileSystemArgs.builder()        
            .storageCapacity(64)
            .subnetIds(aws_subnet.example().id())
            .deploymentType("SINGLE_AZ_1")
            .throughputCapacity(64)
            .build());

        var exampleOpenZfsVolume = new OpenZfsVolume("exampleOpenZfsVolume", OpenZfsVolumeArgs.builder()        
            .parentVolumeId(exampleOpenZfsFileSystem.rootVolumeId())
            .build());

        var exampleOpenZfsSnapshot = new OpenZfsSnapshot("exampleOpenZfsSnapshot", OpenZfsSnapshotArgs.builder()        
            .volumeId(exampleOpenZfsVolume.id())
            .build());

    }
}
```

</details>

## [*partial failure*] #/resources/aws:iot/policyAttachment:PolicyAttachment

### HCL

```terraform
resource "aws_iot_policy" "pubsub" {
  name = "PubSubToAnyTopic"

  policy = <<EOF
{
  "Version": "2012-10-17",
  "Statement": [
    {
      "Action": [
        "iot:*"
      ],
      "Effect": "Allow",
      "Resource": "*"
    }
  ]
}
EOF
}

resource "aws_iot_certificate" "cert" {
  csr    = file("csr.pem")
  active = true
}

resource "aws_iot_policy_attachment" "att" {
  policy = aws_iot_policy.pubsub.name
  target = aws_iot_certificate.cert.arn
}

```

### Failed Languages

#### yaml

```text
.pp:17,12-31: Failed to generate YAML program: Unknown Function; YAML does not support Fn::readFile.
```

### Successes

<details>

<summary>csharp</summary>

```csharp
using System.Collections.Generic;
using System.IO;
using Pulumi;
using Aws = Pulumi.Aws;

return await Deployment.RunAsync(() => 
{
    var pubsub = new Aws.Iot.Policy("pubsub", new()
    {
        PolicyDocument = @"{
  ""Version"": ""2012-10-17"",
  ""Statement"": [
    {
      ""Action"": [
        ""iot:*""
      ],
      ""Effect"": ""Allow"",
      ""Resource"": ""*""
    }
  ]
}
",
    });

    var cert = new Aws.Iot.Certificate("cert", new()
    {
        Csr = File.ReadAllText("csr.pem"),
        Active = true,
    });

    var att = new Aws.Iot.PolicyAttachment("att", new()
    {
        Policy = pubsub.Name,
        Target = cert.Arn,
    });

});
```

</details>

<details>

<summary>go</summary>

```go
package main

import (
	"fmt"
	"io/ioutil"

	"github.com/pulumi/pulumi-aws/sdk/v5/go/aws"
	"github.com/pulumi/pulumi-aws/sdk/v5/go/aws/iot"
	"github.com/pulumi/pulumi/sdk/v3/go/pulumi"
)

func readFileOrPanic(path string) pulumi.StringPtrInput {
	data, err := ioutil.ReadFile(path)
	if err != nil {
		panic(err.Error())
	}
	return pulumi.String(string(data))
}

func main() {
	pulumi.Run(func(ctx *pulumi.Context) error {
		pubsub, err := iot.NewPolicy(ctx, "pubsub", &iot.PolicyArgs{
			Policy: pulumi.String(fmt.Sprintf(`{
  "Version": "2012-10-17",
  "Statement": [
    {
      "Action": [
        "iot:*"
      ],
      "Effect": "Allow",
      "Resource": "*"
    }
  ]
}
`)),
		})
		if err != nil {
			return err
		}
		cert, err := iot.NewCertificate(ctx, "cert", &iot.CertificateArgs{
			Csr:    readFileOrPanic("csr.pem"),
			Active: pulumi.Bool(true),
		})
		if err != nil {
			return err
		}
		_, err = iot.NewPolicyAttachment(ctx, "att", &iot.PolicyAttachmentArgs{
			Policy: pubsub.Name,
			Target: cert.Arn,
		})
		if err != nil {
			return err
		}
		return nil
	})
}
```

</details>

<details>

<summary>java</summary>

```java
package generated_program;

import com.pulumi.Context;
import com.pulumi.Pulumi;
import com.pulumi.core.Output;
import com.pulumi.aws.iot.Policy;
import com.pulumi.aws.iot.PolicyArgs;
import com.pulumi.aws.iot.Certificate;
import com.pulumi.aws.iot.CertificateArgs;
import com.pulumi.aws.iot.PolicyAttachment;
import com.pulumi.aws.iot.PolicyAttachmentArgs;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;

public class App {
    public static void main(String[] args) {
        Pulumi.run(App::stack);
    }

    public static void stack(Context ctx) {
        var pubsub = new Policy("pubsub", PolicyArgs.builder()        
            .policy("""
{
  "Version": "2012-10-17",
  "Statement": [
    {
      "Action": [
        "iot:*"
      ],
      "Effect": "Allow",
      "Resource": "*"
    }
  ]
}
            """)
            .build());

        var cert = new Certificate("cert", CertificateArgs.builder()        
            .csr(Files.readString(Paths.get("csr.pem")))
            .active(true)
            .build());

        var att = new PolicyAttachment("att", PolicyAttachmentArgs.builder()        
            .policy(pubsub.name())
            .target(cert.arn())
            .build());

    }
}
```

</details>

<details>

<summary>typescript</summary>

```typescript
import * as pulumi from "@pulumi/pulumi";
import * as aws from "@pulumi/aws";
import * as fs from "fs";

const pubsub = new aws.iot.Policy("pubsub", {policy: `{
  "Version": "2012-10-17",
  "Statement": [
    {
      "Action": [
        "iot:*"
      ],
      "Effect": "Allow",
      "Resource": "*"
    }
  ]
}
`});
const cert = new aws.iot.Certificate("cert", {
    csr: fs.readFileSync("csr.pem"),
    active: true,
});
const att = new aws.iot.PolicyAttachment("att", {
    policy: pubsub.name,
    target: cert.arn,
});
```

</details>

<details>

<summary>python</summary>

```python
import pulumi
import pulumi_aws as aws

pubsub = aws.iot.Policy("pubsub", policy="""{
  "Version": "2012-10-17",
  "Statement": [
    {
      "Action": [
        "iot:*"
      ],
      "Effect": "Allow",
      "Resource": "*"
    }
  ]
}
""")
cert = aws.iot.Certificate("cert",
    csr=(lambda path: open(path).read())("csr.pem"),
    active=True)
att = aws.iot.PolicyAttachment("att",
    policy=pubsub.name,
    target=cert.arn)
```

</details>

## [*partial failure*] Application Load Balancer

### HCL

```terraform
resource "aws_lb" "test" {
  name               = "test-lb-tf"
  internal           = false
  load_balancer_type = "application"
  security_groups    = [aws_security_group.lb_sg.id]
  subnets            = [for subnet in aws_subnet.public : subnet.id]

  enable_deletion_protection = true

  access_logs {
    bucket  = aws_s3_bucket.lb_logs.bucket
    prefix  = "test-lb"
    enabled = true
  }

  tags = {
    Environment = "production"
  }
}

```

### Failed Languages

#### csharp

```text
<nil>: not yet implemented: ForExpression; not yet implemented: ForExpression
```

#### go

```text
<nil>: not yet implemented: For expression; not yet implemented: For expression
```

#### yaml

```text
.pp:4,24-69: Failed to generate YAML program: For; Pulumi YAML cannot represent for loops.If the values of the for loop are known, you can manually unroll the loop, otherwise it is necessary to switch to a more expressive language.
```

#### java

```text
<nil>: not yet implemented: ForExpression; not yet implemented: ForExpression
```

### Successes

<details>

<summary>python</summary>

```python
import pulumi
import pulumi_aws as aws

test = aws.lb.LoadBalancer("test",
    internal=False,
    load_balancer_type="application",
    security_groups=[aws_security_group["lb_sg"]["id"]],
    subnets=[subnet["id"] for subnet in aws_subnet["public"]],
    enable_deletion_protection=True,
    access_logs=aws.lb.LoadBalancerAccessLogsArgs(
        bucket=aws_s3_bucket["lb_logs"]["bucket"],
        prefix="test-lb",
        enabled=True,
    ),
    tags={
        "Environment": "production",
    })
```

</details>

<details>

<summary>typescript</summary>

```typescript
import * as pulumi from "@pulumi/pulumi";
import * as aws from "@pulumi/aws";

const test = new aws.lb.LoadBalancer("test", {
    internal: false,
    loadBalancerType: "application",
    securityGroups: [aws_security_group.lb_sg.id],
    subnets: .map(subnet => subnet.id),
    enableDeletionProtection: true,
    accessLogs: {
        bucket: aws_s3_bucket.lb_logs.bucket,
        prefix: "test-lb",
        enabled: true,
    },
    tags: {
        Environment: "production",
    },
});
```

</details>

## [*partial failure*] Network Load Balancer

### HCL

```terraform
resource "aws_lb" "test" {
  name               = "test-lb-tf"
  internal           = false
  load_balancer_type = "network"
  subnets            = [for subnet in aws_subnet.public : subnet.id]

  enable_deletion_protection = true

  tags = {
    Environment = "production"
  }
}

```

### Failed Languages

#### yaml

```text
.pp:3,24-69: Failed to generate YAML program: For; Pulumi YAML cannot represent for loops.If the values of the for loop are known, you can manually unroll the loop, otherwise it is necessary to switch to a more expressive language.
```

#### java

```text
<nil>: not yet implemented: ForExpression; not yet implemented: ForExpression
```

#### csharp

```text
<nil>: not yet implemented: ForExpression; not yet implemented: ForExpression
```

#### go

```text
<nil>: not yet implemented: For expression; not yet implemented: For expression
```

### Successes

<details>

<summary>typescript</summary>

```typescript
import * as pulumi from "@pulumi/pulumi";
import * as aws from "@pulumi/aws";

const test = new aws.lb.LoadBalancer("test", {
    internal: false,
    loadBalancerType: "network",
    subnets: .map(subnet => subnet.id),
    enableDeletionProtection: true,
    tags: {
        Environment: "production",
    },
});
```

</details>

<details>

<summary>python</summary>

```python
import pulumi
import pulumi_aws as aws

test = aws.lb.LoadBalancer("test",
    internal=False,
    load_balancer_type="network",
    subnets=[subnet["id"] for subnet in aws_subnet["public"]],
    enable_deletion_protection=True,
    tags={
        "Environment": "production",
    })
```

</details>

## [*partial failure*] API Gateway Association

### HCL

```terraform
resource "aws_wafregional_ipset" "ipset" {
  name = "tfIPSet"

  ip_set_descriptor {
    type  = "IPV4"
    value = "192.0.7.0/24"
  }
}

resource "aws_wafregional_rule" "foo" {
  name        = "tfWAFRule"
  metric_name = "tfWAFRule"

  predicate {
    data_id = aws_wafregional_ipset.ipset.id
    negated = false
    type    = "IPMatch"
  }
}

resource "aws_wafregional_web_acl" "foo" {
  name        = "foo"
  metric_name = "foo"

  default_action {
    type = "ALLOW"
  }

  rule {
    action {
      type = "BLOCK"
    }

    priority = 1
    rule_id  = aws_wafregional_rule.foo.id
  }
}

resource "aws_api_gateway_rest_api" "example" {
  body = jsonencode({
    openapi = "3.0.1"
    info = {
      title   = "example"
      version = "1.0"
    }
    paths = {
      "/path1" = {
        get = {
          x-amazon-apigateway-integration = {
            httpMethod           = "GET"
            payloadFormatVersion = "1.0"
            type                 = "HTTP_PROXY"
            uri                  = "https://ip-ranges.amazonaws.com/ip-ranges.json"
          }
        }
      }
    }
  })

  name = "example"
}

resource "aws_api_gateway_deployment" "example" {
  rest_api_id = aws_api_gateway_rest_api.example.id

  triggers = {
    redeployment = sha1(jsonencode(aws_api_gateway_rest_api.example.body))
  }

  lifecycle {
    create_before_destroy = true
  }
}

resource "aws_api_gateway_stage" "example" {
  deployment_id = aws_api_gateway_deployment.example.id
  rest_api_id   = aws_api_gateway_rest_api.example.id
  stage_name    = "example"
}

resource "aws_wafregional_web_acl_association" "association" {
  resource_arn = aws_api_gateway_stage.example.arn
  web_acl_id   = aws_wafregional_web_acl.foo.id
}

```

### Failed Languages

#### yaml

```text
.pp:51,20-53: Failed to generate YAML program: Unknown Function; YAML does not support Fn::sha1.
```

### Successes

<details>

<summary>typescript</summary>

```typescript
import * as pulumi from "@pulumi/pulumi";
import * as aws from "@pulumi/aws";
import * as crypto from "crypto";

const ipset = new aws.wafregional.IpSet("ipset", {ipSetDescriptors: [{
    type: "IPV4",
    value: "192.0.7.0/24",
}]});
const fooRule = new aws.wafregional.Rule("fooRule", {
    metricName: "tfWAFRule",
    predicates: [{
        dataId: ipset.id,
        negated: false,
        type: "IPMatch",
    }],
});
const fooWebAcl = new aws.wafregional.WebAcl("fooWebAcl", {
    metricName: "foo",
    defaultAction: {
        type: "ALLOW",
    },
    rules: [{
        action: {
            type: "BLOCK",
        },
        priority: 1,
        ruleId: fooRule.id,
    }],
});
const exampleRestApi = new aws.apigateway.RestApi("exampleRestApi", {body: JSON.stringify({
    openapi: "3.0.1",
    info: {
        title: "example",
        version: "1.0",
    },
    paths: {
        "/path1": {
            get: {
                "x-amazon-apigateway-integration": {
                    httpMethod: "GET",
                    payloadFormatVersion: "1.0",
                    type: "HTTP_PROXY",
                    uri: "https://ip-ranges.amazonaws.com/ip-ranges.json",
                },
            },
        },
    },
})});
const exampleDeployment = new aws.apigateway.Deployment("exampleDeployment", {
    restApi: exampleRestApi.id,
    triggers: {
        redeployment: exampleRestApi.body.apply(body => JSON.stringify(body)).apply(toJSON => crypto.createHash('sha1').update(toJSON).digest('hex')),
    },
});
const exampleStage = new aws.apigateway.Stage("exampleStage", {
    deployment: exampleDeployment.id,
    restApi: exampleRestApi.id,
    stageName: "example",
});
const association = new aws.wafregional.WebAclAssociation("association", {
    resourceArn: exampleStage.arn,
    webAclId: fooWebAcl.id,
});
```

</details>

<details>

<summary>python</summary>

```python
import pulumi
import hashlib
import json
import pulumi_aws as aws

ipset = aws.wafregional.IpSet("ipset", ip_set_descriptors=[aws.wafregional.IpSetIpSetDescriptorArgs(
    type="IPV4",
    value="192.0.7.0/24",
)])
foo_rule = aws.wafregional.Rule("fooRule",
    metric_name="tfWAFRule",
    predicates=[aws.wafregional.RulePredicateArgs(
        data_id=ipset.id,
        negated=False,
        type="IPMatch",
    )])
foo_web_acl = aws.wafregional.WebAcl("fooWebAcl",
    metric_name="foo",
    default_action=aws.wafregional.WebAclDefaultActionArgs(
        type="ALLOW",
    ),
    rules=[aws.wafregional.WebAclRuleArgs(
        action=aws.wafregional.WebAclRuleActionArgs(
            type="BLOCK",
        ),
        priority=1,
        rule_id=foo_rule.id,
    )])
example_rest_api = aws.apigateway.RestApi("exampleRestApi", body=json.dumps({
    "openapi": "3.0.1",
    "info": {
        "title": "example",
        "version": "1.0",
    },
    "paths": {
        "/path1": {
            "get": {
                "x-amazon-apigateway-integration": {
                    "httpMethod": "GET",
                    "payloadFormatVersion": "1.0",
                    "type": "HTTP_PROXY",
                    "uri": "https://ip-ranges.amazonaws.com/ip-ranges.json",
                },
            },
        },
    },
}))
example_deployment = aws.apigateway.Deployment("exampleDeployment",
    rest_api=example_rest_api.id,
    triggers={
        "redeployment": example_rest_api.body.apply(lambda body: json.dumps(body)).apply(lambda to_json: hashlib.sha1(to_json.encode()).hexdigest()),
    })
example_stage = aws.apigateway.Stage("exampleStage",
    deployment=example_deployment.id,
    rest_api=example_rest_api.id,
    stage_name="example")
association = aws.wafregional.WebAclAssociation("association",
    resource_arn=example_stage.arn,
    web_acl_id=foo_web_acl.id)
```

</details>

<details>

<summary>csharp</summary>

```csharp
using System.Collections.Generic;
using System.Security.Cryptography;
using System.Text;
using System.Text.Json;
using Pulumi;
using Aws = Pulumi.Aws;

	private static string ComputeSHA1(string input) {
		return BitConverter.ToString(
			SHA1.Create().ComputeHash(Encoding.UTF8.GetBytes(input))
		).Replace("-","").ToLowerInvariant());
	}

return await Deployment.RunAsync(() => 
{
    var ipset = new Aws.WafRegional.IpSet("ipset", new()
    {
        IpSetDescriptors = new[]
        {
            new Aws.WafRegional.Inputs.IpSetIpSetDescriptorArgs
            {
                Type = "IPV4",
                Value = "192.0.7.0/24",
            },
        },
    });

    var fooRule = new Aws.WafRegional.Rule("fooRule", new()
    {
        MetricName = "tfWAFRule",
        Predicates = new[]
        {
            new Aws.WafRegional.Inputs.RulePredicateArgs
            {
                DataId = ipset.Id,
                Negated = false,
                Type = "IPMatch",
            },
        },
    });

    var fooWebAcl = new Aws.WafRegional.WebAcl("fooWebAcl", new()
    {
        MetricName = "foo",
        DefaultAction = new Aws.WafRegional.Inputs.WebAclDefaultActionArgs
        {
            Type = "ALLOW",
        },
        Rules = new[]
        {
            new Aws.WafRegional.Inputs.WebAclRuleArgs
            {
                Action = new Aws.WafRegional.Inputs.WebAclRuleActionArgs
                {
                    Type = "BLOCK",
                },
                Priority = 1,
                RuleId = fooRule.Id,
            },
        },
    });

    var exampleRestApi = new Aws.ApiGateway.RestApi("exampleRestApi", new()
    {
        Body = JsonSerializer.Serialize(new Dictionary<string, object?>
        {
            ["openapi"] = "3.0.1",
            ["info"] = new Dictionary<string, object?>
            {
                ["title"] = "example",
                ["version"] = "1.0",
            },
            ["paths"] = new Dictionary<string, object?>
            {
                ["/path1"] = new Dictionary<string, object?>
                {
                    ["get"] = new Dictionary<string, object?>
                    {
                        ["x-amazon-apigateway-integration"] = new Dictionary<string, object?>
                        {
                            ["httpMethod"] = "GET",
                            ["payloadFormatVersion"] = "1.0",
                            ["type"] = "HTTP_PROXY",
                            ["uri"] = "https://ip-ranges.amazonaws.com/ip-ranges.json",
                        },
                    },
                },
            },
        }),
    });

    var exampleDeployment = new Aws.ApiGateway.Deployment("exampleDeployment", new()
    {
        RestApi = exampleRestApi.Id,
        Triggers = 
        {
            { "redeployment", exampleRestApi.Body.Apply(body => JsonSerializer.Serialize(body)).Apply(toJSON => ComputeSHA1(toJSON)) },
        },
    });

    var exampleStage = new Aws.ApiGateway.Stage("exampleStage", new()
    {
        Deployment = exampleDeployment.Id,
        RestApi = exampleRestApi.Id,
        StageName = "example",
    });

    var association = new Aws.WafRegional.WebAclAssociation("association", new()
    {
        ResourceArn = exampleStage.Arn,
        WebAclId = fooWebAcl.Id,
    });

});
```

</details>

<details>

<summary>go</summary>

```go
package main

import (
	"crypto/sha1"
	"encoding/json"
	"fmt"

	"github.com/pulumi/pulumi-aws/sdk/v5/go/aws/apigateway"
	"github.com/pulumi/pulumi-aws/sdk/v5/go/aws/wafregional"
	"github.com/pulumi/pulumi/sdk/v3/go/pulumi"
)

func sha1Hash(input string) string {
	hash := sha1.Sum([]byte(input))
	return hex.EncodeToString(hash[:])
}

func main() {
	pulumi.Run(func(ctx *pulumi.Context) error {
		ipset, err := wafregional.NewIpSet(ctx, "ipset", &wafregional.IpSetArgs{
			IpSetDescriptors: wafregional.IpSetIpSetDescriptorArray{
				&wafregional.IpSetIpSetDescriptorArgs{
					Type:  pulumi.String("IPV4"),
					Value: pulumi.String("192.0.7.0/24"),
				},
			},
		})
		if err != nil {
			return err
		}
		fooRule, err := wafregional.NewRule(ctx, "fooRule", &wafregional.RuleArgs{
			MetricName: pulumi.String("tfWAFRule"),
			Predicates: wafregional.RulePredicateArray{
				&wafregional.RulePredicateArgs{
					DataId:  ipset.ID(),
					Negated: pulumi.Bool(false),
					Type:    pulumi.String("IPMatch"),
				},
			},
		})
		if err != nil {
			return err
		}
		fooWebAcl, err := wafregional.NewWebAcl(ctx, "fooWebAcl", &wafregional.WebAclArgs{
			MetricName: pulumi.String("foo"),
			DefaultAction: &wafregional.WebAclDefaultActionArgs{
				Type: pulumi.String("ALLOW"),
			},
			Rules: wafregional.WebAclRuleArray{
				&wafregional.WebAclRuleArgs{
					Action: &wafregional.WebAclRuleActionArgs{
						Type: pulumi.String("BLOCK"),
					},
					Priority: pulumi.Int(1),
					RuleId:   fooRule.ID(),
				},
			},
		})
		if err != nil {
			return err
		}
		tmpJSON0, err := json.Marshal(map[string]interface{}{
			"openapi": "3.0.1",
			"info": map[string]interface{}{
				"title":   "example",
				"version": "1.0",
			},
			"paths": map[string]interface{}{
				"/path1": map[string]interface{}{
					"get": map[string]interface{}{
						"x-amazon-apigateway-integration": map[string]interface{}{
							"httpMethod":           "GET",
							"payloadFormatVersion": "1.0",
							"type":                 "HTTP_PROXY",
							"uri":                  "https://ip-ranges.amazonaws.com/ip-ranges.json",
						},
					},
				},
			},
		})
		if err != nil {
			return err
		}
		json0 := string(tmpJSON0)
		exampleRestApi, err := apigateway.NewRestApi(ctx, "exampleRestApi", &apigateway.RestApiArgs{
			Body: pulumi.String(json0),
		})
		if err != nil {
			return err
		}
		exampleDeployment, err := apigateway.NewDeployment(ctx, "exampleDeployment", &apigateway.DeploymentArgs{
			RestApi: exampleRestApi.ID(),
			Triggers: pulumi.StringMap{
				"redeployment": exampleRestApi.Body.ApplyT(func(body string) (pulumi.String, error) {
					var _zero pulumi.String
					tmpJSON1, err := json.Marshal(body)
					if err != nil {
						return _zero, err
					}
					json1 := string(tmpJSON1)
					return json1, nil
				}).(pulumi.StringOutput).ApplyT(func(toJSON string) (pulumi.String, error) {
					return sha1Hash(toJSON), nil
				}).(pulumi.StringOutput),
			},
		})
		if err != nil {
			return err
		}
		exampleStage, err := apigateway.NewStage(ctx, "exampleStage", &apigateway.StageArgs{
			Deployment: exampleDeployment.ID(),
			RestApi:    exampleRestApi.ID(),
			StageName:  pulumi.String("example"),
		})
		if err != nil {
			return err
		}
		_, err = wafregional.NewWebAclAssociation(ctx, "association", &wafregional.WebAclAssociationArgs{
			ResourceArn: exampleStage.Arn,
			WebAclId:    fooWebAcl.ID(),
		})
		if err != nil {
			return err
		}
		return nil
	})
}
```

</details>

<details>

<summary>java</summary>

```java
package generated_program;

import com.pulumi.Context;
import com.pulumi.Pulumi;
import com.pulumi.core.Output;
import com.pulumi.aws.wafregional.IpSet;
import com.pulumi.aws.wafregional.IpSetArgs;
import com.pulumi.aws.wafregional.inputs.IpSetIpSetDescriptorArgs;
import com.pulumi.aws.wafregional.Rule;
import com.pulumi.aws.wafregional.RuleArgs;
import com.pulumi.aws.wafregional.inputs.RulePredicateArgs;
import com.pulumi.aws.wafregional.WebAcl;
import com.pulumi.aws.wafregional.WebAclArgs;
import com.pulumi.aws.wafregional.inputs.WebAclDefaultActionArgs;
import com.pulumi.aws.wafregional.inputs.WebAclRuleArgs;
import com.pulumi.aws.wafregional.inputs.WebAclRuleActionArgs;
import com.pulumi.aws.apigateway.RestApi;
import com.pulumi.aws.apigateway.RestApiArgs;
import com.pulumi.aws.apigateway.Deployment;
import com.pulumi.aws.apigateway.DeploymentArgs;
import com.pulumi.aws.apigateway.Stage;
import com.pulumi.aws.apigateway.StageArgs;
import com.pulumi.aws.wafregional.WebAclAssociation;
import com.pulumi.aws.wafregional.WebAclAssociationArgs;
import static com.pulumi.codegen.internal.Serialization.*;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;

public class App {
    public static void main(String[] args) {
        Pulumi.run(App::stack);
    }

    public static void stack(Context ctx) {
        var ipset = new IpSet("ipset", IpSetArgs.builder()        
            .ipSetDescriptors(IpSetIpSetDescriptorArgs.builder()
                .type("IPV4")
                .value("192.0.7.0/24")
                .build())
            .build());

        var fooRule = new Rule("fooRule", RuleArgs.builder()        
            .metricName("tfWAFRule")
            .predicates(RulePredicateArgs.builder()
                .dataId(ipset.id())
                .negated(false)
                .type("IPMatch")
                .build())
            .build());

        var fooWebAcl = new WebAcl("fooWebAcl", WebAclArgs.builder()        
            .metricName("foo")
            .defaultAction(WebAclDefaultActionArgs.builder()
                .type("ALLOW")
                .build())
            .rules(WebAclRuleArgs.builder()
                .action(WebAclRuleActionArgs.builder()
                    .type("BLOCK")
                    .build())
                .priority(1)
                .ruleId(fooRule.id())
                .build())
            .build());

        var exampleRestApi = new RestApi("exampleRestApi", RestApiArgs.builder()        
            .body(serializeJson(
                jsonObject(
                    jsonProperty("openapi", "3.0.1"),
                    jsonProperty("info", jsonObject(
                        jsonProperty("title", "example"),
                        jsonProperty("version", "1.0")
                    )),
                    jsonProperty("paths", jsonObject(
                        jsonProperty("/path1", jsonObject(
                            jsonProperty("get", jsonObject(
                                jsonProperty("x-amazon-apigateway-integration", jsonObject(
                                    jsonProperty("httpMethod", "GET"),
                                    jsonProperty("payloadFormatVersion", "1.0"),
                                    jsonProperty("type", "HTTP_PROXY"),
                                    jsonProperty("uri", "https://ip-ranges.amazonaws.com/ip-ranges.json")
                                ))
                            ))
                        ))
                    ))
                )))
            .build());

        var exampleDeployment = new Deployment("exampleDeployment", DeploymentArgs.builder()        
            .restApi(exampleRestApi.id())
            .triggers(Map.of("redeployment", exampleRestApi.body().applyValue(body -> serializeJson(
                body)).applyValue(toJSON -> computeSHA1(toJSON))))
            .build());

        var exampleStage = new Stage("exampleStage", StageArgs.builder()        
            .deployment(exampleDeployment.id())
            .restApi(exampleRestApi.id())
            .stageName("example")
            .build());

        var association = new WebAclAssociation("association", WebAclAssociationArgs.builder()        
            .resourceArn(exampleStage.arn())
            .webAclId(fooWebAcl.id())
            .build());

    }
}
```

</details>

## [*partial failure*] #/resources/aws:eks/fargateProfile:FargateProfile

### HCL

```terraform
resource "aws_eks_fargate_profile" "example" {
  cluster_name           = aws_eks_cluster.example.name
  fargate_profile_name   = "example"
  pod_execution_role_arn = aws_iam_role.example.arn
  subnet_ids             = aws_subnet.example[*].id

  selector {
    namespace = "example"
  }
}

```

### Failed Languages

#### go

```text
failed to convert HCL for #/resources/aws:eks/fargateProfile:FargateProfile to go: invalid Go source code:

package main

import (

"github.com/pulumi/pulumi/sdk/v3/go/pulumi"
"github.com/pulumi/pulumi-aws/sdk/v5/go/aws/eks"
)
func main() {
pulumi.Run(func(ctx *pulumi.Context) error {
_, err := eks.NewFargateProfile(ctx, "example", &eks.FargateProfileArgs{
ClusterName: pulumi.Any(aws_eks_cluster.Example.Name),
PodExecutionRoleArn: pulumi.Any(aws_iam_role.Example.Arn),
SubnetIds: %!v(PANIC=Format method: fatal: A failure has occurred: unlowered splat expression @ #-resources-aws:eks-fargateProfile:FargateProfile.tf.pp:3,27-51),
Selectors: eks.FargateProfileSelectorArray{
&eks.FargateProfileSelectorArgs{
Namespace: pulumi.String("example"),
},
},
})
if err != nil {
return err
}
return nil
})
}
: 13:12: expected operand, found '%' (and 7 more errors)
```

#### yaml

```text
.pp:3,27-51: Failed to generate YAML program: Splat; A 'Splat' expression is equivalent in expressive power to a 'for loop', and is not representable in YAML.
If the values of the function are known, you can manually unroll the loop, otherwise it is necessary to switch to a more expressive language.
```

### Successes

<details>

<summary>java</summary>

```java
package generated_program;

import com.pulumi.Context;
import com.pulumi.Pulumi;
import com.pulumi.core.Output;
import com.pulumi.aws.eks.FargateProfile;
import com.pulumi.aws.eks.FargateProfileArgs;
import com.pulumi.aws.eks.inputs.FargateProfileSelectorArgs;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;

public class App {
    public static void main(String[] args) {
        Pulumi.run(App::stack);
    }

    public static void stack(Context ctx) {
        var example = new FargateProfile("example", FargateProfileArgs.builder()        
            .clusterName(aws_eks_cluster.example().name())
            .podExecutionRoleArn(aws_iam_role.example().arn())
            .subnetIds(aws_subnet.example().stream().map(element -> element.id()).collect(toList()))
            .selectors(FargateProfileSelectorArgs.builder()
                .namespace("example")
                .build())
            .build());

    }
}
```

</details>

<details>

<summary>typescript</summary>

```typescript
import * as pulumi from "@pulumi/pulumi";
import * as aws from "@pulumi/aws";

const example = new aws.eks.FargateProfile("example", {
    clusterName: aws_eks_cluster.example.name,
    podExecutionRoleArn: aws_iam_role.example.arn,
    subnetIds: aws_subnet.example.map(__item => __item.id),
    selectors: [{
        namespace: "example",
    }],
});
```

</details>

<details>

<summary>python</summary>

```python
import pulumi
import pulumi_aws as aws

example = aws.eks.FargateProfile("example",
    cluster_name=aws_eks_cluster["example"]["name"],
    pod_execution_role_arn=aws_iam_role["example"]["arn"],
    subnet_ids=[__item["id"] for __item in aws_subnet["example"]],
    selectors=[aws.eks.FargateProfileSelectorArgs(
        namespace="example",
    )])
```

</details>

<details>

<summary>csharp</summary>

```csharp
using System.Collections.Generic;
using System.Linq;
using Pulumi;
using Aws = Pulumi.Aws;

return await Deployment.RunAsync(() => 
{
    var example = new Aws.Eks.FargateProfile("example", new()
    {
        ClusterName = aws_eks_cluster.Example.Name,
        PodExecutionRoleArn = aws_iam_role.Example.Arn,
        SubnetIds = aws_subnet.Example.Select(__item => __item.Id).ToList(),
        Selectors = new[]
        {
            new Aws.Eks.Inputs.FargateProfileSelectorArgs
            {
                Namespace = "example",
            },
        },
    });

});
```

</details>

## [*partial failure*] #/resources/aws:cloudfront/publicKey:PublicKey

### HCL

```terraform
resource "aws_cloudfront_public_key" "example" {
  comment     = "test public key"
  encoded_key = file("public_key.pem")
  name        = "test_key"
}

```

### Failed Languages

#### yaml

```text
.pp:2,16-42: Failed to generate YAML program: Unknown Function; YAML does not support Fn::readFile.
```

### Successes

<details>

<summary>python</summary>

```python
import pulumi
import pulumi_aws as aws

example = aws.cloudfront.PublicKey("example",
    comment="test public key",
    encoded_key=(lambda path: open(path).read())("public_key.pem"))
```

</details>

<details>

<summary>csharp</summary>

```csharp
using System.Collections.Generic;
using System.IO;
using Pulumi;
using Aws = Pulumi.Aws;

return await Deployment.RunAsync(() => 
{
    var example = new Aws.CloudFront.PublicKey("example", new()
    {
        Comment = "test public key",
        EncodedKey = File.ReadAllText("public_key.pem"),
    });

});
```

</details>

<details>

<summary>go</summary>

```go
package main

import (
	"io/ioutil"

	"github.com/pulumi/pulumi-aws/sdk/v5/go/aws/cloudfront"
	"github.com/pulumi/pulumi/sdk/v3/go/pulumi"
)

func readFileOrPanic(path string) pulumi.StringPtrInput {
	data, err := ioutil.ReadFile(path)
	if err != nil {
		panic(err.Error())
	}
	return pulumi.String(string(data))
}

func main() {
	pulumi.Run(func(ctx *pulumi.Context) error {
		_, err := cloudfront.NewPublicKey(ctx, "example", &cloudfront.PublicKeyArgs{
			Comment:    pulumi.String("test public key"),
			EncodedKey: readFileOrPanic("public_key.pem"),
		})
		if err != nil {
			return err
		}
		return nil
	})
}
```

</details>

<details>

<summary>java</summary>

```java
package generated_program;

import com.pulumi.Context;
import com.pulumi.Pulumi;
import com.pulumi.core.Output;
import com.pulumi.aws.cloudfront.PublicKey;
import com.pulumi.aws.cloudfront.PublicKeyArgs;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;

public class App {
    public static void main(String[] args) {
        Pulumi.run(App::stack);
    }

    public static void stack(Context ctx) {
        var example = new PublicKey("example", PublicKeyArgs.builder()        
            .comment("test public key")
            .encodedKey(Files.readString(Paths.get("public_key.pem")))
            .build());

    }
}
```

</details>

<details>

<summary>typescript</summary>

```typescript
import * as pulumi from "@pulumi/pulumi";
import * as aws from "@pulumi/aws";
import * as fs from "fs";

const example = new aws.cloudfront.PublicKey("example", {
    comment: "test public key",
    encodedKey: fs.readFileSync("public_key.pem"),
});
```

</details>

## [**complete failure**] Replica Tagging

### HCL

```terraform
provider "aws" {
  region = "us-west-2"
}

provider "awsalternate" {
  region = "us-east-1"
}

provider "awsthird" {
  region = "us-east-2"
}

data "aws_region" "current" {}

data "aws_region" "alternate" {
  provider = "awsalternate"
}

data "aws_region" "third" {
  provider = "awsthird"
}

resource "aws_dynamodb_table" "example" {
  billing_mode     = "PAY_PER_REQUEST"
  hash_key         = "TestTableHashKey"
  name             = "example-13281"
  stream_enabled   = true
  stream_view_type = "NEW_AND_OLD_IMAGES"

  attribute {
    name = "TestTableHashKey"
    type = "S"
  }

  replica {
    region_name = data.aws_region.alternate.name
  }

  replica {
    region_name    = data.aws_region.third.name
    propagate_tags = true
  }

  tags = {
    Architect = "Eleanor"
    Zone      = "SW"
  }
}

resource "aws_dynamodb_tag" "example" {
  resource_arn = replace(aws_dynamodb_table.example.arn, data.aws_region.current.name, data.aws_region.alternate.name)
  key          = "Architect"
  value        = "Gigi"
}

```

### Failed Languages

#### typescript

```text
:50,18-25: unknown function 'replace'; , and 4 other diagnostic(s)
```

#### python

```text
:50,18-25: unknown function 'replace'; , and 4 other diagnostic(s)
```

#### csharp

```text
:50,18-25: unknown function 'replace'; , and 4 other diagnostic(s)
```

#### go

```text
:50,18-25: unknown function 'replace'; , and 4 other diagnostic(s)
```

#### yaml

```text
:50,18-25: unknown function 'replace'; , and 4 other diagnostic(s)
```

#### java

```text
:50,18-25: unknown function 'replace'; , and 4 other diagnostic(s)
```

## [*partial failure*] Basic Usage

### HCL

```terraform
resource "aws_opensearch_domain" "example" {
  domain_name    = "example"
  engine_version = "OpenSearch_1.1"

  cluster_config {
    instance_type = "r4.large.search"
  }

  snapshot_options {
    automated_snapshot_start_hour = 23
  }

  tags = {
    Domain = "TestDomain"
  }
}

resource "aws_opensearch_domain_saml_options" "example" {
  domain_name = aws_opensearch_domain.example.domain_name
  saml_options {
    enabled = true
    idp {
      entity_id        = "https://example.com"
      metadata_content = file("./saml-metadata.xml")
    }
  }
}

```

### Failed Languages

#### yaml

```text
.pp:18,25-56: Failed to generate YAML program: Unknown Function; YAML does not support Fn::readFile.
```

### Successes

<details>

<summary>java</summary>

```java
package generated_program;

import com.pulumi.Context;
import com.pulumi.Pulumi;
import com.pulumi.core.Output;
import com.pulumi.aws.opensearch.Domain;
import com.pulumi.aws.opensearch.DomainArgs;
import com.pulumi.aws.opensearch.inputs.DomainClusterConfigArgs;
import com.pulumi.aws.opensearch.inputs.DomainSnapshotOptionsArgs;
import com.pulumi.aws.opensearch.DomainSamlOptions;
import com.pulumi.aws.opensearch.DomainSamlOptionsArgs;
import com.pulumi.aws.opensearch.inputs.DomainSamlOptionsSamlOptionsArgs;
import com.pulumi.aws.opensearch.inputs.DomainSamlOptionsSamlOptionsIdpArgs;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;

public class App {
    public static void main(String[] args) {
        Pulumi.run(App::stack);
    }

    public static void stack(Context ctx) {
        var exampleDomain = new Domain("exampleDomain", DomainArgs.builder()        
            .engineVersion("OpenSearch_1.1")
            .clusterConfig(DomainClusterConfigArgs.builder()
                .instanceType("r4.large.search")
                .build())
            .snapshotOptions(DomainSnapshotOptionsArgs.builder()
                .automatedSnapshotStartHour(23)
                .build())
            .tags(Map.of("Domain", "TestDomain"))
            .build());

        var exampleDomainSamlOptions = new DomainSamlOptions("exampleDomainSamlOptions", DomainSamlOptionsArgs.builder()        
            .domainName(exampleDomain.domainName())
            .samlOptions(DomainSamlOptionsSamlOptionsArgs.builder()
                .enabled(true)
                .idp(DomainSamlOptionsSamlOptionsIdpArgs.builder()
                    .entityId("https://example.com")
                    .metadataContent(Files.readString(Paths.get("./saml-metadata.xml")))
                    .build())
                .build())
            .build());

    }
}
```

</details>

<details>

<summary>typescript</summary>

```typescript
import * as pulumi from "@pulumi/pulumi";
import * as aws from "@pulumi/aws";
import * as fs from "fs";

const exampleDomain = new aws.opensearch.Domain("exampleDomain", {
    engineVersion: "OpenSearch_1.1",
    clusterConfig: {
        instanceType: "r4.large.search",
    },
    snapshotOptions: {
        automatedSnapshotStartHour: 23,
    },
    tags: {
        Domain: "TestDomain",
    },
});
const exampleDomainSamlOptions = new aws.opensearch.DomainSamlOptions("exampleDomainSamlOptions", {
    domainName: exampleDomain.domainName,
    samlOptions: {
        enabled: true,
        idp: {
            entityId: "https://example.com",
            metadataContent: fs.readFileSync("./saml-metadata.xml"),
        },
    },
});
```

</details>

<details>

<summary>python</summary>

```python
import pulumi
import pulumi_aws as aws

example_domain = aws.opensearch.Domain("exampleDomain",
    engine_version="OpenSearch_1.1",
    cluster_config=aws.opensearch.DomainClusterConfigArgs(
        instance_type="r4.large.search",
    ),
    snapshot_options=aws.opensearch.DomainSnapshotOptionsArgs(
        automated_snapshot_start_hour=23,
    ),
    tags={
        "Domain": "TestDomain",
    })
example_domain_saml_options = aws.opensearch.DomainSamlOptions("exampleDomainSamlOptions",
    domain_name=example_domain.domain_name,
    saml_options=aws.opensearch.DomainSamlOptionsSamlOptionsArgs(
        enabled=True,
        idp=aws.opensearch.DomainSamlOptionsSamlOptionsIdpArgs(
            entity_id="https://example.com",
            metadata_content=(lambda path: open(path).read())("./saml-metadata.xml"),
        ),
    ))
```

</details>

<details>

<summary>csharp</summary>

```csharp
using System.Collections.Generic;
using System.IO;
using Pulumi;
using Aws = Pulumi.Aws;

return await Deployment.RunAsync(() => 
{
    var exampleDomain = new Aws.OpenSearch.Domain("exampleDomain", new()
    {
        EngineVersion = "OpenSearch_1.1",
        ClusterConfig = new Aws.OpenSearch.Inputs.DomainClusterConfigArgs
        {
            InstanceType = "r4.large.search",
        },
        SnapshotOptions = new Aws.OpenSearch.Inputs.DomainSnapshotOptionsArgs
        {
            AutomatedSnapshotStartHour = 23,
        },
        Tags = 
        {
            { "Domain", "TestDomain" },
        },
    });

    var exampleDomainSamlOptions = new Aws.OpenSearch.DomainSamlOptions("exampleDomainSamlOptions", new()
    {
        DomainName = exampleDomain.DomainName,
        SamlOptions = new Aws.OpenSearch.Inputs.DomainSamlOptionsSamlOptionsArgs
        {
            Enabled = true,
            Idp = new Aws.OpenSearch.Inputs.DomainSamlOptionsSamlOptionsIdpArgs
            {
                EntityId = "https://example.com",
                MetadataContent = File.ReadAllText("./saml-metadata.xml"),
            },
        },
    });

});
```

</details>

<details>

<summary>go</summary>

```go
package main

import (
	"io/ioutil"

	"github.com/pulumi/pulumi-aws/sdk/v5/go/aws/opensearch"
	"github.com/pulumi/pulumi/sdk/v3/go/pulumi"
)

func readFileOrPanic(path string) pulumi.StringPtrInput {
	data, err := ioutil.ReadFile(path)
	if err != nil {
		panic(err.Error())
	}
	return pulumi.String(string(data))
}

func main() {
	pulumi.Run(func(ctx *pulumi.Context) error {
		exampleDomain, err := opensearch.NewDomain(ctx, "exampleDomain", &opensearch.DomainArgs{
			EngineVersion: pulumi.String("OpenSearch_1.1"),
			ClusterConfig: &opensearch.DomainClusterConfigArgs{
				InstanceType: pulumi.String("r4.large.search"),
			},
			SnapshotOptions: &opensearch.DomainSnapshotOptionsArgs{
				AutomatedSnapshotStartHour: pulumi.Int(23),
			},
			Tags: pulumi.StringMap{
				"Domain": pulumi.String("TestDomain"),
			},
		})
		if err != nil {
			return err
		}
		_, err = opensearch.NewDomainSamlOptions(ctx, "exampleDomainSamlOptions", &opensearch.DomainSamlOptionsArgs{
			DomainName: exampleDomain.DomainName,
			SamlOptions: &opensearch.DomainSamlOptionsSamlOptionsArgs{
				Enabled: pulumi.Bool(true),
				Idp: &opensearch.DomainSamlOptionsSamlOptionsIdpArgs{
					EntityId:        pulumi.String("https://example.com"),
					MetadataContent: readFileOrPanic("./saml-metadata.xml"),
				},
			},
		})
		if err != nil {
			return err
		}
		return nil
	})
}
```

</details>

## [**complete failure**] #/resources/aws:cognito/identityPoolProviderPrincipalTag:IdentityPoolProviderPrincipalTag

### HCL

```terraform
resource "aws_cognito_user_pool" "example" {
  name                     = "user pool"
  auto_verified_attributes = ["email"]
}

resource "aws_cognito_user_pool_client" "example" {
  name         = "client"
  user_pool_id = aws_cognito_user_pool.example.id
  supported_identity_providers = compact([
    "COGNITO",
  ])
}

resource "aws_cognito_identity_pool" "example" {
  identity_pool_name               = "identity pool"
  allow_unauthenticated_identities = false
  cognito_identity_providers {
    client_id               = aws_cognito_user_pool_client.example.id
    provider_name           = aws_cognito_user_pool.example.endpoint
    server_side_token_check = false
  }
}

resource "aws_cognito_identity_pool_provider_principal_tag" "example" {
  identity_pool_id       = aws_cognito_identity_pool.example.id
  identity_provider_name = aws_cognito_user_pool.example.endpoint
  use_defaults           = false
  principal_tags = {
    test = "value"
  }
}

```

### Failed Languages

#### python

```text
:8,34-41: unknown function 'compact'; , and 1 other diagnostic(s)
```

#### csharp

```text
:8,34-41: unknown function 'compact'; , and 1 other diagnostic(s)
```

#### go

```text
:8,34-41: unknown function 'compact'; , and 1 other diagnostic(s)
```

#### yaml

```text
:8,34-41: unknown function 'compact'; , and 1 other diagnostic(s)
```

#### java

```text
:8,34-41: unknown function 'compact'; , and 1 other diagnostic(s)
```

#### typescript

```text
:8,34-41: unknown function 'compact'; , and 1 other diagnostic(s)
```

## [*partial failure*] #/resources/aws:rds/proxyEndpoint:ProxyEndpoint

### HCL

```terraform
resource "aws_db_proxy_endpoint" "example" {
  db_proxy_name          = aws_db_proxy.test.name
  db_proxy_endpoint_name = "example"
  vpc_subnet_ids         = aws_subnet.test.*.id
  target_role            = "READ_ONLY"
}

```

### Failed Languages

#### go

```text
failed to convert HCL for #/resources/aws:rds/proxyEndpoint:ProxyEndpoint to go: invalid Go source code:

package main

import (

"github.com/pulumi/pulumi/sdk/v3/go/pulumi"
"github.com/pulumi/pulumi-aws/sdk/v5/go/aws/rds"
)
func main() {
pulumi.Run(func(ctx *pulumi.Context) error {
_, err := rds.NewProxyEndpoint(ctx, "example", &rds.ProxyEndpointArgs{
DbProxyName: pulumi.Any(aws_db_proxy.Test.Name),
DbProxyEndpointName: pulumi.String("example"),
VpcSubnetIds: %!v(PANIC=Format method: fatal: A failure has occurred: unlowered splat expression @ #-resources-aws:rds-proxyEndpoint:ProxyEndpoint.tf.pp:3,26-46),
TargetRole: pulumi.String("READ_ONLY"),
})
if err != nil {
return err
}
return nil
})
}
: 13:15: expected operand, found '%' (and 7 more errors)
```

#### yaml

```text
.pp:3,26-46: Failed to generate YAML program: Splat; A 'Splat' expression is equivalent in expressive power to a 'for loop', and is not representable in YAML.
If the values of the function are known, you can manually unroll the loop, otherwise it is necessary to switch to a more expressive language.
```

### Successes

<details>

<summary>python</summary>

```python
import pulumi
import pulumi_aws as aws

example = aws.rds.ProxyEndpoint("example",
    db_proxy_name=aws_db_proxy["test"]["name"],
    db_proxy_endpoint_name="example",
    vpc_subnet_ids=[__item["id"] for __item in aws_subnet["test"]],
    target_role="READ_ONLY")
```

</details>

<details>

<summary>csharp</summary>

```csharp
using System.Collections.Generic;
using System.Linq;
using Pulumi;
using Aws = Pulumi.Aws;

return await Deployment.RunAsync(() => 
{
    var example = new Aws.Rds.ProxyEndpoint("example", new()
    {
        DbProxyName = aws_db_proxy.Test.Name,
        DbProxyEndpointName = "example",
        VpcSubnetIds = aws_subnet.Test.Select(__item => __item.Id).ToList(),
        TargetRole = "READ_ONLY",
    });

});
```

</details>

<details>

<summary>java</summary>

```java
package generated_program;

import com.pulumi.Context;
import com.pulumi.Pulumi;
import com.pulumi.core.Output;
import com.pulumi.aws.rds.ProxyEndpoint;
import com.pulumi.aws.rds.ProxyEndpointArgs;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;

public class App {
    public static void main(String[] args) {
        Pulumi.run(App::stack);
    }

    public static void stack(Context ctx) {
        var example = new ProxyEndpoint("example", ProxyEndpointArgs.builder()        
            .dbProxyName(aws_db_proxy.test().name())
            .dbProxyEndpointName("example")
            .vpcSubnetIds(aws_subnet.test().stream().map(element -> element.id()).collect(toList()))
            .targetRole("READ_ONLY")
            .build());

    }
}
```

</details>

<details>

<summary>typescript</summary>

```typescript
import * as pulumi from "@pulumi/pulumi";
import * as aws from "@pulumi/aws";

const example = new aws.rds.ProxyEndpoint("example", {
    dbProxyName: aws_db_proxy.test.name,
    dbProxyEndpointName: "example",
    vpcSubnetIds: aws_subnet.test.map(__item => __item.id),
    targetRole: "READ_ONLY",
});
```

</details>

## [**complete failure**] With External Content

### HCL

```terraform
$ aws connect describe-contact-flow-module --instance-id 1b3c5d8-1b3c-1b3c-1b3c-1b3c5d81b3c5 --contact-flow-module-id c1d4e5f6-1b3c-1b3c-1b3c-c1d4e5f6c1d4e5 --region us-west-2 | jq '.ContactFlowModule.Content | fromjson' > contact_flow_module.json

```

### Failed Languages

#### typescript

```text
:0,0-1: Invalid character; This character is not used within the language., and 4 other diagnostic(s)
```

#### python

```text
:0,0-1: Invalid character; This character is not used within the language., and 4 other diagnostic(s)
```

#### csharp

```text
:0,0-1: Invalid character; This character is not used within the language., and 4 other diagnostic(s)
```

#### go

```text
:0,0-1: Invalid character; This character is not used within the language., and 4 other diagnostic(s)
```

#### yaml

```text
:0,0-1: Invalid character; This character is not used within the language., and 4 other diagnostic(s)
```

#### java

```text
:0,0-1: Invalid character; This character is not used within the language., and 4 other diagnostic(s)
```

## [*partial failure*] With External Content

### HCL

```terraform
resource "aws_connect_contact_flow_module" "example" {
  instance_id  = "aaaaaaaa-bbbb-cccc-dddd-111111111111"
  name         = "Example"
  description  = "Example Contact Flow Module Description"
  filename     = "contact_flow_module.json"
  content_hash = filebase64sha256("contact_flow_module.json")

  tags = {
    "Name"        = "Example Contact Flow Module",
    "Application" = "Terraform",
    "Method"      = "Create"
  }
}

```

### Failed Languages

#### yaml

```text
.pp:4,17-61: Failed to generate YAML program: Unknown Function; YAML does not support Fn::filebase64sha256.
```

### Successes

<details>

<summary>csharp</summary>

```csharp
using System;
using System.Collections.Generic;
using System.IO;
using System.Security.Cryptography;
using System.Text;
using Pulumi;
using Aws = Pulumi.Aws;

	private static string ComputeFileBase64Sha256(string path) {
		var fileData = Encoding.UTF8.GetBytes(File.ReadAllText(path));
		var hashData = SHA256.Create().ComputeHash(fileData);
		return Convert.ToBase64String(hashData);
	}

return await Deployment.RunAsync(() => 
{
    var example = new Aws.Connect.ContactFlowModule("example", new()
    {
        InstanceId = "aaaaaaaa-bbbb-cccc-dddd-111111111111",
        Description = "Example Contact Flow Module Description",
        Filename = "contact_flow_module.json",
        ContentHash = ComputeFileBase64Sha256("contact_flow_module.json"),
        Tags = 
        {
            { "Name", "Example Contact Flow Module" },
            { "Application", "Terraform" },
            { "Method", "Create" },
        },
    });

});
```

</details>

<details>

<summary>go</summary>

```go
package main

import (
	"crypto/sha256"
	"fmt"
	"io/ioutil"

	"github.com/pulumi/pulumi-aws/sdk/v5/go/aws/connect"
	"github.com/pulumi/pulumi/sdk/v3/go/pulumi"
)

func filebase64sha256OrPanic(path string) pulumi.StringPtrInput {
	if fileData, err := ioutil.ReadFile(path); err == nil {
		hashedData := sha256.Sum256([]byte(fileData))
		return pulumi.String(base64.StdEncoding.EncodeToString(hashedData[:]))
	} else {
		panic(err.Error())
	}
}

func main() {
	pulumi.Run(func(ctx *pulumi.Context) error {
		_, err := connect.NewContactFlowModule(ctx, "example", &connect.ContactFlowModuleArgs{
			InstanceId:  pulumi.String("aaaaaaaa-bbbb-cccc-dddd-111111111111"),
			Description: pulumi.String("Example Contact Flow Module Description"),
			Filename:    pulumi.String("contact_flow_module.json"),
			ContentHash: filebase64sha256OrPanic("contact_flow_module.json"),
			Tags: pulumi.StringMap{
				"Name":        pulumi.String("Example Contact Flow Module"),
				"Application": pulumi.String("Terraform"),
				"Method":      pulumi.String("Create"),
			},
		})
		if err != nil {
			return err
		}
		return nil
	})
}
```

</details>

<details>

<summary>java</summary>

```java
package generated_program;

import com.pulumi.Context;
import com.pulumi.Pulumi;
import com.pulumi.core.Output;
import com.pulumi.aws.connect.ContactFlowModule;
import com.pulumi.aws.connect.ContactFlowModuleArgs;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;

public class App {
    public static void main(String[] args) {
        Pulumi.run(App::stack);
    }

    public static void stack(Context ctx) {
        var example = new ContactFlowModule("example", ContactFlowModuleArgs.builder()        
            .instanceId("aaaaaaaa-bbbb-cccc-dddd-111111111111")
            .description("Example Contact Flow Module Description")
            .filename("contact_flow_module.json")
            .contentHash(computeFileBase64Sha256("contact_flow_module.json"))
            .tags(Map.ofEntries(
                Map.entry("Name", "Example Contact Flow Module"),
                Map.entry("Application", "Terraform"),
                Map.entry("Method", "Create")
            ))
            .build());

    }
}
```

</details>

<details>

<summary>typescript</summary>

```typescript
import * as pulumi from "@pulumi/pulumi";
import * as aws from "@pulumi/aws";
import * as crypto from "crypto";
import * as fs from "fs";

func computeFilebase64sha256(path string) string {
	const fileData = Buffer.from(fs.readFileSync(path), 'binary')
	return crypto.createHash('sha256').update(fileData).digest('hex')
}

const example = new aws.connect.ContactFlowModule("example", {
    instanceId: "aaaaaaaa-bbbb-cccc-dddd-111111111111",
    description: "Example Contact Flow Module Description",
    filename: "contact_flow_module.json",
    contentHash: computeFilebase64sha256("contact_flow_module.json"),
    tags: {
        Name: "Example Contact Flow Module",
        Application: "Terraform",
        Method: "Create",
    },
});
```

</details>

<details>

<summary>python</summary>

```python
import pulumi
import base64
import hashlib
import pulumi_aws as aws

def computeFilebase64sha256(path):
	fileData = open(path).read().encode()
	hashedData = hashlib.sha256(fileData.encode()).digest()
	return base64.b64encode(hashedData).decode()

example = aws.connect.ContactFlowModule("example",
    instance_id="aaaaaaaa-bbbb-cccc-dddd-111111111111",
    description="Example Contact Flow Module Description",
    filename="contact_flow_module.json",
    content_hash=computeFilebase64sha256("contact_flow_module.json"),
    tags={
        "Name": "Example Contact Flow Module",
        "Application": "Terraform",
        "Method": "Create",
    })
```

</details>

## [*partial failure*] VPC based OpenSearch

### HCL

```terraform
variable "vpc" {}

variable "domain" {
  default = "tf-test"
}

data "aws_vpc" "example" {
  tags = {
    Name = var.vpc
  }
}

data "aws_subnet_ids" "example" {
  vpc_id = data.aws_vpc.example.id

  tags = {
    Tier = "private"
  }
}

data "aws_region" "current" {}

data "aws_caller_identity" "current" {}

resource "aws_security_group" "example" {
  name        = "${var.vpc}-opensearch-${var.domain}"
  description = "Managed by Terraform"
  vpc_id      = data.aws_vpc.example.id

  ingress {
    from_port = 443
    to_port   = 443
    protocol  = "tcp"

    cidr_blocks = [
      data.aws_vpc.example.cidr_block,
    ]
  }
}

resource "aws_iam_service_linked_role" "example" {
  aws_service_name = "opensearchservice.amazonaws.com"
}

resource "aws_opensearch_domain" "example" {
  domain_name    = var.domain
  engine_version = "OpenSearch_1.0"

  cluster_config {
    instance_type          = "m4.large.search"
    zone_awareness_enabled = true
  }

  vpc_options {
    subnet_ids = [
      data.aws_subnet_ids.example.ids[0],
      data.aws_subnet_ids.example.ids[1],
    ]

    security_group_ids = [aws_security_group.example.id]
  }

  advanced_options = {
    "rest.action.multi.allow_explicit_index" = "true"
  }

  access_policies = <<CONFIG
{
	"Version": "2012-10-17",
	"Statement": [
		{
			"Action": "es:*",
			"Principal": "*",
			"Effect": "Allow",
			"Resource": "arn:aws:es:${data.aws_region.current.name}:${data.aws_caller_identity.current.account_id}:domain/${var.domain}/*"
		}
	]
}
CONFIG

  tags = {
    Domain = "TestDomain"
  }

  depends_on = [aws_iam_service_linked_role.example]
}

```

### Failed Languages

#### go

```text
failed to convert HCL for #/resources/aws:opensearch/domain:Domain to go: invalid Go source code:

package main

import (
"fmt"

"github.com/pulumi/pulumi/sdk/v3/go/pulumi"
"github.com/pulumi/pulumi-aws/sdk/v5/go/aws"
"github.com/pulumi/pulumi-aws/sdk/v5/go/aws/ec2"
"github.com/pulumi/pulumi-aws/sdk/v5/go/aws/iam"
"github.com/pulumi/pulumi-aws/sdk/v5/go/aws/opensearch"
"github.com/pulumi/pulumi/sdk/v3/go/pulumi/config"
)
func main() {
pulumi.Run(func(ctx *pulumi.Context) error {
cfg := config.New(ctx, "")
vpc := cfg.RequireObject("vpc")
domain := "tf-test";
if param := cfg.Get("domain"); param != ""{
domain = param
}
exampleVpc, err := ec2.LookupVpc(ctx, &ec2.LookupVpcArgs{
Tags: interface{}{
Name: vpc,
},
}, nil);
if err != nil {
return err
}
exampleSubnetIds, err := ec2.GetSubnetIds(ctx, &ec2.GetSubnetIdsArgs{
VpcId: exampleVpc.Id,
Tags: map[string]interface{}{
"Tier": "private",
},
}, nil);
if err != nil {
return err
}
currentRegion, err := aws.GetRegion(ctx, nil, nil);
if err != nil {
return err
}
currentCallerIdentity, err := aws.GetCallerIdentity(ctx, nil, nil);
if err != nil {
return err
}
exampleSecurityGroup, err := ec2.NewSecurityGroup(ctx, "exampleSecurityGroup", &ec2.SecurityGroupArgs{
Description: pulumi.String("Managed by Terraform"),
VpcId: pulumi.String(exampleVpc.Id),
Ingress: ec2.SecurityGroupIngressArray{
&ec2.SecurityGroupIngressArgs{
FromPort: pulumi.Int(443),
ToPort: pulumi.Int(443),
Protocol: pulumi.String("tcp"),
CidrBlocks: pulumi.StringArray{
pulumi.String(exampleVpc.CidrBlock),
},
},
},
})
if err != nil {
return err
}
exampleServiceLinkedRole, err := iam.NewServiceLinkedRole(ctx, "exampleServiceLinkedRole", &iam.ServiceLinkedRoleArgs{
AwsServiceName: pulumi.String("opensearchservice.amazonaws.com"),
})
if err != nil {
return err
}
_, err = opensearch.NewDomain(ctx, "exampleDomain", &opensearch.DomainArgs{
EngineVersion: pulumi.String("OpenSearch_1.0"),
ClusterConfig: &opensearch.DomainClusterConfigArgs{
InstanceType: pulumi.String("m4.large.search"),
ZoneAwarenessEnabled: pulumi.Bool(true),
},
VpcOptions: &opensearch.DomainVpcOptionsArgs{
SubnetIds: pulumi.StringArray{
pulumi.String(exampleSubnetIds.Ids[0]),
pulumi.String(exampleSubnetIds.Ids[1]),
},
SecurityGroupIds: pulumi.StringArray{
exampleSecurityGroup.ID(),
},
},
AdvancedOptions: pulumi.StringMap{
"rest.action.multi.allow_explicit_index": pulumi.String("true"),
},
AccessPolicies: pulumi.String(fmt.Sprintf(`{
	"Version": "2012-10-17",
	"Statement": [
		{
			"Action": "es:*",
			"Principal": "*",
			"Effect": "Allow",
			"Resource": "arn:aws:es:%v:%v:domain/%v/*"
		}
	]
}
`, currentRegion.Name, currentCallerIdentity.AccountId, domain)),
Tags: pulumi.StringMap{
"Domain": pulumi.String("TestDomain"),
},
}, pulumi.DependsOn([]pulumi.Resource{
exampleServiceLinkedRole,
}))
if err != nil {
return err
}
return nil
})
}
: 22:7: expected expression (and 10 more errors)
```

### Successes

<details>

<summary>csharp</summary>

```csharp
using System.Collections.Generic;
using Pulumi;
using Aws = Pulumi.Aws;

return await Deployment.RunAsync(() => 
{
    var config = new Config();
    var vpc = config.RequireObject<dynamic>("vpc");
    var domain = config.Get("domain") ?? "tf-test";
    var exampleVpc = Aws.Ec2.GetVpc.Invoke(new()
    {
        Tags = 
        {
            { "Name", vpc },
        },
    });

    var exampleSubnetIds = Aws.Ec2.GetSubnetIds.Invoke(new()
    {
        VpcId = exampleVpc.Apply(getVpcResult => getVpcResult.Id),
        Tags = 
        {
            { "Tier", "private" },
        },
    });

    var currentRegion = Aws.GetRegion.Invoke();

    var currentCallerIdentity = Aws.GetCallerIdentity.Invoke();

    var exampleSecurityGroup = new Aws.Ec2.SecurityGroup("exampleSecurityGroup", new()
    {
        Description = "Managed by Terraform",
        VpcId = exampleVpc.Apply(getVpcResult => getVpcResult.Id),
        Ingress = new[]
        {
            new Aws.Ec2.Inputs.SecurityGroupIngressArgs
            {
                FromPort = 443,
                ToPort = 443,
                Protocol = "tcp",
                CidrBlocks = new[]
                {
                    exampleVpc.Apply(getVpcResult => getVpcResult.CidrBlock),
                },
            },
        },
    });

    var exampleServiceLinkedRole = new Aws.Iam.ServiceLinkedRole("exampleServiceLinkedRole", new()
    {
        AwsServiceName = "opensearchservice.amazonaws.com",
    });

    var exampleDomain = new Aws.OpenSearch.Domain("exampleDomain", new()
    {
        EngineVersion = "OpenSearch_1.0",
        ClusterConfig = new Aws.OpenSearch.Inputs.DomainClusterConfigArgs
        {
            InstanceType = "m4.large.search",
            ZoneAwarenessEnabled = true,
        },
        VpcOptions = new Aws.OpenSearch.Inputs.DomainVpcOptionsArgs
        {
            SubnetIds = new[]
            {
                exampleSubnetIds.Apply(getSubnetIdsResult => getSubnetIdsResult.Ids[0]),
                exampleSubnetIds.Apply(getSubnetIdsResult => getSubnetIdsResult.Ids[1]),
            },
            SecurityGroupIds = new[]
            {
                exampleSecurityGroup.Id,
            },
        },
        AdvancedOptions = 
        {
            { "rest.action.multi.allow_explicit_index", "true" },
        },
        AccessPolicies = Output.Tuple(currentRegion.Apply(getRegionResult => getRegionResult), currentCallerIdentity.Apply(getCallerIdentityResult => getCallerIdentityResult)).Apply(values =>
        {
            var currentRegion = values.Item1;
            var currentCallerIdentity = values.Item2;
            return @$"{{
	""Version"": ""2012-10-17"",
	""Statement"": [
		{{
			""Action"": ""es:*"",
			""Principal"": ""*"",
			""Effect"": ""Allow"",
			""Resource"": ""arn:aws:es:{currentRegion.Apply(getRegionResult => getRegionResult.Name)}:{currentCallerIdentity.Apply(getCallerIdentityResult => getCallerIdentityResult.AccountId)}:domain/{domain}/*""
		}}
	]
}}
";
        }),
        Tags = 
        {
            { "Domain", "TestDomain" },
        },
    }, new CustomResourceOptions
    {
        DependsOn = new[]
        {
            exampleServiceLinkedRole,
        },
    });

});
```

</details>

<details>

<summary>yaml</summary>

```yaml
configuration:
  vpc:
    type: dynamic
  domain:
    type: string
    default: tf-test
resources:
  exampleSecurityGroup:
    type: aws:ec2:SecurityGroup
    properties:
      description: Managed by Terraform
      vpcId: ${exampleVpc.id}
      ingress:
        - fromPort: 443
          toPort: 443
          protocol: tcp
          cidrBlocks:
            - ${exampleVpc.cidrBlock}
  exampleServiceLinkedRole:
    type: aws:iam:ServiceLinkedRole
    properties:
      awsServiceName: opensearchservice.amazonaws.com
  exampleDomain:
    type: aws:opensearch:Domain
    properties:
      engineVersion: OpenSearch_1.0
      clusterConfig:
        instanceType: m4.large.search
        zoneAwarenessEnabled: true
      vpcOptions:
        subnetIds:
          - ${exampleSubnetIds.ids[0]}
          - ${exampleSubnetIds.ids[1]}
        securityGroupIds:
          - ${exampleSecurityGroup.id}
      advancedOptions:
        rest.action.multi.allow_explicit_index: true
      accessPolicies: |
        {
        	"Version": "2012-10-17",
        	"Statement": [
        		{
        			"Action": "es:*",
        			"Principal": "*",
        			"Effect": "Allow",
        			"Resource": "arn:aws:es:${currentRegion.name}:${currentCallerIdentity.accountId}:domain/${domain}/*"
        		}
        	]
        }
      tags:
        Domain: TestDomain
    options:
      dependson:
        - ${exampleServiceLinkedRole}
variables:
  exampleVpc:
    Fn::Invoke:
      Function: aws:ec2:getVpc
      Arguments:
        tags:
          Name: ${vpc}
  exampleSubnetIds:
    Fn::Invoke:
      Function: aws:ec2:getSubnetIds
      Arguments:
        vpcId: ${exampleVpc.id}
        tags:
          Tier: private
  currentRegion:
    Fn::Invoke:
      Function: aws:getRegion
      Arguments: {}
  currentCallerIdentity:
    Fn::Invoke:
      Function: aws:getCallerIdentity
      Arguments: {}
```

</details>

<details>

<summary>java</summary>

```java
package generated_program;

import com.pulumi.Context;
import com.pulumi.Pulumi;
import com.pulumi.core.Output;
import com.pulumi.aws.ec2.Ec2Functions;
import com.pulumi.aws.ec2.inputs.GetVpcArgs;
import com.pulumi.aws.ec2.inputs.GetSubnetIdsArgs;
import com.pulumi.aws.AwsFunctions;
import com.pulumi.aws.inputs.GetRegionArgs;
import com.pulumi.aws.ec2.SecurityGroup;
import com.pulumi.aws.ec2.SecurityGroupArgs;
import com.pulumi.aws.ec2.inputs.SecurityGroupIngressArgs;
import com.pulumi.aws.iam.ServiceLinkedRole;
import com.pulumi.aws.iam.ServiceLinkedRoleArgs;
import com.pulumi.aws.opensearch.Domain;
import com.pulumi.aws.opensearch.DomainArgs;
import com.pulumi.aws.opensearch.inputs.DomainClusterConfigArgs;
import com.pulumi.aws.opensearch.inputs.DomainVpcOptionsArgs;
import com.pulumi.resources.CustomResourceOptions;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;

public class App {
    public static void main(String[] args) {
        Pulumi.run(App::stack);
    }

    public static void stack(Context ctx) {
        final var config = ctx.config();
        final var vpc = config.get("vpc");
        final var domain = config.get("domain").orElse("tf-test");
        final var exampleVpc = Ec2Functions.getVpc(GetVpcArgs.builder()
            .tags(Map.of("Name", vpc))
            .build());

        final var exampleSubnetIds = Ec2Functions.getSubnetIds(GetSubnetIdsArgs.builder()
            .vpcId(exampleVpc.applyValue(getVpcResult -> getVpcResult.id()))
            .tags(Map.of("Tier", "private"))
            .build());

        final var currentRegion = AwsFunctions.getRegion();

        final var currentCallerIdentity = AwsFunctions.getCallerIdentity();

        var exampleSecurityGroup = new SecurityGroup("exampleSecurityGroup", SecurityGroupArgs.builder()        
            .description("Managed by Terraform")
            .vpcId(exampleVpc.applyValue(getVpcResult -> getVpcResult.id()))
            .ingress(SecurityGroupIngressArgs.builder()
                .fromPort(443)
                .toPort(443)
                .protocol("tcp")
                .cidrBlocks(exampleVpc.applyValue(getVpcResult -> getVpcResult.cidrBlock()))
                .build())
            .build());

        var exampleServiceLinkedRole = new ServiceLinkedRole("exampleServiceLinkedRole", ServiceLinkedRoleArgs.builder()        
            .awsServiceName("opensearchservice.amazonaws.com")
            .build());

        var exampleDomain = new Domain("exampleDomain", DomainArgs.builder()        
            .engineVersion("OpenSearch_1.0")
            .clusterConfig(DomainClusterConfigArgs.builder()
                .instanceType("m4.large.search")
                .zoneAwarenessEnabled(true)
                .build())
            .vpcOptions(DomainVpcOptionsArgs.builder()
                .subnetIds(                
                    exampleSubnetIds.applyValue(getSubnetIdsResult -> getSubnetIdsResult.ids()[0]),
                    exampleSubnetIds.applyValue(getSubnetIdsResult -> getSubnetIdsResult.ids()[1]))
                .securityGroupIds(exampleSecurityGroup.id())
                .build())
            .advancedOptions(Map.of("rest.action.multi.allow_explicit_index", "true"))
            .accessPolicies("""
{
	"Version": "2012-10-17",
	"Statement": [
		{
			"Action": "es:*",
			"Principal": "*",
			"Effect": "Allow",
			"Resource": "arn:aws:es:%s:%s:domain/%s/*"
		}
	]
}
", currentRegion.applyValue(getRegionResult -> getRegionResult.name()),currentCallerIdentity.applyValue(getCallerIdentityResult -> getCallerIdentityResult.accountId()),domain))
            .tags(Map.of("Domain", "TestDomain"))
            .build(), CustomResourceOptions.builder()
                .dependsOn(exampleServiceLinkedRole)
                .build());

    }
}
```

</details>

<details>

<summary>typescript</summary>

```typescript
import * as pulumi from "@pulumi/pulumi";
import * as aws from "@pulumi/aws";

const config = new pulumi.Config();
const vpc = config.requireObject("vpc");
const domain = config.get("domain") || "tf-test";
const exampleVpc = aws.ec2.getVpc({
    tags: {
        Name: vpc,
    },
});
const exampleSubnetIds = exampleVpc.then(exampleVpc => aws.ec2.getSubnetIds({
    vpcId: exampleVpc.id,
    tags: {
        Tier: "private",
    },
}));
const currentRegion = aws.getRegion({});
const currentCallerIdentity = aws.getCallerIdentity({});
const exampleSecurityGroup = new aws.ec2.SecurityGroup("exampleSecurityGroup", {
    description: "Managed by Terraform",
    vpcId: exampleVpc.then(exampleVpc => exampleVpc.id),
    ingress: [{
        fromPort: 443,
        toPort: 443,
        protocol: "tcp",
        cidrBlocks: [exampleVpc.then(exampleVpc => exampleVpc.cidrBlock)],
    }],
});
const exampleServiceLinkedRole = new aws.iam.ServiceLinkedRole("exampleServiceLinkedRole", {awsServiceName: "opensearchservice.amazonaws.com"});
const exampleDomain = new aws.opensearch.Domain("exampleDomain", {
    engineVersion: "OpenSearch_1.0",
    clusterConfig: {
        instanceType: "m4.large.search",
        zoneAwarenessEnabled: true,
    },
    vpcOptions: {
        subnetIds: [
            exampleSubnetIds.then(exampleSubnetIds => exampleSubnetIds.ids?[0]),
            exampleSubnetIds.then(exampleSubnetIds => exampleSubnetIds.ids?[1]),
        ],
        securityGroupIds: [exampleSecurityGroup.id],
    },
    advancedOptions: {
        "rest.action.multi.allow_explicit_index": "true",
    },
    accessPolicies: Promise.all([currentRegion, currentCallerIdentity]).then(([currentRegion, currentCallerIdentity]) => `{
	"Version": "2012-10-17",
	"Statement": [
		{
			"Action": "es:*",
			"Principal": "*",
			"Effect": "Allow",
			"Resource": "arn:aws:es:${currentRegion.name}:${currentCallerIdentity.accountId}:domain/${domain}/*"
		}
	]
}
`),
    tags: {
        Domain: "TestDomain",
    },
}, {
    dependsOn: [exampleServiceLinkedRole],
});
```

</details>

<details>

<summary>python</summary>

```python
import pulumi
import pulumi_aws as aws

config = pulumi.Config()
vpc = config.require_object("vpc")
domain = config.get("domain")
if domain is None:
    domain = "tf-test"
example_vpc = aws.ec2.get_vpc(tags={
    "Name": vpc,
})
example_subnet_ids = aws.ec2.get_subnet_ids(vpc_id=example_vpc.id,
    tags={
        "Tier": "private",
    })
current_region = aws.get_region()
current_caller_identity = aws.get_caller_identity()
example_security_group = aws.ec2.SecurityGroup("exampleSecurityGroup",
    description="Managed by Terraform",
    vpc_id=example_vpc.id,
    ingress=[aws.ec2.SecurityGroupIngressArgs(
        from_port=443,
        to_port=443,
        protocol="tcp",
        cidr_blocks=[example_vpc.cidr_block],
    )])
example_service_linked_role = aws.iam.ServiceLinkedRole("exampleServiceLinkedRole", aws_service_name="opensearchservice.amazonaws.com")
example_domain = aws.opensearch.Domain("exampleDomain",
    engine_version="OpenSearch_1.0",
    cluster_config=aws.opensearch.DomainClusterConfigArgs(
        instance_type="m4.large.search",
        zone_awareness_enabled=True,
    ),
    vpc_options=aws.opensearch.DomainVpcOptionsArgs(
        subnet_ids=[
            example_subnet_ids.ids[0],
            example_subnet_ids.ids[1],
        ],
        security_group_ids=[example_security_group.id],
    ),
    advanced_options={
        "rest.action.multi.allow_explicit_index": "true",
    },
    access_policies=f"""{{
	"Version": "2012-10-17",
	"Statement": [
		{{
			"Action": "es:*",
			"Principal": "*",
			"Effect": "Allow",
			"Resource": "arn:aws:es:{current_region.name}:{current_caller_identity.account_id}:domain/{domain}/*"
		}}
	]
}}
""",
    tags={
        "Domain": "TestDomain",
    },
    opts=pulumi.ResourceOptions(depends_on=[example_service_linked_role]))
```

</details>

## [*partial failure*] Application Load Balancer

### HCL

```terraform
resource "aws_lb" "test" {
  name               = "test-lb-tf"
  internal           = false
  load_balancer_type = "application"
  security_groups    = [aws_security_group.lb_sg.id]
  subnets            = [for subnet in aws_subnet.public : subnet.id]

  enable_deletion_protection = true

  access_logs {
    bucket  = aws_s3_bucket.lb_logs.bucket
    prefix  = "test-lb"
    enabled = true
  }

  tags = {
    Environment = "production"
  }
}

```

### Failed Languages

#### csharp

```text
<nil>: not yet implemented: ForExpression; not yet implemented: ForExpression
```

#### go

```text
<nil>: not yet implemented: For expression; not yet implemented: For expression
```

#### yaml

```text
.pp:4,24-69: Failed to generate YAML program: For; Pulumi YAML cannot represent for loops.If the values of the for loop are known, you can manually unroll the loop, otherwise it is necessary to switch to a more expressive language.
```

#### java

```text
<nil>: not yet implemented: ForExpression; not yet implemented: ForExpression
```

### Successes

<details>

<summary>typescript</summary>

```typescript
import * as pulumi from "@pulumi/pulumi";
import * as aws from "@pulumi/aws";

const test = new aws.lb.LoadBalancer("test", {
    internal: false,
    loadBalancerType: "application",
    securityGroups: [aws_security_group.lb_sg.id],
    subnets: .map(subnet => subnet.id),
    enableDeletionProtection: true,
    accessLogs: {
        bucket: aws_s3_bucket.lb_logs.bucket,
        prefix: "test-lb",
        enabled: true,
    },
    tags: {
        Environment: "production",
    },
});
```

</details>

<details>

<summary>python</summary>

```python
import pulumi
import pulumi_aws as aws

test = aws.lb.LoadBalancer("test",
    internal=False,
    load_balancer_type="application",
    security_groups=[aws_security_group["lb_sg"]["id"]],
    subnets=[subnet["id"] for subnet in aws_subnet["public"]],
    enable_deletion_protection=True,
    access_logs=aws.lb.LoadBalancerAccessLogsArgs(
        bucket=aws_s3_bucket["lb_logs"]["bucket"],
        prefix="test-lb",
        enabled=True,
    ),
    tags={
        "Environment": "production",
    })
```

</details>

## [*partial failure*] Network Load Balancer

### HCL

```terraform
resource "aws_lb" "test" {
  name               = "test-lb-tf"
  internal           = false
  load_balancer_type = "network"
  subnets            = [for subnet in aws_subnet.public : subnet.id]

  enable_deletion_protection = true

  tags = {
    Environment = "production"
  }
}

```

### Failed Languages

#### java

```text
<nil>: not yet implemented: ForExpression; not yet implemented: ForExpression
```

#### csharp

```text
<nil>: not yet implemented: ForExpression; not yet implemented: ForExpression
```

#### go

```text
<nil>: not yet implemented: For expression; not yet implemented: For expression
```

#### yaml

```text
.pp:3,24-69: Failed to generate YAML program: For; Pulumi YAML cannot represent for loops.If the values of the for loop are known, you can manually unroll the loop, otherwise it is necessary to switch to a more expressive language.
```

### Successes

<details>

<summary>python</summary>

```python
import pulumi
import pulumi_aws as aws

test = aws.lb.LoadBalancer("test",
    internal=False,
    load_balancer_type="network",
    subnets=[subnet["id"] for subnet in aws_subnet["public"]],
    enable_deletion_protection=True,
    tags={
        "Environment": "production",
    })
```

</details>

<details>

<summary>typescript</summary>

```typescript
import * as pulumi from "@pulumi/pulumi";
import * as aws from "@pulumi/aws";

const test = new aws.lb.LoadBalancer("test", {
    internal: false,
    loadBalancerType: "network",
    subnets: .map(subnet => subnet.id),
    enableDeletionProtection: true,
    tags: {
        Environment: "production",
    },
});
```

</details>

## [*partial failure*] #/resources/aws:cloudfront/keyGroup:KeyGroup

### HCL

```terraform
resource "aws_cloudfront_public_key" "example" {
  comment     = "example public key"
  encoded_key = file("public_key.pem")
  name        = "example-key"
}

resource "aws_cloudfront_key_group" "example" {
  comment = "example key group"
  items   = [aws_cloudfront_public_key.example.id]
  name    = "example-key-group"
}

```

### Failed Languages

#### yaml

```text
.pp:2,16-42: Failed to generate YAML program: Unknown Function; YAML does not support Fn::readFile.
```

### Successes

<details>

<summary>java</summary>

```java
package generated_program;

import com.pulumi.Context;
import com.pulumi.Pulumi;
import com.pulumi.core.Output;
import com.pulumi.aws.cloudfront.PublicKey;
import com.pulumi.aws.cloudfront.PublicKeyArgs;
import com.pulumi.aws.cloudfront.KeyGroup;
import com.pulumi.aws.cloudfront.KeyGroupArgs;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;

public class App {
    public static void main(String[] args) {
        Pulumi.run(App::stack);
    }

    public static void stack(Context ctx) {
        var examplePublicKey = new PublicKey("examplePublicKey", PublicKeyArgs.builder()        
            .comment("example public key")
            .encodedKey(Files.readString(Paths.get("public_key.pem")))
            .build());

        var exampleKeyGroup = new KeyGroup("exampleKeyGroup", KeyGroupArgs.builder()        
            .comment("example key group")
            .items(examplePublicKey.id())
            .build());

    }
}
```

</details>

<details>

<summary>typescript</summary>

```typescript
import * as pulumi from "@pulumi/pulumi";
import * as aws from "@pulumi/aws";
import * as fs from "fs";

const examplePublicKey = new aws.cloudfront.PublicKey("examplePublicKey", {
    comment: "example public key",
    encodedKey: fs.readFileSync("public_key.pem"),
});
const exampleKeyGroup = new aws.cloudfront.KeyGroup("exampleKeyGroup", {
    comment: "example key group",
    items: [examplePublicKey.id],
});
```

</details>

<details>

<summary>python</summary>

```python
import pulumi
import pulumi_aws as aws

example_public_key = aws.cloudfront.PublicKey("examplePublicKey",
    comment="example public key",
    encoded_key=(lambda path: open(path).read())("public_key.pem"))
example_key_group = aws.cloudfront.KeyGroup("exampleKeyGroup",
    comment="example key group",
    items=[example_public_key.id])
```

</details>

<details>

<summary>csharp</summary>

```csharp
using System.Collections.Generic;
using System.IO;
using Pulumi;
using Aws = Pulumi.Aws;

return await Deployment.RunAsync(() => 
{
    var examplePublicKey = new Aws.CloudFront.PublicKey("examplePublicKey", new()
    {
        Comment = "example public key",
        EncodedKey = File.ReadAllText("public_key.pem"),
    });

    var exampleKeyGroup = new Aws.CloudFront.KeyGroup("exampleKeyGroup", new()
    {
        Comment = "example key group",
        Items = new[]
        {
            examplePublicKey.Id,
        },
    });

});
```

</details>

<details>

<summary>go</summary>

```go
package main

import (
	"io/ioutil"

	"github.com/pulumi/pulumi-aws/sdk/v5/go/aws/cloudfront"
	"github.com/pulumi/pulumi/sdk/v3/go/pulumi"
)

func readFileOrPanic(path string) pulumi.StringPtrInput {
	data, err := ioutil.ReadFile(path)
	if err != nil {
		panic(err.Error())
	}
	return pulumi.String(string(data))
}

func main() {
	pulumi.Run(func(ctx *pulumi.Context) error {
		examplePublicKey, err := cloudfront.NewPublicKey(ctx, "examplePublicKey", &cloudfront.PublicKeyArgs{
			Comment:    pulumi.String("example public key"),
			EncodedKey: readFileOrPanic("public_key.pem"),
		})
		if err != nil {
			return err
		}
		_, err = cloudfront.NewKeyGroup(ctx, "exampleKeyGroup", &cloudfront.KeyGroupArgs{
			Comment: pulumi.String("example key group"),
			Items: pulumi.StringArray{
				examplePublicKey.ID(),
			},
		})
		if err != nil {
			return err
		}
		return nil
	})
}
```

</details>

## [**complete failure**] #/resources/aws:directoryservice/serviceRegion:ServiceRegion

### HCL

```terraform
provider "aws" {
  region = "us-west-2"
}

provider "aws" {
  alias  = "secondary"
  region = "us-east-2"
}

data "aws_region" "example" {
  provider = aws.secondary
}

data "aws_availability_zones" "available" {
  state = "available"

  filter {
    name   = "opt-in-status"
    values = ["opt-in-not-required"]
  }
}

resource "aws_vpc" "example" {
  cidr_block = "10.0.0.0/16"

  tags = {
    Name = "Primary"
  }
}

resource "aws_subnet" "example" {
  count = 2

  vpc_id            = aws_vpc.example.id
  availability_zone = data.aws_availability_zones.available.names[count.index]
  cidr_block        = cidrsubnet(aws_vpc.example.cidr_block, 8, count.index)

  tags = {
    Name = "Primary"
  }
}

resource "aws_directory_service_directory" "example" {
  name     = "example.com"
  password = "SuperSecretPassw0rd"
  type     = "MicrosoftAD"

  vpc_settings {
    vpc_id     = aws_vpc.example.id
    subnet_ids = aws_subnet.example[*].id
  }
}

data "aws_availability_zones" "available-secondary" {
  provider = aws.secondary

  state = "available"

  filter {
    name   = "opt-in-status"
    values = ["opt-in-not-required"]
  }
}

resource "aws_vpc" "example-secondary" {
  provider = aws.secondary

  cidr_block = "10.1.0.0/16" # Can't overlap with primary's VPC.

  tags = {
    Name = "Secondary"
  }
}

resource "aws_subnet" "example-secondary" {
  provider = aws.secondary

  count = 2

  vpc_id            = aws_vpc.example-secondary.id
  availability_zone = data.aws_availability_zones.available-secondary.names[count.index]
  cidr_block        = cidrsubnet(aws_vpc.example-secondary.cidr_block, 8, count.index)

  tags = {
    Name = "Secondary"
  }
}

resource "aws_directory_service_region" "example" {
  directory_id = aws_directory_service_directory.example.id
  region_name  = data.aws_region.example.name

  vpc_settings {
    vpc_id     = aws_vpc.example-secondary.id
    subnet_ids = aws_subnet.example-secondary[*].id
  }

  tags = {
    Name = "Secondary"
  }
}

```

### Failed Languages

#### python

```text
:0,0-2,2: default provider configuration is not supported; , and 4 other diagnostic(s)
```

#### csharp

```text
:0,0-2,2: default provider configuration is not supported; , and 4 other diagnostic(s)
```

#### go

```text
:0,0-2,2: default provider configuration is not supported; , and 4 other diagnostic(s)
```

#### yaml

```text
:0,0-2,2: default provider configuration is not supported; , and 4 other diagnostic(s)
```

#### java

```text
:0,0-2,2: default provider configuration is not supported; , and 4 other diagnostic(s)
```

#### typescript

```text
:0,0-2,2: default provider configuration is not supported; , and 4 other diagnostic(s)
```

## [**complete failure**] #/resources/aws:ssoadmin/customerManagedPolicyAttachment:CustomerManagedPolicyAttachment

### HCL

```terraform
data "aws_ssoadmin_instances" "example" {}

resource "aws_ssoadmin_permission_set" "example" {
  name         = "Example"
  instance_arn = tolist(data.aws_ssoadmin_instances.example.arns)[0]
}

resource "aws_iam_policy" "example" {
  name        = "TestPolicy"
  description = "My test policy"
  policy = jsonencode({
    Version = "2012-10-17"
    Statement = [
      {
        Action = [
          "ec2:Describe*",
        ]
        Effect   = "Allow"
        Resource = "*"
      },
    ]
  })
}

resource "aws_ssoadmin_customer_managed_policy_attachment" "example" {
  instance_arn       = aws_ssoadmin_permission_set.example.instance_arn
  permission_set_arn = aws_ssoadmin_permission_set.example.arn
  customer_managed_policy_reference {
    name = aws_iam_policy.example.name
    path = "/"
  }
}

```

### Failed Languages

#### yaml

```text
:4,18-24: unknown function 'tolist'; , and 1 other diagnostic(s)
```

#### java

```text
:4,18-24: unknown function 'tolist'; , and 1 other diagnostic(s)
```

#### typescript

```text
:4,18-24: unknown function 'tolist'; , and 1 other diagnostic(s)
```

#### python

```text
:4,18-24: unknown function 'tolist'; , and 1 other diagnostic(s)
```

#### csharp

```text
:4,18-24: unknown function 'tolist'; , and 1 other diagnostic(s)
```

#### go

```text
:4,18-24: unknown function 'tolist'; , and 1 other diagnostic(s)
```

## [*partial failure*] Basic Example

### HCL

```terraform
resource "aws_vpc" "mainvpc" {
  cidr_block = "10.1.0.0/16"
}

resource "aws_default_network_acl" "default" {
  default_network_acl_id = aws_vpc.mainvpc.default_network_acl_id

  ingress {
    protocol   = -1
    rule_no    = 100
    action     = "allow"
    cidr_block = "0.0.0.0/0"
    from_port  = 0
    to_port    = 0
  }

  egress {
    protocol   = -1
    rule_no    = 100
    action     = "allow"
    cidr_block = "0.0.0.0/0"
    from_port  = 0
    to_port    = 0
  }
}

```

### Failed Languages

#### yaml

```text
.pp:6,18-20: Failed to generate YAML program: *model.UnaryOpExpression; Unimplemented! Needed for  -1, and 1 other diagnostic(s)
```

#### java

```text
<nil>: not yet implemented: GenUnaryOpExpression; not yet implemented: GenUnaryOpExpression, and 1 other diagnostic(s)
```

### Successes

<details>

<summary>python</summary>

```python
import pulumi
import pulumi_aws as aws

mainvpc = aws.ec2.Vpc("mainvpc", cidr_block="10.1.0.0/16")
default = aws.ec2.DefaultNetworkAcl("default",
    default_network_acl_id=mainvpc.default_network_acl_id,
    ingress=[aws.ec2.DefaultNetworkAclIngressArgs(
        protocol="-1",
        rule_no=100,
        action="allow",
        cidr_block="0.0.0.0/0",
        from_port=0,
        to_port=0,
    )],
    egress=[aws.ec2.DefaultNetworkAclEgressArgs(
        protocol="-1",
        rule_no=100,
        action="allow",
        cidr_block="0.0.0.0/0",
        from_port=0,
        to_port=0,
    )])
```

</details>

<details>

<summary>csharp</summary>

```csharp
using System.Collections.Generic;
using Pulumi;
using Aws = Pulumi.Aws;

return await Deployment.RunAsync(() => 
{
    var mainvpc = new Aws.Ec2.Vpc("mainvpc", new()
    {
        CidrBlock = "10.1.0.0/16",
    });

    var @default = new Aws.Ec2.DefaultNetworkAcl("default", new()
    {
        DefaultNetworkAclId = mainvpc.DefaultNetworkAclId,
        Ingress = new[]
        {
            new Aws.Ec2.Inputs.DefaultNetworkAclIngressArgs
            {
                Protocol = "-1",
                RuleNo = 100,
                Action = "allow",
                CidrBlock = "0.0.0.0/0",
                FromPort = 0,
                ToPort = 0,
            },
        },
        Egress = new[]
        {
            new Aws.Ec2.Inputs.DefaultNetworkAclEgressArgs
            {
                Protocol = "-1",
                RuleNo = 100,
                Action = "allow",
                CidrBlock = "0.0.0.0/0",
                FromPort = 0,
                ToPort = 0,
            },
        },
    });

});
```

</details>

<details>

<summary>go</summary>

```go
package main

import (
	"github.com/pulumi/pulumi-aws/sdk/v5/go/aws/ec2"
	"github.com/pulumi/pulumi/sdk/v3/go/pulumi"
)

func main() {
	pulumi.Run(func(ctx *pulumi.Context) error {
		mainvpc, err := ec2.NewVpc(ctx, "mainvpc", &ec2.VpcArgs{
			CidrBlock: pulumi.String("10.1.0.0/16"),
		})
		if err != nil {
			return err
		}
		_, err = ec2.NewDefaultNetworkAcl(ctx, "default", &ec2.DefaultNetworkAclArgs{
			DefaultNetworkAclId: mainvpc.DefaultNetworkAclId,
			Ingress: ec2.DefaultNetworkAclIngressArray{
				&ec2.DefaultNetworkAclIngressArgs{
					Protocol:  pulumi.String("-1"),
					RuleNo:    pulumi.Int(100),
					Action:    pulumi.String("allow"),
					CidrBlock: pulumi.String("0.0.0.0/0"),
					FromPort:  pulumi.Int(0),
					ToPort:    pulumi.Int(0),
				},
			},
			Egress: ec2.DefaultNetworkAclEgressArray{
				&ec2.DefaultNetworkAclEgressArgs{
					Protocol:  pulumi.String("-1"),
					RuleNo:    pulumi.Int(100),
					Action:    pulumi.String("allow"),
					CidrBlock: pulumi.String("0.0.0.0/0"),
					FromPort:  pulumi.Int(0),
					ToPort:    pulumi.Int(0),
				},
			},
		})
		if err != nil {
			return err
		}
		return nil
	})
}
```

</details>

<details>

<summary>typescript</summary>

```typescript
import * as pulumi from "@pulumi/pulumi";
import * as aws from "@pulumi/aws";

const mainvpc = new aws.ec2.Vpc("mainvpc", {cidrBlock: "10.1.0.0/16"});
const _default = new aws.ec2.DefaultNetworkAcl("default", {
    defaultNetworkAclId: mainvpc.defaultNetworkAclId,
    ingress: [{
        protocol: "-1",
        ruleNo: 100,
        action: "allow",
        cidrBlock: "0.0.0.0/0",
        fromPort: 0,
        toPort: 0,
    }],
    egress: [{
        protocol: "-1",
        ruleNo: 100,
        action: "allow",
        cidrBlock: "0.0.0.0/0",
        fromPort: 0,
        toPort: 0,
    }],
});
```

</details>

## [*partial failure*] Example: Deny All Egress Traffic, Allow Ingress

### HCL

```terraform
resource "aws_vpc" "mainvpc" {
  cidr_block = "10.1.0.0/16"
}

resource "aws_default_network_acl" "default" {
  default_network_acl_id = aws_vpc.mainvpc.default_network_acl_id

  ingress {
    protocol   = -1
    rule_no    = 100
    action     = "allow"
    cidr_block = aws_default_vpc.mainvpc.cidr_block
    from_port  = 0
    to_port    = 0
  }
}

```

### Failed Languages

#### yaml

```text
.pp:6,18-20: Failed to generate YAML program: *model.UnaryOpExpression; Unimplemented! Needed for  -1
```

#### java

```text
<nil>: not yet implemented: GenUnaryOpExpression; not yet implemented: GenUnaryOpExpression
```

### Successes

<details>

<summary>typescript</summary>

```typescript
import * as pulumi from "@pulumi/pulumi";
import * as aws from "@pulumi/aws";

const mainvpc = new aws.ec2.Vpc("mainvpc", {cidrBlock: "10.1.0.0/16"});
const _default = new aws.ec2.DefaultNetworkAcl("default", {
    defaultNetworkAclId: mainvpc.defaultNetworkAclId,
    ingress: [{
        protocol: "-1",
        ruleNo: 100,
        action: "allow",
        cidrBlock: aws_default_vpc.mainvpc.cidr_block,
        fromPort: 0,
        toPort: 0,
    }],
});
```

</details>

<details>

<summary>python</summary>

```python
import pulumi
import pulumi_aws as aws

mainvpc = aws.ec2.Vpc("mainvpc", cidr_block="10.1.0.0/16")
default = aws.ec2.DefaultNetworkAcl("default",
    default_network_acl_id=mainvpc.default_network_acl_id,
    ingress=[aws.ec2.DefaultNetworkAclIngressArgs(
        protocol="-1",
        rule_no=100,
        action="allow",
        cidr_block=aws_default_vpc["mainvpc"]["cidr_block"],
        from_port=0,
        to_port=0,
    )])
```

</details>

<details>

<summary>csharp</summary>

```csharp
using System.Collections.Generic;
using Pulumi;
using Aws = Pulumi.Aws;

return await Deployment.RunAsync(() => 
{
    var mainvpc = new Aws.Ec2.Vpc("mainvpc", new()
    {
        CidrBlock = "10.1.0.0/16",
    });

    var @default = new Aws.Ec2.DefaultNetworkAcl("default", new()
    {
        DefaultNetworkAclId = mainvpc.DefaultNetworkAclId,
        Ingress = new[]
        {
            new Aws.Ec2.Inputs.DefaultNetworkAclIngressArgs
            {
                Protocol = "-1",
                RuleNo = 100,
                Action = "allow",
                CidrBlock = aws_default_vpc.Mainvpc.Cidr_block,
                FromPort = 0,
                ToPort = 0,
            },
        },
    });

});
```

</details>

<details>

<summary>go</summary>

```go
package main

import (
	"github.com/pulumi/pulumi-aws/sdk/v5/go/aws/ec2"
	"github.com/pulumi/pulumi/sdk/v3/go/pulumi"
)

func main() {
	pulumi.Run(func(ctx *pulumi.Context) error {
		mainvpc, err := ec2.NewVpc(ctx, "mainvpc", &ec2.VpcArgs{
			CidrBlock: pulumi.String("10.1.0.0/16"),
		})
		if err != nil {
			return err
		}
		_, err = ec2.NewDefaultNetworkAcl(ctx, "default", &ec2.DefaultNetworkAclArgs{
			DefaultNetworkAclId: mainvpc.DefaultNetworkAclId,
			Ingress: ec2.DefaultNetworkAclIngressArray{
				&ec2.DefaultNetworkAclIngressArgs{
					Protocol:  pulumi.String("-1"),
					RuleNo:    pulumi.Int(100),
					Action:    pulumi.String("allow"),
					CidrBlock: pulumi.Any(aws_default_vpc.Mainvpc.Cidr_block),
					FromPort:  pulumi.Int(0),
					ToPort:    pulumi.Int(0),
				},
			},
		})
		if err != nil {
			return err
		}
		return nil
	})
}
```

</details>

## [**complete failure**] #/resources/aws:ssoadmin/managedPolicyAttachment:ManagedPolicyAttachment

### HCL

```terraform
data "aws_ssoadmin_instances" "example" {}

resource "aws_ssoadmin_permission_set" "example" {
  name         = "Example"
  instance_arn = tolist(data.aws_ssoadmin_instances.example.arns)[0]
}

resource "aws_ssoadmin_managed_policy_attachment" "example" {
  instance_arn       = tolist(data.aws_ssoadmin_instances.example.arns)[0]
  managed_policy_arn = "arn:aws:iam::aws:policy/AlexaForBusinessDeviceSetup"
  permission_set_arn = aws_ssoadmin_permission_set.example.arn
}

```

### Failed Languages

#### typescript

```text
:4,18-24: unknown function 'tolist'; , and 3 other diagnostic(s)
```

#### python

```text
:4,18-24: unknown function 'tolist'; , and 3 other diagnostic(s)
```

#### csharp

```text
:4,18-24: unknown function 'tolist'; , and 3 other diagnostic(s)
```

#### go

```text
:4,18-24: unknown function 'tolist'; , and 3 other diagnostic(s)
```

#### yaml

```text
:4,18-24: unknown function 'tolist'; , and 3 other diagnostic(s)
```

#### java

```text
:4,18-24: unknown function 'tolist'; , and 3 other diagnostic(s)
```

## [*partial failure*] #/resources/aws:lex/intent:Intent

### HCL

```terraform
resource "aws_lex_intent" "order_flowers_intent" {
  confirmation_prompt {
    max_attempts = 2

    message {
      content      = "Okay, your {FlowerType} will be ready for pickup by {PickupTime} on {PickupDate}.  Does this sound okay?"
      content_type = "PlainText"
    }
  }

  create_version = false
  name           = "OrderFlowers"
  description    = "Intent to order a bouquet of flowers for pick up"

  fulfillment_activity {
    type = "ReturnIntent"
  }

  rejection_statement {
    message {
      content      = "Okay, I will not place your order."
      content_type = "PlainText"
    }
  }

  sample_utterances = [
    "I would like to order some flowers",
    "I would like to pick up flowers",
  ]

  slot {
    description = "The type of flowers to pick up"
    name        = "FlowerType"
    priority    = 1

    sample_utterances = [
      "I would like to order {FlowerType}",
    ]

    slot_constraint   = "Required"
    slot_type         = "FlowerTypes"
    slot_type_version = "$$LATEST"

    value_elicitation_prompt {
      max_attempts = 2

      message {
        content      = "What type of flowers would you like to order?"
        content_type = "PlainText"
      }
    }
  }

  slot {
    description = "The date to pick up the flowers"
    name        = "PickupDate"
    priority    = 2

    sample_utterances = [
      "I would like to order {FlowerType}",
    ]

    slot_constraint   = "Required"
    slot_type         = "AMAZON.DATE"
    slot_type_version = "$$LATEST"

    value_elicitation_prompt {
      max_attempts = 2

      message {
        content      = "What day do you want the {FlowerType} to be picked up?"
        content_type = "PlainText"
      }
    }
  }

  slot {
    description = "The time to pick up the flowers"
    name        = "PickupTime"
    priority    = 3

    sample_utterances = [
      "I would like to order {FlowerType}",
    ]

    slot_constraint   = "Required"
    slot_type         = "AMAZON.TIME"
    slot_type_version = "$$LATEST"

    value_elicitation_prompt {
      max_attempts = 2

      message {
        content      = "Pick up the {FlowerType} at what time on {PickupDate}?"
        content_type = "PlainText"
      }
    }
  }
}

```

### Failed Languages

#### python

```text
:0,0-0: unknown property 'message' among [messages responseCard maxAttempts]; , and 14 other diagnostic(s)
```

#### csharp

```text
:0,0-0: unknown property 'message' among [maxAttempts messages responseCard]; , and 14 other diagnostic(s)
```

#### go

```text
:0,0-0: unknown property 'message' among [maxAttempts messages responseCard]; , and 14 other diagnostic(s)
```

### Successes

<details>

<summary>yaml</summary>

```yaml
resources:
  orderFlowersIntent:
    type: aws:lex:Intent
    properties:
      confirmationPrompt:
        maxAttempts: 2
        messages:
          - content: Okay, your {FlowerType} will be ready for pickup by {PickupTime} on {PickupDate}.  Does this sound okay?
            contentType: PlainText
      createVersion: false
      description: Intent to order a bouquet of flowers for pick up
      fulfillmentActivity:
        type: ReturnIntent
      name: OrderFlowers
      rejectionStatement:
        messages:
          - content: Okay, I will not place your order.
            contentType: PlainText
      sampleUtterances:
        - I would like to order some flowers
        - I would like to pick up flowers
      slots:
        - description: The type of flowers to pick up
          name: FlowerType
          priority: 1
          sampleUtterances:
            - I would like to order {FlowerType}
          slotConstraint: Required
          slotType: FlowerTypes
          slotTypeVersion: $LATEST
          valueElicitationPrompt:
            maxAttempts: 2
            message:
              - content: What type of flowers would you like to order?
                contentType: PlainText
        - description: The date to pick up the flowers
          name: PickupDate
          priority: 2
          sampleUtterances:
            - I would like to order {FlowerType}
          slotConstraint: Required
          slotType: AMAZON.DATE
          slotTypeVersion: $LATEST
          valueElicitationPrompt:
            maxAttempts: 2
            message:
              - content: What day do you want the {FlowerType} to be picked up?
                contentType: PlainText
        - description: The time to pick up the flowers
          name: PickupTime
          priority: 3
          sampleUtterances:
            - I would like to order {FlowerType}
          slotConstraint: Required
          slotType: AMAZON.TIME
          slotTypeVersion: $LATEST
          valueElicitationPrompt:
            maxAttempts: 2
            message:
              - content: Pick up the {FlowerType} at what time on {PickupDate}?
                contentType: PlainText
```

</details>

<details>

<summary>java</summary>

```java
package generated_program;

import com.pulumi.Context;
import com.pulumi.Pulumi;
import com.pulumi.core.Output;
import com.pulumi.aws.lex.Intent;
import com.pulumi.aws.lex.IntentArgs;
import com.pulumi.aws.lex.inputs.IntentConfirmationPromptArgs;
import com.pulumi.aws.lex.inputs.IntentFulfillmentActivityArgs;
import com.pulumi.aws.lex.inputs.IntentRejectionStatementArgs;
import com.pulumi.aws.lex.inputs.IntentSlotArgs;
import com.pulumi.aws.lex.inputs.IntentSlotValueElicitationPromptArgs;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;

public class App {
    public static void main(String[] args) {
        Pulumi.run(App::stack);
    }

    public static void stack(Context ctx) {
        var orderFlowersIntent = new Intent("orderFlowersIntent", IntentArgs.builder()        
            .confirmationPrompt(IntentConfirmationPromptArgs.builder()
                .maxAttempts(2)
                .messages(IntentConfirmationPromptMessageArgs.builder()
                    .content("Okay, your {FlowerType} will be ready for pickup by {PickupTime} on {PickupDate}.  Does this sound okay?")
                    .contentType("PlainText")
                    .build())
                .build())
            .createVersion(false)
            .description("Intent to order a bouquet of flowers for pick up")
            .fulfillmentActivity(IntentFulfillmentActivityArgs.builder()
                .type("ReturnIntent")
                .build())
            .name("OrderFlowers")
            .rejectionStatement(IntentRejectionStatementArgs.builder()
                .messages(IntentRejectionStatementMessageArgs.builder()
                    .content("Okay, I will not place your order.")
                    .contentType("PlainText")
                    .build())
                .build())
            .sampleUtterances(            
                "I would like to order some flowers",
                "I would like to pick up flowers")
            .slots(            
                IntentSlotArgs.builder()
                    .description("The type of flowers to pick up")
                    .name("FlowerType")
                    .priority(1)
                    .sampleUtterances("I would like to order {FlowerType}")
                    .slotConstraint("Required")
                    .slotType("FlowerTypes")
                    .slotTypeVersion("$LATEST")
                    .valueElicitationPrompt(IntentSlotValueElicitationPromptArgs.builder()
                        .maxAttempts(2)
                        .message(%!v(PANIC=Format method: runtime error: invalid memory address or nil pointer dereference))
                        .build())
                    .build(),
                IntentSlotArgs.builder()
                    .description("The date to pick up the flowers")
                    .name("PickupDate")
                    .priority(2)
                    .sampleUtterances("I would like to order {FlowerType}")
                    .slotConstraint("Required")
                    .slotType("AMAZON.DATE")
                    .slotTypeVersion("$LATEST")
                    .valueElicitationPrompt(IntentSlotValueElicitationPromptArgs.builder()
                        .maxAttempts(2)
                        .message(%!v(PANIC=Format method: runtime error: invalid memory address or nil pointer dereference))
                        .build())
                    .build(),
                IntentSlotArgs.builder()
                    .description("The time to pick up the flowers")
                    .name("PickupTime")
                    .priority(3)
                    .sampleUtterances("I would like to order {FlowerType}")
                    .slotConstraint("Required")
                    .slotType("AMAZON.TIME")
                    .slotTypeVersion("$LATEST")
                    .valueElicitationPrompt(IntentSlotValueElicitationPromptArgs.builder()
                        .maxAttempts(2)
                        .message(%!v(PANIC=Format method: runtime error: invalid memory address or nil pointer dereference))
                        .build())
                    .build())
            .build());

    }
}
```

</details>

<details>

<summary>typescript</summary>

```typescript
import * as pulumi from "@pulumi/pulumi";
import * as aws from "@pulumi/aws";

const orderFlowersIntent = new aws.lex.Intent("order_flowers_intent", {
    confirmationPrompt: {
        maxAttempts: 2,
        messages: [{
            content: "Okay, your {FlowerType} will be ready for pickup by {PickupTime} on {PickupDate}.  Does this sound okay?",
            contentType: "PlainText",
        }],
    },
    createVersion: false,
    description: "Intent to order a bouquet of flowers for pick up",
    fulfillmentActivity: {
        type: "ReturnIntent",
    },
    name: "OrderFlowers",
    rejectionStatement: {
        messages: [{
            content: "Okay, I will not place your order.",
            contentType: "PlainText",
        }],
    },
    sampleUtterances: [
        "I would like to order some flowers",
        "I would like to pick up flowers",
    ],
    slots: [
        {
            description: "The type of flowers to pick up",
            name: "FlowerType",
            priority: 1,
            sampleUtterances: ["I would like to order {FlowerType}"],
            slotConstraint: "Required",
            slotType: "FlowerTypes",
            slotTypeVersion: "$LATEST",
            valueElicitationPrompt: {
                maxAttempts: 2,
                messages: [{
                    content: "What type of flowers would you like to order?",
                    contentType: "PlainText",
                }],
            },
        },
        {
            description: "The date to pick up the flowers",
            name: "PickupDate",
            priority: 2,
            sampleUtterances: ["I would like to order {FlowerType}"],
            slotConstraint: "Required",
            slotType: "AMAZON.DATE",
            slotTypeVersion: "$LATEST",
            valueElicitationPrompt: {
                maxAttempts: 2,
                messages: [{
                    content: "What day do you want the {FlowerType} to be picked up?",
                    contentType: "PlainText",
                }],
            },
        },
        {
            description: "The time to pick up the flowers",
            name: "PickupTime",
            priority: 3,
            sampleUtterances: ["I would like to order {FlowerType}"],
            slotConstraint: "Required",
            slotType: "AMAZON.TIME",
            slotTypeVersion: "$LATEST",
            valueElicitationPrompt: {
                maxAttempts: 2,
                messages: [{
                    content: "Pick up the {FlowerType} at what time on {PickupDate}?",
                    contentType: "PlainText",
                }],
            },
        },
    ],
});
```

</details>

## [*partial failure*] #/resources/aws:sagemaker/humanTaskUI:HumanTaskUI

### HCL

```terraform
resource "aws_sagemaker_human_task_ui" "example" {
  human_task_ui_name = "example"

  ui_template {
    content = file("sagemaker-human-task-ui-template.html")
  }
}

```

### Failed Languages

#### yaml

```text
.pp:3,15-64: Failed to generate YAML program: Unknown Function; YAML does not support Fn::readFile.
```

### Successes

<details>

<summary>typescript</summary>

```typescript
import * as pulumi from "@pulumi/pulumi";
import * as aws from "@pulumi/aws";
import * as fs from "fs";

const example = new aws.sagemaker.HumanTaskUI("example", {
    humanTaskUiName: "example",
    uiTemplate: {
        content: fs.readFileSync("sagemaker-human-task-ui-template.html"),
    },
});
```

</details>

<details>

<summary>python</summary>

```python
import pulumi
import pulumi_aws as aws

example = aws.sagemaker.HumanTaskUI("example",
    human_task_ui_name="example",
    ui_template=aws.sagemaker.HumanTaskUIUiTemplateArgs(
        content=(lambda path: open(path).read())("sagemaker-human-task-ui-template.html"),
    ))
```

</details>

<details>

<summary>csharp</summary>

```csharp
using System.Collections.Generic;
using System.IO;
using Pulumi;
using Aws = Pulumi.Aws;

return await Deployment.RunAsync(() => 
{
    var example = new Aws.Sagemaker.HumanTaskUI("example", new()
    {
        HumanTaskUiName = "example",
        UiTemplate = new Aws.Sagemaker.Inputs.HumanTaskUIUiTemplateArgs
        {
            Content = File.ReadAllText("sagemaker-human-task-ui-template.html"),
        },
    });

});
```

</details>

<details>

<summary>go</summary>

```go
package main

import (
	"io/ioutil"

	"github.com/pulumi/pulumi-aws/sdk/v5/go/aws/sagemaker"
	"github.com/pulumi/pulumi/sdk/v3/go/pulumi"
)

func readFileOrPanic(path string) pulumi.StringPtrInput {
	data, err := ioutil.ReadFile(path)
	if err != nil {
		panic(err.Error())
	}
	return pulumi.String(string(data))
}

func main() {
	pulumi.Run(func(ctx *pulumi.Context) error {
		_, err := sagemaker.NewHumanTaskUI(ctx, "example", &sagemaker.HumanTaskUIArgs{
			HumanTaskUiName: pulumi.String("example"),
			UiTemplate: &sagemaker.HumanTaskUIUiTemplateArgs{
				Content: readFileOrPanic("sagemaker-human-task-ui-template.html"),
			},
		})
		if err != nil {
			return err
		}
		return nil
	})
}
```

</details>

<details>

<summary>java</summary>

```java
package generated_program;

import com.pulumi.Context;
import com.pulumi.Pulumi;
import com.pulumi.core.Output;
import com.pulumi.aws.sagemaker.HumanTaskUI;
import com.pulumi.aws.sagemaker.HumanTaskUIArgs;
import com.pulumi.aws.sagemaker.inputs.HumanTaskUIUiTemplateArgs;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;

public class App {
    public static void main(String[] args) {
        Pulumi.run(App::stack);
    }

    public static void stack(Context ctx) {
        var example = new HumanTaskUI("example", HumanTaskUIArgs.builder()        
            .humanTaskUiName("example")
            .uiTemplate(HumanTaskUIUiTemplateArgs.builder()
                .content(Files.readString(Paths.get("sagemaker-human-task-ui-template.html")))
                .build())
            .build());

    }
}
```

</details>

## [*partial failure*] Basic

### HCL

```terraform
resource "aws_acmpca_certificate" "example" {
  certificate_authority_arn   = aws_acmpca_certificate_authority.example.arn
  certificate_signing_request = tls_cert_request.csr.cert_request_pem
  signing_algorithm           = "SHA256WITHRSA"
  validity {
    type  = "YEARS"
    value = 1
  }
}

resource "aws_acmpca_certificate_authority" "example" {
  private_certificate_configuration {
    key_algorithm     = "RSA_4096"
    signing_algorithm = "SHA512WITHRSA"

    subject {
      common_name = "example.com"
    }
  }

  permanent_deletion_time_in_days = 7
}

resource "tls_private_key" "key" {
  algorithm = "RSA"
}

resource "tls_cert_request" "csr" {
  key_algorithm   = "RSA"
  private_key_pem = tls_private_key.key.private_key_pem

  subject {
    common_name = "example"
  }
}

```

### Failed Languages

#### typescript

```text
:0,0-0: unknown property 'privateCertificateConfiguration' among [revocationConfiguration tags type certificateAuthorityConfiguration enabled permanentDeletionTimeInDays]; 
```

#### python

```text
:0,0-0: unknown property 'privateCertificateConfiguration' among [certificateAuthorityConfiguration enabled permanentDeletionTimeInDays revocationConfiguration tags type]; 
```

#### csharp

```text
:0,0-0: unknown property 'privateCertificateConfiguration' among [permanentDeletionTimeInDays revocationConfiguration tags type certificateAuthorityConfiguration enabled]; 
```

#### go

```text
:0,0-0: unknown property 'privateCertificateConfiguration' among [tags type certificateAuthorityConfiguration enabled permanentDeletionTimeInDays revocationConfiguration]; 
```

### Successes

<details>

<summary>yaml</summary>

```yaml
resources:
  exampleCertificate:
    type: aws:acmpca:Certificate
    properties:
      certificateAuthorityArn: ${exampleCertificateAuthority.arn}
      certificateSigningRequest: ${csr.certRequestPem}
      signingAlgorithm: SHA256WITHRSA
      validity:
        type: YEARS
        value: 1
  exampleCertificateAuthority:
    type: aws:acmpca:CertificateAuthority
    properties:
      privateCertificateConfiguration:
        - keyAlgorithm: RSA_4096
          signingAlgorithm: SHA512WITHRSA
          subject:
            - commonName: example.com
      permanentDeletionTimeInDays: 7
  key:
    type: tls:PrivateKey
    properties:
      algorithm: RSA
  csr:
    type: tls:CertRequest
    properties:
      keyAlgorithm: RSA
      privateKeyPem: ${key.privateKeyPem}
      subjects:
        - commonName: example
```

</details>

<details>

<summary>java</summary>

```java
package generated_program;

import com.pulumi.Context;
import com.pulumi.Pulumi;
import com.pulumi.core.Output;
import com.pulumi.aws.acmpca.CertificateAuthority;
import com.pulumi.aws.acmpca.CertificateAuthorityArgs;
import com.pulumi.tls.PrivateKey;
import com.pulumi.tls.PrivateKeyArgs;
import com.pulumi.tls.CertRequest;
import com.pulumi.tls.CertRequestArgs;
import com.pulumi.tls.inputs.CertRequestSubjectArgs;
import com.pulumi.aws.acmpca.Certificate;
import com.pulumi.aws.acmpca.CertificateArgs;
import com.pulumi.aws.acmpca.inputs.CertificateValidityArgs;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;

public class App {
    public static void main(String[] args) {
        Pulumi.run(App::stack);
    }

    public static void stack(Context ctx) {
        var exampleCertificateAuthority = new CertificateAuthority("exampleCertificateAuthority", CertificateAuthorityArgs.builder()        
            .privateCertificateConfiguration(%!v(PANIC=Format method: runtime error: invalid memory address or nil pointer dereference))
            .permanentDeletionTimeInDays(7)
            .build());

        var key = new PrivateKey("key", PrivateKeyArgs.builder()        
            .algorithm("RSA")
            .build());

        var csr = new CertRequest("csr", CertRequestArgs.builder()        
            .keyAlgorithm("RSA")
            .privateKeyPem(key.privateKeyPem())
            .subjects(CertRequestSubjectArgs.builder()
                .commonName("example")
                .build())
            .build());

        var exampleCertificate = new Certificate("exampleCertificate", CertificateArgs.builder()        
            .certificateAuthorityArn(exampleCertificateAuthority.arn())
            .certificateSigningRequest(csr.certRequestPem())
            .signingAlgorithm("SHA256WITHRSA")
            .validity(CertificateValidityArgs.builder()
                .type("YEARS")
                .value(1)
                .build())
            .build());

    }
}
```

</details>

## [*partial failure*] With Documents Metadata Configuration

### HCL

```terraform
resource "aws_kendra_data_source" "example" {
  index_id = aws_kendra_index.example.id
  name     = "example"
  type     = "S3"
  role_arn = aws_iam_role.example.arn

  configuration {
    s3_configuration {
      bucket_name = aws_s3_bucket.example.id
      s3_prefix   = "example"

      exclusion_patterns = ["example"]
      inclusion_patterns = ["hello"]
      inclusion_prefixes = ["world"]
    }
  }
}

```

### Failed Languages

#### typescript

```text
:0,0-0: unknown property 's3Prefix' among [accessControlListConfiguration bucketName documentsMetadataConfiguration exclusionPatterns inclusionPatterns inclusionPrefixes]; , and 4 other diagnostic(s)
```

#### python

```text
:0,0-0: unknown property 's3Prefix' among [accessControlListConfiguration bucketName documentsMetadataConfiguration exclusionPatterns inclusionPatterns inclusionPrefixes]; , and 4 other diagnostic(s)
```

#### csharp

```text
:0,0-0: unknown property 's3Prefix' among [accessControlListConfiguration bucketName documentsMetadataConfiguration exclusionPatterns inclusionPatterns inclusionPrefixes]; , and 4 other diagnostic(s)
```

#### go

```text
:0,0-0: unknown property 's3Prefix' among [accessControlListConfiguration bucketName documentsMetadataConfiguration exclusionPatterns inclusionPatterns inclusionPrefixes]; , and 4 other diagnostic(s)
```

### Successes

<details>

<summary>yaml</summary>

```yaml
resources:
  example:
    type: aws:kendra:DataSource
    properties:
      indexId: ${aws_kendra_index.example.id}
      type: S3
      roleArn: ${aws_iam_role.example.arn}
      configuration:
        s3Configuration:
          bucketName: ${aws_s3_bucket.example.id}
          s3Prefix: example
          exclusionPatterns:
            - example
          inclusionPatterns:
            - hello
          inclusionPrefixes:
            - world
```

</details>

<details>

<summary>java</summary>

```java
package generated_program;

import com.pulumi.Context;
import com.pulumi.Pulumi;
import com.pulumi.core.Output;
import com.pulumi.aws.kendra.DataSource;
import com.pulumi.aws.kendra.DataSourceArgs;
import com.pulumi.aws.kendra.inputs.DataSourceConfigurationArgs;
import com.pulumi.aws.kendra.inputs.DataSourceConfigurationS3ConfigurationArgs;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;

public class App {
    public static void main(String[] args) {
        Pulumi.run(App::stack);
    }

    public static void stack(Context ctx) {
        var example = new DataSource("example", DataSourceArgs.builder()        
            .indexId(aws_kendra_index.example().id())
            .type("S3")
            .roleArn(aws_iam_role.example().arn())
            .configuration(DataSourceConfigurationArgs.builder()
                .s3Configuration(DataSourceConfigurationS3ConfigurationArgs.builder()
                    .bucketName(aws_s3_bucket.example().id())
                    .s3Prefix("example")
                    .exclusionPatterns("example")
                    .inclusionPatterns("hello")
                    .inclusionPrefixes("world")
                    .build())
                .build())
            .build());

    }
}
```

</details>

## [**complete failure**] Basic Authorization

### HCL

```terraform
resource "aws_amplify_app" "example" {
  name = "example"

  enable_basic_auth      = true
  basic_auth_credentials = base64encode("username1:password1")
}

```

### Failed Languages

#### go

```text
:4,28-40: unknown function 'base64encode'; , and 1 other diagnostic(s)
```

#### yaml

```text
:4,28-40: unknown function 'base64encode'; , and 1 other diagnostic(s)
```

#### java

```text
:4,28-40: unknown function 'base64encode'; , and 1 other diagnostic(s)
```

#### typescript

```text
:4,28-40: unknown function 'base64encode'; , and 1 other diagnostic(s)
```

#### python

```text
:4,28-40: unknown function 'base64encode'; , and 1 other diagnostic(s)
```

#### csharp

```text
:4,28-40: unknown function 'base64encode'; , and 1 other diagnostic(s)
```

## [*partial failure*] #/resources/aws:fsx/lustreFileSystem:LustreFileSystem

### HCL

```terraform
resource "aws_fsx_lustre_file_system" "example" {
  import_path      = "s3://${aws_s3_bucket.example.bucket}"
  storage_capacity = 1200
  subnet_ids       = [aws_subnet.example.id]
}

```

### Failed Languages

#### python

```text
:0,0-0: cannot traverse value of type string; , and 2 other diagnostic(s)
```

#### csharp

```text
:0,0-0: cannot traverse value of type string; , and 2 other diagnostic(s)
```

#### go

```text
:0,0-0: cannot traverse value of type string; , and 2 other diagnostic(s)
```

#### typescript

```text
:0,0-0: cannot traverse value of type string; , and 2 other diagnostic(s)
```

### Successes

<details>

<summary>yaml</summary>

```yaml
resources:
  example:
    type: aws:fsx:LustreFileSystem
    properties:
      importPath: s3://${aws_s3_bucket.example.bucket}
      storageCapacity: 1200
      subnetIds:
        - ${aws_subnet.example.id}
```

</details>

<details>

<summary>java</summary>

```java
package generated_program;

import com.pulumi.Context;
import com.pulumi.Pulumi;
import com.pulumi.core.Output;
import com.pulumi.aws.fsx.LustreFileSystem;
import com.pulumi.aws.fsx.LustreFileSystemArgs;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;

public class App {
    public static void main(String[] args) {
        Pulumi.run(App::stack);
    }

    public static void stack(Context ctx) {
        var example = new LustreFileSystem("example", LustreFileSystemArgs.builder()        
            .importPath(String.format("s3://%s", aws_s3_bucket.example().bucket()))
            .storageCapacity(1200)
            .subnetIds(aws_subnet.example().id())
            .build());

    }
}
```

</details>

## [*partial failure*] #/resources/aws:iam/samlProvider:SamlProvider

### HCL

```terraform
resource "aws_iam_saml_provider" "default" {
  name                   = "myprovider"
  saml_metadata_document = file("saml-metadata.xml")
}

```

### Failed Languages

#### yaml

```text
.pp:1,26-55: Failed to generate YAML program: Unknown Function; YAML does not support Fn::readFile.
```

### Successes

<details>

<summary>csharp</summary>

```csharp
using System.Collections.Generic;
using System.IO;
using Pulumi;
using Aws = Pulumi.Aws;

return await Deployment.RunAsync(() => 
{
    var @default = new Aws.Iam.SamlProvider("default", new()
    {
        SamlMetadataDocument = File.ReadAllText("saml-metadata.xml"),
    });

});
```

</details>

<details>

<summary>go</summary>

```go
package main

import (
	"io/ioutil"

	"github.com/pulumi/pulumi-aws/sdk/v5/go/aws/iam"
	"github.com/pulumi/pulumi/sdk/v3/go/pulumi"
)

func readFileOrPanic(path string) pulumi.StringPtrInput {
	data, err := ioutil.ReadFile(path)
	if err != nil {
		panic(err.Error())
	}
	return pulumi.String(string(data))
}

func main() {
	pulumi.Run(func(ctx *pulumi.Context) error {
		_, err := iam.NewSamlProvider(ctx, "default", &iam.SamlProviderArgs{
			SamlMetadataDocument: readFileOrPanic("saml-metadata.xml"),
		})
		if err != nil {
			return err
		}
		return nil
	})
}
```

</details>

<details>

<summary>java</summary>

```java
package generated_program;

import com.pulumi.Context;
import com.pulumi.Pulumi;
import com.pulumi.core.Output;
import com.pulumi.aws.iam.SamlProvider;
import com.pulumi.aws.iam.SamlProviderArgs;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;

public class App {
    public static void main(String[] args) {
        Pulumi.run(App::stack);
    }

    public static void stack(Context ctx) {
        var default_ = new SamlProvider("default", SamlProviderArgs.builder()        
            .samlMetadataDocument(Files.readString(Paths.get("saml-metadata.xml")))
            .build());

    }
}
```

</details>

<details>

<summary>typescript</summary>

```typescript
import * as pulumi from "@pulumi/pulumi";
import * as aws from "@pulumi/aws";
import * as fs from "fs";

const _default = new aws.iam.SamlProvider("default", {samlMetadataDocument: fs.readFileSync("saml-metadata.xml")});
```

</details>

<details>

<summary>python</summary>

```python
import pulumi
import pulumi_aws as aws

default = aws.iam.SamlProvider("default", saml_metadata_document=(lambda path: open(path).read())("saml-metadata.xml"))
```

</details>

## [*partial failure*] #/resources/aws:workspaces/directory:Directory

### HCL

```terraform
resource "aws_workspaces_directory" "example" {
  directory_id = aws_directory_service_directory.example.id
  subnet_ids = [
    aws_subnet.example_c.id,
    aws_subnet.example_d.id
  ]

  tags = {
    Example = true
  }

  self_service_permissions {
    change_compute_type  = true
    increase_volume_size = true
    rebuild_workspace    = true
    restart_workspace    = true
    switch_running_mode  = true
  }

  workspace_access_properties {
    device_type_android    = "ALLOW"
    device_type_chromeos   = "ALLOW"
    device_type_ios        = "ALLOW"
    device_type_linux      = "DENY"
    device_type_osx        = "ALLOW"
    device_type_web        = "DENY"
    device_type_windows    = "DENY"
    device_type_zeroclient = "DENY"
  }

  workspace_creation_properties {
    custom_security_group_id            = aws_security_group.example.id
    default_ou                          = "OU=AWS,DC=Workgroup,DC=Example,DC=com"
    enable_internet_access              = true
    enable_maintenance_mode             = true
    user_enabled_as_local_administrator = true
  }

  depends_on = [
    aws_iam_role_policy_attachment.workspaces_default_service_access,
    aws_iam_role_policy_attachment.workspaces_default_self_service_access
  ]
}

resource "aws_directory_service_directory" "example" {
  name     = "corp.example.com"
  password = "#S1ncerely"
  size     = "Small"

  vpc_settings {
    vpc_id = aws_vpc.example.id
    subnet_ids = [
      aws_subnet.example_a.id,
      aws_subnet.example_b.id
    ]
  }
}

data "aws_iam_policy_document" "workspaces" {
  statement {
    actions = ["sts:AssumeRole"]

    principals {
      type        = "Service"
      identifiers = ["workspaces.amazonaws.com"]
    }
  }
}

resource "aws_iam_role" "workspaces_default" {
  name               = "workspaces_DefaultRole"
  assume_role_policy = data.aws_iam_policy_document.workspaces.json
}

resource "aws_iam_role_policy_attachment" "workspaces_default_service_access" {
  role       = aws_iam_role.workspaces_default.name
  policy_arn = "arn:aws:iam::aws:policy/AmazonWorkSpacesServiceAccess"
}

resource "aws_iam_role_policy_attachment" "workspaces_default_self_service_access" {
  role       = aws_iam_role.workspaces_default.name
  policy_arn = "arn:aws:iam::aws:policy/AmazonWorkSpacesSelfServiceAccess"
}

resource "aws_vpc" "example" {
  cidr_block = "10.0.0.0/16"
}

resource "aws_subnet" "example_a" {
  vpc_id            = aws_vpc.example.id
  availability_zone = "us-east-1a"
  cidr_block        = "10.0.0.0/24"
}

resource "aws_subnet" "example_b" {
  vpc_id            = aws_vpc.example.id
  availability_zone = "us-east-1b"
  cidr_block        = "10.0.1.0/24"
}
resource "aws_subnet" "example_c" {
  vpc_id            = aws_vpc.example.id
  availability_zone = "us-east-1c"
  cidr_block        = "10.0.2.0/24"
}

resource "aws_subnet" "example_d" {
  vpc_id            = aws_vpc.example.id
  availability_zone = "us-east-1d"
  cidr_block        = "10.0.3.0/24"
}

```

### Failed Languages

#### yaml

```text
.pp:1,17-62: Failed to generate YAML program: *model.BinaryOpExpression; Unimplemented! Needed for  exampleDirectoryservice/directoryDirectory.id

```

### Successes

<details>

<summary>typescript</summary>

```typescript
import * as pulumi from "@pulumi/pulumi";
import * as aws from "@pulumi/aws";

const workspaces = aws.iam.getPolicyDocument({
    statements: [{
        actions: ["sts:AssumeRole"],
        principals: [{
            type: "Service",
            identifiers: ["workspaces.amazonaws.com"],
        }],
    }],
});
const workspacesDefault = new aws.iam.Role("workspacesDefault", {assumeRolePolicy: workspaces.then(workspaces => workspaces.json)});
const workspacesDefaultServiceAccess = new aws.iam.RolePolicyAttachment("workspacesDefaultServiceAccess", {
    role: workspacesDefault.name,
    policyArn: "arn:aws:iam::aws:policy/AmazonWorkSpacesServiceAccess",
});
const workspacesDefaultSelfServiceAccess = new aws.iam.RolePolicyAttachment("workspacesDefaultSelfServiceAccess", {
    role: workspacesDefault.name,
    policyArn: "arn:aws:iam::aws:policy/AmazonWorkSpacesSelfServiceAccess",
});
const exampleVpc = new aws.ec2.Vpc("exampleVpc", {cidrBlock: "10.0.0.0/16"});
const exampleC = new aws.ec2.Subnet("exampleC", {
    vpcId: exampleVpc.id,
    availabilityZone: "us-east-1c",
    cidrBlock: "10.0.2.0/24",
});
const exampleD = new aws.ec2.Subnet("exampleD", {
    vpcId: exampleVpc.id,
    availabilityZone: "us-east-1d",
    cidrBlock: "10.0.3.0/24",
});
const exampleDirectory = new aws.workspaces.Directory("exampleDirectory", {
    directoryId: exampleDirectoryservice / directoryDirectory.id,
    subnetIds: [
        exampleC.id,
        exampleD.id,
    ],
    tags: {
        Example: "true",
    },
    selfServicePermissions: {
        changeComputeType: true,
        increaseVolumeSize: true,
        rebuildWorkspace: true,
        restartWorkspace: true,
        switchRunningMode: true,
    },
    workspaceAccessProperties: {
        deviceTypeAndroid: "ALLOW",
        deviceTypeChromeos: "ALLOW",
        deviceTypeIos: "ALLOW",
        deviceTypeLinux: "DENY",
        deviceTypeOsx: "ALLOW",
        deviceTypeWeb: "DENY",
        deviceTypeWindows: "DENY",
        deviceTypeZeroclient: "DENY",
    },
    workspaceCreationProperties: {
        customSecurityGroupId: aws_security_group.example.id,
        defaultOu: "OU=AWS,DC=Workgroup,DC=Example,DC=com",
        enableInternetAccess: true,
        enableMaintenanceMode: true,
        userEnabledAsLocalAdministrator: true,
    },
}, {
    dependsOn: [
        workspacesDefaultServiceAccess,
        workspacesDefaultSelfServiceAccess,
    ],
});
const exampleA = new aws.ec2.Subnet("exampleA", {
    vpcId: exampleVpc.id,
    availabilityZone: "us-east-1a",
    cidrBlock: "10.0.0.0/24",
});
const exampleB = new aws.ec2.Subnet("exampleB", {
    vpcId: exampleVpc.id,
    availabilityZone: "us-east-1b",
    cidrBlock: "10.0.1.0/24",
});
const exampleDirectoryservice_directoryDirectory = new aws.directoryservice.Directory("exampleDirectoryservice/directoryDirectory", {
    name: "corp.example.com",
    password: "#S1ncerely",
    size: "Small",
    vpcSettings: {
        vpcId: exampleVpc.id,
        subnetIds: [
            exampleA.id,
            exampleB.id,
        ],
    },
});
```

</details>

<details>

<summary>python</summary>

```python
import pulumi
import pulumi_aws as aws

workspaces = aws.iam.get_policy_document(statements=[aws.iam.GetPolicyDocumentStatementArgs(
    actions=["sts:AssumeRole"],
    principals=[aws.iam.GetPolicyDocumentStatementPrincipalArgs(
        type="Service",
        identifiers=["workspaces.amazonaws.com"],
    )],
)])
workspaces_default = aws.iam.Role("workspacesDefault", assume_role_policy=workspaces.json)
workspaces_default_service_access = aws.iam.RolePolicyAttachment("workspacesDefaultServiceAccess",
    role=workspaces_default.name,
    policy_arn="arn:aws:iam::aws:policy/AmazonWorkSpacesServiceAccess")
workspaces_default_self_service_access = aws.iam.RolePolicyAttachment("workspacesDefaultSelfServiceAccess",
    role=workspaces_default.name,
    policy_arn="arn:aws:iam::aws:policy/AmazonWorkSpacesSelfServiceAccess")
example_vpc = aws.ec2.Vpc("exampleVpc", cidr_block="10.0.0.0/16")
example_c = aws.ec2.Subnet("exampleC",
    vpc_id=example_vpc.id,
    availability_zone="us-east-1c",
    cidr_block="10.0.2.0/24")
example_d = aws.ec2.Subnet("exampleD",
    vpc_id=example_vpc.id,
    availability_zone="us-east-1d",
    cidr_block="10.0.3.0/24")
example_directory = aws.workspaces.Directory("exampleDirectory",
    directory_id=example_directoryservice / directory_directory["id"],
    subnet_ids=[
        example_c.id,
        example_d.id,
    ],
    tags={
        "Example": "true",
    },
    self_service_permissions=aws.workspaces.DirectorySelfServicePermissionsArgs(
        change_compute_type=True,
        increase_volume_size=True,
        rebuild_workspace=True,
        restart_workspace=True,
        switch_running_mode=True,
    ),
    workspace_access_properties=aws.workspaces.DirectoryWorkspaceAccessPropertiesArgs(
        device_type_android="ALLOW",
        device_type_chromeos="ALLOW",
        device_type_ios="ALLOW",
        device_type_linux="DENY",
        device_type_osx="ALLOW",
        device_type_web="DENY",
        device_type_windows="DENY",
        device_type_zeroclient="DENY",
    ),
    workspace_creation_properties=aws.workspaces.DirectoryWorkspaceCreationPropertiesArgs(
        custom_security_group_id=aws_security_group["example"]["id"],
        default_ou="OU=AWS,DC=Workgroup,DC=Example,DC=com",
        enable_internet_access=True,
        enable_maintenance_mode=True,
        user_enabled_as_local_administrator=True,
    ),
    opts=pulumi.ResourceOptions(depends_on=[
            workspaces_default_service_access,
            workspaces_default_self_service_access,
        ]))
example_a = aws.ec2.Subnet("exampleA",
    vpc_id=example_vpc.id,
    availability_zone="us-east-1a",
    cidr_block="10.0.0.0/24")
example_b = aws.ec2.Subnet("exampleB",
    vpc_id=example_vpc.id,
    availability_zone="us-east-1b",
    cidr_block="10.0.1.0/24")
example_directoryservice_directory_directory = aws.directoryservice.Directory("exampleDirectoryservice/directoryDirectory",
    name="corp.example.com",
    password="#S1ncerely",
    size="Small",
    vpc_settings=aws.directoryservice.DirectoryVpcSettingsArgs(
        vpc_id=example_vpc.id,
        subnet_ids=[
            example_a.id,
            example_b.id,
        ],
    ))
```

</details>

<details>

<summary>csharp</summary>

```csharp
using System.Collections.Generic;
using Pulumi;
using Aws = Pulumi.Aws;

return await Deployment.RunAsync(() => 
{
    var workspaces = Aws.Iam.GetPolicyDocument.Invoke(new()
    {
        Statements = new[]
        {
            new Aws.Iam.Inputs.GetPolicyDocumentStatementInputArgs
            {
                Actions = new[]
                {
                    "sts:AssumeRole",
                },
                Principals = new[]
                {
                    new Aws.Iam.Inputs.GetPolicyDocumentStatementPrincipalInputArgs
                    {
                        Type = "Service",
                        Identifiers = new[]
                        {
                            "workspaces.amazonaws.com",
                        },
                    },
                },
            },
        },
    });

    var workspacesDefault = new Aws.Iam.Role("workspacesDefault", new()
    {
        AssumeRolePolicy = workspaces.Apply(getPolicyDocumentResult => getPolicyDocumentResult.Json),
    });

    var workspacesDefaultServiceAccess = new Aws.Iam.RolePolicyAttachment("workspacesDefaultServiceAccess", new()
    {
        Role = workspacesDefault.Name,
        PolicyArn = "arn:aws:iam::aws:policy/AmazonWorkSpacesServiceAccess",
    });

    var workspacesDefaultSelfServiceAccess = new Aws.Iam.RolePolicyAttachment("workspacesDefaultSelfServiceAccess", new()
    {
        Role = workspacesDefault.Name,
        PolicyArn = "arn:aws:iam::aws:policy/AmazonWorkSpacesSelfServiceAccess",
    });

    var exampleVpc = new Aws.Ec2.Vpc("exampleVpc", new()
    {
        CidrBlock = "10.0.0.0/16",
    });

    var exampleC = new Aws.Ec2.Subnet("exampleC", new()
    {
        VpcId = exampleVpc.Id,
        AvailabilityZone = "us-east-1c",
        CidrBlock = "10.0.2.0/24",
    });

    var exampleD = new Aws.Ec2.Subnet("exampleD", new()
    {
        VpcId = exampleVpc.Id,
        AvailabilityZone = "us-east-1d",
        CidrBlock = "10.0.3.0/24",
    });

    var exampleDirectory = new Aws.Workspaces.Directory("exampleDirectory", new()
    {
        DirectoryId = exampleDirectoryservice / directoryDirectory.Id,
        SubnetIds = new[]
        {
            exampleC.Id,
            exampleD.Id,
        },
        Tags = 
        {
            { "Example", "true" },
        },
        SelfServicePermissions = new Aws.Workspaces.Inputs.DirectorySelfServicePermissionsArgs
        {
            ChangeComputeType = true,
            IncreaseVolumeSize = true,
            RebuildWorkspace = true,
            RestartWorkspace = true,
            SwitchRunningMode = true,
        },
        WorkspaceAccessProperties = new Aws.Workspaces.Inputs.DirectoryWorkspaceAccessPropertiesArgs
        {
            DeviceTypeAndroid = "ALLOW",
            DeviceTypeChromeos = "ALLOW",
            DeviceTypeIos = "ALLOW",
            DeviceTypeLinux = "DENY",
            DeviceTypeOsx = "ALLOW",
            DeviceTypeWeb = "DENY",
            DeviceTypeWindows = "DENY",
            DeviceTypeZeroclient = "DENY",
        },
        WorkspaceCreationProperties = new Aws.Workspaces.Inputs.DirectoryWorkspaceCreationPropertiesArgs
        {
            CustomSecurityGroupId = aws_security_group.Example.Id,
            DefaultOu = "OU=AWS,DC=Workgroup,DC=Example,DC=com",
            EnableInternetAccess = true,
            EnableMaintenanceMode = true,
            UserEnabledAsLocalAdministrator = true,
        },
    }, new CustomResourceOptions
    {
        DependsOn = new[]
        {
            workspacesDefaultServiceAccess,
            workspacesDefaultSelfServiceAccess,
        },
    });

    var exampleA = new Aws.Ec2.Subnet("exampleA", new()
    {
        VpcId = exampleVpc.Id,
        AvailabilityZone = "us-east-1a",
        CidrBlock = "10.0.0.0/24",
    });

    var exampleB = new Aws.Ec2.Subnet("exampleB", new()
    {
        VpcId = exampleVpc.Id,
        AvailabilityZone = "us-east-1b",
        CidrBlock = "10.0.1.0/24",
    });

    var exampleDirectoryservice_directoryDirectory = new Aws.DirectoryService.Directory("exampleDirectoryservice/directoryDirectory", new()
    {
        Name = "corp.example.com",
        Password = "#S1ncerely",
        Size = "Small",
        VpcSettings = new Aws.DirectoryService.Inputs.DirectoryVpcSettingsArgs
        {
            VpcId = exampleVpc.Id,
            SubnetIds = new[]
            {
                exampleA.Id,
                exampleB.Id,
            },
        },
    });

});
```

</details>

<details>

<summary>go</summary>

```go
package main

import (
	"github.com/pulumi/pulumi-aws/sdk/v5/go/aws/directoryservice"
	"github.com/pulumi/pulumi-aws/sdk/v5/go/aws/ec2"
	"github.com/pulumi/pulumi-aws/sdk/v5/go/aws/iam"
	"github.com/pulumi/pulumi-aws/sdk/v5/go/aws/workspaces"
	"github.com/pulumi/pulumi/sdk/v3/go/pulumi"
)

func main() {
	pulumi.Run(func(ctx *pulumi.Context) error {
		workspaces, err := iam.GetPolicyDocument(ctx, &iam.GetPolicyDocumentArgs{
			Statements: []iam.GetPolicyDocumentStatement{
				iam.GetPolicyDocumentStatement{
					Actions: []string{
						"sts:AssumeRole",
					},
					Principals: []iam.GetPolicyDocumentStatementPrincipal{
						iam.GetPolicyDocumentStatementPrincipal{
							Type: "Service",
							Identifiers: []string{
								"workspaces.amazonaws.com",
							},
						},
					},
				},
			},
		}, nil)
		if err != nil {
			return err
		}
		workspacesDefault, err := iam.NewRole(ctx, "workspacesDefault", &iam.RoleArgs{
			AssumeRolePolicy: pulumi.String(workspaces.Json),
		})
		if err != nil {
			return err
		}
		workspacesDefaultServiceAccess, err := iam.NewRolePolicyAttachment(ctx, "workspacesDefaultServiceAccess", &iam.RolePolicyAttachmentArgs{
			Role:      workspacesDefault.Name,
			PolicyArn: pulumi.String("arn:aws:iam::aws:policy/AmazonWorkSpacesServiceAccess"),
		})
		if err != nil {
			return err
		}
		workspacesDefaultSelfServiceAccess, err := iam.NewRolePolicyAttachment(ctx, "workspacesDefaultSelfServiceAccess", &iam.RolePolicyAttachmentArgs{
			Role:      workspacesDefault.Name,
			PolicyArn: pulumi.String("arn:aws:iam::aws:policy/AmazonWorkSpacesSelfServiceAccess"),
		})
		if err != nil {
			return err
		}
		exampleVpc, err := ec2.NewVpc(ctx, "exampleVpc", &ec2.VpcArgs{
			CidrBlock: pulumi.String("10.0.0.0/16"),
		})
		if err != nil {
			return err
		}
		exampleC, err := ec2.NewSubnet(ctx, "exampleC", &ec2.SubnetArgs{
			VpcId:            exampleVpc.ID(),
			AvailabilityZone: pulumi.String("us-east-1c"),
			CidrBlock:        pulumi.String("10.0.2.0/24"),
		})
		if err != nil {
			return err
		}
		exampleD, err := ec2.NewSubnet(ctx, "exampleD", &ec2.SubnetArgs{
			VpcId:            exampleVpc.ID(),
			AvailabilityZone: pulumi.String("us-east-1d"),
			CidrBlock:        pulumi.String("10.0.3.0/24"),
		})
		if err != nil {
			return err
		}
		_, err = workspaces.NewDirectory(ctx, "exampleDirectory", &workspaces.DirectoryArgs{
			DirectoryId: exampleDirectoryservice / directoryDirectory.Id,
			SubnetIds: pulumi.StringArray{
				exampleC.ID(),
				exampleD.ID(),
			},
			Tags: pulumi.StringMap{
				"Example": pulumi.String("true"),
			},
			SelfServicePermissions: &workspaces.DirectorySelfServicePermissionsArgs{
				ChangeComputeType:  pulumi.Bool(true),
				IncreaseVolumeSize: pulumi.Bool(true),
				RebuildWorkspace:   pulumi.Bool(true),
				RestartWorkspace:   pulumi.Bool(true),
				SwitchRunningMode:  pulumi.Bool(true),
			},
			WorkspaceAccessProperties: &workspaces.DirectoryWorkspaceAccessPropertiesArgs{
				DeviceTypeAndroid:    pulumi.String("ALLOW"),
				DeviceTypeChromeos:   pulumi.String("ALLOW"),
				DeviceTypeIos:        pulumi.String("ALLOW"),
				DeviceTypeLinux:      pulumi.String("DENY"),
				DeviceTypeOsx:        pulumi.String("ALLOW"),
				DeviceTypeWeb:        pulumi.String("DENY"),
				DeviceTypeWindows:    pulumi.String("DENY"),
				DeviceTypeZeroclient: pulumi.String("DENY"),
			},
			WorkspaceCreationProperties: &workspaces.DirectoryWorkspaceCreationPropertiesArgs{
				CustomSecurityGroupId:           pulumi.Any(aws_security_group.Example.Id),
				DefaultOu:                       pulumi.String("OU=AWS,DC=Workgroup,DC=Example,DC=com"),
				EnableInternetAccess:            pulumi.Bool(true),
				EnableMaintenanceMode:           pulumi.Bool(true),
				UserEnabledAsLocalAdministrator: pulumi.Bool(true),
			},
		}, pulumi.DependsOn([]pulumi.Resource{
			workspacesDefaultServiceAccess,
			workspacesDefaultSelfServiceAccess,
		}))
		if err != nil {
			return err
		}
		exampleA, err := ec2.NewSubnet(ctx, "exampleA", &ec2.SubnetArgs{
			VpcId:            exampleVpc.ID(),
			AvailabilityZone: pulumi.String("us-east-1a"),
			CidrBlock:        pulumi.String("10.0.0.0/24"),
		})
		if err != nil {
			return err
		}
		exampleB, err := ec2.NewSubnet(ctx, "exampleB", &ec2.SubnetArgs{
			VpcId:            exampleVpc.ID(),
			AvailabilityZone: pulumi.String("us-east-1b"),
			CidrBlock:        pulumi.String("10.0.1.0/24"),
		})
		if err != nil {
			return err
		}
		_, err = directoryservice.NewDirectory(ctx, "exampleDirectoryservice/directoryDirectory", &directoryservice.DirectoryArgs{
			Name:     pulumi.String("corp.example.com"),
			Password: pulumi.String("#S1ncerely"),
			Size:     pulumi.String("Small"),
			VpcSettings: &directoryservice.DirectoryVpcSettingsArgs{
				VpcId: exampleVpc.ID(),
				SubnetIds: pulumi.StringArray{
					exampleA.ID(),
					exampleB.ID(),
				},
			},
		})
		if err != nil {
			return err
		}
		return nil
	})
}
```

</details>

<details>

<summary>java</summary>

```java
package generated_program;

import com.pulumi.Context;
import com.pulumi.Pulumi;
import com.pulumi.core.Output;
import com.pulumi.aws.iam.IamFunctions;
import com.pulumi.aws.iam.inputs.GetPolicyDocumentArgs;
import com.pulumi.aws.iam.Role;
import com.pulumi.aws.iam.RoleArgs;
import com.pulumi.aws.iam.RolePolicyAttachment;
import com.pulumi.aws.iam.RolePolicyAttachmentArgs;
import com.pulumi.aws.ec2.Vpc;
import com.pulumi.aws.ec2.VpcArgs;
import com.pulumi.aws.ec2.Subnet;
import com.pulumi.aws.ec2.SubnetArgs;
import com.pulumi.aws.workspaces.Directory;
import com.pulumi.aws.workspaces.DirectoryArgs;
import com.pulumi.aws.workspaces.inputs.DirectorySelfServicePermissionsArgs;
import com.pulumi.aws.workspaces.inputs.DirectoryWorkspaceAccessPropertiesArgs;
import com.pulumi.aws.workspaces.inputs.DirectoryWorkspaceCreationPropertiesArgs;
import com.pulumi.aws.directoryservice.Directory;
import com.pulumi.aws.directoryservice.DirectoryArgs;
import com.pulumi.aws.directoryservice.inputs.DirectoryVpcSettingsArgs;
import com.pulumi.resources.CustomResourceOptions;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;

public class App {
    public static void main(String[] args) {
        Pulumi.run(App::stack);
    }

    public static void stack(Context ctx) {
        final var workspaces = IamFunctions.getPolicyDocument(GetPolicyDocumentArgs.builder()
            .statements(GetPolicyDocumentStatementArgs.builder()
                .actions("sts:AssumeRole")
                .principals(GetPolicyDocumentStatementPrincipalArgs.builder()
                    .type("Service")
                    .identifiers("workspaces.amazonaws.com")
                    .build())
                .build())
            .build());

        var workspacesDefault = new Role("workspacesDefault", RoleArgs.builder()        
            .assumeRolePolicy(workspaces.applyValue(getPolicyDocumentResult -> getPolicyDocumentResult.json()))
            .build());

        var workspacesDefaultServiceAccess = new RolePolicyAttachment("workspacesDefaultServiceAccess", RolePolicyAttachmentArgs.builder()        
            .role(workspacesDefault.name())
            .policyArn("arn:aws:iam::aws:policy/AmazonWorkSpacesServiceAccess")
            .build());

        var workspacesDefaultSelfServiceAccess = new RolePolicyAttachment("workspacesDefaultSelfServiceAccess", RolePolicyAttachmentArgs.builder()        
            .role(workspacesDefault.name())
            .policyArn("arn:aws:iam::aws:policy/AmazonWorkSpacesSelfServiceAccess")
            .build());

        var exampleVpc = new Vpc("exampleVpc", VpcArgs.builder()        
            .cidrBlock("10.0.0.0/16")
            .build());

        var exampleC = new Subnet("exampleC", SubnetArgs.builder()        
            .vpcId(exampleVpc.id())
            .availabilityZone("us-east-1c")
            .cidrBlock("10.0.2.0/24")
            .build());

        var exampleD = new Subnet("exampleD", SubnetArgs.builder()        
            .vpcId(exampleVpc.id())
            .availabilityZone("us-east-1d")
            .cidrBlock("10.0.3.0/24")
            .build());

        var exampleDirectory = new Directory("exampleDirectory", DirectoryArgs.builder()        
            .directoryId(exampleDirectoryservice / directoryDirectory.id())
            .subnetIds(            
                exampleC.id(),
                exampleD.id())
            .tags(Map.of("Example", true))
            .selfServicePermissions(DirectorySelfServicePermissionsArgs.builder()
                .changeComputeType(true)
                .increaseVolumeSize(true)
                .rebuildWorkspace(true)
                .restartWorkspace(true)
                .switchRunningMode(true)
                .build())
            .workspaceAccessProperties(DirectoryWorkspaceAccessPropertiesArgs.builder()
                .deviceTypeAndroid("ALLOW")
                .deviceTypeChromeos("ALLOW")
                .deviceTypeIos("ALLOW")
                .deviceTypeLinux("DENY")
                .deviceTypeOsx("ALLOW")
                .deviceTypeWeb("DENY")
                .deviceTypeWindows("DENY")
                .deviceTypeZeroclient("DENY")
                .build())
            .workspaceCreationProperties(DirectoryWorkspaceCreationPropertiesArgs.builder()
                .customSecurityGroupId(aws_security_group.example().id())
                .defaultOu("OU=AWS,DC=Workgroup,DC=Example,DC=com")
                .enableInternetAccess(true)
                .enableMaintenanceMode(true)
                .userEnabledAsLocalAdministrator(true)
                .build())
            .build(), CustomResourceOptions.builder()
                .dependsOn(                
                    workspacesDefaultServiceAccess,
                    workspacesDefaultSelfServiceAccess)
                .build());

        var exampleA = new Subnet("exampleA", SubnetArgs.builder()        
            .vpcId(exampleVpc.id())
            .availabilityZone("us-east-1a")
            .cidrBlock("10.0.0.0/24")
            .build());

        var exampleB = new Subnet("exampleB", SubnetArgs.builder()        
            .vpcId(exampleVpc.id())
            .availabilityZone("us-east-1b")
            .cidrBlock("10.0.1.0/24")
            .build());

        var exampleDirectoryservice_directoryDirectory = new Directory("exampleDirectoryservice/directoryDirectory", DirectoryArgs.builder()        
            .name("corp.example.com")
            .password("#S1ncerely")
            .size("Small")
            .vpcSettings(DirectoryVpcSettingsArgs.builder()
                .vpcId(exampleVpc.id())
                .subnetIds(                
                    exampleA.id(),
                    exampleB.id())
                .build())
            .build());

    }
}
```

</details>

## [*partial failure*] #/resources/aws:ses/domainDkim:DomainDkim

### HCL

```terraform
resource "aws_ses_domain_identity" "example" {
  domain = "example.com"
}

resource "aws_ses_domain_dkim" "example" {
  domain = aws_ses_domain_identity.example.domain
}

resource "aws_route53_record" "example_amazonses_dkim_record" {
  count   = 3
  zone_id = "ABCDEFGHIJ123"
  name    = "${element(aws_ses_domain_dkim.example.dkim_tokens, count.index)}._domainkey"
  type    = "CNAME"
  ttl     = "600"
  records = ["${element(aws_ses_domain_dkim.example.dkim_tokens, count.index)}.dkim.amazonses.com"]
}

```

### Failed Languages

#### go

```text
<nil>: not yet implemented: element; not yet implemented: element, and 1 other diagnostic(s)
```

### Successes

<details>

<summary>yaml</summary>

```yaml
resources:
  exampleDomainIdentity:
    type: aws:ses:DomainIdentity
    properties:
      domain: example.com
  exampleDomainDkim:
    type: aws:ses:DomainDkim
    properties:
      domain: ${exampleDomainIdentity.domain}
  exampleAmazonsesDkimRecord:
    type: aws:route53:Record
    properties:
      zoneId: ABCDEFGHIJ123
      name:
        Fn::Join:
          -
          - - Fn::Select:
                - ${range.value}
                - ${exampleDomainDkim.dkimTokens}
            - ._domainkey
      type: CNAME
      ttl: 600
      records:
        - Fn::Join:
            -
            - - Fn::Select:
                  - ${range.value}
                  - ${exampleDomainDkim.dkimTokens}
              - .dkim.amazonses.com
    options: {}
```

</details>

<details>

<summary>java</summary>

```java
package generated_program;

import com.pulumi.Context;
import com.pulumi.Pulumi;
import com.pulumi.core.Output;
import com.pulumi.aws.ses.DomainIdentity;
import com.pulumi.aws.ses.DomainIdentityArgs;
import com.pulumi.aws.ses.DomainDkim;
import com.pulumi.aws.ses.DomainDkimArgs;
import com.pulumi.aws.route53.Record;
import com.pulumi.aws.route53.RecordArgs;
import com.pulumi.codegen.internal.KeyedValue;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;

public class App {
    public static void main(String[] args) {
        Pulumi.run(App::stack);
    }

    public static void stack(Context ctx) {
        var exampleDomainIdentity = new DomainIdentity("exampleDomainIdentity", DomainIdentityArgs.builder()        
            .domain("example.com")
            .build());

        var exampleDomainDkim = new DomainDkim("exampleDomainDkim", DomainDkimArgs.builder()        
            .domain(exampleDomainIdentity.domain())
            .build());

        for (var i = 0; i < 3; i++) {
            new Record("exampleAmazonsesDkimRecord-" + i, RecordArgs.builder()            
                .zoneId("ABCDEFGHIJ123")
                .name(exampleDomainDkim.dkimTokens()[range.value()].applyValue(dkimTokens -> String.format("%s._domainkey", dkimTokens)))
                .type("CNAME")
                .ttl("600")
                .records(exampleDomainDkim.dkimTokens()[range.value()].applyValue(dkimTokens -> String.format("%s.dkim.amazonses.com", dkimTokens)))
                .build());

        
}
    }
}
```

</details>

<details>

<summary>typescript</summary>

```typescript
import * as pulumi from "@pulumi/pulumi";
import * as aws from "@pulumi/aws";

const exampleDomainIdentity = new aws.ses.DomainIdentity("exampleDomainIdentity", {domain: "example.com"});
const exampleDomainDkim = new aws.ses.DomainDkim("exampleDomainDkim", {domain: exampleDomainIdentity.domain});
const exampleAmazonsesDkimRecord: aws.route53.Record[];
for (const range = {value: 0}; range.value < 3; range.value++) {
    exampleAmazonsesDkimRecord.push(new aws.route53.Record(`exampleAmazonsesDkimRecord-${range.value}`, {
        zoneId: "ABCDEFGHIJ123",
        name: exampleDomainDkim.dkimTokens[range.value].apply(dkimTokens => `${dkimTokens}._domainkey`),
        type: "CNAME",
        ttl: 600,
        records: [exampleDomainDkim.dkimTokens[range.value].apply(dkimTokens => `${dkimTokens}.dkim.amazonses.com`)],
    }));
}
```

</details>

<details>

<summary>python</summary>

```python
import pulumi
import pulumi_aws as aws

example_domain_identity = aws.ses.DomainIdentity("exampleDomainIdentity", domain="example.com")
example_domain_dkim = aws.ses.DomainDkim("exampleDomainDkim", domain=example_domain_identity.domain)
example_amazonses_dkim_record = []
for range in [{"value": i} for i in range(0, 3)]:
    example_amazonses_dkim_record.append(aws.route53.Record(f"exampleAmazonsesDkimRecord-{range['value']}",
        zone_id="ABCDEFGHIJ123",
        name=example_domain_dkim.dkim_tokens[range["value"]].apply(lambda dkim_tokens: f"{dkim_tokens}._domainkey"),
        type="CNAME",
        ttl=600,
        records=[example_domain_dkim.dkim_tokens[range["value"]].apply(lambda dkim_tokens: f"{dkim_tokens}.dkim.amazonses.com")]))
```

</details>

<details>

<summary>csharp</summary>

```csharp
using System.Collections.Generic;
using Pulumi;
using Aws = Pulumi.Aws;

return await Deployment.RunAsync(() => 
{
    var exampleDomainIdentity = new Aws.Ses.DomainIdentity("exampleDomainIdentity", new()
    {
        Domain = "example.com",
    });

    var exampleDomainDkim = new Aws.Ses.DomainDkim("exampleDomainDkim", new()
    {
        Domain = exampleDomainIdentity.Domain,
    });

    var exampleAmazonsesDkimRecord = new List<Aws.Route53.Record>();
    for (var rangeIndex = 0; rangeIndex < 3; rangeIndex++)
    {
        var range = new { Value = rangeIndex };
        exampleAmazonsesDkimRecord.Add(new Aws.Route53.Record($"exampleAmazonsesDkimRecord-{range.Value}", new()
        {
            ZoneId = "ABCDEFGHIJ123",
            Name = exampleDomainDkim.DkimTokens[range.Value].Apply(dkimTokens => $"{dkimTokens}._domainkey"),
            Type = "CNAME",
            Ttl = 600,
            Records = new[]
            {
                exampleDomainDkim.DkimTokens[range.Value].Apply(dkimTokens => $"{dkimTokens}.dkim.amazonses.com"),
            },
        }));
    }
});
```

</details>

## [**complete failure**] #/resources/aws:autoscaling/group:Group

### HCL

```terraform
resource "aws_placement_group" "test" {
  name     = "test"
  strategy = "cluster"
}

resource "aws_autoscaling_group" "bar" {
  name                      = "foobar3-test"
  max_size                  = 5
  min_size                  = 2
  health_check_grace_period = 300
  health_check_type         = "ELB"
  desired_capacity          = 4
  force_delete              = true
  placement_group           = aws_placement_group.test.id
  launch_configuration      = aws_launch_configuration.foobar.name
  vpc_zone_identifier       = [aws_subnet.example1.id, aws_subnet.example2.id]

  initial_lifecycle_hook {
    name                 = "foobar"
    default_result       = "CONTINUE"
    heartbeat_timeout    = 2000
    lifecycle_transition = "autoscaling:EC2_INSTANCE_LAUNCHING"

    notification_metadata = <<EOF
{
  "foo": "bar"
}
EOF

    notification_target_arn = "arn:aws:sqs:us-east-1:444455556666:queue1*"
    role_arn                = "arn:aws:iam::123456789012:role/S3Access"
  }

  tag {
    key                 = "foo"
    value               = "bar"
    propagate_at_launch = true
  }

  timeouts {
    delete = "15m"
  }

  tag {
    key                 = "lorem"
    value               = "ipsum"
    propagate_at_launch = false
  }
}

```

### Failed Languages

#### python

```text
failed to convert HCL for #/resources/aws:autoscaling/group:Group to python: panic converting HCL: fatal: A failure has occurred
```

#### csharp

```text
failed to convert HCL for #/resources/aws:autoscaling/group:Group to csharp: panic converting HCL: fatal: A failure has occurred
```

#### go

```text
failed to convert HCL for #/resources/aws:autoscaling/group:Group to go: panic converting HCL: fatal: A failure has occurred
```

#### yaml

```text
failed to convert HCL for #/resources/aws:autoscaling/group:Group to yaml: panic converting HCL: fatal: A failure has occurred
```

#### java

```text
failed to convert HCL for #/resources/aws:autoscaling/group:Group to java: panic converting HCL: fatal: A failure has occurred
```

#### typescript

```text
failed to convert HCL for #/resources/aws:autoscaling/group:Group to typescript: panic converting HCL: fatal: A failure has occurred
```

## [**complete failure**] Interpolated tags

### HCL

```terraform
variable "extra_tags" {
  default = [
    {
      key                 = "Foo"
      value               = "Bar"
      propagate_at_launch = true
    },
    {
      key                 = "Baz"
      value               = "Bam"
      propagate_at_launch = true
    },
  ]
}

resource "aws_autoscaling_group" "bar" {
  name                 = "foobar3-test"
  max_size             = 5
  min_size             = 2
  launch_configuration = aws_launch_configuration.foobar.name
  vpc_zone_identifier  = [aws_subnet.example1.id, aws_subnet.example2.id]

  tags = concat(
    [
      {
        "key"                 = "interpolation1"
        "value"               = "value3"
        "propagate_at_launch" = true
      },
      {
        "key"                 = "interpolation2"
        "value"               = "value4"
        "propagate_at_launch" = true
      },
    ],
    var.extra_tags,
  )
}

```

### Failed Languages

#### csharp

```text
:22,10-16: unknown function 'concat'; , and 2 other diagnostic(s)
```

#### go

```text
:22,10-16: unknown function 'concat'; , and 2 other diagnostic(s)
```

#### yaml

```text
:22,10-16: unknown function 'concat'; , and 2 other diagnostic(s)
```

#### java

```text
:22,10-16: unknown function 'concat'; , and 2 other diagnostic(s)
```

#### typescript

```text
:22,10-16: unknown function 'concat'; , and 2 other diagnostic(s)
```

#### python

```text
:22,10-16: unknown function 'concat'; , and 2 other diagnostic(s)
```

## [**complete failure**] Example IAM Role for EKS Addon "vpc-cni" with AWS managed policy

### HCL

```terraform
resource "aws_eks_cluster" "example" {
  # ... other configuration ...
}

data "tls_certificate" "example" {
  url = aws_eks_cluster.example.identity[0].oidc[0].issuer
}

resource "aws_iam_openid_connect_provider" "example" {
  client_id_list  = ["sts.amazonaws.com"]
  thumbprint_list = [data.tls_certificate.example.certificates[0].sha1_fingerprint]
  url             = aws_eks_cluster.example.identity[0].oidc[0].issuer
}

data "aws_iam_policy_document" "example_assume_role_policy" {
  statement {
    actions = ["sts:AssumeRoleWithWebIdentity"]
    effect  = "Allow"

    condition {
      test     = "StringEquals"
      variable = "${replace(aws_iam_openid_connect_provider.example.url, "https://", "")}:sub"
      values   = ["system:serviceaccount:kube-system:aws-node"]
    }

    principals {
      identifiers = [aws_iam_openid_connect_provider.example.arn]
      type        = "Federated"
    }
  }
}

resource "aws_iam_role" "example" {
  assume_role_policy = data.aws_iam_policy_document.example_assume_role_policy.json
  name               = "example-vpc-cni-role"
}

resource "aws_iam_role_policy_attachment" "example" {
  policy_arn = "arn:aws:iam::aws:policy/AmazonEKS_CNI_Policy"
  role       = aws_iam_role.example.name
}

```

### Failed Languages

#### yaml

```text
:21,21-28: unknown function 'replace'; , and 1 other diagnostic(s)
```

#### java

```text
:21,21-28: unknown function 'replace'; , and 1 other diagnostic(s)
```

#### typescript

```text
:21,21-28: unknown function 'replace'; , and 1 other diagnostic(s)
```

#### python

```text
:21,21-28: unknown function 'replace'; , and 1 other diagnostic(s)
```

#### csharp

```text
:21,21-28: unknown function 'replace'; , and 1 other diagnostic(s)
```

#### go

```text
:21,21-28: unknown function 'replace'; , and 1 other diagnostic(s)
```

## [*partial failure*] With CSR

### HCL

```terraform
resource "aws_iot_certificate" "cert" {
  csr    = file("/my/csr.pem")
  active = true
}

```

### Failed Languages

#### yaml

```text
.pp:1,12-35: Failed to generate YAML program: Unknown Function; YAML does not support Fn::readFile.
```

### Successes

<details>

<summary>go</summary>

```go
package main

import (
	"io/ioutil"

	"github.com/pulumi/pulumi-aws/sdk/v5/go/aws/iot"
	"github.com/pulumi/pulumi/sdk/v3/go/pulumi"
)

func readFileOrPanic(path string) pulumi.StringPtrInput {
	data, err := ioutil.ReadFile(path)
	if err != nil {
		panic(err.Error())
	}
	return pulumi.String(string(data))
}

func main() {
	pulumi.Run(func(ctx *pulumi.Context) error {
		_, err := iot.NewCertificate(ctx, "cert", &iot.CertificateArgs{
			Csr:    readFileOrPanic("/my/csr.pem"),
			Active: pulumi.Bool(true),
		})
		if err != nil {
			return err
		}
		return nil
	})
}
```

</details>

<details>

<summary>java</summary>

```java
package generated_program;

import com.pulumi.Context;
import com.pulumi.Pulumi;
import com.pulumi.core.Output;
import com.pulumi.aws.iot.Certificate;
import com.pulumi.aws.iot.CertificateArgs;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;

public class App {
    public static void main(String[] args) {
        Pulumi.run(App::stack);
    }

    public static void stack(Context ctx) {
        var cert = new Certificate("cert", CertificateArgs.builder()        
            .csr(Files.readString(Paths.get("/my/csr.pem")))
            .active(true)
            .build());

    }
}
```

</details>

<details>

<summary>typescript</summary>

```typescript
import * as pulumi from "@pulumi/pulumi";
import * as aws from "@pulumi/aws";
import * as fs from "fs";

const cert = new aws.iot.Certificate("cert", {
    csr: fs.readFileSync("/my/csr.pem"),
    active: true,
});
```

</details>

<details>

<summary>python</summary>

```python
import pulumi
import pulumi_aws as aws

cert = aws.iot.Certificate("cert",
    csr=(lambda path: open(path).read())("/my/csr.pem"),
    active=True)
```

</details>

<details>

<summary>csharp</summary>

```csharp
using System.Collections.Generic;
using System.IO;
using Pulumi;
using Aws = Pulumi.Aws;

return await Deployment.RunAsync(() => 
{
    var cert = new Aws.Iot.Certificate("cert", new()
    {
        Csr = File.ReadAllText("/my/csr.pem"),
        Active = true,
    });

});
```

</details>

## [*partial failure*] From existing certificate without a CA

### HCL

```terraform
resource "aws_iot_certificate" "cert" {
  certificate_pem = file("/my/cert.pem")
  active          = true
}

```

### Failed Languages

#### yaml

```text
.pp:1,20-44: Failed to generate YAML program: Unknown Function; YAML does not support Fn::readFile.
```

### Successes

<details>

<summary>java</summary>

```java
package generated_program;

import com.pulumi.Context;
import com.pulumi.Pulumi;
import com.pulumi.core.Output;
import com.pulumi.aws.iot.Certificate;
import com.pulumi.aws.iot.CertificateArgs;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;

public class App {
    public static void main(String[] args) {
        Pulumi.run(App::stack);
    }

    public static void stack(Context ctx) {
        var cert = new Certificate("cert", CertificateArgs.builder()        
            .certificatePem(Files.readString(Paths.get("/my/cert.pem")))
            .active(true)
            .build());

    }
}
```

</details>

<details>

<summary>typescript</summary>

```typescript
import * as pulumi from "@pulumi/pulumi";
import * as aws from "@pulumi/aws";
import * as fs from "fs";

const cert = new aws.iot.Certificate("cert", {
    certificatePem: fs.readFileSync("/my/cert.pem"),
    active: true,
});
```

</details>

<details>

<summary>python</summary>

```python
import pulumi
import pulumi_aws as aws

cert = aws.iot.Certificate("cert",
    certificate_pem=(lambda path: open(path).read())("/my/cert.pem"),
    active=True)
```

</details>

<details>

<summary>csharp</summary>

```csharp
using System.Collections.Generic;
using System.IO;
using Pulumi;
using Aws = Pulumi.Aws;

return await Deployment.RunAsync(() => 
{
    var cert = new Aws.Iot.Certificate("cert", new()
    {
        CertificatePem = File.ReadAllText("/my/cert.pem"),
        Active = true,
    });

});
```

</details>

<details>

<summary>go</summary>

```go
package main

import (
	"io/ioutil"

	"github.com/pulumi/pulumi-aws/sdk/v5/go/aws/iot"
	"github.com/pulumi/pulumi/sdk/v3/go/pulumi"
)

func readFileOrPanic(path string) pulumi.StringPtrInput {
	data, err := ioutil.ReadFile(path)
	if err != nil {
		panic(err.Error())
	}
	return pulumi.String(string(data))
}

func main() {
	pulumi.Run(func(ctx *pulumi.Context) error {
		_, err := iot.NewCertificate(ctx, "cert", &iot.CertificateArgs{
			CertificatePem: readFileOrPanic("/my/cert.pem"),
			Active:         pulumi.Bool(true),
		})
		if err != nil {
			return err
		}
		return nil
	})
}
```

</details>

## [*partial failure*] #/resources/aws:pinpoint/apnsChannel:ApnsChannel

### HCL

```terraform
resource "aws_pinpoint_apns_channel" "apns" {
  application_id = aws_pinpoint_app.app.application_id

  certificate = file("./certificate.pem")
  private_key = file("./private_key.key")
}

resource "aws_pinpoint_app" "app" {}

```

### Failed Languages

#### yaml

```text
.pp:2,17-46: Failed to generate YAML program: Unknown Function; YAML does not support Fn::readFile., and 1 other diagnostic(s)
```

### Successes

<details>

<summary>java</summary>

```java
package generated_program;

import com.pulumi.Context;
import com.pulumi.Pulumi;
import com.pulumi.core.Output;
import com.pulumi.aws.pinpoint.App;
import com.pulumi.aws.pinpoint.ApnsChannel;
import com.pulumi.aws.pinpoint.ApnsChannelArgs;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;

public class App {
    public static void main(String[] args) {
        Pulumi.run(App::stack);
    }

    public static void stack(Context ctx) {
        var app = new App("app");

        var apns = new ApnsChannel("apns", ApnsChannelArgs.builder()        
            .applicationId(app.applicationId())
            .certificate(Files.readString(Paths.get("./certificate.pem")))
            .privateKey(Files.readString(Paths.get("./private_key.key")))
            .build());

    }
}
```

</details>

<details>

<summary>typescript</summary>

```typescript
import * as pulumi from "@pulumi/pulumi";
import * as aws from "@pulumi/aws";
import * as fs from "fs";

const app = new aws.pinpoint.App("app", {});
const apns = new aws.pinpoint.ApnsChannel("apns", {
    applicationId: app.applicationId,
    certificate: fs.readFileSync("./certificate.pem"),
    privateKey: fs.readFileSync("./private_key.key"),
});
```

</details>

<details>

<summary>python</summary>

```python
import pulumi
import pulumi_aws as aws

app = aws.pinpoint.App("app")
apns = aws.pinpoint.ApnsChannel("apns",
    application_id=app.application_id,
    certificate=(lambda path: open(path).read())("./certificate.pem"),
    private_key=(lambda path: open(path).read())("./private_key.key"))
```

</details>

<details>

<summary>csharp</summary>

```csharp
using System.Collections.Generic;
using System.IO;
using Pulumi;
using Aws = Pulumi.Aws;

return await Deployment.RunAsync(() => 
{
    var app = new Aws.Pinpoint.App("app");

    var apns = new Aws.Pinpoint.ApnsChannel("apns", new()
    {
        ApplicationId = app.ApplicationId,
        Certificate = File.ReadAllText("./certificate.pem"),
        PrivateKey = File.ReadAllText("./private_key.key"),
    });

});
```

</details>

<details>

<summary>go</summary>

```go
package main

import (
	"io/ioutil"

	"github.com/pulumi/pulumi-aws/sdk/v5/go/aws/pinpoint"
	"github.com/pulumi/pulumi/sdk/v3/go/pulumi"
)

func readFileOrPanic(path string) pulumi.StringPtrInput {
	data, err := ioutil.ReadFile(path)
	if err != nil {
		panic(err.Error())
	}
	return pulumi.String(string(data))
}

func main() {
	pulumi.Run(func(ctx *pulumi.Context) error {
		app, err := pinpoint.NewApp(ctx, "app", nil)
		if err != nil {
			return err
		}
		_, err = pinpoint.NewApnsChannel(ctx, "apns", &pinpoint.ApnsChannelArgs{
			ApplicationId: app.ApplicationId,
			Certificate:   readFileOrPanic("./certificate.pem"),
			PrivateKey:    readFileOrPanic("./private_key.key"),
		})
		if err != nil {
			return err
		}
		return nil
	})
}
```

</details>

## [**complete failure**] #/resources/aws:iot/topicRuleDestination:TopicRuleDestination

### HCL

```terraform
resource "aws_iot_topic_rule_destination" "example" {
  vpc_configuration {
    role_arn        = aws_iam_role.example.arn
    security_groups = [aws_security_group.example.id]
    subnet_ids      = aws_subnet.example[*].id
    vpc_id          = aws_vpc.example.id
  }
}

```

### Failed Languages

#### typescript

```text
failed to convert HCL for #/resources/aws:iot/topicRuleDestination:TopicRuleDestination to typescript: panic converting HCL: fatal: A failure has occurred
```

#### python

```text
failed to convert HCL for #/resources/aws:iot/topicRuleDestination:TopicRuleDestination to python: panic converting HCL: fatal: A failure has occurred
```

#### csharp

```text
failed to convert HCL for #/resources/aws:iot/topicRuleDestination:TopicRuleDestination to csharp: panic converting HCL: fatal: A failure has occurred
```

#### go

```text
failed to convert HCL for #/resources/aws:iot/topicRuleDestination:TopicRuleDestination to go: panic converting HCL: fatal: A failure has occurred
```

#### yaml

```text
failed to convert HCL for #/resources/aws:iot/topicRuleDestination:TopicRuleDestination to yaml: panic converting HCL: fatal: A failure has occurred
```

#### java

```text
failed to convert HCL for #/resources/aws:iot/topicRuleDestination:TopicRuleDestination to java: panic converting HCL: fatal: A failure has occurred
```

## [*partial failure*] Basic Usage

### HCL

```terraform
resource "aws_mwaa_environment" "example" {
  dag_s3_path        = "dags/"
  execution_role_arn = aws_iam_role.example.arn
  name               = "example"

  network_configuration {
    security_group_ids = [aws_security_group.example.id]
    subnet_ids         = aws_subnet.private[*].id
  }

  source_bucket_arn = aws_s3_bucket.example.arn
}

```

### Failed Languages

#### go

```text
failed to convert HCL for #/resources/aws:mwaa/environment:Environment to go: invalid Go source code:

package main

import (

"github.com/pulumi/pulumi/sdk/v3/go/pulumi"
"github.com/pulumi/pulumi-aws/sdk/v5/go/aws/mwaa"
)
func main() {
pulumi.Run(func(ctx *pulumi.Context) error {
_, err := mwaa.NewEnvironment(ctx, "example", &mwaa.EnvironmentArgs{
DagS3Path: pulumi.String("dags/"),
ExecutionRoleArn: pulumi.Any(aws_iam_role.Example.Arn),
NetworkConfiguration: &mwaa.EnvironmentNetworkConfigurationArgs{
SecurityGroupIds: pulumi.StringArray{
pulumi.Any(aws_security_group.Example.Id),
},
SubnetIds: %!v(PANIC=Format method: fatal: A failure has occurred: unlowered splat expression @ #-resources-aws:mwaa-environment:Environment.tf.pp:5,25-49),
},
SourceBucketArn: pulumi.Any(aws_s3_bucket.Example.Arn),
})
if err != nil {
return err
}
return nil
})
}
: 17:12: expected operand, found '%' (and 8 more errors)
```

#### yaml

```text
.pp:5,25-49: Failed to generate YAML program: Splat; A 'Splat' expression is equivalent in expressive power to a 'for loop', and is not representable in YAML.
If the values of the function are known, you can manually unroll the loop, otherwise it is necessary to switch to a more expressive language.
```

### Successes

<details>

<summary>java</summary>

```java
package generated_program;

import com.pulumi.Context;
import com.pulumi.Pulumi;
import com.pulumi.core.Output;
import com.pulumi.aws.mwaa.Environment;
import com.pulumi.aws.mwaa.EnvironmentArgs;
import com.pulumi.aws.mwaa.inputs.EnvironmentNetworkConfigurationArgs;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;

public class App {
    public static void main(String[] args) {
        Pulumi.run(App::stack);
    }

    public static void stack(Context ctx) {
        var example = new Environment("example", EnvironmentArgs.builder()        
            .dagS3Path("dags/")
            .executionRoleArn(aws_iam_role.example().arn())
            .networkConfiguration(EnvironmentNetworkConfigurationArgs.builder()
                .securityGroupIds(aws_security_group.example().id())
                .subnetIds(aws_subnet.private().stream().map(element -> element.id()).collect(toList()))
                .build())
            .sourceBucketArn(aws_s3_bucket.example().arn())
            .build());

    }
}
```

</details>

<details>

<summary>typescript</summary>

```typescript
import * as pulumi from "@pulumi/pulumi";
import * as aws from "@pulumi/aws";

const example = new aws.mwaa.Environment("example", {
    dagS3Path: "dags/",
    executionRoleArn: aws_iam_role.example.arn,
    networkConfiguration: {
        securityGroupIds: [aws_security_group.example.id],
        subnetIds: aws_subnet["private"].map(__item => __item.id),
    },
    sourceBucketArn: aws_s3_bucket.example.arn,
});
```

</details>

<details>

<summary>python</summary>

```python
import pulumi
import pulumi_aws as aws

example = aws.mwaa.Environment("example",
    dag_s3_path="dags/",
    execution_role_arn=aws_iam_role["example"]["arn"],
    network_configuration=aws.mwaa.EnvironmentNetworkConfigurationArgs(
        security_group_ids=[aws_security_group["example"]["id"]],
        subnet_ids=[__item["id"] for __item in aws_subnet["private"]],
    ),
    source_bucket_arn=aws_s3_bucket["example"]["arn"])
```

</details>

<details>

<summary>csharp</summary>

```csharp
using System.Collections.Generic;
using System.Linq;
using Pulumi;
using Aws = Pulumi.Aws;

return await Deployment.RunAsync(() => 
{
    var example = new Aws.Mwaa.Environment("example", new()
    {
        DagS3Path = "dags/",
        ExecutionRoleArn = aws_iam_role.Example.Arn,
        NetworkConfiguration = new Aws.Mwaa.Inputs.EnvironmentNetworkConfigurationArgs
        {
            SecurityGroupIds = new[]
            {
                aws_security_group.Example.Id,
            },
            SubnetIds = aws_subnet.Private.Select(__item => __item.Id).ToList(),
        },
        SourceBucketArn = aws_s3_bucket.Example.Arn,
    });

});
```

</details>

## [*partial failure*] Example with Airflow configuration options

### HCL

```terraform
resource "aws_mwaa_environment" "example" {
  airflow_configuration_options = {
    "core.default_task_retries" = 16
    "core.parallelism"          = 1
  }

  dag_s3_path        = "dags/"
  execution_role_arn = aws_iam_role.example.arn
  name               = "example"

  network_configuration {
    security_group_ids = [aws_security_group.example.id]
    subnet_ids         = aws_subnet.private[*].id
  }

  source_bucket_arn = aws_s3_bucket.example.arn
}

```

### Failed Languages

#### go

```text
failed to convert HCL for #/resources/aws:mwaa/environment:Environment to go: invalid Go source code:

package main

import (

"github.com/pulumi/pulumi/sdk/v3/go/pulumi"
"github.com/pulumi/pulumi-aws/sdk/v5/go/aws/mwaa"
)
func main() {
pulumi.Run(func(ctx *pulumi.Context) error {
_, err := mwaa.NewEnvironment(ctx, "example", &mwaa.EnvironmentArgs{
AirflowConfigurationOptions: pulumi.StringMap{
"core.default_task_retries": pulumi.String("16"),
"core.parallelism": pulumi.String("1"),
},
DagS3Path: pulumi.String("dags/"),
ExecutionRoleArn: pulumi.Any(aws_iam_role.Example.Arn),
NetworkConfiguration: &mwaa.EnvironmentNetworkConfigurationArgs{
SecurityGroupIds: pulumi.StringArray{
pulumi.Any(aws_security_group.Example.Id),
},
SubnetIds: %!v(PANIC=Format method: fatal: A failure has occurred: unlowered splat expression @ #-resources-aws:mwaa-environment:Environment.tf.pp:9,25-49),
},
SourceBucketArn: pulumi.Any(aws_s3_bucket.Example.Arn),
})
if err != nil {
return err
}
return nil
})
}
: 21:12: expected operand, found '%' (and 8 more errors)
```

#### yaml

```text
.pp:9,25-49: Failed to generate YAML program: Splat; A 'Splat' expression is equivalent in expressive power to a 'for loop', and is not representable in YAML.
If the values of the function are known, you can manually unroll the loop, otherwise it is necessary to switch to a more expressive language.
```

### Successes

<details>

<summary>typescript</summary>

```typescript
import * as pulumi from "@pulumi/pulumi";
import * as aws from "@pulumi/aws";

const example = new aws.mwaa.Environment("example", {
    airflowConfigurationOptions: {
        "core.default_task_retries": "16",
        "core.parallelism": "1",
    },
    dagS3Path: "dags/",
    executionRoleArn: aws_iam_role.example.arn,
    networkConfiguration: {
        securityGroupIds: [aws_security_group.example.id],
        subnetIds: aws_subnet["private"].map(__item => __item.id),
    },
    sourceBucketArn: aws_s3_bucket.example.arn,
});
```

</details>

<details>

<summary>python</summary>

```python
import pulumi
import pulumi_aws as aws

example = aws.mwaa.Environment("example",
    airflow_configuration_options={
        "core.default_task_retries": "16",
        "core.parallelism": "1",
    },
    dag_s3_path="dags/",
    execution_role_arn=aws_iam_role["example"]["arn"],
    network_configuration=aws.mwaa.EnvironmentNetworkConfigurationArgs(
        security_group_ids=[aws_security_group["example"]["id"]],
        subnet_ids=[__item["id"] for __item in aws_subnet["private"]],
    ),
    source_bucket_arn=aws_s3_bucket["example"]["arn"])
```

</details>

<details>

<summary>csharp</summary>

```csharp
using System.Collections.Generic;
using System.Linq;
using Pulumi;
using Aws = Pulumi.Aws;

return await Deployment.RunAsync(() => 
{
    var example = new Aws.Mwaa.Environment("example", new()
    {
        AirflowConfigurationOptions = 
        {
            { "core.default_task_retries", "16" },
            { "core.parallelism", "1" },
        },
        DagS3Path = "dags/",
        ExecutionRoleArn = aws_iam_role.Example.Arn,
        NetworkConfiguration = new Aws.Mwaa.Inputs.EnvironmentNetworkConfigurationArgs
        {
            SecurityGroupIds = new[]
            {
                aws_security_group.Example.Id,
            },
            SubnetIds = aws_subnet.Private.Select(__item => __item.Id).ToList(),
        },
        SourceBucketArn = aws_s3_bucket.Example.Arn,
    });

});
```

</details>

<details>

<summary>java</summary>

```java
package generated_program;

import com.pulumi.Context;
import com.pulumi.Pulumi;
import com.pulumi.core.Output;
import com.pulumi.aws.mwaa.Environment;
import com.pulumi.aws.mwaa.EnvironmentArgs;
import com.pulumi.aws.mwaa.inputs.EnvironmentNetworkConfigurationArgs;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;

public class App {
    public static void main(String[] args) {
        Pulumi.run(App::stack);
    }

    public static void stack(Context ctx) {
        var example = new Environment("example", EnvironmentArgs.builder()        
            .airflowConfigurationOptions(Map.ofEntries(
                Map.entry("core.default_task_retries", 16),
                Map.entry("core.parallelism", 1)
            ))
            .dagS3Path("dags/")
            .executionRoleArn(aws_iam_role.example().arn())
            .networkConfiguration(EnvironmentNetworkConfigurationArgs.builder()
                .securityGroupIds(aws_security_group.example().id())
                .subnetIds(aws_subnet.private().stream().map(element -> element.id()).collect(toList()))
                .build())
            .sourceBucketArn(aws_s3_bucket.example().arn())
            .build());

    }
}
```

</details>

## [*partial failure*] Example with logging configurations

### HCL

```terraform
resource "aws_mwaa_environment" "example" {
  dag_s3_path        = "dags/"
  execution_role_arn = aws_iam_role.example.arn

  logging_configuration {
    dag_processing_logs {
      enabled   = true
      log_level = "DEBUG"
    }

    scheduler_logs {
      enabled   = true
      log_level = "INFO"
    }

    task_logs {
      enabled   = true
      log_level = "WARNING"
    }

    webserver_logs {
      enabled   = true
      log_level = "ERROR"
    }

    worker_logs {
      enabled   = true
      log_level = "CRITICAL"
    }
  }

  name = "example"

  network_configuration {
    security_group_ids = [aws_security_group.example.id]
    subnet_ids         = aws_subnet.private[*].id
  }

  source_bucket_arn = aws_s3_bucket.example.arn
}

```

### Failed Languages

#### go

```text
failed to convert HCL for #/resources/aws:mwaa/environment:Environment to go: invalid Go source code:

package main

import (

"github.com/pulumi/pulumi/sdk/v3/go/pulumi"
"github.com/pulumi/pulumi-aws/sdk/v5/go/aws/mwaa"
)
func main() {
pulumi.Run(func(ctx *pulumi.Context) error {
_, err := mwaa.NewEnvironment(ctx, "example", &mwaa.EnvironmentArgs{
DagS3Path: pulumi.String("dags/"),
ExecutionRoleArn: pulumi.Any(aws_iam_role.Example.Arn),
LoggingConfiguration: &mwaa.EnvironmentLoggingConfigurationArgs{
DagProcessingLogs: &mwaa.EnvironmentLoggingConfigurationDagProcessingLogsArgs{
Enabled: pulumi.Bool(true),
LogLevel: pulumi.String("DEBUG"),
},
SchedulerLogs: &mwaa.EnvironmentLoggingConfigurationSchedulerLogsArgs{
Enabled: pulumi.Bool(true),
LogLevel: pulumi.String("INFO"),
},
TaskLogs: &mwaa.EnvironmentLoggingConfigurationTaskLogsArgs{
Enabled: pulumi.Bool(true),
LogLevel: pulumi.String("WARNING"),
},
WebserverLogs: &mwaa.EnvironmentLoggingConfigurationWebserverLogsArgs{
Enabled: pulumi.Bool(true),
LogLevel: pulumi.String("ERROR"),
},
WorkerLogs: &mwaa.EnvironmentLoggingConfigurationWorkerLogsArgs{
Enabled: pulumi.Bool(true),
LogLevel: pulumi.String("CRITICAL"),
},
},
NetworkConfiguration: &mwaa.EnvironmentNetworkConfigurationArgs{
SecurityGroupIds: pulumi.StringArray{
pulumi.Any(aws_security_group.Example.Id),
},
SubnetIds: %!v(PANIC=Format method: fatal: A failure has occurred: unlowered splat expression @ #-resources-aws:mwaa-environment:Environment.tf.pp:27,25-49),
},
SourceBucketArn: pulumi.Any(aws_s3_bucket.Example.Arn),
})
if err != nil {
return err
}
return nil
})
}
: 39:12: expected operand, found '%' (and 8 more errors)
```

#### yaml

```text
.pp:27,25-49: Failed to generate YAML program: Splat; A 'Splat' expression is equivalent in expressive power to a 'for loop', and is not representable in YAML.
If the values of the function are known, you can manually unroll the loop, otherwise it is necessary to switch to a more expressive language.
```

### Successes

<details>

<summary>python</summary>

```python
import pulumi
import pulumi_aws as aws

example = aws.mwaa.Environment("example",
    dag_s3_path="dags/",
    execution_role_arn=aws_iam_role["example"]["arn"],
    logging_configuration=aws.mwaa.EnvironmentLoggingConfigurationArgs(
        dag_processing_logs=aws.mwaa.EnvironmentLoggingConfigurationDagProcessingLogsArgs(
            enabled=True,
            log_level="DEBUG",
        ),
        scheduler_logs=aws.mwaa.EnvironmentLoggingConfigurationSchedulerLogsArgs(
            enabled=True,
            log_level="INFO",
        ),
        task_logs=aws.mwaa.EnvironmentLoggingConfigurationTaskLogsArgs(
            enabled=True,
            log_level="WARNING",
        ),
        webserver_logs=aws.mwaa.EnvironmentLoggingConfigurationWebserverLogsArgs(
            enabled=True,
            log_level="ERROR",
        ),
        worker_logs=aws.mwaa.EnvironmentLoggingConfigurationWorkerLogsArgs(
            enabled=True,
            log_level="CRITICAL",
        ),
    ),
    network_configuration=aws.mwaa.EnvironmentNetworkConfigurationArgs(
        security_group_ids=[aws_security_group["example"]["id"]],
        subnet_ids=[__item["id"] for __item in aws_subnet["private"]],
    ),
    source_bucket_arn=aws_s3_bucket["example"]["arn"])
```

</details>

<details>

<summary>csharp</summary>

```csharp
using System.Collections.Generic;
using System.Linq;
using Pulumi;
using Aws = Pulumi.Aws;

return await Deployment.RunAsync(() => 
{
    var example = new Aws.Mwaa.Environment("example", new()
    {
        DagS3Path = "dags/",
        ExecutionRoleArn = aws_iam_role.Example.Arn,
        LoggingConfiguration = new Aws.Mwaa.Inputs.EnvironmentLoggingConfigurationArgs
        {
            DagProcessingLogs = new Aws.Mwaa.Inputs.EnvironmentLoggingConfigurationDagProcessingLogsArgs
            {
                Enabled = true,
                LogLevel = "DEBUG",
            },
            SchedulerLogs = new Aws.Mwaa.Inputs.EnvironmentLoggingConfigurationSchedulerLogsArgs
            {
                Enabled = true,
                LogLevel = "INFO",
            },
            TaskLogs = new Aws.Mwaa.Inputs.EnvironmentLoggingConfigurationTaskLogsArgs
            {
                Enabled = true,
                LogLevel = "WARNING",
            },
            WebserverLogs = new Aws.Mwaa.Inputs.EnvironmentLoggingConfigurationWebserverLogsArgs
            {
                Enabled = true,
                LogLevel = "ERROR",
            },
            WorkerLogs = new Aws.Mwaa.Inputs.EnvironmentLoggingConfigurationWorkerLogsArgs
            {
                Enabled = true,
                LogLevel = "CRITICAL",
            },
        },
        NetworkConfiguration = new Aws.Mwaa.Inputs.EnvironmentNetworkConfigurationArgs
        {
            SecurityGroupIds = new[]
            {
                aws_security_group.Example.Id,
            },
            SubnetIds = aws_subnet.Private.Select(__item => __item.Id).ToList(),
        },
        SourceBucketArn = aws_s3_bucket.Example.Arn,
    });

});
```

</details>

<details>

<summary>java</summary>

```java
package generated_program;

import com.pulumi.Context;
import com.pulumi.Pulumi;
import com.pulumi.core.Output;
import com.pulumi.aws.mwaa.Environment;
import com.pulumi.aws.mwaa.EnvironmentArgs;
import com.pulumi.aws.mwaa.inputs.EnvironmentLoggingConfigurationArgs;
import com.pulumi.aws.mwaa.inputs.EnvironmentLoggingConfigurationDagProcessingLogsArgs;
import com.pulumi.aws.mwaa.inputs.EnvironmentLoggingConfigurationSchedulerLogsArgs;
import com.pulumi.aws.mwaa.inputs.EnvironmentLoggingConfigurationTaskLogsArgs;
import com.pulumi.aws.mwaa.inputs.EnvironmentLoggingConfigurationWebserverLogsArgs;
import com.pulumi.aws.mwaa.inputs.EnvironmentLoggingConfigurationWorkerLogsArgs;
import com.pulumi.aws.mwaa.inputs.EnvironmentNetworkConfigurationArgs;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;

public class App {
    public static void main(String[] args) {
        Pulumi.run(App::stack);
    }

    public static void stack(Context ctx) {
        var example = new Environment("example", EnvironmentArgs.builder()        
            .dagS3Path("dags/")
            .executionRoleArn(aws_iam_role.example().arn())
            .loggingConfiguration(EnvironmentLoggingConfigurationArgs.builder()
                .dagProcessingLogs(EnvironmentLoggingConfigurationDagProcessingLogsArgs.builder()
                    .enabled(true)
                    .logLevel("DEBUG")
                    .build())
                .schedulerLogs(EnvironmentLoggingConfigurationSchedulerLogsArgs.builder()
                    .enabled(true)
                    .logLevel("INFO")
                    .build())
                .taskLogs(EnvironmentLoggingConfigurationTaskLogsArgs.builder()
                    .enabled(true)
                    .logLevel("WARNING")
                    .build())
                .webserverLogs(EnvironmentLoggingConfigurationWebserverLogsArgs.builder()
                    .enabled(true)
                    .logLevel("ERROR")
                    .build())
                .workerLogs(EnvironmentLoggingConfigurationWorkerLogsArgs.builder()
                    .enabled(true)
                    .logLevel("CRITICAL")
                    .build())
                .build())
            .networkConfiguration(EnvironmentNetworkConfigurationArgs.builder()
                .securityGroupIds(aws_security_group.example().id())
                .subnetIds(aws_subnet.private().stream().map(element -> element.id()).collect(toList()))
                .build())
            .sourceBucketArn(aws_s3_bucket.example().arn())
            .build());

    }
}
```

</details>

<details>

<summary>typescript</summary>

```typescript
import * as pulumi from "@pulumi/pulumi";
import * as aws from "@pulumi/aws";

const example = new aws.mwaa.Environment("example", {
    dagS3Path: "dags/",
    executionRoleArn: aws_iam_role.example.arn,
    loggingConfiguration: {
        dagProcessingLogs: {
            enabled: true,
            logLevel: "DEBUG",
        },
        schedulerLogs: {
            enabled: true,
            logLevel: "INFO",
        },
        taskLogs: {
            enabled: true,
            logLevel: "WARNING",
        },
        webserverLogs: {
            enabled: true,
            logLevel: "ERROR",
        },
        workerLogs: {
            enabled: true,
            logLevel: "CRITICAL",
        },
    },
    networkConfiguration: {
        securityGroupIds: [aws_security_group.example.id],
        subnetIds: aws_subnet["private"].map(__item => __item.id),
    },
    sourceBucketArn: aws_s3_bucket.example.arn,
});
```

</details>

## [*partial failure*] Example with tags

### HCL

```terraform
resource "aws_mwaa_environment" "example" {
  dag_s3_path        = "dags/"
  execution_role_arn = aws_iam_role.example.arn
  name               = "example"

  network_configuration {
    security_group_ids = [aws_security_group.example.id]
    subnet_ids         = aws_subnet.private[*].id
  }

  source_bucket_arn = aws_s3_bucket.example.arn

  tags = {
    Name        = "example"
    Environment = "production"
  }
}

```

### Failed Languages

#### go

```text
failed to convert HCL for #/resources/aws:mwaa/environment:Environment to go: invalid Go source code:

package main

import (

"github.com/pulumi/pulumi/sdk/v3/go/pulumi"
"github.com/pulumi/pulumi-aws/sdk/v5/go/aws/mwaa"
)
func main() {
pulumi.Run(func(ctx *pulumi.Context) error {
_, err := mwaa.NewEnvironment(ctx, "example", &mwaa.EnvironmentArgs{
DagS3Path: pulumi.String("dags/"),
ExecutionRoleArn: pulumi.Any(aws_iam_role.Example.Arn),
NetworkConfiguration: &mwaa.EnvironmentNetworkConfigurationArgs{
SecurityGroupIds: pulumi.StringArray{
pulumi.Any(aws_security_group.Example.Id),
},
SubnetIds: %!v(PANIC=Format method: fatal: A failure has occurred: unlowered splat expression @ #-resources-aws:mwaa-environment:Environment.tf.pp:5,25-49),
},
SourceBucketArn: pulumi.Any(aws_s3_bucket.Example.Arn),
Tags: pulumi.StringMap{
"Name": pulumi.String("example"),
"Environment": pulumi.String("production"),
},
})
if err != nil {
return err
}
return nil
})
}
: 17:12: expected operand, found '%' (and 8 more errors)
```

#### yaml

```text
.pp:5,25-49: Failed to generate YAML program: Splat; A 'Splat' expression is equivalent in expressive power to a 'for loop', and is not representable in YAML.
If the values of the function are known, you can manually unroll the loop, otherwise it is necessary to switch to a more expressive language.
```

### Successes

<details>

<summary>typescript</summary>

```typescript
import * as pulumi from "@pulumi/pulumi";
import * as aws from "@pulumi/aws";

const example = new aws.mwaa.Environment("example", {
    dagS3Path: "dags/",
    executionRoleArn: aws_iam_role.example.arn,
    networkConfiguration: {
        securityGroupIds: [aws_security_group.example.id],
        subnetIds: aws_subnet["private"].map(__item => __item.id),
    },
    sourceBucketArn: aws_s3_bucket.example.arn,
    tags: {
        Name: "example",
        Environment: "production",
    },
});
```

</details>

<details>

<summary>python</summary>

```python
import pulumi
import pulumi_aws as aws

example = aws.mwaa.Environment("example",
    dag_s3_path="dags/",
    execution_role_arn=aws_iam_role["example"]["arn"],
    network_configuration=aws.mwaa.EnvironmentNetworkConfigurationArgs(
        security_group_ids=[aws_security_group["example"]["id"]],
        subnet_ids=[__item["id"] for __item in aws_subnet["private"]],
    ),
    source_bucket_arn=aws_s3_bucket["example"]["arn"],
    tags={
        "Name": "example",
        "Environment": "production",
    })
```

</details>

<details>

<summary>csharp</summary>

```csharp
using System.Collections.Generic;
using System.Linq;
using Pulumi;
using Aws = Pulumi.Aws;

return await Deployment.RunAsync(() => 
{
    var example = new Aws.Mwaa.Environment("example", new()
    {
        DagS3Path = "dags/",
        ExecutionRoleArn = aws_iam_role.Example.Arn,
        NetworkConfiguration = new Aws.Mwaa.Inputs.EnvironmentNetworkConfigurationArgs
        {
            SecurityGroupIds = new[]
            {
                aws_security_group.Example.Id,
            },
            SubnetIds = aws_subnet.Private.Select(__item => __item.Id).ToList(),
        },
        SourceBucketArn = aws_s3_bucket.Example.Arn,
        Tags = 
        {
            { "Name", "example" },
            { "Environment", "production" },
        },
    });

});
```

</details>

<details>

<summary>java</summary>

```java
package generated_program;

import com.pulumi.Context;
import com.pulumi.Pulumi;
import com.pulumi.core.Output;
import com.pulumi.aws.mwaa.Environment;
import com.pulumi.aws.mwaa.EnvironmentArgs;
import com.pulumi.aws.mwaa.inputs.EnvironmentNetworkConfigurationArgs;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;

public class App {
    public static void main(String[] args) {
        Pulumi.run(App::stack);
    }

    public static void stack(Context ctx) {
        var example = new Environment("example", EnvironmentArgs.builder()        
            .dagS3Path("dags/")
            .executionRoleArn(aws_iam_role.example().arn())
            .networkConfiguration(EnvironmentNetworkConfigurationArgs.builder()
                .securityGroupIds(aws_security_group.example().id())
                .subnetIds(aws_subnet.private().stream().map(element -> element.id()).collect(toList()))
                .build())
            .sourceBucketArn(aws_s3_bucket.example().arn())
            .tags(Map.ofEntries(
                Map.entry("Name", "example"),
                Map.entry("Environment", "production")
            ))
            .build());

    }
}
```

</details>

## [*partial failure*] #/resources/aws:apigateway/basePathMapping:BasePathMapping

### HCL

```terraform
resource "aws_api_gateway_stage" "example" {
  deployment_id = aws_api_gateway_deployment.example.id
  rest_api_id   = aws_api_gateway_rest_api.example.id
  stage_name    = "example"
}

resource "aws_api_gateway_domain_name" "example" {
  domain_name = "example.com"

  certificate_name        = "example-api"
  certificate_body        = file("${path.module}/example.com/example.crt")
  certificate_chain       = file("${path.module}/example.com/ca.crt")
  certificate_private_key = file("${path.module}/example.com/example.key")
}

resource "aws_api_gateway_base_path_mapping" "example" {
  api_id      = aws_api_gateway_rest_api.example.id
  stage_name  = aws_api_gateway_stage.example.stage_name
  domain_name = aws_api_gateway_domain_name.example.domain_name
}

```

### Failed Languages

#### yaml

```text
.pp:8,28-78: Failed to generate YAML program: Unknown Function; YAML does not support Fn::readFile., and 2 other diagnostic(s)
```

### Successes

<details>

<summary>typescript</summary>

```typescript
import * as pulumi from "@pulumi/pulumi";
import * as aws from "@pulumi/aws";
import * as fs from "fs";

const exampleStage = new aws.apigateway.Stage("exampleStage", {
    deployment: aws_api_gateway_deployment.example.id,
    restApi: aws_api_gateway_rest_api.example.id,
    stageName: "example",
});
const exampleDomainName = new aws.apigateway.DomainName("exampleDomainName", {
    domainName: "example.com",
    certificateName: "example-api",
    certificateBody: fs.readFileSync(`${path.module}/example.com/example.crt`),
    certificateChain: fs.readFileSync(`${path.module}/example.com/ca.crt`),
    certificatePrivateKey: fs.readFileSync(`${path.module}/example.com/example.key`),
});
const exampleBasePathMapping = new aws.apigateway.BasePathMapping("exampleBasePathMapping", {
    restApi: aws_api_gateway_rest_api.example.id,
    stageName: exampleStage.stageName,
    domainName: exampleDomainName.domainName,
});
```

</details>

<details>

<summary>python</summary>

```python
import pulumi
import pulumi_aws as aws

example_stage = aws.apigateway.Stage("exampleStage",
    deployment=aws_api_gateway_deployment["example"]["id"],
    rest_api=aws_api_gateway_rest_api["example"]["id"],
    stage_name="example")
example_domain_name = aws.apigateway.DomainName("exampleDomainName",
    domain_name="example.com",
    certificate_name="example-api",
    certificate_body=(lambda path: open(path).read())(f"{path['module']}/example.com/example.crt"),
    certificate_chain=(lambda path: open(path).read())(f"{path['module']}/example.com/ca.crt"),
    certificate_private_key=(lambda path: open(path).read())(f"{path['module']}/example.com/example.key"))
example_base_path_mapping = aws.apigateway.BasePathMapping("exampleBasePathMapping",
    rest_api=aws_api_gateway_rest_api["example"]["id"],
    stage_name=example_stage.stage_name,
    domain_name=example_domain_name.domain_name)
```

</details>

<details>

<summary>csharp</summary>

```csharp
using System.Collections.Generic;
using System.IO;
using Pulumi;
using Aws = Pulumi.Aws;

return await Deployment.RunAsync(() => 
{
    var exampleStage = new Aws.ApiGateway.Stage("exampleStage", new()
    {
        Deployment = aws_api_gateway_deployment.Example.Id,
        RestApi = aws_api_gateway_rest_api.Example.Id,
        StageName = "example",
    });

    var exampleDomainName = new Aws.ApiGateway.DomainName("exampleDomainName", new()
    {
        Domain = "example.com",
        CertificateName = "example-api",
        CertificateBody = File.ReadAllText($"{path.Module}/example.com/example.crt"),
        CertificateChain = File.ReadAllText($"{path.Module}/example.com/ca.crt"),
        CertificatePrivateKey = File.ReadAllText($"{path.Module}/example.com/example.key"),
    });

    var exampleBasePathMapping = new Aws.ApiGateway.BasePathMapping("exampleBasePathMapping", new()
    {
        RestApi = aws_api_gateway_rest_api.Example.Id,
        StageName = exampleStage.StageName,
        DomainName = exampleDomainName.Domain,
    });

});
```

</details>

<details>

<summary>go</summary>

```go
package main

import (
	"fmt"
	"io/ioutil"

	"github.com/pulumi/pulumi-aws/sdk/v5/go/aws/apigateway"
	"github.com/pulumi/pulumi/sdk/v3/go/pulumi"
)

func readFileOrPanic(path string) pulumi.StringPtrInput {
	data, err := ioutil.ReadFile(path)
	if err != nil {
		panic(err.Error())
	}
	return pulumi.String(string(data))
}

func main() {
	pulumi.Run(func(ctx *pulumi.Context) error {
		exampleStage, err := apigateway.NewStage(ctx, "exampleStage", &apigateway.StageArgs{
			Deployment: pulumi.Any(aws_api_gateway_deployment.Example.Id),
			RestApi:    pulumi.Any(aws_api_gateway_rest_api.Example.Id),
			StageName:  pulumi.String("example"),
		})
		if err != nil {
			return err
		}
		exampleDomainName, err := apigateway.NewDomainName(ctx, "exampleDomainName", &apigateway.DomainNameArgs{
			DomainName:            pulumi.String("example.com"),
			CertificateName:       pulumi.String("example-api"),
			CertificateBody:       readFileOrPanic(fmt.Sprintf("%v/example.com/example.crt", path.Module)),
			CertificateChain:      readFileOrPanic(fmt.Sprintf("%v/example.com/ca.crt", path.Module)),
			CertificatePrivateKey: readFileOrPanic(fmt.Sprintf("%v/example.com/example.key", path.Module)),
		})
		if err != nil {
			return err
		}
		_, err = apigateway.NewBasePathMapping(ctx, "exampleBasePathMapping", &apigateway.BasePathMappingArgs{
			RestApi:    pulumi.Any(aws_api_gateway_rest_api.Example.Id),
			StageName:  exampleStage.StageName,
			DomainName: exampleDomainName.DomainName,
		})
		if err != nil {
			return err
		}
		return nil
	})
}
```

</details>

<details>

<summary>java</summary>

```java
package generated_program;

import com.pulumi.Context;
import com.pulumi.Pulumi;
import com.pulumi.core.Output;
import com.pulumi.aws.apigateway.Stage;
import com.pulumi.aws.apigateway.StageArgs;
import com.pulumi.aws.apigateway.DomainName;
import com.pulumi.aws.apigateway.DomainNameArgs;
import com.pulumi.aws.apigateway.BasePathMapping;
import com.pulumi.aws.apigateway.BasePathMappingArgs;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;

public class App {
    public static void main(String[] args) {
        Pulumi.run(App::stack);
    }

    public static void stack(Context ctx) {
        var exampleStage = new Stage("exampleStage", StageArgs.builder()        
            .deployment(aws_api_gateway_deployment.example().id())
            .restApi(aws_api_gateway_rest_api.example().id())
            .stageName("example")
            .build());

        var exampleDomainName = new DomainName("exampleDomainName", DomainNameArgs.builder()        
            .domainName("example.com")
            .certificateName("example-api")
            .certificateBody(Files.readString(Paths.get(String.format("%s/example.com/example.crt", path.module()))))
            .certificateChain(Files.readString(Paths.get(String.format("%s/example.com/ca.crt", path.module()))))
            .certificatePrivateKey(Files.readString(Paths.get(String.format("%s/example.com/example.key", path.module()))))
            .build());

        var exampleBasePathMapping = new BasePathMapping("exampleBasePathMapping", BasePathMappingArgs.builder()        
            .restApi(aws_api_gateway_rest_api.example().id())
            .stageName(exampleStage.stageName())
            .domainName(exampleDomainName.domainName())
            .build());

    }
}
```

</details>

## [**complete failure**] #/resources/aws:appflow/connectorProfile:ConnectorProfile

### HCL

```terraform
data "aws_iam_policy" "example" {
  name = "AmazonRedshiftAllCommandsFullAccess"
}

resource "aws_iam_role" "example" {
  name = "example_role"

  managed_policy_arns = [data.aws_iam_policy.test.arn]

  assume_role_policy = jsonencode({
    Version = "2012-10-17"
    Statement = [
      {
        Action = "sts:AssumeRole"
        Effect = "Allow"
        Sid    = ""
        Principal = {
          Service = "ec2.amazonaws.com"
        }
      },
    ]
  })
}

resource "aws_s3_bucket" "example" {
  bucket = "example_bucket"
}

resource "aws_redshift_cluster" "example" {
  cluster_identifier = "example_cluster"
  database_name      = "example_db"
  master_username    = "exampleuser"
  master_password    = "examplePassword123!"
  node_type          = "dc1.large"
  cluster_type       = "single-node"
}

resource "aws_appflow_connector_profile" "example" {
  name            = "example_profile"
  connector_type  = "Redshift"
  connection_mode = "Public"

  connector_profile_config {

    connector_profile_credentials {
      redshift {
        password = aws_redshift_cluster.example.master_password
        username = aws_redshift_cluster.example.master_username
      }
    }

    connector_profile_properties {
      redshift {
        bucket_name  = aws_s3_bucket.example.name
        database_url = "jdbc:redshift://${aws_redshift_cluster.example.endpoint}/${aws_redshift_cluster.example.database_name}"
        role_arn     = aws_iam_role.example.arn
      }
    }
  }
}

```

### Failed Languages

#### csharp

```text
:53,45-50: unknown property 'name' among [website_domain force_destroy website policy versioning logging acceleration_status bucket_regional_domain_name bucket_domain_name cors_rule tags tags_all lifecycle_rule server_side_encryption_configuration id bucket hosted_zone_id arn request_payer region replication_configuration acl object_lock_configuration bucket_prefix website_endpoint object_lock_enabled grant]; , and 1 other diagnostic(s)
```

#### go

```text
:53,45-50: unknown property 'name' among [website_endpoint arn acceleration_status bucket_regional_domain_name website website_domain versioning request_payer object_lock_enabled server_side_encryption_configuration grant bucket_prefix force_destroy object_lock_configuration hosted_zone_id policy replication_configuration cors_rule tags bucket tags_all lifecycle_rule id bucket_domain_name logging region acl]; , and 1 other diagnostic(s)
```

#### yaml

```text
:53,45-50: unknown property 'name' among [force_destroy id bucket_prefix request_payer acl object_lock_configuration tags policy hosted_zone_id region grant arn bucket_domain_name logging lifecycle_rule website cors_rule website_endpoint bucket website_domain versioning bucket_regional_domain_name object_lock_enabled tags_all replication_configuration server_side_encryption_configuration acceleration_status]; , and 1 other diagnostic(s)
```

#### java

```text
:53,45-50: unknown property 'name' among [acl bucket object_lock_enabled acceleration_status bucket_domain_name force_destroy website_endpoint policy object_lock_configuration website_domain arn id region logging hosted_zone_id request_payer server_side_encryption_configuration tags_all replication_configuration grant bucket_regional_domain_name website lifecycle_rule bucket_prefix cors_rule tags versioning]; , and 1 other diagnostic(s)
```

#### typescript

```text
:53,45-50: unknown property 'name' among [request_payer tags_all versioning bucket_regional_domain_name object_lock_configuration website_endpoint acl bucket lifecycle_rule hosted_zone_id cors_rule policy logging acceleration_status force_destroy website_domain id bucket_domain_name bucket_prefix object_lock_enabled server_side_encryption_configuration arn region replication_configuration website tags grant]; , and 1 other diagnostic(s)
```

#### python

```text
:53,45-50: unknown property 'name' among [hosted_zone_id acceleration_status cors_rule object_lock_enabled grant versioning lifecycle_rule id tags_all tags bucket bucket_prefix server_side_encryption_configuration logging request_payer object_lock_configuration website_domain bucket_regional_domain_name replication_configuration acl force_destroy website_endpoint bucket_domain_name website policy arn region]; , and 1 other diagnostic(s)
```

## [*partial failure*] Updating your bucket policy

### HCL

```terraform
data "aws_iam_policy_document" "s3_policy" {
  statement {
    actions   = ["s3:GetObject"]
    resources = ["${aws_s3_bucket.example.arn}/*"]

    principals {
      type        = "AWS"
      identifiers = [aws_cloudfront_origin_access_identity.example.iam_arn]
    }
  }
}

resource "aws_s3_bucket_policy" "example" {
  bucket = aws_s3_bucket.example.id
  policy = data.aws_iam_policy_document.s3_policy.json
}

```

### Failed Languages

#### go

```text
failed to convert HCL for #/resources/aws:cloudfront/originAccessIdentity:OriginAccessIdentity to go: invalid Go source code:

package main

import (
"fmt"

"github.com/pulumi/pulumi/sdk/v3/go/pulumi"
"github.com/pulumi/pulumi-aws/sdk/v5/go/aws/iam"
"github.com/pulumi/pulumi-aws/sdk/v5/go/aws/s3"
)
func main() {
pulumi.Run(func(ctx *pulumi.Context) error {
s3Policy, err := iam.GetPolicyDocument(ctx, &iam.GetPolicyDocumentArgs{
Statements: []iam.GetPolicyDocumentStatement{
iam.GetPolicyDocumentStatement{
Actions: []string{
"s3:GetObject",
},
Resources: []string{
fmt.Sprintf("%v/*", aws_s3_bucket.Example.Arn),
},
Principals: []iam.GetPolicyDocumentStatementPrincipal{
iam.GetPolicyDocumentStatementPrincipal{
Type: "AWS",
Identifiers: interface{}{
aws_cloudfront_origin_access_identity.Example.Iam_arn,
},
},
},
},
},
}, nil);
if err != nil {
return err
}
_, err = s3.NewBucketPolicy(ctx, "example", &s3.BucketPolicyArgs{
Bucket: pulumi.Any(aws_s3_bucket.Example.Id),
Policy: pulumi.String(s3Policy.Json),
})
if err != nil {
return err
}
return nil
})
}
: 24:14: expected expression (and 10 more errors)
```

### Successes

<details>

<summary>java</summary>

```java
package generated_program;

import com.pulumi.Context;
import com.pulumi.Pulumi;
import com.pulumi.core.Output;
import com.pulumi.aws.iam.IamFunctions;
import com.pulumi.aws.iam.inputs.GetPolicyDocumentArgs;
import com.pulumi.aws.s3.BucketPolicy;
import com.pulumi.aws.s3.BucketPolicyArgs;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;

public class App {
    public static void main(String[] args) {
        Pulumi.run(App::stack);
    }

    public static void stack(Context ctx) {
        final var s3Policy = IamFunctions.getPolicyDocument(GetPolicyDocumentArgs.builder()
            .statements(GetPolicyDocumentStatementArgs.builder()
                .actions("s3:GetObject")
                .resources(String.format("%s/*", aws_s3_bucket.example().arn()))
                .principals(GetPolicyDocumentStatementPrincipalArgs.builder()
                    .type("AWS")
                    .identifiers(aws_cloudfront_origin_access_identity.example().iam_arn())
                    .build())
                .build())
            .build());

        var example = new BucketPolicy("example", BucketPolicyArgs.builder()        
            .bucket(aws_s3_bucket.example().id())
            .policy(s3Policy.applyValue(getPolicyDocumentResult -> getPolicyDocumentResult.json()))
            .build());

    }
}
```

</details>

<details>

<summary>typescript</summary>

```typescript
import * as pulumi from "@pulumi/pulumi";
import * as aws from "@pulumi/aws";

const s3Policy = aws.iam.getPolicyDocument({
    statements: [{
        actions: ["s3:GetObject"],
        resources: [`${aws_s3_bucket.example.arn}/*`],
        principals: [{
            type: "AWS",
            identifiers: [aws_cloudfront_origin_access_identity.example.iam_arn],
        }],
    }],
});
const example = new aws.s3.BucketPolicy("example", {
    bucket: aws_s3_bucket.example.id,
    policy: s3Policy.then(s3Policy => s3Policy.json),
});
```

</details>

<details>

<summary>python</summary>

```python
import pulumi
import pulumi_aws as aws

s3_policy = aws.iam.get_policy_document(statements=[aws.iam.GetPolicyDocumentStatementArgs(
    actions=["s3:GetObject"],
    resources=[f"{aws_s3_bucket['example']['arn']}/*"],
    principals=[aws.iam.GetPolicyDocumentStatementPrincipalArgs(
        type="AWS",
        identifiers=[aws_cloudfront_origin_access_identity["example"]["iam_arn"]],
    )],
)])
example = aws.s3.BucketPolicy("example",
    bucket=aws_s3_bucket["example"]["id"],
    policy=s3_policy.json)
```

</details>

<details>

<summary>csharp</summary>

```csharp
using System.Collections.Generic;
using Pulumi;
using Aws = Pulumi.Aws;

return await Deployment.RunAsync(() => 
{
    var s3Policy = Aws.Iam.GetPolicyDocument.Invoke(new()
    {
        Statements = new[]
        {
            new Aws.Iam.Inputs.GetPolicyDocumentStatementInputArgs
            {
                Actions = new[]
                {
                    "s3:GetObject",
                },
                Resources = new[]
                {
                    $"{aws_s3_bucket.Example.Arn}/*",
                },
                Principals = new[]
                {
                    new Aws.Iam.Inputs.GetPolicyDocumentStatementPrincipalInputArgs
                    {
                        Type = "AWS",
                        Identifiers = new[]
                        {
                            aws_cloudfront_origin_access_identity.Example.Iam_arn,
                        },
                    },
                },
            },
        },
    });

    var example = new Aws.S3.BucketPolicy("example", new()
    {
        Bucket = aws_s3_bucket.Example.Id,
        Policy = s3Policy.Apply(getPolicyDocumentResult => getPolicyDocumentResult.Json),
    });

});
```

</details>

<details>

<summary>yaml</summary>

```yaml
resources:
  example:
    type: aws:s3:BucketPolicy
    properties:
      bucket: ${aws_s3_bucket.example.id}
      policy: ${s3Policy.json}
variables:
  s3Policy:
    Fn::Invoke:
      Function: aws:iam:getPolicyDocument
      Arguments:
        statements:
          - actions:
              - s3:GetObject
            resources:
              - ${aws_s3_bucket.example.arn}/*
            principals:
              - type: AWS
                identifiers:
                  - ${aws_cloudfront_origin_access_identity.example.iam_arn}
```

</details>

## [*partial failure*] #/resources/aws:elasticloadbalancing/loadBalancerPolicy:LoadBalancerPolicy

### HCL

```terraform
resource "aws_elb" "wu-tang" {
  name               = "wu-tang"
  availability_zones = ["us-east-1a"]

  listener {
    instance_port      = 443
    instance_protocol  = "http"
    lb_port            = 443
    lb_protocol        = "https"
    ssl_certificate_id = "arn:aws:iam::000000000000:server-certificate/wu-tang.net"
  }

  tags = {
    Name = "wu-tang"
  }
}

resource "aws_load_balancer_policy" "wu-tang-ca-pubkey-policy" {
  load_balancer_name = aws_elb.wu-tang.name
  policy_name        = "wu-tang-ca-pubkey-policy"
  policy_type_name   = "PublicKeyPolicyType"

  # The public key of a CA certificate file can be extracted with:
  # $ cat wu-tang-ca.pem | openssl x509 -pubkey -noout | grep -v '\-\-\-\-' | tr -d '\n' > wu-tang-pubkey
  policy_attribute {
    name  = "PublicKey"
    value = file("wu-tang-pubkey")
  }
}

resource "aws_load_balancer_policy" "wu-tang-root-ca-backend-auth-policy" {
  load_balancer_name = aws_elb.wu-tang.name
  policy_name        = "wu-tang-root-ca-backend-auth-policy"
  policy_type_name   = "BackendServerAuthenticationPolicyType"

  policy_attribute {
    name  = "PublicKeyPolicyName"
    value = aws_load_balancer_policy.wu-tang-root-ca-pubkey-policy.policy_name
  }
}

resource "aws_load_balancer_policy" "wu-tang-ssl" {
  load_balancer_name = aws_elb.wu-tang.name
  policy_name        = "wu-tang-ssl"
  policy_type_name   = "SSLNegotiationPolicyType"

  policy_attribute {
    name  = "ECDHE-ECDSA-AES128-GCM-SHA256"
    value = "true"
  }

  policy_attribute {
    name  = "Protocol-TLSv1.2"
    value = "true"
  }
}

resource "aws_load_balancer_policy" "wu-tang-ssl-tls-1-1" {
  load_balancer_name = aws_elb.wu-tang.name
  policy_name        = "wu-tang-ssl"
  policy_type_name   = "SSLNegotiationPolicyType"

  policy_attribute {
    name  = "Reference-Security-Policy"
    value = "ELBSecurityPolicy-TLS-1-1-2017-01"
  }
}

resource "aws_load_balancer_backend_server_policy" "wu-tang-backend-auth-policies-443" {
  load_balancer_name = aws_elb.wu-tang.name
  instance_port      = 443

  policy_names = [
    aws_load_balancer_policy.wu-tang-root-ca-backend-auth-policy.policy_name,
  ]
}

resource "aws_load_balancer_listener_policy" "wu-tang-listener-policies-443" {
  load_balancer_name = aws_elb.wu-tang.name
  load_balancer_port = 443

  policy_names = [
    aws_load_balancer_policy.wu-tang-ssl.policy_name,
  ]
}

```

### Failed Languages

#### yaml

```text
.pp:14,21-29: Invalid property name access; 'wu-tang' is not a valid property name access. It has been changed to a quoted key access., and 9 other diagnostic(s)
```

### Successes

<details>

<summary>java</summary>

```java
package generated_program;

import com.pulumi.Context;
import com.pulumi.Pulumi;
import com.pulumi.core.Output;
import com.pulumi.aws.elb.LoadBalancer;
import com.pulumi.aws.elb.LoadBalancerArgs;
import com.pulumi.aws.elb.inputs.LoadBalancerListenerArgs;
import com.pulumi.aws.elb.LoadBalancerPolicy;
import com.pulumi.aws.elb.LoadBalancerPolicyArgs;
import com.pulumi.aws.elb.inputs.LoadBalancerPolicyPolicyAttributeArgs;
import com.pulumi.aws.elb.LoadBalancerBackendServerPolicy;
import com.pulumi.aws.elb.LoadBalancerBackendServerPolicyArgs;
import com.pulumi.aws.elb.ListenerPolicy;
import com.pulumi.aws.elb.ListenerPolicyArgs;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;

public class App {
    public static void main(String[] args) {
        Pulumi.run(App::stack);
    }

    public static void stack(Context ctx) {
        var wu_tang = new LoadBalancer("wu-tang", LoadBalancerArgs.builder()        
            .availabilityZones("us-east-1a")
            .listeners(LoadBalancerListenerArgs.builder()
                .instancePort(443)
                .instanceProtocol("http")
                .lbPort(443)
                .lbProtocol("https")
                .sslCertificateId("arn:aws:iam::000000000000:server-certificate/wu-tang.net")
                .build())
            .tags(Map.of("Name", "wu-tang"))
            .build());

        var wu_tang_ca_pubkey_policy = new LoadBalancerPolicy("wu-tang-ca-pubkey-policy", LoadBalancerPolicyArgs.builder()        
            .loadBalancerName(wu_tang.name())
            .policyName("wu-tang-ca-pubkey-policy")
            .policyTypeName("PublicKeyPolicyType")
            .policyAttributes(LoadBalancerPolicyPolicyAttributeArgs.builder()
                .name("PublicKey")
                .value(Files.readString(Paths.get("wu-tang-pubkey")))
                .build())
            .build());

        var wu_tang_root_ca_backend_auth_policy = new LoadBalancerPolicy("wu-tang-root-ca-backend-auth-policy", LoadBalancerPolicyArgs.builder()        
            .loadBalancerName(wu_tang.name())
            .policyName("wu-tang-root-ca-backend-auth-policy")
            .policyTypeName("BackendServerAuthenticationPolicyType")
            .policyAttributes(LoadBalancerPolicyPolicyAttributeArgs.builder()
                .name("PublicKeyPolicyName")
                .value(aws_load_balancer_policy.wu-tang-root-ca-pubkey-policy().policy_name())
                .build())
            .build());

        var wu_tang_ssl = new LoadBalancerPolicy("wu-tang-ssl", LoadBalancerPolicyArgs.builder()        
            .loadBalancerName(wu_tang.name())
            .policyName("wu-tang-ssl")
            .policyTypeName("SSLNegotiationPolicyType")
            .policyAttributes(            
                LoadBalancerPolicyPolicyAttributeArgs.builder()
                    .name("ECDHE-ECDSA-AES128-GCM-SHA256")
                    .value("true")
                    .build(),
                LoadBalancerPolicyPolicyAttributeArgs.builder()
                    .name("Protocol-TLSv1.2")
                    .value("true")
                    .build())
            .build());

        var wu_tang_ssl_tls_1_1 = new LoadBalancerPolicy("wu-tang-ssl-tls-1-1", LoadBalancerPolicyArgs.builder()        
            .loadBalancerName(wu_tang.name())
            .policyName("wu-tang-ssl")
            .policyTypeName("SSLNegotiationPolicyType")
            .policyAttributes(LoadBalancerPolicyPolicyAttributeArgs.builder()
                .name("Reference-Security-Policy")
                .value("ELBSecurityPolicy-TLS-1-1-2017-01")
                .build())
            .build());

        var wu_tang_backend_auth_policies_443 = new LoadBalancerBackendServerPolicy("wu-tang-backend-auth-policies-443", LoadBalancerBackendServerPolicyArgs.builder()        
            .loadBalancerName(wu_tang.name())
            .instancePort(443)
            .policyNames(wu_tang_root_ca_backend_auth_policy.policyName())
            .build());

        var wu_tang_listener_policies_443 = new ListenerPolicy("wu-tang-listener-policies-443", ListenerPolicyArgs.builder()        
            .loadBalancerName(wu_tang.name())
            .loadBalancerPort(443)
            .policyNames(wu_tang_ssl.policyName())
            .build());

    }
}
```

</details>

<details>

<summary>typescript</summary>

```typescript
import * as pulumi from "@pulumi/pulumi";
import * as aws from "@pulumi/aws";
import * as fs from "fs";

const wu_tang = new aws.elb.LoadBalancer("wu-tang", {
    availabilityZones: ["us-east-1a"],
    listeners: [{
        instancePort: 443,
        instanceProtocol: "http",
        lbPort: 443,
        lbProtocol: "https",
        sslCertificateId: "arn:aws:iam::000000000000:server-certificate/wu-tang.net",
    }],
    tags: {
        Name: "wu-tang",
    },
});
const wu_tang_ca_pubkey_policy = new aws.elb.LoadBalancerPolicy("wu-tang-ca-pubkey-policy", {
    loadBalancerName: wu_tang.name,
    policyName: "wu-tang-ca-pubkey-policy",
    policyTypeName: "PublicKeyPolicyType",
    policyAttributes: [{
        name: "PublicKey",
        value: fs.readFileSync("wu-tang-pubkey"),
    }],
});
const wu_tang_root_ca_backend_auth_policy = new aws.elb.LoadBalancerPolicy("wu-tang-root-ca-backend-auth-policy", {
    loadBalancerName: wu_tang.name,
    policyName: "wu-tang-root-ca-backend-auth-policy",
    policyTypeName: "BackendServerAuthenticationPolicyType",
    policyAttributes: [{
        name: "PublicKeyPolicyName",
        value: aws_load_balancer_policy["wu-tang-root-ca-pubkey-policy"].policy_name,
    }],
});
const wu_tang_ssl = new aws.elb.LoadBalancerPolicy("wu-tang-ssl", {
    loadBalancerName: wu_tang.name,
    policyName: "wu-tang-ssl",
    policyTypeName: "SSLNegotiationPolicyType",
    policyAttributes: [
        {
            name: "ECDHE-ECDSA-AES128-GCM-SHA256",
            value: "true",
        },
        {
            name: "Protocol-TLSv1.2",
            value: "true",
        },
    ],
});
const wu_tang_ssl_tls_1_1 = new aws.elb.LoadBalancerPolicy("wu-tang-ssl-tls-1-1", {
    loadBalancerName: wu_tang.name,
    policyName: "wu-tang-ssl",
    policyTypeName: "SSLNegotiationPolicyType",
    policyAttributes: [{
        name: "Reference-Security-Policy",
        value: "ELBSecurityPolicy-TLS-1-1-2017-01",
    }],
});
const wu_tang_backend_auth_policies_443 = new aws.elb.LoadBalancerBackendServerPolicy("wu-tang-backend-auth-policies-443", {
    loadBalancerName: wu_tang.name,
    instancePort: 443,
    policyNames: [wu_tang_root_ca_backend_auth_policy.policyName],
});
const wu_tang_listener_policies_443 = new aws.elb.ListenerPolicy("wu-tang-listener-policies-443", {
    loadBalancerName: wu_tang.name,
    loadBalancerPort: 443,
    policyNames: [wu_tang_ssl.policyName],
});
```

</details>

<details>

<summary>python</summary>

```python
import pulumi
import pulumi_aws as aws

wu_tang = aws.elb.LoadBalancer("wu-tang",
    availability_zones=["us-east-1a"],
    listeners=[aws.elb.LoadBalancerListenerArgs(
        instance_port=443,
        instance_protocol="http",
        lb_port=443,
        lb_protocol="https",
        ssl_certificate_id="arn:aws:iam::000000000000:server-certificate/wu-tang.net",
    )],
    tags={
        "Name": "wu-tang",
    })
wu_tang_ca_pubkey_policy = aws.elb.LoadBalancerPolicy("wu-tang-ca-pubkey-policy",
    load_balancer_name=wu_tang.name,
    policy_name="wu-tang-ca-pubkey-policy",
    policy_type_name="PublicKeyPolicyType",
    policy_attributes=[aws.elb.LoadBalancerPolicyPolicyAttributeArgs(
        name="PublicKey",
        value=(lambda path: open(path).read())("wu-tang-pubkey"),
    )])
wu_tang_root_ca_backend_auth_policy = aws.elb.LoadBalancerPolicy("wu-tang-root-ca-backend-auth-policy",
    load_balancer_name=wu_tang.name,
    policy_name="wu-tang-root-ca-backend-auth-policy",
    policy_type_name="BackendServerAuthenticationPolicyType",
    policy_attributes=[aws.elb.LoadBalancerPolicyPolicyAttributeArgs(
        name="PublicKeyPolicyName",
        value=aws_load_balancer_policy["wu-tang-root-ca-pubkey-policy"]["policy_name"],
    )])
wu_tang_ssl = aws.elb.LoadBalancerPolicy("wu-tang-ssl",
    load_balancer_name=wu_tang.name,
    policy_name="wu-tang-ssl",
    policy_type_name="SSLNegotiationPolicyType",
    policy_attributes=[
        aws.elb.LoadBalancerPolicyPolicyAttributeArgs(
            name="ECDHE-ECDSA-AES128-GCM-SHA256",
            value="true",
        ),
        aws.elb.LoadBalancerPolicyPolicyAttributeArgs(
            name="Protocol-TLSv1.2",
            value="true",
        ),
    ])
wu_tang_ssl_tls_1_1 = aws.elb.LoadBalancerPolicy("wu-tang-ssl-tls-1-1",
    load_balancer_name=wu_tang.name,
    policy_name="wu-tang-ssl",
    policy_type_name="SSLNegotiationPolicyType",
    policy_attributes=[aws.elb.LoadBalancerPolicyPolicyAttributeArgs(
        name="Reference-Security-Policy",
        value="ELBSecurityPolicy-TLS-1-1-2017-01",
    )])
wu_tang_backend_auth_policies_443 = aws.elb.LoadBalancerBackendServerPolicy("wu-tang-backend-auth-policies-443",
    load_balancer_name=wu_tang.name,
    instance_port=443,
    policy_names=[wu_tang_root_ca_backend_auth_policy.policy_name])
wu_tang_listener_policies_443 = aws.elb.ListenerPolicy("wu-tang-listener-policies-443",
    load_balancer_name=wu_tang.name,
    load_balancer_port=443,
    policy_names=[wu_tang_ssl.policy_name])
```

</details>

<details>

<summary>csharp</summary>

```csharp
using System.Collections.Generic;
using System.IO;
using Pulumi;
using Aws = Pulumi.Aws;

return await Deployment.RunAsync(() => 
{
    var wu_tang = new Aws.Elb.LoadBalancer("wu-tang", new()
    {
        AvailabilityZones = new[]
        {
            "us-east-1a",
        },
        Listeners = new[]
        {
            new Aws.Elb.Inputs.LoadBalancerListenerArgs
            {
                InstancePort = 443,
                InstanceProtocol = "http",
                LbPort = 443,
                LbProtocol = "https",
                SslCertificateId = "arn:aws:iam::000000000000:server-certificate/wu-tang.net",
            },
        },
        Tags = 
        {
            { "Name", "wu-tang" },
        },
    });

    var wu_tang_ca_pubkey_policy = new Aws.Elb.LoadBalancerPolicy("wu-tang-ca-pubkey-policy", new()
    {
        LoadBalancerName = wu_tang.Name,
        PolicyName = "wu-tang-ca-pubkey-policy",
        PolicyTypeName = "PublicKeyPolicyType",
        PolicyAttributes = new[]
        {
            new Aws.Elb.Inputs.LoadBalancerPolicyPolicyAttributeArgs
            {
                Name = "PublicKey",
                Value = File.ReadAllText("wu-tang-pubkey"),
            },
        },
    });

    var wu_tang_root_ca_backend_auth_policy = new Aws.Elb.LoadBalancerPolicy("wu-tang-root-ca-backend-auth-policy", new()
    {
        LoadBalancerName = wu_tang.Name,
        PolicyName = "wu-tang-root-ca-backend-auth-policy",
        PolicyTypeName = "BackendServerAuthenticationPolicyType",
        PolicyAttributes = new[]
        {
            new Aws.Elb.Inputs.LoadBalancerPolicyPolicyAttributeArgs
            {
                Name = "PublicKeyPolicyName",
                Value = aws_load_balancer_policy.Wu_tang_root_ca_pubkey_policy.Policy_name,
            },
        },
    });

    var wu_tang_ssl = new Aws.Elb.LoadBalancerPolicy("wu-tang-ssl", new()
    {
        LoadBalancerName = wu_tang.Name,
        PolicyName = "wu-tang-ssl",
        PolicyTypeName = "SSLNegotiationPolicyType",
        PolicyAttributes = new[]
        {
            new Aws.Elb.Inputs.LoadBalancerPolicyPolicyAttributeArgs
            {
                Name = "ECDHE-ECDSA-AES128-GCM-SHA256",
                Value = "true",
            },
            new Aws.Elb.Inputs.LoadBalancerPolicyPolicyAttributeArgs
            {
                Name = "Protocol-TLSv1.2",
                Value = "true",
            },
        },
    });

    var wu_tang_ssl_tls_1_1 = new Aws.Elb.LoadBalancerPolicy("wu-tang-ssl-tls-1-1", new()
    {
        LoadBalancerName = wu_tang.Name,
        PolicyName = "wu-tang-ssl",
        PolicyTypeName = "SSLNegotiationPolicyType",
        PolicyAttributes = new[]
        {
            new Aws.Elb.Inputs.LoadBalancerPolicyPolicyAttributeArgs
            {
                Name = "Reference-Security-Policy",
                Value = "ELBSecurityPolicy-TLS-1-1-2017-01",
            },
        },
    });

    var wu_tang_backend_auth_policies_443 = new Aws.Elb.LoadBalancerBackendServerPolicy("wu-tang-backend-auth-policies-443", new()
    {
        LoadBalancerName = wu_tang.Name,
        InstancePort = 443,
        PolicyNames = new[]
        {
            wu_tang_root_ca_backend_auth_policy.PolicyName,
        },
    });

    var wu_tang_listener_policies_443 = new Aws.Elb.ListenerPolicy("wu-tang-listener-policies-443", new()
    {
        LoadBalancerName = wu_tang.Name,
        LoadBalancerPort = 443,
        PolicyNames = new[]
        {
            wu_tang_ssl.PolicyName,
        },
    });

});
```

</details>

<details>

<summary>go</summary>

```go
package main

import (
	"io/ioutil"

	"github.com/pulumi/pulumi-aws/sdk/v5/go/aws/elb"
	"github.com/pulumi/pulumi/sdk/v3/go/pulumi"
)

func readFileOrPanic(path string) pulumi.StringPtrInput {
	data, err := ioutil.ReadFile(path)
	if err != nil {
		panic(err.Error())
	}
	return pulumi.String(string(data))
}

func main() {
	pulumi.Run(func(ctx *pulumi.Context) error {
		_, err := elb.NewLoadBalancer(ctx, "wu-tang", &elb.LoadBalancerArgs{
			AvailabilityZones: pulumi.StringArray{
				pulumi.String("us-east-1a"),
			},
			Listeners: elb.LoadBalancerListenerArray{
				&elb.LoadBalancerListenerArgs{
					InstancePort:     pulumi.Int(443),
					InstanceProtocol: pulumi.String("http"),
					LbPort:           pulumi.Int(443),
					LbProtocol:       pulumi.String("https"),
					SslCertificateId: pulumi.String("arn:aws:iam::000000000000:server-certificate/wu-tang.net"),
				},
			},
			Tags: pulumi.StringMap{
				"Name": pulumi.String("wu-tang"),
			},
		})
		if err != nil {
			return err
		}
		_, err = elb.NewLoadBalancerPolicy(ctx, "wu-tang-ca-pubkey-policy", &elb.LoadBalancerPolicyArgs{
			LoadBalancerName: wu_tang.Name,
			PolicyName:       pulumi.String("wu-tang-ca-pubkey-policy"),
			PolicyTypeName:   pulumi.String("PublicKeyPolicyType"),
			PolicyAttributes: elb.LoadBalancerPolicyPolicyAttributeArray{
				&elb.LoadBalancerPolicyPolicyAttributeArgs{
					Name:  pulumi.String("PublicKey"),
					Value: readFileOrPanic("wu-tang-pubkey"),
				},
			},
		})
		if err != nil {
			return err
		}
		_, err = elb.NewLoadBalancerPolicy(ctx, "wu-tang-root-ca-backend-auth-policy", &elb.LoadBalancerPolicyArgs{
			LoadBalancerName: wu_tang.Name,
			PolicyName:       pulumi.String("wu-tang-root-ca-backend-auth-policy"),
			PolicyTypeName:   pulumi.String("BackendServerAuthenticationPolicyType"),
			PolicyAttributes: elb.LoadBalancerPolicyPolicyAttributeArray{
				&elb.LoadBalancerPolicyPolicyAttributeArgs{
					Name:  pulumi.String("PublicKeyPolicyName"),
					Value: pulumi.Any(aws_load_balancer_policy.Wu - tang - root - ca - pubkey - policy.Policy_name),
				},
			},
		})
		if err != nil {
			return err
		}
		_, err = elb.NewLoadBalancerPolicy(ctx, "wu-tang-ssl", &elb.LoadBalancerPolicyArgs{
			LoadBalancerName: wu_tang.Name,
			PolicyName:       pulumi.String("wu-tang-ssl"),
			PolicyTypeName:   pulumi.String("SSLNegotiationPolicyType"),
			PolicyAttributes: elb.LoadBalancerPolicyPolicyAttributeArray{
				&elb.LoadBalancerPolicyPolicyAttributeArgs{
					Name:  pulumi.String("ECDHE-ECDSA-AES128-GCM-SHA256"),
					Value: pulumi.String("true"),
				},
				&elb.LoadBalancerPolicyPolicyAttributeArgs{
					Name:  pulumi.String("Protocol-TLSv1.2"),
					Value: pulumi.String("true"),
				},
			},
		})
		if err != nil {
			return err
		}
		_, err = elb.NewLoadBalancerPolicy(ctx, "wu-tang-ssl-tls-1-1", &elb.LoadBalancerPolicyArgs{
			LoadBalancerName: wu_tang.Name,
			PolicyName:       pulumi.String("wu-tang-ssl"),
			PolicyTypeName:   pulumi.String("SSLNegotiationPolicyType"),
			PolicyAttributes: elb.LoadBalancerPolicyPolicyAttributeArray{
				&elb.LoadBalancerPolicyPolicyAttributeArgs{
					Name:  pulumi.String("Reference-Security-Policy"),
					Value: pulumi.String("ELBSecurityPolicy-TLS-1-1-2017-01"),
				},
			},
		})
		if err != nil {
			return err
		}
		_, err = elb.NewLoadBalancerBackendServerPolicy(ctx, "wu-tang-backend-auth-policies-443", &elb.LoadBalancerBackendServerPolicyArgs{
			LoadBalancerName: wu_tang.Name,
			InstancePort:     pulumi.Int(443),
			PolicyNames: pulumi.StringArray{
				wu_tang_root_ca_backend_auth_policy.PolicyName,
			},
		})
		if err != nil {
			return err
		}
		_, err = elb.NewListenerPolicy(ctx, "wu-tang-listener-policies-443", &elb.ListenerPolicyArgs{
			LoadBalancerName: wu_tang.Name,
			LoadBalancerPort: pulumi.Int(443),
			PolicyNames: pulumi.StringArray{
				wu_tang_ssl.PolicyName,
			},
		})
		if err != nil {
			return err
		}
		return nil
	})
}
```

</details>

## [*partial failure*] Associate Web ACL (v2)

### HCL

```terraform
resource "aws_appsync_graphql_api" "example" {
  authentication_type = "API_KEY"
  name                = "example"
}

resource "aws_wafv2_web_acl_association" "example" {
  resource_arn = aws_appsync_graphql_api.example.arn
  web_acl_arn  = aws_wafv2_web_acl.example.arn
}

resource "aws_wafv2_web_acl" "example" {
  name        = "managed-rule-example"
  description = "Example of a managed rule."
  scope       = "REGIONAL"

  default_action {
    allow {}
  }

  rule {
    name     = "rule-1"
    priority = 1

    override_action {
      block {}
    }

    statement {
      managed_rule_group_statement {
        name        = "AWSManagedRulesCommonRuleSet"
        vendor_name = "AWS"
      }
    }

    visibility_config {
      cloudwatch_metrics_enabled = false
      metric_name                = "friendly-rule-metric-name"
      sampled_requests_enabled   = false
    }
  }

  visibility_config {
    cloudwatch_metrics_enabled = false
    metric_name                = "friendly-metric-name"
    sampled_requests_enabled   = false
  }
}

```

### Failed Languages

#### typescript

```text
:0,0-0: unknown property 'block' among [count none]; , and 4 other diagnostic(s)
```

#### python

```text
:0,0-0: unknown property 'block' among [none count]; , and 4 other diagnostic(s)
```

#### csharp

```text
:0,0-0: unknown property 'block' among [none count]; , and 4 other diagnostic(s)
```

#### go

```text
:0,0-0: unknown property 'block' among [count none]; , and 4 other diagnostic(s)
```

### Successes

<details>

<summary>yaml</summary>

```yaml
resources:
  exampleGraphQLApi:
    type: aws:appsync:GraphQLApi
    properties:
      authenticationType: API_KEY
  exampleWebAclAssociation:
    type: aws:wafv2:WebAclAssociation
    properties:
      resourceArn: ${exampleGraphQLApi.arn}
      webAclArn: ${exampleWebAcl.arn}
  exampleWebAcl:
    type: aws:wafv2:WebAcl
    properties:
      description: Example of a managed rule.
      scope: REGIONAL
      defaultAction:
        allow: {}
      rules:
        - name: rule-1
          priority: 1
          overrideAction:
            block:
              - {}
          statement:
            managedRuleGroupStatement:
              name: AWSManagedRulesCommonRuleSet
              vendorName: AWS
          visibilityConfig:
            cloudwatchMetricsEnabled: false
            metricName: friendly-rule-metric-name
            sampledRequestsEnabled: false
      visibilityConfig:
        cloudwatchMetricsEnabled: false
        metricName: friendly-metric-name
        sampledRequestsEnabled: false
```

</details>

<details>

<summary>java</summary>

```java
package generated_program;

import com.pulumi.Context;
import com.pulumi.Pulumi;
import com.pulumi.core.Output;
import com.pulumi.aws.appsync.GraphQLApi;
import com.pulumi.aws.appsync.GraphQLApiArgs;
import com.pulumi.aws.wafv2.WebAcl;
import com.pulumi.aws.wafv2.WebAclArgs;
import com.pulumi.aws.wafv2.inputs.WebAclDefaultActionArgs;
import com.pulumi.aws.wafv2.inputs.WebAclDefaultActionAllowArgs;
import com.pulumi.aws.wafv2.inputs.WebAclRuleArgs;
import com.pulumi.aws.wafv2.inputs.WebAclRuleOverrideActionArgs;
import com.pulumi.aws.wafv2.inputs.WebAclRuleStatementArgs;
import com.pulumi.aws.wafv2.inputs.WebAclRuleStatementManagedRuleGroupStatementArgs;
import com.pulumi.aws.wafv2.inputs.WebAclRuleVisibilityConfigArgs;
import com.pulumi.aws.wafv2.inputs.WebAclVisibilityConfigArgs;
import com.pulumi.aws.wafv2.WebAclAssociation;
import com.pulumi.aws.wafv2.WebAclAssociationArgs;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;

public class App {
    public static void main(String[] args) {
        Pulumi.run(App::stack);
    }

    public static void stack(Context ctx) {
        var exampleGraphQLApi = new GraphQLApi("exampleGraphQLApi", GraphQLApiArgs.builder()        
            .authenticationType("API_KEY")
            .build());

        var exampleWebAcl = new WebAcl("exampleWebAcl", WebAclArgs.builder()        
            .description("Example of a managed rule.")
            .scope("REGIONAL")
            .defaultAction(WebAclDefaultActionArgs.builder()
                .allow()
                .build())
            .rules(WebAclRuleArgs.builder()
                .name("rule-1")
                .priority(1)
                .overrideAction(WebAclRuleOverrideActionArgs.builder()
                    .block()
                    .build())
                .statement(WebAclRuleStatementArgs.builder()
                    .managedRuleGroupStatement(WebAclRuleStatementManagedRuleGroupStatementArgs.builder()
                        .name("AWSManagedRulesCommonRuleSet")
                        .vendorName("AWS")
                        .build())
                    .build())
                .visibilityConfig(WebAclRuleVisibilityConfigArgs.builder()
                    .cloudwatchMetricsEnabled(false)
                    .metricName("friendly-rule-metric-name")
                    .sampledRequestsEnabled(false)
                    .build())
                .build())
            .visibilityConfig(WebAclVisibilityConfigArgs.builder()
                .cloudwatchMetricsEnabled(false)
                .metricName("friendly-metric-name")
                .sampledRequestsEnabled(false)
                .build())
            .build());

        var exampleWebAclAssociation = new WebAclAssociation("exampleWebAclAssociation", WebAclAssociationArgs.builder()        
            .resourceArn(exampleGraphQLApi.arn())
            .webAclArn(exampleWebAcl.arn())
            .build());

    }
}
```

</details>

## [**complete failure**] With External Content

### HCL

```terraform
$ aws connect describe-contact-flow --instance-id 1b3c5d8-1b3c-1b3c-1b3c-1b3c5d81b3c5 --contact-flow-id c1d4e5f6-1b3c-1b3c-1b3c-c1d4e5f6c1d4e5 --region us-west-2 | jq '.ContactFlow.Content | fromjson' > contact_flow.json

```

### Failed Languages

#### typescript

```text
:0,0-1: Invalid character; This character is not used within the language., and 4 other diagnostic(s)
```

#### python

```text
:0,0-1: Invalid character; This character is not used within the language., and 4 other diagnostic(s)
```

#### csharp

```text
:0,0-1: Invalid character; This character is not used within the language., and 4 other diagnostic(s)
```

#### go

```text
:0,0-1: Invalid character; This character is not used within the language., and 4 other diagnostic(s)
```

#### yaml

```text
:0,0-1: Invalid character; This character is not used within the language., and 4 other diagnostic(s)
```

#### java

```text
:0,0-1: Invalid character; This character is not used within the language., and 4 other diagnostic(s)
```

## [*partial failure*] With External Content

### HCL

```terraform
resource "aws_connect_contact_flow" "test" {
  instance_id  = "aaaaaaaa-bbbb-cccc-dddd-111111111111"
  name         = "Test"
  description  = "Test Contact Flow Description"
  type         = "CONTACT_FLOW"
  filename     = "contact_flow.json"
  content_hash = filebase64sha256("contact_flow.json")
  tags = {
    "Name"        = "Test Contact Flow",
    "Application" = "Terraform",
    "Method"      = "Create"
  }
}

```

### Failed Languages

#### yaml

```text
.pp:5,17-54: Failed to generate YAML program: Unknown Function; YAML does not support Fn::filebase64sha256.
```

### Successes

<details>

<summary>java</summary>

```java
package generated_program;

import com.pulumi.Context;
import com.pulumi.Pulumi;
import com.pulumi.core.Output;
import com.pulumi.aws.connect.ContactFlow;
import com.pulumi.aws.connect.ContactFlowArgs;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;

public class App {
    public static void main(String[] args) {
        Pulumi.run(App::stack);
    }

    public static void stack(Context ctx) {
        var test = new ContactFlow("test", ContactFlowArgs.builder()        
            .instanceId("aaaaaaaa-bbbb-cccc-dddd-111111111111")
            .description("Test Contact Flow Description")
            .type("CONTACT_FLOW")
            .filename("contact_flow.json")
            .contentHash(computeFileBase64Sha256("contact_flow.json"))
            .tags(Map.ofEntries(
                Map.entry("Name", "Test Contact Flow"),
                Map.entry("Application", "Terraform"),
                Map.entry("Method", "Create")
            ))
            .build());

    }
}
```

</details>

<details>

<summary>typescript</summary>

```typescript
import * as pulumi from "@pulumi/pulumi";
import * as aws from "@pulumi/aws";
import * as crypto from "crypto";
import * as fs from "fs";

func computeFilebase64sha256(path string) string {
	const fileData = Buffer.from(fs.readFileSync(path), 'binary')
	return crypto.createHash('sha256').update(fileData).digest('hex')
}

const test = new aws.connect.ContactFlow("test", {
    instanceId: "aaaaaaaa-bbbb-cccc-dddd-111111111111",
    description: "Test Contact Flow Description",
    type: "CONTACT_FLOW",
    filename: "contact_flow.json",
    contentHash: computeFilebase64sha256("contact_flow.json"),
    tags: {
        Name: "Test Contact Flow",
        Application: "Terraform",
        Method: "Create",
    },
});
```

</details>

<details>

<summary>python</summary>

```python
import pulumi
import base64
import hashlib
import pulumi_aws as aws

def computeFilebase64sha256(path):
	fileData = open(path).read().encode()
	hashedData = hashlib.sha256(fileData.encode()).digest()
	return base64.b64encode(hashedData).decode()

test = aws.connect.ContactFlow("test",
    instance_id="aaaaaaaa-bbbb-cccc-dddd-111111111111",
    description="Test Contact Flow Description",
    type="CONTACT_FLOW",
    filename="contact_flow.json",
    content_hash=computeFilebase64sha256("contact_flow.json"),
    tags={
        "Name": "Test Contact Flow",
        "Application": "Terraform",
        "Method": "Create",
    })
```

</details>

<details>

<summary>csharp</summary>

```csharp
using System;
using System.Collections.Generic;
using System.IO;
using System.Security.Cryptography;
using System.Text;
using Pulumi;
using Aws = Pulumi.Aws;

	private static string ComputeFileBase64Sha256(string path) {
		var fileData = Encoding.UTF8.GetBytes(File.ReadAllText(path));
		var hashData = SHA256.Create().ComputeHash(fileData);
		return Convert.ToBase64String(hashData);
	}

return await Deployment.RunAsync(() => 
{
    var test = new Aws.Connect.ContactFlow("test", new()
    {
        InstanceId = "aaaaaaaa-bbbb-cccc-dddd-111111111111",
        Description = "Test Contact Flow Description",
        Type = "CONTACT_FLOW",
        Filename = "contact_flow.json",
        ContentHash = ComputeFileBase64Sha256("contact_flow.json"),
        Tags = 
        {
            { "Name", "Test Contact Flow" },
            { "Application", "Terraform" },
            { "Method", "Create" },
        },
    });

});
```

</details>

<details>

<summary>go</summary>

```go
package main

import (
	"crypto/sha256"
	"fmt"
	"io/ioutil"

	"github.com/pulumi/pulumi-aws/sdk/v5/go/aws/connect"
	"github.com/pulumi/pulumi/sdk/v3/go/pulumi"
)

func filebase64sha256OrPanic(path string) pulumi.StringPtrInput {
	if fileData, err := ioutil.ReadFile(path); err == nil {
		hashedData := sha256.Sum256([]byte(fileData))
		return pulumi.String(base64.StdEncoding.EncodeToString(hashedData[:]))
	} else {
		panic(err.Error())
	}
}

func main() {
	pulumi.Run(func(ctx *pulumi.Context) error {
		_, err := connect.NewContactFlow(ctx, "test", &connect.ContactFlowArgs{
			InstanceId:  pulumi.String("aaaaaaaa-bbbb-cccc-dddd-111111111111"),
			Description: pulumi.String("Test Contact Flow Description"),
			Type:        pulumi.String("CONTACT_FLOW"),
			Filename:    pulumi.String("contact_flow.json"),
			ContentHash: filebase64sha256OrPanic("contact_flow.json"),
			Tags: pulumi.StringMap{
				"Name":        pulumi.String("Test Contact Flow"),
				"Application": pulumi.String("Terraform"),
				"Method":      pulumi.String("Create"),
			},
		})
		if err != nil {
			return err
		}
		return nil
	})
}
```

</details>

## [*partial failure*] With AppMesh Proxy

### HCL

```terraform
resource "aws_ecs_task_definition" "service" {
  family                = "service"
  container_definitions = file("task-definitions/service.json")

  proxy_configuration {
    type           = "APPMESH"
    container_name = "applicationContainerName"
    properties = {
      AppPorts         = "8080"
      EgressIgnoredIPs = "169.254.170.2,169.254.169.254"
      IgnoredUID       = "1337"
      ProxyEgressPort  = 15001
      ProxyIngressPort = 15000
    }
  }
}

```

### Failed Languages

#### yaml

```text
.pp:2,26-67: Failed to generate YAML program: Unknown Function; YAML does not support Fn::readFile.
```

### Successes

<details>

<summary>go</summary>

```go
package main

import (
	"io/ioutil"

	"github.com/pulumi/pulumi-aws/sdk/v5/go/aws/ecs"
	"github.com/pulumi/pulumi/sdk/v3/go/pulumi"
)

func readFileOrPanic(path string) pulumi.StringPtrInput {
	data, err := ioutil.ReadFile(path)
	if err != nil {
		panic(err.Error())
	}
	return pulumi.String(string(data))
}

func main() {
	pulumi.Run(func(ctx *pulumi.Context) error {
		_, err := ecs.NewTaskDefinition(ctx, "service", &ecs.TaskDefinitionArgs{
			Family:               pulumi.String("service"),
			ContainerDefinitions: readFileOrPanic("task-definitions/service.json"),
			ProxyConfiguration: &ecs.TaskDefinitionProxyConfigurationArgs{
				Type:          pulumi.String("APPMESH"),
				ContainerName: pulumi.String("applicationContainerName"),
				Properties: pulumi.StringMap{
					"AppPorts":         pulumi.String("8080"),
					"EgressIgnoredIPs": pulumi.String("169.254.170.2,169.254.169.254"),
					"IgnoredUID":       pulumi.String("1337"),
					"ProxyEgressPort":  pulumi.String("15001"),
					"ProxyIngressPort": pulumi.String("15000"),
				},
			},
		})
		if err != nil {
			return err
		}
		return nil
	})
}
```

</details>

<details>

<summary>java</summary>

```java
package generated_program;

import com.pulumi.Context;
import com.pulumi.Pulumi;
import com.pulumi.core.Output;
import com.pulumi.aws.ecs.TaskDefinition;
import com.pulumi.aws.ecs.TaskDefinitionArgs;
import com.pulumi.aws.ecs.inputs.TaskDefinitionProxyConfigurationArgs;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;

public class App {
    public static void main(String[] args) {
        Pulumi.run(App::stack);
    }

    public static void stack(Context ctx) {
        var service = new TaskDefinition("service", TaskDefinitionArgs.builder()        
            .family("service")
            .containerDefinitions(Files.readString(Paths.get("task-definitions/service.json")))
            .proxyConfiguration(TaskDefinitionProxyConfigurationArgs.builder()
                .type("APPMESH")
                .containerName("applicationContainerName")
                .properties(Map.ofEntries(
                    Map.entry("AppPorts", "8080"),
                    Map.entry("EgressIgnoredIPs", "169.254.170.2,169.254.169.254"),
                    Map.entry("IgnoredUID", "1337"),
                    Map.entry("ProxyEgressPort", 15001),
                    Map.entry("ProxyIngressPort", 15000)
                ))
                .build())
            .build());

    }
}
```

</details>

<details>

<summary>typescript</summary>

```typescript
import * as pulumi from "@pulumi/pulumi";
import * as aws from "@pulumi/aws";
import * as fs from "fs";

const service = new aws.ecs.TaskDefinition("service", {
    family: "service",
    containerDefinitions: fs.readFileSync("task-definitions/service.json"),
    proxyConfiguration: {
        type: "APPMESH",
        containerName: "applicationContainerName",
        properties: {
            AppPorts: "8080",
            EgressIgnoredIPs: "169.254.170.2,169.254.169.254",
            IgnoredUID: "1337",
            ProxyEgressPort: "15001",
            ProxyIngressPort: "15000",
        },
    },
});
```

</details>

<details>

<summary>python</summary>

```python
import pulumi
import pulumi_aws as aws

service = aws.ecs.TaskDefinition("service",
    family="service",
    container_definitions=(lambda path: open(path).read())("task-definitions/service.json"),
    proxy_configuration=aws.ecs.TaskDefinitionProxyConfigurationArgs(
        type="APPMESH",
        container_name="applicationContainerName",
        properties={
            "AppPorts": "8080",
            "EgressIgnoredIPs": "169.254.170.2,169.254.169.254",
            "IgnoredUID": "1337",
            "ProxyEgressPort": "15001",
            "ProxyIngressPort": "15000",
        },
    ))
```

</details>

<details>

<summary>csharp</summary>

```csharp
using System.Collections.Generic;
using System.IO;
using Pulumi;
using Aws = Pulumi.Aws;

return await Deployment.RunAsync(() => 
{
    var service = new Aws.Ecs.TaskDefinition("service", new()
    {
        Family = "service",
        ContainerDefinitions = File.ReadAllText("task-definitions/service.json"),
        ProxyConfiguration = new Aws.Ecs.Inputs.TaskDefinitionProxyConfigurationArgs
        {
            Type = "APPMESH",
            ContainerName = "applicationContainerName",
            Properties = 
            {
                { "AppPorts", "8080" },
                { "EgressIgnoredIPs", "169.254.170.2,169.254.169.254" },
                { "IgnoredUID", "1337" },
                { "ProxyEgressPort", "15001" },
                { "ProxyIngressPort", "15000" },
            },
        },
    });

});
```

</details>

## [*partial failure*] Example Using `docker_volume_configuration`

### HCL

```terraform
resource "aws_ecs_task_definition" "service" {
  family                = "service"
  container_definitions = file("task-definitions/service.json")

  volume {
    name = "service-storage"

    docker_volume_configuration {
      scope         = "shared"
      autoprovision = true
      driver        = "local"

      driver_opts = {
        "type"   = "nfs"
        "device" = "${aws_efs_file_system.fs.dns_name}:/"
        "o"      = "addr=${aws_efs_file_system.fs.dns_name},rsize=1048576,wsize=1048576,hard,timeo=600,retrans=2,noresvport"
      }
    }
  }
}

```

### Failed Languages

#### yaml

```text
.pp:2,26-67: Failed to generate YAML program: Unknown Function; YAML does not support Fn::readFile.
```

### Successes

<details>

<summary>csharp</summary>

```csharp
using System.Collections.Generic;
using System.IO;
using Pulumi;
using Aws = Pulumi.Aws;

return await Deployment.RunAsync(() => 
{
    var service = new Aws.Ecs.TaskDefinition("service", new()
    {
        Family = "service",
        ContainerDefinitions = File.ReadAllText("task-definitions/service.json"),
        Volumes = new[]
        {
            new Aws.Ecs.Inputs.TaskDefinitionVolumeArgs
            {
                Name = "service-storage",
                DockerVolumeConfiguration = new Aws.Ecs.Inputs.TaskDefinitionVolumeDockerVolumeConfigurationArgs
                {
                    Scope = "shared",
                    Autoprovision = true,
                    Driver = "local",
                    DriverOpts = 
                    {
                        { "type", "nfs" },
                        { "device", $"{aws_efs_file_system.Fs.Dns_name}:/" },
                        { "o", $"addr={aws_efs_file_system.Fs.Dns_name},rsize=1048576,wsize=1048576,hard,timeo=600,retrans=2,noresvport" },
                    },
                },
            },
        },
    });

});
```

</details>

<details>

<summary>go</summary>

```go
package main

import (
	"fmt"
	"io/ioutil"

	"github.com/pulumi/pulumi-aws/sdk/v5/go/aws/ecs"
	"github.com/pulumi/pulumi/sdk/v3/go/pulumi"
)

func readFileOrPanic(path string) pulumi.StringPtrInput {
	data, err := ioutil.ReadFile(path)
	if err != nil {
		panic(err.Error())
	}
	return pulumi.String(string(data))
}

func main() {
	pulumi.Run(func(ctx *pulumi.Context) error {
		_, err := ecs.NewTaskDefinition(ctx, "service", &ecs.TaskDefinitionArgs{
			Family:               pulumi.String("service"),
			ContainerDefinitions: readFileOrPanic("task-definitions/service.json"),
			Volumes: ecs.TaskDefinitionVolumeArray{
				&ecs.TaskDefinitionVolumeArgs{
					Name: pulumi.String("service-storage"),
					DockerVolumeConfiguration: &ecs.TaskDefinitionVolumeDockerVolumeConfigurationArgs{
						Scope:         pulumi.String("shared"),
						Autoprovision: pulumi.Bool(true),
						Driver:        pulumi.String("local"),
						DriverOpts: pulumi.StringMap{
							"type":   pulumi.String("nfs"),
							"device": pulumi.String(fmt.Sprintf("%v:/", aws_efs_file_system.Fs.Dns_name)),
							"o":      pulumi.String(fmt.Sprintf("addr=%v,rsize=1048576,wsize=1048576,hard,timeo=600,retrans=2,noresvport", aws_efs_file_system.Fs.Dns_name)),
						},
					},
				},
			},
		})
		if err != nil {
			return err
		}
		return nil
	})
}
```

</details>

<details>

<summary>java</summary>

```java
package generated_program;

import com.pulumi.Context;
import com.pulumi.Pulumi;
import com.pulumi.core.Output;
import com.pulumi.aws.ecs.TaskDefinition;
import com.pulumi.aws.ecs.TaskDefinitionArgs;
import com.pulumi.aws.ecs.inputs.TaskDefinitionVolumeArgs;
import com.pulumi.aws.ecs.inputs.TaskDefinitionVolumeDockerVolumeConfigurationArgs;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;

public class App {
    public static void main(String[] args) {
        Pulumi.run(App::stack);
    }

    public static void stack(Context ctx) {
        var service = new TaskDefinition("service", TaskDefinitionArgs.builder()        
            .family("service")
            .containerDefinitions(Files.readString(Paths.get("task-definitions/service.json")))
            .volumes(TaskDefinitionVolumeArgs.builder()
                .name("service-storage")
                .dockerVolumeConfiguration(TaskDefinitionVolumeDockerVolumeConfigurationArgs.builder()
                    .scope("shared")
                    .autoprovision(true)
                    .driver("local")
                    .driverOpts(Map.ofEntries(
                        Map.entry("type", "nfs"),
                        Map.entry("device", String.format("%s:/", aws_efs_file_system.fs().dns_name())),
                        Map.entry("o", String.format("addr=%s,rsize=1048576,wsize=1048576,hard,timeo=600,retrans=2,noresvport", aws_efs_file_system.fs().dns_name()))
                    ))
                    .build())
                .build())
            .build());

    }
}
```

</details>

<details>

<summary>typescript</summary>

```typescript
import * as pulumi from "@pulumi/pulumi";
import * as aws from "@pulumi/aws";
import * as fs from "fs";

const service = new aws.ecs.TaskDefinition("service", {
    family: "service",
    containerDefinitions: fs.readFileSync("task-definitions/service.json"),
    volumes: [{
        name: "service-storage",
        dockerVolumeConfiguration: {
            scope: "shared",
            autoprovision: true,
            driver: "local",
            driverOpts: {
                type: "nfs",
                device: `${aws_efs_file_system.fs.dns_name}:/`,
                o: `addr=${aws_efs_file_system.fs.dns_name},rsize=1048576,wsize=1048576,hard,timeo=600,retrans=2,noresvport`,
            },
        },
    }],
});
```

</details>

<details>

<summary>python</summary>

```python
import pulumi
import pulumi_aws as aws

service = aws.ecs.TaskDefinition("service",
    family="service",
    container_definitions=(lambda path: open(path).read())("task-definitions/service.json"),
    volumes=[aws.ecs.TaskDefinitionVolumeArgs(
        name="service-storage",
        docker_volume_configuration=aws.ecs.TaskDefinitionVolumeDockerVolumeConfigurationArgs(
            scope="shared",
            autoprovision=True,
            driver="local",
            driver_opts={
                "type": "nfs",
                "device": f"{aws_efs_file_system['fs']['dns_name']}:/",
                "o": f"addr={aws_efs_file_system['fs']['dns_name']},rsize=1048576,wsize=1048576,hard,timeo=600,retrans=2,noresvport",
            },
        ),
    )])
```

</details>

## [*partial failure*] Example Using `efs_volume_configuration`

### HCL

```terraform
resource "aws_ecs_task_definition" "service" {
  family                = "service"
  container_definitions = file("task-definitions/service.json")

  volume {
    name = "service-storage"

    efs_volume_configuration {
      file_system_id          = aws_efs_file_system.fs.id
      root_directory          = "/opt/data"
      transit_encryption      = "ENABLED"
      transit_encryption_port = 2999
      authorization_config {
        access_point_id = aws_efs_access_point.test.id
        iam             = "ENABLED"
      }
    }
  }
}

```

### Failed Languages

#### yaml

```text
.pp:2,26-67: Failed to generate YAML program: Unknown Function; YAML does not support Fn::readFile.
```

### Successes

<details>

<summary>typescript</summary>

```typescript
import * as pulumi from "@pulumi/pulumi";
import * as aws from "@pulumi/aws";
import * as fs from "fs";

const service = new aws.ecs.TaskDefinition("service", {
    family: "service",
    containerDefinitions: fs.readFileSync("task-definitions/service.json"),
    volumes: [{
        name: "service-storage",
        efsVolumeConfiguration: {
            fileSystemId: aws_efs_file_system.fs.id,
            rootDirectory: "/opt/data",
            transitEncryption: "ENABLED",
            transitEncryptionPort: 2999,
            authorizationConfig: {
                accessPointId: aws_efs_access_point.test.id,
                iam: "ENABLED",
            },
        },
    }],
});
```

</details>

<details>

<summary>python</summary>

```python
import pulumi
import pulumi_aws as aws

service = aws.ecs.TaskDefinition("service",
    family="service",
    container_definitions=(lambda path: open(path).read())("task-definitions/service.json"),
    volumes=[aws.ecs.TaskDefinitionVolumeArgs(
        name="service-storage",
        efs_volume_configuration=aws.ecs.TaskDefinitionVolumeEfsVolumeConfigurationArgs(
            file_system_id=aws_efs_file_system["fs"]["id"],
            root_directory="/opt/data",
            transit_encryption="ENABLED",
            transit_encryption_port=2999,
            authorization_config=aws.ecs.TaskDefinitionVolumeEfsVolumeConfigurationAuthorizationConfigArgs(
                access_point_id=aws_efs_access_point["test"]["id"],
                iam="ENABLED",
            ),
        ),
    )])
```

</details>

<details>

<summary>csharp</summary>

```csharp
using System.Collections.Generic;
using System.IO;
using Pulumi;
using Aws = Pulumi.Aws;

return await Deployment.RunAsync(() => 
{
    var service = new Aws.Ecs.TaskDefinition("service", new()
    {
        Family = "service",
        ContainerDefinitions = File.ReadAllText("task-definitions/service.json"),
        Volumes = new[]
        {
            new Aws.Ecs.Inputs.TaskDefinitionVolumeArgs
            {
                Name = "service-storage",
                EfsVolumeConfiguration = new Aws.Ecs.Inputs.TaskDefinitionVolumeEfsVolumeConfigurationArgs
                {
                    FileSystemId = aws_efs_file_system.Fs.Id,
                    RootDirectory = "/opt/data",
                    TransitEncryption = "ENABLED",
                    TransitEncryptionPort = 2999,
                    AuthorizationConfig = new Aws.Ecs.Inputs.TaskDefinitionVolumeEfsVolumeConfigurationAuthorizationConfigArgs
                    {
                        AccessPointId = aws_efs_access_point.Test.Id,
                        Iam = "ENABLED",
                    },
                },
            },
        },
    });

});
```

</details>

<details>

<summary>go</summary>

```go
package main

import (
	"io/ioutil"

	"github.com/pulumi/pulumi-aws/sdk/v5/go/aws/ecs"
	"github.com/pulumi/pulumi/sdk/v3/go/pulumi"
)

func readFileOrPanic(path string) pulumi.StringPtrInput {
	data, err := ioutil.ReadFile(path)
	if err != nil {
		panic(err.Error())
	}
	return pulumi.String(string(data))
}

func main() {
	pulumi.Run(func(ctx *pulumi.Context) error {
		_, err := ecs.NewTaskDefinition(ctx, "service", &ecs.TaskDefinitionArgs{
			Family:               pulumi.String("service"),
			ContainerDefinitions: readFileOrPanic("task-definitions/service.json"),
			Volumes: ecs.TaskDefinitionVolumeArray{
				&ecs.TaskDefinitionVolumeArgs{
					Name: pulumi.String("service-storage"),
					EfsVolumeConfiguration: &ecs.TaskDefinitionVolumeEfsVolumeConfigurationArgs{
						FileSystemId:          pulumi.Any(aws_efs_file_system.Fs.Id),
						RootDirectory:         pulumi.String("/opt/data"),
						TransitEncryption:     pulumi.String("ENABLED"),
						TransitEncryptionPort: pulumi.Int(2999),
						AuthorizationConfig: &ecs.TaskDefinitionVolumeEfsVolumeConfigurationAuthorizationConfigArgs{
							AccessPointId: pulumi.Any(aws_efs_access_point.Test.Id),
							Iam:           pulumi.String("ENABLED"),
						},
					},
				},
			},
		})
		if err != nil {
			return err
		}
		return nil
	})
}
```

</details>

<details>

<summary>java</summary>

```java
package generated_program;

import com.pulumi.Context;
import com.pulumi.Pulumi;
import com.pulumi.core.Output;
import com.pulumi.aws.ecs.TaskDefinition;
import com.pulumi.aws.ecs.TaskDefinitionArgs;
import com.pulumi.aws.ecs.inputs.TaskDefinitionVolumeArgs;
import com.pulumi.aws.ecs.inputs.TaskDefinitionVolumeEfsVolumeConfigurationArgs;
import com.pulumi.aws.ecs.inputs.TaskDefinitionVolumeEfsVolumeConfigurationAuthorizationConfigArgs;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;

public class App {
    public static void main(String[] args) {
        Pulumi.run(App::stack);
    }

    public static void stack(Context ctx) {
        var service = new TaskDefinition("service", TaskDefinitionArgs.builder()        
            .family("service")
            .containerDefinitions(Files.readString(Paths.get("task-definitions/service.json")))
            .volumes(TaskDefinitionVolumeArgs.builder()
                .name("service-storage")
                .efsVolumeConfiguration(TaskDefinitionVolumeEfsVolumeConfigurationArgs.builder()
                    .fileSystemId(aws_efs_file_system.fs().id())
                    .rootDirectory("/opt/data")
                    .transitEncryption("ENABLED")
                    .transitEncryptionPort(2999)
                    .authorizationConfig(TaskDefinitionVolumeEfsVolumeConfigurationAuthorizationConfigArgs.builder()
                        .accessPointId(aws_efs_access_point.test().id())
                        .iam("ENABLED")
                        .build())
                    .build())
                .build())
            .build());

    }
}
```

</details>

## [*partial failure*] Example Using `fsx_windows_file_server_volume_configuration`

### HCL

```terraform
resource "aws_ecs_task_definition" "service" {
  family                = "service"
  container_definitions = file("task-definitions/service.json")

  volume {
    name = "service-storage"

    fsx_windows_file_server_volume_configuration {
      file_system_id = aws_fsx_windows_file_system.test.id
      root_directory = "\\data"

      authorization_config {
        credentials_parameter = aws_secretsmanager_secret_version.test.arn
        domain                = aws_directory_service_directory.test.name
      }
    }
  }
}

resource "aws_secretsmanager_secret_version" "test" {
  secret_id     = aws_secretsmanager_secret.test.id
  secret_string = jsonencode({ username : "admin", password : aws_directory_service_directory.test.password })
}

```

### Failed Languages

#### yaml

```text
.pp:2,26-67: Failed to generate YAML program: Unknown Function; YAML does not support Fn::readFile.
```

### Successes

<details>

<summary>java</summary>

```java
package generated_program;

import com.pulumi.Context;
import com.pulumi.Pulumi;
import com.pulumi.core.Output;
import com.pulumi.aws.secretsmanager.SecretVersion;
import com.pulumi.aws.secretsmanager.SecretVersionArgs;
import com.pulumi.aws.ecs.TaskDefinition;
import com.pulumi.aws.ecs.TaskDefinitionArgs;
import com.pulumi.aws.ecs.inputs.TaskDefinitionVolumeArgs;
import com.pulumi.aws.ecs.inputs.TaskDefinitionVolumeFsxWindowsFileServerVolumeConfigurationArgs;
import com.pulumi.aws.ecs.inputs.TaskDefinitionVolumeFsxWindowsFileServerVolumeConfigurationAuthorizationConfigArgs;
import static com.pulumi.codegen.internal.Serialization.*;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;

public class App {
    public static void main(String[] args) {
        Pulumi.run(App::stack);
    }

    public static void stack(Context ctx) {
        var test = new SecretVersion("test", SecretVersionArgs.builder()        
            .secretId(aws_secretsmanager_secret.test().id())
            .secretString(serializeJson(
                jsonObject(
                    jsonProperty("username", "admin"),
                    jsonProperty("password", aws_directory_service_directory.test().password())
                )))
            .build());

        var service = new TaskDefinition("service", TaskDefinitionArgs.builder()        
            .family("service")
            .containerDefinitions(Files.readString(Paths.get("task-definitions/service.json")))
            .volumes(TaskDefinitionVolumeArgs.builder()
                .name("service-storage")
                .fsxWindowsFileServerVolumeConfiguration(TaskDefinitionVolumeFsxWindowsFileServerVolumeConfigurationArgs.builder()
                    .fileSystemId(aws_fsx_windows_file_system.test().id())
                    .rootDirectory("\\data")
                    .authorizationConfig(TaskDefinitionVolumeFsxWindowsFileServerVolumeConfigurationAuthorizationConfigArgs.builder()
                        .credentialsParameter(test.arn())
                        .domain(aws_directory_service_directory.test().name())
                        .build())
                    .build())
                .build())
            .build());

    }
}
```

</details>

<details>

<summary>typescript</summary>

```typescript
import * as pulumi from "@pulumi/pulumi";
import * as aws from "@pulumi/aws";
import * as fs from "fs";

const test = new aws.secretsmanager.SecretVersion("test", {
    secretId: aws_secretsmanager_secret.test.id,
    secretString: JSON.stringify({
        username: "admin",
        password: aws_directory_service_directory.test.password,
    }),
});
const service = new aws.ecs.TaskDefinition("service", {
    family: "service",
    containerDefinitions: fs.readFileSync("task-definitions/service.json"),
    volumes: [{
        name: "service-storage",
        fsxWindowsFileServerVolumeConfiguration: {
            fileSystemId: aws_fsx_windows_file_system.test.id,
            rootDirectory: "\\data",
            authorizationConfig: {
                credentialsParameter: test.arn,
                domain: aws_directory_service_directory.test.name,
            },
        },
    }],
});
```

</details>

<details>

<summary>python</summary>

```python
import pulumi
import json
import pulumi_aws as aws

test = aws.secretsmanager.SecretVersion("test",
    secret_id=aws_secretsmanager_secret["test"]["id"],
    secret_string=json.dumps({
        "username": "admin",
        "password": aws_directory_service_directory["test"]["password"],
    }))
service = aws.ecs.TaskDefinition("service",
    family="service",
    container_definitions=(lambda path: open(path).read())("task-definitions/service.json"),
    volumes=[aws.ecs.TaskDefinitionVolumeArgs(
        name="service-storage",
        fsx_windows_file_server_volume_configuration=aws.ecs.TaskDefinitionVolumeFsxWindowsFileServerVolumeConfigurationArgs(
            file_system_id=aws_fsx_windows_file_system["test"]["id"],
            root_directory="\\data",
            authorization_config=aws.ecs.TaskDefinitionVolumeFsxWindowsFileServerVolumeConfigurationAuthorizationConfigArgs(
                credentials_parameter=test.arn,
                domain=aws_directory_service_directory["test"]["name"],
            ),
        ),
    )])
```

</details>

<details>

<summary>csharp</summary>

```csharp
using System.Collections.Generic;
using System.IO;
using System.Text.Json;
using Pulumi;
using Aws = Pulumi.Aws;

return await Deployment.RunAsync(() => 
{
    var test = new Aws.SecretsManager.SecretVersion("test", new()
    {
        SecretId = aws_secretsmanager_secret.Test.Id,
        SecretString = JsonSerializer.Serialize(new Dictionary<string, object?>
        {
            ["username"] = "admin",
            ["password"] = aws_directory_service_directory.Test.Password,
        }),
    });

    var service = new Aws.Ecs.TaskDefinition("service", new()
    {
        Family = "service",
        ContainerDefinitions = File.ReadAllText("task-definitions/service.json"),
        Volumes = new[]
        {
            new Aws.Ecs.Inputs.TaskDefinitionVolumeArgs
            {
                Name = "service-storage",
                FsxWindowsFileServerVolumeConfiguration = new Aws.Ecs.Inputs.TaskDefinitionVolumeFsxWindowsFileServerVolumeConfigurationArgs
                {
                    FileSystemId = aws_fsx_windows_file_system.Test.Id,
                    RootDirectory = "\\data",
                    AuthorizationConfig = new Aws.Ecs.Inputs.TaskDefinitionVolumeFsxWindowsFileServerVolumeConfigurationAuthorizationConfigArgs
                    {
                        CredentialsParameter = test.Arn,
                        Domain = aws_directory_service_directory.Test.Name,
                    },
                },
            },
        },
    });

});
```

</details>

<details>

<summary>go</summary>

```go
package main

import (
	"encoding/json"
	"io/ioutil"

	"github.com/pulumi/pulumi-aws/sdk/v5/go/aws/ecs"
	"github.com/pulumi/pulumi-aws/sdk/v5/go/aws/secretsmanager"
	"github.com/pulumi/pulumi/sdk/v3/go/pulumi"
)

func readFileOrPanic(path string) pulumi.StringPtrInput {
	data, err := ioutil.ReadFile(path)
	if err != nil {
		panic(err.Error())
	}
	return pulumi.String(string(data))
}

func main() {
	pulumi.Run(func(ctx *pulumi.Context) error {
		tmpJSON0, err := json.Marshal(map[string]interface{}{
			"username": "admin",
			"password": aws_directory_service_directory.Test.Password,
		})
		if err != nil {
			return err
		}
		json0 := string(tmpJSON0)
		test, err := secretsmanager.NewSecretVersion(ctx, "test", &secretsmanager.SecretVersionArgs{
			SecretId:     pulumi.Any(aws_secretsmanager_secret.Test.Id),
			SecretString: pulumi.String(json0),
		})
		if err != nil {
			return err
		}
		_, err = ecs.NewTaskDefinition(ctx, "service", &ecs.TaskDefinitionArgs{
			Family:               pulumi.String("service"),
			ContainerDefinitions: readFileOrPanic("task-definitions/service.json"),
			Volumes: ecs.TaskDefinitionVolumeArray{
				&ecs.TaskDefinitionVolumeArgs{
					Name: pulumi.String("service-storage"),
					FsxWindowsFileServerVolumeConfiguration: &ecs.TaskDefinitionVolumeFsxWindowsFileServerVolumeConfigurationArgs{
						FileSystemId:  pulumi.Any(aws_fsx_windows_file_system.Test.Id),
						RootDirectory: pulumi.String("\\data"),
						AuthorizationConfig: &ecs.TaskDefinitionVolumeFsxWindowsFileServerVolumeConfigurationAuthorizationConfigArgs{
							CredentialsParameter: test.Arn,
							Domain:               pulumi.Any(aws_directory_service_directory.Test.Name),
						},
					},
				},
			},
		})
		if err != nil {
			return err
		}
		return nil
	})
}
```

</details>

## [**complete failure**] #/resources/aws:ssoadmin/permissionSet:PermissionSet

### HCL

```terraform
data "aws_ssoadmin_instances" "example" {}

resource "aws_ssoadmin_permission_set" "example" {
  name             = "Example"
  description      = "An example"
  instance_arn     = tolist(data.aws_ssoadmin_instances.example.arns)[0]
  relay_state      = "https://s3.console.aws.amazon.com/s3/home?region=us-east-1#"
  session_duration = "PT2H"
}

```

### Failed Languages

#### yaml

```text
:5,22-28: unknown function 'tolist'; , and 1 other diagnostic(s)
```

#### java

```text
:5,22-28: unknown function 'tolist'; , and 1 other diagnostic(s)
```

#### typescript

```text
:5,22-28: unknown function 'tolist'; , and 1 other diagnostic(s)
```

#### python

```text
:5,22-28: unknown function 'tolist'; , and 1 other diagnostic(s)
```

#### csharp

```text
:5,22-28: unknown function 'tolist'; , and 1 other diagnostic(s)
```

#### go

```text
:5,22-28: unknown function 'tolist'; , and 1 other diagnostic(s)
```

## [**complete failure**] Uploading a file to a bucket

### HCL

```terraform
resource "aws_s3_object" "object" {
  bucket = "your_bucket_name"
  key    = "new_object_key"
  source = "path/to/file"

  # The filemd5() function is available in Terraform 0.11.12 and later
  # For Terraform 0.11.11 and earlier, use the md5() function and the file() function:
  # etag = "${md5(file("path/to/file"))}"
  etag = filemd5("path/to/file")
}

```

### Failed Languages

#### go

```text
:8,10-17: unknown function 'filemd5'; , and 1 other diagnostic(s)
```

#### yaml

```text
:8,10-17: unknown function 'filemd5'; , and 1 other diagnostic(s)
```

#### java

```text
:8,10-17: unknown function 'filemd5'; , and 1 other diagnostic(s)
```

#### typescript

```text
:8,10-17: unknown function 'filemd5'; , and 1 other diagnostic(s)
```

#### python

```text
:8,10-17: unknown function 'filemd5'; , and 1 other diagnostic(s)
```

#### csharp

```text
:8,10-17: unknown function 'filemd5'; , and 1 other diagnostic(s)
```

## [*partial failure*] #/resources/aws:iot/authorizer:Authorizer

### HCL

```terraform
resource "aws_iot_authorizer" "example" {
  name                    = "example"
  authorizer_function_arn = aws_lambda_function.example.arn
  signing_disabled        = false
  status                  = "ACTIVE"
  token_key_name          = "Token-Header"

  token_signing_public_keys = {
    Key1 = "${file("test-fixtures/iot-authorizer-signing-key.pem")}"
  }
}

```

### Failed Languages

#### yaml

```text
.pp:6,12-68: Failed to generate YAML program: Unknown Function; YAML does not support Fn::readFile.
```

### Successes

<details>

<summary>typescript</summary>

```typescript
import * as pulumi from "@pulumi/pulumi";
import * as aws from "@pulumi/aws";
import * as fs from "fs";

const example = new aws.iot.Authorizer("example", {
    authorizerFunctionArn: aws_lambda_function.example.arn,
    signingDisabled: false,
    status: "ACTIVE",
    tokenKeyName: "Token-Header",
    tokenSigningPublicKeys: {
        Key1: fs.readFileSync("test-fixtures/iot-authorizer-signing-key.pem"),
    },
});
```

</details>

<details>

<summary>python</summary>

```python
import pulumi
import pulumi_aws as aws

example = aws.iot.Authorizer("example",
    authorizer_function_arn=aws_lambda_function["example"]["arn"],
    signing_disabled=False,
    status="ACTIVE",
    token_key_name="Token-Header",
    token_signing_public_keys={
        "Key1": (lambda path: open(path).read())("test-fixtures/iot-authorizer-signing-key.pem"),
    })
```

</details>

<details>

<summary>csharp</summary>

```csharp
using System.Collections.Generic;
using System.IO;
using Pulumi;
using Aws = Pulumi.Aws;

return await Deployment.RunAsync(() => 
{
    var example = new Aws.Iot.Authorizer("example", new()
    {
        AuthorizerFunctionArn = aws_lambda_function.Example.Arn,
        SigningDisabled = false,
        Status = "ACTIVE",
        TokenKeyName = "Token-Header",
        TokenSigningPublicKeys = 
        {
            { "Key1", File.ReadAllText("test-fixtures/iot-authorizer-signing-key.pem") },
        },
    });

});
```

</details>

<details>

<summary>go</summary>

```go
package main

import (
	"io/ioutil"

	"github.com/pulumi/pulumi-aws/sdk/v5/go/aws/iot"
	"github.com/pulumi/pulumi/sdk/v3/go/pulumi"
)

func readFileOrPanic(path string) pulumi.StringPtrInput {
	data, err := ioutil.ReadFile(path)
	if err != nil {
		panic(err.Error())
	}
	return pulumi.String(string(data))
}

func main() {
	pulumi.Run(func(ctx *pulumi.Context) error {
		_, err := iot.NewAuthorizer(ctx, "example", &iot.AuthorizerArgs{
			AuthorizerFunctionArn: pulumi.Any(aws_lambda_function.Example.Arn),
			SigningDisabled:       pulumi.Bool(false),
			Status:                pulumi.String("ACTIVE"),
			TokenKeyName:          pulumi.String("Token-Header"),
			TokenSigningPublicKeys: pulumi.StringMap{
				"Key1": readFileOrPanic("test-fixtures/iot-authorizer-signing-key.pem"),
			},
		})
		if err != nil {
			return err
		}
		return nil
	})
}
```

</details>

<details>

<summary>java</summary>

```java
package generated_program;

import com.pulumi.Context;
import com.pulumi.Pulumi;
import com.pulumi.core.Output;
import com.pulumi.aws.iot.Authorizer;
import com.pulumi.aws.iot.AuthorizerArgs;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;

public class App {
    public static void main(String[] args) {
        Pulumi.run(App::stack);
    }

    public static void stack(Context ctx) {
        var example = new Authorizer("example", AuthorizerArgs.builder()        
            .authorizerFunctionArn(aws_lambda_function.example().arn())
            .signingDisabled(false)
            .status("ACTIVE")
            .tokenKeyName("Token-Header")
            .tokenSigningPublicKeys(Map.of("Key1", Files.readString(Paths.get("test-fixtures/iot-authorizer-signing-key.pem"))))
            .build());

    }
}
```

</details>

## [*partial failure*] #/resources/aws:pinpoint/apnsVoipChannel:ApnsVoipChannel

### HCL

```terraform
resource "aws_pinpoint_apns_voip_channel" "apns_voip" {
  application_id = aws_pinpoint_app.app.application_id

  certificate = file("./certificate.pem")
  private_key = file("./private_key.key")
}

resource "aws_pinpoint_app" "app" {}

```

### Failed Languages

#### yaml

```text
.pp:2,17-46: Failed to generate YAML program: Unknown Function; YAML does not support Fn::readFile., and 1 other diagnostic(s)
```

### Successes

<details>

<summary>typescript</summary>

```typescript
import * as pulumi from "@pulumi/pulumi";
import * as aws from "@pulumi/aws";
import * as fs from "fs";

const app = new aws.pinpoint.App("app", {});
const apnsVoip = new aws.pinpoint.ApnsVoipChannel("apnsVoip", {
    applicationId: app.applicationId,
    certificate: fs.readFileSync("./certificate.pem"),
    privateKey: fs.readFileSync("./private_key.key"),
});
```

</details>

<details>

<summary>python</summary>

```python
import pulumi
import pulumi_aws as aws

app = aws.pinpoint.App("app")
apns_voip = aws.pinpoint.ApnsVoipChannel("apnsVoip",
    application_id=app.application_id,
    certificate=(lambda path: open(path).read())("./certificate.pem"),
    private_key=(lambda path: open(path).read())("./private_key.key"))
```

</details>

<details>

<summary>csharp</summary>

```csharp
using System.Collections.Generic;
using System.IO;
using Pulumi;
using Aws = Pulumi.Aws;

return await Deployment.RunAsync(() => 
{
    var app = new Aws.Pinpoint.App("app");

    var apnsVoip = new Aws.Pinpoint.ApnsVoipChannel("apnsVoip", new()
    {
        ApplicationId = app.ApplicationId,
        Certificate = File.ReadAllText("./certificate.pem"),
        PrivateKey = File.ReadAllText("./private_key.key"),
    });

});
```

</details>

<details>

<summary>go</summary>

```go
package main

import (
	"io/ioutil"

	"github.com/pulumi/pulumi-aws/sdk/v5/go/aws/pinpoint"
	"github.com/pulumi/pulumi/sdk/v3/go/pulumi"
)

func readFileOrPanic(path string) pulumi.StringPtrInput {
	data, err := ioutil.ReadFile(path)
	if err != nil {
		panic(err.Error())
	}
	return pulumi.String(string(data))
}

func main() {
	pulumi.Run(func(ctx *pulumi.Context) error {
		app, err := pinpoint.NewApp(ctx, "app", nil)
		if err != nil {
			return err
		}
		_, err = pinpoint.NewApnsVoipChannel(ctx, "apnsVoip", &pinpoint.ApnsVoipChannelArgs{
			ApplicationId: app.ApplicationId,
			Certificate:   readFileOrPanic("./certificate.pem"),
			PrivateKey:    readFileOrPanic("./private_key.key"),
		})
		if err != nil {
			return err
		}
		return nil
	})
}
```

</details>

<details>

<summary>java</summary>

```java
package generated_program;

import com.pulumi.Context;
import com.pulumi.Pulumi;
import com.pulumi.core.Output;
import com.pulumi.aws.pinpoint.App;
import com.pulumi.aws.pinpoint.ApnsVoipChannel;
import com.pulumi.aws.pinpoint.ApnsVoipChannelArgs;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;

public class App {
    public static void main(String[] args) {
        Pulumi.run(App::stack);
    }

    public static void stack(Context ctx) {
        var app = new App("app");

        var apnsVoip = new ApnsVoipChannel("apnsVoip", ApnsVoipChannelArgs.builder()        
            .applicationId(app.applicationId())
            .certificate(Files.readString(Paths.get("./certificate.pem")))
            .privateKey(Files.readString(Paths.get("./private_key.key")))
            .build());

    }
}
```

</details>

## [*partial failure*] Example IAM Setup in Target Account

### HCL

```terraform
data "aws_iam_policy_document" "AWSCloudFormationStackSetExecutionRole_assume_role_policy" {
  statement {
    actions = ["sts:AssumeRole"]
    effect  = "Allow"

    principals {
      identifiers = [aws_iam_role.AWSCloudFormationStackSetAdministrationRole.arn]
      type        = "AWS"
    }
  }
}

resource "aws_iam_role" "AWSCloudFormationStackSetExecutionRole" {
  assume_role_policy = data.aws_iam_policy_document.AWSCloudFormationStackSetExecutionRole_assume_role_policy.json
  name               = "AWSCloudFormationStackSetExecutionRole"
}

# Documentation: https://docs.aws.amazon.com/AWSCloudFormation/latest/UserGuide/stacksets-prereqs.html
# Additional IAM permissions necessary depend on the resources defined in the StackSet template
data "aws_iam_policy_document" "AWSCloudFormationStackSetExecutionRole_MinimumExecutionPolicy" {
  statement {
    actions = [
      "cloudformation:*",
      "s3:*",
      "sns:*",
    ]

    effect    = "Allow"
    resources = ["*"]
  }
}

resource "aws_iam_role_policy" "AWSCloudFormationStackSetExecutionRole_MinimumExecutionPolicy" {
  name   = "MinimumExecutionPolicy"
  policy = data.aws_iam_policy_document.AWSCloudFormationStackSetExecutionRole_MinimumExecutionPolicy.json
  role   = aws_iam_role.AWSCloudFormationStackSetExecutionRole.name
}

```

### Failed Languages

#### go

```text
failed to convert HCL for #/resources/aws:cloudformation/stackSetInstance:StackSetInstance to go: invalid Go source code:

package main

import (

"github.com/pulumi/pulumi/sdk/v3/go/pulumi"
"github.com/pulumi/pulumi-aws/sdk/v5/go/aws/iam"
)
func main() {
pulumi.Run(func(ctx *pulumi.Context) error {
aWSCloudFormationStackSetExecutionRoleAssumeRolePolicy, err := iam.GetPolicyDocument(ctx, &iam.GetPolicyDocumentArgs{
Statements: []iam.GetPolicyDocumentStatement{
iam.GetPolicyDocumentStatement{
Actions: []string{
"sts:AssumeRole",
},
Effect: pulumi.StringRef("Allow"),
Principals: []iam.GetPolicyDocumentStatementPrincipal{
iam.GetPolicyDocumentStatementPrincipal{
Identifiers: interface{}{
aws_iam_role.AWSCloudFormationStackSetAdministrationRole.Arn,
},
Type: "AWS",
},
},
},
},
}, nil);
if err != nil {
return err
}
aWSCloudFormationStackSetExecutionRole, err := iam.NewRole(ctx, "aWSCloudFormationStackSetExecutionRole", &iam.RoleArgs{
AssumeRolePolicy: pulumi.String(aWSCloudFormationStackSetExecutionRoleAssumeRolePolicy.Json),
})
if err != nil {
return err
}
aWSCloudFormationStackSetExecutionRoleMinimumExecutionPolicyPolicyDocument, err := iam.GetPolicyDocument(ctx, &iam.GetPolicyDocumentArgs{
Statements: []iam.GetPolicyDocumentStatement{
iam.GetPolicyDocumentStatement{
Actions: []string{
"cloudformation:*",
"s3:*",
"sns:*",
},
Effect: pulumi.StringRef("Allow"),
Resources: []string{
"*",
},
},
},
}, nil);
if err != nil {
return err
}
_, err = iam.NewRolePolicy(ctx, "aWSCloudFormationStackSetExecutionRoleMinimumExecutionPolicyRolePolicy", &iam.RolePolicyArgs{
Policy: pulumi.String(aWSCloudFormationStackSetExecutionRoleMinimumExecutionPolicyPolicyDocument.Json),
Role: aWSCloudFormationStackSetExecutionRole.Name,
})
if err != nil {
return err
}
return nil
})
}
: 19:14: expected expression (and 10 more errors)
```

### Successes

<details>

<summary>typescript</summary>

```typescript
import * as pulumi from "@pulumi/pulumi";
import * as aws from "@pulumi/aws";

const aWSCloudFormationStackSetExecutionRoleAssumeRolePolicy = aws.iam.getPolicyDocument({
    statements: [{
        actions: ["sts:AssumeRole"],
        effect: "Allow",
        principals: [{
            identifiers: [aws_iam_role.AWSCloudFormationStackSetAdministrationRole.arn],
            type: "AWS",
        }],
    }],
});
const aWSCloudFormationStackSetExecutionRole = new aws.iam.Role("aWSCloudFormationStackSetExecutionRole", {assumeRolePolicy: aWSCloudFormationStackSetExecutionRoleAssumeRolePolicy.then(aWSCloudFormationStackSetExecutionRoleAssumeRolePolicy => aWSCloudFormationStackSetExecutionRoleAssumeRolePolicy.json)});
const aWSCloudFormationStackSetExecutionRoleMinimumExecutionPolicyPolicyDocument = aws.iam.getPolicyDocument({
    statements: [{
        actions: [
            "cloudformation:*",
            "s3:*",
            "sns:*",
        ],
        effect: "Allow",
        resources: ["*"],
    }],
});
const aWSCloudFormationStackSetExecutionRoleMinimumExecutionPolicyRolePolicy = new aws.iam.RolePolicy("aWSCloudFormationStackSetExecutionRoleMinimumExecutionPolicyRolePolicy", {
    policy: aWSCloudFormationStackSetExecutionRoleMinimumExecutionPolicyPolicyDocument.then(aWSCloudFormationStackSetExecutionRoleMinimumExecutionPolicyPolicyDocument => aWSCloudFormationStackSetExecutionRoleMinimumExecutionPolicyPolicyDocument.json),
    role: aWSCloudFormationStackSetExecutionRole.name,
});
```

</details>

<details>

<summary>python</summary>

```python
import pulumi
import pulumi_aws as aws

a_ws_cloud_formation_stack_set_execution_role_assume_role_policy = aws.iam.get_policy_document(statements=[aws.iam.GetPolicyDocumentStatementArgs(
    actions=["sts:AssumeRole"],
    effect="Allow",
    principals=[aws.iam.GetPolicyDocumentStatementPrincipalArgs(
        identifiers=[aws_iam_role["AWSCloudFormationStackSetAdministrationRole"]["arn"]],
        type="AWS",
    )],
)])
a_ws_cloud_formation_stack_set_execution_role = aws.iam.Role("aWSCloudFormationStackSetExecutionRole", assume_role_policy=a_ws_cloud_formation_stack_set_execution_role_assume_role_policy.json)
a_ws_cloud_formation_stack_set_execution_role_minimum_execution_policy_policy_document = aws.iam.get_policy_document(statements=[aws.iam.GetPolicyDocumentStatementArgs(
    actions=[
        "cloudformation:*",
        "s3:*",
        "sns:*",
    ],
    effect="Allow",
    resources=["*"],
)])
a_ws_cloud_formation_stack_set_execution_role_minimum_execution_policy_role_policy = aws.iam.RolePolicy("aWSCloudFormationStackSetExecutionRoleMinimumExecutionPolicyRolePolicy",
    policy=a_ws_cloud_formation_stack_set_execution_role_minimum_execution_policy_policy_document.json,
    role=a_ws_cloud_formation_stack_set_execution_role.name)
```

</details>

<details>

<summary>csharp</summary>

```csharp
using System.Collections.Generic;
using Pulumi;
using Aws = Pulumi.Aws;

return await Deployment.RunAsync(() => 
{
    var aWSCloudFormationStackSetExecutionRoleAssumeRolePolicy = Aws.Iam.GetPolicyDocument.Invoke(new()
    {
        Statements = new[]
        {
            new Aws.Iam.Inputs.GetPolicyDocumentStatementInputArgs
            {
                Actions = new[]
                {
                    "sts:AssumeRole",
                },
                Effect = "Allow",
                Principals = new[]
                {
                    new Aws.Iam.Inputs.GetPolicyDocumentStatementPrincipalInputArgs
                    {
                        Identifiers = new[]
                        {
                            aws_iam_role.AWSCloudFormationStackSetAdministrationRole.Arn,
                        },
                        Type = "AWS",
                    },
                },
            },
        },
    });

    var aWSCloudFormationStackSetExecutionRole = new Aws.Iam.Role("aWSCloudFormationStackSetExecutionRole", new()
    {
        AssumeRolePolicy = aWSCloudFormationStackSetExecutionRoleAssumeRolePolicy.Apply(getPolicyDocumentResult => getPolicyDocumentResult.Json),
    });

    var aWSCloudFormationStackSetExecutionRoleMinimumExecutionPolicyPolicyDocument = Aws.Iam.GetPolicyDocument.Invoke(new()
    {
        Statements = new[]
        {
            new Aws.Iam.Inputs.GetPolicyDocumentStatementInputArgs
            {
                Actions = new[]
                {
                    "cloudformation:*",
                    "s3:*",
                    "sns:*",
                },
                Effect = "Allow",
                Resources = new[]
                {
                    "*",
                },
            },
        },
    });

    var aWSCloudFormationStackSetExecutionRoleMinimumExecutionPolicyRolePolicy = new Aws.Iam.RolePolicy("aWSCloudFormationStackSetExecutionRoleMinimumExecutionPolicyRolePolicy", new()
    {
        Policy = aWSCloudFormationStackSetExecutionRoleMinimumExecutionPolicyPolicyDocument.Apply(getPolicyDocumentResult => getPolicyDocumentResult.Json),
        Role = aWSCloudFormationStackSetExecutionRole.Name,
    });

});
```

</details>

<details>

<summary>yaml</summary>

```yaml
resources:
  aWSCloudFormationStackSetExecutionRole:
    type: aws:iam:Role
    properties:
      assumeRolePolicy: ${aWSCloudFormationStackSetExecutionRoleAssumeRolePolicy.json}
  aWSCloudFormationStackSetExecutionRoleMinimumExecutionPolicyRolePolicy:
    type: aws:iam:RolePolicy
    properties:
      policy: ${aWSCloudFormationStackSetExecutionRoleMinimumExecutionPolicyPolicyDocument.json}
      role: ${aWSCloudFormationStackSetExecutionRole.name}
variables:
  aWSCloudFormationStackSetExecutionRoleAssumeRolePolicy:
    Fn::Invoke:
      Function: aws:iam:getPolicyDocument
      Arguments:
        statements:
          - actions:
              - sts:AssumeRole
            effect: Allow
            principals:
              - identifiers:
                  - ${aws_iam_role.AWSCloudFormationStackSetAdministrationRole.arn}
                type: AWS
  aWSCloudFormationStackSetExecutionRoleMinimumExecutionPolicyPolicyDocument:
    Fn::Invoke:
      Function: aws:iam:getPolicyDocument
      Arguments:
        statements:
          - actions:
              - cloudformation:*
              - s3:*
              - sns:*
            effect: Allow
            resources:
              - '*'
```

</details>

<details>

<summary>java</summary>

```java
package generated_program;

import com.pulumi.Context;
import com.pulumi.Pulumi;
import com.pulumi.core.Output;
import com.pulumi.aws.iam.IamFunctions;
import com.pulumi.aws.iam.inputs.GetPolicyDocumentArgs;
import com.pulumi.aws.iam.Role;
import com.pulumi.aws.iam.RoleArgs;
import com.pulumi.aws.iam.RolePolicy;
import com.pulumi.aws.iam.RolePolicyArgs;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;

public class App {
    public static void main(String[] args) {
        Pulumi.run(App::stack);
    }

    public static void stack(Context ctx) {
        final var aWSCloudFormationStackSetExecutionRoleAssumeRolePolicy = IamFunctions.getPolicyDocument(GetPolicyDocumentArgs.builder()
            .statements(GetPolicyDocumentStatementArgs.builder()
                .actions("sts:AssumeRole")
                .effect("Allow")
                .principals(GetPolicyDocumentStatementPrincipalArgs.builder()
                    .identifiers(aws_iam_role.AWSCloudFormationStackSetAdministrationRole().arn())
                    .type("AWS")
                    .build())
                .build())
            .build());

        var aWSCloudFormationStackSetExecutionRole = new Role("aWSCloudFormationStackSetExecutionRole", RoleArgs.builder()        
            .assumeRolePolicy(aWSCloudFormationStackSetExecutionRoleAssumeRolePolicy.applyValue(getPolicyDocumentResult -> getPolicyDocumentResult.json()))
            .build());

        final var aWSCloudFormationStackSetExecutionRoleMinimumExecutionPolicyPolicyDocument = IamFunctions.getPolicyDocument(GetPolicyDocumentArgs.builder()
            .statements(GetPolicyDocumentStatementArgs.builder()
                .actions(                
                    "cloudformation:*",
                    "s3:*",
                    "sns:*")
                .effect("Allow")
                .resources("*")
                .build())
            .build());

        var aWSCloudFormationStackSetExecutionRoleMinimumExecutionPolicyRolePolicy = new RolePolicy("aWSCloudFormationStackSetExecutionRoleMinimumExecutionPolicyRolePolicy", RolePolicyArgs.builder()        
            .policy(aWSCloudFormationStackSetExecutionRoleMinimumExecutionPolicyPolicyDocument.applyValue(getPolicyDocumentResult -> getPolicyDocumentResult.json()))
            .role(aWSCloudFormationStackSetExecutionRole.name())
            .build());

    }
}
```

</details>

## [*partial failure*] Create Cached iSCSI Volume From Snapshot

### HCL

```terraform
resource "aws_storagegateway_cached_iscsi_volume" "example" {
  gateway_arn          = aws_storagegateway_cache.example.gateway_arn
  network_interface_id = aws_instance.example.private_ip
  snapshot_id          = aws_ebs_snapshot.example.id
  target_name          = "example"
  volume_size_in_bytes = aws_ebs_snapshot.example.volume_size * 1024 * 1024 * 1024
}

```

### Failed Languages

#### yaml

```text
.pp:5,23-80: Failed to generate YAML program: *model.BinaryOpExpression; Unimplemented! Needed for  aws_ebs_snapshot.example.volume_size * 1024 * 1024 * 1024

```

### Successes

<details>

<summary>typescript</summary>

```typescript
import * as pulumi from "@pulumi/pulumi";
import * as aws from "@pulumi/aws";

const example = new aws.storagegateway.CachesIscsiVolume("example", {
    gatewayArn: aws_storagegateway_cache.example.gateway_arn,
    networkInterfaceId: aws_instance.example.private_ip,
    snapshotId: aws_ebs_snapshot.example.id,
    targetName: "example",
    volumeSizeInBytes: aws_ebs_snapshot.example.volume_size * 1024 * 1024 * 1024,
});
```

</details>

<details>

<summary>python</summary>

```python
import pulumi
import pulumi_aws as aws

example = aws.storagegateway.CachesIscsiVolume("example",
    gateway_arn=aws_storagegateway_cache["example"]["gateway_arn"],
    network_interface_id=aws_instance["example"]["private_ip"],
    snapshot_id=aws_ebs_snapshot["example"]["id"],
    target_name="example",
    volume_size_in_bytes=aws_ebs_snapshot["example"]["volume_size"] * 1024 * 1024 * 1024)
```

</details>

<details>

<summary>csharp</summary>

```csharp
using System.Collections.Generic;
using Pulumi;
using Aws = Pulumi.Aws;

return await Deployment.RunAsync(() => 
{
    var example = new Aws.StorageGateway.CachesIscsiVolume("example", new()
    {
        GatewayArn = aws_storagegateway_cache.Example.Gateway_arn,
        NetworkInterfaceId = aws_instance.Example.Private_ip,
        SnapshotId = aws_ebs_snapshot.Example.Id,
        TargetName = "example",
        VolumeSizeInBytes = aws_ebs_snapshot.Example.Volume_size * 1024 * 1024 * 1024,
    });

});
```

</details>

<details>

<summary>go</summary>

```go
package main

import (
	"github.com/pulumi/pulumi-aws/sdk/v5/go/aws/storagegateway"
	"github.com/pulumi/pulumi/sdk/v3/go/pulumi"
)

func main() {
	pulumi.Run(func(ctx *pulumi.Context) error {
		_, err := storagegateway.NewCachesIscsiVolume(ctx, "example", &storagegateway.CachesIscsiVolumeArgs{
			GatewayArn:         pulumi.Any(aws_storagegateway_cache.Example.Gateway_arn),
			NetworkInterfaceId: pulumi.Any(aws_instance.Example.Private_ip),
			SnapshotId:         pulumi.Any(aws_ebs_snapshot.Example.Id),
			TargetName:         pulumi.String("example"),
			VolumeSizeInBytes:  aws_ebs_snapshot.Example.Volume_size * 1024 * 1024 * 1024,
		})
		if err != nil {
			return err
		}
		return nil
	})
}
```

</details>

<details>

<summary>java</summary>

```java
package generated_program;

import com.pulumi.Context;
import com.pulumi.Pulumi;
import com.pulumi.core.Output;
import com.pulumi.aws.storagegateway.CachesIscsiVolume;
import com.pulumi.aws.storagegateway.CachesIscsiVolumeArgs;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;

public class App {
    public static void main(String[] args) {
        Pulumi.run(App::stack);
    }

    public static void stack(Context ctx) {
        var example = new CachesIscsiVolume("example", CachesIscsiVolumeArgs.builder()        
            .gatewayArn(aws_storagegateway_cache.example().gateway_arn())
            .networkInterfaceId(aws_instance.example().private_ip())
            .snapshotId(aws_ebs_snapshot.example().id())
            .targetName("example")
            .volumeSizeInBytes(aws_ebs_snapshot.example().volume_size() * 1024 * 1024 * 1024)
            .build());

    }
}
```

</details>

## [**complete failure**] #/resources/aws:cloudhsmv2/cluster:Cluster

### HCL

```terraform
provider "aws" {
  region = var.aws_region
}

data "aws_availability_zones" "available" {}

resource "aws_vpc" "cloudhsm_v2_vpc" {
  cidr_block = "10.0.0.0/16"

  tags = {
    Name = "example-aws_cloudhsm_v2_cluster"
  }
}

resource "aws_subnet" "cloudhsm_v2_subnets" {
  count                   = 2
  vpc_id                  = aws_vpc.cloudhsm_v2_vpc.id
  cidr_block              = element(var.subnets, count.index)
  map_public_ip_on_launch = false
  availability_zone       = element(data.aws_availability_zones.available.names, count.index)

  tags = {
    Name = "example-aws_cloudhsm_v2_cluster"
  }
}

resource "aws_cloudhsm_v2_cluster" "cloudhsm_v2_cluster" {
  hsm_type   = "hsm1.medium"
  subnet_ids = aws_subnet.cloudhsm_v2_subnets.*.id

  tags = {
    Name = "example-aws_cloudhsm_v2_cluster"
  }
}

```

### Failed Languages

#### typescript

```text
:17,37-48: the first argument to 'element' must be a list or tuple; , and 3 other diagnostic(s)
```

#### python

```text
:17,37-48: the first argument to 'element' must be a list or tuple; , and 3 other diagnostic(s)
```

#### csharp

```text
:17,37-48: the first argument to 'element' must be a list or tuple; , and 3 other diagnostic(s)
```

#### go

```text
:17,37-48: the first argument to 'element' must be a list or tuple; , and 3 other diagnostic(s)
```

#### yaml

```text
:17,37-48: the first argument to 'element' must be a list or tuple; , and 3 other diagnostic(s)
```

#### java

```text
:17,37-48: the first argument to 'element' must be a list or tuple; , and 3 other diagnostic(s)
```

## [*partial failure*] #/resources/aws:apigateway/usagePlan:UsagePlan

### HCL

```terraform
resource "aws_api_gateway_rest_api" "example" {
  body = jsonencode({
    openapi = "3.0.1"
    info = {
      title   = "example"
      version = "1.0"
    }
    paths = {
      "/path1" = {
        get = {
          x-amazon-apigateway-integration = {
            httpMethod           = "GET"
            payloadFormatVersion = "1.0"
            type                 = "HTTP_PROXY"
            uri                  = "https://ip-ranges.amazonaws.com/ip-ranges.json"
          }
        }
      }
    }
  })

  name = "example"
}

resource "aws_api_gateway_deployment" "example" {
  rest_api_id = aws_api_gateway_rest_api.example.id

  triggers = {
    redeployment = sha1(jsonencode(aws_api_gateway_rest_api.example.body))
  }

  lifecycle {
    create_before_destroy = true
  }
}

resource "aws_api_gateway_stage" "development" {
  deployment_id = aws_api_gateway_deployment.example.id
  rest_api_id   = aws_api_gateway_rest_api.example.id
  stage_name    = "development"
}

resource "aws_api_gateway_stage" "production" {
  deployment_id = aws_api_gateway_deployment.example.id
  rest_api_id   = aws_api_gateway_rest_api.example.id
  stage_name    = "production"
}

resource "aws_api_gateway_usage_plan" "example" {
  name         = "my-usage-plan"
  description  = "my description"
  product_code = "MYCODE"

  api_stages {
    api_id = aws_api_gateway_rest_api.example.id
    stage  = aws_api_gateway_stage.development.stage_name
  }

  api_stages {
    api_id = aws_api_gateway_rest_api.example.id
    stage  = aws_api_gateway_stage.production.stage_name
  }

  quota_settings {
    limit  = 20
    offset = 2
    period = "WEEK"
  }

  throttle_settings {
    burst_limit = 5
    rate_limit  = 10
  }
}

```

### Failed Languages

#### yaml

```text
.pp:24,20-53: Failed to generate YAML program: Unknown Function; YAML does not support Fn::sha1.
```

### Successes

<details>

<summary>python</summary>

```python
import pulumi
import hashlib
import json
import pulumi_aws as aws

example_rest_api = aws.apigateway.RestApi("exampleRestApi", body=json.dumps({
    "openapi": "3.0.1",
    "info": {
        "title": "example",
        "version": "1.0",
    },
    "paths": {
        "/path1": {
            "get": {
                "x-amazon-apigateway-integration": {
                    "httpMethod": "GET",
                    "payloadFormatVersion": "1.0",
                    "type": "HTTP_PROXY",
                    "uri": "https://ip-ranges.amazonaws.com/ip-ranges.json",
                },
            },
        },
    },
}))
example_deployment = aws.apigateway.Deployment("exampleDeployment",
    rest_api=example_rest_api.id,
    triggers={
        "redeployment": example_rest_api.body.apply(lambda body: json.dumps(body)).apply(lambda to_json: hashlib.sha1(to_json.encode()).hexdigest()),
    })
development = aws.apigateway.Stage("development",
    deployment=example_deployment.id,
    rest_api=example_rest_api.id,
    stage_name="development")
production = aws.apigateway.Stage("production",
    deployment=example_deployment.id,
    rest_api=example_rest_api.id,
    stage_name="production")
example_usage_plan = aws.apigateway.UsagePlan("exampleUsagePlan",
    description="my description",
    product_code="MYCODE",
    api_stages=[
        aws.apigateway.UsagePlanApiStageArgs(
            api_id=example_rest_api.id,
            stage=development.stage_name,
        ),
        aws.apigateway.UsagePlanApiStageArgs(
            api_id=example_rest_api.id,
            stage=production.stage_name,
        ),
    ],
    quota_settings=aws.apigateway.UsagePlanQuotaSettingsArgs(
        limit=20,
        offset=2,
        period="WEEK",
    ),
    throttle_settings=aws.apigateway.UsagePlanThrottleSettingsArgs(
        burst_limit=5,
        rate_limit=10,
    ))
```

</details>

<details>

<summary>csharp</summary>

```csharp
using System.Collections.Generic;
using System.Security.Cryptography;
using System.Text;
using System.Text.Json;
using Pulumi;
using Aws = Pulumi.Aws;

	private static string ComputeSHA1(string input) {
		return BitConverter.ToString(
			SHA1.Create().ComputeHash(Encoding.UTF8.GetBytes(input))
		).Replace("-","").ToLowerInvariant());
	}

return await Deployment.RunAsync(() => 
{
    var exampleRestApi = new Aws.ApiGateway.RestApi("exampleRestApi", new()
    {
        Body = JsonSerializer.Serialize(new Dictionary<string, object?>
        {
            ["openapi"] = "3.0.1",
            ["info"] = new Dictionary<string, object?>
            {
                ["title"] = "example",
                ["version"] = "1.0",
            },
            ["paths"] = new Dictionary<string, object?>
            {
                ["/path1"] = new Dictionary<string, object?>
                {
                    ["get"] = new Dictionary<string, object?>
                    {
                        ["x-amazon-apigateway-integration"] = new Dictionary<string, object?>
                        {
                            ["httpMethod"] = "GET",
                            ["payloadFormatVersion"] = "1.0",
                            ["type"] = "HTTP_PROXY",
                            ["uri"] = "https://ip-ranges.amazonaws.com/ip-ranges.json",
                        },
                    },
                },
            },
        }),
    });

    var exampleDeployment = new Aws.ApiGateway.Deployment("exampleDeployment", new()
    {
        RestApi = exampleRestApi.Id,
        Triggers = 
        {
            { "redeployment", exampleRestApi.Body.Apply(body => JsonSerializer.Serialize(body)).Apply(toJSON => ComputeSHA1(toJSON)) },
        },
    });

    var development = new Aws.ApiGateway.Stage("development", new()
    {
        Deployment = exampleDeployment.Id,
        RestApi = exampleRestApi.Id,
        StageName = "development",
    });

    var production = new Aws.ApiGateway.Stage("production", new()
    {
        Deployment = exampleDeployment.Id,
        RestApi = exampleRestApi.Id,
        StageName = "production",
    });

    var exampleUsagePlan = new Aws.ApiGateway.UsagePlan("exampleUsagePlan", new()
    {
        Description = "my description",
        ProductCode = "MYCODE",
        ApiStages = new[]
        {
            new Aws.ApiGateway.Inputs.UsagePlanApiStageArgs
            {
                ApiId = exampleRestApi.Id,
                Stage = development.StageName,
            },
            new Aws.ApiGateway.Inputs.UsagePlanApiStageArgs
            {
                ApiId = exampleRestApi.Id,
                Stage = production.StageName,
            },
        },
        QuotaSettings = new Aws.ApiGateway.Inputs.UsagePlanQuotaSettingsArgs
        {
            Limit = 20,
            Offset = 2,
            Period = "WEEK",
        },
        ThrottleSettings = new Aws.ApiGateway.Inputs.UsagePlanThrottleSettingsArgs
        {
            BurstLimit = 5,
            RateLimit = 10,
        },
    });

});
```

</details>

<details>

<summary>go</summary>

```go
package main

import (
	"crypto/sha1"
	"encoding/json"
	"fmt"

	"github.com/pulumi/pulumi-aws/sdk/v5/go/aws/apigateway"
	"github.com/pulumi/pulumi/sdk/v3/go/pulumi"
)

func sha1Hash(input string) string {
	hash := sha1.Sum([]byte(input))
	return hex.EncodeToString(hash[:])
}

func main() {
	pulumi.Run(func(ctx *pulumi.Context) error {
		tmpJSON0, err := json.Marshal(map[string]interface{}{
			"openapi": "3.0.1",
			"info": map[string]interface{}{
				"title":   "example",
				"version": "1.0",
			},
			"paths": map[string]interface{}{
				"/path1": map[string]interface{}{
					"get": map[string]interface{}{
						"x-amazon-apigateway-integration": map[string]interface{}{
							"httpMethod":           "GET",
							"payloadFormatVersion": "1.0",
							"type":                 "HTTP_PROXY",
							"uri":                  "https://ip-ranges.amazonaws.com/ip-ranges.json",
						},
					},
				},
			},
		})
		if err != nil {
			return err
		}
		json0 := string(tmpJSON0)
		exampleRestApi, err := apigateway.NewRestApi(ctx, "exampleRestApi", &apigateway.RestApiArgs{
			Body: pulumi.String(json0),
		})
		if err != nil {
			return err
		}
		exampleDeployment, err := apigateway.NewDeployment(ctx, "exampleDeployment", &apigateway.DeploymentArgs{
			RestApi: exampleRestApi.ID(),
			Triggers: pulumi.StringMap{
				"redeployment": exampleRestApi.Body.ApplyT(func(body string) (pulumi.String, error) {
					var _zero pulumi.String
					tmpJSON1, err := json.Marshal(body)
					if err != nil {
						return _zero, err
					}
					json1 := string(tmpJSON1)
					return json1, nil
				}).(pulumi.StringOutput).ApplyT(func(toJSON string) (pulumi.String, error) {
					return sha1Hash(toJSON), nil
				}).(pulumi.StringOutput),
			},
		})
		if err != nil {
			return err
		}
		development, err := apigateway.NewStage(ctx, "development", &apigateway.StageArgs{
			Deployment: exampleDeployment.ID(),
			RestApi:    exampleRestApi.ID(),
			StageName:  pulumi.String("development"),
		})
		if err != nil {
			return err
		}
		production, err := apigateway.NewStage(ctx, "production", &apigateway.StageArgs{
			Deployment: exampleDeployment.ID(),
			RestApi:    exampleRestApi.ID(),
			StageName:  pulumi.String("production"),
		})
		if err != nil {
			return err
		}
		_, err = apigateway.NewUsagePlan(ctx, "exampleUsagePlan", &apigateway.UsagePlanArgs{
			Description: pulumi.String("my description"),
			ProductCode: pulumi.String("MYCODE"),
			ApiStages: apigateway.UsagePlanApiStageArray{
				&apigateway.UsagePlanApiStageArgs{
					ApiId: exampleRestApi.ID(),
					Stage: development.StageName,
				},
				&apigateway.UsagePlanApiStageArgs{
					ApiId: exampleRestApi.ID(),
					Stage: production.StageName,
				},
			},
			QuotaSettings: &apigateway.UsagePlanQuotaSettingsArgs{
				Limit:  pulumi.Int(20),
				Offset: pulumi.Int(2),
				Period: pulumi.String("WEEK"),
			},
			ThrottleSettings: &apigateway.UsagePlanThrottleSettingsArgs{
				BurstLimit: pulumi.Int(5),
				RateLimit:  pulumi.Float64(10),
			},
		})
		if err != nil {
			return err
		}
		return nil
	})
}
```

</details>

<details>

<summary>java</summary>

```java
package generated_program;

import com.pulumi.Context;
import com.pulumi.Pulumi;
import com.pulumi.core.Output;
import com.pulumi.aws.apigateway.RestApi;
import com.pulumi.aws.apigateway.RestApiArgs;
import com.pulumi.aws.apigateway.Deployment;
import com.pulumi.aws.apigateway.DeploymentArgs;
import com.pulumi.aws.apigateway.Stage;
import com.pulumi.aws.apigateway.StageArgs;
import com.pulumi.aws.apigateway.UsagePlan;
import com.pulumi.aws.apigateway.UsagePlanArgs;
import com.pulumi.aws.apigateway.inputs.UsagePlanApiStageArgs;
import com.pulumi.aws.apigateway.inputs.UsagePlanQuotaSettingsArgs;
import com.pulumi.aws.apigateway.inputs.UsagePlanThrottleSettingsArgs;
import static com.pulumi.codegen.internal.Serialization.*;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;

public class App {
    public static void main(String[] args) {
        Pulumi.run(App::stack);
    }

    public static void stack(Context ctx) {
        var exampleRestApi = new RestApi("exampleRestApi", RestApiArgs.builder()        
            .body(serializeJson(
                jsonObject(
                    jsonProperty("openapi", "3.0.1"),
                    jsonProperty("info", jsonObject(
                        jsonProperty("title", "example"),
                        jsonProperty("version", "1.0")
                    )),
                    jsonProperty("paths", jsonObject(
                        jsonProperty("/path1", jsonObject(
                            jsonProperty("get", jsonObject(
                                jsonProperty("x-amazon-apigateway-integration", jsonObject(
                                    jsonProperty("httpMethod", "GET"),
                                    jsonProperty("payloadFormatVersion", "1.0"),
                                    jsonProperty("type", "HTTP_PROXY"),
                                    jsonProperty("uri", "https://ip-ranges.amazonaws.com/ip-ranges.json")
                                ))
                            ))
                        ))
                    ))
                )))
            .build());

        var exampleDeployment = new Deployment("exampleDeployment", DeploymentArgs.builder()        
            .restApi(exampleRestApi.id())
            .triggers(Map.of("redeployment", exampleRestApi.body().applyValue(body -> serializeJson(
                body)).applyValue(toJSON -> computeSHA1(toJSON))))
            .build());

        var development = new Stage("development", StageArgs.builder()        
            .deployment(exampleDeployment.id())
            .restApi(exampleRestApi.id())
            .stageName("development")
            .build());

        var production = new Stage("production", StageArgs.builder()        
            .deployment(exampleDeployment.id())
            .restApi(exampleRestApi.id())
            .stageName("production")
            .build());

        var exampleUsagePlan = new UsagePlan("exampleUsagePlan", UsagePlanArgs.builder()        
            .description("my description")
            .productCode("MYCODE")
            .apiStages(            
                UsagePlanApiStageArgs.builder()
                    .apiId(exampleRestApi.id())
                    .stage(development.stageName())
                    .build(),
                UsagePlanApiStageArgs.builder()
                    .apiId(exampleRestApi.id())
                    .stage(production.stageName())
                    .build())
            .quotaSettings(UsagePlanQuotaSettingsArgs.builder()
                .limit(20)
                .offset(2)
                .period("WEEK")
                .build())
            .throttleSettings(UsagePlanThrottleSettingsArgs.builder()
                .burstLimit(5)
                .rateLimit(10)
                .build())
            .build());

    }
}
```

</details>

<details>

<summary>typescript</summary>

```typescript
import * as pulumi from "@pulumi/pulumi";
import * as aws from "@pulumi/aws";
import * as crypto from "crypto";

const exampleRestApi = new aws.apigateway.RestApi("exampleRestApi", {body: JSON.stringify({
    openapi: "3.0.1",
    info: {
        title: "example",
        version: "1.0",
    },
    paths: {
        "/path1": {
            get: {
                "x-amazon-apigateway-integration": {
                    httpMethod: "GET",
                    payloadFormatVersion: "1.0",
                    type: "HTTP_PROXY",
                    uri: "https://ip-ranges.amazonaws.com/ip-ranges.json",
                },
            },
        },
    },
})});
const exampleDeployment = new aws.apigateway.Deployment("exampleDeployment", {
    restApi: exampleRestApi.id,
    triggers: {
        redeployment: exampleRestApi.body.apply(body => JSON.stringify(body)).apply(toJSON => crypto.createHash('sha1').update(toJSON).digest('hex')),
    },
});
const development = new aws.apigateway.Stage("development", {
    deployment: exampleDeployment.id,
    restApi: exampleRestApi.id,
    stageName: "development",
});
const production = new aws.apigateway.Stage("production", {
    deployment: exampleDeployment.id,
    restApi: exampleRestApi.id,
    stageName: "production",
});
const exampleUsagePlan = new aws.apigateway.UsagePlan("exampleUsagePlan", {
    description: "my description",
    productCode: "MYCODE",
    apiStages: [
        {
            apiId: exampleRestApi.id,
            stage: development.stageName,
        },
        {
            apiId: exampleRestApi.id,
            stage: production.stageName,
        },
    ],
    quotaSettings: {
        limit: 20,
        offset: 2,
        period: "WEEK",
    },
    throttleSettings: {
        burstLimit: 5,
        rateLimit: 10,
    },
});
```

</details>

## [**complete failure**] Lambda Tasks

### HCL

```terraform
resource "aws_ssm_maintenance_window_task" "example" {
  max_concurrency = 2
  max_errors      = 1
  priority        = 1
  task_arn        = aws_lambda_function.example.arn
  task_type       = "LAMBDA"
  window_id       = aws_ssm_maintenance_window.example.id

  targets {
    key    = "InstanceIds"
    values = [aws_instance.example.id]
  }

  task_invocation_parameters {
    lambda_parameters {
      client_context = base64encode("{\"key1\":\"value1\"}")
      payload        = "{\"key1\":\"value1\"}"
    }
  }
}

```

### Failed Languages

#### csharp

```text
:15,24-36: unknown function 'base64encode'; , and 1 other diagnostic(s)
```

#### go

```text
:15,24-36: unknown function 'base64encode'; , and 1 other diagnostic(s)
```

#### yaml

```text
:15,24-36: unknown function 'base64encode'; , and 1 other diagnostic(s)
```

#### java

```text
:15,24-36: unknown function 'base64encode'; , and 1 other diagnostic(s)
```

#### typescript

```text
:15,24-36: unknown function 'base64encode'; , and 1 other diagnostic(s)
```

#### python

```text
:15,24-36: unknown function 'base64encode'; , and 1 other diagnostic(s)
```

## [*partial failure*] #/resources/aws:elb/loadBalancerBackendServerPolicy:LoadBalancerBackendServerPolicy

### HCL

```terraform
resource "aws_elb" "wu-tang" {
  name               = "wu-tang"
  availability_zones = ["us-east-1a"]

  listener {
    instance_port      = 443
    instance_protocol  = "http"
    lb_port            = 443
    lb_protocol        = "https"
    ssl_certificate_id = "arn:aws:iam::000000000000:server-certificate/wu-tang.net"
  }

  tags = {
    Name = "wu-tang"
  }
}

resource "aws_load_balancer_policy" "wu-tang-ca-pubkey-policy" {
  load_balancer_name = aws_elb.wu-tang.name
  policy_name        = "wu-tang-ca-pubkey-policy"
  policy_type_name   = "PublicKeyPolicyType"

  # The public key of a CA certificate file can be extracted with:
  # $ cat wu-tang-ca.pem | openssl x509 -pubkey -noout | grep -v '\-\-\-\-' | tr -d '\n' > wu-tang-pubkey
  policy_attribute {
    name  = "PublicKey"
    value = file("wu-tang-pubkey")
  }
}

resource "aws_load_balancer_policy" "wu-tang-root-ca-backend-auth-policy" {
  load_balancer_name = aws_elb.wu-tang.name
  policy_name        = "wu-tang-root-ca-backend-auth-policy"
  policy_type_name   = "BackendServerAuthenticationPolicyType"

  policy_attribute {
    name  = "PublicKeyPolicyName"
    value = aws_load_balancer_policy.wu-tang-root-ca-pubkey-policy.policy_name
  }
}

resource "aws_load_balancer_backend_server_policy" "wu-tang-backend-auth-policies-443" {
  load_balancer_name = aws_elb.wu-tang.name
  instance_port      = 443

  policy_names = [
    aws_load_balancer_policy.wu-tang-root-ca-backend-auth-policy.policy_name,
  ]
}

```

### Failed Languages

#### yaml

```text
.pp:14,21-29: Invalid property name access; 'wu-tang' is not a valid property name access. It has been changed to a quoted key access., and 5 other diagnostic(s)
```

### Successes

<details>

<summary>java</summary>

```java
package generated_program;

import com.pulumi.Context;
import com.pulumi.Pulumi;
import com.pulumi.core.Output;
import com.pulumi.aws.elb.LoadBalancer;
import com.pulumi.aws.elb.LoadBalancerArgs;
import com.pulumi.aws.elb.inputs.LoadBalancerListenerArgs;
import com.pulumi.aws.elb.LoadBalancerPolicy;
import com.pulumi.aws.elb.LoadBalancerPolicyArgs;
import com.pulumi.aws.elb.inputs.LoadBalancerPolicyPolicyAttributeArgs;
import com.pulumi.aws.elb.LoadBalancerBackendServerPolicy;
import com.pulumi.aws.elb.LoadBalancerBackendServerPolicyArgs;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;

public class App {
    public static void main(String[] args) {
        Pulumi.run(App::stack);
    }

    public static void stack(Context ctx) {
        var wu_tang = new LoadBalancer("wu-tang", LoadBalancerArgs.builder()        
            .availabilityZones("us-east-1a")
            .listeners(LoadBalancerListenerArgs.builder()
                .instancePort(443)
                .instanceProtocol("http")
                .lbPort(443)
                .lbProtocol("https")
                .sslCertificateId("arn:aws:iam::000000000000:server-certificate/wu-tang.net")
                .build())
            .tags(Map.of("Name", "wu-tang"))
            .build());

        var wu_tang_ca_pubkey_policy = new LoadBalancerPolicy("wu-tang-ca-pubkey-policy", LoadBalancerPolicyArgs.builder()        
            .loadBalancerName(wu_tang.name())
            .policyName("wu-tang-ca-pubkey-policy")
            .policyTypeName("PublicKeyPolicyType")
            .policyAttributes(LoadBalancerPolicyPolicyAttributeArgs.builder()
                .name("PublicKey")
                .value(Files.readString(Paths.get("wu-tang-pubkey")))
                .build())
            .build());

        var wu_tang_root_ca_backend_auth_policy = new LoadBalancerPolicy("wu-tang-root-ca-backend-auth-policy", LoadBalancerPolicyArgs.builder()        
            .loadBalancerName(wu_tang.name())
            .policyName("wu-tang-root-ca-backend-auth-policy")
            .policyTypeName("BackendServerAuthenticationPolicyType")
            .policyAttributes(LoadBalancerPolicyPolicyAttributeArgs.builder()
                .name("PublicKeyPolicyName")
                .value(aws_load_balancer_policy.wu-tang-root-ca-pubkey-policy().policy_name())
                .build())
            .build());

        var wu_tang_backend_auth_policies_443 = new LoadBalancerBackendServerPolicy("wu-tang-backend-auth-policies-443", LoadBalancerBackendServerPolicyArgs.builder()        
            .loadBalancerName(wu_tang.name())
            .instancePort(443)
            .policyNames(wu_tang_root_ca_backend_auth_policy.policyName())
            .build());

    }
}
```

</details>

<details>

<summary>typescript</summary>

```typescript
import * as pulumi from "@pulumi/pulumi";
import * as aws from "@pulumi/aws";
import * as fs from "fs";

const wu_tang = new aws.elb.LoadBalancer("wu-tang", {
    availabilityZones: ["us-east-1a"],
    listeners: [{
        instancePort: 443,
        instanceProtocol: "http",
        lbPort: 443,
        lbProtocol: "https",
        sslCertificateId: "arn:aws:iam::000000000000:server-certificate/wu-tang.net",
    }],
    tags: {
        Name: "wu-tang",
    },
});
const wu_tang_ca_pubkey_policy = new aws.elb.LoadBalancerPolicy("wu-tang-ca-pubkey-policy", {
    loadBalancerName: wu_tang.name,
    policyName: "wu-tang-ca-pubkey-policy",
    policyTypeName: "PublicKeyPolicyType",
    policyAttributes: [{
        name: "PublicKey",
        value: fs.readFileSync("wu-tang-pubkey"),
    }],
});
const wu_tang_root_ca_backend_auth_policy = new aws.elb.LoadBalancerPolicy("wu-tang-root-ca-backend-auth-policy", {
    loadBalancerName: wu_tang.name,
    policyName: "wu-tang-root-ca-backend-auth-policy",
    policyTypeName: "BackendServerAuthenticationPolicyType",
    policyAttributes: [{
        name: "PublicKeyPolicyName",
        value: aws_load_balancer_policy["wu-tang-root-ca-pubkey-policy"].policy_name,
    }],
});
const wu_tang_backend_auth_policies_443 = new aws.elb.LoadBalancerBackendServerPolicy("wu-tang-backend-auth-policies-443", {
    loadBalancerName: wu_tang.name,
    instancePort: 443,
    policyNames: [wu_tang_root_ca_backend_auth_policy.policyName],
});
```

</details>

<details>

<summary>python</summary>

```python
import pulumi
import pulumi_aws as aws

wu_tang = aws.elb.LoadBalancer("wu-tang",
    availability_zones=["us-east-1a"],
    listeners=[aws.elb.LoadBalancerListenerArgs(
        instance_port=443,
        instance_protocol="http",
        lb_port=443,
        lb_protocol="https",
        ssl_certificate_id="arn:aws:iam::000000000000:server-certificate/wu-tang.net",
    )],
    tags={
        "Name": "wu-tang",
    })
wu_tang_ca_pubkey_policy = aws.elb.LoadBalancerPolicy("wu-tang-ca-pubkey-policy",
    load_balancer_name=wu_tang.name,
    policy_name="wu-tang-ca-pubkey-policy",
    policy_type_name="PublicKeyPolicyType",
    policy_attributes=[aws.elb.LoadBalancerPolicyPolicyAttributeArgs(
        name="PublicKey",
        value=(lambda path: open(path).read())("wu-tang-pubkey"),
    )])
wu_tang_root_ca_backend_auth_policy = aws.elb.LoadBalancerPolicy("wu-tang-root-ca-backend-auth-policy",
    load_balancer_name=wu_tang.name,
    policy_name="wu-tang-root-ca-backend-auth-policy",
    policy_type_name="BackendServerAuthenticationPolicyType",
    policy_attributes=[aws.elb.LoadBalancerPolicyPolicyAttributeArgs(
        name="PublicKeyPolicyName",
        value=aws_load_balancer_policy["wu-tang-root-ca-pubkey-policy"]["policy_name"],
    )])
wu_tang_backend_auth_policies_443 = aws.elb.LoadBalancerBackendServerPolicy("wu-tang-backend-auth-policies-443",
    load_balancer_name=wu_tang.name,
    instance_port=443,
    policy_names=[wu_tang_root_ca_backend_auth_policy.policy_name])
```

</details>

<details>

<summary>csharp</summary>

```csharp
using System.Collections.Generic;
using System.IO;
using Pulumi;
using Aws = Pulumi.Aws;

return await Deployment.RunAsync(() => 
{
    var wu_tang = new Aws.Elb.LoadBalancer("wu-tang", new()
    {
        AvailabilityZones = new[]
        {
            "us-east-1a",
        },
        Listeners = new[]
        {
            new Aws.Elb.Inputs.LoadBalancerListenerArgs
            {
                InstancePort = 443,
                InstanceProtocol = "http",
                LbPort = 443,
                LbProtocol = "https",
                SslCertificateId = "arn:aws:iam::000000000000:server-certificate/wu-tang.net",
            },
        },
        Tags = 
        {
            { "Name", "wu-tang" },
        },
    });

    var wu_tang_ca_pubkey_policy = new Aws.Elb.LoadBalancerPolicy("wu-tang-ca-pubkey-policy", new()
    {
        LoadBalancerName = wu_tang.Name,
        PolicyName = "wu-tang-ca-pubkey-policy",
        PolicyTypeName = "PublicKeyPolicyType",
        PolicyAttributes = new[]
        {
            new Aws.Elb.Inputs.LoadBalancerPolicyPolicyAttributeArgs
            {
                Name = "PublicKey",
                Value = File.ReadAllText("wu-tang-pubkey"),
            },
        },
    });

    var wu_tang_root_ca_backend_auth_policy = new Aws.Elb.LoadBalancerPolicy("wu-tang-root-ca-backend-auth-policy", new()
    {
        LoadBalancerName = wu_tang.Name,
        PolicyName = "wu-tang-root-ca-backend-auth-policy",
        PolicyTypeName = "BackendServerAuthenticationPolicyType",
        PolicyAttributes = new[]
        {
            new Aws.Elb.Inputs.LoadBalancerPolicyPolicyAttributeArgs
            {
                Name = "PublicKeyPolicyName",
                Value = aws_load_balancer_policy.Wu_tang_root_ca_pubkey_policy.Policy_name,
            },
        },
    });

    var wu_tang_backend_auth_policies_443 = new Aws.Elb.LoadBalancerBackendServerPolicy("wu-tang-backend-auth-policies-443", new()
    {
        LoadBalancerName = wu_tang.Name,
        InstancePort = 443,
        PolicyNames = new[]
        {
            wu_tang_root_ca_backend_auth_policy.PolicyName,
        },
    });

});
```

</details>

<details>

<summary>go</summary>

```go
package main

import (
	"io/ioutil"

	"github.com/pulumi/pulumi-aws/sdk/v5/go/aws/elb"
	"github.com/pulumi/pulumi/sdk/v3/go/pulumi"
)

func readFileOrPanic(path string) pulumi.StringPtrInput {
	data, err := ioutil.ReadFile(path)
	if err != nil {
		panic(err.Error())
	}
	return pulumi.String(string(data))
}

func main() {
	pulumi.Run(func(ctx *pulumi.Context) error {
		_, err := elb.NewLoadBalancer(ctx, "wu-tang", &elb.LoadBalancerArgs{
			AvailabilityZones: pulumi.StringArray{
				pulumi.String("us-east-1a"),
			},
			Listeners: elb.LoadBalancerListenerArray{
				&elb.LoadBalancerListenerArgs{
					InstancePort:     pulumi.Int(443),
					InstanceProtocol: pulumi.String("http"),
					LbPort:           pulumi.Int(443),
					LbProtocol:       pulumi.String("https"),
					SslCertificateId: pulumi.String("arn:aws:iam::000000000000:server-certificate/wu-tang.net"),
				},
			},
			Tags: pulumi.StringMap{
				"Name": pulumi.String("wu-tang"),
			},
		})
		if err != nil {
			return err
		}
		_, err = elb.NewLoadBalancerPolicy(ctx, "wu-tang-ca-pubkey-policy", &elb.LoadBalancerPolicyArgs{
			LoadBalancerName: wu_tang.Name,
			PolicyName:       pulumi.String("wu-tang-ca-pubkey-policy"),
			PolicyTypeName:   pulumi.String("PublicKeyPolicyType"),
			PolicyAttributes: elb.LoadBalancerPolicyPolicyAttributeArray{
				&elb.LoadBalancerPolicyPolicyAttributeArgs{
					Name:  pulumi.String("PublicKey"),
					Value: readFileOrPanic("wu-tang-pubkey"),
				},
			},
		})
		if err != nil {
			return err
		}
		_, err = elb.NewLoadBalancerPolicy(ctx, "wu-tang-root-ca-backend-auth-policy", &elb.LoadBalancerPolicyArgs{
			LoadBalancerName: wu_tang.Name,
			PolicyName:       pulumi.String("wu-tang-root-ca-backend-auth-policy"),
			PolicyTypeName:   pulumi.String("BackendServerAuthenticationPolicyType"),
			PolicyAttributes: elb.LoadBalancerPolicyPolicyAttributeArray{
				&elb.LoadBalancerPolicyPolicyAttributeArgs{
					Name:  pulumi.String("PublicKeyPolicyName"),
					Value: pulumi.Any(aws_load_balancer_policy.Wu - tang - root - ca - pubkey - policy.Policy_name),
				},
			},
		})
		if err != nil {
			return err
		}
		_, err = elb.NewLoadBalancerBackendServerPolicy(ctx, "wu-tang-backend-auth-policies-443", &elb.LoadBalancerBackendServerPolicyArgs{
			LoadBalancerName: wu_tang.Name,
			InstancePort:     pulumi.Int(443),
			PolicyNames: pulumi.StringArray{
				wu_tang_root_ca_backend_auth_policy.PolicyName,
			},
		})
		if err != nil {
			return err
		}
		return nil
	})
}
```

</details>

## [*partial failure*] Basic

### HCL

```terraform
resource "aws_iam_role" "dlm_lifecycle_role" {
  name = "dlm-lifecycle-role"

  assume_role_policy = <<EOF
{
  "Version": "2012-10-17",
  "Statement": [
    {
      "Action": "sts:AssumeRole",
      "Principal": {
        "Service": "dlm.amazonaws.com"
      },
      "Effect": "Allow",
      "Sid": ""
    }
  ]
}
EOF
}

resource "aws_iam_role_policy" "dlm_lifecycle" {
  name = "dlm-lifecycle-policy"
  role = aws_iam_role.dlm_lifecycle_role.id

  policy = <<EOF
{
   "Version": "2012-10-17",
   "Statement": [
      {
         "Effect": "Allow",
         "Action": [
            "ec2:CreateSnapshot",
            "ec2:CreateSnapshots",
            "ec2:DeleteSnapshot",
            "ec2:DescribeInstances",
            "ec2:DescribeVolumes",
            "ec2:DescribeSnapshots"
         ],
         "Resource": "*"
      },
      {
         "Effect": "Allow",
         "Action": [
            "ec2:CreateTags"
         ],
         "Resource": "arn:aws:ec2:*::snapshot/*"
      }
   ]
}
EOF
}

resource "aws_dlm_lifecycle_policy" "example" {
  description        = "example DLM lifecycle policy"
  execution_role_arn = aws_iam_role.dlm_lifecycle_role.arn
  state              = "ENABLED"

  policy_details {
    resource_types = ["VOLUME"]

    schedule {
      name = "2 weeks of daily snapshots"

      create_rule {
        interval      = 24
        interval_unit = "HOURS"
        times         = ["23:45"]
      }

      retain_rule {
        count = 14
      }

      tags_to_add = {
        SnapshotCreator = "DLM"
      }

      copy_tags = false
    }

    target_tags = {
      Snapshot = "true"
    }
  }
}

```

### Failed Languages

#### typescript

```text
:0,0-0: cannot traverse value of type string; , and 4 other diagnostic(s)
```

#### python

```text
:0,0-0: cannot traverse value of type string; , and 4 other diagnostic(s)
```

#### csharp

```text
:0,0-0: cannot traverse value of type string; , and 4 other diagnostic(s)
```

#### go

```text
:0,0-0: cannot traverse value of type string; , and 4 other diagnostic(s)
```

### Successes

<details>

<summary>yaml</summary>

```yaml
resources:
  dlmLifecycleRole:
    type: aws:iam:Role
    properties:
      assumeRolePolicy: |
        {
          "Version": "2012-10-17",
          "Statement": [
            {
              "Action": "sts:AssumeRole",
              "Principal": {
                "Service": "dlm.amazonaws.com"
              },
              "Effect": "Allow",
              "Sid": ""
            }
          ]
        }
  dlmLifecycle:
    type: aws:iam:RolePolicy
    properties:
      role: ${dlmLifecycleRole.id}
      policy: |
        {
           "Version": "2012-10-17",
           "Statement": [
              {
                 "Effect": "Allow",
                 "Action": [
                    "ec2:CreateSnapshot",
                    "ec2:CreateSnapshots",
                    "ec2:DeleteSnapshot",
                    "ec2:DescribeInstances",
                    "ec2:DescribeVolumes",
                    "ec2:DescribeSnapshots"
                 ],
                 "Resource": "*"
              },
              {
                 "Effect": "Allow",
                 "Action": [
                    "ec2:CreateTags"
                 ],
                 "Resource": "arn:aws:ec2:*::snapshot/*"
              }
           ]
        }
  example:
    type: aws:dlm:LifecyclePolicy
    properties:
      description: example DLM lifecycle policy
      executionRoleArn: ${dlmLifecycleRole.arn}
      state: ENABLED
      policyDetails:
        resourceTypes:
          - VOLUME
        schedules:
          - name: 2 weeks of daily snapshots
            createRule:
              interval: 24
              intervalUnit: HOURS
              times:
                - 23:45
            retainRule:
              count: 14
            tagsToAdd:
              SnapshotCreator: DLM
            copyTags: false
        targetTags:
          Snapshot: true
```

</details>

<details>

<summary>java</summary>

```java
package generated_program;

import com.pulumi.Context;
import com.pulumi.Pulumi;
import com.pulumi.core.Output;
import com.pulumi.aws.iam.Role;
import com.pulumi.aws.iam.RoleArgs;
import com.pulumi.aws.iam.RolePolicy;
import com.pulumi.aws.iam.RolePolicyArgs;
import com.pulumi.aws.dlm.LifecyclePolicy;
import com.pulumi.aws.dlm.LifecyclePolicyArgs;
import com.pulumi.aws.dlm.inputs.LifecyclePolicyPolicyDetailsArgs;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;

public class App {
    public static void main(String[] args) {
        Pulumi.run(App::stack);
    }

    public static void stack(Context ctx) {
        var dlmLifecycleRole = new Role("dlmLifecycleRole", RoleArgs.builder()        
            .assumeRolePolicy("""
{
  "Version": "2012-10-17",
  "Statement": [
    {
      "Action": "sts:AssumeRole",
      "Principal": {
        "Service": "dlm.amazonaws.com"
      },
      "Effect": "Allow",
      "Sid": ""
    }
  ]
}
            """)
            .build());

        var dlmLifecycle = new RolePolicy("dlmLifecycle", RolePolicyArgs.builder()        
            .role(dlmLifecycleRole.id())
            .policy("""
{
   "Version": "2012-10-17",
   "Statement": [
      {
         "Effect": "Allow",
         "Action": [
            "ec2:CreateSnapshot",
            "ec2:CreateSnapshots",
            "ec2:DeleteSnapshot",
            "ec2:DescribeInstances",
            "ec2:DescribeVolumes",
            "ec2:DescribeSnapshots"
         ],
         "Resource": "*"
      },
      {
         "Effect": "Allow",
         "Action": [
            "ec2:CreateTags"
         ],
         "Resource": "arn:aws:ec2:*::snapshot/*"
      }
   ]
}
            """)
            .build());

        var example = new LifecyclePolicy("example", LifecyclePolicyArgs.builder()        
            .description("example DLM lifecycle policy")
            .executionRoleArn(dlmLifecycleRole.arn())
            .state("ENABLED")
            .policyDetails(LifecyclePolicyPolicyDetailsArgs.builder()
                .resourceTypes("VOLUME")
                .schedules(LifecyclePolicyPolicyDetailsScheduleArgs.builder()
                    .name("2 weeks of daily snapshots")
                    .createRule(LifecyclePolicyPolicyDetailsScheduleCreateRuleArgs.builder()
                        .interval(24)
                        .intervalUnit("HOURS")
                        .times("23:45")
                        .build())
                    .retainRule(LifecyclePolicyPolicyDetailsScheduleRetainRuleArgs.builder()
                        .count(14)
                        .build())
                    .tagsToAdd(Map.of("SnapshotCreator", "DLM"))
                    .copyTags(false)
                    .build())
                .targetTags(Map.of("Snapshot", "true"))
                .build())
            .build());

    }
}
```

</details>

## [*partial failure*] Example Cross-Region Snapshot Copy Usage

### HCL

```terraform
# ...other configuration...
data "aws_caller_identity" "current" {}

resource "aws_kms_key" "dlm_cross_region_copy_cmk" {
  provider = aws.alternate

  description = "Example Alternate Region KMS Key"

  policy = <<POLICY
{
  "Version": "2012-10-17",
  "Id": "dlm-cross-region-copy-cmk",
  "Statement": [
    {
      "Sid": "Enable IAM User Permissions",
      "Effect": "Allow",
      "Principal": {
        "AWS": "arn:aws:iam::${data.aws_caller_identity.current.account_id}:root"
      },
      "Action": "kms:*",
      "Resource": "*"
    }
  ]
}
POLICY
}

resource "aws_dlm_lifecycle_policy" "example" {
  description        = "example DLM lifecycle policy"
  execution_role_arn = aws_iam_role.dlm_lifecycle_role.arn
  state              = "ENABLED"

  policy_details {
    resource_types = ["VOLUME"]

    schedule {
      name = "2 weeks of daily snapshots"

      create_rule {
        interval      = 24
        interval_unit = "HOURS"
        times         = ["23:45"]
      }

      retain_rule {
        count = 14
      }

      tags_to_add = {
        SnapshotCreator = "DLM"
      }

      copy_tags = false

      cross_region_copy_rule {
        target    = "us-west-2"
        encrypted = true
        cmk_arn   = aws_kms_key.dlm_cross_region_copy_cmk.arn
        copy_tags = true
        retain_rule {
          interval      = 30
          interval_unit = "DAYS"
        }
      }
    }

    target_tags = {
      Snapshot = "true"
    }
  }
}

```

### Failed Languages

#### typescript

```text
:0,0-0: cannot traverse value of type string; , and 4 other diagnostic(s)
```

#### python

```text
:0,0-0: cannot traverse value of type string; , and 4 other diagnostic(s)
```

#### csharp

```text
:0,0-0: cannot traverse value of type string; , and 4 other diagnostic(s)
```

#### go

```text
:0,0-0: cannot traverse value of type string; , and 4 other diagnostic(s)
```

### Successes

<details>

<summary>yaml</summary>

```yaml
resources:
  dlmCrossRegionCopyCmk:
    type: aws:kms:Key
    properties:
      description: Example Alternate Region KMS Key
      policy: |
        {
          "Version": "2012-10-17",
          "Id": "dlm-cross-region-copy-cmk",
          "Statement": [
            {
              "Sid": "Enable IAM User Permissions",
              "Effect": "Allow",
              "Principal": {
                "AWS": "arn:aws:iam::${current.accountId}:root"
              },
              "Action": "kms:*",
              "Resource": "*"
            }
          ]
        }
    options:
      provider: ${aws.alternate}
  example:
    type: aws:dlm:LifecyclePolicy
    properties:
      description: example DLM lifecycle policy
      executionRoleArn: ${aws_iam_role.dlm_lifecycle_role.arn}
      state: ENABLED
      policyDetails:
        resourceTypes:
          - VOLUME
        schedules:
          - name: 2 weeks of daily snapshots
            createRule:
              interval: 24
              intervalUnit: HOURS
              times:
                - 23:45
            retainRule:
              count: 14
            tagsToAdd:
              SnapshotCreator: DLM
            copyTags: false
            crossRegionCopyRules:
              - target: us-west-2
                encrypted: true
                cmkArn: ${dlmCrossRegionCopyCmk.arn}
                copyTags: true
                retainRule:
                  interval: 30
                  intervalUnit: DAYS
        targetTags:
          Snapshot: true
variables:
  current:
    Fn::Invoke:
      Function: aws:getCallerIdentity
      Arguments: {}
```

</details>

<details>

<summary>java</summary>

```java
package generated_program;

import com.pulumi.Context;
import com.pulumi.Pulumi;
import com.pulumi.core.Output;
import com.pulumi.aws.AwsFunctions;
import com.pulumi.aws.kms.Key;
import com.pulumi.aws.kms.KeyArgs;
import com.pulumi.aws.dlm.LifecyclePolicy;
import com.pulumi.aws.dlm.LifecyclePolicyArgs;
import com.pulumi.aws.dlm.inputs.LifecyclePolicyPolicyDetailsArgs;
import com.pulumi.resources.CustomResourceOptions;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;

public class App {
    public static void main(String[] args) {
        Pulumi.run(App::stack);
    }

    public static void stack(Context ctx) {
        final var current = AwsFunctions.getCallerIdentity();

        var dlmCrossRegionCopyCmk = new Key("dlmCrossRegionCopyCmk", KeyArgs.builder()        
            .description("Example Alternate Region KMS Key")
            .policy("""
{
  "Version": "2012-10-17",
  "Id": "dlm-cross-region-copy-cmk",
  "Statement": [
    {
      "Sid": "Enable IAM User Permissions",
      "Effect": "Allow",
      "Principal": {
        "AWS": "arn:aws:iam::%s:root"
      },
      "Action": "kms:*",
      "Resource": "*"
    }
  ]
}
", current.applyValue(getCallerIdentityResult -> getCallerIdentityResult.accountId())))
            .build(), CustomResourceOptions.builder()
                .provider(aws.alternate())
                .build());

        var example = new LifecyclePolicy("example", LifecyclePolicyArgs.builder()        
            .description("example DLM lifecycle policy")
            .executionRoleArn(aws_iam_role.dlm_lifecycle_role().arn())
            .state("ENABLED")
            .policyDetails(LifecyclePolicyPolicyDetailsArgs.builder()
                .resourceTypes("VOLUME")
                .schedules(LifecyclePolicyPolicyDetailsScheduleArgs.builder()
                    .name("2 weeks of daily snapshots")
                    .createRule(LifecyclePolicyPolicyDetailsScheduleCreateRuleArgs.builder()
                        .interval(24)
                        .intervalUnit("HOURS")
                        .times("23:45")
                        .build())
                    .retainRule(LifecyclePolicyPolicyDetailsScheduleRetainRuleArgs.builder()
                        .count(14)
                        .build())
                    .tagsToAdd(Map.of("SnapshotCreator", "DLM"))
                    .copyTags(false)
                    .crossRegionCopyRules(LifecyclePolicyPolicyDetailsScheduleCrossRegionCopyRuleArgs.builder()
                        .target("us-west-2")
                        .encrypted(true)
                        .cmkArn(dlmCrossRegionCopyCmk.arn())
                        .copyTags(true)
                        .retainRule(LifecyclePolicyPolicyDetailsScheduleCrossRegionCopyRuleRetainRuleArgs.builder()
                            .interval(30)
                            .intervalUnit("DAYS")
                            .build())
                        .build())
                    .build())
                .targetTags(Map.of("Snapshot", "true"))
                .build())
            .build());

    }
}
```

</details>

## [**complete failure**] Example Event Based Policy Usage

### HCL

```terraform
data "aws_caller_identity" "current" {}

resource "aws_dlm_lifecycle_policy" "example" {
  description        = "tf-acc-basic"
  execution_role_arn = aws_iam_role.example.arn

  policy_details {
    policy_type = "EVENT_BASED_POLICY"

    action {
      name = "tf-acc-basic"
      cross_region_copy {
        encryption_configuration {}
        retain_rule {
          interval      = 15
          interval_unit = "MONTHS"
        }

        target = %[1]q
      }
    }

    event_source {
      type = "MANAGED_CWE"
      parameters {
        description_regex = "^.*Created for policy: policy-1234567890abcdef0.*$"
        event_type        = "shareSnapshot"
        snapshot_owner    = [data.aws_caller_identity.current.account_id]
      }
    }
  }
}

data "aws_iam_policy" "example" {
  name = "AWSDataLifecycleManagerServiceRole"
}

resource "aws_iam_role_policy_attachment" "example" {
  role       = aws_iam_role.example.id
  policy_arn = data.aws_iam_policy.example.arn
}

```

### Failed Languages

#### typescript

```text
:18,18-19: Invalid expression; Expected the start of an expression, but found an invalid expression token.
```

#### python

```text
:18,18-19: Invalid expression; Expected the start of an expression, but found an invalid expression token.
```

#### csharp

```text
:18,18-19: Invalid expression; Expected the start of an expression, but found an invalid expression token.
```

#### go

```text
:18,18-19: Invalid expression; Expected the start of an expression, but found an invalid expression token.
```

#### yaml

```text
:18,18-19: Invalid expression; Expected the start of an expression, but found an invalid expression token.
```

#### java

```text
:18,18-19: Invalid expression; Expected the start of an expression, but found an invalid expression token.
```

## [*partial failure*] Basic Usage

### HCL

```terraform
resource "aws_servicecatalog_product" "example" {
  name  = "example"
  owner = [aws_security_group.example.id]
  type  = aws_subnet.main.id

  provisioning_artifact_parameters {
    template_url = "https://s3.amazonaws.com/cf-templates-ozkq9d3hgiq2-us-east-1/temp1.json"
  }

  tags = {
    foo = "bar"
  }
}

```

### Failed Languages

#### go

```text
:0,0-0: cannot traverse value of type string; , and 2 other diagnostic(s)
```

#### typescript

```text
:0,0-0: cannot traverse value of type string; , and 2 other diagnostic(s)
```

#### python

```text
:0,0-0: cannot traverse value of type string; , and 2 other diagnostic(s)
```

#### csharp

```text
:0,0-0: cannot traverse value of type string; , and 2 other diagnostic(s)
```

### Successes

<details>

<summary>yaml</summary>

```yaml
resources:
  example:
    type: aws:servicecatalog:Product
    properties:
      owner:
        - ${aws_security_group.example.id}
      type: ${aws_subnet.main.id}
      provisioningArtifactParameters:
        templateUrl: https://s3.amazonaws.com/cf-templates-ozkq9d3hgiq2-us-east-1/temp1.json
      tags:
        foo: bar
```

</details>

<details>

<summary>java</summary>

```java
package generated_program;

import com.pulumi.Context;
import com.pulumi.Pulumi;
import com.pulumi.core.Output;
import com.pulumi.aws.servicecatalog.Product;
import com.pulumi.aws.servicecatalog.ProductArgs;
import com.pulumi.aws.servicecatalog.inputs.ProductProvisioningArtifactParametersArgs;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;

public class App {
    public static void main(String[] args) {
        Pulumi.run(App::stack);
    }

    public static void stack(Context ctx) {
        var example = new Product("example", ProductArgs.builder()        
            .owner(aws_security_group.example().id())
            .type(aws_subnet.main().id())
            .provisioningArtifactParameters(ProductProvisioningArtifactParametersArgs.builder()
                .templateUrl("https://s3.amazonaws.com/cf-templates-ozkq9d3hgiq2-us-east-1/temp1.json")
                .build())
            .tags(Map.of("foo", "bar"))
            .build());

    }
}
```

</details>

## [**complete failure**] #/resources/aws:sagemaker/notebookInstanceLifecycleConfiguration:NotebookInstanceLifecycleConfiguration

### HCL

```terraform
resource "aws_sagemaker_notebook_instance_lifecycle_configuration" "lc" {
  name      = "foo"
  on_create = base64encode("echo foo")
  on_start  = base64encode("echo bar")
}

```

### Failed Languages

#### typescript

```text
:2,15-27: unknown function 'base64encode'; , and 3 other diagnostic(s)
```

#### python

```text
:2,15-27: unknown function 'base64encode'; , and 3 other diagnostic(s)
```

#### csharp

```text
:2,15-27: unknown function 'base64encode'; , and 3 other diagnostic(s)
```

#### go

```text
:2,15-27: unknown function 'base64encode'; , and 3 other diagnostic(s)
```

#### yaml

```text
:2,15-27: unknown function 'base64encode'; , and 3 other diagnostic(s)
```

#### java

```text
:2,15-27: unknown function 'base64encode'; , and 3 other diagnostic(s)
```

## [**complete failure**] With VPC Endpoints

### HCL

```terraform
resource "aws_datasync_agent" "example" {
  ip_address            = "1.2.3.4"
  security_group_arns   = [aws_security_group.example.arn]
  subnet_arns           = [aws_subnet.example.arn]
  vpc_endpoint_id       = aws_vpc_endpoint.example.id
  private_link_endpoint = data.aws_network_interface.example.private_ip
  name                  = "example"
}

data "aws_region" "current" {}

resource "aws_vpc_endpoint" "example" {
  service_name       = "com.amazonaws.${data.aws_region.current.name}.datasync"
  vpc_id             = aws_vpc.example.id
  security_group_ids = [aws_security_group.example.id]
  subnet_ids         = [aws_subnet.example.id]
  vpc_endpoint_type  = "Interface"
}

data "aws_network_interface" "example" {
  id = tolist(aws_vpc_endpoint.example.network_interface_ids)[0]
}

```

### Failed Languages

#### python

```text
:20,8-14: unknown function 'tolist'; , and 1 other diagnostic(s)
```

#### csharp

```text
:20,8-14: unknown function 'tolist'; , and 1 other diagnostic(s)
```

#### go

```text
:20,8-14: unknown function 'tolist'; , and 1 other diagnostic(s)
```

#### yaml

```text
:20,8-14: unknown function 'tolist'; , and 1 other diagnostic(s)
```

#### java

```text
:20,8-14: unknown function 'tolist'; , and 1 other diagnostic(s)
```

#### typescript

```text
:20,8-14: unknown function 'tolist'; , and 1 other diagnostic(s)
```

## [*partial failure*] Referencing domain_validation_options With for_each Based Resources

### HCL

```terraform
resource "aws_route53_record" "example" {
  for_each = {
    for dvo in aws_acm_certificate.example.domain_validation_options : dvo.domain_name => {
      name   = dvo.resource_record_name
      record = dvo.resource_record_value
      type   = dvo.resource_record_type
    }
  }

  allow_overwrite = true
  name            = each.value.name
  records         = [each.value.record]
  ttl             = 60
  type            = each.value.type
  zone_id         = aws_route53_zone.example.zone_id
}

```

### Failed Languages

#### csharp

```text
<nil>: not yet implemented: MapOrObjectEntries; not yet implemented: MapOrObjectEntries
```

#### go

```text
<nil>: not yet implemented: For expression; not yet implemented: For expression
```

#### java

```text
<nil>: not yet implemented: ForExpression; not yet implemented: ForExpression
```

### Successes

<details>

<summary>python</summary>

```python
import pulumi
import pulumi_aws as aws

example = []
for range in [{"key": k, "value": v} for [k, v] in enumerate({dvo.domainName: {
    name: dvo.resourceRecordName,
    record: dvo.resourceRecordValue,
    type: dvo.resourceRecordType,
} for dvo in aws_acm_certificate.example.domain_validation_options})]:
    example.append(aws.route53.Record(f"example-{range['key']}",
        allow_overwrite=True,
        name=range["value"]["name"],
        records=[range["value"]["record"]],
        ttl=60,
        type=aws.route53/recordtype.RecordType(range["value"]["type"]),
        zone_id=aws_route53_zone["example"]["zone_id"]))
```

</details>

<details>

<summary>yaml</summary>

```yaml
resources:
  example:
    type: aws:route53:Record
    properties:
      allowOverwrite: true
      name: ${range.value.name}
      records:
        - ${range.value.record}
      ttl: 60
      type: ${range.value.type}
      zoneId: ${aws_route53_zone.example.zone_id}
    options: {}
```

</details>

<details>

<summary>typescript</summary>

```typescript
import * as pulumi from "@pulumi/pulumi";
import * as aws from "@pulumi/aws";

const example: aws.route53.Record[];
for (const range of Object.entries(.reduce((__obj, dvo) => { ...__obj, [dvo.domainName]: {
    name: dvo.resourceRecordName,
    record: dvo.resourceRecordValue,
    type: dvo.resourceRecordType,
} })).map(([k, v]) => {key: k, value: v})) {
    example.push(new aws.route53.Record(`example-${range.key}`, {
        allowOverwrite: true,
        name: range.value.name,
        records: [range.value.record],
        ttl: 60,
        type: aws.route53.recordtype.RecordType[range.value.type],
        zoneId: aws_route53_zone.example.zone_id,
    }));
}
```

</details>

## [*partial failure*] Managed Rule

### HCL

```terraform
resource "aws_wafv2_web_acl" "example" {
  name        = "managed-rule-example"
  description = "Example of a managed rule."
  scope       = "REGIONAL"

  default_action {
    allow {}
  }

  rule {
    name     = "rule-1"
    priority = 1

    override_action {
      count {}
    }

    statement {
      managed_rule_group_statement {
        name        = "AWSManagedRulesCommonRuleSet"
        vendor_name = "AWS"

        excluded_rule {
          name = "SizeRestrictions_QUERYSTRING"
        }

        excluded_rule {
          name = "NoUserAgent_HEADER"
        }

        scope_down_statement {
          geo_match_statement {
            country_codes = ["US", "NL"]
          }
        }
      }
    }

    visibility_config {
      cloudwatch_metrics_enabled = false
      metric_name                = "friendly-rule-metric-name"
      sampled_requests_enabled   = false
    }
  }

  tags = {
    Tag1 = "Value1"
    Tag2 = "Value2"
  }

  visibility_config {
    cloudwatch_metrics_enabled = false
    metric_name                = "friendly-metric-name"
    sampled_requests_enabled   = false
  }
}

```

### Failed Languages

#### python

```text
:0,0-0: unknown property 'excludedRule' among [scopeDownStatement vendorName version excludedRules name]; , and 4 other diagnostic(s)
```

#### csharp

```text
:0,0-0: unknown property 'excludedRule' among [scopeDownStatement vendorName version excludedRules name]; , and 4 other diagnostic(s)
```

#### go

```text
:0,0-0: unknown property 'excludedRule' among [name scopeDownStatement vendorName version excludedRules]; , and 4 other diagnostic(s)
```

### Successes

<details>

<summary>java</summary>

```java
package generated_program;

import com.pulumi.Context;
import com.pulumi.Pulumi;
import com.pulumi.core.Output;
import com.pulumi.aws.wafv2.WebAcl;
import com.pulumi.aws.wafv2.WebAclArgs;
import com.pulumi.aws.wafv2.inputs.WebAclDefaultActionArgs;
import com.pulumi.aws.wafv2.inputs.WebAclDefaultActionAllowArgs;
import com.pulumi.aws.wafv2.inputs.WebAclRuleArgs;
import com.pulumi.aws.wafv2.inputs.WebAclRuleOverrideActionArgs;
import com.pulumi.aws.wafv2.inputs.WebAclRuleOverrideActionCountArgs;
import com.pulumi.aws.wafv2.inputs.WebAclRuleStatementArgs;
import com.pulumi.aws.wafv2.inputs.WebAclRuleStatementManagedRuleGroupStatementArgs;
import com.pulumi.aws.wafv2.inputs.WebAclRuleStatementManagedRuleGroupStatementScopeDownStatementArgs;
import com.pulumi.aws.wafv2.inputs.WebAclRuleStatementManagedRuleGroupStatementScopeDownStatementGeoMatchStatementArgs;
import com.pulumi.aws.wafv2.inputs.WebAclRuleVisibilityConfigArgs;
import com.pulumi.aws.wafv2.inputs.WebAclVisibilityConfigArgs;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;

public class App {
    public static void main(String[] args) {
        Pulumi.run(App::stack);
    }

    public static void stack(Context ctx) {
        var example = new WebAcl("example", WebAclArgs.builder()        
            .defaultAction(WebAclDefaultActionArgs.builder()
                .allow()
                .build())
            .description("Example of a managed rule.")
            .rules(WebAclRuleArgs.builder()
                .name("rule-1")
                .overrideAction(WebAclRuleOverrideActionArgs.builder()
                    .count()
                    .build())
                .priority(1)
                .statement(WebAclRuleStatementArgs.builder()
                    .managedRuleGroupStatement(WebAclRuleStatementManagedRuleGroupStatementArgs.builder()
                        .excludedRule(                        
                            %!v(PANIC=Format method: runtime error: invalid memory address or nil pointer dereference),
                            %!v(PANIC=Format method: runtime error: invalid memory address or nil pointer dereference))
                        .name("AWSManagedRulesCommonRuleSet")
                        .scopeDownStatement(WebAclRuleStatementManagedRuleGroupStatementScopeDownStatementArgs.builder()
                            .geoMatchStatement(WebAclRuleStatementManagedRuleGroupStatementScopeDownStatementGeoMatchStatementArgs.builder()
                                .countryCodes(                                
                                    "US",
                                    "NL")
                                .build())
                            .build())
                        .vendorName("AWS")
                        .build())
                    .build())
                .visibilityConfig(WebAclRuleVisibilityConfigArgs.builder()
                    .cloudwatchMetricsEnabled(false)
                    .metricName("friendly-rule-metric-name")
                    .sampledRequestsEnabled(false)
                    .build())
                .build())
            .scope("REGIONAL")
            .tags(Map.ofEntries(
                Map.entry("Tag1", "Value1"),
                Map.entry("Tag2", "Value2")
            ))
            .visibilityConfig(WebAclVisibilityConfigArgs.builder()
                .cloudwatchMetricsEnabled(false)
                .metricName("friendly-metric-name")
                .sampledRequestsEnabled(false)
                .build())
            .build());

    }
}
```

</details>

<details>

<summary>typescript</summary>

```typescript
import * as pulumi from "@pulumi/pulumi";
import * as aws from "@pulumi/aws";

const example = new aws.wafv2.WebAcl("example", {
    defaultAction: {
        allow: {},
    },
    description: "Example of a managed rule.",
    rules: [{
        name: "rule-1",
        overrideAction: {
            count: {},
        },
        priority: 1,
        statement: {
            managedRuleGroupStatement: {
                excludedRules: [
                    {
                        name: "SizeRestrictions_QUERYSTRING",
                    },
                    {
                        name: "NoUserAgent_HEADER",
                    },
                ],
                name: "AWSManagedRulesCommonRuleSet",
                scopeDownStatement: {
                    geoMatchStatement: {
                        countryCodes: [
                            "US",
                            "NL",
                        ],
                    },
                },
                vendorName: "AWS",
            },
        },
        visibilityConfig: {
            cloudwatchMetricsEnabled: false,
            metricName: "friendly-rule-metric-name",
            sampledRequestsEnabled: false,
        },
    }],
    scope: "REGIONAL",
    tags: {
        Tag1: "Value1",
        Tag2: "Value2",
    },
    visibilityConfig: {
        cloudwatchMetricsEnabled: false,
        metricName: "friendly-metric-name",
        sampledRequestsEnabled: false,
    },
});
```

</details>

<details>

<summary>yaml</summary>

```yaml
resources:
  example:
    type: aws:wafv2:WebAcl
    properties:
      defaultAction:
        allow: {}
      description: Example of a managed rule.
      rules:
        - name: rule-1
          overrideAction:
            count: {}
          priority: 1
          statement:
            managedRuleGroupStatement:
              excludedRule:
                - name: SizeRestrictions_QUERYSTRING
                - name: NoUserAgent_HEADER
              name: AWSManagedRulesCommonRuleSet
              scopeDownStatement:
                geoMatchStatement:
                  countryCodes:
                    - US
                    - NL
              vendorName: AWS
          visibilityConfig:
            cloudwatchMetricsEnabled: false
            metricName: friendly-rule-metric-name
            sampledRequestsEnabled: false
      scope: REGIONAL
      tags:
        Tag1: Value1
        Tag2: Value2
      visibilityConfig:
        cloudwatchMetricsEnabled: false
        metricName: friendly-metric-name
        sampledRequestsEnabled: false
```

</details>

## [*partial failure*] #/resources/aws:iot/thingPrincipalAttachment:ThingPrincipalAttachment

### HCL

```terraform
resource "aws_iot_thing" "example" {
  name = "example"
}

resource "aws_iot_certificate" "cert" {
  csr    = file("csr.pem")
  active = true
}

resource "aws_iot_thing_principal_attachment" "att" {
  principal = aws_iot_certificate.cert.arn
  thing     = aws_iot_thing.example.name
}

```

### Failed Languages

#### yaml

```text
.pp:3,12-31: Failed to generate YAML program: Unknown Function; YAML does not support Fn::readFile.
```

### Successes

<details>

<summary>typescript</summary>

```typescript
import * as pulumi from "@pulumi/pulumi";
import * as aws from "@pulumi/aws";
import * as fs from "fs";

const example = new aws.iot.Thing("example", {});
const cert = new aws.iot.Certificate("cert", {
    csr: fs.readFileSync("csr.pem"),
    active: true,
});
const att = new aws.iot.ThingPrincipalAttachment("att", {
    principal: cert.arn,
    thing: example.name,
});
```

</details>

<details>

<summary>python</summary>

```python
import pulumi
import pulumi_aws as aws

example = aws.iot.Thing("example")
cert = aws.iot.Certificate("cert",
    csr=(lambda path: open(path).read())("csr.pem"),
    active=True)
att = aws.iot.ThingPrincipalAttachment("att",
    principal=cert.arn,
    thing=example.name)
```

</details>

<details>

<summary>csharp</summary>

```csharp
using System.Collections.Generic;
using System.IO;
using Pulumi;
using Aws = Pulumi.Aws;

return await Deployment.RunAsync(() => 
{
    var example = new Aws.Iot.Thing("example");

    var cert = new Aws.Iot.Certificate("cert", new()
    {
        Csr = File.ReadAllText("csr.pem"),
        Active = true,
    });

    var att = new Aws.Iot.ThingPrincipalAttachment("att", new()
    {
        Principal = cert.Arn,
        Thing = example.Name,
    });

});
```

</details>

<details>

<summary>go</summary>

```go
package main

import (
	"io/ioutil"

	"github.com/pulumi/pulumi-aws/sdk/v5/go/aws"
	"github.com/pulumi/pulumi-aws/sdk/v5/go/aws/iot"
	"github.com/pulumi/pulumi/sdk/v3/go/pulumi"
)

func readFileOrPanic(path string) pulumi.StringPtrInput {
	data, err := ioutil.ReadFile(path)
	if err != nil {
		panic(err.Error())
	}
	return pulumi.String(string(data))
}

func main() {
	pulumi.Run(func(ctx *pulumi.Context) error {
		example, err := iot.NewThing(ctx, "example", nil)
		if err != nil {
			return err
		}
		cert, err := iot.NewCertificate(ctx, "cert", &iot.CertificateArgs{
			Csr:    readFileOrPanic("csr.pem"),
			Active: pulumi.Bool(true),
		})
		if err != nil {
			return err
		}
		_, err = iot.NewThingPrincipalAttachment(ctx, "att", &iot.ThingPrincipalAttachmentArgs{
			Principal: cert.Arn,
			Thing:     example.Name,
		})
		if err != nil {
			return err
		}
		return nil
	})
}
```

</details>

<details>

<summary>java</summary>

```java
package generated_program;

import com.pulumi.Context;
import com.pulumi.Pulumi;
import com.pulumi.core.Output;
import com.pulumi.aws.iot.Thing;
import com.pulumi.aws.iot.Certificate;
import com.pulumi.aws.iot.CertificateArgs;
import com.pulumi.aws.iot.ThingPrincipalAttachment;
import com.pulumi.aws.iot.ThingPrincipalAttachmentArgs;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;

public class App {
    public static void main(String[] args) {
        Pulumi.run(App::stack);
    }

    public static void stack(Context ctx) {
        var example = new Thing("example");

        var cert = new Certificate("cert", CertificateArgs.builder()        
            .csr(Files.readString(Paths.get("csr.pem")))
            .active(true)
            .build());

        var att = new ThingPrincipalAttachment("att", ThingPrincipalAttachmentArgs.builder()        
            .principal(cert.arn())
            .thing(example.name())
            .build());

    }
}
```

</details>

## [*partial failure*] VPC based ES

### HCL

```terraform
variable "vpc" {}

variable "domain" {
  default = "tf-test"
}

data "aws_vpc" "selected" {
  tags = {
    Name = var.vpc
  }
}

data "aws_subnet_ids" "selected" {
  vpc_id = data.aws_vpc.selected.id

  tags = {
    Tier = "private"
  }
}

data "aws_region" "current" {}

data "aws_caller_identity" "current" {}

resource "aws_security_group" "es" {
  name        = "${var.vpc}-elasticsearch-${var.domain}"
  description = "Managed by Pulumi"
  vpc_id      = data.aws_vpc.selected.id

  ingress {
    from_port = 443
    to_port   = 443
    protocol  = "tcp"

    cidr_blocks = [
      data.aws_vpc.selected.cidr_block,
    ]
  }
}

resource "aws_iam_service_linked_role" "es" {
  aws_service_name = "es.amazonaws.com"
}

resource "aws_elasticsearch_domain" "es" {
  domain_name           = var.domain
  elasticsearch_version = "6.3"

  cluster_config {
    instance_type          = "m4.large.elasticsearch"
    zone_awareness_enabled = true
  }

  vpc_options {
    subnet_ids = [
      data.aws_subnet_ids.selected.ids[0],
      data.aws_subnet_ids.selected.ids[1],
    ]

    security_group_ids = [aws_security_group.es.id]
  }

  advanced_options = {
    "rest.action.multi.allow_explicit_index" = "true"
  }

  access_policies = <<CONFIG
{
	"Version": "2012-10-17",
	"Statement": [
		{
			"Action": "es:*",
			"Principal": "*",
			"Effect": "Allow",
			"Resource": "arn:aws:es:${data.aws_region.current.name}:${data.aws_caller_identity.current.account_id}:domain/${var.domain}/*"
		}
	]
}
CONFIG

  tags = {
    Domain = "TestDomain"
  }

  depends_on = [aws_iam_service_linked_role.es]
}

```

### Failed Languages

#### go

```text
failed to convert HCL for #/resources/aws:elasticsearch/domain:Domain to go: invalid Go source code:

package main

import (
"fmt"

"github.com/pulumi/pulumi/sdk/v3/go/pulumi"
"github.com/pulumi/pulumi-aws/sdk/v5/go/aws"
"github.com/pulumi/pulumi-aws/sdk/v5/go/aws/ec2"
"github.com/pulumi/pulumi-aws/sdk/v5/go/aws/elasticsearch"
"github.com/pulumi/pulumi-aws/sdk/v5/go/aws/iam"
"github.com/pulumi/pulumi/sdk/v3/go/pulumi/config"
)
func main() {
pulumi.Run(func(ctx *pulumi.Context) error {
cfg := config.New(ctx, "")
vpc := cfg.RequireObject("vpc")
domain := "tf-test";
if param := cfg.Get("domain"); param != ""{
domain = param
}
selectedVpc, err := ec2.LookupVpc(ctx, &ec2.LookupVpcArgs{
Tags: interface{}{
Name: vpc,
},
}, nil);
if err != nil {
return err
}
selectedSubnetIds, err := ec2.GetSubnetIds(ctx, &ec2.GetSubnetIdsArgs{
VpcId: selectedVpc.Id,
Tags: map[string]interface{}{
"Tier": "private",
},
}, nil);
if err != nil {
return err
}
currentRegion, err := aws.GetRegion(ctx, nil, nil);
if err != nil {
return err
}
currentCallerIdentity, err := aws.GetCallerIdentity(ctx, nil, nil);
if err != nil {
return err
}
esSecurityGroup, err := ec2.NewSecurityGroup(ctx, "esSecurityGroup", &ec2.SecurityGroupArgs{
Description: pulumi.String("Managed by Pulumi"),
VpcId: pulumi.String(selectedVpc.Id),
Ingress: ec2.SecurityGroupIngressArray{
&ec2.SecurityGroupIngressArgs{
FromPort: pulumi.Int(443),
ToPort: pulumi.Int(443),
Protocol: pulumi.String("tcp"),
CidrBlocks: pulumi.StringArray{
pulumi.String(selectedVpc.CidrBlock),
},
},
},
})
if err != nil {
return err
}
esServiceLinkedRole, err := iam.NewServiceLinkedRole(ctx, "esServiceLinkedRole", &iam.ServiceLinkedRoleArgs{
AwsServiceName: pulumi.String("es.amazonaws.com"),
})
if err != nil {
return err
}
_, err = elasticsearch.NewDomain(ctx, "esDomain", &elasticsearch.DomainArgs{
ElasticsearchVersion: pulumi.String("6.3"),
ClusterConfig: &elasticsearch.DomainClusterConfigArgs{
InstanceType: pulumi.String("m4.large.elasticsearch"),
ZoneAwarenessEnabled: pulumi.Bool(true),
},
VpcOptions: &elasticsearch.DomainVpcOptionsArgs{
SubnetIds: pulumi.StringArray{
pulumi.String(selectedSubnetIds.Ids[0]),
pulumi.String(selectedSubnetIds.Ids[1]),
},
SecurityGroupIds: pulumi.StringArray{
esSecurityGroup.ID(),
},
},
AdvancedOptions: pulumi.StringMap{
"rest.action.multi.allow_explicit_index": pulumi.String("true"),
},
AccessPolicies: pulumi.Any(fmt.Sprintf(`{
	"Version": "2012-10-17",
	"Statement": [
		{
			"Action": "es:*",
			"Principal": "*",
			"Effect": "Allow",
			"Resource": "arn:aws:es:%v:%v:domain/%v/*"
		}
	]
}
`, currentRegion.Name, currentCallerIdentity.AccountId, domain)),
Tags: pulumi.StringMap{
"Domain": pulumi.String("TestDomain"),
},
}, pulumi.DependsOn([]pulumi.Resource{
esServiceLinkedRole,
}))
if err != nil {
return err
}
return nil
})
}
: 22:7: expected expression (and 10 more errors)
```

### Successes

<details>

<summary>java</summary>

```java
package generated_program;

import com.pulumi.Context;
import com.pulumi.Pulumi;
import com.pulumi.core.Output;
import com.pulumi.aws.ec2.Ec2Functions;
import com.pulumi.aws.ec2.inputs.GetVpcArgs;
import com.pulumi.aws.ec2.inputs.GetSubnetIdsArgs;
import com.pulumi.aws.AwsFunctions;
import com.pulumi.aws.inputs.GetRegionArgs;
import com.pulumi.aws.ec2.SecurityGroup;
import com.pulumi.aws.ec2.SecurityGroupArgs;
import com.pulumi.aws.ec2.inputs.SecurityGroupIngressArgs;
import com.pulumi.aws.iam.ServiceLinkedRole;
import com.pulumi.aws.iam.ServiceLinkedRoleArgs;
import com.pulumi.aws.elasticsearch.Domain;
import com.pulumi.aws.elasticsearch.DomainArgs;
import com.pulumi.aws.elasticsearch.inputs.DomainClusterConfigArgs;
import com.pulumi.aws.elasticsearch.inputs.DomainVpcOptionsArgs;
import com.pulumi.resources.CustomResourceOptions;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;

public class App {
    public static void main(String[] args) {
        Pulumi.run(App::stack);
    }

    public static void stack(Context ctx) {
        final var config = ctx.config();
        final var vpc = config.get("vpc");
        final var domain = config.get("domain").orElse("tf-test");
        final var selectedVpc = Ec2Functions.getVpc(GetVpcArgs.builder()
            .tags(Map.of("Name", vpc))
            .build());

        final var selectedSubnetIds = Ec2Functions.getSubnetIds(GetSubnetIdsArgs.builder()
            .vpcId(selectedVpc.applyValue(getVpcResult -> getVpcResult.id()))
            .tags(Map.of("Tier", "private"))
            .build());

        final var currentRegion = AwsFunctions.getRegion();

        final var currentCallerIdentity = AwsFunctions.getCallerIdentity();

        var esSecurityGroup = new SecurityGroup("esSecurityGroup", SecurityGroupArgs.builder()        
            .description("Managed by Pulumi")
            .vpcId(selectedVpc.applyValue(getVpcResult -> getVpcResult.id()))
            .ingress(SecurityGroupIngressArgs.builder()
                .fromPort(443)
                .toPort(443)
                .protocol("tcp")
                .cidrBlocks(selectedVpc.applyValue(getVpcResult -> getVpcResult.cidrBlock()))
                .build())
            .build());

        var esServiceLinkedRole = new ServiceLinkedRole("esServiceLinkedRole", ServiceLinkedRoleArgs.builder()        
            .awsServiceName("es.amazonaws.com")
            .build());

        var esDomain = new Domain("esDomain", DomainArgs.builder()        
            .elasticsearchVersion("6.3")
            .clusterConfig(DomainClusterConfigArgs.builder()
                .instanceType("m4.large.elasticsearch")
                .zoneAwarenessEnabled(true)
                .build())
            .vpcOptions(DomainVpcOptionsArgs.builder()
                .subnetIds(                
                    selectedSubnetIds.applyValue(getSubnetIdsResult -> getSubnetIdsResult.ids()[0]),
                    selectedSubnetIds.applyValue(getSubnetIdsResult -> getSubnetIdsResult.ids()[1]))
                .securityGroupIds(esSecurityGroup.id())
                .build())
            .advancedOptions(Map.of("rest.action.multi.allow_explicit_index", "true"))
            .accessPolicies("""
{
	"Version": "2012-10-17",
	"Statement": [
		{
			"Action": "es:*",
			"Principal": "*",
			"Effect": "Allow",
			"Resource": "arn:aws:es:%s:%s:domain/%s/*"
		}
	]
}
", currentRegion.applyValue(getRegionResult -> getRegionResult.name()),currentCallerIdentity.applyValue(getCallerIdentityResult -> getCallerIdentityResult.accountId()),domain))
            .tags(Map.of("Domain", "TestDomain"))
            .build(), CustomResourceOptions.builder()
                .dependsOn(esServiceLinkedRole)
                .build());

    }
}
```

</details>

<details>

<summary>typescript</summary>

```typescript
import * as pulumi from "@pulumi/pulumi";
import * as aws from "@pulumi/aws";

const config = new pulumi.Config();
const vpc = config.requireObject("vpc");
const domain = config.get("domain") || "tf-test";
const selectedVpc = aws.ec2.getVpc({
    tags: {
        Name: vpc,
    },
});
const selectedSubnetIds = selectedVpc.then(selectedVpc => aws.ec2.getSubnetIds({
    vpcId: selectedVpc.id,
    tags: {
        Tier: "private",
    },
}));
const currentRegion = aws.getRegion({});
const currentCallerIdentity = aws.getCallerIdentity({});
const esSecurityGroup = new aws.ec2.SecurityGroup("esSecurityGroup", {
    description: "Managed by Pulumi",
    vpcId: selectedVpc.then(selectedVpc => selectedVpc.id),
    ingress: [{
        fromPort: 443,
        toPort: 443,
        protocol: "tcp",
        cidrBlocks: [selectedVpc.then(selectedVpc => selectedVpc.cidrBlock)],
    }],
});
const esServiceLinkedRole = new aws.iam.ServiceLinkedRole("esServiceLinkedRole", {awsServiceName: "es.amazonaws.com"});
const esDomain = new aws.elasticsearch.Domain("esDomain", {
    elasticsearchVersion: "6.3",
    clusterConfig: {
        instanceType: "m4.large.elasticsearch",
        zoneAwarenessEnabled: true,
    },
    vpcOptions: {
        subnetIds: [
            selectedSubnetIds.then(selectedSubnetIds => selectedSubnetIds.ids?[0]),
            selectedSubnetIds.then(selectedSubnetIds => selectedSubnetIds.ids?[1]),
        ],
        securityGroupIds: [esSecurityGroup.id],
    },
    advancedOptions: {
        "rest.action.multi.allow_explicit_index": "true",
    },
    accessPolicies: Promise.all([currentRegion, currentCallerIdentity]).then(([currentRegion, currentCallerIdentity]) => `{
	"Version": "2012-10-17",
	"Statement": [
		{
			"Action": "es:*",
			"Principal": "*",
			"Effect": "Allow",
			"Resource": "arn:aws:es:${currentRegion.name}:${currentCallerIdentity.accountId}:domain/${domain}/*"
		}
	]
}
`),
    tags: {
        Domain: "TestDomain",
    },
}, {
    dependsOn: [esServiceLinkedRole],
});
```

</details>

<details>

<summary>python</summary>

```python
import pulumi
import pulumi_aws as aws

config = pulumi.Config()
vpc = config.require_object("vpc")
domain = config.get("domain")
if domain is None:
    domain = "tf-test"
selected_vpc = aws.ec2.get_vpc(tags={
    "Name": vpc,
})
selected_subnet_ids = aws.ec2.get_subnet_ids(vpc_id=selected_vpc.id,
    tags={
        "Tier": "private",
    })
current_region = aws.get_region()
current_caller_identity = aws.get_caller_identity()
es_security_group = aws.ec2.SecurityGroup("esSecurityGroup",
    description="Managed by Pulumi",
    vpc_id=selected_vpc.id,
    ingress=[aws.ec2.SecurityGroupIngressArgs(
        from_port=443,
        to_port=443,
        protocol="tcp",
        cidr_blocks=[selected_vpc.cidr_block],
    )])
es_service_linked_role = aws.iam.ServiceLinkedRole("esServiceLinkedRole", aws_service_name="es.amazonaws.com")
es_domain = aws.elasticsearch.Domain("esDomain",
    elasticsearch_version="6.3",
    cluster_config=aws.elasticsearch.DomainClusterConfigArgs(
        instance_type="m4.large.elasticsearch",
        zone_awareness_enabled=True,
    ),
    vpc_options=aws.elasticsearch.DomainVpcOptionsArgs(
        subnet_ids=[
            selected_subnet_ids.ids[0],
            selected_subnet_ids.ids[1],
        ],
        security_group_ids=[es_security_group.id],
    ),
    advanced_options={
        "rest.action.multi.allow_explicit_index": "true",
    },
    access_policies=f"""{{
	"Version": "2012-10-17",
	"Statement": [
		{{
			"Action": "es:*",
			"Principal": "*",
			"Effect": "Allow",
			"Resource": "arn:aws:es:{current_region.name}:{current_caller_identity.account_id}:domain/{domain}/*"
		}}
	]
}}
""",
    tags={
        "Domain": "TestDomain",
    },
    opts=pulumi.ResourceOptions(depends_on=[es_service_linked_role]))
```

</details>

<details>

<summary>csharp</summary>

```csharp
using System.Collections.Generic;
using Pulumi;
using Aws = Pulumi.Aws;

return await Deployment.RunAsync(() => 
{
    var config = new Config();
    var vpc = config.RequireObject<dynamic>("vpc");
    var domain = config.Get("domain") ?? "tf-test";
    var selectedVpc = Aws.Ec2.GetVpc.Invoke(new()
    {
        Tags = 
        {
            { "Name", vpc },
        },
    });

    var selectedSubnetIds = Aws.Ec2.GetSubnetIds.Invoke(new()
    {
        VpcId = selectedVpc.Apply(getVpcResult => getVpcResult.Id),
        Tags = 
        {
            { "Tier", "private" },
        },
    });

    var currentRegion = Aws.GetRegion.Invoke();

    var currentCallerIdentity = Aws.GetCallerIdentity.Invoke();

    var esSecurityGroup = new Aws.Ec2.SecurityGroup("esSecurityGroup", new()
    {
        Description = "Managed by Pulumi",
        VpcId = selectedVpc.Apply(getVpcResult => getVpcResult.Id),
        Ingress = new[]
        {
            new Aws.Ec2.Inputs.SecurityGroupIngressArgs
            {
                FromPort = 443,
                ToPort = 443,
                Protocol = "tcp",
                CidrBlocks = new[]
                {
                    selectedVpc.Apply(getVpcResult => getVpcResult.CidrBlock),
                },
            },
        },
    });

    var esServiceLinkedRole = new Aws.Iam.ServiceLinkedRole("esServiceLinkedRole", new()
    {
        AwsServiceName = "es.amazonaws.com",
    });

    var esDomain = new Aws.ElasticSearch.Domain("esDomain", new()
    {
        ElasticsearchVersion = "6.3",
        ClusterConfig = new Aws.ElasticSearch.Inputs.DomainClusterConfigArgs
        {
            InstanceType = "m4.large.elasticsearch",
            ZoneAwarenessEnabled = true,
        },
        VpcOptions = new Aws.ElasticSearch.Inputs.DomainVpcOptionsArgs
        {
            SubnetIds = new[]
            {
                selectedSubnetIds.Apply(getSubnetIdsResult => getSubnetIdsResult.Ids[0]),
                selectedSubnetIds.Apply(getSubnetIdsResult => getSubnetIdsResult.Ids[1]),
            },
            SecurityGroupIds = new[]
            {
                esSecurityGroup.Id,
            },
        },
        AdvancedOptions = 
        {
            { "rest.action.multi.allow_explicit_index", "true" },
        },
        AccessPolicies = Output.Tuple(currentRegion.Apply(getRegionResult => getRegionResult), currentCallerIdentity.Apply(getCallerIdentityResult => getCallerIdentityResult)).Apply(values =>
        {
            var currentRegion = values.Item1;
            var currentCallerIdentity = values.Item2;
            return @$"{{
	""Version"": ""2012-10-17"",
	""Statement"": [
		{{
			""Action"": ""es:*"",
			""Principal"": ""*"",
			""Effect"": ""Allow"",
			""Resource"": ""arn:aws:es:{currentRegion.Apply(getRegionResult => getRegionResult.Name)}:{currentCallerIdentity.Apply(getCallerIdentityResult => getCallerIdentityResult.AccountId)}:domain/{domain}/*""
		}}
	]
}}
";
        }),
        Tags = 
        {
            { "Domain", "TestDomain" },
        },
    }, new CustomResourceOptions
    {
        DependsOn = new[]
        {
            esServiceLinkedRole,
        },
    });

});
```

</details>

<details>

<summary>yaml</summary>

```yaml
configuration:
  vpc:
    type: dynamic
  domain:
    type: string
    default: tf-test
resources:
  esSecurityGroup:
    type: aws:ec2:SecurityGroup
    properties:
      description: Managed by Pulumi
      vpcId: ${selectedVpc.id}
      ingress:
        - fromPort: 443
          toPort: 443
          protocol: tcp
          cidrBlocks:
            - ${selectedVpc.cidrBlock}
  esServiceLinkedRole:
    type: aws:iam:ServiceLinkedRole
    properties:
      awsServiceName: es.amazonaws.com
  esDomain:
    type: aws:elasticsearch:Domain
    properties:
      elasticsearchVersion: 6.3
      clusterConfig:
        instanceType: m4.large.elasticsearch
        zoneAwarenessEnabled: true
      vpcOptions:
        subnetIds:
          - ${selectedSubnetIds.ids[0]}
          - ${selectedSubnetIds.ids[1]}
        securityGroupIds:
          - ${esSecurityGroup.id}
      advancedOptions:
        rest.action.multi.allow_explicit_index: true
      accessPolicies: |
        {
        	"Version": "2012-10-17",
        	"Statement": [
        		{
        			"Action": "es:*",
        			"Principal": "*",
        			"Effect": "Allow",
        			"Resource": "arn:aws:es:${currentRegion.name}:${currentCallerIdentity.accountId}:domain/${domain}/*"
        		}
        	]
        }
      tags:
        Domain: TestDomain
    options:
      dependson:
        - ${esServiceLinkedRole}
variables:
  selectedVpc:
    Fn::Invoke:
      Function: aws:ec2:getVpc
      Arguments:
        tags:
          Name: ${vpc}
  selectedSubnetIds:
    Fn::Invoke:
      Function: aws:ec2:getSubnetIds
      Arguments:
        vpcId: ${selectedVpc.id}
        tags:
          Tier: private
  currentRegion:
    Fn::Invoke:
      Function: aws:getRegion
      Arguments: {}
  currentCallerIdentity:
    Fn::Invoke:
      Function: aws:getCallerIdentity
      Arguments: {}
```

</details>

## [*partial failure*] #/resources/aws:iam/serverCertificate:ServerCertificate

### HCL

```terraform
resource "aws_iam_server_certificate" "test_cert" {
  name             = "some_test_cert"
  certificate_body = file("self-ca-cert.pem")
  private_key      = file("test-key.pem")
}

```

### Failed Languages

#### yaml

```text
.pp:1,21-49: Failed to generate YAML program: Unknown Function; YAML does not support Fn::readFile., and 1 other diagnostic(s)
```

### Successes

<details>

<summary>typescript</summary>

```typescript
import * as pulumi from "@pulumi/pulumi";
import * as aws from "@pulumi/aws";
import * as fs from "fs";

const testCert = new aws.iam.ServerCertificate("testCert", {
    certificateBody: fs.readFileSync("self-ca-cert.pem"),
    privateKey: fs.readFileSync("test-key.pem"),
});
```

</details>

<details>

<summary>python</summary>

```python
import pulumi
import pulumi_aws as aws

test_cert = aws.iam.ServerCertificate("testCert",
    certificate_body=(lambda path: open(path).read())("self-ca-cert.pem"),
    private_key=(lambda path: open(path).read())("test-key.pem"))
```

</details>

<details>

<summary>csharp</summary>

```csharp
using System.Collections.Generic;
using System.IO;
using Pulumi;
using Aws = Pulumi.Aws;

return await Deployment.RunAsync(() => 
{
    var testCert = new Aws.Iam.ServerCertificate("testCert", new()
    {
        CertificateBody = File.ReadAllText("self-ca-cert.pem"),
        PrivateKey = File.ReadAllText("test-key.pem"),
    });

});
```

</details>

<details>

<summary>go</summary>

```go
package main

import (
	"io/ioutil"

	"github.com/pulumi/pulumi-aws/sdk/v5/go/aws/iam"
	"github.com/pulumi/pulumi/sdk/v3/go/pulumi"
)

func readFileOrPanic(path string) pulumi.StringPtrInput {
	data, err := ioutil.ReadFile(path)
	if err != nil {
		panic(err.Error())
	}
	return pulumi.String(string(data))
}

func main() {
	pulumi.Run(func(ctx *pulumi.Context) error {
		_, err := iam.NewServerCertificate(ctx, "testCert", &iam.ServerCertificateArgs{
			CertificateBody: readFileOrPanic("self-ca-cert.pem"),
			PrivateKey:      readFileOrPanic("test-key.pem"),
		})
		if err != nil {
			return err
		}
		return nil
	})
}
```

</details>

<details>

<summary>java</summary>

```java
package generated_program;

import com.pulumi.Context;
import com.pulumi.Pulumi;
import com.pulumi.core.Output;
import com.pulumi.aws.iam.ServerCertificate;
import com.pulumi.aws.iam.ServerCertificateArgs;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;

public class App {
    public static void main(String[] args) {
        Pulumi.run(App::stack);
    }

    public static void stack(Context ctx) {
        var testCert = new ServerCertificate("testCert", ServerCertificateArgs.builder()        
            .certificateBody(Files.readString(Paths.get("self-ca-cert.pem")))
            .privateKey(Files.readString(Paths.get("test-key.pem")))
            .build());

    }
}
```

</details>

## [*partial failure*] #/resources/aws:iam/serverCertificate:ServerCertificate

### HCL

```terraform
resource "aws_iam_server_certificate" "test_cert" {
  name_prefix      = "example-cert"
  certificate_body = file("self-ca-cert.pem")
  private_key      = file("test-key.pem")

  lifecycle {
    create_before_destroy = true
  }
}

resource "aws_elb" "ourapp" {
  name                      = "asg-deployment-example"
  availability_zones        = ["us-west-2a"]
  cross_zone_load_balancing = true

  listener {
    instance_port      = 8000
    instance_protocol  = "http"
    lb_port            = 443
    lb_protocol        = "https"
    ssl_certificate_id = aws_iam_server_certificate.test_cert.arn
  }
}

```

### Failed Languages

#### yaml

```text
.pp:2,21-49: Failed to generate YAML program: Unknown Function; YAML does not support Fn::readFile., and 1 other diagnostic(s)
```

### Successes

<details>

<summary>csharp</summary>

```csharp
using System.Collections.Generic;
using System.IO;
using Pulumi;
using Aws = Pulumi.Aws;

return await Deployment.RunAsync(() => 
{
    var testCert = new Aws.Iam.ServerCertificate("testCert", new()
    {
        NamePrefix = "example-cert",
        CertificateBody = File.ReadAllText("self-ca-cert.pem"),
        PrivateKey = File.ReadAllText("test-key.pem"),
    });

    var ourapp = new Aws.Elb.LoadBalancer("ourapp", new()
    {
        AvailabilityZones = new[]
        {
            "us-west-2a",
        },
        CrossZoneLoadBalancing = true,
        Listeners = new[]
        {
            new Aws.Elb.Inputs.LoadBalancerListenerArgs
            {
                InstancePort = 8000,
                InstanceProtocol = "http",
                LbPort = 443,
                LbProtocol = "https",
                SslCertificateId = testCert.Arn,
            },
        },
    });

});
```

</details>

<details>

<summary>go</summary>

```go
package main

import (
	"io/ioutil"

	"github.com/pulumi/pulumi-aws/sdk/v5/go/aws/elb"
	"github.com/pulumi/pulumi-aws/sdk/v5/go/aws/iam"
	"github.com/pulumi/pulumi/sdk/v3/go/pulumi"
)

func readFileOrPanic(path string) pulumi.StringPtrInput {
	data, err := ioutil.ReadFile(path)
	if err != nil {
		panic(err.Error())
	}
	return pulumi.String(string(data))
}

func main() {
	pulumi.Run(func(ctx *pulumi.Context) error {
		testCert, err := iam.NewServerCertificate(ctx, "testCert", &iam.ServerCertificateArgs{
			NamePrefix:      pulumi.String("example-cert"),
			CertificateBody: readFileOrPanic("self-ca-cert.pem"),
			PrivateKey:      readFileOrPanic("test-key.pem"),
		})
		if err != nil {
			return err
		}
		_, err = elb.NewLoadBalancer(ctx, "ourapp", &elb.LoadBalancerArgs{
			AvailabilityZones: pulumi.StringArray{
				pulumi.String("us-west-2a"),
			},
			CrossZoneLoadBalancing: pulumi.Bool(true),
			Listeners: elb.LoadBalancerListenerArray{
				&elb.LoadBalancerListenerArgs{
					InstancePort:     pulumi.Int(8000),
					InstanceProtocol: pulumi.String("http"),
					LbPort:           pulumi.Int(443),
					LbProtocol:       pulumi.String("https"),
					SslCertificateId: testCert.Arn,
				},
			},
		})
		if err != nil {
			return err
		}
		return nil
	})
}
```

</details>

<details>

<summary>java</summary>

```java
package generated_program;

import com.pulumi.Context;
import com.pulumi.Pulumi;
import com.pulumi.core.Output;
import com.pulumi.aws.iam.ServerCertificate;
import com.pulumi.aws.iam.ServerCertificateArgs;
import com.pulumi.aws.elb.LoadBalancer;
import com.pulumi.aws.elb.LoadBalancerArgs;
import com.pulumi.aws.elb.inputs.LoadBalancerListenerArgs;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;

public class App {
    public static void main(String[] args) {
        Pulumi.run(App::stack);
    }

    public static void stack(Context ctx) {
        var testCert = new ServerCertificate("testCert", ServerCertificateArgs.builder()        
            .namePrefix("example-cert")
            .certificateBody(Files.readString(Paths.get("self-ca-cert.pem")))
            .privateKey(Files.readString(Paths.get("test-key.pem")))
            .build());

        var ourapp = new LoadBalancer("ourapp", LoadBalancerArgs.builder()        
            .availabilityZones("us-west-2a")
            .crossZoneLoadBalancing(true)
            .listeners(LoadBalancerListenerArgs.builder()
                .instancePort(8000)
                .instanceProtocol("http")
                .lbPort(443)
                .lbProtocol("https")
                .sslCertificateId(testCert.arn())
                .build())
            .build());

    }
}
```

</details>

<details>

<summary>typescript</summary>

```typescript
import * as pulumi from "@pulumi/pulumi";
import * as aws from "@pulumi/aws";
import * as fs from "fs";

const testCert = new aws.iam.ServerCertificate("testCert", {
    namePrefix: "example-cert",
    certificateBody: fs.readFileSync("self-ca-cert.pem"),
    privateKey: fs.readFileSync("test-key.pem"),
});
const ourapp = new aws.elb.LoadBalancer("ourapp", {
    availabilityZones: ["us-west-2a"],
    crossZoneLoadBalancing: true,
    listeners: [{
        instancePort: 8000,
        instanceProtocol: "http",
        lbPort: 443,
        lbProtocol: "https",
        sslCertificateId: testCert.arn,
    }],
});
```

</details>

<details>

<summary>python</summary>

```python
import pulumi
import pulumi_aws as aws

test_cert = aws.iam.ServerCertificate("testCert",
    name_prefix="example-cert",
    certificate_body=(lambda path: open(path).read())("self-ca-cert.pem"),
    private_key=(lambda path: open(path).read())("test-key.pem"))
ourapp = aws.elb.LoadBalancer("ourapp",
    availability_zones=["us-west-2a"],
    cross_zone_load_balancing=True,
    listeners=[aws.elb.LoadBalancerListenerArgs(
        instance_port=8000,
        instance_protocol="http",
        lb_port=443,
        lb_protocol="https",
        ssl_certificate_id=test_cert.arn,
    )])
```

</details>

## [*partial failure*] #/resources/aws:worklink/fleet:Fleet

### HCL

```terraform
resource "aws_worklink_fleet" "example" {
  name = "example"

  network {
    vpc_id             = aws_vpc.test.id
    subnet_ids         = [aws_subnet.test.*.id]
    security_group_ids = [aws_security_group.test.id]
  }
}

```

### Failed Languages

#### yaml

```text
.pp:3,26-46: Failed to generate YAML program: Splat; A 'Splat' expression is equivalent in expressive power to a 'for loop', and is not representable in YAML.
If the values of the function are known, you can manually unroll the loop, otherwise it is necessary to switch to a more expressive language.
```

#### go

```text
failed to convert HCL for #/resources/aws:worklink/fleet:Fleet to go: invalid Go source code:

package main

import (

"github.com/pulumi/pulumi/sdk/v3/go/pulumi"
"github.com/pulumi/pulumi-aws/sdk/v5/go/aws/worklink"
)
func main() {
pulumi.Run(func(ctx *pulumi.Context) error {
_, err := worklink.NewFleet(ctx, "example", &worklink.FleetArgs{
Network: &worklink.FleetNetworkArgs{
VpcId: pulumi.Any(aws_vpc.Test.Id),
SubnetIds: pulumi.StringArray{
%!v(PANIC=Format method: fatal: A failure has occurred: unlowered splat expression @ #-resources-aws:worklink-fleet:Fleet.tf.pp:3,26-46),
},
SecurityGroupIds: pulumi.StringArray{
pulumi.Any(aws_security_group.Test.Id),
},
},
})
if err != nil {
return err
}
return nil
})
}
: 14:1: expected operand, found '%' (and 8 more errors)
```

### Successes

<details>

<summary>typescript</summary>

```typescript
import * as pulumi from "@pulumi/pulumi";
import * as aws from "@pulumi/aws";

const example = new aws.worklink.Fleet("example", {network: {
    vpcId: aws_vpc.test.id,
    subnetIds: [aws_subnet.test.map(__item => __item.id)],
    securityGroupIds: [aws_security_group.test.id],
}});
```

</details>

<details>

<summary>python</summary>

```python
import pulumi
import pulumi_aws as aws

example = aws.worklink.Fleet("example", network=aws.worklink.FleetNetworkArgs(
    vpc_id=aws_vpc["test"]["id"],
    subnet_ids=[[__item["id"] for __item in aws_subnet["test"]]],
    security_group_ids=[aws_security_group["test"]["id"]],
))
```

</details>

<details>

<summary>csharp</summary>

```csharp
using System.Collections.Generic;
using System.Linq;
using Pulumi;
using Aws = Pulumi.Aws;

return await Deployment.RunAsync(() => 
{
    var example = new Aws.WorkLink.Fleet("example", new()
    {
        Network = new Aws.WorkLink.Inputs.FleetNetworkArgs
        {
            VpcId = aws_vpc.Test.Id,
            SubnetIds = new[]
            {
                aws_subnet.Test.Select(__item => __item.Id).ToList(),
            },
            SecurityGroupIds = new[]
            {
                aws_security_group.Test.Id,
            },
        },
    });

});
```

</details>

<details>

<summary>java</summary>

```java
package generated_program;

import com.pulumi.Context;
import com.pulumi.Pulumi;
import com.pulumi.core.Output;
import com.pulumi.aws.worklink.Fleet;
import com.pulumi.aws.worklink.FleetArgs;
import com.pulumi.aws.worklink.inputs.FleetNetworkArgs;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;

public class App {
    public static void main(String[] args) {
        Pulumi.run(App::stack);
    }

    public static void stack(Context ctx) {
        var example = new Fleet("example", FleetArgs.builder()        
            .network(FleetNetworkArgs.builder()
                .vpcId(aws_vpc.test().id())
                .subnetIds(aws_subnet.test().stream().map(element -> element.id()).collect(toList()))
                .securityGroupIds(aws_security_group.test().id())
                .build())
            .build());

    }
}
```

</details>

## [*partial failure*] #/resources/aws:worklink/fleet:Fleet

### HCL

```terraform
resource "aws_worklink_fleet" "test" {
  name = "tf-worklink-fleet"

  identity_provider {
    type          = "SAML"
    saml_metadata = file("saml-metadata.xml")
  }
}

```

### Failed Languages

#### yaml

```text
.pp:3,20-49: Failed to generate YAML program: Unknown Function; YAML does not support Fn::readFile.
```

### Successes

<details>

<summary>java</summary>

```java
package generated_program;

import com.pulumi.Context;
import com.pulumi.Pulumi;
import com.pulumi.core.Output;
import com.pulumi.aws.worklink.Fleet;
import com.pulumi.aws.worklink.FleetArgs;
import com.pulumi.aws.worklink.inputs.FleetIdentityProviderArgs;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;

public class App {
    public static void main(String[] args) {
        Pulumi.run(App::stack);
    }

    public static void stack(Context ctx) {
        var test = new Fleet("test", FleetArgs.builder()        
            .identityProvider(FleetIdentityProviderArgs.builder()
                .type("SAML")
                .samlMetadata(Files.readString(Paths.get("saml-metadata.xml")))
                .build())
            .build());

    }
}
```

</details>

<details>

<summary>typescript</summary>

```typescript
import * as pulumi from "@pulumi/pulumi";
import * as aws from "@pulumi/aws";
import * as fs from "fs";

const test = new aws.worklink.Fleet("test", {identityProvider: {
    type: "SAML",
    samlMetadata: fs.readFileSync("saml-metadata.xml"),
}});
```

</details>

<details>

<summary>python</summary>

```python
import pulumi
import pulumi_aws as aws

test = aws.worklink.Fleet("test", identity_provider=aws.worklink.FleetIdentityProviderArgs(
    type="SAML",
    saml_metadata=(lambda path: open(path).read())("saml-metadata.xml"),
))
```

</details>

<details>

<summary>csharp</summary>

```csharp
using System.Collections.Generic;
using System.IO;
using Pulumi;
using Aws = Pulumi.Aws;

return await Deployment.RunAsync(() => 
{
    var test = new Aws.WorkLink.Fleet("test", new()
    {
        IdentityProvider = new Aws.WorkLink.Inputs.FleetIdentityProviderArgs
        {
            Type = "SAML",
            SamlMetadata = File.ReadAllText("saml-metadata.xml"),
        },
    });

});
```

</details>

<details>

<summary>go</summary>

```go
package main

import (
	"io/ioutil"

	"github.com/pulumi/pulumi-aws/sdk/v5/go/aws/worklink"
	"github.com/pulumi/pulumi/sdk/v3/go/pulumi"
)

func readFileOrPanic(path string) pulumi.StringPtrInput {
	data, err := ioutil.ReadFile(path)
	if err != nil {
		panic(err.Error())
	}
	return pulumi.String(string(data))
}

func main() {
	pulumi.Run(func(ctx *pulumi.Context) error {
		_, err := worklink.NewFleet(ctx, "test", &worklink.FleetArgs{
			IdentityProvider: &worklink.FleetIdentityProviderArgs{
				Type:         pulumi.String("SAML"),
				SamlMetadata: readFileOrPanic("saml-metadata.xml"),
			},
		})
		if err != nil {
			return err
		}
		return nil
	})
}
```

</details>

## [**complete failure**] #/resources/aws:datasync/task:Task

### HCL

```terraform
resource "aws_datasync_task" "example" {
  destination_location_arn = aws_datasync_location_s3.destination.arn
  name                     = "example"
  source_location_arn      = aws_datasync_location_nfs.source.arn

  options {
    bytes_per_second = -1
  }
}

```

### Failed Languages

#### java

```text
.pp:4,5-19: unsupported attribute 'bytesPerSecond'; unsupported attribute 'bytesPerSecond'
```

#### typescript

```text
.pp:4,5-19: unsupported attribute 'bytesPerSecond'; unsupported attribute 'bytesPerSecond'
```

#### python

```text
.pp:4,5-19: unsupported attribute 'bytesPerSecond'; unsupported attribute 'bytesPerSecond'
```

#### csharp

```text
.pp:4,5-19: unsupported attribute 'bytesPerSecond'; unsupported attribute 'bytesPerSecond'
```

#### go

```text
.pp:4,5-19: unsupported attribute 'bytesPerSecond'; unsupported attribute 'bytesPerSecond'
```

#### yaml

```text
.pp:4,5-19: unsupported attribute 'bytesPerSecond'; unsupported attribute 'bytesPerSecond'
```

## [*partial failure*] #/resources/aws:networkfirewall/firewallPolicy:FirewallPolicy

### HCL

```terraform
resource "aws_networkfirewall_firewall_policy" "test" {
  name = "example"

  firewall_policy {
    stateless_default_actions          = ["aws:pass", "ExampleCustomAction"]
    stateless_fragment_default_actions = ["aws:drop"]

    stateless_custom_action {
      action_definition {
        publish_metric_action {
          dimension {
            value = "1"
          }
        }
      }
      action_name = "ExampleCustomAction"
    }
  }
}

```

### Failed Languages

#### python

```text
:0,0-0: unknown property 'dimension' among [dimensions]; , and 4 other diagnostic(s)
```

#### csharp

```text
:0,0-0: unknown property 'dimension' among [dimensions]; , and 4 other diagnostic(s)
```

#### go

```text
:0,0-0: unknown property 'dimension' among [dimensions]; , and 4 other diagnostic(s)
```

### Successes

<details>

<summary>yaml</summary>

```yaml
resources:
  test:
    type: aws:networkfirewall:FirewallPolicy
    properties:
      firewallPolicy:
        statelessCustomActions:
          - actionDefinition:
              publishMetricAction:
                dimension:
                  - value: 1
            actionName: ExampleCustomAction
        statelessDefaultActions:
          - aws:pass
          - ExampleCustomAction
        statelessFragmentDefaultActions:
          - aws:drop
```

</details>

<details>

<summary>java</summary>

```java
package generated_program;

import com.pulumi.Context;
import com.pulumi.Pulumi;
import com.pulumi.core.Output;
import com.pulumi.aws.networkfirewall.FirewallPolicy;
import com.pulumi.aws.networkfirewall.FirewallPolicyArgs;
import com.pulumi.aws.networkfirewall.inputs.FirewallPolicyFirewallPolicyArgs;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;

public class App {
    public static void main(String[] args) {
        Pulumi.run(App::stack);
    }

    public static void stack(Context ctx) {
        var test = new FirewallPolicy("test", FirewallPolicyArgs.builder()        
            .firewallPolicy(FirewallPolicyFirewallPolicyArgs.builder()
                .statelessCustomActions(FirewallPolicyFirewallPolicyStatelessCustomActionArgs.builder()
                    .actionDefinition(FirewallPolicyFirewallPolicyStatelessCustomActionActionDefinitionArgs.builder()
                        .publishMetricAction(FirewallPolicyFirewallPolicyStatelessCustomActionActionDefinitionPublishMetricActionArgs.builder()
                            .dimension(%!v(PANIC=Format method: runtime error: invalid memory address or nil pointer dereference))
                            .build())
                        .build())
                    .actionName("ExampleCustomAction")
                    .build())
                .statelessDefaultActions(                
                    "aws:pass",
                    "ExampleCustomAction")
                .statelessFragmentDefaultActions("aws:drop")
                .build())
            .build());

    }
}
```

</details>

<details>

<summary>typescript</summary>

```typescript
import * as pulumi from "@pulumi/pulumi";
import * as aws from "@pulumi/aws";

const test = new aws.networkfirewall.FirewallPolicy("test", {
    firewallPolicy: {
        statelessCustomActions: [{
            actionDefinition: {
                publishMetricAction: {
                    dimensions: [{
                        value: "1",
                    }],
                },
            },
            actionName: "ExampleCustomAction",
        }],
        statelessDefaultActions: [
            "aws:pass",
            "ExampleCustomAction",
        ],
        statelessFragmentDefaultActions: ["aws:drop"],
    },
});
```

</details>

## [*partial failure*] #/resources/aws:pinpoint/apnsSandboxChannel:ApnsSandboxChannel

### HCL

```terraform
resource "aws_pinpoint_apns_sandbox_channel" "apns_sandbox" {
  application_id = aws_pinpoint_app.app.application_id

  certificate = file("./certificate.pem")
  private_key = file("./private_key.key")
}

resource "aws_pinpoint_app" "app" {}

```

### Failed Languages

#### yaml

```text
.pp:2,17-46: Failed to generate YAML program: Unknown Function; YAML does not support Fn::readFile., and 1 other diagnostic(s)
```

### Successes

<details>

<summary>java</summary>

```java
package generated_program;

import com.pulumi.Context;
import com.pulumi.Pulumi;
import com.pulumi.core.Output;
import com.pulumi.aws.pinpoint.App;
import com.pulumi.aws.pinpoint.ApnsSandboxChannel;
import com.pulumi.aws.pinpoint.ApnsSandboxChannelArgs;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;

public class App {
    public static void main(String[] args) {
        Pulumi.run(App::stack);
    }

    public static void stack(Context ctx) {
        var app = new App("app");

        var apnsSandbox = new ApnsSandboxChannel("apnsSandbox", ApnsSandboxChannelArgs.builder()        
            .applicationId(app.applicationId())
            .certificate(Files.readString(Paths.get("./certificate.pem")))
            .privateKey(Files.readString(Paths.get("./private_key.key")))
            .build());

    }
}
```

</details>

<details>

<summary>typescript</summary>

```typescript
import * as pulumi from "@pulumi/pulumi";
import * as aws from "@pulumi/aws";
import * as fs from "fs";

const app = new aws.pinpoint.App("app", {});
const apnsSandbox = new aws.pinpoint.ApnsSandboxChannel("apnsSandbox", {
    applicationId: app.applicationId,
    certificate: fs.readFileSync("./certificate.pem"),
    privateKey: fs.readFileSync("./private_key.key"),
});
```

</details>

<details>

<summary>python</summary>

```python
import pulumi
import pulumi_aws as aws

app = aws.pinpoint.App("app")
apns_sandbox = aws.pinpoint.ApnsSandboxChannel("apnsSandbox",
    application_id=app.application_id,
    certificate=(lambda path: open(path).read())("./certificate.pem"),
    private_key=(lambda path: open(path).read())("./private_key.key"))
```

</details>

<details>

<summary>csharp</summary>

```csharp
using System.Collections.Generic;
using System.IO;
using Pulumi;
using Aws = Pulumi.Aws;

return await Deployment.RunAsync(() => 
{
    var app = new Aws.Pinpoint.App("app");

    var apnsSandbox = new Aws.Pinpoint.ApnsSandboxChannel("apnsSandbox", new()
    {
        ApplicationId = app.ApplicationId,
        Certificate = File.ReadAllText("./certificate.pem"),
        PrivateKey = File.ReadAllText("./private_key.key"),
    });

});
```

</details>

<details>

<summary>go</summary>

```go
package main

import (
	"io/ioutil"

	"github.com/pulumi/pulumi-aws/sdk/v5/go/aws/pinpoint"
	"github.com/pulumi/pulumi/sdk/v3/go/pulumi"
)

func readFileOrPanic(path string) pulumi.StringPtrInput {
	data, err := ioutil.ReadFile(path)
	if err != nil {
		panic(err.Error())
	}
	return pulumi.String(string(data))
}

func main() {
	pulumi.Run(func(ctx *pulumi.Context) error {
		app, err := pinpoint.NewApp(ctx, "app", nil)
		if err != nil {
			return err
		}
		_, err = pinpoint.NewApnsSandboxChannel(ctx, "apnsSandbox", &pinpoint.ApnsSandboxChannelArgs{
			ApplicationId: app.ApplicationId,
			Certificate:   readFileOrPanic("./certificate.pem"),
			PrivateKey:    readFileOrPanic("./private_key.key"),
		})
		if err != nil {
			return err
		}
		return nil
	})
}
```

</details>

## [*partial failure*] #/resources/aws:qldb/stream:Stream

### HCL

```terraform
resource "aws_qldb_stream" "example" {
  ledger_name          = "existing-ledger-name"
  stream_name          = "sample-ledger-stream"
  role_arn             = "sample-role-arn"
  inclusive_start_time = "2021-01-01T00:00:00Z"

  kinesis_configuration {
    aggegation_enabled = false
    stream_arn         = "arn:aws:kinesis:us-east-1:xxxxxxxxxxxx:stream/example-kinesis-stream"
  }

  tags = {
    "example" = "tag"
  }
}

```

### Failed Languages

#### python

```text
:0,0-0: unknown property 'aggegationEnabled' among [aggregationEnabled streamArn]; , and 2 other diagnostic(s)
```

#### csharp

```text
:0,0-0: unknown property 'aggegationEnabled' among [aggregationEnabled streamArn]; , and 2 other diagnostic(s)
```

#### go

```text
:0,0-0: unknown property 'aggegationEnabled' among [aggregationEnabled streamArn]; , and 2 other diagnostic(s)
```

### Successes

<details>

<summary>typescript</summary>

```typescript
import * as pulumi from "@pulumi/pulumi";
import * as aws from "@pulumi/aws";

const example = new aws.qldb.Stream("example", {
    inclusiveStartTime: "2021-01-01T00:00:00Z",
    kinesisConfiguration: {
        aggegationEnabled: false,
        streamArn: "arn:aws:kinesis:us-east-1:xxxxxxxxxxxx:stream/example-kinesis-stream",
    },
    ledgerName: "existing-ledger-name",
    roleArn: "sample-role-arn",
    streamName: "sample-ledger-stream",
    tags: {
        example: "tag",
    },
});
```

</details>

<details>

<summary>yaml</summary>

```yaml
resources:
  example:
    type: aws:qldb:Stream
    properties:
      inclusiveStartTime: 2021-01-01T00:00:00Z
      kinesisConfiguration:
        aggegationEnabled: false
        streamArn: arn:aws:kinesis:us-east-1:xxxxxxxxxxxx:stream/example-kinesis-stream
      ledgerName: existing-ledger-name
      roleArn: sample-role-arn
      streamName: sample-ledger-stream
      tags:
        example: tag
```

</details>

<details>

<summary>java</summary>

```java
package generated_program;

import com.pulumi.Context;
import com.pulumi.Pulumi;
import com.pulumi.core.Output;
import com.pulumi.aws.qldb.Stream;
import com.pulumi.aws.qldb.StreamArgs;
import com.pulumi.aws.qldb.inputs.StreamKinesisConfigurationArgs;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;

public class App {
    public static void main(String[] args) {
        Pulumi.run(App::stack);
    }

    public static void stack(Context ctx) {
        var example = new Stream("example", StreamArgs.builder()        
            .inclusiveStartTime("2021-01-01T00:00:00Z")
            .kinesisConfiguration(StreamKinesisConfigurationArgs.builder()
                .aggegationEnabled(false)
                .streamArn("arn:aws:kinesis:us-east-1:xxxxxxxxxxxx:stream/example-kinesis-stream")
                .build())
            .ledgerName("existing-ledger-name")
            .roleArn("sample-role-arn")
            .streamName("sample-ledger-stream")
            .tags(Map.of("example", "tag"))
            .build());

    }
}
```

</details>

## [**complete failure**] #/resources/aws:lambda/invocation:Invocation

### HCL

```terraform
resource "aws_lambda_invocation" "example" {
  function_name = aws_lambda_function.lambda_function_test.function_name

  input = jsonencode({
    key1 = "value1"
    key2 = "value2"
  })
}

output "result_entry" {
  value = jsondecode(aws_lambda_invocation.example.result)["key1"]
}

```

### Failed Languages

#### yaml

```text
:10,11-21: unknown function 'jsondecode'; , and 1 other diagnostic(s)
```

#### java

```text
:10,11-21: unknown function 'jsondecode'; , and 1 other diagnostic(s)
```

#### typescript

```text
:10,11-21: unknown function 'jsondecode'; , and 1 other diagnostic(s)
```

#### python

```text
:10,11-21: unknown function 'jsondecode'; , and 1 other diagnostic(s)
```

#### csharp

```text
:10,11-21: unknown function 'jsondecode'; , and 1 other diagnostic(s)
```

#### go

```text
:10,11-21: unknown function 'jsondecode'; , and 1 other diagnostic(s)
```

## [*partial failure*] Dynamic Invocation Example Using Triggers

### HCL

```terraform
resource "aws_lambda_invocation" "example" {
  function_name = aws_lambda_function.lambda_function_test.function_name

  triggers = {
    redeployment = sha1(jsonencode([
      aws_lambda_function.example.environment
    ]))
  }

  input = jsonencode({
    key1 = "value1"
    key2 = "value2"
  })
}

```

### Failed Languages

#### yaml

```text
.pp:3,20-5,8: Failed to generate YAML program: Unknown Function; YAML does not support Fn::sha1.
```

### Successes

<details>

<summary>java</summary>

```java
package generated_program;

import com.pulumi.Context;
import com.pulumi.Pulumi;
import com.pulumi.core.Output;
import com.pulumi.aws.lambda.Invocation;
import com.pulumi.aws.lambda.InvocationArgs;
import static com.pulumi.codegen.internal.Serialization.*;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;

public class App {
    public static void main(String[] args) {
        Pulumi.run(App::stack);
    }

    public static void stack(Context ctx) {
        var example = new Invocation("example", InvocationArgs.builder()        
            .functionName(aws_lambda_function.lambda_function_test().function_name())
            .triggers(Map.of("redeployment", computeSHA1(serializeJson(
                jsonArray(aws_lambda_function.example().environment())))))
            .input(serializeJson(
                jsonObject(
                    jsonProperty("key1", "value1"),
                    jsonProperty("key2", "value2")
                )))
            .build());

    }
}
```

</details>

<details>

<summary>typescript</summary>

```typescript
import * as pulumi from "@pulumi/pulumi";
import * as aws from "@pulumi/aws";
import * as crypto from "crypto";

const example = new aws.lambda.Invocation("example", {
    functionName: aws_lambda_function.lambda_function_test.function_name,
    triggers: {
        redeployment: crypto.createHash('sha1').update(JSON.stringify([aws_lambda_function.example.environment])).digest('hex'),
    },
    input: JSON.stringify({
        key1: "value1",
        key2: "value2",
    }),
});
```

</details>

<details>

<summary>python</summary>

```python
import pulumi
import hashlib
import json
import pulumi_aws as aws

example = aws.lambda_.Invocation("example",
    function_name=aws_lambda_function["lambda_function_test"]["function_name"],
    triggers={
        "redeployment": hashlib.sha1(json.dumps([aws_lambda_function["example"]["environment"]]).encode()).hexdigest(),
    },
    input=json.dumps({
        "key1": "value1",
        "key2": "value2",
    }))
```

</details>

<details>

<summary>csharp</summary>

```csharp
using System.Collections.Generic;
using System.Security.Cryptography;
using System.Text;
using System.Text.Json;
using Pulumi;
using Aws = Pulumi.Aws;

	private static string ComputeSHA1(string input) {
		return BitConverter.ToString(
			SHA1.Create().ComputeHash(Encoding.UTF8.GetBytes(input))
		).Replace("-","").ToLowerInvariant());
	}

return await Deployment.RunAsync(() => 
{
    var example = new Aws.Lambda.Invocation("example", new()
    {
        FunctionName = aws_lambda_function.Lambda_function_test.Function_name,
        Triggers = 
        {
            { "redeployment", ComputeSHA1(JsonSerializer.Serialize(new[]
            {
                aws_lambda_function.Example.Environment,
            })) },
        },
        Input = JsonSerializer.Serialize(new Dictionary<string, object?>
        {
            ["key1"] = "value1",
            ["key2"] = "value2",
        }),
    });

});
```

</details>

<details>

<summary>go</summary>

```go
package main

import (
	"crypto/sha1"
	"encoding/json"
	"fmt"

	"github.com/pulumi/pulumi-aws/sdk/v5/go/aws/lambda"
	"github.com/pulumi/pulumi/sdk/v3/go/pulumi"
)

func sha1Hash(input string) string {
	hash := sha1.Sum([]byte(input))
	return hex.EncodeToString(hash[:])
}

func main() {
	pulumi.Run(func(ctx *pulumi.Context) error {
		tmpJSON0, err := json.Marshal([]interface{}{
			aws_lambda_function.Example.Environment,
		})
		if err != nil {
			return err
		}
		json0 := string(tmpJSON0)
		tmpJSON1, err := json.Marshal(map[string]interface{}{
			"key1": "value1",
			"key2": "value2",
		})
		if err != nil {
			return err
		}
		json1 := string(tmpJSON1)
		_, err = lambda.NewInvocation(ctx, "example", &lambda.InvocationArgs{
			FunctionName: pulumi.Any(aws_lambda_function.Lambda_function_test.Function_name),
			Triggers: pulumi.StringMap{
				"redeployment": sha1Hash(json0),
			},
			Input: pulumi.String(json1),
		})
		if err != nil {
			return err
		}
		return nil
	})
}
```

</details>

## [*partial failure*] #/resources/aws:ec2/defaultSecurityGroup:DefaultSecurityGroup

### HCL

```terraform
resource "aws_vpc" "mainvpc" {
  cidr_block = "10.1.0.0/16"
}

resource "aws_default_security_group" "default" {
  vpc_id = aws_vpc.mainvpc.id

  ingress {
    protocol  = -1
    self      = true
    from_port = 0
    to_port   = 0
  }

  egress {
    from_port   = 0
    to_port     = 0
    protocol    = "-1"
    cidr_blocks = ["0.0.0.0/0"]
  }
}

```

### Failed Languages

#### java

```text
<nil>: not yet implemented: GenUnaryOpExpression; not yet implemented: GenUnaryOpExpression
```

#### yaml

```text
.pp:6,17-19: Failed to generate YAML program: *model.UnaryOpExpression; Unimplemented! Needed for  -1
```

### Successes

<details>

<summary>go</summary>

```go
package main

import (
	"github.com/pulumi/pulumi-aws/sdk/v5/go/aws/ec2"
	"github.com/pulumi/pulumi/sdk/v3/go/pulumi"
)

func main() {
	pulumi.Run(func(ctx *pulumi.Context) error {
		mainvpc, err := ec2.NewVpc(ctx, "mainvpc", &ec2.VpcArgs{
			CidrBlock: pulumi.String("10.1.0.0/16"),
		})
		if err != nil {
			return err
		}
		_, err = ec2.NewDefaultSecurityGroup(ctx, "default", &ec2.DefaultSecurityGroupArgs{
			VpcId: mainvpc.ID(),
			Ingress: ec2.DefaultSecurityGroupIngressArray{
				&ec2.DefaultSecurityGroupIngressArgs{
					Protocol: pulumi.String("-1"),
					Self:     pulumi.Bool(true),
					FromPort: pulumi.Int(0),
					ToPort:   pulumi.Int(0),
				},
			},
			Egress: ec2.DefaultSecurityGroupEgressArray{
				&ec2.DefaultSecurityGroupEgressArgs{
					FromPort: pulumi.Int(0),
					ToPort:   pulumi.Int(0),
					Protocol: pulumi.String("-1"),
					CidrBlocks: pulumi.StringArray{
						pulumi.String("0.0.0.0/0"),
					},
				},
			},
		})
		if err != nil {
			return err
		}
		return nil
	})
}
```

</details>

<details>

<summary>typescript</summary>

```typescript
import * as pulumi from "@pulumi/pulumi";
import * as aws from "@pulumi/aws";

const mainvpc = new aws.ec2.Vpc("mainvpc", {cidrBlock: "10.1.0.0/16"});
const _default = new aws.ec2.DefaultSecurityGroup("default", {
    vpcId: mainvpc.id,
    ingress: [{
        protocol: "-1",
        self: true,
        fromPort: 0,
        toPort: 0,
    }],
    egress: [{
        fromPort: 0,
        toPort: 0,
        protocol: "-1",
        cidrBlocks: ["0.0.0.0/0"],
    }],
});
```

</details>

<details>

<summary>python</summary>

```python
import pulumi
import pulumi_aws as aws

mainvpc = aws.ec2.Vpc("mainvpc", cidr_block="10.1.0.0/16")
default = aws.ec2.DefaultSecurityGroup("default",
    vpc_id=mainvpc.id,
    ingress=[aws.ec2.DefaultSecurityGroupIngressArgs(
        protocol="-1",
        self=True,
        from_port=0,
        to_port=0,
    )],
    egress=[aws.ec2.DefaultSecurityGroupEgressArgs(
        from_port=0,
        to_port=0,
        protocol="-1",
        cidr_blocks=["0.0.0.0/0"],
    )])
```

</details>

<details>

<summary>csharp</summary>

```csharp
using System.Collections.Generic;
using Pulumi;
using Aws = Pulumi.Aws;

return await Deployment.RunAsync(() => 
{
    var mainvpc = new Aws.Ec2.Vpc("mainvpc", new()
    {
        CidrBlock = "10.1.0.0/16",
    });

    var @default = new Aws.Ec2.DefaultSecurityGroup("default", new()
    {
        VpcId = mainvpc.Id,
        Ingress = new[]
        {
            new Aws.Ec2.Inputs.DefaultSecurityGroupIngressArgs
            {
                Protocol = "-1",
                Self = true,
                FromPort = 0,
                ToPort = 0,
            },
        },
        Egress = new[]
        {
            new Aws.Ec2.Inputs.DefaultSecurityGroupEgressArgs
            {
                FromPort = 0,
                ToPort = 0,
                Protocol = "-1",
                CidrBlocks = new[]
                {
                    "0.0.0.0/0",
                },
            },
        },
    });

});
```

</details>

## [*partial failure*] Example Config To Deny All Egress Traffic, Allowing Ingress

### HCL

```terraform
resource "aws_vpc" "mainvpc" {
  cidr_block = "10.1.0.0/16"
}

resource "aws_default_security_group" "default" {
  vpc_id = aws_vpc.mainvpc.id

  ingress {
    protocol  = -1
    self      = true
    from_port = 0
    to_port   = 0
  }
}

```

### Failed Languages

#### yaml

```text
.pp:6,17-19: Failed to generate YAML program: *model.UnaryOpExpression; Unimplemented! Needed for  -1
```

#### java

```text
<nil>: not yet implemented: GenUnaryOpExpression; not yet implemented: GenUnaryOpExpression
```

### Successes

<details>

<summary>typescript</summary>

```typescript
import * as pulumi from "@pulumi/pulumi";
import * as aws from "@pulumi/aws";

const mainvpc = new aws.ec2.Vpc("mainvpc", {cidrBlock: "10.1.0.0/16"});
const _default = new aws.ec2.DefaultSecurityGroup("default", {
    vpcId: mainvpc.id,
    ingress: [{
        protocol: "-1",
        self: true,
        fromPort: 0,
        toPort: 0,
    }],
});
```

</details>

<details>

<summary>python</summary>

```python
import pulumi
import pulumi_aws as aws

mainvpc = aws.ec2.Vpc("mainvpc", cidr_block="10.1.0.0/16")
default = aws.ec2.DefaultSecurityGroup("default",
    vpc_id=mainvpc.id,
    ingress=[aws.ec2.DefaultSecurityGroupIngressArgs(
        protocol="-1",
        self=True,
        from_port=0,
        to_port=0,
    )])
```

</details>

<details>

<summary>csharp</summary>

```csharp
using System.Collections.Generic;
using Pulumi;
using Aws = Pulumi.Aws;

return await Deployment.RunAsync(() => 
{
    var mainvpc = new Aws.Ec2.Vpc("mainvpc", new()
    {
        CidrBlock = "10.1.0.0/16",
    });

    var @default = new Aws.Ec2.DefaultSecurityGroup("default", new()
    {
        VpcId = mainvpc.Id,
        Ingress = new[]
        {
            new Aws.Ec2.Inputs.DefaultSecurityGroupIngressArgs
            {
                Protocol = "-1",
                Self = true,
                FromPort = 0,
                ToPort = 0,
            },
        },
    });

});
```

</details>

<details>

<summary>go</summary>

```go
package main

import (
	"github.com/pulumi/pulumi-aws/sdk/v5/go/aws/ec2"
	"github.com/pulumi/pulumi/sdk/v3/go/pulumi"
)

func main() {
	pulumi.Run(func(ctx *pulumi.Context) error {
		mainvpc, err := ec2.NewVpc(ctx, "mainvpc", &ec2.VpcArgs{
			CidrBlock: pulumi.String("10.1.0.0/16"),
		})
		if err != nil {
			return err
		}
		_, err = ec2.NewDefaultSecurityGroup(ctx, "default", &ec2.DefaultSecurityGroupArgs{
			VpcId: mainvpc.ID(),
			Ingress: ec2.DefaultSecurityGroupIngressArray{
				&ec2.DefaultSecurityGroupIngressArgs{
					Protocol: pulumi.String("-1"),
					Self:     pulumi.Bool(true),
					FromPort: pulumi.Int(0),
					ToPort:   pulumi.Int(0),
				},
			},
		})
		if err != nil {
			return err
		}
		return nil
	})
}
```

</details>

## [**complete failure**] #/resources/aws:dynamodb/tag:Tag

### HCL

```terraform
provider "aws" {
  region = "us-west-2"
}

provider "aws" {
  alias  = "replica"
  region = "us-east-1"
}

data "aws_region" "replica" {
  provider = "aws.replica"
}

data "aws_region" "current" {}

resource "aws_dynamodb_table" "example" {
  # ... other configuration ...

  replica {
    region_name = data.aws_region.replica.name
  }
}

resource "aws_dynamodb_tag" "test" {
  provider = "aws.replica"

  resource_arn = replace(aws_dynamodb_table.test.arn, data.aws_region.current.name, data.aws_region.replica.name)
  key          = "testkey"
  value        = "testvalue"
}

```

### Failed Languages

#### typescript

```text
:26,18-25: unknown function 'replace'; , and 2 other diagnostic(s)
```

#### python

```text
:26,18-25: unknown function 'replace'; , and 2 other diagnostic(s)
```

#### csharp

```text
:26,18-25: unknown function 'replace'; , and 2 other diagnostic(s)
```

#### go

```text
:26,18-25: unknown function 'replace'; , and 2 other diagnostic(s)
```

#### yaml

```text
:26,18-25: unknown function 'replace'; , and 2 other diagnostic(s)
```

#### java

```text
:26,18-25: unknown function 'replace'; , and 2 other diagnostic(s)
```

## [*partial failure*] Basic Usage

### HCL

```terraform
resource "aws_elasticsearch_domain" "example" {
  domain_name           = "example"
  elasticsearch_version = "1.5"

  cluster_config {
    instance_type = "r4.large.elasticsearch"
  }

  snapshot_options {
    automated_snapshot_start_hour = 23
  }

  tags = {
    Domain = "TestDomain"
  }
}

resource "aws_elasticsearch_domain_saml_options" "example" {
  domain_name = aws_elasticsearch_domain.example.domain_name
  saml_options {
    enabled = true
    idp {
      entity_id        = "https://example.com"
      metadata_content = file("./saml-metadata.xml")
    }
  }
}

```

### Failed Languages

#### yaml

```text
.pp:18,25-56: Failed to generate YAML program: Unknown Function; YAML does not support Fn::readFile.
```

### Successes

<details>

<summary>typescript</summary>

```typescript
import * as pulumi from "@pulumi/pulumi";
import * as aws from "@pulumi/aws";
import * as fs from "fs";

const exampleDomain = new aws.elasticsearch.Domain("exampleDomain", {
    elasticsearchVersion: "1.5",
    clusterConfig: {
        instanceType: "r4.large.elasticsearch",
    },
    snapshotOptions: {
        automatedSnapshotStartHour: 23,
    },
    tags: {
        Domain: "TestDomain",
    },
});
const exampleDomainSamlOptions = new aws.elasticsearch.DomainSamlOptions("exampleDomainSamlOptions", {
    domainName: exampleDomain.domainName,
    samlOptions: {
        enabled: true,
        idp: {
            entityId: "https://example.com",
            metadataContent: fs.readFileSync("./saml-metadata.xml"),
        },
    },
});
```

</details>

<details>

<summary>python</summary>

```python
import pulumi
import pulumi_aws as aws

example_domain = aws.elasticsearch.Domain("exampleDomain",
    elasticsearch_version="1.5",
    cluster_config=aws.elasticsearch.DomainClusterConfigArgs(
        instance_type="r4.large.elasticsearch",
    ),
    snapshot_options=aws.elasticsearch.DomainSnapshotOptionsArgs(
        automated_snapshot_start_hour=23,
    ),
    tags={
        "Domain": "TestDomain",
    })
example_domain_saml_options = aws.elasticsearch.DomainSamlOptions("exampleDomainSamlOptions",
    domain_name=example_domain.domain_name,
    saml_options=aws.elasticsearch.DomainSamlOptionsSamlOptionsArgs(
        enabled=True,
        idp=aws.elasticsearch.DomainSamlOptionsSamlOptionsIdpArgs(
            entity_id="https://example.com",
            metadata_content=(lambda path: open(path).read())("./saml-metadata.xml"),
        ),
    ))
```

</details>

<details>

<summary>csharp</summary>

```csharp
using System.Collections.Generic;
using System.IO;
using Pulumi;
using Aws = Pulumi.Aws;

return await Deployment.RunAsync(() => 
{
    var exampleDomain = new Aws.ElasticSearch.Domain("exampleDomain", new()
    {
        ElasticsearchVersion = "1.5",
        ClusterConfig = new Aws.ElasticSearch.Inputs.DomainClusterConfigArgs
        {
            InstanceType = "r4.large.elasticsearch",
        },
        SnapshotOptions = new Aws.ElasticSearch.Inputs.DomainSnapshotOptionsArgs
        {
            AutomatedSnapshotStartHour = 23,
        },
        Tags = 
        {
            { "Domain", "TestDomain" },
        },
    });

    var exampleDomainSamlOptions = new Aws.ElasticSearch.DomainSamlOptions("exampleDomainSamlOptions", new()
    {
        DomainName = exampleDomain.DomainName,
        SamlOptions = new Aws.ElasticSearch.Inputs.DomainSamlOptionsSamlOptionsArgs
        {
            Enabled = true,
            Idp = new Aws.ElasticSearch.Inputs.DomainSamlOptionsSamlOptionsIdpArgs
            {
                EntityId = "https://example.com",
                MetadataContent = File.ReadAllText("./saml-metadata.xml"),
            },
        },
    });

});
```

</details>

<details>

<summary>go</summary>

```go
package main

import (
	"io/ioutil"

	"github.com/pulumi/pulumi-aws/sdk/v5/go/aws/elasticsearch"
	"github.com/pulumi/pulumi/sdk/v3/go/pulumi"
)

func readFileOrPanic(path string) pulumi.StringPtrInput {
	data, err := ioutil.ReadFile(path)
	if err != nil {
		panic(err.Error())
	}
	return pulumi.String(string(data))
}

func main() {
	pulumi.Run(func(ctx *pulumi.Context) error {
		exampleDomain, err := elasticsearch.NewDomain(ctx, "exampleDomain", &elasticsearch.DomainArgs{
			ElasticsearchVersion: pulumi.String("1.5"),
			ClusterConfig: &elasticsearch.DomainClusterConfigArgs{
				InstanceType: pulumi.String("r4.large.elasticsearch"),
			},
			SnapshotOptions: &elasticsearch.DomainSnapshotOptionsArgs{
				AutomatedSnapshotStartHour: pulumi.Int(23),
			},
			Tags: pulumi.StringMap{
				"Domain": pulumi.String("TestDomain"),
			},
		})
		if err != nil {
			return err
		}
		_, err = elasticsearch.NewDomainSamlOptions(ctx, "exampleDomainSamlOptions", &elasticsearch.DomainSamlOptionsArgs{
			DomainName: exampleDomain.DomainName,
			SamlOptions: &elasticsearch.DomainSamlOptionsSamlOptionsArgs{
				Enabled: pulumi.Bool(true),
				Idp: &elasticsearch.DomainSamlOptionsSamlOptionsIdpArgs{
					EntityId:        pulumi.String("https://example.com"),
					MetadataContent: readFileOrPanic("./saml-metadata.xml"),
				},
			},
		})
		if err != nil {
			return err
		}
		return nil
	})
}
```

</details>

<details>

<summary>java</summary>

```java
package generated_program;

import com.pulumi.Context;
import com.pulumi.Pulumi;
import com.pulumi.core.Output;
import com.pulumi.aws.elasticsearch.Domain;
import com.pulumi.aws.elasticsearch.DomainArgs;
import com.pulumi.aws.elasticsearch.inputs.DomainClusterConfigArgs;
import com.pulumi.aws.elasticsearch.inputs.DomainSnapshotOptionsArgs;
import com.pulumi.aws.elasticsearch.DomainSamlOptions;
import com.pulumi.aws.elasticsearch.DomainSamlOptionsArgs;
import com.pulumi.aws.elasticsearch.inputs.DomainSamlOptionsSamlOptionsArgs;
import com.pulumi.aws.elasticsearch.inputs.DomainSamlOptionsSamlOptionsIdpArgs;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;

public class App {
    public static void main(String[] args) {
        Pulumi.run(App::stack);
    }

    public static void stack(Context ctx) {
        var exampleDomain = new Domain("exampleDomain", DomainArgs.builder()        
            .elasticsearchVersion("1.5")
            .clusterConfig(DomainClusterConfigArgs.builder()
                .instanceType("r4.large.elasticsearch")
                .build())
            .snapshotOptions(DomainSnapshotOptionsArgs.builder()
                .automatedSnapshotStartHour(23)
                .build())
            .tags(Map.of("Domain", "TestDomain"))
            .build());

        var exampleDomainSamlOptions = new DomainSamlOptions("exampleDomainSamlOptions", DomainSamlOptionsArgs.builder()        
            .domainName(exampleDomain.domainName())
            .samlOptions(DomainSamlOptionsSamlOptionsArgs.builder()
                .enabled(true)
                .idp(DomainSamlOptionsSamlOptionsIdpArgs.builder()
                    .entityId("https://example.com")
                    .metadataContent(Files.readString(Paths.get("./saml-metadata.xml")))
                    .build())
                .build())
            .build());

    }
}
```

</details>

## [**complete failure**] Inline Data Document

### HCL

```terraform
resource "aws_imagebuilder_component" "example" {
  data = yamlencode({
    phases = [{
      name = "build"
      steps = [{
        action = "ExecuteBash"
        inputs = {
          commands = ["echo 'hello world'"]
        }
        name      = "example"
        onFailure = "Continue"
      }]
    }]
    schemaVersion = 1.0
  })
  name     = "example"
  platform = "Linux"
  version  = "1.0.0"
}

```

### Failed Languages

#### typescript

```text
:1,10-20: unknown function 'yamlencode'; , and 1 other diagnostic(s)
```

#### python

```text
:1,10-20: unknown function 'yamlencode'; , and 1 other diagnostic(s)
```

#### csharp

```text
:1,10-20: unknown function 'yamlencode'; , and 1 other diagnostic(s)
```

#### go

```text
:1,10-20: unknown function 'yamlencode'; , and 1 other diagnostic(s)
```

#### yaml

```text
:1,10-20: unknown function 'yamlencode'; , and 1 other diagnostic(s)
```

#### java

```text
:1,10-20: unknown function 'yamlencode'; , and 1 other diagnostic(s)
```

## [**complete failure**] Redeployment Triggers

### HCL

```terraform
resource "aws_apigatewayv2_deployment" "example" {
  api_id      = aws_apigatewayv2_api.example.id
  description = "Example deployment"

  triggers = {
    redeployment = sha1(join(",", list(
      jsonencode(aws_apigatewayv2_integration.example),
      jsonencode(aws_apigatewayv2_route.example),
    )))
  }

  lifecycle {
    create_before_destroy = true
  }
}

```

### Failed Languages

#### go

```text
:5,35-39: unknown function 'list'; , and 2 other diagnostic(s)
```

#### yaml

```text
:5,35-39: unknown function 'list'; , and 2 other diagnostic(s)
```

#### java

```text
:5,35-39: unknown function 'list'; , and 2 other diagnostic(s)
```

#### typescript

```text
:5,35-39: unknown function 'list'; , and 2 other diagnostic(s)
```

#### python

```text
:5,35-39: unknown function 'list'; , and 2 other diagnostic(s)
```

#### csharp

```text
:5,35-39: unknown function 'list'; , and 2 other diagnostic(s)
```

## [*partial failure*] Organization Access

### HCL

```terraform
data "aws_iam_policy_document" "test" {
  statement {
    sid    = "OrganizationAccess"
    effect = "Allow"
    actions = [
      "events:DescribeRule",
      "events:ListRules",
      "events:ListTargetsByRule",
      "events:ListTagsForResource",
    ]
    resources = [
      "arn:aws:events:eu-west-1:123456789012:rule/*",
      "arn:aws:events:eu-west-1:123456789012:event-bus/default"
    ]

    principals {
      type        = "AWS"
      identifiers = ["*"]
    }

    condition {
      test     = "StringEquals"
      variable = "aws:PrincipalOrgID"
      values   = [aws_organizations_organization.example.id]
    }
  }
}

resource "aws_cloudwatch_event_bus_policy" "test" {
  policy         = data.aws_iam_policy_document.test.json
  event_bus_name = aws_cloudwatch_event_bus.test.name
}

```

### Failed Languages

#### go

```text
failed to convert HCL for #/resources/aws:cloudwatch/eventBusPolicy:EventBusPolicy to go: invalid Go source code:

package main

import (

"github.com/pulumi/pulumi/sdk/v3/go/pulumi"
"github.com/pulumi/pulumi-aws/sdk/v5/go/aws/cloudwatch"
"github.com/pulumi/pulumi-aws/sdk/v5/go/aws/iam"
)
func main() {
pulumi.Run(func(ctx *pulumi.Context) error {
testPolicyDocument, err := iam.GetPolicyDocument(ctx, &iam.GetPolicyDocumentArgs{
Statements: []iam.GetPolicyDocumentStatement{
iam.GetPolicyDocumentStatement{
Sid: pulumi.StringRef("OrganizationAccess"),
Effect: pulumi.StringRef("Allow"),
Actions: []string{
"events:DescribeRule",
"events:ListRules",
"events:ListTargetsByRule",
"events:ListTagsForResource",
},
Resources: []string{
"arn:aws:events:eu-west-1:123456789012:rule/*",
"arn:aws:events:eu-west-1:123456789012:event-bus/default",
},
Principals: []iam.GetPolicyDocumentStatementPrincipal{
iam.GetPolicyDocumentStatementPrincipal{
Type: "AWS",
Identifiers: []string{
"*",
},
},
},
Conditions: []iam.GetPolicyDocumentStatementCondition{
iam.GetPolicyDocumentStatementCondition{
Test: "StringEquals",
Variable: "aws:PrincipalOrgID",
Values: interface{}{
aws_organizations_organization.Example.Id,
},
},
},
},
},
}, nil);
if err != nil {
return err
}
_, err = cloudwatch.NewEventBusPolicy(ctx, "testEventBusPolicy", &cloudwatch.EventBusPolicyArgs{
Policy: pulumi.String(testPolicyDocument.Json),
EventBusName: pulumi.Any(aws_cloudwatch_event_bus.Test.Name),
})
if err != nil {
return err
}
return nil
})
}
: 38:9: expected expression (and 10 more errors)
```

### Successes

<details>

<summary>typescript</summary>

```typescript
import * as pulumi from "@pulumi/pulumi";
import * as aws from "@pulumi/aws";

const testPolicyDocument = aws.iam.getPolicyDocument({
    statements: [{
        sid: "OrganizationAccess",
        effect: "Allow",
        actions: [
            "events:DescribeRule",
            "events:ListRules",
            "events:ListTargetsByRule",
            "events:ListTagsForResource",
        ],
        resources: [
            "arn:aws:events:eu-west-1:123456789012:rule/*",
            "arn:aws:events:eu-west-1:123456789012:event-bus/default",
        ],
        principals: [{
            type: "AWS",
            identifiers: ["*"],
        }],
        conditions: [{
            test: "StringEquals",
            variable: "aws:PrincipalOrgID",
            values: [aws_organizations_organization.example.id],
        }],
    }],
});
const testEventBusPolicy = new aws.cloudwatch.EventBusPolicy("testEventBusPolicy", {
    policy: testPolicyDocument.then(testPolicyDocument => testPolicyDocument.json),
    eventBusName: aws_cloudwatch_event_bus.test.name,
});
```

</details>

<details>

<summary>python</summary>

```python
import pulumi
import pulumi_aws as aws

test_policy_document = aws.iam.get_policy_document(statements=[aws.iam.GetPolicyDocumentStatementArgs(
    sid="OrganizationAccess",
    effect="Allow",
    actions=[
        "events:DescribeRule",
        "events:ListRules",
        "events:ListTargetsByRule",
        "events:ListTagsForResource",
    ],
    resources=[
        "arn:aws:events:eu-west-1:123456789012:rule/*",
        "arn:aws:events:eu-west-1:123456789012:event-bus/default",
    ],
    principals=[aws.iam.GetPolicyDocumentStatementPrincipalArgs(
        type="AWS",
        identifiers=["*"],
    )],
    conditions=[aws.iam.GetPolicyDocumentStatementConditionArgs(
        test="StringEquals",
        variable="aws:PrincipalOrgID",
        values=[aws_organizations_organization["example"]["id"]],
    )],
)])
test_event_bus_policy = aws.cloudwatch.EventBusPolicy("testEventBusPolicy",
    policy=test_policy_document.json,
    event_bus_name=aws_cloudwatch_event_bus["test"]["name"])
```

</details>

<details>

<summary>csharp</summary>

```csharp
using System.Collections.Generic;
using Pulumi;
using Aws = Pulumi.Aws;

return await Deployment.RunAsync(() => 
{
    var testPolicyDocument = Aws.Iam.GetPolicyDocument.Invoke(new()
    {
        Statements = new[]
        {
            new Aws.Iam.Inputs.GetPolicyDocumentStatementInputArgs
            {
                Sid = "OrganizationAccess",
                Effect = "Allow",
                Actions = new[]
                {
                    "events:DescribeRule",
                    "events:ListRules",
                    "events:ListTargetsByRule",
                    "events:ListTagsForResource",
                },
                Resources = new[]
                {
                    "arn:aws:events:eu-west-1:123456789012:rule/*",
                    "arn:aws:events:eu-west-1:123456789012:event-bus/default",
                },
                Principals = new[]
                {
                    new Aws.Iam.Inputs.GetPolicyDocumentStatementPrincipalInputArgs
                    {
                        Type = "AWS",
                        Identifiers = new[]
                        {
                            "*",
                        },
                    },
                },
                Conditions = new[]
                {
                    new Aws.Iam.Inputs.GetPolicyDocumentStatementConditionInputArgs
                    {
                        Test = "StringEquals",
                        Variable = "aws:PrincipalOrgID",
                        Values = new[]
                        {
                            aws_organizations_organization.Example.Id,
                        },
                    },
                },
            },
        },
    });

    var testEventBusPolicy = new Aws.CloudWatch.EventBusPolicy("testEventBusPolicy", new()
    {
        Policy = testPolicyDocument.Apply(getPolicyDocumentResult => getPolicyDocumentResult.Json),
        EventBusName = aws_cloudwatch_event_bus.Test.Name,
    });

});
```

</details>

<details>

<summary>yaml</summary>

```yaml
resources:
  testEventBusPolicy:
    type: aws:cloudwatch:EventBusPolicy
    properties:
      policy: ${testPolicyDocument.json}
      eventBusName: ${aws_cloudwatch_event_bus.test.name}
variables:
  testPolicyDocument:
    Fn::Invoke:
      Function: aws:iam:getPolicyDocument
      Arguments:
        statements:
          - sid: OrganizationAccess
            effect: Allow
            actions:
              - events:DescribeRule
              - events:ListRules
              - events:ListTargetsByRule
              - events:ListTagsForResource
            resources:
              - arn:aws:events:eu-west-1:123456789012:rule/*
              - arn:aws:events:eu-west-1:123456789012:event-bus/default
            principals:
              - type: AWS
                identifiers:
                  - '*'
            conditions:
              - test: StringEquals
                variable: aws:PrincipalOrgID
                values:
                  - ${aws_organizations_organization.example.id}
```

</details>

<details>

<summary>java</summary>

```java
package generated_program;

import com.pulumi.Context;
import com.pulumi.Pulumi;
import com.pulumi.core.Output;
import com.pulumi.aws.iam.IamFunctions;
import com.pulumi.aws.iam.inputs.GetPolicyDocumentArgs;
import com.pulumi.aws.cloudwatch.EventBusPolicy;
import com.pulumi.aws.cloudwatch.EventBusPolicyArgs;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;

public class App {
    public static void main(String[] args) {
        Pulumi.run(App::stack);
    }

    public static void stack(Context ctx) {
        final var testPolicyDocument = IamFunctions.getPolicyDocument(GetPolicyDocumentArgs.builder()
            .statements(GetPolicyDocumentStatementArgs.builder()
                .sid("OrganizationAccess")
                .effect("Allow")
                .actions(                
                    "events:DescribeRule",
                    "events:ListRules",
                    "events:ListTargetsByRule",
                    "events:ListTagsForResource")
                .resources(                
                    "arn:aws:events:eu-west-1:123456789012:rule/*",
                    "arn:aws:events:eu-west-1:123456789012:event-bus/default")
                .principals(GetPolicyDocumentStatementPrincipalArgs.builder()
                    .type("AWS")
                    .identifiers("*")
                    .build())
                .conditions(GetPolicyDocumentStatementConditionArgs.builder()
                    .test("StringEquals")
                    .variable("aws:PrincipalOrgID")
                    .values(aws_organizations_organization.example().id())
                    .build())
                .build())
            .build());

        var testEventBusPolicy = new EventBusPolicy("testEventBusPolicy", EventBusPolicyArgs.builder()        
            .policy(testPolicyDocument.applyValue(getPolicyDocumentResult -> getPolicyDocumentResult.json()))
            .eventBusName(aws_cloudwatch_event_bus.test().name())
            .build());

    }
}
```

</details>

## [*partial failure*] Multiple Statements

### HCL

```terraform
data "aws_iam_policy_document" "test" {

  statement {
    sid    = "DevAccountAccess"
    effect = "Allow"
    actions = [
      "events:PutEvents",
    ]
    resources = [
      "arn:aws:events:eu-west-1:123456789012:event-bus/default"
    ]

    principals {
      type        = "AWS"
      identifiers = ["123456789012"]
    }
  }

  statement {
    sid    = "OrganizationAccess"
    effect = "Allow"
    actions = [
      "events:DescribeRule",
      "events:ListRules",
      "events:ListTargetsByRule",
      "events:ListTagsForResource",
    ]
    resources = [
      "arn:aws:events:eu-west-1:123456789012:rule/*",
      "arn:aws:events:eu-west-1:123456789012:event-bus/default"
    ]

    principals {
      type        = "AWS"
      identifiers = ["*"]
    }

    condition {
      test     = "StringEquals"
      variable = "aws:PrincipalOrgID"
      values   = [aws_organizations_organization.example.id]
    }
  }
}

resource "aws_cloudwatch_event_bus_policy" "test" {
  policy         = data.aws_iam_policy_document.test.json
  event_bus_name = aws_cloudwatch_event_bus.test.name
}

```

### Failed Languages

#### go

```text
failed to convert HCL for #/resources/aws:cloudwatch/eventBusPolicy:EventBusPolicy to go: invalid Go source code:

package main

import (

"github.com/pulumi/pulumi/sdk/v3/go/pulumi"
"github.com/pulumi/pulumi-aws/sdk/v5/go/aws/cloudwatch"
"github.com/pulumi/pulumi-aws/sdk/v5/go/aws/iam"
)
func main() {
pulumi.Run(func(ctx *pulumi.Context) error {
testPolicyDocument, err := iam.GetPolicyDocument(ctx, &iam.GetPolicyDocumentArgs{
Statements: []iam.GetPolicyDocumentStatement{
iam.GetPolicyDocumentStatement{
Sid: pulumi.StringRef("DevAccountAccess"),
Effect: pulumi.StringRef("Allow"),
Actions: []string{
"events:PutEvents",
},
Resources: []string{
"arn:aws:events:eu-west-1:123456789012:event-bus/default",
},
Principals: []iam.GetPolicyDocumentStatementPrincipal{
iam.GetPolicyDocumentStatementPrincipal{
Type: "AWS",
Identifiers: []string{
"123456789012",
},
},
},
},
iam.GetPolicyDocumentStatement{
Sid: pulumi.StringRef("OrganizationAccess"),
Effect: pulumi.StringRef("Allow"),
Actions: []string{
"events:DescribeRule",
"events:ListRules",
"events:ListTargetsByRule",
"events:ListTagsForResource",
},
Resources: []string{
"arn:aws:events:eu-west-1:123456789012:rule/*",
"arn:aws:events:eu-west-1:123456789012:event-bus/default",
},
Principals: []iam.GetPolicyDocumentStatementPrincipal{
iam.GetPolicyDocumentStatementPrincipal{
Type: "AWS",
Identifiers: []string{
"*",
},
},
},
Conditions: []iam.GetPolicyDocumentStatementCondition{
iam.GetPolicyDocumentStatementCondition{
Test: "StringEquals",
Variable: "aws:PrincipalOrgID",
Values: interface{}{
aws_organizations_organization.Example.Id,
},
},
},
},
},
}, nil);
if err != nil {
return err
}
_, err = cloudwatch.NewEventBusPolicy(ctx, "testEventBusPolicy", &cloudwatch.EventBusPolicyArgs{
Policy: pulumi.String(testPolicyDocument.Json),
EventBusName: pulumi.Any(aws_cloudwatch_event_bus.Test.Name),
})
if err != nil {
return err
}
return nil
})
}
: 56:9: expected expression (and 10 more errors)
```

### Successes

<details>

<summary>yaml</summary>

```yaml
resources:
  testEventBusPolicy:
    type: aws:cloudwatch:EventBusPolicy
    properties:
      policy: ${testPolicyDocument.json}
      eventBusName: ${aws_cloudwatch_event_bus.test.name}
variables:
  testPolicyDocument:
    Fn::Invoke:
      Function: aws:iam:getPolicyDocument
      Arguments:
        statements:
          - sid: DevAccountAccess
            effect: Allow
            actions:
              - events:PutEvents
            resources:
              - arn:aws:events:eu-west-1:123456789012:event-bus/default
            principals:
              - type: AWS
                identifiers:
                  - 123456789012
          - sid: OrganizationAccess
            effect: Allow
            actions:
              - events:DescribeRule
              - events:ListRules
              - events:ListTargetsByRule
              - events:ListTagsForResource
            resources:
              - arn:aws:events:eu-west-1:123456789012:rule/*
              - arn:aws:events:eu-west-1:123456789012:event-bus/default
            principals:
              - type: AWS
                identifiers:
                  - '*'
            conditions:
              - test: StringEquals
                variable: aws:PrincipalOrgID
                values:
                  - ${aws_organizations_organization.example.id}
```

</details>

<details>

<summary>java</summary>

```java
package generated_program;

import com.pulumi.Context;
import com.pulumi.Pulumi;
import com.pulumi.core.Output;
import com.pulumi.aws.iam.IamFunctions;
import com.pulumi.aws.iam.inputs.GetPolicyDocumentArgs;
import com.pulumi.aws.cloudwatch.EventBusPolicy;
import com.pulumi.aws.cloudwatch.EventBusPolicyArgs;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;

public class App {
    public static void main(String[] args) {
        Pulumi.run(App::stack);
    }

    public static void stack(Context ctx) {
        final var testPolicyDocument = IamFunctions.getPolicyDocument(GetPolicyDocumentArgs.builder()
            .statements(            
                GetPolicyDocumentStatementArgs.builder()
                    .sid("DevAccountAccess")
                    .effect("Allow")
                    .actions("events:PutEvents")
                    .resources("arn:aws:events:eu-west-1:123456789012:event-bus/default")
                    .principals(GetPolicyDocumentStatementPrincipalArgs.builder()
                        .type("AWS")
                        .identifiers("123456789012")
                        .build())
                    .build(),
                GetPolicyDocumentStatementArgs.builder()
                    .sid("OrganizationAccess")
                    .effect("Allow")
                    .actions(                    
                        "events:DescribeRule",
                        "events:ListRules",
                        "events:ListTargetsByRule",
                        "events:ListTagsForResource")
                    .resources(                    
                        "arn:aws:events:eu-west-1:123456789012:rule/*",
                        "arn:aws:events:eu-west-1:123456789012:event-bus/default")
                    .principals(GetPolicyDocumentStatementPrincipalArgs.builder()
                        .type("AWS")
                        .identifiers("*")
                        .build())
                    .conditions(GetPolicyDocumentStatementConditionArgs.builder()
                        .test("StringEquals")
                        .variable("aws:PrincipalOrgID")
                        .values(aws_organizations_organization.example().id())
                        .build())
                    .build())
            .build());

        var testEventBusPolicy = new EventBusPolicy("testEventBusPolicy", EventBusPolicyArgs.builder()        
            .policy(testPolicyDocument.applyValue(getPolicyDocumentResult -> getPolicyDocumentResult.json()))
            .eventBusName(aws_cloudwatch_event_bus.test().name())
            .build());

    }
}
```

</details>

<details>

<summary>typescript</summary>

```typescript
import * as pulumi from "@pulumi/pulumi";
import * as aws from "@pulumi/aws";

const testPolicyDocument = aws.iam.getPolicyDocument({
    statements: [
        {
            sid: "DevAccountAccess",
            effect: "Allow",
            actions: ["events:PutEvents"],
            resources: ["arn:aws:events:eu-west-1:123456789012:event-bus/default"],
            principals: [{
                type: "AWS",
                identifiers: ["123456789012"],
            }],
        },
        {
            sid: "OrganizationAccess",
            effect: "Allow",
            actions: [
                "events:DescribeRule",
                "events:ListRules",
                "events:ListTargetsByRule",
                "events:ListTagsForResource",
            ],
            resources: [
                "arn:aws:events:eu-west-1:123456789012:rule/*",
                "arn:aws:events:eu-west-1:123456789012:event-bus/default",
            ],
            principals: [{
                type: "AWS",
                identifiers: ["*"],
            }],
            conditions: [{
                test: "StringEquals",
                variable: "aws:PrincipalOrgID",
                values: [aws_organizations_organization.example.id],
            }],
        },
    ],
});
const testEventBusPolicy = new aws.cloudwatch.EventBusPolicy("testEventBusPolicy", {
    policy: testPolicyDocument.then(testPolicyDocument => testPolicyDocument.json),
    eventBusName: aws_cloudwatch_event_bus.test.name,
});
```

</details>

<details>

<summary>python</summary>

```python
import pulumi
import pulumi_aws as aws

test_policy_document = aws.iam.get_policy_document(statements=[
    aws.iam.GetPolicyDocumentStatementArgs(
        sid="DevAccountAccess",
        effect="Allow",
        actions=["events:PutEvents"],
        resources=["arn:aws:events:eu-west-1:123456789012:event-bus/default"],
        principals=[aws.iam.GetPolicyDocumentStatementPrincipalArgs(
            type="AWS",
            identifiers=["123456789012"],
        )],
    ),
    aws.iam.GetPolicyDocumentStatementArgs(
        sid="OrganizationAccess",
        effect="Allow",
        actions=[
            "events:DescribeRule",
            "events:ListRules",
            "events:ListTargetsByRule",
            "events:ListTagsForResource",
        ],
        resources=[
            "arn:aws:events:eu-west-1:123456789012:rule/*",
            "arn:aws:events:eu-west-1:123456789012:event-bus/default",
        ],
        principals=[aws.iam.GetPolicyDocumentStatementPrincipalArgs(
            type="AWS",
            identifiers=["*"],
        )],
        conditions=[aws.iam.GetPolicyDocumentStatementConditionArgs(
            test="StringEquals",
            variable="aws:PrincipalOrgID",
            values=[aws_organizations_organization["example"]["id"]],
        )],
    ),
])
test_event_bus_policy = aws.cloudwatch.EventBusPolicy("testEventBusPolicy",
    policy=test_policy_document.json,
    event_bus_name=aws_cloudwatch_event_bus["test"]["name"])
```

</details>

<details>

<summary>csharp</summary>

```csharp
using System.Collections.Generic;
using Pulumi;
using Aws = Pulumi.Aws;

return await Deployment.RunAsync(() => 
{
    var testPolicyDocument = Aws.Iam.GetPolicyDocument.Invoke(new()
    {
        Statements = new[]
        {
            new Aws.Iam.Inputs.GetPolicyDocumentStatementInputArgs
            {
                Sid = "DevAccountAccess",
                Effect = "Allow",
                Actions = new[]
                {
                    "events:PutEvents",
                },
                Resources = new[]
                {
                    "arn:aws:events:eu-west-1:123456789012:event-bus/default",
                },
                Principals = new[]
                {
                    new Aws.Iam.Inputs.GetPolicyDocumentStatementPrincipalInputArgs
                    {
                        Type = "AWS",
                        Identifiers = new[]
                        {
                            "123456789012",
                        },
                    },
                },
            },
            new Aws.Iam.Inputs.GetPolicyDocumentStatementInputArgs
            {
                Sid = "OrganizationAccess",
                Effect = "Allow",
                Actions = new[]
                {
                    "events:DescribeRule",
                    "events:ListRules",
                    "events:ListTargetsByRule",
                    "events:ListTagsForResource",
                },
                Resources = new[]
                {
                    "arn:aws:events:eu-west-1:123456789012:rule/*",
                    "arn:aws:events:eu-west-1:123456789012:event-bus/default",
                },
                Principals = new[]
                {
                    new Aws.Iam.Inputs.GetPolicyDocumentStatementPrincipalInputArgs
                    {
                        Type = "AWS",
                        Identifiers = new[]
                        {
                            "*",
                        },
                    },
                },
                Conditions = new[]
                {
                    new Aws.Iam.Inputs.GetPolicyDocumentStatementConditionInputArgs
                    {
                        Test = "StringEquals",
                        Variable = "aws:PrincipalOrgID",
                        Values = new[]
                        {
                            aws_organizations_organization.Example.Id,
                        },
                    },
                },
            },
        },
    });

    var testEventBusPolicy = new Aws.CloudWatch.EventBusPolicy("testEventBusPolicy", new()
    {
        Policy = testPolicyDocument.Apply(getPolicyDocumentResult => getPolicyDocumentResult.Json),
        EventBusName = aws_cloudwatch_event_bus.Test.Name,
    });

});
```

</details>

## [*partial failure*] #/resources/aws:elasticloadbalancing/loadBalancerBackendServerPolicy:LoadBalancerBackendServerPolicy

### HCL

```terraform
resource "aws_elb" "wu-tang" {
  name               = "wu-tang"
  availability_zones = ["us-east-1a"]

  listener {
    instance_port      = 443
    instance_protocol  = "http"
    lb_port            = 443
    lb_protocol        = "https"
    ssl_certificate_id = "arn:aws:iam::000000000000:server-certificate/wu-tang.net"
  }

  tags = {
    Name = "wu-tang"
  }
}

resource "aws_load_balancer_policy" "wu-tang-ca-pubkey-policy" {
  load_balancer_name = aws_elb.wu-tang.name
  policy_name        = "wu-tang-ca-pubkey-policy"
  policy_type_name   = "PublicKeyPolicyType"

  # The public key of a CA certificate file can be extracted with:
  # $ cat wu-tang-ca.pem | openssl x509 -pubkey -noout | grep -v '\-\-\-\-' | tr -d '\n' > wu-tang-pubkey
  policy_attribute {
    name  = "PublicKey"
    value = file("wu-tang-pubkey")
  }
}

resource "aws_load_balancer_policy" "wu-tang-root-ca-backend-auth-policy" {
  load_balancer_name = aws_elb.wu-tang.name
  policy_name        = "wu-tang-root-ca-backend-auth-policy"
  policy_type_name   = "BackendServerAuthenticationPolicyType"

  policy_attribute {
    name  = "PublicKeyPolicyName"
    value = aws_load_balancer_policy.wu-tang-root-ca-pubkey-policy.policy_name
  }
}

resource "aws_load_balancer_backend_server_policy" "wu-tang-backend-auth-policies-443" {
  load_balancer_name = aws_elb.wu-tang.name
  instance_port      = 443

  policy_names = [
    aws_load_balancer_policy.wu-tang-root-ca-backend-auth-policy.policy_name,
  ]
}

```

### Failed Languages

#### yaml

```text
.pp:14,21-29: Invalid property name access; 'wu-tang' is not a valid property name access. It has been changed to a quoted key access., and 5 other diagnostic(s)
```

### Successes

<details>

<summary>java</summary>

```java
package generated_program;

import com.pulumi.Context;
import com.pulumi.Pulumi;
import com.pulumi.core.Output;
import com.pulumi.aws.elb.LoadBalancer;
import com.pulumi.aws.elb.LoadBalancerArgs;
import com.pulumi.aws.elb.inputs.LoadBalancerListenerArgs;
import com.pulumi.aws.elb.LoadBalancerPolicy;
import com.pulumi.aws.elb.LoadBalancerPolicyArgs;
import com.pulumi.aws.elb.inputs.LoadBalancerPolicyPolicyAttributeArgs;
import com.pulumi.aws.elb.LoadBalancerBackendServerPolicy;
import com.pulumi.aws.elb.LoadBalancerBackendServerPolicyArgs;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;

public class App {
    public static void main(String[] args) {
        Pulumi.run(App::stack);
    }

    public static void stack(Context ctx) {
        var wu_tang = new LoadBalancer("wu-tang", LoadBalancerArgs.builder()        
            .availabilityZones("us-east-1a")
            .listeners(LoadBalancerListenerArgs.builder()
                .instancePort(443)
                .instanceProtocol("http")
                .lbPort(443)
                .lbProtocol("https")
                .sslCertificateId("arn:aws:iam::000000000000:server-certificate/wu-tang.net")
                .build())
            .tags(Map.of("Name", "wu-tang"))
            .build());

        var wu_tang_ca_pubkey_policy = new LoadBalancerPolicy("wu-tang-ca-pubkey-policy", LoadBalancerPolicyArgs.builder()        
            .loadBalancerName(wu_tang.name())
            .policyName("wu-tang-ca-pubkey-policy")
            .policyTypeName("PublicKeyPolicyType")
            .policyAttributes(LoadBalancerPolicyPolicyAttributeArgs.builder()
                .name("PublicKey")
                .value(Files.readString(Paths.get("wu-tang-pubkey")))
                .build())
            .build());

        var wu_tang_root_ca_backend_auth_policy = new LoadBalancerPolicy("wu-tang-root-ca-backend-auth-policy", LoadBalancerPolicyArgs.builder()        
            .loadBalancerName(wu_tang.name())
            .policyName("wu-tang-root-ca-backend-auth-policy")
            .policyTypeName("BackendServerAuthenticationPolicyType")
            .policyAttributes(LoadBalancerPolicyPolicyAttributeArgs.builder()
                .name("PublicKeyPolicyName")
                .value(aws_load_balancer_policy.wu-tang-root-ca-pubkey-policy().policy_name())
                .build())
            .build());

        var wu_tang_backend_auth_policies_443 = new LoadBalancerBackendServerPolicy("wu-tang-backend-auth-policies-443", LoadBalancerBackendServerPolicyArgs.builder()        
            .loadBalancerName(wu_tang.name())
            .instancePort(443)
            .policyNames(wu_tang_root_ca_backend_auth_policy.policyName())
            .build());

    }
}
```

</details>

<details>

<summary>typescript</summary>

```typescript
import * as pulumi from "@pulumi/pulumi";
import * as aws from "@pulumi/aws";
import * as fs from "fs";

const wu_tang = new aws.elb.LoadBalancer("wu-tang", {
    availabilityZones: ["us-east-1a"],
    listeners: [{
        instancePort: 443,
        instanceProtocol: "http",
        lbPort: 443,
        lbProtocol: "https",
        sslCertificateId: "arn:aws:iam::000000000000:server-certificate/wu-tang.net",
    }],
    tags: {
        Name: "wu-tang",
    },
});
const wu_tang_ca_pubkey_policy = new aws.elb.LoadBalancerPolicy("wu-tang-ca-pubkey-policy", {
    loadBalancerName: wu_tang.name,
    policyName: "wu-tang-ca-pubkey-policy",
    policyTypeName: "PublicKeyPolicyType",
    policyAttributes: [{
        name: "PublicKey",
        value: fs.readFileSync("wu-tang-pubkey"),
    }],
});
const wu_tang_root_ca_backend_auth_policy = new aws.elb.LoadBalancerPolicy("wu-tang-root-ca-backend-auth-policy", {
    loadBalancerName: wu_tang.name,
    policyName: "wu-tang-root-ca-backend-auth-policy",
    policyTypeName: "BackendServerAuthenticationPolicyType",
    policyAttributes: [{
        name: "PublicKeyPolicyName",
        value: aws_load_balancer_policy["wu-tang-root-ca-pubkey-policy"].policy_name,
    }],
});
const wu_tang_backend_auth_policies_443 = new aws.elb.LoadBalancerBackendServerPolicy("wu-tang-backend-auth-policies-443", {
    loadBalancerName: wu_tang.name,
    instancePort: 443,
    policyNames: [wu_tang_root_ca_backend_auth_policy.policyName],
});
```

</details>

<details>

<summary>python</summary>

```python
import pulumi
import pulumi_aws as aws

wu_tang = aws.elb.LoadBalancer("wu-tang",
    availability_zones=["us-east-1a"],
    listeners=[aws.elb.LoadBalancerListenerArgs(
        instance_port=443,
        instance_protocol="http",
        lb_port=443,
        lb_protocol="https",
        ssl_certificate_id="arn:aws:iam::000000000000:server-certificate/wu-tang.net",
    )],
    tags={
        "Name": "wu-tang",
    })
wu_tang_ca_pubkey_policy = aws.elb.LoadBalancerPolicy("wu-tang-ca-pubkey-policy",
    load_balancer_name=wu_tang.name,
    policy_name="wu-tang-ca-pubkey-policy",
    policy_type_name="PublicKeyPolicyType",
    policy_attributes=[aws.elb.LoadBalancerPolicyPolicyAttributeArgs(
        name="PublicKey",
        value=(lambda path: open(path).read())("wu-tang-pubkey"),
    )])
wu_tang_root_ca_backend_auth_policy = aws.elb.LoadBalancerPolicy("wu-tang-root-ca-backend-auth-policy",
    load_balancer_name=wu_tang.name,
    policy_name="wu-tang-root-ca-backend-auth-policy",
    policy_type_name="BackendServerAuthenticationPolicyType",
    policy_attributes=[aws.elb.LoadBalancerPolicyPolicyAttributeArgs(
        name="PublicKeyPolicyName",
        value=aws_load_balancer_policy["wu-tang-root-ca-pubkey-policy"]["policy_name"],
    )])
wu_tang_backend_auth_policies_443 = aws.elb.LoadBalancerBackendServerPolicy("wu-tang-backend-auth-policies-443",
    load_balancer_name=wu_tang.name,
    instance_port=443,
    policy_names=[wu_tang_root_ca_backend_auth_policy.policy_name])
```

</details>

<details>

<summary>csharp</summary>

```csharp
using System.Collections.Generic;
using System.IO;
using Pulumi;
using Aws = Pulumi.Aws;

return await Deployment.RunAsync(() => 
{
    var wu_tang = new Aws.Elb.LoadBalancer("wu-tang", new()
    {
        AvailabilityZones = new[]
        {
            "us-east-1a",
        },
        Listeners = new[]
        {
            new Aws.Elb.Inputs.LoadBalancerListenerArgs
            {
                InstancePort = 443,
                InstanceProtocol = "http",
                LbPort = 443,
                LbProtocol = "https",
                SslCertificateId = "arn:aws:iam::000000000000:server-certificate/wu-tang.net",
            },
        },
        Tags = 
        {
            { "Name", "wu-tang" },
        },
    });

    var wu_tang_ca_pubkey_policy = new Aws.Elb.LoadBalancerPolicy("wu-tang-ca-pubkey-policy", new()
    {
        LoadBalancerName = wu_tang.Name,
        PolicyName = "wu-tang-ca-pubkey-policy",
        PolicyTypeName = "PublicKeyPolicyType",
        PolicyAttributes = new[]
        {
            new Aws.Elb.Inputs.LoadBalancerPolicyPolicyAttributeArgs
            {
                Name = "PublicKey",
                Value = File.ReadAllText("wu-tang-pubkey"),
            },
        },
    });

    var wu_tang_root_ca_backend_auth_policy = new Aws.Elb.LoadBalancerPolicy("wu-tang-root-ca-backend-auth-policy", new()
    {
        LoadBalancerName = wu_tang.Name,
        PolicyName = "wu-tang-root-ca-backend-auth-policy",
        PolicyTypeName = "BackendServerAuthenticationPolicyType",
        PolicyAttributes = new[]
        {
            new Aws.Elb.Inputs.LoadBalancerPolicyPolicyAttributeArgs
            {
                Name = "PublicKeyPolicyName",
                Value = aws_load_balancer_policy.Wu_tang_root_ca_pubkey_policy.Policy_name,
            },
        },
    });

    var wu_tang_backend_auth_policies_443 = new Aws.Elb.LoadBalancerBackendServerPolicy("wu-tang-backend-auth-policies-443", new()
    {
        LoadBalancerName = wu_tang.Name,
        InstancePort = 443,
        PolicyNames = new[]
        {
            wu_tang_root_ca_backend_auth_policy.PolicyName,
        },
    });

});
```

</details>

<details>

<summary>go</summary>

```go
package main

import (
	"io/ioutil"

	"github.com/pulumi/pulumi-aws/sdk/v5/go/aws/elb"
	"github.com/pulumi/pulumi/sdk/v3/go/pulumi"
)

func readFileOrPanic(path string) pulumi.StringPtrInput {
	data, err := ioutil.ReadFile(path)
	if err != nil {
		panic(err.Error())
	}
	return pulumi.String(string(data))
}

func main() {
	pulumi.Run(func(ctx *pulumi.Context) error {
		_, err := elb.NewLoadBalancer(ctx, "wu-tang", &elb.LoadBalancerArgs{
			AvailabilityZones: pulumi.StringArray{
				pulumi.String("us-east-1a"),
			},
			Listeners: elb.LoadBalancerListenerArray{
				&elb.LoadBalancerListenerArgs{
					InstancePort:     pulumi.Int(443),
					InstanceProtocol: pulumi.String("http"),
					LbPort:           pulumi.Int(443),
					LbProtocol:       pulumi.String("https"),
					SslCertificateId: pulumi.String("arn:aws:iam::000000000000:server-certificate/wu-tang.net"),
				},
			},
			Tags: pulumi.StringMap{
				"Name": pulumi.String("wu-tang"),
			},
		})
		if err != nil {
			return err
		}
		_, err = elb.NewLoadBalancerPolicy(ctx, "wu-tang-ca-pubkey-policy", &elb.LoadBalancerPolicyArgs{
			LoadBalancerName: wu_tang.Name,
			PolicyName:       pulumi.String("wu-tang-ca-pubkey-policy"),
			PolicyTypeName:   pulumi.String("PublicKeyPolicyType"),
			PolicyAttributes: elb.LoadBalancerPolicyPolicyAttributeArray{
				&elb.LoadBalancerPolicyPolicyAttributeArgs{
					Name:  pulumi.String("PublicKey"),
					Value: readFileOrPanic("wu-tang-pubkey"),
				},
			},
		})
		if err != nil {
			return err
		}
		_, err = elb.NewLoadBalancerPolicy(ctx, "wu-tang-root-ca-backend-auth-policy", &elb.LoadBalancerPolicyArgs{
			LoadBalancerName: wu_tang.Name,
			PolicyName:       pulumi.String("wu-tang-root-ca-backend-auth-policy"),
			PolicyTypeName:   pulumi.String("BackendServerAuthenticationPolicyType"),
			PolicyAttributes: elb.LoadBalancerPolicyPolicyAttributeArray{
				&elb.LoadBalancerPolicyPolicyAttributeArgs{
					Name:  pulumi.String("PublicKeyPolicyName"),
					Value: pulumi.Any(aws_load_balancer_policy.Wu - tang - root - ca - pubkey - policy.Policy_name),
				},
			},
		})
		if err != nil {
			return err
		}
		_, err = elb.NewLoadBalancerBackendServerPolicy(ctx, "wu-tang-backend-auth-policies-443", &elb.LoadBalancerBackendServerPolicyArgs{
			LoadBalancerName: wu_tang.Name,
			InstancePort:     pulumi.Int(443),
			PolicyNames: pulumi.StringArray{
				wu_tang_root_ca_backend_auth_policy.PolicyName,
			},
		})
		if err != nil {
			return err
		}
		return nil
	})
}
```

</details>

## [*partial failure*] Application Load Balancer

### HCL

```terraform
resource "aws_lb" "test" {
  name               = "test-lb-tf"
  internal           = false
  load_balancer_type = "application"
  security_groups    = [aws_security_group.lb_sg.id]
  subnets            = [for subnet in aws_subnet.public : subnet.id]

  enable_deletion_protection = true

  access_logs {
    bucket  = aws_s3_bucket.lb_logs.bucket
    prefix  = "test-lb"
    enabled = true
  }

  tags = {
    Environment = "production"
  }
}

```

### Failed Languages

#### java

```text
<nil>: not yet implemented: ForExpression; not yet implemented: ForExpression
```

#### csharp

```text
<nil>: not yet implemented: ForExpression; not yet implemented: ForExpression
```

#### go

```text
<nil>: not yet implemented: For expression; not yet implemented: For expression
```

#### yaml

```text
.pp:4,24-69: Failed to generate YAML program: For; Pulumi YAML cannot represent for loops.If the values of the for loop are known, you can manually unroll the loop, otherwise it is necessary to switch to a more expressive language.
```

### Successes

<details>

<summary>typescript</summary>

```typescript
import * as pulumi from "@pulumi/pulumi";
import * as aws from "@pulumi/aws";

const test = new aws.lb.LoadBalancer("test", {
    internal: false,
    loadBalancerType: "application",
    securityGroups: [aws_security_group.lb_sg.id],
    subnets: .map(subnet => subnet.id),
    enableDeletionProtection: true,
    accessLogs: {
        bucket: aws_s3_bucket.lb_logs.bucket,
        prefix: "test-lb",
        enabled: true,
    },
    tags: {
        Environment: "production",
    },
});
```

</details>

<details>

<summary>python</summary>

```python
import pulumi
import pulumi_aws as aws

test = aws.lb.LoadBalancer("test",
    internal=False,
    load_balancer_type="application",
    security_groups=[aws_security_group["lb_sg"]["id"]],
    subnets=[subnet["id"] for subnet in aws_subnet["public"]],
    enable_deletion_protection=True,
    access_logs=aws.lb.LoadBalancerAccessLogsArgs(
        bucket=aws_s3_bucket["lb_logs"]["bucket"],
        prefix="test-lb",
        enabled=True,
    ),
    tags={
        "Environment": "production",
    })
```

</details>

## [*partial failure*] Network Load Balancer

### HCL

```terraform
resource "aws_lb" "test" {
  name               = "test-lb-tf"
  internal           = false
  load_balancer_type = "network"
  subnets            = [for subnet in aws_subnet.public : subnet.id]

  enable_deletion_protection = true

  tags = {
    Environment = "production"
  }
}

```

### Failed Languages

#### csharp

```text
<nil>: not yet implemented: ForExpression; not yet implemented: ForExpression
```

#### go

```text
<nil>: not yet implemented: For expression; not yet implemented: For expression
```

#### yaml

```text
.pp:3,24-69: Failed to generate YAML program: For; Pulumi YAML cannot represent for loops.If the values of the for loop are known, you can manually unroll the loop, otherwise it is necessary to switch to a more expressive language.
```

#### java

```text
<nil>: not yet implemented: ForExpression; not yet implemented: ForExpression
```

### Successes

<details>

<summary>typescript</summary>

```typescript
import * as pulumi from "@pulumi/pulumi";
import * as aws from "@pulumi/aws";

const test = new aws.lb.LoadBalancer("test", {
    internal: false,
    loadBalancerType: "network",
    subnets: .map(subnet => subnet.id),
    enableDeletionProtection: true,
    tags: {
        Environment: "production",
    },
});
```

</details>

<details>

<summary>python</summary>

```python
import pulumi
import pulumi_aws as aws

test = aws.lb.LoadBalancer("test",
    internal=False,
    load_balancer_type="network",
    subnets=[subnet["id"] for subnet in aws_subnet["public"]],
    enable_deletion_protection=True,
    tags={
        "Environment": "production",
    })
```

</details>

## [*partial failure*] Stateful Inspection for permitting packets from a source IP address

### HCL

```terraform
resource "aws_networkfirewall_rule_group" "example" {
  capacity    = 50
  description = "Permits http traffic from source"
  name        = "example"
  type        = "STATEFUL"
  rule_group {
    rules_source {
      dynamic "stateful_rule" {
        for_each = local.ips
        content {
          action = "PASS"
          header {
            destination      = "ANY"
            destination_port = "ANY"
            protocol         = "HTTP"
            direction        = "ANY"
            source_port      = "ANY"
            source           = stateful_rule.value
          }
          rule_option {
            keyword = "sid:1"
          }
        }
      }
    }
  }

  tags = {
    Name = "permit HTTP from source"
  }
}

locals {
  ips = ["1.1.1.1/32", "1.0.0.1/32"]
}

```

### Failed Languages

#### python

```text
:0,0-0: unknown property 'dynamic' among [rulesSourceList rulesString statefulRules statelessRulesAndCustomActions]; , and 4 other diagnostic(s)
```

#### csharp

```text
:0,0-0: unknown property 'dynamic' among [rulesString statefulRules statelessRulesAndCustomActions rulesSourceList]; , and 4 other diagnostic(s)
```

#### go

```text
:0,0-0: unknown property 'dynamic' among [rulesSourceList rulesString statefulRules statelessRulesAndCustomActions]; , and 4 other diagnostic(s)
```

#### typescript

```text
:0,0-0: unknown property 'dynamic' among [rulesSourceList rulesString statefulRules statelessRulesAndCustomActions]; , and 4 other diagnostic(s)
```

### Successes

<details>

<summary>yaml</summary>

```yaml
resources:
  example:
    type: aws:networkfirewall:RuleGroup
    properties:
      capacity: 50
      description: Permits http traffic from source
      type: STATEFUL
      ruleGroup:
        rulesSource:
          dynamic:
            - forEach: ${ips}
              content:
                - action: PASS
                  header:
                    - destination: ANY
                      destinationPort: ANY
                      protocol: HTTP
                      direction: ANY
                      sourcePort: ANY
                      source: ${stateful_rule.value}
                  ruleOption:
                    - keyword: sid:1
      tags:
        Name: permit HTTP from source
variables:
  ips:
    - 1.1.1.1/32
    - 1.0.0.1/32
```

</details>

<details>

<summary>java</summary>

```java
package generated_program;

import com.pulumi.Context;
import com.pulumi.Pulumi;
import com.pulumi.core.Output;
import com.pulumi.aws.networkfirewall.RuleGroup;
import com.pulumi.aws.networkfirewall.RuleGroupArgs;
import com.pulumi.aws.networkfirewall.inputs.RuleGroupRuleGroupArgs;
import com.pulumi.aws.networkfirewall.inputs.RuleGroupRuleGroupRulesSourceArgs;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;

public class App {
    public static void main(String[] args) {
        Pulumi.run(App::stack);
    }

    public static void stack(Context ctx) {
        final var ips =         
            "1.1.1.1/32",
            "1.0.0.1/32";

        var example = new RuleGroup("example", RuleGroupArgs.builder()        
            .capacity(50)
            .description("Permits http traffic from source")
            .type("STATEFUL")
            .ruleGroup(RuleGroupRuleGroupArgs.builder()
                .rulesSource(RuleGroupRuleGroupRulesSourceArgs.builder()
                    .dynamic(%!v(PANIC=Format method: runtime error: invalid memory address or nil pointer dereference))
                    .build())
                .build())
            .tags(Map.of("Name", "permit HTTP from source"))
            .build());

    }
}
```

</details>

## [*partial failure*] Stateful Inspection for blocking packets from going to an intended destination

### HCL

```terraform
resource "aws_networkfirewall_rule_group" "example" {
  capacity = 100
  name     = "example"
  type     = "STATEFUL"
  rule_group {
    rules_source {
      stateful_rule {
        action = "DROP"
        header {
          destination      = "124.1.1.24/32"
          destination_port = 53
          direction        = "ANY"
          protocol         = "TCP"
          source           = "1.2.3.4/32"
          source_port      = 53
        }
        rule_option {
          keyword = "sid:1"
        }
      }
    }
  }

  tags = {
    Tag1 = "Value1"
    Tag2 = "Value2"
  }
}

```

### Failed Languages

#### python

```text
:0,0-0: unknown property 'statefulRule' among [statefulRules statelessRulesAndCustomActions rulesSourceList rulesString]; , and 4 other diagnostic(s)
```

#### csharp

```text
:0,0-0: unknown property 'statefulRule' among [rulesSourceList rulesString statefulRules statelessRulesAndCustomActions]; , and 4 other diagnostic(s)
```

#### go

```text
:0,0-0: unknown property 'statefulRule' among [rulesSourceList rulesString statefulRules statelessRulesAndCustomActions]; , and 4 other diagnostic(s)
```

### Successes

<details>

<summary>typescript</summary>

```typescript
import * as pulumi from "@pulumi/pulumi";
import * as aws from "@pulumi/aws";

const example = new aws.networkfirewall.RuleGroup("example", {
    capacity: 100,
    ruleGroup: {
        rulesSource: {
            statefulRules: [{
                action: "DROP",
                header: {
                    destination: "124.1.1.24/32",
                    destinationPort: "53",
                    direction: "ANY",
                    protocol: "TCP",
                    source: "1.2.3.4/32",
                    sourcePort: "53",
                },
                ruleOptions: [{
                    keyword: "sid:1",
                }],
            }],
        },
    },
    tags: {
        Tag1: "Value1",
        Tag2: "Value2",
    },
    type: "STATEFUL",
});
```

</details>

<details>

<summary>yaml</summary>

```yaml
resources:
  example:
    type: aws:networkfirewall:RuleGroup
    properties:
      capacity: 100
      ruleGroup:
        rulesSource:
          statefulRule:
            - action: DROP
              header:
                destination: 124.1.1.24/32
                destinationPort: 53
                direction: ANY
                protocol: TCP
                source: 1.2.3.4/32
                sourcePort: 53
              ruleOption:
                - keyword: sid:1
      tags:
        Tag1: Value1
        Tag2: Value2
      type: STATEFUL
```

</details>

<details>

<summary>java</summary>

```java
package generated_program;

import com.pulumi.Context;
import com.pulumi.Pulumi;
import com.pulumi.core.Output;
import com.pulumi.aws.networkfirewall.RuleGroup;
import com.pulumi.aws.networkfirewall.RuleGroupArgs;
import com.pulumi.aws.networkfirewall.inputs.RuleGroupRuleGroupArgs;
import com.pulumi.aws.networkfirewall.inputs.RuleGroupRuleGroupRulesSourceArgs;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;

public class App {
    public static void main(String[] args) {
        Pulumi.run(App::stack);
    }

    public static void stack(Context ctx) {
        var example = new RuleGroup("example", RuleGroupArgs.builder()        
            .capacity(100)
            .ruleGroup(RuleGroupRuleGroupArgs.builder()
                .rulesSource(RuleGroupRuleGroupRulesSourceArgs.builder()
                    .statefulRule(%!v(PANIC=Format method: runtime error: invalid memory address or nil pointer dereference))
                    .build())
                .build())
            .tags(Map.ofEntries(
                Map.entry("Tag1", "Value1"),
                Map.entry("Tag2", "Value2")
            ))
            .type("STATEFUL")
            .build());

    }
}
```

</details>

## [*partial failure*] Stateful Inspection from rules specifications defined in Suricata flat format

### HCL

```terraform
resource "aws_networkfirewall_rule_group" "example" {
  capacity = 100
  name     = "example"
  type     = "STATEFUL"
  rules    = file("example.rules")

  tags = {
    Tag1 = "Value1"
    Tag2 = "Value2"
  }
}

```

### Failed Languages

#### yaml

```text
.pp:3,14-39: Failed to generate YAML program: Unknown Function; YAML does not support Fn::readFile.
```

### Successes

<details>

<summary>csharp</summary>

```csharp
using System.Collections.Generic;
using System.IO;
using Pulumi;
using Aws = Pulumi.Aws;

return await Deployment.RunAsync(() => 
{
    var example = new Aws.NetworkFirewall.RuleGroup("example", new()
    {
        Capacity = 100,
        Type = "STATEFUL",
        Rules = File.ReadAllText("example.rules"),
        Tags = 
        {
            { "Tag1", "Value1" },
            { "Tag2", "Value2" },
        },
    });

});
```

</details>

<details>

<summary>go</summary>

```go
package main

import (
	"io/ioutil"

	"github.com/pulumi/pulumi-aws/sdk/v5/go/aws/networkfirewall"
	"github.com/pulumi/pulumi/sdk/v3/go/pulumi"
)

func readFileOrPanic(path string) pulumi.StringPtrInput {
	data, err := ioutil.ReadFile(path)
	if err != nil {
		panic(err.Error())
	}
	return pulumi.String(string(data))
}

func main() {
	pulumi.Run(func(ctx *pulumi.Context) error {
		_, err := networkfirewall.NewRuleGroup(ctx, "example", &networkfirewall.RuleGroupArgs{
			Capacity: pulumi.Int(100),
			Type:     pulumi.String("STATEFUL"),
			Rules:    readFileOrPanic("example.rules"),
			Tags: pulumi.StringMap{
				"Tag1": pulumi.String("Value1"),
				"Tag2": pulumi.String("Value2"),
			},
		})
		if err != nil {
			return err
		}
		return nil
	})
}
```

</details>

<details>

<summary>java</summary>

```java
package generated_program;

import com.pulumi.Context;
import com.pulumi.Pulumi;
import com.pulumi.core.Output;
import com.pulumi.aws.networkfirewall.RuleGroup;
import com.pulumi.aws.networkfirewall.RuleGroupArgs;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;

public class App {
    public static void main(String[] args) {
        Pulumi.run(App::stack);
    }

    public static void stack(Context ctx) {
        var example = new RuleGroup("example", RuleGroupArgs.builder()        
            .capacity(100)
            .type("STATEFUL")
            .rules(Files.readString(Paths.get("example.rules")))
            .tags(Map.ofEntries(
                Map.entry("Tag1", "Value1"),
                Map.entry("Tag2", "Value2")
            ))
            .build());

    }
}
```

</details>

<details>

<summary>typescript</summary>

```typescript
import * as pulumi from "@pulumi/pulumi";
import * as aws from "@pulumi/aws";
import * as fs from "fs";

const example = new aws.networkfirewall.RuleGroup("example", {
    capacity: 100,
    type: "STATEFUL",
    rules: fs.readFileSync("example.rules"),
    tags: {
        Tag1: "Value1",
        Tag2: "Value2",
    },
});
```

</details>

<details>

<summary>python</summary>

```python
import pulumi
import pulumi_aws as aws

example = aws.networkfirewall.RuleGroup("example",
    capacity=100,
    type="STATEFUL",
    rules=(lambda path: open(path).read())("example.rules"),
    tags={
        "Tag1": "Value1",
        "Tag2": "Value2",
    })
```

</details>

## [*partial failure*] Stateful Inspection from rule group specifications using rule variables and Suricata format rules

### HCL

```terraform
resource "aws_networkfirewall_rule_group" "example" {
  capacity = 100
  name     = "example"
  type     = "STATEFUL"
  rule_group {
    rule_variables {
      ip_sets {
        key = "WEBSERVERS_HOSTS"
        ip_set {
          definition = ["10.0.0.0/16", "10.0.1.0/24", "192.168.0.0/16"]
        }
      }
      ip_sets {
        key = "EXTERNAL_HOST"
        ip_set {
          definition = ["1.2.3.4/32"]
        }
      }
      port_sets {
        key = "HTTP_PORTS"
        port_set {
          definition = ["443", "80"]
        }
      }
    }
    rules_source {
      rules_string = file("suricata_rules_file")
    }
  }
  tags = {
    Tag1 = "Value1"
    Tag2 = "Value2"
  }
}

```

### Failed Languages

#### yaml

```text
.pp:25,21-52: Failed to generate YAML program: Unknown Function; YAML does not support Fn::readFile.
```

### Successes

<details>

<summary>go</summary>

```go
package main

import (
	"io/ioutil"

	"github.com/pulumi/pulumi-aws/sdk/v5/go/aws/networkfirewall"
	"github.com/pulumi/pulumi/sdk/v3/go/pulumi"
)

func readFileOrPanic(path string) pulumi.StringPtrInput {
	data, err := ioutil.ReadFile(path)
	if err != nil {
		panic(err.Error())
	}
	return pulumi.String(string(data))
}

func main() {
	pulumi.Run(func(ctx *pulumi.Context) error {
		_, err := networkfirewall.NewRuleGroup(ctx, "example", &networkfirewall.RuleGroupArgs{
			Capacity: pulumi.Int(100),
			Type:     pulumi.String("STATEFUL"),
			RuleGroup: &networkfirewall.RuleGroupRuleGroupArgs{
				RuleVariables: &networkfirewall.RuleGroupRuleGroupRuleVariablesArgs{
					IpSets: networkfirewall.RuleGroupRuleGroupRuleVariablesIpSetArray{
						&networkfirewall.RuleGroupRuleGroupRuleVariablesIpSetArgs{
							Key: pulumi.String("WEBSERVERS_HOSTS"),
							IpSet: &networkfirewall.RuleGroupRuleGroupRuleVariablesIpSetIpSetArgs{
								Definitions: pulumi.StringArray{
									pulumi.String("10.0.0.0/16"),
									pulumi.String("10.0.1.0/24"),
									pulumi.String("192.168.0.0/16"),
								},
							},
						},
						&networkfirewall.RuleGroupRuleGroupRuleVariablesIpSetArgs{
							Key: pulumi.String("EXTERNAL_HOST"),
							IpSet: &networkfirewall.RuleGroupRuleGroupRuleVariablesIpSetIpSetArgs{
								Definitions: pulumi.StringArray{
									pulumi.String("1.2.3.4/32"),
								},
							},
						},
					},
					PortSets: networkfirewall.RuleGroupRuleGroupRuleVariablesPortSetArray{
						&networkfirewall.RuleGroupRuleGroupRuleVariablesPortSetArgs{
							Key: pulumi.String("HTTP_PORTS"),
							PortSet: &networkfirewall.RuleGroupRuleGroupRuleVariablesPortSetPortSetArgs{
								Definitions: pulumi.StringArray{
									pulumi.String("443"),
									pulumi.String("80"),
								},
							},
						},
					},
				},
				RulesSource: &networkfirewall.RuleGroupRuleGroupRulesSourceArgs{
					RulesString: readFileOrPanic("suricata_rules_file"),
				},
			},
			Tags: pulumi.StringMap{
				"Tag1": pulumi.String("Value1"),
				"Tag2": pulumi.String("Value2"),
			},
		})
		if err != nil {
			return err
		}
		return nil
	})
}
```

</details>

<details>

<summary>java</summary>

```java
package generated_program;

import com.pulumi.Context;
import com.pulumi.Pulumi;
import com.pulumi.core.Output;
import com.pulumi.aws.networkfirewall.RuleGroup;
import com.pulumi.aws.networkfirewall.RuleGroupArgs;
import com.pulumi.aws.networkfirewall.inputs.RuleGroupRuleGroupArgs;
import com.pulumi.aws.networkfirewall.inputs.RuleGroupRuleGroupRuleVariablesArgs;
import com.pulumi.aws.networkfirewall.inputs.RuleGroupRuleGroupRulesSourceArgs;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;

public class App {
    public static void main(String[] args) {
        Pulumi.run(App::stack);
    }

    public static void stack(Context ctx) {
        var example = new RuleGroup("example", RuleGroupArgs.builder()        
            .capacity(100)
            .type("STATEFUL")
            .ruleGroup(RuleGroupRuleGroupArgs.builder()
                .ruleVariables(RuleGroupRuleGroupRuleVariablesArgs.builder()
                    .ipSets(                    
                        RuleGroupRuleGroupRuleVariablesIpSetArgs.builder()
                            .key("WEBSERVERS_HOSTS")
                            .ipSet(RuleGroupRuleGroupRuleVariablesIpSetIpSetArgs.builder()
                                .definitions(                                
                                    "10.0.0.0/16",
                                    "10.0.1.0/24",
                                    "192.168.0.0/16")
                                .build())
                            .build(),
                        RuleGroupRuleGroupRuleVariablesIpSetArgs.builder()
                            .key("EXTERNAL_HOST")
                            .ipSet(RuleGroupRuleGroupRuleVariablesIpSetIpSetArgs.builder()
                                .definitions("1.2.3.4/32")
                                .build())
                            .build())
                    .portSets(RuleGroupRuleGroupRuleVariablesPortSetArgs.builder()
                        .key("HTTP_PORTS")
                        .portSet(RuleGroupRuleGroupRuleVariablesPortSetPortSetArgs.builder()
                            .definitions(                            
                                "443",
                                "80")
                            .build())
                        .build())
                    .build())
                .rulesSource(RuleGroupRuleGroupRulesSourceArgs.builder()
                    .rulesString(Files.readString(Paths.get("suricata_rules_file")))
                    .build())
                .build())
            .tags(Map.ofEntries(
                Map.entry("Tag1", "Value1"),
                Map.entry("Tag2", "Value2")
            ))
            .build());

    }
}
```

</details>

<details>

<summary>typescript</summary>

```typescript
import * as pulumi from "@pulumi/pulumi";
import * as aws from "@pulumi/aws";
import * as fs from "fs";

const example = new aws.networkfirewall.RuleGroup("example", {
    capacity: 100,
    type: "STATEFUL",
    ruleGroup: {
        ruleVariables: {
            ipSets: [
                {
                    key: "WEBSERVERS_HOSTS",
                    ipSet: {
                        definitions: [
                            "10.0.0.0/16",
                            "10.0.1.0/24",
                            "192.168.0.0/16",
                        ],
                    },
                },
                {
                    key: "EXTERNAL_HOST",
                    ipSet: {
                        definitions: ["1.2.3.4/32"],
                    },
                },
            ],
            portSets: [{
                key: "HTTP_PORTS",
                portSet: {
                    definitions: [
                        "443",
                        "80",
                    ],
                },
            }],
        },
        rulesSource: {
            rulesString: fs.readFileSync("suricata_rules_file"),
        },
    },
    tags: {
        Tag1: "Value1",
        Tag2: "Value2",
    },
});
```

</details>

<details>

<summary>python</summary>

```python
import pulumi
import pulumi_aws as aws

example = aws.networkfirewall.RuleGroup("example",
    capacity=100,
    type="STATEFUL",
    rule_group=aws.networkfirewall.RuleGroupRuleGroupArgs(
        rule_variables=aws.networkfirewall.RuleGroupRuleGroupRuleVariablesArgs(
            ip_sets=[
                aws.networkfirewall.RuleGroupRuleGroupRuleVariablesIpSetArgs(
                    key="WEBSERVERS_HOSTS",
                    ip_set=aws.networkfirewall.RuleGroupRuleGroupRuleVariablesIpSetIpSetArgs(
                        definitions=[
                            "10.0.0.0/16",
                            "10.0.1.0/24",
                            "192.168.0.0/16",
                        ],
                    ),
                ),
                aws.networkfirewall.RuleGroupRuleGroupRuleVariablesIpSetArgs(
                    key="EXTERNAL_HOST",
                    ip_set=aws.networkfirewall.RuleGroupRuleGroupRuleVariablesIpSetIpSetArgs(
                        definitions=["1.2.3.4/32"],
                    ),
                ),
            ],
            port_sets=[aws.networkfirewall.RuleGroupRuleGroupRuleVariablesPortSetArgs(
                key="HTTP_PORTS",
                port_set=aws.networkfirewall.RuleGroupRuleGroupRuleVariablesPortSetPortSetArgs(
                    definitions=[
                        "443",
                        "80",
                    ],
                ),
            )],
        ),
        rules_source=aws.networkfirewall.RuleGroupRuleGroupRulesSourceArgs(
            rules_string=(lambda path: open(path).read())("suricata_rules_file"),
        ),
    ),
    tags={
        "Tag1": "Value1",
        "Tag2": "Value2",
    })
```

</details>

<details>

<summary>csharp</summary>

```csharp
using System.Collections.Generic;
using System.IO;
using Pulumi;
using Aws = Pulumi.Aws;

return await Deployment.RunAsync(() => 
{
    var example = new Aws.NetworkFirewall.RuleGroup("example", new()
    {
        Capacity = 100,
        Type = "STATEFUL",
        RuleGroupConfiguration = new Aws.NetworkFirewall.Inputs.RuleGroupRuleGroupArgs
        {
            RuleVariables = new Aws.NetworkFirewall.Inputs.RuleGroupRuleGroupRuleVariablesArgs
            {
                IpSets = new[]
                {
                    new Aws.NetworkFirewall.Inputs.RuleGroupRuleGroupRuleVariablesIpSetArgs
                    {
                        Key = "WEBSERVERS_HOSTS",
                        IpSet = new Aws.NetworkFirewall.Inputs.RuleGroupRuleGroupRuleVariablesIpSetIpSetArgs
                        {
                            Definitions = new[]
                            {
                                "10.0.0.0/16",
                                "10.0.1.0/24",
                                "192.168.0.0/16",
                            },
                        },
                    },
                    new Aws.NetworkFirewall.Inputs.RuleGroupRuleGroupRuleVariablesIpSetArgs
                    {
                        Key = "EXTERNAL_HOST",
                        IpSet = new Aws.NetworkFirewall.Inputs.RuleGroupRuleGroupRuleVariablesIpSetIpSetArgs
                        {
                            Definitions = new[]
                            {
                                "1.2.3.4/32",
                            },
                        },
                    },
                },
                PortSets = new[]
                {
                    new Aws.NetworkFirewall.Inputs.RuleGroupRuleGroupRuleVariablesPortSetArgs
                    {
                        Key = "HTTP_PORTS",
                        PortSet = new Aws.NetworkFirewall.Inputs.RuleGroupRuleGroupRuleVariablesPortSetPortSetArgs
                        {
                            Definitions = new[]
                            {
                                "443",
                                "80",
                            },
                        },
                    },
                },
            },
            RulesSource = new Aws.NetworkFirewall.Inputs.RuleGroupRuleGroupRulesSourceArgs
            {
                RulesString = File.ReadAllText("suricata_rules_file"),
            },
        },
        Tags = 
        {
            { "Tag1", "Value1" },
            { "Tag2", "Value2" },
        },
    });

});
```

</details>

## [*partial failure*] Stateless Inspection with a Custom Action

### HCL

```terraform
resource "aws_networkfirewall_rule_group" "example" {
  description = "Stateless Rate Limiting Rule"
  capacity    = 100
  name        = "example"
  type        = "STATELESS"
  rule_group {
    rules_source {
      stateless_rules_and_custom_actions {
        custom_action {
          action_definition {
            publish_metric_action {
              dimension {
                value = "2"
              }
            }
          }
          action_name = "ExampleMetricsAction"
        }
        stateless_rule {
          priority = 1
          rule_definition {
            actions = ["aws:pass", "ExampleMetricsAction"]
            match_attributes {
              source {
                address_definition = "1.2.3.4/32"
              }
              source_port {
                from_port = 443
                to_port   = 443
              }
              destination {
                address_definition = "124.1.1.5/32"
              }
              destination_port {
                from_port = 443
                to_port   = 443
              }
              protocols = [6]
              tcp_flag {
                flags = ["SYN"]
                masks = ["SYN", "ACK"]
              }
            }
          }
        }
      }
    }
  }

  tags = {
    Tag1 = "Value1"
    Tag2 = "Value2"
  }
}

```

### Failed Languages

#### python

```text
:0,0-0: unknown property 'customAction' among [customActions statelessRules]; , and 9 other diagnostic(s)
```

#### csharp

```text
:0,0-0: unknown property 'customAction' among [customActions statelessRules]; , and 9 other diagnostic(s)
```

#### go

```text
:0,0-0: unknown property 'customAction' among [customActions statelessRules]; , and 9 other diagnostic(s)
```

### Successes

<details>

<summary>yaml</summary>

```yaml
resources:
  example:
    type: aws:networkfirewall:RuleGroup
    properties:
      capacity: 100
      description: Stateless Rate Limiting Rule
      ruleGroup:
        rulesSource:
          statelessRulesAndCustomActions:
            customAction:
              - actionDefinition:
                  publishMetricAction:
                    dimension:
                      - value: 2
                actionName: ExampleMetricsAction
            statelessRule:
              - priority: 1
                ruleDefinition:
                  actions:
                    - aws:pass
                    - ExampleMetricsAction
                  matchAttributes:
                    destination:
                      - addressDefinition: 124.1.1.5/32
                    destinationPort:
                      - fromPort: 443
                        toPort: 443
                    protocols:
                      - 6
                    source:
                      - addressDefinition: 1.2.3.4/32
                    sourcePort:
                      - fromPort: 443
                        toPort: 443
                    tcpFlag:
                      - flags:
                          - SYN
                        masks:
                          - SYN
                          - ACK
      tags:
        Tag1: Value1
        Tag2: Value2
      type: STATELESS
```

</details>

<details>

<summary>java</summary>

```java
package generated_program;

import com.pulumi.Context;
import com.pulumi.Pulumi;
import com.pulumi.core.Output;
import com.pulumi.aws.networkfirewall.RuleGroup;
import com.pulumi.aws.networkfirewall.RuleGroupArgs;
import com.pulumi.aws.networkfirewall.inputs.RuleGroupRuleGroupArgs;
import com.pulumi.aws.networkfirewall.inputs.RuleGroupRuleGroupRulesSourceArgs;
import com.pulumi.aws.networkfirewall.inputs.RuleGroupRuleGroupRulesSourceStatelessRulesAndCustomActionsArgs;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;

public class App {
    public static void main(String[] args) {
        Pulumi.run(App::stack);
    }

    public static void stack(Context ctx) {
        var example = new RuleGroup("example", RuleGroupArgs.builder()        
            .capacity(100)
            .description("Stateless Rate Limiting Rule")
            .ruleGroup(RuleGroupRuleGroupArgs.builder()
                .rulesSource(RuleGroupRuleGroupRulesSourceArgs.builder()
                    .statelessRulesAndCustomActions(RuleGroupRuleGroupRulesSourceStatelessRulesAndCustomActionsArgs.builder()
                        .customAction(%!v(PANIC=Format method: runtime error: invalid memory address or nil pointer dereference))
                        .statelessRule(%!v(PANIC=Format method: runtime error: invalid memory address or nil pointer dereference))
                        .build())
                    .build())
                .build())
            .tags(Map.ofEntries(
                Map.entry("Tag1", "Value1"),
                Map.entry("Tag2", "Value2")
            ))
            .type("STATELESS")
            .build());

    }
}
```

</details>

<details>

<summary>typescript</summary>

```typescript
import * as pulumi from "@pulumi/pulumi";
import * as aws from "@pulumi/aws";

const example = new aws.networkfirewall.RuleGroup("example", {
    capacity: 100,
    description: "Stateless Rate Limiting Rule",
    ruleGroup: {
        rulesSource: {
            statelessRulesAndCustomActions: {
                customActions: [{
                    actionDefinition: {
                        publishMetricAction: {
                            dimensions: [{
                                value: "2",
                            }],
                        },
                    },
                    actionName: "ExampleMetricsAction",
                }],
                statelessRules: [{
                    priority: 1,
                    ruleDefinition: {
                        actions: [
                            "aws:pass",
                            "ExampleMetricsAction",
                        ],
                        matchAttributes: {
                            destinations: [{
                                addressDefinition: "124.1.1.5/32",
                            }],
                            destinationPorts: [{
                                fromPort: 443,
                                toPort: 443,
                            }],
                            protocols: [6],
                            sources: [{
                                addressDefinition: "1.2.3.4/32",
                            }],
                            sourcePorts: [{
                                fromPort: 443,
                                toPort: 443,
                            }],
                            tcpFlags: [{
                                flags: ["SYN"],
                                masks: [
                                    "SYN",
                                    "ACK",
                                ],
                            }],
                        },
                    },
                }],
            },
        },
    },
    tags: {
        Tag1: "Value1",
        Tag2: "Value2",
    },
    type: "STATELESS",
});
```

</details>

## [*partial failure*] #/resources/aws:ec2/vpcIpamPoolCidr:VpcIpamPoolCidr

### HCL

```terraform
data "aws_region" "current" {}

resource "aws_vpc_ipam" "example" {
  operating_regions {
    region_name = data.aws_region.current.name
  }
}

resource "aws_vpc_ipam_pool" "ipv6_test_public" {
  address_family = "ipv6"
  ipam_scope_id  = aws_vpc_ipam.example.public_default_scope_id
  locale         = "us-east-1"
  description    = "public ipv6"
  advertisable   = false
  aws_service    = "ec2"
}

resource "aws_vpc_ipam_pool_cidr" "ipv6_test_public" {
  ipam_pool_id = aws_vpc_ipam_pool.ipv6_test_public.id
  cidr         = var.ipv6_cidr
  cidr_authorization_context {
    message   = var.message
    signature = var.signature
  }
}

```

### Failed Languages

#### go

```text
:0,0-0: unknown property 'advertisable' among [allocationDefaultNetmaskLength allocationMinNetmaskLength locale publiclyAdvertisable sourceIpamPoolId ipamScopeId tags addressFamily allocationMaxNetmaskLength allocationResourceTags autoImport awsService description]; 
```

#### typescript

```text
:0,0-0: unknown property 'advertisable' among [allocationMinNetmaskLength allocationResourceTags ipamScopeId locale publiclyAdvertisable addressFamily allocationDefaultNetmaskLength awsService description sourceIpamPoolId tags allocationMaxNetmaskLength autoImport]; 
```

#### python

```text
:0,0-0: unknown property 'advertisable' among [addressFamily allocationDefaultNetmaskLength allocationMinNetmaskLength awsService ipamScopeId allocationMaxNetmaskLength allocationResourceTags autoImport description locale publiclyAdvertisable sourceIpamPoolId tags]; 
```

#### csharp

```text
:0,0-0: unknown property 'advertisable' among [sourceIpamPoolId tags allocationDefaultNetmaskLength ipamScopeId locale publiclyAdvertisable autoImport awsService description addressFamily allocationMaxNetmaskLength allocationMinNetmaskLength allocationResourceTags]; 
```

### Successes

<details>

<summary>yaml</summary>

```yaml
resources:
  example:
    type: aws:ec2:VpcIpam
    properties:
      operatingRegions:
        - regionName: ${current.name}
  ipv6TestPublicVpcIpamPool:
    type: aws:ec2:VpcIpamPool
    properties:
      addressFamily: ipv6
      ipamScopeId: ${example.publicDefaultScopeId}
      locale: us-east-1
      description: public ipv6
      advertisable: false
      awsService: ec2
  ipv6TestPublicVpcIpamPoolCidr:
    type: aws:ec2:VpcIpamPoolCidr
    properties:
      ipamPoolId: ${ipv6TestPublicVpcIpamPool.id}
      cidr: ${var.ipv6_cidr}
      cidrAuthorizationContext:
        message: ${var.message}
        signature: ${var.signature}
variables:
  current:
    Fn::Invoke:
      Function: aws:getRegion
      Arguments: {}
```

</details>

<details>

<summary>java</summary>

```java
package generated_program;

import com.pulumi.Context;
import com.pulumi.Pulumi;
import com.pulumi.core.Output;
import com.pulumi.aws.AwsFunctions;
import com.pulumi.aws.inputs.GetRegionArgs;
import com.pulumi.aws.ec2.VpcIpam;
import com.pulumi.aws.ec2.VpcIpamArgs;
import com.pulumi.aws.ec2.inputs.VpcIpamOperatingRegionArgs;
import com.pulumi.aws.ec2.VpcIpamPool;
import com.pulumi.aws.ec2.VpcIpamPoolArgs;
import com.pulumi.aws.ec2.VpcIpamPoolCidr;
import com.pulumi.aws.ec2.VpcIpamPoolCidrArgs;
import com.pulumi.aws.ec2.inputs.VpcIpamPoolCidrCidrAuthorizationContextArgs;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;

public class App {
    public static void main(String[] args) {
        Pulumi.run(App::stack);
    }

    public static void stack(Context ctx) {
        final var current = AwsFunctions.getRegion();

        var example = new VpcIpam("example", VpcIpamArgs.builder()        
            .operatingRegions(VpcIpamOperatingRegionArgs.builder()
                .regionName(current.applyValue(getRegionResult -> getRegionResult.name()))
                .build())
            .build());

        var ipv6TestPublicVpcIpamPool = new VpcIpamPool("ipv6TestPublicVpcIpamPool", VpcIpamPoolArgs.builder()        
            .addressFamily("ipv6")
            .ipamScopeId(example.publicDefaultScopeId())
            .locale("us-east-1")
            .description("public ipv6")
            .advertisable(false)
            .awsService("ec2")
            .build());

        var ipv6TestPublicVpcIpamPoolCidr = new VpcIpamPoolCidr("ipv6TestPublicVpcIpamPoolCidr", VpcIpamPoolCidrArgs.builder()        
            .ipamPoolId(ipv6TestPublicVpcIpamPool.id())
            .cidr(var_.ipv6_cidr())
            .cidrAuthorizationContext(VpcIpamPoolCidrCidrAuthorizationContextArgs.builder()
                .message(var_.message())
                .signature(var_.signature())
                .build())
            .build());

    }
}
```

</details>

## [*partial failure*] OAuth Authorization

### HCL

```terraform
resource "aws_cloudwatch_event_connection" "test" {
  name               = "ngrok-connection"
  description        = "A connection description"
  authorization_type = "OAUTH_CLIENT_CREDENTIALS"

  auth_parameters {
    oauth {
      authorization_endpoint = "https://auth.url.com/endpoint"
      http_method            = "GET"

      client_parameters {
        client_id     = "1234567890"
        client_secret = "Pass1234!"
      }

      oauth_http_parameters {
        body {
          key             = "body-parameter-key"
          value           = "body-parameter-value"
          is_value_secret = false
        }

        header {
          key             = "header-parameter-key"
          value           = "header-parameter-value"
          is_value_secret = false
        }

        query_string {
          key             = "query-string-parameter-key"
          value           = "query-string-parameter-value"
          is_value_secret = false
        }
      }
    }
  }
}

```

### Failed Languages

#### csharp

```text
:0,0-0: unknown property 'body' among [bodies headers queryStrings]; , and 14 other diagnostic(s)
```

#### go

```text
:0,0-0: unknown property 'body' among [bodies headers queryStrings]; , and 14 other diagnostic(s)
```

#### python

```text
:0,0-0: unknown property 'body' among [bodies headers queryStrings]; , and 14 other diagnostic(s)
```

### Successes

<details>

<summary>java</summary>

```java
package generated_program;

import com.pulumi.Context;
import com.pulumi.Pulumi;
import com.pulumi.core.Output;
import com.pulumi.aws.cloudwatch.EventConnection;
import com.pulumi.aws.cloudwatch.EventConnectionArgs;
import com.pulumi.aws.cloudwatch.inputs.EventConnectionAuthParametersArgs;
import com.pulumi.aws.cloudwatch.inputs.EventConnectionAuthParametersOauthArgs;
import com.pulumi.aws.cloudwatch.inputs.EventConnectionAuthParametersOauthClientParametersArgs;
import com.pulumi.aws.cloudwatch.inputs.EventConnectionAuthParametersOauthOauthHttpParametersArgs;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;

public class App {
    public static void main(String[] args) {
        Pulumi.run(App::stack);
    }

    public static void stack(Context ctx) {
        var test = new EventConnection("test", EventConnectionArgs.builder()        
            .authParameters(EventConnectionAuthParametersArgs.builder()
                .oauth(EventConnectionAuthParametersOauthArgs.builder()
                    .authorizationEndpoint("https://auth.url.com/endpoint")
                    .clientParameters(EventConnectionAuthParametersOauthClientParametersArgs.builder()
                        .clientId("1234567890")
                        .clientSecret("Pass1234!")
                        .build())
                    .httpMethod("GET")
                    .oauthHttpParameters(EventConnectionAuthParametersOauthOauthHttpParametersArgs.builder()
                        .body(%!v(PANIC=Format method: runtime error: invalid memory address or nil pointer dereference))
                        .header(%!v(PANIC=Format method: runtime error: invalid memory address or nil pointer dereference))
                        .queryString(%!v(PANIC=Format method: runtime error: invalid memory address or nil pointer dereference))
                        .build())
                    .build())
                .build())
            .authorizationType("OAUTH_CLIENT_CREDENTIALS")
            .description("A connection description")
            .build());

    }
}
```

</details>

<details>

<summary>typescript</summary>

```typescript
import * as pulumi from "@pulumi/pulumi";
import * as aws from "@pulumi/aws";

const test = new aws.cloudwatch.EventConnection("test", {
    authParameters: {
        oauth: {
            authorizationEndpoint: "https://auth.url.com/endpoint",
            clientParameters: {
                clientId: "1234567890",
                clientSecret: "Pass1234!",
            },
            httpMethod: "GET",
            oauthHttpParameters: {
                bodies: [{
                    isValueSecret: false,
                    key: "body-parameter-key",
                    value: "body-parameter-value",
                }],
                headers: [{
                    isValueSecret: false,
                    key: "header-parameter-key",
                    value: "header-parameter-value",
                }],
                queryStrings: [{
                    isValueSecret: false,
                    key: "query-string-parameter-key",
                    value: "query-string-parameter-value",
                }],
            },
        },
    },
    authorizationType: "OAUTH_CLIENT_CREDENTIALS",
    description: "A connection description",
});
```

</details>

<details>

<summary>yaml</summary>

```yaml
resources:
  test:
    type: aws:cloudwatch:EventConnection
    properties:
      authParameters:
        oauth:
          authorizationEndpoint: https://auth.url.com/endpoint
          clientParameters:
            clientId: 1234567890
            clientSecret: Pass1234!
          httpMethod: GET
          oauthHttpParameters:
            body:
              - isValueSecret: false
                key: body-parameter-key
                value: body-parameter-value
            header:
              - isValueSecret: false
                key: header-parameter-key
                value: header-parameter-value
            queryString:
              - isValueSecret: false
                key: query-string-parameter-key
                value: query-string-parameter-value
      authorizationType: OAUTH_CLIENT_CREDENTIALS
      description: A connection description
```

</details>

## [*partial failure*] Invocation Http Parameters

### HCL

```terraform
resource "aws_cloudwatch_event_connection" "test" {
  name               = "ngrok-connection"
  description        = "A connection description"
  authorization_type = "BASIC"

  auth_parameters {
    basic {
      username = "user"
      password = "Pass1234!"
    }

    invocation_http_parameters {
      body {
        key             = "body-parameter-key"
        value           = "body-parameter-value"
        is_value_secret = false
      }

      body {
        key             = "body-parameter-key2"
        value           = "body-parameter-value2"
        is_value_secret = true
      }

      header {
        key             = "header-parameter-key"
        value           = "header-parameter-value"
        is_value_secret = false
      }

      query_string {
        key             = "query-string-parameter-key"
        value           = "query-string-parameter-value"
        is_value_secret = false
      }
    }
  }
}

```

### Failed Languages

#### python

```text
:0,0-0: unknown property 'body' among [bodies headers queryStrings]; , and 14 other diagnostic(s)
```

#### csharp

```text
:0,0-0: unknown property 'body' among [bodies headers queryStrings]; , and 14 other diagnostic(s)
```

#### go

```text
:0,0-0: unknown property 'body' among [bodies headers queryStrings]; , and 14 other diagnostic(s)
```

### Successes

<details>

<summary>yaml</summary>

```yaml
resources:
  test:
    type: aws:cloudwatch:EventConnection
    properties:
      authParameters:
        basic:
          password: Pass1234!
          username: user
        invocationHttpParameters:
          body:
            - isValueSecret: false
              key: body-parameter-key
              value: body-parameter-value
            - isValueSecret: true
              key: body-parameter-key2
              value: body-parameter-value2
          header:
            - isValueSecret: false
              key: header-parameter-key
              value: header-parameter-value
          queryString:
            - isValueSecret: false
              key: query-string-parameter-key
              value: query-string-parameter-value
      authorizationType: BASIC
      description: A connection description
```

</details>

<details>

<summary>java</summary>

```java
package generated_program;

import com.pulumi.Context;
import com.pulumi.Pulumi;
import com.pulumi.core.Output;
import com.pulumi.aws.cloudwatch.EventConnection;
import com.pulumi.aws.cloudwatch.EventConnectionArgs;
import com.pulumi.aws.cloudwatch.inputs.EventConnectionAuthParametersArgs;
import com.pulumi.aws.cloudwatch.inputs.EventConnectionAuthParametersBasicArgs;
import com.pulumi.aws.cloudwatch.inputs.EventConnectionAuthParametersInvocationHttpParametersArgs;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;

public class App {
    public static void main(String[] args) {
        Pulumi.run(App::stack);
    }

    public static void stack(Context ctx) {
        var test = new EventConnection("test", EventConnectionArgs.builder()        
            .authParameters(EventConnectionAuthParametersArgs.builder()
                .basic(EventConnectionAuthParametersBasicArgs.builder()
                    .password("Pass1234!")
                    .username("user")
                    .build())
                .invocationHttpParameters(EventConnectionAuthParametersInvocationHttpParametersArgs.builder()
                    .body(                    
                        %!v(PANIC=Format method: runtime error: invalid memory address or nil pointer dereference),
                        %!v(PANIC=Format method: runtime error: invalid memory address or nil pointer dereference))
                    .header(%!v(PANIC=Format method: runtime error: invalid memory address or nil pointer dereference))
                    .queryString(%!v(PANIC=Format method: runtime error: invalid memory address or nil pointer dereference))
                    .build())
                .build())
            .authorizationType("BASIC")
            .description("A connection description")
            .build());

    }
}
```

</details>

<details>

<summary>typescript</summary>

```typescript
import * as pulumi from "@pulumi/pulumi";
import * as aws from "@pulumi/aws";

const test = new aws.cloudwatch.EventConnection("test", {
    authParameters: {
        basic: {
            password: "Pass1234!",
            username: "user",
        },
        invocationHttpParameters: {
            bodies: [
                {
                    isValueSecret: false,
                    key: "body-parameter-key",
                    value: "body-parameter-value",
                },
                {
                    isValueSecret: true,
                    key: "body-parameter-key2",
                    value: "body-parameter-value2",
                },
            ],
            headers: [{
                isValueSecret: false,
                key: "header-parameter-key",
                value: "header-parameter-value",
            }],
            queryStrings: [{
                isValueSecret: false,
                key: "query-string-parameter-key",
                value: "query-string-parameter-value",
            }],
        },
    },
    authorizationType: "BASIC",
    description: "A connection description",
});
```

</details>

## [*partial failure*] Basic Example

### HCL

```terraform
data "aws_caller_identity" "current" {}
data "aws_partition" "current" {}

resource "aws_s3_bucket" "foo_bucket" {
  bucket = "example-bucket-foo"
}

resource "aws_s3control_multi_region_access_point" "example" {
  details {
    name = "example"

    region {
      bucket = aws_s3_bucket.foo_bucket.id
    }
  }
}

resource "aws_s3control_multi_region_access_point_policy" "example" {
  details {
    name = element(split(":", aws_s3control_multi_region_access_point.example.id), 1)
    policy = jsonencode({
      "Version" : "2012-10-17",
      "Statement" : [
        {
          "Sid" : "Example",
          "Effect" : "Allow",
          "Principal" : {
            "AWS" : data.aws_caller_identity.current.account_id
          },
          "Action" : ["s3:GetObject", "s3:PutObject"],
          "Resource" : "arn:${data.aws_partition.current.partition}:s3::${data.aws_caller_identity.current.account_id}:accesspoint/${aws_s3control_multi_region_access_point.example.alias}/object/*"
        }
      ]
    })
  }
}

```

### Failed Languages

#### go

```text
<nil>: not yet implemented: element; not yet implemented: element
```

### Successes

<details>

<summary>yaml</summary>

```yaml
resources:
  fooBucket:
    type: aws:s3:BucketV2
  exampleMultiRegionAccessPoint:
    type: aws:s3control:MultiRegionAccessPoint
    properties:
      details:
        name: example
        regions:
          - bucket: ${fooBucket.id}
  exampleMultiRegionAccessPointPolicy:
    type: aws:s3control:MultiRegionAccessPointPolicy
    properties:
      details:
        name:
          Fn::Select:
            - 1
            - Fn::Split:
                - ${exampleMultiRegionAccessPoint.id}
                - ':'
        policy:
          Fn::ToJSON:
            Version: 2012-10-17
            Statement:
              - Sid: Example
                Effect: Allow
                Principal:
                  AWS: ${currentCallerIdentity.accountId}
                Action:
                  - s3:GetObject
                  - s3:PutObject
                Resource: arn:${currentPartition.partition}:s3::${currentCallerIdentity.accountId}:accesspoint/${exampleMultiRegionAccessPoint.alias}/object/*
variables:
  currentCallerIdentity:
    Fn::Invoke:
      Function: aws:getCallerIdentity
      Arguments: {}
  currentPartition:
    Fn::Invoke:
      Function: aws:getPartition
      Arguments: {}
```

</details>

<details>

<summary>java</summary>

```java
package generated_program;

import com.pulumi.Context;
import com.pulumi.Pulumi;
import com.pulumi.core.Output;
import com.pulumi.aws.AwsFunctions;
import com.pulumi.aws.s3.BucketV2;
import com.pulumi.aws.s3control.MultiRegionAccessPoint;
import com.pulumi.aws.s3control.MultiRegionAccessPointArgs;
import com.pulumi.aws.s3control.inputs.MultiRegionAccessPointDetailsArgs;
import com.pulumi.aws.s3control.MultiRegionAccessPointPolicy;
import com.pulumi.aws.s3control.MultiRegionAccessPointPolicyArgs;
import com.pulumi.aws.s3control.inputs.MultiRegionAccessPointPolicyDetailsArgs;
import static com.pulumi.codegen.internal.Serialization.*;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;

public class App {
    public static void main(String[] args) {
        Pulumi.run(App::stack);
    }

    public static void stack(Context ctx) {
        final var currentCallerIdentity = AwsFunctions.getCallerIdentity();

        final var currentPartition = AwsFunctions.getPartition();

        var fooBucket = new BucketV2("fooBucket");

        var exampleMultiRegionAccessPoint = new MultiRegionAccessPoint("exampleMultiRegionAccessPoint", MultiRegionAccessPointArgs.builder()        
            .details(MultiRegionAccessPointDetailsArgs.builder()
                .name("example")
                .regions(MultiRegionAccessPointDetailsRegionArgs.builder()
                    .bucket(fooBucket.id())
                    .build())
                .build())
            .build());

        var exampleMultiRegionAccessPointPolicy = new MultiRegionAccessPointPolicy("exampleMultiRegionAccessPointPolicy", MultiRegionAccessPointPolicyArgs.builder()        
            .details(MultiRegionAccessPointPolicyDetailsArgs.builder()
                .name(exampleMultiRegionAccessPoint.id().applyValue(id -> id.split(":"))[1])
                .policy(exampleMultiRegionAccessPoint.alias().applyValue(alias -> serializeJson(
                    jsonObject(
                        jsonProperty("Version", "2012-10-17"),
                        jsonProperty("Statement", jsonArray(jsonObject(
                            jsonProperty("Sid", "Example"),
                            jsonProperty("Effect", "Allow"),
                            jsonProperty("Principal", jsonObject(
                                jsonProperty("AWS", currentCallerIdentity.applyValue(getCallerIdentityResult -> getCallerIdentityResult.accountId()))
                            )),
                            jsonProperty("Action", jsonArray(
                                "s3:GetObject", 
                                "s3:PutObject"
                            )),
                            jsonProperty("Resource", String.format("arn:%s:s3::%s:accesspoint/%s/object/*", currentPartition.applyValue(getPartitionResult -> getPartitionResult.partition()),currentCallerIdentity.applyValue(getCallerIdentityResult -> getCallerIdentityResult.accountId()),alias))
                        )))
                    ))))
                .build())
            .build());

    }
}
```

</details>

<details>

<summary>typescript</summary>

```typescript
import * as pulumi from "@pulumi/pulumi";
import * as aws from "@pulumi/aws";

const currentCallerIdentity = aws.getCallerIdentity({});
const currentPartition = aws.getPartition({});
const fooBucket = new aws.s3.BucketV2("fooBucket", {});
const exampleMultiRegionAccessPoint = new aws.s3control.MultiRegionAccessPoint("exampleMultiRegionAccessPoint", {details: {
    name: "example",
    regions: [{
        bucket: fooBucket.id,
    }],
}});
const exampleMultiRegionAccessPointPolicy = new aws.s3control.MultiRegionAccessPointPolicy("exampleMultiRegionAccessPointPolicy", {details: {
    name: exampleMultiRegionAccessPoint.id.apply(id => id.split(":"))[1],
    policy: pulumi.all([currentCallerIdentity, currentPartition, currentCallerIdentity, exampleMultiRegionAccessPoint.alias]).apply(([currentCallerIdentity, currentPartition, currentCallerIdentity1, alias]) => JSON.stringify({
        Version: "2012-10-17",
        Statement: [{
            Sid: "Example",
            Effect: "Allow",
            Principal: {
                AWS: currentCallerIdentity.accountId,
            },
            Action: [
                "s3:GetObject",
                "s3:PutObject",
            ],
            Resource: `arn:${currentPartition.partition}:s3::${currentCallerIdentity1.accountId}:accesspoint/${alias}/object/*`,
        }],
    })),
}});
```

</details>

<details>

<summary>python</summary>

```python
import pulumi
import json
import pulumi_aws as aws

current_caller_identity = aws.get_caller_identity()
current_partition = aws.get_partition()
foo_bucket = aws.s3.BucketV2("fooBucket")
example_multi_region_access_point = aws.s3control.MultiRegionAccessPoint("exampleMultiRegionAccessPoint", details=aws.s3control.MultiRegionAccessPointDetailsArgs(
    name="example",
    regions=[aws.s3control.MultiRegionAccessPointDetailsRegionArgs(
        bucket=foo_bucket.id,
    )],
))
example_multi_region_access_point_policy = aws.s3control.MultiRegionAccessPointPolicy("exampleMultiRegionAccessPointPolicy", details=aws.s3control.MultiRegionAccessPointPolicyDetailsArgs(
    name=example_multi_region_access_point.id.apply(lambda id: id.split(":"))[1],
    policy=example_multi_region_access_point.alias.apply(lambda alias: json.dumps({
        "Version": "2012-10-17",
        "Statement": [{
            "Sid": "Example",
            "Effect": "Allow",
            "Principal": {
                "AWS": current_caller_identity.account_id,
            },
            "Action": [
                "s3:GetObject",
                "s3:PutObject",
            ],
            "Resource": f"arn:{current_partition.partition}:s3::{current_caller_identity.account_id}:accesspoint/{alias}/object/*",
        }],
    })),
))
```

</details>

<details>

<summary>csharp</summary>

```csharp
using System.Collections.Generic;
using System.Text.Json;
using Pulumi;
using Aws = Pulumi.Aws;

return await Deployment.RunAsync(() => 
{
    var currentCallerIdentity = Aws.GetCallerIdentity.Invoke();

    var currentPartition = Aws.GetPartition.Invoke();

    var fooBucket = new Aws.S3.BucketV2("fooBucket");

    var exampleMultiRegionAccessPoint = new Aws.S3Control.MultiRegionAccessPoint("exampleMultiRegionAccessPoint", new()
    {
        Details = new Aws.S3Control.Inputs.MultiRegionAccessPointDetailsArgs
        {
            Name = "example",
            Regions = new[]
            {
                new Aws.S3Control.Inputs.MultiRegionAccessPointDetailsRegionArgs
                {
                    Bucket = fooBucket.Id,
                },
            },
        },
    });

    var exampleMultiRegionAccessPointPolicy = new Aws.S3Control.MultiRegionAccessPointPolicy("exampleMultiRegionAccessPointPolicy", new()
    {
        Details = new Aws.S3Control.Inputs.MultiRegionAccessPointPolicyDetailsArgs
        {
            Name = exampleMultiRegionAccessPoint.Id.Apply(id => id.Split(":"))[1],
            Policy = Output.Tuple(currentCallerIdentity.Apply(getCallerIdentityResult => getCallerIdentityResult), currentPartition.Apply(getPartitionResult => getPartitionResult), currentCallerIdentity.Apply(getCallerIdentityResult => getCallerIdentityResult), exampleMultiRegionAccessPoint.Alias).Apply(values =>
            {
                var currentCallerIdentity = values.Item1;
                var currentPartition = values.Item2;
                var currentCallerIdentity1 = values.Item3;
                var @alias = values.Item4;
                return JsonSerializer.Serialize(new Dictionary<string, object?>
                {
                    ["Version"] = "2012-10-17",
                    ["Statement"] = new[]
                    {
                        new Dictionary<string, object?>
                        {
                            ["Sid"] = "Example",
                            ["Effect"] = "Allow",
                            ["Principal"] = new Dictionary<string, object?>
                            {
                                ["AWS"] = currentCallerIdentity.Apply(getCallerIdentityResult => getCallerIdentityResult.AccountId),
                            },
                            ["Action"] = new[]
                            {
                                "s3:GetObject",
                                "s3:PutObject",
                            },
                            ["Resource"] = $"arn:{currentPartition.Apply(getPartitionResult => getPartitionResult.Partition)}:s3::{currentCallerIdentity1.AccountId}:accesspoint/{@alias}/object/*",
                        },
                    },
                });
            }),
        },
    });

});
```

</details>

## [**complete failure**] #/resources/aws:ssoadmin/accountAssignment:AccountAssignment

### HCL

```terraform
data "aws_ssoadmin_instances" "example" {}

data "aws_ssoadmin_permission_set" "example" {
  instance_arn = tolist(data.aws_ssoadmin_instances.example.arns)[0]
  name         = "AWSReadOnlyAccess"
}

data "aws_identitystore_group" "example" {
  identity_store_id = tolist(data.aws_ssoadmin_instances.example.identity_store_ids)[0]

  filter {
    attribute_path  = "DisplayName"
    attribute_value = "ExampleGroup"
  }
}

resource "aws_ssoadmin_account_assignment" "example" {
  instance_arn       = data.aws_ssoadmin_permission_set.example.instance_arn
  permission_set_arn = data.aws_ssoadmin_permission_set.example.arn

  principal_id   = data.aws_identitystore_group.example.group_id
  principal_type = "GROUP"

  target_id   = "012347678910"
  target_type = "AWS_ACCOUNT"
}

```

### Failed Languages

#### go

```text
:3,18-24: unknown function 'tolist'; , and 3 other diagnostic(s)
```

#### yaml

```text
:3,18-24: unknown function 'tolist'; , and 3 other diagnostic(s)
```

#### java

```text
:3,18-24: unknown function 'tolist'; , and 3 other diagnostic(s)
```

#### typescript

```text
:3,18-24: unknown function 'tolist'; , and 3 other diagnostic(s)
```

#### python

```text
:3,18-24: unknown function 'tolist'; , and 3 other diagnostic(s)
```

#### csharp

```text
:3,18-24: unknown function 'tolist'; , and 3 other diagnostic(s)
```

## [*partial failure*] #/resources/aws:ecrpublic/repository:Repository

### HCL

```terraform
provider "aws" {
  alias  = "us_east_1"
  region = "us-east-1"
}

resource "aws_ecrpublic_repository" "foo" {
  provider = aws.us_east_1

  repository_name = "bar"

  catalog_data {
    about_text        = "About Text"
    architectures     = ["ARM"]
    description       = "Description"
    logo_image_blob   = filebase64(image.png)
    operating_systems = ["Linux"]
    usage_text        = "Usage Text"
  }

  tags = {
    env = "production"
  }
}

```

### Failed Languages

#### yaml

```text
.pp:13,23-44: Failed to generate YAML program: Unknown Function; YAML does not support Fn::filebase64.
```

### Successes

<details>

<summary>csharp</summary>

```csharp
using System;
using System.Collections.Generic;
using System.IO;
using Pulumi;
using Aws = Pulumi.Aws;

	private static string ReadFileBase64(string path) {
		return Convert.ToBase64String(Encoding.UTF8.GetBytes(File.ReadAllText(path)))
	}

return await Deployment.RunAsync(() => 
{
    var usEast1 = new Aws.Provider("usEast1", new()
    {
        Region = "us-east-1",
    });

    var foo = new Aws.EcrPublic.Repository("foo", new()
    {
        RepositoryName = "bar",
        CatalogData = new Aws.EcrPublic.Inputs.RepositoryCatalogDataArgs
        {
            AboutText = "About Text",
            Architectures = new[]
            {
                "ARM",
            },
            Description = "Description",
            LogoImageBlob = ReadFileBase64(image.Png),
            OperatingSystems = new[]
            {
                "Linux",
            },
            UsageText = "Usage Text",
        },
        Tags = 
        {
            { "env", "production" },
        },
    }, new CustomResourceOptions
    {
        Provider = aws.Us_east_1,
    });

});
```

</details>

<details>

<summary>go</summary>

```go
package main

import (
	"encoding/base64"
	"io/ioutil"

	"github.com/pulumi/pulumi-aws/sdk/v5/go/aws"
	"github.com/pulumi/pulumi-aws/sdk/v5/go/aws/ecrpublic"
	"github.com/pulumi/pulumi/sdk/v3/go/pulumi"
)

func filebase64OrPanic(path string) pulumi.StringPtrInput {
	if fileData, err := ioutil.ReadFile(path); err == nil {
		return pulumi.String(base64.StdEncoding.EncodeToString(fileData[:]))
	} else {
		panic(err.Error())
	}
}

func main() {
	pulumi.Run(func(ctx *pulumi.Context) error {
		_, err := aws.NewProvider(ctx, "usEast1", &aws.ProviderArgs{
			Region: pulumi.String("us-east-1"),
		})
		if err != nil {
			return err
		}
		_, err = ecrpublic.NewRepository(ctx, "foo", &ecrpublic.RepositoryArgs{
			RepositoryName: pulumi.String("bar"),
			CatalogData: &ecrpublic.RepositoryCatalogDataArgs{
				AboutText: pulumi.String("About Text"),
				Architectures: pulumi.StringArray{
					pulumi.String("ARM"),
				},
				Description:   pulumi.String("Description"),
				LogoImageBlob: filebase64OrPanic(image.Png),
				OperatingSystems: pulumi.StringArray{
					pulumi.String("Linux"),
				},
				UsageText: pulumi.String("Usage Text"),
			},
			Tags: pulumi.StringMap{
				"env": pulumi.String("production"),
			},
		}, pulumi.Provider(aws.Us_east_1))
		if err != nil {
			return err
		}
		return nil
	})
}
```

</details>

<details>

<summary>java</summary>

```java
package generated_program;

import com.pulumi.Context;
import com.pulumi.Pulumi;
import com.pulumi.core.Output;
import com.pulumi.aws.Provider;
import com.pulumi.aws.ProviderArgs;
import com.pulumi.aws.ecrpublic.Repository;
import com.pulumi.aws.ecrpublic.RepositoryArgs;
import com.pulumi.aws.ecrpublic.inputs.RepositoryCatalogDataArgs;
import com.pulumi.resources.CustomResourceOptions;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;

public class App {
    public static void main(String[] args) {
        Pulumi.run(App::stack);
    }

    public static void stack(Context ctx) {
        var usEast1 = new Provider("usEast1", ProviderArgs.builder()        
            .region("us-east-1")
            .build());

        var foo = new Repository("foo", RepositoryArgs.builder()        
            .repositoryName("bar")
            .catalogData(RepositoryCatalogDataArgs.builder()
                .aboutText("About Text")
                .architectures("ARM")
                .description("Description")
                .logoImageBlob(Base64.getEncoder().encodeToString(Files.readAllBytes(Paths.get(image.png()))))
                .operatingSystems("Linux")
                .usageText("Usage Text")
                .build())
            .tags(Map.of("env", "production"))
            .build(), CustomResourceOptions.builder()
                .provider(aws.us_east_1())
                .build());

    }
}
```

</details>

<details>

<summary>typescript</summary>

```typescript
import * as pulumi from "@pulumi/pulumi";
import * as aws from "@pulumi/aws";
import * as fs from "fs";

const usEast1 = new aws.Provider("usEast1", {region: "us-east-1"});
const foo = new aws.ecrpublic.Repository("foo", {
    repositoryName: "bar",
    catalogData: {
        aboutText: "About Text",
        architectures: ["ARM"],
        description: "Description",
        logoImageBlob: Buffer.from(fs.readFileSync(image.png), 'binary').toString('base64'),
        operatingSystems: ["Linux"],
        usageText: "Usage Text",
    },
    tags: {
        env: "production",
    },
}, {
    provider: aws.us_east_1,
});
```

</details>

<details>

<summary>python</summary>

```python
import pulumi
import base64
import pulumi_aws as aws

us_east1 = aws.Provider("usEast1", region="us-east-1")
foo = aws.ecrpublic.Repository("foo",
    repository_name="bar",
    catalog_data=aws.ecrpublic.RepositoryCatalogDataArgs(
        about_text="About Text",
        architectures=["ARM"],
        description="Description",
        logo_image_blob=(lambda path: base64.b64encode(open(path).read().encode()).decode())(image["png"]),
        operating_systems=["Linux"],
        usage_text="Usage Text",
    ),
    tags={
        "env": "production",
    },
    opts=pulumi.ResourceOptions(provider=aws["us_east_1"]))
```

</details>

## [**complete failure**] Basic Dynamic Scaling

### HCL

```terraform
data "aws_availability_zones" "available" {}

resource "aws_autoscaling_group" "example" {
  name_prefix = "example"

  launch_configuration = aws_launch_configuration.example.name
  availability_zones   = [data.aws_availability_zones.available.names[0]]

  min_size = 0
  max_size = 3

  tags = [
    {
      key                 = "application"
      value               = "example"
      propagate_at_launch = true
    },
  ]
}

resource "aws_autoscalingplans_scaling_plan" "example" {
  name = "example-dynamic-cost-optimization"

  application_source {
    tag_filter {
      key    = "application"
      values = ["example"]
    }
  }

  scaling_instruction {
    max_capacity       = 3
    min_capacity       = 0
    resource_id        = format("autoScalingGroup/%s", aws_autoscaling_group.example.name)
    scalable_dimension = "autoscaling:autoScalingGroup:DesiredCapacity"
    service_namespace  = "autoscaling"

    target_tracking_configuration {
      predefined_scaling_metric_specification {
        predefined_scaling_metric_type = "ASGAverageCPUUtilization"
      }

      target_value = 70
    }
  }
}

```

### Failed Languages

#### go

```text
:33,26-32: unknown function 'format'; , and 1 other diagnostic(s)
```

#### yaml

```text
:33,26-32: unknown function 'format'; , and 1 other diagnostic(s)
```

#### java

```text
:33,26-32: unknown function 'format'; , and 1 other diagnostic(s)
```

#### typescript

```text
:33,26-32: unknown function 'format'; , and 1 other diagnostic(s)
```

#### python

```text
:33,26-32: unknown function 'format'; , and 1 other diagnostic(s)
```

#### csharp

```text
:33,26-32: unknown function 'format'; , and 1 other diagnostic(s)
```

## [**complete failure**] Basic Predictive Scaling

### HCL

```terraform
data "aws_availability_zones" "available" {}

resource "aws_autoscaling_group" "example" {
  name_prefix = "example"

  launch_configuration = aws_launch_configuration.example.name
  availability_zones   = [data.aws_availability_zones.available.names[0]]

  min_size = 0
  max_size = 3

  tags = [
    {
      key                 = "application"
      value               = "example"
      propagate_at_launch = true
    },
  ]
}

resource "aws_autoscalingplans_scaling_plan" "example" {
  name = "example-predictive-cost-optimization"

  application_source {
    tag_filter {
      key    = "application"
      values = ["example"]
    }
  }

  scaling_instruction {
    disable_dynamic_scaling = true

    max_capacity       = 3
    min_capacity       = 0
    resource_id        = format("autoScalingGroup/%s", aws_autoscaling_group.example.name)
    scalable_dimension = "autoscaling:autoScalingGroup:DesiredCapacity"
    service_namespace  = "autoscaling"

    target_tracking_configuration {
      predefined_scaling_metric_specification {
        predefined_scaling_metric_type = "ASGAverageCPUUtilization"
      }

      target_value = 70
    }

    predictive_scaling_max_capacity_behavior = "SetForecastCapacityToMaxCapacity"
    predictive_scaling_mode                  = "ForecastAndScale"

    predefined_load_metric_specification {
      predefined_load_metric_type = "ASGTotalCPUUtilization"
    }
  }
}

```

### Failed Languages

#### csharp

```text
:35,26-32: unknown function 'format'; , and 1 other diagnostic(s)
```

#### go

```text
:35,26-32: unknown function 'format'; , and 1 other diagnostic(s)
```

#### yaml

```text
:35,26-32: unknown function 'format'; , and 1 other diagnostic(s)
```

#### java

```text
:35,26-32: unknown function 'format'; , and 1 other diagnostic(s)
```

#### typescript

```text
:35,26-32: unknown function 'format'; , and 1 other diagnostic(s)
```

#### python

```text
:35,26-32: unknown function 'format'; , and 1 other diagnostic(s)
```

## [*partial failure*] #/functions/aws:cloudformation/getStack:getStack

### HCL

```terraform
data "aws_cloudformation_stack" "network" {
  name = "my-network-stack"
}

resource "aws_instance" "web" {
  ami           = "ami-abb07bcb"
  instance_type = "t2.micro"
  subnet_id     = data.aws_cloudformation_stack.network.outputs["SubnetId"]

  tags = {
    Name = "HelloWorld"
  }
}

```

### Failed Languages

#### python

```text
:0,0-0: cannot iterate over a value of type union(map(string), none); 
```

### Successes

<details>

<summary>csharp</summary>

```csharp
using System.Collections.Generic;
using Pulumi;
using Aws = Pulumi.Aws;

return await Deployment.RunAsync(() => 
{
    var network = Aws.CloudFormation.GetStack.Invoke(new()
    {
        Name = "my-network-stack",
    });

    var web = new Aws.Ec2.Instance("web", new()
    {
        Ami = "ami-abb07bcb",
        InstanceType = "t2.micro",
        SubnetId = network.Apply(getStackResult => getStackResult.Outputs?.SubnetId),
        Tags = 
        {
            { "Name", "HelloWorld" },
        },
    });

});
```

</details>

<details>

<summary>go</summary>

```go
package main

import (
	"github.com/pulumi/pulumi-aws/sdk/v5/go/aws/cloudformation"
	"github.com/pulumi/pulumi-aws/sdk/v5/go/aws/ec2"
	"github.com/pulumi/pulumi/sdk/v3/go/pulumi"
)

func main() {
	pulumi.Run(func(ctx *pulumi.Context) error {
		network, err := cloudformation.LookupStack(ctx, &cloudformation.LookupStackArgs{
			Name: "my-network-stack",
		}, nil)
		if err != nil {
			return err
		}
		_, err = ec2.NewInstance(ctx, "web", &ec2.InstanceArgs{
			Ami:          pulumi.String("ami-abb07bcb"),
			InstanceType: pulumi.String("t2.micro"),
			SubnetId:     pulumi.String(network.Outputs.SubnetId),
			Tags: pulumi.StringMap{
				"Name": pulumi.String("HelloWorld"),
			},
		})
		if err != nil {
			return err
		}
		return nil
	})
}
```

</details>

<details>

<summary>yaml</summary>

```yaml
resources:
  web:
    type: aws:ec2:Instance
    properties:
      ami: ami-abb07bcb
      instanceType: t2.micro
      subnetId: ${network.outputs.SubnetId}
      tags:
        Name: HelloWorld
variables:
  network:
    Fn::Invoke:
      Function: aws:cloudformation:getStack
      Arguments:
        name: my-network-stack
```

</details>

<details>

<summary>java</summary>

```java
package generated_program;

import com.pulumi.Context;
import com.pulumi.Pulumi;
import com.pulumi.core.Output;
import com.pulumi.aws.cloudformation.CloudformationFunctions;
import com.pulumi.aws.cloudformation.inputs.GetStackArgs;
import com.pulumi.aws.ec2.Instance;
import com.pulumi.aws.ec2.InstanceArgs;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;

public class App {
    public static void main(String[] args) {
        Pulumi.run(App::stack);
    }

    public static void stack(Context ctx) {
        final var network = CloudformationFunctions.getStack(GetStackArgs.builder()
            .name("my-network-stack")
            .build());

        var web = new Instance("web", InstanceArgs.builder()        
            .ami("ami-abb07bcb")
            .instanceType("t2.micro")
            .subnetId(network.applyValue(getStackResult -> getStackResult.outputs().SubnetId()))
            .tags(Map.of("Name", "HelloWorld"))
            .build());

    }
}
```

</details>

<details>

<summary>typescript</summary>

```typescript
import * as pulumi from "@pulumi/pulumi";
import * as aws from "@pulumi/aws";

const network = aws.cloudformation.getStack({
    name: "my-network-stack",
});
const web = new aws.ec2.Instance("web", {
    ami: "ami-abb07bcb",
    instanceType: "t2.micro",
    subnetId: network.then(network => network.outputs?.SubnetId),
    tags: {
        Name: "HelloWorld",
    },
});
```

</details>

## [**complete failure**] #/functions/aws:ssoadmin/getPermissionSet:getPermissionSet

### HCL

```terraform
data "aws_ssoadmin_instances" "example" {}

data "aws_ssoadmin_permission_set" "example" {
  instance_arn = tolist(data.aws_ssoadmin_instances.example.arns)[0]
  name         = "Example"
}

output "arn" {
  value = data.aws_ssoadmin_permission_set.example.arn
}

```

### Failed Languages

#### typescript

```text
:3,18-24: unknown function 'tolist'; , and 1 other diagnostic(s)
```

#### python

```text
:3,18-24: unknown function 'tolist'; , and 1 other diagnostic(s)
```

#### csharp

```text
:3,18-24: unknown function 'tolist'; , and 1 other diagnostic(s)
```

#### go

```text
:3,18-24: unknown function 'tolist'; , and 1 other diagnostic(s)
```

#### yaml

```text
:3,18-24: unknown function 'tolist'; , and 1 other diagnostic(s)
```

#### java

```text
:3,18-24: unknown function 'tolist'; , and 1 other diagnostic(s)
```

## [**complete failure**] Role ARNs with paths removed

### HCL

```terraform
data "aws_iam_roles" "roles" {
  path_prefix = "/aws-reserved/sso.amazonaws.com/"
}

output "arns" {
  value = [
    for parts in [for arn in data.aws_iam_roles.roles.arns : split("/", arn)] :
    format("%s/%s", parts[0], element(parts, length(parts) - 1))
  ]
}

```

### Failed Languages

#### python

```text
:7,5-11: unknown function 'format'; , and 2 other diagnostic(s)
```

#### csharp

```text
:7,5-11: unknown function 'format'; , and 2 other diagnostic(s)
```

#### go

```text
:7,5-11: unknown function 'format'; , and 2 other diagnostic(s)
```

#### yaml

```text
:7,5-11: unknown function 'format'; , and 2 other diagnostic(s)
```

#### java

```text
:7,5-11: unknown function 'format'; , and 2 other diagnostic(s)
```

#### typescript

```text
:7,5-11: unknown function 'format'; , and 2 other diagnostic(s)
```

## [**complete failure**] #/functions/aws:eks/getClusters:getClusters

### HCL

```terraform
data "aws_eks_clusters" "example" {}

data "aws_eks_cluster" "example" {
  for_each = toset(data.aws_eks_clusters.example.names)
  name     = each.value
}

```

### Failed Languages

#### typescript

```text
:3,14-19: unknown function 'toset'; , and 1 other diagnostic(s)
```

#### python

```text
:3,14-19: unknown function 'toset'; , and 1 other diagnostic(s)
```

#### csharp

```text
:3,14-19: unknown function 'toset'; , and 1 other diagnostic(s)
```

#### go

```text
:3,14-19: unknown function 'toset'; , and 1 other diagnostic(s)
```

#### yaml

```text
:3,14-19: unknown function 'toset'; , and 1 other diagnostic(s)
```

#### java

```text
:3,14-19: unknown function 'toset'; , and 1 other diagnostic(s)
```

## [**complete failure**] #/functions/aws:ec2/getVpcPeeringConnections:getVpcPeeringConnections

### HCL

```terraform
# Declare the data source
data "aws_vpc_peering_connections" "pcs" {
  filter {
    name   = "requester-vpc-info.vpc-id"
    values = [aws_vpc.foo.id]
  }
}

# get the details of each resource
data "aws_vpc_peering_connection" "pc" {
  count = length(data.aws_vpc_peering_connections.pcs.ids)
  id    = data.aws_vpc_peering_connections.pcs.ids[count.index]
}

```

### Failed Languages

#### typescript

```text
.pp:6,35-42: the first argument to 'length' must be a list, map, object, tuple, or string; , and 1 other diagnostic(s)
```

#### python

```text
.pp:6,35-42: the first argument to 'length' must be a list, map, object, tuple, or string; , and 1 other diagnostic(s)
```

#### csharp

```text
.pp:6,35-42: the first argument to 'length' must be a list, map, object, tuple, or string; , and 1 other diagnostic(s)
```

#### go

```text
.pp:6,35-42: the first argument to 'length' must be a list, map, object, tuple, or string; , and 1 other diagnostic(s)
```

#### yaml

```text
.pp:6,35-42: the first argument to 'length' must be a list, map, object, tuple, or string; , and 1 other diagnostic(s)
```

#### java

```text
.pp:6,35-42: the first argument to 'length' must be a list, map, object, tuple, or string; , and 1 other diagnostic(s)
```

## [*partial failure*] #/functions/aws:ec2/getCoipPool:getCoipPool

### HCL

```terraform
variable "coip_pool_id" {}

data "aws_ec2_coip_pool" "selected" {
  id = var.coip_pool_id
}

```

### Failed Languages

#### python

```text
:0,0-0: unknown property 'id' among [localGatewayRouteTableId poolId tags filters]; , and 2 other diagnostic(s)
```

#### csharp

```text
:0,0-0: unknown property 'id' among [filters localGatewayRouteTableId poolId tags]; , and 2 other diagnostic(s)
```

#### go

```text
:0,0-0: unknown property 'id' among [filters localGatewayRouteTableId poolId tags]; , and 2 other diagnostic(s)
```

#### typescript

```text
:0,0-0: unknown property 'id' among [tags filters localGatewayRouteTableId poolId]; , and 2 other diagnostic(s)
```

### Successes

<details>

<summary>yaml</summary>

```yaml
configuration:
  coipPoolId:
    type: dynamic
variables:
  selected:
    Fn::Invoke:
      Function: aws:ec2:getCoipPool
      Arguments:
        id: ${coipPoolId}
```

</details>

<details>

<summary>java</summary>

```java
package generated_program;

import com.pulumi.Context;
import com.pulumi.Pulumi;
import com.pulumi.core.Output;
import com.pulumi.aws.ec2.Ec2Functions;
import com.pulumi.aws.ec2.inputs.GetCoipPoolArgs;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;

public class App {
    public static void main(String[] args) {
        Pulumi.run(App::stack);
    }

    public static void stack(Context ctx) {
        final var config = ctx.config();
        final var coipPoolId = config.get("coipPoolId");
        final var selected = Ec2Functions.getCoipPool(GetCoipPoolArgs.builder()
            .id(coipPoolId)
            .build());

    }
}
```

</details>

## [*partial failure*] #/functions/aws:redshift/getClusterCredentials:getClusterCredentials

### HCL

```terraform
data "aws_redshift_cluster_credentials" "example" {
  name = aws_redshift_cluster_credentials.example.name
}

```

### Failed Languages

#### typescript

```text
:0,0-0: unknown property 'name' among [dbName dbUser durationSeconds autoCreate clusterIdentifier dbGroups]; , and 2 other diagnostic(s)
```

#### python

```text
:0,0-0: unknown property 'name' among [dbName dbUser durationSeconds autoCreate clusterIdentifier dbGroups]; , and 2 other diagnostic(s)
```

#### csharp

```text
:0,0-0: unknown property 'name' among [dbGroups dbName dbUser durationSeconds autoCreate clusterIdentifier]; , and 2 other diagnostic(s)
```

#### go

```text
:0,0-0: unknown property 'name' among [durationSeconds autoCreate clusterIdentifier dbGroups dbName dbUser]; , and 2 other diagnostic(s)
```

### Successes

<details>

<summary>yaml</summary>

```yaml
variables:
  example:
    Fn::Invoke:
      Function: aws:redshift:getClusterCredentials
      Arguments:
        name: ${aws_redshift_cluster_credentials.example.name}
```

</details>

<details>

<summary>java</summary>

```java
package generated_program;

import com.pulumi.Context;
import com.pulumi.Pulumi;
import com.pulumi.core.Output;
import com.pulumi.aws.redshift.RedshiftFunctions;
import com.pulumi.aws.redshift.inputs.GetClusterCredentialsArgs;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;

public class App {
    public static void main(String[] args) {
        Pulumi.run(App::stack);
    }

    public static void stack(Context ctx) {
        final var example = RedshiftFunctions.getClusterCredentials(GetClusterCredentialsArgs.builder()
            .name(aws_redshift_cluster_credentials.example().name())
            .build());

    }
}
```

</details>

## [**complete failure**] #/functions/aws:ebs/getEbsVolumes:getEbsVolumes

### HCL

```terraform
data "aws_ebs_volumes" "example" {
  tags = {
    VolumeSet = "TestVolumeSet"
  }
}

data "aws_ebs_volume" "example" {
  for_each = data.aws_ebs_volumes.example.ids
  filter {
    name   = "volume-id"
    values = [each.value]
  }
}

output "availability_zone_to_volume_id" {
  value = { for s in data.aws_ebs_volume.example : s.id => s.availability_zone }
}

```

### Failed Languages

#### python

```text
.pp:5,39-60: cannot iterate over a value of type union(list(string), none); 
```

#### csharp

```text
.pp:5,39-60: cannot iterate over a value of type union(list(string), none); 
```

#### go

```text
.pp:5,39-60: cannot iterate over a value of type union(list(string), none); 
```

#### yaml

```text
.pp:5,39-60: cannot iterate over a value of type union(list(string), none); 
```

#### java

```text
.pp:5,39-60: cannot iterate over a value of type union(list(string), none); 
```

#### typescript

```text
.pp:5,39-60: cannot iterate over a value of type union(list(string), none); 
```

## [*partial failure*] #/functions/aws:ec2/getLocalGatewayVirtualInterface:getLocalGatewayVirtualInterface

### HCL

```terraform
data "aws_ec2_local_gateway_virtual_interface" "example" {
  for_each = data.aws_ec2_local_gateway_virtual_interface_group.example.local_gateway_virtual_interface_ids

  id = each.value
}

```

### Failed Languages

#### csharp

```text
<nil>: not yet implemented: ForExpression; not yet implemented: ForExpression
```

#### go

```text
<nil>: not yet implemented: For expression; not yet implemented: For expression
```

#### yaml

```text
.pp:0,9-3,4: Failed to generate YAML program: For; Pulumi YAML cannot represent for loops.If the values of the for loop are known, you can manually unroll the loop, otherwise it is necessary to switch to a more expressive language.
```

#### java

```text
<nil>: not yet implemented: ForExpression; not yet implemented: ForExpression
```

### Successes

<details>

<summary>typescript</summary>

```typescript
import * as pulumi from "@pulumi/pulumi";
import * as aws from "@pulumi/aws";

const example = .map(([, ]) => aws.ec2.getLocalGatewayVirtualInterface({
    id: __value,
}));
```

</details>

<details>

<summary>python</summary>

```python
import pulumi
import pulumi_aws as aws

example = [aws.ec2.get_local_gateway_virtual_interface(id=__value) for __key, __value in data["aws_ec2_local_gateway_virtual_interface_group"]["example"]["local_gateway_virtual_interface_ids"]]
```

</details>

## [**complete failure**] #/functions/aws:ec2/getDedicatedHost:getDedicatedHost

### HCL

```terraform
resource "aws_ec2_host" "test" {
  instance_type     = "c5.18xlarge"
  availability_zone = "us-west-2a"
}

data "aws_ec2_host" "test" {
  host_id = aws_ec2_host.test.id
}

```

### Failed Languages

#### typescript

```text
failed to convert HCL for #/functions/aws:ec2/getDedicatedHost:getDedicatedHost to typescript: panic converting HCL: fatal: A failure has occurred
```

#### python

```text
failed to convert HCL for #/functions/aws:ec2/getDedicatedHost:getDedicatedHost to python: panic converting HCL: fatal: A failure has occurred
```

#### csharp

```text
failed to convert HCL for #/functions/aws:ec2/getDedicatedHost:getDedicatedHost to csharp: panic converting HCL: fatal: A failure has occurred
```

#### go

```text
failed to convert HCL for #/functions/aws:ec2/getDedicatedHost:getDedicatedHost to go: panic converting HCL: fatal: A failure has occurred
```

#### yaml

```text
failed to convert HCL for #/functions/aws:ec2/getDedicatedHost:getDedicatedHost to yaml: panic converting HCL: fatal: A failure has occurred
```

#### java

```text
failed to convert HCL for #/functions/aws:ec2/getDedicatedHost:getDedicatedHost to java: panic converting HCL: fatal: A failure has occurred
```

## [*partial failure*] #/functions/aws:ec2/getNetworkAcls:getNetworkAcls

### HCL

```terraform
data "aws_network_acls" "example" {
  vpc_id = var.vpc_id

  filter {
    name   = "association.subnet-id"
    values = [aws_subnet.test.id]
  }
}

```

### Failed Languages

#### go

```text
failed to convert HCL for #/functions/aws:ec2/getNetworkAcls:getNetworkAcls to go: invalid Go source code:

package main

import (

"github.com/pulumi/pulumi/sdk/v3/go/pulumi"
"github.com/pulumi/pulumi-aws/sdk/v5/go/aws/ec2"
)
func main() {
pulumi.Run(func(ctx *pulumi.Context) error {
_, err := ec2.GetNetworkAcls(ctx, &ec2.GetNetworkAclsArgs{
VpcId: pulumi.StringRef(_var.Vpc_id),
Filters: []ec2.GetNetworkAclsFilter{
ec2.GetNetworkAclsFilter{
Name: "association.subnet-id",
Values: interface{}{
aws_subnet.Test.Id,
},
},
},
}, nil);
if err != nil {
return err
}
return nil
})
}
: 15:9: expected expression (and 7 more errors)
```

### Successes

<details>

<summary>yaml</summary>

```yaml
variables:
  example:
    Fn::Invoke:
      Function: aws:ec2:getNetworkAcls
      Arguments:
        vpcId: ${var.vpc_id}
        filters:
          - name: association.subnet-id
            values:
              - ${aws_subnet.test.id}
```

</details>

<details>

<summary>java</summary>

```java
package generated_program;

import com.pulumi.Context;
import com.pulumi.Pulumi;
import com.pulumi.core.Output;
import com.pulumi.aws.ec2.Ec2Functions;
import com.pulumi.aws.ec2.inputs.GetNetworkAclsArgs;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;

public class App {
    public static void main(String[] args) {
        Pulumi.run(App::stack);
    }

    public static void stack(Context ctx) {
        final var example = Ec2Functions.getNetworkAcls(GetNetworkAclsArgs.builder()
            .vpcId(var_.vpc_id())
            .filters(GetNetworkAclsFilterArgs.builder()
                .name("association.subnet-id")
                .values(aws_subnet.test().id())
                .build())
            .build());

    }
}
```

</details>

<details>

<summary>typescript</summary>

```typescript
import * as pulumi from "@pulumi/pulumi";
import * as aws from "@pulumi/aws";

const example = aws.ec2.getNetworkAcls({
    vpcId: _var.vpc_id,
    filters: [{
        name: "association.subnet-id",
        values: [aws_subnet.test.id],
    }],
});
```

</details>

<details>

<summary>python</summary>

```python
import pulumi
import pulumi_aws as aws

example = aws.ec2.get_network_acls(vpc_id=var["vpc_id"],
    filters=[aws.ec2.GetNetworkAclsFilterArgs(
        name="association.subnet-id",
        values=[aws_subnet["test"]["id"]],
    )])
```

</details>

<details>

<summary>csharp</summary>

```csharp
using System.Collections.Generic;
using Pulumi;
using Aws = Pulumi.Aws;

return await Deployment.RunAsync(() => 
{
    var example = Aws.Ec2.GetNetworkAcls.Invoke(new()
    {
        VpcId = @var.Vpc_id,
        Filters = new[]
        {
            new Aws.Ec2.Inputs.GetNetworkAclsFilterInputArgs
            {
                Name = "association.subnet-id",
                Values = new[]
                {
                    aws_subnet.Test.Id,
                },
            },
        },
    });

});
```

</details>

## [**complete failure**] #/functions/aws:ec2/getRouteTables:getRouteTables

### HCL

```terraform
data "aws_route_tables" "rts" {
  vpc_id = var.vpc_id

  filter {
    name   = "tag:kubernetes.io/kops/role"
    values = ["private*"]
  }
}

resource "aws_route" "r" {
  count                     = length(data.aws_route_tables.rts.ids)
  route_table_id            = tolist(data.aws_route_tables.rts.ids)[count.index]
  destination_cidr_block    = "10.0.0.0/22"
  vpc_peering_connection_id = "pcx-0e9a7a9ecd137dc54"
}

```

### Failed Languages

#### csharp

```text
:11,31-37: unknown function 'tolist'; , and 2 other diagnostic(s)
```

#### go

```text
:11,31-37: unknown function 'tolist'; , and 2 other diagnostic(s)
```

#### yaml

```text
:11,31-37: unknown function 'tolist'; , and 2 other diagnostic(s)
```

#### java

```text
:11,31-37: unknown function 'tolist'; , and 2 other diagnostic(s)
```

#### typescript

```text
:11,31-37: unknown function 'tolist'; , and 2 other diagnostic(s)
```

#### python

```text
:11,31-37: unknown function 'tolist'; , and 2 other diagnostic(s)
```

## [**complete failure**] #/functions/aws:s3/getBucketObjects:getBucketObjects

### HCL

```terraform
data "aws_s3_bucket_objects" "my_objects" {
  bucket = "ourcorp"
}

data "aws_s3_object" "object_info" {
  count  = length(data.aws_s3_bucket_objects.my_objects.keys)
  key    = element(data.aws_s3_bucket_objects.my_objects.keys, count.index)
  bucket = data.aws_s3_bucket_objects.my_objects.bucket
}

```

### Failed Languages

#### yaml

```text
.pp:3,43-57: the first argument to 'length' must be a list, map, object, tuple, or string; , and 1 other diagnostic(s)
```

#### java

```text
.pp:3,43-57: the first argument to 'length' must be a list, map, object, tuple, or string; , and 1 other diagnostic(s)
```

#### typescript

```text
.pp:3,43-57: the first argument to 'length' must be a list, map, object, tuple, or string; , and 1 other diagnostic(s)
```

#### python

```text
.pp:3,43-57: the first argument to 'length' must be a list, map, object, tuple, or string; , and 1 other diagnostic(s)
```

#### csharp

```text
.pp:3,43-57: the first argument to 'length' must be a list, map, object, tuple, or string; , and 1 other diagnostic(s)
```

#### go

```text
.pp:3,43-57: the first argument to 'length' must be a list, map, object, tuple, or string; , and 1 other diagnostic(s)
```

## [*partial failure*] #/functions/aws:ec2/getNetworkInterfaces:getNetworkInterfaces

### HCL

```terraform
data "aws_network_interfaces" "example" {
  filter {
    name   = "subnet-id"
    values = [aws_subnet.test.id]
  }
}

output "example" {
  value = data.aws_network_interfaces.example.ids
}

```

### Failed Languages

#### go

```text
failed to convert HCL for #/functions/aws:ec2/getNetworkInterfaces:getNetworkInterfaces to go: invalid Go source code:

package main

import (

"github.com/pulumi/pulumi/sdk/v3/go/pulumi"
"github.com/pulumi/pulumi-aws/sdk/v5/go/aws/ec2"
)
func main() {
pulumi.Run(func(ctx *pulumi.Context) error {
exampleNetworkInterfaces, err := ec2.GetNetworkInterfaces(ctx, &ec2.GetNetworkInterfacesArgs{
Filters: []ec2.GetNetworkInterfacesFilter{
ec2.GetNetworkInterfacesFilter{
Name: "subnet-id",
Values: interface{}{
aws_subnet.Test.Id,
},
},
},
}, nil);
if err != nil {
return err
}
ctx.Export("example", exampleNetworkInterfaces.Ids)
return nil
})
}
: 14:9: expected expression (and 8 more errors)
```

### Successes

<details>

<summary>yaml</summary>

```yaml
variables:
  exampleNetworkInterfaces:
    Fn::Invoke:
      Function: aws:ec2:getNetworkInterfaces
      Arguments:
        filters:
          - name: subnet-id
            values:
              - ${aws_subnet.test.id}
outputs:
  example: ${exampleNetworkInterfaces.ids}
```

</details>

<details>

<summary>java</summary>

```java
package generated_program;

import com.pulumi.Context;
import com.pulumi.Pulumi;
import com.pulumi.core.Output;
import com.pulumi.aws.ec2.Ec2Functions;
import com.pulumi.aws.ec2.inputs.GetNetworkInterfacesArgs;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;

public class App {
    public static void main(String[] args) {
        Pulumi.run(App::stack);
    }

    public static void stack(Context ctx) {
        final var exampleNetworkInterfaces = Ec2Functions.getNetworkInterfaces(GetNetworkInterfacesArgs.builder()
            .filters(GetNetworkInterfacesFilterArgs.builder()
                .name("subnet-id")
                .values(aws_subnet.test().id())
                .build())
            .build());

        ctx.export("example", exampleNetworkInterfaces.applyValue(getNetworkInterfacesResult -> getNetworkInterfacesResult.ids()));
    }
}
```

</details>

<details>

<summary>typescript</summary>

```typescript
import * as pulumi from "@pulumi/pulumi";
import * as aws from "@pulumi/aws";

const exampleNetworkInterfaces = aws.ec2.getNetworkInterfaces({
    filters: [{
        name: "subnet-id",
        values: [aws_subnet.test.id],
    }],
});
export const example = exampleNetworkInterfaces.then(exampleNetworkInterfaces => exampleNetworkInterfaces.ids);
```

</details>

<details>

<summary>python</summary>

```python
import pulumi
import pulumi_aws as aws

example_network_interfaces = aws.ec2.get_network_interfaces(filters=[aws.ec2.GetNetworkInterfacesFilterArgs(
    name="subnet-id",
    values=[aws_subnet["test"]["id"]],
)])
pulumi.export("example", example_network_interfaces.ids)
```

</details>

<details>

<summary>csharp</summary>

```csharp
using System.Collections.Generic;
using Pulumi;
using Aws = Pulumi.Aws;

return await Deployment.RunAsync(() => 
{
    var exampleNetworkInterfaces = Aws.Ec2.GetNetworkInterfaces.Invoke(new()
    {
        Filters = new[]
        {
            new Aws.Ec2.Inputs.GetNetworkInterfacesFilterInputArgs
            {
                Name = "subnet-id",
                Values = new[]
                {
                    aws_subnet.Test.Id,
                },
            },
        },
    });

    return new Dictionary<string, object?>
    {
        ["example"] = exampleNetworkInterfaces.Apply(getNetworkInterfacesResult => getNetworkInterfacesResult.Ids),
    };
});
```

</details>

## [**complete failure**] #/functions/aws:ec2/getVpc:getVpc

### HCL

```terraform
variable "vpc_id" {}

data "aws_vpc" "selected" {
  id = var.vpc_id
}

resource "aws_subnet" "example" {
  vpc_id            = data.aws_vpc.selected.id
  availability_zone = "us-west-2a"
  cidr_block        = cidrsubnet(data.aws_vpc.selected.cidr_block, 4, 1)
}

```

### Failed Languages

#### java

```text
.pp:7,22-32: unknown function 'cidrsubnet'; 
```

#### typescript

```text
.pp:7,22-32: unknown function 'cidrsubnet'; 
```

#### python

```text
.pp:7,22-32: unknown function 'cidrsubnet'; 
```

#### csharp

```text
.pp:7,22-32: unknown function 'cidrsubnet'; 
```

#### go

```text
.pp:7,22-32: unknown function 'cidrsubnet'; 
```

#### yaml

```text
.pp:7,22-32: unknown function 'cidrsubnet'; 
```

## [**complete failure**] #/functions/aws:identitystore/getGroup:getGroup

### HCL

```terraform
data "aws_ssoadmin_instances" "example" {}

data "aws_identitystore_group" "example" {
  identity_store_id = tolist(data.aws_ssoadmin_instances.example.identity_store_ids)[0]

  filter {
    attribute_path  = "DisplayName"
    attribute_value = "ExampleGroup"
  }
}

output "group_id" {
  value = data.aws_identitystore_group.example.group_id
}

```

### Failed Languages

#### typescript

```text
:3,23-29: unknown function 'tolist'; , and 1 other diagnostic(s)
```

#### python

```text
:3,23-29: unknown function 'tolist'; , and 1 other diagnostic(s)
```

#### csharp

```text
:3,23-29: unknown function 'tolist'; , and 1 other diagnostic(s)
```

#### go

```text
:3,23-29: unknown function 'tolist'; , and 1 other diagnostic(s)
```

#### yaml

```text
:3,23-29: unknown function 'tolist'; , and 1 other diagnostic(s)
```

#### java

```text
:3,23-29: unknown function 'tolist'; , and 1 other diagnostic(s)
```

## [**complete failure**] #/functions/aws:ec2/getManagedPrefixLists:getManagedPrefixLists

### HCL

```terraform
data "aws_ec2_managed_prefix_lists" "test_env" {
  tags = {
    Env = "test"
  }
}

data "aws_ec2_managed_prefix_list" "test_env" {
  count = length(data.aws_ec2_managed_prefix_lists.test_env.ids)
  id    = tolist(data.aws_ec2_managed_prefix_lists.test_env.ids)[count.index]
}

```

### Failed Languages

#### typescript

```text
:8,11-17: unknown function 'tolist'; , and 2 other diagnostic(s)
```

#### python

```text
:8,11-17: unknown function 'tolist'; , and 2 other diagnostic(s)
```

#### csharp

```text
:8,11-17: unknown function 'tolist'; , and 2 other diagnostic(s)
```

#### go

```text
:8,11-17: unknown function 'tolist'; , and 2 other diagnostic(s)
```

#### yaml

```text
:8,11-17: unknown function 'tolist'; , and 2 other diagnostic(s)
```

#### java

```text
:8,11-17: unknown function 'tolist'; , and 2 other diagnostic(s)
```

## [*partial failure*] #/functions/aws:ec2/getSecurityGroups:getSecurityGroups

### HCL

```terraform
data "aws_security_groups" "test" {
  filter {
    name   = "group-name"
    values = ["*nodes*"]
  }

  filter {
    name   = "vpc-id"
    values = [var.vpc_id]
  }
}

```

### Failed Languages

#### go

```text
failed to convert HCL for #/functions/aws:ec2/getSecurityGroups:getSecurityGroups to go: invalid Go source code:

package main

import (

"github.com/pulumi/pulumi/sdk/v3/go/pulumi"
"github.com/pulumi/pulumi-aws/sdk/v5/go/aws/ec2"
)
func main() {
pulumi.Run(func(ctx *pulumi.Context) error {
_, err := ec2.GetSecurityGroups(ctx, &ec2.GetSecurityGroupsArgs{
Filters: []ec2.GetSecurityGroupsFilter{
ec2.GetSecurityGroupsFilter{
Name: "group-name",
Values: []string{
"*nodes*",
},
},
ec2.GetSecurityGroupsFilter{
Name: "vpc-id",
Values: interface{}{
_var.Vpc_id,
},
},
},
}, nil);
if err != nil {
return err
}
return nil
})
}
: 20:9: expected expression (and 7 more errors)
```

### Successes

<details>

<summary>typescript</summary>

```typescript
import * as pulumi from "@pulumi/pulumi";
import * as aws from "@pulumi/aws";

const test = aws.ec2.getSecurityGroups({
    filters: [
        {
            name: "group-name",
            values: ["*nodes*"],
        },
        {
            name: "vpc-id",
            values: [_var.vpc_id],
        },
    ],
});
```

</details>

<details>

<summary>python</summary>

```python
import pulumi
import pulumi_aws as aws

test = aws.ec2.get_security_groups(filters=[
    aws.ec2.GetSecurityGroupsFilterArgs(
        name="group-name",
        values=["*nodes*"],
    ),
    aws.ec2.GetSecurityGroupsFilterArgs(
        name="vpc-id",
        values=[var["vpc_id"]],
    ),
])
```

</details>

<details>

<summary>csharp</summary>

```csharp
using System.Collections.Generic;
using Pulumi;
using Aws = Pulumi.Aws;

return await Deployment.RunAsync(() => 
{
    var test = Aws.Ec2.GetSecurityGroups.Invoke(new()
    {
        Filters = new[]
        {
            new Aws.Ec2.Inputs.GetSecurityGroupsFilterInputArgs
            {
                Name = "group-name",
                Values = new[]
                {
                    "*nodes*",
                },
            },
            new Aws.Ec2.Inputs.GetSecurityGroupsFilterInputArgs
            {
                Name = "vpc-id",
                Values = new[]
                {
                    @var.Vpc_id,
                },
            },
        },
    });

});
```

</details>

<details>

<summary>yaml</summary>

```yaml
variables:
  test:
    Fn::Invoke:
      Function: aws:ec2:getSecurityGroups
      Arguments:
        filters:
          - name: group-name
            values:
              - '*nodes*'
          - name: vpc-id
            values:
              - ${var.vpc_id}
```

</details>

<details>

<summary>java</summary>

```java
package generated_program;

import com.pulumi.Context;
import com.pulumi.Pulumi;
import com.pulumi.core.Output;
import com.pulumi.aws.ec2.Ec2Functions;
import com.pulumi.aws.ec2.inputs.GetSecurityGroupsArgs;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;

public class App {
    public static void main(String[] args) {
        Pulumi.run(App::stack);
    }

    public static void stack(Context ctx) {
        final var test = Ec2Functions.getSecurityGroups(GetSecurityGroupsArgs.builder()
            .filters(            
                GetSecurityGroupsFilterArgs.builder()
                    .name("group-name")
                    .values("*nodes*")
                    .build(),
                GetSecurityGroupsFilterArgs.builder()
                    .name("vpc-id")
                    .values(var_.vpc_id())
                    .build())
            .build());

    }
}
```

</details>

## [*partial failure*] #/functions/aws:networkmanager/getDevice:getDevice

### HCL

```terraform
data "aws_networkmanager_device" "example" {
  global_network_id_id = var.global_network_id
  device_id            = var.device_id
}

```

### Failed Languages

#### typescript

```text
:0,0-0: unknown property 'globalNetworkIdId' among [tags deviceId globalNetworkId]; , and 2 other diagnostic(s)
```

#### python

```text
:0,0-0: unknown property 'globalNetworkIdId' among [globalNetworkId tags deviceId]; , and 2 other diagnostic(s)
```

#### csharp

```text
:0,0-0: unknown property 'globalNetworkIdId' among [deviceId globalNetworkId tags]; , and 2 other diagnostic(s)
```

#### go

```text
:0,0-0: unknown property 'globalNetworkIdId' among [globalNetworkId tags deviceId]; , and 2 other diagnostic(s)
```

### Successes

<details>

<summary>yaml</summary>

```yaml
variables:
  example:
    Fn::Invoke:
      Function: aws:networkmanager:getDevice
      Arguments:
        globalNetworkIdId: ${var.global_network_id}
        deviceId: ${var.device_id}
```

</details>

<details>

<summary>java</summary>

```java
package generated_program;

import com.pulumi.Context;
import com.pulumi.Pulumi;
import com.pulumi.core.Output;
import com.pulumi.aws.networkmanager.NetworkmanagerFunctions;
import com.pulumi.aws.networkmanager.inputs.GetDeviceArgs;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;

public class App {
    public static void main(String[] args) {
        Pulumi.run(App::stack);
    }

    public static void stack(Context ctx) {
        final var example = NetworkmanagerFunctions.getDevice(GetDeviceArgs.builder()
            .globalNetworkIdId(var_.global_network_id())
            .deviceId(var_.device_id())
            .build());

    }
}
```

</details>

## [**complete failure**] By Filter

### HCL

```terraform
data "aws_ec2_transit_gateway_vpc_attachments" "filtered" {
  filter {
    name   = "state"
    values = ["pendingAcceptance"]
  }
}

data "aws_ec2_transit_gateway_vpc_attachment" "unit" {
  count = length(data.aws_ec2_transit_gateway_vpc_attachments.filtered.ids)
  id    = data.aws_ec2_transit_gateway_vpc_attachments.filtered.ids[count.index]
}

```

### Failed Languages

#### typescript

```text
.pp:6,37-49: the first argument to 'length' must be a list, map, object, tuple, or string; , and 1 other diagnostic(s)
```

#### python

```text
.pp:6,37-49: the first argument to 'length' must be a list, map, object, tuple, or string; , and 1 other diagnostic(s)
```

#### csharp

```text
.pp:6,37-49: the first argument to 'length' must be a list, map, object, tuple, or string; , and 1 other diagnostic(s)
```

#### go

```text
.pp:6,37-49: the first argument to 'length' must be a list, map, object, tuple, or string; , and 1 other diagnostic(s)
```

#### yaml

```text
.pp:6,37-49: the first argument to 'length' must be a list, map, object, tuple, or string; , and 1 other diagnostic(s)
```

#### java

```text
.pp:6,37-49: the first argument to 'length' must be a list, map, object, tuple, or string; , and 1 other diagnostic(s)
```

## [*partial failure*] Dynamically Apply Default Tags to Auto Scaling Group

### HCL

```terraform
provider "aws" {
  default_tags {
    tags = {
      Environment = "Test"
      Name        = "Provider Tag"
    }
  }
}

data "aws_default_tags" "example" {}

resource "aws_autoscaling_group" "example" {
  # ...
  dynamic "tag" {
    for_each = data.aws_default_tags.example.tags
    content {
      key                 = tag.key
      value               = tag.value
      propagate_at_launch = true
    }
  }
}

```

### Failed Languages

#### typescript

```text
:0,0-7,2: default provider configuration is not supported; , and 1 other diagnostic(s)
```

#### python

```text
:0,0-7,2: default provider configuration is not supported; , and 1 other diagnostic(s)
```

#### csharp

```text
:0,0-7,2: default provider configuration is not supported; , and 1 other diagnostic(s)
```

#### go

```text
:0,0-7,2: default provider configuration is not supported; , and 1 other diagnostic(s)
```

### Successes

<details>

<summary>java</summary>

```java
package generated_program;

import com.pulumi.Context;
import com.pulumi.Pulumi;
import com.pulumi.core.Output;
import com.pulumi.aws.AwsFunctions;
import com.pulumi.aws.inputs.GetDefaultTagsArgs;
import com.pulumi.aws.autoscaling.Group;
import com.pulumi.aws.autoscaling.GroupArgs;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;

public class App {
    public static void main(String[] args) {
        Pulumi.run(App::stack);
    }

    public static void stack(Context ctx) {
        final var exampleDefaultTags = AwsFunctions.getDefaultTags();

        var exampleGroup = new Group("exampleGroup", GroupArgs.builder()        
            .dynamic(%!v(PANIC=Format method: runtime error: invalid memory address or nil pointer dereference))
            .build());

    }
}
```

</details>

<details>

<summary>yaml</summary>

```yaml
resources:
  exampleGroup:
    type: aws:autoscaling:Group
    properties:
      # ...
      dynamic:
        - forEach: ${exampleDefaultTags.tags}
          content:
            - key: ${tag.key}
              value: ${tag.value}
              propagateAtLaunch: true
variables:
  exampleDefaultTags:
    Fn::Invoke:
      Function: aws:getDefaultTags
      Arguments: {}
```

</details>

## [*partial failure*] #/functions/aws:ec2transitgateway/getAttachment:getAttachment

### HCL

```terraform
data "aws_ec2_transit_gateway_attachment" "example" {
  filter {
    name   = "transit-gateway-id"
    values = [aws_ec2_transit_gateway.example.id]
  }

  filter {
    name   = "resource-type"
    values = ["peering"]
  }
}

```

### Failed Languages

#### go

```text
failed to convert HCL for #/functions/aws:ec2transitgateway/getAttachment:getAttachment to go: invalid Go source code:

package main

import (

"github.com/pulumi/pulumi/sdk/v3/go/pulumi"
"github.com/pulumi/pulumi-aws/sdk/v5/go/aws/ec2transitgateway"
)
func main() {
pulumi.Run(func(ctx *pulumi.Context) error {
_, err := ec2transitgateway.GetAttachment(ctx, &ec2transitgateway.GetAttachmentArgs{
Filters: []ec2transitgateway.GetAttachmentFilter{
ec2transitgateway.GetAttachmentFilter{
Name: "transit-gateway-id",
Values: interface{}{
aws_ec2_transit_gateway.Example.Id,
},
},
ec2transitgateway.GetAttachmentFilter{
Name: "resource-type",
Values: []string{
"peering",
},
},
},
}, nil);
if err != nil {
return err
}
return nil
})
}
: 14:9: expected expression (and 7 more errors)
```

### Successes

<details>

<summary>typescript</summary>

```typescript
import * as pulumi from "@pulumi/pulumi";
import * as aws from "@pulumi/aws";

const example = aws.ec2transitgateway.getAttachment({
    filters: [
        {
            name: "transit-gateway-id",
            values: [aws_ec2_transit_gateway.example.id],
        },
        {
            name: "resource-type",
            values: ["peering"],
        },
    ],
});
```

</details>

<details>

<summary>python</summary>

```python
import pulumi
import pulumi_aws as aws

example = aws.ec2transitgateway.get_attachment(filters=[
    aws.ec2transitgateway.GetAttachmentFilterArgs(
        name="transit-gateway-id",
        values=[aws_ec2_transit_gateway["example"]["id"]],
    ),
    aws.ec2transitgateway.GetAttachmentFilterArgs(
        name="resource-type",
        values=["peering"],
    ),
])
```

</details>

<details>

<summary>csharp</summary>

```csharp
using System.Collections.Generic;
using Pulumi;
using Aws = Pulumi.Aws;

return await Deployment.RunAsync(() => 
{
    var example = Aws.Ec2TransitGateway.GetAttachment.Invoke(new()
    {
        Filters = new[]
        {
            new Aws.Ec2TransitGateway.Inputs.GetAttachmentFilterInputArgs
            {
                Name = "transit-gateway-id",
                Values = new[]
                {
                    aws_ec2_transit_gateway.Example.Id,
                },
            },
            new Aws.Ec2TransitGateway.Inputs.GetAttachmentFilterInputArgs
            {
                Name = "resource-type",
                Values = new[]
                {
                    "peering",
                },
            },
        },
    });

});
```

</details>

<details>

<summary>yaml</summary>

```yaml
variables:
  example:
    Fn::Invoke:
      Function: aws:ec2transitgateway:getAttachment
      Arguments:
        filters:
          - name: transit-gateway-id
            values:
              - ${aws_ec2_transit_gateway.example.id}
          - name: resource-type
            values:
              - peering
```

</details>

<details>

<summary>java</summary>

```java
package generated_program;

import com.pulumi.Context;
import com.pulumi.Pulumi;
import com.pulumi.core.Output;
import com.pulumi.aws.ec2transitgateway.Ec2transitgatewayFunctions;
import com.pulumi.aws.ec2transitgateway.inputs.GetAttachmentArgs;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;

public class App {
    public static void main(String[] args) {
        Pulumi.run(App::stack);
    }

    public static void stack(Context ctx) {
        final var example = Ec2transitgatewayFunctions.getAttachment(GetAttachmentArgs.builder()
            .filters(            
                GetAttachmentFilterArgs.builder()
                    .name("transit-gateway-id")
                    .values(aws_ec2_transit_gateway.example().id())
                    .build(),
                GetAttachmentFilterArgs.builder()
                    .name("resource-type")
                    .values("peering")
                    .build())
            .build());

    }
}
```

</details>

## [**complete failure**] #/functions/aws:ec2/getInstances:getInstances

### HCL

```terraform
data "aws_instances" "test" {
  instance_tags = {
    Role = "HardWorker"
  }

  filter {
    name   = "instance.group-id"
    values = ["sg-12345678"]
  }

  instance_state_names = ["running", "stopped"]
}

resource "aws_eip" "test" {
  count    = length(data.aws_instances.test.ids)
  instance = data.aws_instances.test.ids[count.index]
}

```

### Failed Languages

#### python

```text
.pp:12,21-38: the first argument to 'length' must be a list, map, object, tuple, or string; , and 1 other diagnostic(s)
```

#### csharp

```text
.pp:12,21-38: the first argument to 'length' must be a list, map, object, tuple, or string; , and 1 other diagnostic(s)
```

#### go

```text
.pp:12,21-38: the first argument to 'length' must be a list, map, object, tuple, or string; , and 1 other diagnostic(s)
```

#### yaml

```text
.pp:12,21-38: the first argument to 'length' must be a list, map, object, tuple, or string; , and 1 other diagnostic(s)
```

#### java

```text
.pp:12,21-38: the first argument to 'length' must be a list, map, object, tuple, or string; , and 1 other diagnostic(s)
```

#### typescript

```text
.pp:12,21-38: the first argument to 'length' must be a list, map, object, tuple, or string; , and 1 other diagnostic(s)
```

## [**complete failure**] #/functions/aws:identitystore/getUser:getUser

### HCL

```terraform
data "aws_ssoadmin_instances" "example" {}

data "aws_identitystore_user" "example" {
  identity_store_id = tolist(data.aws_ssoadmin_instances.example.identity_store_ids)[0]

  filter {
    attribute_path  = "UserName"
    attribute_value = "ExampleUser"
  }
}

output "user_id" {
  value = data.aws_identitystore_user.example.user_id
}

```

### Failed Languages

#### go

```text
:3,23-29: unknown function 'tolist'; , and 1 other diagnostic(s)
```

#### yaml

```text
:3,23-29: unknown function 'tolist'; , and 1 other diagnostic(s)
```

#### java

```text
:3,23-29: unknown function 'tolist'; , and 1 other diagnostic(s)
```

#### typescript

```text
:3,23-29: unknown function 'tolist'; , and 1 other diagnostic(s)
```

#### python

```text
:3,23-29: unknown function 'tolist'; , and 1 other diagnostic(s)
```

#### csharp

```text
:3,23-29: unknown function 'tolist'; , and 1 other diagnostic(s)
```

## [**complete failure**] #/functions/aws:ec2/getVpcs:getVpcs

### HCL

```terraform
data "aws_vpcs" "foo" {}

data "aws_vpc" "foo" {
  count = length(data.aws_vpcs.foo.ids)
  id    = tolist(data.aws_vpcs.foo.ids)[count.index]
}

resource "aws_flow_log" "test_flow_log" {
  count = length(data.aws_vpcs.foo.ids)

  # ...
  vpc_id = data.aws_vpc.foo[count.index].id

  # ...
}

output "foo" {
  value = data.aws_vpcs.foo.ids
}

```

### Failed Languages

#### typescript

```text
:4,11-17: unknown function 'tolist'; , and 3 other diagnostic(s)
```

#### python

```text
:4,11-17: unknown function 'tolist'; , and 3 other diagnostic(s)
```

#### csharp

```text
:4,11-17: unknown function 'tolist'; , and 3 other diagnostic(s)
```

#### go

```text
:4,11-17: unknown function 'tolist'; , and 3 other diagnostic(s)
```

#### yaml

```text
:4,11-17: unknown function 'tolist'; , and 3 other diagnostic(s)
```

#### java

```text
:4,11-17: unknown function 'tolist'; , and 3 other diagnostic(s)
```

## [**complete failure**] #/functions/aws:ec2/getCoipPools:getCoipPools

### HCL

```terraform
data "aws_ec2_coip_pools" "foo" {}

output "foo" {
  value = data.aws_ec2_coip_pools.foo.ids
}

```

### Failed Languages

#### typescript

```text
:3,38-42: unknown property 'ids' among [filter pool_ids tags id]; , and 1 other diagnostic(s)
```

#### python

```text
:3,38-42: unknown property 'ids' among [pool_ids tags id filter]; , and 1 other diagnostic(s)
```

#### csharp

```text
:3,38-42: unknown property 'ids' among [pool_ids tags id filter]; , and 1 other diagnostic(s)
```

#### go

```text
:3,38-42: unknown property 'ids' among [filter pool_ids tags id]; , and 1 other diagnostic(s)
```

#### yaml

```text
:3,38-42: unknown property 'ids' among [id filter pool_ids tags]; , and 1 other diagnostic(s)
```

#### java

```text
:3,38-42: unknown property 'ids' among [filter pool_ids tags id]; , and 1 other diagnostic(s)
```

## [**complete failure**] #/functions/aws:ec2/getSubnets:getSubnets

### HCL

```terraform
data "aws_subnets" "example" {
  filter {
    name   = "vpc-id"
    values = [var.vpc_id]
  }
}

data "aws_subnet" "example" {
  for_each = toset(data.aws_subnets.example.ids)
  id       = each.value
}

output "subnet_cidr_blocks" {
  value = [for s in data.aws_subnet.example : s.cidr_block]
}

```

### Failed Languages

#### typescript

```text
:8,14-19: unknown function 'toset'; , and 1 other diagnostic(s)
```

#### python

```text
:8,14-19: unknown function 'toset'; , and 1 other diagnostic(s)
```

#### csharp

```text
:8,14-19: unknown function 'toset'; , and 1 other diagnostic(s)
```

#### go

```text
:8,14-19: unknown function 'toset'; , and 1 other diagnostic(s)
```

#### yaml

```text
:8,14-19: unknown function 'toset'; , and 1 other diagnostic(s)
```

#### java

```text
:8,14-19: unknown function 'toset'; , and 1 other diagnostic(s)
```

## [**complete failure**] #/functions/aws:ec2/getSubnets:getSubnets

### HCL

```terraform
data "aws_subnets" "private" {
  filter {
    name   = "vpc-id"
    values = [var.vpc_id]
  }

  tags = {
    Tier = "Private"
  }
}

resource "aws_instance" "app" {
  for_each      = toset(data.aws_subnets.example.ids)
  ami           = var.ami
  instance_type = "t2.micro"
  subnet_id     = each.value
}

```

### Failed Languages

#### csharp

```text
:12,19-24: unknown function 'toset'; , and 1 other diagnostic(s)
```

#### go

```text
:12,19-24: unknown function 'toset'; , and 1 other diagnostic(s)
```

#### yaml

```text
:12,19-24: unknown function 'toset'; , and 1 other diagnostic(s)
```

#### java

```text
:12,19-24: unknown function 'toset'; , and 1 other diagnostic(s)
```

#### typescript

```text
:12,19-24: unknown function 'toset'; , and 1 other diagnostic(s)
```

#### python

```text
:12,19-24: unknown function 'toset'; , and 1 other diagnostic(s)
```

## [*partial failure*] #/functions/aws:glue/getDataCatalogEncryptionSettings:getDataCatalogEncryptionSettings

### HCL

```terraform
data "aws_glue_data_catalog_encryption_settings" "example" {
  id = "123456789123"
}

```

### Failed Languages

#### python

```text
:0,0-0: unknown property 'id' among [catalogId]; , and 2 other diagnostic(s)
```

#### csharp

```text
:0,0-0: unknown property 'id' among [catalogId]; , and 2 other diagnostic(s)
```

#### go

```text
:0,0-0: unknown property 'id' among [catalogId]; , and 2 other diagnostic(s)
```

### Successes

<details>

<summary>yaml</summary>

```yaml
variables:
  example:
    Fn::Invoke:
      Function: aws:glue:getDataCatalogEncryptionSettings
      Arguments:
        id: 123456789123
```

</details>

<details>

<summary>java</summary>

```java
package generated_program;

import com.pulumi.Context;
import com.pulumi.Pulumi;
import com.pulumi.core.Output;
import com.pulumi.aws.glue.GlueFunctions;
import com.pulumi.aws.glue.inputs.GetDataCatalogEncryptionSettingsArgs;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;

public class App {
    public static void main(String[] args) {
        Pulumi.run(App::stack);
    }

    public static void stack(Context ctx) {
        final var example = GlueFunctions.getDataCatalogEncryptionSettings(GetDataCatalogEncryptionSettingsArgs.builder()
            .id("123456789123")
            .build());

    }
}
```

</details>

<details>

<summary>typescript</summary>

```typescript
import * as pulumi from "@pulumi/pulumi";
import * as aws from "@pulumi/aws";

const example = pulumi.output(aws.glue.getDataCatalogEncryptionSettings({
    id: "123456789123",
}));
```

</details>

## [*partial failure*] #/functions/aws:ecs/getTaskDefinition:getTaskDefinition

### HCL

```terraform
# Simply specify the family to find the latest ACTIVE revision in that family.
data "aws_ecs_task_definition" "mongo" {
  task_definition = aws_ecs_task_definition.mongo.family
}

resource "aws_ecs_cluster" "foo" {
  name = "foo"
}

resource "aws_ecs_task_definition" "mongo" {
  family = "mongodb"

  container_definitions = <<DEFINITION
[
  {
    "cpu": 128,
    "environment": [{
      "name": "SECRET",
      "value": "KEY"
    }],
    "essential": true,
    "image": "mongo:latest",
    "memory": 128,
    "memoryReservation": 64,
    "name": "mongodb"
  }
]
DEFINITION
}

resource "aws_ecs_service" "mongo" {
  name          = "mongo"
  cluster       = aws_ecs_cluster.foo.id
  desired_count = 2

  # Track the latest ACTIVE revision
  task_definition = data.aws_ecs_task_definition.mongo.arn
}

```

### Failed Languages

#### yaml

```text
.pp:1,20-64: Failed to generate YAML program: *model.BinaryOpExpression; Unimplemented! Needed for  mongoEcs/taskDefinitionTaskDefinition.family

```

### Successes

<details>

<summary>python</summary>

```python
import pulumi
import pulumi_aws as aws

mongo_task_definition = aws.ecs.get_task_definition(task_definition=mongo_ecs / task_definition_task_definition["family"])
foo = aws.ecs.Cluster("foo")
mongo_ecs_task_definition_task_definition = aws.ecs.TaskDefinition("mongoEcs/taskDefinitionTaskDefinition",
    family="mongodb",
    container_definitions="""[
  {
    "cpu": 128,
    "environment": [{
      "name": "SECRET",
      "value": "KEY"
    }],
    "essential": true,
    "image": "mongo:latest",
    "memory": 128,
    "memoryReservation": 64,
    "name": "mongodb"
  }
]
""")
mongo_service = aws.ecs.Service("mongoService",
    cluster=foo.id,
    desired_count=2,
    task_definition=mongo_task_definition.arn)
```

</details>

<details>

<summary>csharp</summary>

```csharp
using System.Collections.Generic;
using Pulumi;
using Aws = Pulumi.Aws;

return await Deployment.RunAsync(() => 
{
    var mongoTaskDefinition = Aws.Ecs.GetTaskDefinition.Invoke(new()
    {
        TaskDefinition = mongoEcs / taskDefinitionTaskDefinition.Family,
    });

    var foo = new Aws.Ecs.Cluster("foo");

    var mongoEcs_taskDefinitionTaskDefinition = new Aws.Ecs.TaskDefinition("mongoEcs/taskDefinitionTaskDefinition", new()
    {
        Family = "mongodb",
        ContainerDefinitions = @"[
  {
    ""cpu"": 128,
    ""environment"": [{
      ""name"": ""SECRET"",
      ""value"": ""KEY""
    }],
    ""essential"": true,
    ""image"": ""mongo:latest"",
    ""memory"": 128,
    ""memoryReservation"": 64,
    ""name"": ""mongodb""
  }
]
",
    });

    var mongoService = new Aws.Ecs.Service("mongoService", new()
    {
        Cluster = foo.Id,
        DesiredCount = 2,
        TaskDefinition = mongoTaskDefinition.Apply(getTaskDefinitionResult => getTaskDefinitionResult.Arn),
    });

});
```

</details>

<details>

<summary>go</summary>

```go
package main

import (
	"fmt"

	"github.com/pulumi/pulumi-aws/sdk/v5/go/aws/ecs"
	"github.com/pulumi/pulumi/sdk/v3/go/pulumi"
)

func main() {
	pulumi.Run(func(ctx *pulumi.Context) error {
		mongoTaskDefinition, err := ecs.LookupTaskDefinition(ctx, &ecs.LookupTaskDefinitionArgs{
			TaskDefinition: mongoEcs / taskDefinitionTaskDefinition.Family,
		}, nil)
		if err != nil {
			return err
		}
		foo, err := ecs.NewCluster(ctx, "foo", nil)
		if err != nil {
			return err
		}
		_, err = ecs.NewTaskDefinition(ctx, "mongoEcs/taskDefinitionTaskDefinition", &ecs.TaskDefinitionArgs{
			Family: pulumi.String("mongodb"),
			ContainerDefinitions: pulumi.String(fmt.Sprintf(`[
  {
    "cpu": 128,
    "environment": [{
      "name": "SECRET",
      "value": "KEY"
    }],
    "essential": true,
    "image": "mongo:latest",
    "memory": 128,
    "memoryReservation": 64,
    "name": "mongodb"
  }
]
`)),
		})
		if err != nil {
			return err
		}
		_, err = ecs.NewService(ctx, "mongoService", &ecs.ServiceArgs{
			Cluster:        foo.ID(),
			DesiredCount:   pulumi.Int(2),
			TaskDefinition: pulumi.String(mongoTaskDefinition.Arn),
		})
		if err != nil {
			return err
		}
		return nil
	})
}
```

</details>

<details>

<summary>java</summary>

```java
package generated_program;

import com.pulumi.Context;
import com.pulumi.Pulumi;
import com.pulumi.core.Output;
import com.pulumi.aws.ecs.EcsFunctions;
import com.pulumi.aws.ecs.inputs.GetTaskDefinitionArgs;
import com.pulumi.aws.ecs.Cluster;
import com.pulumi.aws.ecs.TaskDefinition;
import com.pulumi.aws.ecs.TaskDefinitionArgs;
import com.pulumi.aws.ecs.Service;
import com.pulumi.aws.ecs.ServiceArgs;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;

public class App {
    public static void main(String[] args) {
        Pulumi.run(App::stack);
    }

    public static void stack(Context ctx) {
        final var mongoTaskDefinition = EcsFunctions.getTaskDefinition(GetTaskDefinitionArgs.builder()
            .taskDefinition(mongoEcs / taskDefinitionTaskDefinition.family())
            .build());

        var foo = new Cluster("foo");

        var mongoEcs_taskDefinitionTaskDefinition = new TaskDefinition("mongoEcs/taskDefinitionTaskDefinition", TaskDefinitionArgs.builder()        
            .family("mongodb")
            .containerDefinitions("""
[
  {
    "cpu": 128,
    "environment": [{
      "name": "SECRET",
      "value": "KEY"
    }],
    "essential": true,
    "image": "mongo:latest",
    "memory": 128,
    "memoryReservation": 64,
    "name": "mongodb"
  }
]
            """)
            .build());

        var mongoService = new Service("mongoService", ServiceArgs.builder()        
            .cluster(foo.id())
            .desiredCount(2)
            .taskDefinition(mongoTaskDefinition.applyValue(getTaskDefinitionResult -> getTaskDefinitionResult.arn()))
            .build());

    }
}
```

</details>

<details>

<summary>typescript</summary>

```typescript
import * as pulumi from "@pulumi/pulumi";
import * as aws from "@pulumi/aws";

const mongoTaskDefinition = aws.ecs.getTaskDefinition({
    taskDefinition: mongoEcs / taskDefinitionTaskDefinition.family,
});
const foo = new aws.ecs.Cluster("foo", {});
const mongoEcs_taskDefinitionTaskDefinition = new aws.ecs.TaskDefinition("mongoEcs/taskDefinitionTaskDefinition", {
    family: "mongodb",
    containerDefinitions: `[
  {
    "cpu": 128,
    "environment": [{
      "name": "SECRET",
      "value": "KEY"
    }],
    "essential": true,
    "image": "mongo:latest",
    "memory": 128,
    "memoryReservation": 64,
    "name": "mongodb"
  }
]
`,
});
const mongoService = new aws.ecs.Service("mongoService", {
    cluster: foo.id,
    desiredCount: 2,
    taskDefinition: mongoTaskDefinition.then(mongoTaskDefinition => mongoTaskDefinition.arn),
});
```

</details>

## [**complete failure**] #/functions/aws:outposts/getAsset:getAsset

### HCL

```terraform
data "aws_outposts_assets" "example" {
  arn = data.aws_outposts_outpost.example.arn
}

data "aws_outposts_asset" "example" {
  count    = length(data.aws_outposts_assets.example.asset_ids)
  arn      = data.aws_outposts_outpost.example.arn
  asset_id = element(data.aws_outposts_assets.this.asset_ids, count.index)
}


```

### Failed Languages

#### csharp

```text
:7,22-61: the first argument to 'element' must be a list or tuple; , and 2 other diagnostic(s)
```

#### go

```text
:7,22-61: the first argument to 'element' must be a list or tuple; , and 2 other diagnostic(s)
```

#### yaml

```text
:7,22-61: the first argument to 'element' must be a list or tuple; , and 2 other diagnostic(s)
```

#### java

```text
:7,22-61: the first argument to 'element' must be a list or tuple; , and 2 other diagnostic(s)
```

#### typescript

```text
:7,22-61: the first argument to 'element' must be a list or tuple; , and 2 other diagnostic(s)
```

#### python

```text
:7,22-61: the first argument to 'element' must be a list or tuple; , and 2 other diagnostic(s)
```

## [*partial failure*] #/functions/aws:ec2/getInternetGateway:getInternetGateway

### HCL

```terraform
variable "vpc_id" {}

data "aws_internet_gateway" "default" {
  filter {
    name   = "attachment.vpc-id"
    values = [var.vpc_id]
  }
}

```

### Failed Languages

#### go

```text
failed to convert HCL for #/functions/aws:ec2/getInternetGateway:getInternetGateway to go: invalid Go source code:

package main

import (

"github.com/pulumi/pulumi/sdk/v3/go/pulumi"
"github.com/pulumi/pulumi-aws/sdk/v5/go/aws/ec2"
"github.com/pulumi/pulumi/sdk/v3/go/pulumi/config"
)
func main() {
pulumi.Run(func(ctx *pulumi.Context) error {
cfg := config.New(ctx, "")
vpcId := cfg.RequireObject("vpcId")
_, err := ec2.LookupInternetGateway(ctx, &ec2.LookupInternetGatewayArgs{
Filters: []ec2.GetInternetGatewayFilter{
ec2.GetInternetGatewayFilter{
Name: "attachment.vpc-id",
Values: interface{}{
vpcId,
},
},
},
}, nil);
if err != nil {
return err
}
return nil
})
}
: 17:9: expected expression (and 7 more errors)
```

### Successes

<details>

<summary>typescript</summary>

```typescript
import * as pulumi from "@pulumi/pulumi";
import * as aws from "@pulumi/aws";

const config = new pulumi.Config();
const vpcId = config.requireObject("vpcId");
const default = aws.ec2.getInternetGateway({
    filters: [{
        name: "attachment.vpc-id",
        values: [vpcId],
    }],
});
```

</details>

<details>

<summary>python</summary>

```python
import pulumi
import pulumi_aws as aws

config = pulumi.Config()
vpc_id = config.require_object("vpcId")
default = aws.ec2.get_internet_gateway(filters=[aws.ec2.GetInternetGatewayFilterArgs(
    name="attachment.vpc-id",
    values=[vpc_id],
)])
```

</details>

<details>

<summary>csharp</summary>

```csharp
using System.Collections.Generic;
using Pulumi;
using Aws = Pulumi.Aws;

return await Deployment.RunAsync(() => 
{
    var config = new Config();
    var vpcId = config.RequireObject<dynamic>("vpcId");
    var @default = Aws.Ec2.GetInternetGateway.Invoke(new()
    {
        Filters = new[]
        {
            new Aws.Ec2.Inputs.GetInternetGatewayFilterInputArgs
            {
                Name = "attachment.vpc-id",
                Values = new[]
                {
                    vpcId,
                },
            },
        },
    });

});
```

</details>

<details>

<summary>yaml</summary>

```yaml
configuration:
  vpcId:
    type: dynamic
variables:
  default:
    Fn::Invoke:
      Function: aws:ec2:getInternetGateway
      Arguments:
        filters:
          - name: attachment.vpc-id
            values:
              - ${vpcId}
```

</details>

<details>

<summary>java</summary>

```java
package generated_program;

import com.pulumi.Context;
import com.pulumi.Pulumi;
import com.pulumi.core.Output;
import com.pulumi.aws.ec2.Ec2Functions;
import com.pulumi.aws.ec2.inputs.GetInternetGatewayArgs;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;

public class App {
    public static void main(String[] args) {
        Pulumi.run(App::stack);
    }

    public static void stack(Context ctx) {
        final var config = ctx.config();
        final var vpcId = config.get("vpcId");
        final var default = Ec2Functions.getInternetGateway(GetInternetGatewayArgs.builder()
            .filters(GetInternetGatewayFilterArgs.builder()
                .name("attachment.vpc-id")
                .values(vpcId)
                .build())
            .build());

    }
}
```

</details>

## [*partial failure*] Example Assume-Role Policy with Multiple Principals

### HCL

```terraform
data "aws_iam_policy_document" "event_stream_bucket_role_assume_role_policy" {
  statement {
    actions = ["sts:AssumeRole"]

    principals {
      type        = "Service"
      identifiers = ["firehose.amazonaws.com"]
    }

    principals {
      type        = "AWS"
      identifiers = [var.trusted_role_arn]
    }

    principals {
      type        = "Federated"
      identifiers = ["arn:aws:iam::${var.account_id}:saml-provider/${var.provider_name}", "cognito-identity.amazonaws.com"]
    }
  }
}

```

### Failed Languages

#### go

```text
failed to convert HCL for #/functions/aws:iam/getPolicyDocument:getPolicyDocument to go: invalid Go source code:

package main

import (
"fmt"

"github.com/pulumi/pulumi/sdk/v3/go/pulumi"
"github.com/pulumi/pulumi-aws/sdk/v5/go/aws/iam"
)
func main() {
pulumi.Run(func(ctx *pulumi.Context) error {
_, err := iam.GetPolicyDocument(ctx, &iam.GetPolicyDocumentArgs{
Statements: []iam.GetPolicyDocumentStatement{
iam.GetPolicyDocumentStatement{
Actions: []string{
"sts:AssumeRole",
},
Principals: []iam.GetPolicyDocumentStatementPrincipal{
iam.GetPolicyDocumentStatementPrincipal{
Type: "Service",
Identifiers: []string{
"firehose.amazonaws.com",
},
},
iam.GetPolicyDocumentStatementPrincipal{
Type: "AWS",
Identifiers: interface{}{
_var.Trusted_role_arn,
},
},
iam.GetPolicyDocumentStatementPrincipal{
Type: "Federated",
Identifiers: []string{
fmt.Sprintf("arn:aws:iam::%v:saml-provider/%v", _var.Account_id, _var.Provider_name),
"cognito-identity.amazonaws.com",
},
},
},
},
},
}, nil);
if err != nil {
return err
}
return nil
})
}
: 26:14: expected expression (and 7 more errors)
```

### Successes

<details>

<summary>java</summary>

```java
package generated_program;

import com.pulumi.Context;
import com.pulumi.Pulumi;
import com.pulumi.core.Output;
import com.pulumi.aws.iam.IamFunctions;
import com.pulumi.aws.iam.inputs.GetPolicyDocumentArgs;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;

public class App {
    public static void main(String[] args) {
        Pulumi.run(App::stack);
    }

    public static void stack(Context ctx) {
        final var eventStreamBucketRoleAssumeRolePolicy = IamFunctions.getPolicyDocument(GetPolicyDocumentArgs.builder()
            .statements(GetPolicyDocumentStatementArgs.builder()
                .actions("sts:AssumeRole")
                .principals(                
                    GetPolicyDocumentStatementPrincipalArgs.builder()
                        .type("Service")
                        .identifiers("firehose.amazonaws.com")
                        .build(),
                    GetPolicyDocumentStatementPrincipalArgs.builder()
                        .type("AWS")
                        .identifiers(var_.trusted_role_arn())
                        .build(),
                    GetPolicyDocumentStatementPrincipalArgs.builder()
                        .type("Federated")
                        .identifiers(                        
                            String.format("arn:aws:iam::%s:saml-provider/%s", var_.account_id(),var_.provider_name()),
                            "cognito-identity.amazonaws.com")
                        .build())
                .build())
            .build());

    }
}
```

</details>

<details>

<summary>typescript</summary>

```typescript
import * as pulumi from "@pulumi/pulumi";
import * as aws from "@pulumi/aws";

const eventStreamBucketRoleAssumeRolePolicy = aws.iam.getPolicyDocument({
    statements: [{
        actions: ["sts:AssumeRole"],
        principals: [
            {
                type: "Service",
                identifiers: ["firehose.amazonaws.com"],
            },
            {
                type: "AWS",
                identifiers: [_var.trusted_role_arn],
            },
            {
                type: "Federated",
                identifiers: [
                    `arn:aws:iam::${_var.account_id}:saml-provider/${_var.provider_name}`,
                    "cognito-identity.amazonaws.com",
                ],
            },
        ],
    }],
});
```

</details>

<details>

<summary>python</summary>

```python
import pulumi
import pulumi_aws as aws

event_stream_bucket_role_assume_role_policy = aws.iam.get_policy_document(statements=[aws.iam.GetPolicyDocumentStatementArgs(
    actions=["sts:AssumeRole"],
    principals=[
        aws.iam.GetPolicyDocumentStatementPrincipalArgs(
            type="Service",
            identifiers=["firehose.amazonaws.com"],
        ),
        aws.iam.GetPolicyDocumentStatementPrincipalArgs(
            type="AWS",
            identifiers=[var["trusted_role_arn"]],
        ),
        aws.iam.GetPolicyDocumentStatementPrincipalArgs(
            type="Federated",
            identifiers=[
                f"arn:aws:iam::{var['account_id']}:saml-provider/{var['provider_name']}",
                "cognito-identity.amazonaws.com",
            ],
        ),
    ],
)])
```

</details>

<details>

<summary>csharp</summary>

```csharp
using System.Collections.Generic;
using Pulumi;
using Aws = Pulumi.Aws;

return await Deployment.RunAsync(() => 
{
    var eventStreamBucketRoleAssumeRolePolicy = Aws.Iam.GetPolicyDocument.Invoke(new()
    {
        Statements = new[]
        {
            new Aws.Iam.Inputs.GetPolicyDocumentStatementInputArgs
            {
                Actions = new[]
                {
                    "sts:AssumeRole",
                },
                Principals = new[]
                {
                    new Aws.Iam.Inputs.GetPolicyDocumentStatementPrincipalInputArgs
                    {
                        Type = "Service",
                        Identifiers = new[]
                        {
                            "firehose.amazonaws.com",
                        },
                    },
                    new Aws.Iam.Inputs.GetPolicyDocumentStatementPrincipalInputArgs
                    {
                        Type = "AWS",
                        Identifiers = new[]
                        {
                            @var.Trusted_role_arn,
                        },
                    },
                    new Aws.Iam.Inputs.GetPolicyDocumentStatementPrincipalInputArgs
                    {
                        Type = "Federated",
                        Identifiers = new[]
                        {
                            $"arn:aws:iam::{@var.Account_id}:saml-provider/{@var.Provider_name}",
                            "cognito-identity.amazonaws.com",
                        },
                    },
                },
            },
        },
    });

});
```

</details>

<details>

<summary>yaml</summary>

```yaml
variables:
  eventStreamBucketRoleAssumeRolePolicy:
    Fn::Invoke:
      Function: aws:iam:getPolicyDocument
      Arguments:
        statements:
          - actions:
              - sts:AssumeRole
            principals:
              - type: Service
                identifiers:
                  - firehose.amazonaws.com
              - type: AWS
                identifiers:
                  - ${var.trusted_role_arn}
              - type: Federated
                identifiers:
                  - arn:aws:iam::${var.account_id}:saml-provider/${var.provider_name}
                  - cognito-identity.amazonaws.com
```

</details>

## [*partial failure*] Example Using A Source Document

### HCL

```terraform
data "aws_iam_policy_document" "source" {
  statement {
    actions   = ["ec2:*"]
    resources = ["*"]
  }

  statement {
    sid = "SidToOverride"

    actions   = ["s3:*"]
    resources = ["*"]
  }
}

data "aws_iam_policy_document" "source_document_example" {
  source_policy_documents = [data.aws_iam_policy_document.source.json]

  statement {
    sid = "SidToOverride"

    actions = ["s3:*"]

    resources = [
      "arn:aws:s3:::somebucket",
      "arn:aws:s3:::somebucket/*",
    ]
  }
}

```

### Failed Languages

#### go

```text
failed to convert HCL for #/functions/aws:iam/getPolicyDocument:getPolicyDocument to go: invalid Go source code:

package main

import (

"github.com/pulumi/pulumi/sdk/v3/go/pulumi"
"github.com/pulumi/pulumi-aws/sdk/v5/go/aws/iam"
)
func main() {
pulumi.Run(func(ctx *pulumi.Context) error {
source, err := iam.GetPolicyDocument(ctx, &iam.GetPolicyDocumentArgs{
Statements: []iam.GetPolicyDocumentStatement{
iam.GetPolicyDocumentStatement{
Actions: []string{
"ec2:*",
},
Resources: []string{
"*",
},
},
iam.GetPolicyDocumentStatement{
Sid: pulumi.StringRef("SidToOverride"),
Actions: []string{
"s3:*",
},
Resources: []string{
"*",
},
},
},
}, nil);
if err != nil {
return err
}
_, err = iam.GetPolicyDocument(ctx, &iam.GetPolicyDocumentArgs{
SourcePolicyDocuments: interface{}{
source.Json,
},
Statements: []iam.GetPolicyDocumentStatement{
iam.GetPolicyDocumentStatement{
Sid: pulumi.StringRef("SidToOverride"),
Actions: []string{
"s3:*",
},
Resources: []string{
"arn:aws:s3:::somebucket",
"arn:aws:s3:::somebucket/*",
},
},
},
}, nil);
if err != nil {
return err
}
return nil
})
}
: 35:24: expected expression (and 8 more errors)
```

### Successes

<details>

<summary>typescript</summary>

```typescript
import * as pulumi from "@pulumi/pulumi";
import * as aws from "@pulumi/aws";

const source = aws.iam.getPolicyDocument({
    statements: [
        {
            actions: ["ec2:*"],
            resources: ["*"],
        },
        {
            sid: "SidToOverride",
            actions: ["s3:*"],
            resources: ["*"],
        },
    ],
});
const sourceDocumentExample = source.then(source => aws.iam.getPolicyDocument({
    sourcePolicyDocuments: [source.json],
    statements: [{
        sid: "SidToOverride",
        actions: ["s3:*"],
        resources: [
            "arn:aws:s3:::somebucket",
            "arn:aws:s3:::somebucket/*",
        ],
    }],
}));
```

</details>

<details>

<summary>python</summary>

```python
import pulumi
import pulumi_aws as aws

source = aws.iam.get_policy_document(statements=[
    aws.iam.GetPolicyDocumentStatementArgs(
        actions=["ec2:*"],
        resources=["*"],
    ),
    aws.iam.GetPolicyDocumentStatementArgs(
        sid="SidToOverride",
        actions=["s3:*"],
        resources=["*"],
    ),
])
source_document_example = aws.iam.get_policy_document(source_policy_documents=[source.json],
    statements=[aws.iam.GetPolicyDocumentStatementArgs(
        sid="SidToOverride",
        actions=["s3:*"],
        resources=[
            "arn:aws:s3:::somebucket",
            "arn:aws:s3:::somebucket/*",
        ],
    )])
```

</details>

<details>

<summary>csharp</summary>

```csharp
using System.Collections.Generic;
using Pulumi;
using Aws = Pulumi.Aws;

return await Deployment.RunAsync(() => 
{
    var source = Aws.Iam.GetPolicyDocument.Invoke(new()
    {
        Statements = new[]
        {
            new Aws.Iam.Inputs.GetPolicyDocumentStatementInputArgs
            {
                Actions = new[]
                {
                    "ec2:*",
                },
                Resources = new[]
                {
                    "*",
                },
            },
            new Aws.Iam.Inputs.GetPolicyDocumentStatementInputArgs
            {
                Sid = "SidToOverride",
                Actions = new[]
                {
                    "s3:*",
                },
                Resources = new[]
                {
                    "*",
                },
            },
        },
    });

    var sourceDocumentExample = Aws.Iam.GetPolicyDocument.Invoke(new()
    {
        SourcePolicyDocuments = new[]
        {
            source.Apply(getPolicyDocumentResult => getPolicyDocumentResult.Json),
        },
        Statements = new[]
        {
            new Aws.Iam.Inputs.GetPolicyDocumentStatementInputArgs
            {
                Sid = "SidToOverride",
                Actions = new[]
                {
                    "s3:*",
                },
                Resources = new[]
                {
                    "arn:aws:s3:::somebucket",
                    "arn:aws:s3:::somebucket/*",
                },
            },
        },
    });

});
```

</details>

<details>

<summary>yaml</summary>

```yaml
variables:
  source:
    Fn::Invoke:
      Function: aws:iam:getPolicyDocument
      Arguments:
        statements:
          - actions:
              - ec2:*
            resources:
              - '*'
          - sid: SidToOverride
            actions:
              - s3:*
            resources:
              - '*'
  sourceDocumentExample:
    Fn::Invoke:
      Function: aws:iam:getPolicyDocument
      Arguments:
        sourcePolicyDocuments:
          - ${source.json}
        statements:
          - sid: SidToOverride
            actions:
              - s3:*
            resources:
              - arn:aws:s3:::somebucket
              - arn:aws:s3:::somebucket/*
```

</details>

<details>

<summary>java</summary>

```java
package generated_program;

import com.pulumi.Context;
import com.pulumi.Pulumi;
import com.pulumi.core.Output;
import com.pulumi.aws.iam.IamFunctions;
import com.pulumi.aws.iam.inputs.GetPolicyDocumentArgs;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;

public class App {
    public static void main(String[] args) {
        Pulumi.run(App::stack);
    }

    public static void stack(Context ctx) {
        final var source = IamFunctions.getPolicyDocument(GetPolicyDocumentArgs.builder()
            .statements(            
                GetPolicyDocumentStatementArgs.builder()
                    .actions("ec2:*")
                    .resources("*")
                    .build(),
                GetPolicyDocumentStatementArgs.builder()
                    .sid("SidToOverride")
                    .actions("s3:*")
                    .resources("*")
                    .build())
            .build());

        final var sourceDocumentExample = IamFunctions.getPolicyDocument(GetPolicyDocumentArgs.builder()
            .sourcePolicyDocuments(source.applyValue(getPolicyDocumentResult -> getPolicyDocumentResult.json()))
            .statements(GetPolicyDocumentStatementArgs.builder()
                .sid("SidToOverride")
                .actions("s3:*")
                .resources(                
                    "arn:aws:s3:::somebucket",
                    "arn:aws:s3:::somebucket/*")
                .build())
            .build());

    }
}
```

</details>

## [*partial failure*] Example Using An Override Document

### HCL

```terraform
data "aws_iam_policy_document" "override" {
  statement {
    sid = "SidToOverride"

    actions   = ["s3:*"]
    resources = ["*"]
  }
}

data "aws_iam_policy_document" "override_policy_document_example" {
  override_policy_documents = [data.aws_iam_policy_document.override.json]

  statement {
    actions   = ["ec2:*"]
    resources = ["*"]
  }

  statement {
    sid = "SidToOverride"

    actions = ["s3:*"]

    resources = [
      "arn:aws:s3:::somebucket",
      "arn:aws:s3:::somebucket/*",
    ]
  }
}

```

### Failed Languages

#### go

```text
failed to convert HCL for #/functions/aws:iam/getPolicyDocument:getPolicyDocument to go: invalid Go source code:

package main

import (

"github.com/pulumi/pulumi/sdk/v3/go/pulumi"
"github.com/pulumi/pulumi-aws/sdk/v5/go/aws/iam"
)
func main() {
pulumi.Run(func(ctx *pulumi.Context) error {
override, err := iam.GetPolicyDocument(ctx, &iam.GetPolicyDocumentArgs{
Statements: []iam.GetPolicyDocumentStatement{
iam.GetPolicyDocumentStatement{
Sid: pulumi.StringRef("SidToOverride"),
Actions: []string{
"s3:*",
},
Resources: []string{
"*",
},
},
},
}, nil);
if err != nil {
return err
}
_, err = iam.GetPolicyDocument(ctx, &iam.GetPolicyDocumentArgs{
OverridePolicyDocuments: interface{}{
override.Json,
},
Statements: []iam.GetPolicyDocumentStatement{
iam.GetPolicyDocumentStatement{
Actions: []string{
"ec2:*",
},
Resources: []string{
"*",
},
},
iam.GetPolicyDocumentStatement{
Sid: pulumi.StringRef("SidToOverride"),
Actions: []string{
"s3:*",
},
Resources: []string{
"arn:aws:s3:::somebucket",
"arn:aws:s3:::somebucket/*",
},
},
},
}, nil);
if err != nil {
return err
}
return nil
})
}
: 27:26: expected expression (and 8 more errors)
```

### Successes

<details>

<summary>yaml</summary>

```yaml
variables:
  override:
    Fn::Invoke:
      Function: aws:iam:getPolicyDocument
      Arguments:
        statements:
          - sid: SidToOverride
            actions:
              - s3:*
            resources:
              - '*'
  overridePolicyDocumentExample:
    Fn::Invoke:
      Function: aws:iam:getPolicyDocument
      Arguments:
        overridePolicyDocuments:
          - ${override.json}
        statements:
          - actions:
              - ec2:*
            resources:
              - '*'
          - sid: SidToOverride
            actions:
              - s3:*
            resources:
              - arn:aws:s3:::somebucket
              - arn:aws:s3:::somebucket/*
```

</details>

<details>

<summary>java</summary>

```java
package generated_program;

import com.pulumi.Context;
import com.pulumi.Pulumi;
import com.pulumi.core.Output;
import com.pulumi.aws.iam.IamFunctions;
import com.pulumi.aws.iam.inputs.GetPolicyDocumentArgs;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;

public class App {
    public static void main(String[] args) {
        Pulumi.run(App::stack);
    }

    public static void stack(Context ctx) {
        final var override = IamFunctions.getPolicyDocument(GetPolicyDocumentArgs.builder()
            .statements(GetPolicyDocumentStatementArgs.builder()
                .sid("SidToOverride")
                .actions("s3:*")
                .resources("*")
                .build())
            .build());

        final var overridePolicyDocumentExample = IamFunctions.getPolicyDocument(GetPolicyDocumentArgs.builder()
            .overridePolicyDocuments(override.applyValue(getPolicyDocumentResult -> getPolicyDocumentResult.json()))
            .statements(            
                GetPolicyDocumentStatementArgs.builder()
                    .actions("ec2:*")
                    .resources("*")
                    .build(),
                GetPolicyDocumentStatementArgs.builder()
                    .sid("SidToOverride")
                    .actions("s3:*")
                    .resources(                    
                        "arn:aws:s3:::somebucket",
                        "arn:aws:s3:::somebucket/*")
                    .build())
            .build());

    }
}
```

</details>

<details>

<summary>typescript</summary>

```typescript
import * as pulumi from "@pulumi/pulumi";
import * as aws from "@pulumi/aws";

const override = aws.iam.getPolicyDocument({
    statements: [{
        sid: "SidToOverride",
        actions: ["s3:*"],
        resources: ["*"],
    }],
});
const overridePolicyDocumentExample = override.then(override => aws.iam.getPolicyDocument({
    overridePolicyDocuments: [override.json],
    statements: [
        {
            actions: ["ec2:*"],
            resources: ["*"],
        },
        {
            sid: "SidToOverride",
            actions: ["s3:*"],
            resources: [
                "arn:aws:s3:::somebucket",
                "arn:aws:s3:::somebucket/*",
            ],
        },
    ],
}));
```

</details>

<details>

<summary>python</summary>

```python
import pulumi
import pulumi_aws as aws

override = aws.iam.get_policy_document(statements=[aws.iam.GetPolicyDocumentStatementArgs(
    sid="SidToOverride",
    actions=["s3:*"],
    resources=["*"],
)])
override_policy_document_example = aws.iam.get_policy_document(override_policy_documents=[override.json],
    statements=[
        aws.iam.GetPolicyDocumentStatementArgs(
            actions=["ec2:*"],
            resources=["*"],
        ),
        aws.iam.GetPolicyDocumentStatementArgs(
            sid="SidToOverride",
            actions=["s3:*"],
            resources=[
                "arn:aws:s3:::somebucket",
                "arn:aws:s3:::somebucket/*",
            ],
        ),
    ])
```

</details>

<details>

<summary>csharp</summary>

```csharp
using System.Collections.Generic;
using Pulumi;
using Aws = Pulumi.Aws;

return await Deployment.RunAsync(() => 
{
    var @override = Aws.Iam.GetPolicyDocument.Invoke(new()
    {
        Statements = new[]
        {
            new Aws.Iam.Inputs.GetPolicyDocumentStatementInputArgs
            {
                Sid = "SidToOverride",
                Actions = new[]
                {
                    "s3:*",
                },
                Resources = new[]
                {
                    "*",
                },
            },
        },
    });

    var overridePolicyDocumentExample = Aws.Iam.GetPolicyDocument.Invoke(new()
    {
        OverridePolicyDocuments = new[]
        {
            @override.Apply(getPolicyDocumentResult => getPolicyDocumentResult.Json),
        },
        Statements = new[]
        {
            new Aws.Iam.Inputs.GetPolicyDocumentStatementInputArgs
            {
                Actions = new[]
                {
                    "ec2:*",
                },
                Resources = new[]
                {
                    "*",
                },
            },
            new Aws.Iam.Inputs.GetPolicyDocumentStatementInputArgs
            {
                Sid = "SidToOverride",
                Actions = new[]
                {
                    "s3:*",
                },
                Resources = new[]
                {
                    "arn:aws:s3:::somebucket",
                    "arn:aws:s3:::somebucket/*",
                },
            },
        },
    });

});
```

</details>

## [*partial failure*] Example with Both Source and Override Documents

### HCL

```terraform
data "aws_iam_policy_document" "source" {
  statement {
    sid       = "OverridePlaceholder"
    actions   = ["ec2:DescribeAccountAttributes"]
    resources = ["*"]
  }
}

data "aws_iam_policy_document" "override" {
  statement {
    sid       = "OverridePlaceholder"
    actions   = ["s3:GetObject"]
    resources = ["*"]
  }
}

data "aws_iam_policy_document" "politik" {
  source_policy_documents   = [data.aws_iam_policy_document.source.json]
  override_policy_documents = [data.aws_iam_policy_document.override.json]
}

```

### Failed Languages

#### go

```text
failed to convert HCL for #/functions/aws:iam/getPolicyDocument:getPolicyDocument to go: invalid Go source code:

package main

import (

"github.com/pulumi/pulumi/sdk/v3/go/pulumi"
"github.com/pulumi/pulumi-aws/sdk/v5/go/aws/iam"
)
func main() {
pulumi.Run(func(ctx *pulumi.Context) error {
source, err := iam.GetPolicyDocument(ctx, &iam.GetPolicyDocumentArgs{
Statements: []iam.GetPolicyDocumentStatement{
iam.GetPolicyDocumentStatement{
Sid: pulumi.StringRef("OverridePlaceholder"),
Actions: []string{
"ec2:DescribeAccountAttributes",
},
Resources: []string{
"*",
},
},
},
}, nil);
if err != nil {
return err
}
override, err := iam.GetPolicyDocument(ctx, &iam.GetPolicyDocumentArgs{
Statements: []iam.GetPolicyDocumentStatement{
iam.GetPolicyDocumentStatement{
Sid: pulumi.StringRef("OverridePlaceholder"),
Actions: []string{
"s3:GetObject",
},
Resources: []string{
"*",
},
},
},
}, nil);
if err != nil {
return err
}
_, err = iam.GetPolicyDocument(ctx, &iam.GetPolicyDocumentArgs{
SourcePolicyDocuments: interface{}{
source.Json,
},
OverridePolicyDocuments: interface{}{
override.Json,
},
}, nil);
if err != nil {
return err
}
return nil
})
}
: 43:24: expected expression (and 8 more errors)
```

### Successes

<details>

<summary>yaml</summary>

```yaml
variables:
  source:
    Fn::Invoke:
      Function: aws:iam:getPolicyDocument
      Arguments:
        statements:
          - sid: OverridePlaceholder
            actions:
              - ec2:DescribeAccountAttributes
            resources:
              - '*'
  override:
    Fn::Invoke:
      Function: aws:iam:getPolicyDocument
      Arguments:
        statements:
          - sid: OverridePlaceholder
            actions:
              - s3:GetObject
            resources:
              - '*'
  politik:
    Fn::Invoke:
      Function: aws:iam:getPolicyDocument
      Arguments:
        sourcePolicyDocuments:
          - ${source.json}
        overridePolicyDocuments:
          - ${override.json}
```

</details>

<details>

<summary>java</summary>

```java
package generated_program;

import com.pulumi.Context;
import com.pulumi.Pulumi;
import com.pulumi.core.Output;
import com.pulumi.aws.iam.IamFunctions;
import com.pulumi.aws.iam.inputs.GetPolicyDocumentArgs;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;

public class App {
    public static void main(String[] args) {
        Pulumi.run(App::stack);
    }

    public static void stack(Context ctx) {
        final var source = IamFunctions.getPolicyDocument(GetPolicyDocumentArgs.builder()
            .statements(GetPolicyDocumentStatementArgs.builder()
                .sid("OverridePlaceholder")
                .actions("ec2:DescribeAccountAttributes")
                .resources("*")
                .build())
            .build());

        final var override = IamFunctions.getPolicyDocument(GetPolicyDocumentArgs.builder()
            .statements(GetPolicyDocumentStatementArgs.builder()
                .sid("OverridePlaceholder")
                .actions("s3:GetObject")
                .resources("*")
                .build())
            .build());

        final var politik = IamFunctions.getPolicyDocument(GetPolicyDocumentArgs.builder()
            .sourcePolicyDocuments(source.applyValue(getPolicyDocumentResult -> getPolicyDocumentResult.json()))
            .overridePolicyDocuments(override.applyValue(getPolicyDocumentResult -> getPolicyDocumentResult.json()))
            .build());

    }
}
```

</details>

<details>

<summary>typescript</summary>

```typescript
import * as pulumi from "@pulumi/pulumi";
import * as aws from "@pulumi/aws";

const source = aws.iam.getPolicyDocument({
    statements: [{
        sid: "OverridePlaceholder",
        actions: ["ec2:DescribeAccountAttributes"],
        resources: ["*"],
    }],
});
const override = aws.iam.getPolicyDocument({
    statements: [{
        sid: "OverridePlaceholder",
        actions: ["s3:GetObject"],
        resources: ["*"],
    }],
});
const politik = Promise.all([source, override]).then(([source, override]) => aws.iam.getPolicyDocument({
    sourcePolicyDocuments: [source.json],
    overridePolicyDocuments: [override.json],
}));
```

</details>

<details>

<summary>python</summary>

```python
import pulumi
import pulumi_aws as aws

source = aws.iam.get_policy_document(statements=[aws.iam.GetPolicyDocumentStatementArgs(
    sid="OverridePlaceholder",
    actions=["ec2:DescribeAccountAttributes"],
    resources=["*"],
)])
override = aws.iam.get_policy_document(statements=[aws.iam.GetPolicyDocumentStatementArgs(
    sid="OverridePlaceholder",
    actions=["s3:GetObject"],
    resources=["*"],
)])
politik = aws.iam.get_policy_document(source_policy_documents=[source.json],
    override_policy_documents=[override.json])
```

</details>

<details>

<summary>csharp</summary>

```csharp
using System.Collections.Generic;
using Pulumi;
using Aws = Pulumi.Aws;

return await Deployment.RunAsync(() => 
{
    var source = Aws.Iam.GetPolicyDocument.Invoke(new()
    {
        Statements = new[]
        {
            new Aws.Iam.Inputs.GetPolicyDocumentStatementInputArgs
            {
                Sid = "OverridePlaceholder",
                Actions = new[]
                {
                    "ec2:DescribeAccountAttributes",
                },
                Resources = new[]
                {
                    "*",
                },
            },
        },
    });

    var @override = Aws.Iam.GetPolicyDocument.Invoke(new()
    {
        Statements = new[]
        {
            new Aws.Iam.Inputs.GetPolicyDocumentStatementInputArgs
            {
                Sid = "OverridePlaceholder",
                Actions = new[]
                {
                    "s3:GetObject",
                },
                Resources = new[]
                {
                    "*",
                },
            },
        },
    });

    var politik = Aws.Iam.GetPolicyDocument.Invoke(new()
    {
        SourcePolicyDocuments = new[]
        {
            source.Apply(getPolicyDocumentResult => getPolicyDocumentResult.Json),
        },
        OverridePolicyDocuments = new[]
        {
            @override.Apply(getPolicyDocumentResult => getPolicyDocumentResult.Json),
        },
    });

});
```

</details>

## [*partial failure*] Example of Merging Source Documents

### HCL

```terraform
data "aws_iam_policy_document" "source_one" {
  statement {
    actions   = ["ec2:*"]
    resources = ["*"]
  }

  statement {
    sid = "UniqueSidOne"

    actions   = ["s3:*"]
    resources = ["*"]
  }
}

data "aws_iam_policy_document" "source_two" {
  statement {
    sid = "UniqueSidTwo"

    actions   = ["iam:*"]
    resources = ["*"]
  }

  statement {
    actions   = ["lambda:*"]
    resources = ["*"]
  }
}

data "aws_iam_policy_document" "combined" {
  source_policy_documents = [
    data.aws_iam_policy_document.source_one.json,
    data.aws_iam_policy_document.source_two.json
  ]
}

```

### Failed Languages

#### go

```text
failed to convert HCL for #/functions/aws:iam/getPolicyDocument:getPolicyDocument to go: invalid Go source code:

package main

import (

"github.com/pulumi/pulumi/sdk/v3/go/pulumi"
"github.com/pulumi/pulumi-aws/sdk/v5/go/aws/iam"
)
func main() {
pulumi.Run(func(ctx *pulumi.Context) error {
sourceOne, err := iam.GetPolicyDocument(ctx, &iam.GetPolicyDocumentArgs{
Statements: []iam.GetPolicyDocumentStatement{
iam.GetPolicyDocumentStatement{
Actions: []string{
"ec2:*",
},
Resources: []string{
"*",
},
},
iam.GetPolicyDocumentStatement{
Sid: pulumi.StringRef("UniqueSidOne"),
Actions: []string{
"s3:*",
},
Resources: []string{
"*",
},
},
},
}, nil);
if err != nil {
return err
}
sourceTwo, err := iam.GetPolicyDocument(ctx, &iam.GetPolicyDocumentArgs{
Statements: []iam.GetPolicyDocumentStatement{
iam.GetPolicyDocumentStatement{
Sid: pulumi.StringRef("UniqueSidTwo"),
Actions: []string{
"iam:*",
},
Resources: []string{
"*",
},
},
iam.GetPolicyDocumentStatement{
Actions: []string{
"lambda:*",
},
Resources: []string{
"*",
},
},
},
}, nil);
if err != nil {
return err
}
_, err = iam.GetPolicyDocument(ctx, &iam.GetPolicyDocumentArgs{
SourcePolicyDocuments: interface{}{
sourceOne.Json,
sourceTwo.Json,
},
}, nil);
if err != nil {
return err
}
return nil
})
}
: 59:24: expected expression (and 7 more errors)
```

### Successes

<details>

<summary>python</summary>

```python
import pulumi
import pulumi_aws as aws

source_one = aws.iam.get_policy_document(statements=[
    aws.iam.GetPolicyDocumentStatementArgs(
        actions=["ec2:*"],
        resources=["*"],
    ),
    aws.iam.GetPolicyDocumentStatementArgs(
        sid="UniqueSidOne",
        actions=["s3:*"],
        resources=["*"],
    ),
])
source_two = aws.iam.get_policy_document(statements=[
    aws.iam.GetPolicyDocumentStatementArgs(
        sid="UniqueSidTwo",
        actions=["iam:*"],
        resources=["*"],
    ),
    aws.iam.GetPolicyDocumentStatementArgs(
        actions=["lambda:*"],
        resources=["*"],
    ),
])
combined = aws.iam.get_policy_document(source_policy_documents=[
    source_one.json,
    source_two.json,
])
```

</details>

<details>

<summary>csharp</summary>

```csharp
using System.Collections.Generic;
using Pulumi;
using Aws = Pulumi.Aws;

return await Deployment.RunAsync(() => 
{
    var sourceOne = Aws.Iam.GetPolicyDocument.Invoke(new()
    {
        Statements = new[]
        {
            new Aws.Iam.Inputs.GetPolicyDocumentStatementInputArgs
            {
                Actions = new[]
                {
                    "ec2:*",
                },
                Resources = new[]
                {
                    "*",
                },
            },
            new Aws.Iam.Inputs.GetPolicyDocumentStatementInputArgs
            {
                Sid = "UniqueSidOne",
                Actions = new[]
                {
                    "s3:*",
                },
                Resources = new[]
                {
                    "*",
                },
            },
        },
    });

    var sourceTwo = Aws.Iam.GetPolicyDocument.Invoke(new()
    {
        Statements = new[]
        {
            new Aws.Iam.Inputs.GetPolicyDocumentStatementInputArgs
            {
                Sid = "UniqueSidTwo",
                Actions = new[]
                {
                    "iam:*",
                },
                Resources = new[]
                {
                    "*",
                },
            },
            new Aws.Iam.Inputs.GetPolicyDocumentStatementInputArgs
            {
                Actions = new[]
                {
                    "lambda:*",
                },
                Resources = new[]
                {
                    "*",
                },
            },
        },
    });

    var combined = Aws.Iam.GetPolicyDocument.Invoke(new()
    {
        SourcePolicyDocuments = new[]
        {
            sourceOne.Apply(getPolicyDocumentResult => getPolicyDocumentResult.Json),
            sourceTwo.Apply(getPolicyDocumentResult => getPolicyDocumentResult.Json),
        },
    });

});
```

</details>

<details>

<summary>yaml</summary>

```yaml
variables:
  sourceOne:
    Fn::Invoke:
      Function: aws:iam:getPolicyDocument
      Arguments:
        statements:
          - actions:
              - ec2:*
            resources:
              - '*'
          - sid: UniqueSidOne
            actions:
              - s3:*
            resources:
              - '*'
  sourceTwo:
    Fn::Invoke:
      Function: aws:iam:getPolicyDocument
      Arguments:
        statements:
          - sid: UniqueSidTwo
            actions:
              - iam:*
            resources:
              - '*'
          - actions:
              - lambda:*
            resources:
              - '*'
  combined:
    Fn::Invoke:
      Function: aws:iam:getPolicyDocument
      Arguments:
        sourcePolicyDocuments:
          - ${sourceOne.json}
          - ${sourceTwo.json}
```

</details>

<details>

<summary>java</summary>

```java
package generated_program;

import com.pulumi.Context;
import com.pulumi.Pulumi;
import com.pulumi.core.Output;
import com.pulumi.aws.iam.IamFunctions;
import com.pulumi.aws.iam.inputs.GetPolicyDocumentArgs;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;

public class App {
    public static void main(String[] args) {
        Pulumi.run(App::stack);
    }

    public static void stack(Context ctx) {
        final var sourceOne = IamFunctions.getPolicyDocument(GetPolicyDocumentArgs.builder()
            .statements(            
                GetPolicyDocumentStatementArgs.builder()
                    .actions("ec2:*")
                    .resources("*")
                    .build(),
                GetPolicyDocumentStatementArgs.builder()
                    .sid("UniqueSidOne")
                    .actions("s3:*")
                    .resources("*")
                    .build())
            .build());

        final var sourceTwo = IamFunctions.getPolicyDocument(GetPolicyDocumentArgs.builder()
            .statements(            
                GetPolicyDocumentStatementArgs.builder()
                    .sid("UniqueSidTwo")
                    .actions("iam:*")
                    .resources("*")
                    .build(),
                GetPolicyDocumentStatementArgs.builder()
                    .actions("lambda:*")
                    .resources("*")
                    .build())
            .build());

        final var combined = IamFunctions.getPolicyDocument(GetPolicyDocumentArgs.builder()
            .sourcePolicyDocuments(            
                sourceOne.applyValue(getPolicyDocumentResult -> getPolicyDocumentResult.json()),
                sourceTwo.applyValue(getPolicyDocumentResult -> getPolicyDocumentResult.json()))
            .build());

    }
}
```

</details>

<details>

<summary>typescript</summary>

```typescript
import * as pulumi from "@pulumi/pulumi";
import * as aws from "@pulumi/aws";

const sourceOne = aws.iam.getPolicyDocument({
    statements: [
        {
            actions: ["ec2:*"],
            resources: ["*"],
        },
        {
            sid: "UniqueSidOne",
            actions: ["s3:*"],
            resources: ["*"],
        },
    ],
});
const sourceTwo = aws.iam.getPolicyDocument({
    statements: [
        {
            sid: "UniqueSidTwo",
            actions: ["iam:*"],
            resources: ["*"],
        },
        {
            actions: ["lambda:*"],
            resources: ["*"],
        },
    ],
});
const combined = Promise.all([sourceOne, sourceTwo]).then(([sourceOne, sourceTwo]) => aws.iam.getPolicyDocument({
    sourcePolicyDocuments: [
        sourceOne.json,
        sourceTwo.json,
    ],
}));
```

</details>

## [*partial failure*] Example of Merging Override Documents

### HCL

```terraform
data "aws_iam_policy_document" "policy_one" {
  statement {
    sid    = "OverridePlaceHolderOne"
    effect = "Allow"

    actions   = ["s3:*"]
    resources = ["*"]
  }
}

data "aws_iam_policy_document" "policy_two" {
  statement {
    effect    = "Allow"
    actions   = ["ec2:*"]
    resources = ["*"]
  }

  statement {
    sid    = "OverridePlaceHolderTwo"
    effect = "Allow"

    actions   = ["iam:*"]
    resources = ["*"]
  }
}

data "aws_iam_policy_document" "policy_three" {
  statement {
    sid    = "OverridePlaceHolderOne"
    effect = "Deny"

    actions   = ["logs:*"]
    resources = ["*"]
  }
}

data "aws_iam_policy_document" "combined" {
  override_policy_documents = [
    data.aws_iam_policy_document.policy_one.json,
    data.aws_iam_policy_document.policy_two.json,
    data.aws_iam_policy_document.policy_three.json
  ]

  statement {
    sid    = "OverridePlaceHolderTwo"
    effect = "Deny"

    actions   = ["*"]
    resources = ["*"]
  }
}

```

### Failed Languages

#### go

```text
failed to convert HCL for #/functions/aws:iam/getPolicyDocument:getPolicyDocument to go: invalid Go source code:

package main

import (

"github.com/pulumi/pulumi/sdk/v3/go/pulumi"
"github.com/pulumi/pulumi-aws/sdk/v5/go/aws/iam"
)
func main() {
pulumi.Run(func(ctx *pulumi.Context) error {
policyOne, err := iam.GetPolicyDocument(ctx, &iam.GetPolicyDocumentArgs{
Statements: []iam.GetPolicyDocumentStatement{
iam.GetPolicyDocumentStatement{
Sid: pulumi.StringRef("OverridePlaceHolderOne"),
Effect: pulumi.StringRef("Allow"),
Actions: []string{
"s3:*",
},
Resources: []string{
"*",
},
},
},
}, nil);
if err != nil {
return err
}
policyTwo, err := iam.GetPolicyDocument(ctx, &iam.GetPolicyDocumentArgs{
Statements: []iam.GetPolicyDocumentStatement{
iam.GetPolicyDocumentStatement{
Effect: pulumi.StringRef("Allow"),
Actions: []string{
"ec2:*",
},
Resources: []string{
"*",
},
},
iam.GetPolicyDocumentStatement{
Sid: pulumi.StringRef("OverridePlaceHolderTwo"),
Effect: pulumi.StringRef("Allow"),
Actions: []string{
"iam:*",
},
Resources: []string{
"*",
},
},
},
}, nil);
if err != nil {
return err
}
policyThree, err := iam.GetPolicyDocument(ctx, &iam.GetPolicyDocumentArgs{
Statements: []iam.GetPolicyDocumentStatement{
iam.GetPolicyDocumentStatement{
Sid: pulumi.StringRef("OverridePlaceHolderOne"),
Effect: pulumi.StringRef("Deny"),
Actions: []string{
"logs:*",
},
Resources: []string{
"*",
},
},
},
}, nil);
if err != nil {
return err
}
_, err = iam.GetPolicyDocument(ctx, &iam.GetPolicyDocumentArgs{
OverridePolicyDocuments: interface{}{
policyOne.Json,
policyTwo.Json,
policyThree.Json,
},
Statements: []iam.GetPolicyDocumentStatement{
iam.GetPolicyDocumentStatement{
Sid: pulumi.StringRef("OverridePlaceHolderTwo"),
Effect: pulumi.StringRef("Deny"),
Actions: []string{
"*",
},
Resources: []string{
"*",
},
},
},
}, nil);
if err != nil {
return err
}
return nil
})
}
: 71:26: expected expression (and 8 more errors)
```

### Successes

<details>

<summary>csharp</summary>

```csharp
using System.Collections.Generic;
using Pulumi;
using Aws = Pulumi.Aws;

return await Deployment.RunAsync(() => 
{
    var policyOne = Aws.Iam.GetPolicyDocument.Invoke(new()
    {
        Statements = new[]
        {
            new Aws.Iam.Inputs.GetPolicyDocumentStatementInputArgs
            {
                Sid = "OverridePlaceHolderOne",
                Effect = "Allow",
                Actions = new[]
                {
                    "s3:*",
                },
                Resources = new[]
                {
                    "*",
                },
            },
        },
    });

    var policyTwo = Aws.Iam.GetPolicyDocument.Invoke(new()
    {
        Statements = new[]
        {
            new Aws.Iam.Inputs.GetPolicyDocumentStatementInputArgs
            {
                Effect = "Allow",
                Actions = new[]
                {
                    "ec2:*",
                },
                Resources = new[]
                {
                    "*",
                },
            },
            new Aws.Iam.Inputs.GetPolicyDocumentStatementInputArgs
            {
                Sid = "OverridePlaceHolderTwo",
                Effect = "Allow",
                Actions = new[]
                {
                    "iam:*",
                },
                Resources = new[]
                {
                    "*",
                },
            },
        },
    });

    var policyThree = Aws.Iam.GetPolicyDocument.Invoke(new()
    {
        Statements = new[]
        {
            new Aws.Iam.Inputs.GetPolicyDocumentStatementInputArgs
            {
                Sid = "OverridePlaceHolderOne",
                Effect = "Deny",
                Actions = new[]
                {
                    "logs:*",
                },
                Resources = new[]
                {
                    "*",
                },
            },
        },
    });

    var combined = Aws.Iam.GetPolicyDocument.Invoke(new()
    {
        OverridePolicyDocuments = new[]
        {
            policyOne.Apply(getPolicyDocumentResult => getPolicyDocumentResult.Json),
            policyTwo.Apply(getPolicyDocumentResult => getPolicyDocumentResult.Json),
            policyThree.Apply(getPolicyDocumentResult => getPolicyDocumentResult.Json),
        },
        Statements = new[]
        {
            new Aws.Iam.Inputs.GetPolicyDocumentStatementInputArgs
            {
                Sid = "OverridePlaceHolderTwo",
                Effect = "Deny",
                Actions = new[]
                {
                    "*",
                },
                Resources = new[]
                {
                    "*",
                },
            },
        },
    });

});
```

</details>

<details>

<summary>yaml</summary>

```yaml
variables:
  policyOne:
    Fn::Invoke:
      Function: aws:iam:getPolicyDocument
      Arguments:
        statements:
          - sid: OverridePlaceHolderOne
            effect: Allow
            actions:
              - s3:*
            resources:
              - '*'
  policyTwo:
    Fn::Invoke:
      Function: aws:iam:getPolicyDocument
      Arguments:
        statements:
          - effect: Allow
            actions:
              - ec2:*
            resources:
              - '*'
          - sid: OverridePlaceHolderTwo
            effect: Allow
            actions:
              - iam:*
            resources:
              - '*'
  policyThree:
    Fn::Invoke:
      Function: aws:iam:getPolicyDocument
      Arguments:
        statements:
          - sid: OverridePlaceHolderOne
            effect: Deny
            actions:
              - logs:*
            resources:
              - '*'
  combined:
    Fn::Invoke:
      Function: aws:iam:getPolicyDocument
      Arguments:
        overridePolicyDocuments:
          - ${policyOne.json}
          - ${policyTwo.json}
          - ${policyThree.json}
        statements:
          - sid: OverridePlaceHolderTwo
            effect: Deny
            actions:
              - '*'
            resources:
              - '*'
```

</details>

<details>

<summary>java</summary>

```java
package generated_program;

import com.pulumi.Context;
import com.pulumi.Pulumi;
import com.pulumi.core.Output;
import com.pulumi.aws.iam.IamFunctions;
import com.pulumi.aws.iam.inputs.GetPolicyDocumentArgs;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;

public class App {
    public static void main(String[] args) {
        Pulumi.run(App::stack);
    }

    public static void stack(Context ctx) {
        final var policyOne = IamFunctions.getPolicyDocument(GetPolicyDocumentArgs.builder()
            .statements(GetPolicyDocumentStatementArgs.builder()
                .sid("OverridePlaceHolderOne")
                .effect("Allow")
                .actions("s3:*")
                .resources("*")
                .build())
            .build());

        final var policyTwo = IamFunctions.getPolicyDocument(GetPolicyDocumentArgs.builder()
            .statements(            
                GetPolicyDocumentStatementArgs.builder()
                    .effect("Allow")
                    .actions("ec2:*")
                    .resources("*")
                    .build(),
                GetPolicyDocumentStatementArgs.builder()
                    .sid("OverridePlaceHolderTwo")
                    .effect("Allow")
                    .actions("iam:*")
                    .resources("*")
                    .build())
            .build());

        final var policyThree = IamFunctions.getPolicyDocument(GetPolicyDocumentArgs.builder()
            .statements(GetPolicyDocumentStatementArgs.builder()
                .sid("OverridePlaceHolderOne")
                .effect("Deny")
                .actions("logs:*")
                .resources("*")
                .build())
            .build());

        final var combined = IamFunctions.getPolicyDocument(GetPolicyDocumentArgs.builder()
            .overridePolicyDocuments(            
                policyOne.applyValue(getPolicyDocumentResult -> getPolicyDocumentResult.json()),
                policyTwo.applyValue(getPolicyDocumentResult -> getPolicyDocumentResult.json()),
                policyThree.applyValue(getPolicyDocumentResult -> getPolicyDocumentResult.json()))
            .statements(GetPolicyDocumentStatementArgs.builder()
                .sid("OverridePlaceHolderTwo")
                .effect("Deny")
                .actions("*")
                .resources("*")
                .build())
            .build());

    }
}
```

</details>

<details>

<summary>typescript</summary>

```typescript
import * as pulumi from "@pulumi/pulumi";
import * as aws from "@pulumi/aws";

const policyOne = aws.iam.getPolicyDocument({
    statements: [{
        sid: "OverridePlaceHolderOne",
        effect: "Allow",
        actions: ["s3:*"],
        resources: ["*"],
    }],
});
const policyTwo = aws.iam.getPolicyDocument({
    statements: [
        {
            effect: "Allow",
            actions: ["ec2:*"],
            resources: ["*"],
        },
        {
            sid: "OverridePlaceHolderTwo",
            effect: "Allow",
            actions: ["iam:*"],
            resources: ["*"],
        },
    ],
});
const policyThree = aws.iam.getPolicyDocument({
    statements: [{
        sid: "OverridePlaceHolderOne",
        effect: "Deny",
        actions: ["logs:*"],
        resources: ["*"],
    }],
});
const combined = Promise.all([policyOne, policyTwo, policyThree]).then(([policyOne, policyTwo, policyThree]) => aws.iam.getPolicyDocument({
    overridePolicyDocuments: [
        policyOne.json,
        policyTwo.json,
        policyThree.json,
    ],
    statements: [{
        sid: "OverridePlaceHolderTwo",
        effect: "Deny",
        actions: ["*"],
        resources: ["*"],
    }],
}));
```

</details>

<details>

<summary>python</summary>

```python
import pulumi
import pulumi_aws as aws

policy_one = aws.iam.get_policy_document(statements=[aws.iam.GetPolicyDocumentStatementArgs(
    sid="OverridePlaceHolderOne",
    effect="Allow",
    actions=["s3:*"],
    resources=["*"],
)])
policy_two = aws.iam.get_policy_document(statements=[
    aws.iam.GetPolicyDocumentStatementArgs(
        effect="Allow",
        actions=["ec2:*"],
        resources=["*"],
    ),
    aws.iam.GetPolicyDocumentStatementArgs(
        sid="OverridePlaceHolderTwo",
        effect="Allow",
        actions=["iam:*"],
        resources=["*"],
    ),
])
policy_three = aws.iam.get_policy_document(statements=[aws.iam.GetPolicyDocumentStatementArgs(
    sid="OverridePlaceHolderOne",
    effect="Deny",
    actions=["logs:*"],
    resources=["*"],
)])
combined = aws.iam.get_policy_document(override_policy_documents=[
        policy_one.json,
        policy_two.json,
        policy_three.json,
    ],
    statements=[aws.iam.GetPolicyDocumentStatementArgs(
        sid="OverridePlaceHolderTwo",
        effect="Deny",
        actions=["*"],
        resources=["*"],
    )])
```

</details>

## [**complete failure**] #/functions/aws:ec2/getSubnetIds:getSubnetIds

### HCL

```terraform
data "aws_subnet_ids" "example" {
  vpc_id = var.vpc_id
}

data "aws_subnet" "example" {
  for_each = data.aws_subnet_ids.example.ids
  id       = each.value
}

output "subnet_cidr_blocks" {
  value = [for s in data.aws_subnet.example : s.cidr_block]
}

```

### Failed Languages

#### typescript

```text
.pp:3,39-59: cannot iterate over a value of type union(list(string), none); 
```

#### python

```text
.pp:3,39-59: cannot iterate over a value of type union(list(string), none); 
```

#### csharp

```text
.pp:3,39-59: cannot iterate over a value of type union(list(string), none); 
```

#### go

```text
.pp:3,39-59: cannot iterate over a value of type union(list(string), none); 
```

#### yaml

```text
.pp:3,39-59: cannot iterate over a value of type union(list(string), none); 
```

#### java

```text
.pp:3,39-59: cannot iterate over a value of type union(list(string), none); 
```

## [**complete failure**] #/functions/aws:ec2/getSubnetIds:getSubnetIds

### HCL

```terraform
data "aws_subnet_ids" "private" {
  vpc_id = var.vpc_id

  tags = {
    Tier = "Private"
  }
}

resource "aws_instance" "app" {
  for_each      = data.aws_subnet_ids.private.ids
  ami           = var.ami
  instance_type = "t2.micro"
  subnet_id     = each.value
}

```

### Failed Languages

#### typescript

```text
.pp:8,3-27: cannot iterate over a value of type union(list(string), none); 
```

#### python

```text
.pp:8,3-27: cannot iterate over a value of type union(list(string), none); 
```

#### csharp

```text
.pp:8,3-27: cannot iterate over a value of type union(list(string), none); 
```

#### go

```text
.pp:8,3-27: cannot iterate over a value of type union(list(string), none); 
```

#### yaml

```text
.pp:8,3-27: cannot iterate over a value of type union(list(string), none); 
```

#### java

```text
.pp:8,3-27: cannot iterate over a value of type union(list(string), none); 
```

## [**complete failure**] #/functions/aws:eks/getNodeGroups:getNodeGroups

### HCL

```terraform
data "aws_eks_node_groups" "example" {
  cluster_name = "example"
}

data "aws_eks_node_group" "example" {
  for_each = data.aws_eks_node_groups.example.names

  cluster_name    = "example"
  node_group_name = each.value
}

```

### Failed Languages

#### go

```text
.pp:3,42-65: cannot iterate over a value of type union(list(string), none); 
```

#### yaml

```text
.pp:3,42-65: cannot iterate over a value of type union(list(string), none); 
```

#### java

```text
.pp:3,42-65: cannot iterate over a value of type union(list(string), none); 
```

#### typescript

```text
.pp:3,42-65: cannot iterate over a value of type union(list(string), none); 
```

#### python

```text
.pp:3,42-65: cannot iterate over a value of type union(list(string), none); 
```

#### csharp

```text
.pp:3,42-65: cannot iterate over a value of type union(list(string), none); 
```

## [**complete failure**] #/functions/aws:iot/getEndpoint:getEndpoint

### HCL

```terraform
data "aws_iot_endpoint" "example" {}

resource "kubernetes_pod" "agent" {
  metadata {
    name = "my-device"
  }

  spec {
    container {
      image = "gcr.io/my-project/image-name"
      name  = "image-name"

      env {
        name  = "IOT_ENDPOINT"
        value = data.aws_iot_endpoint.example.endpoint_address
      }
    }
  }
}

```

### Failed Languages

#### go

```text
:2,10-26: unknown provider 'kubernetes'; unknown provider 'kubernetes', and 1 other diagnostic(s)
```

#### yaml

```text
:2,10-26: unknown provider 'kubernetes'; unknown provider 'kubernetes', and 1 other diagnostic(s)
```

#### java

```text
:2,10-26: unknown provider 'kubernetes'; unknown provider 'kubernetes', and 1 other diagnostic(s)
```

#### typescript

```text
:2,10-26: unknown provider 'kubernetes'; unknown provider 'kubernetes', and 1 other diagnostic(s)
```

#### python

```text
:2,10-26: unknown provider 'kubernetes'; unknown provider 'kubernetes', and 1 other diagnostic(s)
```

#### csharp

```text
:2,10-26: unknown provider 'kubernetes'; unknown provider 'kubernetes', and 1 other diagnostic(s)
```

## [**complete failure**] #/functions/aws:index/getAvailabilityZone:getAvailabilityZone

### HCL

```terraform
variable "region_number" {
  # Arbitrary mapping of region name to number to use in
  # a VPC's CIDR prefix.
  default = {
    us-east-1      = 1
    us-west-1      = 2
    us-west-2      = 3
    eu-central-1   = 4
    ap-northeast-1 = 5
  }
}

variable "az_number" {
  # Assign a number to each AZ letter used in our configuration
  default = {
    a = 1
    b = 2
    c = 3
    d = 4
    e = 5
    f = 6
  }
}

# Retrieve the AZ where we want to create network resources
# This must be in the region selected on the AWS provider.
data "aws_availability_zone" "example" {
  name = "eu-central-1a"
}

# Create a VPC for the region associated with the AZ
resource "aws_vpc" "example" {
  cidr_block = cidrsubnet("10.0.0.0/8", 4, var.region_number[data.aws_availability_zone.example.region])
}

# Create a subnet for the AZ within the regional VPC
resource "aws_subnet" "example" {
  vpc_id     = aws_vpc.example.id
  cidr_block = cidrsubnet(aws_vpc.example.cidr_block, 4, var.az_number[data.aws_availability_zone.example.name_suffix])
}

```

### Failed Languages

#### python

```text
.pp:27,15-25: unknown function 'cidrsubnet'; , and 1 other diagnostic(s)
```

#### csharp

```text
.pp:27,15-25: unknown function 'cidrsubnet'; , and 1 other diagnostic(s)
```

#### go

```text
.pp:27,15-25: unknown function 'cidrsubnet'; , and 1 other diagnostic(s)
```

#### yaml

```text
.pp:27,15-25: unknown function 'cidrsubnet'; , and 1 other diagnostic(s)
```

#### java

```text
.pp:27,15-25: unknown function 'cidrsubnet'; , and 1 other diagnostic(s)
```

#### typescript

```text
.pp:27,15-25: unknown function 'cidrsubnet'; , and 1 other diagnostic(s)
```

## [**complete failure**] #/functions/aws:lambda/getInvocation:getInvocation

### HCL

```terraform
data "aws_lambda_invocation" "example" {
  function_name = aws_lambda_function.lambda_function_test.function_name

  input = <<JSON
{
  "key1": "value1",
  "key2": "value2"
}
JSON
}

output "result_entry" {
  value = jsondecode(data.aws_lambda_invocation.example.result)["key1"]
}

```

### Failed Languages

#### go

```text
:12,11-21: unknown function 'jsondecode'; , and 1 other diagnostic(s)
```

#### yaml

```text
:12,11-21: unknown function 'jsondecode'; , and 1 other diagnostic(s)
```

#### java

```text
:12,11-21: unknown function 'jsondecode'; , and 1 other diagnostic(s)
```

#### typescript

```text
:12,11-21: unknown function 'jsondecode'; , and 1 other diagnostic(s)
```

#### python

```text
:12,11-21: unknown function 'jsondecode'; , and 1 other diagnostic(s)
```

#### csharp

```text
:12,11-21: unknown function 'jsondecode'; , and 1 other diagnostic(s)
```

## [**complete failure**] #/functions/aws:kms/getSecrets:getSecrets

### HCL

```terraform
$ echo -n 'master-password' > plaintext-password
$ aws kms encrypt --key-id ab123456-c012-4567-890a-deadbeef123 --plaintext fileb://plaintext-password --encryption-context foo=bar --output text --query CiphertextBlob
AQECAHgaPa0J8WadplGCqqVAr4HNvDaFSQ+NaiwIBhmm6qDSFwAAAGIwYAYJKoZIhvcNAQcGoFMwUQIBADBMBgkqhkiG9w0BBwEwHgYJYIZIAWUDBAEuMBEEDI+LoLdvYv8l41OhAAIBEIAfx49FFJCLeYrkfMfAw6XlnxP23MmDBdqP8dPp28OoAQ==

```

### Failed Languages

#### yaml

```text
:0,0-1: Invalid character; This character is not used within the language., and 3 other diagnostic(s)
```

#### java

```text
:0,0-1: Invalid character; This character is not used within the language., and 3 other diagnostic(s)
```

#### typescript

```text
:0,0-1: Invalid character; This character is not used within the language., and 3 other diagnostic(s)
```

#### python

```text
:0,0-1: Invalid character; This character is not used within the language., and 3 other diagnostic(s)
```

#### csharp

```text
:0,0-1: Invalid character; This character is not used within the language., and 3 other diagnostic(s)
```

#### go

```text
:0,0-1: Invalid character; This character is not used within the language., and 3 other diagnostic(s)
```

## [*partial failure*] #/functions/aws:kms/getSecrets:getSecrets

### HCL

```terraform
data "aws_kms_secrets" "example" {
  secret {
    # ... potentially other configuration ...
    name    = "master_password"
    payload = "AQECAHgaPa0J8WadplGCqqVAr4HNvDaFSQ+NaiwIBhmm6qDSFwAAAGIwYAYJKoZIhvcNAQcGoFMwUQIBADBMBgkqhkiG9w0BBwEwHgYJYIZIAWUDBAEuMBEEDI+LoLdvYv8l41OhAAIBEIAfx49FFJCLeYrkfMfAw6XlnxP23MmDBdqP8dPp28OoAQ=="

    context = {
      foo = "bar"
    }
  }

  secret {
    # ... potentially other configuration ...
    name    = "master_username"
    payload = "AQECAHgaPa0J8WadplGCqqVAr4HNvDaFSQ+NaiwIBhmm6qDSFwAAAGIwYAYJKoZIhvcNAQcGoFMwUQIBADBMBgkqhkiG9w0BBwEwHgYJYIZIAWUDBAEuMBEEDI+LoLdvYv8l41OhAAIBEIAfx49FFJCLeYrkfMfAw6XlnxP23MmDBdqP8dPp28OoAQ=="
  }
}

resource "aws_rds_cluster" "example" {
  # ... other configuration ...
  master_password = data.aws_kms_secrets.example.plaintext["master_password"]
  master_username = data.aws_kms_secrets.example.plaintext["master_username"]
}

```

### Failed Languages

#### python

```text
:0,0-0: cannot iterate over a value of type union(map(string), none); , and 1 other diagnostic(s)
```

### Successes

<details>

<summary>go</summary>

```go
package main

import (
	"github.com/pulumi/pulumi-aws/sdk/v5/go/aws/kms"
	"github.com/pulumi/pulumi-aws/sdk/v5/go/aws/rds"
	"github.com/pulumi/pulumi/sdk/v3/go/pulumi"
)

func main() {
	pulumi.Run(func(ctx *pulumi.Context) error {
		exampleSecrets, err := kms.GetSecrets(ctx, &kms.GetSecretsArgs{
			Secrets: []kms.GetSecretsSecret{
				kms.GetSecretsSecret{
					Name:    "master_password",
					Payload: "AQECAHgaPa0J8WadplGCqqVAr4HNvDaFSQ+NaiwIBhmm6qDSFwAAAGIwYAYJKoZIhvcNAQcGoFMwUQIBADBMBgkqhkiG9w0BBwEwHgYJYIZIAWUDBAEuMBEEDI+LoLdvYv8l41OhAAIBEIAfx49FFJCLeYrkfMfAw6XlnxP23MmDBdqP8dPp28OoAQ==",
					Context: map[string]interface{}{
						"foo": "bar",
					},
				},
				kms.GetSecretsSecret{
					Name:    "master_username",
					Payload: "AQECAHgaPa0J8WadplGCqqVAr4HNvDaFSQ+NaiwIBhmm6qDSFwAAAGIwYAYJKoZIhvcNAQcGoFMwUQIBADBMBgkqhkiG9w0BBwEwHgYJYIZIAWUDBAEuMBEEDI+LoLdvYv8l41OhAAIBEIAfx49FFJCLeYrkfMfAw6XlnxP23MmDBdqP8dPp28OoAQ==",
				},
			},
		}, nil)
		if err != nil {
			return err
		}
		_, err = rds.NewCluster(ctx, "exampleCluster", &rds.ClusterArgs{
			MasterPassword: pulumi.String(exampleSecrets.Plaintext.Master_password),
			MasterUsername: pulumi.String(exampleSecrets.Plaintext.Master_username),
		})
		if err != nil {
			return err
		}
		return nil
	})
}
```

</details>

<details>

<summary>yaml</summary>

```yaml
resources:
  exampleCluster:
    type: aws:rds:Cluster
    properties:
      # ... other configuration ...
      masterPassword: ${exampleSecrets.plaintext.master_password}
      masterUsername: ${exampleSecrets.plaintext.master_username}
variables:
  exampleSecrets:
    Fn::Invoke:
      Function: aws:kms:getSecrets
      Arguments:
        secrets:
          - name: master_password
            payload: AQECAHgaPa0J8WadplGCqqVAr4HNvDaFSQ+NaiwIBhmm6qDSFwAAAGIwYAYJKoZIhvcNAQcGoFMwUQIBADBMBgkqhkiG9w0BBwEwHgYJYIZIAWUDBAEuMBEEDI+LoLdvYv8l41OhAAIBEIAfx49FFJCLeYrkfMfAw6XlnxP23MmDBdqP8dPp28OoAQ==
            context:
              foo: bar
          - name: master_username
            payload: AQECAHgaPa0J8WadplGCqqVAr4HNvDaFSQ+NaiwIBhmm6qDSFwAAAGIwYAYJKoZIhvcNAQcGoFMwUQIBADBMBgkqhkiG9w0BBwEwHgYJYIZIAWUDBAEuMBEEDI+LoLdvYv8l41OhAAIBEIAfx49FFJCLeYrkfMfAw6XlnxP23MmDBdqP8dPp28OoAQ==
```

</details>

<details>

<summary>java</summary>

```java
package generated_program;

import com.pulumi.Context;
import com.pulumi.Pulumi;
import com.pulumi.core.Output;
import com.pulumi.aws.kms.KmsFunctions;
import com.pulumi.aws.kms.inputs.GetSecretsArgs;
import com.pulumi.aws.rds.Cluster;
import com.pulumi.aws.rds.ClusterArgs;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;

public class App {
    public static void main(String[] args) {
        Pulumi.run(App::stack);
    }

    public static void stack(Context ctx) {
        final var exampleSecrets = KmsFunctions.getSecrets(GetSecretsArgs.builder()
            .secrets(            
                GetSecretsSecretArgs.builder()
                    .name("master_password")
                    .payload("AQECAHgaPa0J8WadplGCqqVAr4HNvDaFSQ+NaiwIBhmm6qDSFwAAAGIwYAYJKoZIhvcNAQcGoFMwUQIBADBMBgkqhkiG9w0BBwEwHgYJYIZIAWUDBAEuMBEEDI+LoLdvYv8l41OhAAIBEIAfx49FFJCLeYrkfMfAw6XlnxP23MmDBdqP8dPp28OoAQ==")
                    .context(Map.of("foo", "bar"))
                    .build(),
                GetSecretsSecretArgs.builder()
                    .name("master_username")
                    .payload("AQECAHgaPa0J8WadplGCqqVAr4HNvDaFSQ+NaiwIBhmm6qDSFwAAAGIwYAYJKoZIhvcNAQcGoFMwUQIBADBMBgkqhkiG9w0BBwEwHgYJYIZIAWUDBAEuMBEEDI+LoLdvYv8l41OhAAIBEIAfx49FFJCLeYrkfMfAw6XlnxP23MmDBdqP8dPp28OoAQ==")
                    .build())
            .build());

        var exampleCluster = new Cluster("exampleCluster", ClusterArgs.builder()        
            .masterPassword(exampleSecrets.applyValue(getSecretsResult -> getSecretsResult.plaintext().master_password()))
            .masterUsername(exampleSecrets.applyValue(getSecretsResult -> getSecretsResult.plaintext().master_username()))
            .build());

    }
}
```

</details>

<details>

<summary>typescript</summary>

```typescript
import * as pulumi from "@pulumi/pulumi";
import * as aws from "@pulumi/aws";

const exampleSecrets = aws.kms.getSecrets({
    secrets: [
        {
            name: "master_password",
            payload: "AQECAHgaPa0J8WadplGCqqVAr4HNvDaFSQ+NaiwIBhmm6qDSFwAAAGIwYAYJKoZIhvcNAQcGoFMwUQIBADBMBgkqhkiG9w0BBwEwHgYJYIZIAWUDBAEuMBEEDI+LoLdvYv8l41OhAAIBEIAfx49FFJCLeYrkfMfAw6XlnxP23MmDBdqP8dPp28OoAQ==",
            context: {
                foo: "bar",
            },
        },
        {
            name: "master_username",
            payload: "AQECAHgaPa0J8WadplGCqqVAr4HNvDaFSQ+NaiwIBhmm6qDSFwAAAGIwYAYJKoZIhvcNAQcGoFMwUQIBADBMBgkqhkiG9w0BBwEwHgYJYIZIAWUDBAEuMBEEDI+LoLdvYv8l41OhAAIBEIAfx49FFJCLeYrkfMfAw6XlnxP23MmDBdqP8dPp28OoAQ==",
        },
    ],
});
const exampleCluster = new aws.rds.Cluster("exampleCluster", {
    masterPassword: exampleSecrets.then(exampleSecrets => exampleSecrets.plaintext?.master_password),
    masterUsername: exampleSecrets.then(exampleSecrets => exampleSecrets.plaintext?.master_username),
});
```

</details>

<details>

<summary>csharp</summary>

```csharp
using System.Collections.Generic;
using Pulumi;
using Aws = Pulumi.Aws;

return await Deployment.RunAsync(() => 
{
    var exampleSecrets = Aws.Kms.GetSecrets.Invoke(new()
    {
        Secrets = new[]
        {
            new Aws.Kms.Inputs.GetSecretsSecretInputArgs
            {
                Name = "master_password",
                Payload = "AQECAHgaPa0J8WadplGCqqVAr4HNvDaFSQ+NaiwIBhmm6qDSFwAAAGIwYAYJKoZIhvcNAQcGoFMwUQIBADBMBgkqhkiG9w0BBwEwHgYJYIZIAWUDBAEuMBEEDI+LoLdvYv8l41OhAAIBEIAfx49FFJCLeYrkfMfAw6XlnxP23MmDBdqP8dPp28OoAQ==",
                Context = 
                {
                    { "foo", "bar" },
                },
            },
            new Aws.Kms.Inputs.GetSecretsSecretInputArgs
            {
                Name = "master_username",
                Payload = "AQECAHgaPa0J8WadplGCqqVAr4HNvDaFSQ+NaiwIBhmm6qDSFwAAAGIwYAYJKoZIhvcNAQcGoFMwUQIBADBMBgkqhkiG9w0BBwEwHgYJYIZIAWUDBAEuMBEEDI+LoLdvYv8l41OhAAIBEIAfx49FFJCLeYrkfMfAw6XlnxP23MmDBdqP8dPp28OoAQ==",
            },
        },
    });

    var exampleCluster = new Aws.Rds.Cluster("exampleCluster", new()
    {
        MasterPassword = exampleSecrets.Apply(getSecretsResult => getSecretsResult.Plaintext?.Master_password),
        MasterUsername = exampleSecrets.Apply(getSecretsResult => getSecretsResult.Plaintext?.Master_username),
    });

});
```

</details>

## [**complete failure**] #/functions/aws:ec2/getNatGateways:getNatGateways

### HCL

```terraform
data "aws_nat_gateways" "ngws" {
  vpc_id = var.vpc_id

  filter {
    name   = "state"
    values = ["available"]
  }
}

data "aws_nat_gateway" "ngw" {
  count = length(data.aws_nat_gateways.ngws.ids)
  id    = tolist(data.aws_nat_gateways.ngws.ids)[count.index]
}

```

### Failed Languages

#### python

```text
:11,11-17: unknown function 'tolist'; , and 2 other diagnostic(s)
```

#### csharp

```text
:11,11-17: unknown function 'tolist'; , and 2 other diagnostic(s)
```

#### go

```text
:11,11-17: unknown function 'tolist'; , and 2 other diagnostic(s)
```

#### yaml

```text
:11,11-17: unknown function 'tolist'; , and 2 other diagnostic(s)
```

#### java

```text
:11,11-17: unknown function 'tolist'; , and 2 other diagnostic(s)
```

#### typescript

```text
:11,11-17: unknown function 'tolist'; , and 2 other diagnostic(s)
```

## [**complete failure**] #/functions/aws:outposts/getOutpostInstanceType:getOutpostInstanceType

### HCL

```terraform
data "aws_outposts_outpost_instance_type" "example" {
  arn                      = data.aws_outposts_outpost.example.arn
  preferred_instance_types = ["m5.large", "m5.4xlarge"]
}

resource "aws_ec2_instance" "example" {
  # ... other configuration ...

  instance_type = data.aws_outposts_outpost_instance_type.example.instance_type
}

```

### Failed Languages

#### typescript

```text
.pp:4,35-51: malformed token 'aws_ec2_instance': expected 'pkg:module:member'; malformed token 'aws_ec2_instance': expected 'pkg:module:member'
```

#### python

```text
.pp:4,35-51: malformed token 'aws_ec2_instance': expected 'pkg:module:member'; malformed token 'aws_ec2_instance': expected 'pkg:module:member'
```

#### csharp

```text
.pp:4,35-51: malformed token 'aws_ec2_instance': expected 'pkg:module:member'; malformed token 'aws_ec2_instance': expected 'pkg:module:member'
```

#### go

```text
.pp:4,35-51: malformed token 'aws_ec2_instance': expected 'pkg:module:member'; malformed token 'aws_ec2_instance': expected 'pkg:module:member'
```

#### yaml

```text
.pp:4,35-51: malformed token 'aws_ec2_instance': expected 'pkg:module:member'; malformed token 'aws_ec2_instance': expected 'pkg:module:member'
```

#### java

```text
.pp:4,35-51: malformed token 'aws_ec2_instance': expected 'pkg:module:member'; malformed token 'aws_ec2_instance': expected 'pkg:module:member'
```

## [**complete failure**] #/functions/aws:eks/getClusterAuth:getClusterAuth

### HCL

```terraform
data "aws_eks_cluster" "example" {
  name = "example"
}

data "aws_eks_cluster_auth" "example" {
  name = "example"
}

provider "kubernetes" {
  host                   = data.aws_eks_cluster.example.endpoint
  cluster_ca_certificate = base64decode(data.aws_eks_cluster.example.certificate_authority[0].data)
  token                  = data.aws_eks_cluster_auth.example.token
  load_config_file       = false
}

```

### Failed Languages

#### python

```text
:10,28-40: unknown function 'base64decode'; , and 1 other diagnostic(s)
```

#### csharp

```text
:10,28-40: unknown function 'base64decode'; , and 1 other diagnostic(s)
```

#### go

```text
:10,28-40: unknown function 'base64decode'; , and 1 other diagnostic(s)
```

#### yaml

```text
:10,28-40: unknown function 'base64decode'; , and 1 other diagnostic(s)
```

#### java

```text
:10,28-40: unknown function 'base64decode'; , and 1 other diagnostic(s)
```

#### typescript

```text
:10,28-40: unknown function 'base64decode'; , and 1 other diagnostic(s)
```

## [**complete failure**] #/functions/aws:ec2/getLocalGatewayRouteTables:getLocalGatewayRouteTables

### HCL

```terraform
data "aws_ec2_local_gateway_route_table" "foo" {}

output "foo" {
  value = data.aws_ec2_local_gateway_route_table.foo.ids
}

```

### Failed Languages

#### java

```text
:3,53-57: unknown property 'ids' among [tags filter local_gateway_route_table_id id local_gateway_id outpost_arn state]; , and 1 other diagnostic(s)
```

#### typescript

```text
:3,53-57: unknown property 'ids' among [state tags filter local_gateway_route_table_id id local_gateway_id outpost_arn]; , and 1 other diagnostic(s)
```

#### python

```text
:3,53-57: unknown property 'ids' among [local_gateway_route_table_id id local_gateway_id outpost_arn state tags filter]; , and 1 other diagnostic(s)
```

#### csharp

```text
:3,53-57: unknown property 'ids' among [local_gateway_route_table_id id local_gateway_id outpost_arn state tags filter]; , and 1 other diagnostic(s)
```

#### go

```text
:3,53-57: unknown property 'ids' among [tags filter local_gateway_route_table_id id local_gateway_id outpost_arn state]; , and 1 other diagnostic(s)
```

#### yaml

```text
:3,53-57: unknown property 'ids' among [tags filter local_gateway_route_table_id id local_gateway_id outpost_arn state]; , and 1 other diagnostic(s)
```

## [*partial failure*] List all account IDs for the organization

### HCL

```terraform
data "aws_organizations_organization" "example" {}

output "account_ids" {
  value = data.aws_organizations_organization.example.accounts[*].id
}

```

### Failed Languages

#### yaml

```text
.pp:2,11-33: Failed to generate YAML program: Splat; A 'Splat' expression is equivalent in expressive power to a 'for loop', and is not representable in YAML.
If the values of the function are known, you can manually unroll the loop, otherwise it is necessary to switch to a more expressive language.
```

#### go

```text
failed to convert HCL for #/functions/aws:organizations/getOrganization:getOrganization to go: invalid Go source code:

package main

import (

"github.com/pulumi/pulumi/sdk/v3/go/pulumi"
"github.com/pulumi/pulumi-aws/sdk/v5/go/aws/organizations"
)
func main() {
pulumi.Run(func(ctx *pulumi.Context) error {
example, err := organizations.LookupOrganization(ctx, nil, nil);
if err != nil {
return err
}
ctx.Export("accountIds", %!v(PANIC=Format method: fatal: A failure has occurred: unlowered splat expression @ #-functions-aws:organizations-getOrganization:getOrganization.tf.pp:2,11-33))
return nil
})
}
: 14:26: expected operand, found '%' (and 5 more errors)
```

### Successes

<details>

<summary>typescript</summary>

```typescript
import * as pulumi from "@pulumi/pulumi";
import * as aws from "@pulumi/aws";

const example = aws.organizations.getOrganization({});
export const accountIds = [example.then(example => example.accounts)].map(__item => __item?.id);
```

</details>

<details>

<summary>python</summary>

```python
import pulumi
import pulumi_aws as aws

example = aws.organizations.get_organization()
pulumi.export("accountIds", [__item.id for __item in [example.accounts]])
```

</details>

<details>

<summary>csharp</summary>

```csharp
using System.Collections.Generic;
using System.Linq;
using Pulumi;
using Aws = Pulumi.Aws;

return await Deployment.RunAsync(() => 
{
    var example = Aws.Organizations.GetOrganization.Invoke();

    return new Dictionary<string, object?>
    {
        ["accountIds"] = new[]
        {
            example.Apply(getOrganizationResult => getOrganizationResult.Accounts),
        }.Select(__item => __item?.Id).ToList(),
    };
});
```

</details>

<details>

<summary>java</summary>

```java
package generated_program;

import com.pulumi.Context;
import com.pulumi.Pulumi;
import com.pulumi.core.Output;
import com.pulumi.aws.organizations.OrganizationsFunctions;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;

public class App {
    public static void main(String[] args) {
        Pulumi.run(App::stack);
    }

    public static void stack(Context ctx) {
        final var example = OrganizationsFunctions.getOrganization();

        ctx.export("accountIds", example.applyValue(getOrganizationResult -> getOrganizationResult.accounts()).stream().map(element -> element.id()).collect(toList()));
    }
}
```

</details>

## [**complete failure**] #/functions/aws:ssoadmin/getInstances:getInstances

### HCL

```terraform
data "aws_ssoadmin_instances" "example" {}

output "arn" {
  value = tolist(data.aws_ssoadmin_instances.example.arns)[0]
}

output "identity_store_id" {
  value = tolist(data.aws_ssoadmin_instances.example.identity_store_ids)[0]
}

```

### Failed Languages

#### java

```text
:3,11-17: unknown function 'tolist'; , and 3 other diagnostic(s)
```

#### typescript

```text
:3,11-17: unknown function 'tolist'; , and 3 other diagnostic(s)
```

#### python

```text
:3,11-17: unknown function 'tolist'; , and 3 other diagnostic(s)
```

#### csharp

```text
:3,11-17: unknown function 'tolist'; , and 3 other diagnostic(s)
```

#### go

```text
:3,11-17: unknown function 'tolist'; , and 3 other diagnostic(s)
```

#### yaml

```text
:3,11-17: unknown function 'tolist'; , and 3 other diagnostic(s)
```
