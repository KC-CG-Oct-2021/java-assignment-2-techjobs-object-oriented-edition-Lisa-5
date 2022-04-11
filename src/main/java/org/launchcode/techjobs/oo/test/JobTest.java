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
    Job missingName;
    String testString;


    public void createJobObject(){
         emptyJob1 = new Job();
         emptyJob2 = new Job();
         completeJobTest1 = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence") );
         completeJobTest2 = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
         missingName = new Job("", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));

    }


    public void createJobStringToTest(){
        testString = "\nID: " + completeJobTest1.getId() +
                "\nName: " + completeJobTest1.getName() +
                "\nEmployer: " + completeJobTest1.getEmployer() +
                "\nLocation: " + completeJobTest1.getLocation() +
                "\nPosition Type: " + completeJobTest1.getPositionType() +
                "\nCore Competency: " + completeJobTest1.getCoreCompetency() +
                '\n';
    }

    @Before
    public void prepareTestObjects(){
        createJobObject();
        createJobStringToTest();
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

    }

    @Test
    public void testToStringStartsAndEndsWithNewLine(){

    }
// (assertThat(), is());   https://stackoverflow.com/questions/41250401/how-to-test-a-tostring-method
}
