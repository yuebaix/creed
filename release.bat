@echo off
rem #######################################################################################
rem 发布release (kjar使用asm编译字节码的时候不支持中文，不要在变量中用中文)
rem #######################################################################################

rem set /p version=plz set a useful version...:
rem if "%version%"=="" goto releasefailed

set version=1.0-PROD-SNAPSHOT

echo ***************************************************************************************
echo change version to %version%...
echo ***************************************************************************************
call mvn versions:set -DoldVersion=* -DnewVersion=%version% -DprocessAllModules=true -DallowSnapshots=true

rem 确认可以编译通过
echo ***************************************************************************************
echo make sure compile is working
echo ***************************************************************************************
call mvn clean install -DskipTests
if "%errorlevel%"=="1" goto releasefailed
goto releasesuccess

:releasesuccess
rem 检查工程依赖树
echo ***************************************************************************************
echo inspect dependency tree
echo ***************************************************************************************
call mvn dependency:tree -Dverboss -Dincludes=com.jufan.cloud.rules:rules

set /p input=deploy version is %version%,continue?(y/n):
if "%input%"=="n" goto releasefailed
if "%input%" neq "y" echo WRONG INPUT & goto releasefailed

rem 发布动作
echo ***************************************************************************************
echo deploy release...
echo ***************************************************************************************
call mvn clean deploy -DskipTests
if "%errorlevel%"=="1" goto releasefailed

call mvn versions:revert
echo ***************************************************************************************
echo DEPLOY SUCCESS
echo ***************************************************************************************
goto end

:releasefailed
call mvn versions:revert
echo ***************************************************************************************
echo DEPLOY FAIL
echo ***************************************************************************************
goto end

:end
pause > nul