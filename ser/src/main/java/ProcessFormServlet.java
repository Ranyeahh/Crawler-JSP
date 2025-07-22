import us.codecraft.webmagic.Spider;
import us.codecraft.webmagic.pipeline.ConsolePipeline;
import us.codecraft.webmagic.pipeline.JsonFilePipeline;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

//声明一个Servlet,并指定其访问URL为/processForm
@WebServlet("/processForm")
//覆写doPost方法,处理POST请求
public class ProcessFormServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8"); //确保请求使用UTF-8,才能正确输出中文
        //从请求中获取address值
        String address = request.getParameter("address");

        //创建Process类的实例，和一个Spider对象
        Process process = new Process();
        Spider.create(process)
                //添加需要爬取的URL地址
                .addUrl(address)
                //添加一个 ConsolePipeline，将爬取的数据输出到控制台
                .addPipeline(new ConsolePipeline())
                //添加一个 JsonFilePipeline，将爬取的数据保存到指定目录中的JSON文件
                .addPipeline(new JsonFilePipeline("D:\\data\\webmagic"))
                //线程为2，运行
                .thread(2)
                .run();
        //获取爬取到的内容
        String content = process.getContent();
        //设置响应的内容类型为 HTML，字符编码为 UTF-8
        response.setContentType("text/html; charset=UTF-8");
        response.setCharacterEncoding("UTF-8");

        
        //获取当前请求的会话对象
        HttpSession session = request.getSession();
        //设置会话属性 message
        if (content == null || content.isEmpty()) {
            session.setAttribute("message", "未能提取到内容。请检查输入地址是否正确。");
        } else {
            session.setAttribute("message", "提取到的内容如下：");
            session.setAttribute("content", content);

            // 输出提取到的内容以进行调试
            System.out.println("提取到的内容：" + content);

            // 将内容写入PDF
            String pdfPath = "D:/data/test.pdf";
            PDF2Text.writeToPdf(content, pdfPath);
        }

        // 请求转发到结果页面
        request.getRequestDispatcher("/result.jsp").forward(request, response);
    }
}
