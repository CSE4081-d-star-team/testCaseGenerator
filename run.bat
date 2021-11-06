@ECHO OFF

::change working directory to current file
set location=%cd%
echo %location%
cd %location%

java -classpath class\ src.MapGenerator

PAUSE