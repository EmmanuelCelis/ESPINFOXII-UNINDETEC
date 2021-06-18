package Modelos;

import java.util.ArrayList;

public class Nave extends  Coordenada{
    public Coordenada cor1 = new Coordenada();
    public Coordenada cor2 = new Coordenada();
    ArrayList balas = new ArrayList();
    public Nave()
    {
        super();
        
        this.cor1.setX(0);
        this.cor1.setY(0);
        
        this.cor2.setX(0);
        this.cor2.setY(0);
    }
    public Nave(Coordenada a, Coordenada b, Coordenada c)
    {
        super(a.getX(),a.getY());
        
        this.cor1.setX(b.getX());
        this.cor1.setY(b.getY());
        
        this.cor2.setX(c.getX());
        this.cor2.setY(c.getY());
    }
    
    public Nave(Nave c)
    {
        super(c.getX(),c.getY());
        
        this.cor1.setX(c.getX());
        this.cor1.setY(c.getY());
        
        this.cor2.setX(c.getX());
        this.cor2.setY(c.getY());
    }
    
    public void SetVertice(Coordenada NvoVertice, int lado)
    {
       if(lado == 1)
       {
          this.setX(NvoVertice.getX());
          this.setY(NvoVertice.getY());
       }
       if(lado == 2)
       {
          this.cor1.setX(NvoVertice.getX());
          this.cor1.setY(NvoVertice.getY());
       }
       if(lado == 3)
       {
          this.cor2.setX(NvoVertice.getX());
          this.cor2.setY(NvoVertice.getY()); 
       }
    }
    
    public void mover(Coordenada NvaCor){
        SetVertice((this.Suma(NvaCor)),1);
        SetVertice((this.cor1.Suma(NvaCor)),2);
        SetVertice((this.cor2.Suma(NvaCor)),3);
        
    }
}

