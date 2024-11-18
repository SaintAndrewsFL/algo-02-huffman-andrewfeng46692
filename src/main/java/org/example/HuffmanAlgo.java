package org.example;

import java.util.HashMap;
import java.util.Map;


public class HuffmanAlgo {

    public static Map<Character, String> encodingMap = new HashMap<>();


    public static void encode(String text) {
        // Frequency calculation for each character
        Map<Character, Integer> frequencyMap = new HashMap<>();
        for (char ch : text.toCharArray()) {
            frequencyMap.put(ch, frequencyMap.getOrDefault(ch, 0) + 1);
        }

        HuffmanTree tree = new HuffmanTree(frequencyMap);

        // encoding map
        createEncodingMap(tree.getRoot(), "");

        System.out.println("Character Encoding:");
        for (Map.Entry<Character, String> entry : encodingMap.entrySet()) {
            Character value = entry.getKey();
            if (value != null && (value == '\n' || value == '\r')) {
                System.out.println("↵" + ": " + entry.getValue());
            }else {
                System.out.println(entry.getKey() + ": " + entry.getValue());
            }
        }

        tree.printLevels();
    }

    public static void decode(HuffmanTree tree, String encodedText) {
        StringBuilder decodedText = new StringBuilder();
        Node currentNode = tree.getRoot();

        for (char bit : encodedText.toCharArray()) {
            currentNode = (bit == '0') ? currentNode.getLeftChild() : currentNode.getRightChild();

            if (currentNode.isLeaf()) {
                decodedText.append(currentNode.getVal());
                currentNode = tree.getRoot();  // Reset to root for the next character
            }
        }
        System.out.println("Decoded Text: " + decodedText.toString());
    }

    private static void createEncodingMap(Node node, String code) {
        if (node.isLeaf()) {
            encodingMap.put(node.getVal(), code);
        } else {
            createEncodingMap(node.getLeftChild(), code + "0");
            createEncodingMap(node.getRightChild(), code + "1");
        }
    }


}
