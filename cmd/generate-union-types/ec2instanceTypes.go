package main

import (
	"encoding/json"
	"fmt"
	"os"
	"strings"
	"text/template"
)

type Ec2 struct {
	Shapes Shapes `json:"shapes"`
}

type Shapes struct {
	InstanceType InstanceType `json:"InstanceType"`
}

type InstanceType struct {
	Values []string `json:"enum"`
}

func GenerateEc2InstanceTypes() error {
	filePath := "api.json"
	fileurl := "https://raw.githubusercontent.com/aws/aws-sdk-go/master/models/apis/ec2/2016-11-15/api-2.json"

	if err := downloadFile(filePath, fileurl); err != nil {
		return err
	}
	defer os.Remove(filePath)

	jsonData, err := readFile(filePath)
	if err != nil {
		return err
	}

	var ec2 Ec2
	err = json.Unmarshal(jsonData, &ec2)
	if err != nil {
		return err
	}

	fileWriter, err := os.Create("sdk/nodejs/ec2/instanceType.ts")
	if err != nil {
		return err
	}

	fmap := template.FuncMap{
		"formatInstanceType": formatInstanceType,
		"IsLast":             func(i, size int) bool { return i == size-1 },
	}

	t := template.Must(template.New("ec2InstanceTypeTemplate").Funcs(fmap).Parse(ec2InstanceTypeTemplate))
	err = t.Execute(fileWriter, ec2.Shapes.InstanceType)
	if err != nil {
		return err
	}

	return nil
}

func formatInstanceType(instanceType string) (string, error) {
	parts := strings.Split(instanceType, ".")
	if len(parts) > 2 {
		panic("we have a problem here")
	}

	generation := parts[0]
	name := strings.ToLower(parts[1])
	if strings.Contains(name, "xlarge") {
		name = strings.Replace(name, "xlarge", "XLarge", -1)
	}

	if strings.Contains(generation, "-") {
		generation = strings.Replace(generation, "-", "", -1)
	}

	return fmt.Sprintf("%s_%s", strings.Title(generation), strings.Title(name)), nil
}
