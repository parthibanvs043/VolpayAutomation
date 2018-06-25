call ../Setenv.cmd
set BankData=%Testxmlsuites%/PageValidation

REM Execute PageValidation for Bank Data
cd %POM_DIR%
mvn clean test -DsuiteXmlFile=%BankData%/PageValidation.xml