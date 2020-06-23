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
