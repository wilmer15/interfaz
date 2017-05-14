/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Memoria;
import javax.swing.JOptionPane;
import java.awt.*;
import java.awt.Color;
import javax.swing.*;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Punto1 extends JFrame {
    public Punto1(){
    add(new NewPanel());
}
/**
 *
 * @author Diego/**
 *
 * @author Diego
 */


    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
      Punto1 frame= new Punto1();
      frame.setTitle("TestPaintComponent");
      frame.setSize(900,1024);
      frame.setLocationRelativeTo(null);
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.setVisible(true);    
    }  
}
class NewPanel extends JPanel implements ActionListener, MouseListener{
    private Timer time;
    private int posiciones[] = new int[13];
    private int x;
    private int y;
    private int secuencia =0;
    int x1=100;
    int y1=10;
    int temp=0;
    int aux=20;
    int aux2=0;
    int cont=0;
    int intentos=0;
     Rectangle Carro=this.getBounds();
     Rectangle obstaculo=new Rectangle(200,200,10,10);
    public NewPanel(){
        
        this.time=new Timer(300, this);
        this.time.start();
        this.x = 20;
        this.addMouseListener(this);
        JOptionPane.showMessageDialog(null,"Por favor oprima dos posiciones  \n Y encuentra las Parejas");
        for(int i=0;i<13;i++){
            posiciones[i]=-1;
        }
        
    }
    
    @Override
    protected void paintComponent(Graphics g){
       
       super.paintComponent(g);
       Image fondo = loadImage("fondo.png");
       Image Blanco = loadImage("blanco_1.jpg");
       g.drawImage(fondo,0,0,null);
       Image Licor = loadImage("dasfa.gif");    
       
       g.drawImage(Licor,100,10,100+141,10+215,0, 0,141, 256, this);
       g.drawImage(Licor,241,10,241+141,10+215,0, 0, 141, 256, this);
       g.drawImage(Licor,382,10,382+141,10+215,0, 0,148, 256, this);
       g.drawImage(Licor,523,10,523+141,10+215,0, 0,148, 256, this);
       
       g.drawImage(Licor,100,10+215,100+141,440,0, 0,141, 256, this);
       g.drawImage(Licor,241,10+215,241+141,440,0, 0, 141, 256, this);
       g.drawImage(Licor,382,10+215,382+141,440,0, 0,148, 256, this);
       g.drawImage(Licor,523,10+215,523+141,440,0, 0,148, 256, this);

       g.drawImage(Licor,100,440,100+141,655,0, 0,141, 256, this);
       g.drawImage(Licor,241,440,241+141,655,0, 0, 141, 256, this);
       g.drawImage(Licor,382,440,382+141,655,0, 0,148, 256, this);
       g.drawImage(Licor,523,440,523+141,655,0, 0,148, 256, this);
       
       int contador=0;      
       while(!(posiciones[contador]==-1)){
          switch(posiciones[contador++]){
             case 0:
                g.drawImage(Blanco,100,10, this);
             break;
             case 1:
                g.drawImage(Licor,241,10,241+141,10+215, 2*141,0,2*141 + 141 ,256, this);
             break;
             case 2:
               g.drawImage(Licor,382,10,382+141,10+215, 3*141,0,3*141 + 141 ,256, this);
             break;
                 
             case 3:
               g.drawImage(Blanco,523,10, this);
             break;  
             case 4:
               g.drawImage(Licor,100,225,100+141,225+215, 4*141,0,4*141 + 141 ,256, this);
             break; 
             case 5:
               g.drawImage(Licor,241,225,241+141,225+215, 5*141,0,5*141 + 141 ,256, this);
             break;
             case 6:
                 g.drawImage(Licor,382,225,382+141,225+215, 3*141,0,3*141 + 141 ,256, this);
             break; 
             case 7:
                g.drawImage(Licor,523,225,523+141,225+215, 2*141,0,2*141 + 141 ,256, this);
             break; 
             case 8:
               g.drawImage(Licor,100,440,100+141,440+215, 5*141,0,5*141 + 141 ,256, this);
             break; 
             case 9:
               g.drawImage(Blanco,241,440, this);
             break;
             case 10:
                 g.drawImage(Licor,382,440,382+141,440+215, 4*141,0,4*141 + 141 ,256, this);
             break;
              case 11:
               g.drawImage(Blanco,523,440, this);
             break;  
          }
          System.out.println(aux);
         }
    }
    
    @Override
    public Rectangle getBounds(){
        switch(aux){
             case 0:
              x1=100;
              y1=10;
            break;
            case 1:
              x1=241;
              y1=10;
            break;
            case 2:
              x1=382;
              y1=10;
            break;
            case 3:
              x1=523;
              y1=10;
            break;
             case 4:
              x1=100;
              y1=225;
            break;
            case 5:
              x1=241;
              y1=225;
            break;
            case 6:
              x1=382;
              y1=225;
            break;
             case 7:
              x1=523;
              y1=225;
            break;
              case 8:
              x1=100;
              y1=440;
            break;
             case 9:
              x1=241;
              y1=440;
            break;
            case 10:
              x1=382;
              y1=440;
            break;
            case 11:
              x1=523;
              y1=440;
            break;
            
            default:   
        }
        return new Rectangle(x1, y1, 141, 256);
    }

    
    @Override
    public void actionPerformed(ActionEvent e) {
        x+=20;   
        repaint();
    }
    
    
 public void checkCollisions(){
     Rectangle rCicle= Carro.getBounds();
     Rectangle rRect= obstaculo.getBounds();
     if(rCicle.intersects(rRect)){
         System.out.println("Colision");
         time.stop();
     }
 }
 
    @Override
    public void mouseClicked(MouseEvent e) {
        Point mp= e.getPoint();
        aux=0;
        while(!(getBounds().contains(mp))){ 
             mp= e.getPoint();
             this.aux++;
        }
        posiciones[cont]=aux;
        cont++; 
        temp++;
        
        
        
         int c=cont-2;
         int d=cont-1;
         
         if((c +1) >=1){
             if(posiciones[c]==1&&posiciones[d]==7){
               JOptionPane.showMessageDialog(null,"Felicitaciones Acerto + 2 Coronas");
               aux2+=2;
             }
             if(posiciones[c]==2&&posiciones[d]==6){
              JOptionPane.showMessageDialog(null,"Felicitaciones Acerto + 2 Botellas de Whisky");
              aux2+=2;
             }
             if(posiciones[c]==4&&posiciones[d]==10){
               JOptionPane.showMessageDialog(null,"Felicitaciones Acerto + 2 Botellas de Vodka");
               aux2+=2;
             }
             if(posiciones[c]==5&&posiciones[d]==8){
               JOptionPane.showMessageDialog(null,"Felicitaciones Acerto + 2 Botellas de Ginebra");
               aux2+=2;
             }    
             
             
             if(posiciones[c]==7&&posiciones[d]==1){
               JOptionPane.showMessageDialog(null,"Felicitaciones Acerto + 2 Coronas");
               aux2+=2;
             }
             if(posiciones[c]==6&&posiciones[d]==2){
              JOptionPane.showMessageDialog(null,"Felicitaciones Acerto + 2 Botellas de Whisky");
              aux2+=2;
             }
             if(posiciones[c]==10&&posiciones[d]==4){
               JOptionPane.showMessageDialog(null,"Felicitaciones Acerto + 2 Botellas de Vodka");
               aux2+=2;
             }
             if(posiciones[c]==8&&posiciones[d]==5){
               JOptionPane.showMessageDialog(null,"Felicitaciones Acerto + 2 Botellas de Ginebra");
               aux2+=2;
             }  
        } 
         if(temp==2){
            for(int i=aux2;i<13;i++){
                posiciones[i]=-1;
            }
            temp=0;
            cont=aux2;
            intentos++;
        }
        if(aux2==8){
            JOptionPane.showMessageDialog(null,"Ha ganado en este numero de Intentos: " + intentos);
            intentos=0;
            temp=0;
            cont=0;
            aux2=0;
            for(int i=0;i<13;i++){
                posiciones[i]=-1;
            }
        }
        System.out.println("click");
    }

    @Override
    public void mousePressed(MouseEvent e) {
        
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        
    }

    @Override
    public void mouseExited(MouseEvent e) {
        
    }
    public Image loadImage(String imageName){
        ImageIcon ii = new ImageIcon(imageName);
        Image image = ii.getImage();
        return image;
    }
    
}