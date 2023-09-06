import java.util.List;
import java.util.Scanner;

public class Reception extends Person {
    Scanner in=new Scanner(System.in);
    List<Movie>movies;
    List<Session>sessions;
    List<User>users;
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    Reception(){
        this.account="reception";
        this.password="ynureception";
    }
     void showChoice(List<Movie>movies,List<Session>sessions,List<User>users){
        this.users=users;
        this.movies=movies;
        this.sessions=sessions;
         while (true) {
             System.out.println("请选择操作");
             System.out.println("1:显示影片信息");
             System.out.println("2:显示排片信息");
             System.out.println("3:列出指定场次信息");
             System.out.println("4:售票");
             System.out.println("0:退出登录");
             String choice = in.nextLine();
             if(choice.equals("0")){
                 break;
             }
             switch (choice) {
                 case "1":
                     showMovie(movies);
                     break;
                 case "2":
                     showSession(sessions);
                     break;
                 case "3":
                     SearchSession(sessions);
                     break;
                 case "4" :
                     sellTicket();
                     break;
             }
         }
     }
     void sellTicket(){
           String name= inputMovieName();
           String time=inputTime();
           String position=inputPosition();
           String username=inputUserName();
           String phone=in.nextLine();
           int nowUser=0;
           for (int i=0;i<users.size();i++){
               if(username.equals(users.get(i).username)){
                   nowUser=i;
               }
           }
           System.out.println("请输入票数");
            int number=in.nextInt();
           for (int j=0;j<sessions.size();j++){
               if(name.equals(sessions.get(j).movieName)&&sessions.get(j).time.equals(time)&&sessions.get(j).position.equals(position)){
                    users.get(nowUser).sum+=sessions.get(j).price*number;
                    int num=sessions.get(j).ticketId.size();
                   while (0 < number) {
                       number--;
                       sessions.get(j).ticketId.add(num);
                       System.out.println("电影票Id为" + sessions.get(j).ticketId.get(num++));
                       sessions.get(j).showCinemaSession();
                   }
               }

           }

     }
}
