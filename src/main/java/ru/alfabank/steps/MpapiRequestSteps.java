package ru.alfabank.steps;

import cucumber.api.java.en.And;
import cucumber.api.java.ru.И;
import io.restassured.response.Response;
import lombok.extern.slf4j.Slf4j;
import ru.alfabank.alfatest.cucumber.api.AkitaScenario;
import ru.alfabank.steps.BaseMethods;
import ru.alfabank.tests.core.helpers.PropertyLoader;
import ru.alfabank.tests.core.rest.RequestParam;
import ru.alfabank.tests.core.rest.RequestParamType;
import java.util.ArrayList;
import java.util.List;

/**
 * Шаги для тестирования API, доступные по умолчанию в каждом новом проекте
 */

@Slf4j
public class MpapiRequestSteps extends BaseMethods {

    private AkitaScenario akitaScenario = AkitaScenario.getInstance();

    /**
     Запрос GetRequestToken c передачей телефона и мерчанта (в виде переменных или строк)
     */
    @И("^выполнен запрос mpapi/GetRequestToken для мерчанта \"([^\"]*)\" и телефона \"([^\"]*)\". Ответ сохранен в переменную \"([^\"]*)\"$")
    @And("^request mpapi/GetRequestToken with merchant \"([^\"]*)\" and phone \"([^\"]*)\". Response saved as variable \"([^\"]*)\"$")
    public void getRequestToken(String merchantNameOrVariable, String phoneNumber, String varResponse) throws Exception {
        String url = PropertyLoader.getPropertyOrValue("server_url") + "mpapi/GetRequestToken";
        String merchantStr = getPropertyOrStringVariableOrValue(merchantNameOrVariable);
        String phoneStr = getPropertyOrStringVariableOrValue(phoneNumber);
        List<RequestParam> params = new ArrayList<>();
        params.add(new RequestParam(RequestParamType.PARAMETER, "Phone", phoneStr));
        params.add(new RequestParam(RequestParamType.PARAMETER, "MerchantName", merchantStr));
        Response response = sendRequest("POST", url, params);
        getBodyAndSaveToVariable(varResponse, response);
    }


}