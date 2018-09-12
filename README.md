Selenium Tests:	

This code repository contains Selenium tests for the eBay website.
It will help you to run your tests parallel using TestNG (for Firefox and Chrome browsers).
 
Dependencies:

Make sure you have Java (preferably java 8) & Maven installed and path configure on your system, if not follow the vendor instructions for installing them on your operating system.

Working Docker Setup (Optional): 
Good to have otherwise you can run standalone selenium server to run the tests.

Starting Selenium Server Hub : 

Docker :

Under <Project>/grid folder there is docker compose file to start the selenium grid.
Command : docker-compose up -d

Without Docker : 

In command line navigate to "<Project>/grid"
Run command : 
java -jar -Dwebdriver.gecko.driver=../src/main/resources/geckodriver -Dwebdriver.chrome.driver=../src/main/resources/chromedriver selenium-server-standalone-3.14.0.jar

Or run ./runSeleniumServer.sh 

Note: 
( add +X {execute mode} while running) 

Check selenium grid is up and running on local or in remote machine:
http://localhost:4444/grid/console
http://<remote-machine-ip>:4444/grid/console



Running Tests:

After checking out the code build the project using :
Run command(inside the project folder where pom.xml file is located) : mvn clean install -DskipTests ( make sure maven is installed and configure)

Running tests using eclipse : 

        1. Make sure you have eclipse with testng plugin installed.
        2. Go to Project : right click on  "parallel-test.xml" and run as testng.
	
Running tests using command line( can be used when wish to run the tests in CI/CD) :

        1. Go to project folder(which has pom file)
        2. run maven command : mvn test

NOTE:
added support: Simulate Mobile Devices with Device Mode(Chrome)
