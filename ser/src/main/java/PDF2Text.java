import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.font.PDType0Font;
import org.apache.pdfbox.text.PDFTextStripper;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

//将PDF相关的功能集中在一个类中
public class PDF2Text {
    private static String font_path = "D:/SimSun.ttf"; // 定义字体文件路径
    //要使用支持中文的类生成PDF

    //主要方法：writeToPdf静态方法，才能将给定的文本写入PDF
    public static void writeToPdf(String contentStr, String pdfPath) throws IOException {
        if (contentStr == null || contentStr.isEmpty()) { // 检查内容是否为空
            throw new IllegalArgumentException("内容不能为空"); // 如果为空，抛出异常
        }

        PDDocument document = new PDDocument(); // 创建新的PDF文档
        PDPage page = new PDPage(); // 创建新的PDF页面
        document.addPage(page); // 将页面添加到文档中

        //如果不加载这个支持中文的字体，那么TimeRoman字体会乱码，运行不了
        PDType0Font font = PDType0Font.load(document, new File(font_path)); // 加载字体

        // PDPageContentStream创建内容流
        try (PDPageContentStream content = new PDPageContentStream(document, page)) {
            content.beginText(); // 开始文本内容
            content.setFont(font, 12); // 设置字体和字体大小
            content.newLineAtOffset(80, 750); // 设置文本起始位置

            //如果不分割内容为多行，就会超出PDF宽度
            List<String> lines = split(contentStr, 35); // 将内容分割成多行

            for (String line : lines) { // 遍历每一行
                content.showText(line); // 显示文本行
                content.newLineAtOffset(0, -25); // 换行，设置新行位置
            }

            content.endText(); // 结束文本内容
        }

        document.save(pdfPath); // 保存PDF文档到指定路径
        document.close(); // 关闭文档
        System.out.println("写入PDF成功"); // 输出成功信息
    }

    // 辅助方法：将文本内容按指定长度分割成多行
    private static List<String> split(String text, int maxLength) {
        List<String> lines = new ArrayList<>(); // 创建顺序表，保存行
        if (text == null || text.isEmpty()) { // 检查文本是否为空
            return lines; // 如果为空，返回空列表
        }

        int index = 0; // 初始化索引
        while (index < text.length()) { // 遍历文本
            lines.add(text.substring(index, Math.min(index + maxLength, text.length()))); // 按指定长度分割文本
            index += maxLength; // 更新索引
        }
        return lines; // 返回分割后的行列表
    }

    //嵌套的一个内部类，用于将PDF文件转换为文本文件
    public static class PDF2Word {
        // 静态方法：将PDF转换为Word，接受PDF路径和Word路径作为参数
        public static void convertPdfToWord(String pdfPath, String wordPath) {
            try {
                PDDocument doc = PDDocument.load(new File(pdfPath)); // 加载PDF文档
                int pagenumber = doc.getNumberOfPages(); // 获取PDF文档的页数

                File file = new File(wordPath); // 创建一个Word文件对象
                if (!file.exists()) {
                    file.createNewFile(); // 如果Word文件不存在就创建新文件
                }

                FileOutputStream fos = new FileOutputStream(wordPath); // 创建文件输出流，指向Word文件
                Writer writer = new OutputStreamWriter(fos, "UTF-8"); // 创建写入器，设置编码为UTF-8
                PDFTextStripper stripper = new PDFTextStripper(); // 创建PDF文本提取器

                stripper.setSortByPosition(true); // 设置按位置排序文本
                stripper.setStartPage(1); // 设置开始页码
                stripper.setEndPage(pagenumber); // 设置结束页码
                stripper.writeText(doc, writer); // 提取PDF文本并写入Word文件

                writer.close(); // 关闭写入器
                doc.close(); // 关闭PDF文档

                System.out.println("PDF转换为文本成功！"); // 输出转换成功信息

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}