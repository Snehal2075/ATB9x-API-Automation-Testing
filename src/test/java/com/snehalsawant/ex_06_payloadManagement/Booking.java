package com.snehalsawant.ex_06_payloadManagement;

public class Booking {

   private String firstname;
  private   String lastname;
  private Integer totalprice;
  private Boolean depositpaid;
  private String additional_needs;

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public Integer getTotalprice() {
        return totalprice;
    }

    public void setTotalprice(Integer totalprice) {
        this.totalprice = totalprice;
    }

    public Boolean getDepositpaid() {
        return depositpaid;
    }

    public void setDepositpaid(Boolean depositpaid) {
        this.depositpaid = depositpaid;
    }

    public String getAdditional_needs() {
        return additional_needs;
    }

    public void setAdditional_needs(String additional_needs) {
        this.additional_needs = additional_needs;
    }

    public BookingDates getBookingDates() {
        return bookingDates;
    }

    public void setBookingDates(BookingDates bookingDates) {
        this.bookingDates = bookingDates;
    }

    private BookingDates bookingDates;

}
