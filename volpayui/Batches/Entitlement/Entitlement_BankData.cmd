call ../Setenv.cmd
set BankData=%Testxmlsuites%/Entitlement

REM Execute Entitlement for Bank Data
cd %POM_DIR%
mvn clean test -DsuiteXmlFile=%BankData%/Entitlement_BankData.xml