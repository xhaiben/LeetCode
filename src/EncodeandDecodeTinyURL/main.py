import hashlib
import random


class Codec:
    url_map = {}

    chars = ('0', '1', '2', '3', '4', '5', '6', '7', '8', '9',
             'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u',
             'v',
             'w', 'x', 'y', 'z', 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q',
             'R',
             'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z')

    def encode(self, longUrl):
        """Encodes a URL to a shortened URL.

        :type longUrl: str
        :rtype: str
        """
        url_list = []
        md5 = hashlib.md5()
        md5.update(longUrl.encode('UTF-8'))
        hash_bytes = md5.hexdigest()
        for i in range(0, 32, 8):
            url_bytes = hash_bytes[i:i + 8]
            n = int(url_bytes, 16)
            n &= 0x3FFFFFFF
            short_url = ""
            for j in range(0, 6):
                k = n & 0x1F
                # print(k)
                short_url += Codec.chars[k]
                n >>= 5
            url_list.append(short_url)
        short_url = url_list[random.randint(0, 3)]
        Codec.url_map[short_url] = longUrl
        return short_url

    def decode(self, shortUrl):
        """Decodes a shortened URL to its original URL.

        :type shortUrl: str
        :rtype: str
        """
        return Codec.url_map[shortUrl]


codec = Codec()
print(codec.decode(codec.encode('https://leetcode.com/problems/design-tinyurl')))
