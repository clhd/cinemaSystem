import java.util.List;
import java.util.Scanner;

public class Manage extends Person {
    List<Movie> movies;
    List<Session>sessions;
    Scanner in=new Scanner(System.in);
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    Manage(){
        this.password="ynumanage";
        this.account="manage";
    }
    void showChoice(List<Movie>movies,List<Session>sessions){
        this.movies=movies;
        this.sessions=sessions;
        System.out.println("请选择操作");
        System.out.println("1:影片管理");
        System.out.println("2:排片管理");
        String choice=in.nextLine();
        if(choice.equals("1")) {
            while (true) {
                System.out.println("请输入需要的操作");
                System.out.println("1:添加影片");
                System.out.println("2:搜索影片");
                System.out.println("3:更新影片");
                System.out.println("4:删除影片");
                System.out.println("5:显示影片");
                System.out.println("6:退出该界面");
                System.out.println("0:退出登录");
                choice = in.nextLine();
                if(choice.equals("0")){
                    break;
                }
                filmManagementInterface(choice);
            }
        }
        else if(choice.equals("2")){
            while (true) {
                System.out.println("1:添加场次");
                System.out.println("2:显示场次");
                System.out.println("3:更新场次");
                System.out.println("4:删除场次");
                System.out.println("6:退出该界面");
                System.out.println("0:退出登录");
                choice=in.nextLine();
                if(choice.equals("0")){
                    break;
                }
                SessionManagementInterface(choice);
            }
        }
        else {
            System.out.println("请重新输入");

        }

    }
    void  filmManagementInterface(String choice){
        switch (choice){
            case "1":addMovie();break;
            case "2":SearchMovie(movies);;break;
            case "3":updateMovie();break;
            case "4":removeMovie();break;
            case "5":showMovie(movies);break;
            case "6": showChoice(movies,sessions);break;

        }
    }
    void SessionManagementInterface(String choice){
        switch (choice){
            case "1":setCinemaSessions();break;
            case "2":showSession(sessions);break;
            case "3":updateSession();break;
            case "4":removeCinemaSession();break;
            case "6":showChoice(movies,sessions);break;
        }
    }
    void addMovie(){
        Movie movie=new Movie();
        movie.movieName=inputMovieName();
        System.out.println("请输入导演名");
        movie.director=in.nextLine();
        System.out.println("请输入主要剧情简介");
        movie.mainSynopsis=in.nextLine();
        System.out.println("请输入时长");
        movie.minute = in.nextLine();
        movies.add(movie);
    }
    void  updateMovie(){
        int count=0;
        System.out.println("请输入要改变信息的电影名");
        String name=in.nextLine();
        for (int i=0;i<movies.size();i++){
            if(name.equals(movies.get(i).movieName)){
                count=i;
            }
        }
        System.out.println("请输入要改变的信息1.导演2.剧情简介3.时长");
        String s=in.nextLine();
        switch (s){
            case "1": System.out.println("请输入修改后的信息");
                movies.get(count).director=in.nextLine();
                break;
            case "2":System.out.println("请输入修改后的信息");
                movies.get(count).mainSynopsis=in.nextLine();
                break;
            case "3":System.out.println("请输入修改后的信息");
                movies.get(count).minute =in.nextLine();
                break;

            default:
                throw new IllegalStateException("Unexpected value: " + s);
        }
    }
    void removeMovie(){
        System.out.println("请输入要删除的电影名称");
        String name=in.nextLine().trim();
        System.out.println("输入1确认删除，输入0 取消");
        String num=in.nextLine();
        if(num.equals("1")) {
            for (int i = 0; i < movies.size(); i++) {
                if (name.equals(movies.get(i).movieName)) {
                    movies.remove(i);
                }
            }
        }

    }
    void  setCinemaSessions( ){
       Session session=new Session();
        System.out.println("请输入要添加场次的电影放映位置:A-E");
        session.position=in.nextLine();
        System.out.println("请输入电影名字");
        session.movieName = in.nextLine();
        System.out.println("请输入电影的价格");
        session.price=in.nextDouble();
        System.out.println("请输入时间段");
        String line=in.nextLine();
        session.time=in.nextLine();
        sessions.add(session);
    }
    void updateSession() {
        int count = 0;
        System.out.println("请输入要修改的电影名和场次");
        String name = inputMovieName();
        String time =inputTime();
        String poistion =inputPosition();
        for (int i = 0; i < sessions.size(); i++) {
            if (name.equals(sessions.get(i).movieName) && time.equals(sessions.get(i).time)
                    && poistion.equals(sessions.get(i).position)) {
                count = i;
            }
        }
        System.out.println("如果要空场输入1，其他请输入0");
        String choice = in.nextLine();
        if (choice.equals("1")) {
            sessions.remove(count);
        } else {
            System.out.println("请输入修改后的电影名和场次");
            name = inputMovieName();
            time = inputTime();
            poistion =inputPosition();
            sessions.get(count).movieName = name;
            sessions.get(count).time = time;
            sessions.get(count).position = poistion;

        }
    }
    void removeCinemaSession(){
        System.out.println("请输入要删除的片名和场次");
        String name=inputMovieName();
        String time=inputTime();
        String poistion=inputPosition();
        System.out.println("请确认是否删除，确认请按1");
        String choice=in.nextLine();
        if(choice.equals("1"))
            for (int i=0;i<sessions.size();i++){
            if(name.equals(sessions.get(i).movieName)&&time.equals(sessions.get(i).time)
                    &&poistion.equals(sessions.get(i).position)){
                sessions.remove(i);
            }
        }
    }

}
