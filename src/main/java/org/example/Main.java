package org.example;

import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        // Sample text to encode and decode
        String text = "hello huffman";

        // Encode the text
        System.out.println("Original Text: " + text);
        HuffmanAlgo.encode(text);

        // Build the encoded text using the encoding map
        StringBuilder encodedText = new StringBuilder();
        for (char ch : text.toCharArray()) {
            encodedText.append(HuffmanAlgo.encodingMap.get(ch));
        }

        System.out.println("Encoded Text: " + encodedText);

        // Rebuild the frequency map from the original text
        Map<Character, Integer> frequencyMap = new HashMap<>();
        for (char ch : text.toCharArray()) {
            frequencyMap.put(ch, frequencyMap.getOrDefault(ch, 0) + 1);
        }

        // Decode the encoded text
        HuffmanTree huffmanTree = new HuffmanTree(frequencyMap);
        HuffmanAlgo.decode(huffmanTree, encodedText.toString());
    }
}