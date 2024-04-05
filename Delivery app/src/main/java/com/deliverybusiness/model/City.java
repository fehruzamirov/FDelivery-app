package com.deliverybusiness.model;
import com.deliverybusiness.model.view.View;
import com.fasterxml.jackson.annotation.JsonView;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


@Entity
@Table(name="City")
public class City {

        @JsonView(View.ShowAll.class)
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name="ID")
        private int id;

        @JsonView(View.ShowName.class)
        @Size(min = 2, max = 30)
        @Column(name="name")
        @NotNull
        private String name;
        @JsonView(View.ShowZipCode.class)
        @Column(name="zipCode")
        @Size(min=0,max=5)
        private String zipCode;

        public City() {
        }

        public City(int id, String name, String zipCode) {
            this.id = id;
            this.name = name;
           this.zipCode = zipCode;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getZipCode() {
            return zipCode;
        }

        public void setZipCode(String zipCode) {
            this.zipCode = zipCode;
        }

        @Override
        public String toString() {
            return "City{" +
                    "id=" + id +
                    ", name='" + name + '\'' +
                    ", zipCode='" + zipCode + '\'' +
                    '}';
        }
}
