package com.example.parkingapp.model;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface UserDao {
    @Query("SELECT * FROM user")
    List<User> getAll();

    @Query("SELECT * FROM user WHERE uid IN (:userIds)")
    List<User> loadAllByIds(int[] userIds);

    @Insert
    void insertUser(User user);

    @Delete
    void delete(User user);

    @Query("SELECT * FROM user WHERE email IN (:email)")
    User findUserByMail(String email);
}
