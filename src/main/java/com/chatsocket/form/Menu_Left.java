package com.chatsocket.form;

import com.chatsocket.component.Item_People;
import com.chatsocket.event.EventMenuLeft;
import com.chatsocket.event.PublicEvent;
import com.chatsocket.model.Model_User_Account;
import com.chatsocket.swing.ScrollBar;
import java.awt.Component;
import java.util.ArrayList;
import java.util.List;
import net.miginfocom.swing.MigLayout;

public class Menu_Left extends javax.swing.JPanel {

    private List<Model_User_Account> userAccount;
    
    public Menu_Left() {
        initComponents();
        init();
    }

    private void init() {
        sp.setVerticalScrollBar(new ScrollBar());
        menuList.setLayout(new MigLayout("fillx","0[]0","2[]2"));
        userAccount = new ArrayList<>();
        PublicEvent.getInstance().addEventMenuLeft(new EventMenuLeft() {
            @Override
            public void newUser(List<Model_User_Account> users) {
                for (Model_User_Account d : users) {
                    userAccount.add(d);
                    menuList.add(new Item_People(d), "wrap");
                    refreshMenuList();
                }
            }

            @Override
            public void userConnect(int userID) {
                for (Model_User_Account u : userAccount) {
                    if (u.getUserID() == userID) {
                        u.setStatus(true);
                        PublicEvent.getInstance().getEventMain().updateUser(u);
                        break;
                    }
                }
                if (menuMessage.isSelected()) {
                    for (Component com : menuList.getComponents()) {
                        Item_People item = (Item_People) com;
                        if (item.getUser().getUserID() == userID) {
                            item.updateStatus();
                            break;
                        }
                    }
                }
            }

            @Override
            public void userDisconnect(int userID) {
                for (Model_User_Account u : userAccount) {
                    if (u.getUserID() == userID) {
                        u.setStatus(false);
                        PublicEvent.getInstance().getEventMain().updateUser(u);
                        break;
                    }
                }
                if (menuMessage.isSelected()) {
                    for (Component com : menuList.getComponents()) {
                        Item_People item = (Item_People) com;
                        if (item.getUser().getUserID() == userID) {
                            item.updateStatus();
                            break;
                        }
                    }
                }
            }
        });
        showMessage();
    }
    
    private void showMessage() {
        //  test data
        menuList.removeAll();
        for (Model_User_Account d : userAccount) {
            menuList.add(new Item_People(null), "wrap");
        }
        refreshMenuList();
    }

    private void showGroup() {
        //  test data
        menuList.removeAll();
        for (int i = 0; i < 5; i++) {
            menuList.add(new Item_People(null), "wrap");
        }
        refreshMenuList();
    }

    private void showBox() {
        //  test data
        menuList.removeAll();
        for (int i = 0; i < 10; i++) {
            menuList.add(new Item_People(null), "wrap");
        }
        refreshMenuList();
    }

    private void refreshMenuList() {
        menuList.repaint();
        menuList.revalidate();
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        menu = new javax.swing.JLayeredPane();
        menuMessage = new com.chatsocket.component.MenuButton();
        sp = new javax.swing.JScrollPane();
        menuList = new javax.swing.JLayeredPane();

        setBackground(new java.awt.Color(242, 242, 242));

        menu.setBackground(new java.awt.Color(229, 229, 229));
        menu.setOpaque(true);
        menu.setLayout(new java.awt.GridLayout(1, 0));

        menuMessage.setBorder(null);
        menuMessage.setIconSelected(new javax.swing.ImageIcon(getClass().getResource("/images/icons8-chat-30.png"))); // NOI18N
        menuMessage.setIconSimple(new javax.swing.ImageIcon(getClass().getResource("/images/icons8-chat-30 (1).png"))); // NOI18N
        menuMessage.setSelected(true);
        menuMessage.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuMessageActionPerformed(evt);
            }
        });
        menu.add(menuMessage);

        sp.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        sp.setViewportBorder(null);

        javax.swing.GroupLayout menuListLayout = new javax.swing.GroupLayout(menuList);
        menuList.setLayout(menuListLayout);
        menuListLayout.setHorizontalGroup(
            menuListLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        menuListLayout.setVerticalGroup(
            menuListLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 609, Short.MAX_VALUE)
        );

        sp.setViewportView(menuList);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(menu, javax.swing.GroupLayout.DEFAULT_SIZE, 250, Short.MAX_VALUE)
            .addComponent(sp)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(menu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(sp))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void menuMessageActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuMessageActionPerformed
        if (!menuMessage.isSelected()) {
        menuMessage.setSelected(true);
//        menuGroup.setSelected(false);
//        menuBox.setSelected(false);
        showMessage();
        }
    }//GEN-LAST:event_menuMessageActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLayeredPane menu;
    private javax.swing.JLayeredPane menuList;
    private com.chatsocket.component.MenuButton menuMessage;
    private javax.swing.JScrollPane sp;
    // End of variables declaration//GEN-END:variables

}
