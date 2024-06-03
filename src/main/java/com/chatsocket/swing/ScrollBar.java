package com.chatsocket.swing;
import java.awt.Dimension;
import javax.swing.JScrollBar;
public class ScrollBar extends JScrollBar {

    public ScrollBar() {
        setUI(new ModernScrollBarUI());
        setPreferredSize(new Dimension(5, 5));
        setUnitIncrement(20);
    } 
}
