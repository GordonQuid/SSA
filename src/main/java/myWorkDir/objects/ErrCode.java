package myWorkDir.objects;

public class ErrCode {

    public enum success{
        True(true),
        False(false);

        private boolean value;

        success(boolean value) {this.value = value;}

        public boolean getValue() {return value;}
    }

    public enum mpapiErrCode{
        None(0),
        Blacklisted_card(1),
        Card_is_not_activated(2),
        The_card_was_not_found_by_the_token(3),
        One_of_the_customer_in_the_black_list(4),
        Customer_with_this_phone_number_not_found(5),
        Attempt_to_add_a_card_with_an_expired_date(6),
        Attempt_to_add_an_already_activated_card_with_the_same_number(7),
        Card_data_encryption_error(8),
        Save_error_in_database(9),
        Wrong_phone_format(10),
        When_decrypting_a_file_was_not_found(11),
        This_transaction_is_marked_as_fraud(12),
        Internal_error_while_encrypting_the_response(13),
        The_limit_of_the_current_card_has_been_exceeded_for_different_users(14),
        Merchant_with_such_a_name_and_password_not_found(15),
        Session_for_the_card_not_found_and_it_is_not_recurrent(16),
        Amount_less_or_equal_zero(17),
        Errors_occurred_during_decryption_or_csv_format_is_incorrect(18),
        Wrong_params(19),
        Access_denied(20),
        File_is_not_ready_yet(21),
        EmptyDeviceId(48),
        Other_error(99);

        private Integer value;

        mpapiErrCode(int val) {
            this.value = val;
        }

        public Integer getvalue() {
            return value;
        }
    }

    public enum mpapiTestErrCode{
        None(0),
        WrongParams(1),
        API_NOT_ALLOWED(2),
        InternalError(3),
        CustomerNotFound(4),
        FileNotFound(5);

        private Integer value;

        mpapiTestErrCode(int value) {this.value = value;}

        public Integer getValue() {return value;}
    }

    public enum masterpassapiErrCode{
        None(0),
        Access_denied(1),
        Api_not_allowed(2),
        No_operation_for_blind_amount_was_found(3),
        Card_not_active_or_CVC2_always(4),
        Card_not_found(5),
        Cards_quantity_limit_per_customer_exceeded(6),
        The_card_was_registered_earlier_by_the_same_user(7),
        No_user_was_found_by_the_passed_session(8),
        Customer_OTP_not_found(9),
        Customers_quantity_limit_per_card_exceeded(10),
        Empty_DeviceId(11),
        There_is_no_Fingerprint_in_the_request(12),
        Passed_an_empty_OrderId(13),
        Passed_to_empty_PaRes(14),
        Passed_to_empty_MD(15),
        Passed_to_empty_amount(16),
        Attempts_to_verify_OTP_ended(17),
        Fingerprint_not_found_in_previously_saved_requests_Login_or_CheckOTP(18),
        The_service_is_not_available_for_this_card_user(19),
        Internal_error(20),
        Exceeded_the_limit_of_added_cards_for_the_period(21),
        Merchant_not_found(22),
        RequestTokenNotFound(23),
        Waiting_period_for_card_verification_has_expired(24),
        The_time_that_was_set_for_OTP_validation_expired(25),
        RecurringCardsQuantityLimitPerCustomerExceeded(26),
        ThreeeDS_check_is_not_successful(27),
        Wrong_CVC2(28),
        Invalid_PAN_length(29),
        Invalid_Token_card_for_this_request(30),
        The_date_of_the_ExpDate_was_passed_in_the_wrong_format(31),
        No_operations_found_for_this_MD(32),
        The_stored_OTP_does_not_match_the_one_transmitted(33),
        OTP_is_transmitted_in_an_incorrect_format(34),
        Wrong_params(35),
        Wrong_phone_format(36),
        Incorrect_blind_amount(37),
        DuplicateRecurringCard(38),
        Other_error(99);

        private Integer value;

        masterpassapiErrCode(int val) {
            this.value = val;
        }

        public Integer getvalue() {
            return this.value;
        }

    }

    public enum postbackErrCode{

        Refer_to_card_issuer(01),
        Invalid_merchant(03),
        Do_not_honor(05),
        Invalid_transaction(12),
        Invalid_amount(13),
        Invalid_card_number(14),
        Invalid_issuer(15),
        Format_error(30),
        Lost_card(41),
        Stolen_card(43),
        Insufficient_funds_or_over_credit_limit(51),
        Expired_card(54),
        Invalid_PIN(55),
        Transaction_not_permitted_to_issuer_or_cardholder(57),
        Transaction_not_permitted_to_acquirer_or_terminal(58),
        Exceeds_withdrawal_amount_limit(61),
        Restricted_card(62),
        Security_violation(63),
        Exceeds_withdrawal_count_limit(65),
        PIN_Not_Changed(71),
        Allowable_number_of_PIN_tries_exceeded(75),
        Invalid_or_nonexistent_To_Account_specified(76),
        Invalid_or_nonexistent_From_Account_specified(77),
        Invalid_or_nonexistent_account_specified_general(78),
        Domestic_Debit_Transaction_Not_Allowed_regional_use_only(81),
        Invalid_Authorization_Life_Cycle(84),
        PIN_Validation_not_possible(86),
        Purchase_Amount_Only_No_Cash_Back_Allowed(87),
        Cryptographic_failure(88),
        Unacceptable_PIN_Transaction_Declined_Retry(89),
        Authorization_Platform_or_issuer_system_inoperative(91),
        Unable_to_route_transaction(92),
        Duplicate_transmis(94);


        private Integer value;

        postbackErrCode(int val) {
            this.value = val;
        }

        public Integer getvalue() {
            return this.value;
        }

    }
    public enum mpapibErrCode{
        None(0),
        WrongArgument(1),
        UserNotFound(2),
        SmsNotSended(3),
        WrongOTP(4),
        InsufficientRights(5),
        UserLoginIsAlreadyOccupied(6),
        UserLoginContainsCyrillic(7),
        UserNameIsNull(8),
        UserLoginIsEmpty(9),
        NonValidPhoneNumber(10),
        DBError(11),
        AFMerchantNotFound(12),
        MerchantNotFound(13),
        AFMerchantViolation(14),
        MerchantKeyIsEmpty(15),
        MerchantKeyIsAlreadyOccupied(16),
        NoPermissions(17),
        AFRuleNotFound(18),
        DescriptionIsAlreadyOccupie(19),
        CertificateNotFound(20),
        EmsNotStarted(21),
        EmsAlreadyStarted(22),
        CardInBlacklist(23),
        CardNotFound(24),
        CustomerNotFound(25),
        MNONotStarted(26),
        MNOAlreadyStarted(27),
        WrongEmail(28),
        WrongPassword(29),
        WrongParams(30),
        InternalError(31),
        AlreadyExists(32),
        NotExists(33);
        private Integer value;

        mpapibErrCode(int value) {this.value = value;}

        public Integer getValue() {return value;}
    }
}
