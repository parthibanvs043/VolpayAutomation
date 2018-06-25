call ../Setenv.cmd
set ReferenceData=%Testxmlsuites%/ReferenceData

REM Execute Bank Data Create Operation
cd %POM_DIR%
mvn clean test -DsuiteXmlFile=%ReferenceData%/ReferenceData_Create.xml
