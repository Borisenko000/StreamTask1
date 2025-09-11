package edu.polina.generic4;

final class Email {
    String id;
    String task;
    String subject;
    String body;

    Email(String id, String task, String subject, String body) {
        this.id = id;
        this.task = task;
        this.subject = subject;
        this.body = body;
    }

    @Override
    public String toString() {
        return "Email{" +
                "id='" + id + '\'' +
                ", task='" + task + '\'' +
                ", subject='" + subject + '\'' +
                ", body='" + body + '\'' +
                '}';
    }
}
