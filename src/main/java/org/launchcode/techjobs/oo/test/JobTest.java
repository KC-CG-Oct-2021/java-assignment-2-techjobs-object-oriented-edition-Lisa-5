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
    String testString;


    public void createJobObject(){
         emptyJob1 = new Job();
         emptyJob2 = new Job();
         completeJobTest1 = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence") );
         completeJobTest2 = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
         missingEmployer = new Job("Product tester", new Employer(), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));


    }

    @Before
    public void prepareTestObjects(){
        createJobObject();
    }

    @Test
    public void testSettingJobId(){
        assertFalse(emptyJob1.equals(emptyJob2));
    }

    @Test
    public void testJobConstructorSetsAllFields(){
        assertTrue(completeJobTest1 != null);
    }

    @Test
    public void testJobsForEquality(){
        assertFalse(completeJobTest1.equals(completeJobTest2));
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
// (assertThat(), is());   https://stackoverflow.com/questions/41250401/how-to-test-a-tostring-method
// https://stackoverflow.com/questions/9131071/junit-multiple-before-vs-one-before-split-up-into-methods/9131724#9131724
}
