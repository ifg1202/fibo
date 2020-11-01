# fibo

Fibonacci Project.

There are two branches. 

 **main**) Contains the solution by "the classic" layer architecture.
 
 **hexagonal**) Contains the solution by hexagonal architecture.
 
 If you need to change branch you must issue the following git command:
 
 **git checkout [branch]**
 
 Where [branch] could be either main or hexagonal.
 
# Code Coverage

If you want to know the code coverage you could issue the next maven command:

**mvn verify**

If everything is OK, you should see the coverage in the file target/site/jacoco/index.html

# Building

To build the code, open a command-line window change to the directory where you have downloaded the fibo source code.

Run the following maven command. 

**mvn clean package**

If everything builds successfully you should see a message indicating that the build was successful.

# Running the services

Now we are going to use java command to start the project.  To start the project, issue the following java command:

**java -jar target/fibo-0.0.1-SNAPSHOT.jar**

If everything starts correctly you should see a bunch of Spring Boot fibo project by on standard out.  At this point all of the services needed will be running.

In terminal you can run the following command (You can use Postman):

**curl --request GET localhost:8080/v1/fibonacci/{element}**

Where {element} can be any Natural number.

Example:

If {element} = 654, then

**curl --request GET localhost:8080/v1/fibonacci/654**
