# BookShop

Использованные инструменты, фреймворки и технологии:

-Spring Data JPA

-Spring MVC

-Spring Boot

-thymeleaf

-MySQL

-HTML

-CSS

-Docker





Схема БД:



![image](https://github.com/user-attachments/assets/86ebc0e1-f351-44d7-9c3c-5dc1a4cc98d9)









Путь до скрипта создания бд:  src/main/resources/sql/databaseScript.sql

Путь до начальны данных к бд:  src/main/resources/sql/data.sql

Есть docker-compose файл с СУБД MySQL:  docker-compose.yml


Небольшой обзор:

http://localhost:8080/books - главаная страница


![image](https://github.com/user-attachments/assets/d43edeb8-97d7-40e8-b5fc-42afc0bcb3f3)



http://localhost:8080/genres - выбрать книги по жанру



![image](https://github.com/user-attachments/assets/2a8a0aeb-3830-4f74-a4bd-87f9c4cf8558)


http://localhost:8080/authors - аналогично по автору


![image](https://github.com/user-attachments/assets/bccaa598-a8f8-4b88-b40b-c7688a38b0ac)



http://localhost:8080/basket - корзина


![image](https://github.com/user-attachments/assets/d7169c1c-10ac-4948-883e-d599dc6eee89)



http://localhost:8080/search?str=Ма - найти книги в поисковой строке


![image](https://github.com/user-attachments/assets/92d2d27a-9f1a-423f-b1ad-c1fd1f3ecb99)


http://localhost:8080/book/Мастер%20и%20Маргарита?id=1 - дополнительное описание книги


![image](https://github.com/user-attachments/assets/6d3c0199-b35e-4fcd-8c98-4d7109a28934)


http://localhost:8080/admin?login=login&password=password - страница администратора, где можно добавить или удалить книгу, жанр или автора


![image](https://github.com/user-attachments/assets/00eda88f-60ec-4bec-b021-318b8cd5becb)























