package com.chatsocket.component;

import com.chatsocket.model.Model_Receive_Image;
import java.awt.Color;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.Icon;

public class Chat_Left extends javax.swing.JLayeredPane {

    public Chat_Left() {
        initComponents();
        txt.setBackground(new Color(242,242,242));
    }
    
    public void setText(String text) {
        if (text.equals("")) {
            txt.hideText();
        } else {
            txt.setText(text);
        }
    }
    
    public void setFile(String fileName, String fileSize) {
        txt.setFile(fileName, fileSize);
    }
    
    public void setImage(Icon... image) {
      //  txt.setImage(false, image);
      //    Update next
    }
    
    public void setImage(Model_Receive_Image dataImage) {
        txt.setImage(false, dataImage);
    }

    public void setEmoji(Icon icon) {
        txt.hideText();
        txt.setEmoji(false, icon);
    }
    
    public String getCurrentTimeFormatted() {
        // Lấy thời gian hiện tại
        Date now = new Date();
        // Định dạng theo HH:MM A
        SimpleDateFormat sdf = new SimpleDateFormat("hh:mm a");
        // Chuyển đổi Date thành chuỗi theo định dạng đã chỉ định
        String formattedTime = sdf.format(now);
        return formattedTime;
    }
    
    public void setTime(long timestamp) {
        txt.setTime(getCurrentTimeFormatted()); 
    }   
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txt = new com.chatsocket.component.Chat_Item();

        setLayer(txt, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(txt, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(txt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.chatsocket.component.Chat_Item txt;
    // End of variables declaration//GEN-END:variables
}
