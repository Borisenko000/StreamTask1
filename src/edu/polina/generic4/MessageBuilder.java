package edu.polina.generic4;

abstract class MessageBuilder<T extends  MessageBuilder<T>> {
    String id;
    String tag;

    public T id(String id) {
        this.id = id;
        return (T) this;
    }
    public T tag(String tag) {
        this.tag = tag;
        return (T) this;

    }

    protected abstract T self();
}
