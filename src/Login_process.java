import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Login_process extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Connection con1=null;
	ResultSet rs=null;
	Statement st=null;


    public Login_process() 
    {
        super();
    }
	public void init(ServletConfig config) throws ServletException 
	{

		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			con1=DriverManager.getConnection("jdbc:mysql://localhost:3306/pro","root","PR1234567890@");
			System.out.println(con1);
			System.out.println("hello");
		}
		catch(Exception e)
		{
			System.out.println("no");
		}
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		doGet(request, response);
		System.out.println("in doget");
		String a=request.getParameter("usr");
		System.out.println(a);
		String b=request.getParameter("pass");
		System.out.println(b);
		String sql="Select * from register";
		System.out.println(sql);
		try {
			System.out.println("in try");
			rs=st.executeQuery(sql);
			while(rs.next())
			{
				System.out.println(rs.getString(1)+"\t");
				System.out.println(rs.getString(2)+"\t");
				System.out.println(rs.getString(3)+"\t");
				System.out.println("<br>");
			}
			
		} 
		catch (SQLException e) 
		{
			System.out.println("in catch");
			e.printStackTrace();
		}
		
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		
		
	}

}
