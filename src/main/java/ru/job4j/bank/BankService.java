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
        User user = findByPassport(passport);
        if (user != null) {
            List<Account> accounts = users.get(user);
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
    public User findByPassport(String passport) {
        for (User user : users.keySet()) {
            if (passport.equals(user.getPassport())) {
                return user;
            }
        }
        return null;
    }

    /**
     * Поиск пользователя по паспортным данным
     * @param passport паспортные данные пользователя
     * @param requisite реквизиты расчетного счета пользователя
     * @return объект класса {@link Account} или {@code null} (если счет не найден)
     */
    public Account findByRequisite(String passport, String requisite) {
        User user = findByPassport(passport);
        if (user != null) {
            for (Account account : users.get(user)) {
                if (requisite.equals(account.getRequisite())) {
                    return account;
                }
            }
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
        Account srcAcc = findByRequisite(srcPassport, srcRequisite);
        Account destAcc = findByRequisite(destPassport, destRequisite);
        if (srcAcc != null
                && destAcc != null
                && srcAcc.getBalance() >= amount) {
            srcAcc.setBalance(srcAcc.getBalance() - amount);
            destAcc.setBalance(destAcc.getBalance() + amount);
        }
        return rsl;
    }
}
