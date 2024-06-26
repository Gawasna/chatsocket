package com.chatsocket.model;

import com.chatsocket.util.AESUtils;
import org.json.JSONException;
import org.json.JSONObject;

import javax.crypto.SecretKey;
import java.util.Base64;

public class Model_Login {
    private String userName;
    private String password;
    private static SecretKey secretKey;

    public Model_Login(String userName, String password) {
        this.userName = userName;
        this.password = password;
        if (secretKey == null) {
            try {
                secretKey = AESUtils.generateKey();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public Model_Login() {
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public JSONObject toJsonObject() {
        try {
            JSONObject obj = new JSONObject();
            obj.put("userName", AESUtils.encrypt(userName, secretKey));
            obj.put("password", AESUtils.encrypt(password, secretKey));
            obj.put("secretKey", Base64.getEncoder().encodeToString(secretKey.getEncoded()));
            return obj;
        } catch (Exception e) {
            return null;
        }
    }
}
