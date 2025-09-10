# Pulumi aws Provider

The Pulumi aws provider is a Go-based Pulumi resource provider that bridges the Terraform provider to Pulumi. It generates SDKs for TypeScript/JavaScript, Python, .NET, Go, and Java. The provider uses the Terraform provider as an upstream source via git submodules.

Always reference these instructions first and fallback to search or bash commands only when you encounter unexpected information that does not match the info here.

## Working Effectively

### Prerequisites and Environment Setup
- All required dependencies are automatically installed via the `.github/workflows/copilot-setup-steps.yml` workflow
- This includes Go, Node.js, Python, .NET, Gradle, and all necessary Pulumi tools

### Initial Repository Setup
- Initialize the upstream submodule: `make upstream`

### Build Process
- **ALWAYS use `make` targets** - Never run custom commands unless explicitly told to
- **NEVER work directly in the `sdk/` folder** - All SDK generation and building is automated through `make`
- If a `make` target fails, there is something wrong with the environment setup, not the target itself

### Available Make Targets

#### Primary Build Targets:
- `make build` -- Build the provider and all SDKs
- `make provider` -- Build the provider binary
- `make schema` -- Generate the provider schema  
- `make tfgen` -- Generate SDKs from schema
- `make upstream` -- Initialize upstream submodule

#### SDK Targets:
- `make build_sdks` -- Build all SDK packages
- `make generate_sdks` -- Generate all SDK source code
- `make build_nodejs` -- Build TypeScript/Node.js SDK
- `make build_python` -- Build Python SDK
- `make build_dotnet` -- Build .NET SDK
- `make build_go` -- Build Go SDK
- `make build_java` -- Build Java SDK

#### Development Targets:
- `make lint_provider` -- Lint provider Go code
- `make test_provider` -- Run provider unit tests

### Build Guidelines:
- **NEVER CANCEL** any build command once started - builds may take several minutes
- Set timeouts to 300+ seconds for build operations
- **DO NOT run tests in `examples/`** - They require cloud credentials and will run in PR workflows

## Repository Structure

### Key Directories:
- `provider/` -- Go provider implementation
- `sdk/` -- Generated SDKs for all languages
- `upstream/` -- Git submodule with the Terraform provider
- `scripts/` -- Build and utility scripts
- `examples/` -- Example Pulumi programs (test framework available but skipped)

### Important Files:
- `Makefile` -- Primary build orchestration with all available targets
- `provider/go.mod` -- Provider dependencies
- `.github/workflows/copilot-setup-steps.yml` -- Environment setup for AI coding agents
- `.github/workflows/` -- CI/CD pipelines

## Development Workflow

### Making Code Changes:
1. Initialize repository: `make upstream`
2. Make changes to provider code in `provider/`
3. Validate with: `make lint_provider`
4. Test with: `make test_provider`
5. Build provider: `make provider`
6. Generate and build SDKs: `make build_sdks`

### Validation Steps:
- Always use `make lint_provider` to lint provider code
- Use `make test_provider` to run provider unit tests  
- Use `make build` to validate the full build process

### Working with SDKs:
- **NEVER work directly in `sdk/` folders** - All SDK operations are automated via `make` targets
- All SDKs are generated and built through `make` commands
- TypeScript SDK: Use `make build_nodejs` 
- Python SDK: Use `make build_python`
- .NET SDK: Use `make build_dotnet`  
- Go SDK: Use `make build_go`
- Java SDK: Use `make build_java`

## Validation Scenarios

### Code Quality Validation:
- Use `make lint_provider` to lint provider Go code
- Use `make test_provider` to run provider unit tests
- Use `make build` to validate full build process

### Manual Code Review:
- Check Go code follows standard patterns
- Validate resource definitions in `provider/resources.go`
- Ensure imports and dependencies are correct

## Common Tasks Reference

### Repository Root Contents:
```
.ci-mgmt.yaml          -- CI management configuration
.devcontainer/         -- Dev container setup  
.github/               -- GitHub workflows and templates
.gitmodules           -- Git submodule configuration
.golangci.yml         -- Go linter configuration
.mise.toml            -- Mise tool configuration
CONTRIBUTING.md       -- Contribution guidelines
Makefile              -- Build orchestration with all available targets
README.md             -- Project documentation
devbox.json           -- Development environment
provider/             -- Go provider implementation
scripts/              -- Build utilities
sdk/                  -- Generated SDKs (managed via make targets)
upstream/             -- Terraform provider submodule
```

### Common File Operations:
- **Provider source**: `provider/resources.go` -- Resource definitions
- **Provider tests**: `provider/resources_test.go` -- Unit tests  
- **Generated SDKs**: All in `sdk/` directory, managed via `make` targets only

### Common Development Tasks:
- Run provider tests: `make test_provider`
- Build provider: `make provider` 
- Generate schema: `make schema`
- Build all SDKs: `make build_sdks`

## Build Expectations

- Provider builds: 1-3 minutes depending on system
- SDK generation: 2-5 minutes for all SDKs
- Individual SDK builds: 30 seconds to 2 minutes each
- Full build (`make build`): 5-10 minutes total

Set timeouts of 300+ seconds for build operations and NEVER CANCEL running builds.

## Critical Reminders

- **ALWAYS** use `make` targets - never run custom commands unless explicitly instructed
- **NEVER** work directly in `sdk/` folders - use `make` targets for all SDK operations  
- **DO NOT** run tests in `examples/` - they require cloud credentials
- **FOCUS** on `make` targets for all development, building, and validation tasks
