package LGA;
import java.util.Random;
public class Czastka
{
    public int x;
    public int y;
    public int v;
    public int m;
    public char dir;
    Random rand = new Random();
    public double CzasRelaksacji;
    public double Stezenie;
    public double WspolczynnikWagowy;
    public double Feq; //równowaga lokalna

    public Czastka(int x,int y,char dir)
    {
        WspolczynnikWagowy = 1/4;
        CzasRelaksacji = rand.nextInt(1000)+1;
        Feq = CzasRelaksacji * (1 + 3 * v + 3 * v * v);
        Stezenie = Feq / WspolczynnikWagowy;
        this.x=x;
        this.y=y;
        //this.v= rand.nextInt(4)+1;
        this.v=1;
        this.dir=dir;
        this.m=rand.nextInt(3)+1;
    }

    public void move()
    {
        switch (dir)
        {
            case 'l':
                this.y=this.y-v;
            case 'r':
                this.y=this.y+v;
            case 'd':
                this.x=this.x+v;
            case 'u':
                this.x=this.x-v;
        }
    }


}
