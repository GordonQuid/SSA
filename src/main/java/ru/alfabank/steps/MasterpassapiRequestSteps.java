package ru.alfabank.steps;

import cucumber.api.java.ru.И;
import io.restassured.response.Response;
import lombok.extern.slf4j.Slf4j;
import myWorkDir.objects.WebFingerPrint;
import myWorkDir.utils.DataUtils;
import ru.alfabank.alfatest.cucumber.api.AkitaScenario;
import ru.alfabank.tests.core.helpers.PropertyLoader;
import ru.alfabank.tests.core.rest.RequestParam;
import ru.alfabank.tests.core.rest.RequestParamType;
import java.util.ArrayList;
import java.util.List;

/**
 * Шаги для тестирования API, доступные по умолчанию в каждом новом проекте
 */

@Slf4j
public class MasterpassapiRequestSteps extends StepWrapper {

    private AkitaScenario akitaScenario = AkitaScenario.getInstance();

    /**
     Запрос masterpassapi/Login c передачей RequestToken, Fingerprint, BioId, Channel (в виде переменных или строк)
     */
    @И("^выполнен запрос masterpassapi/Login с RequestToken из ответа \"([^\"]*)\", FingerPrint рандомный, BioId=(true|false), Channel=\"([^\"]*)\". Ответ сохранен в переменную \"([^\"]*)\"$")
//    @And("^request masterpassapi/Login with RequestToken from response \"([^\"]*)\" and random FingerPrint, BioId= (true|false), Channel=\"([^\"]*)\"$. Response saved as variable \"([^\"]*)\"$")
    public void login(String requestToken, String bioId, String channel, String varResponse){
        String url = PropertyLoader.getPropertyOrValue("server_url") + "masterpassapi/Login";
        String requestTokenStr = DataUtils.getValueFromJsonAsString(baseMethods.getPropertyOrStringVariableOrValue(requestToken), "RequestToken" );
        String fingerprintStr = WebFingerPrint.getRandomWebFingerPrint().toString();
        List<RequestParam> params = new ArrayList<>();
        params.add(new RequestParam(RequestParamType.PARAMETER, "RequestToken", requestTokenStr));
        params.add(new RequestParam(RequestParamType.PARAMETER, "FingerPrint", fingerprintStr));
        if(bioId.equals("true")||bioId.equals("false")) { params.add(new RequestParam(RequestParamType.PARAMETER, "BioId", bioId)); }
        if (!(bioId.equals("не_передан") || bioId.equals("not_added"))) { params.add(new RequestParam(RequestParamType.PARAMETER, "Channel", channel)); }
        Response response = baseMethods.sendRequest("POST", url, params);
        baseMethods.getBodyAndSaveToVariable(varResponse, response);
        }

    /**
     Запрос masterpassapi/GetCards c передачей строки или json-ответа, содержащего сессию)
     */
    @И("^выполнен запрос masterpassapi/GetCards с сессией из (ответа|строки) \"([^\"]*)\". Ответ сохранен в переменную \"([^\"]*)\"$")
//    @And("^request masterpassapi/Login with RequestToken from response \"([^\"]*)\" and random FingerPrint, BioId= (true|false), Channel=\"([^\"]*)\"$. Response saved as variable \"([^\"]*)\"$")
    public void getCards(String inputType, String sessionVar, String varResponse){
        String url = PropertyLoader.getPropertyOrValue("server_url") + "masterpassapi/GetCards";
        String sessionStr = null;
        switch (inputType){
            case("ответа"):{
                sessionStr = DataUtils.getValueFromJsonAsString(baseMethods.getPropertyOrStringVariableOrValue(sessionVar), "Session" );
                break;
            }
            case("строки"):{
                sessionStr = baseMethods.getPropertyOrStringVariableOrValue(sessionVar);
                break;
            }
            default:break;
        }
        List<RequestParam> params = new ArrayList<>();
        params.add(new RequestParam(RequestParamType.PARAMETER, "Session", sessionStr));
        Response response = baseMethods.sendRequest("POST", url, params);
        baseMethods.getBodyAndSaveToVariable(varResponse, response);
    }


}