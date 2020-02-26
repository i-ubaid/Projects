import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Scanner;

public class project {
	
	public static void main(String[] args) throws IOException {

		Scanner scan=new Scanner(System.in);
		int number;
		ArrayList <String> urls=new ArrayList();
		String url;
		ArrayList <String> orgs=new ArrayList();
		String org;
		
		System.out.println("number of page  you want to get news");
		number = scan.nextInt();
		
		for(int i=0;i<number;i++)
		{
			System.out.println("enter name of page you want to get news");
			url=scan.next();
			urls.add(url);
			System.out.println("enter org(com) of page you want to get news");
			org=scan.next();
			orgs.add(org);
		}
		ArrayList <Document> doc=new ArrayList();
		for(int i=0;i<number;i++)
		{
			try {
				doc.add(Jsoup.connect("https://www."+urls.get(i)+"."+orgs.get(i)).get());
				String title=doc.get(i).title();
				System.out.println("title: "+title);
			}
			catch(Exception e){
				System.out.println("something wrong in this page"+urls.get(i)+"."+orgs.get(i));
				
		}
			
		}
       
        
        System.out.println("news about");
        String news=scan.next();
    
        int i=0;
        ArrayList<String> list=new ArrayList();
        
        for(int j=0;j<doc.size();j++)
        {	
        	Elements links=doc.get(j).getAllElements();
        	for (Element link:links) {
        		if(link.attr("href").toLowerCase().contains(news))
        		{
        			list.add(link.attr("href"));
        			if(!list.get(i).toLowerCase().contains("twitter.com") &&!list.get(i).contains("api.whatsapp.com") &&! list.get(i).contains("www.facebook.com"))
        			{
        				System.out.print(i+":");
        				System.out.println(link.attr("href"));
        				System.out.println(link.text());
        				i++;
        				System.out.println("\n\n");
        			}
        		}
        	}
        }
        	 
        
        
        System.out.println("which news you want to look\n\n");
        int no=scan.nextInt();

     
        String s=list.get(no);
        Document doc1 = Jsoup.connect(s).get();
        String title1=doc1.title();
        
        System.out.println("title: "+title1+"\n\n");
        
        Elements links1=doc1.select("h0, h1, h2, h3, h4, h5, h6");
     
    
        
        int k=0;
        ArrayList <String> filing=new ArrayList();  
        
        for (Element link:links1) {
        	if(link.text().toLowerCase().contains(news) )
        	{
        		if(k==0)
        		{
        			System.out.print("SOME HEADLINES ATOUT ");
        		}
        		k++;
        		System.out.println(link.text());
            	System.out.println("\n\n");
            	filing.add(link.text());
            	
             }
        	
        }
           
}

}
