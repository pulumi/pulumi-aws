//go:build !hack

package main

import (
	"fmt"

	"github.com/dave/jennifer/jen"
	provider "github.com/pulumi/pulumi-aws/provider/v6"
	"github.com/pulumi/pulumi-aws/provider/v6/pkg/version"
	"github.com/pulumi/pulumi-terraform-bridge/v3/pkg/history"
	"github.com/pulumi/pulumi-terraform-bridge/v3/unstable/metadata"
	"github.com/pulumi/pulumi-terraform-bridge/x/muxer"
)

func addField(node *jen.Statement, fh *history.FieldHistory) jen.Code {
	if fh == nil {
		return nil
	}

	maxItems := jen.Nil()
	if fh.MaxItemsOne != nil {
		switch *fh.MaxItemsOne {
		case true:
			maxItems = jen.Id("tfbridge.True()")
		case false:
			maxItems = jen.Id("tfbridge.False()")
		}
	}

	result := []jen.Code{
		node.Clone().Op("=").Add(jen.Id("&history.FieldHistory").Values(
			jen.Id("MaxItemsOne").Op(":").Add(maxItems),
		)),
	}

	if fh.Elem != nil {
		subnode := node.Clone().Dot("Elem")
		result = append(result, addField(subnode, fh.Elem))
	}

	if len(fh.Fields) > 0 {
		result = append(result, node.Clone().Dot("Fields").Op("=").Add(jen.Id(fmt.Sprintf("make(map[string]*history.FieldHistory, %d)", len(fh.Fields)))))
	}
	for k, v := range fh.Fields {
		subnode := node.Clone().Dot("Fields").Index(jen.Lit(k)) // Fields["foo"]
		result = append(result, addField(subnode, v))
	}

	return jen.Func().Params().Block(result...).Params() // This avoids the NewBulk error
}

func main() {
	prov := provider.Provider()
	prov.SetAutonaming(255, "-")
	prov.MustApplyAutoAliases()
	mdinfo := prov.MetadataInfo

	mux, _, _ := metadata.Get[muxer.DispatchTable](mdinfo.Data, "mux")
	muxFuncParams := []jen.Code{}
	for k, v := range mux.Functions {
		muxFuncParams = append(muxFuncParams, jen.Lit(k).Op(":").Add(jen.Lit(v)))
	}
	muxResourceParams := []jen.Code{}
	for k, v := range mux.Resources {
		muxResourceParams = append(muxResourceParams, jen.Lit(k).Op(":").Add(jen.Lit(v)))
	}

	f := jen.NewFile("provider")
	f.PackageComment("//go:build hack")
	f.PackageComment("Generated code DO NOT EDIT")

	hist, _, _ := metadata.Get[history.AliasHistory](mdinfo.Data, "auto-aliasing")

	initParams := []jen.Code{
		jen.Id("MetadataInfo").Op("=").Op("&").Add(jen.Qual("github.com/pulumi/pulumi-terraform-bridge/v3/pkg/tfbridge", "MetadataInfo").Values(
			jen.Id("Path").Op(":").Add(jen.Lit("bridge-metadata.json")),
			jen.Id("Data").Op(":").Add(jen.Op("&").Add(jen.Qual("github.com/pulumi/pulumi-terraform-bridge/v3/unstable/metadata", "Data")).Values(
				jen.Id("AutoAliasing").Op(":").Op("&").Add(jen.Qual("github.com/pulumi/pulumi-terraform-bridge/v3/pkg/history", "AliasHistory")).Values(
					jen.Id("Resources").Op(":").Add(jen.Make(jen.Map(jen.String()).Add(jen.Op("*").Id("history.TokenHistory").Types(jen.Id("tokens.Type"))), jen.Lit(len(hist.Resources)))),
					jen.Id("DataSources").Op(":").Add(jen.Make(jen.Map(jen.String()).Add(jen.Op("*").Id("history.TokenHistory").Types(jen.Id("tokens.ModuleMember"))), jen.Lit(len(hist.Resources)))),
				),

				jen.Id("Mux").Op(":").Add(jen.Qual("github.com/pulumi/pulumi-terraform-bridge/x/muxer", "DispatchTable")).Values(
					jen.Id("DispatchTable_").Op(":").Add(jen.Id("muxer.DispatchTable_")).Values(
						jen.Id("Resources").Op(":").Add(jen.Map(jen.String()).Add(jen.Int()).Values(muxResourceParams...)),
						jen.Id("Functions").Op(":").Add(jen.Map(jen.String()).Add(jen.Int()).Values(muxFuncParams...)),
					),
				),
				jen.Id("Renames").Op(":").Add(jen.Qual("encoding/json", "RawMessage")).Params(
					jen.Index().Byte().Params(jen.Lit(string(*mdinfo.Data.M["renames"]))),
					// jen.Index().Byte().Params(jen.Lit("{}")), // TODO
				),
			)),
		)),
	}

	for k, v := range hist.Resources {
		aliases := []jen.Code{}
		for _, a := range v.Past {
			aliases = append(aliases, jen.Id("history.Alias[tokens.Type]").Values(
				jen.Id("Name").Op(":").Add(jen.Lit(string(a.Name))),
				jen.Id("InCodegen").Op(":").Add(jen.Lit(a.InCodegen)),
				jen.Id("MajorVersion").Op(":").Add(jen.Lit(a.MajorVersion)),
			))
		}

		initParams = append(initParams, jen.Id("MetadataInfo").Dot("Data").Dot("AutoAliasing").Dot("Resources").Index(jen.Lit(k)).Op("=").Add(
			jen.Id("&history.TokenHistory").Types(jen.Qual("github.com/pulumi/pulumi/sdk/v3/go/common/tokens", "Type"))).Values(
			jen.Id("Current").Op(":").Add(jen.Lit(string(v.Current))),
			jen.Id("MajorVersion").Op(":").Add(jen.Lit(v.MajorVersion)),
		))
		if len(aliases) > 0 {
			initParams = append(initParams,
				jen.Id("MetadataInfo").Dot("Data").Dot("AutoAliasing").Dot("Resources").Index(jen.Lit(k)).Dot("Past").Op("=").Add(jen.Index().Id("history.Alias[tokens.ModuleMember]").Values(aliases...)),
			)
		}

		if len(v.Fields) > 0 {
			initParams = append(initParams, jen.Id("MetadataInfo").Dot("Data").Dot("AutoAliasing").Dot("Resources").Index(jen.Lit(k)).Dot("Fields").Op("=").Add(jen.Id(fmt.Sprintf("make(map[string]*history.FieldHistory, %d)", len(v.Fields)))))
		}

		for kk, vv := range v.Fields {
			subnode := jen.Id("MetadataInfo").Dot("Data").Dot("AutoAliasing").Dot("Resources").Index(jen.Lit(k)).Dot("Fields").Index(jen.Lit(kk))
			initParams = append(initParams, addField(subnode, vv))
		}
	}

	for k, v := range hist.DataSources {
		aliases := []jen.Code{}
		for _, a := range v.Past {
			aliases = append(aliases, jen.Id("history.Alias[tokens.ModuleMember]").Values(
				jen.Id("Name").Op(":").Add(jen.Lit(string(a.Name))),
				jen.Id("InCodegen").Op(":").Add(jen.Lit(a.InCodegen)),
				jen.Id("MajorVersion").Op(":").Add(jen.Lit(a.MajorVersion)),
			))
		}

		initParams = append(initParams, jen.Id("MetadataInfo").Dot("Data").Dot("AutoAliasing").Dot("DataSources").Index(jen.Lit(k)).Op("=").Add(
			jen.Id("&history.TokenHistory").Types(
				jen.Qual("github.com/pulumi/pulumi/sdk/v3/go/common/tokens", "ModuleMember"))).Values(
			jen.Id("Current").Op(":").Add(jen.Lit(string(v.Current))),
			jen.Id("MajorVersion").Op(":").Add(jen.Lit(v.MajorVersion)),
		),
		)
		if len(aliases) > 0 {
			initParams = append(initParams,
				jen.Id("MetadataInfo").Dot("Data").Dot("AutoAliasing").Dot("DataSources").Index(jen.Lit(k)).Dot("Past").Op("=").Add(jen.Index().Id("history.Alias[tokens.ModuleMember]").Values(aliases...)),
			)
		}

		if len(v.Fields) > 0 {
			initParams = append(initParams, jen.Id("MetadataInfo").Dot("Data").Dot("AutoAliasing").Dot("DataSources").Index(jen.Lit(k)).Dot("Fields").Op("=").Add(jen.Id(fmt.Sprintf("make(map[string]*history.FieldHistory, %d)", len(v.Fields)))))
		}

		for kk, vv := range v.Fields {
			subnode := jen.Id("MetadataInfo").Dot("Data").Dot("AutoAliasing").Dot("DataSources").Index(jen.Lit(k)).Dot("Fields").Index(jen.Lit(kk))
			initParams = append(initParams, addField(subnode, vv))
		}
	}

	f.Func().Id("init").Params().Block(initParams...)

	err := f.Save("hack.go")
	if err != nil {
		panic(err)
	}
}

func init() {
	version.Version = "1.2.3"
}
