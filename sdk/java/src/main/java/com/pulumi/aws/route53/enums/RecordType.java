// *** WARNING: this file was generated by pulumi-java-gen. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

package com.pulumi.aws.route53.enums;

import com.pulumi.core.annotations.EnumType;
import java.lang.String;
import java.util.Objects;
import java.util.StringJoiner;

    @EnumType
    public enum RecordType {
        A("A"),
        AAAA("AAAA"),
        CNAME("CNAME"),
        CAA("CAA"),
        MX("MX"),
        NAPTR("NAPTR"),
        NS("NS"),
        PTR("PTR"),
        SOA("SOA"),
        SPF("SPF"),
        SRV("SRV"),
        TXT("TXT");

        private final String value;

        RecordType(String value) {
            this.value = Objects.requireNonNull(value);
        }

        @EnumType.Converter
        public String getValue() {
            return this.value;
        }

        @Override
        public java.lang.String toString() {
            return new StringJoiner(", ", "RecordType[", "]")
                .add("value='" + this.value + "'")
                .toString();
        }
    }
