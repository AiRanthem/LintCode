package src.terminate_process_872;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

public class Solution {
    /**
     * 这个问题中. 每个进程都有一个唯一的 PID(进程id) 和 PPID(父进程id)。每个进程只有一个父进程，但可能有一个或多个子进程，这就像一个树形结构。并且只有一个进程的PPID是0，这意味着这个进程没有父进程。所有的pid都是不同的正整数。
     我们使用两个整数列表来表示进程列表，其中第一个列表包含每个进程的PID，第二个列表包含对应的PPID。
     现在给定这两个列表，以及一个你要终止(kill)的进程的ID，返回将在最后被终止的进程的PID列表。（当一个进程被终止时，它的所有子进程将被终止。返回的列表没有顺序要求）

     >给定的kill id一定是PID列表中的某个id
     >给定的PID列表中至少含有一个进程
     * @param pid: the process id
     * @param ppid: the parent process id
     * @param kill: a PID you want to kill
     * @return a list of PIDs of processes that will be killed in the end
     */

    public List<Integer> killProcess(List<Integer> pid, List<Integer> ppid, int kill) {
        HashMap<Integer, Node> idNodeMap = new HashMap<>(pid.size());
        for (int i = 0; i < pid.size(); i++) {
            Integer pp = ppid.get(i);
            Integer p = pid.get(i);
            Node ppNode = idNodeMap.get(pp);
            if (ppNode == null) {
                ppNode = new Node(pp);
                idNodeMap.put(pp, ppNode);
            }
            Node pNode = idNodeMap.get(p);
            if (pNode == null) {
                pNode = new Node(p);
                idNodeMap.put(p, pNode);
            }
            ppNode.children.add(pNode);
        }

        ArrayList<Node> res = new ArrayList<>();
        res.add(idNodeMap.get(kill));

        int cur = 0;
        while (cur < res.size()) {
            Node node = res.get(cur);
            res.addAll(node.children);
            cur++;
        }

        ArrayList<Integer> resPids = new ArrayList<>(res.size());
        for (Node node : res) {
            resPids.add(node.pid);
        }
        return resPids;
    }

    public static class Node{
        public int pid;
        public List<Node> children = new ArrayList<>();
        public Node(int pid) {
            this.pid = pid;
        }
    }
}