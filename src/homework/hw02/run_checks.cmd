@echo off
setlocal
for %%I in ("%~dp0..\..") do set "ROOT=%%~fI"
set "BUILD=%~dp0.build"
where javac >nul 2>nul
if errorlevel 1 (
    echo Missing javac. Install/configure a JDK and reopen your terminal.
    exit /b 2
)
where java >nul 2>nul
if errorlevel 1 (
    echo Missing java. Install/configure a JDK and reopen your terminal.
    exit /b 2
)
if not exist "%BUILD%" mkdir "%BUILD%"
if exist "%BUILD%\homework\hw02" rmdir /s /q "%BUILD%\homework\hw02"
javac -encoding UTF-8 -d "%BUILD%" "%ROOT%\src\homework\hw02\*.java" "%ROOT%\test\homework\hw02\Hw2Checks.java" "%ROOT%\test\homework\hw02\Hw2CheckRunner.java"
if errorlevel 1 exit /b 2
java -cp "%BUILD%" homework.hw02.Hw2CheckRunner
exit /b %ERRORLEVEL%
