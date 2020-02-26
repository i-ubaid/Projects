
class driverDisplay
{
    private int S_no,id,age,money;
    private String name; 
    private String joinedDate;
    
    public driverDisplay(int s_no,int age,int money, String name, String Date)
    {
        S_no=s_no;
        this.age=age;
        this.money=money;
        this.name=name;
        this.joinedDate=Date;
        
    }

    public int getS_no()
    {
        return S_no;
    }
    

    public int getAge()
    {
        return age;
    }
    
    public int getMoney()
    {
        return money;
    }
    
    public String getName()
    {
        return name;
    }
    
    public String getDate()
    {
        return joinedDate;
    }
            
}
