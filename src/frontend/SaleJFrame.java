package frontend;

import classes.ProcessSaleController;
import classes.PurchaseController;
import classes.Sale;
import classes.SellersController;
import java.awt.Color;
import java.awt.event.KeyEvent;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
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
import javax.swing.RowSorter;

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
      
        BufferedReader br = new BufferedReader(new FileReader("notes.txt"));
        try {
            StringBuilder sb = new StringBuilder();
            String line = br.readLine();

            while (line != null) {
                sb.append(line);
                sb.append(System.lineSeparator());
                line = br.readLine();
            }
            notesTextArea.setText(sb.toString());
        } finally {
            br.close();
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane3 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jMenu1 = new javax.swing.JMenu();
        tabPane = new javax.swing.JTabbedPane();
        currentSaleTab = new javax.swing.JPanel();
        errorLabel = new javax.swing.JLabel();
        removeSoldItem = new javax.swing.JButton();
        jScrollPane4 = new javax.swing.JScrollPane();
        salesTable = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        codeIdInput = new javax.swing.JTextField();
        priceInput = new javax.swing.JTextField();
        addItemButton = new javax.swing.JButton();
        newSaleButton = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();
        salesTotal = new javax.swing.JLabel();
        emptyCurrentSale = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        deleteFile = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        purchaseTable = new javax.swing.JTable();
        settings = new javax.swing.JTabbedPane();
        saveNotes = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        notesTextArea = new javax.swing.JTextArea();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        lastThreePurchases = new javax.swing.JLabel();
        swishPerson = new javax.swing.JTextField();
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
        setTitle("Lopplisa v1.0");
        setAutoRequestFocus(false);
        setBackground(new java.awt.Color(255, 255, 255));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tabPane.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N

        currentSaleTab.setBackground(javax.swing.UIManager.getDefaults().getColor("TabbedPane.highlight"));
        currentSaleTab.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N

        errorLabel.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        errorLabel.setForeground(new java.awt.Color(255, 51, 0));
        errorLabel.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        errorLabel.setVerticalAlignment(javax.swing.SwingConstants.TOP);

        removeSoldItem.setBackground(new java.awt.Color(204, 0, 0));
        removeSoldItem.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
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
        salesTable.setGridColor(new java.awt.Color(204, 204, 204));
        salesTable.setRowHeight(25);
        salesTable.getTableHeader().setResizingAllowed(false);
        salesTable.getTableHeader().setReorderingAllowed(false);
        jScrollPane4.setViewportView(salesTable);
        salesTable.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        if (salesTable.getColumnModel().getColumnCount() > 0) {
            salesTable.getColumnModel().getColumn(1).setResizable(false);
        }

        jLabel1.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel1.setText("KOD");

        jLabel2.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel2.setText("PRIS");

        codeIdInput.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        codeIdInput.setToolTipText("C01-25, F26-50, H51-75, J76-100, M101-125 samt X-koder");
        codeIdInput.setMaximumSize(new java.awt.Dimension(6, 20));
        codeIdInput.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                codeIdInputKeyPressed(evt);
            }
        });

        priceInput.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        priceInput.setToolTipText("Endast pris under 1000 kronor. Högre pris måste delas upp i flera inmatningar!");
        priceInput.setMaximumSize(new java.awt.Dimension(6, 20));
        priceInput.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                priceInputKeyPressed(evt);
            }
        });

        addItemButton.setBackground(new java.awt.Color(51, 204, 0));
        addItemButton.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        addItemButton.setForeground(new java.awt.Color(51, 51, 51));
        addItemButton.setText("Lägg till");
        addItemButton.setToolTipText("Kortkommando: Enter");
        addItemButton.setAlignmentY(0.0F);
        addItemButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addItemButtonActionPerformed(evt);
            }
        });

        newSaleButton.setBackground(new java.awt.Color(51, 204, 0));
        newSaleButton.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        newSaleButton.setText("Avsluta försäljning");
        newSaleButton.setToolTipText("Kortkommando: Space");
        newSaleButton.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        newSaleButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                newSaleButtonActionPerformed(evt);
            }
        });

        jLabel10.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel10.setText("Totalt: ");

        salesTotal.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        salesTotal.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        salesTotal.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        salesTotal.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);

        emptyCurrentSale.setBackground(new java.awt.Color(204, 51, 0));
        emptyCurrentSale.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        emptyCurrentSale.setText("Rensa försäljning");
        emptyCurrentSale.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                emptyCurrentSaleActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout currentSaleTabLayout = new javax.swing.GroupLayout(currentSaleTab);
        currentSaleTab.setLayout(currentSaleTabLayout);
        currentSaleTabLayout.setHorizontalGroup(
            currentSaleTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(currentSaleTabLayout.createSequentialGroup()
                .addGap(68, 68, 68)
                .addComponent(emptyCurrentSale)
                .addGap(18, 18, 18)
                .addGroup(currentSaleTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(currentSaleTabLayout.createSequentialGroup()
                        .addGroup(currentSaleTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(codeIdInput, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(currentSaleTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(priceInput, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(14, 14, 14)
                        .addComponent(addItemButton))
                    .addComponent(errorLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(currentSaleTabLayout.createSequentialGroup()
                        .addComponent(removeSoldItem)
                        .addGap(48, 48, 48)
                        .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(salesTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(newSaleButton, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 55, Short.MAX_VALUE))
        );
        currentSaleTabLayout.setVerticalGroup(
            currentSaleTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(currentSaleTabLayout.createSequentialGroup()
                .addGap(13, 13, 13)
                .addComponent(errorLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(currentSaleTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(7, 7, 7)
                .addGroup(currentSaleTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(currentSaleTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(priceInput, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(addItemButton))
                    .addComponent(codeIdInput, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(14, 14, 14)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 377, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 16, Short.MAX_VALUE)
                .addGroup(currentSaleTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, currentSaleTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(removeSoldItem)
                        .addComponent(emptyCurrentSale))
                    .addComponent(salesTotal, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(newSaleButton, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel10, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        currentSaleTabLayout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {addItemButton, codeIdInput, emptyCurrentSale, newSaleButton, priceInput, removeSoldItem});

        currentSaleTabLayout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jLabel10, salesTotal});

        tabPane.addTab("Nuvarande försäljning", currentSaleTab);

        jPanel2.setBackground(javax.swing.UIManager.getDefaults().getColor("TabbedPane.highlight"));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        deleteFile.setBackground(new java.awt.Color(204, 0, 0));
        deleteFile.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        deleteFile.setText("Ta bort markerad");
        deleteFile.setToolTipText("");
        deleteFile.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteFileActionPerformed(evt);
            }
        });
        jPanel2.add(deleteFile, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 490, -1, -1));

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
        purchaseTable.setRowHeight(25);
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

        jPanel2.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 60, 240, 420));

        tabPane.addTab("Avslutade försäljningar", jPanel2);
        tabPane.addTab("tab3", settings);

        getContentPane().add(tabPane, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 20, 710, 580));

        saveNotes.setBackground(new java.awt.Color(51, 204, 0));
        saveNotes.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        saveNotes.setText("Spara");
        saveNotes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveNotesActionPerformed(evt);
            }
        });
        getContentPane().add(saveNotes, new org.netbeans.lib.awtextra.AbsoluteConstraints(940, 360, 70, -1));

        jLabel3.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel3.setText("Kom ihåg!");
        jLabel3.setToolTipText("");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 40, -1, -1));

        notesTextArea.setBackground(new java.awt.Color(241, 241, 241));
        notesTextArea.setColumns(18);
        notesTextArea.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        notesTextArea.setForeground(new java.awt.Color(51, 51, 51));
        notesTextArea.setRows(15);
        notesTextArea.setMargin(new java.awt.Insets(10, 10, 10, 10));
        jScrollPane2.setViewportView(notesTextArea);

        getContentPane().add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 60, 230, 290));

        jLabel4.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel4.setText("Senast avslutade försäljningar");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 420, -1, -1));
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(1090, 300, -1, -1));
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 640, -1, -1));

        lastThreePurchases.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        getContentPane().add(lastThreePurchases, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 440, 180, 70));

        swishPerson.setText("Swish");
        getContentPane().add(swishPerson, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 10, 190, -1));

        menu.setText("File");
        menu.setFont(new java.awt.Font("Segoe UI Light", 0, 12)); // NOI18N

        advancedMenu.setText(" ");

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
    public void setErrorLabelText(String msg) {
        errorLabel.setText(msg);
    }

    private void addItem() {
        String itemIdInputText = codeIdInput.getText();
        String quantityInputText = priceInput.getText();

        if (!itemIdInputText.isEmpty() && !quantityInputText.isEmpty()) {

            String code = itemIdInputText.toUpperCase();
            int price = Integer.parseInt(quantityInputText);

            try {
                if (processSaleController.codeExist(code) && price != 0) {

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
                    salesTable.scrollRectToVisible(salesTable.getCellRect(model.getRowCount()-1,0, true));

                    errorLabel.setText("");
                    priceInput.setText("");
                    codeIdInput.setText("");
                } else {
                    errorLabel.setText("Säljarkoden finns inte.");
                }
                if (!codeIdInput.hasFocus()) {
                    codeIdInput.requestFocus();
                }
            } catch (IOException ex) {
                Logger.getLogger(SaleJFrame.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public void updateGrandTotal() {
        int grandTotal = processSaleController.getSale().getTotal();
        //System.out.println("grandtotal at the end:" + grandTotal);
        salesTotal.setText(String.valueOf(grandTotal));

    }

    public void getFilesNames() {
        PurchaseController purchaseController = new PurchaseController();
        TreeMap<Long, Integer> allPurchasesMap = purchaseController.getAllPurchasesMap();
        DefaultTableModel puchaseTableModel = (DefaultTableModel) purchaseTable.getModel();
        for (Entry entry : allPurchasesMap.entrySet()) {
            Object[] row = {entry.getKey(), entry.getValue()};

            puchaseTableModel.addRow(row);
            purchaseTable.scrollRectToVisible(purchaseTable.getCellRect(puchaseTableModel.getRowCount()-1,0, true));
        }
    }

    private boolean proceedWithSale() throws IOException {
        int total = processSaleController.getSale().getTotal();
        Date date = new Date();
        long time = date.getTime();
        //int res = JOptionPane.showConfirmDialog(null, "Att betala: " + total + " kr", "", JOptionPane.OK_CANCEL_OPTION);
        String[] buttons = { "Swish", "Kontant", "Avbryt" };
        int res = JOptionPane.showOptionDialog(null, "Att betala: " + total + " kr", "Att betala",
        JOptionPane.WARNING_MESSAGE, 0, null, buttons, buttons[2]);
     
        
        if (res == 0 || res == 1) {
            try {
                if(res == 0) {
                    processSaleController.makeNewSale(total, time, "swish");
                } else {
                    processSaleController.makeNewSale(total, time, "kontant");
                }
                
            } catch (IOException ex) {
                Logger.getLogger(SaleJFrame.class.getName()).log(Level.SEVERE, null, ex);
            } finally {
                purchaseController.addPurchaseToTotals();
            }

            salesTotal.setText("");
            priceInput.setText("");
            codeIdInput.setText("");
            DefaultTableModel puchaseTableModel = (DefaultTableModel) purchaseTable.getModel();
            Object[] row = {time, total};
            puchaseTableModel.addRow(row);
            
            int rowCount = puchaseTableModel.getRowCount();
            if (rowCount > 3) {
                rowCount = 3;
            }   
            int i=0;
            String latestThree = "";
            Integer listSize = puchaseTableModel.getRowCount();
            latestThree = "<html>";
            while (i < rowCount) {
                listSize = listSize - i;
                
                latestThree += "Försäljning " + listSize + ": " + puchaseTableModel.getValueAt(i, 1) + " kr";
                i++;
                if (i != 3) {
                  latestThree+= "<br> ";
                }
                  
            }
            latestThree += "</html>";
            lastThreePurchases.setText(latestThree);
            
            DefaultTableModel model = (DefaultTableModel) salesTable.getModel();
            while (model.getRowCount() > 0) {
                model.removeRow(0);
            }
            codeIdInput.requestFocus();
        }
        
        return false;
    }
    
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
                    //System.out.println("scanner was:" + scanner.hasNext());
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
                                if (price != 0) {
                                    model.addRow(row);
                                }
                            }
                            int rowToRemoveFromModel = getRowByValue(purchaseTableModel, key);
                            salesTotal.setText(total.toString());
                            purchaseTableModel.removeRow(rowToRemoveFromModel);
                          
                            scanner.close();
                            
                            purchaseController.deletePurchase(key, total);
                            tabPane.setSelectedIndex(0);
                            codeIdInput.requestFocus();
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
        resetSystem();

    }//GEN-LAST:event_getSellersMenuItemActionPerformed

    private void sendToServerMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sendToServerMenuItemActionPerformed
        try {
            purchaseController.sendPurchasesToServer();
            
            JOptionPane.showMessageDialog(null, "Totalerna är skickade till servern.");
        } catch (IOException ex) {

            JOptionPane.showMessageDialog(null, "Kunde inte skicka till server");
            Logger.getLogger(SaleJFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
        resetSystem();
    }//GEN-LAST:event_sendToServerMenuItemActionPerformed

    private void saveNotesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveNotesActionPerformed
        try(FileWriter fw = new FileWriter("notes.txt", false);
            BufferedWriter bw = new BufferedWriter(fw);
            PrintWriter out = new PrintWriter(bw))
        {
            out.print(notesTextArea.getText());
        } catch (IOException ex) {
            Logger.getLogger(SaleJFrame.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_saveNotesActionPerformed

    private void newSaleButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_newSaleButtonActionPerformed
        try {
            proceedWithSale();
        } catch (IOException ex) {
            Logger.getLogger(SaleJFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_newSaleButtonActionPerformed

    private void addItemButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addItemButtonActionPerformed
        addItem();
    }//GEN-LAST:event_addItemButtonActionPerformed

    private void priceInputKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_priceInputKeyPressed
        if (priceInput.getText().length() > 3) { // limit to 3 characters
            errorLabel.setText("Priset får max vara 999kr");

        } else if (priceInput.getText().contains("-")) {
            errorLabel.setText("Priset får inte innahålla negativa nummer");
        }
        else if (evt.getKeyCode() == KeyEvent.VK_TAB) {
            addItemButton.requestFocus();
        } else if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            addItem();
        }
    }//GEN-LAST:event_priceInputKeyPressed

    private void codeIdInputKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_codeIdInputKeyPressed
        try {

            Sale sale = new Sale();
            if (evt.getKeyCode() == KeyEvent.VK_SPACE) {
                proceedWithSale();
            } else if ((evt.getKeyCode() == KeyEvent.VK_ENTER || evt.getKeyCode() == KeyEvent.VK_TAB) && sale.codeMatchSellers(codeIdInput.getText().toUpperCase())) {
                errorLabel.setText("");
                if (!priceInput.hasFocus()) {
                    priceInput.requestFocus();
                }
            } else if ((evt.getKeyCode() == KeyEvent.VK_ENTER || evt.getKeyCode() == KeyEvent.VK_TAB) && !sale.codeMatchSellers(codeIdInput.getText().toUpperCase())) {
                errorLabel.setText("Säljarkoden finns inte");
            }
        } catch (IOException ex) {
            Logger.getLogger(SaleJFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_codeIdInputKeyPressed

    private void removeSoldItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_removeSoldItemActionPerformed
        DefaultTableModel model = (DefaultTableModel) salesTable.getModel();
        int selectedRowInt = salesTable.getSelectedRow();
        int res = JOptionPane.showConfirmDialog(null, "Är du säker på att du vill ta bort vald rad?", "", JOptionPane.YES_NO_OPTION);

        // String code = (String) salesTable.getValueAt(salesTable.getSelectedRow(), 0);
        //int price = (int) salesTable.getValueAt(salesTable.getSelectedRow(), 1);
        if (res == JOptionPane.YES_OPTION) {

            //model.setValueAt(0, selectedRowInt, 1);
            //System.out.println("after remove row:" + salesTable.getRowCount());
            String codeToRemove = (String) salesTable.getValueAt(selectedRowInt, 0);
            Integer priceToRemove = (int) salesTable.getValueAt(selectedRowInt, 1);
            processSaleController.updateRow(priceToRemove, codeToRemove, 0);
            model.removeRow(selectedRowInt);
            model.fireTableRowsDeleted(selectedRowInt, selectedRowInt);
            model.getRowCount();
            String code = "";
            sale.resetSale();
            ////System.out.println("length:" + sale.getListLength());
            int price = 0;
            for (int row = 0; row < salesTable.getRowCount(); row++) {
                code = (String) salesTable.getValueAt(row, 0);
                price = (int) salesTable.getValueAt(row, 1);
                //System.out.println("add:" + code + ", price:" + price);

            }
            updateGrandTotal();
        }
    }//GEN-LAST:event_removeSoldItemActionPerformed

    private void emptyCurrentSaleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_emptyCurrentSaleActionPerformed
       int res = JOptionPane.showConfirmDialog(null, "Vill du rensa pågående försäljning?", "", JOptionPane.YES_NO_OPTION);

            if (res == JOptionPane.YES_OPTION) {
                
                DefaultTableModel model = (DefaultTableModel) salesTable.getModel();
                while (model.getRowCount() > 0) {
                    model.removeRow(0);
                }
                sale.resetSale();
                salesTotal.setText("");
                updateGrandTotal();
                
            } 
    }//GEN-LAST:event_emptyCurrentSaleActionPerformed

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
    public void resetSystem() {
        DefaultTableModel model = (DefaultTableModel) purchaseTable.getModel();
        while (model.getRowCount() > 0) {
            model.removeRow(0);
        }
        DefaultTableModel model2 = (DefaultTableModel) salesTable.getModel();
        while (model2.getRowCount() > 0) {
            model2.removeRow(0);
        }
        File dir = new File("purchases");
        Date date = new Date();
        File newName = new File("purchases-" + date.getTime());
        
        if ( dir.isDirectory() ) {
                dir.renameTo(newName);
                dir.mkdir();
        } else {
                dir.mkdir();
                dir.renameTo(newName);
        }
        priceInput.setText("");
        codeIdInput.setText("");
        errorLabel.setText("");
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addItemButton;
    private javax.swing.JMenu advancedMenu;
    private javax.swing.JTextField codeIdInput;
    private javax.swing.JPanel currentSaleTab;
    private javax.swing.JButton deleteFile;
    private javax.swing.JButton emptyCurrentSale;
    private javax.swing.JLabel errorLabel;
    private javax.swing.JMenuItem getSellersMenuItem;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTable jTable1;
    private javax.swing.JLabel lastThreePurchases;
    private javax.swing.JMenu menu;
    private javax.swing.JMenuBar menuBar;
    private javax.swing.JButton newSaleButton;
    private javax.swing.JTextArea notesTextArea;
    private javax.swing.JTextField priceInput;
    private javax.swing.JTable purchaseTable;
    private javax.swing.JButton removeSoldItem;
    private javax.swing.JTable salesTable;
    private javax.swing.JLabel salesTotal;
    private javax.swing.JButton saveNotes;
    private javax.swing.JMenuItem sendToServerMenuItem;
    private javax.swing.JTabbedPane settings;
    private javax.swing.JTextField swishPerson;
    private javax.swing.JTabbedPane tabPane;
    // End of variables declaration//GEN-END:variables

}
