package com.paul.atlassian.filters;


import java.util.List;
import java.util.stream.Collectors;

enum State {
    OPEN, IN_PROGRESS, IN_REVIEW, DONE, CANCELLED
}

record Issue(
        int id,
        String title,
        String assignee,
        State state,
        int storyPoints
) {}


interface IssueFilter {
    boolean matches(Issue issue);
}

class AssigneeFilter implements IssueFilter {
    private final String assignee;

    public AssigneeFilter(String assignee) {
        this.assignee = assignee;
    }

    @Override
    public boolean matches(Issue issue) {
        return assignee.equals(issue.assignee());
    }
}

class StateFilter implements IssueFilter {
    private final State state;

    public StateFilter(State state) {
        this.state = state;
    }

    @Override
    public boolean matches(Issue issue) {
        return issue.state() == state;
    }
}

class TitleContainsFilter implements IssueFilter {
    private final String substring;

    public TitleContainsFilter(String substring) {
        this.substring = substring.toLowerCase();
    }

    @Override
    public boolean matches(Issue issue) {
        return issue.title().toLowerCase().contains(substring);
    }
}

class MinStoryPointsFilter implements IssueFilter {
    private final int minPoints;

    public MinStoryPointsFilter(int minPoints) {
        this.minPoints = minPoints;
    }

    @Override
    public boolean matches(Issue issue) {
        return issue.storyPoints() >= minPoints;
    }
}


class AndFilter implements IssueFilter {
    private final IssueFilter left;
    private final IssueFilter right;

    public AndFilter(IssueFilter left, IssueFilter right) {
        this.left = left;
        this.right = right;
    }

    @Override
    public boolean matches(Issue issue) {
        return left.matches(issue) && right.matches(issue);
    }
}


class OrFilter implements IssueFilter {
    private final IssueFilter left;
    private final IssueFilter right;

    public OrFilter(IssueFilter left, IssueFilter right) {
        this.left = left;
        this.right = right;
    }

    @Override
    public boolean matches(Issue issue) {
        return left.matches(issue) || right.matches(issue);
    }
}

class NotFilter implements IssueFilter {
    private final IssueFilter filter;

    public NotFilter(IssueFilter filter) {
        this.filter = filter;
    }

    @Override
    public boolean matches(Issue issue) {
        return !filter.matches(issue);
    }
}


public class FilterIssueDemo {


    public static void main(String[] args) {

        List<Issue> issues = List.of(
                new Issue(1, "Fix login bug", "Alice", State.IN_PROGRESS, 3),
                new Issue(2, "Add search feature", "Bob", State.IN_REVIEW, 5),
                new Issue(3, "Refactor API", "Alice", State.OPEN, 8),
                new Issue(4, "Improve UI", "Kevin", State.DONE, 2),
                new Issue(5, "Setup CI/CD", "Tom", State.IN_PROGRESS, 13)
        );

        // Alice's issues that are still open
        IssueFilter filter1 = new AndFilter(
                new AssigneeFilter("Alice"),
                new OrFilter(
                        new StateFilter(State.OPEN),
                        new StateFilter(State.IN_PROGRESS)
                )
        );

        List<Issue> result = search(issues, filter1);

        result.forEach(System.out::println);
    }


    public static List<Issue> search(List<Issue> issues, IssueFilter filter) {
        return issues.stream()
                .filter(filter::matches)
                .collect(Collectors.toList());
    }
}
