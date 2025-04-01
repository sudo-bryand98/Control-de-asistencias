
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
    Propiedades properties = new Propiedades(); // CREANDO INSTANCIA DE LA CLASE PROPIEDADES
    public Connection  conexion() { 
    try{
        Properties propiedades = properties.cargarArchivoProperties(); //OBTENIENDO EL METODO PARA CARGAR EL ARCHIVO PROPERTIES DE LA CLASE PROPIEDADES 
        Class.forName("com.mysql.cj.jdbc.Driver"); // DRIVER DE CONEXION A LA BD EN MYSQL VER 8
        //OBTENIENDO ATRIBUTOS DEL ARCHIVO PROPERTIES PARA LA CONEXION CON LA BD
        String url= propiedades.getProperty("conexion.url"); // OBTENIENDO LA URL DE LA CONEXION DE LA BD
        String user = propiedades.getProperty("conexion.user"); // OBTENIENDO EL USUARIO DE MYSQL
        String password = propiedades.getProperty("conexion.password"); // OBTENIENDO LA CONTRASEÑA DEL USUARIO MYSQL
        //FIN DE OBTENCION DE ATRIBUTOS DEL ARCHIVO PROPERTIES
        con = DriverManager.getConnection(url,user,password); // ENVIANDO LOS VALORES OBTENIDOS DEL ARCHIVO PROPERTIES A LA CONEXION CON LA BD
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
