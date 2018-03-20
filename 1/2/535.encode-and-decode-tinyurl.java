/*
 * [535] Encode and Decode TinyURL
 *
 * https://leetcode.com/problems/encode-and-decode-tinyurl/description/
 *
 * algorithms
 * Medium (73.83%)
 * Total Accepted:    32.7K
 * Total Submissions: 44.3K
 * Testcase Example:  '"https://leetcode.com/problems/design-tinyurl"'
 *
 * Note: This is a companion problem to the System Design problem: Design
 * TinyURL.
 * 
 * TinyURL is a URL shortening service where you enter a URL such as
 * https://leetcode.com/problems/design-tinyurl and it returns a short URL such
 * as http://tinyurl.com/4e9iAk.
 * 
 * Design the encode and decode methods for the TinyURL service. There is no
 * restriction on how your encode/decode algorithm should work. You just need
 * to ensure that a URL can be encoded to a tiny URL and the tiny URL can be
 * decoded to the original URL.
 */
public class Codec {
    String baseURL = "http://tinyurl.com/";
    String key = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
    Random rand = new Random();
    HashMap<String, String> map = new HashMap<>();

    public String getRandom() {
        String end = "";
        for (int i = 0; i < 6; i++) {
            end += key.charAt(rand.nextInt(key.length()));
        }
        return end;
    }

    // Encodes a URL to a shortened URL.
    public String encode(String longUrl) {
        String end = getRandom();
        while (map.containsKey(end)) end = getRandom();
        map.put(end, longUrl);
        return baseURL + end;
    }

    // Decodes a shortened URL to its original URL.
    public String decode(String shortUrl) {
        shortUrl = shortUrl.replace(baseURL, "");
        return map.get(shortUrl);
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.decode(codec.encode(url));
