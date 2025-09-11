package edu.polina.generic4;

/*
CRTP-билдер с самосвязывающими границами
Цепочки вызовов без кастов: new EmailBuilder().id("X").tag("a").subject("S").body("B").build()
Класс Email — неизменяемый (id, tags, subject, body).
 */

import javax.xml.transform.Source;

public class Main {
    public static void main(String[] args) {
        Email email = new EmailBuilder().id("X").tag("a").subject("S").body("B").build();
        System.out.println(email.toString());

    }
}
