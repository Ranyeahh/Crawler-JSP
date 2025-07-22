import org.apache.log4j.BasicConfigurator;
import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.Spider;
import us.codecraft.webmagic.pipeline.ConsolePipeline;
import us.codecraft.webmagic.pipeline.JsonFilePipeline;
import us.codecraft.webmagic.processor.PageProcessor;

import java.io.IOException;

// 定义实现PageProcessor接口的Process类
public class Process implements PageProcessor {
    // 配置站点信息，设置重试次数、睡眠时间和字符编码
    private Site site = Site.me().setRetryTimes(1).setSleepTime(1000).setCharset("UTF-8");
    private String content; // 定义用于存储内容的字符串变量

    @Override
    public void process(Page page) { // 实现process方法，处理页面
        // 打印抓取到的HTML内容
        System.out.println(page.getHtml().toString()); // 输出抓取到的HTML内容

        // 使用正确的选择器提取内容
        String title = page.getHtml().xpath("//h2[@class='arti_title']/text()").toString(); // 提取文章标题
        page.putField("title", title); // 将标题存储到结果字段中

        content = page.getHtml().xpath("//meta[@name='description']/@content").toString(); // 提取文章描述内容
        page.putField("content", content); // 将内容存储到结果字段中

        // 如果内容为空，尝试使用其他选择器
        if (content == null || content.isEmpty()) { // 检查内容是否为空
            content = page.getHtml().xpath("//body//p/text()").all().toString(); // 如果为空，使用其他选择器提取内容
        }
    }

    @Override
    public Site getSite() { // 实现getSite方法，返回站点信息
        return site; // 返回配置的站点信息
    }

    public String getContent() { // 定义获取内容的方法
        return content; // 返回提取到的内容
    }

    public static void main(String[] args) throws IOException { // 定义主方法，抛出IOException
        BasicConfigurator.configure(); // 配置log4j
    }
}