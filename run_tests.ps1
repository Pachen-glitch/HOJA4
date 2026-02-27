# PowerShell script para ejecutar pruebas unitarias
# Infix to Postfix Converter

Write-Host ""
Write-Host "================================" -ForegroundColor Cyan
Write-Host "Pruebas Unitarias" -ForegroundColor Cyan
Write-Host "Infix to Postfix Converter" -ForegroundColor Cyan
Write-Host "================================" -ForegroundColor Cyan
Write-Host ""

# Variables
$projectPath = Get-Location
$testReportsPath = Join-Path $projectPath "target\surefire-reports"

# Compilar
Write-Host "📦 Compilando proyecto..." -ForegroundColor Yellow
mvn clean compile

# Ejecutar pruebas
Write-Host ""
Write-Host "🧪 Ejecutando pruebas unitarias..." -ForegroundColor Yellow
Write-Host ""
mvn test

# Crear resumen
Write-Host ""
Write-Host "================================" -ForegroundColor Green
Write-Host "✅ Pruebas completadas" -ForegroundColor Green
Write-Host "================================" -ForegroundColor Green
Write-Host ""

# Mostrar información
if (Test-Path $testReportsPath) {
    Write-Host "📊 Reportes disponibles en:" -ForegroundColor Green
    Write-Host "   $testReportsPath" -ForegroundColor Cyan
    Write-Host ""
    
    $xmlReports = Get-ChildItem $testReportsPath -Filter "*.xml" | Measure-Object
    Write-Host "   📄 Archivos de reporte: $($xmlReports.Count)" -ForegroundColor Cyan
}

Write-Host ""
Write-Host "✨ Para más información, revisa los archivos:" -ForegroundColor Green
Write-Host "   - PRUEBAS_RESUMEN.md" -ForegroundColor Cyan
Write-Host "   - TESTING_GUIDE.md" -ForegroundColor Cyan
Write-Host "   - TEST_RESULTS.md" -ForegroundColor Cyan
Write-Host ""
