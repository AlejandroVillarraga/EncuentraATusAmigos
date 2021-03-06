/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eci.arsw.eata.services;

import eci.arsw.eata.model.FreeTime;
import eci.arsw.eata.model.Group;
import eci.arsw.eata.model.Meeting;
import eci.arsw.eata.model.User;
import eci.arsw.eata.persistence.EataNotFoundException;
import eci.arsw.eata.persistence.EataPersistence;
import eci.arsw.eata.persistence.EataPersistenceException;
import java.util.ArrayList;
import java.util.Map;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author 2101751
 */
@Service
public class EataServices {
    
    @Autowired
    EataPersistence eatap = null;
    
    public Set<User> getAllUsers() throws EataNotFoundException{
        return eatap.getAllUsers();
    }
    
    public boolean sonAmigos(int idUser1, int idUser2){
        return eatap.sonAmigos(idUser1, idUser2);
    }
    
    public boolean perteneceAlGrupo(int idUser, int idGroup){
        return eatap.perteneceAlGrupo(idUser, idGroup);
    }
    
    public User getUserByDocument(int idUser) throws EataNotFoundException{
        return eatap.getUserByDocument(idUser);
    }
    
    public Set<User> getUsersByGroup(int idGroup) throws EataNotFoundException{
        return eatap.getUsersByGroup(idGroup);
    }
    
    public Set<User> getMyFriends(int idUser) throws EataNotFoundException{
        return eatap.getMyFriends(idUser);
    }
    
    public Set<Group> getAllGroups() throws EataNotFoundException{
        return eatap.getAllGroups();
    }
    
    public Set<Meeting> getMettingsByGroup(int idGroups) throws EataNotFoundException{
        return eatap.getMeetingsByGroup(idGroups);
    }
    
    public Set<Group> getMyGroups(int idUser) throws EataNotFoundException{
        return eatap.getMyGroups(idUser);
    }
    
    public void addNewUser(User user) throws EataNotFoundException, EataPersistenceException{
        eatap.saveUser(user);
    }
    
    public void addNewGroup(Group group) throws EataNotFoundException, EataPersistenceException{
        eatap.saveGroup(group);
    }
    public void addNewMeeting(Meeting meeting) throws EataPersistenceException {
       eatap.saveMeeting(meeting);
    }
    
    public ArrayList<FreeTime> getFreeTimeByUser(int idUser) throws EataNotFoundException, EataPersistenceException{
        return eatap.getFreeTimebyUser(idUser);
        
    }
    
    public ArrayList<FreeTime> getCommonFreeTime(int idGroup) throws EataNotFoundException, EataPersistenceException{
        return eatap.getCommonFreeTimebyGroup(idGroup);
    }
    
    public void addNewUserConected(int idUser) throws EataPersistenceException{
        eatap.addNewUserConected(idUser);
    }
    
    public ArrayList<User> getAllUsersConected(int idUser) throws EataNotFoundException{
        return eatap.getMyFriendsConected(idUser);
    }
    
    public void addNewUserPosition(int idUser, double  lat, double  lon){
        eatap.addNewUserPosition(idUser,lat,lon);
    }
    
    public void disconectUser(int idUser){
        eatap.disconectUser(idUser);
    }
    
    public Map<Integer, Integer> personasConectadasPorGrupo(){
        return eatap.porcentajeDePersonasConectadasPorGrupo();
    }
    
    public Group getGroupById(int idGroup){
      return eatap.getGroupById(idGroup);
    };
    
    public void addMeetingByGroup(int idMeeting, int idGroup){
        eatap.addMeetingByGroup(idMeeting, idGroup);
    }
    
    public ArrayList<Meeting> getAllMeetings() throws EataNotFoundException{
        return eatap.getAllMeetings();
    }
    
//    
//    public boolean isUserConected(String nombreUser) throws EataNotFoundException{
//        return eatap.userConected(nombreUser);
//    }
//    
//    public void userDisconected(String nombreUser) throws EataNotFoundException{
//        eatap.userDisconected(nombreUser);
//    }

    
    

    
}
