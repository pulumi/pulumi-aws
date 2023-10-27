// Copyright 2016-2017, Pulumi Corporation.  All rights reserved.
//go:build go || all
// +build go all

package examples

import (
	"path/filepath"
	"testing"

	"github.com/pulumi/pulumi/pkg/v3/testing/integration"
)

func TestAccWebserverGo(t *testing.T) {
	test := integration.ProgramTestOptions{
		Dir: filepath.Join(getCwd(t), "webserver-go"),
		Dependencies: []string{
			"github.com/pulumi/pulumi-aws/sdk/v6",
		},
		Config: map[string]string{"aws:region": getEnvRegion(t)},
	}

	integration.ProgramTest(t, &test)
}

func TestTagsCombinationsGo(t *testing.T) {
	tagValues := []string{"", "s"} // empty values are conflated with unknowns in TF internals, must test

	tagsValues := []map[string]string{
		nil,
		map[string]string{},
	}

	for _, tag := range tagValues {
		m := map[string]string{"x": tag}
		tagsValues = append(tagsValues, m)
	}

	for _, tag1 := range tagValues {
		for _, tag2 := range tagValues {
			m := map[string]string{
				"x": tag1,
				"y": tag2,
			}
			tagsValues = append(tagsValues, m)
		}
	}

	type state struct {
		DefaultTags  map[string]string `json:"defaultTags"`
		ResourceTags map[string]string `json:"resourceTags"`
	}

	states := []state{}

	for _, tags1 := range tagsValues {
		for _, tags2 := range tagsValues {
			states = append(states, state{
				DefaultTags:  tags1,
				ResourceTags: tags2,
			})
		}
	}

	expectedTags := func(s state) map[string]string {
		r := map[string]string{}
		for k, v := range s.DefaultTags {
			r[k] = v
		}
		for k, v := range s.ResourceTags {
			r[k] = v
		}
		return r
	}

	validateStateResult := func(state state) func(t *testing.T, stack integration.RuntimeValidationStackInfo) {
		return func(t *testing.T, stack integration.RuntimeValidationStackInfo) {
			for k, v := range stack.Outputs {
				actualTagsJSON := v.(string)
				var actualTags map[string]string
				err := json.Unmarshal([]byte(actualTagsJSON), &actualTags)
				require.NoError(t, err)
				require.Equalf(t, expectedTags(state), actualTags, "key=%s", k)
				t.Logf("key=%s tags are as expected: %v", k, actualTagsJSON)
			}
		}
	}

	serializeState := func(s state) string {
		bytes, err := json.Marshal(s)
		require.NoError(t, err)
		return string(bytes)
	}

	t.Logf("total state space: %v states", len(states))
	t.Logf("random-sampling 100 state transitions")

	for i := 0; i < 100; i++ {
		t.Run(fmt.Sprintf("test-%d", i), func(t *testing.T) {
			i := rand.Intn(len(states))
			j := rand.Intn(len(states))

			state1, state2 := states[i], states[j]

			t.Logf("state1 = %v", serializeState(state1))
			t.Logf("state2 = %v", serializeState(state2))

			integration.ProgramTest(t, &integration.ProgramTestOptions{
				Dir:                    "tags-combinations-go",
				ExtraRuntimeValidation: validateStateResult(state1),
				EditDirs: []integration.EditDir{{
					Dir:                    filepath.Join("tags-combinations-go", "step1"),
					Additive:               true,
					ExtraRuntimeValidation: validateStateResult(state2),
				}},
				Config: map[string]string{
					"aws:region": getEnvRegion(t),
					"state1":     serializeState(state1),
					"state2":     serializeState(state2),
				},
				Quick:            true,
				DestroyOnCleanup: true,
			})
		})
	}
}
