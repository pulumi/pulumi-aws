package lambda

// Runtime represents a lambda runtime.
type Runtime = string

// lambda runtimes
const (
	RuntimeDotnetCore1d0 Runtime = "dotnetcore1.0"
	RuntimeDotnetCore2d1         = "dotnetcore2.1"
	RuntimeGo1dx                 = "go1.x"
	RuntimeJava8                 = "java8"
	RuntimeRuby2d5               = "ruby2.5"
	RuntimeNodeJS8d10            = "nodejs8.10"
	RuntimeNodeJS10dX            = "nodejs10.x"
	RuntimePython2d7             = "python2.7"
	RuntimePython3d6             = "python3.6"
	RuntimePython3d7             = "python3.7"
	RuntimeCustom                = "provided"
)
