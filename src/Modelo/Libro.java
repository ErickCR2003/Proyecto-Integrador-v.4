package Modelo;

public class Libro {
    private int idlibro;
    private String titulo;
    private int idautor;
    private int ideditorial;
    private int idempleado;
    private double precio;
    private int stock;
    private int numpagina;
    private int idtipolibro;
    private int cantidad;
    
    private Autor autor;
    private Editorial editorial;
    private Empleado empleado;
    private TipoLibro tipolibros;
    
    double descuento = 20;
    String prueba;
    int prueba1;
    public Libro() {
    }

    public int getCantidad() {return cantidad;}
    public void setCantidad(int cantidad) {this.cantidad = cantidad;}
    public int getIdlibro()                     {   return idlibro; }
    public void setIdlibro(int idlibro)         {   this.idlibro = idlibro; }
    public String getTitulo()                   { return titulo;  }   
    public void setTitulo(String titulo)        {  this.titulo = titulo;   }
    public int getIdautor()                     {   return idautor; }
    public void setIdautor(int idautor)         {   this.idautor = idautor; }
    public int getIdeditorial()                 {   return ideditorial; }
    public void setIdeditorial(int ideditorial) {   this.ideditorial = ideditorial; }
    public int getIdempleado()                  {    return idempleado;  }
    public void setIdempleado(int idempleado)   { this.idempleado = idempleado;   }
    public double getPrecio()                   { return precio;  }
    public void setPrecio(double precio)        {  this.precio = precio;   }
    public int getStock()                       { return stock;   }
    public void setStock(int stock)             {   this.stock = stock; }
    public Autor getAutor()                     {   return autor;   }
    public void setAutor(Autor autor)           { this.autor = autor; }
    public Editorial getEditorial()             {   return editorial;   }
    public void setEditorial(Editorial editorial) { this.editorial = editorial; }
    public Empleado getEmpleado()               { return empleado;    }
    public void setEmpleado(Empleado empleado)  {    this.empleado = empleado;   }
    public int getNumpagina()                   { return numpagina;    }
    public void setNumpagina(int numpagina)     { this.numpagina = numpagina;    }
    public int getIdtipolibro()                 {   return idtipolibro; }
    public void setIdtipolibro(int idtipolibro) {   this.idtipolibro = idtipolibro; }
    public TipoLibro getTipolibros()            {  return tipolibros;  }
    public void setTipolibros(TipoLibro tipolibros) {   this.tipolibros = tipolibros;   }
    
    
    
    public Object [] RegistroLibros(int num){
          if(autor.getPorcentajeDescuento() >= editorial.getPorcentajeDescuento() && autor.getPorcentajeDescuento() >= tipolibros.getPorcentajeDescuento()){
            descuento = autor.getPorcentajeDescuento();
        } else if(editorial.getPorcentajeDescuento() >= autor.getPorcentajeDescuento() && editorial.getPorcentajeDescuento() >= tipolibros.getPorcentajeDescuento()){
            descuento = editorial.getPorcentajeDescuento();
        } else if (tipolibros.getPorcentajeDescuento() >= autor.getPorcentajeDescuento() && tipolibros.getPorcentajeDescuento() >= editorial.getPorcentajeDescuento()){
            descuento = tipolibros.getPorcentajeDescuento();
        }   
         
        if(descuento>0){
            prueba ="SI";
        }else{
            prueba ="NO";
        }  
          
          
        Object[] fila = {idlibro,titulo,autor.getNombre(),editorial.getNombre(),tipolibros.getNombreTipo(),precio,numpagina,stock,prueba,descuento,idempleado};
        return fila;
    }
    
    public Object [] RegistroLibrosVenta(int num){
        if(autor.getPorcentajeDescuento() >= editorial.getPorcentajeDescuento() && autor.getPorcentajeDescuento() >= tipolibros.getPorcentajeDescuento()){
            descuento = autor.getPorcentajeDescuento();
        } else if(editorial.getPorcentajeDescuento() >= autor.getPorcentajeDescuento() && editorial.getPorcentajeDescuento() >= tipolibros.getPorcentajeDescuento()){
            descuento = editorial.getPorcentajeDescuento();
        } else if (tipolibros.getPorcentajeDescuento() >= autor.getPorcentajeDescuento() && tipolibros.getPorcentajeDescuento() >= editorial.getPorcentajeDescuento()){
            descuento = tipolibros.getPorcentajeDescuento();
        }
        
        Object[] fila = {idlibro,titulo,autor.getNombre(),editorial.getNombre(),tipolibros.getNombreTipo(),precio,numpagina,stock,descuento};
        return fila;
    }
    
    public Object [] RegistroLibrosCarrito(int id,String titulo,String autor, String editorial, String tipo,String numpagina,double precio ,int cantidad,double descuentopppp,double total){
        Object[] fila = {id,titulo,autor,editorial,tipo,numpagina,precio,cantidad,descuentopppp,total};
        return fila;
    }
}
