package models;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Issue {
    private String id;

    private String title;

    private int priority;

    private String assignee;

    private IssueStatus issueStatus;

    private List<Issue> blockedIssues;

    private List<Issue> blockedByIssues;

    public Issue(String id, String title, int priority, String assignee) {
        this.id = id;
        this.title = title;
        this.priority = priority;
        this.assignee = assignee;
        this.issueStatus = IssueStatus.TO_DO;
        this.blockedIssues = new ArrayList<>();
        this.blockedByIssues = new ArrayList<>();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    public String getAssignee() {
        return assignee;
    }

    public void setAssignee(String assignee) {
        this.assignee = assignee;
    }

    public IssueStatus getIssueStatus() {
        return issueStatus;
    }

    public void setIssueStatus(IssueStatus issueStatus) {
        this.issueStatus = issueStatus;
    }

    public List<Issue> getBlockedIssues() {
        return blockedIssues;
    }

    public void setBlockedIssues(List<Issue> blockedIssues) {
        this.blockedIssues = blockedIssues;
    }

    public List<Issue> getBlockedByIssues() {
        return blockedByIssues;
    }

    public void setBlockedByIssues(List<Issue> blockedByIssues) {
        this.blockedByIssues = blockedByIssues;
    }
}
