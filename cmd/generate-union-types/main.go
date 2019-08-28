package main

func main() {
	if err := GenerateEc2InstanceTypes(); err != nil {
		panic(err)
	}
}
