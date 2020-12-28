//
// Created by AiRanthem on 2020/12/24.
//

// 邻接图节点，weight=表头到这个节点的边距离
class GraphNode {
public:
    int id;
    int degree = 0;
    int weight;
    GraphNode *next = nullptr;

    explicit GraphNode(int id = 0) : id(id), weight(0) {}

    GraphNode(int id, int weight) : id(id), weight(weight) {}
};

class TreeGraph {
private:
    map<int, GraphNode> table; // 第一个node是头节点，用其id表示度
    int nodesLeft = 0;

    void link(int s, int t, int w) {
        GraphNode *head = &table[s];
        auto *n = new GraphNode(t, w);
        n->next = head->next;
        head->next = n;
        ++head->degree;
        ++head->id;
        if (head->degree == 1) {
            ++nodesLeft;
        }
    }

public:
    ~TreeGraph() {
        for (auto &iter : table) {
            GraphNode *node = iter.second.next;
            GraphNode *tmp;
            while (node != nullptr) {
                tmp = node->next;
                delete node;
                node = tmp;
            }
        }
    }

    int getNodesLeft() const {
        return nodesLeft;
    }

    int degreeOf(int n) {
        return table[n].degree;
    }

    void addEdge(int s, int t, int w) {
        link(s, t, w);
        link(t, s, w);
    }

    void removeNode(int n) {
        --nodesLeft;
        GraphNode *head = &table[n];
        head->degree = -1; // degree <= 0 means removed
        GraphNode *node = head->next;
        while (node) {
            --table[node->id].degree;
            if (table[node->id].degree == 0) {
                // reduced to 0 means a removing happened
                --nodesLeft;
            }
            node = node->next;
        }
    }

    vector<int> getLeaves() {
        vector<int> v;
        for (const auto &iter : table) {
            if (iter.second.degree == 1) {
                v.push_back(iter.first);
            }
        }
        return v;
    }

    vector<int> getNodeWithMaxDegree() {
        vector<int> v;
        int maxDeg = -1;
        for (const auto &iter : table) {
            if (iter.second.degree > maxDeg) {
                maxDeg = iter.second.degree;
            }
        }
        for (const auto &iter : table) {
            if (iter.second.degree == maxDeg) {
                v.push_back(iter.first);
            }
        }
        return v;
    }

    int calculateTotDist(int node, int from = 0) {
        int dist = 0;
        GraphNode *child = table[node].next;
        while (child != nullptr) {
            if (child->id == from) {
                child = child->next;
                continue;
            }
            dist += calculateTotDist(child->id, node) * (table[child->id].id - 1);
            dist += child->weight;
            child = child->next;
        }
        return dist;
    }
};
