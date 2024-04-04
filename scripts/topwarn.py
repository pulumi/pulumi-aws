"""
Report on most significant documentation warnings.

There are two sources of data:

- Running `COVERAGE_OUTPUT_DIR="$PWD/cov" make tfgen` produces a JSON report of failed example renders

- metadata/top-resources.yml has some stats on which resources are important

Combine the two.
"""

import argparse as ap
import yaml
import os
import json
import sys
from json.decoder import WHITESPACE


argp = ap.ArgumentParser(description=__doc__)
argp.add_argument('-v', action='store_true', help='Print OriginalHCL', default=False)
args = argp.parse_args()


# https://stackoverflow.com/a/8640959
def str_presenter(dumper, data):
    if len(data.splitlines()) > 1:  # check for multiline string
        return dumper.represent_scalar('tag:yaml.org,2002:str', data, style='|')
    return dumper.represent_scalar('tag:yaml.org,2002:str', data)


def iterload(filename, cls=json.JSONDecoder, **kwargs):
    with open(filename, 'r') as fp:
        string = fp.read()
    decoder = cls(**kwargs)
    idx = WHITESPACE.match(string, 0).end()
    while idx < len(string):
        obj, end = decoder.raw_decode(string, idx)
        yield obj
        idx = WHITESPACE.match(string, end).end()


with open('metadata/top-resources.yml', 'r') as fp:
    top_resources = yaml.safe_load(fp)


coverage_output_dir = os.environ.get('COVERAGE_OUTPUT_DIR', 'cov')


def try_parse_top_resource(example_name):
    for r in top_resources['resources']:
        if example_name.startswith(f'#/resources/{r}'):
            return r, top_resources['resources'][r]['N']


def has_failures(obj):
    for k in obj['ConversionResults']:
        if obj['ConversionResults'][k]['FailureSeverity']:
            return True
    return False


important = []
topres = {}

for obj in iterload(f'{coverage_output_dir}/byExample.json'):
    rn = try_parse_top_resource(obj['ExampleName'])
    if not rn:
        continue
    r, n = rn
    if has_failures(obj):
        obj['Importance'] = n
        obj['Failures'] = list(set([obj['ConversionResults'][k]['FailureInfo'] for k in obj['ConversionResults']]))
        del obj['ConversionResults']

        if not args.v:
            del obj['OriginalHCL']

        topres[r] = True
        important.append(obj)


important = sorted(important, key=lambda r: -r['Importance'])


yaml.add_representer(str, str_presenter)
yaml.representer.SafeRepresenter.add_representer(str, str_presenter)

# Dump to YAML with |-style strings:
print(yaml.safe_dump({
    'CountOfTopResources': len(topres),
    'Problems': important
}))
