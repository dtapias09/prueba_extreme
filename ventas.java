
package prueba;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class ventas extends javax.swing.JFrame {
    
   conexion cone = new conexion();
   Connection cone2;
   int id=0, stock=0, prec=0, cod=0;
   
      public void tabla(){
       String col[]={"CODIGO", "CANTIDAD","TOTAL"}; //crea los nombres de cada columna
       DefaultTableModel model = new DefaultTableModel(null, col);
       
       try {
           Statement st = cone2.createStatement(); //llama la base de datos
           ResultSet rs = st.executeQuery("Select * from VENTAS"); //mandamos una consulta sql
           
           while (rs.next()) { //´por medio del while recorremos la tabla mostrada en el SELECT FROM
               Object fil []={rs.getString("codigo"), rs.getString("cantidad_v"), rs.getString("total")};
               model.addRow(fil);
           }
           tb2.setModel(model);
           st.close();
       } catch (SQLException ex) {
           System.out.println("error: "+ex);
       }
   }
      public void actualizar(){
          int codigo, cantidad;
          codigo = id;
          cantidad = stock;
          
          cone2 = cone.cargarBD();
          if (cone2!=null) {
              try {
                  Statement st = cone2.createStatement();
                  String act = "UPDATE producto set cantidad = "+stock+" WHERE codigo= "+id+"";
                  st.executeUpdate(act);
                  System.out.println("Tabla producto, actualizado stock");
                  st.close();
              } catch (SQLException ex) {
                  Logger.getLogger(ventas.class.getName()).log(Level.SEVERE, null, ex);
              }
          }
      }
    public ventas() {
        initComponents();
        cone2 = cone.crearBD2();
        if (cone2!=null) {
            tabla();
                txt7.setEditable(false); //inactivamos la edicion del campo total
                txt8.setEditable(false); //inactivamos la edicion del campo stock
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tb2 = new javax.swing.JTable();
        txt5 = new javax.swing.JTextField();
        txt7 = new javax.swing.JTextField();
        tbn6 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        txt6 = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txt8 = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setText("CODIGO");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 40, -1, -1));

        jLabel2.setText("CANTIDAD");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 70, -1, -1));

        tb2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(tb2);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 20, 310, 180));

        txt5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt5ActionPerformed(evt);
            }
        });
        getContentPane().add(txt5, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 70, 111, -1));
        getContentPane().add(txt7, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 100, 111, -1));

        tbn6.setText("VENDER");
        tbn6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tbn6ActionPerformed(evt);
            }
        });
        getContentPane().add(tbn6, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 140, 123, -1));

        jLabel3.setText("TOTAL (IVA)");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 100, -1, -1));
        getContentPane().add(txt6, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 40, 111, -1));

        jLabel4.setText("STOCK DISPONIBLE");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 220, -1, -1));

        txt8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt8ActionPerformed(evt);
            }
        });
        getContentPane().add(txt8, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 220, 110, -1));

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel7.setText("PORTAL DE GESTION DE VENTAS");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));

        jMenu1.setText("Inicio");

        jMenuItem1.setText("Inventario");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem1);

        jMenuItem2.setText("Salir");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem2);

        jMenuBar1.add(jMenu1);

        setJMenuBar(jMenuBar1);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void txt5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt5ActionPerformed

    }//GEN-LAST:event_txt5ActionPerformed

    private void tbn6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tbn6ActionPerformed
        cone2 = cone.cargarBD();
        if (cone2!=null) {
            try {
                int codigo = Integer.parseInt(txt6.getText());
                int cantidad = Integer.parseInt(txt5.getText());
                double total =0;
                 // creamos una variable cod para asignar el codigo consultado
         
           Statement st = cone2.createStatement(); //llama la base de datos
           ResultSet rs = st.executeQuery("Select * from producto WHERE codigo = "+codigo+""); //mandamos una consulta sql
        
           while (rs.next()) { //´por medio del while recorremos la tabla mostrada en el SELECT FROM
                cod = Integer.parseInt(rs.getString("codigo"));
                stock = Integer.parseInt(rs.getString("cantidad")); //asignamos el valor la cantidad registrada en producto
                prec = Integer.parseInt(rs.getString("precio")); // asignamos el valor del precio registrado en producto
           }
                if (cod==codigo) {
                  if (cantidad<stock) {
              double IVA=0.19;
                total = prec * cantidad;
                IVA=IVA*total;
                total=total+IVA;
                stock = stock-cantidad;
                String insert="insert into ventas (codigo, cantidad_v, total) values "
                            + "("+codigo+", "+cantidad+" , "+total+")";
                
                st.executeUpdate(insert);
                JOptionPane.showMessageDialog(null, "Venta Registrada");
                tabla();
                id = codigo;  
                actualizar();
                
                }else{
                    JOptionPane.showMessageDialog(null, "Cantidad de Stock insuficiente para su compra");
                }  
                }else{
                    JOptionPane.showMessageDialog(null, "El codigo ingresado no existe, intente de nuevo");
                }
                
                    String disponible = Integer.toString(stock); //convertimos numerico a caracter
                    String tot = Double.toString(total); //convertimos numerico a caracter
                    txt8.setText(disponible); //mostramos por medio del campo de texto el valor de stock
                    txt7.setText(tot); //mostramos por medio del campo de texto el valor total
                
            //    limpiar();
            } catch (SQLException ex) {
                System.out.println("error: "+ ex);
            }
        }
    }//GEN-LAST:event_tbn6ActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        inventario ir = new inventario();
        ir.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        System.exit(0);
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void txt8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt8ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt8ActionPerformed

    public static void main(String args[]) {  
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                
                new ventas().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tb2;
    private javax.swing.JButton tbn6;
    private javax.swing.JTextField txt5;
    private javax.swing.JTextField txt6;
    private javax.swing.JTextField txt7;
    private javax.swing.JTextField txt8;
    // End of variables declaration//GEN-END:variables
}
