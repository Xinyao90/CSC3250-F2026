package homework.hw03;

import java.util.ArrayList;
import java.util.List;

/** Supplied observer that records events in memory. Do not edit. */
public class CombatLog implements CombatObserver {
    private final List<AttackEvent> events = new ArrayList<>();

    @Override
    public void update(AttackEvent event) {
        events.add(event);
    }

    public int getUpdateCount() { return events.size(); }

    /** No events means there is no last event yet. */
    public AttackEvent getLastEvent() {
        return events.isEmpty() ? null : events.get(events.size() - 1);
    }
}
