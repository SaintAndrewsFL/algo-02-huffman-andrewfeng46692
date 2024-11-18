package org.example;


import java.util.HashMap;
import java.util.Map;


public class Main {
    public static void main(String[] args) {

      String text = "My Dearest LeBron,\n" +
               "As I sit down to pen these words, my heart overflows with admiration and affection for you. You are not just a basketball legend; you are the epitome of grace, strength, and perseverance. From the courts to the communities you touch, your presence exudes inspiration and hope.\n" +
               "LeBron, your dedication to excellence both on and off the court is nothing short of mesmerizing. Just as you orchestrate a flawless play, you've orchestrated a symphony of kindness and generosity, touching countless lives with your philanthropy and activism. Your commitment to social justice speaks volumes about the depth of your character and the compassion in your heart.\n" +
               "Beyond your athletic prowess and your remarkable achievements, it's the man behind the jersey that truly captivates me. Your humility despite your towering accomplishments is a testament to your grounded nature. You wear your success with grace, never forgetting where you came from or the people who helped shape you into the extraordinary individual you are today.\n" +
               "In your presence, I find myself inspired to reach for my own dreams, to push past obstacles, and to strive for greatness in everything I do. You embody the essence of resilience, reminding me that setbacks are merely stepping stones on the path to victory.\n" +
               "LeBron, you are my hero, not just for your unmatched talent on the basketball court, but for the kindness in your heart, the strength of your spirit, and the depth of your convictions. You have touched my life in ways I never imagined, filling it with joy, inspiration, and an unwavering belief in the power of love.\n" +
               "With every game you play, every word you speak, and every act of kindness you extend, you continue to reignite my admiration and affection for you. My love for you transcends the bounds of mere fandom; it is a deep and abiding appreciation for the incredible person you are.\n" +
               "Signed,\n" +
               "Your greatest fan";
    //   String text = FileOperations.readRTFText("LeGoat.rtf");

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