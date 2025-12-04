package com.paul.atlassian.state;

import java.util.Map;
import java.util.Set;

import static com.paul.atlassian.state.Role.*;
import static com.paul.atlassian.state.State.*;


/*
New requirements:
Only DEVELOPERS can move to IN_PROGRESS
Only REVIEWERS can move to IN_REVIEW
Only QA can move to DONE
Only ADMINS can CANCEL
 */

enum State {
    OPEN, IN_PROGRESS, IN_REVIEW, DONE, CANCELLED
}

enum Role {
    DEVELOPER, QA, REVIEW, ADMIN
}

record Transition(State from, State to) {

}

public class Issue {
    private State state = OPEN;

    static final Set<Transition> allowedTransitions = Set.of(
            new Transition(OPEN, IN_PROGRESS),
            new Transition(OPEN, CANCELLED),
            new Transition(IN_PROGRESS, IN_REVIEW),
            new Transition(IN_PROGRESS, CANCELLED),
            new Transition(IN_REVIEW, DONE),
            new Transition(IN_REVIEW, CANCELLED)
    );

    static final Map<Transition, Set<Role>> allowedRoles = Map.of(
            new Transition(OPEN, IN_PROGRESS), Set.of(DEVELOPER),
            new Transition(IN_PROGRESS, IN_REVIEW), Set.of(REVIEW),
            new Transition(IN_REVIEW, DONE), Set.of(QA),
            new Transition(OPEN, CANCELLED), Set.of(ADMIN),
            new Transition(IN_PROGRESS, CANCELLED), Set.of(ADMIN),
            new Transition(IN_REVIEW, CANCELLED), Set.of(ADMIN)
    );

    public State getState() {
        return state;
    }

    public void transitionTo(State next, Role role) {
        if (next == state) {
            return;
        }

        Transition t = new Transition(state, next);

        if (!allowedTransitions.contains(t)) {
            throw new IllegalStateException(
                    "Transition " + state + " → " + next + " is not allowed."
            );
        }

        Set<Role> roles = allowedRoles.get(t);
        if (!roles.contains(role)) {
            throw new IllegalStateException(
                    "Role " + role + " is not permitted to perform transition "
                            + state + " → " + next + ". Allowed: " + roles
            );
        }
        state = next;
    }

    public static void main(String[] args) {

        Issue issue = new Issue();
        System.out.println(issue.getState());  // OPEN

        issue.transitionTo(IN_PROGRESS, DEVELOPER);
        System.out.println(issue.getState());  // IN_PROGRESS

        issue.transitionTo(IN_REVIEW, Role.REVIEW);
        System.out.println(issue.getState());  // IN_REVIEW

        // Invalid transition: cannot skip DONE → OPEN
        try {
            issue.transitionTo(OPEN, Role.ADMIN);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        try {
            issue.transitionTo(DONE, Role.ADMIN);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        // Now no more transitions allowed
        try {
            issue.transitionTo(IN_PROGRESS, DEVELOPER);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

}
