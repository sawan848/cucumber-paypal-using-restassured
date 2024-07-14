package org.example.app.payload;

/**
 * 2/20/2024
 * 9:54 AM
 */

public record ResponsePayload(
        String scope,
        String access_token,
        String token_type,
        String app_id,
        Integer expires_in,
        String nonce
) {
}
