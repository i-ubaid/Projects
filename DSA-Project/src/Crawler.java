import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import java.io.*;
import java.util.*;

public class Crawler {
    private static final int MAX_DEPTH = 2;
    public ArrayList<String> links;
    Map<String, Integer> dictionary = new HashMap();
    ArrayList<String> heading1 = new ArrayList<>();
    ArrayList<String> heading2 = new ArrayList<>();
    ArrayList<String> heading3 = new ArrayList<>();
    ArrayList<String> heading4 = new ArrayList<>();
    ArrayList<Element> headlinks = new ArrayList<>();
    String inputLine = null;
    public Crawler()
    {
        links = new ArrayList<>();

    }

    public void getPagesH5(String URL, int depth, BufferedWriter bw1, BufferedWriter bw2, BufferedWriter bw3, BufferedWriter bw4) throws IOException {
        BufferedWriter w1 = bw1;
        BufferedWriter w2 = bw2;
        BufferedWriter w3 = bw3;
        BufferedWriter w4 = bw4;

        if ((!links.contains(URL) && (depth < MAX_DEPTH))) {
            try {
                links.add(URL);

                Document document = Jsoup.connect(URL).get();
                Elements linksOnPage = document.select("href");
                Elements h1 = document.getElementsByTag("h1");
                Elements h2 = document.getElementsByTag("h2");
                Elements h3 = document.getElementsByTag("h3");
                Elements h4 = document.getElementsByTag("h4");
                for (Element g : h1) {
                    w1.write(g.text());
                    w1.newLine();
                }
                for (Element g : h2) {
                    w2.write(g.text());
                    w2.newLine();
                }
                for (Element g : h3) {
                    w3.write(g.text());
                    w3.newLine();
                }
                for (Element g : h4) {
                    w4.write(g.text());
                    w4.newLine();
                }

                depth++;
                for (Element page : linksOnPage)
                    getPagesH5(page.attr("abs:href"), depth, w1, w2, w3, w4);
            } catch (IOException e) {
                System.err.println("For '" + URL + "': " + e.getMessage());
            }
        }
        return;
    }

    public void readH1(BufferedReader r1) throws IOException {
        int j = 0;
        while ((inputLine = r1.readLine()) != null) {

            heading1.add(inputLine);
            j++;

            if (inputLine.equals("")) {
                continue;

            }
        }


    }

    public void readH2(BufferedReader r1) throws IOException {

        int j = 0;
        while ((inputLine = r1.readLine()) != null) {

            heading2.add(inputLine);
            j++;

            if (inputLine.equals(""))
                continue;

        }

    }

    public void readH3(BufferedReader r1) throws IOException {

        int j = 0;
        while ((inputLine = r1.readLine()) != null) {

            heading3.add(inputLine);
            j++;

            if (inputLine.equals("")) {
                continue;
            }

        }

    }

    public void readH4(BufferedReader r1) throws IOException {
        int j = 0;
        while ((inputLine = r1.readLine()) != null) {

            heading4.add(inputLine);
            j++;

            if (inputLine.equals(""))
            {
                continue;
            }
        }

    }

    public void link(String url,BufferedWriter bw1, BufferedWriter bw2, BufferedWriter bw3, BufferedWriter bw4) throws IOException
    {
        ArrayList<String> list=new ArrayList();
        Scanner in = new Scanner(System.in);
        Document doc = Jsoup.connect(url).get();
        String title=doc.title();
        System.out.println("Title: "+title);
        System.out.println("Enter Something you want to search");
        String search=in.next();
        int i=0;
        Elements links=doc.getAllElements();
        for (Element link:links) {
            if(link.attr("href").toLowerCase().contains(search))
            {
                list.add(link.attr("href"));
                {
                    System.out.print(i+":");
                    System.out.println(link.attr("href"));
                    System.out.println(link.text());
                    i++;
                    System.out.println("\n\n");
                }
            }
            }
        System.out.println("which link you want to look\n");
        int no=in.nextInt();
        String p=list.get(no);
        Document doc1 = Jsoup.connect(p).get();
        String title1=doc1.title();
        System.out.println("title: "+title1+"\n");
        Elements h1 = doc1.getElementsByTag("h1");
        Elements h2 = doc1.getElementsByTag("h2");
        Elements h3 = doc1.getElementsByTag("h3");
        Elements h4 = doc1.getElementsByTag("h4");
        for (Element g : h1) {
            bw1.write(g.text());
            bw1.newLine();
        }
        for (Element g : h2) {
            bw2.write(g.text());
            bw2.newLine();
        }
        for (Element g : h3) {
            bw3.write(g.text());
            bw3.newLine();
        }
        for (Element g : h4) {
            bw4.write(g.text());
            bw4.newLine();
        }
        System.out.println("Some Main headings/Headlines");
        int l=0;
        for (Element g : h1) {
            System.out.println(l+":"+g.text());
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedWriter h1 = new BufferedWriter(new FileWriter("D:\\w1.txt", true));
        BufferedWriter h2 = new BufferedWriter(new FileWriter("D:\\w2.txt", true));
        BufferedWriter h3 = new BufferedWriter(new FileWriter("D:\\w3.txt", true));
        BufferedWriter h4 = new BufferedWriter(new FileWriter("D:\\w4.txt", true));
        BufferedReader r1 = new BufferedReader(new FileReader("D:\\w1.txt"));
        BufferedReader r2 = new BufferedReader(new FileReader("D:\\w2.txt"));
        BufferedReader r3 = new BufferedReader(new FileReader("D:\\w3.txt"));
        BufferedReader r4 = new BufferedReader(new FileReader("D:\\w4.txt"));

        Crawler c = new Crawler();
        Scanner in = new Scanner(System.in);
        System.out.printf("Enter Domain name:");
        String D = in.nextLine();
        System.out.printf("Enter Domain Type e.g(.com,.org, etc):");
        String DT = in.nextLine();
        String url = "http://www." + D + "." + DT;
        //c.getPagesH5(url, 0, h1, h2, h3, h4);
        c.link(url, h1, h2, h3, h4);
        c.readH1(r1);
        c.readH2(r2);
        c.readH3(r3);
        c.readH4(r4);
        h1.close();h2.close();h3.close();h4.close();r1.close();r2.close();r3.close();r4.close();
    }
}
