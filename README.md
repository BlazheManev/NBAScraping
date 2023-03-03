# NBAScraping
This program takes a NBA player name as a command-line argument and prints out the 3-pointers average the player managed for each season data is available for, during the regular season, per 40 minutes. The program performs web scraping on https://stats.nba.com to extract the information.
Installation

    1.Download and install the latest version of Java.
    2.Download the ChromeDriver executable that matches your version of Google Chrome and save it to your machine.
    3.Clone or download the repository to your local machine.
    4.Navigate to the project directory on your terminal/command prompt.

#Usage

    Open the command prompt and navigate to the project directory.
    Run the program by typing mvn exec:java -Dexec.args="PLAYER_NAME" where PLAYER_NAME is the name of the NBA player you want to search for. For example, to search for Luka Doncic, you would type mvn exec:java -Dexec.args="Luka Doncic".
    The program will print out the 3-pointers average the player managed for each season data is available for, during the regular season, per 40 minutes.

#Notes

    Make sure that you have added the path to the ChromeDriver executable in your system's PATH environment variable or specify the path of the Chromedriver executable in the code before running the program.
    The program uses Selenium WebDriver and Jsoup libraries for web scraping. These dependencies are managed through Maven and will be automatically downloaded and installed when you run the program for the first time.
    The program uses the NBA stats website https://stats.nba.com for web scraping. If the website structure or URLs change, the program may not work properly.
