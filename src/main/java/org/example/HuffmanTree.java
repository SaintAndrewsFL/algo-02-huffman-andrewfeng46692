package org.example;


import java.util.Map;
import java.util.PriorityQueue;

public class HuffmanTree {

    private Node root;

    public HuffmanTree(Map<Character, Integer> frequencyMap) {
        PriorityQueue<Node> priorityQueue = new PriorityQueue<>((n1, n2) -> n1.getFrequency() - n2.getFrequency());

        for (Map.Entry<Character, Integer> entry : frequencyMap.entrySet()) {
            priorityQueue.offer(new Node(entry.getValue(), entry.getKey()));
        }

        while (priorityQueue.size() > 1) {
            Node left = priorityQueue.poll();
            Node right = priorityQueue.poll();
            Node parent = new Node(left, right);
            priorityQueue.offer(parent);
        }
        root = priorityQueue.poll();
    }

    public Node getRoot() {
        return root;
    }
}

