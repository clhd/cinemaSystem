public class Movie {
    String movieName;
    String director;//导演
    String mainSynopsis;//剧情简介
    String minute;//时长
    void  show(){
        System.out.println("电影名:"+"\t"+ movieName +"导演:"+"\t"+director+"\n剧情简介:"+"\t"+mainSynopsis+"时长\t:"+"\t"+ minute);
    }
}
