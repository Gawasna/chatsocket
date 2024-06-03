package com.chatsocket.component;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.border.EmptyBorder;

public class Chat_Item extends javax.swing.JLayeredPane {
    
    private JLabel label;
    
    public Chat_Item() {
        initComponents();
        txt.setEditable(false);
        txt.setBackground(new Color(0,0,0,0));
        txt.setOpaque(false);
    }

    public void setUserProfile(String user) {
         JLayeredPane layer = new JLayeredPane();
        layer.setLayout(new FlowLayout(FlowLayout.LEFT,0,0));
        layer.setBorder(new EmptyBorder(10, 10, 0, 10));
        JButton cmd = new JButton(user);
        cmd.setContentAreaFilled(false);
        cmd.setFocusable(false);
        cmd.setForeground(new Color(30,121,213));
        cmd.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        cmd.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        //txt.setBorder(new EmptyBorder(5, 10, 10, 10));
        txt.setBorder(javax.swing.BorderFactory.createEmptyBorder(5, 10, 5, 10));
        cmd.setBorder(null);
        layer.add(cmd);
        add(layer, 0);
    }
    
    public void setText(String text) {
        txt.setText(text);
    }
    
    public void setTime(String time) {
        JLayeredPane layer = new JLayeredPane();
        layer.setLayout(new FlowLayout(FlowLayout.RIGHT,0,0));
        layer.setBorder(new EmptyBorder(0, 5, 5, 5));
        label = new JLabel(time);
        label.setForeground(new Color(110,110,110));
        label.setHorizontalTextPosition(JLabel.LEFT);
        label.setFont(new java.awt.Font("Dialog", 2, 10));
        layer.add(label);
        add(layer);
    }
    
    public void setImage(boolean right, Icon ... image) {
        if (image.length > 0) {
            JLayeredPane layer = new JLayeredPane();
            layer.setLayout(new FlowLayout(right ? FlowLayout.RIGHT : FlowLayout.LEFT));
            layer.setBorder(new EmptyBorder(0, 5, 0, 5));
            Chat_Image chatImage = new Chat_Image(right);
            chatImage.addImage(image);
            layer.add(chatImage);
            add(layer);
        }
    }
    
    public void setImage(boolean right, String... image) {
        JLayeredPane layer = new JLayeredPane();
        layer.setLayout(new FlowLayout(right?FlowLayout.RIGHT:FlowLayout.LEFT));
        layer.setBorder(new EmptyBorder(0, 5, 0, 5));
        Chat_Image chatimage= new Chat_Image(right);
        chatimage.addImage(image);
        layer.add(chatimage);
        add(layer);
    }
    
    public void setFile(String fileName, String fileSize) {
        JLayeredPane layer = new JLayeredPane();
        layer.setLayout(new FlowLayout(FlowLayout.LEFT));
        layer.setBorder(new EmptyBorder(0, 5, 0, 5));
        Chat_File chatFile = new Chat_File();
        chatFile.setFile(fileName, fileSize);
        layer.add(chatFile);
        add(layer);
    }
    
    public void sendSuccess() {
        if (label != null) {
            label.setIcon(new ImageIcon(getClass().getResource("/images/icons8-tick-15.png")));
        }
    }
    
    public void seen() {
        if (label != null) {
            label.setIcon(new ImageIcon(getClass().getResource("/images/icons8-double-tick-15.png")));
        }
    }
    
    public void hideText() {
        txt.setVisible(false);
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txt = new com.chatsocket.swing.JIMSendTextPane();

        setLayout(new javax.swing.BoxLayout(this, javax.swing.BoxLayout.PAGE_AXIS));

        txt.setBorder(javax.swing.BorderFactory.createEmptyBorder(10, 10, 5, 10));
        txt.setSelectionColor(new java.awt.Color(102, 204, 255));
        add(txt);
    }// </editor-fold>//GEN-END:initComponents

    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D gp = (Graphics2D) g;
        gp.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        gp.setColor(getBackground());
        gp.fillRoundRect(0, 0, getWidth(), getHeight(), 15, 15);
        super.paintComponent(g); 
    }
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.chatsocket.swing.JIMSendTextPane txt;
    // End of variables declaration//GEN-END:variables
}
