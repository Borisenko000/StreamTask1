package edu.polina.generic4;

final class  EmailBuilder extends MessageBuilder<EmailBuilder> {
    String s;
    String b;
    public EmailBuilder subject(String s) {
        this.s = s;
        return this;
    }
    public EmailBuilder body(String b) {
        this.b = b;
        return this;
    }
    public Email build() {
        return new Email(this.id, this.tag, this.s, this.b);
    }


    @Override
    protected EmailBuilder self() {
        return this;
    }
}
