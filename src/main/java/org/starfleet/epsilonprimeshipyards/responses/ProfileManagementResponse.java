package org.starfleet.epsilonprimeshipyards.responses;

import lombok.Getter;

@Getter

public class ProfileManagementResponse {

    private final boolean success;
    private final String message;

    public ProfileManagementResponse(boolean success, String message) {
        this.success = success;
        this.message = message;
    }

}
