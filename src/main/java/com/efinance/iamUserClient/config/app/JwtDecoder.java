package com.efinance.iamUserClient.config.app;

import java.util.Base64;

public class JwtDecoder {

    public static String getPayloadData(String token) {

        String[] chunks = token.split("\\.");
        Base64.Decoder decoder = Base64.getDecoder();

        return new String(decoder.decode(chunks[1]));
    }

}
