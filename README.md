#1 Описание задания:
В ресурсах хранятся вопросы и различные ответы к ним в виде CSV файла (5 вопросов).
Вопросы могут быть с выбором из нескольких вариантов или со свободным ответом - на Ваше желание и усмотрение.
Приложение должно просто вывести вопросы теста из CSV-файла с возможными вариантами ответа (если имеются).

Реализовано консольное приложение. Запуск приложения осуществляется через IDE или через запуск jar файла   java -jar .\target\task-matest-1.0-SNAPSHOT.jar
При старте приложения выводиться строка привествия
Hello! Are you ready? Yes(Y/y) or No(N/n)?
А затем по одному вопросы с вариантами ответов
1 Question:  What is a correct syntax to output "Hello World" in Java?
Select the correct answer number
0. echo("Hello world")
1. Console.WriteLine("Hello world")
2. System.out.println("Hello world")
После ответа на все  вопросы выдается информация о количестве правильных ответов.
   Count of correct answers is: 2


