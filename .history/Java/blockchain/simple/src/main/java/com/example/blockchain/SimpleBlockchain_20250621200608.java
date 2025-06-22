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
    
    public static boolean isChainValid() {
        for(int i = 1; i < blockchain.size(); i ++) {
            Block current = blockchain.get(i);
            Block previous = blockchain.get(i - 1);

            if(!current.hash.equals(current.calculateHash())) {
                System.out.println("Invalid hash at block " + i);
                return false;
            }
            if(!current.previousHash.equals(previous.hash)) {
                System.out.println("Invalid previous hash at block " + i);
                return false;
            }

        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println("Creating genesis block...");
        Block genesisBlock = new Block(0, "Genesis Block", "0");
        genesisBlock.mineBlock(difficulty);
        blockchain.add(genesisBlock);

        System.out.println("\n Adding block 1...");
        Block block1 = new Block(1, "Transaction A -> B: $10", blockchain.get(blockchain.size() - 1).hash);
        block1.mineBlock(difficulty);
        blockchain.add(block1);

        System.out.println("\n⛏️ Adding block 2...");
        Block block2 = new Block(2, "Transaction B -> C: $5", blockchain.get(blockchain.size() - 1).hash);
        block2.mineBlock(difficulty);
        blockchain.add(block2);

        System.out.println("\n✅ Blockchain valid? " + isChainValid());

        System.out.println("\n📜 Blockchain contents:");
        for (Block block : blockchain) {
            System.out.println("Index: " + block.index);
            System.out.println("Hash: " + block.hash);
            System.out.println("Prev: " + block.previousHash);
            System.out.println("Data: " + block.data);
            System.out.println("------------");
        }
    }
    }
}

