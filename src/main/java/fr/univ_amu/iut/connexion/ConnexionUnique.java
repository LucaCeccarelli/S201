package fr.univ_amu.iut.connexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnexionUnique {
        // URL de connexion
        static final String CONNECT_URL = "jdbc:postgresql://tyke.db.elephantsql.com/ygnqhbhc ";
        static final String LOGIN = "ygnqhbhc";
        static final String PASSWORD = "9eqow-b5FZ-n8dLAbZVwJwG5IdX6rjVa";

        // Objet Connection
        private Connection connection;
        private static ConnexionUnique instance;

        private ConnexionUnique()
        {
        }

        public Connection getConnection() {
            return connection;
        }

        public static ConnexionUnique getInstance() {
            if (instance == null) {
                try {
                    instance = new ConnexionUnique();
                    instance.connection = DriverManager.getConnection(CONNECT_URL, LOGIN, PASSWORD);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            } else {
                try {
                    if (instance.connection.isClosed()) {
                        instance.connection = DriverManager.getConnection(CONNECT_URL, LOGIN, PASSWORD);

                    }
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            return instance;
        }
    }

