package View.Swing;

import ViewModels.SanPhamResponse;
import java.awt.Component;

public interface EventItem {
    public void itemClick(Component com, SanPhamResponse item);
}
