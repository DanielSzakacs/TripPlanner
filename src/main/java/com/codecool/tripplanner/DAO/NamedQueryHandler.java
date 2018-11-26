//package com.codecool.tripplanner.DAO;
//
//import com.codecool.tripplanner.enums.CityName;
//import com.codecool.tripplanner.enums.Genre;
//import com.codecool.tripplanner.module.WalkingTour;
//
//import java.util.List;
//
//public class NamedQueryHandler {
//
//    public List<WalkingTour> getAllWalkingTour(String city, String genre){
//        CityName enumCityName = CityName.valueOf(city);
//         Genre enumGenre = Genre.valueOf(genre);
//        List<WalkingTour> result = JPA.getEntityManager()
//                .createNamedQuery("Walkingtour.getAllWalkingtour")
//                .setParameter("cityName", enumCityName)
//                .setParameter("walkingtourgenre", enumGenre)
//                .getResultList();
//        //List<WalkingTour> result = JPA.getEntityManager().createNamedQuery("Walkingtour.getAllWalkingtourByLocation").setParameter("cityName", enumCityName).getResultList();
//        return result;
//    }
//
////    public void singUpUserData(String email, String password){
////        JPA.getEntityManager().createNamedQuery("singUpUser").setParameter("email", email).setParameter("password", password);
////    }
//
//    public void saveUserData(String email, String password) {
//        JPA.getEntityManager().createNativeQuery("INSERT INTO tripuser (username, password) " +
//                "       VALUES(?, ?)")
//                .setParameter(1, email)
//                .setParameter(2, password);
//    }
//}
