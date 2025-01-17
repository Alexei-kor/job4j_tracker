package ru.job4j.collection;

import org.junit.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.junit.Assert.*;
import static org.hamcrest.core.Is.is;

public class NotifyAccountTest {

    @Test
    public void sent() {
        List<Account> accounts = Arrays.asList(
                new Account("123", "Petr Arsentev", "eDer3432f"),
                new Account("142", "Petr Arsentev", "000001")
        );
        Set<Account> expect = Set.of(
                new Account("123", "Petr Arsentev", "eDer3432f"),
                new Account("142", "Petr Arsentev", "000001")
        );
        assertThat(NotifyAccount.sent(accounts), is(expect));
    }

    @Test
    public void whenIsDuplicate() {
        List<Account> accounts = Arrays.asList(
                new Account("123", "Ivan", "one"),
                new Account("123", "Ivan2", "two"),
                new Account("123", "Ivan3", "three"),
                new Account("142", "Stepan", "000001")
        );
        Set<Account> expect = Set.of(
                new Account("123", "Ivan", "one"),
                new Account("142", "Stepan", "000001")
        );
        assertThat(NotifyAccount.sent(accounts), is(expect));
    }

}