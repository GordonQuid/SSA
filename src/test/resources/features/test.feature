#language:ru

Функционал: Проверка списка карт
  Предыстория:
    Дано карта Visa хранится в переменной "card"
    И телефон Beeline хранится в переменной "phone"
    И мерчант Trusted хранится в переменной "merchant"

  Сценарий: пользователь вошел в кошельке и проверяет список карт (успех)
    Пусть выполнен вход с телефоном "phone" по мерчанту "merchant". Сессия хранится в переменной "session2"
    И выполнен запрос masterpassapi/GetCards с сессией из строки "session2". Ответ сохранен в переменную "getCardsResponse22"
    Тогда ответ "getCardsResponse22" успешен
    К тому же ответ "getCardsResponse22" содержит список карт размером "0"

    ############################################################

  Сценарий: тест
    Пусть выполнен запрос mpapi/GetRequestToken для мерчанта "merchant" и телефона "phone". Ответ сохранен в переменную "response_grt"
    Тогда ответ "response_grt" содержит значение jsonpath "ErrCode", соответствующее 0
    К тому же ответ "response_grt" содержит значение jsonpath "Success", соответствующее true

    Пусть выполнен запрос masterpassapi/Login с RequestToken из ответа "response_grt", FingerPrint рандомный, BioId=true, Channel="1". Ответ сохранен в переменную "response_login"
    Тогда ответ "response_login" содержит значение jsonpath "ErrCode", соответствующее 0
    К тому же ответ "response_login" содержит значение jsonpath "Success", соответствующее true

    Пусть выполнен запрос masterpassapi/GetCards с сессией из ответа "response_login". Ответ сохранен в переменную "response_getCards"
    Тогда ответ "response_login" содержит значение jsonpath "ErrCode", соответствующее 0
    К тому же ответ "response_login" содержит значение jsonpath "Success", соответствующее true
    К тому же ответ "response_getCards" содержит список карт размером "0"



#  Сценарий: пользователь вошел в кошельке и проверяет список карт (успех)
##    Пусть выполнен вход с телефоном "79194548656" по мерчанту "TrustedMerchant". Сессия хранится в переменной "session2"
##    И выполнен запрос masterpassapi/GetCards с сессией из строки "session2". Ответ сохранен в переменную "getCardsResponse22"
##    Тогда ответ "getCardsResponse22" успешен
##    К тому же ответ "getCardsResponse22" содержит список карт размером "1"