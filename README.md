# Java_BC


=============================CodeAsssist====================
Application for students discussing problems regarding tasks as final project in Java Bootcamp 2019. Main purpose of this application is to alleviate participation in Accenture bootcamps by providing internal communication through web application.
Main features of our project are server side database, user creation functionality and opportunity to post issues and reply to them. As one of our projects best features we would like to mention the ease of setting this application on any machine that has JRE or JDK installed on it by simply downloading the files and running one command line from terminal.
============================================================

===========================USERGUIDES=======================
!!!IMPORTANT!!! Ommit all the <> when typing the given commands
To launch this application on your computer you must follow these steps:
  1) have JRE installed. If you don't have JDK or JRE on your machine, please refer to this guide for detailed instructions:
  https://docs.oracle.com/goldengate/1212/gg-winux/GDRAD/java.htm#BGBFJHAB

  2) Download files located in https://drive.google.com/file/d/15NdpO_D_Bo4O0CJqzeVQGtmaVm2h13aH/view?usp=sharing to a folder where you want this application to reside
  3) Open terminal and navigate inside the CodeAssist folder. If you are on Linux you can just open the CodeAssist folder and press F4 to open terminal.
  4) type <java -jar application_name.war> inside terminal
  5) Application should launch and should be accessible from your Web browser
  6) Open Web browser and type <localhost:8080> in your navigation bar
  7) Login as administrator using these credentials:
   Username: admin
   Password: 3qhcGW6R
  8) Navigate to admin page by pressing the link "Go to admin" in your browser
  9) Add all the activities that will be included in your project or class. After that they should appear on the left side bar of every other navigation page.
  10) Application is ready for students to use
  11) You will need to give students IPv4 address (SERVER_IP_ADDRESS in following text) of the server so they are able to connect. You can get IP address by:
      11.1) On Linux OS open terminal and type <ifconfig>
            You can locate your Ethernet adress after tag 'inet adrr:'
      11.2) On Windows OS open command line terminal and type <ipconfig>
            You can locate it after tag 'IPv4 Address..:'
  12) Give students the SERVER_IP_ADDRESS 
  
After following these steps new users will be able to register and use the functionality of CodeAssist application.
Student should follow these steps to be able to use this application:
  1) Open their web browser
  2) Connect to the application server by typing <SERVER_IP_ADDRESS:8080>
  3) Register their account and they are ready to go


To access database of all the users and their created issues follow these steps:
  1) Open H2-database in your web browser by typing <http://localhost:8080/h2-console> in navigation bar or press the button through admin page
  2) Make sure you use these settings in the required fields:
    Saved Settings: Generic H2 (Embedded)
    Setting Name: Generic H2 (Embedded)
    Driver Class: org.h2.Driver
    JDBC URL: jdbc:h2:file:./src/resources/yourdbname
    User Name: admin
    Password: 3qhcGW6R
 3) You should now be able to access database and manually configure or delete unnecessary data.
 4) !!!IMPORTANT!!! Don't delete admin entry from USERS_TABLE as it will delete the admin account. Don't delete any role from ROLE_TABLE as it will break the application.
==========================================================
