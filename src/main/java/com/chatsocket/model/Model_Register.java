package com.chatsocket.model;

import com.chatsocket.util.AESUtils;
import org.json.JSONException;
import org.json.JSONObject;

import javax.crypto.SecretKey;
import java.util.Base64;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Model_Register {
    private String userName;
    private String password;
    private static SecretKey secretKey;

    public Model_Register(String userName, String password) {
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

    public Model_Register() {
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
            JSONObject json = new JSONObject();
            json.put("userName", AESUtils.encrypt(userName, secretKey));
            json.put("password", AESUtils.encrypt(password, secretKey));
            json.put("secretKey", Base64.getEncoder().encodeToString(secretKey.getEncoded()));
            return json;
        } catch (JSONException e) {
            return null;
        } catch (Exception ex) {
            Logger.getLogger(Model_Register.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
}
