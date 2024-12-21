package com.snehalsawant.ex_06_payloadManagement.Jackson;

import io.qameta.allure.internal.shadowed.jackson.annotation.*;

import java.util.LinkedHashMap;
import java.util.Map;

public class BookingResponse {

    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonPropertyOrder({
            "bookingid",
            "booking"
    })

        @JsonProperty("bookingid")
        private Integer bookingid;
        @JsonProperty("booking")
        private Booking booking;
        @JsonIgnore
        private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

        @JsonProperty("bookingid")
        public Integer getBookingid() {
            return bookingid;
        }

        @JsonProperty("bookingid")
        public void setBookingid(Integer bookingid) {
            this.bookingid = bookingid;
        }

        @JsonProperty("booking")
        public Booking getBooking() {
            return booking;
        }

        @JsonProperty("booking")
        public void setBooking(Booking booking) {
            this.booking = booking;
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

