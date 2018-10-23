package ac.knu.service;

import org.junit.Test;

import static org.junit.Assert.*;

public class FriendsTest {
    Friends friends = new Friends("ds", "m", 23);
    @Test
    public void sample_test_age() {
        assertTrue(friends.getAge() == 23);
    }
    @Test
    public void sample_test_sex() {
        assertTrue(friends.getSex().equals("m"));
    }

    @Test
    public void sample_test_name() {
        assertTrue(friends.getName().equals("ds"));
    }
}