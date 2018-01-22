import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/calc")
public class CalcServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      Integer first = Integer.valueOf(request.getParameter("x"));
      Integer second = Integer.valueOf(request.getParameter("y"));
      String operation = request.getParameter("op");
      int sum = 0;
        if(operation.equals("plus")){
            sum = first + second;
        }
        if(operation.equals("minus")){
            sum = first - second;
        }
        if(operation.equals("divide")){
            sum = first / second;
        }
        if(operation.equals("multiply")){
            sum = first * second;
        }
        RequestDispatcher dispatcher = request.getRequestDispatcher("result.jsp");
        request.setAttribute("sum", sum);
        dispatcher.forward( request, response );


    }
    }


