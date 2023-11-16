<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Testing Application</title>
    <style>
        body {
            background-color: #faf0e6;
            margin: auto;
        }
    </style>

</head>

<body>
<div align="center">
    <h2 style="color: #8686c8">Регистрация студента</h2>
    <br>
    <br>
    <br>

    <div>

        <form action="/registration" method="post">
            Введите имя:<br>
            <input type="text" name="name">
            <br><br>
            Введите фамилию:<br>
            <input type="text" name="surName">
            <br><br><br>

            <input type="submit" value="Начать тест">
        </form>

    </div>

</div>

</body>
</html>
