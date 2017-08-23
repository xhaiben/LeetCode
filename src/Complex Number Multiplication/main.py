class Solution(object):
    def complexNumberMultiply(self, a, b):
        """
        :type a: str
        :type b: str
        :rtype: str
        """
        n1 = a[0:a.index('+')]
        n2 = a[a.index('+') + 1:a.index('i')]
        n3 = b[0:b.index('+')]
        n4 = b[b.index('+') + 1:b.index('i')]

        q = int(n1) * int(n3) - int(n2) * int(n4)
        p = int(n1) * int(n4) + int(n2) * int(n3)

        return str(q) + '+' + str(p) + 'i'


solution = Solution()
a = "-11+-30i"
b = "55+-69i"
print solution.complexNumberMultiply(a, b)
