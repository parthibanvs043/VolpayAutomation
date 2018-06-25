call ../Setenv.cmd
set PageValidation=%Testxmlsuites%/PageValidation

REM Execute Page Validation Operation
cd %POM_DIR%
mvn clean test -DsuiteXmlFile=%PageValidation%/PageValidation.xml

