@echo off
REM Script para ejecutar pruebas unitarias - Infix to Postfix Converter

echo.
echo ================================
echo Pruebas Unitarias
echo Infix to Postfix Converter
echo ================================
echo.

REM Limpiar y compilar
echo 📦 Compilando proyecto...
call mvn clean compile

REM Ejecutar pruebas
echo.
echo 🧪 Ejecutando pruebas unitarias...
echo.
call mvn test

REM Mostrar resumen
echo.
echo ================================
echo ✅ Pruebas completadas
echo ================================
echo.
echo Reportes disponibles en: target/surefire-reports/
echo.
pause
