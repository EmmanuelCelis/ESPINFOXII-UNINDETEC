//SECRETARÍA DE MARINA
//CESNAV - ESPINFO XIII
package Ejecuciones;
import Modelos.*; //importa todas clases del paquete modelos
import java.awt.*;
import java.util.*;



public class main {
    public static int Aleatorio(int Max, int Min)
        {
             return (int) (Math.random()*(Max-Min));
        }
    public static void main(String[] args) {
        Ventana nuestraventana = new Ventana("Juego de guerra Informatica XIII");
        ArrayList ArregloDeObjetos = new ArrayList();
        //Coordenada cor1 = new Coordenada(250,250);
        //Coordenada cor2 = new Coordenada(350,300);
       // RectanguloGrafico rectangulo = new RectanguloGrafico(cor1,30,30,Color.blue);
        //CirculoGrafico circulo = new CirculoGrafico(cor2,15,Color.yellow);
        
        Coordenada cor3 = new Coordenada(475,500);
        Coordenada cor4 = new Coordenada(425,575);
        Coordenada cor5 = new Coordenada(525,575);
        
        NaveGrafico nave = new NaveGrafico(cor3,cor4,cor5,Color.black);
        
        int rango = Aleatorio(800,50);
        Coordenada Salida = new Coordenada(rango,0);
        RectanguloGrafico Asteroide1 = new RectanguloGrafico(Salida, 25, 25, Color.yellow);
        
        int rango1 = Aleatorio(800,50);
        Coordenada Salida1 = new Coordenada(rango1,0);
        RectanguloGrafico Asteroide2 = new RectanguloGrafico(Salida1, 25, 25, Color.yellow);

        int rango2 = Aleatorio(800,50);
        Coordenada Salida2 = new Coordenada(rango2,0);
        RectanguloGrafico Asteroide3 = new RectanguloGrafico(Salida2, 25, 25, Color.yellow);

        int rango3 = Aleatorio(800,50);
        Coordenada Salida3 = new Coordenada(rango3,0);
        RectanguloGrafico Asteroide4 = new RectanguloGrafico(Salida3, 25, 25, Color.yellow);

        int rango4 = Aleatorio(800,50);
        Coordenada Salida4 = new Coordenada(rango4,0);
        RectanguloGrafico Asteroide5 = new RectanguloGrafico(Salida4, 25, 25, Color.yellow);
        
        ArregloDeObjetos.add(Asteroide1);
        ArregloDeObjetos.add(Asteroide2);
        ArregloDeObjetos.add(Asteroide3);
        ArregloDeObjetos.add(Asteroide4);
        ArregloDeObjetos.add(Asteroide5);
        
        //ArregloDeObjetos.add(rectangulo);
        //ArregloDeObjetos.add(circulo);
        ArregloDeObjetos.add(nave);
        PanelFG nuestroPanel = new PanelFG(ArregloDeObjetos);
        
        nuestroPanel.refNave(nave);
        nuestroPanel.refAst(Asteroide1, Asteroide2, Asteroide3, Asteroide4, Asteroide5);
        nuestraventana.add(nuestroPanel);
        nuestraventana.setSize(800,600);
        nuestraventana.setVisible(true);
        nuestroPanel.iniciar();
        
    }
    
}
