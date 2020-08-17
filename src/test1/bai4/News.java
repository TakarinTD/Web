package test1.bai4;

import java.util.Scanner;

public class News implements INews {
    private  int id;
    private String title,publishDate,author,content;
    private float averageRate;
    public final int MAX_NEWS=100;
    int rateList[]=new int[3];

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPublishDate() {
        return publishDate;
    }

    public void setPublishDate(String publishDate) {
        this.publishDate = publishDate;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public float getAverageRate() {
        return averageRate;
    }

    @Override
    public void dislay() {
        System.out.println("News title: "+this.getTitle());
        System.out.println("News publish date: "+this.getPublishDate());
        System.out.println("News author: "+this.getAuthor());
        System.out.println("News content: "+this.getContent());
        System.out.println("News average rate: "+this.getAverageRate());
    }

    public void calculate(){
        for(int i=0;i<3;i++){
            this.averageRate+=rateList[i];
        }
        this.averageRate/=3;
    }
    public static void Menu(){
        System.out.println("Select an option!");
        System.out.println("1-Insert news");
        System.out.println("2-View list news");
        System.out.println("3-Average rate");
        System.out.println("4-Exit");
    }

    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        String choose=null;
        boolean exit=false;
        News news=new News();
        News arrayList[]=new News[news.MAX_NEWS];
        Menu();
        int k=0;
        while(true){
            choose=scanner.nextLine();
            switch(choose){
                case "1":
                    System.out.println("Insert news: ");
                    System.out.println("Input title: ");
                    String title=scanner.nextLine();
                    news.setTitle(title);
                    System.out.println("Input publish date: ");
                    String publishDate=scanner.nextLine();
                    news.setPublishDate(publishDate);
                    System.out.println("Input author: ");
                    String author=scanner.nextLine();
                    news.setAuthor(author);
                    System.out.println("Input content: ");
                    String content=scanner.nextLine();
                    news.setContent(content);
                    System.out.println("Input rate on a 10 point scale: ");
                    for(int i=0;i<3;i++){
                        System.out.println("rate "+i+":");
                        news.rateList[i]=scanner.nextInt();
                    }
                    arrayList[k]=news;
                    k++;
                    break;
                case "2":
                    System.out.println("View list news: ");
                    int j=0;
                    while(j!=k){
                        arrayList[j].dislay();
                        j++;
                    }
                    break;
                case "3":
                    System.out.println("Average rate: ");
                    int t=0;
                    while(t!=k){
                        arrayList[t].calculate();
                        arrayList[t].dislay();
                        t++;
                    }
                    break;
                case "4":
                    System.out.println("exited!");
                    exit = true;
                    break;
                default:
                    System.out.println("invalid! please choose action in below menu:");
                    break;
            }
            if(exit) break;
            Menu();
        }
    }
}
