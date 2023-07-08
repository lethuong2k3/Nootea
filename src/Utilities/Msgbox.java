package Utilities;

import java.awt.Component;
import javax.swing.JOptionPane;

public class Msgbox {
    public static void alert(Component p,String m){
        JOptionPane.showMessageDialog(p, m, "Hệ thống thông báo", JOptionPane.INFORMATION_MESSAGE);
    }
    public static boolean confirm(Component p, String m){
        int resul = JOptionPane.showConfirmDialog(p, m, "Hệ thống thông báo", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        return resul == JOptionPane.YES_OPTION;
    }
    
    public static String prompt(Component p, String m){
        return JOptionPane.showInputDialog(p, m, "Hệ thống thông báo", JOptionPane.INFORMATION_MESSAGE);
    }
}
