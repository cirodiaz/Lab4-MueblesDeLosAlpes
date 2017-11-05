/**
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * $Id$ VentaBean.java
 * Universidad de los Andes (Bogotá - Colombia)
 * Departamento de Ingeniería de Sistemas y Computación
 * Licenciado bajo el esquema Academic Free License version 3.0
 *
 * Ejercicio: Muebles de los Alpes
 *
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 */
package com.losalpes.beans;

import com.losalpes.entities.Ciudad;
import com.losalpes.entities.Mueble;
import com.losalpes.entities.Pais;
import com.losalpes.entities.RegistroVenta;
import com.losalpes.entities.Usuario;
import java.util.List;
import javax.ejb.EJB;
import com.losalpes.servicios.IServicioReporteVentasMockLocal;
import java.util.ArrayList;
import javax.faces.model.SelectItem;

/**
 * Managed Bean encargado de renderizar el informe de ventas
 *
 */
public class VentaBean {

    //-----------------------------------------------------------
    // Atributos
    //-----------------------------------------------------------
    /**
     * Relación con la interfaz que provee los servicios necesarios del reporte
     * de ventas
     */
    @EJB
    private IServicioReporteVentasMockLocal servicioVentas;

    
    /**
     * Lista con los países del sistema
     */
    private List<Pais> paises;
    
    /**
     * Cliente del sistema
     */
    private Usuario cliente;

    /**
     * País seleccionado en el registro
     */
    private Pais pais;
             
    /**
     * Lista de ventas realizadas por usuario
     */
    List<RegistroVenta> ventasPorUsuario;

    
    /**
     * Lista de los tres muebles mas vendidos
     */
    List<Mueble> tresMueblesMasVendidos;
    
    
    /**
     * Lista de los cinco mayores compradores por país
     */
    List<RegistroVenta> mayoresCompradoresPorPais;
    
        
    //-----------------------------------------------------------
    // Constructor
    //-----------------------------------------------------------
    
    /**
     * Constructor sin argumentos de la clase
     */
    public VentaBean()
    {
        cliente=new Usuario();
        paises = new ArrayList<Pais>();
        List<Ciudad> ciudades;
        
        paises = new ArrayList<Pais>();
        ciudades = new ArrayList<Ciudad>();   

        ArrayList<Ciudad> array = new ArrayList<Ciudad>();
        array.add(new Ciudad("Bogotá"));
        array.add(new Ciudad("Cali"));
        array.add(new Ciudad("Cartagena"));
        array.add(new Ciudad("Medellín"));
        array.add(new Ciudad("Santa Marta"));
        pais = new Pais("Colombia", array);
        paises.add(pais);

        ArrayList<Ciudad> array2 = new ArrayList<Ciudad>();
        array2.add(new Ciudad("Atlanta"));
        array2.add(new Ciudad("Chicago"));
        array2.add(new Ciudad("Miami"));
        array2.add(new Ciudad("New York"));
        array2.add(new Ciudad("Washington D.C"));      

        paises.add(new Pais("Estados Unidos", array2));

        ArrayList<Ciudad> array3 = new ArrayList<Ciudad>();
        array3.add(new Ciudad("Cambridge"));
        array3.add(new Ciudad("Canterbury"));
        array3.add(new Ciudad("Liverpool"));
        array3.add(new Ciudad("Manchester"));
        array3.add(new Ciudad("Oxford"));

        paises.add(new Pais("Inglaterra", array3));
        
        
    }
         
    public void consultarVentasPorUsuario(){
        ventasPorUsuario = servicioVentas.getVentasPorCliente(getCliente());
        
    }
    
    public void consultarTresMueblesMasVendidos(){
        tresMueblesMasVendidos = servicioVentas.getTresMueblesMasVendidos();
        
    }
    
    public void consultarMayoresCompradoresPorPais(){        
        mayoresCompradoresPorPais = servicioVentas.getMayoresCompradoresPorPais(new Pais(getPais(),null));
        
    }
    
    //-----------------------------------------------------------
    // Getters y setters
    //-----------------------------------------------------------
 
    public Usuario getCliente() {
        return cliente;
    }

    public SelectItem[] getPaises()
    {
        SelectItem[] sitems = new SelectItem[paises.size()];
        for (int i = 0; i < sitems.length; i++) {
            sitems[i] = new SelectItem(paises.get(i).getNombre());
        }
        return sitems;
    }

    public String getPais() {
        return pais.getNombre();
    }    

    /**
     * Modifica, dado el nombre, el objeto país de la clase
     * @param nombre Nombre del país a seleccionar
     */
    public void setPais(String nombre)
    {

        for (int i = 0; i < paises.size(); i++)
        {
            if (paises.get(i).getNombre().equals(nombre))
            {
                pais = paises.get(i);
                return;
            }
        }
    }
    
    
    public List<RegistroVenta> getVentasPorUsuario() {
        return ventasPorUsuario;
    } 
    
    
    public List<Mueble> getTresMueblesMasVendidos() {
        return tresMueblesMasVendidos;
    }
    
    public List<RegistroVenta> getMayoresCompradoresPorPais() {
        return mayoresCompradoresPorPais;
    }
    
    
    
}
