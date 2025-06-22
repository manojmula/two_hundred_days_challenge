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
}