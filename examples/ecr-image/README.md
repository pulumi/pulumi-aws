# examples/ecr-image

This example demonstrates how to use Pulumi to publish a Docker image to Amazon Elastic Container Registry (ECR).

## Steps

1. **Install Dependencies**

    Ensure you have the necessary dependencies installed:

    ```sh
    npm install
    ```

2. **Run Pulumi Up**

    Run Pulumi to create the ECR repository and push the Docker image:

    ```sh
    pulumi up
    ```

    Confirm the changes and wait for the process to complete.

## Files

- `index.ts`: Contains the Pulumi program to create the ECR repository and push the Docker image.
- `Dockerfile`: Dockerfile for building the Docker image.

## Clean Up

To clean up the resources created by Pulumi:

```sh
pulumi destroy
```

## Additional Resources

- [Pulumi AWS Documentation](https://www.pulumi.com/docs/intro/cloud-providers/aws/)
- [Amazon ECR Documentation](https://docs.aws.amazon.com/AmazonECR/latest/userguide/what-is-ecr.html)
