package enduroatari;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Polygon;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JComponent;
import javax.swing.JLabel;

public class MainDraw extends JComponent implements Runnable, ActionListener, KeyListener
{

    Random gerador = new Random();
    public JLabel Movimento;
    public BackgroundDraw bg = new BackgroundDraw();
    private Image car, carInvert, enemy, enemyInvert;
    public int moveX, moveY, posY = 0, posX = 0, i = 0, ePosY = 0, ePosX = 0, xMax = 95, yMax = 37, max = 0;
    public int score = 0, level = 1, cont = 10, tipo = 0, j = 0, k = 0, zoomP = 0, moveMountain = 0;
    public boolean flick = true, play = false, leftPress = false, rightPress = false, upPress = false, downPress = false;

    public MainDraw()
    {
        addKeyListener(this);
        setFocusable(true);
        setFocusTraversalKeysEnabled(false);
    }

    public void paint(Graphics g)
    {
        bg.paint(g); //desenhando o background
        posX = 438 + moveX; //posição X do principal 
        posY = 509 + moveY;// posição Y do principal

        xMax = 61 + max;
        yMax = max;

        ePosX = 454 + i + k; //posição X dos inimigos
        ePosY = 276 + i + j; //posição Y dos inimigos

        Carro(g);
        placar(g);
        Montanha(g);
    }
    

    public void placar(Graphics g) //COLOCAR UM DRAWSTRING PARA MOSTRAR O COMANDO DE START - SPACE/ RESTART - BACKSPACE
    {
        g.setColor(Color.BLACK);
        g.setFont(new Font("Press Start 2P", Font.BOLD, 25));
        g.drawString(String.valueOf(score), 322, 601);
        g.drawString(String.valueOf(level), 317, 650);
        g.drawString(String.valueOf(cont), 460, 650);

        g.setColor(Color.white);
        g.setFont(new Font("Press Start 2P", Font.PLAIN, 16)); //PARA USAR A FONTE É NECESSARIO INSTALÁ-LA. ESTA DENTRO DA PASTA
        g.drawString("Start: ENTER ", 690, 574);
        g.drawString("Restart: R ", 690, 604);

        if (!play)
        {
            g.setFont(new Font("Press Start 2P", Font.PLAIN, 36));
            g.drawString("PRESS START", 300, 312);
        } else
        {
            g.drawString(" ", 400, 312);
        }
    }

    public void Montanha(Graphics g) //ja foi
    {
        /*Desenhando as montanhas esquerda*/
        g.setColor(new Color(134, 134, 29));

        // Cria um polígono que será o nosso triângulo.  
        Polygon T1 = new Polygon();
        // Adiciona o primeiro ponto, o de cima.
        T1.addPoint(265 + moveMountain, 100);
        // Adiciona o segundo ponto, o do canto inferior esquerdo  
        T1.addPoint(203 + moveMountain, 212);
        // Adiciona o segundo ponto, o do canto inferior direito          
        T1.addPoint(315 + moveMountain, 212);
        // Desenha o triângulo  
        g.fillPolygon(T1);

        // Cria um polígono que será o nosso triângulo.  
        Polygon T2 = new Polygon();
        // Adiciona o primeiro ponto, o de cima.  
        T2.addPoint(315 + moveMountain, 125);
        // Adiciona o segundo ponto, o do canto inferior esquerdo  
        T2.addPoint(265 + moveMountain, 212);
        // Adiciona o segundo ponto, o do canto inferior direito          
        T2.addPoint(365 + moveMountain, 212);
        // Desenha o triângulo  
        g.fillPolygon(T2);

        /*Desenhando a montanha direita*/
        // Cria um polígono que será o nosso triângulo.  
        Polygon T3 = new Polygon();
        // Adiciona o primeiro ponto, o de cima.  
        T3.addPoint(668 + moveMountain, 180);
        // Adiciona o segundo ponto, o do canto inferior esquerdo  
        T3.addPoint(618 + moveMountain, 212);
        // Adiciona o segundo ponto, o do canto inferior direito          
        T3.addPoint(718 + moveMountain, 212);
        // Desenha o triângulo  
        g.fillPolygon(T3);
    }
    public void Carro(Graphics g)
    {
        if (flick == true)
        {
            switch (tipo)
            {
                case 0://CARRO INIMIGO TIPO 1
                    enemy = new ImageIcon("enemy.png").getImage();
                    g.drawImage(enemy, ePosX, ePosY, xMax, yMax, Movimento);
                    i++;
                    break;
                case 1://CARRO INIMIGO TIPO 2

                    enemy = new ImageIcon("enemy2.png").getImage();
                    g.drawImage(enemy, ePosX, ePosY, xMax, yMax, Movimento);
                    j += 2;
                    break;
                case 2://CARRO INIMIGO TIPO 3
                    enemy = new ImageIcon("enemy3.png").getImage();
                    g.drawImage(enemy, ePosX, ePosY, xMax, yMax, Movimento);
                    k--;
                    j += 2;
                    break;
            }
            //CARRO PRINCIPAL
            car = new ImageIcon("carroEnduro2.png").getImage();
            g.drawImage(car, posX, posY, 95 + zoomP, 37 + zoomP, Movimento);
        } else
        {
            switch (tipo)
            {
                case 0://CARRO INIMIGO TIPO 1
                    enemyInvert = new ImageIcon("enemyInvert.png").getImage();
                    g.drawImage(enemyInvert, ePosX, ePosY, xMax, yMax, Movimento);
                    i++;
                    break;
                case 1://CARRO INIMIGO TIPO 2
                    enemy = new ImageIcon("enemyInvert2.png").getImage();
                    g.drawImage(enemy, ePosX, ePosY, xMax, yMax, Movimento);
                    break;
                case 2://CARRO INIMIGO TIPO 3
                    enemy = new ImageIcon("enemyInvert3.png").getImage();
                    g.drawImage(enemy, ePosX, ePosY, xMax, yMax, Movimento);
                    break;
            }
            //CARRO PRINCIPAL
            carInvert = new ImageIcon("carroEnduro.png").getImage();
            g.drawImage(carInvert, posX, posY, 95, 37, Movimento);
        }
    }

    public void actionPerformed(ActionEvent e)
    {
        repaint();
    }

    public void keyPressed(KeyEvent e)
    {

        repaint();
        int code = e.getKeyCode();
        if (code == KeyEvent.VK_ENTER) //COMEÇA O JOGO
        {
            if (play == false)
            {
                new Thread(this).start();
                play = true;
            }
        }
        if (code == KeyEvent.VK_R) //RESETA O JOGO
        {
            play = false;
        }
        if (code == KeyEvent.VK_RIGHT)//DIREITA
        {
            rightPress = true;
        }

        if (e.getKeyCode() == KeyEvent.VK_LEFT)//ESQUERDA
        {
            leftPress = true;
        }

        if (e.getKeyCode() == KeyEvent.VK_SPACE) //ACELERA, OU SEJA, CIMA
        {
            upPress = true;
        }
        if (e.getKeyCode() == KeyEvent.VK_DOWN)
        {
            downPress = true;
        }
    }

    public void keyTyped(KeyEvent e)
    {
    }

    public void keyReleased(KeyEvent e)
    {
        int code = e.getKeyCode();
        if (code == KeyEvent.VK_RIGHT)//DIREITA
        {
            rightPress = false;
        }
        if (code == KeyEvent.VK_LEFT)
        {
            leftPress = false;
        }
        if (code == KeyEvent.VK_SPACE)
        {
            upPress = false;
        }
        if (code == KeyEvent.VK_DOWN)
        {
            downPress = false;
        }
    }

    @Override
    public void run()
    {
        while (play)
        {
            try
            {
                //SETAS
                if (rightPress)
                {
                    if (posY >= (316 * (posX + 95) - 94736) / 289)
                    {
                        moveMountain--;
                        moveX += 4;
                    }
                }
                if (leftPress)
                {
                    if (posY > ((-316 * posX) + 220700) / 285)
                    {
                        moveMountain++;
                        moveX -= 4;
                    }
                }
                if (upPress)
                {
                    if ((posY > ((-316 * posX) + 220700) / 285) && (posY >= (316 * (posX + 95) - 94736) / 289))
                    {
                        moveY -= 4;
                    }
                }
                if (downPress)
                {
                    if (posY <= this.getHeight() - 161)
                    {
                        moveY += 4;
                    }
                }

                //CARROS DESCENDO
                if (ePosY > this.getHeight() - 161)
                {
                    k = 0;
                    j = 0;
                    i = 0;
                    ePosY = 200 + i;
                    max = 0;
                    xMax = 58 + max;
                    yMax = max;
                    cont--;

                    if (cont == 0)//PASSA DE NÍVEL
                    {
                        level++;
                        cont = 10 * level;
                    }
                } else
                {
                    if (ePosY == this.getHeight() - 161)
                    {
                        tipo = gerador.nextInt(3);
                    }
                }
                flick = !flick;
                Thread.sleep(15);
                repaint();

                if (xMax < 95)//LIMITE DOS CARROS
                {
                    max++;
                }

                score++;//Pontuação

                if ((posX < ePosX + 97 && (posX + 97) > ePosX) && (posY < (ePosY + 37) && posY + 37 > ePosY))
                {
                    play = false; // terminou o jogo
                }

            } catch (InterruptedException ex)
            {
                Logger.getLogger(MainDraw.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        if (!play) //RESETA TODO O JOGO
        {
            moveX = moveY = 0;
            k = 0;
            j = 0;
            i = 0;
            ePosY = 200 + i;
            max = 0;
            xMax = 58 + max;
            yMax = max;
            cont = 10;
            score = 0;
            level = 1;
            posX = 438 + moveX;
            posY = 509 + moveY;
        }
    }
}
