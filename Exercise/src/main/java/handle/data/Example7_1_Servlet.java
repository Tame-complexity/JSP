package handle.data;

import save.data.Example7_1_Bean;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
/**
 * @author linshengqian
 */
public class Example7_1_Servlet extends HttpServlet{
   @Override
   public void init(ServletConfig config) throws ServletException{
       super.init(config);
   }
   @Override
   public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException,IOException{
       Example7_1_Bean digitBean = null;
       digitBean = new Example7_1_Bean();  //创建Javabean对象.
       //digitBean 是request bean:
       request.setAttribute("digitBean",digitBean);
       String str1 = request.getParameter("numberOne");
       String str2 = request.getParameter("numberTwo");
       if(str1==null||str2==null) {
           return;
       }
       if(str1.length()==0||str2.length()==0) {
           return;
       }
       double numberOne = Double.parseDouble(str1);
       double numberTwo = Double.parseDouble(str2);
       String operator = request.getParameter("operator");
       double result=0;
       if(operator.equals("+")) {
           result = numberOne+numberTwo;
       } else if(operator.equals("-")) {
           result = numberOne-numberTwo;
       } else if(operator.equals("*")) {
           result = numberOne*numberTwo;
       } else if(operator.equals("/")) {
           result = numberOne/numberTwo;
       }
       digitBean.setNumberOne(numberOne); //将数据存储在digitBean中 
       digitBean.setNumberTwo(numberTwo);  
       digitBean.setOperator(operator);   
       digitBean.setResult(result); 
       //请求example7_1.jsp显示digitBean中的数据:
       RequestDispatcher dispatcher= request.getRequestDispatcher("example7_1.jsp");
       dispatcher.forward(request,response);
   } 
   @Override
   public  void  doGet(HttpServletRequest request, HttpServletResponse response)throws ServletException,IOException{
       doPost(request,response);
   }
} 
