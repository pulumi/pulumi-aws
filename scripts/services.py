#!/usr/bin/env python
#
# Print all upstream services that have Go tests as JSON.

import os
import json


def has_tests(service):
    for f in os.listdir(f"upstream/internal/service/{service}"):
        if "_test.go" in f:
            return True
    return False


if __name__ == '__main__':
    d = "upstream/internal/service"
    s = [f for f in os.listdir(d) if has_tests(f)]
    print(json.dumps(s))
