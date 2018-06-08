// Copyright 2016-2018, Pulumi Corporation.
//
// Licensed under the Apache License, Version 2.0 (the "License");
// you may not use this file except in compliance with the License.
// You may obtain a copy of the License at
//
//     http://www.apache.org/licenses/LICENSE-2.0
//
// Unless required by applicable law or agreed to in writing, software
// distributed under the License is distributed on an "AS IS" BASIS,
// WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
// See the License for the specific language governing permissions and
// limitations under the License.

// This program simply reads a package.json from stdin, takes a set of arguments representing
// package names, and for each one, promotes that package from a peerDependency to a real dependency.

// Read the package.json from stdin.
let packageJSONText = "";
const readline = require("readline");
const stdin = readline.createInterface({
    input: process.stdin,
    output: process.stdout,
    terminal: false,
});
stdin.on("line", function(line) {
    packageJSONText += `${line}\n`;
});
stdin.on("close", function() {
    // All stdin is available. Add our install script.
    const packageJSON = JSON.parse(packageJSONText);

    if (!packageJSON.scripts) {
        packageJSON.scripts = {};
    }
    var name = packageJSON.name;
    if (name.lastIndexOf("/") !== -1) {
        name = name.substring(name.lastIndexOf("/")+1);
    }
    packageJSON.scripts["install"] = `pulumi plugin install resource ${name} ${packageJSON.version}`;

    // Now print out the result to stdout.
    console.log(JSON.stringify(packageJSON, null, 4));
});
