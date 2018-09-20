"use strict";
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
var __awaiter = (this && this.__awaiter) || function (thisArg, _arguments, P, generator) {
    return new (P || (P = Promise))(function (resolve, reject) {
        function fulfilled(value) { try { step(generator.next(value)); } catch (e) { reject(e); } }
        function rejected(value) { try { step(generator["throw"](value)); } catch (e) { reject(e); } }
        function step(result) { result.done ? resolve(result.value) : new P(function (resolve) { resolve(result.value); }).then(fulfilled, rejected); }
        step((generator = generator.apply(thisArg, _arguments || [])).next());
    });
};
Object.defineProperty(exports, "__esModule", { value: true });
const aws = require("@pulumi/aws");
const table = new aws.dynamodb.Table("testtable", {
    attributes: [{
            name: "id",
            type: "S",
        }],
    hashKey: "id",
    readCapacity: 5,
    writeCapacity: 5,
    streamEnabled: true,
    streamViewType: "NEW_AND_OLD_IMAGES",
});
table.onEvent("test", (event) => __awaiter(this, void 0, void 0, function* () {
    console.log("Received event: " + JSON.stringify(event, null, 2));
}), { batchSize: 10, startingPosition: "LATEST" });
//# sourceMappingURL=index.js.map