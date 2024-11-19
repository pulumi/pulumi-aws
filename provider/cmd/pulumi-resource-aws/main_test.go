// Copyright 2016-2024, Pulumi Corporation.  All rights reserved.

package main

import (
    "testing"
)

func BenchmarkDecompressSchema(b *testing.B) {
    b.ResetTimer()
    for i := 0; i < b.N; i++ {
        decompressed := loadSchema(pulumiSchema, true)
        if len(decompressed) == 0 {
            b.Fatal("empty schema")
        }
    }
}

func BenchmarkSchema(b *testing.B) {
    b.ResetTimer()
    for i := 0; i < b.N; i++ {
        decompressed := loadSchema(pulumiSchema, false)
        if len(decompressed) == 0 {
            b.Fatal("empty schema")
        }
    }
}
