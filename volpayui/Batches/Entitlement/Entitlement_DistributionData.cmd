call ../Setenv.cmd
set DistributionData=%Testxmlsuites%/Entitlement

REM Execute Entitlement for Bank Data
cd %POM_DIR%
mvn clean test -DsuiteXmlFile=%DistributionData%/Entitlement_DistributionData.xml