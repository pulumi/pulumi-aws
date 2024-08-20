#!/usr/bin/env python
#
# Print all upstream services in JSON.

import os
import json

if __name__ == '__main__':
    d = "upstream/internal/service"
    print(json.dumps([f for f in os.listdir(d)]))
