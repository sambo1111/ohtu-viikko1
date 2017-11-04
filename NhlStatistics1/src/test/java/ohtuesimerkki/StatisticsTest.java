/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ohtuesimerkki;

import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author hasasami
 */
public class StatisticsTest {
    Statistics stats;
    ReaderStub reader;
    public StatisticsTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        reader = new ReaderStub();
        stats = new Statistics(reader);
    }
    
    @After
    public void tearDown() {
    }

    @Test
    public void teamDisplaysCorrectPlayers() {
        
        List<Player> team = stats.team("EDM");
        assertTrue(team.size() == 3);
        assertTrue(team.get(0).getName().equals("Semenko"));
        assertTrue(team.get(1).getName().equals("Kurri"));
        assertTrue(team.get(2).getName().equals("Gretzky"));
        
    }
    
    @Test
    public void searchFindsPlayer() {
        assertTrue(stats.search("Semenko") != null);
        assertTrue(stats.search("Selanne") == null);
    }
    
    @Test
    public void topScorersDisplaysCorrectPlayers() {
        List<Player> top2 = stats.topScorers(2);
        assertTrue(top2.get(0).getName().equals("Gretzky"));
        assertTrue(top2.get(1).getName().equals("Lemieux"));
    }
}
