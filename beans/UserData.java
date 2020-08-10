package beans;

public class UserData implements java.io.Serializable
{
    private String username;
    private String mailid;
    private String salary;

    public UserData(){
    }

    // setter and getter methods

    public void setUsername(String username) {
        this.username = username;
    }

    public void setMailid(String mailid) {
        this.mailid = mailid;
    }

    public void setSalary(String salary) {
        this.salary = salary;
    }

    public String getUsername() {
        return username;
    }

    public String getMailid() {
        return mailid;
    }

    public String getSalary() {
        return salary;
    }
}
