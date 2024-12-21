package com.snehalsawant.ex_06_payloadManagement.Jackson;

import io.qameta.allure.internal.shadowed.jackson.annotation.*;

import java.util.LinkedHashMap;
import java.util.Map;

public class Bookingdates {
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonPropertyOrder({
            "checkin",
            "checkout"
    })


        @JsonProperty("checkin")
        private String checkin;
        @JsonProperty("checkout")
        private String checkout;
        @JsonIgnore
        private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

        @JsonProperty("checkin")
        public String getCheckin() {
            return checkin;
        }

        @JsonProperty("checkin")
        public void setCheckin(String checkin) {
            this.checkin = checkin;
        }

        @JsonProperty("checkout")
        public String getCheckout() {
            return checkout;
        }

        @JsonProperty("checkout")
        public void setCheckout(String checkout) {
            this.checkout = checkout;
        }

        @JsonAnyGetter
        public Map<String, Object> getAdditionalProperties() {
            return this.additionalProperties;
        }

        @JsonAnySetter
        public void setAdditionalProperty(String name, Object value) {
            this.additionalProperties.put(name, value);
        }

    }
