module test {
    requires org.junit.jupiter.api;
    requires ch.fhnw.richards;

    opens ch.fhnw.richards.test.Week_01 to org.junit.platform.commons;
}