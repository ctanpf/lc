/*
 * [207] Course Schedule
 *
 * https://leetcode.com/problems/course-schedule/description/
 *
 * algorithms
 * Medium (33.81%)
 * Total Accepted:    122.5K
 * Total Submissions: 362.5K
 * Testcase Example:  '2\n[[1,0]]'
 *
 * 
 * There are a total of n courses you have to take, labeled from 0 to n - 1.
 * 
 * Some courses may have prerequisites, for example to take course 0 you have
 * to first take course 1, which is expressed as a pair: [0,1]
 * 
 * 
 * Given the total number of courses and a list of prerequisite pairs, is it
 * possible for you to finish all courses?
 * 
 * 
 * For example:
 * 2, [[1,0]]
 * There are a total of 2 courses to take. To take course 1 you should have
 * finished course 0. So it is possible.
 * 
 * 2, [[1,0],[0,1]]
 * There are a total of 2 courses to take. To take course 1 you should have
 * finished course 0, and to take course 0 you should also have finished course
 * 1. So it is impossible.
 * 
 * Note:
 * The input prerequisites is a graph represented by a list of edges, not
 * adjacency matrices. Read more about how a graph is represented.
 * You may assume that there are no duplicate edges in the input
 * prerequisites.
 * 
 * 
 * 
 * click to show more hints.
 * 
 * Hints:
 * 
 * This problem is equivalent to finding if a cycle exists in a directed graph.
 * If a cycle exists, no topological ordering exists and therefore it will be
 * impossible to take all courses.
 * Topological Sort via DFS - A great video tutorial (21 minutes) on Coursera
 * explaining the basic concepts of Topological Sort.
 * Topological sort could also be done via BFS.
 * 
 * 
 */
class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int[] edges = new int[numCourses];
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        for (int[] e : prerequisites) {
            int in = e[0];
            int out = e[1];
            if (!map.containsKey(out)) map.put(out, new ArrayList<>());
            map.get(out).add(in);
            edges[in]++;
        }
        int count = 0;
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < edges.length; i++) {
            if (edges[i] == 0) q.offer(i);
        }
        while (!q.isEmpty()) {
            int node = q.poll();
            count++;
            if (map.containsKey(node)) {
                List<Integer> dep = map.get(node);
                for (Integer i : dep) {
                    edges[i]--;
                    if (edges[i] == 0) q.offer(i);
                }
            }
        }
        return count == numCourses;   
    }
}
