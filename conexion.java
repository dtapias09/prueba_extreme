
package prueba;

import java.io.File;
import java.sql.*;
import javax.swing.JOptionPane;


public class conexion {
 private Connection conn = null;
 int n=0;
 
    public Connection crearBD() {
            
        try {       
          Class.forName("org.apache.derby.jdbc.EmbeddedDriver");  //llamamos el driver de para mysql       
          conn = DriverManager.getConnection("jdbc:derby:.\\basedatos\\"); //inicializamos la conexión
         
          if (conn!=null){
              
            System.out.println("conexion existosa a Derby");
 
            String tabla="create table producto(codigo int primary key not null, "
                       + "nombre varchar(50) not null,"
                       + "cantidad int not null, "
                       + "precio int  not null)";          
                   
            try {
            PreparedStatement ps = conn.prepareStatement(tabla);
            ps.execute();
            ps.close(); 
            System.out.println("Tabla PRODUCTO creada");
            
                System.out.println("ventas");
        } catch (SQLException ex ) {
         //   JOptionPane.showMessageDialog(null, ex.getLocalizedMessage());
        }
         }
        } catch (Exception e) {
         JOptionPane.showMessageDialog(null,e.getMessage(),"Error" ,  JOptionPane.ERROR_MESSAGE);
      } 
       return conn; 
}
        public Connection crearBD2() {
        try {       
          Class.forName("org.apache.derby.jdbc.EmbeddedDriver");  //llamamos el driver de para mysql       
          conn = DriverManager.getConnection("jdbc:derby:.\\basedatos\\"); //inicializamos la conexión
         
          if (conn!=null){
            System.out.println("conexion existosa a Derby");
            
            String tabla2="create table VENTAS (codigo int not null, "
                       + "cantidad_v int not null,"
                       + "total double not null)";   
            try {
            
            PreparedStatement ps2 = conn.prepareStatement(tabla2);
            ps2.execute();
            ps2.close(); 
            System.out.println("Tabla VENTAS creada");
            
        } catch (SQLException ex ) {
          //  JOptionPane.showMessageDialog(null, ex.getLocalizedMessage());
        }
         }
        } catch (Exception e) {
         JOptionPane.showMessageDialog(null,e.getMessage(),"Error" ,  JOptionPane.ERROR_MESSAGE);
      } 
       return conn; 
}

    public Connection cargarBD(){
     try {
         Class.forName("org.apache.derby.jdbc.EmbeddedDriver");  //llamamos el driver de para mysql 
         conn = DriverManager.getConnection("jdbc:derby:.\\basedatos\\;create=true"); //inicializamos la conexión
         
         if (n==0) {
           System.out.println("Base de datos - Loaded!");  
           n=1;
         }    
     } catch (ClassNotFoundException | SQLException ex) {
         JOptionPane.showMessageDialog(null,ex.getMessage(),"Error" ,  JOptionPane.ERROR_MESSAGE);
     }   
     return conn;
    }
  
}
    