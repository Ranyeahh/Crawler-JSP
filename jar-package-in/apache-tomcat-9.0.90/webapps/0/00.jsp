<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html>
<html lang="zh-CN">
<head>
    <meta charset="UTF-8">
    <title>JSP 标签初学者指南</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f4f4f4;
        }
        table {
            width: 100%;
            border-collapse: collapse;
        }
        th, td {
            padding: 10px;
            border: 1px solid #ddd;
        }
        th {
            background-color: #4CAF50;
            color: white;
        }
        td {
            text-align: center;
        }
    </style>
</head>
<body>
    <h1>JSP 标签初学者指南</h1> <!-- 标题 -->
    <table>
        <tr>
            <th>标签</th> <!-- 表头 -->
            <th>示例</th> <!-- 表头 -->
            <th>说明</th> <!-- 表头 -->
        </tr>
        <tr>
            <td>&lt;a&gt;</td> <!-- 超链接标签 -->
            <td><a href="https://www.example.com" target="_blank">示例链接</a></td> <!-- 链接示例，打开新窗口 -->
            <td>超链接，用于跳转到另一个页面</td> <!-- 说明 -->
        </tr>
        <tr>
            <td>&lt;button&gt;</td> <!-- 按钮标签 -->
            <td><button>示例按钮</button></td> <!-- 按钮示例 -->
            <td>按钮元素</td> <!-- 说明 -->
        </tr>
        <tr>
            <td>&lt;input type="text"&gt;</td> <!-- 输入标签 -->
            <td><input type="text" placeholder="请输入文本"></td> <!-- 输入示例 -->
            <td>输入框，用于接收用户输入</td> <!-- 说明 -->
        </tr>
        <tr>
            <td>&lt;input type="radio"&gt;</td> <!-- 单选按钮标签 -->
            <td>
                <input type="radio" name="option" value="1"> 选项 1
                <input type="radio" name="option" value="2"> 选项 2
            </td> <!-- 单选按钮示例 -->
            <td>单选按钮，用于选择一个选项</td> <!-- 说明 -->
        </tr>
        <tr>
            <td>&lt;input type="checkbox"&gt;</td> <!-- 复选框标签 -->
            <td>
                <input type="checkbox" name="check1" value="A"> 选项 A
                <input type="checkbox" name="check2" value="B"> 选项 B
            </td> <!-- 复选框示例 -->
            <td>复选框，用于选择多个选项</td> <!-- 说明 -->
        </tr>
        <tr>
            <td>&lt;select&gt;</td> <!-- 下拉菜单标签 -->
            <td>
                <select>
                    <option value="1">选项 1</option>
                    <option value="2">选项 2</option>
                    <option value="3">选项 3</option>
                </select>
            </td> <!-- 下拉菜单示例 -->
            <td>下拉菜单，用于选择一个选项</td> <!-- 说明 -->
        </tr>
        <tr>
            <td>&lt;img&gt;</td> <!-- 图片标签 -->
            <td><img src="https://via.placeholder.com/100" alt="示例图片"></td> <!-- 图片示例 -->
            <td>图片元素</td> <!-- 说明 -->
        </tr>
        <tr>
            <td>&lt;p&gt;</td> <!-- 段落标签 -->
            <td><p>这是一个段落。</p></td> <!-- 段落示例 -->
            <td>段落元素，用于文本内容</td> <!-- 说明 -->
        </tr>
        <tr>
            <td>&lt;h1&gt; - &lt;h6&gt;</td> <!-- 标题标签 -->
            <td>
                <h1>标题 1</h1> <!-- 标题 1 示例 -->
                <h2>标题 2</h2> <!-- 标题 2 示例 -->
                <h3>标题 3</h3> <!-- 标题 3 示例 -->
            </td>
            <td>标题元素，从 <code>&lt;h1&gt;</code> 到 <code>&lt;h6&gt;</code> 逐级递减</td> <!-- 说明 -->
        </tr>
    </table>
</body>
</html>
