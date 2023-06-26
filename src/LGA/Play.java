package LGA;
import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class Play
{
    public static void play(int rows, int cols, JButton[][] board, ArrayList<Czastka> list)
    {
        int size=list.size();//
     //    KlasaDlaWatekRun()  =new KlasaDlaWatek();
            for (int i = 0; i < size; i++) {
                int x = list.get(i).x;
                int y = list.get(i).y;
                int v = list.get(i).v;
                switch (list.get(i).dir) {
                    case 'l':
                        if(board[x][y - v].getBackground().equals(Color.green))
                        {
                        board[x][y - v].setBackground(Color.red);
                        board[x][y].setBackground(Color.green);
                        list.get(i).y-=v;
                        break;
                        }

                        for(int j=0;j<size;j++)
                        {
                            if(list.get(j).x==x && list.get(j).y==y-v && list.get(j).dir=='r')
                            {
                                //zasada zachowania pedu
                                int m1=list.get(i).m;int v1=list.get(i).v;
                                int m2=list.get(j).m;int v2=list.get(j).v;
                                list.get(i).v=(m1-m2)/(m1+m2)*v1+2*m2/(m1+m2)*v2;
                                list.get(j).v=(m2-m1)/(m1+m2)*v2+2*m1/(m1+m2)*v1;
                            }
                        }
                        list.get(i).dir='r';
                        break;
                    case 'r':
                        if(board[x][y + v].getBackground().equals(Color.green))
                        {
                            board[x][y + v].setBackground(Color.red);
                            board[x][y].setBackground(Color.green);
                            list.get(i).y += v;
                            break;
                        }
                        for(int j=0;j<size;j++)
                        {
                            if(list.get(j).x==x && list.get(j).y==y+v && list.get(j).dir=='l')
                            {
                                //zasada zachowania pedu
                                int m1=list.get(i).m;int v1=list.get(i).v;
                                int m2=list.get(j).m;int v2=list.get(j).v;
                                list.get(i).v=(m1-m2)/(m1+m2)*v1+2*m2/(m1+m2)*v2;
                                list.get(j).v=(m2-m1)/(m1+m2)*v2+2*m1/(m1+m2)*v1;
                            }
                        }
                        list.get(i).dir='l';
                        break;
                    case 'u':
                        if(board[x-v][y].getBackground().equals(Color.green))
                        {
                            board[x - v][y].setBackground(Color.red);
                            board[x][y].setBackground(Color.green);
                            list.get(i).x -= v;
                            break;
                        }
                        for(int j=0;j<size;j++)
                        {
                            if(list.get(j).x==x-v && list.get(j).y==y && list.get(j).dir=='d')
                            {
                                //zasada zachowania pedu
                                int m1=list.get(i).m;int v1=list.get(i).v;
                                int m2=list.get(j).m;int v2=list.get(j).v;
                                list.get(i).v=(m1-m2)/(m1+m2)*v1+2*m2/(m1+m2)*v2;
                                list.get(j).v=(m2-m1)/(m1+m2)*v2+2*m1/(m1+m2)*v1;
                            }
                        }
                        list.get(i).dir='d';
                        break;
                    case 'd':
                        if(board[x+v][y].getBackground().equals(Color.green))
                        {
                            board[x + v][y].setBackground(Color.red);
                            board[x][y].setBackground(Color.green);
                            list.get(i).x += v;
                            break;
                        }
                        for(int j=0;j<size;j++)
                        {
                            if(list.get(j).x==x+v && list.get(j).y==y && list.get(j).dir=='u')
                            {
                                //zasada zachowania pedu
                                int m1=list.get(i).m;int v1=list.get(i).v;
                                int m2=list.get(j).m;int v2=list.get(j).v;
                                list.get(i).v=(m1-m2)/(m1+m2)*v1+2*m2/(m1+m2)*v2;
                                list.get(j).v=(m2-m1)/(m1+m2)*v2+2*m1/(m1+m2)*v1;
                            }
                        }
                        list.get(i).dir='u';
                        break;
                }
            }

        }
    }
