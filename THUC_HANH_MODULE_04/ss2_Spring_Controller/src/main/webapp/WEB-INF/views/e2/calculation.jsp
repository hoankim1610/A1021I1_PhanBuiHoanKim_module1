<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<div style="display: block; text-align: -webkit-center">
    <h3>Calculation</h3><br>
    <hr>
    <form action="/calculation" method="post">
        <table>
            <tr>
                <td colspan="2">
                    <input type="text" name="number1" required style="width: 100%">
                </td>
                <td colspan="2">
                    <input type="text" name="number2" required style="width: 100%">
                </td>
            </tr>
            <tr>
                <td>
                    <button type="submit" name="cal" value="addition">Addition</button>
                </td>
                <td>
                    <button type="submit" name="cal" value="subtraction">Subtraction</button>
                </td>
                <td>
                    <button type="submit" name="cal" value="multiplication">Multiplication</button>
                </td>
                <td>
                    <button type="submit" name="cal" value="division">Division</button>
                </td>
            </tr>
        </table>
    </form>
    <output name="result">Result: ${result}</output>
</div>
</body>
</html>
