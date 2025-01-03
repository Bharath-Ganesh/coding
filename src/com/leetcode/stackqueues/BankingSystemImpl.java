package com.leetcode.stackqueues;

import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.PriorityQueue;

public class BankingSystemImpl {

    Map<String, Integer> accountMap = new HashMap<>(); // Stores account balances
    Map<String, Integer> transactionMap = new HashMap<>(); // Stores total transaction values for ranking
    Map<String, Transfer> transferMap = new HashMap<>(); // Stores pending transfers
    int transferCounter = 1; // Counter to generate unique transfer IDs

    public BankingSystemImpl() {
        // Default constructor
    }

    public boolean createAccount(int timestamp, String accountId) {
        if (accountMap.containsKey(accountId)) {
            return false;
        } else {
            accountMap.put(accountId, 0);
            transactionMap.put(accountId, 0); // Initialize total transaction value to 0
            return true;
        }
    }

    public Optional<Integer> deposit(int timestamp, String accountId, int amount) {
        if (accountMap.containsKey(accountId)) {
            Integer balance = accountMap.get(accountId);
            Integer updatedBalance = balance + amount;
            accountMap.put(accountId, updatedBalance);

            // Update total transactions
            transactionMap.put(accountId, transactionMap.getOrDefault(accountId, 0) + amount);

            return Optional.of(updatedBalance);
        }
        return Optional.empty();
    }

    public Optional<Integer> pay(int timestamp, String accountId, int amount) {
        if (accountMap.containsKey(accountId)) {
            Integer balance = accountMap.get(accountId);
            if (balance < amount) {
                return Optional.empty();
            } else {
                Integer updatedBalance = balance - amount;
                accountMap.put(accountId, updatedBalance);

                // Update total transactions
                transactionMap.put(accountId, transactionMap.getOrDefault(accountId, 0) + amount);

                return Optional.of(updatedBalance);
            }
        }
        return Optional.empty();
    }

    public Optional<String> transfer(int timestamp, String sourceAccountId, String targetAccountId, int amount) {
        if (sourceAccountId.equals(targetAccountId) ||
            !accountMap.containsKey(sourceAccountId) ||
            !accountMap.containsKey(targetAccountId)) {
            return Optional.empty();
        }

        Integer sourceBalance = accountMap.get(sourceAccountId);
        if (sourceBalance < amount) {
            return Optional.empty();
        }

        // Withhold the money from the source account
        accountMap.put(sourceAccountId, sourceBalance - amount);

        // Create a new transfer and store it in the transferMap
        String transferId = "transfer" + transferCounter++;
        transferMap.put(transferId, new Transfer(transferId, sourceAccountId, targetAccountId, amount, timestamp));

        return Optional.of(transferId);
    }

    public boolean acceptTransfer(int timestamp, String accountId, String transferId) {
        if (!transferMap.containsKey(transferId)) {
            return false;
        }

        Transfer transfer = transferMap.get(transferId);
        if (!transfer.targetAccountId.equals(accountId) || transfer.isExpired(timestamp)) {
            return false;
        }

        // Update the target account balance
        Integer targetBalance = accountMap.get(accountId);
        accountMap.put(accountId, targetBalance + transfer.amount);

        // Update the total transaction values for both source and target accounts
        transactionMap.put(transfer.sourceAccountId, transactionMap.getOrDefault(transfer.sourceAccountId, 0) + transfer.amount);
        transactionMap.put(transfer.targetAccountId, transactionMap.getOrDefault(transfer.targetAccountId, 0) + transfer.amount);

        // Remove the transfer from the pending transfers map
        transferMap.remove(transferId);

        return true;
    }

    public List<String> topActivity(int timestamp, int n) {
        List<Map.Entry<String, Integer>> accountEntries = new ArrayList<>(transactionMap.entrySet());

        // Sort by total transaction value (descending) and accountId (ascending in case of ties)
        accountEntries.sort((entry1, entry2) -> {
            int valueComparison = Integer.compare(entry2.getValue(), entry1.getValue());
            if (valueComparison != 0) {
                return valueComparison; // Sort by transaction value descending
            } else {
                return entry1.getKey().compareTo(entry2.getKey()); // Sort by accountId ascending
            }
        });

        // Prepare the result list
        List<String> result = new ArrayList<>();
        for (int i = 0; i < Math.min(n, accountEntries.size()); i++) {
            String accountId = accountEntries.get(i).getKey();
            int transactionValue = accountEntries.get(i).getValue();
            result.add(accountId + "(" + transactionValue + ")");
        }

        return result;
    }

    private static class Transfer {
        String transferId;
        String sourceAccountId;
        String targetAccountId;
        int amount;
        int timestamp;

        public Transfer(String transferId, String sourceAccountId, String targetAccountId, int amount, int timestamp) {
            this.transferId = transferId;
            this.sourceAccountId = sourceAccountId;
            this.targetAccountId = targetAccountId;
            this.amount = amount;
            this.timestamp = timestamp;
        }

        public boolean isExpired(int currentTimestamp) {
            return currentTimestamp - this.timestamp >= 86400000; // 24 hours
        }
    }
}