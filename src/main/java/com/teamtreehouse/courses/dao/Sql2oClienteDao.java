package com.teamtreehouse.courses.dao;

import com.teamtreehouse.courses.exc.DaoException;
import com.teamtreehouse.courses.model.Cliente;
import com.teamtreehouse.courses.model.Course;
import org.sql2o.Connection;
import org.sql2o.Sql2o;
import org.sql2o.Sql2oException;

import java.util.List;

public class Sql2oClienteDao implements ClienteDao {

    private final Sql2o sql2o;

    public Sql2oClienteDao(Sql2o sql2o) {
        this.sql2o = sql2o;
    }

    @Override
    public void add(Cliente cliente) throws DaoException {
        String sql = "INSERT INTO clientes (nombre,apellido,diaCumpleaños,mesCumpleaños,saldo) VALUES (:nombre,:apellido,:diaCumpleaños,:mesCumpleaños,:saldo)";
        try (Connection con = sql2o.open()) {
            int id = (int) con.createQuery(sql)
                    .bind(cliente)
                    .executeUpdate()
                    .getKey();
            cliente.setId(id);
        } catch(Sql2oException ex) {
            throw new DaoException(ex, "Problem adding cliente");
        }
    }

    @Override
    public List<Cliente> findAll() {
        try (Connection con = sql2o.open()) {
            return con.createQuery("SELECT * FROM clientes")
                    .executeAndFetch(Cliente.class);
        }
    }

    @Override
    public Cliente findById(int id) {
        try (Connection con = sql2o.open()) {
            return con.createQuery("SELECT * FROM clientes WHERE id = :id")
                    .addParameter("id", id)
                    .executeAndFetchFirst(Cliente.class);
        }
    }
}
