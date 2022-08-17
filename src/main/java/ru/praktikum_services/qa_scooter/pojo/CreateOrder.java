package ru.praktikum_services.qa_scooter.pojo;

import java.util.List;
import java.util.Objects;

public class CreateOrder {
       private String firstName;
       private String lastName;
       private String address;
       private Integer metroStation;
       private String phone;
       private Integer rentTime;
       private String deliveryDate;
       private String comment;
       private List<String> color;
       private Integer track;


       public CreateOrder(String firstName, String lastName, String address, Integer metroStation, String phone, Integer rentTime, String deliveryDate, String comment, List<String> color, Integer track) {
              this.firstName = firstName;
              this.lastName = lastName;
              this.address = address;
              this.metroStation = metroStation;
              this.phone = phone;
              this.rentTime = rentTime;
              this.deliveryDate = deliveryDate;
              this.comment = comment;
              this.color = color;
              this.track = track;
       }

       public CreateOrder(){}

       public String getFirstName() {
              return firstName;
       }

       public void setFirstName(String firstName) {
              this.firstName = firstName;
       }

       public String getLastName() {
              return lastName;
       }

       public void setLastName(String lastName) {
              this.lastName = lastName;
       }

       public String getAddress() {
              return address;
       }

       public void setAddress(String address) {
              this.address = address;
       }

       public Integer getMetroStation() {
              return metroStation;
       }

       public void setMetroStation(Integer metroStation) {
              this.metroStation = metroStation;
       }

       public String getPhone() {
              return phone;
       }

       public void setPhone(String phone) {
              this.phone = phone;
       }

       public Integer getRentTime() {
              return rentTime;
       }

       public void setRentTime(Integer rentTime) {
              this.rentTime = rentTime;
       }

       public String getDeliveryDate() {
              return deliveryDate;
       }

       public void setDeliveryDate(String deliveryDate) {
              this.deliveryDate = deliveryDate;
       }

       public String getComment() {
              return comment;
       }

       public void setComment(String comment) {
              this.comment = comment;
       }

       public List<String> getColor() {
              return color;
       }

       public void setColor(List<String> color) {
              this.color = color;
       }

       public Integer getTrack() {
              return track;
       }

       public void setTrack(Integer track) {
              this.track = track;
       }

       @Override
       public String toString() {
              return "CreateOrder{" +
                      "firstName='" + firstName + '\'' +
                      ", lastName='" + lastName + '\'' +
                      ", address='" + address + '\'' +
                      ", metroStation=" + metroStation +
                      ", phone='" + phone + '\'' +
                      ", rentTime=" + rentTime +
                      ", deliveryDate='" + deliveryDate + '\'' +
                      ", comment='" + comment + '\'' +
                      ", color=" + color +
                      ", track=" + track +
                      '}';
       }

       @Override
       public boolean equals(Object o) {
              if (this == o) return true;
              if (o == null || getClass() != o.getClass()) return false;
              CreateOrder that = (CreateOrder) o;
              return Objects.equals(firstName, that.firstName) && Objects.equals(lastName, that.lastName) && Objects.equals(address, that.address) && Objects.equals(metroStation, that.metroStation) && Objects.equals(phone, that.phone) && Objects.equals(rentTime, that.rentTime) && Objects.equals(deliveryDate, that.deliveryDate) && Objects.equals(comment, that.comment) && Objects.equals(color, that.color) && Objects.equals(track, that.track);
       }

       @Override
       public int hashCode() {
              return Objects.hash(firstName, lastName, address, metroStation, phone, rentTime, deliveryDate, comment, color, track);
       }
}
