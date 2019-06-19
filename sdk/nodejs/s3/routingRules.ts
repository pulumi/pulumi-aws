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

/**
 * A rule that identifies a condition and the redirect that is applied when the condition is met.
 * If a condition is not included, the rule is applied to all requests.
 *
 * For more details, please refer to the AWS documentation online:
 * https://docs.aws.amazon.com/AmazonS3/latest/dev/how-to-page-redirect.html#advanced-conditional-redirects
 */
export interface RoutingRule {
    /**
     * A condition that must be met for the specified redirect to be applied.
     * If not included, the rule is applied to all requests.
     */
    Condition?: Condition;

    /**
     * Provides instructions for redirecting the request. You can redirect requests to another host or another page,
     * or you can specify another protocol to use.
     */
    Redirect: Redirect;
}

/**
 * A condition that must be met for the specified redirect to be applied.
 */
export interface Condition {
    /**
     * The HTTP error code that must match for the redirect to apply. If an error occurs, and if the error code meets
     * this value, then the specified redirect applies.
     *
     * `HttpErrorCodeReturnedEquals` is required if `KeyPrefixEquals` is not specified. If both `KeyPrefixEquals` and
     * `HttpErrorCodeReturnedEquals` are specified, both must be true for the condition to be met.
     */
    HttpErrorCodeReturnedEquals?: string;

    /**
     * The prefix of the object key name from which requests are redirected.
     *
     * `KeyPrefixEquals` is required if `HttpErrorCodeReturnedEquals` is not specified. If both `KeyPrefixEquals` and
     * `HttpErrorCodeReturnedEquals` are specified, both must be true for the condition to be met.
     */
    KeyPrefixEquals?: string;
}

/**
 * Provides instructions for redirecting the request. You can redirect requests to another host or another page, or you
 * can specify another protocol to use. At least one property must be set.
 */
export interface Redirect {
    /**
     * The hostname to be used in the Location header that is returned in the response.
     *
     * If another property is set, `HostName` is not required.
     */
    HostName?: string;

    /**
     * The HTTP redirect code to be used in the Location header that is returned in the response.
     *
     * If another property is set, `HttpRedirectCode` is not required.
     */
    HttpRedirectCode?: string;

    /**
     * The protocol, http or https, to be used in the Location header that is returned in the response.
     *
     * If another property is set, `Protocol` is not required.
     */
    Protocol?: string;

    /**
     * The prefix of the object key name that replaces the value of `KeyPrefixEquals` in the redirect request.
     *
     * If another property is set, `ReplaceKeyPrefixWith` is not required.
     * It can be set only if `ReplaceKeyWith` is not set.
     */
    ReplaceKeyPrefixWith?: string;

    /**
     * The object key to be used in the Location header that is returned in the response.
     *
     * If another property is set, `ReplaceKeyWith` is not required.
     * It can be set only if `ReplaceKeyPrefixWith` is not set.
     */
    ReplaceKeyWith?: string;
}
