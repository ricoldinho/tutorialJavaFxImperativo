package edu.rico.tutorial.tutorialclase.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.control.Button;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;

public class PerfilController {

    @FXML
    private TextField txtNombre;
    @FXML
    private Slider sldRadio;
    @FXML
    private TextField txtRadio;
    @FXML
    private ColorPicker colorPicker;
    @FXML
    private Circle circlePreview;
    @FXML
    private Label lblEstado;
    @FXML
    private Button btnGuardar;
    @FXML
    public void initialize() {

        colorPicker.setValue(Color.CORNFLOWERBLUE);

        txtRadio.setText(
                String.valueOf((int) sldRadio.getValue())
        );

        circlePreview.setRadius(
                sldRadio.getValue()
        );

        circlePreview.setFill(
                colorPicker.getValue()
        );

        actualizarEstado();

        validarFormulario();
    }

    @FXML
    private void onNombreModificado(KeyEvent event) {

        validarFormulario();
    }

    @FXML
    private void onSliderModificado() {

        int radio = (int) sldRadio.getValue();

        txtRadio.setText(
                String.valueOf(radio)
        );

        circlePreview.setRadius(radio);

        actualizarEstado();

        validarFormulario();
    }

    @FXML
    private void actualizarRadioDesdeTexto() {

        try {

            double radio =
                    Double.parseDouble(
                            txtRadio.getText()
                    );

            if (radio < sldRadio.getMin()) {
                radio = sldRadio.getMin();
            }

            if (radio > sldRadio.getMax()) {
                radio = sldRadio.getMax();
            }

            sldRadio.setValue(radio);

            circlePreview.setRadius(radio);

            actualizarEstado();

            validarFormulario();

        } catch (NumberFormatException e) {

            txtRadio.setText(
                    String.valueOf(
                            (int) sldRadio.getValue()
                    )
            );
        }
    }

    @FXML
    private void cambiarColor() {

        circlePreview.setFill(
                colorPicker.getValue()
        );
    }

    private void actualizarEstado() {

        lblEstado.setText(
                "Dimensiones del Avatar: "
                        + (int) sldRadio.getValue()
                        + " px de radio"
        );
    }

    private void validarFormulario() {

        boolean nombreValido =
                !txtNombre.getText().isBlank();

        boolean radioValido =
                sldRadio.getValue() >= 30;

        btnGuardar.setDisable(
                !(nombreValido && radioValido)
        );
    }

    @FXML
    private void guardarConfiguracion() {

        System.out.println(
                "Nombre: "
                        + txtNombre.getText()
        );

        System.out.println(
                "Radio: "
                        + (int) sldRadio.getValue()
        );

        System.out.println(
                "Color: "
                        + colorPicker.getValue()
        );
    }
}