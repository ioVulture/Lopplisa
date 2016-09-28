package frontend;

import classes.ProcessSaleController;
import classes.PurchaseController;
import classes.Sale;
import classes.SellersController;
import java.awt.Color;
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
    Sale sale;

    public SaleJFrame() throws IOException {
        this.sale = new Sale();
        initComponents();
        purchaseTable.removeColumn(purchaseTable.getColumnModel().getColumn(0));
        getFilesNames();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane3 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jMenu1 = new javax.swing.JMenu();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        errorLabel = new javax.swing.JLabel();
        removeSoldItem = new javax.swing.JButton();
        jScrollPane4 = new javax.swing.JScrollPane();
        salesTable = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        itemIdInput = new javax.swing.JTextField();
        quantityInput = new javax.swing.JTextField();
        addItemButton = new javax.swing.JButton();
        newSaleButton = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();
        salesTotal = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        deleteFile = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        purchaseTable = new javax.swing.JTable();
        menuBar = new javax.swing.JMenuBar();
        menu = new javax.swing.JMenu();
        advancedMenu = new javax.swing.JMenu();
        sendToServerMenuItem = new javax.swing.JMenuItem();
        getSellersMenuItem = new javax.swing.JMenuItem();
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

        jMenu1.setText("jMenu1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Loppis");
        setAutoRequestFocus(false);
        setBackground(new java.awt.Color(255, 255, 255));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTabbedPane1.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N

        jPanel1.setBackground(javax.swing.UIManager.getDefaults().getColor("TabbedPane.highlight"));
        jPanel1.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N

        errorLabel.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        errorLabel.setForeground(new java.awt.Color(255, 51, 0));
        errorLabel.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        errorLabel.setVerticalAlignment(javax.swing.SwingConstants.TOP);

        removeSoldItem.setBackground(javax.swing.UIManager.getDefaults().getColor("Button.highlight"));
        removeSoldItem.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        removeSoldItem.setText("Ta bort markerad");
        removeSoldItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                removeSoldItemActionPerformed(evt);
            }
        });

        salesTable.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        salesTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Kod", "Pris"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.Integer.class
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
        salesTable.setCellSelectionEnabled(true);
        salesTable.setGridColor(new java.awt.Color(204, 204, 204));
        salesTable.getTableHeader().setResizingAllowed(false);
        salesTable.getTableHeader().setReorderingAllowed(false);
        jScrollPane4.setViewportView(salesTable);
        salesTable.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_INTERVAL_SELECTION);
        if (salesTable.getColumnModel().getColumnCount() > 0) {
            salesTable.getColumnModel().getColumn(1).setResizable(false);
        }

        jLabel1.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel1.setText("KOD");

        jLabel2.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel2.setText("PRIS");

        itemIdInput.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        itemIdInput.setToolTipText("C01-25, F26-50, H51-75, J76-100, M101-125 samt X-koder");
        itemIdInput.setMaximumSize(new java.awt.Dimension(6, 20));
        itemIdInput.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                itemIdInputKeyPressed(evt);
            }
        });

        quantityInput.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        quantityInput.setToolTipText("Endast pris under 1000 kronor. Högre pris måste delas upp i flera inmatningar!");
        quantityInput.setMaximumSize(new java.awt.Dimension(6, 20));
        quantityInput.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                quantityInputKeyPressed(evt);
            }
        });

        addItemButton.setBackground(java.awt.Color.white);
        addItemButton.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        addItemButton.setForeground(new java.awt.Color(51, 51, 51));
        addItemButton.setText("+");
        addItemButton.setToolTipText("Kortkommando: Enter");
        addItemButton.setAlignmentY(0.0F);
        addItemButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addItemButtonActionPerformed(evt);
            }
        });

        newSaleButton.setBackground(java.awt.Color.white);
        newSaleButton.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        newSaleButton.setText("Avsluta försäljning");
        newSaleButton.setToolTipText("Kortkommando: Space");
        newSaleButton.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        newSaleButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                newSaleButtonActionPerformed(evt);
            }
        });

        jLabel10.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel10.setText("Totalt: ");

        salesTotal.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        salesTotal.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        salesTotal.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        salesTotal.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(2, 2, 2)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(removeSoldItem, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(40, 40, 40)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(40, 40, 40)
                                        .addComponent(salesTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(errorLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(172, 172, 172))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(itemIdInput, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(quantityInput, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(addItemButton, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(77, 77, 77)
                        .addComponent(newSaleButton, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 98, Short.MAX_VALUE))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(itemIdInput, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(quantityInput, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(addItemButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(newSaleButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 52, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(errorLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(495, 495, 495))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 440, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(20, 20, 20)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(removeSoldItem)
                            .addComponent(salesTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel10))
                        .addGap(39, 39, 39))))
        );

        jTabbedPane1.addTab("Nuvarande försäljning", jPanel1);

        jPanel2.setBackground(javax.swing.UIManager.getDefaults().getColor("TabbedPane.highlight"));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        deleteFile.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        deleteFile.setText("Ta bort vald försäljning");
        deleteFile.setToolTipText("");
        deleteFile.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteFileActionPerformed(evt);
            }
        });
        jPanel2.add(deleteFile, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 420, 180, -1));

        purchaseTable.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        purchaseTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Kod", "Totalt"
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

        jPanel2.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 40, 240, 370));

        jTabbedPane1.addTab("Avslutade försäljningar", jPanel2);

        getContentPane().add(jTabbedPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 700, 670));

        menu.setText("File");
        menu.setFont(new java.awt.Font("Segoe UI Light", 0, 12)); // NOI18N

        advancedMenu.setText("Avancerat");

        sendToServerMenuItem.setText("Skicka totaler till server");
        sendToServerMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sendToServerMenuItemActionPerformed(evt);
            }
        });
        advancedMenu.add(sendToServerMenuItem);

        getSellersMenuItem.setText("Hämta säljare");
        getSellersMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                getSellersMenuItemActionPerformed(evt);
            }
        });
        advancedMenu.add(getSellersMenuItem);

        menu.add(advancedMenu);

        jMenuItem1.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F4, java.awt.event.InputEvent.ALT_MASK));
        jMenuItem1.setText("Avsluta");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        menu.add(jMenuItem1);

        menuBar.add(menu);

        setJMenuBar(menuBar);

        getAccessibleContext().setAccessibleParent(this);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void addItemButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addItemButtonActionPerformed
        addItem();
    }//GEN-LAST:event_addItemButtonActionPerformed
    public void setErrorLabelText(String msg) {
        errorLabel.setText(msg);
    }
    private void addItem() {
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

                    updateGrandTotal();
                    Object[] row = {code, price};
                    DefaultTableModel model = (DefaultTableModel) salesTable.getModel();
                    model.addRow(row);
                    errorLabel.setText("");
                    quantityInput.setText("");
                    itemIdInput.setText("");
                } else {
                    errorLabel.setText("Säljarkoden finns inte.");
                }
                if (!itemIdInput.hasFocus()) {
                    itemIdInput.requestFocus();
                }
            } catch (IOException ex) {
                Logger.getLogger(SaleJFrame.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public void updateGrandTotal() {
        int grandTotal = processSaleController.getSale().getTotal();
        salesTotal.setText(String.valueOf(grandTotal));

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
        int res = JOptionPane.showConfirmDialog(null, "Att betala: " + total + " kr", "", JOptionPane.YES_NO_OPTION);

        if (res == JOptionPane.YES_OPTION) {
            try {
                processSaleController.makeNewSale(total, time);
            } catch (IOException ex) {
                Logger.getLogger(SaleJFrame.class.getName()).log(Level.SEVERE, null, ex);
            }

            salesTotal.setText("");
            quantityInput.setText("");
            itemIdInput.setText("");
            DefaultTableModel puchaseTableModel = (DefaultTableModel) purchaseTable.getModel();
            Object[] row = {time, total};
            puchaseTableModel.addRow(row);

            DefaultTableModel model = (DefaultTableModel) salesTable.getModel();
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
            if (evt.getKeyCode() == KeyEvent.VK_SPACE ) {
                proceedWithSale();

            } else if ((evt.getKeyCode() == KeyEvent.VK_ENTER || evt.getKeyCode() == KeyEvent.VK_TAB) && sale.codeMatchSellers(itemIdInput.getText().toUpperCase())) {
                errorLabel.setText("");
                if (!quantityInput.hasFocus()) {
                    quantityInput.requestFocus();
                }
            } else if ((evt.getKeyCode() == KeyEvent.VK_ENTER || evt.getKeyCode() == KeyEvent.VK_TAB) && !sale.codeMatchSellers(itemIdInput.getText().toUpperCase())) {
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

        if (evt.getKeyCode() == KeyEvent.VK_TAB) {
            addItemButton.requestFocus();
        } else if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            addItem();
        }
    }//GEN-LAST:event_quantityInputKeyPressed

    private void purchaseTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_purchaseTableMouseClicked
        DefaultTableModel purchaseTableModel = (DefaultTableModel) purchaseTable.getModel();
        if (evt.getClickCount() == 2) {
            int res = JOptionPane.showConfirmDialog(null, "Din pågånde försäljning kommer rensas för att du ska kunna redigera", "", JOptionPane.YES_NO_OPTION);

            if (res == JOptionPane.YES_OPTION) {

                Integer total = (Integer) purchaseTable.getValueAt(purchaseTable.getSelectedRow(), 0);
                Long key = (Long) purchaseTable.getModel().getValueAt(purchaseTable.getSelectedRow(), 0);
                
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
                            DefaultTableModel model = (DefaultTableModel) salesTable.getModel();
                            while (model.getRowCount() > 0) {
                                model.removeRow(0);
                            }
                            sale.resetSale();
                            for (final JsonNode objNode : arrNode) {
                                String code = objNode.get("code").getTextValue();
                                Integer price = objNode.get("price").getIntValue();
                                Object[] row = {code, price};
                                try {

                                    processSaleController.addItem(price, code);
                                    sale.addSoldItem(price, code);
                                } catch (FileNotFoundException ex) {
                                    Logger.getLogger(SaleJFrame.class.getName()).log(Level.SEVERE, null, ex);
                                } catch (IOException ex) {
                                    Logger.getLogger(SaleJFrame.class.getName()).log(Level.SEVERE, null, ex);
                                }
                                model.addRow(row);
                            }
                            int rowToRemoveFromModel = getRowByValue(purchaseTableModel, key);
                            salesTotal.setText(total.toString());
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

    private void getSellersMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_getSellersMenuItemActionPerformed
        try {
            sellers.populateSellers();
            JOptionPane.showMessageDialog(null, "Säljarlistan är uppdaterad och alla försäljningar nollställda");

        } catch (IOException ex) {

            JOptionPane.showMessageDialog(null, "Kunde inte hämta säljarlistan");
            Logger.getLogger(SaleJFrame.class.getName()).log(Level.SEVERE, null, ex);
        }


    }//GEN-LAST:event_getSellersMenuItemActionPerformed

    private void sendToServerMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sendToServerMenuItemActionPerformed
        try {
            purchaseController.sendPurchasesToServer();
            JOptionPane.showMessageDialog(null, "Totalerna är skickade till servern.");
        } catch (IOException ex) {

            JOptionPane.showMessageDialog(null, "Kunde inte skicka till server");
            Logger.getLogger(SaleJFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_sendToServerMenuItemActionPerformed

    private void removeSoldItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_removeSoldItemActionPerformed
        DefaultTableModel model = (DefaultTableModel) salesTable.getModel();
        int selectedRowInt = salesTable.getSelectedRow();
        int res = JOptionPane.showConfirmDialog(null, "Är du säker på att du vill ta bort vald rad?", "", JOptionPane.YES_NO_OPTION);
        
       // String code = (String) salesTable.getValueAt(salesTable.getSelectedRow(), 0);
        //int price = (int) salesTable.getValueAt(salesTable.getSelectedRow(), 1);
        
        if (res == JOptionPane.YES_OPTION) {
            
            model.removeRow(selectedRowInt);
            System.out.println("after remove row:" + salesTable.getRowCount());
            
           model.getRowCount();
         String code = "";
         sale.resetSale();
         System.out.println("length:" + sale.getListLength());
         int price = 0;
           for (int row = 0; row < salesTable.getRowCount(); row++){
               code = (String) salesTable.getValueAt(row, 0);
               price = (int) salesTable.getValueAt(row, 1);
                try {
                    System.out.println("add:" + code + ", price:" + price);
                    processSaleController.addItem(price, code);
                } catch (IOException ex) {
                    Logger.getLogger(SaleJFrame.class.getName()).log(Level.SEVERE, null, ex);
                }
           }
           updateGrandTotal();
        }
    }//GEN-LAST:event_removeSoldItemActionPerformed

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
                try {
                    new SaleJFrame().setVisible(true);
                } catch (IOException ex) {
                    Logger.getLogger(SaleJFrame.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addItemButton;
    private javax.swing.JMenu advancedMenu;
    private javax.swing.JButton deleteFile;
    private javax.swing.JLabel errorLabel;
    private javax.swing.JMenuItem getSellersMenuItem;
    private javax.swing.JTextField itemIdInput;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JMenu menu;
    private javax.swing.JMenuBar menuBar;
    private javax.swing.JButton newSaleButton;
    private javax.swing.JTable purchaseTable;
    private javax.swing.JTextField quantityInput;
    private javax.swing.JButton removeSoldItem;
    private javax.swing.JTable salesTable;
    private javax.swing.JLabel salesTotal;
    private javax.swing.JMenuItem sendToServerMenuItem;
    // End of variables declaration//GEN-END:variables

}
