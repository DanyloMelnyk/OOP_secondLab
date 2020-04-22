package ua.lviv.ai.oop_labs.second.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.hateoas.RepresentationModel;

import javax.persistence.*;
import java.util.Objects;
import java.util.Set;

@Entity
public class Kit extends RepresentationModel<Kit> {

    @Id
    @GeneratedValue
    private Integer id;

    private String name;

    private String producer;

    private Double price;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "Kit_Elements",
            joinColumns = {@JoinColumn(name = "kit_id", nullable = false)},
            inverseJoinColumns = {@JoinColumn(name = "element_id", nullable = false)})
    @JsonIgnoreProperties("kits")
    private Set<Element> elements;

    public Kit() {
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

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Set<Element> getElements() {
        return elements;
    }

    public void setElements(Set<Element> elements) {
        this.elements = elements;
    }

    public void setElementsFromArr(Element[] elements) {
        this.elements = Set.of(elements);
    }

    public String getProducer() {
        return producer;
    }

    public void setProducer(String producer) {
        this.producer = producer;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Kit kit)) return false;
        if (!super.equals(o)) return false;
        return Objects.equals(id, kit.id) &&
                Objects.equals(name, kit.name) &&
                Objects.equals(producer, kit.producer) &&
                Objects.equals(price, kit.price) &&
                Objects.equals(elements, kit.elements);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), id, name, producer, price, elements);
    }

    @Override
    public String toString() {
        return "Kit{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", producer='" + producer + '\'' +
                ", price=" + price +
                ", elements=" + elements +
                '}';
    }
}
