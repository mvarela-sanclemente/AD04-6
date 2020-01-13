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
        
        //Creamos as posicions
        Posicion porteiro = new Posicion(Posicion.PORTEIRO,"Porteiro");
        Posicion central = new Posicion(Posicion.DEFENSA,"Central");
        Posicion lateral = new Posicion(Posicion.DEFENSA,"Lateral");
        Posicion interior = new Posicion(Posicion.CENTROCAMPISTA,"Interior");
        
        //Creamos os xogadores
        Xogador xogador1 = new Xogador("nome1",1,equipo);
        xogador1.addPosicion(porteiro);
        porteiro.addXogadores(xogador1);
        equipo.addXogador(xogador1);
        
        Xogador xogador2 = new Xogador("nome2",2,equipo);
        xogador1.addPosicion(lateral);
        lateral.addXogadores(xogador2);
        xogador1.addPosicion(central);
        central.addXogadores(xogador2);
        equipo.addXogador(xogador2);
        
        Xogador xogador3 = new Xogador("nome3",3,equipo);
        xogador3.addPosicion(central);
        central.addXogadores(xogador3);
        xogador3.addPosicion(interior);
        interior.addXogadores(xogador3);
        equipo.addXogador(xogador3);
        
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
