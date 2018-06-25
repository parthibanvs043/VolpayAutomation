call ../Setenv.cmd
set ReferenceData=%Testxmlsuites%/ReferenceData

REM Execute Reference Data Create Operation
cd %POM_DIR%
mvn clean test -DsuiteXmlFile=%ReferenceData%/Create_ReferenceData.xml"
