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

import com.losalpes.entities.RegistroVenta;
import com.losalpes.entities.Usuario;
import java.util.List;
import javax.ejb.EJB;
import com.losalpes.servicios.IServicioReporteVentasMockLocal;

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

    
    private Usuario cliente;

             
    /**
     * Lista de ventas realizadas por usuario
     */
    List<RegistroVenta> ventasPorUsuario;

    
    /**
     * Lista de los tres muebles mas vendidos
     */
    List<RegistroVenta> tresMueblesMasVendidos;
    
        
    //-----------------------------------------------------------
    // Constructor
    //-----------------------------------------------------------
    
    /**
     * Constructor sin argumentos de la clase
     */
    public VentaBean()
    {
        cliente=new Usuario();
    }
         
    public void consultarVentasPorUsuario(){
        ventasPorUsuario = servicioVentas.getVentasPorCliente(getCliente());
        
    }
    
    public void consultarTresMueblesMasVendidos(){
        tresMueblesMasVendidos = servicioVentas.getTresMueblesMasVendidos();
        
    }
    
    //-----------------------------------------------------------
    // Getters y setters
    //-----------------------------------------------------------
 
    public Usuario getCliente() {
        return cliente;
    }
     
     
    public List<RegistroVenta> getVentasPorUsuario() {
        return ventasPorUsuario;
    } 
    
    
    public List<RegistroVenta> getTresMueblesMasVendidos() {
        return tresMueblesMasVendidos;
    }
}
