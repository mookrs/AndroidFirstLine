package com.example.uibestpractice;

/**
 * Created by mookrs on 16/1/10.
 */
public class Msg {

    // TYPE_RECEIVED表示这是一条收到的消息
    // TYPE_SENT表示这是一条发出的消息
    public static final int TYPE_RECEIVED = 0;
    public static final int TYPE_SENT = 1;

    private String content;
    private int type;

    public Msg(String content, int type) {
        this.content = content;
        this.type = type;
    }

    public String getContent() {
        return content;
    }

    public int getType() {
        return type;
    }
}
