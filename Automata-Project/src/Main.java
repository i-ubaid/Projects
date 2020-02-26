import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.net.URL;

public class Main
{
    static LinkedList<String> list;
    static LinkedList<String> email;
    static LinkedList<String> url;
    static LinkedList<String> date;
    static LinkedList<String> time;
    static LinkedList<String> garbage;
    //To validate Email address
    public static boolean isValidEMAIL(String email)
    {
        String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\." + "[a-zA-Z0-9_+&*-]+)*@" + "(?:[a-zA-Z0-9-]+\\.)+[a-z" + "A-Z]{2,7}$";
        Pattern pat = Pattern.compile(emailRegex);
        if (email == null)
        {
            return false;
        }
        return pat.matcher(email).matches();
    }

    //To validate Url's
    public static boolean isValidURL(String url)
    {
        try {
            new URL(url).toURI();
            return true;
        }
        catch (Exception e) {
            return false;
        }
    }

    //To validate date in different dates
    public static boolean isValidDate1(String d)
    {
        String regex = "^((19|20)\\d\\d)-(0?[1-9]|1[012])-(0?[1-9]|[12][0-9]|3[01])$"; //YYYY-MM-DD

        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher((CharSequence)d);
        return matcher.matches();
    }
    public static boolean isValidDate2(String d)
    {
        String regex = "^(0?[1-9]|1[012])-(0?[1-9]|[12][0-9]|3[01])-((19|20)\\d\\d)$"; //MM-DD-YYYY 2

        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher((CharSequence)d);
        return matcher.matches();
    }
    public static boolean isValidDate3(String d)
    {
        String regex = "^(0?[1-9]|[12][0-9]|3[01])-(0?[1-9]|1[012])-((19|20)\\d\\d)$"; //DD-MM-YYYY 3

        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher((CharSequence)d);
        return matcher.matches();
    }
    public static boolean isValidDate4(String d)
    {
        String regex = "^((19|20)\\d\\d)/(0?[1-9]|1[012])/(0?[1-9]|[12][0-9]|3[01])$"; // YYYY/MM/DD

        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher((CharSequence)d);
        return matcher.matches();
    }
    public static boolean isValidDate5(String d)
    {
        String regex = "^(0?[1-9]|1[012])/(0?[1-9]|[12][0-9]|3[01])/((19|20)\\d\\d)$";  //MM-DD-YYYY

        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher((CharSequence)d);
        return matcher.matches();
    }
    public static boolean isValidDate6(String d)
    {
        String regex = "^(0?[1-9]|[12][0-9]|3[01])/(0?[1-9]|1[012])/((19|20)\\d\\d)$"; //DD-MM-YYYY

        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher((CharSequence)d);
        return matcher.matches();
    }
    public static boolean isValidDate7(String d)
    {
        String regex = "^((19|20)\\d\\d)/(0?[1-9]|[12][0-9]|3[01])/(0?[1-9]|1[012])$"; // YYYY/DD/MM

        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher((CharSequence)d);
        return matcher.matches();
    }
    public static boolean isValidDate8(String d)
    {
        String regex = "^((19|20)\\d\\d)-(0?[1-9]|[12][0-9]|3[01])-(0?[1-9]|1[012])$"; // YYYY/DD/MM

        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher((CharSequence)d);
        return matcher.matches();
    }

    //To Validate Time in different formats
    public static boolean isValidTime1(String d)
    {
        String regex = "([01]?[0-9]|2[0-3]):[0-5][0-9]"; //24:00 1
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher((CharSequence)d);
        return matcher.matches();
    }
    public static boolean isValidTime2(String d)
    {
        String regex = "([01]?[0-9]|2[0-3]):[0-5][0-9]:[0-5][0-9]"; //24:00:00 2
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher((CharSequence)d);
        return matcher.matches();
    }
    public static boolean isValidTime3(String d)
    {
        String regex = "(1[012]|[1-9]):[0-5][0-9](\\s)?(?i)(am|pm)"; //12:00 pm/am 3
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher((CharSequence)d);
        return matcher.matches();
    }
    public static boolean isValidTime4(String d)
    {
        String regex = "(1[012]|[1-9]):[0-5][0-9](\\s)?(?i)(a|p)"; //12:00 a/p 4
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher((CharSequence)d);
        return matcher.matches();
    }
    public static boolean isValidTime5(String d)
    {
        String regex = "(1[012]|[1-9]):[0-5][0-9]:[0-5][0-9](\\s)?(?i)(am|pm)"; //12:00:00 pm/am 5

        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher((CharSequence)d);
        return matcher.matches();
    }
    public static boolean isValidTime6(String d)
    {
        String regex = "(1[012]|[1-9]):[0-5][0-9]:[0-5][0-9](\\s)?(?i)(a|p)"; //12:00:00 a/p 6

        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher((CharSequence)d);
        return matcher.matches();
    }

    //To read Elements from the File
    public static void fileReading() throws IOException
    {
        list = new LinkedList<>();
        File file = new File("filing.txt");
        BufferedReader br = new BufferedReader(new FileReader(file));
        String line;
        line=br.readLine();
        while(line !=null)
        {
            list.add(line);
            System.out.println(line);
            line = br.readLine();

        }
        br.close();
    }

    //To validate date in multiple formats
    public static boolean validDate(String d)
    {
        boolean flag = false;
        flag=isValidDate1(d);
        if(flag)
        {
            return flag;
        }
        flag=isValidDate2(d);
        if(flag)
        {
            return flag;
        }
        flag=isValidDate3(d);
        if(flag)
        {
            return flag;
        }
        flag=isValidDate4(d);
        if(flag)
        {
            return flag;
        }
        flag=isValidDate5(d);
        if(flag)
        {
            return flag;
        }
        flag=isValidDate6(d);
        if(flag)
        {
            return flag;
        }
        flag=isValidDate7(d);
        if(flag)
        {
            return flag;
        }
        flag=isValidDate8(d);
        if(flag)
        {
            return flag;
        }
        return flag;
    }

    //To validate time in multiple formats
    public static boolean validTime(String d)
    {
        boolean flag = false;
        flag = isValidTime1(d);
        if(flag)
        {
            return flag;
        }
        flag = isValidTime2(d);
        if(flag)
        {
            return flag;
        }
        flag = isValidTime3(d);
        if(flag)
        {
            return flag;
        }
        flag = isValidTime4(d);
        if(flag)
        {
            return flag;
        }
        flag = isValidTime5(d);
        if(flag)
        {
            return flag;
        }
        flag = isValidTime6(d);
        if(flag)
        {
            return flag;
        }

        return flag;
    }

    public static void main(String[] args)throws Exception
    {

        email = new LinkedList<>();
        url = new LinkedList<>();
        time = new LinkedList<>();
        date = new LinkedList<>();
        garbage = new LinkedList<>();
        //To read elements from file and insert in list
        fileReading();

      //To print the elements in list
     /* for(int i=0; i<list.size(); i++)
      {
          System.out.println(i+1+". "+list.get(i));
      }
     */
        for(int i=0; i<list.size(); i++)
        {
            String temp = list.get(i);

            if(isValidEMAIL(temp))
            {
                email.add(temp);
                continue;
            }
            else
            {
                if(isValidURL(temp))
                {
                    url.add(temp);
                    continue;
                }
                else
                {
                    if(validDate(temp))
                    {
                        date.add(temp);
                        continue;
                    }
                    else
                    {
                        if(validTime(temp))
                        {
                            time.add(temp);
                            continue;
                        }
                    }

                }

            }
            garbage.add(temp);
        }
        System.out.println("");
        System.out.println("Email");
        System.out.println("*-------------*");
        for(int i =0; i<email.size(); i++)
        {
            System.out.println(i+1+". "+email.get(i));
        }
        System.out.println("");
        System.out.println("Url");
        System.out.println("*-------------*");
        for(int i =0; i<url.size(); i++)
        {
            System.out.println(i+1+". "+url.get(i));
        }
        System.out.println("");
        System.out.println("Date");
        System.out.println("*-------------*");
        for(int i =0; i<date.size(); i++)
        {
            System.out.println(i+1+". "+date.get(i));
        }
        System.out.println("");
        System.out.println("Time");
        System.out.println("*-------------*");
        for(int i =0; i<time.size(); i++)
        {
            System.out.println(i+1+". "+time.get(i));
        }
        System.out.println("");
        System.out.println("Garbage");
        System.out.println("*-------------*");
        for(int i =0; i<garbage.size(); i++)
        {
            System.out.println(i+1+". "+garbage.get(i));
        }

    }

}

