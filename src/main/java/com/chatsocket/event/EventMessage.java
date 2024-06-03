package com.chatsocket.event;

import com.chatsocket.model.Model_Message;

public interface EventMessage {
    public void callMessage(Model_Message message);
}
