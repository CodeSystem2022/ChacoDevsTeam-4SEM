package main.java.utn.tienda_libros.vista;
import org.graalvm.compiler.lir.CompositeValue;
import org.springframework.beans.factory.annotation.Autowired;

import javax.swing.*;
@Component
public class LibroFrom extends JFrame {
    utn.tienda_libros.servicio.LibroServicio libroServicio;
    private JPanel panel;

    @Autowired
    public LibroFrom(utn.tienda_libros.servicio.LibroServicio libroServicio){
        this.libroServicio =libroServicio;
        iniciarForma();
    }

    private void  iniciarForma(){
        setContentPane(panel);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        setSize(900, 700);
        //Para obtener las dimensiones
        Toolkit toolkit =Toolkit.getDefaultToolkit();
        Dimension tamanioPantalla= toolkit.getScreenSize();
        int x = (tamanioPantalla.widht - getWidth()/2);
        int y = (tamanioPantalla.height - getHeight()/2);
        setLocation(x, y);
    }
}
