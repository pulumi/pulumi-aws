// *** WARNING: this file was generated by pulumi-language-dotnet. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

using System;
using System.Collections.Generic;
using System.Collections.Immutable;
using System.Threading.Tasks;
using Pulumi.Serialization;

namespace Pulumi.Aws.Route53Domains.Outputs
{

    [OutputType]
    public sealed class DomainRegistrantContact
    {
        /// <summary>
        /// First line of the contact's address.
        /// </summary>
        public readonly string? AddressLine1;
        /// <summary>
        /// Second line of contact's address, if any.
        /// </summary>
        public readonly string? AddressLine2;
        /// <summary>
        /// The city of the contact's address.
        /// </summary>
        public readonly string? City;
        /// <summary>
        /// Indicates whether the contact is a person, company, association, or public organization. See the [AWS API documentation](https://docs.aws.amazon.com/Route53/latest/APIReference/API_domains_ContactDetail.html#Route53Domains-Type-domains_ContactDetail-ContactType) for valid values.
        /// </summary>
        public readonly string? ContactType;
        /// <summary>
        /// Code for the country of the contact's address. See the [AWS API documentation](https://docs.aws.amazon.com/Route53/latest/APIReference/API_domains_ContactDetail.html#Route53Domains-Type-domains_ContactDetail-CountryCode) for valid values.
        /// </summary>
        public readonly string? CountryCode;
        /// <summary>
        /// Email address of the contact.
        /// </summary>
        public readonly string? Email;
        /// <summary>
        /// A list of name-value pairs for parameters required by certain top-level domains.
        /// </summary>
        public readonly ImmutableArray<Outputs.DomainRegistrantContactExtraParam> ExtraParams;
        /// <summary>
        /// Fax number of the contact. Phone number must be specified in the format "+[country dialing code].[number including any area code]".
        /// </summary>
        public readonly string? Fax;
        /// <summary>
        /// First name of contact.
        /// </summary>
        public readonly string? FirstName;
        /// <summary>
        /// Last name of contact.
        /// </summary>
        public readonly string? LastName;
        /// <summary>
        /// Name of the organization for contact types other than `PERSON`.
        /// </summary>
        public readonly string? OrganizationName;
        /// <summary>
        /// The phone number of the contact. Phone number must be specified in the format "+[country dialing code].[number including any area code]".
        /// </summary>
        public readonly string? PhoneNumber;
        /// <summary>
        /// The state or province of the contact's city.
        /// </summary>
        public readonly string? State;
        /// <summary>
        /// The zip or postal code of the contact's address.
        /// </summary>
        public readonly string? ZipCode;

        [OutputConstructor]
        private DomainRegistrantContact(
            string? addressLine1,

            string? addressLine2,

            string? city,

            string? contactType,

            string? countryCode,

            string? email,

            ImmutableArray<Outputs.DomainRegistrantContactExtraParam> extraParams,

            string? fax,

            string? firstName,

            string? lastName,

            string? organizationName,

            string? phoneNumber,

            string? state,

            string? zipCode)
        {
            AddressLine1 = addressLine1;
            AddressLine2 = addressLine2;
            City = city;
            ContactType = contactType;
            CountryCode = countryCode;
            Email = email;
            ExtraParams = extraParams;
            Fax = fax;
            FirstName = firstName;
            LastName = lastName;
            OrganizationName = organizationName;
            PhoneNumber = phoneNumber;
            State = state;
            ZipCode = zipCode;
        }
    }
}
