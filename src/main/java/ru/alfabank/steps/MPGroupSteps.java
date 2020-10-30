package ru.alfabank.steps;

import cucumber.api.java.ru.И;
import lombok.extern.slf4j.Slf4j;
import myWorkDir.utils.DataUtils;
import ru.alfabank.alfatest.cucumber.api.AkitaScenario;

import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Шаги для тестирования API, доступные по умолчанию в каждом новом проекте
 */

@Slf4j
public class MPGroupSteps extends StepWrapper {

    private AkitaScenario akitaScenario = AkitaScenario.getInstance();

    /**

     */
    @И("^выполнен вход с телефоном \"([^\"]*)\" по мерчанту \"([^\"]*)\". Сессия хранится в переменной \"([^\"]*)\"")
//    @And("^(GET|POST|PUT|DELETE) request to URL \"([^\"]*)\" with headers and parametres from the table has been executed. Response has been saved to the variable named \"([^\"]*)\"$")
    public void enterTheWallet(String phone, String merchant, String session) throws Exception {
        String tmpGrtResponseVar = "tmp_GetRequestTokenResponse_" + baseMethods.getRandCharSequence(6,"en");
        String tmpLoginResponseVar = "tmp_LoginResponse_" + baseMethods.getRandCharSequence(6,"en");
        mpapi.getRequestToken(merchant,phone,tmpGrtResponseVar);
        response.checkResponseIsSuccess(tmpGrtResponseVar);
        masterpassapi.login(tmpGrtResponseVar, "true", "1", tmpLoginResponseVar);
        response.checkResponseIsSuccess(tmpLoginResponseVar);
        String sessionStr = DataUtils.getValueFromJsonAsString(baseMethods.getPropertyOrStringVariableOrValue(tmpLoginResponseVar), "Session");
        akitaScenario.setVar(session, sessionStr);
        akitaScenario.write("Сессия " + sessionStr +  " сохранена в переменную " + session);
    }

}