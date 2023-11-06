package main

import (
	"os"

	"github.com/dave/jennifer/jen"
	"github.com/pulumi/pulumi-terraform-bridge/v3/pkg/tfbridge"
)

func main() {
	content, err := os.ReadFile("cmd/pulumi-resource-aws/bridge-metadata.json")
	if err != nil {
		panic(err)
	}

	minfo := tfbridge.NewProviderMetadata(content)

	params := []jen.Code{}
	for k, v := range minfo.Data.M {
		params = append(params, jen.Lit(k).Op(":").Add(jen.Id("ptr").Params(jen.Id("json.RawMessage").Params(jen.Index().Byte().Params(jen.Lit(string(*v)))))))
	}

	f := jen.NewFile("provider")
	f.PackageComment("Generated code DO NOT EDIT")

	f.Var().Add(jen.Id("MetadataInfo").Op("=").Add(jen.Qual("github.com/pulumi/pulumi-terraform-bridge/v3/pkg/tfbridge", "MetadataInfo").Values(
		jen.Id("Path").Op(":").Add(jen.Lit("bridge-metadata.json")),
		jen.Id("Data").Op(":").Add(jen.Op("&").Add(jen.Qual("github.com/pulumi/pulumi-terraform-bridge/v3/unstable/metadata", "Data")).Values(
			jen.Id("M").Op(":").Add(jen.Map(jen.String()).Add(jen.Op("*").Add(jen.Qual("encoding/json", "RawMessage")).Values(params...))),
		)),
	)))

	err = f.Save("hack.go")
	if err != nil {
		panic(err)
	}
}
