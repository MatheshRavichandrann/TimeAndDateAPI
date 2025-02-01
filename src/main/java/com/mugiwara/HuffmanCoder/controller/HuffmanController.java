/*
package com.mugiwara.HuffmanCoder.controller;

import com.mugiwara.HuffmanCoder.service.HuffmanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/huffman")
public class HuffmanController {

    @Autowired
    private HuffmanService huffmanService;

    @PostMapping("/encode")
    public String encode(@RequestParam String input){
        try {
            return huffmanService.encode(input);
        }catch (Exception e){
            return "Error: " + e.getMessage();
        }
    }

    @PostMapping("/decode")
    public String decode(@RequestParam String input, @RequestParam String encodedText){
        try {
            return huffmanService.decode(input, encodedText);
        }catch (Exception e){
            return "Error: " + e.getMessage();
        }
    }

}
*/
