call ../Setenv.cmd
set ReferenceData=%Testxmlsuites%/ReferenceData

REM Execute Bank Data Delete Operation
cd %POM_DIR%
mvn clean test -DsuiteXmlFile=%ReferenceData%/ReferenceData_Delete.xml

