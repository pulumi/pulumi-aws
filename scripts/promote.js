// Copyright 2016-2018, Pulumi Corporation.  All rights reserved.

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
    // All stdin is available.  Parse the JSON and move dependencies around.
    const packageJSON = JSON.parse(packageJSONText);
    for (const arg of process.argv.slice(2)) {
        if (!packageJSON.peerDependencies || !packageJSON.peerDependencies[arg]) {
            throw new Error(`No peerDependency for "${arg}" found`);
        }

        // Add this dependency.
        if (!packageJSON.dependencies) {
            packageJSON.dependencies = {};
        }
        packageJSON.dependencies[arg] = packageJSON.peerDependencies[arg];

        // And now delete the peer dependency.
        delete packageJSON.peerDependencies[arg];
        if (Object.keys(packageJSON.peerDependencies).length === 0) {
            delete packageJSON.peerDependencies;
        }
    }

    // Now print out the result to stdout.
    console.log(JSON.stringify(packageJSON, null, 4));
});
