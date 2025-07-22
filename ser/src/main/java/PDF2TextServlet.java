import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

//声明了一个 Servlet，并指定其访问URL为/pdf2text
@WebServlet("/pdf2text")
public class PDF2TextServlet extends HttpServlet {
    //覆写HttpServlet类的doPost方法，处理POST请求
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String pdfPath = "D:/data/test.pdf";
        String textPath = "D:/data/test.txt";

        //将指定路径的PDF文件转换为文本文件
        PDF2Text.PDF2Word.convertPdfToWord(pdfPath, textPath);
        //设置响应的内容类型为纯文本
        response.setContentType("text/plain");
        response.getWriter().write("PDF转换为txt完成。");
    }
}
