package com.teamtreehouse.courses;

import com.google.gson.Gson;
import com.teamtreehouse.courses.dao.ClienteDao;
import com.teamtreehouse.courses.dao.CourseDao;
import com.teamtreehouse.courses.dao.Sql2oClienteDao;
import com.teamtreehouse.courses.dao.Sql2oCourseDao;
import com.teamtreehouse.courses.model.Cliente;
import com.teamtreehouse.courses.model.Course;
import org.sql2o.Sql2o;

import static spark.Spark.after;
import static spark.Spark.get;
import static spark.Spark.post;

public class Api {
    public static void main(String[] args) {
        Sql2o sql2o = new Sql2o("jdbc:h2:~/exploradores.db;INIT=RUNSCRIPT from 'classpath:db/init.sql'", "", "");
        CourseDao courseDao = new Sql2oCourseDao(sql2o);
        ClienteDao clienteDao = new Sql2oClienteDao(sql2o);
        Gson gson = new Gson();

        post("/courses", "application/json", (req, res) -> {
            Course course = gson.fromJson(req.body(), Course.class);  //Retorna el json enviado en el request y crea una clase course usando gson
            courseDao.add(course);
            res.status(201);
            return course;
        }, gson::toJson);

        get("/courses", "application/json",
                (req, res) -> courseDao.findAll(), gson::toJson);

        get("/courses/:id", "application/json", (req, res) -> {
            int id = Integer.parseInt(req.params("id"));
            Course course = courseDao.findById(id);
            return course;
        }, gson::toJson);

        post("/cliente", "application/json", (req, res) -> {
            Cliente cliente = gson.fromJson(req.body(), Cliente.class);  //Retorna el json enviado en el request y crea una clase course usando gson
            clienteDao.add(cliente);
            res.status(201);
            return cliente;
        }, gson::toJson);

        get("/clientes", "application/json",
                (req, res) -> clienteDao.findAll(), gson::toJson);

        get("/clientes/:id", "application/json", (req, res) -> {
            int id = Integer.parseInt(req.params("id"));
            Cliente cliente = clienteDao.findById(id);
            return cliente;
        }, gson::toJson);

        after((req, res) -> {
            res.type("application/json");
        });
    }
}
