call ../Setenv.cmd
set Profile=%Testxmlsuites%/Modules/Home

REM Execute Landing Page Validation Operation
cd %POM_DIR%
mvn clean test -DsuiteXmlFile=%Profile%/MyProfile.xml