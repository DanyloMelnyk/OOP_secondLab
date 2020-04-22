package ua.lviv.ai.oop_labs.second.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.hateoas.RepresentationModel;

import javax.persistence.*;
import java.util.Objects;
import java.util.Set;

@Entity
public class Element extends RepresentationModel<Element> {

    @Id
    @GeneratedValue
    private Integer id;

    @Column(nullable = false)
    private String name;

    private double value;

    private double voltage;

    @Column(nullable = false)
    private String producer;

    @Enumerated
    @Column(nullable = false)
    private ElementType type;

    private Double price;

    private int amount;

    @ManyToMany(mappedBy = "elements", fetch = FetchType.EAGER)
    @JsonIgnoreProperties("elements")
    private Set<Kit> kits;

    public Element() {
        // default constructor for spring
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ElementType getType() {
        return type;
    }

    public void setType(ElementType type) {
        this.type = type;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Set<Kit> getKits() {
        return kits;
    }

    public void setKits(Set<Kit> kits) {
        this.kits = kits;
    }

    public String getProducer() {
        return producer;
    }

    public void setProducer(String producer) {
        this.producer = producer;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    public double getVoltage() {
        return voltage;
    }

    public void setVoltage(double voltage) {
        this.voltage = voltage;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Element element)) return false;
        if (!super.equals(o)) return false;
        return Double.compare(element.value, value) == 0 &&
                Double.compare(element.voltage, voltage) == 0 &&
                amount == element.amount &&
                Objects.equals(id, element.id) &&
                Objects.equals(name, element.name) &&
                Objects.equals(producer, element.producer) &&
                type == element.type &&
                Objects.equals(price, element.price) &&
                Objects.equals(kits, element.kits);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), id, name, value, voltage, producer, type, price, amount); //kits
    }

    @Override
    public String toString() {
        return "Element{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", value=" + value +
                ", voltage=" + voltage +
                ", producer='" + producer + '\'' +
                ", type=" + type +
                ", price=" + price +
                ", amount=" + amount +
                ", kits=" + kits +
                '}';
    }
}
