package ru.job4j.bank;

import java.util.*;

/**
 * В классе реализован методы для совершения банковских переводов
 * между расчетными счетами (объекты класса {@link Account})
 * пользователей (объекты класса {@link User})
 * @author Alexei
 * @version 1.0.0.1
 */
public class BankService {
    /**
     * хранение расчетных счетов пользователей
     */
    private final Map<User, List<Account>> users = new HashMap<>();

    /**
     * Добавление нового пользователя (выполняется контроль на дубли)
     * @param user объект класса {@link User}
     */
    public void addUser(User user) {
        users.putIfAbsent(user, new ArrayList<Account>());
    }

    /**
     * Добавление нового расчетного счета пользователя
     * @param passport паспортные данные пользователя (объект класса {@link User})
     * @param account объект класса {@link Account}
     */
    public void addAccount(String passport, Account account) {
        var user = findByPassport(passport);
        if (user.isPresent()) {
            List<Account> accounts = users.get(user.get());
            if (!accounts.contains(account)) {
                accounts.add(account);
            }
        }
    }

    /**
     * Поиск пользователя по паспортным данным
     * @param passport паспортные данные пользователя
     * @return объект класса {@link User} или {@code null} (если пользователь не найден)
     */
    public Optional<User> findByPassport(String passport) {
        return users.keySet()
                .stream()
                .filter(e -> e.getPassport().equals(passport))
                .findFirst();
    }

    /**
     * Поиск пользователя по паспортным данным
     * @param passport паспортные данные пользователя
     * @param requisite реквизиты расчетного счета пользователя
     * @return объект класса {@link Account} или {@code null} (если счет не найден)
     */
    public Optional<Account> findByRequisite(String passport, String requisite) {
        var user = findByPassport(passport);
        if (user.isPresent()) {
            return users.get(user.get())
                    .stream()
                    .filter(e -> e.getRequisite().equals(requisite))
                    .findFirst();
        }
        return null;
    }

    /**
     * Перевод средств между счетами
     * @param srcPassport паспортные данные пользователя-отправителя
     * @param srcRequisite реквизиты расчетного счета пользователя-отправителя
     * @param destPassport паспортные данные пользователя-получателя
     * @param destRequisite реквизиты расчетного счета пользователя-получателя
     * @param amount сумма перевода
     * @return результат выполнения операции: {@code true} - успешно, {@code false} - ошибка
     */
    public boolean transferMoney(String srcPassport, String srcRequisite,
                                 String destPassport, String destRequisite, double amount) {
        boolean rsl = false;
        var srcAcc = findByRequisite(srcPassport, srcRequisite);
        var destAcc = findByRequisite(destPassport, destRequisite);
        if (srcAcc.isPresent()
                && destAcc.isPresent()
                && srcAcc.get().getBalance() >= amount) {
            srcAcc.get().setBalance(srcAcc.get().getBalance() - amount);
            destAcc.get().setBalance(destAcc.get().getBalance() + amount);
        }
        return rsl;
    }
}
