package com.portfolio.social_media_api.DTO;

public class UpdateMessageRequest {

    private String messageText;

    public UpdateMessageRequest(){}

    public String getMessageText(){
        return this.messageText;
    }

    public void setMessageText(String messageText) {
        this.messageText = messageText;
    }
}
