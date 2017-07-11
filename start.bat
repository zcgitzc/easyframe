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
ECHO.注意：现在的编译和部署步骤分开，需要先选择编译打包，成功后再选择启动jetty
ECHO.
ECHO 1-生成eclipse工程文件
ECHO.
ECHO 2-增量编译打包
ECHO.
ECHO 3-全量编译打包业务代码（在项目的依赖jar包升级或增量编译有错误时使用）
ECHO.
ECHO 4-全量编译所有代码（包括业务代码，测试代码，黑白名单，用于验证项目的正确性）
ECHO.
ECHO 5-启动tomcat
ECHO.
ECHO 6-热部署（完善中）
ECHO.
ECHO 7-安装和启动nginx（完善中）
ECHO.
ECHO 8-执行所有测试 
ECHO.
ECHO 9-执行子项目测试
ECHO.
ECHO 10-单独编译deploy工程（适用于修改了配置项后的编译）
ECHO.
ECHO 0-退出菜单

set /p isopt=【选择命令】
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

echo "无效选项，请选择(0-9)"
goto mvn_command

:mvn_eclipse
	ECHO.
	ECHO.
	ECHO.
	ECHO 1-第一次生成eclipse工程 (修改了WEB-INF目录下的文件时使用)
	ECHO.
	ECHO 2-重新生成eclipse工程 (仅在pom.xml内添加了依赖时使用)
	ECHO.
	ECHO 0-返回
	set /p eopt=【选择命令】
	if /i "%eopt%"=="1" goto mvn_eclipse_first
	if /i "%eopt%"=="2" goto mvn_eclipse_again
	goto mvn_command

:mvn_eclipse_first
	cd %PROJECT_HOME%
	echo 生成eclipse工程文件
	start /HIGH mvn clean install eclipse:clean eclipse:eclipse -DskipTests -DuserProp=%ANTX_PROPERTY% -Dautoconfig.userProperties=%ANTX_PROPERTY%
	goto mvn_command

:mvn_eclipse_again
	cd %PROJECT_HOME%
	echo 生成eclipse工程文件
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
	echo 开始执行测试
	start /HIGH mvn clean test
	goto mvn_command
	
:mvn_test_project
	set /p subprj=【输入项目路径】
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
