package org.wtt.solarapp.solar_app.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String address;
    private Long mobileNumber;
    private Long solarCapacity;
    private String paymentMode;

    @Lob
    @Column(name = "aadhar_file", columnDefinition = "LONGBLOB")
    private byte[] aadharCardFile;

    @Lob
    @Column(name = "pan_file", columnDefinition = "LONGBLOB")
    private byte[] panCardFile;

    @Lob
    @Column(name = "bank_file", columnDefinition = "LONGBLOB")
    private byte[] bankDetailsFile;

    public User() {}

    public User(String name, String address, Long mobileNumber, Long solarCapacity, String paymentMode,
                byte[] aadharCardFile, byte[] panCardFile, byte[] bankDetailsFile) {
        this.name = name;
        this.address = address;
        this.mobileNumber = mobileNumber;
        this.solarCapacity = solarCapacity;
        this.paymentMode = paymentMode;
        this.aadharCardFile = aadharCardFile;
        this.panCardFile = panCardFile;
        this.bankDetailsFile = bankDetailsFile;
    }

    // Getters and setters omitted for brevity

    public Long getId() { return id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getAddress() { return address; }
    public void setAddress(String address) { this.address = address; }

    public Long getMobileNumber() { return mobileNumber; }
    public void setMobileNumber(Long mobileNumber) { this.mobileNumber = mobileNumber; }

    public Long getSolarCapacity() { return solarCapacity; }
    public void setSolarCapacity(Long solarCapacity) { this.solarCapacity = solarCapacity; }

    public String getPaymentMode() { return paymentMode; }
    public void setPaymentMode(String paymentMode) { this.paymentMode = paymentMode; }

    public byte[] getAadharCardFile() { return aadharCardFile; }
    public void setAadharCardFile(byte[] aadharCardFile) { this.aadharCardFile = aadharCardFile; }

    public byte[] getPanCardFile() { return panCardFile; }
    public void setPanCardFile(byte[] panCardFile) { this.panCardFile = panCardFile; }

    public byte[] getBankDetailsFile() { return bankDetailsFile; }
    public void setBankDetailsFile(byte[] bankDetailsFile) { this.bankDetailsFile = bankDetailsFile; }
}