#!/bin/bash
# Script para ejecutar pruebas unitarias - Infix to Postfix Converter

echo "================================"
echo "Pruebas Unitarias"
echo "Infix to Postfix Converter"
echo "================================"
echo ""

# Limpiar y compilar
echo "📦 Compilando proyecto..."
mvn clean compile

# Ejecutar pruebas
echo ""
echo "🧪 Ejecutando pruebas unitarias..."
echo ""
mvn test

# Mostrar resumen
echo ""
echo "================================"
echo "✅ Pruebas completadas"
echo "================================"
echo ""
echo "Reportes disponibles en: target/surefire-reports/"
