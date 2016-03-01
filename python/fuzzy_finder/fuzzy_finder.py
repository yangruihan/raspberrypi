#!/usr/bin/env python3

import re

collection = ['django_migrations.py',
              'django_admin_log.py',
              'main_generator.py',
              'migrations.py',
              'api_user.doc',
              'user_group.doc',
              'accounts.txt',
              ]


def fuzzyfinder(user_input, collection):
    suggestions = []
    pattern = '.*?'.join(user_input)
    regex = re.compile(pattern)
    for item in collection:
        match = regex.search(item)
        if match:
            suggestions.append((len(match.group()), match.start(), item))
    return [x for _, _, x in sorted(suggestions)]

if __name__ == '__main__':
    print(fuzzyfinder('mig', collection))
