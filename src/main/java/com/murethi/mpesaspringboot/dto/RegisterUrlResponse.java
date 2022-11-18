package com.murethi.mpesaspringboot.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class RegisterUrlResponse{

    @JsonProperty("ConversationID")
    private String conversationID;

    @JsonProperty("ResponseDescription")
    private String responseDescription;

    @JsonProperty("OriginatorCoversationID")
    private String originatorCoversationID;
}
