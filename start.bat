echo off

SET CMD_HOME=%cd%
SET ANTX_PROPERTY="%CMD_HOME%\antx.properties"
cd %CMD_HOME%

SET PROJECT_HOME=%cd%
ECHO PROJECT_HOME:"%PROJECT_HOME%"

IF [%ANTX_PROPERTY%]==[] SET ANTX_PROPERTY="C:%HOMEPATH%\antx.properties"
ECHO ANTX_PROPERTY:%ANTX_PROPERTY%

set MAVEN_OPTS=-Xms256m -Xmx512m -XX:ReservedCodeCacheSize=64m -XX:MaxPermSize=128m
cd %PROJECT_HOME%

:mvn_command
ECHO.
ECHO.ע�⣺���ڵı���Ͳ�����ֿ�����Ҫ��ѡ����������ɹ�����ѡ������jetty
ECHO.
ECHO 1-����eclipse�����ļ�
ECHO.
ECHO 2-����������
ECHO.
ECHO 3-ȫ��������ҵ����루����Ŀ������jar�����������������д���ʱʹ�ã�
ECHO.
ECHO 4-ȫ���������д��루����ҵ����룬���Դ��룬�ڰ�������������֤��Ŀ����ȷ�ԣ�
ECHO.
ECHO 5-����tomcat
ECHO.
ECHO 6-�Ȳ��������У�
ECHO.
ECHO 7-��װ������nginx�������У�
ECHO.
ECHO 8-ִ�����в��� 
ECHO.
ECHO 9-ִ������Ŀ����
ECHO.
ECHO 10-��������deploy���̣��������޸����������ı��룩
ECHO.
ECHO 0-�˳��˵�

set /p isopt=��ѡ�����
if /i "%isopt%"=="1" goto mvn_eclipse
if /i "%isopt%"=="2" goto mvn_incremental_package
if /i "%isopt%"=="3" goto mvn_full_package
if /i "%isopt%"=="4" goto mvn_compile_all
if /i "%isopt%"=="5" goto run_tomcat
if /i "%isopt%"=="6" goto run_hotswap_jetty 
if /i "%isopt%"=="7" goto httpd_service
if /i "%isopt%"=="8" goto mvn_test_all
if /i "%isopt%"=="9" goto mvn_test_project
if /i "%isopt%"=="10" goto mvn_complie_deploy
if /i "%isopt%"=="0" goto mvn_end

echo "��Чѡ���ѡ��(0-9)"
goto mvn_command

:mvn_eclipse
	ECHO.
	ECHO.
	ECHO.
	ECHO 1-��һ������eclipse���� (�޸���WEB-INFĿ¼�µ��ļ�ʱʹ��)
	ECHO.
	ECHO 2-��������eclipse���� (����pom.xml�����������ʱʹ��)
	ECHO.
	ECHO 0-����
	set /p eopt=��ѡ�����
	if /i "%eopt%"=="1" goto mvn_eclipse_first
	if /i "%eopt%"=="2" goto mvn_eclipse_again
	goto mvn_command

:mvn_eclipse_first
	cd %PROJECT_HOME%
	echo ����eclipse�����ļ�
	start /HIGH mvn clean install eclipse:clean eclipse:eclipse -DskipTests -DuserProp=%ANTX_PROPERTY% -Dautoconfig.userProperties=%ANTX_PROPERTY%
	goto mvn_command

:mvn_eclipse_again
	cd %PROJECT_HOME%
	echo ����eclipse�����ļ�
	start /HIGH mvn eclipse:clean eclipse:eclipse -DskipTests -DuserProp=%ANTX_PROPERTY% -Dautoconfig.userProperties=%ANTX_PROPERTY%
	goto mvn_command

	
:mvn_incremental_package
	cd %PROJECT_HOME%	
	start /HIGH mvn install -Dmaven.test.skip -Pskip.test.resources -DuserProp=%ANTX_PROPERTY% -Dautoconfig.userProperties=%ANTX_PROPERTY%
	goto mvn_command
	

:mvn_full_package
	cd %PROJECT_HOME%
	start /HIGH mvn clean install -DskipTests -DuserProp=%ANTX_PROPERTY% -Dautoconfig.userProperties=%ANTX_PROPERTY%
	goto mvn_command
	
:mvn_compile_all
	cd %PROJECT_HOME%
	start /HIGH mvn clean install -DskipTests=true -Pskip.attach.sources -DuserProp=%ANTX_PROPERTY% -Dautoconfig.userProperties=%ANTX_PROPERTY%
	goto mvn_command
	
:run_tomcat
	cd %CATALINA_HOME%\bin\
	start debug.bat
	goto mvn_command
	
:run_hotswap_jetty
	cd %PROJECT_HOME%\bundle\war
	call mvn compile -DenableHotswap=true -DuserProp=%ANTX_PROPERTY% -Dautoconfig.userProperties=%ANTX_PROPERTY%
	start /HIGH call %PROJECT_HOME%\deploy\target\web-deploy\bin\jettyctl.bat true %PROJECT_HOME%
	goto mvn_command
    
:httpd_service
	cd %PROJECT_HOME%\deploy\target\web-deploy\bin
	start /SEPARATE call httpdService.bat
	goto mvn_command
	
:mvn_test_all
	cd %PROJECT_HOME%
	echo ��ʼִ�в���
	start /HIGH mvn clean test
	goto mvn_command
	
:mvn_test_project
	set /p subprj=��������Ŀ·����
	echo %PROJECT_HOME%\%subprj%
	cd %PROJECT_HOME%\%subprj%
	start /HIGH mvn test
	goto mvn_command	
	
:mvn_complie_deploy
	cd %PROJECT_HOME%\deploy	
	start /HIGH mvn clean install -DskipTests -DuserProp=%ANTX_PROPERTY% -Dautoconfig.userProperties=%ANTX_PROPERTY%
	goto mvn_command
	
:mvn_end
cd %PROJECT_HOME%
