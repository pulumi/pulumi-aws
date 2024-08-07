A CallbackFunction is a special type of `aws.lambda.Function` that can be created out of an actual JavaScript function instance. The Pulumi compiler and runtime work in tandem to extract your function, package it up along with its dependencies, upload the package to AWS Lambda, and configure the resulting AWS Lambda resources automatically.

The JavaScript function may capture references to other variables in the surrounding code, including other resources and even imported modules. The Pulumi compiler figures out how to serialize the resulting closure as it uploads and configures the AWS Lambda. This works even if you are composing multiple functions together.

See [Function Serialization](https://www.pulumi.com/docs/concepts/inputs-outputs/function-serialization/) for additional details on this process.

If no IAM Role is specified, CallbackFunction will automatically use the following managed policies:
- `AWSLambda_FullAccess`
- `CloudWatchFullAccessV2`
- `CloudWatchEventsFullAccess`
- `AmazonS3FullAccess`
- `AmazonDynamoDBFullAccess`
- `AmazonSQSFullAccess`
- `AmazonKinesisFullAccess`
- `AWSCloudFormationReadOnlyAccess`
- `AmazonCognitoPowerUser`
- `AWSXrayWriteOnlyAccess`

### Lambda Function Handler

You can provide the JavaScript function used for the Lambda Function's Handler either directly by setting the `callback` input property or instead specify the `callbackFactory`, which is a Javascript function that will be called to produce the callback function that is the entrypoint for the AWS Lambda.
Using `callbackFactory` is useful when there is expensive initialization work that should only be executed once. The factory-function will be invoked once when the final AWS Lambda module is loaded. It can run whatever code it needs, and will end by returning the actual function that Lambda will call into each time the Lambda is invoked.

The callback function should follow the following signature: `(event: E, context: Context, callback: (error?: Error | string | null, result?: R) => void) => Promise<R> | void`. It is recommended to use an async function, otherwise the Lambda execution will run until the `callback` parameter is called and the event loop is empty. See [Define Lambda function handler in Node.js](https://docs.aws.amazon.com/lambda/latest/dg/nodejs-handler.html) for additional details.

### Customizing Lambda function attributes

The Lambdas created by `aws.lambda.CallbackFunction` use reasonable defaults for CPU, memory, IAM, logging, and other configuration.
Should you need to customize these settings, the `aws.lambda.CallbackFunction` resource offers all of the underlying AWS Lambda settings.

For example, to increase the RAM available to your function to 256MB:

```typescript
import * as aws from "@pulumi/aws";

// Create an AWS Lambda function with 256MB RAM
const lambda = new aws.lambda.CallbackFunction("docsHandlerFunc", {
    callback: async(event: aws.s3.BucketEvent) => {
        // ...
    },

    memorySize: 256 /* MB */,
});
```

### Adding/removing files from a function bundle

Occasionally you may need to customize the contents of function bundle before uploading it to AWS Lambda --- for example, to remove unneeded Node.js modules or add certain files or folders to the bundle explicitly. The `codePathOptions` property of `CallbackFunction` allows you to do this.

In this example, a local directory `./config` is added to the function bundle, while an unneeded Node.js module `mime` is removed:

```typescript
import * as aws from "@pulumi/aws";
import * as fs from "fs";

const lambda = new aws.lambda.CallbackFunction("docsHandlerFunc", {
    callback: async(event: aws.s3.BucketEvent) => {
        // ...
    },

    codePathOptions: {

        // Add local files or folders to the Lambda function bundle.
        extraIncludePaths: [
            "./config",
        ],

        // Remove unneeded Node.js packages from the bundle.
        extraExcludePackages: [
            "mime",
        ],
    },
});
```

### Using Lambda layers {#lambda-layers}

[Lambda layers](https://docs.aws.amazon.com/lambda/latest/dg/chapter-layers.html) allow you to share code, configuration, and other assets across multiple Lambda functions. At runtime, AWS Lambda extracts these files into the function's filesystem, where you can access their contents as though they belonged to the function bundle itself.

Layers are managed with the [`aws.lambda.LayerVersion`](/registry/packages/aws/api-docs/lambda/layerversion/) resource, and you can attach them to as many `lambda.Function` or `lambda.CallbackFunction` resources as you need using the function's `layers` property. Here, the preceding program is updated to package the `./config` folder as a Lambda layer instead:

```typescript
import * as pulumi from "@pulumi/pulumi";
import * as aws from "@pulumi/aws";
import * as fs from "fs";

// Create a Lambda layer containing some shared configuration.
const configLayer = new aws.lambda.LayerVersion("config-layer", {
    layerName: "my-config-layer",

    // Use a Pulumi AssetArchive to zip up the contents of the folder.
    code: new pulumi.asset.AssetArchive({
        "config": new pulumi.asset.FileArchive("./config"),
    }),
});

const lambda = new aws.lambda.CallbackFunction("docsHandlerFunc", {
    callback: async(event: aws.s3.BucketEvent) => {
        // ...
    },

    // Attach the config layer to the function.
    layers: [
        configLayer.arn,
    ],
});
```

Notice the path to the file is now `/opt/config/config.json` --- `/opt` being the path at which AWS Lambda extracts the contents of a layer. The configuration layer is now manageable and deployable independently of the Lambda itself, allowing changes to be applied immediately across all functions that use it.

#### Using layers for Node.js dependencies

This same approach can be used for sharing Node.js module dependencies. When you package your dependencies [at the proper path](https://docs.aws.amazon.com/lambda/latest/dg/packaging-layers.html) within the layer zip file, (e.g., `nodejs/node_modules`), AWS Lambda will unpack and expose them automatically to the functions that use them at runtime. This approach can be useful in monorepo scenarios such as the example below, which adds a locally built Node.js module as a layer, then references references the module from within the body of a `CallbackFunction`:

```typescript
import * as pulumi from "@pulumi/pulumi";
import * as aws from "@pulumi/aws";

// Create a layer containing a locally built Node.js module.
const utilsLayer = new aws.lambda.LayerVersion("utils-layer", {
    layerName: "utils",
    code: new pulumi.asset.AssetArchive({

        // Store the module under nodejs/node_modules to make it available
        // on the Node.js module path.
        "nodejs/node_modules/@my-alias/utils": new pulumi.asset.FileArchive("./layers/utils/dist"),
    }),
});

const lambda =  new aws.lambda.CallbackFunction("docsHandlerFunc", {
    callback: async (event: aws.s3.BucketEvent) => {

        // Import the module from the layer at runtime.
        const { sayHello } = await import("@my-alias/utils");

        // Call a function from the utils module.
        console.log(sayHello());
    },

    // Attach the utils layer to the function.
    layers: [
        utilsLayer.arn,
    ],
});
```

Notice the example uses the module name `@my-alias/utils`. To make this work, you'll need to add a few lines to your Pulumi project's `tsconfig.json` file to map your chosen module name to the path of the module's TypeScript source code:

```javascript
{
    "compilerOptions": {
        // ...
        "baseUrl": ".",
        "paths": {
            "@my-alias/utils": [
                "./layers/utils"
            ]
        }
    },
    // ...
}
```


{{% examples %}}
## Example Usage
{{% example %}}
### Basic Lambda Function

```typescript
import * as aws from "@pulumi/aws";

// Create an AWS Lambda function that fetches the Pulumi website and returns the HTTP status
const lambda = new aws.lambda.CallbackFunction("fetcher", {
    callback: async(event) => {
        try {
            const res = await fetch("https://www.pulumi.com");
            console.info("status", res.status);
            return res.status;
        }
        catch (e) {
            console.error(e);
            return 500;
        }
    },
});
```
{{% /example %}}

{{% example %}}
### API Gateway Handler Function
```typescript
import * as apigateway from "@pulumi/aws-apigateway";
import { APIGatewayProxyEvent, Context } from "aws-lambda";

const api = new apigateway.RestAPI("api", {
    routes: [
        {
            path: "/api",
            eventHandler: async (event: APIGatewayProxyEvent, context: Context) => {
                return {
                    statusCode: 200,
                    body: JSON.stringify({
                        eventPath: event.path,
                        functionName: context.functionName,
                    })
                };
            },
        },
    ],
});

export const url = api.url;
```
{{% /example %}}
{{% /examples %}}
