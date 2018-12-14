def calc_op(x_l, x_r, op):
    if op == "*":
        return x_l * x_r
    elif op == "+":
        return x_l + x_r
    raise Exception("op must be + or *")


def calc(nums, ops, n):
    if n == 1:
        return (
            (nums[0], nums[0])
        )
    if n == 2:
        return (
            calc_op(nums[0], nums[1], ops[0]),
            [nums[0], ops[0], nums[1]]
        )
    r_max = None
    r_glob = None
    for i in range(1, n):
        l_r = calc(nums[:i], ops[:i - 1], i)
        r_r = calc(nums[i:], ops[i:], n - i)
        r_loc = calc_op(l_r[0], r_r[0], ops[i - 1])
        if not r_max or r_loc > r_max:
            r_max = r_loc
            r_glob = [l_r[1], ops[i - 1], r_r[1]]
    return (r_max, r_glob)


calc([, 0.1, 0.1], ["+", "*"], 3)
