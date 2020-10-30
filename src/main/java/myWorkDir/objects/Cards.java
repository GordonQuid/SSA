package myWorkDir.objects;

import myWorkDir.utils.LuhnGenerator;

import java.util.*;

public class Cards {

    String pan;
    String expMonth;
    String expYear;
    String cvv;
    String holder;
    String panMask;

    Cards(String pan, String expMonth, String expYear, String cvv, String holder, String panMask) {
        this.pan = pan;
        this.cvv = cvv;
        this.expMonth = expMonth;
        this.expYear = expYear;
        this.holder = holder;
        this.panMask = panMask;
    }

    public void setPan(String pan) {
        this.pan = pan;
        this.panMask = hidePAN(pan);
    }

    public void setCvv(String cvv) {
        this.cvv = cvv;
    }

    public void setExpMonth(String expMonth) {
        this.expMonth = expMonth;
    }

    public void setCardHolder(String cardHolder) {
        this.holder = cardHolder;
    }

    public void setExpYear(String expYear) {
        this.expYear = expYear;
    }

    public String getPan() {
        return pan;
    }

    public String getExpMonth() {
        return expMonth;
    }

    public String getExpYear() {
        return expYear;
    }

    public String getCvv() {
        return cvv;
    }

    public String getHolder() {
        return holder;
    }

    public String getPanMask() {
        return panMask;
    }



    public static String hidePAN(String PAN) {
        String hidePAN;
        hidePAN = PAN.substring(0, 6) + PAN.substring(6, 12).replaceAll(".", "x") + PAN.substring(12);
        return hidePAN;
    }

    public static String getRandomBIN(){
        Random rand = new Random();
        String bin = Integer.toString(rand.nextInt(3) + 4);

        for (int i = 0; i < 5; i++) {
            bin = bin + Integer.toString(rand.nextInt(10));
        }

        return bin;
    }

    public static String getRandomPan(){
        LuhnGenerator lunh = new LuhnGenerator();
        return lunh.generate(getRandomBIN(),16);
    }

    public static String getRandomPanWithBin(String bin){
        LuhnGenerator lunh = new LuhnGenerator();
        return lunh.generate(bin,16);
    }

    public static String getRandomCvv(){

        Random rand = new Random();
        String cvv = "";

        for (int i = 0; i < 3; i++) {
            cvv = cvv + Integer.toString(rand.nextInt(10));
        }

        return cvv;
    }

    public static String getRandomMonth(){
        Random rand = new Random();
        Integer randMonth = rand.nextInt(12) + 1;

        return (randMonth < 10) ? ("0" + Integer.toString(randMonth)) : (Integer.toString(randMonth));
    }

    public static String getrandomYear(){
        Random rand = new Random();
        return Integer.toString(Calendar.getInstance().get(Calendar.YEAR)%100 + rand.nextInt(5) + 1);
    }

    public static Cards getRandomCard(){
        String pan = getRandomPan();
        return new Cards(pan,getRandomMonth(),getrandomYear(),getRandomCvv(),"sasha zasha", hidePAN(pan));
    }

    public static Cards getValidMDESCard(){
        List<String> validCards = Collections.unmodifiableList(Arrays.asList("5185741450005009", "5185741450005017", "5185741450005025", "5185741450005033", "5185741450005041", "5185741450005058"
        ));
        String pan = validCards.get(new Random().nextInt(validCards.size()));
        return new Cards(pan, "05", "25", "123", "Card Holder", hidePAN(pan));
    }

    public static Cards getRandomCardWithBin(String bin){
        String pan = getRandomPanWithBin(bin);
        return new Cards(pan,getRandomMonth(),getrandomYear(),getRandomCvv(),"sasha zasha", hidePAN(pan));
    }

    public static List<String> mastercardBins = Collections.unmodifiableList(
            Arrays.asList("553677", "518573", "546940", "546941", "546939", "551127", "527454", "531485", "548802", "556310", "558620", "547140",  "550400", "554547", "535275", "531008", "557020", "536829", "559612", "554410", "541067", "538146", "524849", "524406", "512062", "546454", "527139", "516844", "532065", "530977", "559508", "547597", "528215"));
    public static List<String> visaBins = Collections.unmodifiableList(
            Arrays.asList("456938", "446938", "499860", "480292", "425316", "432797", "426227", "458897", "499002", "428678", "454215", "448166", "412804", "438466", "470627", "404223", "420223", "436818", "467467", "432205", "476372", "496394", "498828", "417772", "405870", "481603", "411111", "437806", "494386", "448215", "490907", "469203", "444622", "433128", "454077", "450055", "467992", "439080", "480680", "478285", "487440", "483289", "470586"));
    public static List<String> maestroBins = Collections.unmodifiableList(
            Arrays.asList("673590", "592814", "565289", "608716", "563239", "595652", "592760", "610266", "671425", "564159", "585185", "629187", "588258", "667944", "602914", "611030", "685203", "508511", "672841", "618988", "605673", "500474", "562926", "641562", "609279", "577332", "501404", "602544", "604697", "690988", "568770", "672235", "593931", "624396", "627851", "619252", "626752", "697385", "618038", "678908", "590908", "641533", "506435", "605748", "601594", "575595", "583586", "563424", "588018", "593066", "503286"));

    public static Cards getRandomMasterCard() {
        String bin = mastercardBins.get(new Random().nextInt(mastercardBins.size()));
        return getRandomCardWithBin(bin);
    }
    public static Cards getRandomVisaCard() {
        String bin = visaBins.get(new Random().nextInt(visaBins.size()));
        return getRandomCardWithBin(bin);
    }
    public static Cards getRandomMaestroCard() {
        String bin = maestroBins.get(new Random().nextInt(maestroBins.size()));
        return getRandomCardWithBin(bin);
    }

    public static String getMastercardBin(){
        return mastercardBins.get(new Random().nextInt(mastercardBins.size()));
    }

    public static String getMaestroBin(){
        return maestroBins.get(new Random().nextInt(maestroBins.size()));
    }

    public static String getVisaBin(){
        return visaBins.get(new Random().nextInt(visaBins.size()));
    }

    @Override
    public String toString(){
        return this.getPan() + ";" + this.expMonth + ";" + this.expYear + ";" + this.holder + ";" + this.cvv;
    }

    public static enum CardType {
        RandomCard,
        RandomThreeDsCard,
        RandomCardWithErrorWhileBlocking,
        RandomCardWithErrorWhileCharging,
        RandomCardWithErrorWhileRefunding,
        RandomThreeDsCardWithErrorWhileRefunding,
        RandomCardWithOneThousandAmountBalance,
        RandomThreeDsCardWithErrorWhileBlocking,
        RandomThreeDsCardWithErrorWhileCharging,
        RandomCardWithoutCvv,
        RandomThreeDsCardWithErrorWhileUnblocking,
        RandomCardWithErrorWhileUnblocking,
    }

    public static Cards generateCard(CardType type, String bin) {
        String body = "";
        switch (type) {
            case RandomCard:
                body = "111110002";
                break;
            case RandomThreeDsCard:
                body = "111110001";
                break;
            case RandomCardWithErrorWhileBlocking:
                body = "111110005";
                break;
            case RandomCardWithoutCvv:
                body = "111110003";
                break;
            case RandomThreeDsCardWithErrorWhileCharging:
                body = "111110021";
                break;
            case RandomCardWithErrorWhileRefunding:
                body = "111110202";
                break;
            case RandomCardWithOneThousandAmountBalance:
                body = "100000004";
                break;
            case RandomCardWithErrorWhileCharging:
                body = "111110022";
                break;
            case RandomThreeDsCardWithErrorWhileBlocking:
                body = "111150001";
                break;
            case RandomThreeDsCardWithErrorWhileRefunding:
                body = "111110201";
                break;
            case RandomThreeDsCardWithErrorWhileUnblocking:
                body = "111110061";
                break;
            case RandomCardWithErrorWhileUnblocking:
                body = "111110062";
                break;
        }

        String number = bin + body;

        int sum = 0;
        for (int i = 0; i < number.length(); i++) {
            int digit = Integer.parseInt(number.substring(i, (i + 1)));
            if ((i % 2) == 0) {
                digit = digit * 2;
                if (digit > 9) {
                    digit = (digit / 10) + (digit % 10);
                }
            }
            sum += digit;
        }
        int mod = sum % 10;
        String pan = ((mod == 0) ? number + 0 : number + (10 - mod));
        return new Cards(pan,getRandomMonth(),getrandomYear(),"123","sasha zasha", hidePAN(pan));
    }


    public Cards stringToCard(String card){
        String[] cardArray = card.split(";");
        return new Cards(cardArray[0],cardArray[1],cardArray[2],cardArray[4],cardArray[3],hidePAN(cardArray[0]));
    }

}
