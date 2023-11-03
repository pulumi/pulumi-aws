package examples

import (
	"log"
	"os"
	"os/exec"
	"path/filepath"
	"testing"
)

func TestMain(m *testing.M) {
	// Ensure we use a locally built provider
	awsProviderPath, err := exec.LookPath("pulumi-resource-aws")
	if err != nil {
		log.Println("AWS provider not found in path!")
		os.Exit(1)
	}

	cwd, err := os.Getwd()
	if err != nil {
		log.Println("Unable to get working directory!")
		os.Exit(1)
	}
	desiredPath := filepath.Join(cwd, "..", "bin", "pulumi-resource-aws")

	if awsProviderPath != desiredPath {
		log.Println("AWS provider not built locally!")
		os.Exit(1)
	}

	exitVal := m.Run()
	os.Exit(exitVal)
}
