import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import java.util.ArrayList;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.FileWriter;
import java.io.BufferedWriter;
import java.util.Scanner;

public class Crawling
{
    ArrayList<String> link ;
    
    public void links(String Domain,String DT)throws IOException
    {
        link = new ArrayList();
        String url = "http://www."+Domain+DT;
        Document doc = Jsoup.connect(url).get();
        Elements l = doc.select("a[href]");
        for(Element e : l)
        {
            link.add(e.attr("abs:href"));
        }
    }
    public void getH1() throws IOException
    {
       BufferedWriter bf= new BufferedWriter(new FileWriter("D:\\h1.txt"));
        for(int i = 0 ;i<link.size()/2;i++)
        {
           Document d2 = Jsoup.connect(link.get(i)).get();
           Elements f = d2.getElementsByTag("h1");
           for(Element e : f)
           {
               bf.write(e.text());
               bf.newLine();
           }
        }
           bf.close();
    }
    public void getH2() throws IOException
    {
        BufferedWriter bf= new BufferedWriter(new FileWriter("D:\\h2.txt"));
        for(int i=0;i<link.size()/2;i++)
        {
           Document d2 = Jsoup.connect(link.get(i)).get();
           Elements f = d2.getElementsByTag("h2");
           for(Element g : f)
           {
               bf.write(g.text());
               bf.newLine();
           }
        }
        bf.close();
    }
    public void getH3() throws IOException
    {
        BufferedWriter bf= new BufferedWriter(new FileWriter("D:\\h3.txt"));
        for(int i = 0 ;i<link.size()/2;i++)
        {
           Document d2 = Jsoup.connect(link.get(i)).get();
           Elements f = d2.getElementsByTag("h3");
           for(Element g : f)
           {
               bf.write(g.text());
               bf.newLine();
           }
        }
        bf.close();
    }
    public void getH4() throws IOException
    {
        BufferedWriter bf= new BufferedWriter(new FileWriter("D:\\h4.txt"));
        for(int i=0;i<link.size()/2;i++)
        {
           Document d2 = Jsoup.connect(link.get(i)).get();
           Elements f = d2.getElementsByTag("h4");
           for(Element g : f)
           {
               bf.write(g.text());
               bf.newLine();
           }
        }
        bf.close();
    }
    public void Display(ArrayList<String> items)
    {
       
        for(String e:items)
        {
            System.out.println(e);
        }
    }
    public static void main(String[] args) throws IOException
    {
        Crawling c = new Crawling();
        Scanner in = new Scanner(System.in);
        System.out.printf("Enter Domain name:");
        String D = in.nextLine();
        System.out.printf("Enter Domain Type e.g(.com,.org, etc):");
        String DT = in.nextLine();
        
    
        c.links(D,DT);
        c.getH1();

        c.getH2();
        c.getH3();
        c.getH4();
     
    }
}
