# 📋 Resumen de Pruebas Unitarias - Infix to Postfix Converter

## ✅ Estado: TODAS LAS PRUEBAS PASAN

### 📊 Estadísticas Finales

| Categoría | Cantidad |
|-----------|----------|
| **Pruebas Totales** | **91** |
| **Exitosas** | **91** ✅ |
| **Fallos** | **0** ✅ |
| **Errores** | **0** ✅ |
| **Saltos** | **0** ✅ |

---

## 📁 Estructura de Pruebas

### 1. **IntegrationTest.java** (8 pruebas)
Pruebas de integración completa: Infix → Postfix → Evaluación
```
✅ Integración: 2+3 -> 2 3 + -> 5
✅ Integración: 2+3*4 -> 2 3 4 * + -> 14
✅ Integración: (2+3)*4 -> 2 3 + 4 * -> 20
✅ Integración: 10-5+3 = 8
✅ Integración: 100/10*2 = 20
✅ Integración: (5+3)*(2+1) = 24
✅ Integración: 2^3+4*5 = 28
✅ Integración: ((5+5)*2)+10 = 30
```

### 2. **InfixToPostfixConverterTest.java** (15 pruebas)
Conversión de notación Infix a Postfix
```
✅ Conversión simple: 2+3
✅ Conversión simple: 2*3
✅ Precedencia: 2+3*4 = 2 3 4 * +
✅ Precedencia: 2*3+4 = 2 3 * 4 +
✅ Paréntesis: (2+3)*4 = 2 3 + 4 *
✅ Paréntesis anidados: ((2+3)*4)
✅ Números de múltiples dígitos: 12+34
✅ Resta: 10-5
✅ División: 20/5
✅ Potencia: 2^3
✅ Expresión compleja: 3+4*2/(1-5)
✅ Con espacios: 2 + 3 * 4
✅ Un solo número: 42
✅ Múltiples operadores iguales: 1+2+3
✅ Expresión con todas las operaciones: 5+3*2-8/4^2
```

### 3. **PostfixEvaluatorTest.java** (15 pruebas)
Evaluación de expresiones Postfix
```
✅ Evaluación suma: 2 3 + = 5
✅ Evaluación resta: 10 5 - = 5
✅ Evaluación multiplicación: 3 4 * = 12
✅ Evaluación división: 20 5 / = 4
✅ Evaluación potencia: 2 3 ^ = 8
✅ Expresión: 2 3 4 * + = 14
✅ Expresión: 2 3 + 4 * = 20
✅ Expresión: 10 5 - 3 * = 15
✅ Expresión compleja: 15 7 1 1 + - / 3 * 2 1 1 + + - = 5
✅ Un solo número: 42 = 42
✅ Resultado decimal: 10 3 / ≈ 3.333
✅ Números de múltiples dígitos: 123 45 + = 168
✅ Expresión del ejercicio: 3 4 2 * + = 11
✅ Resta con números negativos: 5 5 - 3 + = 3
✅ Múltiples operadores: 1 2 + 3 + 4 + = 10
```

### 4. **ArrayListStackTest.java** (10 pruebas)
Stack basado en ArrayList
```
✅ Nuevo stack debe estar vacío
✅ Push agrega elemento al stack
✅ Peek devuelve elemento sin remover
✅ Pop remueve y devuelve elemento
✅ Stack LIFO - Last In First Out
✅ Pop en stack vacío lanza excepción
✅ Peek en stack vacío lanza excepción
✅ Size retorna cantidad correcta de elementos
✅ Stack maneja múltiples operaciones
✅ Stack con null values
```

### 5. **ListStackTest.java** (10 pruebas)
Stack basado en ListADT
```
✅ Nuevo ListStack debe estar vacío
✅ Push agrega elemento al ListStack
✅ Peek devuelve elemento sin remover
✅ Pop remueve y devuelve elemento
✅ ListStack mantiene orden LIFO
✅ Pop en ListStack vacío lanza excepción
✅ Peek en ListStack vacío lanza excepción
✅ Size retorna cantidad correcta
✅ ListStack con múltiples operaciones
✅ ListStack alternativo con lista diferente
```

### 6. **VectorStackTest.java** (11 pruebas)
Stack basado en Vector
```
✅ Nuevo VectorStack debe estar vacío
✅ Push agrega elemento al VectorStack
✅ Peek devuelve elemento sin remover
✅ Pop remueve y devuelve elemento
✅ VectorStack LIFO
✅ Pop en VectorStack vacío lanza excepción
✅ Peek en VectorStack vacío lanza excepción
✅ Size retorna cantidad correcta
✅ VectorStack con múltiples operaciones
✅ VectorStack con valores duplicados
✅ VectorStack con null
```

### 7. **SinglyLinkedListTest.java** (11 pruebas)
Lista enlazada simple
```
✅ Nueva lista debe estar vacía
✅ Add agrega elemento a la lista
✅ GetLast devuelve último elemento
✅ RemoveLast remueve y devuelve último
✅ RemoveLast en lista vacía lanza excepción
✅ GetLast en lista vacía lanza excepción
✅ Size retorna cantidad correcta
✅ Lista maneja múltiples adiciones
✅ Remover todos los elementos
✅ Lista con un solo elemento
✅ Lista con valores null
```

### 8. **DoublyLinkedListTest.java** (11 pruebas)
Lista doblemente enlazada
```
✅ Nueva DoublyLinkedList debe estar vacía
✅ Add agrega elemento a la lista
✅ GetLast devuelve último elemento
✅ RemoveLast remueve y devuelve último
✅ RemoveLast en lista vacía lanza excepción
✅ GetLast en lista vacía lanza excepción
✅ Size retorna cantidad correcta
✅ Múltiples adiciones
✅ Remover todos elementos
✅ Un solo elemento
✅ DoublyLinkedList con null
```

---

## 🚀 Cómo Ejecutar las Pruebas

### Con Maven
```bash
# Ejecutar todas las pruebas
mvn clean test

# Ejecutar una clase de prueba específica
mvn clean test -Dtest=ArrayListStackTest

# Ejecutar una prueba específica
mvn clean test -Dtest=ArrayListStackTest#testPushAddElement

# Con salida resumida
mvn clean test -q
```

### En IDE
- **IntelliJ IDEA**: Click derecho en `src/test/java` → `Run All Tests` (Ctrl+Shift+F10)
- **Eclipse**: Click derecho en `src/test/java` → `Run As` → `JUnit Test`
- **VSCode**: Usar extensión Test Runner for Java

---

## 📋 Requisitos

- **Java**: 11 o superior
- **Maven**: 3.6 o superior
- **JUnit**: 5.9.2 (incluido en pom.xml)

---

## 📁 Estructura de Carpetas

```
c:\Users\Admin\Documents\HOJA4\INFIXTOPOSTFIX\
│
├── pom.xml                          (Maven configuration)
│
├── src/
│   ├── main/java/                   (Código fuente)
│   │   ├── domain/
│   │   │   ├── Stack.java
│   │   │   ├── ListADT.java
│   │   │   ├── AbstractStack.java
│   │   │   └── AbstractList.java
│   │   ├── service/
│   │   │   ├── InfixToPostfixConverter.java
│   │   │   └── PostfixEvaluator.java
│   │   ├── structure/
│   │   │   ├── ArrayListStack.java
│   │   │   ├── ListStack.java
│   │   │   ├── VectorStack.java
│   │   │   ├── SinglyLinkedList.java
│   │   │   └── DoublyLinkedList.java
│   │   └── app/
│   │       └── Main.java
│   │
│   └── test/java/                   (Pruebas unitarias)
│       ├── service/
│       │   ├── InfixToPostfixConverterTest.java
│       │   └── PostfixEvaluatorTest.java
│       ├── structure/
│       │   ├── ArrayListStackTest.java
│       │   ├── ListStackTest.java
│       │   ├── VectorStackTest.java
│       │   ├── SinglyLinkedListTest.java
│       │   └── DoublyLinkedListTest.java
│       └── IntegrationTest.java
│
├── target/                          (Generado tras compilación)
│   ├── classes/                     (Clases compiladas)
│   ├── test-classes/                (Clases de prueba compiladas)
│   └── surefire-reports/            (Reportes de pruebas)
│
├── README.md                        (Descripción del proyecto)
└── TESTING_GUIDE.md                 (Guía de pruebas)
```

---

## ✨ Características de las Pruebas

✅ **Cobertura completa** - Todos los casos use están cubiertos
✅ **Manejo de excepciones** - Se prueban casos de error
✅ **Pruebas de integración** - Flujo completo infix→postfix→evaluación
✅ **Nombres descriptivos** - Cada prueba documenta qué hace
✅ **Uso de @DisplayName** - Descripción clara en reportes
✅ **Valores nulos** - Se prueban casos edge (null values)
✅ **Múltiples implementaciones** - Se prueban diferentes estructuras de datos

---

## 🎯 Casos de Prueba Cubiertos

### Operadores
- ✅ Suma (+)
- ✅ Resta (-)
- ✅ Multiplicación (*)
- ✅ División (/)
- ✅ Potencia (^)

### Precedencia
- ✅ Operadores de igual precedencia
- ✅ Operadores de diferente precedencia
- ✅ Paréntesis simples
- ✅ Paréntesis anidados

### Estructuras de Datos
- ✅ ArrayList Stack
- ✅ Vector Stack
- ✅ List Stack (con LinkedList)
- ✅ SinglyLinkedList
- ✅ DoublyLinkedList

### Casos Edge
- ✅ Stack/Lista vacía
- ✅ Un solo elemento
- ✅ Valores null
- ✅ Un solo número
- ✅ Números multi-dígito
- ✅ Resultados decimales

---

## 📞 Próximos Pasos

1. **Generar reporte HTML**:
   ```bash
   mvn surefire-report:report
   mvn site
   ```

2. **Generar reporte de cobertura**:
   ```bash
   mvn clean test jacoco:report
   ```

3. **Ejecutar el programa**:
   ```bash
   mvn exec:java -Dexec.mainClass="app.Main"
   ```

---

**Creado:** 27 de febrero de 2026  
**Estado:** ✅ TODAS LAS PRUEBAS EXITOSAS (91/91)
