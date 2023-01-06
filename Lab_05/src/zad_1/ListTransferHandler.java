package zad_1;

import javax.swing.*;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.StringSelection;
import java.awt.datatransfer.Transferable;
import java.util.ArrayList;

import static zad_1.arrays.*;


public class ListTransferHandler extends TransferHandler {
    static ArrayList<String> temp = null;

    //Wybór możliwych akcji
    @Override
    public int getSourceActions(JComponent c) {
        return TransferHandler.MOVE;
    }
    //wyciąga nazwe elementu ciągniętego
    @Override
    protected Transferable createTransferable(JComponent c) {
        @SuppressWarnings("unchecked")
        JList<String> list = (JList<String>) c;
        temp = arrList.get(Integer.parseInt(list.getName())).get(list.getSelectedIndex());
        String data = list.getSelectedValue();
        return new StringSelection(data);
    }
    //usuwa przedmiot po przesuwaniu
    @Override
    protected void exportDone(JComponent c, Transferable data, int action) {
        @SuppressWarnings("unchecked")
        JList<String> list = (JList<String>) c;
        DefaultListModel dfm = (DefaultListModel) list.getModel ();
        arrList.get(Integer.parseInt(list.getName())).remove(list.getSelectedIndex());
        dfm.remove(list.getSelectedIndex());
    }
    //sprawdza możliwość importu
    @Override
    public boolean canImport(TransferHandler.TransferSupport support) {
        if (!support.isDrop()) {
            return false;
        }
        return support.isDataFlavorSupported(DataFlavor.stringFlavor);
    }
    //sprawdza możliwość importu i wciska element w konkretne wybrane miejsce
    @Override
    public boolean importData(TransferHandler.TransferSupport support) {
        if (!this.canImport(support)) {
            return false;
        }
        Transferable t = support.getTransferable();
        String data;
        try {
            data = (String) t.getTransferData(DataFlavor.stringFlavor);
            if (data == null) return false;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        JList.DropLocation dropLocation = (JList.DropLocation) support.getDropLocation();
        int dropIndex = dropLocation.getIndex();
        @SuppressWarnings("unchecked")
        JList<String> targetList = (JList<String>) support.getComponent();

        DefaultListModel<String> listModel = (DefaultListModel<String>) targetList.getModel();
        if (dropLocation.isInsert()) {
            listModel.add(dropIndex, data);
            arrList.get(Integer.parseInt(targetList.getName())).add(dropIndex,temp);
        } else {
            listModel.set(dropIndex, data);
            arrList.get(Integer.parseInt(targetList.getName())).set(dropIndex,temp);
        }
        return true;
    }
}
