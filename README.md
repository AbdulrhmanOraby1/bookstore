Steps To Run The APP

Install MySQL in your laptop if you do not have one. You can download it from here: https://www.mysql.com/downloads/
In your MySQL workbench make a database named: bookstore
Now in your IDE, open the application.yaml file, change the spring datasource url, username and password. Right now the spring datasource url=”jdbc:mysql://localhost:3306/bookstore” which is likely to be same in your case too. If not please put on your datasource url. Right now Spring datasource name is “root” and password is “admin” which is likely to change in your case. Please put on your database username and password in these fields.
Now you can run your application. The table “book” will be automatically created in “bookstore”. By default, it runs in port:9999. You can open up the swagger ui from following url: http://localhost:9999/swagger-ui.html .
Once you have set up your database, you can also run the unit tests.
You can also use jacoco plugins to generate unit test reports. For that go to the project root folder and run the following two commands in command prompt:
mvn clean test
mvn jacoco:report

Tools/Frameworks

MYSQL: MYSQL is a open-source relational database management system.
JPA: Java Persistence API(JPA) is a Java programming interface specification that describes the management of relational data in applications using Java Platform.
JUNIT/Mockito: Junit is the unit testing framework for the Java programming language. Mockito is a mocking framework.
Jacoco: Jacoco is a Java Code Coverage tool. The jacoco maven plugin is used in this project. This generate unit test code coverage report.


Functionality

BookStore uses MySql and consists of database named “bookstore” which has only one table named: “book”. The book table consist of following columns: 1)id 2)author 3)title 4)category 5)price 6)total_count 7)sold. ‘total_count’ and ‘sold’ column helps to keep the records of the book in the store. Jpa/Hibernate is used to communicate with database. In java project the database structure is present in “domain” folder. BookStore supports following functionality:

Addition of book: Addition of book is done by two end points.
“/api/add-new-book”: If the book is not registered before, it should be registered and the amount of books to be added can be specified.
“api/add-book”: For the book that are already registered into database, you can just add amount of books to be added to the already registered book.
Get book by Id: It gets all the detail of book for that id. The end point for this function is:”/api/book/{id}”. Here id is the path variable.
Get All Books: It gets all the books that are registered. The url for this function is: “/api/book-list”.
Get Number of books available by id: The end point for this function is:”/api/number-of-books/{id}”. Here id is the path variable.
Update a book: The end point is “/api/books/{id}” where id is path variable. Here we pass the BookDto object too. While updating if “id” in the BookDto is changed and doesn’t match with the path variable “id” in the url, it gives exception. While updating if “id” in the bookDto object is removed, it still updates other field updated in the id of the path variable.
Sell a Book: The end point is “/api/sell-book/{id}”. Here the id is path variable. It will sell one book of given id at a time. If there is no book to sell, it will throw exception.
Sell List of Books:The end point is “/api/sell-books”. Here the List of SellDto object is passed on request body. SellDto object specifies the book id and the number of copies of that book, we want to sell. If there is enough book, it throws exception.
Get books by category and keyword: The end point is “/api/books?keyword=keyword&category=category”. It has two request param-keyword and category. Category represents the 9 categories of books. Keyword is assumed to be any group of strings in id, author or title.
Get Number of books sold per category and keyword: The end point is “/api/number-of-books?keyword=keyword&category=category”.
Unit Tests: The unit test is done in service and controller level. In Controller level, the unit test is done using mockMvc, Mockito and junit. In Service level, the unit test is done using junit. It has over 89% line code coverage. Jacoco can also be used to generate unit test report. For more information on jacoco look into step 8 of section:Steps to run the application.
