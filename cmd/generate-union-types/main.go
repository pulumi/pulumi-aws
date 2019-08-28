package main

func main() {
	if err := GenerateEc2InstanceTypes(); err != nil {
		panic(err)
	}

	if err := GenerateEc2Regions(); err != nil {
		panic(err)
	}
}
