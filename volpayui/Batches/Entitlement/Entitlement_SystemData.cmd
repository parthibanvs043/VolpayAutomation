call ../Setenv.cmd
set SystemData=%Testxmlsuites%/Entitlement

REM Execute Entitlement for Bank Data
cd %POM_DIR%
mvn clean test -DsuiteXmlFile=%SystemData%/Entitlement_SystemData.xml