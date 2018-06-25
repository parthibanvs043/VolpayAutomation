call ../Setenv.cmd
set ReferenceData=%Testxmlsuites%/ReferenceData

REM Execute Bank Data Update Operation
cd %POM_DIR%
mvn clean test -DsuiteXmlFile=%ReferenceData%/ReferenceData_Edit.xml