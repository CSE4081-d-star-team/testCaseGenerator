@ECHO OFF

::change working directory to current file
set location=%cd%
echo %location%
cd %location%

::compiles "calendar related java package files
cd src\export
javac -d ..\..\class\ *.java
echo "exportation files compilation done."

::compiles data related java package files
cd ..\setup
javac -d ..\..\class\ *.java
echo "setup files compilation done."

::compiles interface related java package files 
cd ..\map
javac -cp ..\..\class\ -d ..\..\class\ *.java
echo "map generator files compilation done."

::compiles interface related java package files 
cd ..\ui
javac -cp ..\..\class\ -d ..\..\class\ *.java
echo "ui files compilation done."

::compiles root java pakage files
cd ..
javac -cp ..\class\ -d ..\class\ *.java
echo "root files compilation done."

PAUSE