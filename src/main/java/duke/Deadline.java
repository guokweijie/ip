package duke;

import java.time.format.DateTimeFormatter;

/** Represents a Task of type Deadline. */
public class Deadline extends Task {
    protected String by;

    /**
     * Creates a Deadline task.
     *
     * @param description Description of the Deadline task.
     * @param by Date and time of the Deadline task.
     */
    public Deadline(String description, String by) {
        super(description);
        this.by = by;
    }

    /**
     * Gets the string representation of the Deadline task.
     *
     * @return String representation of the Deadline task.
     */
    @Override
    public String toString() {
        if (by.contains("/") || by.contains("-")) {
            String date = super.date.format(DateTimeFormatter.ofPattern("MMM dd yyyy"));
            String time = super.time.toString();
            return "[D]" + super.toString() + " (by: " + date + " " + time + ")";
        } else {
            return "[D]" + super.toString() + " (by: " + by + ")";
        }
    }
}
