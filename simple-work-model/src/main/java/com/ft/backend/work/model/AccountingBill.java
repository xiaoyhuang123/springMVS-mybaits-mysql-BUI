package com.ft.backend.work.model;

import java.util.Date;

public class AccountingBill {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column accounting_bill.id
     *
     * @mbggenerated
     */
    private Long id;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column accounting_bill.pin
     *
     * @mbggenerated
     */
    private String pin;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column accounting_bill.pay_type
     *
     * @mbggenerated
     */
    private Byte payType;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column accounting_bill.bill_start_time
     *
     * @mbggenerated
     */
    private Date billStartTime;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column accounting_bill.bill_end_time
     *
     * @mbggenerated
     */
    private Date billEndTime;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column accounting_bill.create_time
     *
     * @mbggenerated
     */
    private Date createTime;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column accounting_bill.remittance_code
     *
     * @mbggenerated
     */
    private String remittanceCode;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column accounting_bill.end_charge_date
     *
     * @mbggenerated
     */
    private Date endChargeDate;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column accounting_bill.sum_fee
     *
     * @mbggenerated
     */
    private Double sumFee;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column accounting_bill.discount_fee
     *
     * @mbggenerated
     */
    private Double discountFee;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column accounting_bill.coupon_fee
     *
     * @mbggenerated
     */
    private Double couponFee;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column accounting_bill.bill_fee
     *
     * @mbggenerated
     */
    private Double billFee;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column accounting_bill.tax_fee
     *
     * @mbggenerated
     */
    private Double taxFee;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column accounting_bill.total_fee
     *
     * @mbggenerated
     */
    private Double totalFee;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column accounting_bill.cash_coupon_pay_fee
     *
     * @mbggenerated
     */
    private Double cashCouponPayFee;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column accounting_bill.balance_pay_fee
     *
     * @mbggenerated
     */
    private Double balancePayFee;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column accounting_bill.cash_pay_fee
     *
     * @mbggenerated
     */
    private Double cashPayFee;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column accounting_bill.pay_state
     *
     * @mbggenerated
     */
    private Byte payState;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column accounting_bill.invoice
     *
     * @mbggenerated
     */
    private String invoice;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column accounting_bill.site
     *
     * @mbggenerated
     */
    private Byte site;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column accounting_bill.id
     *
     * @return the value of accounting_bill.id
     *
     * @mbggenerated
     */
    public Long getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column accounting_bill.id
     *
     * @param id the value for accounting_bill.id
     *
     * @mbggenerated
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column accounting_bill.pin
     *
     * @return the value of accounting_bill.pin
     *
     * @mbggenerated
     */
    public String getPin() {
        return pin;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column accounting_bill.pin
     *
     * @param pin the value for accounting_bill.pin
     *
     * @mbggenerated
     */
    public void setPin(String pin) {
        this.pin = pin == null ? null : pin.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column accounting_bill.pay_type
     *
     * @return the value of accounting_bill.pay_type
     *
     * @mbggenerated
     */
    public Byte getPayType() {
        return payType;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column accounting_bill.pay_type
     *
     * @param payType the value for accounting_bill.pay_type
     *
     * @mbggenerated
     */
    public void setPayType(Byte payType) {
        this.payType = payType;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column accounting_bill.bill_start_time
     *
     * @return the value of accounting_bill.bill_start_time
     *
     * @mbggenerated
     */
    public Date getBillStartTime() {
        return billStartTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column accounting_bill.bill_start_time
     *
     * @param billStartTime the value for accounting_bill.bill_start_time
     *
     * @mbggenerated
     */
    public void setBillStartTime(Date billStartTime) {
        this.billStartTime = billStartTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column accounting_bill.bill_end_time
     *
     * @return the value of accounting_bill.bill_end_time
     *
     * @mbggenerated
     */
    public Date getBillEndTime() {
        return billEndTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column accounting_bill.bill_end_time
     *
     * @param billEndTime the value for accounting_bill.bill_end_time
     *
     * @mbggenerated
     */
    public void setBillEndTime(Date billEndTime) {
        this.billEndTime = billEndTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column accounting_bill.create_time
     *
     * @return the value of accounting_bill.create_time
     *
     * @mbggenerated
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column accounting_bill.create_time
     *
     * @param createTime the value for accounting_bill.create_time
     *
     * @mbggenerated
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column accounting_bill.remittance_code
     *
     * @return the value of accounting_bill.remittance_code
     *
     * @mbggenerated
     */
    public String getRemittanceCode() {
        return remittanceCode;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column accounting_bill.remittance_code
     *
     * @param remittanceCode the value for accounting_bill.remittance_code
     *
     * @mbggenerated
     */
    public void setRemittanceCode(String remittanceCode) {
        this.remittanceCode = remittanceCode == null ? null : remittanceCode.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column accounting_bill.end_charge_date
     *
     * @return the value of accounting_bill.end_charge_date
     *
     * @mbggenerated
     */
    public Date getEndChargeDate() {
        return endChargeDate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column accounting_bill.end_charge_date
     *
     * @param endChargeDate the value for accounting_bill.end_charge_date
     *
     * @mbggenerated
     */
    public void setEndChargeDate(Date endChargeDate) {
        this.endChargeDate = endChargeDate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column accounting_bill.sum_fee
     *
     * @return the value of accounting_bill.sum_fee
     *
     * @mbggenerated
     */
    public Double getSumFee() {
        return sumFee;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column accounting_bill.sum_fee
     *
     * @param sumFee the value for accounting_bill.sum_fee
     *
     * @mbggenerated
     */
    public void setSumFee(Double sumFee) {
        this.sumFee = sumFee;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column accounting_bill.discount_fee
     *
     * @return the value of accounting_bill.discount_fee
     *
     * @mbggenerated
     */
    public Double getDiscountFee() {
        return discountFee;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column accounting_bill.discount_fee
     *
     * @param discountFee the value for accounting_bill.discount_fee
     *
     * @mbggenerated
     */
    public void setDiscountFee(Double discountFee) {
        this.discountFee = discountFee;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column accounting_bill.coupon_fee
     *
     * @return the value of accounting_bill.coupon_fee
     *
     * @mbggenerated
     */
    public Double getCouponFee() {
        return couponFee;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column accounting_bill.coupon_fee
     *
     * @param couponFee the value for accounting_bill.coupon_fee
     *
     * @mbggenerated
     */
    public void setCouponFee(Double couponFee) {
        this.couponFee = couponFee;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column accounting_bill.bill_fee
     *
     * @return the value of accounting_bill.bill_fee
     *
     * @mbggenerated
     */
    public Double getBillFee() {
        return billFee;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column accounting_bill.bill_fee
     *
     * @param billFee the value for accounting_bill.bill_fee
     *
     * @mbggenerated
     */
    public void setBillFee(Double billFee) {
        this.billFee = billFee;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column accounting_bill.tax_fee
     *
     * @return the value of accounting_bill.tax_fee
     *
     * @mbggenerated
     */
    public Double getTaxFee() {
        return taxFee;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column accounting_bill.tax_fee
     *
     * @param taxFee the value for accounting_bill.tax_fee
     *
     * @mbggenerated
     */
    public void setTaxFee(Double taxFee) {
        this.taxFee = taxFee;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column accounting_bill.total_fee
     *
     * @return the value of accounting_bill.total_fee
     *
     * @mbggenerated
     */
    public Double getTotalFee() {
        return totalFee;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column accounting_bill.total_fee
     *
     * @param totalFee the value for accounting_bill.total_fee
     *
     * @mbggenerated
     */
    public void setTotalFee(Double totalFee) {
        this.totalFee = totalFee;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column accounting_bill.cash_coupon_pay_fee
     *
     * @return the value of accounting_bill.cash_coupon_pay_fee
     *
     * @mbggenerated
     */
    public Double getCashCouponPayFee() {
        return cashCouponPayFee;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column accounting_bill.cash_coupon_pay_fee
     *
     * @param cashCouponPayFee the value for accounting_bill.cash_coupon_pay_fee
     *
     * @mbggenerated
     */
    public void setCashCouponPayFee(Double cashCouponPayFee) {
        this.cashCouponPayFee = cashCouponPayFee;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column accounting_bill.balance_pay_fee
     *
     * @return the value of accounting_bill.balance_pay_fee
     *
     * @mbggenerated
     */
    public Double getBalancePayFee() {
        return balancePayFee;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column accounting_bill.balance_pay_fee
     *
     * @param balancePayFee the value for accounting_bill.balance_pay_fee
     *
     * @mbggenerated
     */
    public void setBalancePayFee(Double balancePayFee) {
        this.balancePayFee = balancePayFee;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column accounting_bill.cash_pay_fee
     *
     * @return the value of accounting_bill.cash_pay_fee
     *
     * @mbggenerated
     */
    public Double getCashPayFee() {
        return cashPayFee;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column accounting_bill.cash_pay_fee
     *
     * @param cashPayFee the value for accounting_bill.cash_pay_fee
     *
     * @mbggenerated
     */
    public void setCashPayFee(Double cashPayFee) {
        this.cashPayFee = cashPayFee;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column accounting_bill.pay_state
     *
     * @return the value of accounting_bill.pay_state
     *
     * @mbggenerated
     */
    public Byte getPayState() {
        return payState;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column accounting_bill.pay_state
     *
     * @param payState the value for accounting_bill.pay_state
     *
     * @mbggenerated
     */
    public void setPayState(Byte payState) {
        this.payState = payState;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column accounting_bill.invoice
     *
     * @return the value of accounting_bill.invoice
     *
     * @mbggenerated
     */
    public String getInvoice() {
        return invoice;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column accounting_bill.invoice
     *
     * @param invoice the value for accounting_bill.invoice
     *
     * @mbggenerated
     */
    public void setInvoice(String invoice) {
        this.invoice = invoice == null ? null : invoice.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column accounting_bill.site
     *
     * @return the value of accounting_bill.site
     *
     * @mbggenerated
     */
    public Byte getSite() {
        return site;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column accounting_bill.site
     *
     * @param site the value for accounting_bill.site
     *
     * @mbggenerated
     */
    public void setSite(Byte site) {
        this.site = site;
    }
}