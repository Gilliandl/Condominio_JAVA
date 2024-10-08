
package view;

import controller.daoApartamento;
import controller.daoSalaofesta;
import enums.Limpeza;
import enums.Reserva;
import java.time.format.DateTimeFormatter;
import javax.swing.DefaultComboBoxModel;
import java.sql.*;
import java.time.LocalDate;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import model.Apartamento;
import model.salaoFesta;

public class dialogSalaofesta extends javax.swing.JDialog {

    private daoSalaofesta dao = new daoSalaofesta();
    private DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    
    private void limpaComponentes(){
        txtCodigo.setText("");
        txtData.setText(LocalDate.now().format(formato));
        comboReserva.setSelectedIndex(0);
        comboLimpeza.setSelectedIndex(0);
        comboApartamento.setSelectedIndex(0);       
    }
    

    
    //carregar os combos
    private void carregaComboReserva() throws SQLException{
        DefaultComboBoxModel cbm = new DefaultComboBoxModel(Reserva.values());
        comboReserva.setModel(cbm);
    }
    
    //carregar os combos
    private void carregaComboLimpeza() throws SQLException{
        DefaultComboBoxModel cbm = new DefaultComboBoxModel(Limpeza.values());
        comboLimpeza.setModel(cbm);
    }
    
    //carregar os combos
    private void carregaComboApartamento() throws java.sql.SQLException{
        DefaultComboBoxModel cbm = new DefaultComboBoxModel(new daoApartamento().read().toArray());
        comboApartamento.setModel(cbm);
    }
    
    
    public dialogSalaofesta(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
    }
    
    private salaoFesta criaObjeto(){
        salaoFesta sf = new salaoFesta();
        if(txtCodigo.getText().isEmpty()){
            sf.setId(0);
        }else{
            sf.setId(Integer.parseInt(txtCodigo.getText()));
        }
        sf.setDatareserva(LocalDate.parse(txtData.getText(),formato));
        sf.setReserva((Reserva)comboReserva.getSelectedItem());
        sf.setLimpeza((Limpeza)comboLimpeza.getSelectedItem());
        sf.setApartamento((Apartamento)comboApartamento.getSelectedItem());
        
        return(sf);
    }
    
     private void populaComponentes(salaoFesta sf){
        txtCodigo.setText(sf.getId()+"");
        txtData.setText(sf.getDatareserva().format(formato));
        comboReserva.setSelectedItem(sf.getReserva());
        comboLimpeza.setSelectedItem(sf.getLimpeza());
        comboApartamento.setSelectedItem(sf.getApartamento());
    }
    
    private boolean camposValidos(){
        return(!(txtData.getText().equals("  /  /    ")));
    }
    
    private void atualizaLista() throws SQLException{
        DefaultListModel lm = new DefaultListModel();
        lm.addAll(dao.read());
        System.out.print(lm);
        listaSalaofesta.setModel(lm);            
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtData = new javax.swing.JFormattedTextField();
        txtCodigo = new javax.swing.JTextField();
        comboReserva = new javax.swing.JComboBox<>();
        comboLimpeza = new javax.swing.JComboBox<>();
        comboApartamento = new javax.swing.JComboBox<>();
        btnNovo = new javax.swing.JButton();
        btnSalvar = new javax.swing.JButton();
        btnRemover = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        listaSalaofesta = new javax.swing.JList();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(135, 206, 250));

        jPanel2.setBackground(new java.awt.Color(0, 191, 255));

        jLabel1.setText("Codigo:");

        jLabel2.setText("Data Reserva:");

        jLabel3.setText("Reserva:");

        jLabel4.setText("Limpeza:");

        jLabel5.setText("Apartamento:");

        try {
            txtData.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        comboReserva.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        comboLimpeza.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        comboApartamento.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        comboApartamento.setToolTipText("");
        comboApartamento.setRequestFocusEnabled(false);
        comboApartamento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboApartamentoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(txtCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtData, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addGap(47, 47, 47)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel5)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4)
                    .addComponent(comboReserva, 0, 272, Short.MAX_VALUE)
                    .addComponent(comboLimpeza, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(comboApartamento, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(24, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(comboReserva, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(15, 15, 15)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtData, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(comboLimpeza, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jLabel5)
                .addGap(18, 18, 18)
                .addComponent(comboApartamento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(35, Short.MAX_VALUE))
        );

        btnNovo.setText("Novo Registro");
        btnNovo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNovoActionPerformed(evt);
            }
        });

        btnSalvar.setText("Salvar Registro");
        btnSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalvarActionPerformed(evt);
            }
        });

        btnRemover.setText("Remover Registro");
        btnRemover.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRemoverActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 52, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnSalvar, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnRemover)
                    .addComponent(btnNovo, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(44, 44, 44))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addComponent(btnNovo)
                .addGap(26, 26, 26)
                .addComponent(btnSalvar)
                .addGap(30, 30, 30)
                .addComponent(btnRemover)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        listaSalaofesta.setModel(new javax.swing.AbstractListModel() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        listaSalaofesta.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        listaSalaofesta.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                listaSalaofestaMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(listaSalaofesta);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane1)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 356, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void comboApartamentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboApartamentoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_comboApartamentoActionPerformed

    private void btnNovoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNovoActionPerformed
        // TODO add your handling code here:
        this.limpaComponentes();
    }//GEN-LAST:event_btnNovoActionPerformed

    private void btnSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalvarActionPerformed
        // TODO add your handling code here:
        if (!this.camposValidos()){
            JOptionPane.showMessageDialog(null, "Campos obrigatorios não preenchidos.");
            txtData.requestFocus();
            return;
        }

        salaoFesta sf = this.criaObjeto();

        try{
            if (txtCodigo.getText().isEmpty()){//registro novo
                dao.create(sf);
            }else{//atualização de registros
                dao.update(sf);
            }

            //atualização de componetes
            this.limpaComponentes();
            this.atualizaLista();
            JOptionPane.showMessageDialog(null, "Cliente Gravado.");

        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "ERRO:" + ex.getMessage());
        }
    }//GEN-LAST:event_btnSalvarActionPerformed

    private void btnRemoverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRemoverActionPerformed
        // TODO add your handling code here:
        if (listaSalaofesta.getSelectedIndex() == -1){
            JOptionPane.showMessageDialog(null, "Selecione");
            return;
        }
        if (JOptionPane.showConfirmDialog(null, "Confirma?")!=0){
            return;
        }
        try{
            salaoFesta sf = (salaoFesta)listaSalaofesta.getSelectedValue();
            dao.delete(sf);
            this.limpaComponentes();
            this.atualizaLista();
            JOptionPane.showMessageDialog(null, "Cliente Removido.");
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "ERROR:" + ex.getMessage());

        }
    }//GEN-LAST:event_btnRemoverActionPerformed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        // TODO add your handling code here:
        try{
            this.carregaComboApartamento();
            this.carregaComboReserva();
            this.carregaComboLimpeza();
            this.atualizaLista();
        }catch(SQLException ex){
            System.out.println("ERRO:" + ex.getMessage());
        }    
    }//GEN-LAST:event_formWindowOpened

    private void listaSalaofestaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_listaSalaofestaMouseClicked
        // TODO add your handling code here:
        if (evt.getClickCount() == 2 ){
            salaoFesta sf = (salaoFesta)listaSalaofesta.getSelectedValue();
            this.populaComponentes(sf);
        }
    }//GEN-LAST:event_listaSalaofestaMouseClicked

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(dialogSalaofesta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(dialogSalaofesta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(dialogSalaofesta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(dialogSalaofesta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                dialogSalaofesta dialog = new dialogSalaofesta(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnNovo;
    private javax.swing.JButton btnRemover;
    private javax.swing.JButton btnSalvar;
    private javax.swing.JComboBox<String> comboApartamento;
    private javax.swing.JComboBox<String> comboLimpeza;
    private javax.swing.JComboBox<String> comboReserva;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JList listaSalaofesta;
    private javax.swing.JTextField txtCodigo;
    private javax.swing.JFormattedTextField txtData;
    // End of variables declaration//GEN-END:variables
}
