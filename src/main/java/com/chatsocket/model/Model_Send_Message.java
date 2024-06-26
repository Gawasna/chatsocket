package com.chatsocket.model;

import com.chatsocket.app.MessageType;
import org.json.JSONException;
import org.json.JSONObject;

public class Model_Send_Message {

    public MessageType getMessageType() {
        return messageType;
    }

    public void setMessageType(MessageType messageType) {
        this.messageType = messageType;
    }

    public int getFromUserID() {
        return fromUserID;
    }

    public void setFromUserID(int fromUserID) {
        this.fromUserID = fromUserID;
    }

    public int getToUserID() {
        return toUserID;
    }

    public void setToUserID(int toUserID) {
        this.toUserID = toUserID;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Model_File_Sender getFile() {
        return file;
    }

    public void setFile(Model_File_Sender file) {
        this.file = file;
    }

    public Model_Send_Message(MessageType messageType, int fromUserID, int toUserID, String text) {
        this.messageType = messageType;
        this.fromUserID = fromUserID;
        this.toUserID = toUserID;
        this.text = text;
    }

    public long getTimestamp() {
        return timestamp;
    }
    
    public Model_Send_Message(String text, MessageType messageType, Model_File_Sender file) {
        this.text = text;
        this.messageType = messageType;
        this.file = file;
        this.timestamp = System.currentTimeMillis(); 
    }
    //fififfi
    public Model_Send_Message() {
    }

    private MessageType messageType;
    private int fromUserID;
    private int toUserID;
    private String text;
    private Model_File_Sender file;
    private long timestamp;
    
    public JSONObject toJsonObject() {
        try {
            JSONObject json = new JSONObject();
            json.put("messageType", messageType.getValue());
            json.put("fromUserID", fromUserID);
            json.put("toUserID", toUserID);
            if (messageType == MessageType.FILE || messageType == MessageType.IMAGE) {
                json.put("text", file.getFileExtensions());
            } else {
                json.put("text", text);
            }
            return json;
        } catch (JSONException e) {
            return null;
        }
    }
}
