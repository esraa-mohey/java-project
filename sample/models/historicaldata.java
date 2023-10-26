package jar.project.timelapsev0.models;
//import java.time.Instant;
import java.util.Date;

import javax.persistence.*;

//class for table historicaldata with geters and seters
@Entity
@Table(name="historicaldata")
public class historicaldata {

    @Id 
    @Column(name = "id")
    private Long id;
    //@CreationTimestamp
    @Column(name = "date")
    private Date date;

    @Column(name = "solarpower")
    private double solarPower;

    @Column(name = "battery")
    private double battery;

    @Column(name = "temp")
    private double temp;
    
    public historicaldata(){}

    public historicaldata(Long id, Date date, double solarPower, double battery, double temp) {
        this.id = id;
        this.date = date;
        this.solarPower = solarPower;
        this.battery = battery;
        this.temp = temp;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public double getSolarPower() {
        return solarPower;
    }

    public void setSolarPower(double solarPower) {
        this.solarPower = solarPower;
    }

    public double getBattery() {
        return battery;
    }

    public void setBattery(double battery) {
        this.battery = battery;
    }

    public double getTemp() {
        return temp;
    }

    public void setTemp(double temp) {
        this.temp = temp;
    }
    
    
}
