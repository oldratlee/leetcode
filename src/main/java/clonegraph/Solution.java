package clonegraph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * <a href="http://oj.leetcode.com/problems/clone-graph/">Problem URL</a>
 *
 * @author Jerry Lee
 */
public class Solution {
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        Map<Integer, UndirectedGraphNode> history = new HashMap<Integer, UndirectedGraphNode>();
        return cloneGraph(node, history);
    }

    public static UndirectedGraphNode cloneGraph(UndirectedGraphNode node, Map<Integer, UndirectedGraphNode> history) {
        if (node == null) return null;
        if (history.containsKey(node.label)) return history.get(node.label);

        ArrayList<UndirectedGraphNode> neighbors = new ArrayList<UndirectedGraphNode>();
        UndirectedGraphNode ret = new UndirectedGraphNode(node.label);
        ret.neighbors = neighbors;
        history.put(node.label, ret);

        for (UndirectedGraphNode neighbor : node.neighbors) {
            neighbors.add(cloneGraph(neighbor, history));
        }

        return ret;
    }
}
