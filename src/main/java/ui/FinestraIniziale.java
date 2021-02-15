package ui;

import it.unimol.file.FileInputRecord;
import it.unimol.gestori.GestoreInterfaccia;

import it.unimol.record.ListaRecord;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * classe utilizzata per far visualizzare al giocatore
 * la finestra iniziale del gioco
 *
 * @author Francesco Chiacchiari
 */
public class FinestraIniziale {
    private JPanel panel1;
    private JButton bottoneClassifica;
    private JButton bottoneEsci;
    private JButton bottoneGioca;
    private FileInputRecord fileInputRecord = FileInputRecord.getInstance();
    private ListaRecord listaRecord = ListaRecord.getInstance();

    public FinestraIniziale(GestoreInterfaccia gestoreInterfaccia) {
        listaRecord.listaRecord = fileInputRecord.leggiFile(listaRecord.listaRecord);
        bottoneGioca.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                gestoreInterfaccia.status = 1;
                gestoreInterfaccia.sceltaInterfaccia();
            }
        });
        bottoneEsci.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        bottoneClassifica.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                gestoreInterfaccia.status = 4;
                gestoreInterfaccia.sceltaInterfaccia();

            }
        });
    }

    public JPanel getPanel1() {
        return panel1;
    }


    {
// GUI initializer generated by IntelliJ IDEA GUI Designer
// >>> IMPORTANT!! <<<
// DO NOT EDIT OR ADD ANY CODE HERE!
        $$$setupUI$$$();
    }

    /**
     * Method generated by IntelliJ IDEA GUI Designer
     * >>> IMPORTANT!! <<<
     * DO NOT edit this method OR call it in your code!
     *
     * @noinspection ALL
     */
    private void $$$setupUI$$$() {
        panel1 = new JPanel();
        panel1.setLayout(new com.intellij.uiDesigner.core.GridLayoutManager(2, 3, new Insets(0, 0, 0, 0), -1, -1));
        panel1.setBackground(new Color(-14013137));
        panel1.setEnabled(true);
        final JLabel label1 = new JLabel();
        label1.setEnabled(true);
        Font label1Font = this.$$$getFont$$$("OCR A Extended", Font.BOLD, 28, label1.getFont());
        if (label1Font != null) label1.setFont(label1Font);
        label1.setForeground(new Color(-12544960));
        label1.setText("INVASIONE ALIENA");
        panel1.add(label1, new com.intellij.uiDesigner.core.GridConstraints(0, 0, 1, 3, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        bottoneEsci = new JButton();
        bottoneEsci.setBackground(new Color(-14013137));
        Font bottoneEsciFont = this.$$$getFont$$$("OCR A Extended", -1, -1, bottoneEsci.getFont());
        if (bottoneEsciFont != null) bottoneEsci.setFont(bottoneEsciFont);
        bottoneEsci.setForeground(new Color(-12544960));
        bottoneEsci.setText("ESCI");
        panel1.add(bottoneEsci, new com.intellij.uiDesigner.core.GridConstraints(1, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        bottoneClassifica = new JButton();
        bottoneClassifica.setBackground(new Color(-14013137));
        Font bottoneClassificaFont = this.$$$getFont$$$("OCR A Extended", -1, -1, bottoneClassifica.getFont());
        if (bottoneClassificaFont != null) bottoneClassifica.setFont(bottoneClassificaFont);
        bottoneClassifica.setForeground(new Color(-12544960));
        bottoneClassifica.setText("RECORD");
        panel1.add(bottoneClassifica, new com.intellij.uiDesigner.core.GridConstraints(1, 2, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        bottoneGioca = new JButton();
        bottoneGioca.setBackground(new Color(-14013137));
        Font bottoneGiocaFont = this.$$$getFont$$$("OCR A Extended", Font.BOLD, -1, bottoneGioca.getFont());
        if (bottoneGiocaFont != null) bottoneGioca.setFont(bottoneGiocaFont);
        bottoneGioca.setForeground(new Color(-12544960));
        bottoneGioca.setText("GIOCA");
        panel1.add(bottoneGioca, new com.intellij.uiDesigner.core.GridConstraints(1, 1, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
    }

    /**
     * @noinspection ALL
     */
    private Font $$$getFont$$$(String fontName, int style, int size, Font currentFont) {
        if (currentFont == null) return null;
        String resultName;
        if (fontName == null) {
            resultName = currentFont.getName();
        } else {
            Font testFont = new Font(fontName, Font.PLAIN, 10);
            if (testFont.canDisplay('a') && testFont.canDisplay('1')) {
                resultName = fontName;
            } else {
                resultName = currentFont.getName();
            }
        }
        return new Font(resultName, style >= 0 ? style : currentFont.getStyle(), size >= 0 ? size : currentFont.getSize());
    }

    /**
     * @noinspection ALL
     */
    public JComponent $$$getRootComponent$$$() {
        return panel1;
    }

}
