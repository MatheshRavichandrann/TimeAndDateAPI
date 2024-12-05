package com.mugiwara.HuffmanCoder.service;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;

public class HuffmanCoder {
    private HashMap<Character, String> encoder;
    private HashMap<String, Character> decoder;

    private class Node implements Comparable<Node> {
        Character data;
        int cost; // Frequency
        Node left;
        Node right;

        public Node(Character data, int cost) {
            this.data = data;
            this.cost = cost;
            this.left = null;
            this.right = null;
        }

        @Override
        public int compareTo(Node other) {
            return this.cost - other.cost;
        }
    }

    public HuffmanCoder(String feeder) throws Exception {
        HashMap<Character, Integer> frequencyMap = new HashMap<>();
        for (int i = 0; i < feeder.length(); i++) {
            char ch = feeder.charAt(i);
            frequencyMap.put(ch, frequencyMap.getOrDefault(ch, 0) + 1);
        }

        PriorityQueue<Node> minHeap = new PriorityQueue<>();
        Set<Map.Entry<Character, Integer>> entrySet = frequencyMap.entrySet();

        for (Map.Entry<Character, Integer> entry : entrySet) {
            Node node = new Node(entry.getKey(), entry.getValue());
            minHeap.add(node);
        }

        while (minHeap.size() != 1) {
            Node first = minHeap.remove();
            Node second = minHeap.remove();

            Node newNode = new Node('\0', first.cost + second.cost);
            newNode.left = first;
            newNode.right = second;

            minHeap.add(newNode);
        }

        Node fullTree = minHeap.remove();
        this.encoder = new HashMap<>();
        this.decoder = new HashMap<>();
        this.initEncoderDecoder(fullTree, "");
    }

    private void initEncoderDecoder(Node node, String outputSoFar) {
        if (node == null) return;

        if (node.left == null && node.right == null) {
            this.encoder.put(node.data, outputSoFar);
            this.decoder.put(outputSoFar, node.data);
        }

        initEncoderDecoder(node.left, outputSoFar + "0");
        initEncoderDecoder(node.right, outputSoFar + "1");
    }

    public String encode(String source) {
        StringBuilder ans = new StringBuilder();
        for (int i = 0; i < source.length(); i++) {
            ans.append(encoder.get(source.charAt(i)));
        }
        return ans.toString();
    }

    public String decode(String codedString) {
        String key = "";
        StringBuilder ans = new StringBuilder();
        for (int i = 0; i < codedString.length(); i++) {
            key += codedString.charAt(i);
            if (decoder.containsKey(key)) {
                ans.append(decoder.get(key));
                key = "";
            }
        }
        return ans.toString();
    }
}
