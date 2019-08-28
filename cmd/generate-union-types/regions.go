package main

import (
	"encoding/json"
	"fmt"
	"os"
	"sort"
	"strings"
	"text/template"
)

type regionDocument struct {
	Partitions []Partitions `json:"partitions"`
}

type Partitions struct {
	Regions map[string]interface{} `json:"regions"`
	Partition string `json:"partition"`
}

func GenerateEc2Regions() error {
	filePath := "endpoints.json"
	fileurl := "https://raw.githubusercontent.com/aws/aws-sdk-go/master/models/endpoints/endpoints.json"

	if err := downloadFile(filePath, fileurl); err != nil {
		return err
	}
	defer os.Remove(filePath)

	jsonData, err := readFile(filePath)
	if err != nil {
		return err
	}

	var document regionDocument
	err = json.Unmarshal(jsonData, &document)
	if err != nil {
		return err
	}

	var regionNames  []string
	for _, partition := range document.Partitions {
		for regionName := range partition.Regions {
			if !strings.Contains(regionName, "gov") &&
				!strings.Contains(regionName,"iso") {
				regionNames = append(regionNames, regionName)
			}
		}
	}

	sort.Strings(regionNames)

	fileWriter, err := os.Create("sdk/nodejs/region.ts")
	if err != nil {
		return err
	}

	fmap := template.FuncMap{
		"formatRegionName": formatRegionName,
		"IsLast":           func(i, size int) bool { return i == size-1 },
	}

	t := template.Must(template.New("ec2RegionTemplate").Funcs(fmap).Parse(ec2RegionTemplate))
	err = t.Execute(fileWriter, regionNames)
	if err != nil {
		return err
	}

	return nil
}

func formatRegionName(instanceType string) (string, error) {
	parts := strings.Split(instanceType, "-")
	if len(parts) < 3 {
		panic("we have a problem here")
	}

	return fmt.Sprintf("%s%s%sRegion", strings.ToUpper(parts[0]), strings.Title(parts[1]), parts[2]), nil
}
