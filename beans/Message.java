package beans;

public class Message implements java.io.Serializable
{
	private String msg;

	public Message()
	{
		// we will ask jsp to initialise msg
	}
	// setter method
	public void setMsg(String msg)
	{
		this.msg = msg;
	}
	// getter method

	public String getMsg()
	{
		return msg;
	}
}
