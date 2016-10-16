package com.example.m_tomomi.marriagehunter.activities;

/**
 * Created by mm on 2016/07/14.
 */
public class ChatMessage {
    public String timestamp;
    public String sender;
    public String body;

    public ChatMessage(String timestamp, String sender, String body) {
        this.timestamp = timestamp;
        this.sender = sender;
        this.body = body;
    }
}
