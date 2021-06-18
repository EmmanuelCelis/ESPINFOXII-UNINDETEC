/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelos;
import static Ejecuciones.main.Aleatorio;
import java.awt.*;//todo librerias awt
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import javax.swing.JPanel;


/**
 *
 * @author Administrador
 */

public class PanelFG extends JPanel implements KeyListener{
    
    ArrayList v;
    ArrayList ast =new ArrayList();
    NaveGrafico nave;
    Coordenada movimientoIzq = new Coordenada(-25,0);
    Coordenada movimientoDer = new Coordenada(25,0);
    Coordenada movimientoUp = new Coordenada(0,-25);
    Coordenada movimientoDown = new Coordenada(0,25);
    Coordenada movimientoNulo = new Coordenada(0,0);
    
    int ContadorAsteroides = 5;
    
    public PanelFG(ArrayList vectordeO)
    {
        this.v = vectordeO;
        this.addKeyListener(this);
        setFocusable(true);
    }
    
    @Override
    public void paint(Graphics g)
    {
        Dimension d = getSize();
        Image Imagen = createImage(d.width,d.height);
        Graphics buff = Imagen.getGraphics();
        
        Dibujable dib;
        for (int i=0; i<v.size(); i++)
        {
            dib = (Dibujable)v.get(i);
            dib.dibujar(buff);
        }
      g.drawImage(Imagen, 0, 0,null);
      
    }
    
    public void update(Graphics g)
    {
        paint(g);
    }

    @Override
    public void keyTyped(KeyEvent ke) {}

    @Override
    public void keyPressed(KeyEvent e) {
        int tecla = e.getKeyCode();
        if (tecla == KeyEvent.VK_UP)
        {
            
            this.nave.mover(movimientoUp);
            
        }
        if (tecla == KeyEvent.VK_DOWN)
        {
            
            this.nave.mover(movimientoDown);
            
        }
        if (tecla == KeyEvent.VK_LEFT)
        {
            
            this.nave.mover(movimientoIzq);
            
        }
        if (tecla == KeyEvent.VK_RIGHT)
        {
           
           this.nave.mover(movimientoDer);
           
        }
        
        if (tecla == KeyEvent.VK_Q)
        {
            CirculoGrafico bala = nave.Bala();
            nave.balas.add(bala);
            v.add(bala);
        }
   }

    @Override
    public void keyReleased(KeyEvent e) {
        int tecla = e.getKeyCode();
        if (tecla == KeyEvent.VK_LEFT)
        {
            
            this.nave.mover(movimientoNulo);
           
        }
        if (tecla == KeyEvent.VK_RIGHT)
        {
            
            this.nave.mover(movimientoNulo);
            
        }
        if (tecla == KeyEvent.VK_UP)
        {
            
            this.nave.mover(movimientoNulo);
            
        }
        if (tecla == KeyEvent.VK_DOWN)
        {
            
            this.nave.mover(movimientoNulo);
            
        }
          }
    public  void refNave(NaveGrafico n)
    {
        this.nave = n;
    }
    public void refAst(RectanguloGrafico a,RectanguloGrafico b,
            RectanguloGrafico c,RectanguloGrafico d,
            RectanguloGrafico e)
    {
      ast.add(a);
      ast.add(b);
      ast.add(c);
      ast.add(d);
      ast.add(e);
    }
    public void Colision()
    {
        int i,j;
        for(i=0;i<nave.balas.size();i++)
        {
            CirculoGrafico bala = (CirculoGrafico) nave.balas.get(i);
        for(j=0;j<ast.size();j++)
        {
            RectanguloGrafico aste = (RectanguloGrafico) ast.get(j);
            Coordenada Corbala = new Coordenada(bala.getX(),bala.getY());
            Coordenada Derecha = new Coordenada(aste.getX()+15,aste.getY());
            Coordenada Izquierda = new Coordenada(aste.getX()-15,aste.getY());
            Coordenada Medio = new Coordenada(aste.getX(),aste.getY());
            
            if(Corbala.getX() > Izquierda.getX() && Corbala.getX() < Derecha.getX() && Corbala.getY() < Medio.getY())
            {
                aste.pintar(Color.white);
                bala.pintar(Color.white);
            }
        }
        }
    }
    public void iniciar()
    {
        while (true) {
            try {
                if(!nave.balas.isEmpty())
                {
                    nave.Ciclo();
                }
                int i;
                for (i=0;i<ast.size();i++)
                {
                    RectanguloGrafico rect = (RectanguloGrafico) ast.get(i);
                    rect.ciclo();
                if (rect.getY() > 525)
                    {
                    int rango = Aleatorio(800,50);
                    rect.setY(0);
                    rect.setX(rango);
                
                    }
                }
                
                Colision();
                
                Thread.sleep(50);
                    
            } catch (InterruptedException err)
            {System.out.println(err);
            }
            repaint();
        }
    }
  
}
