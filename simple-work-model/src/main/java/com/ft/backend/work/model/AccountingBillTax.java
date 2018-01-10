package com.ft.backend.work.model;

public class AccountingBillTax {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column accounting_bill_tax.id
     *
     * @mbggenerated
     */
    private Long id;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column accounting_bill_tax.bill_id
     *
     * @mbggenerated
     */
    private Long billId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column accounting_bill_tax.type
     *
     * @mbggenerated
     */
    private String type;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column accounting_bill_tax.tax_rate
     *
     * @mbggenerated
     */
    private Double taxRate;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column accounting_bill_tax.tax_value
     *
     * @mbggenerated
     */
    private Double taxValue;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column accounting_bill_tax.id
     *
     * @return the value of accounting_bill_tax.id
     *
     * @mbggenerated
     */
    public Long getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column accounting_bill_tax.id
     *
     * @param id the value for accounting_bill_tax.id
     *
     * @mbggenerated
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column accounting_bill_tax.bill_id
     *
     * @return the value of accounting_bill_tax.bill_id
     *
     * @mbggenerated
     */
    public Long getBillId() {
        return billId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column accounting_bill_tax.bill_id
     *
     * @param billId the value for accounting_bill_tax.bill_id
     *
     * @mbggenerated
     */
    public void setBillId(Long billId) {
        this.billId = billId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column accounting_bill_tax.type
     *
     * @return the value of accounting_bill_tax.type
     *
     * @mbggenerated
     */
    public String getType() {
        return type;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column accounting_bill_tax.type
     *
     * @param type the value for accounting_bill_tax.type
     *
     * @mbggenerated
     */
    public void setType(String type) {
        this.type = type == null ? null : type.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column accounting_bill_tax.tax_rate
     *
     * @return the value of accounting_bill_tax.tax_rate
     *
     * @mbggenerated
     */
    public Double getTaxRate() {
        return taxRate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column accounting_bill_tax.tax_rate
     *
     * @param taxRate the value for accounting_bill_tax.tax_rate
     *
     * @mbggenerated
     */
    public void setTaxRate(Double taxRate) {
        this.taxRate = taxRate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column accounting_bill_tax.tax_value
     *
     * @return the value of accounting_bill_tax.tax_value
     *
     * @mbggenerated
     */
    public Double getTaxValue() {
        return taxValue;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column accounting_bill_tax.tax_value
     *
     * @param taxValue the value for accounting_bill_tax.tax_value
     *
     * @mbggenerated
     */
    public void setTaxValue(Double taxValue) {
        this.taxValue = taxValue;
    }
}