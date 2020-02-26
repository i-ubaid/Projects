
class DisplayDriver
{
    private int S_no,id,age,salary;
    private String name; 
    private String joinedDate;
    
    public DisplayDriver(int s_no,int id, String name, int age, String Date, int money)
    {
        S_no=s_no;
        this.id=id;
        this.age=age;
        this.salary=money;
        this.name=name;
        this.joinedDate=Date;
        
    }

    public int getS_no()
    {
        return S_no;
    }
    

    public int getID()
    {
        return id;
    }
    
    public int getAge()
    {
        return age;
    }
    
    public int getMoney()
    {
        return salary;
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
