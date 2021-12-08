package enduroatari;

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JComponent;

public class BackgroundDraw extends JComponent
{

    public int x0, y0, x1, y1, l = 0, rodas = 0, px = 0;
    public int speed, posY, pt = 0;

    public BackgroundDraw()
    {
        this.speed = 5;
    }

    public BackgroundDraw(int speed)
    {
        this.speed = speed;
    }

    public void setSpeed(int speed)
    {
        this.speed = speed;
    }

    public int getSpeed(int speed)
    {
        return speed;
    }

    public void paint(Graphics g) //Graphics possuii vários métodos de desenho
    {
        super.paintComponent(g);

        l = 0;
        /*Desenhando a grama*/
        g.setColor(new Color(0, 68, 0));
        g.fillRect(40, 212, 860, 333);

        /*Desenhando o céu*/
        g.setColor(new Color(24, 26, 167));
        g.fillRect(40, 47, 860, 165);

        /*Desenhando o placar*/
        g.setColor(new Color(167, 26, 26));
        g.fillRect(272, 564, 368, 97);

        /*Desenhando o placar*/
        g.setColor(new Color(195, 144, 61));
        g.fillRect(318, 573, 231+45, 30); // pontuação
        g.fillRect(318, 621, 47, 30); // quadrado
        g.fillRect(410, 621, 185, 30); // carros

        g.setColor(Color.BLACK);
        g.fillRect(416, 624, 6, 11);
        g.fillRect(416, 637, 6, 11);
        g.fillRect(445, 624, 6, 11);
        g.fillRect(445, 637, 6, 11);

        g.fillRect(428, 627, 12, 20);

        g.fillRect(422, 627, 6, 4);
        g.fillRect(422, 640, 6, 4);
        g.fillRect(439, 627, 6, 4);
        g.fillRect(439, 640, 6, 4);

        /*Desenhando o lado esquerdo da pista*/
        g.setColor(new Color(192, 192, 192));
        x0 = 215;
        y0 = 536;
        x1 = 329;
        y1 = 410;
        while (l < 4)
        {
            g.drawLine(x0++, y0, x1++, y1);
            l++;
        }
        l = 0;
        x0 = 215;
        y0 = 536;
        x1 = 222;
        y1 = 543;
        while (l < 4)
        {
            g.drawLine(x0++, y0, x1++, y1);
            l++;
        }
        g.setColor(new Color(134, 142, 142));
        l = 0;
        x0 = 330;
        y0 = 409;
        x1 = 375;
        y1 = 359;
        while (l < 4)
        {
            g.drawLine(x0++, y0, x1++, y1);
            l++;
        }
        g.setColor(new Color(111, 111, 111));
        l = 0;
        x0 = 376;
        y0 = 358;
        x1 = 410;
        y1 = 320;

        while (l < 4)
        {
            g.drawLine(x0++, y0, x1++, y1);
            l++;
        }
        g.setColor(new Color(74, 74, 74));
        l = 0;
        x0 = 411;
        y0 = 319;
        x1 = 500;
        y1 = 220;

        while (l < 4)
        {
            g.drawLine(x0++, y0, x1++, y1);
            l++;
        }
        /*Desenhando o lado direito da pista*/
        g.setColor(new Color(192, 192, 192));
        l = 0;
        x0 = 790;
        y0 = 536;
        x1 = 676;
        y1 = 413;
        while (l < 4)
        {
            g.drawLine(x0++, y0, x1++, y1);
            l++;
        }
        l = 0;
        x0 = 790;
        y0 = 536;
        x1 = 783;
        y1 = 543;
        while (l < 4)
        {
            g.drawLine(x0++, y0, x1++, y1);
            l++;
        }

        g.setColor(new Color(134, 142, 142));
        l = 0;
        x0 = 675;
        y0 = 412;
        x1 = 624;
        y1 = 356;
        while (l < 4)
        {
            g.drawLine(x0++, y0, x1++, y1);
            l++;
        }

        g.setColor(new Color(111, 111, 111));
        l = 0;
        x0 = 623;
        y0 = 355;
        x1 = 589;
        y1 = 317;

        while (l < 4)
        {
            g.drawLine(x0++, y0, x1++, y1);
            l++;
        }

        g.setColor(new Color(74, 74, 74));
        l = 0;
        x0 = 588;
        y0 = 316;
        x1 = 501;
        y1 = 220;

        while (l < 4)
        {
            g.drawLine(x0++, y0, x1++, y1);
            l++;
        }
        
    }
}
