module ch.fhnw.richards {
    // Necessary for JavaFX
    requires javafx.controls;
    requires javafx.fxml;
    opens ch.fhnw.richards.demo to javafx.fxml;

    // Necessary for Jackson parsing
    requires com.fasterxml.jackson.core;
    requires com.fasterxml.jackson.databind;
    requires org.json;
    requires java.logging;
    requires jdk.httpserver;
    requires java.net.http;
    requires java.sql;
    exports ch.fhnw.richards.json.jacksonDemos to com.fasterxml.jackson.databind;
    opens ch.fhnw.richards.json.jacksonDemos to com.fasterxml.jackson.databind;
    exports ch.fhnw.richards.json.dataClasses to com.fasterxml.jackson.databind;
    opens ch.fhnw.richards.json.dataClasses to com.fasterxml.jackson.databind;

    // Necessary for any JavaFX programs that should be directly runnable
    exports ch.fhnw.richards.demo;
    exports ch.fhnw.richards.Week_01;
    exports ch.fhnw.richards.Week_02.Lambdas.countrySort_v1;
    exports ch.fhnw.richards.Week_02.Lambdas;
    exports ch.fhnw.richards.Week_02.Streams.loginRecord_example;
    exports ch.fhnw.richards.Week_02.Streams.transaction_exercise;
    exports ch.fhnw.richards.Week_05;
    exports ch.fhnw.richards.Week_06;
    exports ch.fhnw.richards.Week_06.executors;
    exports ch.fhnw.richards.Week_06.solarSystem;
    exports ch.fhnw.richards.Week_06.whac_a_mole;
}