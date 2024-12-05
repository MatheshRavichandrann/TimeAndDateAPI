package com.mugiwara.HuffmanCoder.service;

import org.springframework.stereotype.Service;
@Service
public class HuffmanService {


    public String encode(String input) throws Exception{
        HuffmanCoder coder = new HuffmanCoder(input);
        return coder.encode(input);
    }

    public String decode(String input, String encodedText) throws Exception {
        HuffmanCoder coder = new HuffmanCoder(input);
        return coder.decode(encodedText);

    }
}
