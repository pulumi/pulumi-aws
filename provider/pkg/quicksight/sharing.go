package quicksight

import (
	"encoding/json"
	"fmt"
	"os"
	"sort"
	"strings"

	"github.com/pulumi/pulumi-terraform-bridge/v3/pkg/tfbridge/info"
	shim "github.com/pulumi/pulumi-terraform-bridge/v3/pkg/tfshim"
	"github.com/pulumi/pulumi-terraform-bridge/v3/pkg/tfshim/walk"
	"github.com/pulumi/pulumi/pkg/v3/codegen/cgstrings"
	"github.com/pulumi/pulumi/sdk/v3/go/common/tokens"
	"github.com/pulumi/pulumi/sdk/v3/go/common/util/contract"
)

// Inject sharing markers into the provider configuration, to instruct the bridge to share the types.
func shareTypes(sharing SharedTypes, p *info.Provider) {
	for _, sh := range sharing.Sharing {
		if sh.KeepDistinct {
			continue
		}
		insertSharingMarker(p, sh.Location, sh.TypeName)
		tn := sh.TypeName
		tok := tokens.Type(fmt.Sprintf("aws:quicksight/%s:%s", tn, tn))
		for _, sim := range sh.Similar {
			if sim.String() == sh.Location.String() {
				continue
			}
			insertSharingToken(p, sim, tok)
		}
	}
}

func insertSharingMarker(p *info.Provider, loc Location, typeName string) {
	i := getOrCreateSchemaInfoByLocation(p, loc)
	contract.Assertf(i != nil, "Failed to resolve rewrite location %s", loc.String())
	if i.Elem == nil {
		i.Elem = &info.Schema{}
	}
	i.Elem.TypeName = &typeName
}

func insertSharingToken(p *info.Provider, loc Location, tok tokens.Type) {
	i := getOrCreateSchemaInfoByLocation(p, loc)
	contract.Assertf(i != nil, "Failed to resolve rewrite location %s", loc.String())
	if i.Elem == nil {
		i.Elem = &info.Schema{}
	}
	i.Elem.Type = tok
	i.Elem.OmitType = true
}

func getOrCreateSchemaInfoByLocation(p *info.Provider, loc Location) *info.Schema {
	if loc.Resource != "" {
		if r, ok := p.Resources[loc.Resource]; ok {
			if r.Fields == nil {
				r.Fields = map[string]*info.Schema{}
			}
			return getSchemaInfoRoot(loc.SchemaPath(), r.Fields)
		}
		return nil
	}
	if d, ok := p.DataSources[loc.DataSource]; ok {
		if d.Fields == nil {
			d.Fields = map[string]*info.Schema{}
		}
		return getSchemaInfoRoot(loc.SchemaPath(), d.Fields)
	}
	return nil
}

func getOrCreateSchemaInfoPath(schemaPath walk.SchemaPath, schemaInfo *info.Schema) *info.Schema {
	if len(schemaPath) == 0 {
		return schemaInfo
	}

	switch first := schemaPath[0].(type) {
	case walk.ElementStep:
		return getOrCreateSchemaInfoPath(schemaPath[1:], ensureField(&schemaInfo.Elem))
	case walk.GetAttrStep:
		return getOrCreateSchemaInfoPath(schemaPath[1:], ensureMapKey(&schemaInfo.Fields, first.Name))
	default:
		contract.Failf("Unable to walk SchemaPath segment of type %T", schemaPath[0])
		return nil
	}
}

func getSchemaInfoRoot(p walk.SchemaPath, infos map[string]*info.Schema) *info.Schema {
	if len(p) == 0 { // This must be the root of a resource or datasource, so we mock the root.
		return &info.Schema{Fields: infos}
	}
	contract.Assertf(infos != nil, "info cannot be nil")
	contract.Assertf(len(p) > 0, "p cannot point to the resource or datasource")

	switch root := p[0].(type) {
	case walk.GetAttrStep:
		return getOrCreateSchemaInfoPath(p[1:], ensureMapKey(&infos, root.Name))
	default:
		contract.Failf("The first step of a resource or datasource must be a attr")
		return nil
	}
}

func ensureMap[K comparable, V any](m *map[K]V) map[K]V {
	if *m == nil {
		*m = map[K]V{}
	}
	return *m
}

func ensureMapKey[K comparable, V any](m *map[K]*V, key K) *V {
	ensureMap(m)
	v, ok := (*m)[key]
	if ok {
		return v
	}
	v = new(V)
	(*m)[key] = v
	return v
}

func ensureField[T any](t **T) *T {
	if *t == nil {
		*t = new(T)
	}
	return *t
}

type schema struct {
	location Location
	schema   shim.Schema
}

func equalGroups(ss []schema) [][]schema {
	g := [][]schema{{ss[0]}}
	for _, s := range ss[1:] {
		placed := false
		for i, cg := range g {
			if equal(s, cg[0]) {
				g[i] = append(g[i], s)
				placed = true
				break
			}
		}
		if !placed {
			g = append(g, []schema{s})
		}
	}
	return g
}

func equal(a, b schema) bool {
	return equalSchema(a.schema, b.schema)
}

func equalSchema(a, b shim.Schema) bool {
	if a.Type() != b.Type() {
		return false
	}
	if a.MaxItems() != b.MaxItems() {
		return false
	}
	if a.MinItems() != b.MinItems() {
		return false
	}
	switch aElem := a.Elem().(type) {
	case nil:
		if b.Elem() != nil {
			return false
		}
	case shim.Resource:
		bR, ok := b.Elem().(shim.Resource)
		if !ok {
			return false
		}
		return equalSchemaMap(aElem.Schema(), bR.Schema())
	case shim.Schema:
		bS, ok := b.Elem().(shim.Schema)
		if !ok {
			return false
		}
		return equalSchema(aElem, bS)
	}
	return true
}

func equalSchemaMap(a, b shim.SchemaMap) bool {
	if a.Len() != b.Len() {
		return false
	}
	eq := true
	a.Range(func(key string, value shim.Schema) bool {
		bv, ok := b.GetOk(key)
		if !ok {
			eq = false
			return false
		}
		if !equalSchema(value, bv) {
			eq = false
			return false
		}
		return true
	})
	return eq
}

func visitAllQuicksightSchemas(p shim.Provider, visit func(s schema)) {
	visitor := func(token string, isResource bool) walk.SchemaVisitor {
		return func(sp walk.SchemaPath, s shim.Schema) {
			if _, ok := s.Elem().(shim.Resource); ok {
				loc := Location{
					Path: sp.MustEncodeSchemaPath(),
				}
				if isResource {
					loc.Resource = token
				} else {
					loc.DataSource = token
				}
				visit(schema{
					schema:   s,
					location: loc,
				})
			}
		}
	}
	p.ResourcesMap().Range(func(token string, value shim.Resource) bool {
		if !strings.Contains(token, "quicksight") {
			return true
		}
		walk.VisitSchemaMap(value.Schema(), visitor(token, true))
		return true
	})
	p.DataSourcesMap().Range(func(token string, value shim.Resource) bool {
		if !strings.Contains(token, "quicksight") {
			return true
		}
		walk.VisitSchemaMap(value.Schema(), visitor(token, false))
		return true
	})
}

// Serializable marker for a type sharing location.
type Location struct {
	// Path where is found. See [walk.SchemaPath].
	Path string `json:"path"`

	// The TF name of the parent resource. Conflicts with [DataSource].
	Resource string `json:"resource,omitempty"`

	// The TF name of the parent datasource. Conflicts with [Resource].
	DataSource string `json:"dataSource,omitempty"`
}

// Pretty-print. Can also serve as a unique key.
func (loc Location) String() string {
	if loc.Resource != "" {
		return fmt.Sprintf("resource:%s:%s", loc.Resource, loc.Path)
	}
	return fmt.Sprintf("datasource:%s:%s", loc.DataSource, loc.Path)
}

// Decode the type form of [Path].
func (loc Location) SchemaPath() walk.SchemaPath {
	return walk.DecodeSchemaPath(loc.Path)
}

func (loc Location) suggestedTypeName() string {
	sp := loc.SchemaPath()
	switch t := sp[len(sp)-1].(type) {
	case walk.GetAttrStep:
		r := []string{}
		parts := strings.Split(t.Name, "_")
		for _, p := range parts {
			r = append(r, cgstrings.UppercaseFirst(p))
		}
		return strings.Join(r, "")
	default:
		contract.Failf("Unexpected path")
		return ""
	}
}

// Configuration for type sharing.
//
// Provider maintainers edit the configuration to confirm which types are shared intentionally and which are shared
// accidentally. Maintainers can also edit the desired type name for the shared type.
//
// This structure needs to be serializable so that it can be computed at build time and then consulted when configuring
// the provider mapping. It also facilitates keeping track of changes in the source control history.
type SharedTypes struct {
	Sharing []SharedType `json:"sharing"`
}

func (st SharedTypes) Check() {
	used := map[string]struct{}{}
	for _, x := range st.Sharing {
		if _, confl := used[x.TypeName]; confl {
			fmt.Printf("Conflicting TypeName: %s\n", x.TypeName)
		}
		used[x.TypeName] = struct{}{}
	}
}

func (st SharedTypes) rootsOnly() SharedTypes {
	x := SharedTypes{}
	for _, sh := range st.Sharing {
		sh.Similar = nil
		x.Sharing = append(x.Sharing, sh)
	}
	return x

}

func (st SharedTypes) rewritesOnly() SharedTypes {
	x := SharedTypes{}
	for _, sh := range st.Sharing {
		if !sh.KeepDistinct {
			x.Sharing = append(x.Sharing, sh)
		}
	}
	return x
}

func (st SharedTypes) index(p shim.Provider) func(schema shim.Schema) (SharedType, bool) {
	canonicals := []shim.Schema{}
	for _, sh := range st.Sharing {
		s, ok := resolveLocation(sh.Location, p)
		if ok {
			canonicals = append(canonicals, s)
		}
	}
	return func(schema shim.Schema) (SharedType, bool) {
		for i, c := range canonicals {
			if equalSchema(c, schema) {
				return st.Sharing[i], true
			}
		}
		return SharedType{}, false
	}
}

type SharedType struct {
	Location     Location   `json:"location"`
	TypeName     string     `json:"typeName"`
	KeepDistinct bool       `json:"keepDistinct,omitempty"`
	Similar      []Location `json:"similar,omitempty"`
}

func (st SharedType) WithNewLocations(loc ...Location) SharedType {
	seen := map[string]struct{}{}
	seen[st.Location.String()] = struct{}{}
	for _, loc := range st.Similar {
		seen[loc.String()] = struct{}{}
	}
	for _, x := range loc {
		if _, skip := seen[x.String()]; !skip {
			st.Similar = append(st.Similar, x)
		}
	}
	return st
}

func resolveLocation(loc Location, p shim.Provider) (shim.Schema, bool) {
	var baseMap shim.SchemaMap
	if loc.Resource != "" {
		res, ok := p.ResourcesMap().GetOk(loc.Resource)
		if !ok {
			return nil, false
		}
		baseMap = res.Schema()
	} else {
		ds, ok := p.DataSourcesMap().GetOk(loc.DataSource)
		if !ok {
			return nil, false
		}
		baseMap = ds.Schema()
	}
	sch, err := walk.LookupSchemaMapPath(loc.SchemaPath(), baseMap)
	if err == nil {
		return sch, true
	}
	return sch, false
}

// Inspect the provider schema to detect structurally identical types and surface them as sharing possibilities.
//
// Prior sharing configuration is consulted to respect the historical choices on the canonical location and
// [SharedType.KeepDistinct].
func detectSharing(priorSharing SharedTypes, p shim.Provider) SharedTypes {
	// TODO priorSharing may have entries that no longer resolve to types in the provider which may be changing.
	// Should discard such entries before moving forward.
	schemata := []schema{}

	visitAllQuicksightSchemas(p, func(s schema) {
		schemata = append(schemata, s)
	})
	eqs := equalGroups(schemata)
	sort.Slice(eqs, func(i, j int) bool {
		return len(eqs[i]) > len(eqs[j])
	})
	st := SharedTypes{}
	ix := priorSharing.index(p)
	for _, eq := range eqs {
		if len(eq) == 1 {
			continue
		}
		locations := []Location{}
		for _, x := range eq {
			locations = append(locations, x.location)
		}
		prior, hasPrior := ix(eq[0].schema)
		if hasPrior {
			st.Sharing = append(st.Sharing, prior.WithNewLocations(locations...))
		} else {
			loc := locationWithShortestPath(locations)
			newSharing := SharedType{
				Location:     loc,
				Similar:      locations,
				TypeName:     loc.suggestedTypeName(),
				KeepDistinct: true,
			}
			st.Sharing = append(st.Sharing, newSharing)
		}
	}
	return st
}

func locationWithShortestPath(all []Location) Location {
	contract.Assertf(len(all) > 0, "locationWithShortestPath expects a non-empty slice")
	best := all[0]
	for _, l := range all {
		p1 := l.SchemaPath()
		p2 := best.SchemaPath()
		if len(p1) < len(p2) || len(p1) == len(p2) && l.Path < best.Path {
			best = l
		}
	}
	return best
}

func readSharedTypesFile(fn string) (SharedTypes, error) {
	var sh SharedTypes
	bytes, err := os.ReadFile(fn)
	if err != nil {
		return SharedTypes{}, err
	}
	err = json.Unmarshal(bytes, &sh)
	if err != nil {
		return SharedTypes{}, err
	}
	return sh, nil
}
