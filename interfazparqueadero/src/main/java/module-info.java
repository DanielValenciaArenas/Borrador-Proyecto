module co.uniquindio.parqueadero {
    requires javafx.controls;
    requires javafx.fxml;

    opens co.uniquindio.parqueadero to javafx.fxml;
    exports co.uniquindio.parqueadero;

    opens co.uniquindio.parqueadero.controller;
    exports co.uniquindio.parqueadero.controller;
}
