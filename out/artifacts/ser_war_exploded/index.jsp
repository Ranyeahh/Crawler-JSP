<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Crawler</title>

  <style>
    body {
      margin:0px;
      background: url(/img/Crawler.png) no-repeat;
      background-size:100% 100%;
      background-attachment:fixed;
    }
    .addandinput{
      font-size:60px;
      position:absolute;
      left:200px;
      top: 600px;
    }
    .butt{
      color: rgba(23, 23, 23, 0.855);
      background-color: rgb(255, 191, 0);
      padding: 10px;
      font-size: x-large;
      border-radius: 30px;
    }
  </style>
</head>
<body>

<form action="processForm" method="post">

  <!-- 文本输入框 -->
  <div class="addandinput">
    <input type="text" id="address" name="address" required style="width: 600px; height: 40px; border-radius: 30px;">
    <br>
    <button class="butt" type="submit" >提取内容并输出PDF</button>
    <button class="butt" type="button" onclick="PDF2Word()">转为WORD</button>
    <button class="butt" type="button" onclick="PDF2Text()">转为TXT</button>
  </div>

  <script>

    function PDF2Text() {
      // 使用 fetch 函数发送一个 POST 请求到 'pdf2text' 端点
      fetch('pdf2text', { method: 'POST' })
              // 当服务器响应后，将响应转换为文本
              .then(response => response.text())
              // 将转换后的文本数据打印到控制台
              .then(data => console.log(data))
              // 如果请求过程中发生错误，捕获并打印错误信息
              .catch(error => console.error('Error:', error));
    }

    function PDF2Word() {
      // 使用 fetch 函数发送一个 POST 请求到 'pdf2word' 端点
      fetch('pdf2word', { method: 'POST' })
              // 当服务器响应后，将响应转换为文本
              .then(response => response.text())
              // 将转换后的文本数据打印到控制台
              .then(data => console.log(data))
              // 如果请求过程中发生错误，捕获并打印错误信息
              .catch(error => console.error('Error:', error));
    }
  </script>

</form>
</body>
</html>
