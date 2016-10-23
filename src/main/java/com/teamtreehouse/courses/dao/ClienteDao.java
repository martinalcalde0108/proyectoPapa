package com.teamtreehouse.courses.dao;

import com.teamtreehouse.courses.exc.DaoException;
import com.teamtreehouse.courses.model.Cliente;

import java.util.List;

public interface ClienteDao {
    void add(Cliente cliente) throws DaoException;

    List<Cliente> findAll();

    Cliente findById(int id);
}
