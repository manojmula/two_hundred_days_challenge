package com.example.blockchain;

import java.util.*;
import java.security.MessageDigest;

class Block {
    public int index;
    public String timeStamp;
    public String data;
    public String previousHash;
    public String hash;
    public int nonce;

    public Block(int index, String data, String previousHash) {
        this.index = index;
        this.timeStamp = new Date().toString();
        this.data = data;
        this.previousHash = previousHash;
        this.hash = calculateHash();
        this.nonce = 0;
    }

    public String calculateHash()  {
        try {
            String input = index + timestamp + data + previousHash + nonce;
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            byte[] hashBytes = digest.digest(input.getBytes("UTF-8"));
            StringBuilder hexString = new StringBuilder();
            for (byte b: hashBytes) {
                String hex = Integer.toHexString(0xff & b);
                if(hex.length() == 1) hexString.append('0')
                hexString.append(hex);
            }
            return hexString.toString();
        } catch (Exception e) {
            throw new RunTimeException(e)
        }
    }

    public void mineBlock(int difficulty) {
        String prefix = new String(new char[difficulty]).replace('\0', '0');
        while(!this.hash.substring(0, difficulty).equals(prefix)) {
            this.nonce++;
            this.hash = calculateHash();
        }
        System.out.println("Block mind: " + this.hash);
    }
}

public class SimpleBlockChain {
    public static List<Block> blockchain = new ArrayList<>();
    public static int difficulty = 4;
}

