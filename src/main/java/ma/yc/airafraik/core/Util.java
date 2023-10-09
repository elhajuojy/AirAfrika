package ma.yc.airafraik.core;

import java.util.Date;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import ma.yc.airafraik.entities.SocieteAerienneEntity;
import ma.yc.airafraik.entities.VolEntity;
import org.mindrot.jbcrypt.BCrypt;


public class Util {
    private static final String CHARACTERS = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";

    public static Long generatedLong() {
        long leftLimit = 1L;
        long rightLimit = 100000000L;
        return leftLimit + (long) (Math.random() * (rightLimit - leftLimit));
    }


    public static Date readDate(String key , Scanner scanner){
        Print.log(key+" : ");
        return new Date(scanner.nextLong());
    }
    public static String hasString(String value){
        return BCrypt.hashpw(value, BCrypt.gensalt());
    }

    public static  double readDouble(String key , Scanner scanner){
        Print.log(key+" : ");
        return scanner.nextDouble();
    }
    public static boolean verifyEmail(String input){
        String rgx = "^[a-zA-Z0-9]+@[a-z]+\\.[a-z]+$";
        Pattern pattern = Pattern.compile(rgx);
        Matcher matcher = pattern.matcher(input);
        return matcher.matches();
    }

    public static void clearScreen() {
        Print.log("\033[H\033[2J");
        System.out.flush();

    }

    public static String readString(String key , Scanner scanner){
        //todo : fix this bug
        scanner.nextLine();
        Print.log(key+" : ");
        return scanner.nextLine();
    }

    public static String readString(String key , Scanner scanner, String defaultValue){
        //todo : fix this bug
        scanner.nextLine();
        Print.log(key+" : ");
        String input = scanner.nextLine();
        if (input.isEmpty()){
            return defaultValue;
        }
        return input;
    }

    public  static  int readInt(String key , Scanner scanner){
        Print.log(key+" : ");
        return scanner.nextInt();
    }
    public static  int readInt(String key , Scanner scanner, int defaultValue){
        Print.log(key+" : ");
        int input = scanner.nextInt();
        if (input == 0){
            return defaultValue;
        }
        return input;
    }

    public static  long readLong(String key , Scanner scanner){
        Print.log(key+" : ");
        return scanner.nextLong();
    }

    public static int calculateAge(int year, int month, int day) {
        int age = 0;
        int currentYear = new Date().getYear() + 1900;
        int currentMonth = new Date().getMonth() + 1;
        int currentDay = new Date().getDay() + 1;
        age = currentYear - year;
        if (currentMonth < month) {
            age--;
        } else if (currentMonth == month && currentDay < day) {
            age--;
        }
        return age;
    }

    public static SocieteAerienneEntity getSocieteAerienneEntity() {
        SocieteAerienneEntity societeAerienneEntity = new SocieteAerienneEntity();
        societeAerienneEntity.setCode("Air-Afraik-"+Util.generatedLong().toString());
        societeAerienneEntity.setNom("Air Afraik");
        societeAerienneEntity.setAdresse("Casablanca Maroc 3937 2");
        societeAerienneEntity.setTelephone("0522 22 22 22");
        societeAerienneEntity.setLogo("https://res.cloudinary.com/zenbusiness/q_auto/v1/logaster/logaster-2019-02-0093-h-air-tran-airways-logo-15.png");
        return societeAerienneEntity;
    }

    public static VolEntity getVolEntity() {
        VolEntity vol = new VolEntity();
        vol.setCode("VOL-"+Util.generatedLong().toString());
        vol.setPrix(1000);
        vol.setNomberDePlaces(33);
        vol.setDateDepart("2021-05-12");
        vol.setHeureDepart("12:00");
        vol.setDateArrive("2021-05-12");
        vol.setHeureArrivee("14:00");
        vol.setVilleDepart("Casablanca");
        vol.setVilleArrivee("Rabat");

        return vol;
    }

    //add more helper method
    //todo : work with local storage to store information
    public boolean storeInformation(String key , String value){
        //todo : store the information in the local storage
        return false;
    }
}