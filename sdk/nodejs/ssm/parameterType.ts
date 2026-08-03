// WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
// See the License for the specific language governing permissions and
// limitations under the License.

// This file contains:
//
//     1) 1) A union type, Parameter, that accepts any valid SSM Parameter Types.
//     2) Individual constants for each SSM parameter type.
//
// These just give a better developer experience and are just sugared strings.

import {ParameterType} from ".";

/** @deprecated Use ParameterType.String instead. */
export let StringParameter:       ParameterType = "String";
/** @deprecated Use ParameterType.StringList instead. */
export let StringListParameter:   ParameterType = "StringList";
/** @deprecated Use ParameterType.SecureString instead. */
export let SecureStringParameter: ParameterType = "SecureString";
