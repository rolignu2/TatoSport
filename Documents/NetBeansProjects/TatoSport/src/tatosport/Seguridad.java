

package tatosport;


import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.imageio.ImageIO;


/**
 *
 * @author rolandoantonio
 */
public class Seguridad {
    
    private static int PRIVILEGIOS_ = 0;
    
    public static void Set_privilegios(int priv)
    {
        PRIVILEGIOS_ = priv;
    }
    
    public static int Get_privilegios()
    {
        return PRIVILEGIOS_;
    }
    
    public static String Get_formato_fecha(Date fecha)
    {
        try{
            String fecha_salida = null;
            Date date = fecha;
            long d = date.getTime();
            java.sql.Date fech = new java.sql.Date(d);
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            fecha_salida=sdf.format(fech);
            return fecha_salida;
        }catch(Exception ex)
        {
            return null;
        }
    }
    
    public BufferedImage ConvertidorByteImg(byte[] Mbits) throws IOException
    {
       InputStream in = new ByteArrayInputStream(Mbits);
       BufferedImage bImageFromConvert = ImageIO.read(in);
       return bImageFromConvert;
    }
    
}
