import java.awt.*;
import java.awt.event.MouseListener;
import javax.swing.*;

public class Work extends JPanel {
    public static Graphics gs;
    public  static String[][] array = {
            {"A","B","C","B","A"},
            {"B","B","C","B","B"},
            {"C","C","C","C","C"},
            {"B","B","C","B","B"},
            {"A","B","C","B","A"}
    };
    public  static String[][] base = {
            {"A","B","C","B","A"},
            {"B","B","C","B","B"},
            {"C","C","C","C","C"},
            {"B","B","C","B","B"},
            {"A","B","C","B","A"}
    };
    static int padding = 25;
    static JFrame frame;

    /**
     * Metod koito risuva
     * @param g
     */
    public  void paint(Graphics g){
        gs = g;
        AddElements(g, Application.array_model, false);
    }

    /**
     * Dobavq kvadratchetata
     * @param g
     * @param array_mode
     * @param modes
     */
    public  static void AddElements(Graphics g, Scheme[][] array_mode, boolean modes) {
        if (modes)
        {
            frame.repaint();
        }
        int x = 0 ;
        int y = 0;
        for(int i = 0; i < 5; i++){
            for(int j = 0; j < 5; j++){

                if (array[i][j] == "A")
                {
                    g.setColor(Color.red);
                }
                else if (array[i][j] == "B") {
                    if (Application.array_model[i][j].avatar != null) {
                        g.setColor(Color.gray);
                    } else {
                        g.setColor(Color.lightGray);
                    }
                }
                else if (array[i][j] == "C")
                {
                    g.setColor(Color.white);
                }
                else
                {
                    g.setColor(Color.orange);
                }
                g.fillRect(x, y, 100, 100);

                g.setColor(Color.black);
                g.drawRect(x, y, 100, 100);
                Scheme model = Application.array_model[i][j];
                model.start_y =y;
                model.start_x =x;
                model.end_x =x + 100;
                model.end_y = y+100;
                Application.array_model[i][j] = model;
                AddAvatars(g , Application.array_model , x, y , i , j) ;
                AddCenterElement(g,x,y, i , j );
                x+=100;

            }
            y+= 100;
            x = 0 ;
        }
    }

    public static void NullColor() {
        for (int m = 0 ; m < 5 ; m++)
        {
            for (int  mk = 0 ; mk < 5 ; mk++)
            {
                array[m][mk] = base[m][mk];
            }
        }
    }

    /**
     * Dobavq krygcheto v sredata na dyskata
     * @param g
     * @param x
     * @param y
     * @param i
     * @param j
     */
    private  static void AddCenterElement(Graphics g , int x , int y , int i , int j) {
        if (i == j && i == 2) {
            g.setColor(Color.BLACK);
            g.fillOval(x + padding, y + padding, 50, 50);
            g.setColor(Color.gray);
            g.drawOval(x + padding, y + padding, 50, 50);
        }
    }

    /**
     * Pribavq figurite vyrhu dyskata
     * @param g
     * @param array_model
     * @param x
     * @param y
     * @param i
     * @param j
     */
    private static void AddAvatars(Graphics g, Scheme[][] array_model, int x , int  y , int i , int j) {
        if (array_model[i][j].avatar != null)
        {
            if (array_model[i][j].avatar.type == 2)
            {
                g.setColor(array_model[i][j].avatar.color);
                g.fillOval(x+padding, y+padding, 50, 50);
                g.setColor(array_model[i][j].avatar.border);
                g.drawOval(x+padding, y+padding , 50, 50);
            }
            else
            {
                g.setColor(array_model[i][j].avatar.color);
                g.fillRect(x+padding, y+padding, 50, 50);
                g.setColor(array_model[i][j].avatar.border);
                g.drawRect(x+padding, y+padding , 50, 50);
            }
        }
    }

    private static void ChangeCoordinates(int x, int y, int i, int j) {

    }

    /**
     * Syzdava panela za risuvane
     */
    public static void Create(){
        frame = new JFrame();
        frame.setSize(600,600);
        frame.getContentPane().add(new Work());
        frame.setLocationRelativeTo(null);
        frame.setBackground(Color.black);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        Component mouseClick = new Mouse()  ;
        frame.addMouseListener((MouseListener) mouseClick);
    }


}


