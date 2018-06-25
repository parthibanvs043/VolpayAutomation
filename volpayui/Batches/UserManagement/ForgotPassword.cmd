call ../Setenv.cmd
set UserManagement=%Testxmlsuites%/UserManagement

REM Execute Bank Data Create Operation
cd %POM_DIR%
mvn clean test -DsuiteXmlFile=%UserManagement%/ForgotPassword.xml
