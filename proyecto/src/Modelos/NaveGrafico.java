package Modelos;

//import java.awt.Color;
//import java.awt.Graphics;
//import java.awt.Polygon;
import java.awt.*;


public class NaveGrafico extends Nave implements Dibujable{
    Color color;
    
    public NaveGrafico(Coordenada a, Coordenada b, Coordenada c, Color uncolor)
    {
      super(a,b,c);
      this.color = uncolor;
    }
    @Override
    public void dibujar(Graphics dw) {
        dw.setColor(color);
        int x[] = {(int)this.getX(),(int)cor1.getX(),(int)cor2.getX()};
        int y[] = {(int)this.getY(),(int)cor1.getY(),(int)cor2.getY()};
        Polygon p = new Polygon(x,y,3);
        
        dw.fillPolygon(p);
    }

    
    public void pintar(Graphics dw, Color uncolor) {
        dw.setColor(uncolor);
        int x[] = {(int)this.getX(),(int)cor1.getX(),(int)cor2.getX()};
        int y[] = {(int)this.getY(),(int)cor1.getY(),(int)cor2.getY()};
   
        Polygon p = new Polygon(x,y,3);
        
        dw.fillPolygon(p);
    }
    public CirculoGrafico Bala()
    {
        Coordenada salida = new Coordenada(this.getX(),this.getY());
        CirculoGrafico bala = new CirculoGrafico(salida, 10, color.RED);
        return bala;
    }
    
    public void Ciclo()
    {
        for(int i=0;i<this.balas.size();i++)
        {
            CirculoGrafico y = (CirculoGrafico)this.balas.get(i);
            float x = y.getY();
            y.setY(x -= 5);
        }
    }
   
}
