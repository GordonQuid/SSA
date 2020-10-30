package myWorkDir.objects;

import java.util.*;

public class Phone {
    public static ArrayList<String> phoneList = new ArrayList<>();
    public String PhoneNumber = "9999999999";
    public String CustomParameter = "9999999999";
    private static List<Integer> opsosPrefix = Arrays.asList(
            7900, 7901, 7902, 7903, 7904, 7905, 7906, 7908, 7909, 7910, 7912,
            7913, 7914, 7915, 7916, 7917, 7918, 7920, 7921, 7922, 7923, 7924,
            7925, 7926, 7927, 7928, 7929, 7931, 7932, 7933, 7936, 7937, 7938, 7941,
            7950, 7951, 7952, 7953, 7954, 7955, 7956, 7958, 7960, 7961, 7962, 7963,
            7964, 7965, 7966, 7967, 7968, 7969, 7970, 7971, 7977, 7978, 7981, 7982,
            7983, 7985, 7987, 7988, 7989, 7991, 7996, 7997, 7999);

    private static List<Integer> notBeelinePrefix = Arrays.asList(
            7915, 7920, 7950);

    public String getPhoneNumber() {
        return PhoneNumber;
    }

    public String getCustomParameter() {
        return CustomParameter;
    }

    public Phone(String phoneNumber, String customParameter) {
        PhoneNumber = phoneNumber;
        CustomParameter = customParameter;

        if ( !(phoneNumber==null || phoneNumber.equals("null") || phoneNumber.equals("")) ) {
            phoneList.add(phoneNumber);
        }
    }

    public void setCustomParameter(String customParameter) {
        CustomParameter = customParameter;
    }

    public Phone(String phone) {
        this.CustomParameter = phone;
        this.PhoneNumber = phone;
        phoneList.add(phone.substring(1));
    }

    public Phone(){
    }

    public static Phone getPhone(String phoneNumber, String customParameter){
        return new Phone(phoneNumber,customParameter);
    }

    public static Phone getPhone(Phone phone) {
        Phone temp = new Phone();
        temp.PhoneNumber = phone.PhoneNumber;
        temp.CustomParameter = phone.CustomParameter;
        return temp;
    }

    public static Phone getRandomPhone(){
        Random rnd = new Random();
        Integer [] arr = {0,2,3,4,5,6,7,8,9};
        String s = opsosPrefix.get(rnd.nextInt(opsosPrefix.size())).toString();
        for (int i = 0; i < 7; i++) {
            s = s + Integer.toString(arr[rnd.nextInt(arr.length)]);
        }
        return new Phone(s,s);
    }

    public static Phone getRandomNotBeelinePhone(){
        Random rnd = new Random();
        Integer [] arr = {0,2,3,4,5,6,7,8,9};
        String s = notBeelinePrefix.get(rnd.nextInt(notBeelinePrefix.size())).toString();
        for (int i = 0; i < 7; i++) {
            s = s + Integer.toString(arr[rnd.nextInt(arr.length)]);
        }
        return new Phone(s,s);
    }

    public static Phone getRandomMTSPhone(){
        Random rnd = new Random();
        Integer [] arr = {0,2,3,4,5,6,7,8,9};
        String s = "7915";
        for (int i = 0; i < 7; i++) {
            s = s + Integer.toString(arr[rnd.nextInt(arr.length)]);
        }
        return new Phone(s,s);
    }

    public static Phone getRandomBeeLinePhone(){
        Random rnd = new Random();
        Integer [] arr = {0,2,3,4,5,6,7,8,9};
        String s = "7909";                      //  Префикс захардкожен, см. задачу   https://rm.payture.com/redmine/issues/6595#note-10
        for (int i = 0; i < 7; i++) {
            s = s + Integer.toString(arr[rnd.nextInt(arr.length)]);
        }
        return new Phone(s,s);
    }

    public static Phone getRandomMegaPhonePhone(){
        Random rnd = new Random();
        Integer [] arr = {0,2,3,4,5,6,7,8,9};
        String s = "7920";
        for (int i = 0; i < 7; i++) {
            s = s + Integer.toString(arr[rnd.nextInt(arr.length)]);
        }
        return new Phone(s,s);
    }

    public static Phone getRandomTele2Phone(){
        Random rnd = new Random();
        Integer [] arr = {0,2,3,4,5,6,7,8,9};
        String s = "7950";
        for (int i = 0; i < 7; i++) {
            s = s + Integer.toString(arr[rnd.nextInt(arr.length)]);
        }
        return new Phone(s,s);
    }

    public static Phone getRandomKazakhPhone(){
        Random rnd = new Random();
        Integer [] arr = {0,2,3,4,5,6,7,8,9};
        String s = "77";
        for (int i = 0; i < 9; i++) {
            s = s + Integer.toString(arr[rnd.nextInt(arr.length)]);
        }
        return new Phone(s,s);
    }

    public static Phone getRandomBeelineInternetPhone(){
        Random rnd = new Random();
        Integer [] arr = {0,2,3,4,5,6,7,8,9};
        String s = "708";
        for (int i = 0; i < 8; i++) {
            s = s + Integer.toString(arr[rnd.nextInt(arr.length)]);
        }
        return new Phone(s,s);
    }

    public static Phone getRandomPhoneWithCustomPrefix(int prefix){
        Random rnd = new Random();
        Integer [] arr = {0,2,3,4,5,6,7,8,9};
        String s = Integer.toString(prefix);
        int a = s.length();
        for (int i = 0; i < 11-a; i++) {
            s = s + Integer.toString(arr[rnd.nextInt(arr.length)]);
        }
        return new Phone(s,s);
    }

    public static Phone getPhoneForNegativeNudataScore() { return new Phone("79160000003", "79160000003");}

    public static Phone getPhoneFor150NudataScore() { return new Phone("79151350976", "79151350976");}

    public static Phone getPhoneForSyncSubscription(){
        return new Phone("79160000000", "79160000000");
    }

    public static Phone getPhoneForAsyncSubscription(){
        return new Phone("79160000001", "79160000001");
    }


    public static String getRandomCustomParameter() {
        return UUID.randomUUID().toString();
    }

    @Override
    public String toString() {
        return this.PhoneNumber;
    }


}
