import java.io.*;
import java.sql.*;
import javax.servlet.*;
import javax.servlet.http.*;
public class StudentServlet3 extends HttpServlet
{

    private static final long serialVersionUID = 1L;
    private String message;
    private String Seat_no;
    private String Name;
    private String ans1;
    private String ans2;
    private String ans3;
    private String ans4;
    private String ans5;
private int Total=0;
private Connection connect; private Statement stmt; private ResultSet rs;

    public StudentServlet3() {
        this.rs = null;
        this.stmt = null;
    }

    /**
     *
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    @Override
    public void doPost(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException
{
try
{
Class.forName("com.mysql.cj.jdbc.Driver");
            setConnect(DriverManager.getConnection("jdbc:mysql://localhost:3306/mce","root","")); setMessage("Thank you for participating in onlineExam");
}
catch(ClassNotFoundException cnfex){ cnfex.printStackTrace();
}
catch(SQLException sqlex){ sqlex.printStackTrace();
}
catch(Exception excp){ excp.printStackTrace();
}
        setSeat_no(request.getParameter("Seat_no")); setName(request.getParameter("Name"));
        setAns1(request.getParameter("group1")); setAns2(request.getParameter("group2"));
        setAns3(request.getParameter("group3")); setAns4(request.getParameter("group4"));
        setAns5(request.getParameter("group5")); 
if(     getAns1().equals("True")) {
            setTotal(getTotal() + 2);
}
if(     getAns2().equals("False")) {
            setTotal(getTotal() + 2);
}
if(     getAns3().equals("True")) {
            setTotal(getTotal() + 2);
}
if(     getAns4().equals("False")) {
            setTotal(getTotal() + 2);
}
if(     getAns5().equals("False")) {
            setTotal(getTotal() + 2);
} try
{
    try (Statement stmt = getConnect().createStatement()) {
        String query="INSERT INTO cse VALUES('"+getSeat_no()+"','"+getName()+"','"+getTotal()+"')";
        int result=stmt.executeUpdate(query);
    }
}catch(SQLException ex){
}
response.setContentType("text/html"); PrintWriter out=response.getWriter(); out.println("<html>");
out.println("<head>"); out.println("</head>"); out.println("<body bgcolor=cyan>");
out.println("<center>"); out.println("<h1>"+getMessage()+"</h1>\n");
out.println("<h3>Yours results stored in our database</h3>"); out.print("<br><br>");
out.println("<b>"+"Participants and their Marks"+"</b>"); out.println("<table border=5>");
try
{
Statement stmt=getConnect().createStatement(); 
String query="SELECT * FROM cse";
setRs(stmt.executeQuery(query)); 
out.println("<th>"+"Seat_no"+"</th>");
out.println("<th>"+"Name"+"</th>");
out.println("<th>"+"Marks"+"</th>");
while(getRs().next())
{
out.println("<tr>");
out.print("<td>"+getRs().getInt(1)+"</td>");
out.print("<td>"+getRs().getString(2)+"</td>");
out.print("<td>"+getRs().getString(3)+"</td>");
out.println("</tr>");
}
out.println("</table>");
}
catch(SQLException ex){ } finally
{
try
{
if(             getRs()!=null) {
                    getRs().close();
}
if(             getStmt()!=null) {
                    getStmt().close();
}
if(             getConnect()==null) {
    } else {
                    getConnect().close();
    }
}
catch(SQLException e){ }
}
out.println("</center>");
out.println("</body></html>");
        setTotal(0);
} 

    /**
     * @return the message
     */
    public String getMessage() {
        return message;
    }

    /**
     * @param message the message to set
     */
    public void setMessage(String message) {
        this.message = message;
    }

    /**
     * @return the Seat_no
     */
    public String getSeat_no() {
        return Seat_no;
    }

    /**
     * @param Seat_no the Seat_no to set
     */
    public void setSeat_no(String Seat_no) {
        this.Seat_no = Seat_no;
    }

    /**
     * @return the Name
     */
    public String getName() {
        return Name;
    }

    /**
     * @param Name the Name to set
     */
    public void setName(String Name) {
        this.Name = Name;
    }

    /**
     * @return the ans1
     */
    public String getAns1() {
        return ans1;
    }

    /**
     * @param ans1 the ans1 to set
     */
    public void setAns1(String ans1) {
        this.ans1 = ans1;
    }

    /**
     * @return the ans2
     */
    public String getAns2() {
        return ans2;
    }

    /**
     * @param ans2 the ans2 to set
     */
    public void setAns2(String ans2) {
        this.ans2 = ans2;
    }

    /**
     * @return the ans3
     */
    public String getAns3() {
        return ans3;
    }

    /**
     * @param ans3 the ans3 to set
     */
    public void setAns3(String ans3) {
        this.ans3 = ans3;
    }

    /**
     * @return the ans4
     */
    public String getAns4() {
        return ans4;
    }

    /**
     * @param ans4 the ans4 to set
     */
    public void setAns4(String ans4) {
        this.ans4 = ans4;
    }

    /**
     * @return the ans5
     */
    public String getAns5() {
        return ans5;
    }

    /**
     * @param ans5 the ans5 to set
     */
    public void setAns5(String ans5) {
        this.ans5 = ans5;
    }

    /**
     * @return the Total
     */
    public int getTotal() {
        return Total;
    }

    /**
     * @param Total the Total to set
     */
    public void setTotal(int Total) {
        this.Total = Total;
    }

    /**
     * @return the connect
     */
    public Connection getConnect() {
        return connect;
    }

    /**
     * @param connect the connect to set
     */
    public void setConnect(Connection connect) {
        this.connect = connect;
    }

    /**
     * @return the stmt
     */
    public Statement getStmt() {
        return stmt;
    }

    /**
     * @param stmt the stmt to set
     */
    public void setStmt(Statement stmt) {
        this.stmt = stmt;
    }

    /**
     * @return the rs
     */
    public ResultSet getRs() {
        return rs;
    }

    /**
     * @param rs the rs to set
     */
    public void setRs(ResultSet rs) {
        this.rs = rs;
    }
}