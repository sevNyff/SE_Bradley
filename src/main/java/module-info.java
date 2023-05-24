module ch.fhnw.richards {
    // Necessary for JavaFX
    requires javafx.controls;
    requires javafx.fxml;
    opens ch.fhnw.richards.demo to javafx.fxml;

    // Necessary for Jackson parsing
    requires com.fasterxml.jackson.core;
    requires com.fasterxml.jackson.databind;
    exports ch.fhnw.richards.jacksonDemos to com.fasterxml.jackson.databind;
    opens ch.fhnw.richards.jacksonDemos to com.fasterxml.jackson.databind;

    // Necessary for any JavaFX programs that should be directly runnable
    exports ch.fhnw.richards.demo;
    exports ch.fhnw.richards.Week_01;
    exports ch.fhnw.richards.Week_02.Lambdas.countrySort_v1;
    exports ch.fhnw.richards.Week_02.Lambdas;
    exports ch.fhnw.richards.Week_02.Streams.loginRecord_example;
    exports ch.fhnw.richards.Week_02.Streams.transaction_exercise;
}