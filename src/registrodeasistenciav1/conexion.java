
package registrodeasistenciav1;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;


public class conexion {
    Connection con=null;
    Propiedades properties = new Propiedades();
    public Connection  conexion() { 
    try{
        Properties propiedades = properties.cargarArchivoProperties();
        Class.forName("com.mysql.cj.jdbc.Driver");
//        con=DriverManager.getConnection("jdbc:mysql://localhost/asistencias?serverTimezone=UTC","root","Mysql");
        String url= propiedades.getProperty("conexion.url");
        String user = propiedades.getProperty("conexion.user");
        String password = propiedades.getProperty("conexion.password");
        con = DriverManager.getConnection(url,user,password);
        System.out.println("conexion establecida");
    }  catch (ClassNotFoundException e ) { 
           System.out.println("error de conexion"+e);
           JOptionPane.showMessageDialog(null, "Error de conexion con la base de datos, comunicarse con soporte técnico al Whatsapp 999480878 o enviar un mail a nonalayavalderramabryan@gmail.com", "ERROR CON EL ARCHIVO PROPERTIES DE CONEXION A BD", JOptionPane.ERROR_MESSAGE);
           } catch (IOException ex) {
            Logger.getLogger(conexion.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Error de conexion con la base de datos, comunicarse con soporte técnico al Whatsapp 999480878 o enviar un mail a nonalayavalderramabryan@gmail.com", "ERROR CON EL ARCHIVO PROPERTIES DE CONEXION A BD", JOptionPane.ERROR_MESSAGE);
        } catch (SQLException ex) {
            Logger.getLogger(conexion.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Error de conexion con la base de datos, comunicarse con soporte técnico al Whatsapp 999480878 o enviar un mail a nonalayavalderramabryan@gmail.com", "ERROR CON EL ARCHIVO PROPERTIES DE CONEXION A BD", JOptionPane.ERROR_MESSAGE);
        }
       return con;
    }
}
