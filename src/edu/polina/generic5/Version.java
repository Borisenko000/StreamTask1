package edu.polina.generic5;

import java.util.Collection;

final class Version implements SelfComparable<Version> {
    public int major;
    public int minor;
    public int patch;

    public Version(int major, int minor, int patch) {
        this.major = major;
        this.minor = minor;
        this.patch = patch;
    }

    public int compareTo(Version o) {
        int c = Integer.compare(this.major, o.major);
        if (c != 0) {
            return c;
        }
        c = Integer.compare(this.minor, o.minor);
        if (c != 0) {
            return c;
        }
        return Integer.compare(this.patch, o.patch);
    }

    @Override
    public String toString() {
        return "Version:" +
                "major=" + major +
                ", minor=" + minor +
                ", patch=" + patch;
    }
}
