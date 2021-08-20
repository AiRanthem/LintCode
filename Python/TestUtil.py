from typing import Callable


class Test:
    def __init__(self, cls):
        self.cls = cls

    def run(self, cases, f):
        for case in cases:
            attr = getattr(self.cls, f)
            if isinstance(case, tuple):
                print(attr(*case))
            elif isinstance(case, dict):
                print(attr(**case))
            else:
                print(attr(case))


def __do_nothing(x):
    return x


def console_test(converter: Callable, mapper: Callable = __do_nothing):
    while True:
        user_input = input()
        if user_input == "exit":
            print("Bye")
            break
        case = list(map(mapper, user_input.split()))
        converter(case)


def error_test(file: str, converter: Callable, mapper: Callable = __do_nothing, debug_cases=None):
    if debug_cases is None:
        debug_cases = []
    with open(file) as f:
        cases = [list(map(mapper, line[5:-2].split(','))) for line in f.readlines()]
        for case in cases:
            if case in debug_cases:
                converter(case)
            else:
                converter(case)
