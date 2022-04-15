package org.launchcode.techjobs.oo.test;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.launchcode.techjobs.oo.CoreCompetency;
import org.launchcode.techjobs.oo.Employer;
import org.launchcode.techjobs.oo.Job;
import org.launchcode.techjobs.oo.Location;
import org.launchcode.techjobs.oo.PositionType;

import static org.junit.Assert.*;

/**
 * Created by LaunchCode
 */
@RunWith(JUnit4.class)

public class JobTest {
    Job emptyJob1;
    Job emptyJob2;
    Job completeJobTest1;
    Job completeJobTest2;
    Job missingEmployer;
    String testString = "\nID: " + 3 +
            "\nName: " + "Product tester" +
            "\nEmployer: " + "ACME" +
            "\nLocation: " + "Desert" +
            "\nPosition Type: " + "Quality control" +
            "\nCore Competency: " + "Persistence"+
            '\n';


    public void createJobObject(){
         emptyJob1 = new Job();
         emptyJob2 = new Job();
         completeJobTest1 = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence") );
         completeJobTest2 = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        missingEmployer = new Job("Product tester", new Employer(""), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));

    }

    @Before
    public void prepareTestObjects(){
        createJobObject();
    }

    @Test
    public void testSettingJobId(){
        assertNotEquals(emptyJob1, emptyJob2);
        assertEquals(emptyJob1.getId() + 1, emptyJob2.getId());
    }

    @Test
    public void testJobConstructorSetsAllFields(){
        assertNotNull(completeJobTest1);
        assertTrue(completeJobTest1.getId() > 0);
        assertEquals("Product tester", completeJobTest1.getName());
        assertEquals("ACME", completeJobTest1.getEmployer().getValue());
        assertTrue(completeJobTest1.getEmployer() instanceof Employer);
        assertEquals("Desert", completeJobTest1.getLocation().getValue());
        assertTrue(completeJobTest1.getLocation() instanceof Location);
        assertEquals("Quality control", completeJobTest1.getPositionType().getValue());
        assertTrue(completeJobTest1.getPositionType() instanceof PositionType);
        assertEquals("Persistence", completeJobTest1.getCoreCompetency().getValue());
        assertTrue(completeJobTest1.getCoreCompetency() instanceof CoreCompetency);
    }

    @Test
    public void testJobsForEquality(){
        assertNotEquals(completeJobTest1, completeJobTest2);
    }

    @Test
    public void testToStringContainsCorrectLabelsAndData(){
        assertEquals(testString, completeJobTest1.toString());
    }

    @Test
    public void testToStringHandlesEmptyField(){
            assertTrue(missingEmployer.toString().contains("Employer: Data not available"));
    }

    @Test
    public void testToStringStartsAndEndsWithNewLine(){
        assertTrue(completeJobTest1.toString().indexOf('\n') == 0);
        assertTrue(completeJobTest1.toString().lastIndexOf('\n') == (completeJobTest1.toString().length()-1));

    }

}
