package rmi;

import java.awt.Color;
import java.rmi.RemoteException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class GraficoChatRMI extends javax.swing.JFrame {
    ComunicacionServidor chatServer;
    ComunicacionCliente chatClient;
    String username;
    int idClient=0;
    
    public GraficoChatRMI() throws RemoteException {
        this.chatServer = new ComunicacionServidor();
        this.chatClient = new ComunicacionCliente();
        initComponents();
        txtMensaje.setVisible(false);
        btnEnviar.setVisible(false);
        btnPrivado.setVisible(false);
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        btnCLiente = new javax.swing.JButton();
        btnServidor = new javax.swing.JButton();
        btnEnviar = new javax.swing.JButton();
        txtMensaje = new javax.swing.JTextField();
        nombreChat = new javax.swing.JLabel();
        btnPrivado = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(51, 51, 255));

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane1.setViewportView(jTextArea1);

        btnCLiente.setText("Cliente");
        btnCLiente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCLienteActionPerformed(evt);
            }
        });

        btnServidor.setText("Servidor");
        btnServidor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnServidorActionPerformed(evt);
            }
        });

        btnEnviar.setText("Enviar publico");
        btnEnviar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEnviarActionPerformed(evt);
            }
        });

        nombreChat.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        nombreChat.setText("CHAT RMI");

        btnPrivado.setText("Enviar privado");
        btnPrivado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPrivadoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(64, 64, 64)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jScrollPane1)
                            .addComponent(txtMensaje)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnCLiente, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 60, Short.MAX_VALUE)
                                .addComponent(btnServidor, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(87, 87, 87)
                        .addComponent(btnEnviar, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(108, 108, 108)
                        .addComponent(btnPrivado))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(195, 195, 195)
                        .addComponent(nombreChat)))
                .addContainerGap(68, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(nombreChat, javax.swing.GroupLayout.DEFAULT_SIZE, 38, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 243, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCLiente)
                    .addComponent(btnServidor))
                .addGap(27, 27, 27)
                .addComponent(txtMensaje, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnEnviar)
                    .addComponent(btnPrivado))
                .addGap(16, 16, 16))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnServidorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnServidorActionPerformed

        String Ip=JOptionPane.showInputDialog(rootPane, "Ingresa tu ip", "Servidor", HEIGHT);
        System.out.println(Ip);
        chatServer.connection(Ip);
        
        jTextArea1.append("Conexion al servidor exitosa!");
        
        nombreChat.setText("Servidor");
        
        btnServidor.setEnabled(false);
        btnCLiente.setEnabled(false);
    }//GEN-LAST:event_btnServidorActionPerformed

    private void btnCLienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCLienteActionPerformed
        
        if(idClient<5){
            String Ip=JOptionPane.showInputDialog(rootPane, "Ingresa la ip del servidor", "Cliente", HEIGHT);
            username=JOptionPane.showInputDialog(rootPane, "Ingresa tu username", "Cliente", HEIGHT);

            System.out.println(Ip);
            
            chatClient=new ComunicacionCliente();
            chatClient.startClient(username, jTextArea1,Ip);
            
            idClient++;
            jTextArea1.append("Conexion al servidor exitosa!");
            System.out.println(idClient);
            
            nombreChat.setText("Usuario cli: " + username);
            
            txtMensaje.setVisible(true);
            btnEnviar.setVisible(true);
            btnPrivado.setVisible(true);
            
            btnServidor.setEnabled(false);
            btnCLiente.setEnabled(false);
        }
        
                
    }//GEN-LAST:event_btnCLienteActionPerformed

    private void btnEnviarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEnviarActionPerformed
        if(!txtMensaje.getText().isEmpty()){
            String message=txtMensaje.getText();

            try {
                chatClient.sendMessage(message,username);
                System.out.println(idClient-1);
                cleanTxt();
            } catch (RemoteException ex) {
                Logger.getLogger(GraficoChatRMI.class.getName()).log(Level.SEVERE, null, ex);
            }  
        }

    }//GEN-LAST:event_btnEnviarActionPerformed

    private void btnPrivadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPrivadoActionPerformed
        if(!txtMensaje.getText().isEmpty()){

            String privateUser=JOptionPane.showInputDialog(rootPane, "Ingresa el nombre del usario para mandarle mensaje privado", "Cliente", HEIGHT);
            try {
                chatClient.sendPrivate(username, privateUser, txtMensaje.getText());
                cleanTxt();
            } catch (RemoteException ex) {
                Logger.getLogger(GraficoChatRMI.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_btnPrivadoActionPerformed

    private void cleanTxt(){
        txtMensaje.setText("");
    }
    
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
            java.util.logging.Logger.getLogger(GraficoChatRMI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GraficoChatRMI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GraficoChatRMI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GraficoChatRMI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new GraficoChatRMI().setVisible(true);
                } catch (RemoteException ex) {
                    Logger.getLogger(GraficoChatRMI.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCLiente;
    private javax.swing.JButton btnEnviar;
    private javax.swing.JButton btnPrivado;
    private javax.swing.JButton btnServidor;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JLabel nombreChat;
    private javax.swing.JTextField txtMensaje;
    // End of variables declaration//GEN-END:variables
}
