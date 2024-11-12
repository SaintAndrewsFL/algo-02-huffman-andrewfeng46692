package org.example;


import java.util.HashMap;
import java.util.Map;


public class Main {
    public static void main(String[] args) {

        String text = FileOperations.readRTFText("LeGoat.rtf");

        if (text != null) {
            System.out.println("File Content:");
            System.out.println(text);
        } else {
            System.out.println("Failed to read the RTF file.");
        }

        System.out.println("Original Text: " + text);
        HuffmanAlgo.encode(text);

        StringBuilder encodedText = new StringBuilder();
        for (char ch : text.toCharArray()) {
            encodedText.append(HuffmanAlgo.encodingMap.get(ch));
        }

        System.out.println("Encoded Text: " + encodedText);

        Map<Character, Integer> frequencyMap = new HashMap<>();
        for (char ch : text.toCharArray()) {
            frequencyMap.put(ch, frequencyMap.getOrDefault(ch, 0) + 1);
        }

        HuffmanTree huffmanTree = new HuffmanTree(frequencyMap);
        HuffmanAlgo.decode(huffmanTree, encodedText.toString());
        System.out.println("Test");
    }


}