class TimeMap:
    timeMap: dict[str, list[tuple[str, int]]]

    def __init__(self):
        self.timeMap = {}

    def set(self, key: str, value: str, timestamp: int) -> None:
        if not key in self.timeMap:
            self.timeMap[key] = [(value, timestamp)]
        else:
            self.timeMap[key].append((value, timestamp))
        

    def get(self, key: str, timestamp: int) -> str:
        if not key in self.timeMap:
            return ""
        return self.findValue(self.timeMap[key], timestamp)

    def findValue(self, values: list[tuple[str, int]], timestamp: int) -> str:
        if len(values) == 1:
            (value, prev_timestamp) = values[0]
            return value if prev_timestamp <= timestamp else ""

        left = 0
        right = len(values) - 1
        res = ""
        while left <= right:
            mid = left + (right - left) // 2
            print(f"mid={mid}, ts={timestamp}, values={values}")
            (value, prev_timestamp) = values[mid]
            if prev_timestamp <= timestamp:
                res = value
                left = mid + 1
            else:
                right = mid - 1
        
        return res

        
