package View;

import View.Swing.EventItem;
import View.Swing.ScrollBar;
import ViewModels.SanPhamResponse;
import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.SwingUtilities;

public class FormSPCT extends javax.swing.JPanel {

    private EventItem event;
    
    private String maSP = null;
    
    public void setEvent(EventItem event) {
        this.event = event;
    }
    
    public FormSPCT() {
        initComponents();
        scroll.setVerticalScrollBar(new ScrollBar());
    }
    // update
    public void removeItem() {
        panelItem.removeAll();
    }
    //
    public void addItem(SanPhamResponse dataSP) {
        Item item = new Item();
        item.setData(dataSP);
        item.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                if (SwingUtilities.isLeftMouseButton(e)) {
                    event.itemClick(item, dataSP);
                }
            }
        }); 
        panelItem.add(item);
        panelItem.repaint();
        panelItem.revalidate();
    }
    
    public void setselected(Component item) {
        for (Component com : panelItem.getComponents()) {
            Item i = (Item) com;
            if (i.isSelected()) {
                i.setSelected(false);
            }
        }
        ((Item) item).setSelected(true);
    }
   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        item1 = new View.Item();
        item2 = new View.Item();
        scroll = new javax.swing.JScrollPane();
        panelItem = new View.Swing.PanelItem();

        setOpaque(false);

        scroll.setBorder(null);
        scroll.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        scroll.setViewportView(panelItem);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(scroll, javax.swing.GroupLayout.DEFAULT_SIZE, 725, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(scroll, javax.swing.GroupLayout.PREFERRED_SIZE, 489, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private View.Item item1;
    private View.Item item2;
    private View.Swing.PanelItem panelItem;
    private javax.swing.JScrollPane scroll;
    // End of variables declaration//GEN-END:variables
}
