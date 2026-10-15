package com.scc.model;

public record User(int id, String username, String password, String roles) {

    @Override
    public String toString() {
        return String.format(
                "[%d] %s (%s) - Status: %s",
                id, username, roles, "Pending Approval"
        );
    }
}
