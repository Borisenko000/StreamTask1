package edu.polina.generic6;

/*
TimeSpan (миллисекунды как long), merge — суммирование.
 */

public class TimeSpan implements Mergeable<TimeSpan> {
    long millyseconds;

    public TimeSpan(long millyseconds) {
        this.millyseconds = millyseconds;
    }

    @Override
    public TimeSpan merge(TimeSpan other) {
        return new TimeSpan(this.millyseconds + other.millyseconds);
    }

    @Override
    public String toString() {
        return "TimeSpan: millyseconds = " + millyseconds;
    }
}
