<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Testing</title>
    <style>
        body {
            background-color: #faf0e6;
            margin: auto;
        }

        .button2 {
            height: 25px;
            width: 80px;

        }
    </style>

</head>
<body>
<div align="center">
    <h2 style="color: #8686c8">Тест студента ${student.name}  ${student.surName}</h2>
    <br><br><br>
    <h2>${question.text}</h2>
    <br><br><br>
    <form action="/testAnswer" method="post">

        <#list answers as answer>
            <div>
                <p><input type="radio" name="answer" value="${answer.text}">${answer.text}</p>
            </div>
        </#list>
        <input type="hidden" name="questionId" value="${question.id}">
        <input type="hidden" name="studentId" value="${student.id}">
        <input type="submit" value="Ответить" class="button2">
    </form>
    <div>
    </div>
</div>
</body>
</html>