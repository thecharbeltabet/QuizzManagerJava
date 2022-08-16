package fr.epita.main.launchers;

import fr.epita.tests.Test1;
import fr.epita.tests.TestDBConnection;
import fr.epita.tests.TestXML;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.sql.SQLException;

public class TLauncher {

    public static void main(String[] args) throws SQLException, IOException, ParserConfigurationException, SAXException {
        Test1.test();
        TestDBConnection.test();
        TestXML.test();



    }
}
