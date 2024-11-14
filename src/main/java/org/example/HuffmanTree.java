package org.example;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

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
    public void printLevels() {
        if (root == null) {
            System.out.println("The tree is empty.");
            return;
        }

        Queue<Node> queue = new LinkedList<>();
        queue.add(root);

        boolean hasNextLevel = true;

        while (hasNextLevel) {
            int levelSize = queue.size();
            StringBuilder levelOutput = new StringBuilder();
            hasNextLevel = false;

            for (int i = 0; i < levelSize; i++) {
                Node currentNode = queue.poll();

                if (currentNode == null) {
                    levelOutput.append("* ");
                    queue.add(null);
                    queue.add(null);
                } else {
                    levelOutput.append(currentNode.getVal() != null ? currentNode.getVal() : "*").append(" ");

                    if (currentNode.getLeftChild() != null || currentNode.getRightChild() != null) {
                        hasNextLevel = true;
                    }
                    queue.add(currentNode.getLeftChild());
                    queue.add(currentNode.getRightChild());
                }
            }

            System.out.println(levelOutput.toString().trim());
        }
    }
}