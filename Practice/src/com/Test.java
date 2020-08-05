package com;

import java.io.*;
import java.sql.*;
import java.util.*;
import java.util.stream.Collectors;

public class Test {


//    private static String st = "{payment_gateway_response={txn_id=snapdeal_test-68791989-1, rrn=null," +
//            " resp_message= GV00004 !ERROR!-GV00004-PARes status not sucessful., " +
//            "resp_code=failure, epg_txn_id=8461004575, created=2019-05-17T06:15:28Z, auth_id_code=NA}, " +
//            "amount=2680, orderId=68791989, udf1=MOB_WEB, gateway_id=12, card.card_isin=517550, " +
//            "amount_refunded=0, card.card_issuer=YESBANK.LTD., card.card_brand=MASTERCARD, ppgErrorCode=AUTHORIZATION_FAILED, " +
//            "txn_id=snapdeal_test-68791989-1, card.card_fingerprint=36b81r9n5jth5e0324ob7omsb9, status_id=27, bank_error_code=failure, " +
//            "pgErrorCode=failure, card.card_type=DEBIT, bank_name=YESBANK.LTD., " +
//            "bank_error_message= GV00004 !ERROR!-GV00004-PARes status not sucessful., refunded=false, " +
//            "id=ordeu_b7920bd3130549a0a2bbc3d3b1c0de6c, recon_pg=22, status=AUTHORIZATION_FAILED}";
    public static void main(String[] args) throws IOException {

//        StringTokenizer tokenizer = new StringTokenizer(st,"=");
//        while(tokenizer.hasMoreTokens()){
//            System.out.println(tokenizer.nextElement());
//        }


//        System.out.println(st.replace("={","#").replace("{","").replace("}",""));

//        String replace = st.replace("={", "#").replace("{", "").replace("}", "");
//        String[] split = replace.split("#");
//       // System.out.println(split[1]);
//        String[] split1 = split[1].split(",");
//        for (String s : split1) {
//            //System.out.println(s.split("=")[0].trim()+" = "+s.split("=")[1]);
//        }
//
//
//        String st1 = "{payment_gateway_response={txn_id=snapdeal_test-68791989-1, rrn=null," +
//                " resp_message= GV00004 !ERROR!-GV00004-PARes status not sucessful., " +
//                "resp_code=failure, epg_txn_id=8461004575, created=2019-05-17T06:15:28Z, auth_id_code=NA}, " +
//                "amount=2680, orderId=68791989, udf1=MOB_WEB, gateway_id=12, card.card_isin=517550, " +
//                "amount_refunded=0, card.card_issuer=YESBANK.LTD., card.card_brand=MASTERCARD, ppgErrorCode=AUTHORIZATION_FAILED, " +
//                "txn_id=snapdeal_test-68791989-1, card.card_fingerprint=36b81r9n5jth5e0324ob7omsb9, status_id=27, bank_error_code=failure, " +
//                "pgErrorCode=failure, card.card_type=DEBIT, bank_name=YESBANK.LTD., " +
//                "bank_error_message= GV00004 !ERROR!-GV00004-PARes status not sucessful., refunded=false, " +
//                "id=ordeu_b7920bd3130549a0a2bbc3d3b1c0de6c, recon_pg=22, status=AUTHORIZATION_FAILED}";
//
//
//        try {
//            Class.forName("oracle.jdbc.driver.OracleDriver");
//            //step2 create  the connection object
//            Connection con= DriverManager.getConnection(
//                    "jdbc:oracle:thin:@localhost:1521:xe","system","oracle");
//
////step3 create the statement object
//            Statement stmt=con.createStatement();
//
////step4 execute query
//            ResultSet rs=stmt.executeQuery("select * from emp");
//            while(rs.next())
//                System.out.println(rs.getInt(1)+"  "+rs.getString(2)+"  "+rs.getString(3));
//
////step5 close the connection object
//            con.close();
//        } catch (ClassNotFoundException | SQLException e) {
//            e.printStackTrace();
//        }


        //System.out.println("'33328451753','33533285485','33550141059','33530358625','33724334488','33667515726','33641359712','33478334716','33783707474','33786358433','33751989086','33789796269','33753662134','33914439546','33975932213','33978702634','33950825789','33838414850','33447795272','33448375557','33581201305','33538882589','33315909823','33491384552','33745912275','33726266863','33885226367','33668667753','26471400464','33753836601','33936612102','33814572266','33936868998','33546743972','33533494286','33567455084','33486604010','33443187963','33564499907','33420565460','33596056674','33664966402','33539968360','33578766529','33652743154','33794900746','33634625120','33529924278','33690471191','33698815968','33539972144','33787877792','33760751188','33734132454','33723952242','33739813522','33854197759','33864429053','33148483413','32833341563','32713341260','32341165598','32442950848','33674402046','32594153143'".split(",").length);


        String st = "";
        System.out.println(st.split(",").length);;

        List<String> strings = Arrays.asList(st.split(","));

        Set<String> unique = new HashSet<>(strings);

        System.out.println(unique.size());

        ArrayList<String> strings2 = new ArrayList<>(unique);

        Collections.sort(strings2);

//        System.out.println(strings2);

        // Create a list with the distinct elements using stream.
        List<String> listDistinct = strings.stream().distinct().collect(Collectors.toList());

// Display them to terminal using stream::collect with a build in Collector.
        String collectAll = strings.stream().collect(Collectors.joining(","));
//        System.out.println(collectAll); //=> CO2, CH4, SO2, CO2, CH4 etc..
        String collectDistinct = listDistinct.stream().collect(Collectors.joining(","));
        System.out.println(collectDistinct); //=> CO2, CH4, SO2
//        List<String> strings1 = Arrays.asList(collectDistinct.split(","));
//        Collections.sort(strings1);
//        System.out.println(strings1);
    }

}
