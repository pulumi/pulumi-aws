const fs = require("fs");

const file = process.env["GITHUB_OUTPUT"];
var stream = fs.createWriteStream(file, { flags: "a" });

for (const [name, value] of Object.entries(process.env)) {
  try {
    stream.write(`${name}=${value}\n`);
  } catch (err) {
    console.log(`error: failed to set output for ${name}: ${err.message}`);
  }
}

stream.end();
