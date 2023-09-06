import java.util.Date;

public class History {
    Session session;
    int Id;
    Date buyTicketTime;
    int x,y;
    History(){
        buyTicketTime= new Date();
    }
    void  showHistory(){
        System.out.println("购票时间"+buyTicketTime+"电影票Id"+Id+"电影票信息:");
       session.showCinemaSession();
        System.out.println("座位为"+"第"+x+"排"+"第"+y+"列");
    }
}
