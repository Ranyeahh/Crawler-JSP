<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Results</title>

        <style>
            body {
                margin:0px;
                background: url(/img/Spider.png) no-repeat;
                background-size:100% 100%;
                background-attachment:fixed;
            }
            .con {
                font-size: 20px;
                position: absolute;
                left: 200px;
                top: 300px;
                width: 500px;
            }
            .box {
                width: 400px;
            }
            .div{
                position:absolute;
                left:200px;
                top: 250px;
                font-size: x-large;
            }
            a{ font-size:20px}
            a:hover{ font-size:50px}
        </style>
    </head>

    <body>
        <div class="con">
            <%--输出一个标题元素 (<h1>)，其内容是变量 message 的值。--%>
            <h1>${message}</h1>

                <div class="box">
                            <pre><%--预格式化文本块,主要负责换行--%>

<%--                                从session里面取出content，直接转换成字符串--%>
                                <% String content = (String) request.getSession().getAttribute("content"); %>
<%--                                防止content为空--%>
                                <% if (content != null && !content.isEmpty()) {
                                    //获取content的长度，然后每20个汉字分段
                                    int length = content.length();
                                    int Size = 40; // 每隔20个汉字分段
                                    for (int i = 0; i < length; i += Size) {
                                        int end = Math.min(i + Size, length);
                                        //关闭 JSP 代码块
                                %>
                                        <%--使用 substring(i, end) 方法获取子字符串--%>
                                        <%= content.substring(i, end) %>
                                        <br>
                                <%
                                        }
                                    }
                                %>
                            </pre>
                </div>
        </div>

        <h3 align="center">如需继续生成Word文档请<a href="index.jsp">返回首页</a></h3>

        <div id="text" class="div">

        </div>

        <script>
            let divTyping = document.getElementById('text')
            let i = 0,
                timer = 0,
                str = 'GROUP MEMBERS:  2206050106徐未然;  2206050105何佳;  2206050108黄玉婷;  2206050201唐子尧'

            function typing () {
                if (i <= str.length) {
                    divTyping.innerHTML = str.slice(0, i++) + '_'
                    timer = setTimeout(typing, 30)
                }
                else {
                    divTyping.innerHTML = str//结束打字,移除 _ 光标
                    clearTimeout(timer)
                }
            }

            typing()
        </script>

    </body>
</html>