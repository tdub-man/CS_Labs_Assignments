# from decimal import Decimal
def collatz(n):
    val = 0
    while n != 1:
        # if val > 1000:
            # print(n)
        if n%2 == 0:
            val += 1
            n = n/2
        else:
            val += 1
            n = (3*n) + 1
    return val

def testCollatz():
    x = pow(2,744)-1
    # y = Decimal(x)
    # print("{0:E}".format(x))
    MAX = 0
    while MAX <= 10000:
        x += x/2 if x%2==0 else (x+1)/2
        c = collatz(x)
        if c>MAX:
            print("Max={1} : X={0}".format(x,MAX))
            MAX = c
        # MAX = c if c>MAX else MAX
    # print("X={0}".format(x))

# Find the maximum between two powers of 2
# def bwCollatz(minPow,maxPow):
#     pass
