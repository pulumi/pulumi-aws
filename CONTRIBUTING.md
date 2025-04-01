# Contributing to the Pulumi ecosystem

Do you want to contribute to Pulumi? Awesome! We are so happy to have you.
We have a few tips and housekeeping items to help you get up and running.

## Code of Conduct

Please make sure to read and observe our [Code of Conduct](./CODE-OF-CONDUCT.md)

## Community Expectations

Please read about our [contribution guidelines here.](https://github.com/pulumi/pulumi/blob/master/CONTRIBUTING.md#communications)

## Setting up your development environment

### Pulumi prerequisites

Please refer to the [main Pulumi repo](https://github.com/pulumi/pulumi/)'s [CONTRIBUTING.md file](
<https://github.com/pulumi/pulumi/blob/master/CONTRIBUTING.md#developing>) for details on how to get set up with Pulumi.

## Committing Generated Code

You must generate and check in the SDKs on each pull request containing a code change, e.g. adding a new resource to `resources.go`.

1. Run `make tfgen` to re-generate the provider binary.
1. Run `make build_sdks` from the root of this repository
1. Open a pull request containing all changes
1. *Note:* If a large number of seemingly-unrelated diffs are produced by `make build_sdks` (for example, lots of changes to comments unrelated to the change you are making), ensure that the latest dependencies for the provider are installed by running `go mod tidy` in the `provider/` directory of this repository.

## Running Integration Tests

The examples and integration tests in this repository will create and destroy real AWS
cloud resources while running. Before running these tests, make sure that you have
[configured Pulumi with AWS](https://pulumi.io/install/aws.html) successfully once before.

The only additional step you need to take to run tests in this repo is to set the
`AWS_REGION` environment variable to the region you'd like to create test resources in.
The integration tests do try to clean up after themselves by deleting everything that was
created, but in the event of bugs or test failures you may need to go into the AWS Console
and delete resources yourself.

Once you have set `AWS_REGION` and configured your AWS credentials, `make test` will run your integration tests.

## Generating IAM Policies

```bash
aws iam list-policies --scope AWS | jq -f docs/generate-iam-policies.jq -r > policies.go
```

Copy the content of `policies.go` and insert into the `iam_managed_policy.go` file, merging with any existing manual changes. If policies have been removed, we should keep them but mark them as deprecated.

## Updating pulumi-terraform-aws dependency

Keeping the pulumi-terraform-aws dependency up-to-date involves updating the `./upstream` Git sub-module, resolving
patch conflicts, adjusting `resources.go` mappings configurations and re-generating the SDKs. For a fully worked
example, to update to v5.60.0 (actual update in #4309):

```bash
git branch upstream-v5.60.0 && git checkout upstream-v5.60.0
./scripts/upstream.sh checkout
./scripts/upstream.sh rebase -o v5.60.0
# in ./rebase finish the Git rebase and resolve conflicts
./scripts/patch_computed_only.sh
# if patch_computed_only edited anything in ./upstream, commit it
(cd ./upstream && go build ./...) # verify everything builds
# add commits as needed to make it build
./scripts/upstream.sh format_patches
git add ./patches && git commit -m "Update patches for v5.60.0"
(cd upstream && git reset --hard v5.60.0)
git add ./upstream && git commit -m "Move upstream to v5.60.0"
./scripts/upstream.sh init -f # verify patches apply cleanly with no changes
./scripts/tidy-all.sh
git add . && git commit -m "./scripts/tidy-all.sh"
make tfgen # iterate on editing resources.go configurations as needed
git add . && git commit -m "make tfgen"
make build_sdks && git add . && git commit -m "make build_sdks"
```
