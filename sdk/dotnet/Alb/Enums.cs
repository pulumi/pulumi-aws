// *** WARNING: this file was generated by pulumi-language-dotnet. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

using System;
using System.ComponentModel;
using Pulumi;

namespace Pulumi.Aws.Alb
{
    [EnumType]
    public readonly struct IpAddressType : IEquatable<IpAddressType>
    {
        private readonly string _value;

        private IpAddressType(string value)
        {
            _value = value ?? throw new ArgumentNullException(nameof(value));
        }

        public static IpAddressType Ipv4 { get; } = new IpAddressType("ipv4");
        public static IpAddressType Dualstack { get; } = new IpAddressType("dualstack");

        public static bool operator ==(IpAddressType left, IpAddressType right) => left.Equals(right);
        public static bool operator !=(IpAddressType left, IpAddressType right) => !left.Equals(right);

        public static explicit operator string(IpAddressType value) => value._value;

        [EditorBrowsable(EditorBrowsableState.Never)]
        public override bool Equals(object? obj) => obj is IpAddressType other && Equals(other);
        public bool Equals(IpAddressType other) => string.Equals(_value, other._value, StringComparison.Ordinal);

        [EditorBrowsable(EditorBrowsableState.Never)]
        public override int GetHashCode() => _value?.GetHashCode() ?? 0;

        public override string ToString() => _value;
    }

    [EnumType]
    public readonly struct LoadBalancerType : IEquatable<LoadBalancerType>
    {
        private readonly string _value;

        private LoadBalancerType(string value)
        {
            _value = value ?? throw new ArgumentNullException(nameof(value));
        }

        public static LoadBalancerType Application { get; } = new LoadBalancerType("application");
        public static LoadBalancerType Network { get; } = new LoadBalancerType("network");

        public static bool operator ==(LoadBalancerType left, LoadBalancerType right) => left.Equals(right);
        public static bool operator !=(LoadBalancerType left, LoadBalancerType right) => !left.Equals(right);

        public static explicit operator string(LoadBalancerType value) => value._value;

        [EditorBrowsable(EditorBrowsableState.Never)]
        public override bool Equals(object? obj) => obj is LoadBalancerType other && Equals(other);
        public bool Equals(LoadBalancerType other) => string.Equals(_value, other._value, StringComparison.Ordinal);

        [EditorBrowsable(EditorBrowsableState.Never)]
        public override int GetHashCode() => _value?.GetHashCode() ?? 0;

        public override string ToString() => _value;
    }
}
