h = sorted([int(input()) for _ in range(9)])
excess = sum(h) - 100

for i in h:
    for j in h:
        if (i + j) == excess:
            for k in h:
                if k != i and k != j:
                    print(k)
            exit(0)