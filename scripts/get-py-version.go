package main

import (
	"bytes"
	"fmt"
	"io"
	"os"
	"regexp"
)

func main() {
	if len(os.Args) != 2 {
		fmt.Fprintf(os.Stderr, "error: need exactly one argument\n")
		os.Exit(-1)
	}

	p, err := pyPiVersionFromNpmVersion(os.Args[1])
	if err != nil {
		fmt.Fprintf(os.Stderr, "error: %s\n", err)
		os.Exit(-1)
	}

	fmt.Println(p)
}

var (
	releaseVersionRegex = regexp.MustCompile(
		`^v(?P<version>\d+\.\d+\.\d+)(?P<dirty>\+dirty)?$`)
	rcVersionRegex = regexp.MustCompile(
		`^v(?P<version>\d+\.\d+\.\d+)-rc\.(?P<rcN>\d+)(?P<dirty>\+dirty)?$`)
	devVersionRegex = regexp.MustCompile(
		`^v(?P<version>\d+\.\d+\.\d+)-dev\.(?P<time>\d+)\+(?P<gitInfo>g[a-z0-9]+)(?P<dirty>.dirty)?$`)
)

// pyPiVersionFromNpmVersion returns a PEP-440 compliant version for a given semver version. This method does not
// support all possible semver strings, but instead just supports versions that we generate for our node packages.
//
// NOTE: We do not include git information in the generated version (even within the local part, which PEP440 would
// allow) because we publish dev packages to PyPI, which does not allow local parts. Instead, we only add a local part
// when the build is dirty (which has the nice side effect of preventing us from publishing a build from dirty bits).
func pyPiVersionFromNpmVersion(s string) (string, error) {
	var b bytes.Buffer

	if releaseVersionRegex.MatchString(s) {
		capMap := captureToMap(releaseVersionRegex, s)
		mustFprintf(&b, "%s", capMap["version"])
		if capMap["dirty"] != "" {
			mustFprintf(&b, "+dirty")
		}
		return b.String(), nil
	} else if rcVersionRegex.MatchString(s) {
		capMap := captureToMap(rcVersionRegex, s)
		mustFprintf(&b, "%src%s", capMap["version"], capMap["rcN"])
		if capMap["dirty"] != "" {
			mustFprintf(&b, "+dirty")
		}
		return b.String(), nil
	} else if devVersionRegex.MatchString(s) {
		capMap := captureToMap(devVersionRegex, s)
		mustFprintf(&b, "%s.dev%s", capMap["version"], capMap["time"])
		if capMap["dirty"] != "" {
			mustFprintf(&b, "+dirty")
		}
		return b.String(), nil
	}

	return "", fmt.Errorf("can not parse version string %q", s)
}

func captureToMap(r *regexp.Regexp, s string) map[string]string {
	matches := r.FindStringSubmatch(s)
	capMap := make(map[string]string)
	for i, name := range r.SubexpNames() {
		if name != "" {
			capMap[name] = matches[i]
		}
	}

	return capMap
}

func mustFprintf(w io.Writer, format string, a ...interface{}) {
	_, err := fmt.Fprintf(w, format, a...)
	if err != nil {
		panic("unexpected error: " + err.Error())
	}
}
