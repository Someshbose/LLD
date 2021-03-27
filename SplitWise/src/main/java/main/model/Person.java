package main.model;

import lombok.*;

@Builder
@Getter
@Setter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class Person {
    private int id;
    private String name;
    private String contact;
    private String mailId;
}
