package ru.alfabank.steps;

import com.google.gson.JsonArray;
import cucumber.api.java.en.Then;
import cucumber.api.java.ru.Тогда;
import lombok.extern.slf4j.Slf4j;
import myWorkDir.utils.DataUtils;
import ru.alfabank.alfatest.cucumber.api.AkitaScenario;

import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Шаги для тестирования API, доступные по умолчанию в каждом новом проекте
 */

@Slf4j
public class MPResponseSteps extends StepWrapper {

    private AkitaScenario akitaScenario = AkitaScenario.getInstance();


    /**
     * Шаги для тестирования API, доступные по умолчанию в каждом новом проекте
     */



    /**
     * Проверка, что размер массива из ответа responseVar, доступного по jsonpath равен size
     */
    @Тогда("^ответ \"([^\"]*)\" содержит массив jsonpath \"([^\"]*)\" размером ([^\"]*)")
    @Then("^response \"([^\"]*)\" has array in jsonpath \"([^\"]*)\" with size ([^\"]*)")
    public void checkListSize(String responseVar, String jsonpath, String size) {
        boolean error = false;
        JsonArray array = DataUtils.getValueFromJsonAsJsonArray(baseMethods.getPropertyOrStringVariableOrValue(responseVar), jsonpath);
        if(array.size()!=Integer.parseInt(size)){ error = true; }
        if (error)
            throw new RuntimeException("Размер массива " + jsonpath + " равен: " + array.size() + "; Ожидалось :" + size);
    }

    /**
     * Проверка, что строковое значение jsonpath из ответа responseVar сответствует строке value
     */
    @Тогда("^ответ \"([^\"]*)\" содержит значение jsonpath \"([^\"]*)\", соответствующее ([^\"]*)")
    @Then("^response \"([^\"]*)\" has value in jsonpath \"([^\"]*)\" equal ([^\"]*)")
    public void checkFieldString(String responseVar, String jsonpath, String value) {
        String respVal = DataUtils.getValueFromJsonAsString(baseMethods.getPropertyOrStringVariableOrValue(responseVar), jsonpath);
        if (!respVal.equals(value)) {
            throw new RuntimeException("Значение в " + jsonpath + ": " + respVal + "; Ожидалось: " + value );
        }
    }


    @Тогда("^ответ \"([^\"]*)\" содержит список карт размером \"([^\"]*)\"")
    @Then("^response \"([^\"]*)\" has CardList size \"([^\"]*)\"")
    public void checkCardListSize(String getCardsResponse, String size) {
        checkListSize(getCardsResponse, "CardList", size);
    }

    @Тогда("^ответ \"([^\"]*)\" успешен")
    @Then("^response \"([^\"]*)\" is successful")
    public void checkResponseIsSuccess(String response) {
        checkFieldString(response, "ErrCode", "0");
        checkFieldString(response, "Success", "true");

    }


}