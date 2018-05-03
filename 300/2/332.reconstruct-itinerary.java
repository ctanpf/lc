import sun.print.resources.serviceui_ko;

/*
 * [332] Reconstruct Itinerary
 *
 * https://leetcode.com/problems/reconstruct-itinerary/description/
 *
 * algorithms
 * Medium (29.99%)
 * Total Accepted:    48.5K
 * Total Submissions: 161.6K
 * Testcase Example:  '[["MUC","LHR"],["JFK","MUC"],["SFO","SJC"],["LHR","SFO"]]'
 *
 * Given a list of airline tickets represented by pairs of departure and
 * arrival airports [from, to], reconstruct the itinerary in order. All of the
 * tickets belong to a man who departs from JFK. Thus, the itinerary must begin
 * with JFK.
 * 
 * 
 * Note:
 * 
 * If there are multiple valid itineraries, you should return the itinerary
 * that has the smallest lexical order when read as a single string. For
 * example, the itinerary ["JFK", "LGA"] has a smaller lexical order than
 * ["JFK", "LGB"].
 * All airports are represented by three capital letters (IATA code).
 * You may assume all tickets form at least one valid itinerary.
 * 
 * 
 * 
 * 
 * ⁠   Example 1:
 * ⁠   tickets = [["MUC", "LHR"], ["JFK", "MUC"], ["SFO", "SJC"], ["LHR",
 * "SFO"]]
 * ⁠   Return ["JFK", "MUC", "LHR", "SFO", "SJC"].
 * 
 * 
 * ⁠   Example 2:
 * ⁠   tickets =
 * [["JFK","SFO"],["JFK","ATL"],["SFO","ATL"],["ATL","JFK"],["ATL","SFO"]]
 * ⁠   Return ["JFK","ATL","JFK","SFO","ATL","SFO"].
 * ⁠   Another possible reconstruction is
 * ["JFK","SFO","ATL","JFK","ATL","SFO"]. But it is larger in lexical order.
 * 
 * 
 * Credits:Special thanks to @dietpepsi for adding this problem and creating
 * all test cases.
 */
class Solution {
    public List<String> findItinerary(String[][] tickets) {
        List<String> res = new ArrayList<>();
        HashMap<String, PriorityQueue<String>> map = new HashMap<>();
        for (String[] t : tickets) {
            String orig = t[0];
            String dest = t[1];
            if (!map.containsKey(orig)) {
                map.put(orig, new PriorityQueue<>());
            }
            map.get(orig).offer(dest);
        }
        Stack<String> st = new Stack<>();
        st.push("JFK");
        while (!st.isEmpty()) {
            while (!st.isEmpty() && map.containsKey(st.peek()) && !map.get(st.peek()).isEmpty()) {
                st.push(map.get(st.peek()).poll());
            }
            res.add(0, st.pop());
        }
        return res;
    }
}
