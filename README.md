Hazme un README.md para este proyecto en markdown
Copilot said:



# Tutorial JavaFX - Programación Imperativa

Proyecto didáctico orientado a la enseñanza de **JavaFX con programación imperativa**, utilizando **FXML**, **CSS**, **Maven** y **JPMS (Java Platform Module System)**.

El objetivo principal es que el alumnado comprenda primero la arquitectura de una aplicación JavaFX, la gestión de eventos y la manipulación manual de la interfaz antes de introducir conceptos más avanzados como listeners, properties, bindings o programación reactiva. 【1-6c8373】

---

# Índice

- [Objetivos del proyecto](#objetivos-del-proyecto)
- [Tecnologías utilizadas](#tecnologías-utilizadas)
- [Arquitectura del proyecto](#arquitectura-del-proyecto)
- [Módulo 1. Infraestructura y configuración](#módulo-1-infraestructura-y-configuración)
- [Módulo 2. Programación imperativa con JavaFX](#módulo-2-programación-imperativa-con-javafx)
- [Módulo 3. Navegación y coordinación de vistas](#módulo-3-navegación-y-coordinación-de-vistas)
- [Estructura del proyecto](#estructura-del-proyecto)
- [Ejecución del proyecto](#ejecución-del-proyecto)
- [Conceptos didácticos trabajados](#conceptos-didácticos-trabajados)
- [Programación imperativa vs reactiva](#programación-imperativa-vs-reactiva)
- [Requisitos](#requisitos)
- [Autor](#autor)

---

# Objetivos del proyecto

Este proyecto pretende enseñar:

- Arquitectura JavaFX moderna.
- Uso correcto de Maven.
- Modularización mediante JPMS.
- Comprensión de FXMLLoader.
- Uso de FXML para separar presentación y lógica.
- Uso de CSS para desacoplar los estilos.
- Programación basada en eventos.
- Navegación entre vistas.
- Diseño de aplicaciones escalables. 【1-6c8373】

---

# Tecnologías utilizadas

- Java 21
- JavaFX
- Maven
- JPMS (Java Platform Module System)
- FXML
- CSS
- Scene Builder
- AtlantaFX Theme
- IntelliJ IDEA 【1-6c8373】

---

# Arquitectura del proyecto

El proyecto se apoya en una clara separación de responsabilidades:

```text
┌─────────────────────┐
│        FXML         │
│      (Vista)        │
└──────────┬──────────┘
           │
           ▼
┌─────────────────────┐
│     Controller      │
│   (Lógica UI)       │
└──────────┬──────────┘
           │
           ▼
┌─────────────────────┐
│       Modelo        │
│      (Datos)        │
└─────────────────────┘
```

FXML define la interfaz, CSS define la apariencia y el controlador contiene la lógica de interacción. 【1-6c8373】

---

# Módulo 1. Infraestructura y configuración

En este módulo se construyen los cimientos de la aplicación.

## Contenidos

### Maven

Se utiliza Maven para:

- Gestión de dependencias.
- Compilación.
- Empaquetado.
- Ejecución con JavaFX. 【1-6c8373】

### JPMS

Se introduce el sistema modular de Java mediante:

```java
module edu.rico.tutorial.tutorialclase {
    requires javafx.controls;
    requires javafx.fxml;

    opens edu.rico.tutorial.tutorialclase.controllers
        to javafx.fxml;

    exports edu.rico.tutorial.tutorialclase;
}
```

JPMS aporta encapsulación, seguridad y compatibilidad con herramientas como `jlink`. 【1-6c8373】

### FXMLLoader

Se estudia:

- Carga de archivos FXML.
- Inyección de controles mediante `@FXML`.
- Asociación de eventos.
- Uso de reflexión en JavaFX. 【1-6c8373】

---

# Módulo 2. Programación imperativa con JavaFX

Este módulo elimina completamente el enfoque reactivo utilizado habitualmente en JavaFX y se centra en programación imperativa clásica. 【1-6c8373】

## Principio fundamental

```text
Evento
   ↓
Método @FXML
   ↓
Procesamiento
   ↓
Actualización manual de la interfaz
```

No se utilizan:

- Bindings
- Properties
- ObservableValue
- BooleanBinding
- Programación reactiva 【1-6c8373】

---

## Vista FXML

Los eventos se declaran directamente en el archivo FXML:

```xml
<TextField
    fx:id="txtNombre"
    onKeyReleased="#onNombreModificado"/>

<Slider
    fx:id="sldRadio"
    onMouseReleased="#onSliderModificado"/>

<ColorPicker
    fx:id="colorPicker"
    onAction="#cambiarColor"/>
```

---

## Flujo de trabajo

```text
Usuario mueve el Slider
          ↓
FXML llama a onSliderModificado()
          ↓
Leer valor actual
          ↓
Actualizar TextField
          ↓
Actualizar Circle
          ↓
Actualizar Label
          ↓
Validar formulario
```

Este flujo permite comprender claramente la relación causa-efecto dentro de una interfaz gráfica. 【1-6c8373】

---

# Módulo 3. Navegación y coordinación de vistas

El proyecto implementa un sistema de navegación empresarial mediante un coordinador central.

## Componentes

### ViewType

Enumeración que define las vistas disponibles.

```java
PERFIL
DASHBOARD
ESTADISTICAS
```

### NavigationManager

Responsable de:

- Cargar vistas.
- Gestionar el contenedor principal.
- Realizar la navegación.
- Mantener el estado actual. 【1-6c8373】

### MainLayoutController

Coordina:

- Menús.
- Botones de navegación.
- Títulos.
- Cambio de vistas. 【1-6c8373】

---

# Estructura del proyecto

```text
src
├── main
│   ├── java
│   │   └── edu
│   │       └── rico
│   │           └── tutorial
│   │               └── tutorialclase
│   │                   ├── controllers
│   │                   ├── navigation
│   │                   ├── model
│   │                   ├── App.java
│   │                   └── Launcher.java
│   │
│   └── resources
│       └── edu
│           └── rico
│               └── tutorial
│                   └── tutorialclase
│                       ├── views
│                       └── styles
│
└── pom.xml
```

---

# Ejecución del proyecto

## Desde IntelliJ IDEA

1. Abrir el proyecto.
2. Permitir que Maven descargue las dependencias.
3. Verificar que se utiliza Java 21.
4. Abrir la ventana Maven.
5. Ejecutar:

```text
Plugins
 └─ javafx
     └─ javafx:run
```

【1-6c8373】

---

# Conceptos didácticos trabajados

## JavaFX

- Scene
- Stage
- Parent
- Scene Graph
- FXMLLoader
- Controladores

## Programación orientada a eventos

- Eventos de teclado
- Eventos de ratón
- Eventos de acción
- Métodos `@FXML`

## Modularización

- requires
- exports
- opens

## Diseño de interfaces

- FXML
- CSS
- Scene Builder

【1-6c8373】

---

# Programación imperativa vs reactiva

## Enfoque imperativo

```java
@FXML
private void onSliderModificado() {

    int radio = (int) sldRadio.getValue();

    txtRadio.setText(String.valueOf(radio));

    circlePreview.setRadius(radio);

    actualizarEstado();

    validarFormulario();
}
```

### Ventajas

- Fácil de seguir.
- Ideal para principiantes.
- Flujo explícito.
- Similar a Swing. 【1-6c8373】

---

## Enfoque reactivo

```java
sldRadio.valueProperty()
        .addListener(...);
```

### Ventajas

- Menos código repetitivo.
- Mayor automatización.
- Escala mejor en aplicaciones complejas. 【1-6c8373】

---

# Requisitos

- JDK 21 o superior
- Maven 3.9+
- IntelliJ IDEA (recomendado)
- JavaFX SDK compatible con la versión utilizada 【1-6c8373】

---

# Autor

**Manuel Rico López**

Tutorial orientado a la enseñanza de JavaFX desde una perspectiva imperativa, poniendo el foco en la comprensión de la arquitectura de aplicaciones, los eventos y la separación de responsabilidades antes de introducir técnicas reactivas avanzadas. 【1-6c8373】