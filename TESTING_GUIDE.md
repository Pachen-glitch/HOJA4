# Guía de Pruebas Unitarias - Infix to Postfix Converter

## 📋 Estructura de Proyecto

El proyecto ahora tiene una estructura Maven estándar:

```
INFIXTOPOSTFIX/
├── pom.xml                          # Configuración de Maven con JUnit 5
├── src/
│   ├── main/java/                   # (Pendiente: mover código fuente aquí)
│   │   ├── domain/
│   │   ├── service/
│   │   └── structure/
│   └── test/java/                   # Pruebas unitarias
│       ├── structure/
│       │   ├── ArrayListStackTest.java
│       │   └── SinglyLinkedListTest.java
│       ├── service/
│       │   ├── InfixToPostfixConverterTest.java
│       │   └── PostfixEvaluatorTest.java
│       └── IntegrationTest.java
└── README.md
```

## 🚀 Ejecución de Pruebas

### Opción 1: Con Maven (Recomendado)
```bash
# Ejecutar todas las pruebas
mvn clean test

# Ejecutar pruebas de una clase específica
mvn clean test -Dtest=ArrayListStackTest

# Ejecutar con más detalles
mvn clean test -X
```

### Opción 2: Con IDE (IntelliJ IDEA, Eclipse, VSCode)
- Click derecho en la carpeta `src/test/java`
- Seleccionar "Run All Tests" o presionar Ctrl+Shift+F10 (IntelliJ)

## 📝 Pruebas Implementadas

### 1. **ArrayListStackTest** (10 pruebas)
Prueba la implementación de Stack usando ArrayList:
- ✅ Stack vacío
- ✅ Push/Pop/Peek
- ✅ Order LIFO (Last In First Out)
- ✅ Excepciones en operaciones inválidas
- ✅ Size y isEmpty
- ✅ Operaciones múltiples

### 2. **SinglyLinkedListTest** (10 pruebas)
Prueba la implementación de List con linked list:
- ✅ Lista vacía
- ✅ Add/Get/Remove
- ✅ Manejo de excepciones
- ✅ Size y estado
- ✅ Remover todos los elementos

### 3. **InfixToPostfixConverterTest** (15 pruebas)
Prueba la conversión de notación Infix a Postfix:
- ✅ Operaciones simples (2+3, 2*3)
- ✅ Precedencia de operadores
- ✅ Paréntesis
- ✅ Números multi-dígito
- ✅ Todas las operaciones (+, -, *, /, ^)
- ✅ Expresiones complejas con espacios

### 4. **PostfixEvaluatorTest** (14 pruebas)
Prueba la evaluación de expresiones en notación Postfix:
- ✅ Operaciones simples
- ✅ Expresiones complejas
- ✅ Números multi-dígito
- ✅ Resultados decimales
- ✅ Números negativos

### 5. **IntegrationTest** (8 pruebas)
Prueba la integración completa: Infix → Postfix → Evaluación:
- ✅ Conversión correcta + Evaluación correcta
- ✅ Casos complejos con paréntesis múltiples
- ✅ Expresiones con todas las operaciones

## 📊 Total: 57 Pruebas Unitarias

## ⚙️ Requisitos

- Java 11 o superior
- Maven 3.6+

## 🔧 Próximos Pasos Recomendados

1. **Reorganizar código fuente** (Opcional pero recomendado):
   - Mover archivos de `src/` a `src/main/java/{package}/`
   - Esto sigue la estructura estándar de Maven

2. **Ejecutar pruebas**:
   ```bash
   mvn clean test
   ```

3. **Generar reporte de cobertura**:
   ```bash
   mvn clean test jacoco:report
   ```

## 📚 Referencias

- [JUnit 5 Documentation](https://junit.org/junit5/docs/current/user-guide/)
- [Maven Test Plugin](https://maven.apache.org/plugins/maven-surefire-plugin/)
- [Notación Infix y Postfix](https://es.wikipedia.org/wiki/Notaci%C3%B3n_polaca_inversa)
