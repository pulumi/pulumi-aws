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


type Diff<T extends string | number | symbol, U extends string | number | symbol> =
  ({ [P in T]: P } & { [P in U]: never } & { [x: string]: never })[T];

// Overwrite allows you to take an existing type, and then overwrite existing properties in it
// with properties of the same name, but with entirely different types.
export type Overwrite<T, U> = Pick<T, Diff<keyof T, keyof U>> & U;
