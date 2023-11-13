package examples

import (
	"log"
	"os"
	"os/exec"
	"path/filepath"
	"testing"
)

func TestMain(m *testing.M) {
	disableProviderBuild := os.Getenv("GITHUB_ACTIONS")
	if disableProviderBuild == "" {
		cwd, err := os.Getwd()
		if err != nil {
			log.Println("Unable to get working directory!")
			os.Exit(1)
		}
		command := exec.Command("make", "provider_no_deps")
		command.Dir = filepath.Join(cwd, "..")
		err = command.Run()
		if err != nil {
			log.Println("Unable to build provider!")
			os.Exit(1)
		}

		binPath := filepath.Join(cwd, "..", "bin")
		err = os.Setenv("PATH", binPath+":"+os.Getenv("PATH"))
		if err != nil {
			log.Println("Unable to set PATH!")
			os.Exit(1)
		}
	}

	exitVal := m.Run()
	os.Exit(exitVal)
}
