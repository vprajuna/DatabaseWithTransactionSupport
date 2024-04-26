# DatabaseWithTransactionSupport
Built an in-memory key-value database.

Author: Prajuna Venkatesan 

Clear instructions of how to run the code: 

    1. Clone the repository and obtain all files onto local host. 
    
    2. Go into src\main\java\org\example. 
        -> Here, there are 3 different files: InMemoryDB.java, Main.java, and memoryDatabase.java. 
        -> InMemoryDB.java contains the definition for the InMemoryDB interface.
        -> Main.java contains the main method that will invoke all required methods of functionality. 
        -> memoryDatabase.java contains the definition for the memoryDatabase class
        
    3. Go to Main.java and run the file. 
    
How this assignment should be modified in order to become an “official” assignment: 

    Although the instructions specify a certain method must return null, it does not specify how to handle those exceptions. Because the code throws an exception, it causes the program to discontinue and the rest of the functionality does not occur. Therefore, having a guideline for a try-cstch block or how to handle the exception will help students run and test their program easily. Additionally, the assignment could have two extra methods like print the database's contents and clear the database's contents, which will help in an "official" assignment because there will be more functionalities to complete than just the ones required for this assignment. Lastly, having the description of each function right under the name of the function in the guidelines will help keep the project spec document organized. 
