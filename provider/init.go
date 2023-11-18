package provider

import "os"
import "encoding/json"

func init() {
	os.Setenv("PULUMI_REPO_PATHS", "github.com/hashicorp/terraform-provider-aws=./upstream")
}

func enablePyProject(pythonInfo []byte) ([]byte, error) {
	var model map[string]any
	if err := json.Unmarshal(pythonInfo, &model); err != nil {
		return nil, err
	}
	model["pyproject"] = map[string]any{"enabled": true}
	return json.Marshal(model)
}
