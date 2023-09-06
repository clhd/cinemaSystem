import java.util.List;
import java.util.Objects;
import java.util.Scanner;

public class Person {
    Scanner in=new Scanner(System.in);
    String inputUserName(){
        System.out.println("请输入用户名");
        return in.nextLine();
    }
    String account;
    String password;
    String inputPassWord(){
        System.out.println("请输入密码");
        return in.nextLine();
    }
    void showMovie(List<Movie> movies){
        for (Movie movie:movies){
             movie.show();
        }
    }
    String inputMovieName(){
        System.out.println("请输入片名");
        return  in.nextLine();
    }
    void  showSession(List<Session> list){
        for (Session session:list){
            session.showCinemaSession();
        }
    }

    void SearchMovie(List<Movie> movies){
        String movieName=inputMovieName();
        for (Movie movie:movies){
            if(movie.movieName.equals(movieName)){
                movie.show();
            }
        }
    }
    void SearchSession(List<Session> list){
        String movieName=inputMovieName();
        for (Session session:list){
            if(session.movieName.equals(movieName))
                   {
                 session.showCinemaSession();
            }
        }
    }
    void LoginOperate() {
        String account=inputUserName();
        String  password=inputPassWord();
        if(Objects.equals(this.password, password)&& this.account.equals(account)){//判断密码是否相等
            System.out.println("成功登录");
        }
        else {
            System.out.println("密码错误，请重新输入");
            LoginOperate();
        }
    }
    String inputPosition(){
        System.out.println("请输入放映厅位置");
        return  in.nextLine();
    }
    String inputTime(){
        System.out.println("请输入时间段");
        return in.nextLine();
    }
}
