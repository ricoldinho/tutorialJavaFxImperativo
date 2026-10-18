package edu.rico.tutorial.tutorialclase;

import atlantafx.base.theme.PrimerDark;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.net.URL;

public class App extends Application {

    @Override
    public void start(Stage primaryStage) {
        try {
            // PASO 1: Obtención de la URL de la vista FXML en la carpeta de recursos
            URL fxmlLocation = getClass().getResource("/edu/rico/tutorial/tutorialclase/views/perfil-view.fxml");

            // PASO 2: Instanciación del deserializador para esa ubicación
            FXMLLoader loader = new FXMLLoader(fxmlLocation);

            // PASO 3: Alineación del ClassLoader con nuestro módulo JPMS
            loader.setClassLoader(getClass().getClassLoader());

            // PASO 4: Deserialización de FXML; Generación del Grafo de Objetos; Retorno del nodo raíz Parent
            Parent root = loader.load();

            // PASO 5: Creación del lienzo visual (Scene) pasando el contenedor raíz y sus dimensiones
            Scene scene = new Scene(root, 1024, 768);

            // PASO 6: Inyección global del tema oscuro moderno AtlantaFX a toda la aplicación
            Application.setUserAgentStylesheet(new PrimerDark().getUserAgentStylesheet());

            // PASO 7: Configuración del escenario principal (Ventana) y renderizado
            primaryStage.setTitle("Sistema de Gestión Enterprise - Módulo 1");
            primaryStage.setScene(scene);
            primaryStage.show();

        } catch (Exception e) {
            System.err.println("Error crítico al inicializar la vista principal:");
            e.printStackTrace();
        }
    }
}



