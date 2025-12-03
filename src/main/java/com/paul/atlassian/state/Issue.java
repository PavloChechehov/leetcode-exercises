package com.paul.atlassian.state;

import java.util.Map;
import java.util.Set;

import static com.paul.atlassian.state.State.*;

enum State {
    OPEN, IN_PROGRESS, IN_REVIEW, DONE, CANCELLED;
}

public class Issue {
    private State state = OPEN;

    public static final Map<State, Set<State>> allowedTransitions = Map.of(
            OPEN, Set.of(IN_PROGRESS, CANCELLED),
            IN_PROGRESS, Set.of(IN_REVIEW, CANCELLED),
            IN_REVIEW, Set.of(DONE, CANCELLED),
            DONE, Set.of(),
            CANCELLED, Set.of()
    );

    public State getState(){
        return state;
    }

    public void transitionTo(State next){
        if (next == state) {
            return;
        }

        Set<State> states = allowedTransitions.get(state);

        if (!states.contains(next)) {
            throw new IllegalStateException(
                    "Transition from " + state + " to " + next + " is not allowed. Allowed transitions: " + states
            );

//        throw new IllegalStateException(String.format("Issue %s state can't be transitioned to %s", state, next ));
        }

        state = next;
    }

    public static void main(String[] args) {

        Issue issue = new Issue();
        System.out.println(issue.getState());  // OPEN

        issue.transitionTo(IN_PROGRESS);
        System.out.println(issue.getState());  // IN_PROGRESS

        issue.transitionTo(IN_REVIEW);
        System.out.println(issue.getState());  // IN_REVIEW

        // Invalid transition: cannot skip DONE → OPEN
        try {
            issue.transitionTo(OPEN);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        issue.transitionTo(DONE);
        System.out.println(issue.getState());  // DONE

        // Now no more transitions allowed
        try {
            issue.transitionTo(IN_PROGRESS);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

}
