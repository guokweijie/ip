package duke;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
public class Event extends Task{
    protected String at;
    protected LocalDate date;
    protected LocalTime time;

    public Event(String description, String at) {
        super(description);
        this.at = at;

        if (at.contains("/") || at.contains("-")) {
            setDateAndTime();
        }
    }

    public void setDateAndTime() {
        int space = this.at.indexOf(' ');
        String date = this.at.substring(0, space);
        String time = this.at.substring(space + 1);

        if (date.contains("/")) {
            int firstSlash = date.indexOf('/', 0);
            int secondSlash = date.indexOf('/', firstSlash + 1);
            String day = date.substring(0, firstSlash);
            String month = date.substring(firstSlash + 1, secondSlash);

            if (day.length() == 1) {
                day = "0" + day;
            }

            if (month.length() == 1) {
                month = "0" + month;
            }

            String year = date.substring(secondSlash + 1);
            date = (year + "-" + month + "-" + day);
        }

        String min = time.substring(2);
        String hour = time.substring(0, 2);
        time = (hour + ":" + min);

        this.date = LocalDate.parse(date);
        this.time = LocalTime.parse(time);
    }
    @Override
    public String toString() {
        if (this.at.contains("/") || at.contains("-")) {
            String date = this.date.format(DateTimeFormatter.ofPattern("MMM dd yyyy"));
            String time = this.time.toString();

            return "[E]" + super.toString() + " (at: " + date + " " + time + ")";
        } else {
            return "[E]" + super.toString() + " (at: " + at + ")";
        }
    }
}