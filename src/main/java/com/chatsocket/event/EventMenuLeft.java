package com.chatsocket.event;

import com.chatsocket.model.Model_User_Account;
import java.util.List;

public interface EventMenuLeft {

    public void newUser(List<Model_User_Account> users);

    public void userConnect(int userID);

    public void userDisconnect(int userID);
}
