package myWorkDir.objects;

import ru.alfabank.steps.BaseMethods;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Merchant {
    public Integer Id;
    public String MerchantName;
    public String MerchantCheckoutIdentifier;
    public String PublicKey;
    public String ExportPassword;
    public String MerchantType;
    public Integer AFMerchantId;
    public static List<Merchant> MerchantList = new ArrayList<>();
    public static List<Merchant> TrustedMerchantList = new ArrayList<>();
    public static List<Merchant> NewPublicMerchantList = new ArrayList<>();
    public static List<Merchant> PublicMerchantList = new ArrayList<>();



    public Merchant(Integer id, String merchantName, String merchantCheckoutIdentifier, String publicKey,
                    String exportPassword, String merchantType, Integer afMerchantId) {
        Id = id;
        MerchantName = merchantName;
        MerchantCheckoutIdentifier = merchantCheckoutIdentifier;
        PublicKey = publicKey;
        ExportPassword = exportPassword;
        MerchantType = merchantType;
        AFMerchantId = afMerchantId;
    }

    public Merchant(){
        new Merchant(5, "TrustedMerchant", "[  {    \"CheckoutIdentifier\": \"a4a6w4wrd7jgyhxw7c5qm1hxyute8zd1abv\",    \"Country\": 1,    \"AlreadyApproved\": false  }]",
                "-----BEGIN PGP PUBLIC KEY BLOCK-----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1YHE-----END PGP PUBLIC KEY BLOCK-----",
                "26f791c6-1d79-40de-95f4-356119f7a952", "Trusted", 48);
    }

    static {
        MerchantList.add(new Merchant(5, "TrustedMerchant", "[  {    \"CheckoutIdentifier\": \"a4a6w4wrd7jgyhxw7c5qm1hxyute8zd1abv\",    \"Country\": 1,    \"AlreadyApproved\": false  }]",
                "-----BEGIN PGP PUBLIC KEY BLOCK-----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1YHE-----END PGP PUBLIC KEY BLOCK-----",
                "26f791c6-1d79-40de-95f4-356119f7a952", "Trusted", 48));
        TrustedMerchantList.add(new Merchant(5, "TrustedMerchant", "[  {    \"CheckoutIdentifier\": \"a4a6w4wrd7jgyhxw7c5qm1hxyute8zd1abv\",    \"Country\": 1,    \"AlreadyApproved\": false  }]",
                "-----BEGIN PGP PUBLIC KEY BLOCK-----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1YHE-----END PGP PUBLIC KEY BLOCK-----",
                "26f791c6-1d79-40de-95f4-356119f7a952", "Trusted", 48));
    }

    public static Merchant getRandomTrustedMerchant(){
        return TrustedMerchantList.get((int) (Math.random() * TrustedMerchantList.size()));
    }
    public static Merchant getRandomNewPublicMerchant(){
        return NewPublicMerchantList.get((int) (Math.random() * NewPublicMerchantList.size()));
    }
    public static Merchant getRandomPublicMerchant(){
        return PublicMerchantList.get((int) (Math.random() * PublicMerchantList.size()));
    }

//    public Merchant getMerchantByName(String merchantName){
//
//    }

}
