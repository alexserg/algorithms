# -*- coding: utf-8 -*-
def count_healthy_trees_groups(forest):
    healthy = [0]
    zeroes = False

    for i in range(len(forest)):
        if forest[i] == 1:
            healthy[-1] += 1
            zeroes = True

        else:
            if zeroes and (i != len(forest) - 1):
                healthy.append(0)
            zeroes = False

    return healthy


forest = [1, 1, 1, 0, 1, 1, 1, 0, 1]  # 1- healthy tree
doors = 2
survived = 0

# если все деревья здоровые, то они все выживают
if not 0 in forest:
    survived = len(forest)

healthy = count_healthy_trees_groups(forest)
healthy.sort(reverse=True)

left_side = 0
for tree in forest:
    if tree == 1:
        left_side += 1
    else:
        break

right_side = 0
for tree in forest[::-1]:
    if tree == 1:
        right_side += 1
    else:
        break

# если дверь всего одна, то решение- максимальный край
if doors == 1:
    survived = max(left_side, right_side)
    print survived


if survived == 0:
    left_side_used = False
    right_side_used = False
    i = 0

    while doors > 0:
        if i == len(healthy):
            break

        # если лево+право больше чем текущий элемент, то выгоднее использовать оба края
        if (left_side + right_side > healthy[i]) \
                and ((left_side < healthy[i]) or (right_side < healthy[i])):
            survived += left_side
            survived += right_side
            left_side_used = True
            right_side_used = True
            doors -= 2
            i += 1
            continue

        if (not left_side_used) and (healthy[i] == left_side):
            survived += healthy[i]
            doors -= 1
            left_side_used = True
            i += 1
            print 'left side is used'
            continue

        if (not right_side_used) and (healthy[i] == right_side):
            survived += healthy[i]
            doors -= 1
            right_side_used = True
            i += 1
            print 'right side is used'
            continue

        if doors >= 2:
            survived += healthy[i]
            doors -= 2
            i += 1

    print 'survived: ', survived
    print 'doors left: ', doors
