/*
 *  Copyright 2010 Jasper Infotech (P) Limited . All Rights Reserved.
 *  JASPER INFOTECH PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 *  
 *  @version     1.0, Sep 29, 2010
 *  @author singla
 */
package com.bhas.practice.errormessage;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Test{
    int code;
    String message;
    public Test(int code, String message){
        this.code = code;
        this.message = message;
    }

    @Override
    public String toString() {
        return "Test{" +
                "code=" + code +
                ", message='" + message + '\'' +
                '}';
    }
}

public class APIException extends Exception {

    public static void main(String[] args) {
        System.out.println("Test");

        Map<String, Test> testMap = new HashMap<String, Test>();


        ApiErrorCode[] values = ApiErrorCode.values();
        for (ApiErrorCode value : values) {
            testMap.put(value.name(), new Test(value.code, value.description));
        }

        System.out.println(testMap);

        List<String> st = new ArrayList<>();
        System.out.println(st.isEmpty());

        if(!st.isEmpty()){
            System.out.println(st.get(0));
        }

//        printInstrumentationSize(testMap);

    }
//
//    public static void printInstrumentationSize(final Object object)
//    {
//        System.out.println(
//                "Object of type '" + object.getClass() + "' has size of "
//                        + InstrumentationAgent.getObjectSize(object) + " bytes.");
//    }

    public enum ApiErrorCode {
                INVALID_API_KEY(101, "Invalid api key"), 
                INVALID_PARAMETERS(104, "Invalid/Missing parameters"), 
                INVALID_REQUEST(112, "Invalid request"), 
                COUPON_GENERATED(125, "Coupon aleady exists for this user"), 
                PROMO_INVALID_DEVICE(408, "This promo code is only applicable on %s"), 
                PROMO_CODE_INACTIVE(410, "This promo code is currently inactive. Please try again later."), 
                PROMO_CODE_INVALID(411, "Invalid promo code"), 
                PROMO_CODE_EXPIRED(412, "This promo code has expired on %s"), 
                PROMO_CODE_PER_PERSON_LIMIT(413, "You have exceeded the usage limit for this promo code"),
                PROMO_CODE_LIMIT_EXHAUSTED(414, "Sorry! This promo campaign has been withdrawn and is no longer active"),               
                AUTO_PROMO_AS_MANUAL(423, "This promo code will be auto-applied in your cart. Manual application not required."), 
                BANK_PROMO_AS_MANUAL(426, "This bank promo code is not supposed to be used manually"),
                SECONDARY_BASE_URL_NOT_SET(427, "Secondary base URL is not set"),
                PROMO_USAGE_LIMIT_EXCEEDED(432,"Promo Usage Limit Already Exceeded."),
                PROMO_CODE_ALL_NEGATED_PRODUCTS(435, "Sorry! Promo is not applicable as selected product(s) are already best priced."), 
                PROMO_CODE_NOT_APPLICABLE_ON_CART(436, "This promo code is not applicable on selected product(s)"),
                INVALID_USERID(439, "Sorry! This promo code is linked to a different user account."),
                INVALID_COUPON_CODE(440, "Sorry!! This promo has either expired or is invalid"),
                EXC_FTU_ERROR(441, "Sorry! Promo cannot be applied. Please try again"),
                INVALID_FTU_ERROR(442, "Promo is only applicable for first time customers"),
                NULL_SUPC_MAPPING(443, "Null supc mapping is received from client"),
                INVALID_SUBCART_FILTER(445,"Same products found in combo promo of Buy X and get discount on different Y. Make sure there are no common items in X and Y"),             
                SERVER_BUSY(500, "Server busy"),
                INTERNAL_SERVER_ERROR(501, "internal server error"), 
                INVALID_FILTER_SET(601, "Invalid promo filter set file uploaded"),
                NULL_PROMO_SRO(603, "Null Promo Admin SRO received"),
                INVALID_COMBO_PROMO_TYPE(604,"Invalid Combo Promo Type received"),
                SELLER_FILE_SIZE_LIMIT_REACHED(605,"Seller POG Mapping file size limit reached"),
                INVALID_POG_ID_IN_SELLER_POG_FILE(606,"Invalid pogId entered in the seller pog mapping file"),
                INVALID_SELLER_CODE_IN_SELLER_POG_FILE(607,"Invalid seller code entered in seller pog mapping file"),
                EMPTY_SELLER_POG_FILE(608,"Seller pog file is empty"),
                EMPTY_SELLER_CODE_FOR_POG(609,"Seller code is empty for a pog in seller pog mapping file"),
                EMPTY_POG_ID_FOR_SELLER(610,"PogId is empty for a seller in seller pog mapping file"),
                DUPLICATE_LIVE_EXTERNAL_CODE(611,"There already exists a non expired Promo with this external Code"),
                INVALID_PROMOCODE_PREFIX(612,"Failed to Create Unique Prefix.Please try another prefix"),
                DB_PERSIST_ERROR(613,"Error occured while persisting in database"),
                INVALID_SUBTRANSACTION_ID(614, "Invalid subOrderTransaction ID"),
                DUPLICATE_NEGATIVE_POGS(615,"Duplicate POGs exist in Negative POG List"),
                INVALID_SUBCART_FILTER_ADMIN(616,"X & Y Product Sets that you have selected contain common POGs, Buckets or Subcats. Please edit your list so that there are no common items in both lists"),
                DUPLICATE_LIVE_CAMPAIGN_CODE(617,"There exists a campaign with live user coupons having the same external code"),
                INVALID_BANK_PROMO(619, "Invalid bank Promo Code"),
                INVALID_STORE_FRONT(622, "Invalid Store Front"),
                CARD_TYPE_WRONG(701,"Payment type used is invalid for selected offer. Please try again or remove the offer to proceed (T&C)"),
                BANK_TIMES_USED_EXCEED(702,"Your card has exceeded the limit of %d transactions for selected offer. Please try again with another card or remove the offer to proceed (T&C)"),
                BANK_VALUE_USED_EXCEED(703,"Your card has exceeded the maximum discount for selected offer. Please try again with another card or remove the offer to proceed (T&C)"),
                PROMO_CODE_NOT_APPROVED(760, "Invalid promo code"),
                NEGATED_POG(801,"PogId for the Product is a negated Pog"),
                INVALID_USER_PROMO(804, "User promo is invalid"), 
                ISSUE_LIMIT_BREACHED(805, "Issue limit for user promo is breached"), 
                UNAUTHORIZED_REQUESTER(807, "Unauthorized request"),
    			INVALID_SUBTRANSACTION_ID_ALREADY_REFUNDED(808, "Invalid subOrderTransaction ID. Already Refunded"),
    			UNEXPECTED_ERROR_OCCURRED(810, "Unexpected Error Occured"), 
    			USER_PROMO_NOT_LIVE(811, "User Promo has not started yet"), 
    			USER_PROMO_EXPIRED(812, "User promo has been expired"), 
    			WRONG_EXPIRY_INTERVAL(813, "Expiry interval of user promo is wrong"), 
    			INVALID_MAX_COUNT(814, "Max count of user promo is invalid"), 
    			INVALID_MAX_LIMIT(815, "Max limit of user promo is less than 1"),
    			PRECHECK_FAILED(816,"PreCheck Condition Failed"),
    			MISMATCH_PROMOVALUE(817,"Failed Promo Value Validation"),
                MISMATCH_CARDBIN(818,"Invalid Card Bin"),
                PROMO_CODE_PER_DEVICE_LIMIT(819, "You have exceeded the usage limit for this promo code."),
                DEVICE_ID_INVALID(820, "Null DeviceId in request for a Limits per device Promo."),
    			BANK_PROMO_CODE_INVALID(821, "You have tried to apply invalid bank promo code."),
    			WALLET_AMOUNT_LESS(822, "Wallet Amount Less than min purchase value"),
    			NON_WALLET_AMOUNT_LESS(823, "Payable Amount Less than min purchase value"),
                INVALID_LABELS(824, "Sorry! Promo is not applicable as promo labels doesnt match with request labels"),
                PURE_WALLET_CHECK_FAIL(825, "Insufficient Wallet Balance. Please make the full payment using Wallet."),
                INVALID_PAYMENT_DISTRIBUTION(826,"Payable Amount doesnot match sum of wallet and nonWallet amounts."),
                MANUAL_BANK_PROMO_WITH_NON_WALLET_AMOUNT(827,"Applied promo cannot be used with Wallet, SD Cash or Gift Vouchers."),
                UPI_TIMES_USED_EXCEED(828,"Your have exceeded the limit of %d transactions for selected offer. Please remove the offer to proceed (T&C)"),
                UPI_VALUE_USED_EXCEED(829,"Your have exceeded the maximum discount for selected offer. Please remove the offer to proceed (T&C)");
                


        private int    code;
        private String description;

        private ApiErrorCode(int code, String description) {
            this.code = code;
            this.description = description;
        }

        public int code() {
            return this.code;
        }

        public String description() {
            return this.description;
        }
    }

    /**
     * 
     */
    private static final long serialVersionUID = 8794509293355865963L;
    private ApiErrorCode      code;

    /**
     * Constructs an <code>APIException</code> with the specified message.
     * 
     * @param message
     * @param cause
     */
    public APIException(ApiErrorCode code, String message, Throwable cause) {
        super(message, cause);
        this.code = code;
    }

    /**
     * Constructs an <code>APIException</code> with the specified message and root cause.
     * 
     * @param message
     */
    public APIException(ApiErrorCode code, String message) {
        this(code, message, null);
    }

    /**
     * Constructs an <code>APIException</code> with the specified message and root cause.
     */
    public APIException(ApiErrorCode code) {
        this(code, null, null);
    }

    public ApiErrorCode getCode() {
        return code;
    }

}