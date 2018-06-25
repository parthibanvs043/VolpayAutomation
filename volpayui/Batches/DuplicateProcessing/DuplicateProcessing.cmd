call ../Setenv.cmd
set Duplicate=%Testxmlsuites%/DuplicateProcessing

REM Execute DuplicateProcessing for File and Payment
cd %POM_DIR%
mvn clean test -DsuiteXmlFile=%Duplicate%/DuplicateProcessing.xml