module edu.rico.tutorial.tutorialclase {
    // Requerimos los módulos necesarios para nuestro desarrollo
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;          // Para nuestro futuro CRUD con MySQL
    requires atlantafx.base;    // Estilos CSS modernos

    // Abrimos el paquete de controladores a 'javafx.fxml' para la inyección reflexiva de @FXML
    opens edu.rico.tutorial.tutorialclase.controllers to javafx.fxml;

    // Exportamos el paquete raíz para que el motor gráfico de JavaFX arranque la aplicación
    exports edu.rico.tutorial.tutorialclase;
}


