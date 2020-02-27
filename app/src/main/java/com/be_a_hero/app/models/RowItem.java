package com.be_a_hero.app.models;

public class RowItem extends UsersListItem {

    private Users users;

    public Users getUsers() {
        return users;
    }

    public void setUsers(Users users) {
        this.users = users;
    }

    @Override
    public int getType() {
        return TYPE_ROW;
    }

}
