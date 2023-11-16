
package fravemax.VistasProvisorias;


public class MenuProvisorio extends javax.swing.JFrame {


    public MenuProvisorio() {
        initComponents();
        this.setLocationRelativeTo(null);
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jdpEscritorio = new javax.swing.JDesktopPane();
        jMenuBar1 = new javax.swing.JMenuBar();
        jmCliente = new javax.swing.JMenu();
        jmProducto = new javax.swing.JMenu();
        jmDetalleVenta = new javax.swing.JMenu();
        jmVenta = new javax.swing.JMenu();
        jmSalir = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout jdpEscritorioLayout = new javax.swing.GroupLayout(jdpEscritorio);
        jdpEscritorio.setLayout(jdpEscritorioLayout);
        jdpEscritorioLayout.setHorizontalGroup(
            jdpEscritorioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 732, Short.MAX_VALUE)
        );
        jdpEscritorioLayout.setVerticalGroup(
            jdpEscritorioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 650, Short.MAX_VALUE)
        );

        jmCliente.setText("Cliente");
        jmCliente.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jmClienteMouseClicked(evt);
            }
        });
        jMenuBar1.add(jmCliente);

        jmProducto.setText("Producto");
        jmProducto.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jmProductoMouseClicked(evt);
            }
        });
        jMenuBar1.add(jmProducto);

        jmDetalleVenta.setText("Detalle de Venta");
        jMenuBar1.add(jmDetalleVenta);

        jmVenta.setText("Venta");
        jmVenta.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jmVentaMouseClicked(evt);
            }
        });
        jMenuBar1.add(jmVenta);

        jmSalir.setText("Salir");
        jmSalir.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jmSalirMouseClicked(evt);
            }
        });
        jMenuBar1.add(jmSalir);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jdpEscritorio)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jdpEscritorio)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jmClienteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jmClienteMouseClicked
        jdpEscritorio.removeAll();
        jdpEscritorio.repaint();
        ClienteFormulario nc = new ClienteFormulario();
        nc.setVisible(true);
        jdpEscritorio.add(nc);
        jdpEscritorio.moveToFront(nc);
    }//GEN-LAST:event_jmClienteMouseClicked

    private void jmSalirMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jmSalirMouseClicked
        jdpEscritorio.removeAll();
        jdpEscritorio.repaint();
        System.exit(0);
    }//GEN-LAST:event_jmSalirMouseClicked

    private void jmProductoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jmProductoMouseClicked
        jdpEscritorio.removeAll();
        jdpEscritorio.repaint();
        ProductoFormulario pf = new ProductoFormulario();
        pf.setVisible(true);
        jdpEscritorio.add(pf);
        jdpEscritorio.moveToFront(pf);
    }//GEN-LAST:event_jmProductoMouseClicked

    private void jmVentaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jmVentaMouseClicked
        jdpEscritorio.removeAll();
        jdpEscritorio.repaint();
        VentaFormulario vf = new VentaFormulario();
        vf.setVisible(true);
        jdpEscritorio.add(vf);
        jdpEscritorio.moveToFront(vf);
    }//GEN-LAST:event_jmVentaMouseClicked


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
            java.util.logging.Logger.getLogger(MenuProvisorio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MenuProvisorio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MenuProvisorio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MenuProvisorio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MenuProvisorio().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JDesktopPane jdpEscritorio;
    private javax.swing.JMenu jmCliente;
    private javax.swing.JMenu jmDetalleVenta;
    private javax.swing.JMenu jmProducto;
    private javax.swing.JMenu jmSalir;
    private javax.swing.JMenu jmVenta;
    // End of variables declaration//GEN-END:variables
}
