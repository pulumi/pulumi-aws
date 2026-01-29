# Pulumi aws Provider

This is a Go-based Pulumi resource provider that bridges the Terraform provider to Pulumi. It generates SDKs for TypeScript/JavaScript, Python, .NET, Go, and Java. The provider uses the Terraform provider as an upstream source via git submodules.

## Build Commands

**Always use `make` targets. Never run custom commands unless explicitly instructed.**

### Primary Targets
- `make build` - Build provider and all SDKs
- `make provider` - Build provider binary
- `make schema` - Generate provider schema
- `make tfgen` - Generate SDKs from schema
- `make upstream` - Initialize upstream submodule

### SDK Targets
- `make build_sdks` - Build all SDK packages
- `make build_nodejs` - Build TypeScript/Node.js SDK
- `make build_python` - Build Python SDK
- `make build_dotnet` - Build .NET SDK
- `make build_go` - Build Go SDK
- `make build_java` - Build Java SDK

### Development Targets
- `make lint_provider` - Lint provider Go code
- `make test_provider` - Run provider unit tests

## Repository Structure

```
provider/             -- Go provider implementation
sdk/                  -- Generated SDKs (never edit directly)
upstream/             -- Terraform provider submodule
scripts/              -- Build utilities
examples/             -- Example Pulumi programs
.ci-mgmt.yaml         -- CI management configuration
Makefile              -- Build orchestration
```

### Key Files
- `provider/resources.go` - Resource definitions
- `provider/resources_test.go` - Unit tests

## Development Workflow

1. Initialize repository: `make upstream`
2. Make changes in `provider/`
3. Lint: `make lint_provider`
4. Test: `make test_provider`
5. Build provider: `make provider`
6. Build SDKs: `make build_sdks`

## Rules

- **Never work directly in `sdk/` folders** - All SDK generation is automated through `make`
- **Never cancel running builds** - Builds may take several minutes
- **Do not run tests in `examples/`** - They require cloud credentials and run in CI
- **Set timeouts to 300+ seconds** for build operations
