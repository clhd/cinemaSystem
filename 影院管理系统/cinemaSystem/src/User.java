import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class User extends Person {
    int nowSession;
    List<User> users;
    List<Movie> movies;
    List<Session>sessions;
    List<Integer> ticketId = new ArrayList<>();
    List<History>histories=new ArrayList<>();
    boolean isLogin;
    Scanner in = new Scanner(System.in);
    int userId;
    int BuyTicketsNumber;
    String phoneNumber;
    double sum = 0;//消费的总金额
    String userLevel = "铜牌用户";
    int buyTickets = 0;//电影票的个数
    private String password;
    String email;//邮箱
    private int Id;//用户Id
    int count = 0;//记录登录的次数

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    String username;//用户名
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public int getId() {
        return Id;
    }
    public void setId(int id) {
        Id = id;
    }
    int length = 10; // 随机字符串的长度
    String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789"; // 可以包含的字符集合
    // 创建随机数生成器
    Random random = new Random();
    boolean JudgePassword(String password){
        String regex = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[\\p{P}\\p{S}])[\\p{L}\\p{N}\\p{P}\\p{S}]{8,}$";
        Pattern pattern = Pattern.compile(regex);
        // 使用正则表达式匹配密码
        Matcher matcher = pattern.matcher(password);
        return matcher.matches();
    }


    void ShowChoice(){
        while (true) {
            System.out.println("请选择选项");
            System.out.println("1:密码管理");
            System.out.println("2:查看所有电影放映信息");
            System.out.println("3:查看指定电影放映信息");
            System.out.println("4:购票");
            System.out.println("5:付账");
            System.out.println("6:取票");
            System.out.println("7:查看购物历史");
            System.out.println("0:退出");
            String choice = in.nextLine();
            if (choice.equals("0")) {
                break;
            }
            if(choice.equals("1")){
               setPassword();
                break;
            }
            switch (choice) {
                case "2":
                    showMovie(movies);
                    break;
                case "3":
                  SearchSession(sessions);
                    break;
                case "4":
                    buyTicket();
                    break;
                case "5":
                    pay();
                    break;
                case "6":
                   takeTicket();
                   in.nextLine();
                    break;
                case "7":
                    showHistory();
                    in.nextLine();
                    break;
            }
        }
    }
      void  setPassword(){
          System.out.println("请输入修改后的密码");
          String password=in.nextLine();
          if(JudgePassword(password)){
              this.password=password;
              System.out.println("密码修改成功");
          }
          else  {
              System.out.println("密码格式不对，需要由大小写字母数字和标点符号组成，且需要大于等于八位");
              setPassword();
          }
      }
    void Window(List<Movie>movies,List<Session>sessions,List<User>users) {
        this.movies=movies;
        this.sessions=sessions;
        this.users=users;
        while (true) {
            System.out.println("请选择登录或者注册");
            System.out.println("1:登录");
            System.out.println("2:注册");
            System.out.println("3:忘记密码");
            System.out.println("0:退出");
            String choice = in.nextLine();
            if (choice.equals("0")) {
                break;
            }
            switch (choice) {
                case "1": {
                    String username = inputUserName();
                    int count = 0;
                    for (User user : users) {
                        if (username.equals(user.username)) {
                            user.LoginOperate(username);
                            if(user.isLogin){
                                ShowChoice();
                            }
                        } else count++;
                    }
                    if (count == users.size()) {
                        System.out.println("用户名不存在");
                        continue;
                    }
                    break;
                }
                case "2":
                    User user1 = new User();
                    user1.Register();
                    user1.userId = users.size();
                    users.add(user1);
                    break;
                case "3": {
                      ReSetPassword();

                }
            }
        }
    }


    void buyTicket() {
        System.out.println("请输入片名");
        String movieName = in.nextLine();
        System.out.println("请输入时间段");
        String time = in.nextLine();
        System.out.println("请输入放映厅位置");
        String position = in.nextLine();
        for (int i=0;i<sessions.size();i++) {
            if (movieName.equals(sessions.get(i).movieName) &&
                    time.equals(sessions.get(i).time) && position.equals(sessions.get(i).position)) {
                {
                    sessions.get(i).showSeat();
                    nowSession=i;

                }

            }
        }

    }
    void pay() {
        int counts=0;
        System.out.println("请输入要买的票数");
        try {
            counts = in.nextInt();
        }
        catch (InputMismatchException e){
            System.out.println("请输入整数");
            pay();
        }
        int tickets = counts;
        if (counts >= 1) {
            buyTickets++;
        }
        while (counts > 0) {
            System.out.println("请输入坐标");
            int x = in.nextInt();
            int y = in.nextInt();
            in.nextLine();
            if(sessions.get(nowSession).setCinema(x,y)) {
                counts--;
                sessions.get(nowSession).pointList.add(new Point(x,y));
            }

        }
        System.out.println("你需要支付的金额为 " + getSum(tickets));
        System.out.println("请选择支付的方式：1.支付宝 2.银行卡 3.微信");
        String choice = in.nextLine();
        System.out.println("确认支付:1 取消:0");
        choice = in.nextLine();
        int number = sessions.get(nowSession).ticketId.size();
        if (choice.equals("1")) {
            System.out.println("支付成功");
            BuyTicketsNumber++;
            while (0 < tickets) {
                tickets--;
                sessions.get(nowSession).ticketId.add(number+1);
                System.out.println("电影票Id为" + sessions.get(nowSession).ticketId.get(number++));
            }

        } else {
            while (tickets > 0) {
                int n=sessions.get(nowSession).pointList.size()-1;
              sessions.get(nowSession).pointList.remove(n);
                tickets--;

            }
            System.out.println("支付失败");
        }
    }
    double getSum(int tickets){
        double money = 0;
        switch (userLevel) {
            case "铜牌用户":
                sum += tickets * (sessions.get(nowSession).price);
                money = tickets * (sessions.get(nowSession).price);
                break;
            case "银牌用户":
                money = tickets * (sessions.get(nowSession).price) * 0.95;
                sum += money;
                break;
            case "金牌用户":
                money = tickets * (sessions.get(nowSession).price) * 0.88;
                sum += money;
                break;
        }
        if (sum > 500 && sum < 2000) {
            userLevel = "银牌用户";
        } else if (sum > 2000) {
            userLevel = "金牌用户";
        }
        return money;
    }

    public void LoginOperate( String username) {
        String password=inputPassWord();
        if (count >= 5) {
            System.out.println("你已输入密码错误超过5次，账号被锁定");
            return;
        }
        if (password.equals(this.password) && username.equals(this.username)) {
            System.out.println("登录成功");
            isLogin = true;
        } else {
            System.out.println("密码错误，请重新输入");
            count++;
            isLogin = false;
            LoginOperate(username);
        }
    }
    void Register(){
        System.out.println("请输入用户名,注意用户名需要大于5个字符");
        Scanner in = new Scanner(System.in);
        String s = in.nextLine();
        if (s.length() < 5) {
            Register();
        } else {
            System.out.println("请输入邮件地址");
            this.username = s;
        }
        s = in.nextLine();
        this.email = s;
        System.out.println("请输入手机号");
        s = in.nextLine();
        this.phoneNumber = s;
        System.out.println("请输入密码");
        System.out.println("密码长度大于 8 个字符，必须是大小写字母、数字和标点符号的组合");
          while (true){
              String password=inputPassWord();
              if(JudgePassword(password)){
                  this.password=password;
                  break;
              }
              System.out.println("密码不符合格式请重新输入");
          }
          System.out.println("注册成功");
    }
    void ReSetPassword(){
        String username =inputUserName();
        int count = 0;
        for (User user : users) {
            if (username.equals(user.username)) {
                System.out.println("请输入邮箱");
                email = in.nextLine();
                StringBuilder sb = new StringBuilder(length);
                for (int j = 0; j < length; j++) {
                    // 从字符集合中随机选择一个字符
                    char randomChar = characters.charAt(random.nextInt(characters.length()));
                    sb.append(randomChar);
                }
                String randomString = sb.toString();
                user.setPassword(randomString);//设置随机密码
                System.out.println("重置密码已发送到邮箱中是否选择查看" +
                        "查看请按1 退出请按0");
                String choices = in.nextLine();
                if (choices.equals("1")) {
                    System.out.println(user.getPassword());
                }
            } else count++;
        }
        if (count == users.size()) {
            System.out.println("用户名不存在");
        }

    }
    void takeTicket() {
            System.out.println("请输入电影票Id");
            int Id = in.nextInt();
            for (int i = 0; i <sessions.get(nowSession).ticketId.size(); i++) {
                if (Id == sessions.get(nowSession).ticketId.get(i)) {
                    int x=sessions.get(nowSession).pointList.get(i).x;
                    int y=sessions.get(nowSession).pointList.get(i).y;
                    sessions.get(nowSession).getTicket(x,y);
                    History buyTicketHistory=new History();
                    buyTicketHistory.Id=Id;
                    buyTicketHistory.session=sessions.get(nowSession);
                    buyTicketHistory.x=x;
                    buyTicketHistory.y=y;
                    histories.add(buyTicketHistory);
                }
            }

        }

    void  showHistory(){
        for (History history : histories) history.showHistory();
    }
    void showUserInformation() {
        System.out.println("用户ID: " + userId + " 用户名: " + username + " 用户级别 " + userLevel + " 用户消费次数 " + BuyTicketsNumber + " 用户消费金额 " +
                sum + " 用户电话 " + phoneNumber + " 用户邮箱 " + email);
    }
}

