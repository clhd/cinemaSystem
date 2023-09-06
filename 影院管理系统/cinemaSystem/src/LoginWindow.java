import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class LoginWindow {
  Manage manage=new Manage();
  Admin admin=new Admin();
  Reception reception=new Reception();
  List<User> users=new ArrayList<>();
  User user=new User();
  List<Movie> movies=new ArrayList<>();
  List<Session> sessions=new ArrayList<>();
  LoginWindow(){

  }
  void showLogin(){
    System.out.println("请选择身份");
    System.out.println("1:管理员");
    System.out.println("2:经理");
    System.out.println("3:前台");
    System.out.println("4:用户");
    System.out.println("0:退出");

  }
  void Window(){
    Scanner in=new Scanner(System.in);
    while (true) {
      showLogin();
      String input = in.nextLine();
      if (input.equals("0")) {
        break;
      }
      switch (input) {
        case "1":
          admin.LoginOperate();
          admin.showChoice(users);
          break;
        case "2":
          manage.LoginOperate();
          manage.showChoice(movies,sessions);
          break;
        case "3":
          reception.LoginOperate();
          reception.showChoice(movies,sessions,users);
          break;
        case "4":user.Window(movies,sessions,users);
      }
    }
  }
}
