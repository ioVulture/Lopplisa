package frontend;

import classes.ProcessSaleController;
import classes.PurchaseController;
import classes.Sale;
import classes.SellersController;
import java.awt.event.KeyEvent;
import java.io.BufferedWriter;
import java.io.File;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.TreeMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import org.codehaus.jackson.JsonNode;
import org.codehaus.jackson.map.ObjectMapper;

public class SaleJFrame extends javax.swing.JFrame {

    static ProcessSaleController processSaleController;
    static SellersController sellers = new SellersController();
    PurchaseController purchaseController = new PurchaseController();

    public SaleJFrame() {
        initComponents();
        purchaseTable.removeColumn(purchaseTable.getColumnModel().getColumn(0));
        getFilesNames();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane3 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        newSaleButton = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        itemIdInput = new javax.swing.JTextField();
        quantityInput = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        purchaseTable = new javax.swing.JTable();
        addItemButton = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        grandTotalOutput = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        populateSellersButton = new javax.swing.JButton();
        errorLabel = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        saleTable1 = new javax.swing.JTable();
        sendToServer = new javax.swing.JButton();
        deleteFile = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane3.setViewportView(jTable1);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Loppis");
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        newSaleButton.setText("Avsluta försäljning");
        newSaleButton.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        newSaleButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                newSaleButtonActionPerformed(evt);
            }
        });
        getContentPane().add(newSaleButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(189, 573, -1, -1));

        jLabel1.setText("Kod");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(37, 51, -1, -1));

        jLabel2.setText("Pris");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(38, 80, -1, -1));

        itemIdInput.setToolTipText("Enter Item Id");
        itemIdInput.setMaximumSize(new java.awt.Dimension(6, 20));
        itemIdInput.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                itemIdInputKeyPressed(evt);
            }
        });
        getContentPane().add(itemIdInput, new org.netbeans.lib.awtextra.AbsoluteConstraints(65, 51, 99, -1));

        quantityInput.setToolTipText("Enter quantity of the item");
        quantityInput.setMaximumSize(new java.awt.Dimension(6, 20));
        quantityInput.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                quantityInputKeyPressed(evt);
            }
        });
        getContentPane().add(quantityInput, new org.netbeans.lib.awtextra.AbsoluteConstraints(65, 77, 99, -1));

        purchaseTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Totalt"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        purchaseTable.setCellSelectionEnabled(true);
        purchaseTable.getTableHeader().setResizingAllowed(false);
        purchaseTable.getTableHeader().setReorderingAllowed(false);
        purchaseTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                purchaseTableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(purchaseTable);
        purchaseTable.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_INTERVAL_SELECTION);
        if (purchaseTable.getColumnModel().getColumnCount() > 0) {
            purchaseTable.getColumnModel().getColumn(1).setResizable(false);
        }

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 180, 129, 317));

        addItemButton.setText("Lägg till");
        addItemButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addItemButtonActionPerformed(evt);
            }
        });
        getContentPane().add(addItemButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(65, 103, 99, -1));

        jLabel5.setText("Slutsumma");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(37, 538, -1, -1));
        getContentPane().add(grandTotalOutput, new org.netbeans.lib.awtextra.AbsoluteConstraints(211, 535, 99, -1));

        jLabel6.setText("Avslutade försäjningar");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 150, -1, -1));

        populateSellersButton.setText("Hämta säljare");
        populateSellersButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                populateSellersActionPerformed(evt);
            }
        });
        getContentPane().add(populateSellersButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 50, 109, -1));

        errorLabel.setForeground(new java.awt.Color(255, 0, 0));
        getContentPane().add(errorLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(26, 31, 137, 14));

        saleTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Kod", "Pris"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.Integer.class
            };
            boolean[] canEdit = new boolean [] {
                false, true, true
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        saleTable1.setCellSelectionEnabled(true);
        saleTable1.getTableHeader().setResizingAllowed(false);
        saleTable1.getTableHeader().setReorderingAllowed(false);
        jScrollPane4.setViewportView(saleTable1);
        saleTable1.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_INTERVAL_SELECTION);
        if (saleTable1.getColumnModel().getColumnCount() > 0) {
            saleTable1.getColumnModel().getColumn(1).setResizable(false);
        }

        getContentPane().add(jScrollPane4, new org.netbeans.lib.awtextra.AbsoluteConstraints(37, 167, 273, 320));

        sendToServer.setText("Skicka till server");
        sendToServer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sendToServerActionPerformed(evt);
            }
        });
        getContentPane().add(sendToServer, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 20, -1, -1));

        deleteFile.setText("Ta bort försäljning");
        deleteFile.setToolTipText("");
        deleteFile.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteFileActionPerformed(evt);
            }
        });
        getContentPane().add(deleteFile, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 530, 129, -1));

        jMenu1.setText("File");

        jMenuItem1.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F4, java.awt.event.InputEvent.ALT_MASK));
        jMenuItem1.setText("Exit");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem1);

        jMenuBar1.add(jMenu1);

        setJMenuBar(jMenuBar1);

        getAccessibleContext().setAccessibleParent(this);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void addItemButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addItemButtonActionPerformed
        String itemIdInputText = itemIdInput.getText();
        String quantityInputText = quantityInput.getText();

        if (!itemIdInputText.isEmpty() && !quantityInputText.isEmpty()) {

            String code = itemIdInputText.toUpperCase();
            int price = Integer.parseInt(quantityInputText);

            try {
                if (processSaleController.codeExist(code)) {

                    try {

                        processSaleController.addItem(price, code);
                    } catch (FileNotFoundException ex) {
                        Logger.getLogger(SaleJFrame.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (IOException ex) {
                        Logger.getLogger(SaleJFrame.class.getName()).log(Level.SEVERE, null, ex);
                    }

                    int grandTotal = processSaleController.getSale().getTotal();
                    grandTotalOutput.setText(String.valueOf(grandTotal));

                    Object[] row = {processSaleController.getSale().getListLength(), code, price};
                    DefaultTableModel model = (DefaultTableModel) saleTable1.getModel();
                    model.addRow(row);
                    errorLabel.setText("");
                    quantityInput.setText("");
                    itemIdInput.setText("");
                } else {
                    errorLabel.setText("Koden finns inte");
                }
                if (!itemIdInput.hasFocus()) {
                    itemIdInput.requestFocus();
                }
            } catch (IOException ex) {
                Logger.getLogger(SaleJFrame.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_addItemButtonActionPerformed
    public void setErrorLabelText(String msg) {
        errorLabel.setText(msg);
    }

    public void getFilesNames() {
        PurchaseController purchaseController = new PurchaseController();
        TreeMap<Long, Integer> allPurchasesMap = purchaseController.getAllPurchasesMap();
        DefaultTableModel puchaseTableModel = (DefaultTableModel) purchaseTable.getModel();
        for (Entry entry : allPurchasesMap.entrySet()) {
            Object[] row = {entry.getKey(), entry.getValue()};

            puchaseTableModel.addRow(row);

        }
    }

    private boolean proceedWithSale() {
        int total = processSaleController.getSale().getTotal();
        Date date = new Date();
        long time = date.getTime();
        int res = JOptionPane.showConfirmDialog(null, "Att betala:" + total + "kr", "", JOptionPane.YES_NO_OPTION);

        if (res == JOptionPane.YES_OPTION) {
            try {
                processSaleController.makeNewSale(total, time);
            } catch (IOException ex) {
                Logger.getLogger(SaleJFrame.class.getName()).log(Level.SEVERE, null, ex);
            }

            grandTotalOutput.setText("");
            quantityInput.setText("");
            itemIdInput.setText("");
            DefaultTableModel puchaseTableModel = (DefaultTableModel) purchaseTable.getModel();
            Object[] row = {time, total};
            puchaseTableModel.addRow(row);

            DefaultTableModel model = (DefaultTableModel) saleTable1.getModel();
            while (model.getRowCount() > 0) {
                model.removeRow(0);
            }
            itemIdInput.requestFocus();
        }
        return false;
    }
    private void newSaleButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_newSaleButtonActionPerformed
        proceedWithSale();
    }//GEN-LAST:event_newSaleButtonActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed

        System.exit(0);
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void populateSellersActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_populateSellersActionPerformed
        try {
            sellers.populateSellers();
        } catch (IOException ex) {
            Logger.getLogger(SaleJFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_populateSellersActionPerformed
    private int getRowByValue(DefaultTableModel model, Object value) {
        for (int i = model.getRowCount() - 1; i >= 0; --i) {

            if (model.getValueAt(i, 0).equals(value)) {
                // what if value is not unique?
                return i;
            }

        }
        return -1;
    }
    private void deleteFileActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteFileActionPerformed
        PurchaseController purchaseController = new PurchaseController();

        int purchaseRowInt = purchaseTable.getSelectedRow();
        DefaultTableModel purchaseTableModel = (DefaultTableModel) purchaseTable.getModel();
        //int rowInt = getRowByValue(purchaseTableModel, id);
        Long key = (Long) purchaseTableModel.getValueAt(purchaseRowInt, 0);
        Integer total = (Integer) purchaseTableModel.getValueAt(purchaseRowInt, 1);
        int res = JOptionPane.showConfirmDialog(null, "Är du säker på att du nollställa försäljningen?", "", JOptionPane.YES_NO_OPTION);

        if (res == JOptionPane.YES_OPTION) {
            try {
                boolean deletePurchase = purchaseController.deletePurchase(key, total);
                if (deletePurchase) {

                    purchaseTableModel.removeRow(purchaseRowInt);

                }
            } catch (IOException ex) {
                Logger.getLogger(SaleJFrame.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_deleteFileActionPerformed

    private void itemIdInputKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_itemIdInputKeyPressed
        try {
            Sale sale = new Sale();
            if (evt.getKeyCode() == KeyEvent.VK_SPACE) {
                proceedWithSale();

            } else if (evt.getKeyCode() == KeyEvent.VK_ENTER && sale.codeMatchSellers(itemIdInput.getText().toUpperCase())) {
                errorLabel.setText("");
                if (!quantityInput.hasFocus()) {
                    quantityInput.requestFocus();
                }
            } else if (evt.getKeyCode() == KeyEvent.VK_ENTER && !sale.codeMatchSellers(itemIdInput.getText().toUpperCase())) {
                errorLabel.setText("Säljarkoden finns inte");
            }
            /*else if (itemIdInput.getText().length() > 2 || evt.getKeyCode() == 10) {
                System.out.println("textLength:" + itemIdInput.getText().length());
                System.out.println("keyCode:" + evt.getKeyCode());
                System.out.println("codeMatch:" + sale.codeMatchSellers(itemIdInput.getText()));
               // errorLabel.setText("Säljarkoden finns inte");
            } */
        } catch (IOException ex) {
            Logger.getLogger(SaleJFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_itemIdInputKeyPressed

    private void quantityInputKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_quantityInputKeyPressed

        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            addItemButton.requestFocus();
        }
    }//GEN-LAST:event_quantityInputKeyPressed

    private void sendToServerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sendToServerActionPerformed
        try {
            purchaseController.sendPurchasesToServer();
        } catch (IOException ex) {
            Logger.getLogger(SaleJFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_sendToServerActionPerformed

    private void purchaseTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_purchaseTableMouseClicked
        DefaultTableModel purchaseTableModel = (DefaultTableModel) purchaseTable.getModel();
        if (evt.getClickCount() == 2) {
            int res = JOptionPane.showConfirmDialog(null, "Din pågånde försäljning kommer rensas för att du ska kunna redigera", "", JOptionPane.YES_NO_OPTION);

            if (res == JOptionPane.YES_OPTION) {

                Integer total = (Integer) purchaseTable.getValueAt(purchaseTable.getSelectedRow(), 0);
                Long key = (Long) purchaseTable.getModel().getValueAt(purchaseTable.getSelectedRow(), 0);
                System.out.println("key was:" + key + "  Value:" + total);
                String filePath = "purchases/" + total + "-" + key + "-purchases.txt";

                Scanner scanner;
                try {
                    scanner = new Scanner(new File(filePath));
                    System.out.println("scanner was:" + scanner.hasNext());
                    if (scanner != null && scanner.hasNext()) {
                        String text = scanner.next();

                        ObjectMapper mapper = new ObjectMapper();
                        JsonNode node = mapper.readValue(text, JsonNode.class);
                        JsonNode brandNode = node.get("purchase");

                        final JsonNode arrNode = new ObjectMapper().readTree(text).get("purchase");
                        if (arrNode.isArray()) {
                            DefaultTableModel model = (DefaultTableModel) saleTable1.getModel();
                            while (model.getRowCount() > 0) {
                                model.removeRow(0);
                            }
                            
                            for (final JsonNode objNode : arrNode) {
                                String code = objNode.get("code").getTextValue();
                                Integer price = objNode.get("price").getIntValue();
                                Object[] row = {code, price};
                                model.addRow(row);
                            }
                            int rowToRemoveFromModel = getRowByValue(purchaseTableModel, key);
                            grandTotalOutput.setText(total.toString());
                            purchaseTableModel.removeRow(rowToRemoveFromModel);
                            purchaseController.deletePurchase(key, total);
                            itemIdInput.requestFocus();
                        }
                    }
                } catch (FileNotFoundException ex) {
                    Logger.getLogger(SaleJFrame.class.getName()).log(Level.SEVERE, null, ex);
                } catch (IOException ex) {
                    Logger.getLogger(SaleJFrame.class.getName()).log(Level.SEVERE, null, ex);
                }
            }  
        }
    }//GEN-LAST:event_purchaseTableMouseClicked

    /**
         * @param args the command line arguments
         */
    public static void main(String[] args) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(SaleJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(SaleJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(SaleJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(SaleJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    processSaleController = new ProcessSaleController();
                } catch (IOException ex) {
                    Logger.getLogger(SaleJFrame.class.getName()).log(Level.SEVERE, null, ex);
                }
                new SaleJFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addItemButton;
    private javax.swing.JButton deleteFile;
    public javax.swing.JLabel errorLabel;
    private javax.swing.JTextField grandTotalOutput;
    private javax.swing.JTextField itemIdInput;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTable jTable1;
    private javax.swing.JButton newSaleButton;
    private javax.swing.JButton populateSellersButton;
    private javax.swing.JTable purchaseTable;
    private javax.swing.JTextField quantityInput;
    private javax.swing.JTable saleTable1;
    private javax.swing.JButton sendToServer;
    // End of variables declaration//GEN-END:variables

}
