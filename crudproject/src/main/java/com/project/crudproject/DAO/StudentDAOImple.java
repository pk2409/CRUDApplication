package com.project.crudproject.DAO;

import com.project.crudproject.entity.Student;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class StudentDAOImple implements StudentDAO{

    //define field for entity manager
    private EntityManager entitymanager;
    //inject EM using constructor injection

    @Autowired
    public StudentDAOImple(EntityManager entitymanager) {
        this.entitymanager = entitymanager;
    }

    //implement save method

    @Override
    @Transactional
    public void save(Student thestudent){
        entitymanager.persist(thestudent);

    }

    @Override
    public Student findById(Integer id) {
        return entitymanager.find(Student.class,id);
    }

    @Override
    public List<Student> findAll() {
        //create query
        TypedQuery<Student> theQuery = entitymanager.createQuery("FROM Student",Student.class);

        //return query results
        return theQuery.getResultList();
    }

    @Override
    public List<Student> findByLastname(String thelastname) {

        //create query
        TypedQuery<Student> theQuery = entitymanager.createQuery("FROM Student WHERE lastname=:theData",Student.class);

        //set query parameters

        theQuery.setParameter("theData",thelastname);


        //return query results
        return theQuery.getResultList();
    }

    @Override
    @Transactional
    public void update(Student theStudent) {

        entitymanager.merge(theStudent);

    }

    @Override
    @Transactional
    public void delete(Integer id) {

        //find student by id
        Student thestudent = entitymanager.find(Student.class,id);

        //delete the student
        entitymanager.remove(thestudent);

    }


}
