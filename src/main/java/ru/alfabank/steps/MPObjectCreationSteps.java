
package ru.alfabank.steps;

import cucumber.api.java.en.And;
import cucumber.api.java.ru.И;
import lombok.extern.slf4j.Slf4j;
import myWorkDir.objects.Cards;
import myWorkDir.objects.Merchant;
import myWorkDir.objects.Phone;
import ru.alfabank.alfatest.cucumber.api.AkitaScenario;

import static org.junit.jupiter.api.Assertions.assertTrue;

@Slf4j
public class MPObjectCreationSteps extends StepWrapper {

    private AkitaScenario akitaScenario = AkitaScenario.getInstance();

    /**
     Генерация карты с типом cardType и сохранение её в переменную variableName
     */
    @И("^карта (MasterCard|Visa|Maestro|MDES) хранится в переменной \"([^\"]*)\"")
    @And("^card (MasterCard|Visa|Maestr|oMDES) saved as variable \"([^\"]*)\"")
    public void returnCard(String cardType, String variableName) throws Exception {
        Cards card;
        switch (cardType) {
            case ("MasterCard"):{
                card = Cards.getRandomMasterCard();
                break;
            }
            case ("Visa"):{
                card = Cards.getRandomVisaCard();
                break;
            }
            case ("Maestro"):{
                card = Cards.getRandomMaestroCard();
                break;
            }
            case ("MDES"):{
                card = Cards.getValidMDESCard();
                break;
            }
            default:{
                throw new RuntimeException("Указан неверный тип карты.");
            }
        }
        String cardString = card.toString();
        akitaScenario.setVar(variableName, cardString);
        akitaScenario.write("Карта " + cardType + " сгенерирована и сохранена в переменную: \"" + variableName + "\". PAN:" + card.getPan() +
                "; ExpDate:" + card.getExpMonth() + "/" + card.getExpYear());
    }

    @И("^телефон (Beeline|MTS|Megafon|Tele2|KZ|BeelineInternet) хранится в переменной \"([^\"]*)\"")
    @And("^phone (Beeline|MTS|Megafon|Tele2|KZ|BeelineInternet) saved as variable \"([^\"]*)\"")
    public void returnPhone(String phoneType, String variableName) throws Exception {
        String phone;
        switch (phoneType) {
            case ("Beeline"):{
                phone = Phone.getRandomBeeLinePhone().PhoneNumber;
                break;
            }
            case ("MTS"):{
                phone = Phone.getRandomMTSPhone().PhoneNumber;
                break;
            }
            case ("Megafon"):{
                phone = Phone.getRandomMegaPhonePhone().PhoneNumber;
                break;
            }
            case ("Tele2"):{
                phone =Phone.getRandomTele2Phone().PhoneNumber;
                break;
            }
            case ("KZ"):{
                phone = Phone.getRandomKazakhPhone().PhoneNumber;
                break;
            }
            case ("BeelineInternet"):{
                phone = Phone.getRandomBeelineInternetPhone().PhoneNumber;
                break;
            }
            default:{
                throw new RuntimeException("Указан неверный мобильный оператор.");
            }
        }
        akitaScenario.setVar(variableName, phone);
        akitaScenario.write("Телефон " + phone +  " сохранен в переменную: \"" + variableName + "\".");
    }

    @И("^мерчант (Trusted|NewPublic|Public) хранится в переменной \"([^\"]*)\"")
    @And("^merchant (Trusted|NewPublic|Public) saved as variable \"([^\"]*)\"")
    public void returnMerchant(String merchantType, String variableName) throws Exception {
        String merchantName;
        switch (merchantType) {
            case ("Trusted"):{
                merchantName = Merchant.getRandomTrustedMerchant().MerchantName;
                break;
            }
            case ("NewPublic"):{
                merchantName = Merchant.getRandomNewPublicMerchant().MerchantName;
                break;
            }
            case ("Public"):{
                merchantName = Merchant.getRandomPublicMerchant().MerchantName;
                break;
            }
            default:{
                throw new RuntimeException("Указан неверный тип мерчанта.");
            }
        }
        akitaScenario.setVar(variableName, merchantName);
        akitaScenario.write("Мерчант: " + merchantName +  ", тип: " + merchantType + " сохранен в переменную: \"" + variableName + "\".");
    }

}