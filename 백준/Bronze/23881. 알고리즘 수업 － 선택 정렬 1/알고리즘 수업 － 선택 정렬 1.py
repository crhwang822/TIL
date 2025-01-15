n, k = tuple(map(int,input().split()))
arr = list(map(int,input().split()))

def solution(arr, k):
    temp = 0
    for i in range(n-1, 0, -1):
        max = i
        for j in range(i):
            if arr[j] > arr[max]:
                max = j
        if max != i:
            temp += 1
            arr[max], arr[i] = arr[i], arr[max]
        if temp == k:
            return [arr[max], arr[i]]
    if temp < k:
        return [-1]

for elem in solution(arr, k):
    print(elem, end=" ")