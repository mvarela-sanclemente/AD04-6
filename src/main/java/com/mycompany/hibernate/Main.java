/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.hibernate;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class Main {
    
    public static void main(String args[]){
        //Creamos un entrenador
        Entrenador entrenador = new Entrenador(1,"Nome1","Apelidos1",50);
        
        //Creamos un equipo
        Equipo equipo = new Equipo(1,"San Clemente", "Santiago", 1000, entrenador);
        Transaction tran = null;
        try{
            //Collemos a sesión de Hibernate
            Session session = HibernateUtil.getSessionFactory().openSession();
            //Comenzamos unha transacción
            tran = session.beginTransaction();
            
            //Gardamos o equipo
            session.save(equipo);
            
            //Facemos un commit da transacción
            tran.commit();
        }catch(HibernateException e){
            e.printStackTrace();
        }
    }
    
}
