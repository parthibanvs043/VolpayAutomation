call ../Setenv.cmd
set OnboardingData=%Testxmlsuites%/Entitlement

REM Execute Entitlement for Bank Data
cd %POM_DIR%
mvn clean test -DsuiteXmlFile=%OnboardingData%/Entitlement_OnboardingData.xml