package com.userLogin.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.HashSet;
import java.util.Set;

public class FavoriteList {
    private Long id;
    @JsonProperty("user_id")
    private Long userId;
    @JsonProperty("item_id")
    private Long itemId;

    public FavoriteList(Long id, Long userId, Long itemId) {
        this.id = id;
        this.userId = userId;
        this.itemId = itemId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getItemId() {
        return itemId;
    }

    public void setItemId(Long itemId) {
        this.itemId = itemId;
    }
}
