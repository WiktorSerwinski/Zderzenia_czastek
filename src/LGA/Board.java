package LGA;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Random;
import static LGA.Play.play;
import static javax.swing.WindowConstants.EXIT_ON_CLOSE;

public class Board extends Thread
{
    JFrame mainFrame;
    Container container;
    int cols=20;
    int rows=20;
    public static ArrayList<Czastka> list = new ArrayList<Czastka>();
    public JButton[][] board=new JButton[rows][cols];
    JButton play= new JButton();
    JLabel plej=new JLabel("Play");
    JLabel klin =new JLabel("Clean");
    JButton clean =new JButton();

    public Board()
    {
        mainFrame = new JFrame("LBM");
        mainFrame.setDefaultCloseOperation(EXIT_ON_CLOSE);
        mainFrame.setSize(800, 800);
        container = mainFrame.getContentPane();
        container.setLayout(new GridLayout(rows+1,cols));
        for(int i=0;i<rows;i++)
            for(int j=0;j<cols;j++)
            {
                board[i][j] =new JButton();
                container.add(board[i][j]);
                board[i][j].setBackground(Color.green);
                int finalI = i;
                int finalJ = j;
                board[i][j].addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e)
                    {
                        Random random=new Random();
                        char[] dir=new char[4];
                        dir[0]='l';
                        dir[1]='r';
                        dir[2]='u';
                        dir[3]='d';
                        list.add(new Czastka(finalI,finalJ,dir[random.nextInt(4)]));
                        board[finalI][finalJ].setBackground(Color.red);
                    }
                });
            }
        container.add(plej);
        container.add(play);

        play.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                start();

            }
        });
        container.add(klin);
        container.add(clean);
        clean.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                for(int i=0;i<rows;i++)
                    for(int j=0;j<cols;j++)
                    {
                        board[i][j].setBackground(Color.green);

                    }
                set_bounds();

            }
        });
        mainFrame.setResizable(false);
        mainFrame.setVisible(true);
        set_bounds();
    }


    public void set_bounds() {
        for (int i = 0; i < rows; i++) {
            board[0][i].setBackground(Color.red);//top
            board[rows - 1][i].setBackground(Color.red);//bottom
            board[i][0].setBackground(Color.red);//left
            board[i][cols - 1].setBackground(Color.red);//right
        }

    }

    public void run()
    {
        for(int i=0;i<10000;i++)
        {
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            play(rows,cols,board,list);
        }
    }

}