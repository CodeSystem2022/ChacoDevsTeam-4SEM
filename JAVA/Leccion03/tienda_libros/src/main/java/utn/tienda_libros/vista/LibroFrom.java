package main.java.utn.tienda_libros.vista;
import org.springframework.beans.factory.annotation.Autowired;

import javax.swing.*;

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
    }
}
