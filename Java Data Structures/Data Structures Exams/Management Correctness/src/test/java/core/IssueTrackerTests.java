import core.IssueTracker;
import core.IssueTrackerImpl;
import models.Issue;
import models.IssueStatus;
import org.junit.Before;
import org.junit.Test;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import static org.junit.Assert.*;

public class IssueTrackerTests {
    private interface InternalTest {
        void execute();
    }

    private IssueTracker issueTracker;

    private Issue getRandomIssue() {
        return new Issue(
                UUID.randomUUID().toString(),
                UUID.randomUUID().toString(),
                (int) Math.min(1, Math.random() * 1_000),
                UUID.randomUUID().toString());
    }

    @Before
    public void setup() {
        this.issueTracker = new IssueTrackerImpl();
    }

    // Correctness Tests

    @Test
    public void testAddIssue_WithCorrectData_ShouldSuccessfullyAddIssue() {
        this.issueTracker.addIssue(getRandomIssue());
        this.issueTracker.addIssue(getRandomIssue());

        assertEquals(2, this.issueTracker.size());
    }

    @Test
    public void testContains_WithExistentIssue_ShouldReturnTrue() {
        Issue issue = getRandomIssue();

        this.issueTracker.addIssue(issue);

        assertTrue(this.issueTracker.contains(issue));
    }

    @Test
    public void testContains_WithNonexistentIssue_ShouldReturnTrue() {
        this.issueTracker.addIssue(getRandomIssue());

        assertFalse(this.issueTracker.contains(getRandomIssue()));
    }

    @Test
    public void testCount_With5Issues_ShouldReturn5() {
        this.issueTracker.addIssue(this.getRandomIssue());
        this.issueTracker.addIssue(this.getRandomIssue());
        this.issueTracker.addIssue(this.getRandomIssue());
        this.issueTracker.addIssue(this.getRandomIssue());
        this.issueTracker.addIssue(this.getRandomIssue());

        assertEquals(5, this.issueTracker.size());
    }

    @Test
    public void testGetBacklog_WithTodoIssues_ShouldReturnCorrectIssues() {
        Issue issue = new Issue("Test1", "Title1", 200,  "Pesho");
        Issue issue2 = new Issue("Test2", "Title2", 5,  "Gosho");
        Issue issue3 = new Issue("Test3", "Title3", 10,  "Sasho");
        Issue issue4 = new Issue("Test4", "Title4", 0,  "Tosho");
        Issue issue5 = new Issue("Test5", "Title5", 0,  "Misho");

        this.issueTracker.addIssue(issue);
        this.issueTracker.addIssue(issue2);
        this.issueTracker.addIssue(issue3);
        this.issueTracker.addIssue(issue4);
        this.issueTracker.addIssue(issue5);

        issue.setIssueStatus(IssueStatus.IN_PROGRESS);
        issue5.setIssueStatus(IssueStatus.DONE);

        List<Issue> issues = StreamSupport.stream(this.issueTracker.getBacklog().spliterator(), false)
                .collect(Collectors.toList());
        ;

        assertEquals(3, issues.size());
        assertEquals(issue4, issues.get(0));
        assertEquals(issue2, issues.get(1));
        assertEquals(issue3, issues.get(2));
    }

    // Performance Tests

    @Test
    public void testAddIssue_With100000Results_ShouldPassQuickly() {
        List<Issue> issuesToAdd = new ArrayList<>();

        int count = 100000;

        for (int i = 0; i < count; i++) {
            issuesToAdd.add(new Issue(i + "", "Title" + i, i * 100, "Assignee" + i));
        }

        long start = System.currentTimeMillis();

        for (int i = 0; i < count; i++) {
            this.issueTracker.addIssue(issuesToAdd.get(i));
        }

        long stop = System.currentTimeMillis();

        long elapsedTime = stop - start;

        assertTrue(elapsedTime < 450);
    }
}
