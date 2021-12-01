package com.DiegoDegracia.PresentacionTerminal;

import com.DiegoDegracia.Modelos.Atraccion;
import com.DiegoDegracia.Modelos.TipoAventura;
import com.DiegoDegracia.Modelos.Usuario;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class AlmacenFicheros {
    // Constructores

    public AlmacenFicheros() {
    }

    public List<Usuario> LeerUsuariosDesdeFichero(String pathArchivo){
        List<Usuario> ret = new ArrayList<>();
        try{
            File archivo = new File(pathArchivo);
            FileReader fr = new FileReader(archivo);
            BufferedReader br = new BufferedReader(fr);

            String linea = br.readLine();
            while(linea != null){
                String[] valores = linea.split(",");
                String nombre = valores[0];
                TipoAventura preferencia = TipoAventura.valueOf(valores[1]);
                Integer tiempo = Integer.valueOf(valores[2]);
                Double presupuesto = Double.valueOf(valores[3]);

                linea = br.readLine();
            }

            return ret;
        }catch (Exception ex)
        {
            System.out.println(ex);
        }
        return ret;
    }
}
