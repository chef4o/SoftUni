package core;

import models.Issue;
import models.IssueStatus;

import java.util.List;
import java.util.Map;

public interface IssueTracker {
    void addIssue(Issue issue);

    void removeIssue(String issueId);

    boolean contains(Issue issue);

    int size();

    void moveInProgress(String issueId);

    void moveInDone(String issueId);

    void blocks(String issueId, String blockedIssueId);

    Iterable<Issue> getBacklog();

    Iterable<Issue> getBlockedIssues();

    Iterable<Issue> getLongestBlockChain();

    Map<String, Map<IssueStatus, List<Issue>>> getAssigneeIssueGroupedByStatus();
}
