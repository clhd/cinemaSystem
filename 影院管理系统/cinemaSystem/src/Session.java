import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Scanner;

public class Session {
    List<Point>pointList=new ArrayList<>();
    List<Integer> ticketId=new ArrayList<>();//记录电影票的电子Id
    Calendar calendar = Calendar.getInstance();
    // 获取当前日期是星期几（1-7分别代表星期日到星期六）
    int dayOfWeek = calendar.get(Calendar.DAY_OF_WEEK);
    String[] weekDays = {"Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"};
    String time;//时间段
    double price;
    String movieName;
    String position;
    String weekday=weekDays[dayOfWeek-1];//表示周几默认为当天
    String [][]cinema;
    private double[][] isGetTicket=new double[8][13];

    Session(){
        cinema=new String[8][13];
        for (int i = 0; i<8; i++){
            for (int j=0;j<13;j++){
                cinema[i][j]="O";
                isGetTicket[i][j]=0;
            }
        }
        for (int i=1;i<8;i++){
            String x=Integer.toString(i);
            cinema[i][0]=x;
        }
        for (int j=1;j<13;j++){
            String x=Integer.toString(j);
            cinema[0][j]=x;
        }
        cinema[0][0]=" ";
    }
    boolean  setCinema(int x,int y){//设置坐的位置
        if(isGetTicket[x][y]==1){
            System.out.println("这里已经有人了");
            return false;
        }
        cinema[x][y]="X";
        isGetTicket[x][y]=1;
        return true;


    }
    void  showCinemaSession(){
        System.out.println("电影名:"+"\t"+movieName+" 放映厅:"+"\t"+position+" 价格:"+"\t"+price+"时间: "+weekday+time);
    }
    void showSeat(){
        for (int i=0;i<8;i++){
            for (int j=0;j<13;j++){
                 System.out.print(cinema[i][j]+"\t");
            }
            System.out.println();
        }
    }

    public void getTicket(int x, int y) {
        if(isGetTicket[x][y]==1){
            isGetTicket[x][y]=-1;
            System.out.println("取票成功");
        }
        else
            System.out.println("票已被取走");
    }
}

