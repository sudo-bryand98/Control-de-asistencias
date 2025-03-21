package registrodeasistenciav1;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class Propiedades {
    
    public Properties cargarArchivoProperties() throws FileNotFoundException, IOException{
        Properties propiedades = new Properties();
        InputStream archivo = new FileInputStream("./resources/conexionBD.properties");
        propiedades.load(archivo);
        return propiedades;
    }
    
}
