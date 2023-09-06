import java.util.List;
import java.util.Scanner;

public class Admin extends Person {
    Scanner in=new Scanner(System.in);
    public String getPassword() {
        return password;
    }
 List<User> users;
    public void setPassword(String password) {
        this.password = password;
    }

     Admin(){
        this.account="admin";
        this.password="ynuadmin";
     }
    void showChoice(List<User> list){
        this.users=list;
        while (true) {
            System.out.println("请输入选项");
            System.out.println("1:重置管理员密码");
            System.out.println("2:重置用户密码");
            System.out.println("3:显示用户信息");
            System.out.println("4:查询用户信息");
            System.out.println("5:删除用户信息");
            System.out.println("6:退出登录");
            String choice = in.nextLine();
            if(choice.equals("6")){
                System.out.println("退出成功");
                break;
            }
            switch (choice) {
                case "1":
                    revisePassword();
                    break;
                case "2":
                    updatePassword();
                    break;
                case "3":
                    ShowUser(users);
                    break;
                case "4":
                    SearchUser(users);
                    break;
                case "5":removeUsr();

            }
        }
    }
    void ShowUser(List<User> users){
        for (User user:users){
            user.showUserInformation();
        }
    }
    void SearchUser(List<User> users) {
        String name = inputUserName();
        for (User user : users) {
            if (user.username.equals(name)) {
                user.showUserInformation();
            }
        }
    }
    void updatePassword(){
        System.out.println("请输入要修改密码的用户名");
        String name=in.nextLine();
        for (User user : users) {
            if (name.equals(user.username)) {
                System.out.println("请输入修改后的密码");
                String password = in.nextLine();
                user.setPassword(password);
            }
        }
    }
    void revisePassword( ){
        System.out.println("请输入更改后的密码");
        String password=in.nextLine();
        setPassword(password);
    }
    void removeUsr(){
        System.out.println("请输入要删除的用户名");
        String name=in.nextLine();
        for (int i=0;i<users.size();i++){
            if(users.get(i).username.equals(name)){
                System.out.println("请确认是否删除，删除请按1,取消请按0");
                String choice=in.nextLine();
                if(choice.equals("1")){
                    users.remove(i);
                }
                else
                    break;
            }
        }
    }
}
