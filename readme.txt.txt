Load Data
------------
CSV file is added in the project root folder. Once user performs search operation, data from CSV file will be loaded automatically.

Run The Program
-----------------
1. Download the Project into local machine
2. Open Command Prompt and Navigate to project folder.
3. Enter command 
	javac csvSearchCriteria.java
4. Once compilation done, provide below commands for search
	java csvSearchCriteria.java "Bank Name"="Awesome Bank"
	java csvSearchCriteria.java "Bank Name"="Awesome Bank" Type=ATM
	java csvSearchCriteria.java "Bank Name"="Awesome Bank" State=NY "Zip code"=10021
	java csvSearchCriteria.java State=NY City="New York"
   NOTE: Include the parameters in Double quotes(") if any space

Unit Testing
--------------
 Will use Junit for testing java applications. Will create a seperate test class and provides possible scenarios 
 like, Giving valid/In valid header column name, valid/In valid data