package core;

import models.Issue;
import models.IssueStatus;

import java.util.*;
import java.util.stream.Collectors;

import static models.IssueStatus.*;

public class IssueTrackerImpl implements IssueTracker {

    private Map<String, Issue> issues;
    private Map<String, Map<IssueStatus, List<Issue>>> assignees;

    public IssueTrackerImpl() {
        this.issues = new LinkedHashMap<>();
        this.assignees = new LinkedHashMap<>();
    }

    @Override
    public void addIssue(Issue issue) {
        this.issues.putIfAbsent(issue.getId(), issue);
        this.assignees.putIfAbsent(issue.getAssignee(), new LinkedHashMap<>());
        this.assignees.get(issue.getAssignee())
                .putIfAbsent(issue.getIssueStatus(), new ArrayList<>());
        this.assignees.get(issue.getAssignee()).get(issue.getIssueStatus()).add(issue);
    }

    @Override
    public void removeIssue(String issueId) {
        if (!this.issues.containsKey(issueId)) {
            throw new IllegalArgumentException();
        }
        this.issues.remove(issueId);
        this.assignees.remove(this.issues.get(issueId).getAssignee());
    }

    @Override
    public boolean contains(Issue issue) {
        return this.issues.containsKey(issue.getId());
    }

    @Override
    public int size() {
        return this.issues.size();
    }

    @Override
    public void moveInProgress(String issueId) {
        Issue current = getIfPresent(issueId);
        if (!current.getIssueStatus().equals(TO_DO)) {
            throw new IllegalArgumentException();
        }
        updateAssigneesStatus(current, IN_PROGRESS);
    }

    @Override
    public void moveInDone(String issueId) {
        Issue current = getIfPresent(issueId);
        updateAssigneesStatus(current, DONE);
    }

    private void updateAssigneesStatus(Issue current, IssueStatus done) {
        current.setIssueStatus(done);

        for (Map<IssueStatus, List<Issue>> assignee : this.assignees.values()) {
            for (IssueStatus issueStatus : assignee.keySet()) {
                if (issueStatus != done) {
                    assignee.get(issueStatus).remove(current);
                } else {
                    assignee.get(issueStatus).add(current);
                }
            }
        }
    }

    @Override
    public void blocks(String issueId, String blockedIssueId) {
        Issue current = getIfPresent(blockedIssueId);
        Issue destination = getIfPresent(issueId);

        destination.getBlockedIssues().add(current);
        current.getBlockedByIssues().add(destination);
    }

    @Override
    public Iterable<Issue> getBacklog() {
        return this.issues.values().stream()
                .filter(i -> i.getIssueStatus().equals(TO_DO))
                .sorted(Comparator.comparingInt(Issue::getPriority))
                .collect(Collectors.toList());
    }

    @Override
    public Iterable<Issue> getBlockedIssues() {
        return this.issues.values().stream()
                .filter(i -> !i.getBlockedByIssues().isEmpty())
                .sorted((a, b) -> {
                    int byPriority = a.getPriority() - b.getPriority();
                    if (byPriority == 0) {
                        return a.getTitle().compareTo(b.getTitle());
                    }
                    return byPriority;
                })
                .collect(Collectors.toList());
    }

    @Override
    public Iterable<Issue> getLongestBlockChain() {
        List<Issue> chain = new ArrayList<>();

        for (Issue blockedIssue : this.issues.values()) {
            List<Issue> items = new ArrayList<>();

            items.addAll(getHeadElements(blockedIssue));
            items.addAll(getTailElements(blockedIssue));

            if (items.size() > chain.size()) {
                chain = items;
            }
        }

        return chain;
    }

    @Override
    public Map<String, Map<IssueStatus, List<Issue>>> getAssigneeIssueGroupedByStatus() {
        return this.assignees;
    }

    private Issue getIfPresent(String issueId) {
        Issue current = this.issues.get(issueId);
        if (current == null) {
            throw new IllegalArgumentException();
        }
        return current;
    }

    private List<Issue> getTailElements(Issue input) {

        List<Issue> result = new ArrayList<>();
        result.add(input);

        List<Issue> subItems = input.getBlockedIssues();
        if (subItems.isEmpty()) {
            return result;
        } else {
            for (Issue subIssue : subItems) {
                getTailElements(subIssue);
            }
        }

        Collections.reverse(result);
        return result;
    }

    private List<Issue> getHeadElements(Issue input) {

        List<Issue> result = new ArrayList<>();
        result.add(input);

        List<Issue> subItems = input.getBlockedByIssues();
        if (subItems.isEmpty()) {
            return result;
        } else {
            for (Issue subIssue : subItems) {
                getHeadElements(subIssue);
            }
        }

        return result;
    }

}
