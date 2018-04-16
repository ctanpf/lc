/*
 * [134] Gas Station
 *
 * https://leetcode.com/problems/gas-station/description/
 *
 * algorithms
 * Medium (30.00%)
 * Total Accepted:    102.4K
 * Total Submissions: 341.5K
 * Testcase Example:  '[4]\n[5]'
 *
 * 
 * There are N gas stations along a circular route, where the amount of gas at
 * station i is gas[i].
 * 
 * 
 * 
 * You have a car with an unlimited gas tank and it costs cost[i] of gas to
 * travel from station i to its next station (i+1). You begin the journey with
 * an empty tank at one of the gas stations.
 * 
 * 
 * 
 * Return the starting gas station's index if you can travel around the circuit
 * once, otherwise return -1.
 * 
 * 
 * 
 * Note:
 * The solution is guaranteed to be unique.
 * 
 */
class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int totalGas = 0;
        int curGas = 0;
        int totalCost = 0;
        int curCost = 0;
        int start = 0;
        for (int i = 0; i < cost.length; i++) {
            totalCost += cost[i];
            curCost += cost[i];
            totalGas += gas[i];
            curGas += gas[i];
            if (curGas < curCost) {
                curGas = 0;
                curCost = 0;
                start = i + 1;
            }
        }
        return totalGas >= totalCost ? start : -1;
    }
}
