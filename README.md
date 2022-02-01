OnlineTodo list allows us to add new todos, delete  and view last updated todo. Please follow the below steps to build and install the application.

1. Clone the OnlineTodoList repository with Git clone command.
2. Once a pull is taken in the local, open the project in intellij ultimate. Open a terminal in intellij and do a mvn clean install. This should build all the components from Pom file and load all the target classes.
3. For client to run, we have to make sure that node js is installed in our machine so that npm command works. We can test this by running the command npm --version will display the current version of node js in our local machine.
4. If node js is installed then, open second terminal tab, from root of project do a cd client. Once we are inside client do a npm install to build and load all the node js libraries.
5. After the installtion is complete, we can view the Node_Modules folder inside client.
6. Now we can start our frontend and it can communicate with our rest interface taskcontroller.
7. Go back to the first terminal and type mvn spring-boot:run in the terminal and run the command. This will start the springboot and make our restful services ready to take input. Also it will start the Database.
8. Navigate to the second tab of the terminal opened and run npm start. This will start the react application and the UI will come up.

Database:-
 1. We are using a spring H2 database hence, once spring boot starts the h2 database can be visible on localhost:8080/h2
 2. Once loaded, click on test connection and connect.
 3. On Right hand side we can see the tables whose data can be viewied with sql queries.
 
 Tests: -
 
 Junit tests are avilable and can be run using mvn test

